package A2;

import B.m;
import L0.s;
import O.InterfaceC0171j0;
import X2.t;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import com.google.android.gms.internal.measurement.AbstractC0333i;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.google.android.gms.internal.measurement.C0313e;
import com.google.android.gms.internal.measurement.C0323g;
import com.google.android.gms.internal.measurement.C0328h;
import com.google.android.gms.internal.measurement.C0358n;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import w3.C0934b;
import w3.C0942j;
import w3.InterfaceC0939g;
import w3.InterfaceC0940h;
import w3.InterfaceC0941i;

/* loaded from: classes.dex */
public abstract class b implements InterfaceC0171j0 {
    public static void A(Parcel parcel, int i5, Float f5) {
        if (f5 == null) {
            return;
        }
        M(parcel, i5, 4);
        parcel.writeFloat(f5.floatValue());
    }

    public static void B(Parcel parcel, int i5, IBinder iBinder) {
        if (iBinder == null) {
            return;
        }
        int I = I(i5, parcel);
        parcel.writeStrongBinder(iBinder);
        K(I, parcel);
    }

    public static void C(Parcel parcel, int i5, int[] iArr) {
        if (iArr == null) {
            return;
        }
        int I = I(i5, parcel);
        parcel.writeIntArray(iArr);
        K(I, parcel);
    }

    public static void D(Parcel parcel, int i5, Parcelable parcelable, int i6) {
        if (parcelable == null) {
            return;
        }
        int I = I(i5, parcel);
        parcelable.writeToParcel(parcel, i6);
        K(I, parcel);
    }

    public static void E(Parcel parcel, int i5, String str) {
        if (str == null) {
            return;
        }
        int I = I(i5, parcel);
        parcel.writeString(str);
        K(I, parcel);
    }

    public static void F(Parcel parcel, int i5, List list) {
        if (list == null) {
            return;
        }
        int I = I(i5, parcel);
        parcel.writeStringList(list);
        K(I, parcel);
    }

    public static void G(Parcel parcel, int i5, Parcelable[] parcelableArr, int i6) {
        if (parcelableArr == null) {
            return;
        }
        int I = I(i5, parcel);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, i6);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        K(I, parcel);
    }

    public static void H(Parcel parcel, int i5, List list) {
        if (list == null) {
            return;
        }
        int I = I(i5, parcel);
        int size = list.size();
        parcel.writeInt(size);
        for (int i6 = 0; i6 < size; i6++) {
            Parcelable parcelable = (Parcelable) list.get(i6);
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                int iDataPosition = parcel.dataPosition();
                parcel.writeInt(1);
                int iDataPosition2 = parcel.dataPosition();
                parcelable.writeToParcel(parcel, 0);
                int iDataPosition3 = parcel.dataPosition();
                parcel.setDataPosition(iDataPosition);
                parcel.writeInt(iDataPosition3 - iDataPosition2);
                parcel.setDataPosition(iDataPosition3);
            }
        }
        K(I, parcel);
    }

    public static int I(int i5, Parcel parcel) {
        parcel.writeInt(i5 | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static C0313e J(C0313e c0313e, t tVar, C0358n c0358n, Boolean bool, Boolean bool2) {
        C0313e c0313e2 = new C0313e();
        Iterator itM = c0313e.m();
        while (itM.hasNext()) {
            int iIntValue = ((Integer) itM.next()).intValue();
            if (c0313e.q(iIntValue)) {
                InterfaceC0363o interfaceC0363oC = c0358n.c(tVar, Arrays.asList(c0313e.k(iIntValue), new C0328h(Double.valueOf(iIntValue)), c0313e));
                if (interfaceC0363oC.i().equals(bool)) {
                    break;
                }
                if (bool2 == null || interfaceC0363oC.i().equals(bool2)) {
                    c0313e2.p(iIntValue, interfaceC0363oC);
                }
            }
        }
        return c0313e2;
    }

    public static void K(int i5, Parcel parcel) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i5 - 4);
        parcel.writeInt(iDataPosition - i5);
        parcel.setDataPosition(iDataPosition);
    }

    public static InterfaceC0363o L(C0313e c0313e, t tVar, ArrayList arrayList, boolean z4) {
        InterfaceC0363o interfaceC0363oC;
        Z3.i.r(arrayList, 1, "reduce");
        Z3.i.s("reduce", 2, arrayList);
        InterfaceC0363o interfaceC0363oD = ((s) tVar.f2834d).D(tVar, (InterfaceC0363o) arrayList.get(0));
        if (!(interfaceC0363oD instanceof AbstractC0333i)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (arrayList.size() == 2) {
            interfaceC0363oC = ((s) tVar.f2834d).D(tVar, (InterfaceC0363o) arrayList.get(1));
            if (interfaceC0363oC instanceof C0323g) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (c0313e.j() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            interfaceC0363oC = null;
        }
        AbstractC0333i abstractC0333i = (AbstractC0333i) interfaceC0363oD;
        int iJ = c0313e.j();
        int i5 = z4 ? 0 : iJ - 1;
        int i6 = z4 ? iJ - 1 : 0;
        int i7 = true == z4 ? 1 : -1;
        if (interfaceC0363oC == null) {
            interfaceC0363oC = c0313e.k(i5);
            i5 += i7;
        }
        while ((i6 - i5) * i7 >= 0) {
            if (c0313e.q(i5)) {
                interfaceC0363oC = abstractC0333i.c(tVar, Arrays.asList(interfaceC0363oC, c0313e.k(i5), new C0328h(Double.valueOf(i5)), c0313e));
                if (interfaceC0363oC instanceof C0323g) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i5 += i7;
            } else {
                i5 += i7;
            }
        }
        return interfaceC0363oC;
    }

    public static void M(Parcel parcel, int i5, int i6) {
        parcel.writeInt(i5 | (i6 << 16));
    }

    public static byte[] f(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        int length = bArr.length;
        int length2 = bArr2.length;
        int length3 = bArr3.length;
        int i5 = length + length2;
        byte[] bArr4 = new byte[i5 + length3];
        System.arraycopy(bArr, 0, bArr4, 0, length);
        System.arraycopy(bArr2, 0, bArr4, length, length2);
        System.arraycopy(bArr3, 0, bArr4, i5, length3);
        return bArr4;
    }

    public static InterfaceC0939g g(InterfaceC0939g interfaceC0939g, InterfaceC0940h interfaceC0940h) {
        F3.i.f(interfaceC0940h, "key");
        if (F3.i.a(interfaceC0939g.getKey(), interfaceC0940h)) {
            return interfaceC0939g;
        }
        return null;
    }

    public static byte[] h(byte b5, byte b6) {
        byte b7 = (byte) (b5 % 598);
        return f(new byte[]{b6}, new byte[]{b7}, new byte[]{(byte) (~b7)});
    }

    public static float i(String[] strArr, int i5) throws NumberFormatException {
        float f5 = Float.parseFloat(strArr[i5]);
        if (f5 >= BitmapDescriptorFactory.HUE_RED && f5 <= 1.0f) {
            return f5;
        }
        throw new IllegalArgumentException("Motion easing control point value must be between 0 and 1; instead got: " + f5);
    }

    public static Intent j(Activity activity) {
        Intent intentA = m.a(activity);
        if (intentA != null) {
            return intentA;
        }
        try {
            String strL = l(activity, activity.getComponentName());
            if (strL == null) {
                return null;
            }
            ComponentName componentName = new ComponentName(activity, strL);
            try {
                return l(activity, componentName) == null ? Intent.makeMainActivity(componentName) : new Intent().setComponent(componentName);
            } catch (PackageManager.NameNotFoundException unused) {
                Log.e("NavUtils", "getParentActivityIntent: bad parentActivityName '" + strL + "' in manifest");
                return null;
            }
        } catch (PackageManager.NameNotFoundException e5) {
            throw new IllegalArgumentException(e5);
        }
    }

    public static Intent k(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String strL = l(context, componentName);
        if (strL == null) {
            return null;
        }
        ComponentName componentName2 = new ComponentName(componentName.getPackageName(), strL);
        return l(context, componentName2) == null ? Intent.makeMainActivity(componentName2) : new Intent().setComponent(componentName2);
    }

    public static String l(Context context, ComponentName componentName) throws PackageManager.NameNotFoundException {
        String string;
        ActivityInfo activityInfo = context.getPackageManager().getActivityInfo(componentName, Build.VERSION.SDK_INT >= 29 ? 269222528 : 787072);
        String str = activityInfo.parentActivityName;
        if (str != null) {
            return str;
        }
        Bundle bundle = activityInfo.metaData;
        if (bundle == null || (string = bundle.getString("android.support.PARENT_ACTIVITY")) == null) {
            return null;
        }
        if (string.charAt(0) != '.') {
            return string;
        }
        return context.getPackageName() + string;
    }

    public static boolean o(String str, String str2) {
        return str.startsWith(str2.concat("(")) && str.endsWith(")");
    }

    public static InterfaceC0941i p(InterfaceC0939g interfaceC0939g, InterfaceC0940h interfaceC0940h) {
        F3.i.f(interfaceC0940h, "key");
        return F3.i.a(interfaceC0939g.getKey(), interfaceC0940h) ? C0942j.f10143j : interfaceC0939g;
    }

    public static InterfaceC0941i u(InterfaceC0939g interfaceC0939g, InterfaceC0941i interfaceC0941i) {
        F3.i.f(interfaceC0941i, "context");
        return interfaceC0941i == C0942j.f10143j ? interfaceC0939g : (InterfaceC0941i) interfaceC0941i.D(interfaceC0939g, C0934b.f10138l);
    }

    public static int v(Context context, int i5, int i6) {
        TypedValue typedValueF = AbstractC0399v1.f(context, i5);
        return (typedValueF == null || typedValueF.type != 16) ? i6 : typedValueF.data;
    }

    public static TimeInterpolator w(Context context, int i5, Interpolator interpolator) {
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(i5, typedValue, true)) {
            return interpolator;
        }
        if (typedValue.type != 3) {
            throw new IllegalArgumentException("Motion easing theme attribute must be an @interpolator resource for ?attr/motionEasing*Interpolator attributes or a string for ?attr/motionEasing* attributes.");
        }
        String strValueOf = String.valueOf(typedValue.string);
        if (!o(strValueOf, "cubic-bezier") && !o(strValueOf, "path")) {
            return AnimationUtils.loadInterpolator(context, typedValue.resourceId);
        }
        if (o(strValueOf, "cubic-bezier")) {
            String[] strArrSplit = strValueOf.substring(13, strValueOf.length() - 1).split(",");
            if (strArrSplit.length == 4) {
                return Q.a.b(i(strArrSplit, 0), i(strArrSplit, 1), i(strArrSplit, 2), i(strArrSplit, 3));
            }
            throw new IllegalArgumentException("Motion easing theme attribute must have 4 control points if using bezier curve format; instead got: " + strArrSplit.length);
        }
        if (!o(strValueOf, "path")) {
            throw new IllegalArgumentException("Invalid motion easing type: ".concat(strValueOf));
        }
        String strSubstring = strValueOf.substring(5, strValueOf.length() - 1);
        Path path = new Path();
        E.f[] fVarArrF = h4.d.f(strSubstring);
        if (fVarArrF != null) {
            try {
                E.f.b(fVarArrF, path);
            } catch (RuntimeException e5) {
                throw new RuntimeException(com.unified.ur1.SatelliteTracker.h.s("Error in parsing ", strSubstring), e5);
            }
        } else {
            path = null;
        }
        return Q.a.c(path);
    }

    public static void x(Drawable drawable, int i5) {
        F.b.g(drawable, i5);
    }

    public static void z(Parcel parcel, int i5, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        int I = I(i5, parcel);
        parcel.writeBundle(bundle);
        K(I, parcel);
    }

    @Override // O.InterfaceC0171j0
    public void b(View view) {
    }

    @Override // O.InterfaceC0171j0
    public void c() {
    }

    public abstract int d(View view, int i5);

    public abstract int e(View view, int i5);

    public int m(View view) {
        return 0;
    }

    public int n() {
        return 0;
    }

    public void q(View view, int i5) {
    }

    public abstract void r(int i5);

    public abstract void s(View view, int i5, int i6);

    public abstract void t(View view, float f5, float f6);

    public abstract boolean y(View view, int i5);
}
