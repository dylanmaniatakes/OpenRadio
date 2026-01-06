package i4;

import O.C0182v;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import g4.g;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import java.util.concurrent.Semaphore;
import k4.l;

/* loaded from: classes.dex */
public abstract class d implements c {

    /* renamed from: a, reason: collision with root package name */
    public final int f7367a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7368b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7369c;

    /* renamed from: d, reason: collision with root package name */
    public final String f7370d;

    /* renamed from: e, reason: collision with root package name */
    public final Random f7371e = new Random();

    /* renamed from: f, reason: collision with root package name */
    public final int f7372f;
    public final String[] g;
    public final Semaphore h;

    /* renamed from: i, reason: collision with root package name */
    public final C0182v f7373i;

    public d(String str, int i5, int i6, int i7, String str2, String[] strArr, C0182v c0182v) {
        this.f7369c = str;
        this.f7367a = i5;
        this.f7368b = i6;
        this.f7372f = i7;
        this.f7370d = str2;
        this.g = strArr;
        this.f7373i = c0182v;
        int i8 = c0182v.f1974a;
        if (i8 > 0) {
            this.h = new Semaphore(i8, true);
        } else {
            this.h = null;
        }
    }

    public final String a() {
        String[] strArr = this.g;
        return (strArr == null || strArr.length <= 0) ? "" : strArr[this.f7371e.nextInt(strArr.length)];
    }

    public final g b(InputStream inputStream) throws IOException, a {
        try {
            int i5 = this.f7372f;
            if (inputStream.markSupported()) {
                inputStream.mark(1048576);
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeStream(inputStream, null, options);
                i5 = options.outHeight;
                inputStream.reset();
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inBitmap = g4.a.f7035c.b(i5, i5);
            options2.inSampleSize = 1;
            options2.inMutable = true;
            Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStream, null, options2);
            if (bitmapDecodeStream != null) {
                return new g(bitmapDecodeStream);
            }
        } catch (Exception e5) {
            Log.w("OsmDroid", "#547 Error loading bitmap" + e(), e5);
        } catch (OutOfMemoryError e6) {
            Log.e("OsmDroid", "OutOfMemoryError loading bitmap");
            System.gc();
            throw new a(e6);
        }
        return null;
    }

    public final String c(long j5) {
        return e() + '/' + ((int) (j5 >> 58)) + '/' + l.g(j5) + '/' + l.h(j5) + this.f7370d;
    }

    public abstract String d(long j5);

    public String e() {
        return this.f7369c;
    }

    public String toString() {
        return this.f7369c;
    }
}
