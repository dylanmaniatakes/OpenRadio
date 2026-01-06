package okhttp3.internal.cache2;

import F3.f;
import F3.i;
import J1.C;
import W3.F;
import W3.I;
import W3.l;
import W3.o;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import okhttp3.internal.Util;

/* loaded from: classes.dex */
public final class Relay {
    public static final Companion Companion = new Companion(null);
    private static final long FILE_HEADER_SIZE = 32;
    public static final o PREFIX_CLEAN;
    public static final o PREFIX_DIRTY;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final l buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final o metadata;
    private int sourceCount;
    private F upstream;
    private final l upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;

    public static final class Companion {
        private Companion() {
        }

        public final Relay edit(File file, F f5, o oVar, long j5) throws IOException {
            i.f(file, "file");
            i.f(f5, "upstream");
            i.f(oVar, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay relay = new Relay(randomAccessFile, f5, 0L, oVar, j5, null);
            randomAccessFile.setLength(0L);
            relay.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return relay;
        }

        public final Relay read(File file) throws IOException {
            i.f(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            i.e(channel, "randomAccessFile.channel");
            FileOperator fileOperator = new FileOperator(channel);
            l lVar = new l();
            fileOperator.read(0L, lVar, Relay.FILE_HEADER_SIZE);
            if (!i.a(lVar.g(r1.c()), Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long jQ = lVar.q();
            long jQ2 = lVar.q();
            l lVar2 = new l();
            fileOperator.read(jQ + Relay.FILE_HEADER_SIZE, lVar2, jQ2);
            return new Relay(randomAccessFile, null, jQ, lVar2.g(lVar2.f2648k), 0L, null);
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public final class RelaySource implements F {
        private FileOperator fileOperator;
        private long sourcePos;
        private final I timeout = new I();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            i.c(file);
            FileChannel channel = file.getChannel();
            i.e(channel, "file!!.channel");
            this.fileOperator = new FileOperator(channel);
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            RandomAccessFile randomAccessFile = null;
            this.fileOperator = null;
            Relay relay = Relay.this;
            synchronized (relay) {
                relay.setSourceCount(relay.getSourceCount() - 1);
                if (relay.getSourceCount() == 0) {
                    RandomAccessFile file = relay.getFile();
                    relay.setFile(null);
                    randomAccessFile = file;
                }
            }
            if (randomAccessFile != null) {
                Util.closeQuietly(randomAccessFile);
            }
        }

        @Override // W3.F
        public long read(l lVar, long j5) throws IOException {
            char c2;
            i.f(lVar, "sink");
            if (this.fileOperator == null) {
                throw new IllegalStateException("Check failed.".toString());
            }
            Relay relay = Relay.this;
            synchronized (relay) {
                while (true) {
                    try {
                        if (this.sourcePos != relay.getUpstreamPos()) {
                            long upstreamPos = relay.getUpstreamPos() - relay.getBuffer().f2648k;
                            if (this.sourcePos >= upstreamPos) {
                                long jMin = Math.min(j5, relay.getUpstreamPos() - this.sourcePos);
                                relay.getBuffer().s(this.sourcePos - upstreamPos, lVar, jMin);
                                this.sourcePos += jMin;
                                return jMin;
                            }
                            c2 = 2;
                        } else if (!relay.getComplete()) {
                            if (relay.getUpstreamReader() == null) {
                                relay.setUpstreamReader(Thread.currentThread());
                                c2 = 1;
                                break;
                            }
                            this.timeout.waitUntilNotified(relay);
                        } else {
                            return -1L;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (c2 == 2) {
                    long jMin2 = Math.min(j5, Relay.this.getUpstreamPos() - this.sourcePos);
                    FileOperator fileOperator = this.fileOperator;
                    i.c(fileOperator);
                    fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, lVar, jMin2);
                    this.sourcePos += jMin2;
                    return jMin2;
                }
                try {
                    F upstream = Relay.this.getUpstream();
                    i.c(upstream);
                    long j6 = upstream.read(Relay.this.getUpstreamBuffer(), Relay.this.getBufferMaxSize());
                    if (j6 == -1) {
                        Relay relay2 = Relay.this;
                        relay2.commit(relay2.getUpstreamPos());
                        Relay relay3 = Relay.this;
                        synchronized (relay3) {
                            relay3.setUpstreamReader(null);
                            relay3.notifyAll();
                        }
                        return -1L;
                    }
                    long jMin3 = Math.min(j6, j5);
                    Relay.this.getUpstreamBuffer().s(0L, lVar, jMin3);
                    this.sourcePos += jMin3;
                    FileOperator fileOperator2 = this.fileOperator;
                    i.c(fileOperator2);
                    fileOperator2.write(Relay.this.getUpstreamPos() + Relay.FILE_HEADER_SIZE, Relay.this.getUpstreamBuffer().clone(), j6);
                    Relay relay4 = Relay.this;
                    synchronized (relay4) {
                        try {
                            relay4.getBuffer().write(relay4.getUpstreamBuffer(), j6);
                            if (relay4.getBuffer().f2648k > relay4.getBufferMaxSize()) {
                                relay4.getBuffer().i(relay4.getBuffer().f2648k - relay4.getBufferMaxSize());
                            }
                            relay4.setUpstreamPos(relay4.getUpstreamPos() + j6);
                        } finally {
                        }
                    }
                    Relay relay5 = Relay.this;
                    synchronized (relay5) {
                        relay5.setUpstreamReader(null);
                        relay5.notifyAll();
                    }
                    return jMin3;
                } catch (Throwable th2) {
                    Relay relay6 = Relay.this;
                    synchronized (relay6) {
                        relay6.setUpstreamReader(null);
                        relay6.notifyAll();
                        throw th2;
                    }
                }
            }
        }

        @Override // W3.F
        public I timeout() {
            return this.timeout;
        }
    }

    static {
        o oVar = o.f2649m;
        PREFIX_CLEAN = C.i("OkHttp cache v1\n");
        PREFIX_DIRTY = C.i("OkHttp DIRTY :(\n");
    }

    public /* synthetic */ Relay(RandomAccessFile randomAccessFile, F f5, long j5, o oVar, long j6, f fVar) {
        this(randomAccessFile, f5, j5, oVar, j6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void writeHeader(o oVar, long j5, long j6) throws IOException {
        l lVar = new l();
        lVar.c0(oVar);
        lVar.i0(j5);
        lVar.i0(j6);
        if (lVar.f2648k != FILE_HEADER_SIZE) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        RandomAccessFile randomAccessFile = this.file;
        i.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        i.e(channel, "file!!.channel");
        new FileOperator(channel).write(0L, lVar, FILE_HEADER_SIZE);
    }

    private final void writeMetadata(long j5) throws IOException {
        l lVar = new l();
        lVar.c0(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        i.c(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        i.e(channel, "file!!.channel");
        new FileOperator(channel).write(FILE_HEADER_SIZE + j5, lVar, this.metadata.c());
    }

    public final void commit(long j5) throws IOException {
        writeMetadata(j5);
        RandomAccessFile randomAccessFile = this.file;
        i.c(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j5, this.metadata.c());
        RandomAccessFile randomAccessFile2 = this.file;
        i.c(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        F f5 = this.upstream;
        if (f5 != null) {
            Util.closeQuietly(f5);
        }
        this.upstream = null;
    }

    public final l getBuffer() {
        return this.buffer;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final F getUpstream() {
        return this.upstream;
    }

    public final l getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final o metadata() {
        return this.metadata;
    }

    public final F newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    public final void setComplete(boolean z4) {
        this.complete = z4;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final void setSourceCount(int i5) {
        this.sourceCount = i5;
    }

    public final void setUpstream(F f5) {
        this.upstream = f5;
    }

    public final void setUpstreamPos(long j5) {
        this.upstreamPos = j5;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    private Relay(RandomAccessFile randomAccessFile, F f5, long j5, o oVar, long j6) {
        this.file = randomAccessFile;
        this.upstream = f5;
        this.upstreamPos = j5;
        this.metadata = oVar;
        this.bufferMaxSize = j6;
        this.upstreamBuffer = new l();
        this.complete = f5 == null;
        this.buffer = new l();
    }
}
