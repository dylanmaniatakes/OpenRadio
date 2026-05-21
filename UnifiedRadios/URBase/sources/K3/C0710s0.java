package k3;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.unified.ur1.primary.LaunchActivity;
import java.util.Map;

/* renamed from: k3.s0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0710s0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Spinner f8202c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Spinner f8203d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8204e;

    public C0710s0(LaunchActivity launchActivity, Spinner spinner, Spinner spinner2) {
        this.f8204e = launchActivity;
        this.f8202c = spinner;
        this.f8203d = spinner2;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i5, long j5) {
        LaunchActivity launchActivity = this.f8204e;
        Spinner spinner = this.f8202c;
        LaunchActivity.j(launchActivity, spinner, i5);
        if (i5 == 2 || i5 == 3) {
            this.f8203d.setSelection(i5);
        }
        int iF = h4.c.F(LaunchActivity.f5853D1);
        for (Map.Entry entry : launchActivity.f5975x1.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == iF) {
                String str = (String) entry.getKey();
                int i6 = 0;
                int i7 = 0;
                while (true) {
                    if (i7 >= spinner.getCount()) {
                        break;
                    }
                    if (spinner.getItemAtPosition(i7).toString().equals(str)) {
                        i6 = i7;
                        break;
                    }
                    i7++;
                }
                if (i6 >= 0) {
                    spinner.setSelection(i6);
                    return;
                }
                return;
            }
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
    }
}
