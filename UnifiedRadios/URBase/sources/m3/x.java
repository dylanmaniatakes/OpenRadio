package m3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.format.DateFormat;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.rfmodule.RecordingsActivity;
import java.io.File;
import java.util.Date;

/* loaded from: classes.dex */
public final /* synthetic */ class x implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8639c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RecordingsActivity f8640d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0776l f8641e;

    public /* synthetic */ x(RecordingsActivity recordingsActivity, C0776l c0776l, int i5) {
        this.f8639c = i5;
        this.f8640d = recordingsActivity;
        this.f8641e = c0776l;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        C0776l c0776l;
        int i6 = 1;
        C0776l c0776l2 = this.f8641e;
        RecordingsActivity recordingsActivity = this.f8640d;
        switch (this.f8639c) {
            case 0:
                if (i5 != 0) {
                    int i7 = RecordingsActivity.f6091j;
                    recordingsActivity.getClass();
                    if (i5 == 1) {
                        new AlertDialog.Builder(recordingsActivity).setTitle("Delete Recording").setMessage("Are you sure you want to delete this recording?").setPositiveButton("Delete", new x(recordingsActivity, c0776l2, i6)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
                        break;
                    } else if (i5 == 2) {
                        dialogInterface.dismiss();
                        break;
                    }
                } else {
                    recordingsActivity.h = c0776l2;
                    Intent intent = new Intent("android.intent.action.CREATE_DOCUMENT");
                    intent.addCategory("android.intent.category.OPENABLE");
                    intent.setType("audio/raw");
                    intent.putExtra("android.intent.extra.TITLE", "Unified_Recording_" + ((Object) DateFormat.format("yyyy-MM-dd_HH-mm-ss", new Date(c0776l2.f8617b))) + ".raw");
                    try {
                        recordingsActivity.f6096i.a(intent);
                        break;
                    } catch (Exception e5) {
                        Toast.makeText(recordingsActivity, "Error launching file picker", 0).show();
                        Log.e("RecordingsActivity", "Error launching file picker", e5);
                        return;
                    }
                }
                break;
            default:
                if (recordingsActivity.f6094e && (c0776l = recordingsActivity.g) != null && c0776l.f8616a == c0776l2.f8616a) {
                    recordingsActivity.j();
                }
                File file = new File(c0776l2.f8618c);
                if (file.exists()) {
                    file.delete();
                }
                new Thread(new g3.k(recordingsActivity, 25, c0776l2)).start();
                break;
        }
    }
}
