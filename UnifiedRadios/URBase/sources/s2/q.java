package s2;

import O.G;
import O.Y;
import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class q extends ArrayAdapter {

    /* renamed from: c, reason: collision with root package name */
    public ColorStateList f9664c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f9665d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ r f9666e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(r rVar, Context context, int i5, String[] strArr) {
        super(context, i5, strArr);
        this.f9666e = rVar;
        a();
    }

    public final void a() {
        ColorStateList colorStateList;
        r rVar = this.f9666e;
        ColorStateList colorStateList2 = rVar.n;
        ColorStateList colorStateList3 = null;
        if (colorStateList2 != null) {
            int[] iArr = {R.attr.state_pressed};
            colorStateList = new ColorStateList(new int[][]{iArr, new int[0]}, new int[]{colorStateList2.getColorForState(iArr, 0), 0});
        } else {
            colorStateList = null;
        }
        this.f9665d = colorStateList;
        if (rVar.f9671m != 0 && rVar.n != null) {
            int[] iArr2 = {R.attr.state_hovered, -16842919};
            int[] iArr3 = {R.attr.state_selected, -16842919};
            colorStateList3 = new ColorStateList(new int[][]{iArr3, iArr2, new int[0]}, new int[]{E.a.b(rVar.n.getColorForState(iArr3, 0), rVar.f9671m), E.a.b(rVar.n.getColorForState(iArr2, 0), rVar.f9671m), rVar.f9671m});
        }
        this.f9664c = colorStateList3;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public final View getView(int i5, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i5, view, viewGroup);
        if (view2 instanceof TextView) {
            TextView textView = (TextView) view2;
            r rVar = this.f9666e;
            Drawable rippleDrawable = null;
            if (rVar.getText().toString().contentEquals(textView.getText()) && rVar.f9671m != 0) {
                ColorDrawable colorDrawable = new ColorDrawable(rVar.f9671m);
                if (this.f9665d != null) {
                    F.b.h(colorDrawable, this.f9664c);
                    rippleDrawable = new RippleDrawable(this.f9665d, colorDrawable, null);
                } else {
                    rippleDrawable = colorDrawable;
                }
            }
            WeakHashMap weakHashMap = Y.f1904a;
            G.q(textView, rippleDrawable);
        }
        return view2;
    }
}
