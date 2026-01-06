package o3;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.n0;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class w extends n0 {

    /* renamed from: a, reason: collision with root package name */
    public final CardView f8971a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8972b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f8973c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8974d;

    /* renamed from: e, reason: collision with root package name */
    public final TextView f8975e;

    /* renamed from: f, reason: collision with root package name */
    public final View f8976f;
    public final ImageView g;
    public final /* synthetic */ u h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(u uVar, View view) {
        super(view);
        this.h = uVar;
        CardView cardView = (CardView) view.findViewById(R.id.talkgroupCard);
        this.f8971a = cardView;
        this.f8972b = (TextView) view.findViewById(R.id.talkgroupId);
        this.f8973c = (TextView) view.findViewById(R.id.talkgroupNetwork);
        this.f8974d = (TextView) view.findViewById(R.id.talkgroupDescription);
        this.f8975e = (TextView) view.findViewById(R.id.talkgroupFullDescription);
        this.f8976f = view.findViewById(R.id.selectionIndicator);
        this.g = (ImageView) view.findViewById(R.id.statusIcon);
        cardView.setOnClickListener(new com.google.android.material.datepicker.l(8, this));
    }
}
