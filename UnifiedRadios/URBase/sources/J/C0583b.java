package j;

import android.view.View;
import androidx.appcompat.view.menu.ActionMenuItemView;
import k.AbstractViewOnTouchListenerC0653r0;
import k.C0627e;
import k.C0629f;
import k.C0633h;
import k.C0637j;

/* renamed from: j.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0583b extends AbstractViewOnTouchListenerC0653r0 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f7411l = 0;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ View f7412m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0583b(ActionMenuItemView actionMenuItemView) {
        super(actionMenuItemView);
        this.f7412m = actionMenuItemView;
    }

    @Override // k.AbstractViewOnTouchListenerC0653r0
    public final D b() {
        C0627e c0627e;
        switch (this.f7411l) {
            case 0:
                AbstractC0584c abstractC0584c = ((ActionMenuItemView) this.f7412m).n;
                if (abstractC0584c == null || (c0627e = ((C0629f) abstractC0584c).f7768a.f7806w) == null) {
                    return null;
                }
                return c0627e.a();
            default:
                C0627e c0627e2 = ((C0633h) this.f7412m).f7783f.f7805v;
                if (c0627e2 == null) {
                    return null;
                }
                return c0627e2.a();
        }
    }

    @Override // k.AbstractViewOnTouchListenerC0653r0
    public final boolean c() {
        D dB;
        switch (this.f7411l) {
            case 0:
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) this.f7412m;
                l lVar = actionMenuItemView.f3289l;
                return lVar != null && lVar.d(actionMenuItemView.f3286i) && (dB = b()) != null && dB.b();
            default:
                ((C0633h) this.f7412m).f7783f.n();
                return true;
        }
    }

    @Override // k.AbstractViewOnTouchListenerC0653r0
    public boolean d() {
        switch (this.f7411l) {
            case 1:
                C0637j c0637j = ((C0633h) this.f7412m).f7783f;
                if (c0637j.f7807x != null) {
                    return false;
                }
                c0637j.c();
                return true;
            default:
                return super.d();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0583b(C0633h c0633h, View view) {
        super(view);
        this.f7412m = c0633h;
    }
}
