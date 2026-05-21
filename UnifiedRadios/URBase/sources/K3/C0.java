package k3;

import android.app.Activity;
import com.unified.ur1.adapters.AppDatabase;
import f3.C0518i;
import java.util.List;
import java.util.concurrent.Executors;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class C0 extends androidx.lifecycle.S {
    public static AppDatabase g;

    /* renamed from: d, reason: collision with root package name */
    public Activity f7947d = null;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.lifecycle.B f7948e = new androidx.lifecycle.B();

    /* renamed from: f, reason: collision with root package name */
    public e4.a f7949f;

    public final void c() {
        Object obj = this.f7948e.f3899e;
        if (obj == androidx.lifecycle.A.f3894k) {
            obj = null;
        }
        List list = (List) obj;
        if (list == null) {
            return;
        }
        for (int i5 = 0; i5 < list.size(); i5++) {
            ((C0518i) list.get(i5)).getClass();
        }
    }

    public final void d() {
        if (g == null) {
            g = (AppDatabase) AbstractC0930a.h(this.f7947d.getApplicationContext(), AppDatabase.class, "UR1-db").b();
        }
        Executors.newSingleThreadExecutor().execute(new C0.e(27, this));
    }
}
