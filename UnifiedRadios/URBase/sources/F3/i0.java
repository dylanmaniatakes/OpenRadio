package f3;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.unified.ur1.adapters.RepeaterDirectoryActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class i0 implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6727c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RepeaterDirectoryActivity f6728d;

    public /* synthetic */ i0(RepeaterDirectoryActivity repeaterDirectoryActivity, int i5) {
        this.f6727c = i5;
        this.f6728d = repeaterDirectoryActivity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        RepeaterDirectoryActivity repeaterDirectoryActivity = this.f6728d;
        switch (this.f6727c) {
            case 0:
                repeaterDirectoryActivity.f5699o = false;
                repeaterDirectoryActivity.startLocationUpdates();
                Toast.makeText(repeaterDirectoryActivity, "Switching to GPS location...", 0).show();
                break;
            case 1:
                int i6 = RepeaterDirectoryActivity.f5689s;
                repeaterDirectoryActivity.k();
                break;
            case 2:
                int i7 = RepeaterDirectoryActivity.f5689s;
                repeaterDirectoryActivity.k();
                break;
            case 3:
                int i8 = RepeaterDirectoryActivity.f5689s;
                repeaterDirectoryActivity.getClass();
                Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", repeaterDirectoryActivity.getPackageName(), null));
                repeaterDirectoryActivity.startActivity(intent);
                break;
            case 4:
                int i9 = RepeaterDirectoryActivity.f5689s;
                repeaterDirectoryActivity.getClass();
                dialogInterface.dismiss();
                repeaterDirectoryActivity.finish();
                break;
            case 5:
                int i10 = RepeaterDirectoryActivity.f5689s;
                repeaterDirectoryActivity.getClass();
                repeaterDirectoryActivity.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                break;
            default:
                int i11 = RepeaterDirectoryActivity.f5689s;
                repeaterDirectoryActivity.getClass();
                dialogInterface.dismiss();
                repeaterDirectoryActivity.finish();
                break;
        }
    }
}
