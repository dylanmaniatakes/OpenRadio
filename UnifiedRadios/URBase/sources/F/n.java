package f;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: c, reason: collision with root package name */
    public static final M0.m f6350c = new M0.m(new C2.c(8));

    /* renamed from: d, reason: collision with root package name */
    public static final int f6351d = -100;

    /* renamed from: e, reason: collision with root package name */
    public static K.i f6352e = null;

    /* renamed from: f, reason: collision with root package name */
    public static K.i f6353f = null;
    public static Boolean g = null;
    public static boolean h = false;

    /* renamed from: i, reason: collision with root package name */
    public static final q.c f6354i = new q.c(0);

    /* renamed from: j, reason: collision with root package name */
    public static final Object f6355j = new Object();

    /* renamed from: k, reason: collision with root package name */
    public static final Object f6356k = new Object();

    public static boolean c(Context context) {
        if (g == null) {
            try {
                int i5 = AbstractServiceC0457C.f6245c;
                Bundle bundle = context.getPackageManager().getServiceInfo(new ComponentName(context, (Class<?>) AbstractServiceC0457C.class), AbstractC0456B.a() | 128).metaData;
                if (bundle != null) {
                    g = Boolean.valueOf(bundle.getBoolean("autoStoreLocales"));
                }
            } catch (PackageManager.NameNotFoundException unused) {
                Log.d("AppCompatDelegate", "Checking for metadata for AppLocalesMetadataHolderService : Service not found");
                g = Boolean.FALSE;
            }
        }
        return g.booleanValue();
    }

    public static void h(n nVar) {
        synchronized (f6355j) {
            try {
                Iterator it = f6354i.iterator();
                while (it.hasNext()) {
                    n nVar2 = (n) ((WeakReference) it.next()).get();
                    if (nVar2 == nVar || nVar2 == null) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void a();

    public abstract void b();

    public abstract void d();

    public abstract void f();

    public abstract boolean i(int i5);

    public abstract void j(int i5);

    public abstract void k(View view);

    public abstract void l(View view, ViewGroup.LayoutParams layoutParams);

    public abstract void m(CharSequence charSequence);

    public abstract i.b n(i.a aVar);
}
