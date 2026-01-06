package g3;

import android.app.AlertDialog;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageResponse;
import f3.DialogInterfaceOnClickListenerC0517h;
import java.util.ArrayList;
import java.util.List;
import m3.C0777m;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class g implements Callback {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ChatActivity f6968c;

    public /* synthetic */ g(ChatActivity chatActivity) {
        this.f6968c = chatActivity;
    }

    public void a(Message message) {
        int i5 = ChatActivity.f5725L;
        ChatActivity chatActivity = this.f6968c;
        chatActivity.getClass();
        String[] strArr = {"Copy Text"};
        if (message.getFromCallsign().equals(chatActivity.f5745o)) {
            strArr = new String[]{"Copy Text", "Delete"};
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(chatActivity);
        builder.setItems(strArr, new DialogInterfaceOnClickListenerC0517h(chatActivity, 5, message));
        builder.show();
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        ArrayList arrayList = new ArrayList();
        ChatActivity chatActivity = this.f6968c;
        chatActivity.f5744m.getSentMessages("get_sent", chatActivity.f5745o, 0, 300).enqueue(new C0777m(chatActivity, arrayList));
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        List<Message> arrayList = new ArrayList<>();
        if (response.isSuccessful() && response.body() != null && ((MessageResponse) response.body()).getMessages() != null) {
            arrayList = ((MessageResponse) response.body()).getMessages();
        }
        ChatActivity chatActivity = this.f6968c;
        chatActivity.f5744m.getSentMessages("get_sent", chatActivity.f5745o, 0, 300).enqueue(new C0777m(chatActivity, arrayList));
    }
}
