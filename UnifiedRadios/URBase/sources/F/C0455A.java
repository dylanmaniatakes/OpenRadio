package f;

import android.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatButton;
import java.lang.reflect.Constructor;
import k.C0606A;
import k.C0645n;
import k.C0647o;
import k.Z;

/* renamed from: f.A, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0455A {

    /* renamed from: b, reason: collision with root package name */
    public static final Class[] f6239b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f6240c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f6241d = {R.attr.accessibilityHeading};

    /* renamed from: e, reason: collision with root package name */
    public static final int[] f6242e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f, reason: collision with root package name */
    public static final int[] f6243f = {R.attr.screenReaderFocusable};
    public static final String[] g = {"android.widget.", "android.view.", "android.webkit."};
    public static final q.k h = new q.k();

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f6244a = new Object[2];

    public C0645n a(Context context, AttributeSet attributeSet) {
        return new C0645n(context, attributeSet);
    }

    public AppCompatButton b(Context context, AttributeSet attributeSet) {
        return new AppCompatButton(context, attributeSet);
    }

    public C0647o c(Context context, AttributeSet attributeSet) {
        return new C0647o(context, attributeSet, com.unified.ur1.R.attr.checkboxStyle);
    }

    public C0606A d(Context context, AttributeSet attributeSet) {
        return new C0606A(context, attributeSet);
    }

    public Z e(Context context, AttributeSet attributeSet) {
        return new Z(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) throws NoSuchMethodException, SecurityException {
        String strConcat;
        q.k kVar = h;
        Constructor constructor = (Constructor) kVar.getOrDefault(str, null);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f6239b);
            kVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return (View) constructor.newInstance(this.f6244a);
    }
}
