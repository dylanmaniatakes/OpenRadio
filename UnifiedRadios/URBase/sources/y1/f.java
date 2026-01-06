package y1;

import L0.s;
import N3.C0150y;
import X2.t;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.measurement.AbstractC0333i;
import com.google.android.gms.internal.measurement.InterfaceC0343k;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.internal.measurement.r;
import g0.AbstractC0535a;
import g0.C0536b;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import r.k;
import r1.C0874b;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static ClassLoader f10481a = null;

    /* renamed from: b, reason: collision with root package name */
    public static Thread f10482b = null;

    /* renamed from: c, reason: collision with root package name */
    public static Field f10483c = null;

    /* renamed from: d, reason: collision with root package name */
    public static boolean f10484d = false;

    /* renamed from: e, reason: collision with root package name */
    public static boolean f10485e = true;

    public static int A(int i5, Parcel parcel) {
        N(parcel, i5, 4);
        return parcel.readInt();
    }

    public static long B(int i5, Parcel parcel) {
        N(parcel, i5, 8);
        return parcel.readLong();
    }

    public static int C(int i5, Parcel parcel) {
        return (i5 & (-65536)) != -65536 ? (char) (i5 >> 16) : parcel.readInt();
    }

    public static void D(int i5) throws Throwable {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            fileWriter = new FileWriter(new File("/sys/devices/platform/dmr_gpio/dmrptt"));
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(String.valueOf(i5 == 1 ? 0 : 1));
            fileWriter.flush();
            e(fileWriter);
        } catch (IOException unused2) {
            fileWriter2 = fileWriter;
            e(fileWriter2);
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            e(fileWriter2);
            throw th;
        }
    }

    public static void G(int i5, Parcel parcel) {
        parcel.setDataPosition(parcel.dataPosition() + C(i5, parcel));
    }

    public static int H(Parcel parcel) {
        int i5 = parcel.readInt();
        int iC = C(i5, parcel);
        char c2 = (char) i5;
        int iDataPosition = parcel.dataPosition();
        if (c2 != 20293) {
            throw new C0874b("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(i5))), parcel);
        }
        int i6 = iC + iDataPosition;
        if (i6 < iDataPosition || i6 > parcel.dataSize()) {
            throw new C0874b(com.unified.ur1.SatelliteTracker.h.c("Size read is invalid start=", " end=", iDataPosition, i6), parcel);
        }
        return i6;
    }

    public static void I(String str, String str2) throws Throwable {
        FileWriter fileWriter;
        FileWriter fileWriter2 = null;
        try {
            try {
                fileWriter = new FileWriter(new File(str2));
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException unused) {
        }
        try {
            fileWriter.write(str);
            fileWriter.flush();
            e(fileWriter);
        } catch (IOException unused2) {
            fileWriter2 = fileWriter;
            d3.a.b("Failed to initialize node: ".concat(str2), new Object[0]);
            e(fileWriter2);
        } catch (Throwable th2) {
            th = th2;
            fileWriter2 = fileWriter;
            e(fileWriter2);
            throw th;
        }
    }

    public static InterfaceC0363o J(InterfaceC0343k interfaceC0343k, r rVar, t tVar, ArrayList arrayList) {
        String str = rVar.f5027j;
        if (interfaceC0343k.d(str)) {
            InterfaceC0363o interfaceC0363oF = interfaceC0343k.f(str);
            if (interfaceC0363oF instanceof AbstractC0333i) {
                return ((AbstractC0333i) interfaceC0363oF).c(tVar, arrayList);
            }
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.b(str, " is not a function"));
        }
        if (!"hasOwnProperty".equals(str)) {
            throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.s("Object has no function ", str));
        }
        Z3.i.q(arrayList, 1, "hasOwnProperty");
        return interfaceC0343k.d(((s) tVar.f2834d).D(tVar, (InterfaceC0363o) arrayList.get(0)).b()) ? InterfaceC0363o.g : InterfaceC0363o.h;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x00ab A[Catch: all -> 0x00a7, PHI: r1
      0x00ab: PHI (r1v4 java.lang.Thread) = (r1v3 java.lang.Thread), (r1v15 java.lang.Thread) binds: [B:7:0x000a, B:47:0x00a4] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #4 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000c, B:46:0x00a2, B:61:0x00d1, B:12:0x001f, B:52:0x00aa, B:53:0x00ab, B:64:0x00d5, B:65:0x00d6, B:54:0x00ac, B:60:0x00d0, B:59:0x00b6, B:13:0x0020, B:15:0x002d, B:25:0x0047, B:26:0x004e, B:28:0x0059, B:34:0x006e, B:35:0x0075, B:43:0x0086, B:44:0x00a0, B:18:0x003c), top: B:77:0x0003, inners: #2, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.lang.ClassLoader K() {
        /*
            Method dump skipped, instructions count: 220
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.f.K():java.lang.ClassLoader");
    }

    public static String L(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            length = objArr.length;
            if (i6 >= length) {
                break;
            }
            Object obj = objArr[i6];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e5) {
                    String str2 = obj.getClass().getName() + "@" + Integer.toHexString(System.identityHashCode(obj));
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(str2), (Throwable) e5);
                    string = "<" + str2 + " threw " + e5.getClass().getName() + ">";
                }
            }
            objArr[i6] = string;
            i6++;
        }
        StringBuilder sb = new StringBuilder(str.length() + (length * 16));
        int i7 = 0;
        while (true) {
            length2 = objArr.length;
            if (i5 >= length2 || (iIndexOf = str.indexOf("%s", i7)) == -1) {
                break;
            }
            sb.append((CharSequence) str, i7, iIndexOf);
            sb.append(objArr[i5]);
            i7 = iIndexOf + 2;
            i5++;
        }
        sb.append((CharSequence) str, i7, str.length());
        if (i5 < length2) {
            sb.append(" [");
            sb.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb.append(", ");
                sb.append(objArr[i8]);
            }
            sb.append(']');
        }
        return sb.toString();
    }

    public static void M(Parcel parcel, int i5, int i6) {
        if (i5 == i6) {
            return;
        }
        String hexString = Integer.toHexString(i5);
        StringBuilder sb = new StringBuilder("Expected size ");
        sb.append(i6);
        sb.append(" got ");
        sb.append(i5);
        sb.append(" (0x");
        throw new C0874b(com.unified.ur1.SatelliteTracker.h.e(sb, hexString, ")"), parcel);
    }

    public static void N(Parcel parcel, int i5, int i6) {
        int iC = C(i5, parcel);
        if (iC == i6) {
            return;
        }
        String hexString = Integer.toHexString(iC);
        StringBuilder sb = new StringBuilder("Expected size ");
        sb.append(i6);
        sb.append(" got ");
        sb.append(iC);
        sb.append(" (0x");
        throw new C0874b(com.unified.ur1.SatelliteTracker.h.e(sb, hexString, ")"), parcel);
    }

    public static r.j a(C0150y c0150y) {
        r.h hVar = new r.h();
        hVar.f9505c = new k();
        r.j jVar = new r.j(hVar);
        hVar.f9504b = jVar;
        hVar.f9503a = AbstractC0535a.class;
        try {
            c0150y.F(false, true, new C0536b(hVar, c0150y));
            hVar.f9503a = "Deferred.asListenableFuture";
        } catch (Exception e5) {
            jVar.f9509k.j(e5);
        }
        return jVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean b(int r9, android.graphics.Rect r10, android.graphics.Rect r11, android.graphics.Rect r12) {
        /*
            boolean r0 = c(r9, r10, r11)
            boolean r1 = c(r9, r10, r12)
            r2 = 0
            if (r1 != 0) goto L78
            if (r0 != 0) goto Lf
            goto L78
        Lf:
            java.lang.String r0 = "direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}."
            r1 = 130(0x82, float:1.82E-43)
            r3 = 33
            r4 = 66
            r5 = 17
            r6 = 1
            if (r9 == r5) goto L3d
            if (r9 == r3) goto L36
            if (r9 == r4) goto L2f
            if (r9 != r1) goto L29
            int r7 = r10.bottom
            int r8 = r12.top
            if (r7 > r8) goto L77
            goto L43
        L29:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L2f:
            int r7 = r10.right
            int r8 = r12.left
            if (r7 > r8) goto L77
            goto L43
        L36:
            int r7 = r10.top
            int r8 = r12.bottom
            if (r7 < r8) goto L77
            goto L43
        L3d:
            int r7 = r10.left
            int r8 = r12.right
            if (r7 < r8) goto L77
        L43:
            if (r9 == r5) goto L77
            if (r9 != r4) goto L48
            goto L77
        L48:
            int r11 = r(r9, r10, r11)
            if (r9 == r5) goto L6a
            if (r9 == r3) goto L65
            if (r9 == r4) goto L60
            if (r9 != r1) goto L5a
            int r9 = r12.bottom
            int r10 = r10.bottom
        L58:
            int r9 = r9 - r10
            goto L6f
        L5a:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r0)
            throw r9
        L60:
            int r9 = r12.right
            int r10 = r10.right
            goto L58
        L65:
            int r9 = r10.top
            int r10 = r12.top
            goto L58
        L6a:
            int r9 = r10.left
            int r10 = r12.left
            goto L58
        L6f:
            int r9 = java.lang.Math.max(r6, r9)
            if (r11 >= r9) goto L76
            r2 = r6
        L76:
            return r2
        L77:
            return r6
        L78:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.f.b(int, android.graphics.Rect, android.graphics.Rect, android.graphics.Rect):boolean");
    }

    public static boolean c(int i5, Rect rect, Rect rect2) {
        if (i5 != 17) {
            if (i5 != 33) {
                if (i5 != 66) {
                    if (i5 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return rect2.right >= rect.left && rect2.left <= rect.right;
        }
        return rect2.bottom >= rect.top && rect2.top <= rect.bottom;
    }

    public static void d(String str) throws Throwable {
        FileReader fileReader;
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            fileReader = new FileReader(new File(str));
            try {
                try {
                    bufferedReader = new BufferedReader(fileReader);
                } catch (IOException e5) {
                    e = e5;
                }
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e6) {
            e = e6;
            fileReader = null;
        } catch (Throwable th2) {
            th = th2;
            fileReader = null;
        }
        try {
            d3.a.a("GPIO Path: " + str + " - Current state: " + bufferedReader.readLine());
            e(bufferedReader);
        } catch (IOException e7) {
            e = e7;
            bufferedReader2 = bufferedReader;
            d3.a.b("Failed to read GPIO state: " + str + " - Error: " + e.getMessage(), new Object[0]);
            e(bufferedReader2);
            e(fileReader);
        } catch (Throwable th3) {
            th = th3;
            bufferedReader2 = bufferedReader;
            e(bufferedReader2);
            e(fileReader);
            throw th;
        }
        e(fileReader);
    }

    public static void e(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void f() throws Throwable {
        I("4", "/sys/bus/platform/drivers/dmr_gpio/auctusctl");
        I("0", "/sys/bus/platform/drivers/dmr_gpio/auctusctl");
        I("0", "/sys/bus/platform/drivers/dmr_gpio/dmr_pwr");
    }

    public static Bundle g(int i5, Parcel parcel) {
        int iC = C(i5, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iC == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iC);
        return bundle;
    }

    public static int[] h(int i5, Parcel parcel) {
        int iC = C(i5, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iC == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iC);
        return iArrCreateIntArray;
    }

    public static Parcelable i(Parcel parcel, int i5, Parcelable.Creator creator) {
        int iC = C(i5, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iC == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iC);
        return parcelable;
    }

    public static String j(int i5, Parcel parcel) {
        int iC = C(i5, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iC == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iC);
        return string;
    }

    public static ArrayList k(int i5, Parcel parcel) {
        int iC = C(i5, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iC == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iC);
        return arrayListCreateStringArrayList;
    }

    public static Object[] l(Parcel parcel, int i5, Parcelable.Creator creator) {
        int iC = C(i5, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iC == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iC);
        return objArrCreateTypedArray;
    }

    public static ArrayList m(Parcel parcel, int i5, Parcelable.Creator creator) {
        int iC = C(i5, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iC == 0) {
            return null;
        }
        ArrayList arrayListCreateTypedArrayList = parcel.createTypedArrayList(creator);
        parcel.setDataPosition(iDataPosition + iC);
        return arrayListCreateTypedArrayList;
    }

    public static void n(int i5, Parcel parcel) {
        if (parcel.dataPosition() != i5) {
            throw new C0874b(com.unified.ur1.SatelliteTracker.h.a(i5, "Overread allowed size end="), parcel);
        }
    }

    public static boolean p(int i5, Rect rect, Rect rect2) {
        if (i5 == 17) {
            int i6 = rect.right;
            int i7 = rect2.right;
            return (i6 > i7 || rect.left >= i7) && rect.left > rect2.left;
        }
        if (i5 == 33) {
            int i8 = rect.bottom;
            int i9 = rect2.bottom;
            return (i8 > i9 || rect.top >= i9) && rect.top > rect2.top;
        }
        if (i5 == 66) {
            int i10 = rect.left;
            int i11 = rect2.left;
            return (i10 < i11 || rect.right <= i11) && rect.right < rect2.right;
        }
        if (i5 != 130) {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int i12 = rect.top;
        int i13 = rect2.top;
        return (i12 < i13 || rect.bottom <= i13) && rect.bottom < rect2.bottom;
    }

    public static boolean q(MotionEvent motionEvent, int i5) {
        return (motionEvent.getSource() & i5) == i5;
    }

    public static int r(int i5, Rect rect, Rect rect2) {
        int i6;
        int i7;
        if (i5 == 17) {
            i6 = rect.left;
            i7 = rect2.right;
        } else if (i5 == 33) {
            i6 = rect.top;
            i7 = rect2.bottom;
        } else if (i5 == 66) {
            i6 = rect2.left;
            i7 = rect.right;
        } else {
            if (i5 != 130) {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
            }
            i6 = rect2.top;
            i7 = rect.bottom;
        }
        return Math.max(0, i6 - i7);
    }

    public static int s(int i5, Rect rect, Rect rect2) {
        if (i5 != 17) {
            if (i5 != 33) {
                if (i5 != 66) {
                    if (i5 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs(((rect.width() / 2) + rect.left) - ((rect2.width() / 2) + rect2.left));
        }
        return Math.abs(((rect.height() / 2) + rect.top) - ((rect2.height() / 2) + rect2.top));
    }

    public static void t() throws Throwable {
        I("0", "/sys/bus/platform/drivers/dmr_gpio/auctusctl");
        I("1", "/sys/bus/platform/drivers/dmr_gpio/dmr_pwr");
        I("1", "/sys/bus/platform/drivers/dmr_gpio/auctusctl");
    }

    public static boolean u(int i5, Parcel parcel) {
        N(parcel, i5, 4);
        return parcel.readInt() != 0;
    }

    public static byte v(int i5, Parcel parcel) {
        N(parcel, i5, 4);
        return (byte) parcel.readInt();
    }

    public static double w(int i5, Parcel parcel) {
        N(parcel, i5, 8);
        return parcel.readDouble();
    }

    public static float x(int i5, Parcel parcel) {
        N(parcel, i5, 4);
        return parcel.readFloat();
    }

    public static Float y(int i5, Parcel parcel) {
        int iC = C(i5, parcel);
        if (iC == 0) {
            return null;
        }
        M(parcel, iC, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static IBinder z(int i5, Parcel parcel) {
        int iC = C(i5, parcel);
        int iDataPosition = parcel.dataPosition();
        if (iC == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iC);
        return strongBinder;
    }

    public void E(View view, float f5) {
        if (f10485e) {
            try {
                view.setTransitionAlpha(f5);
                return;
            } catch (NoSuchMethodError unused) {
                f10485e = false;
            }
        }
        view.setAlpha(f5);
    }

    public void F(View view, int i5) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (!f10484d) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f10483c = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsBase", "fetchViewFlagsField: ");
            }
            f10484d = true;
        }
        Field field = f10483c;
        if (field != null) {
            try {
                f10483c.setInt(view, i5 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public float o(View view) {
        if (f10485e) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                f10485e = false;
            }
        }
        return view.getAlpha();
    }
}
