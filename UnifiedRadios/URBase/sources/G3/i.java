package g3;

import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageResponse;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class i implements Callback {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6971c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ChatActivity f6972d;

    public /* synthetic */ i(ChatActivity chatActivity, int i5) {
        this.f6971c = i5;
        this.f6972d = chatActivity;
    }

    @Override // retrofit2.Callback
    public final void onFailure(Call call, Throwable th) {
        switch (this.f6971c) {
            case 0:
                this.f6972d.runOnUiThread(new h(this, 0));
                break;
            default:
                ArrayList arrayList = new ArrayList();
                ChatActivity chatActivity = this.f6972d;
                chatActivity.f5744m.getSentMessages("get_sent", chatActivity.f5745o, 0, 300).enqueue(new L0.s(16, chatActivity, arrayList, false));
                break;
        }
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call call, Response response) {
        switch (this.f6971c) {
            case 0:
                if (response.isSuccessful()) {
                    this.f6972d.runOnUiThread(new h(this, 1));
                    break;
                }
                break;
            default:
                List<Message> arrayList = new ArrayList<>();
                if (response.isSuccessful() && response.body() != null && ((MessageResponse) response.body()).getMessages() != null) {
                    arrayList = ((MessageResponse) response.body()).getMessages();
                }
                ChatActivity chatActivity = this.f6972d;
                chatActivity.f5744m.getSentMessages("get_sent", chatActivity.f5745o, 0, 300).enqueue(new L0.s(16, chatActivity, arrayList, false));
                break;
        }
    }
}
