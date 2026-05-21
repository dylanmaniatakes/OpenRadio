#include <jni.h>

#include <algorithm>
#include <cerrno>
#include <cstdint>
#include <cstring>
#include <fcntl.h>
#include <memory>
#include <mutex>
#include <string>
#include <sys/ioctl.h>
#include <termios.h>
#include <unistd.h>

#include "mbevocoder.h"

extern "C" {
#include "mbelib.h"
}

namespace {

constexpr int kPcmSamples = 160;

void throwIOException(JNIEnv *env, const std::string &message) {
    jclass exceptionClass = env->FindClass("java/io/IOException");
    if (exceptionClass != nullptr) {
        env->ThrowNew(exceptionClass, message.c_str());
    }
}

speed_t baudToSpeed(int baud) {
    switch (baud) {
        case 9600:
            return B9600;
        case 19200:
            return B19200;
        case 38400:
            return B38400;
        case 57600:
            return B57600;
        case 115200:
            return B115200;
        case 230400:
            return B230400;
        default:
            return 0;
    }
}

int speedToBaud(speed_t speed) {
    switch (speed) {
        case B9600:
            return 9600;
        case B19200:
            return 19200;
        case B38400:
            return 38400;
        case B57600:
            return 57600;
        case B115200:
            return 115200;
        case B230400:
            return 230400;
        default:
            return 0;
    }
}

bool configureSerialFd(int fd, int baud, std::string *error) {
    const speed_t speed = baudToSpeed(baud);
    if (speed == 0) {
        *error = "unsupported baud rate " + std::to_string(baud);
        return false;
    }

    termios options {};
    if (tcgetattr(fd, &options) != 0) {
        *error = "tcgetattr failed: " + std::string(std::strerror(errno));
        return false;
    }

    cfsetispeed(&options, speed);
    cfsetospeed(&options, speed);

    options.c_cflag |= CLOCAL | CREAD;
    options.c_cflag &= ~CSIZE;
    options.c_cflag |= CS8;
    options.c_cflag &= ~PARENB;
    options.c_cflag &= ~CSTOPB;
#ifdef CRTSCTS
    options.c_cflag &= ~CRTSCTS;
#endif

    options.c_iflag = 0;
    options.c_oflag = 0;
    options.c_lflag = 0;
    options.c_cc[VMIN] = 0;
    options.c_cc[VTIME] = 0;

    if (tcsetattr(fd, TCSANOW, &options) != 0) {
        *error = "tcsetattr failed: " + std::string(std::strerror(errno));
        return false;
    }
    tcflush(fd, TCIOFLUSH);
    return true;
}

const int rW[36] = {
    0, 1, 0, 1, 0, 1,
    0, 1, 0, 1, 0, 1,
    0, 1, 0, 1, 0, 1,
    0, 1, 0, 1, 0, 2,
    0, 2, 0, 2, 0, 2,
    0, 2, 0, 2, 0, 2
};

const int rX[36] = {
    23, 10, 22, 9, 21, 8,
    20, 7, 19, 6, 18, 5,
    17, 4, 16, 3, 15, 2,
    14, 1, 13, 0, 12, 10,
    11, 9, 10, 8, 9, 7,
    8, 6, 7, 5, 6, 4
};

const int rY[36] = {
    0, 2, 0, 2, 0, 2,
    0, 2, 0, 3, 0, 3,
    1, 3, 1, 3, 1, 3,
    1, 3, 1, 3, 1, 3,
    1, 3, 1, 3, 1, 3,
    1, 3, 1, 3, 1, 3
};

const int rZ[36] = {
    5, 3, 4, 2, 3, 1,
    2, 0, 1, 13, 0, 12,
    22, 11, 21, 10, 20, 9,
    19, 8, 18, 7, 17, 6,
    16, 5, 15, 4, 14, 3,
    13, 2, 12, 1, 11, 0
};

struct DecoderState {
    mbe_parms current;
    mbe_parms previous;
    mbe_parms previousEnhanced;
    char ambeData[49];
    int errors;
    char errorString[64];
    bool initialized;
};

std::mutex gDecoderMutex;
DecoderState gDecoder = {};

std::mutex gEncoderMutex;
std::unique_ptr<MBEVocoder> gEncoder;

void resetDecoderLocked() {
    mbe_initMbeParms(&gDecoder.current, &gDecoder.previous, &gDecoder.previousEnhanced);
    std::memset(gDecoder.ambeData, 0, sizeof(gDecoder.ambeData));
    std::memset(gDecoder.errorString, 0, sizeof(gDecoder.errorString));
    gDecoder.errors = 0;
    gDecoder.initialized = true;
}

void ensureDecoderLocked() {
    if (!gDecoder.initialized) {
        resetDecoderLocked();
    }
}

void unpackDmrAmbe2450x1150(const uint8_t input[9], char ambeFrame[4][24]) {
    std::memset(ambeFrame, 0, 4 * 24);
    int index = 0;
    for (int byteIndex = 0; byteIndex < 9; ++byteIndex) {
        const uint8_t value = input[byteIndex];
        for (int bit = 0; bit < 8; bit += 2) {
            ambeFrame[rY[index]][rZ[index]] = static_cast<char>((value >> (7 - (bit + 1))) & 0x01);
            ambeFrame[rW[index]][rX[index]] = static_cast<char>((value >> (7 - bit)) & 0x01);
            ++index;
        }
    }
}

jshortArray decode2450x1150(JNIEnv *env, jbyteArray encoded) {
    if (env->GetArrayLength(encoded) != 9) {
        return env->NewShortArray(0);
    }

    jbyte rawInput[9];
    env->GetByteArrayRegion(encoded, 0, 9, rawInput);

    uint8_t ambe[9];
    for (int i = 0; i < 9; ++i) {
        ambe[i] = static_cast<uint8_t>(rawInput[i]);
    }

    float pcmFloat[kPcmSamples] = {};
    char ambeFrame[4][24];
    unpackDmrAmbe2450x1150(ambe, ambeFrame);

    {
        std::lock_guard<std::mutex> lock(gDecoderMutex);
        ensureDecoderLocked();
        mbe_processAmbe3600x2450Framef(
            pcmFloat,
            &gDecoder.errors,
            gDecoder.errorString,
            ambeFrame,
            gDecoder.ambeData,
            &gDecoder.current,
            &gDecoder.previous,
            &gDecoder.previousEnhanced,
            3
        );
    }

    jshort pcm[kPcmSamples];
    for (int i = 0; i < kPcmSamples; ++i) {
        const float clipped = std::clamp(pcmFloat[i], -32760.0f, 32760.0f);
        pcm[i] = static_cast<jshort>(clipped);
    }

    jshortArray output = env->NewShortArray(kPcmSamples);
    env->SetShortArrayRegion(output, 0, kPcmSamples, pcm);
    return output;
}

jbyteArray encode2450x1150(JNIEnv *env, jshortArray pcmInput) {
    if (env->GetArrayLength(pcmInput) != kPcmSamples) {
        return env->NewByteArray(0);
    }

    jshort rawPcm[kPcmSamples];
    env->GetShortArrayRegion(pcmInput, 0, kPcmSamples, rawPcm);

    int16_t pcm[kPcmSamples];
    for (int i = 0; i < kPcmSamples; ++i) {
        pcm[i] = static_cast<int16_t>(rawPcm[i]);
    }

    uint8_t encoded[9] = {};
    {
        std::lock_guard<std::mutex> lock(gEncoderMutex);
        if (!gEncoder) {
            gEncoder = std::make_unique<MBEVocoder>();
        }
        gEncoder->encode_2450x1150(pcm, encoded);
    }

    jbyte outputBytes[9];
    for (int i = 0; i < 9; ++i) {
        outputBytes[i] = static_cast<jbyte>(encoded[i]);
    }

    jbyteArray output = env->NewByteArray(9);
    env->SetByteArrayRegion(output, 0, 9, outputBytes);
    return output;
}

} // namespace

extern "C" JNIEXPORT jshortArray JNICALL
Java_com_roip_mobile_radio_roip_NativeDmrAmbeDecoder_nativeDecode2450x1150(
    JNIEnv *env,
    jobject,
    jbyteArray encoded
) {
    return decode2450x1150(env, encoded);
}

extern "C" JNIEXPORT void JNICALL
Java_com_roip_mobile_radio_roip_NativeDmrAmbeDecoder_nativeReset(
    JNIEnv *,
    jobject
) {
    std::lock_guard<std::mutex> lock(gDecoderMutex);
    resetDecoderLocked();
}

extern "C" JNIEXPORT jbyteArray JNICALL
Java_com_roip_mobile_radio_roip_NativeDmrAmbeEncoder_nativeEncode2450x1150(
    JNIEnv *env,
    jobject,
    jshortArray pcm
) {
    return encode2450x1150(env, pcm);
}

extern "C" JNIEXPORT void JNICALL
Java_com_roip_mobile_radio_roip_NativeDmrAmbeEncoder_nativeResetEncoder(
    JNIEnv *,
    jobject
) {
    std::lock_guard<std::mutex> lock(gEncoderMutex);
    gEncoder = std::make_unique<MBEVocoder>();
}

extern "C" JNIEXPORT jint JNICALL
Java_com_roip_mobile_radio_comjot_ComjotNativeSerial_00024Companion_nativeOpen(
    JNIEnv *env,
    jobject,
    jstring path,
    jint baud
) {
    const char *rawPath = env->GetStringUTFChars(path, nullptr);
    if (rawPath == nullptr) {
        throwIOException(env, "serial path is null");
        return -1;
    }

    const int fd = open(rawPath, O_RDWR | O_NOCTTY | O_CLOEXEC);
    const std::string pathCopy(rawPath);
    env->ReleaseStringUTFChars(path, rawPath);

    if (fd < 0) {
        throwIOException(env, "open " + pathCopy + " failed: " + std::strerror(errno));
        return -1;
    }

    std::string error;
    if (!configureSerialFd(fd, baud, &error)) {
        close(fd);
        throwIOException(env, "configure " + pathCopy + " failed: " + error);
        return -1;
    }

    return fd;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_roip_mobile_radio_comjot_ComjotNativeSerial_00024Companion_nativeConfiguredBaud(
    JNIEnv *,
    jobject,
    jint fd
) {
    termios options {};
    if (tcgetattr(fd, &options) != 0) {
        return 0;
    }
    return speedToBaud(cfgetispeed(&options));
}

extern "C" JNIEXPORT jint JNICALL
Java_com_roip_mobile_radio_comjot_ComjotNativeSerial_00024Companion_nativeAvailable(
    JNIEnv *,
    jobject,
    jint fd
) {
    int available = 0;
    if (ioctl(fd, FIONREAD, &available) != 0) {
        return 0;
    }
    return available;
}

extern "C" JNIEXPORT jbyteArray JNICALL
Java_com_roip_mobile_radio_comjot_ComjotNativeSerial_00024Companion_nativeRead(
    JNIEnv *env,
    jobject,
    jint fd,
    jint maxBytes
) {
    if (maxBytes <= 0) {
        return env->NewByteArray(0);
    }

    std::unique_ptr<uint8_t[]> buffer(new uint8_t[maxBytes]);
    ssize_t readCount;
    do {
        readCount = read(fd, buffer.get(), static_cast<size_t>(maxBytes));
    } while (readCount < 0 && errno == EINTR);

    if (readCount <= 0) {
        return env->NewByteArray(0);
    }

    jbyteArray output = env->NewByteArray(static_cast<jsize>(readCount));
    env->SetByteArrayRegion(
        output,
        0,
        static_cast<jsize>(readCount),
        reinterpret_cast<jbyte *>(buffer.get())
    );
    return output;
}

extern "C" JNIEXPORT jint JNICALL
Java_com_roip_mobile_radio_comjot_ComjotNativeSerial_00024Companion_nativeWrite(
    JNIEnv *env,
    jobject,
    jint fd,
    jbyteArray packet,
    jboolean drain
) {
    const jsize length = env->GetArrayLength(packet);
    if (length <= 0) {
        return 0;
    }

    jbyte *bytes = env->GetByteArrayElements(packet, nullptr);
    if (bytes == nullptr) {
        throwIOException(env, "serial write failed: packet bytes unavailable");
        return 0;
    }

    int total = 0;
    while (total < length) {
        const ssize_t written = write(
            fd,
            bytes + total,
            static_cast<size_t>(length - total)
        );
        if (written < 0) {
            if (errno == EINTR) {
                continue;
            }
            const std::string error = std::strerror(errno);
            env->ReleaseByteArrayElements(packet, bytes, JNI_ABORT);
            throwIOException(env, "serial write failed: " + error);
            return total;
        }
        if (written == 0) {
            break;
        }
        total += static_cast<int>(written);
    }

    env->ReleaseByteArrayElements(packet, bytes, JNI_ABORT);
    if (drain == JNI_TRUE) {
        tcdrain(fd);
    }
    return total;
}

extern "C" JNIEXPORT void JNICALL
Java_com_roip_mobile_radio_comjot_ComjotNativeSerial_00024Companion_nativeClose(
    JNIEnv *,
    jobject,
    jint fd
) {
    if (fd >= 0) {
        close(fd);
    }
}
