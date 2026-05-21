package o3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.n0;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class u extends N {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8964a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f8965b;

    public /* synthetic */ u(x xVar, int i5) {
        this.f8964a = i5;
        this.f8965b = xVar;
    }

    @Override // androidx.recyclerview.widget.N
    public final int getItemCount() {
        switch (this.f8964a) {
            case 0:
                return this.f8965b.n.size();
            default:
                return this.f8965b.f8994l.size();
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final void onBindViewHolder(n0 n0Var, int i5) {
        String str;
        switch (this.f8964a) {
            case 0:
                t tVar = (t) n0Var;
                s sVar = (s) this.f8965b.n.get(i5);
                tVar.getClass();
                tVar.f8959b.setText(sVar.f8951b);
                String str2 = sVar.f8955f;
                String str3 = sVar.g;
                if (str3 != null && !str3.isEmpty()) {
                    str2 = str2 + ", " + str3;
                }
                String str4 = sVar.h;
                if (str4 != null && !str4.isEmpty()) {
                    str2 = str2 + ", " + str4;
                }
                tVar.f8960c.setText(str2);
                TextView textView = tVar.f8961d;
                String str5 = sVar.f8956i;
                if (str5 == null || str5.isEmpty()) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(str5);
                    textView.setVisibility(0);
                }
                TextView textView2 = tVar.f8962e;
                String str6 = sVar.f8957j;
                if (str6 == null || str6.isEmpty()) {
                    textView2.setVisibility(8);
                } else {
                    textView2.setText(str6);
                    textView2.setVisibility(8);
                }
                u uVar = tVar.g;
                s sVar2 = uVar.f8965b.f8990f;
                boolean z4 = sVar2 != null && sVar2.f8950a.equals(sVar.f8950a);
                tVar.f8963f.setVisibility(z4 ? 0 : 4);
                CardView cardView = tVar.f8958a;
                x xVar = uVar.f8965b;
                if (!z4) {
                    cardView.setCardBackgroundColor(xVar.f8985a.getColor(R.color.card_dark));
                    cardView.setCardElevation(4.0f);
                    break;
                } else {
                    cardView.setCardBackgroundColor(xVar.f8985a.getColor(R.color.selected_card_dark));
                    cardView.setCardElevation(8.0f);
                    break;
                }
            default:
                w wVar = (w) n0Var;
                v vVar = (v) this.f8965b.f8994l.get(i5);
                wVar.getClass();
                wVar.f8972b.setText("TG " + vVar.f8968c);
                TextView textView3 = wVar.f8973c;
                String str7 = vVar.f8967b;
                textView3.setText(str7);
                TextView textView4 = wVar.f8974d;
                String str8 = vVar.f8969d;
                textView4.setText(str8);
                String str9 = vVar.f8966a;
                boolean z5 = str9 != null && str9.startsWith("manual_");
                u uVar2 = wVar.h;
                if (z5) {
                    textView4.setTextColor(uVar2.f8965b.f8985a.getColor(R.color.manual_entry_color));
                    textView3.setText(str7);
                } else {
                    textView4.setTextColor(uVar2.f8965b.f8985a.getColor(android.R.color.white));
                }
                TextView textView5 = wVar.f8975e;
                String str10 = vVar.f8970e;
                if (str10 == null || str10.isEmpty() || str10.equals(str8)) {
                    textView5.setVisibility(8);
                } else {
                    textView5.setText(str10);
                    textView5.setVisibility(0);
                }
                x xVar2 = uVar2.f8965b;
                v vVar2 = xVar2.f8996o;
                View view = wVar.f8976f;
                ImageView imageView = wVar.g;
                CardView cardView2 = wVar.f8971a;
                if (vVar2 != null && (str = vVar2.f8966a) != null && str.equals(str9)) {
                    view.setVisibility(0);
                    imageView.setImageResource(R.drawable.ic_check_circle);
                    cardView2.setCardBackgroundColor(xVar2.f8985a.getColor(R.color.selected_card_dark));
                    cardView2.setCardElevation(8.0f);
                    break;
                } else {
                    view.setVisibility(4);
                    if (z5) {
                        imageView.setImageResource(R.drawable.ic_radio);
                    } else {
                        imageView.setImageResource(R.drawable.ic_radio);
                    }
                    cardView2.setCardBackgroundColor(xVar2.f8985a.getColor(R.color.card_dark));
                    cardView2.setCardElevation(4.0f);
                    break;
                }
                break;
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final n0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        switch (this.f8964a) {
            case 0:
                return new t(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.server_item_layout, viewGroup, false));
            default:
                return new w(this, LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_talkgroup_dark, viewGroup, false));
        }
    }
}
