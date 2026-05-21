package i3;

import android.content.DialogInterface;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.AppSettings;
import com.unified.ur1.primary.LaunchActivity;
import f3.C0524o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.C0676b;

/* renamed from: i3.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogInterfaceOnClickListenerC0580i implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7306c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7307d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f7308e;

    public /* synthetic */ DialogInterfaceOnClickListenerC0580i(Object obj, int i5, Object obj2) {
        this.f7306c = i5;
        this.f7308e = obj;
        this.f7307d = obj2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        l lVar;
        Object obj = this.f7308e;
        Object obj2 = this.f7307d;
        switch (this.f7306c) {
            case 0:
                m mVar = (m) obj;
                Message message = (Message) obj2;
                int iIndexOf = mVar.h.indexOf(message);
                if (i5 == 0) {
                    l lVar2 = mVar.f7320i;
                    if (lVar2 != null) {
                        ((UnifiedInboxActivity) lVar2).t(message);
                        mVar.i();
                        break;
                    }
                } else if (i5 == 1) {
                    m.g(mVar, message, iIndexOf);
                    break;
                } else if (i5 == 2) {
                    l lVar3 = mVar.f7320i;
                    if (lVar3 != null) {
                        ((UnifiedInboxActivity) lVar3).l(message);
                        break;
                    }
                } else if (i5 == 3 && (lVar = mVar.f7320i) != null) {
                    ((UnifiedInboxActivity) lVar).n(message);
                    break;
                }
                break;
            case 1:
                UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) obj;
                Message message2 = (Message) obj2;
                int iIndexOf2 = unifiedInboxActivity.f5835i.indexOf(message2);
                if (i5 == 0) {
                    unifiedInboxActivity.t(message2);
                    break;
                } else if (i5 == 1) {
                    unifiedInboxActivity.s(message2, iIndexOf2);
                    break;
                } else if (i5 == 2) {
                    unifiedInboxActivity.l(message2);
                    break;
                } else if (i5 == 3) {
                    unifiedInboxActivity.n(message2);
                    break;
                }
                break;
            case 2:
                String strTrim = ((EditText) obj2).getText().toString().trim();
                if (!strTrim.isEmpty()) {
                    int i6 = UnifiedInboxActivity.f5830m;
                    UnifiedInboxActivity unifiedInboxActivity2 = (UnifiedInboxActivity) obj;
                    unifiedInboxActivity2.getClass();
                    ArrayList arrayList = new ArrayList();
                    Iterator it = unifiedInboxActivity2.f5835i.iterator();
                    while (it.hasNext()) {
                        Message message3 = (Message) it.next();
                        String lowerCase = strTrim.toLowerCase();
                        if ((message3.getFromCallsign() != null && message3.getFromCallsign().toLowerCase().contains(lowerCase)) || ((message3.getSubject() != null && message3.getSubject().toLowerCase().contains(lowerCase)) || (message3.getPreviewText() != null && message3.getPreviewText().toLowerCase().contains(lowerCase)))) {
                            arrayList.add(message3);
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        unifiedInboxActivity2.g = new C0524o(arrayList, new Z2.c(20, unifiedInboxActivity2), 5);
                        Toast.makeText(unifiedInboxActivity2, "Found " + arrayList.size() + " messages", 0).show();
                        if (unifiedInboxActivity2.getSupportActionBar() != null) {
                            unifiedInboxActivity2.getSupportActionBar().p("Search Results (" + arrayList.size() + ")");
                            break;
                        }
                    } else {
                        Toast.makeText(unifiedInboxActivity2, "No messages found matching '" + strTrim + "'", 0).show();
                        break;
                    }
                }
                break;
            case 3:
                UnifiedInboxActivity unifiedInboxActivity3 = (UnifiedInboxActivity) obj;
                unifiedInboxActivity3.f5831c.setVisibility(0);
                unifiedInboxActivity3.j((ArrayList) ((List) obj2), 0);
                break;
            case 4:
                ((CompoundButton) obj2).setChecked(false);
                C0676b c0676b = (C0676b) obj;
                AppSettings appSettings = c0676b.f8104b;
                int i7 = AppSettings.f5842e;
                appSettings.n(false);
                h4.c.d0(c0676b.f8104b, String.valueOf(0));
                Log.w("Unified - Settings", "MARS capability enable cancelled by user");
                break;
            case 5:
                B.e.d((LaunchActivity) obj, (String[]) ((List) obj2).toArray(new String[0]), 123);
                break;
            default:
                B.e.d((LaunchActivity) obj, (String[]) obj2, 123);
                break;
        }
    }
}
