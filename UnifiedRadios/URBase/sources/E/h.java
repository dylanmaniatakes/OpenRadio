package E;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import h4.r;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class h extends h4.f {

    /* renamed from: j, reason: collision with root package name */
    public static Class f428j = null;

    /* renamed from: k, reason: collision with root package name */
    public static Constructor f429k = null;

    /* renamed from: l, reason: collision with root package name */
    public static Method f430l = null;

    /* renamed from: m, reason: collision with root package name */
    public static Method f431m = null;
    public static boolean n = false;

    /* renamed from: c, reason: collision with root package name */
    public final Class f432c;

    /* renamed from: d, reason: collision with root package name */
    public final Constructor f433d;

    /* renamed from: e, reason: collision with root package name */
    public final Method f434e;

    /* renamed from: f, reason: collision with root package name */
    public final Method f435f;
    public final Method g;
    public final Method h;

    /* renamed from: i, reason: collision with root package name */
    public final Method f436i;

    public h() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method methodX;
        Constructor<?> constructor;
        Method methodW;
        Method method;
        Method method2;
        Method method3;
        Class<?> cls = null;
        try {
            Class<?> cls2 = Class.forName("android.graphics.FontFamily");
            constructor = cls2.getConstructor(null);
            methodW = w(cls2);
            Class cls3 = Integer.TYPE;
            method = cls2.getMethod("addFontFromBuffer", ByteBuffer.class, cls3, FontVariationAxis[].class, cls3, cls3);
            method2 = cls2.getMethod("freeze", null);
            method3 = cls2.getMethod("abortCreation", null);
            methodX = x(cls2);
            cls = cls2;
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi26Impl", "Unable to collect necessary methods for class ".concat(e5.getClass().getName()), e5);
            methodX = null;
            constructor = null;
            methodW = null;
            method = null;
            method2 = null;
            method3 = null;
        }
        this.f432c = cls;
        this.f433d = constructor;
        this.f434e = methodW;
        this.f435f = method;
        this.g = method2;
        this.h = method3;
        this.f436i = methodX;
    }

    public static boolean p(Object obj, String str, int i5, boolean z4) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        t();
        try {
            return ((Boolean) f430l.invoke(obj, str, Integer.valueOf(i5), Boolean.valueOf(z4))).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static void t() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method;
        Class<?> cls;
        Method method2;
        if (n) {
            return;
        }
        n = true;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(null);
            method2 = cls.getMethod("addFontWeightStyle", String.class, Integer.TYPE, Boolean.TYPE);
            method = Typeface.class.getMethod("createFromFamiliesWithDefault", Array.newInstance(cls, 1).getClass());
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e5) {
            Log.e("TypefaceCompatApi21Impl", e5.getClass().getName(), e5);
            method = null;
            cls = null;
            method2 = null;
        }
        f429k = constructor;
        f428j = cls;
        f430l = method2;
        f431m = method;
    }

    public static Method w(Class cls) {
        Class cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, cls2, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }

    @Override // h4.f
    public final Typeface d(Context context, D.f fVar, Resources resources, int i5) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!u()) {
            return r(context, fVar, resources, i5);
        }
        Object objV = v();
        if (objV == null) {
            return null;
        }
        for (D.g gVar : fVar.f203a) {
            if (!o(context, objV, gVar.f204a, gVar.f208e, gVar.f205b, gVar.f206c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(gVar.f207d))) {
                n(objV);
                return null;
            }
        }
        if (s(objV)) {
            return q(objV);
        }
        return null;
    }

    @Override // h4.f
    public final Typeface e(Context context, L.i[] iVarArr, int i5) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        Typeface typefaceQ;
        boolean zBooleanValue;
        if (iVarArr.length < 1) {
            return null;
        }
        if (!u()) {
            L.i iVarG = g(i5, iVarArr);
            try {
                ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = context.getContentResolver().openFileDescriptor(iVarG.f1523a, "r", null);
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                        parcelFileDescriptorOpenFileDescriptor.close();
                    }
                    return null;
                }
                try {
                    Typeface typefaceBuild = new Typeface.Builder(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).setWeight(iVarG.f1525c).setItalic(iVarG.f1526d).build();
                    parcelFileDescriptorOpenFileDescriptor.close();
                    return typefaceBuild;
                } finally {
                }
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap map = new HashMap();
        for (L.i iVar : iVarArr) {
            if (iVar.f1527e == 0) {
                Uri uri = iVar.f1523a;
                if (!map.containsKey(uri)) {
                    map.put(uri, r.l(context, uri));
                }
            }
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        Object objV = v();
        if (objV == null) {
            return null;
        }
        int length = iVarArr.length;
        int i6 = 0;
        boolean z4 = false;
        while (i6 < length) {
            L.i iVar2 = iVarArr[i6];
            ByteBuffer byteBuffer = (ByteBuffer) mapUnmodifiableMap.get(iVar2.f1523a);
            if (byteBuffer != null) {
                try {
                    zBooleanValue = ((Boolean) this.f435f.invoke(objV, byteBuffer, Integer.valueOf(iVar2.f1524b), null, Integer.valueOf(iVar2.f1525c), Integer.valueOf(iVar2.f1526d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    zBooleanValue = false;
                }
                if (!zBooleanValue) {
                    n(objV);
                    return null;
                }
                z4 = true;
            }
            i6++;
            z4 = z4;
        }
        if (!z4) {
            n(objV);
            return null;
        }
        if (s(objV) && (typefaceQ = q(objV)) != null) {
            return Typeface.create(typefaceQ, i5);
        }
        return null;
    }

    @Override // h4.f
    public final Typeface f(Context context, Resources resources, int i5, String str, int i6) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!u()) {
            return super.f(context, resources, i5, str, i6);
        }
        Object objV = v();
        if (objV == null) {
            return null;
        }
        if (!o(context, objV, str, 0, -1, -1, null)) {
            n(objV);
            return null;
        }
        if (s(objV)) {
            return q(objV);
        }
        return null;
    }

    public final void n(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            this.h.invoke(obj, null);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    public final boolean o(Context context, Object obj, String str, int i5, int i6, int i7, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.f434e.invoke(obj, context.getAssets(), str, 0, Boolean.FALSE, Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final Typeface q(Object obj) throws ArrayIndexOutOfBoundsException, IllegalArgumentException, NegativeArraySizeException {
        try {
            Object objNewInstance = Array.newInstance((Class<?>) this.f432c, 1);
            Array.set(objNewInstance, 0, obj);
            return (Typeface) this.f436i.invoke(null, objNewInstance, "sans-serif", -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final Typeface r(Context context, D.f fVar, Resources resources, int i5) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, SecurityException, ArrayIndexOutOfBoundsException, IllegalArgumentException, InvocationTargetException, NegativeArraySizeException {
        t();
        try {
            Object objNewInstance = f429k.newInstance(null);
            for (D.g gVar : fVar.f203a) {
                File fileJ = r.j(context);
                if (fileJ == null) {
                    return null;
                }
                try {
                    if (!r.e(fileJ, resources, gVar.f209f)) {
                        return null;
                    }
                    if (!p(objNewInstance, fileJ.getPath(), gVar.f205b, gVar.f206c)) {
                        return null;
                    }
                    fileJ.delete();
                } catch (RuntimeException unused) {
                    return null;
                } finally {
                    fileJ.delete();
                }
            }
            t();
            try {
                Object objNewInstance2 = Array.newInstance((Class<?>) f428j, 1);
                Array.set(objNewInstance2, 0, objNewInstance);
                return (Typeface) f431m.invoke(null, objNewInstance2);
            } catch (IllegalAccessException | InvocationTargetException e5) {
                throw new RuntimeException(e5);
            }
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e6) {
            throw new RuntimeException(e6);
        }
    }

    public final boolean s(Object obj) {
        try {
            return ((Boolean) this.g.invoke(obj, null)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public final boolean u() {
        Method method = this.f434e;
        if (method == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return method != null;
    }

    public final Object v() {
        try {
            return this.f433d.newInstance(null);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public final Method x(Class cls) throws NoSuchMethodException, SecurityException {
        Class<?> cls2 = Array.newInstance((Class<?>) cls, 1).getClass();
        Class cls3 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod("createFromFamiliesWithDefault", cls2, String.class, cls3, cls3);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
