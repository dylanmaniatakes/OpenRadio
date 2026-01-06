package k;

import android.R;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/* loaded from: classes.dex */
public final class S0 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f7696a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f7697b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f7698c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f7699d;

    /* renamed from: e, reason: collision with root package name */
    public final ImageView f7700e;

    public S0(View view) {
        this.f7696a = (TextView) view.findViewById(R.id.text1);
        this.f7697b = (TextView) view.findViewById(R.id.text2);
        this.f7698c = (ImageView) view.findViewById(R.id.icon1);
        this.f7699d = (ImageView) view.findViewById(R.id.icon2);
        this.f7700e = (ImageView) view.findViewById(com.unified.ur1.R.id.edit_query);
    }
}
