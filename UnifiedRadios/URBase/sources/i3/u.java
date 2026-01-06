package i3;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import com.unified.ur1.inbox.MessageDetailActivity;
import com.unified.ur1.primary.LaunchActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class u implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7356c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Dialog f7357d;

    public /* synthetic */ u(Dialog dialog, int i5) {
        this.f7356c = i5;
        this.f7357d = dialog;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Dialog dialog = this.f7357d;
        switch (this.f7356c) {
            case 0:
                int i5 = MessageDetailActivity.f5814p;
                dialog.dismiss();
                break;
            case 1:
                Context context = LaunchActivity.f5853D1;
                dialog.dismiss();
                break;
            default:
                dialog.dismiss();
                break;
        }
    }
}
