package g3;

import com.unified.ur1.chat.NewMessageActivity;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: g3.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0548A implements Q0.k, Q0.j {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ NewMessageActivity f6955c;

    @Override // Q0.k
    public void a(JSONObject jSONObject) {
        int i5 = NewMessageActivity.f5757u;
        NewMessageActivity newMessageActivity = this.f6955c;
        newMessageActivity.getClass();
        try {
            newMessageActivity.k(jSONObject);
        } catch (JSONException e5) {
            newMessageActivity.n("Failed to parse response: " + e5.getMessage());
        }
    }

    @Override // Q0.j
    public void b(Q0.l lVar) {
        String str;
        int i5 = NewMessageActivity.f5757u;
        NewMessageActivity newMessageActivity = this.f6955c;
        newMessageActivity.getClass();
        if (lVar.getMessage() != null) {
            str = "Network error: " + lVar.getMessage();
        } else {
            str = "Network error";
        }
        newMessageActivity.n(str);
    }
}
