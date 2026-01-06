package J1;

import android.content.SharedPreferences;

/* renamed from: J1.f0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0066f0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1204a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1205b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1206c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1207d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0072h0 f1208e;

    public C0066f0(C0072h0 c0072h0, String str, boolean z4) {
        this.f1208e = c0072h0;
        q1.E.f(str);
        this.f1204a = str;
        this.f1205b = z4;
    }

    public final void a(boolean z4) {
        SharedPreferences.Editor editorEdit = this.f1208e.p().edit();
        editorEdit.putBoolean(this.f1204a, z4);
        editorEdit.apply();
        this.f1207d = z4;
    }

    public final boolean b() {
        if (!this.f1206c) {
            this.f1206c = true;
            this.f1207d = this.f1208e.p().getBoolean(this.f1204a, this.f1205b);
        }
        return this.f1207d;
    }
}
