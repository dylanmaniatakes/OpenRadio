package a;

import A2.g;
import B0.l;
import E3.p;
import F.b;
import F3.i;
import M3.e;
import O.F;
import O.G;
import O.Y;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.google.android.gms.internal.measurement.C0313e;
import com.google.android.gms.internal.measurement.C0318f;
import com.google.android.gms.internal.measurement.C0328h;
import com.google.android.gms.internal.measurement.C0348l;
import com.google.android.gms.internal.measurement.C0368p;
import com.google.android.gms.internal.measurement.C0384s1;
import com.google.android.gms.internal.measurement.InterfaceC0341j2;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.internal.measurement.r;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import w3.C0942j;
import w3.InterfaceC0936d;
import w3.InterfaceC0941i;
import x3.C0974b;
import x3.c;
import y3.AbstractC0987a;
import y3.AbstractC0989c;

/* renamed from: a.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0203a {
    public static void a(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null) {
            drawable = drawable.mutate();
            if (colorStateList == null || !colorStateList.isStateful()) {
                b.h(drawable, colorStateList);
            } else {
                int[] drawableState = textInputLayout.getDrawableState();
                int[] drawableState2 = checkableImageButton.getDrawableState();
                int length = drawableState.length;
                int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
                System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
                b.h(drawable, ColorStateList.valueOf(colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor())));
            }
            if (mode != null) {
                b.i(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    public static int b(int i5, int i6, int i7) {
        return i5 < i6 ? i6 : i5 > i7 ? i7 : i5;
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e5) {
                e5.printStackTrace();
            }
        }
    }

    public static ImageView.ScaleType d(int i5) {
        return i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 5 ? i5 != 6 ? ImageView.ScaleType.CENTER : ImageView.ScaleType.CENTER_INSIDE : ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_END : ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_START : ImageView.ScaleType.FIT_XY;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static InterfaceC0936d e(p pVar, Object obj, InterfaceC0936d interfaceC0936d) {
        i.f(pVar, "<this>");
        i.f(interfaceC0936d, "completion");
        if (pVar instanceof AbstractC0987a) {
            return ((AbstractC0987a) pVar).create(obj, interfaceC0936d);
        }
        InterfaceC0941i context = interfaceC0936d.getContext();
        return context == C0942j.f10143j ? new C0974b(pVar, obj, interfaceC0936d) : new c(interfaceC0936d, context, pVar, obj);
    }

    public static boolean f(String str, String str2) {
        i.f(str, "current");
        if (str.equals(str2)) {
            return true;
        }
        if (str.length() != 0) {
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i5 < str.length()) {
                    char cCharAt = str.charAt(i5);
                    int i8 = i7 + 1;
                    if (i7 == 0 && cCharAt != '(') {
                        break;
                    }
                    if (cCharAt != '(') {
                        if (cCharAt == ')' && i6 - 1 == 0 && i7 != str.length() - 1) {
                            break;
                        }
                    } else {
                        i6++;
                    }
                    i5++;
                    i7 = i8;
                } else if (i6 == 0) {
                    String strSubstring = str.substring(1, str.length() - 1);
                    i.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
                    return i.a(e.P(strSubstring).toString(), str2);
                }
            }
        }
        return false;
    }

    public static boolean g() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        try {
            g.b();
            g gVarB = g.b();
            gVarB.a();
            Context context = gVarB.f26a;
            SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
            if (sharedPreferences.contains("export_to_big_query")) {
                return sharedPreferences.getBoolean("export_to_big_query", false);
            }
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) != null && (bundle = applicationInfo.metaData) != null && bundle.containsKey("delivery_metrics_exported_to_big_query_enabled")) {
                    return applicationInfo.metaData.getBoolean("delivery_metrics_exported_to_big_query_enabled", false);
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
            return false;
        } catch (IllegalStateException unused2) {
            Log.i("FirebaseMessaging", "FirebaseApp has not being initialized. Device might be in direct boot mode. Skip exporting delivery metrics to Big Query");
            return false;
        }
    }

    public static InterfaceC0936d h(InterfaceC0936d interfaceC0936d) {
        InterfaceC0936d interfaceC0936dIntercepted;
        i.f(interfaceC0936d, "<this>");
        AbstractC0989c abstractC0989c = interfaceC0936d instanceof AbstractC0989c ? (AbstractC0989c) interfaceC0936d : null;
        return (abstractC0989c == null || (interfaceC0936dIntercepted = abstractC0989c.intercepted()) == null) ? interfaceC0936d : interfaceC0936dIntercepted;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:107:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x015b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00e1 A[PHI: r6
      0x00e1: PHI (r6v25 java.lang.String) = (r6v24 java.lang.String), (r6v37 java.lang.String) binds: [B:43:0x00c9, B:47:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0142  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void i(android.content.Intent r22) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 561
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a.AbstractC0203a.i(android.content.Intent):void");
    }

    public static void j(Bundle bundle, String str) {
        try {
            g.b();
            if (bundle == null) {
                bundle = new Bundle();
            }
            Bundle bundle2 = new Bundle();
            String string = bundle.getString("google.c.a.c_id");
            if (string != null) {
                bundle2.putString("_nmid", string);
            }
            String string2 = bundle.getString("google.c.a.c_l");
            if (string2 != null) {
                bundle2.putString("_nmn", string2);
            }
            String string3 = bundle.getString("google.c.a.m_l");
            if (!TextUtils.isEmpty(string3)) {
                bundle2.putString("label", string3);
            }
            String string4 = bundle.getString("google.c.a.m_c");
            if (!TextUtils.isEmpty(string4)) {
                bundle2.putString("message_channel", string4);
            }
            String string5 = bundle.getString("from");
            if (string5 == null || !string5.startsWith("/topics/")) {
                string5 = null;
            }
            if (string5 != null) {
                bundle2.putString("_nt", string5);
            }
            String string6 = bundle.getString("google.c.a.ts");
            if (string6 != null) {
                try {
                    bundle2.putInt("_nmt", Integer.parseInt(string6));
                } catch (NumberFormatException e5) {
                    Log.w("FirebaseMessaging", "Error while parsing timestamp in GCM event", e5);
                }
            }
            String string7 = bundle.containsKey("google.c.a.udt") ? bundle.getString("google.c.a.udt") : null;
            if (string7 != null) {
                try {
                    bundle2.putInt("_ndt", Integer.parseInt(string7));
                } catch (NumberFormatException e6) {
                    Log.w("FirebaseMessaging", "Error while parsing use_device_time in GCM event", e6);
                }
            }
            String str2 = l.t(bundle) ? "display" : "data";
            if ("_nr".equals(str) || "_nf".equals(str)) {
                bundle2.putString("_nmc", str2);
            }
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Logging to scion event=" + str + " scionPayload=" + bundle2);
            }
            g gVarB = g.b();
            gVarB.a();
            C2.a aVar = (C2.a) gVarB.f29d.a(C2.a.class);
            if (aVar != null) {
                ((C2.b) aVar).a(bundle2, str);
            } else {
                Log.w("FirebaseMessaging", "Unable to log event: analytics library is missing");
            }
        } catch (IllegalStateException unused) {
            Log.e("FirebaseMessaging", "Default FirebaseApp has not been initialized. Skip logging event to GA.");
        }
    }

    public static void k(AnimatorSet animatorSet, ArrayList arrayList) {
        int size = arrayList.size();
        long jMax = 0;
        for (int i5 = 0; i5 < size; i5++) {
            Animator animator = (Animator) arrayList.get(i5);
            jMax = Math.max(jMax, animator.getDuration() + animator.getStartDelay());
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 0);
        valueAnimatorOfInt.setDuration(jMax);
        arrayList.add(0, valueAnimatorOfInt);
        animatorSet.playTogether(arrayList);
    }

    public static void l(TextInputLayout textInputLayout, CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() == null || colorStateList == null || !colorStateList.isStateful()) {
            return;
        }
        int[] drawableState = textInputLayout.getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] iArrCopyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, iArrCopyOf, length, drawableState2.length);
        int colorForState = colorStateList.getColorForState(iArrCopyOf, colorStateList.getDefaultColor());
        Drawable drawableMutate = drawable.mutate();
        b.h(drawableMutate, ColorStateList.valueOf(colorForState));
        checkableImageButton.setImageDrawable(drawableMutate);
    }

    public static void m(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        WeakHashMap weakHashMap = Y.f1904a;
        boolean zA = F.a(checkableImageButton);
        boolean z4 = onLongClickListener != null;
        boolean z5 = zA || z4;
        checkableImageButton.setFocusable(z5);
        checkableImageButton.setClickable(zA);
        checkableImageButton.setPressable(zA);
        checkableImageButton.setLongClickable(z4);
        G.s(checkableImageButton, z5 ? 1 : 2);
    }

    public static boolean n(Intent intent) {
        Bundle extras;
        if (intent == null || "com.google.firebase.messaging.RECEIVE_DIRECT_BOOT".equals(intent.getAction()) || (extras = intent.getExtras()) == null) {
            return false;
        }
        return "1".equals(extras.getString("google.c.a.e"));
    }

    public static InterfaceC0363o o(C0384s1 c0384s1) {
        if (c0384s1 == null) {
            return InterfaceC0363o.f5004b;
        }
        int iX = c0384s1.x() - 1;
        if (iX == 1) {
            return c0384s1.w() ? new r(c0384s1.r()) : InterfaceC0363o.f5009i;
        }
        if (iX == 2) {
            return c0384s1.v() ? new C0328h(Double.valueOf(c0384s1.p())) : new C0328h(null);
        }
        if (iX == 3) {
            return c0384s1.u() ? new C0318f(Boolean.valueOf(c0384s1.t())) : new C0318f(null);
        }
        if (iX != 4) {
            throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
        }
        InterfaceC0341j2 interfaceC0341j2S = c0384s1.s();
        ArrayList arrayList = new ArrayList();
        Iterator it = interfaceC0341j2S.iterator();
        while (it.hasNext()) {
            arrayList.add(o((C0384s1) it.next()));
        }
        return new C0368p(c0384s1.q(), arrayList);
    }

    public static InterfaceC0363o p(Object obj) {
        if (obj == null) {
            return InterfaceC0363o.f5005c;
        }
        if (obj instanceof String) {
            return new r((String) obj);
        }
        if (obj instanceof Double) {
            return new C0328h((Double) obj);
        }
        if (obj instanceof Long) {
            return new C0328h(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new C0328h(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new C0318f((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            C0313e c0313e = new C0313e();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                c0313e.p(c0313e.j(), p(it.next()));
            }
            return c0313e;
        }
        C0348l c0348l = new C0348l();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            InterfaceC0363o interfaceC0363oP = p(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                c0348l.g((String) string, interfaceC0363oP);
            }
        }
        return c0348l;
    }
}
