package j0;

import D0.w;
import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.ROIP.DMRActivity;
import f3.C0515f;
import i3.C0573b;
import java.io.Serializable;
import k3.V0;

/* renamed from: j0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0588a implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7526j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f7527k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f7528l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f7529m;

    public /* synthetic */ RunnableC0588a(Object obj, int i5, Object obj2, int i6) {
        this.f7526j = i6;
        this.f7528l = obj;
        this.f7527k = i5;
        this.f7529m = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TextView textView;
        String str;
        TextView textView2;
        int i5 = this.f7527k;
        Object obj = this.f7529m;
        Object obj2 = this.f7528l;
        switch (this.f7526j) {
            case 0:
                ((C0589b) obj2).f7531b.d(i5, (Serializable) obj);
                break;
            case 1:
                LaunchActivity launchActivity = (LaunchActivity) obj2;
                CardView cardView = launchActivity.f5874F0;
                if (cardView != null && cardView.getVisibility() == 0 && (textView2 = (TextView) launchActivity.f5874F0.findViewById(R.id.ROIP_Connection)) != null) {
                    textView2.setText("ROIP Connected");
                }
                TextView textView3 = (TextView) obj;
                if (textView3 != null) {
                    if (LaunchActivity.f5854E1) {
                        str = "Multi-RX";
                    } else {
                        str = "TG: " + i5;
                    }
                    textView3.setText(str);
                    if (str.length() > 8) {
                        textView3.setTextSize(1, Math.max((8.0f / str.length()) * 60.0f, 30.0f));
                    } else {
                        textView3.setTextSize(1, 60.0f);
                    }
                    textView3.setTextColor(Color.parseColor("#000000"));
                    textView3.clearAnimation();
                }
                if (launchActivity.f5973x != null && (textView = (TextView) launchActivity.findViewById(R.id.locFlag)) != null) {
                    textView.setText("");
                    break;
                }
                break;
            case 2:
                C0573b c0573b = (C0573b) obj2;
                c0573b.getClass();
                Log.d("Unified - Main Activity", "Posting displayCallerInfo to main thread for radioId: " + i5);
                Context context = LaunchActivity.f5853D1;
                ((LaunchActivity) c0573b.f7297e).O((C0515f) obj);
                break;
            case 3:
                if (!((V0) obj2).f8061b.isFinishing()) {
                    w wVar = (w) obj;
                    if (wVar != null && ((String) wVar.f310c) != null) {
                        Log.d("Unified - Settings", "Mic gain set successfully to: " + i5);
                        break;
                    } else {
                        Log.w("Unified - Settings", "No response received for mic gain setting");
                        break;
                    }
                }
                break;
            default:
                DMRActivity dMRActivity = (DMRActivity) obj2;
                TextView textView4 = dMRActivity.f6058f;
                if (textView4 != null) {
                    textView4.setText("RX: " + ((String) obj) + " (" + i5 + ")");
                    dMRActivity.f6058f.setVisibility(0);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ RunnableC0588a(Object obj, Object obj2, int i5, int i6) {
        this.f7526j = i6;
        this.f7528l = obj;
        this.f7529m = obj2;
        this.f7527k = i5;
    }
}
