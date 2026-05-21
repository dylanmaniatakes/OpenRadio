package f3;

import android.view.View;
import com.unified.ur1.adapters.MemoryChannelActivity;

/* renamed from: f3.I, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0498I implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6592c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ InterfaceC0500K f6593d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ C0532x f6594e;

    public /* synthetic */ ViewOnClickListenerC0498I(InterfaceC0500K interfaceC0500K, C0532x c0532x, int i5) {
        this.f6592c = i5;
        this.f6593d = interfaceC0500K;
        this.f6594e = c0532x;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f6592c) {
            case 0:
                ((MemoryChannelActivity) this.f6593d).l(this.f6594e);
                break;
            case 1:
                ((MemoryChannelActivity) this.f6593d).l(this.f6594e);
                break;
            default:
                ((MemoryChannelActivity) this.f6593d).l(this.f6594e);
                break;
        }
    }
}
