package g4;

import F2.t;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import k4.j;
import k4.m;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f7038a;

    /* renamed from: b, reason: collision with root package name */
    public final k4.g f7039b;

    /* renamed from: c, reason: collision with root package name */
    public final j f7040c;

    /* renamed from: d, reason: collision with root package name */
    public final m f7041d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f7042e;

    /* renamed from: f, reason: collision with root package name */
    public int f7043f;
    public final t g;
    public final ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7044i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7045j;

    public b() {
        short s4 = e4.a.g().f6225c;
        this.f7038a = new HashMap();
        this.f7039b = new k4.g();
        this.f7040c = new j();
        this.f7041d = new m();
        this.f7042e = new ArrayList();
        this.h = new ArrayList();
        a(s4);
        this.g = new t(this);
    }

    public final boolean a(int i5) {
        if (this.f7043f >= i5) {
            return false;
        }
        Log.i("OsmDroid", "Tile cache increased from " + this.f7043f + " to " + i5);
        this.f7043f = i5;
        return true;
    }

    public final Drawable b(long j5) {
        Drawable drawable;
        synchronized (this.f7038a) {
            drawable = (Drawable) this.f7038a.get(Long.valueOf(j5));
        }
        return drawable;
    }

    public final void c(m mVar) {
        synchronized (this.f7038a) {
            try {
                mVar.b(this.f7038a.size());
                mVar.f8284k = 0;
                Iterator it = this.f7038a.keySet().iterator();
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    mVar.b(mVar.f8284k + 1);
                    long[] jArr = mVar.f8283j;
                    int i5 = mVar.f8284k;
                    mVar.f8284k = i5 + 1;
                    jArr[i5] = jLongValue;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(long j5) {
        Drawable drawable;
        synchronized (this.f7038a) {
            drawable = (Drawable) this.f7038a.remove(Long.valueOf(j5));
        }
        a.f7035c.a(drawable);
    }
}
