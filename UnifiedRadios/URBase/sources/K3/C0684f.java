package k3;

import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.unified.ur1.primary.BrowserActivity;

/* renamed from: k3.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0684f extends WebViewClient {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BrowserActivity f8124a;

    public C0684f(BrowserActivity browserActivity) {
        this.f8124a = browserActivity;
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i5, String str, String str2) {
        Toast.makeText(this.f8124a, "" + str, 0).show();
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        webView.loadUrl(str);
        return true;
    }
}
