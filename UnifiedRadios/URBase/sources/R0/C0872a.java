package r0;

import android.util.Log;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: r0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0872a {

    /* renamed from: e, reason: collision with root package name */
    public static final HashMap f9510e = new HashMap();

    /* renamed from: a, reason: collision with root package name */
    public final boolean f9511a;

    /* renamed from: b, reason: collision with root package name */
    public final File f9512b;

    /* renamed from: c, reason: collision with root package name */
    public final Lock f9513c;

    /* renamed from: d, reason: collision with root package name */
    public FileChannel f9514d;

    public C0872a(String str, File file, boolean z4) {
        Lock lock;
        this.f9511a = z4;
        this.f9512b = file != null ? new File(file, str.concat(".lck")) : null;
        HashMap map = f9510e;
        synchronized (map) {
            try {
                Object reentrantLock = map.get(str);
                if (reentrantLock == null) {
                    reentrantLock = new ReentrantLock();
                    map.put(str, reentrantLock);
                }
                lock = (Lock) reentrantLock;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f9513c = lock;
    }

    public final void a(boolean z4) throws IOException {
        this.f9513c.lock();
        if (z4) {
            File file = this.f9512b;
            try {
                if (file == null) {
                    throw new IOException("No lock directory was provided.");
                }
                File parentFile = file.getParentFile();
                if (parentFile != null) {
                    parentFile.mkdirs();
                }
                FileChannel channel = new FileOutputStream(file).getChannel();
                channel.lock();
                this.f9514d = channel;
            } catch (IOException e5) {
                this.f9514d = null;
                Log.w("SupportSQLiteLock", "Unable to grab file lock.", e5);
            }
        }
    }

    public final void b() throws IOException {
        try {
            FileChannel fileChannel = this.f9514d;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.f9513c.unlock();
    }
}
