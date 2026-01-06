package okhttp3.internal.cache;

import F1.b;
import F3.f;
import F3.i;
import G3.a;
import M3.d;
import M3.e;
import W3.AbstractC0189b;
import W3.C0195h;
import W3.D;
import W3.F;
import W3.m;
import W3.r;
import W3.y;
import W3.z;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.unified.ur1.SatelliteTracker.h;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.internal.Util;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.concurrent.Task;
import okhttp3.internal.concurrent.TaskQueue;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;

/* loaded from: classes.dex */
public final class DiskLruCache implements Closeable, Flushable {
    private final int appVersion;
    private boolean civilizedFileSystem;
    private final TaskQueue cleanupQueue;
    private final DiskLruCache$cleanupTask$1 cleanupTask;
    private boolean closed;
    private final File directory;
    private final FileSystem fileSystem;
    private boolean hasJournalErrors;
    private boolean initialized;
    private final File journalFile;
    private final File journalFileBackup;
    private final File journalFileTmp;
    private m journalWriter;
    private final LinkedHashMap<String, Entry> lruEntries;
    private long maxSize;
    private boolean mostRecentRebuildFailed;
    private boolean mostRecentTrimFailed;
    private long nextSequenceNumber;
    private int redundantOpCount;
    private long size;
    private final int valueCount;
    public static final Companion Companion = new Companion(null);
    public static final String JOURNAL_FILE = "journal";
    public static final String JOURNAL_FILE_TEMP = "journal.tmp";
    public static final String JOURNAL_FILE_BACKUP = "journal.bkp";
    public static final String MAGIC = "libcore.io.DiskLruCache";
    public static final String VERSION_1 = "1";
    public static final long ANY_SEQUENCE_NUMBER = -1;
    public static final d LEGAL_KEY_PATTERN = new d("[a-z0-9_-]{1,120}");
    public static final String CLEAN = "CLEAN";
    public static final String DIRTY = "DIRTY";
    public static final String REMOVE = "REMOVE";
    public static final String READ = "READ";

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public final class Editor {
        private boolean done;
        private final Entry entry;
        final /* synthetic */ DiskLruCache this$0;
        private final boolean[] written;

        public Editor(DiskLruCache diskLruCache, Entry entry) {
            i.f(entry, "entry");
            this.this$0 = diskLruCache;
            this.entry = entry;
            this.written = entry.getReadable$okhttp() ? null : new boolean[diskLruCache.getValueCount$okhttp()];
        }

        public final void abort() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (!(!this.done)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (i.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, false);
                    }
                    this.done = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void commit() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (!(!this.done)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (i.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        diskLruCache.completeEdit$okhttp(this, true);
                    }
                    this.done = true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final void detach$okhttp() throws IOException {
            if (i.a(this.entry.getCurrentEditor$okhttp(), this)) {
                if (this.this$0.civilizedFileSystem) {
                    this.this$0.completeEdit$okhttp(this, false);
                } else {
                    this.entry.setZombie$okhttp(true);
                }
            }
        }

        public final Entry getEntry$okhttp() {
            return this.entry;
        }

        public final boolean[] getWritten$okhttp() {
            return this.written;
        }

        public final D newSink(int i5) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                try {
                    if (!(!this.done)) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    if (!i.a(this.entry.getCurrentEditor$okhttp(), this)) {
                        return new C0195h();
                    }
                    if (!this.entry.getReadable$okhttp()) {
                        boolean[] zArr = this.written;
                        i.c(zArr);
                        zArr[i5] = true;
                    }
                    try {
                        return new FaultHidingSink(diskLruCache.getFileSystem$okhttp().sink(this.entry.getDirtyFiles$okhttp().get(i5)), new DiskLruCache$Editor$newSink$1$1(diskLruCache, this));
                    } catch (FileNotFoundException unused) {
                        return new C0195h();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public final F newSource(int i5) {
            DiskLruCache diskLruCache = this.this$0;
            synchronized (diskLruCache) {
                if (!(!this.done)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                F fSource = null;
                if (!this.entry.getReadable$okhttp() || !i.a(this.entry.getCurrentEditor$okhttp(), this) || this.entry.getZombie$okhttp()) {
                    return null;
                }
                try {
                    fSource = diskLruCache.getFileSystem$okhttp().source(this.entry.getCleanFiles$okhttp().get(i5));
                } catch (FileNotFoundException unused) {
                }
                return fSource;
            }
        }
    }

    public final class Entry {
        private final List<File> cleanFiles;
        private Editor currentEditor;
        private final List<File> dirtyFiles;
        private final String key;
        private final long[] lengths;
        private int lockingSourceCount;
        private boolean readable;
        private long sequenceNumber;
        final /* synthetic */ DiskLruCache this$0;
        private boolean zombie;

        public Entry(DiskLruCache diskLruCache, String str) {
            i.f(str, "key");
            this.this$0 = diskLruCache;
            this.key = str;
            this.lengths = new long[diskLruCache.getValueCount$okhttp()];
            this.cleanFiles = new ArrayList();
            this.dirtyFiles = new ArrayList();
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            int valueCount$okhttp = diskLruCache.getValueCount$okhttp();
            for (int i5 = 0; i5 < valueCount$okhttp; i5++) {
                sb.append(i5);
                this.cleanFiles.add(new File(this.this$0.getDirectory(), sb.toString()));
                sb.append(".tmp");
                this.dirtyFiles.add(new File(this.this$0.getDirectory(), sb.toString()));
                sb.setLength(length);
            }
        }

        private final Void invalidLengths(List<String> list) throws IOException {
            throw new IOException("unexpected journal line: " + list);
        }

        private final F newSource(int i5) throws FileNotFoundException {
            final F fSource = this.this$0.getFileSystem$okhttp().source(this.cleanFiles.get(i5));
            if (this.this$0.civilizedFileSystem) {
                return fSource;
            }
            this.lockingSourceCount++;
            final DiskLruCache diskLruCache = this.this$0;
            return new r(fSource) { // from class: okhttp3.internal.cache.DiskLruCache$Entry$newSource$1
                private boolean closed;

                @Override // W3.r, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    super.close();
                    if (this.closed) {
                        return;
                    }
                    this.closed = true;
                    DiskLruCache diskLruCache2 = diskLruCache;
                    DiskLruCache.Entry entry = this;
                    synchronized (diskLruCache2) {
                        entry.setLockingSourceCount$okhttp(entry.getLockingSourceCount$okhttp() - 1);
                        if (entry.getLockingSourceCount$okhttp() == 0 && entry.getZombie$okhttp()) {
                            diskLruCache2.removeEntry$okhttp(entry);
                        }
                    }
                }
            };
        }

        public final List<File> getCleanFiles$okhttp() {
            return this.cleanFiles;
        }

        public final Editor getCurrentEditor$okhttp() {
            return this.currentEditor;
        }

        public final List<File> getDirtyFiles$okhttp() {
            return this.dirtyFiles;
        }

        public final String getKey$okhttp() {
            return this.key;
        }

        public final long[] getLengths$okhttp() {
            return this.lengths;
        }

        public final int getLockingSourceCount$okhttp() {
            return this.lockingSourceCount;
        }

        public final boolean getReadable$okhttp() {
            return this.readable;
        }

        public final long getSequenceNumber$okhttp() {
            return this.sequenceNumber;
        }

        public final boolean getZombie$okhttp() {
            return this.zombie;
        }

        public final void setCurrentEditor$okhttp(Editor editor) {
            this.currentEditor = editor;
        }

        public final void setLengths$okhttp(List<String> list) throws IOException {
            i.f(list, "strings");
            if (list.size() != this.this$0.getValueCount$okhttp()) {
                invalidLengths(list);
                throw new b();
            }
            try {
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    this.lengths[i5] = Long.parseLong(list.get(i5));
                }
            } catch (NumberFormatException unused) {
                invalidLengths(list);
                throw new b();
            }
        }

        public final void setLockingSourceCount$okhttp(int i5) {
            this.lockingSourceCount = i5;
        }

        public final void setReadable$okhttp(boolean z4) {
            this.readable = z4;
        }

        public final void setSequenceNumber$okhttp(long j5) {
            this.sequenceNumber = j5;
        }

        public final void setZombie$okhttp(boolean z4) {
            this.zombie = z4;
        }

        public final Snapshot snapshot$okhttp() throws IOException {
            DiskLruCache diskLruCache = this.this$0;
            if (Util.assertionsEnabled && !Thread.holdsLock(diskLruCache)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + diskLruCache);
            }
            if (!this.readable) {
                return null;
            }
            if (!this.this$0.civilizedFileSystem && (this.currentEditor != null || this.zombie)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            long[] jArr = (long[]) this.lengths.clone();
            try {
                int valueCount$okhttp = this.this$0.getValueCount$okhttp();
                for (int i5 = 0; i5 < valueCount$okhttp; i5++) {
                    arrayList.add(newSource(i5));
                }
                return new Snapshot(this.this$0, this.key, this.sequenceNumber, arrayList, jArr);
            } catch (FileNotFoundException unused) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Util.closeQuietly((F) it.next());
                }
                try {
                    this.this$0.removeEntry$okhttp(this);
                } catch (IOException unused2) {
                }
                return null;
            }
        }

        public final void writeLengths$okhttp(m mVar) throws IOException {
            i.f(mVar, "writer");
            for (long j5 : this.lengths) {
                mVar.A(32).P(j5);
            }
        }
    }

    public final class Snapshot implements Closeable {
        private final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final List<F> sources;
        final /* synthetic */ DiskLruCache this$0;

        /* JADX WARN: Multi-variable type inference failed */
        public Snapshot(DiskLruCache diskLruCache, String str, long j5, List<? extends F> list, long[] jArr) {
            i.f(str, "key");
            i.f(list, "sources");
            i.f(jArr, "lengths");
            this.this$0 = diskLruCache;
            this.key = str;
            this.sequenceNumber = j5;
            this.sources = list;
            this.lengths = jArr;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            Iterator<F> it = this.sources.iterator();
            while (it.hasNext()) {
                Util.closeQuietly(it.next());
            }
        }

        public final Editor edit() throws IOException {
            return this.this$0.edit(this.key, this.sequenceNumber);
        }

        public final long getLength(int i5) {
            return this.lengths[i5];
        }

        public final F getSource(int i5) {
            return this.sources.get(i5);
        }

        public final String key() {
            return this.key;
        }
    }

    /* renamed from: okhttp3.internal.cache.DiskLruCache$snapshots$1, reason: invalid class name */
    public static final class AnonymousClass1 implements Iterator<Snapshot>, a {
        private final Iterator<Entry> delegate;
        private Snapshot nextSnapshot;
        private Snapshot removeSnapshot;

        public AnonymousClass1() {
            Iterator<Entry> it = new ArrayList(DiskLruCache.this.getLruEntries$okhttp().values()).iterator();
            i.e(it, "ArrayList(lruEntries.values).iterator()");
            this.delegate = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            Snapshot snapshotSnapshot$okhttp;
            if (this.nextSnapshot != null) {
                return true;
            }
            DiskLruCache diskLruCache = DiskLruCache.this;
            synchronized (diskLruCache) {
                if (diskLruCache.getClosed$okhttp()) {
                    return false;
                }
                while (this.delegate.hasNext()) {
                    Entry next = this.delegate.next();
                    if (next != null && (snapshotSnapshot$okhttp = next.snapshot$okhttp()) != null) {
                        this.nextSnapshot = snapshotSnapshot$okhttp;
                        return true;
                    }
                }
                return false;
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            Snapshot snapshot = this.removeSnapshot;
            if (snapshot == null) {
                throw new IllegalStateException("remove() before next()".toString());
            }
            try {
                DiskLruCache.this.remove(snapshot.key());
            } catch (IOException unused) {
            } catch (Throwable th) {
                this.removeSnapshot = null;
                throw th;
            }
            this.removeSnapshot = null;
        }

        @Override // java.util.Iterator
        public Snapshot next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Snapshot snapshot = this.nextSnapshot;
            this.removeSnapshot = snapshot;
            this.nextSnapshot = null;
            i.c(snapshot);
            return snapshot;
        }
    }

    /* JADX WARN: Type inference failed for: r5v3, types: [okhttp3.internal.cache.DiskLruCache$cleanupTask$1] */
    public DiskLruCache(FileSystem fileSystem, File file, int i5, int i6, long j5, TaskRunner taskRunner) {
        i.f(fileSystem, "fileSystem");
        i.f(file, "directory");
        i.f(taskRunner, "taskRunner");
        this.fileSystem = fileSystem;
        this.directory = file;
        this.appVersion = i5;
        this.valueCount = i6;
        this.maxSize = j5;
        this.lruEntries = new LinkedHashMap<>(0, 0.75f, true);
        this.cleanupQueue = taskRunner.newQueue();
        final String strE = h.e(new StringBuilder(), Util.okHttpName, " Cache");
        this.cleanupTask = new Task(strE) { // from class: okhttp3.internal.cache.DiskLruCache$cleanupTask$1
            @Override // okhttp3.internal.concurrent.Task
            public long runOnce() {
                DiskLruCache diskLruCache = this.this$0;
                synchronized (diskLruCache) {
                    if (!diskLruCache.initialized || diskLruCache.getClosed$okhttp()) {
                        return -1L;
                    }
                    try {
                        diskLruCache.trimToSize();
                    } catch (IOException unused) {
                        diskLruCache.mostRecentTrimFailed = true;
                    }
                    try {
                        if (diskLruCache.journalRebuildRequired()) {
                            diskLruCache.rebuildJournal$okhttp();
                            diskLruCache.redundantOpCount = 0;
                        }
                    } catch (IOException unused2) {
                        diskLruCache.mostRecentRebuildFailed = true;
                        diskLruCache.journalWriter = AbstractC0189b.b(new C0195h());
                    }
                    return -1L;
                }
            }
        };
        if (j5 <= 0) {
            throw new IllegalArgumentException("maxSize <= 0".toString());
        }
        if (i6 <= 0) {
            throw new IllegalArgumentException("valueCount <= 0".toString());
        }
        this.journalFile = new File(file, JOURNAL_FILE);
        this.journalFileTmp = new File(file, JOURNAL_FILE_TEMP);
        this.journalFileBackup = new File(file, JOURNAL_FILE_BACKUP);
    }

    private final synchronized void checkNotClosed() {
        if (!(!this.closed)) {
            throw new IllegalStateException("cache is closed".toString());
        }
    }

    public static /* synthetic */ Editor edit$default(DiskLruCache diskLruCache, String str, long j5, int i5, Object obj) throws IOException {
        if ((i5 & 2) != 0) {
            j5 = ANY_SEQUENCE_NUMBER;
        }
        return diskLruCache.edit(str, j5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean journalRebuildRequired() {
        int i5 = this.redundantOpCount;
        return i5 >= 2000 && i5 >= this.lruEntries.size();
    }

    private final m newJournalWriter() throws FileNotFoundException {
        return AbstractC0189b.b(new FaultHidingSink(this.fileSystem.appendingSink(this.journalFile), new DiskLruCache$newJournalWriter$faultHidingSink$1(this)));
    }

    private final void processJournal() throws IOException {
        this.fileSystem.delete(this.journalFileTmp);
        Iterator<Entry> it = this.lruEntries.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            i.e(next, "i.next()");
            Entry entry = next;
            int i5 = 0;
            if (entry.getCurrentEditor$okhttp() == null) {
                int i6 = this.valueCount;
                while (i5 < i6) {
                    this.size += entry.getLengths$okhttp()[i5];
                    i5++;
                }
            } else {
                entry.setCurrentEditor$okhttp(null);
                int i7 = this.valueCount;
                while (i5 < i7) {
                    this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i5));
                    this.fileSystem.delete(entry.getDirtyFiles$okhttp().get(i5));
                    i5++;
                }
                it.remove();
            }
        }
    }

    private final void readJournal() throws IOException {
        z zVarC = AbstractC0189b.c(this.fileSystem.source(this.journalFile));
        try {
            String strG = zVarC.G(Long.MAX_VALUE);
            String strG2 = zVarC.G(Long.MAX_VALUE);
            String strG3 = zVarC.G(Long.MAX_VALUE);
            String strG4 = zVarC.G(Long.MAX_VALUE);
            String strG5 = zVarC.G(Long.MAX_VALUE);
            if (!i.a(MAGIC, strG) || !i.a(VERSION_1, strG2) || !i.a(String.valueOf(this.appVersion), strG3) || !i.a(String.valueOf(this.valueCount), strG4) || strG5.length() > 0) {
                throw new IOException("unexpected journal header: [" + strG + ", " + strG2 + ", " + strG4 + ", " + strG5 + ']');
            }
            int i5 = 0;
            while (true) {
                try {
                    readJournalLine(zVarC.G(Long.MAX_VALUE));
                    i5++;
                } catch (EOFException unused) {
                    this.redundantOpCount = i5 - this.lruEntries.size();
                    if (zVarC.y()) {
                        this.journalWriter = newJournalWriter();
                    } else {
                        rebuildJournal$okhttp();
                    }
                    AbstractC0399v1.b(zVarC, null);
                    return;
                }
            }
        } finally {
        }
    }

    private final void readJournalLine(String str) throws IOException {
        String strSubstring;
        int iC = e.C(str, ' ', 0, false, 6);
        if (iC == -1) {
            throw new IOException("unexpected journal line: ".concat(str));
        }
        int i5 = iC + 1;
        int iC2 = e.C(str, ' ', i5, false, 4);
        if (iC2 == -1) {
            strSubstring = str.substring(i5);
            i.e(strSubstring, "this as java.lang.String).substring(startIndex)");
            String str2 = REMOVE;
            if (iC == str2.length() && M3.m.x(str, str2, false)) {
                this.lruEntries.remove(strSubstring);
                return;
            }
        } else {
            strSubstring = str.substring(i5, iC2);
            i.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        Entry entry = this.lruEntries.get(strSubstring);
        if (entry == null) {
            entry = new Entry(this, strSubstring);
            this.lruEntries.put(strSubstring, entry);
        }
        if (iC2 != -1) {
            String str3 = CLEAN;
            if (iC == str3.length() && M3.m.x(str, str3, false)) {
                String strSubstring2 = str.substring(iC2 + 1);
                i.e(strSubstring2, "this as java.lang.String).substring(startIndex)");
                List<String> listK = e.K(strSubstring2, new char[]{' '});
                entry.setReadable$okhttp(true);
                entry.setCurrentEditor$okhttp(null);
                entry.setLengths$okhttp(listK);
                return;
            }
        }
        if (iC2 == -1) {
            String str4 = DIRTY;
            if (iC == str4.length() && M3.m.x(str, str4, false)) {
                entry.setCurrentEditor$okhttp(new Editor(this, entry));
                return;
            }
        }
        if (iC2 == -1) {
            String str5 = READ;
            if (iC == str5.length() && M3.m.x(str, str5, false)) {
                return;
            }
        }
        throw new IOException("unexpected journal line: ".concat(str));
    }

    private final boolean removeOldestEntry() throws IOException {
        for (Entry entry : this.lruEntries.values()) {
            if (!entry.getZombie$okhttp()) {
                removeEntry$okhttp(entry);
                return true;
            }
        }
        return false;
    }

    private final void validateKey(String str) {
        d dVar = LEGAL_KEY_PATTERN;
        dVar.getClass();
        i.f(str, "input");
        if (dVar.f1752j.matcher(str).matches()) {
            return;
        }
        throw new IllegalArgumentException(("keys must match regex [a-z0-9_-]{1,120}: \"" + str + '\"').toString());
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        Editor currentEditor$okhttp;
        try {
            if (this.initialized && !this.closed) {
                Collection<Entry> collectionValues = this.lruEntries.values();
                i.e(collectionValues, "lruEntries.values");
                for (Entry entry : (Entry[]) collectionValues.toArray(new Entry[0])) {
                    if (entry.getCurrentEditor$okhttp() != null && (currentEditor$okhttp = entry.getCurrentEditor$okhttp()) != null) {
                        currentEditor$okhttp.detach$okhttp();
                    }
                }
                trimToSize();
                m mVar = this.journalWriter;
                i.c(mVar);
                mVar.close();
                this.journalWriter = null;
                this.closed = true;
                return;
            }
            this.closed = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void completeEdit$okhttp(Editor editor, boolean z4) throws IOException {
        i.f(editor, "editor");
        Entry entry$okhttp = editor.getEntry$okhttp();
        if (!i.a(entry$okhttp.getCurrentEditor$okhttp(), editor)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if (z4 && !entry$okhttp.getReadable$okhttp()) {
            int i5 = this.valueCount;
            for (int i6 = 0; i6 < i5; i6++) {
                boolean[] written$okhttp = editor.getWritten$okhttp();
                i.c(written$okhttp);
                if (!written$okhttp[i6]) {
                    editor.abort();
                    throw new IllegalStateException("Newly created entry didn't create value for index " + i6);
                }
                if (!this.fileSystem.exists(entry$okhttp.getDirtyFiles$okhttp().get(i6))) {
                    editor.abort();
                    return;
                }
            }
        }
        int i7 = this.valueCount;
        for (int i8 = 0; i8 < i7; i8++) {
            File file = entry$okhttp.getDirtyFiles$okhttp().get(i8);
            if (!z4 || entry$okhttp.getZombie$okhttp()) {
                this.fileSystem.delete(file);
            } else if (this.fileSystem.exists(file)) {
                File file2 = entry$okhttp.getCleanFiles$okhttp().get(i8);
                this.fileSystem.rename(file, file2);
                long j5 = entry$okhttp.getLengths$okhttp()[i8];
                long size = this.fileSystem.size(file2);
                entry$okhttp.getLengths$okhttp()[i8] = size;
                this.size = (this.size - j5) + size;
            }
        }
        entry$okhttp.setCurrentEditor$okhttp(null);
        if (entry$okhttp.getZombie$okhttp()) {
            removeEntry$okhttp(entry$okhttp);
            return;
        }
        this.redundantOpCount++;
        m mVar = this.journalWriter;
        i.c(mVar);
        if (entry$okhttp.getReadable$okhttp() || z4) {
            entry$okhttp.setReadable$okhttp(true);
            mVar.O(CLEAN).A(32);
            mVar.O(entry$okhttp.getKey$okhttp());
            entry$okhttp.writeLengths$okhttp(mVar);
            mVar.A(10);
            if (z4) {
                long j6 = this.nextSequenceNumber;
                this.nextSequenceNumber = 1 + j6;
                entry$okhttp.setSequenceNumber$okhttp(j6);
            }
        } else {
            this.lruEntries.remove(entry$okhttp.getKey$okhttp());
            mVar.O(REMOVE).A(32);
            mVar.O(entry$okhttp.getKey$okhttp());
            mVar.A(10);
        }
        mVar.flush();
        if (this.size > this.maxSize || journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final void delete() throws IOException {
        close();
        this.fileSystem.deleteContents(this.directory);
    }

    public final Editor edit(String str) throws IOException {
        i.f(str, "key");
        return edit$default(this, str, 0L, 2, null);
    }

    public final synchronized void evictAll() throws IOException {
        try {
            initialize();
            Collection<Entry> collectionValues = this.lruEntries.values();
            i.e(collectionValues, "lruEntries.values");
            for (Entry entry : (Entry[]) collectionValues.toArray(new Entry[0])) {
                i.e(entry, "entry");
                removeEntry$okhttp(entry);
            }
            this.mostRecentTrimFailed = false;
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        if (this.initialized) {
            checkNotClosed();
            trimToSize();
            m mVar = this.journalWriter;
            i.c(mVar);
            mVar.flush();
        }
    }

    public final synchronized Snapshot get(String str) throws IOException {
        i.f(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return null;
        }
        Snapshot snapshotSnapshot$okhttp = entry.snapshot$okhttp();
        if (snapshotSnapshot$okhttp == null) {
            return null;
        }
        this.redundantOpCount++;
        m mVar = this.journalWriter;
        i.c(mVar);
        mVar.O(READ).A(32).O(str).A(10);
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return snapshotSnapshot$okhttp;
    }

    public final boolean getClosed$okhttp() {
        return this.closed;
    }

    public final File getDirectory() {
        return this.directory;
    }

    public final FileSystem getFileSystem$okhttp() {
        return this.fileSystem;
    }

    public final LinkedHashMap<String, Entry> getLruEntries$okhttp() {
        return this.lruEntries;
    }

    public final synchronized long getMaxSize() {
        return this.maxSize;
    }

    public final int getValueCount$okhttp() {
        return this.valueCount;
    }

    public final synchronized void initialize() throws IOException {
        try {
            if (Util.assertionsEnabled && !Thread.holdsLock(this)) {
                throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + this);
            }
            if (this.initialized) {
                return;
            }
            if (this.fileSystem.exists(this.journalFileBackup)) {
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.delete(this.journalFileBackup);
                } else {
                    this.fileSystem.rename(this.journalFileBackup, this.journalFile);
                }
            }
            this.civilizedFileSystem = Util.isCivilized(this.fileSystem, this.journalFileBackup);
            if (this.fileSystem.exists(this.journalFile)) {
                try {
                    readJournal();
                    processJournal();
                    this.initialized = true;
                    return;
                } catch (IOException e5) {
                    Platform.Companion.get().log("DiskLruCache " + this.directory + " is corrupt: " + e5.getMessage() + ", removing", 5, e5);
                    try {
                        delete();
                        this.closed = false;
                    } catch (Throwable th) {
                        this.closed = false;
                        throw th;
                    }
                }
            }
            rebuildJournal$okhttp();
            this.initialized = true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final synchronized boolean isClosed() {
        return this.closed;
    }

    public final synchronized void rebuildJournal$okhttp() throws IOException {
        try {
            m mVar = this.journalWriter;
            if (mVar != null) {
                mVar.close();
            }
            y yVarB = AbstractC0189b.b(this.fileSystem.sink(this.journalFileTmp));
            try {
                yVarB.O(MAGIC);
                yVarB.A(10);
                yVarB.O(VERSION_1);
                yVarB.A(10);
                yVarB.P(this.appVersion);
                yVarB.A(10);
                yVarB.P(this.valueCount);
                yVarB.A(10);
                yVarB.A(10);
                for (Entry entry : this.lruEntries.values()) {
                    if (entry.getCurrentEditor$okhttp() != null) {
                        yVarB.O(DIRTY);
                        yVarB.A(32);
                        yVarB.O(entry.getKey$okhttp());
                        yVarB.A(10);
                    } else {
                        yVarB.O(CLEAN);
                        yVarB.A(32);
                        yVarB.O(entry.getKey$okhttp());
                        entry.writeLengths$okhttp(yVarB);
                        yVarB.A(10);
                    }
                }
                AbstractC0399v1.b(yVarB, null);
                if (this.fileSystem.exists(this.journalFile)) {
                    this.fileSystem.rename(this.journalFile, this.journalFileBackup);
                }
                this.fileSystem.rename(this.journalFileTmp, this.journalFile);
                this.fileSystem.delete(this.journalFileBackup);
                this.journalWriter = newJournalWriter();
                this.hasJournalErrors = false;
                this.mostRecentRebuildFailed = false;
            } finally {
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized boolean remove(String str) throws IOException {
        i.f(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (entry == null) {
            return false;
        }
        boolean zRemoveEntry$okhttp = removeEntry$okhttp(entry);
        if (zRemoveEntry$okhttp && this.size <= this.maxSize) {
            this.mostRecentTrimFailed = false;
        }
        return zRemoveEntry$okhttp;
    }

    public final boolean removeEntry$okhttp(Entry entry) throws IOException {
        m mVar;
        i.f(entry, "entry");
        if (!this.civilizedFileSystem) {
            if (entry.getLockingSourceCount$okhttp() > 0 && (mVar = this.journalWriter) != null) {
                mVar.O(DIRTY);
                mVar.A(32);
                mVar.O(entry.getKey$okhttp());
                mVar.A(10);
                mVar.flush();
            }
            if (entry.getLockingSourceCount$okhttp() > 0 || entry.getCurrentEditor$okhttp() != null) {
                entry.setZombie$okhttp(true);
                return true;
            }
        }
        Editor currentEditor$okhttp = entry.getCurrentEditor$okhttp();
        if (currentEditor$okhttp != null) {
            currentEditor$okhttp.detach$okhttp();
        }
        int i5 = this.valueCount;
        for (int i6 = 0; i6 < i5; i6++) {
            this.fileSystem.delete(entry.getCleanFiles$okhttp().get(i6));
            this.size -= entry.getLengths$okhttp()[i6];
            entry.getLengths$okhttp()[i6] = 0;
        }
        this.redundantOpCount++;
        m mVar2 = this.journalWriter;
        if (mVar2 != null) {
            mVar2.O(REMOVE);
            mVar2.A(32);
            mVar2.O(entry.getKey$okhttp());
            mVar2.A(10);
        }
        this.lruEntries.remove(entry.getKey$okhttp());
        if (journalRebuildRequired()) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
        return true;
    }

    public final void setClosed$okhttp(boolean z4) {
        this.closed = z4;
    }

    public final synchronized void setMaxSize(long j5) {
        this.maxSize = j5;
        if (this.initialized) {
            TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        }
    }

    public final synchronized long size() throws IOException {
        initialize();
        return this.size;
    }

    public final synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new AnonymousClass1();
    }

    public final void trimToSize() throws IOException {
        while (this.size > this.maxSize) {
            if (!removeOldestEntry()) {
                return;
            }
        }
        this.mostRecentTrimFailed = false;
    }

    public final synchronized Editor edit(String str, long j5) throws IOException {
        i.f(str, "key");
        initialize();
        checkNotClosed();
        validateKey(str);
        Entry entry = this.lruEntries.get(str);
        if (j5 != ANY_SEQUENCE_NUMBER && (entry == null || entry.getSequenceNumber$okhttp() != j5)) {
            return null;
        }
        if ((entry != null ? entry.getCurrentEditor$okhttp() : null) != null) {
            return null;
        }
        if (entry != null && entry.getLockingSourceCount$okhttp() != 0) {
            return null;
        }
        if (!this.mostRecentTrimFailed && !this.mostRecentRebuildFailed) {
            m mVar = this.journalWriter;
            i.c(mVar);
            mVar.O(DIRTY).A(32).O(str).A(10);
            mVar.flush();
            if (this.hasJournalErrors) {
                return null;
            }
            if (entry == null) {
                entry = new Entry(this, str);
                this.lruEntries.put(str, entry);
            }
            Editor editor = new Editor(this, entry);
            entry.setCurrentEditor$okhttp(editor);
            return editor;
        }
        TaskQueue.schedule$default(this.cleanupQueue, this.cleanupTask, 0L, 2, null);
        return null;
    }
}
