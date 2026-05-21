package k;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.widget.SearchView;
import com.unified.ur1.primary.OptionsActivity;

/* renamed from: k.t0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0657t0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7868c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f7869d;

    public /* synthetic */ C0657t0(int i5, Object obj) {
        this.f7868c = i5;
        this.f7869d = obj;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    private final void c(AdapterView adapterView) {
    }

    private final void d(AdapterView adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i5, long j5) {
        C0648o0 c0648o0;
        int i6 = 1;
        Object obj = this.f7869d;
        switch (this.f7868c) {
            case 0:
                if (i5 != -1 && (c0648o0 = ((C0667y0) obj).f7891e) != null) {
                    c0648o0.setListSelectionHidden(false);
                    break;
                }
                break;
            case 1:
                ((SearchView) obj).q(i5);
                break;
            case 2:
                int i7 = OptionsActivity.f5981H;
                OptionsActivity optionsActivity = (OptionsActivity) obj;
                optionsActivity.getClass();
                try {
                    h4.c.C(optionsActivity).edit().putInt("aprssside", i5).apply();
                    OptionsActivity.f5981H = i5;
                    optionsActivity.B("SetAprsSsid", new k3.D0(i5, i6));
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error in setAprsSsid", e5);
                }
                Log.d("Unified - Settings", "APRS SSID selected: " + i5 + " (position: " + i5 + ")");
                break;
            default:
                if (i5 > 0) {
                    o3.x xVar = (o3.x) obj;
                    xVar.f8989e = (String) xVar.f8992j.get(i5 - 1);
                    if (!xVar.o()) {
                        xVar.f9000s.setSelection(0);
                        xVar.f8989e = null;
                        xVar.l();
                        break;
                    } else {
                        xVar.f8984H = 2;
                        xVar.n();
                        xVar.g();
                        break;
                    }
                }
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i5 = this.f7868c;
    }
}
