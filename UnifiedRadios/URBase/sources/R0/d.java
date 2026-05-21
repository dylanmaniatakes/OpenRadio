package R0;

import Q0.o;
import android.os.SystemClock;
import android.text.TextUtils;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: c, reason: collision with root package name */
    public final L0.c f2210c;

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f2208a = new LinkedHashMap(16, 0.75f, true);

    /* renamed from: b, reason: collision with root package name */
    public long f2209b = 0;

    /* renamed from: d, reason: collision with root package name */
    public final int f2211d = 5242880;

    public d(L0.c cVar) {
        this.f2210c = cVar;
    }

    public static String c(String str) {
        int length = str.length() / 2;
        StringBuilder sbB = AbstractC0882e.b(String.valueOf(str.substring(0, length).hashCode()));
        sbB.append(String.valueOf(str.substring(length).hashCode()));
        return sbB.toString();
    }

    public static int h(InputStream inputStream) throws IOException {
        int i5 = inputStream.read();
        if (i5 != -1) {
            return i5;
        }
        throw new EOFException();
    }

    public static int i(InputStream inputStream) {
        return (h(inputStream) << 24) | h(inputStream) | (h(inputStream) << 8) | (h(inputStream) << 16);
    }

    public static long j(InputStream inputStream) {
        return (h(inputStream) & 255) | ((h(inputStream) & 255) << 8) | ((h(inputStream) & 255) << 16) | ((h(inputStream) & 255) << 24) | ((h(inputStream) & 255) << 32) | ((h(inputStream) & 255) << 40) | ((h(inputStream) & 255) << 48) | ((255 & h(inputStream)) << 56);
    }

    public static String k(c cVar) {
        return new String(l(cVar, j(cVar)), "UTF-8");
    }

    public static byte[] l(c cVar, long j5) throws IOException {
        long j6 = cVar.f2206k - cVar.f2207l;
        if (j5 >= 0 && j5 <= j6) {
            int i5 = (int) j5;
            if (i5 == j5) {
                byte[] bArr = new byte[i5];
                new DataInputStream(cVar).readFully(bArr);
                return bArr;
            }
        }
        throw new IOException("streamToBytes length=" + j5 + ", maxLength=" + j6);
    }

    public static void m(BufferedOutputStream bufferedOutputStream, int i5) {
        bufferedOutputStream.write(i5 & 255);
        bufferedOutputStream.write((i5 >> 8) & 255);
        bufferedOutputStream.write((i5 >> 16) & 255);
        bufferedOutputStream.write((i5 >> 24) & 255);
    }

    public static void n(BufferedOutputStream bufferedOutputStream, long j5) {
        bufferedOutputStream.write((byte) j5);
        bufferedOutputStream.write((byte) (j5 >>> 8));
        bufferedOutputStream.write((byte) (j5 >>> 16));
        bufferedOutputStream.write((byte) (j5 >>> 24));
        bufferedOutputStream.write((byte) (j5 >>> 32));
        bufferedOutputStream.write((byte) (j5 >>> 40));
        bufferedOutputStream.write((byte) (j5 >>> 48));
        bufferedOutputStream.write((byte) (j5 >>> 56));
    }

    public static void o(BufferedOutputStream bufferedOutputStream, String str) {
        byte[] bytes = str.getBytes("UTF-8");
        n(bufferedOutputStream, bytes.length);
        bufferedOutputStream.write(bytes, 0, bytes.length);
    }

    public final synchronized Q0.b a(String str) {
        b bVar = (b) this.f2208a.get(str);
        if (bVar == null) {
            return null;
        }
        File fileB = b(str);
        try {
            c cVar = new c(new BufferedInputStream(new FileInputStream(fileB)), fileB.length());
            try {
                b bVarA = b.a(cVar);
                if (TextUtils.equals(str, bVarA.f2200b)) {
                    return bVar.b(l(cVar, cVar.f2206k - cVar.f2207l));
                }
                o.b("%s: key=%s, found=%s", fileB.getAbsolutePath(), str, bVarA.f2200b);
                b bVar2 = (b) this.f2208a.remove(str);
                if (bVar2 != null) {
                    this.f2209b -= bVar2.f2199a;
                }
                return null;
            } finally {
                cVar.close();
            }
        } catch (IOException e5) {
            o.b("%s: %s", fileB.getAbsolutePath(), e5.toString());
            synchronized (this) {
                boolean zDelete = b(str).delete();
                b bVar3 = (b) this.f2208a.remove(str);
                if (bVar3 != null) {
                    this.f2209b -= bVar3.f2199a;
                }
                if (!zDelete) {
                    o.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
                }
                return null;
            }
        }
    }

    public final File b(String str) {
        return new File(this.f2210c.e(), c(str));
    }

    public final synchronized void d() {
        long length;
        c cVar;
        File fileE = this.f2210c.e();
        if (!fileE.exists()) {
            if (!fileE.mkdirs()) {
                o.c("Unable to create cache dir %s", fileE.getAbsolutePath());
            }
            return;
        }
        File[] fileArrListFiles = fileE.listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            try {
                length = file.length();
                cVar = new c(new BufferedInputStream(new FileInputStream(file)), length);
            } catch (IOException unused) {
                file.delete();
            }
            try {
                b bVarA = b.a(cVar);
                bVarA.f2199a = length;
                g(bVarA.f2200b, bVarA);
                cVar.close();
            } catch (Throwable th) {
                cVar.close();
                throw th;
            }
        }
    }

    public final void e() {
        long j5 = this.f2209b;
        int i5 = this.f2211d;
        if (j5 < i5) {
            return;
        }
        int i6 = 0;
        if (o.f2164a) {
            o.d("Pruning old cache entries.", new Object[0]);
        }
        long j6 = this.f2209b;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Iterator it = this.f2208a.entrySet().iterator();
        while (it.hasNext()) {
            b bVar = (b) ((Map.Entry) it.next()).getValue();
            if (b(bVar.f2200b).delete()) {
                this.f2209b -= bVar.f2199a;
            } else {
                String str = bVar.f2200b;
                o.b("Could not delete cache entry for key=%s, filename=%s", str, c(str));
            }
            it.remove();
            i6++;
            if (this.f2209b < i5 * 0.9f) {
                break;
            }
        }
        if (o.f2164a) {
            o.d("pruned %d files, %d bytes, %d ms", Integer.valueOf(i6), Long.valueOf(this.f2209b - j6), Long.valueOf(SystemClock.elapsedRealtime() - jElapsedRealtime));
        }
    }

    public final synchronized void f(String str, Q0.b bVar) {
        BufferedOutputStream bufferedOutputStream;
        b bVar2;
        long j5 = this.f2209b;
        byte[] bArr = bVar.f2129a;
        long length = j5 + bArr.length;
        int i5 = this.f2211d;
        if (length <= i5 || bArr.length <= i5 * 0.9f) {
            File fileB = b(str);
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileB));
                bVar2 = new b(str, bVar);
            } catch (IOException unused) {
                if (!fileB.delete()) {
                    o.b("Could not clean up file %s", fileB.getAbsolutePath());
                }
                if (!this.f2210c.e().exists()) {
                    o.b("Re-initializing cache after external clearing.", new Object[0]);
                    this.f2208a.clear();
                    this.f2209b = 0L;
                    d();
                }
            }
            if (!bVar2.c(bufferedOutputStream)) {
                bufferedOutputStream.close();
                o.b("Failed to write header for %s", fileB.getAbsolutePath());
                throw new IOException();
            }
            bufferedOutputStream.write(bVar.f2129a);
            bufferedOutputStream.close();
            bVar2.f2199a = fileB.length();
            g(str, bVar2);
            e();
        }
    }

    public final void g(String str, b bVar) {
        LinkedHashMap linkedHashMap = this.f2208a;
        if (linkedHashMap.containsKey(str)) {
            this.f2209b = (bVar.f2199a - ((b) linkedHashMap.get(str)).f2199a) + this.f2209b;
        } else {
            this.f2209b += bVar.f2199a;
        }
        linkedHashMap.put(str, bVar);
    }
}
