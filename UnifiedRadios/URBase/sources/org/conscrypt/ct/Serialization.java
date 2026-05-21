package org.conscrypt.ct;

import com.unified.ur1.SatelliteTracker.h;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Serialization {
    private static final int DER_LENGTH_LONG_FORM_FLAG = 128;
    private static final int DER_TAG_MASK = 63;
    private static final int DER_TAG_OCTET_STRING = 4;

    private Serialization() {
    }

    public static byte readByte(InputStream inputStream) throws IOException, SerializationException {
        try {
            int i5 = inputStream.read();
            if (i5 != -1) {
                return (byte) i5;
            }
            throw new SerializationException("Premature end of input, could not read byte.");
        } catch (IOException e5) {
            throw new SerializationException(e5);
        }
    }

    public static byte[] readDEROctetString(byte[] bArr) throws SerializationException {
        return readDEROctetString(new ByteArrayInputStream(bArr));
    }

    public static byte[] readFixedBytes(InputStream inputStream, int i5) throws IOException, SerializationException {
        try {
            if (i5 < 0) {
                throw new SerializationException("Negative length: " + i5);
            }
            byte[] bArr = new byte[i5];
            int i6 = inputStream.read(bArr);
            if (i6 >= i5) {
                return bArr;
            }
            throw new SerializationException("Premature end of input, expected " + i5 + " bytes, only read " + i6);
        } catch (IOException e5) {
            throw new SerializationException(e5);
        }
    }

    public static byte[][] readList(byte[] bArr, int i5, int i6) throws SerializationException {
        return readList(new ByteArrayInputStream(bArr), i5, i6);
    }

    public static long readLong(InputStream inputStream, int i5) throws SerializationException {
        if (i5 > 8 || i5 < 0) {
            throw new IllegalArgumentException(h.a(i5, "Invalid width: "));
        }
        long j5 = 0;
        for (int i6 = 0; i6 < i5; i6++) {
            j5 = (j5 << 8) | (readByte(inputStream) & 255);
        }
        return j5;
    }

    public static int readNumber(InputStream inputStream, int i5) throws SerializationException {
        if (i5 > 4 || i5 < 0) {
            throw new SerializationException(h.a(i5, "Invalid width: "));
        }
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 = (i6 << 8) | (readByte(inputStream) & 255);
        }
        return i6;
    }

    public static byte[] readVariableBytes(InputStream inputStream, int i5) throws SerializationException {
        return readFixedBytes(inputStream, readNumber(inputStream, i5));
    }

    public static void writeFixedBytes(OutputStream outputStream, byte[] bArr) throws SerializationException {
        try {
            outputStream.write(bArr);
        } catch (IOException e5) {
            throw new SerializationException(e5);
        }
    }

    public static void writeNumber(OutputStream outputStream, long j5, int i5) throws SerializationException {
        if (i5 < 0) {
            throw new SerializationException(h.a(i5, "Negative width: "));
        }
        if (i5 < 8 && j5 >= (1 << (i5 * 8))) {
            throw new SerializationException("Number too large, " + j5 + " does not fit in " + i5 + " bytes");
        }
        while (i5 > 0) {
            if ((i5 - 1) * 8 < 64) {
                try {
                    outputStream.write((byte) ((j5 >> ((int) r0)) & 255));
                } catch (IOException e5) {
                    throw new SerializationException(e5);
                }
            } else {
                outputStream.write(0);
            }
            i5--;
        }
    }

    public static void writeVariableBytes(OutputStream outputStream, byte[] bArr, int i5) throws SerializationException {
        writeNumber(outputStream, bArr.length, i5);
        writeFixedBytes(outputStream, bArr);
    }

    public static byte[] readDEROctetString(InputStream inputStream) throws SerializationException {
        int i5 = readByte(inputStream) & 63;
        if (i5 != 4) {
            throw new SerializationException(h.a(i5, "Wrong DER tag, expected OCTET STRING, got "));
        }
        int number = readNumber(inputStream, 1);
        if ((number & 128) != 0) {
            number = readNumber(inputStream, number & (-129));
        }
        return readFixedBytes(inputStream, number);
    }

    public static byte[][] readList(InputStream inputStream, int i5, int i6) throws SerializationException {
        ArrayList arrayList = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readVariableBytes(inputStream, i5));
        while (byteArrayInputStream.available() > 0) {
            try {
                arrayList.add(readVariableBytes(byteArrayInputStream, i6));
            } catch (IOException e5) {
                throw new SerializationException(e5);
            }
        }
        return (byte[][]) arrayList.toArray(new byte[arrayList.size()][]);
    }
}
