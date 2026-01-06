package f3;

import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import com.unified.ur1.adapters.LastHeardActivity;
import com.unified.ur1.adapters.MemoryChannelActivity;
import com.unified.ur1.adapters.RepeaterDirectoryActivity;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.primary.OptionsActivity;

/* renamed from: f3.g, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0516g implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6712c;

    public /* synthetic */ DialogInterfaceOnClickListenerC0516g(int i5) {
        this.f6712c = i5;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        switch (this.f6712c) {
            case 0:
                dialogInterface.dismiss();
                break;
            case 1:
                dialogInterface.dismiss();
                break;
            case 2:
                int i6 = LastHeardActivity.f5664i;
                dialogInterface.dismiss();
                break;
            case 3:
                int i7 = MemoryChannelActivity.f5681l;
                Log.d("Unified - MemoryChannel", "User clicked NO - dialog dismissed");
                break;
            case 4:
                int i8 = RepeaterDirectoryActivity.f5689s;
                dialogInterface.dismiss();
                break;
            case 5:
                int i9 = RepeaterDirectoryActivity.f5689s;
                dialogInterface.dismiss();
                break;
            case 6:
                int i10 = RepeaterDirectoryActivity.f5689s;
                dialogInterface.dismiss();
                break;
            case 7:
                Context context = LaunchActivity.f5853D1;
                dialogInterface.cancel();
                break;
            case 8:
                Context context2 = LaunchActivity.f5853D1;
                dialogInterface.cancel();
                break;
            case 9:
                Context context3 = LaunchActivity.f5853D1;
                dialogInterface.cancel();
                break;
            case 10:
                Context context4 = LaunchActivity.f5853D1;
                dialogInterface.cancel();
                break;
            default:
                int i11 = OptionsActivity.f5981H;
                dialogInterface.dismiss();
                break;
        }
    }
}
