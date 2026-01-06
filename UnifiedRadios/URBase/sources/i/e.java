package i;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class e extends ContextWrapper {

    /* renamed from: f, reason: collision with root package name */
    public static Configuration f7128f;

    /* renamed from: a, reason: collision with root package name */
    public int f7129a;

    /* renamed from: b, reason: collision with root package name */
    public Resources.Theme f7130b;

    /* renamed from: c, reason: collision with root package name */
    public LayoutInflater f7131c;

    /* renamed from: d, reason: collision with root package name */
    public Configuration f7132d;

    /* renamed from: e, reason: collision with root package name */
    public Resources f7133e;

    public e(Context context, int i5) {
        super(context);
        this.f7129a = i5;
    }

    public final void a(Configuration configuration) {
        if (this.f7133e != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.f7132d != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.f7132d = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public final void b() {
        if (this.f7130b == null) {
            this.f7130b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.f7130b.setTo(theme);
            }
        }
        this.f7130b.applyStyle(this.f7129a, true);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final AssetManager getAssets() {
        return getResources().getAssets();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // android.content.ContextWrapper, android.content.Context
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.content.res.Resources getResources() {
        /*
            r3 = this;
            android.content.res.Resources r0 = r3.f7133e
            if (r0 != 0) goto L32
            android.content.res.Configuration r0 = r3.f7132d
            if (r0 == 0) goto L2c
            android.content.res.Configuration r1 = i.e.f7128f
            if (r1 != 0) goto L16
            android.content.res.Configuration r1 = new android.content.res.Configuration
            r1.<init>()
            r2 = 0
            r1.fontScale = r2
            i.e.f7128f = r1
        L16:
            android.content.res.Configuration r1 = i.e.f7128f
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L1f
            goto L2c
        L1f:
            android.content.res.Configuration r0 = r3.f7132d
            android.content.Context r0 = i.d.a(r3, r0)
            android.content.res.Resources r0 = r0.getResources()
            r3.f7133e = r0
            goto L32
        L2c:
            android.content.res.Resources r0 = super.getResources()
            r3.f7133e = r0
        L32:
            android.content.res.Resources r0 = r3.f7133e
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i.e.getResources():android.content.res.Resources");
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return getBaseContext().getSystemService(str);
        }
        if (this.f7131c == null) {
            this.f7131c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
        }
        return this.f7131c;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme = this.f7130b;
        if (theme != null) {
            return theme;
        }
        if (this.f7129a == 0) {
            this.f7129a = R.style.Theme_AppCompat_Light;
        }
        b();
        return this.f7130b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i5) {
        if (this.f7129a != i5) {
            this.f7129a = i5;
            b();
        }
    }
}
