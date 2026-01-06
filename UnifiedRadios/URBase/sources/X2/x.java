package X2;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: b, reason: collision with root package name */
    public static WeakReference f2848b;

    /* renamed from: a, reason: collision with root package name */
    public F2.t f2849a;

    public final synchronized w a() {
        String str;
        w wVar;
        F2.t tVar = this.f2849a;
        synchronized (((ArrayDeque) tVar.f584e)) {
            str = (String) ((ArrayDeque) tVar.f584e).peek();
        }
        Pattern pattern = w.f2844d;
        wVar = null;
        if (!TextUtils.isEmpty(str)) {
            String[] strArrSplit = str.split("!", -1);
            if (strArrSplit.length == 2) {
                wVar = new w(strArrSplit[0], strArrSplit[1]);
            }
        }
        return wVar;
    }
}
