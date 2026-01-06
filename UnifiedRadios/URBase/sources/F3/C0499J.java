package f3;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.unified.ur1.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: f3.J, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0499J extends AbstractC0496G {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f6595a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f6596b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f6597c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f6598d;

    /* renamed from: e, reason: collision with root package name */
    public final View f6599e;

    /* renamed from: f, reason: collision with root package name */
    public final TextView f6600f;
    public final TextView g;
    public final LinearLayout h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f6601i;

    /* renamed from: j, reason: collision with root package name */
    public final LinearLayout f6602j;

    public C0499J(View view) {
        super(view);
        this.f6595a = (TextView) view.findViewById(R.id.channelNumber);
        this.f6596b = (TextView) view.findViewById(R.id.channelSubtitle);
        this.f6597c = (LinearLayout) view.findViewById(R.id.frequencySection);
        this.f6598d = (TextView) view.findViewById(R.id.frequencyInfo);
        this.f6599e = view.findViewById(R.id.frequencyDivider);
        this.f6600f = (TextView) view.findViewById(R.id.multiRxStatus);
        this.g = (TextView) view.findViewById(R.id.primaryContact);
        this.h = (LinearLayout) view.findViewById(R.id.multiContactsContainer);
        this.f6601i = (TextView) view.findViewById(R.id.multiContactsList);
        this.f6602j = (LinearLayout) view.findViewById(R.id.multiRxStatusContainer);
    }

    @Override // f3.AbstractC0496G
    public final void a(C0532x c0532x, InterfaceC0500K interfaceC0500K) {
        String str;
        this.itemView.setOnClickListener(new ViewOnClickListenerC0498I(interfaceC0500K, c0532x, 0));
        this.f6595a.setText(c0532x.f6828a);
        boolean zD = c0532x.d();
        String str2 = c0532x.f6832e;
        if (zD && (str = c0532x.f6840p) != null && !str.isEmpty()) {
            str2 = str2 + " - " + str;
        } else if (c0532x.f()) {
            String str3 = c0532x.f6846v;
            if (str3 != null && !str3.isEmpty()) {
                str2 = str2 + " - " + str3;
            }
            String str4 = c0532x.f6847w;
            if (str4 != null && !str4.isEmpty()) {
                str2 = str2 + " (" + str4 + ")";
            }
        }
        this.f6596b.setText(str2);
        boolean zF = c0532x.f();
        View view = this.f6599e;
        LinearLayout linearLayout = this.f6597c;
        if (zF) {
            linearLayout.setVisibility(8);
            view.setVisibility(8);
        } else {
            linearLayout.setVisibility(0);
            view.setVisibility(0);
            this.f6598d.setText(com.unified.ur1.SatelliteTracker.h.e(new StringBuilder(), c0532x.f6830c, " MHz"));
        }
        this.f6600f.setText(c0532x.b() > 0 ? c0532x.b() + " contacts monitored" : "Multi-RX enabled");
        String str5 = "TG " + c0532x.f6837l;
        String str6 = c0532x.f6841q;
        if (str6 != null && !str6.isEmpty()) {
            str5 = str5 + " (" + str6 + ")";
        }
        this.g.setText(str5);
        List list = c0532x.f6826F;
        boolean z4 = (list == null || list.isEmpty()) ? false : true;
        LinearLayout linearLayout2 = this.h;
        if (z4) {
            linearLayout2.setVisibility(0);
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < c0532x.b(); i5++) {
                String strA = c0532x.a(i5);
                String strC = c0532x.c(i5);
                C0497H c0497h = new C0497H();
                c0497h.f6590a = strA;
                c0497h.f6591b = strC;
                arrayList.add(c0497h);
            }
            Collections.sort(arrayList, new B0.a(7));
            StringBuilder sb = new StringBuilder();
            for (int i6 = 0; i6 < arrayList.size(); i6++) {
                C0497H c0497h2 = (C0497H) arrayList.get(i6);
                if (i6 > 0) {
                    sb.append("\n");
                }
                sb.append("TG ");
                sb.append(c0497h2.f6590a);
                String str7 = c0497h2.f6591b;
                if (str7 != null && !str7.isEmpty() && !str7.equals("null")) {
                    sb.append(" (");
                    sb.append(str7);
                    sb.append(")");
                }
            }
            this.f6601i.setText(sb.toString());
        } else {
            linearLayout2.setVisibility(8);
        }
        this.f6602j.setVisibility(0);
    }
}
