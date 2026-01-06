package J1;

import W3.AbstractC0188a;
import W3.AbstractC0189b;
import android.util.Log;
import android.view.View;
import com.google.android.gms.internal.measurement.C0322f3;
import com.google.android.gms.internal.measurement.C0332h3;
import com.google.android.gms.internal.measurement.InterfaceC0327g3;
import com.google.android.gms.internal.measurement.J3;
import com.google.android.gms.internal.measurement.L3;
import com.google.android.gms.internal.measurement.W2;
import com.google.android.gms.internal.measurement.Y2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.PinConfig;
import d0.C0424b;
import f1.C0475a;
import java.util.Arrays;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import org.conscrypt.FileClientSessionCache;
import r3.InterfaceC0877a;

/* loaded from: classes.dex */
public final /* synthetic */ class C implements F, g2.n, InterfaceC0877a, Z3.f, androidx.lifecycle.V {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f708c;

    public /* synthetic */ C(int i5) {
        this.f708c = i5;
    }

    public static W3.o g(String str) {
        int i5;
        char cCharAt;
        F3.i.f(str, "<this>");
        byte[] bArr = AbstractC0188a.f2628a;
        int length = str.length();
        while (length > 0 && ((cCharAt = str.charAt(length - 1)) == '=' || cCharAt == '\n' || cCharAt == '\r' || cCharAt == ' ' || cCharAt == '\t')) {
            length--;
        }
        int i6 = (int) ((length * 6) / 8);
        byte[] bArrCopyOf = new byte[i6];
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (true) {
            if (i7 < length) {
                char cCharAt2 = str.charAt(i7);
                if ('A' <= cCharAt2 && cCharAt2 < '[') {
                    i5 = cCharAt2 - 'A';
                } else if ('a' <= cCharAt2 && cCharAt2 < '{') {
                    i5 = cCharAt2 - 'G';
                } else if ('0' <= cCharAt2 && cCharAt2 < ':') {
                    i5 = cCharAt2 + 4;
                } else if (cCharAt2 != '+' && cCharAt2 != '-') {
                    if (cCharAt2 != '/' && cCharAt2 != '_') {
                        if (cCharAt2 != '\n' && cCharAt2 != '\r' && cCharAt2 != ' ' && cCharAt2 != '\t') {
                            break;
                        }
                        i7++;
                    } else {
                        i5 = 63;
                    }
                } else {
                    i5 = 62;
                }
                int i11 = i5 | (i9 << 6);
                i8++;
                if (i8 % 4 == 0) {
                    bArrCopyOf[i10] = (byte) (i11 >> 16);
                    int i12 = i10 + 2;
                    bArrCopyOf[i10 + 1] = (byte) (i11 >> 8);
                    i10 += 3;
                    bArrCopyOf[i12] = (byte) i11;
                }
                i9 = i11;
                i7++;
            } else {
                int i13 = i8 % 4;
                if (i13 != 1) {
                    if (i13 == 2) {
                        bArrCopyOf[i10] = (byte) ((i9 << 12) >> 16);
                        i10 = 1 + i10;
                    } else if (i13 == 3) {
                        int i14 = i9 << 6;
                        int i15 = 1 + i10;
                        bArrCopyOf[i10] = (byte) (i14 >> 16);
                        i10 += 2;
                        bArrCopyOf[i15] = (byte) (i14 >> 8);
                    }
                    if (i10 != i6) {
                        bArrCopyOf = Arrays.copyOf(bArrCopyOf, i10);
                        F3.i.e(bArrCopyOf, "copyOf(this, newSize)");
                    }
                }
            }
        }
        bArrCopyOf = null;
        if (bArrCopyOf != null) {
            return new W3.o(bArrCopyOf);
        }
        return null;
    }

    public static W3.o h(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Unexpected hex string: ".concat(str).toString());
        }
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i5 = 0; i5 < length; i5++) {
            int i6 = i5 * 2;
            bArr[i5] = (byte) (X3.b.a(str.charAt(i6 + 1)) + (X3.b.a(str.charAt(i6)) << 4));
        }
        return new W3.o(bArr);
    }

    public static W3.o i(String str) {
        F3.i.f(str, "<this>");
        byte[] bytes = str.getBytes(M3.a.f1740a);
        F3.i.e(bytes, "this as java.lang.String).getBytes(charset)");
        W3.o oVar = new W3.o(bytes);
        oVar.f2652l = str;
        return oVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0049, code lost:
    
        if (java.lang.Character.isHighSurrogate(r5) != false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0086, code lost:
    
        if (java.lang.Character.isLowSurrogate(r5) != false) goto L60;
     */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0070 A[EDGE_INSN: B:91:0x0070->B:48:0x0070 BREAK  A[LOOP:2: B:49:0x0072->B:60:0x0089, LOOP_LABEL: LOOP:2: B:49:0x0072->B:60:0x0089], EDGE_INSN: B:94:0x0070->B:48:0x0070 BREAK  A[LOOP:2: B:49:0x0072->B:60:0x0089]] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00a6 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean j(android.view.inputmethod.InputConnection r7, android.text.Editable r8, int r9, int r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.C.j(android.view.inputmethod.InputConnection, android.text.Editable, int, int, boolean):boolean");
    }

    public static int k(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }

    public static W3.o l(byte[] bArr) {
        W3.o oVar = W3.o.f2649m;
        int length = bArr.length;
        AbstractC0189b.e(bArr.length, 0, length);
        com.google.android.gms.internal.measurement.D1.c(length, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, length);
        F3.i.e(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return new W3.o(bArrCopyOfRange);
    }

    @Override // J1.F
    public Object a() {
        switch (this.f708c) {
            case 0:
                List list = H.f796a;
                ((L3) J3.f4711k.get()).getClass();
                Double d5 = (Double) L3.f4731c.b();
                d5.getClass();
                return d5;
            case 1:
                List list2 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4867s.b()).longValue());
            case 2:
                List list3 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4840d.b()).longValue());
            case 3:
                List list4 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                Long l5 = (Long) Y2.f4837b0.b();
                l5.getClass();
                return l5;
            case 4:
                List list5 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return (String) Y2.f4844f.b();
            case 5:
                List list6 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.n.b()).longValue());
            case 6:
                List list7 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return (String) Y2.f4829V.b();
            case 7:
                List list8 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                Long l6 = (Long) Y2.f4848i.b();
                l6.getClass();
                return l6;
            case 8:
                List list9 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return (String) Y2.f4870t0.b();
            case 9:
                List list10 = H.f796a;
                ((C0332h3) ((InterfaceC0327g3) C0322f3.f4933k.f4934j.f10447j)).getClass();
                Boolean bool = (Boolean) C0332h3.f4948a.b();
                bool.getClass();
                return bool;
            case 10:
                List list11 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4846g0.b()).longValue());
            case 11:
                List list12 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4827T.b()).longValue());
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                List list13 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4871u.b()).longValue());
            case o1.f.ERROR /* 13 */:
                List list14 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                Boolean bool2 = (Boolean) Y2.f4838c.b();
                bool2.getClass();
                return bool2;
            default:
                List list15 = H.f796a;
                ((Y2) W2.f4795k.get()).getClass();
                return Integer.valueOf((int) ((Long) Y2.f4876z.b()).longValue());
        }
    }

    @Override // androidx.lifecycle.V
    public androidx.lifecycle.S b(Class cls) {
        switch (this.f708c) {
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                return new androidx.fragment.app.W(true);
            default:
                return new C0424b();
        }
    }

    @Override // Z3.f
    public void c(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(k(level), "EventBus", str);
        }
    }

    @Override // Z3.f
    public void d(Level level, String str, Exception exc) {
        if (level != Level.OFF) {
            Log.println(k(level), "EventBus", str + "\n" + Log.getStackTraceString(exc));
        }
    }

    @Override // g2.n
    public O.F0 e(View view, O.F0 f02, g2.o oVar) {
        oVar.f6953d = f02.a() + oVar.f6953d;
        WeakHashMap weakHashMap = O.Y.f1904a;
        boolean z4 = O.H.d(view) == 1;
        int iB = f02.b();
        int iC = f02.c();
        int i5 = oVar.f6950a + (z4 ? iC : iB);
        oVar.f6950a = i5;
        int i6 = oVar.f6952c;
        if (!z4) {
            iB = iC;
        }
        int i7 = i6 + iB;
        oVar.f6952c = i7;
        O.H.k(view, i5, oVar.f6951b, i7, oVar.f6953d);
        return f02;
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        switch (this.f708c) {
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                return new V0(3, Executors.newSingleThreadExecutor());
            case 28:
                return "com.google.android.datatransport.events";
            default:
                return C0475a.f6443f;
        }
    }

    public synchronized Z3.h m() {
        return null;
    }

    public C(androidx.fragment.app.T t4) {
        this.f708c = 25;
    }

    public C(X1.f fVar, X1.f fVar2) {
        this.f708c = 19;
        fVar.getClass();
        fVar2.getClass();
        if (BitmapDescriptorFactory.HUE_RED > BitmapDescriptorFactory.HUE_RED) {
            throw new IllegalArgumentException();
        }
    }
}
