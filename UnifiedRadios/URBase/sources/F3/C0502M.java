package f3;

import android.view.View;
import android.widget.TextView;
import com.unified.ur1.R;

/* renamed from: f3.M, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0502M extends AbstractC0496G {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f6614a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f6615b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f6616c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f6617d;

    /* renamed from: e, reason: collision with root package name */
    public final View f6618e;

    public C0502M(View view) {
        super(view);
        this.f6614a = (TextView) view.findViewById(R.id.channelNumber);
        this.f6615b = (TextView) view.findViewById(R.id.channelSubtitle);
        this.f6616c = (TextView) view.findViewById(R.id.networkInfo);
        this.f6617d = (TextView) view.findViewById(R.id.talkgroupInfo);
        this.f6618e = view.findViewById(R.id.connectionStatusContainer);
    }

    @Override // f3.AbstractC0496G
    public final void a(C0532x c0532x, InterfaceC0500K interfaceC0500K) {
        this.itemView.setOnClickListener(new ViewOnClickListenerC0498I(interfaceC0500K, c0532x, 2));
        this.f6614a.setText("" + c0532x.f6828a);
        this.f6615b.setText(c0532x.f6846v + " - " + c0532x.f6847w);
        TextView textView = this.f6616c;
        String str = c0532x.f6848x;
        if (str == null || str.isEmpty()) {
            textView.setText("Direct IP");
        } else {
            textView.setText(str);
        }
        this.f6617d.setText(String.format("TG: %d", Integer.valueOf(c0532x.f6837l)));
        this.f6618e.setVisibility(8);
    }
}
