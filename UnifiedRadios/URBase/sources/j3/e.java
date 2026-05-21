package j3;

import L0.m;
import android.util.Log;
import h1.C0558b;

/* loaded from: classes.dex */
public final class e implements f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ f f7612c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ double f7613d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ double f7614e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ C0558b f7615f;

    public e(C0558b c0558b, m mVar, double d5, double d6) {
        this.f7615f = c0558b;
        this.f7612c = mVar;
        this.f7613d = d5;
        this.f7614e = d6;
    }

    @Override // j3.f
    public final void b(String str) {
        Log.w("WeatherDataManager", "Open-Meteo failed, trying OpenWeatherMap: " + str);
        Z2.c cVar = new Z2.c(22, this);
        this.f7615f.getClass();
        cVar.b("OpenWeatherMap API key not configured");
    }

    @Override // j3.f
    public final void c(g gVar) {
        this.f7615f.getClass();
        C0558b.a(gVar);
        this.f7612c.c(gVar);
    }
}
