package g3;

import com.unified.ur1.chat.ChatActivity;
import java.util.ArrayList;

/* renamed from: g3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0551b implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6961j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ChatActivity f6962k;

    public /* synthetic */ RunnableC0551b(ChatActivity chatActivity, int i5) {
        this.f6961j = i5;
        this.f6962k = chatActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ChatActivity chatActivity = this.f6962k;
        switch (this.f6961j) {
            case 0:
                chatActivity.f5738e.g0(chatActivity.n.size() - 1);
                break;
            case 1:
                int i5 = ChatActivity.f5725L;
                chatActivity.v();
                break;
            case 2:
                chatActivity.f5738e.g0(chatActivity.n.size() - 1);
                break;
            case 3:
                ArrayList arrayList = chatActivity.n;
                if (arrayList != null && !arrayList.isEmpty()) {
                    chatActivity.f5738e.j0(chatActivity.n.size() - 1);
                    break;
                }
                break;
            case 4:
                int i6 = ChatActivity.f5725L;
                chatActivity.k();
                break;
            default:
                chatActivity.f5743l.notifyDataSetChanged();
                if (!chatActivity.n.isEmpty()) {
                    chatActivity.f5738e.post(new RunnableC0551b(chatActivity, 2));
                    break;
                }
                break;
        }
    }
}
