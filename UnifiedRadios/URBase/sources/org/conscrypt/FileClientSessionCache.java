package org.conscrypt;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLSession;
import org.conscrypt.io.IoUtils;

/* loaded from: classes.dex */
public final class FileClientSessionCache {
    public static final int MAX_SIZE = 12;
    private static final Logger logger = Logger.getLogger(FileClientSessionCache.class.getName());
    static final Map<File, Impl> caches = new HashMap();

    public static class CacheFile extends File {
        long lastModified;
        final String name;

        public CacheFile(File file, String str) {
            super(file, str);
            this.lastModified = -1L;
            this.name = str;
        }

        @Override // java.io.File
        public long lastModified() {
            long j5 = this.lastModified;
            if (j5 != -1) {
                return j5;
            }
            long jLastModified = super.lastModified();
            this.lastModified = jLastModified;
            return jLastModified;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.lang.Comparable
        public int compareTo(File file) {
            long jLastModified = lastModified() - file.lastModified();
            return jLastModified == 0 ? super.compareTo(file) : jLastModified < 0 ? -1 : 1;
        }
    }

    public static class Impl implements SSLClientSessionCache {
        Map<String, File> accessOrder = newAccessOrder();
        final File directory;
        String[] initialFiles;
        int size;

        public Impl(File file) throws IOException {
            boolean zExists = file.exists();
            if (zExists && !file.isDirectory()) {
                throw new IOException(file + " exists but is not a directory.");
            }
            if (zExists) {
                String[] list = file.list();
                this.initialFiles = list;
                if (list == null) {
                    throw new IOException(file + " exists but cannot list contents.");
                }
                Arrays.sort(list);
                this.size = this.initialFiles.length;
            } else {
                if (!file.mkdirs()) {
                    throw new IOException("Creation of " + file + " directory failed.");
                }
                this.size = 0;
            }
            this.directory = file;
        }

        private void delete(File file) {
            if (!file.delete()) {
                IOException iOException = new IOException("FileClientSessionCache: Failed to delete " + file + ".");
                FileClientSessionCache.logger.log(Level.WARNING, iOException.getMessage(), (Throwable) iOException);
            }
            this.size--;
        }

        private static String fileName(String str, int i5) {
            if (str == null) {
                throw new NullPointerException("host == null");
            }
            return str + "." + i5;
        }

        private void indexFiles() {
            String[] strArr = this.initialFiles;
            if (strArr != null) {
                this.initialFiles = null;
                TreeSet treeSet = new TreeSet();
                for (String str : strArr) {
                    if (!this.accessOrder.containsKey(str)) {
                        treeSet.add(new CacheFile(this.directory, str));
                    }
                }
                if (treeSet.isEmpty()) {
                    return;
                }
                Map<String, File> mapNewAccessOrder = newAccessOrder();
                Iterator it = treeSet.iterator();
                while (it.hasNext()) {
                    CacheFile cacheFile = (CacheFile) it.next();
                    mapNewAccessOrder.put(cacheFile.name, cacheFile);
                }
                mapNewAccessOrder.putAll(this.accessOrder);
                this.accessOrder = mapNewAccessOrder;
            }
        }

        public static void logReadError(String str, File file, Throwable th) {
            FileClientSessionCache.logger.log(Level.WARNING, "FileClientSessionCache: Error reading session data for " + str + " from " + file + ".", th);
        }

        public static void logWriteError(String str, File file, Throwable th) {
            FileClientSessionCache.logger.log(Level.WARNING, "FileClientSessionCache: Error writing session data for " + str + " to " + file + ".", th);
        }

        private void makeRoom() {
            if (this.size <= 12) {
                return;
            }
            indexFiles();
            int i5 = this.size - 12;
            Iterator<File> it = this.accessOrder.values().iterator();
            do {
                delete(it.next());
                it.remove();
                i5--;
            } while (i5 > 0);
        }

        private static Map<String, File> newAccessOrder() {
            return new LinkedHashMap(12, 0.75f, true);
        }

        @Override // org.conscrypt.SSLClientSessionCache
        public synchronized byte[] getSessionData(String str, int i5) {
            String strFileName = fileName(str, i5);
            File file = this.accessOrder.get(strFileName);
            if (file == null) {
                String[] strArr = this.initialFiles;
                if (strArr == null) {
                    return null;
                }
                if (Arrays.binarySearch(strArr, strFileName) < 0) {
                    return null;
                }
                file = new File(this.directory, strFileName);
                this.accessOrder.put(strFileName, file);
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                try {
                    byte[] bArr = new byte[(int) file.length()];
                    new DataInputStream(fileInputStream).readFully(bArr);
                    return bArr;
                } catch (IOException e5) {
                    logReadError(str, file, e5);
                    return null;
                } finally {
                    IoUtils.closeQuietly(fileInputStream);
                }
            } catch (FileNotFoundException e6) {
                logReadError(str, file, e6);
                return null;
            }
        }

        @Override // org.conscrypt.SSLClientSessionCache
        public synchronized void putSessionData(SSLSession sSLSession, byte[] bArr) {
            String peerHost = sSLSession.getPeerHost();
            if (bArr == null) {
                throw new NullPointerException("sessionData == null");
            }
            String strFileName = fileName(peerHost, sSLSession.getPeerPort());
            File file = new File(this.directory, strFileName);
            boolean zExists = file.exists();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                if (!zExists) {
                    this.size++;
                    makeRoom();
                }
                try {
                    try {
                        try {
                            fileOutputStream.write(bArr);
                        } catch (IOException e5) {
                            logWriteError(peerHost, file, e5);
                            try {
                                try {
                                    fileOutputStream.close();
                                } finally {
                                }
                            } catch (IOException e6) {
                                logWriteError(peerHost, file, e6);
                            }
                            delete(file);
                        }
                        try {
                            fileOutputStream.close();
                            this.accessOrder.put(strFileName, file);
                        } catch (IOException e7) {
                            logWriteError(peerHost, file, e7);
                            delete(file);
                        }
                    } catch (Throwable th) {
                        try {
                            try {
                                fileOutputStream.close();
                            } catch (IOException e8) {
                                logWriteError(peerHost, file, e8);
                                throw th;
                            }
                            throw th;
                        } finally {
                        }
                    }
                } finally {
                }
            } catch (FileNotFoundException e9) {
                logWriteError(peerHost, file, e9);
            }
        }
    }

    private FileClientSessionCache() {
    }

    public static synchronized void reset() {
        caches.clear();
    }

    public static synchronized SSLClientSessionCache usingDirectory(File file) throws IOException {
        Impl impl;
        Map<File, Impl> map = caches;
        impl = map.get(file);
        if (impl == null) {
            impl = new Impl(file);
            map.put(file, impl);
        }
        return impl;
    }
}
