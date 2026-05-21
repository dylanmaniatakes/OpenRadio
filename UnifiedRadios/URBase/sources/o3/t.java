package o3;

import android.view.View;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.n0;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class t extends n0 {

    /* renamed from: a, reason: collision with root package name */
    public final CardView f8958a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8959b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f8960c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8961d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f8962e;

    /* renamed from: f, reason: collision with root package name */
    public final View f8963f;
    public final /* synthetic */ u g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(u uVar, View view) {
        super(view);
        this.g = uVar;
        CardView cardView = (CardView) view.findViewById(R.id.serverCard);
        this.f8958a = cardView;
        this.f8959b = (TextView) view.findViewById(R.id.serverName);
        this.f8960c = (TextView) view.findViewById(R.id.serverLocation);
        this.f8961d = (TextView) view.findViewById(R.id.serverDistance);
        this.f8962e = (TextView) view.findViewById(R.id.serverComment);
        this.f8963f = view.findViewById(R.id.selectionIndicator);
        cardView.setOnClickListener(new com.google.android.material.datepicker.l(7, this));
    }
}
