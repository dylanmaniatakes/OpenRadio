package D1;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognition;
import p1.AbstractC0829e;

/* renamed from: D1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0006d extends AbstractC0829e {
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0006d(o1.k kVar, int i5) {
        super(ActivityRecognition.API, kVar);
        this.h = i5;
        switch (i5) {
            case 1:
                super(C0017o.f398i, kVar);
                break;
            case 2:
                super(C0017o.f398i, kVar);
                break;
            default:
                break;
        }
    }

    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    public final /* bridge */ /* synthetic */ o1.o a(Status status) {
        int i5 = this.h;
        return status;
    }
}
