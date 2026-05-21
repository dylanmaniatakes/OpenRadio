package i2;

import android.content.Context;
import android.view.SubMenu;
import j.m;
import j.o;

/* loaded from: classes.dex */
public final class d extends m {

    /* renamed from: A, reason: collision with root package name */
    public final int f7226A;

    /* renamed from: z, reason: collision with root package name */
    public final Class f7227z;

    public d(Context context, Class cls, int i5) {
        super(context);
        this.f7227z = cls;
        this.f7226A = i5;
    }

    @Override // j.m
    public final o a(int i5, int i6, int i7, CharSequence charSequence) {
        int size = this.f7459f.size() + 1;
        int i8 = this.f7226A;
        if (size <= i8) {
            w();
            o oVarA = super.a(i5, i6, i7, charSequence);
            oVarA.g(true);
            v();
            return oVarA;
        }
        String simpleName = this.f7227z.getSimpleName();
        StringBuilder sb = new StringBuilder("Maximum number of items supported by ");
        sb.append(simpleName);
        sb.append(" is ");
        sb.append(i8);
        sb.append(". Limit can be checked with ");
        throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.e(sb, simpleName, "#getMaxItemCount()"));
    }

    @Override // j.m, android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f7227z.getSimpleName().concat(" does not support submenus"));
    }
}
