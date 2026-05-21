package h4;

import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import java.io.IOException;

/* loaded from: classes.dex */
public final class i extends M0.d {

    /* renamed from: l, reason: collision with root package name */
    public final AssetManager f7096l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ j f7097m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(j jVar, AssetManager assetManager) {
        super(jVar);
        this.f7097m = jVar;
        this.f7096l = assetManager;
    }

    @Override // M0.d
    public final Drawable b(long j5) throws b {
        i4.c cVar = (i4.c) this.f7097m.h.get();
        if (cVar == null) {
            return null;
        }
        try {
            i4.d dVar = (i4.d) cVar;
            return dVar.b(this.f7096l.open(dVar.c(j5)));
        } catch (i4.a e5) {
            throw new b((Throwable) e5);
        } catch (IOException unused) {
            return null;
        }
    }
}
