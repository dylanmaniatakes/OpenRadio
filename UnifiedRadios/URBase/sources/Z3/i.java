package Z3;

import M3.m;
import X2.t;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.widget.EditText;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.google.android.gms.internal.measurement.C0313e;
import com.google.android.gms.internal.measurement.C0318f;
import com.google.android.gms.internal.measurement.C0328h;
import com.google.android.gms.internal.measurement.C0348l;
import com.google.android.gms.internal.measurement.C0353m;
import com.google.android.gms.internal.measurement.C0382s;
import com.google.android.gms.internal.measurement.EnumC0402w;
import com.google.android.gms.internal.measurement.InterfaceC0363o;
import com.google.android.gms.internal.measurement.r;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import q0.C0840c;
import u3.C0910a;
import u3.C0911b;

/* loaded from: classes.dex */
public abstract class i {
    public static void a(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static byte[] b(ArrayDeque arrayDeque, int i5) {
        if (arrayDeque.isEmpty()) {
            return new byte[0];
        }
        byte[] bArr = (byte[]) arrayDeque.remove();
        if (bArr.length == i5) {
            return bArr;
        }
        int length = i5 - bArr.length;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, i5);
        while (length > 0) {
            byte[] bArr2 = (byte[]) arrayDeque.remove();
            int iMin = Math.min(length, bArr2.length);
            System.arraycopy(bArr2, 0, bArrCopyOf, i5 - length, iMin);
            length -= iMin;
        }
        return bArrCopyOf;
    }

    public static final void c(C0840c c0840c) throws SQLException {
        C0911b c0911b = new C0911b();
        Cursor cursorX = c0840c.X("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        while (cursorX.moveToNext()) {
            try {
                c0911b.add(cursorX.getString(0));
            } finally {
            }
        }
        AbstractC0399v1.b(cursorX, null);
        Iterator it = AbstractC0296a2.a(c0911b).iterator();
        while (true) {
            C0910a c0910a = (C0910a) it;
            if (!c0910a.hasNext()) {
                return;
            }
            String str = (String) c0910a.next();
            F3.i.e(str, "triggerName");
            if (m.x(str, "room_fts_content_sync_", false)) {
                c0840c.x("DROP TRIGGER IF EXISTS ".concat(str));
            }
        }
    }

    public static j4.c d(Context context) throws Throwable {
        ArrayList arrayListE;
        if (Build.VERSION.SDK_INT >= 29) {
            arrayListE = context != null ? e(context) : f();
        } else {
            ArrayList arrayListF = f();
            if (context != null) {
                ArrayList arrayListE2 = e(context);
                arrayListE2.removeAll(arrayListF);
                arrayListF.addAll(arrayListE2);
            }
            arrayListE = arrayListF;
        }
        j4.c cVar = null;
        for (int i5 = 0; i5 < arrayListE.size(); i5++) {
            j4.c cVar2 = (j4.c) arrayListE.get(i5);
            if (!cVar2.f7626c && h(new File(cVar2.f7624a)) && (cVar == null || cVar.f7628e < cVar2.f7628e)) {
                cVar = cVar2;
            }
        }
        return cVar;
    }

    public static ArrayList e(Context context) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new j4.c(context.getFilesDir().getAbsolutePath(), true, false, -1));
        ArrayList arrayList2 = new ArrayList();
        for (File file : context.getExternalFilesDirs(null)) {
            if (file != null && "mounted".equals(Environment.getStorageState(file))) {
                arrayList2.add(file);
            }
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList.add(new j4.c(((File) it.next()).getAbsolutePath(), false, false, -1));
        }
        return arrayList;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0204 A[Catch: all -> 0x0231, Exception -> 0x0235, TRY_LEAVE, TryCatch #22 {Exception -> 0x0235, all -> 0x0231, blocks: (B:112:0x01f9, B:114:0x0204), top: B:259:0x01f9 }] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0238  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0252 A[Catch: all -> 0x0292, Exception -> 0x0296, TRY_LEAVE, TryCatch #23 {Exception -> 0x0296, all -> 0x0292, blocks: (B:138:0x0245, B:140:0x0252), top: B:234:0x0245 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x029d A[Catch: Exception -> 0x02a9, TRY_ENTER, TRY_LEAVE, TryCatch #3 {Exception -> 0x02a9, blocks: (B:163:0x029d, B:167:0x02a6), top: B:234:0x0245 }] */
    /* JADX WARN: Removed duplicated region for block: B:171:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x02d6  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x03ca A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x03c4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:247:0x023b A[EXC_TOP_SPLITTER, PHI: r2
      0x023b: PHI (r2v4 java.util.Scanner) = (r2v3 java.util.Scanner), (r2v31 java.util.Scanner) binds: [B:136:0x0242, B:132:0x0239] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x03be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x018d  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r11v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList f() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 974
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: Z3.i.f():java.util.ArrayList");
    }

    public static boolean g(EditText editText) {
        return editText.getInputType() != 0;
    }

    public static boolean h(File file) {
        try {
            File file2 = new File(file.getAbsolutePath() + File.separator + UUID.randomUUID().toString());
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            fileOutputStream.write("hi".getBytes());
            fileOutputStream.close();
            file2.delete();
            Log.i("StorageUtils", file.getAbsolutePath() + " is writable");
            return true;
        } catch (Throwable unused) {
            Log.i("StorageUtils", file.getAbsolutePath() + " is NOT writable");
            return false;
        }
    }

    public static String i(String str, Object... objArr) {
        int iIndexOf;
        String string;
        int i5 = 0;
        for (int i6 = 0; i6 < objArr.length; i6++) {
            Object obj = objArr[i6];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e5) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb.append(name);
                    sb.append('@');
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String strValueOf = String.valueOf(string2);
                    logger.log(level, strValueOf.length() != 0 ? "Exception during lenientFormat for ".concat(strValueOf) : new String("Exception during lenientFormat for "), (Throwable) e5);
                    String name2 = e5.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(name2.length() + String.valueOf(string2).length() + 9);
                    sb2.append("<");
                    sb2.append(string2);
                    sb2.append(" threw ");
                    sb2.append(name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i6] = string;
        }
        StringBuilder sb3 = new StringBuilder((objArr.length * 16) + str.length());
        int i7 = 0;
        while (i5 < objArr.length && (iIndexOf = str.indexOf("%s", i7)) != -1) {
            sb3.append((CharSequence) str, i7, iIndexOf);
            sb3.append(objArr[i5]);
            i7 = iIndexOf + 2;
            i5++;
        }
        sb3.append((CharSequence) str, i7, str.length());
        if (i5 < objArr.length) {
            sb3.append(" [");
            sb3.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb3.append(", ");
                sb3.append(objArr[i8]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public static byte[] j(R0.c cVar) throws IOException {
        ArrayDeque arrayDeque = new ArrayDeque(20);
        int iMin = Math.min(8192, Math.max(128, Integer.highestOneBit(0) * 2));
        int i5 = 0;
        while (i5 < 2147483639) {
            int iMin2 = Math.min(iMin, 2147483639 - i5);
            byte[] bArr = new byte[iMin2];
            arrayDeque.add(bArr);
            int i6 = 0;
            while (i6 < iMin2) {
                int i7 = cVar.read(bArr, i6, iMin2 - i6);
                if (i7 == -1) {
                    return b(arrayDeque, i5);
                }
                i6 += i7;
                i5 += i7;
            }
            long j5 = iMin * (iMin < 4096 ? 4 : 2);
            iMin = j5 > 2147483647L ? Integer.MAX_VALUE : j5 < -2147483648L ? Integer.MIN_VALUE : (int) j5;
        }
        if (cVar.read() == -1) {
            return b(arrayDeque, 2147483639);
        }
        throw new OutOfMemoryError("input is too large to fit in a byte array");
    }

    public static double k(double d5) {
        if (Double.isNaN(d5)) {
            return 0.0d;
        }
        if (Double.isInfinite(d5) || d5 == 0.0d || d5 == 0.0d) {
            return d5;
        }
        return (d5 > 0.0d ? 1 : -1) * Math.floor(Math.abs(d5));
    }

    public static int l(double d5) {
        if (Double.isNaN(d5) || Double.isInfinite(d5) || d5 == 0.0d) {
            return 0;
        }
        return (int) (((d5 > 0.0d ? 1 : -1) * Math.floor(Math.abs(d5))) % 4.294967296E9d);
    }

    public static void m(t tVar) {
        int iL = l(tVar.u("runtime.counter").a().doubleValue() + 1.0d);
        if (iL > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        tVar.w("runtime.counter", new C0328h(Double.valueOf(iL)));
    }

    public static EnumC0402w n(String str) throws NumberFormatException {
        EnumC0402w enumC0402w = null;
        if (str != null && !str.isEmpty()) {
            enumC0402w = (EnumC0402w) EnumC0402w.f5114u0.get(Integer.valueOf(Integer.parseInt(str)));
        }
        if (enumC0402w != null) {
            return enumC0402w;
        }
        throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.s("Unsupported commandId ", str));
    }

    public static Object o(InterfaceC0363o interfaceC0363o) {
        if (InterfaceC0363o.f5005c.equals(interfaceC0363o)) {
            return null;
        }
        if (InterfaceC0363o.f5004b.equals(interfaceC0363o)) {
            return "";
        }
        if (interfaceC0363o instanceof C0348l) {
            return p((C0348l) interfaceC0363o);
        }
        if (!(interfaceC0363o instanceof C0313e)) {
            return !interfaceC0363o.a().isNaN() ? interfaceC0363o.a() : interfaceC0363o.b();
        }
        ArrayList arrayList = new ArrayList();
        C0313e c0313e = (C0313e) interfaceC0363o;
        c0313e.getClass();
        int i5 = 0;
        while (i5 < c0313e.j()) {
            if (i5 >= c0313e.j()) {
                throw new NoSuchElementException(com.unified.ur1.SatelliteTracker.h.a(i5, "Out of bounds index: "));
            }
            int i6 = i5 + 1;
            Object objO = o(c0313e.k(i5));
            if (objO != null) {
                arrayList.add(objO);
            }
            i5 = i6;
        }
        return arrayList;
    }

    public static HashMap p(C0348l c0348l) {
        HashMap map = new HashMap();
        Iterator it = new ArrayList(c0348l.f4976j.keySet()).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Object objO = o(c0348l.f(str));
            if (objO != null) {
                map.put(str, objO);
            }
        }
        return map;
    }

    public static void q(List list, int i5, String str) {
        if (list.size() == i5) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires " + i5 + " parameters found " + list.size());
    }

    public static void r(List list, int i5, String str) {
        if (list.size() >= i5) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at least " + i5 + " parameters found " + list.size());
    }

    public static void s(String str, int i5, ArrayList arrayList) {
        if (arrayList.size() <= i5) {
            return;
        }
        throw new IllegalArgumentException(str + " operation requires at most " + i5 + " parameters found " + arrayList.size());
    }

    public static boolean t(InterfaceC0363o interfaceC0363o) {
        if (interfaceC0363o == null) {
            return false;
        }
        Double dA = interfaceC0363o.a();
        return !dA.isNaN() && dA.doubleValue() >= 0.0d && dA.equals(Double.valueOf(Math.floor(dA.doubleValue())));
    }

    public static boolean u(InterfaceC0363o interfaceC0363o, InterfaceC0363o interfaceC0363o2) {
        if (!interfaceC0363o.getClass().equals(interfaceC0363o2.getClass())) {
            return false;
        }
        if ((interfaceC0363o instanceof C0382s) || (interfaceC0363o instanceof C0353m)) {
            return true;
        }
        if (!(interfaceC0363o instanceof C0328h)) {
            return interfaceC0363o instanceof r ? interfaceC0363o.b().equals(interfaceC0363o2.b()) : interfaceC0363o instanceof C0318f ? interfaceC0363o.i().equals(interfaceC0363o2.i()) : interfaceC0363o == interfaceC0363o2;
        }
        if (Double.isNaN(interfaceC0363o.a().doubleValue()) || Double.isNaN(interfaceC0363o2.a().doubleValue())) {
            return false;
        }
        return interfaceC0363o.a().equals(interfaceC0363o2.a());
    }
}
