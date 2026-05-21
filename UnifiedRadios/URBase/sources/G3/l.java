package g3;

import com.unified.ur1.chat.ChatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class l implements Callback {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6978c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ChatActivity f6979d;

    public /* synthetic */ l(ChatActivity chatActivity, int i5) {
        this.f6978c = i5;
        this.f6979d = chatActivity;
    }

    @Override // retrofit2.Callback
    public final void onFailure(Call call, Throwable th) {
        switch (this.f6978c) {
            case 0:
                this.f6979d.runOnUiThread(new j(this, 0));
                break;
            default:
                this.f6979d.runOnUiThread(new k(this, 1, th));
                break;
        }
    }

    @Override // retrofit2.Callback
    public final void onResponse(Call call, Response response) {
        switch (this.f6978c) {
            case 0:
                boolean zIsSuccessful = response.isSuccessful();
                ChatActivity chatActivity = this.f6979d;
                if (!zIsSuccessful) {
                    chatActivity.runOnUiThread(new j(this, 1));
                    break;
                } else {
                    chatActivity.runOnUiThread(new k(this, 0, (String) response.body()));
                    break;
                }
            default:
                this.f6979d.runOnUiThread(new k(this, 2, response));
                break;
        }
    }
}
