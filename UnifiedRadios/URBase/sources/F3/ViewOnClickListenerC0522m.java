package f3;

import android.app.AlertDialog;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.adapters.LastHeardActivity;

/* renamed from: f3.m, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0522m implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Z2.c f6742c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ C0525p f6743d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0523n f6744e;

    public ViewOnClickListenerC0522m(C0523n c0523n, Z2.c cVar, C0525p c0525p) {
        this.f6744e = c0523n;
        this.f6742c = cVar;
        this.f6743d = c0525p;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i5 = 1;
        long jCurrentTimeMillis = System.currentTimeMillis();
        C0523n c0523n = this.f6744e;
        if (jCurrentTimeMillis - c0523n.g < 300) {
            Runnable runnable = c0523n.f6765i;
            if (runnable != null) {
                c0523n.h.removeCallbacks(runnable);
            }
            Z2.c cVar = this.f6742c;
            if (cVar != null) {
                cVar.getClass();
                int i6 = LastHeardActivity.f5664i;
                LastHeardActivity lastHeardActivity = (LastHeardActivity) cVar.f3147d;
                lastHeardActivity.getClass();
                AlertDialog.Builder builder = new AlertDialog.Builder(lastHeardActivity, R.style.Base_Theme_Material3_Dark_Dialog);
                builder.setTitle("📻 Call Details");
                LinearLayout linearLayout = new LinearLayout(lastHeardActivity);
                linearLayout.setOrientation(1);
                linearLayout.setPadding(48, 32, 48, 32);
                GradientDrawable gradientDrawable = new GradientDrawable();
                gradientDrawable.setColors(new int[]{Color.parseColor("#1A1F2E"), Color.parseColor("#252A3A")});
                gradientDrawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                gradientDrawable.setCornerRadius(24.0f);
                linearLayout.setBackground(gradientDrawable);
                LinearLayout linearLayout2 = new LinearLayout(lastHeardActivity);
                linearLayout2.setOrientation(0);
                linearLayout2.setGravity(16);
                linearLayout2.setPadding(0, 0, 0, 24);
                TextView textView = new TextView(lastHeardActivity);
                textView.setText("📡");
                textView.setTextSize(28.0f);
                textView.setPadding(0, 0, 16, 0);
                linearLayout2.addView(textView);
                TextView textView2 = new TextView(lastHeardActivity);
                textView2.setText("Last Heard Call Information");
                textView2.setTextColor(Color.parseColor("#B0FFFFFF"));
                textView2.setTextSize(16.0f);
                linearLayout2.addView(textView2);
                linearLayout.addView(linearLayout2);
                LinearLayout linearLayout3 = new LinearLayout(lastHeardActivity);
                linearLayout3.setOrientation(1);
                linearLayout3.setPadding(24, 20, 24, 20);
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(Color.parseColor("#252A3A"));
                gradientDrawable2.setCornerRadius(16.0f);
                gradientDrawable2.setStroke(2, Color.parseColor("#FFD700"));
                linearLayout3.setBackground(gradientDrawable2);
                C0525p c0525p = this.f6743d;
                lastHeardActivity.j(linearLayout3, "📞 Callsign", c0525p.f6774a, "#4CAF50");
                lastHeardActivity.j(linearLayout3, "👤 Name", c0525p.f6775b, "#2196F3");
                lastHeardActivity.j(linearLayout3, "📍 Location", c0525p.f6776c, "#FF9800");
                lastHeardActivity.j(linearLayout3, "📻 Talkgroup", String.valueOf(c0525p.f6777d), "#9C27B0");
                lastHeardActivity.j(linearLayout3, "⏰ Time", c0525p.f6778e, "#607D8B");
                lastHeardActivity.j(linearLayout3, "⏱️ Duration", com.unified.ur1.SatelliteTracker.h.d(new StringBuilder(), c0525p.f6779f, " seconds"), "#795548");
                lastHeardActivity.j(linearLayout3, "📊 Status", c0525p.g, "#E91E63");
                linearLayout.addView(linearLayout3);
                builder.setView(linearLayout);
                builder.setPositiveButton("✅ Close", new DialogInterfaceOnClickListenerC0516g(2));
                String str = c0525p.f6774a;
                if (str != null && !str.isEmpty()) {
                    builder.setNeutralButton("🔍 QRZ Lookup", new DialogInterfaceOnClickListenerC0517h(lastHeardActivity, i5, c0525p));
                }
                AlertDialog alertDialogCreate = builder.create();
                if (alertDialogCreate.getWindow() != null) {
                    Window window = alertDialogCreate.getWindow();
                    window.setBackgroundDrawable(new ColorDrawable(-16777216));
                    window.getAttributes().windowAnimations = android.R.style.Animation.Dialog;
                    window.setFlags(4, 4);
                    window.getAttributes().dimAmount = 0.7f;
                }
                alertDialogCreate.show();
                Button button = alertDialogCreate.getButton(-1);
                Button button2 = alertDialogCreate.getButton(-3);
                if (button != null) {
                    button.setTextColor(Color.parseColor("#4CAF50"));
                    button.setTypeface(Typeface.DEFAULT_BOLD);
                    GradientDrawable gradientDrawable3 = new GradientDrawable();
                    gradientDrawable3.setColor(Color.parseColor("#1A4CAF50"));
                    gradientDrawable3.setCornerRadius(8.0f);
                    gradientDrawable3.setStroke(1, Color.parseColor("#4CAF50"));
                    button.setBackground(gradientDrawable3);
                }
                if (button2 != null) {
                    button2.setTextColor(Color.parseColor("#2196F3"));
                    button2.setTypeface(Typeface.DEFAULT_BOLD);
                    GradientDrawable gradientDrawable4 = new GradientDrawable();
                    gradientDrawable4.setColor(Color.parseColor("#1A2196F3"));
                    gradientDrawable4.setCornerRadius(8.0f);
                    gradientDrawable4.setStroke(1, Color.parseColor("#2196F3"));
                    button2.setBackground(gradientDrawable4);
                }
            }
        } else {
            C0.A a2 = new C0.A(19, this);
            c0523n.f6765i = a2;
            c0523n.h.postDelayed(a2, 300L);
        }
        c0523n.g = jCurrentTimeMillis;
    }
}
