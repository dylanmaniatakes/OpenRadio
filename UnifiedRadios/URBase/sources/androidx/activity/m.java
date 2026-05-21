package androidx.activity;

import androidx.fragment.app.K;
import java.util.ListIterator;
import s3.C0900j;

/* loaded from: classes.dex */
public final class m extends F3.j implements E3.l {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f3239j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ u f3240k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(u uVar, int i5) {
        super(1);
        this.f3239j = i5;
        this.f3240k = uVar;
    }

    @Override // E3.l
    public final Object invoke(Object obj) {
        Object objPrevious;
        Object objPrevious2;
        switch (this.f3239j) {
            case 0:
                F3.i.f((b) obj, "backEvent");
                u uVar = this.f3240k;
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
                uVar.f3280c = (K) objPrevious;
                break;
            default:
                F3.i.f((b) obj, "backEvent");
                t3.g gVar2 = this.f3240k.f3279b;
                ListIterator listIterator2 = gVar2.listIterator(gVar2.size());
                while (true) {
                    if (listIterator2.hasPrevious()) {
                        objPrevious2 = listIterator2.previous();
                        if (((K) objPrevious2).f3671a) {
                        }
                    } else {
                        objPrevious2 = null;
                    }
                }
                break;
        }
        return C0900j.f9694a;
    }
}
