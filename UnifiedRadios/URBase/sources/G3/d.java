package g3;

import android.util.Log;
import com.unified.ur1.chat.ChatActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements u0.j, Q0.k, Q0.j {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ChatActivity f6963c;

    @Override // Q0.k
    public void a(JSONObject jSONObject) {
        int i5 = ChatActivity.f5725L;
        ChatActivity chatActivity = this.f6963c;
        chatActivity.getClass();
        try {
            chatActivity.o(jSONObject);
        } catch (JSONException e5) {
            Log.w("ChatActivity", "Failed to parse distance response: " + e5.getMessage());
            chatActivity.A("");
        }
    }

    @Override // Q0.j
    public void b(Q0.l lVar) {
        int i5 = ChatActivity.f5725L;
        ChatActivity chatActivity = this.f6963c;
        chatActivity.getClass();
        Log.w("ChatActivity", "Failed to get distance info: " + lVar.getMessage());
        chatActivity.A("");
    }

    @Override // u0.j
    public void g() {
        int i5 = ChatActivity.f5725L;
        this.f6963c.t();
    }
}
