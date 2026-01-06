package m3;

import android.content.Context;
import com.google.gson.Gson;

/* renamed from: m3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0765a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8566a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f8567b;

    /* renamed from: c, reason: collision with root package name */
    public int f8568c;

    /* renamed from: d, reason: collision with root package name */
    public int f8569d;

    /* renamed from: e, reason: collision with root package name */
    public int f8570e;

    /* renamed from: f, reason: collision with root package name */
    public int f8571f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f8572i;

    /* renamed from: j, reason: collision with root package name */
    public int f8573j;

    /* renamed from: k, reason: collision with root package name */
    public int f8574k;

    /* renamed from: l, reason: collision with root package name */
    public int f8575l;

    /* renamed from: m, reason: collision with root package name */
    public int f8576m;
    public int n;

    public /* synthetic */ C0765a() {
    }

    public static String b(int i5) {
        return String.format("%02X%02X%02X%02X", Integer.valueOf(i5 & 255), Integer.valueOf((i5 >> 8) & 255), Integer.valueOf((i5 >> 16) & 255), Integer.valueOf((i5 >> 24) & 255));
    }

    public C0765a a() {
        C0765a c0765a = new C0765a();
        c0765a.f8567b = this.f8567b;
        c0765a.f8568c = this.f8568c;
        c0765a.f8569d = this.f8569d;
        c0765a.f8570e = this.f8570e;
        c0765a.f8571f = this.f8571f;
        c0765a.g = this.g;
        c0765a.h = this.h;
        c0765a.f8572i = this.f8572i;
        c0765a.f8573j = this.f8573j;
        c0765a.f8574k = this.f8574k;
        c0765a.f8575l = this.f8575l;
        c0765a.f8576m = this.f8576m;
        c0765a.n = this.n;
        return c0765a;
    }

    public String toString() {
        switch (this.f8566a) {
            case 1:
                return new Gson().toJson(this);
            default:
                return super.toString();
        }
    }

    public C0765a(Context context) {
        this.f8567b = (int) h4.c.A(context);
        this.f8568c = (int) h4.c.E(context);
        this.f8569d = h4.c.C(context).getInt("band", 1);
        this.f8570e = h4.c.C(context).getInt("power", 1);
        this.f8571f = h4.c.C(context).getInt("squelch", 1);
        this.g = h4.c.C(context).getInt("rx_type", 0);
        this.h = h4.c.C(context).getInt("rx_subcode", 0);
        this.f8572i = h4.c.C(context).getInt("tx_type", 0);
        this.f8573j = h4.c.C(context).getInt("tx_subcode", 0);
        this.f8574k = h4.c.C(context).getInt("power_save", 2);
        this.f8575l = h4.c.C(context).getInt("volume", 1);
        this.f8576m = h4.c.C(context).getInt("monitor", 2);
        this.n = h4.c.C(context).getInt("relay", 2);
    }
}
