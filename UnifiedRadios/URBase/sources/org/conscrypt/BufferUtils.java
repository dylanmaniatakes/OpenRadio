package org.conscrypt;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
final class BufferUtils {
    private BufferUtils() {
    }

    public static void checkNotNull(ByteBuffer[] byteBufferArr) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            if (byteBuffer == null) {
                throw new IllegalArgumentException("Null buffer in array");
            }
        }
    }

    public static void consume(ByteBuffer[] byteBufferArr, int i5) {
        for (ByteBuffer byteBuffer : byteBufferArr) {
            int iMin = Math.min(byteBuffer.remaining(), i5);
            if (iMin > 0) {
                byteBuffer.position(byteBuffer.position() + iMin);
                i5 -= iMin;
                if (i5 == 0) {
                    break;
                }
            }
        }
        if (i5 > 0) {
            throw new IllegalArgumentException("toConsume > data size");
        }
    }

    public static ByteBuffer copyNoConsume(ByteBuffer[] byteBufferArr, ByteBuffer byteBuffer, int i5) {
        Preconditions.checkArgument(byteBuffer.remaining() >= i5, "Destination buffer too small");
        for (ByteBuffer byteBuffer2 : byteBufferArr) {
            int iRemaining = byteBuffer2.remaining();
            if (iRemaining > 0) {
                int iPosition = byteBuffer2.position();
                if (iRemaining <= i5) {
                    byteBuffer.put(byteBuffer2);
                    i5 -= iRemaining;
                } else {
                    int iLimit = byteBuffer2.limit();
                    byteBuffer2.limit(byteBuffer2.position() + i5);
                    byteBuffer.put(byteBuffer2);
                    byteBuffer2.limit(iLimit);
                    i5 = 0;
                }
                byteBuffer2.position(iPosition);
                if (i5 == 0) {
                    break;
                }
            }
        }
        byteBuffer.flip();
        return byteBuffer;
    }

    public static ByteBuffer getBufferLargerThan(ByteBuffer[] byteBufferArr, int i5) {
        int length = byteBufferArr.length;
        int i6 = 0;
        while (i6 < length) {
            ByteBuffer byteBuffer = byteBufferArr[i6];
            int iRemaining = byteBuffer.remaining();
            if (iRemaining > 0) {
                if (iRemaining >= i5) {
                    return byteBuffer;
                }
                do {
                    i6++;
                    if (i6 >= length) {
                        return byteBuffer;
                    }
                } while (byteBufferArr[i6].remaining() <= 0);
                return null;
            }
            i6++;
        }
        return null;
    }

    public static long remaining(ByteBuffer[] byteBufferArr) {
        long jRemaining = 0;
        for (ByteBuffer byteBuffer : byteBufferArr) {
            jRemaining += byteBuffer.remaining();
        }
        return jRemaining;
    }
}
