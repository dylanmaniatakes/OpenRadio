package J1;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.AbstractBinderC0407x;
import com.google.android.gms.internal.measurement.AbstractC0412y;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: J1.r1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0102r1 extends AbstractBinderC0407x implements N {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1367c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0120x1 f1368d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC0102r1(C0120x1 c0120x1, AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.IUploadBatchesCallback");
        this.f1367c = atomicReference;
        this.f1368d = c0120x1;
    }

    @Override // J1.N
    public final void B(P1 p12) {
        AtomicReference atomicReference = this.f1367c;
        synchronized (atomicReference) {
            Z z4 = ((C0113v0) this.f1368d.f84c).f1417k;
            C0113v0.k(z4);
            z4.f1084p.b(Integer.valueOf(p12.f929j.size()), "[sgtm] Got upload batches from service. count");
            atomicReference.set(p12);
            atomicReference.notifyAll();
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractBinderC0407x
    public final boolean a(int i5, Parcel parcel, Parcel parcel2) {
        if (i5 != 2) {
            return false;
        }
        P1 p12 = (P1) AbstractC0412y.a(parcel, P1.CREATOR);
        AbstractC0412y.b(parcel);
        B(p12);
        return true;
    }
}
