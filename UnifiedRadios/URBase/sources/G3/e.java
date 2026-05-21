package g3;

import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6964a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChatActivity f6965b;

    public /* synthetic */ e(ChatActivity chatActivity, int i5) {
        this.f6964a = i5;
        this.f6965b = chatActivity;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        ChatActivity chatActivity = this.f6965b;
        Message message = (Message) obj;
        Message message2 = (Message) obj2;
        switch (this.f6964a) {
            case 0:
                int i5 = ChatActivity.f5725L;
                chatActivity.getClass();
                break;
            default:
                int i6 = ChatActivity.f5725L;
                chatActivity.getClass();
                break;
        }
        return Long.compare(ChatActivity.w(message.getCreatedAt()), ChatActivity.w(message2.getCreatedAt()));
    }
}
