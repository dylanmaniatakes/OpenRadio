package t3;

import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.D1;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class h extends D1 {
    public static List r(Object[] objArr) {
        F3.i.f(objArr, "<this>");
        List listAsList = Arrays.asList(objArr);
        F3.i.e(listAsList, "asList(this)");
        return listAsList;
    }

    public static void s(int i5, int i6, int i7, Object[] objArr, Object[] objArr2) {
        F3.i.f(objArr, "<this>");
        F3.i.f(objArr2, "destination");
        System.arraycopy(objArr, i6, objArr2, i5, i7 - i6);
    }

    public static void t(byte[] bArr, int i5, int i6, byte[] bArr2, int i7) {
        F3.i.f(bArr, "<this>");
        F3.i.f(bArr2, "destination");
        System.arraycopy(bArr, i6, bArr2, i5, i7 - i6);
    }

    public static void u(Object[] objArr, Object obj, int i5, int i6) {
        F3.i.f(objArr, "<this>");
        Arrays.fill(objArr, i5, i6, obj);
    }

    public static ArrayList w(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : objArr) {
            if (obj != null) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    public static char x(char[] cArr) {
        F3.i.f(cArr, "<this>");
        int length = cArr.length;
        if (length == 0) {
            throw new NoSuchElementException("Array is empty.");
        }
        if (length == 1) {
            return cArr[0];
        }
        throw new IllegalArgumentException("Array has more than one element.");
    }

    public static List y(Object[] objArr) {
        F3.i.f(objArr, "<this>");
        int length = objArr.length;
        return length != 0 ? length != 1 ? new ArrayList(new f(objArr, false)) : AbstractC0296a2.i(objArr[0]) : q.f9711j;
    }
}
