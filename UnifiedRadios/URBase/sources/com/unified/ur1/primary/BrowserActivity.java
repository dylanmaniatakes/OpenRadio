package com.unified.ur1.primary;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import f.AbstractActivityC0472i;
import k3.C0684f;

/* loaded from: classes.dex */
public class BrowserActivity extends AbstractActivityC0472i {

    /* renamed from: c, reason: collision with root package name */
    public WebView f5845c;

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.f5845c.canGoBack()) {
            this.f5845c.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        WebView webView = new WebView(this);
        this.f5845c = webView;
        setContentView(webView);
        WebSettings settings = this.f5845c.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setUserAgentString("Mozilla/5.0 (Linux; Android 11; Unified Radio App)");
        this.f5845c.setWebViewClient(new C0684f(this));
        String stringExtra = getIntent().getStringExtra("url");
        if (stringExtra != null && !stringExtra.isEmpty()) {
            this.f5845c.loadUrl(stringExtra);
        } else {
            Toast.makeText(this, "Invalid URL", 0).show();
            finish();
        }
    }
}
