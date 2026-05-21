package k;

import android.content.Context;
import android.view.View;
import com.unified.ur1.R;
import f3.C0519j;

/* renamed from: k.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0627e extends j.x {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f7762m = 0;
    public final /* synthetic */ C0637j n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0627e(C0637j c0637j, Context context, j.m mVar, View view) {
        super(R.attr.actionOverflowMenuStyle, 0, context, view, mVar, true);
        this.n = c0637j;
        this.g = 8388613;
        C0519j c0519j = c0637j.f7809z;
        this.f7522i = c0519j;
        j.u uVar = this.f7523j;
        if (uVar != null) {
            uVar.l(c0519j);
        }
    }

    @Override // j.x
    public final void c() {
        switch (this.f7762m) {
            case 0:
                C0637j c0637j = this.n;
                c0637j.f7806w = null;
                c0637j.f7788A = 0;
                super.c();
                break;
            default:
                C0637j c0637j2 = this.n;
                j.m mVar = c0637j2.f7791e;
                if (mVar != null) {
                    mVar.c(true);
                }
                c0637j2.f7805v = null;
                super.c();
                break;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0627e(C0637j c0637j, Context context, j.F f5, View view) {
        super(R.attr.actionOverflowMenuStyle, 0, context, view, f5, false);
        this.n = c0637j;
        if (!f5.f7396A.f()) {
            View view2 = c0637j.f7796l;
            this.f7521f = view2 == null ? (View) c0637j.f7794j : view2;
        }
        C0519j c0519j = c0637j.f7809z;
        this.f7522i = c0519j;
        j.u uVar = this.f7523j;
        if (uVar != null) {
            uVar.l(c0519j);
        }
    }
}
