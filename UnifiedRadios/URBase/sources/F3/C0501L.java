package f3;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unified.ur1.R;

/* renamed from: f3.L, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0501L extends AbstractC0496G {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f6603a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f6604b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f6605c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f6606d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f6607e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f6608f;
    public final TextView g;
    public final TextView h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f6609i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f6610j;

    /* renamed from: k, reason: collision with root package name */
    public final TextView f6611k;

    /* renamed from: l, reason: collision with root package name */
    public final LinearLayout f6612l;

    /* renamed from: m, reason: collision with root package name */
    public final LinearLayout f6613m;
    public final LinearLayout n;

    public C0501L(View view) {
        super(view);
        this.f6603a = (TextView) view.findViewById(R.id.channelNumber);
        this.f6604b = (TextView) view.findViewById(R.id.channelName);
        this.f6605c = (TextView) view.findViewById(R.id.frequency);
        this.f6606d = (TextView) view.findViewById(R.id.offset);
        this.f6607e = (TextView) view.findViewById(R.id.mode);
        this.f6608f = (TextView) view.findViewById(R.id.bandwidth);
        this.g = (TextView) view.findViewById(R.id.toneInfo);
        this.h = (TextView) view.findViewById(R.id.dmrInfo);
        this.f6609i = (TextView) view.findViewById(R.id.colorCode);
        this.f6610j = (TextView) view.findViewById(R.id.talkgroup);
        this.f6611k = (TextView) view.findViewById(R.id.powerLevel);
        this.f6612l = (LinearLayout) view.findViewById(R.id.toneContainer);
        this.f6613m = (LinearLayout) view.findViewById(R.id.dmrContainer);
        this.n = (LinearLayout) view.findViewById(R.id.powerContainer);
    }

    @Override // f3.AbstractC0496G
    public final void a(C0532x c0532x, InterfaceC0500K interfaceC0500K) {
        this.itemView.setOnClickListener(new ViewOnClickListenerC0498I(interfaceC0500K, c0532x, 1));
        this.f6603a.setText(c0532x.f6828a);
        String str = c0532x.f6841q;
        TextView textView = this.f6604b;
        if (str == null || str.isEmpty()) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(8);
        }
        StringBuilder sb = new StringBuilder();
        String str2 = c0532x.f6830c;
        this.f6605c.setText(com.unified.ur1.SatelliteTracker.h.e(sb, str2, " MHz"));
        String str3 = c0532x.f6831d;
        boolean zEquals = str2.equals(str3);
        TextView textView2 = this.f6606d;
        if (zEquals) {
            textView2.setVisibility(8);
        } else {
            double d5 = Double.parseDouble(str3) - Double.parseDouble(str2);
            textView2.setText(d5 > 0.0d ? String.format("(+%.3f MHz)", Double.valueOf(Math.abs(d5))) : String.format("(-%.3f MHz)", Double.valueOf(Math.abs(d5))));
            textView2.setVisibility(0);
        }
        this.f6607e.setText(c0532x.f6832e);
        this.f6608f.setVisibility(8);
        StringBuilder sb2 = new StringBuilder();
        double d6 = c0532x.f6833f;
        int i5 = c0532x.f6834i;
        int i6 = c0532x.h;
        double d7 = c0532x.g;
        LinearLayout linearLayout = this.f6612l;
        if (d6 > 0.0d || d7 > 0.0d || i6 > 0 || i5 > 0) {
            if (d6 > 0.0d) {
                sb2.append(String.format("TX: %.1f Hz", Double.valueOf(d6)));
            }
            if (d7 > 0.0d) {
                if (sb2.length() > 0) {
                    sb2.append("  ");
                }
                sb2.append(String.format("RX: %.1f Hz", Double.valueOf(d7)));
            }
            if (i6 > 0) {
                if (sb2.length() > 0) {
                    sb2.append("  ");
                }
                sb2.append(String.format("TX DCS: %03d", Integer.valueOf(i6)));
            }
            if (i5 > 0) {
                if (sb2.length() > 0) {
                    sb2.append("  ");
                }
                sb2.append(String.format("RX DCS: %03d", Integer.valueOf(i5)));
            }
            this.g.setText(sb2.toString());
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        boolean zD = c0532x.d();
        LinearLayout linearLayout2 = this.f6613m;
        if (zD) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(0);
            String str4 = c0532x.f6840p;
            if (str4 == null || str4.isEmpty()) {
                str4 = "Local";
            }
            this.h.setText("DMR Network: ".concat(str4));
            String str5 = String.format("Color Code: %d", Integer.valueOf(c0532x.f6835j));
            TextView textView3 = this.f6609i;
            textView3.setText(str5);
            textView3.setVisibility(0);
            String str6 = String.format("TG: %d (TS%d)", Integer.valueOf(c0532x.f6837l), Integer.valueOf(c0532x.f6836k + 1));
            TextView textView4 = this.f6610j;
            textView4.setText(str6);
            textView4.setVisibility(0);
        } else {
            linearLayout2.setVisibility(8);
            linearLayout.setVisibility(0);
        }
        String str7 = c0532x.f6839o;
        LinearLayout linearLayout3 = this.n;
        if (str7 == null || str7.isEmpty()) {
            linearLayout3.setVisibility(8);
        } else {
            this.f6611k.setText(str7);
            linearLayout3.setVisibility(0);
        }
    }
}
