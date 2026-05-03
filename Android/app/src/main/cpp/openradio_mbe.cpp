#include <jni.h>

#include <algorithm>
#include <cstdint>
#include <cstring>
#include <memory>
#include <mutex>

#include "mbevocoder.h"

extern "C" {
#include "mbelib.h"
}

namespace {

constexpr int kPcmSamples = 160;

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
