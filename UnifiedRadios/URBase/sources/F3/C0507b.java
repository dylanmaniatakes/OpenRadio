package f3;

import android.view.View;
import android.widget.AdapterView;
import com.unified.ur1.adapters.AntennaCalculatorActivity;

/* renamed from: f3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0507b implements AdapterView.OnItemSelectedListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6672c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AntennaCalculatorActivity f6673d;

    public /* synthetic */ C0507b(AntennaCalculatorActivity antennaCalculatorActivity, int i5) {
        this.f6672c = i5;
        this.f6673d = antennaCalculatorActivity;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    private final void c(AdapterView adapterView) {
    }

    private final void d(AdapterView adapterView) {
    }

    private final void e(AdapterView adapterView) {
    }

    private final void f(AdapterView adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i5, long j5) {
        AntennaCalculatorActivity antennaCalculatorActivity = this.f6673d;
        switch (this.f6672c) {
            case 0:
                AntennaCalculatorActivity.m(antennaCalculatorActivity);
                break;
            case 1:
                AntennaCalculatorActivity.n(antennaCalculatorActivity);
                break;
            case 2:
                AntennaCalculatorActivity.j(antennaCalculatorActivity);
                break;
            case 3:
                int i6 = AntennaCalculatorActivity.f5587E0;
                antennaCalculatorActivity.r(i5);
                break;
            case 4:
                AntennaCalculatorActivity.k(antennaCalculatorActivity);
                break;
            default:
                AntennaCalculatorActivity.l(antennaCalculatorActivity);
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i5 = this.f6672c;
    }
}
