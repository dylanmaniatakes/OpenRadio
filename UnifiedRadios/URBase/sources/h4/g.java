package h4;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g extends M0.d {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f7092l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ m f7093m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(m mVar, int i5) {
        super(mVar);
        this.f7092l = i5;
        this.f7093m = mVar;
    }

    private final Drawable f(long j5) {
        if (((i4.c) ((j) this.f7093m).h.get()) == null) {
            return null;
        }
        try {
            e4.a.g().getClass();
            j jVar = (j) this.f7093m;
            synchronized (jVar) {
                Iterator it = ((ArrayList) jVar.f7100i).iterator();
                while (it.hasNext()) {
                    com.unified.ur1.SatelliteTracker.h.p(it.next());
                }
            }
        } catch (Throwable th) {
            Log.e("OsmDroid", "Error loading tile", th);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x01f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:163:? A[LOOP:1: B:113:0x01ae->B:163:?, LOOP_END, SYNTHETIC] */
    @Override // M0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable b(long r10) throws h4.b, java.lang.InterruptedException {
        /*
            Method dump skipped, instructions count: 536
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.g.b(long):android.graphics.drawable.Drawable");
    }

    @Override // M0.d
    public void e(g4.f fVar, Drawable drawable) {
        switch (this.f7092l) {
            case 1:
                k kVar = (k) this.f7093m;
                long j5 = fVar.f7064b;
                kVar.h(j5);
                g4.e eVar = (g4.e) fVar.f7065c;
                eVar.getClass();
                eVar.f(0);
                e4.a.g().getClass();
                eVar.j(j5);
                g4.a.f7035c.a(drawable);
                break;
            default:
                super.e(fVar, drawable);
                break;
        }
    }
}
