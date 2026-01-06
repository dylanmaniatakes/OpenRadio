package Z1;

import android.graphics.Typeface;
import com.google.android.gms.internal.measurement.D1;
import com.google.android.material.chip.Chip;
import g2.C0546j;
import g2.InterfaceC0545i;

/* loaded from: classes.dex */
public final class b extends D1 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3077b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3078c;

    public /* synthetic */ b(int i5, Object obj) {
        this.f3077b = i5;
        this.f3078c = obj;
    }

    private final void r(int i5) {
    }

    @Override // com.google.android.gms.internal.measurement.D1
    public final void l(int i5) {
        switch (this.f3077b) {
            case 0:
                break;
            default:
                C0546j c0546j = (C0546j) this.f3078c;
                c0546j.f6944e = true;
                InterfaceC0545i interfaceC0545i = (InterfaceC0545i) c0546j.f6945f.get();
                if (interfaceC0545i != null) {
                    interfaceC0545i.a();
                    break;
                }
                break;
        }
    }

    @Override // com.google.android.gms.internal.measurement.D1
    public final void m(Typeface typeface, boolean z4) {
        switch (this.f3077b) {
            case 0:
                Chip chip = (Chip) this.f3078c;
                f fVar = chip.g;
                chip.setText(fVar.f3094F0 ? fVar.f3095G : chip.getText());
                chip.requestLayout();
                chip.invalidate();
                break;
            default:
                if (!z4) {
                    C0546j c0546j = (C0546j) this.f3078c;
                    c0546j.f6944e = true;
                    InterfaceC0545i interfaceC0545i = (InterfaceC0545i) c0546j.f6945f.get();
                    if (interfaceC0545i != null) {
                        interfaceC0545i.a();
                        break;
                    }
                }
                break;
        }
    }
}
