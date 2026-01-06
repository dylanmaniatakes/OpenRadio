package I0;

import F3.i;
import L0.o;
import android.os.Build;

/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f668b;

    /* renamed from: c, reason: collision with root package name */
    public final int f669c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(J0.f fVar, int i5) {
        super(fVar);
        this.f668b = i5;
        switch (i5) {
            case 2:
                i.f(fVar, "tracker");
                super(fVar);
                this.f669c = 7;
                break;
            case 3:
                i.f(fVar, "tracker");
                super(fVar);
                this.f669c = 7;
                break;
            case 4:
                i.f(fVar, "tracker");
                super(fVar);
                this.f669c = 9;
                break;
            default:
                i.f(fVar, "tracker");
                this.f669c = 6;
                break;
        }
    }

    @Override // I0.e
    public final int a() {
        switch (this.f668b) {
        }
        return this.f669c;
    }

    @Override // I0.e
    public final boolean b(o oVar) {
        switch (this.f668b) {
            case 0:
                i.f(oVar, "workSpec");
                return oVar.f1568j.f144b;
            case 1:
                i.f(oVar, "workSpec");
                return oVar.f1568j.f146d;
            case 2:
                i.f(oVar, "workSpec");
                return oVar.f1568j.f143a == 2;
            case 3:
                i.f(oVar, "workSpec");
                int i5 = oVar.f1568j.f143a;
                return i5 == 3 || (Build.VERSION.SDK_INT >= 30 && i5 == 6);
            default:
                i.f(oVar, "workSpec");
                return oVar.f1568j.f147e;
        }
    }

    @Override // I0.e
    public final boolean c(Object obj) {
        switch (this.f668b) {
            case 2:
                H0.d dVar = (H0.d) obj;
                i.f(dVar, "value");
                if (!dVar.f646a || !dVar.f647b) {
                }
                break;
            case 3:
                H0.d dVar2 = (H0.d) obj;
                i.f(dVar2, "value");
                if (!dVar2.f646a || dVar2.f648c) {
                }
                break;
        }
        return !((Boolean) obj).booleanValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(J0.a aVar) {
        super(aVar);
        this.f668b = 1;
        i.f(aVar, "tracker");
        this.f669c = 5;
    }
}
