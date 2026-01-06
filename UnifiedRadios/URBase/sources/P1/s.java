package p1;

import android.os.Parcel;
import q1.C0865p;
import s1.C0885a;
import s1.C0887c;

/* loaded from: classes.dex */
public final class s implements o {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f9136c;

    public /* synthetic */ s(Object obj) {
        this.f9136c = obj;
    }

    @Override // p1.o
    public void p(Object obj, Object obj2) {
        N1.k kVar = (N1.k) obj2;
        C0885a c0885a = (C0885a) ((C0887c) obj).t();
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(c0885a.f8e);
        int i5 = A1.c.f10a;
        C0865p c0865p = (C0865p) this.f9136c;
        if (c0865p == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            c0865p.writeToParcel(parcelObtain, 0);
        }
        try {
            c0885a.f7d.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            kVar.a(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }
}
