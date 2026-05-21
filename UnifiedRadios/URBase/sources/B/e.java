package B;

import android.app.Activity;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class e extends C.h {
    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Activity activity, String[] strArr, int i5) {
        HashSet hashSet = new HashSet();
        for (int i6 = 0; i6 < strArr.length; i6++) {
            if (TextUtils.isEmpty(strArr[i6])) {
                throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.e(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (!AbstractC0399v1.e() && TextUtils.equals(strArr[i6], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i6));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i7 = 0;
            for (int i8 = 0; i8 < strArr.length; i8++) {
                if (!hashSet.contains(Integer.valueOf(i8))) {
                    strArr2[i7] = strArr[i8];
                    i7++;
                }
            }
        }
        if (activity instanceof d) {
            ((d) activity).validateRequestPermissionsRequestCode(i5);
        }
        c.b(activity, strArr, i5);
    }

    public static boolean e(Activity activity, String str) {
        if (AbstractC0399v1.e() || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return c.c(activity, str);
        }
        return false;
    }
}
