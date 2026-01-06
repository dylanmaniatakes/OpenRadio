package okhttp3.internal.io;

import F3.i;
import W3.C0192e;
import W3.C0193f;
import W3.D;
import W3.F;
import W3.I;
import W3.v;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public interface FileSystem {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final FileSystem SYSTEM = new Companion.SystemFileSystem();

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        public static final class SystemFileSystem implements FileSystem {
            @Override // okhttp3.internal.io.FileSystem
            public D appendingSink(File file) throws FileNotFoundException {
                i.f(file, "file");
                try {
                    Logger logger = v.f2665a;
                    return new C0192e(new FileOutputStream(file, true), 1, new I());
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    Logger logger2 = v.f2665a;
                    return new C0192e(new FileOutputStream(file, true), 1, new I());
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public void delete(File file) throws IOException {
                i.f(file, "file");
                if (file.delete() || !file.exists()) {
                    return;
                }
                throw new IOException("failed to delete " + file);
            }

            @Override // okhttp3.internal.io.FileSystem
            public void deleteContents(File file) throws IOException {
                i.f(file, "directory");
                File[] fileArrListFiles = file.listFiles();
                if (fileArrListFiles == null) {
                    throw new IOException("not a readable directory: " + file);
                }
                for (File file2 : fileArrListFiles) {
                    if (file2.isDirectory()) {
                        deleteContents(file2);
                    }
                    if (!file2.delete()) {
                        throw new IOException("failed to delete " + file2);
                    }
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public boolean exists(File file) {
                i.f(file, "file");
                return file.exists();
            }

            @Override // okhttp3.internal.io.FileSystem
            public void rename(File file, File file2) throws IOException {
                i.f(file, "from");
                i.f(file2, "to");
                delete(file2);
                if (file.renameTo(file2)) {
                    return;
                }
                throw new IOException("failed to rename " + file + " to " + file2);
            }

            @Override // okhttp3.internal.io.FileSystem
            public D sink(File file) throws FileNotFoundException {
                i.f(file, "file");
                try {
                    Logger logger = v.f2665a;
                    return new C0192e(new FileOutputStream(file, false), 1, new I());
                } catch (FileNotFoundException unused) {
                    file.getParentFile().mkdirs();
                    Logger logger2 = v.f2665a;
                    return new C0192e(new FileOutputStream(file, false), 1, new I());
                }
            }

            @Override // okhttp3.internal.io.FileSystem
            public long size(File file) {
                i.f(file, "file");
                return file.length();
            }

            @Override // okhttp3.internal.io.FileSystem
            public F source(File file) throws FileNotFoundException {
                i.f(file, "file");
                Logger logger = v.f2665a;
                return new C0193f(new FileInputStream(file), I.NONE);
            }

            public String toString() {
                return "FileSystem.SYSTEM";
            }
        }

        private Companion() {
        }
    }

    D appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    D sink(File file) throws FileNotFoundException;

    long size(File file);

    F source(File file) throws FileNotFoundException;
}
