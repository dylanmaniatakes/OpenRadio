package androidx.lifecycle;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.SparseArray;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import s3.C0895e;

/* loaded from: classes.dex */
public final class K {

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f3915f = {Boolean.TYPE, boolean[].class, Double.TYPE, double[].class, Integer.TYPE, int[].class, Long.TYPE, long[].class, String.class, String[].class, Binder.class, Bundle.class, Byte.TYPE, byte[].class, Character.TYPE, char[].class, CharSequence.class, CharSequence[].class, ArrayList.class, Float.TYPE, float[].class, Parcelable.class, Parcelable[].class, Serializable.class, Short.TYPE, short[].class, SparseArray.class, Size.class, SizeF.class};

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f3916a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f3917b;

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f3918c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f3919d;

    /* renamed from: e, reason: collision with root package name */
    public final o0.b f3920e;

    public K(HashMap map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.f3916a = linkedHashMap;
        this.f3917b = new LinkedHashMap();
        this.f3918c = new LinkedHashMap();
        this.f3919d = new LinkedHashMap();
        this.f3920e = new androidx.activity.e(1, this);
        linkedHashMap.putAll(map);
    }

    public static Bundle a(K k5) {
        F3.i.f(k5, "this$0");
        LinkedHashMap linkedHashMap = k5.f3917b;
        F3.i.f(linkedHashMap, "<this>");
        int size = linkedHashMap.size();
        Iterator it = (size != 0 ? size != 1 ? new LinkedHashMap(linkedHashMap) : t3.u.y(linkedHashMap) : t3.r.f9712j).entrySet().iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            LinkedHashMap linkedHashMap2 = k5.f3916a;
            int i5 = 0;
            if (!zHasNext) {
                Set<String> setKeySet = linkedHashMap2.keySet();
                ArrayList arrayList = new ArrayList(setKeySet.size());
                ArrayList arrayList2 = new ArrayList(arrayList.size());
                for (String str : setKeySet) {
                    arrayList.add(str);
                    arrayList2.add(linkedHashMap2.get(str));
                }
                C0895e[] c0895eArr = {new C0895e("keys", arrayList), new C0895e("values", arrayList2)};
                Bundle bundle = new Bundle(2);
                while (i5 < 2) {
                    C0895e c0895e = c0895eArr[i5];
                    String str2 = (String) c0895e.f9687j;
                    Object obj = c0895e.f9688k;
                    if (obj == null) {
                        bundle.putString(str2, null);
                    } else if (obj instanceof Boolean) {
                        bundle.putBoolean(str2, ((Boolean) obj).booleanValue());
                    } else if (obj instanceof Byte) {
                        bundle.putByte(str2, ((Number) obj).byteValue());
                    } else if (obj instanceof Character) {
                        bundle.putChar(str2, ((Character) obj).charValue());
                    } else if (obj instanceof Double) {
                        bundle.putDouble(str2, ((Number) obj).doubleValue());
                    } else if (obj instanceof Float) {
                        bundle.putFloat(str2, ((Number) obj).floatValue());
                    } else if (obj instanceof Integer) {
                        bundle.putInt(str2, ((Number) obj).intValue());
                    } else if (obj instanceof Long) {
                        bundle.putLong(str2, ((Number) obj).longValue());
                    } else if (obj instanceof Short) {
                        bundle.putShort(str2, ((Number) obj).shortValue());
                    } else if (obj instanceof Bundle) {
                        bundle.putBundle(str2, (Bundle) obj);
                    } else if (obj instanceof CharSequence) {
                        bundle.putCharSequence(str2, (CharSequence) obj);
                    } else if (obj instanceof Parcelable) {
                        bundle.putParcelable(str2, (Parcelable) obj);
                    } else if (obj instanceof boolean[]) {
                        bundle.putBooleanArray(str2, (boolean[]) obj);
                    } else if (obj instanceof byte[]) {
                        bundle.putByteArray(str2, (byte[]) obj);
                    } else if (obj instanceof char[]) {
                        bundle.putCharArray(str2, (char[]) obj);
                    } else if (obj instanceof double[]) {
                        bundle.putDoubleArray(str2, (double[]) obj);
                    } else if (obj instanceof float[]) {
                        bundle.putFloatArray(str2, (float[]) obj);
                    } else if (obj instanceof int[]) {
                        bundle.putIntArray(str2, (int[]) obj);
                    } else if (obj instanceof long[]) {
                        bundle.putLongArray(str2, (long[]) obj);
                    } else if (obj instanceof short[]) {
                        bundle.putShortArray(str2, (short[]) obj);
                    } else if (obj instanceof Object[]) {
                        Class<?> componentType = obj.getClass().getComponentType();
                        F3.i.c(componentType);
                        if (Parcelable.class.isAssignableFrom(componentType)) {
                            bundle.putParcelableArray(str2, (Parcelable[]) obj);
                        } else if (String.class.isAssignableFrom(componentType)) {
                            bundle.putStringArray(str2, (String[]) obj);
                        } else if (CharSequence.class.isAssignableFrom(componentType)) {
                            bundle.putCharSequenceArray(str2, (CharSequence[]) obj);
                        } else {
                            if (!Serializable.class.isAssignableFrom(componentType)) {
                                throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str2 + '\"');
                            }
                            bundle.putSerializable(str2, (Serializable) obj);
                        }
                    } else if (obj instanceof Serializable) {
                        bundle.putSerializable(str2, (Serializable) obj);
                    } else if (obj instanceof IBinder) {
                        K.a.a(bundle, str2, (IBinder) obj);
                    } else if (obj instanceof Size) {
                        K.b.a(bundle, str2, (Size) obj);
                    } else {
                        if (!(obj instanceof SizeF)) {
                            throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str2 + '\"');
                        }
                        K.b.b(bundle, str2, (SizeF) obj);
                    }
                    i5++;
                }
                return bundle;
            }
            Map.Entry entry = (Map.Entry) it.next();
            String str3 = (String) entry.getKey();
            Bundle bundleA = ((o0.b) entry.getValue()).a();
            F3.i.f(str3, "key");
            if (bundleA != null) {
                Class[] clsArr = f3915f;
                while (i5 < 29) {
                    Class cls = clsArr[i5];
                    F3.i.c(cls);
                    if (!cls.isInstance(bundleA)) {
                        i5++;
                    }
                }
                throw new IllegalArgumentException("Can't put value with type " + bundleA.getClass() + " into saved state");
            }
            Object obj2 = k5.f3918c.get(str3);
            B b5 = obj2 instanceof B ? (B) obj2 : null;
            if (b5 != null) {
                b5.e(bundleA);
            } else {
                linkedHashMap2.put(str3, bundleA);
            }
            com.unified.ur1.SatelliteTracker.h.p(k5.f3919d.get(str3));
        }
    }

    public K() {
        this.f3916a = new LinkedHashMap();
        this.f3917b = new LinkedHashMap();
        this.f3918c = new LinkedHashMap();
        this.f3919d = new LinkedHashMap();
        this.f3920e = new androidx.activity.e(1, this);
    }
}
