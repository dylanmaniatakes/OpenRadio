package m3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.n0;
import com.hoho.android.usbserial.driver.UsbId;
import com.unified.ur1.R;
import f3.ViewOnClickListenerC0508b0;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public final class z extends N {

    /* renamed from: a, reason: collision with root package name */
    public List f8645a;

    /* renamed from: b, reason: collision with root package name */
    public Context f8646b;

    /* renamed from: c, reason: collision with root package name */
    public L0.l f8647c;

    /* renamed from: d, reason: collision with root package name */
    public SimpleDateFormat f8648d;

    @Override // androidx.recyclerview.widget.N
    public final int getItemCount() {
        List list = this.f8645a;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.N
    public final void onBindViewHolder(n0 n0Var, int i5) {
        y yVar = (y) n0Var;
        C0776l c0776l = (C0776l) this.f8645a.get(i5);
        String str = this.f8648d.format(new Date(c0776l.f8617b));
        int i6 = c0776l.f8619d;
        String str2 = String.format(Locale.getDefault(), "%d:%02d", Integer.valueOf(i6 / UsbId.SILABS_CP2102), Integer.valueOf((i6 % UsbId.SILABS_CP2102) / 1000));
        yVar.f8642a.setText(str);
        yVar.f8643b.setText(str2);
        ImageButton imageButton = yVar.f8644c;
        imageButton.setImageResource(R.drawable.ic_play);
        imageButton.setOnClickListener(new ViewOnClickListenerC0508b0(this, c0776l, yVar, 2));
        yVar.itemView.setOnLongClickListener(new i3.o(this, 2, c0776l));
    }

    @Override // androidx.recyclerview.widget.N
    public final n0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        View viewInflate = LayoutInflater.from(this.f8646b).inflate(R.layout.item_recording, viewGroup, false);
        y yVar = new y(viewInflate);
        yVar.f8642a = (TextView) viewInflate.findViewById(R.id.text_time);
        yVar.f8643b = (TextView) viewInflate.findViewById(R.id.text_duration);
        yVar.f8644c = (ImageButton) viewInflate.findViewById(R.id.play_button);
        return yVar;
    }
}
