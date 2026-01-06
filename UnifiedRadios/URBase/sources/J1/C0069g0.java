package J1;

import android.content.SharedPreferences;

/* renamed from: J1.g0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0069g0 {

    /* renamed from: a, reason: collision with root package name */
    public final String f1216a;

    /* renamed from: b, reason: collision with root package name */
    public final long f1217b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f1218c;

    /* renamed from: d, reason: collision with root package name */
    public long f1219d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0072h0 f1220e;

    public C0069g0(C0072h0 c0072h0, String str, long j5) {
        this.f1220e = c0072h0;
        q1.E.f(str);
        this.f1216a = str;
        this.f1217b = j5;
    }

    public final long a() {
        if (!this.f1218c) {
            this.f1218c = true;
            this.f1219d = this.f1220e.p().getLong(this.f1216a, this.f1217b);
        }
        return this.f1219d;
    }

    public final void b(long j5) {
        SharedPreferences.Editor editorEdit = this.f1220e.p().edit();
        editorEdit.putLong(this.f1216a, j5);
        editorEdit.apply();
        this.f1219d = j5;
    }
}
