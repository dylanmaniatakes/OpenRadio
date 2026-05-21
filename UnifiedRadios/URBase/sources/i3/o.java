package i3;

import android.app.AlertDialog;
import android.view.View;
import android.widget.Toast;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.rfmodule.RecordingsActivity;
import f3.C0519j;
import m3.C0776l;

/* loaded from: classes.dex */
public final /* synthetic */ class o implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7324a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7325b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f7326c;

    public /* synthetic */ o(Object obj, int i5, Object obj2) {
        this.f7324a = i5;
        this.f7326c = obj;
        this.f7325b = obj2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        String str;
        Object obj = this.f7325b;
        Object obj2 = this.f7326c;
        switch (this.f7324a) {
            case 0:
                s sVar = (s) obj2;
                if (sVar != null) {
                    sVar.h((Message) obj);
                    break;
                }
                break;
            case 1:
                C0519j c0519j = (C0519j) obj2;
                if (c0519j != null) {
                    E e5 = (E) c0519j.f6730d;
                    if (e5.getContext() != null) {
                        Message message = (Message) obj;
                        String str2 = message.isRead() ? "Read" : "Unread";
                        if (!message.isRead() || message.getReadAt() == null) {
                            str = "";
                        } else {
                            str = " at " + message.getReadAt();
                        }
                        Toast.makeText(e5.getContext(), "To: " + message.getToCallsign() + "\nStatus: " + str2 + str, 1).show();
                        break;
                    }
                }
                break;
            default:
                L0.l lVar = ((m3.z) obj2).f8647c;
                if (lVar != null) {
                    int i5 = RecordingsActivity.f6091j;
                    RecordingsActivity recordingsActivity = (RecordingsActivity) lVar.f1554d;
                    recordingsActivity.getClass();
                    new AlertDialog.Builder(recordingsActivity).setTitle("Recording Options").setItems(new String[]{"Save to External Storage", "Delete", "Cancel"}, new m3.x(recordingsActivity, (C0776l) obj, 0)).show();
                    break;
                }
                break;
        }
        return true;
    }
}
