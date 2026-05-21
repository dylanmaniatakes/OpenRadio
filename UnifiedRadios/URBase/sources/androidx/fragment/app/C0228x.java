package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import c.InterfaceC0288b;
import f.AbstractActivityC0472i;

/* renamed from: androidx.fragment.app.x, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0228x implements InterfaceC0288b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0230z f3893a;

    public C0228x(AbstractActivityC0472i abstractActivityC0472i) {
        this.f3893a = abstractActivityC0472i;
    }

    @Override // c.InterfaceC0288b
    public final void a(Context context) {
        AbstractActivityC0230z abstractActivityC0230z = this.f3893a;
        F f5 = abstractActivityC0230z.mFragments.f3650a;
        f5.f3654f.b(f5, f5, null);
        Bundle bundleA = abstractActivityC0230z.getSavedStateRegistry().a("android:support:fragments");
        if (bundleA != null) {
            Parcelable parcelable = bundleA.getParcelable("android:support:fragments");
            F f6 = abstractActivityC0230z.mFragments.f3650a;
            if (!(f6 instanceof androidx.lifecycle.X)) {
                throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
            }
            f6.f3654f.M(parcelable);
        }
    }
}
