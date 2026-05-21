package i3;

import android.view.View;
import com.unified.ur1.inbox.ComposeMessageActivity;
import s2.C0890c;

/* renamed from: i3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnFocusChangeListenerC0574c implements View.OnFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7298a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f7299b;

    public /* synthetic */ ViewOnFocusChangeListenerC0574c(int i5, Object obj) {
        this.f7298a = i5;
        this.f7299b = obj;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z4) {
        Object obj = this.f7299b;
        switch (this.f7298a) {
            case 0:
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) obj;
                if (!z4) {
                    composeMessageActivity.f5806s.postDelayed(new C0.e(19, composeMessageActivity), 200L);
                    break;
                } else {
                    int i5 = ComposeMessageActivity.f5790C;
                    composeMessageActivity.getClass();
                    break;
                }
            case 1:
                C0890c c0890c = (C0890c) obj;
                c0890c.t(c0890c.u());
                break;
            default:
                s2.h hVar = (s2.h) obj;
                hVar.f9598l = z4;
                hVar.q();
                if (!z4) {
                    hVar.t(false);
                    hVar.f9599m = false;
                    break;
                }
                break;
        }
    }
}
