package D2;

import J1.L0;
import android.support.v4.media.session.b;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.internal.measurement.D1;
import java.util.Arrays;
import y2.AbstractC0985d;
import y2.C0983b;
import y2.f;
import y2.h;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final h f414a;

    /* renamed from: b, reason: collision with root package name */
    public static final h f415b;

    /* renamed from: c, reason: collision with root package name */
    public static final h f416c;

    static {
        int i5 = f.f10497l;
        Object[] objArr = new Object[15];
        objArr[0] = "_in";
        objArr[1] = "_xa";
        objArr[2] = "_xu";
        objArr[3] = "_aq";
        objArr[4] = "_aa";
        objArr[5] = "_ai";
        System.arraycopy(new String[]{"_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"}, 0, objArr, 6, 9);
        f.h(15, objArr);
        C0983b c0983b = AbstractC0985d.f10493k;
        Object[] objArr2 = {"_e", "_f", "_iap", "_s", "_au", "_ui", "_cd"};
        D1.b(7, objArr2);
        f414a = AbstractC0985d.f(7, objArr2);
        Object[] objArr3 = {"auto", "app", "am"};
        D1.b(3, objArr3);
        f415b = AbstractC0985d.f(3, objArr3);
        Object[] objArr4 = {"_r", "_dbg"};
        D1.b(2, objArr4);
        f416c = AbstractC0985d.f(2, objArr4);
        b.d(4, "initialCapacity");
        String[] strArr = L0.f890i;
        D1.b(15, strArr);
        Object[] objArrCopyOf = Arrays.copyOf(new Object[4], AbstractC0409x1.c(4, 15));
        System.arraycopy(strArr, 0, objArrCopyOf, 0, 15);
        String[] strArr2 = L0.f891j;
        D1.b(15, strArr2);
        if (objArrCopyOf.length < 30) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, AbstractC0409x1.c(objArrCopyOf.length, 30));
        }
        System.arraycopy(strArr2, 0, objArrCopyOf, 15, 15);
        AbstractC0985d.f(30, objArrCopyOf);
        Object[] objArr5 = {"^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$"};
        D1.b(2, objArr5);
        AbstractC0985d.f(2, objArr5);
    }
}
