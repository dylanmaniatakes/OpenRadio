package h4;

import a.AbstractC0203a;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class q implements e {

    /* renamed from: c, reason: collision with root package name */
    public static long f7122c = 0;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f7123d = false;

    /* renamed from: a, reason: collision with root package name */
    public final p f7124a;

    /* renamed from: b, reason: collision with root package name */
    public long f7125b;

    public q() {
        this.f7124a = null;
        if (f7123d) {
            return;
        }
        f7123d = true;
        p pVar = new p(0, this);
        this.f7124a = pVar;
        pVar.setName("TileWriter#init");
        pVar.setPriority(1);
        pVar.start();
    }

    public static void c(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    f7122c = file2.length() + f7122c;
                }
                if (file2.isDirectory()) {
                    boolean zEquals = true;
                    try {
                        zEquals = true ^ file.getCanonicalPath().equals(file2.getCanonicalFile().getParent());
                    } catch (IOException | NoSuchElementException unused) {
                    }
                    if (!zEquals) {
                        c(file2);
                    }
                }
            }
        }
    }

    public static void d() {
        synchronized (e4.a.g().b(null)) {
            try {
                if (f7122c > e4.a.g().f6229i) {
                    Log.d("OsmDroid", "Trimming tile cache from " + f7122c + " to " + e4.a.g().f6229i);
                    File[] fileArr = (File[]) e(e4.a.g().b(null)).toArray(new File[0]);
                    Arrays.sort(fileArr, new B0.a(9));
                    for (File file : fileArr) {
                        if (f7122c <= e4.a.g().f6229i) {
                            break;
                        }
                        long length = file.length();
                        if (file.delete()) {
                            e4.a.g().getClass();
                            f7122c -= length;
                        }
                    }
                    Log.d("OsmDroid", "Finished trimming tile cache");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static ArrayList e(File file) {
        ArrayList arrayList = new ArrayList();
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                if (file2.isFile()) {
                    arrayList.add(file2);
                }
                if (file2.isDirectory()) {
                    arrayList.addAll(e(file2));
                }
            }
        }
        return arrayList;
    }

    public static File f(i4.c cVar, long j5) {
        return new File(e4.a.g().b(null), ((i4.d) cVar).c(j5) + ".tile");
    }

    @Override // h4.e
    public final boolean a(i4.c cVar, long j5, ByteArrayInputStream byteArrayInputStream, Long l5) throws Throwable {
        BufferedOutputStream bufferedOutputStream;
        File fileF = f(cVar, j5);
        e4.a.g().getClass();
        File parentFile = fileF.getParentFile();
        if (!parentFile.exists() && !parentFile.mkdirs()) {
            e4.a.g().getClass();
            try {
                Thread.sleep(500L);
            } catch (InterruptedException unused) {
            }
            if (!parentFile.exists()) {
                e4.a.g().getClass();
                return false;
            }
            e4.a.g().getClass();
        }
        BufferedOutputStream bufferedOutputStream2 = null;
        try {
            try {
                bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileF.getPath()), 8192);
            } catch (IOException unused2) {
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[8192];
            long j6 = 0;
            while (true) {
                int i5 = byteArrayInputStream.read(bArr);
                if (i5 == -1) {
                    break;
                }
                bufferedOutputStream.write(bArr, 0, i5);
                j6 += i5;
            }
            long j7 = f7122c + j6;
            f7122c = j7;
            if (j7 > e4.a.g().h) {
                d();
            }
            AbstractC0203a.c(bufferedOutputStream);
            return true;
        } catch (IOException unused3) {
            bufferedOutputStream2 = bufferedOutputStream;
            int i6 = j4.a.f7622a;
            if (bufferedOutputStream2 != null) {
                AbstractC0203a.c(bufferedOutputStream2);
            }
            return false;
        } catch (Throwable th2) {
            th = th2;
            bufferedOutputStream2 = bufferedOutputStream;
            if (bufferedOutputStream2 != null) {
                AbstractC0203a.c(bufferedOutputStream2);
            }
            throw th;
        }
    }

    @Override // h4.e
    public final void b() {
        p pVar = this.f7124a;
        if (pVar != null) {
            try {
                pVar.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    public final g4.g g(i4.c cVar, long j5) throws i4.a {
        File fileF = f(cVar, j5);
        g4.g gVar = null;
        if (!fileF.exists()) {
            return null;
        }
        String path = fileF.getPath();
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(path, options);
            int i5 = options.outHeight;
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inBitmap = g4.a.f7035c.b(i5, i5);
            options2.inSampleSize = 1;
            options2.inMutable = true;
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(path, options2);
            if (bitmapDecodeFile != null) {
                gVar = new g4.g(bitmapDecodeFile);
            } else if (new File(path).exists()) {
                Log.d("OsmDroid", path + " is an invalid image file, deleting...");
                try {
                    new File(path).delete();
                } catch (Throwable th) {
                    Log.e("OsmDroid", "Error deleting invalid file: " + path, th);
                }
            } else {
                Log.d("OsmDroid", "Request tile: " + path + " does not exist");
            }
        } catch (Exception e5) {
            Log.e("OsmDroid", "Unexpected error loading bitmap: " + path, e5);
            int i6 = j4.a.f7622a;
            System.gc();
        } catch (OutOfMemoryError e6) {
            Log.e("OsmDroid", "OutOfMemoryError loading bitmap: " + path);
            System.gc();
            throw new i4.a(e6);
        }
        if (fileF.lastModified() < System.currentTimeMillis() - this.f7125b && gVar != null) {
            e4.a.g().getClass();
            int[] iArr = g4.g.f7067d;
            gVar.f7068a = new int[]{-2};
        }
        return gVar;
    }
}
