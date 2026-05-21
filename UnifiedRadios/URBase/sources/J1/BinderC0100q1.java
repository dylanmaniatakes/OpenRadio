package J1;

import android.os.Parcel;
import com.google.android.gms.internal.measurement.AbstractBinderC0407x;
import com.google.android.gms.internal.measurement.AbstractC0412y;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: J1.q1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class BinderC0100q1 extends AbstractBinderC0407x implements L {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AtomicReference f1356c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BinderC0100q1(AtomicReference atomicReference) {
        super("com.google.android.gms.measurement.internal.ITriggerUrisCallback");
        this.f1356c = atomicReference;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractBinderC0407x
    public final boolean a(int i5, Parcel parcel, Parcel parcel2) {
        if (i5 != 2) {
            return false;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(K1.CREATOR);
        AbstractC0412y.b(parcel);
        u(arrayListCreateTypedArrayList);
        return true;
    }

    @Override // J1.L
    public final void u(List list) {
        AtomicReference atomicReference = this.f1356c;
        synchronized (atomicReference) {
            atomicReference.set(list);
            atomicReference.notifyAll();
        }
    }
}
