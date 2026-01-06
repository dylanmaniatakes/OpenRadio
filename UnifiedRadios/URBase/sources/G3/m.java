package g3;

import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import java.util.Comparator;
import retrofit2.Callback;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6980a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Callback f6981b;

    public /* synthetic */ m(Callback callback, int i5) {
        this.f6980a = i5;
        this.f6981b = callback;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Callback callback = this.f6981b;
        Message message = (Message) obj;
        Message message2 = (Message) obj2;
        switch (this.f6980a) {
            case 0:
                B0.l lVar = (B0.l) callback;
                lVar.getClass();
                String createdAt = message.getCreatedAt();
                int i5 = ChatActivity.f5725L;
                ((ChatActivity) lVar.f110d).getClass();
                return Long.compare(ChatActivity.w(createdAt), ChatActivity.w(message2.getCreatedAt()));
            default:
                L0.s sVar = (L0.s) callback;
                sVar.getClass();
                String createdAt2 = message.getCreatedAt();
                int i6 = ChatActivity.f5725L;
                ((ChatActivity) sVar.f1597e).getClass();
                return Long.compare(ChatActivity.w(createdAt2), ChatActivity.w(message2.getCreatedAt()));
        }
    }
}
