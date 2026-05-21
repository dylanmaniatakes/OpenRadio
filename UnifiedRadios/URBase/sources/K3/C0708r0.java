package k3;

import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import com.unified.ur1.primary.LaunchActivity;
import java.util.Map;

/* renamed from: k3.r0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0708r0 implements AdapterView.OnItemSelectedListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Spinner f8197c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8198d;

    public C0708r0(LaunchActivity launchActivity, Spinner spinner) {
        this.f8198d = launchActivity;
        this.f8197c = spinner;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i5, long j5) {
        LaunchActivity launchActivity = this.f8198d;
        Spinner spinner = this.f8197c;
        LaunchActivity.j(launchActivity, spinner, i5);
        int iB = h4.c.B(LaunchActivity.f5853D1);
        for (Map.Entry entry : launchActivity.f5975x1.entrySet()) {
            if (((Integer) entry.getValue()).intValue() == iB) {
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
