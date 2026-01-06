package L;

import F2.t;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static final q.f f1517a = new q.f(16);

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadPoolExecutor f1518b;

    /* renamed from: c, reason: collision with root package name */
    public static final Object f1519c;

    /* renamed from: d, reason: collision with root package name */
    public static final q.k f1520d;

    static {
        k kVar = new k();
        kVar.f1531c = "fonts-androidx";
        kVar.f1530b = 10;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), kVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        f1518b = threadPoolExecutor;
        f1519c = new Object();
        f1520d = new q.k();
    }

    public static f a(String str, Context context, t tVar, int i5) {
        q.f fVar = f1517a;
        Typeface typeface = (Typeface) fVar.b(str);
        if (typeface != null) {
            return new f(typeface);
        }
        try {
            h hVarA = c.a(context, tVar);
            int i6 = 1;
            i[] iVarArr = (i[]) hVarA.f1522d;
            int i7 = hVarA.f1521c;
            if (i7 != 0) {
                i6 = i7 != 1 ? -3 : -2;
            } else if (iVarArr != null && iVarArr.length != 0) {
                int length = iVarArr.length;
                i6 = 0;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        break;
                    }
                    int i9 = iVarArr[i8].f1527e;
                    if (i9 == 0) {
                        i8++;
                    } else if (i9 >= 0) {
                        i6 = i9;
                    }
                }
            }
            if (i6 != 0) {
                return new f(i6);
            }
            Typeface typefaceE = E.g.f426a.e(context, iVarArr, i5);
            if (typefaceE == null) {
                return new f(-3);
            }
            fVar.c(str, typefaceE);
            return new f(typefaceE);
        } catch (PackageManager.NameNotFoundException unused) {
            return new f(-1);
        }
    }
}
