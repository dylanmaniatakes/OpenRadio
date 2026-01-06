package x;

import android.util.AttributeSet;
import u.C0904a;

/* renamed from: x.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0943a extends c {

    /* renamed from: j, reason: collision with root package name */
    public int f10144j;

    /* renamed from: k, reason: collision with root package name */
    public int f10145k;

    /* renamed from: l, reason: collision with root package name */
    public C0904a f10146l;

    @Override // x.c
    public final void g(AttributeSet attributeSet) {
        C0904a c0904a = new C0904a();
        c0904a.f9716s0 = 0;
        c0904a.f9717t0 = true;
        c0904a.f9718u0 = 0;
        c0904a.v0 = false;
        this.f10146l = c0904a;
        this.f10156f = c0904a;
        i();
    }

    public boolean getAllowsGoneWidget() {
        return this.f10146l.f9717t0;
    }

    public int getMargin() {
        return this.f10146l.f9718u0;
    }

    public int getType() {
        return this.f10144j;
    }

    @Override // x.c
    public final void h(u.d dVar, boolean z4) {
        int i5 = this.f10144j;
        this.f10145k = i5;
        if (z4) {
            if (i5 == 5) {
                this.f10145k = 1;
            } else if (i5 == 6) {
                this.f10145k = 0;
            }
        } else if (i5 == 5) {
            this.f10145k = 0;
        } else if (i5 == 6) {
            this.f10145k = 1;
        }
        if (dVar instanceof C0904a) {
            ((C0904a) dVar).f9716s0 = this.f10145k;
        }
    }

    public void setAllowsGoneWidget(boolean z4) {
        this.f10146l.f9717t0 = z4;
    }

    public void setDpMargin(int i5) {
        this.f10146l.f9718u0 = (int) ((i5 * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public void setMargin(int i5) {
        this.f10146l.f9718u0 = i5;
    }

    public void setType(int i5) {
        this.f10144j = i5;
    }
}
