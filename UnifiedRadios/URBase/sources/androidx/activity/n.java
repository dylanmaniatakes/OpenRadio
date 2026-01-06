package androidx.activity;

import androidx.fragment.app.K;
import java.util.ListIterator;
import s3.C0900j;

/* loaded from: classes.dex */
public final class n extends F3.j implements E3.a {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3241j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ u f3242k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(u uVar, int i5) {
        super(0);
        this.f3241j = i5;
        this.f3242k = uVar;
    }

    @Override // E3.a
    public final Object invoke() {
        Object objPrevious;
        switch (this.f3241j) {
            case 0:
                this.f3242k.b();
                break;
            case 1:
                u uVar = this.f3242k;
                t3.g gVar = uVar.f3279b;
                ListIterator listIterator = gVar.listIterator(gVar.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        objPrevious = listIterator.previous();
                        if (((K) objPrevious).f3671a) {
                        }
                    } else {
                        objPrevious = null;
                    }
                }
                uVar.f3280c = null;
                break;
            default:
                this.f3242k.b();
                break;
        }
        return C0900j.f9694a;
    }
}
