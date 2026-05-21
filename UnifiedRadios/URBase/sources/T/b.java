package T;

import android.database.DataSetObserver;
import k.C0667y0;

/* loaded from: classes.dex */
public final class b extends DataSetObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2431a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2432b;

    public /* synthetic */ b(int i5, Object obj) {
        this.f2431a = i5;
        this.f2432b = obj;
    }

    @Override // android.database.DataSetObserver
    public final void onChanged() {
        switch (this.f2431a) {
            case 0:
                c cVar = (c) this.f2432b;
                cVar.f2433c = true;
                cVar.notifyDataSetChanged();
                break;
            default:
                C0667y0 c0667y0 = (C0667y0) this.f2432b;
                if (c0667y0.f7888B.isShowing()) {
                    c0667y0.c();
                    break;
                }
                break;
        }
    }

    @Override // android.database.DataSetObserver
    public final void onInvalidated() {
        switch (this.f2431a) {
            case 0:
                c cVar = (c) this.f2432b;
                cVar.f2433c = false;
                cVar.notifyDataSetInvalidated();
                break;
            default:
                ((C0667y0) this.f2432b).dismiss();
                break;
        }
    }
}
