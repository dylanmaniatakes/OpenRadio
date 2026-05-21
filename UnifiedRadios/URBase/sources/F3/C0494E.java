package f3;

import android.view.View;
import android.widget.AdapterView;
import com.unified.ur1.adapters.MemoryChannelActivity;

/* renamed from: f3.E, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0494E implements AdapterView.OnItemSelectedListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6555c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ MemoryChannelActivity f6556d;

    public /* synthetic */ C0494E(MemoryChannelActivity memoryChannelActivity, int i5) {
        this.f6555c = i5;
        this.f6556d = memoryChannelActivity;
    }

    private final void a(AdapterView adapterView) {
    }

    private final void b(AdapterView adapterView) {
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onItemSelected(AdapterView adapterView, View view, int i5, long j5) {
        int i6 = 22;
        MemoryChannelActivity memoryChannelActivity = this.f6556d;
        switch (this.f6555c) {
            case 0:
                String string = adapterView.getItemAtPosition(i5).toString();
                int i7 = MemoryChannelActivity.f5681l;
                memoryChannelActivity.getClass();
                memoryChannelActivity.f5684e.execute(new D.m(memoryChannelActivity, i6, string));
                break;
            default:
                String string2 = adapterView.getItemAtPosition(i5).toString();
                int i8 = MemoryChannelActivity.f5681l;
                memoryChannelActivity.getClass();
                memoryChannelActivity.f5684e.execute(new D.m(memoryChannelActivity, i6, string2));
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public final void onNothingSelected(AdapterView adapterView) {
        int i5 = this.f6555c;
    }
}
