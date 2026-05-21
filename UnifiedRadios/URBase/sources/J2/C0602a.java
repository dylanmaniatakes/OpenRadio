package j2;

import S.b;
import android.R;
import android.content.res.ColorStateList;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import k.C0606A;

/* renamed from: j2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0602a extends C0606A {

    /* renamed from: i, reason: collision with root package name */
    public static final int[][] f7575i = {new int[]{R.attr.state_enabled, R.attr.state_checked}, new int[]{R.attr.state_enabled, -16842912}, new int[]{-16842910, R.attr.state_checked}, new int[]{-16842910, -16842912}};
    public ColorStateList g;
    public boolean h;

    private ColorStateList getMaterialThemeColorsTintList() {
        if (this.g == null) {
            int iF = AbstractC0296a2.f(this, com.unified.ur1.R.attr.colorControlActivated);
            int iF2 = AbstractC0296a2.f(this, com.unified.ur1.R.attr.colorOnSurface);
            int iF3 = AbstractC0296a2.f(this, com.unified.ur1.R.attr.colorSurface);
            this.g = new ColorStateList(f7575i, new int[]{AbstractC0296a2.h(1.0f, iF3, iF), AbstractC0296a2.h(0.54f, iF3, iF2), AbstractC0296a2.h(0.38f, iF3, iF2), AbstractC0296a2.h(0.38f, iF3, iF2)});
        }
        return this.g;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.h && b.a(this) == null) {
            setUseMaterialThemeColors(true);
        }
    }

    public void setUseMaterialThemeColors(boolean z4) {
        this.h = z4;
        if (z4) {
            b.c(this, getMaterialThemeColorsTintList());
        } else {
            b.c(this, null);
        }
    }
}
