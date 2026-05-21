package n2;

import android.graphics.Matrix;
import android.graphics.Path;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public float f8876a;

    /* renamed from: b, reason: collision with root package name */
    public float f8877b;

    /* renamed from: c, reason: collision with root package name */
    public float f8878c;

    /* renamed from: d, reason: collision with root package name */
    public float f8879d;

    /* renamed from: e, reason: collision with root package name */
    public float f8880e;

    /* renamed from: f, reason: collision with root package name */
    public float f8881f;
    public final ArrayList g = new ArrayList();
    public final ArrayList h = new ArrayList();

    public w() {
        d(BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 270.0f, BitmapDescriptorFactory.HUE_RED);
    }

    public final void a(float f5) {
        float f6 = this.f8880e;
        if (f6 == f5) {
            return;
        }
        float f7 = ((f5 - f6) + 360.0f) % 360.0f;
        if (f7 > 180.0f) {
            return;
        }
        float f8 = this.f8878c;
        float f9 = this.f8879d;
        s sVar = new s(f8, f9, f8, f9);
        sVar.f8870f = this.f8880e;
        sVar.g = f7;
        this.h.add(new q(sVar));
        this.f8880e = f5;
    }

    public final void b(Matrix matrix, Path path) {
        ArrayList arrayList = this.g;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ((u) arrayList.get(i5)).a(matrix, path);
        }
    }

    public final void c(float f5, float f6) {
        t tVar = new t();
        tVar.f8871b = f5;
        tVar.f8872c = f6;
        this.g.add(tVar);
        r rVar = new r(tVar, this.f8878c, this.f8879d);
        float fB = rVar.b() + 270.0f;
        float fB2 = rVar.b() + 270.0f;
        a(fB);
        this.h.add(rVar);
        this.f8880e = fB2;
        this.f8878c = f5;
        this.f8879d = f6;
    }

    public final void d(float f5, float f6, float f7, float f8) {
        this.f8876a = f5;
        this.f8877b = f6;
        this.f8878c = f5;
        this.f8879d = f6;
        this.f8880e = f7;
        this.f8881f = (f7 + f8) % 360.0f;
        this.g.clear();
        this.h.clear();
    }
}
