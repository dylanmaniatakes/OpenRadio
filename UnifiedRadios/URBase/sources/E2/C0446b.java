package e2;

import O.InterfaceC0171j0;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;

/* renamed from: e2.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0446b implements InterfaceC0171j0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6194a;

    /* renamed from: b, reason: collision with root package name */
    public int f6195b;

    /* renamed from: c, reason: collision with root package name */
    public final View f6196c;

    /* JADX WARN: Multi-variable type inference failed */
    public C0446b(InterfaceC0445a interfaceC0445a) {
        this.f6194a = false;
        this.f6195b = 0;
        this.f6196c = (View) interfaceC0445a;
    }

    @Override // O.InterfaceC0171j0
    public void a() {
        if (this.f6194a) {
            return;
        }
        ActionBarContextView actionBarContextView = (ActionBarContextView) this.f6196c;
        actionBarContextView.h = null;
        super/*android.view.View*/.setVisibility(this.f6195b);
    }

    @Override // O.InterfaceC0171j0
    public void b(View view) {
        this.f6194a = true;
    }

    @Override // O.InterfaceC0171j0
    public void c() {
        super/*android.view.View*/.setVisibility(0);
        this.f6194a = false;
    }

    public C0446b(ActionBarContextView actionBarContextView) {
        this.f6196c = actionBarContextView;
        this.f6194a = false;
    }
}
