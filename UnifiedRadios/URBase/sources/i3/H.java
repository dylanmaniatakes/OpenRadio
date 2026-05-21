package i3;

import android.content.DialogInterface;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import f3.C0524o;

/* loaded from: classes.dex */
public final class H implements DialogInterface.OnCancelListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7289c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ UnifiedInboxActivity f7290d;

    public H(UnifiedInboxActivity unifiedInboxActivity, int i5) {
        this.f7290d = unifiedInboxActivity;
        this.f7289c = i5;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        C0524o c0524o = this.f7290d.g;
        if (c0524o != null) {
            c0524o.notifyItemChanged(this.f7289c);
        }
    }
}
