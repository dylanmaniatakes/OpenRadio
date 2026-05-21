package f3;

import X2.C0202f;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import com.unified.ur1.R;
import com.unified.ur1.rfmodule.RecordingsActivity;
import f.DialogC0469f;
import m3.C0776l;

/* renamed from: f3.b0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0508b0 implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6674c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ androidx.recyclerview.widget.N f6675d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6676e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f6677f;

    public /* synthetic */ ViewOnClickListenerC0508b0(androidx.recyclerview.widget.N n, Object obj, Object obj2, int i5) {
        this.f6674c = i5;
        this.f6675d = n;
        this.f6676e = obj;
        this.f6677f = obj2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6674c) {
            case 0:
                f0 f0Var = (f0) this.f6675d;
                if (PreferenceManager.getDefaultSharedPreferences(f0Var.f6710b).getString("user_callsign", null) == null) {
                    f0Var.c(new D0.p(f0Var, (m0) this.f6676e));
                } else {
                    f0Var.f6711c.execute(new Q(f0Var, 0));
                }
                ((DialogC0469f) this.f6677f).dismiss();
                break;
            case 1:
                f0 f0Var2 = (f0) this.f6675d;
                String string = PreferenceManager.getDefaultSharedPreferences(f0Var2.f6710b).getString("user_callsign", null);
                m0 m0Var = (m0) this.f6676e;
                if (string == null) {
                    f0Var2.c(new C0202f(f0Var2, 8, m0Var));
                } else {
                    f0Var2.g(m0Var);
                }
                ((DialogC0469f) this.f6677f).dismiss();
                break;
            default:
                L0.l lVar = ((m3.z) this.f6675d).f8647c;
                if (lVar != null) {
                    ImageButton imageButton = ((m3.y) this.f6677f).f8644c;
                    RecordingsActivity recordingsActivity = (RecordingsActivity) lVar.f1554d;
                    boolean z4 = recordingsActivity.f6094e;
                    C0776l c0776l = (C0776l) this.f6676e;
                    if (!z4 || c0776l.f8616a != recordingsActivity.g.f8616a) {
                        if (z4) {
                            Log.d("RecordingsActivity", "Stopping previous playback before starting new one");
                            recordingsActivity.j();
                        }
                        Log.d("RecordingsActivity", "Starting playback of new recording");
                        ImageButton imageButton2 = recordingsActivity.f6095f;
                        if (imageButton2 != null) {
                            imageButton2.setImageResource(R.drawable.ic_play);
                        }
                        recordingsActivity.f6094e = true;
                        recordingsActivity.f6095f = imageButton;
                        recordingsActivity.g = c0776l;
                        imageButton.setImageResource(R.drawable.ic_stop);
                        break;
                    } else {
                        Log.d("RecordingsActivity", "Stopping current playback");
                        recordingsActivity.j();
                        break;
                    }
                }
                break;
        }
    }
}
