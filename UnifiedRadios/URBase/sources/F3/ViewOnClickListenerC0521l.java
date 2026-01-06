package f3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import com.unified.ur1.R;
import com.unified.ur1.adapters.LastHeardActivity;

/* renamed from: f3.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0521l implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6738c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LastHeardActivity f6739d;

    public /* synthetic */ ViewOnClickListenerC0521l(LastHeardActivity lastHeardActivity, int i5) {
        this.f6738c = i5;
        this.f6739d = lastHeardActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        LastHeardActivity lastHeardActivity = this.f6739d;
        switch (this.f6738c) {
            case 0:
                int i5 = LastHeardActivity.f5664i;
                lastHeardActivity.getClass();
                AlertDialog.Builder builder = new AlertDialog.Builder(lastHeardActivity, R.style.Base_Theme_Material3_Dark_Dialog);
                builder.setTitle("Clear History");
                builder.setMessage("Are you sure you want to clear all last heard data?");
                builder.setPositiveButton("Clear", new DialogInterfaceOnClickListenerC0520k(0, lastHeardActivity));
                builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
                builder.show();
                break;
            default:
                lastHeardActivity.finish();
                break;
        }
    }
}
