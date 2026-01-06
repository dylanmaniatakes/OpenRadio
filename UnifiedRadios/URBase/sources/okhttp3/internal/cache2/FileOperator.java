package okhttp3.internal.cache2;

import F3.i;
import W3.l;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* loaded from: classes.dex */
public final class FileOperator {
    private final FileChannel fileChannel;

    public FileOperator(FileChannel fileChannel) {
        i.f(fileChannel, "fileChannel");
        this.fileChannel = fileChannel;
    }

    public final void read(long j5, l lVar, long j6) throws IOException {
        i.f(lVar, "sink");
        if (j6 < 0) {
            throw new IndexOutOfBoundsException();
        }
        while (j6 > 0) {
            long jTransferTo = this.fileChannel.transferTo(j5, j6, lVar);
            j5 += jTransferTo;
            j6 -= jTransferTo;
        }
    }

    public final void write(long j5, l lVar, long j6) throws IOException {
        i.f(lVar, "source");
        if (j6 < 0 || j6 > lVar.f2648k) {
            throw new IndexOutOfBoundsException();
        }
        while (j6 > 0) {
            long jTransferFrom = this.fileChannel.transferFrom(lVar, j5, j6);
            j5 += jTransferFrom;
            j6 -= jTransferFrom;
        }
    }
}
