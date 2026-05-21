package g2;

import L0.s;
import O.H;
import O.J;
import O.K;
import O.M;
import O.Y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.unified.ur1.R;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f6946a = {R.attr.colorPrimary};

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f6947b = {R.attr.colorPrimaryVariant};

    /* renamed from: c, reason: collision with root package name */
    public static final B0.a f6948c = new B0.a(8);

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f6949d = 0;

    public static void a(Context context, AttributeSet attributeSet, int i5, int i6) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O1.a.f1998H, i5, i6);
        boolean z4 = typedArrayObtainStyledAttributes.getBoolean(1, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z4) {
            TypedValue typedValue = new TypedValue();
            if (!context.getTheme().resolveAttribute(R.attr.isMaterialTheme, typedValue, true) || (typedValue.type == 18 && typedValue.data == 0)) {
                c(context, f6947b, "Theme.MaterialComponents");
            }
        }
        c(context, f6946a, "Theme.AppCompat");
    }

    public static void b(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, O1.a.f1998H, i5, i6);
        boolean z4 = false;
        if (!typedArrayObtainStyledAttributes.getBoolean(2, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2.length != 0) {
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
            for (int i7 : iArr2) {
                if (typedArrayObtainStyledAttributes2.getResourceId(i7, -1) == -1) {
                    typedArrayObtainStyledAttributes2.recycle();
                    break;
                }
            }
            typedArrayObtainStyledAttributes2.recycle();
            z4 = true;
        } else if (typedArrayObtainStyledAttributes.getResourceId(0, -1) != -1) {
            z4 = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!z4) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    public static void c(Context context, int[] iArr, String str) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        for (int i5 = 0; i5 < iArr.length; i5++) {
            if (!typedArrayObtainStyledAttributes.hasValue(i5)) {
                typedArrayObtainStyledAttributes.recycle();
                throw new IllegalArgumentException(AbstractC0535a.l("The style on this component requires your app theme to be ", str, " (or a descendant)."));
            }
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public static void d(View view, n nVar) {
        WeakHashMap weakHashMap = Y.f1904a;
        int iF = H.f(view);
        int paddingTop = view.getPaddingTop();
        int iE = H.e(view);
        int paddingBottom = view.getPaddingBottom();
        o oVar = new o();
        oVar.f6950a = iF;
        oVar.f6951b = paddingTop;
        oVar.f6952c = iE;
        oVar.f6953d = paddingBottom;
        M.u(view, new s(nVar, 15, oVar));
        if (J.b(view)) {
            K.c(view);
        } else {
            view.addOnAttachStateChangeListener(new androidx.databinding.c(1));
        }
    }

    public static ViewGroup e(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(android.R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static L0.l f(View view) {
        ViewGroup viewGroupE = e(view);
        if (viewGroupE == null) {
            return null;
        }
        return new L0.l(viewGroupE);
    }

    public static ArrayList g(Toolbar toolbar, CharSequence charSequence) {
        ArrayList arrayList = new ArrayList();
        for (int i5 = 0; i5 < toolbar.getChildCount(); i5++) {
            View childAt = toolbar.getChildAt(i5);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    arrayList.add(textView);
                }
            }
        }
        return arrayList;
    }

    public static boolean h(View view) {
        WeakHashMap weakHashMap = Y.f1904a;
        return H.d(view) == 1;
    }

    public static TypedArray i(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6, int... iArr2) {
        a(context, attributeSet, i5, i6);
        b(context, attributeSet, iArr, i5, i6, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i5, i6);
    }

    public static L0.m j(Context context, AttributeSet attributeSet, int[] iArr, int i5, int i6, int... iArr2) {
        a(context, attributeSet, i5, i6);
        b(context, attributeSet, iArr, i5, i6, iArr2);
        return new L0.m(context, context.obtainStyledAttributes(attributeSet, iArr, i5, i6));
    }

    public static PorterDuff.Mode k(int i5, PorterDuff.Mode mode) {
        if (i5 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i5 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i5 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i5) {
            case o1.f.INTERRUPTED /* 14 */:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }
}
