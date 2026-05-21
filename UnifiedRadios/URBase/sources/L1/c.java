package L1;

import N1.p;
import android.os.Parcel;
import p1.BinderC0823D;

/* loaded from: classes.dex */
public abstract class c extends A1.b implements d {
    @Override // A1.b
    public final boolean H(int i5, Parcel parcel, Parcel parcel2) {
        switch (i5) {
            case 3:
                A1.c.b(parcel);
                break;
            case 4:
                A1.c.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                A1.c.b(parcel);
                break;
            case 7:
                A1.c.b(parcel);
                break;
            case 8:
                g gVar = (g) A1.c.a(parcel, g.CREATOR);
                A1.c.b(parcel);
                BinderC0823D binderC0823D = (BinderC0823D) this;
                binderC0823D.f9088e.post(new p(binderC0823D, 11, gVar));
                break;
            case 9:
                A1.c.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
