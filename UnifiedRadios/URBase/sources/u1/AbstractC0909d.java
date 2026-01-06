package u1;

import android.os.Process;
import android.os.WorkSource;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import q1.E;

/* renamed from: u1.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0909d {

    /* renamed from: a, reason: collision with root package name */
    public static final Method f9926a;

    /* renamed from: b, reason: collision with root package name */
    public static final Method f9927b;

    /* renamed from: c, reason: collision with root package name */
    public static final Method f9928c;

    /* renamed from: d, reason: collision with root package name */
    public static final Method f9929d;

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f9930e;

    static {
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Process.myUid();
        try {
            method = WorkSource.class.getMethod("add", Integer.TYPE);
        } catch (Exception unused) {
            method = null;
        }
        f9926a = method;
        try {
            method2 = WorkSource.class.getMethod("add", Integer.TYPE, String.class);
        } catch (Exception unused2) {
            method2 = null;
        }
        f9927b = method2;
        try {
            method3 = WorkSource.class.getMethod("size", null);
        } catch (Exception unused3) {
            method3 = null;
        }
        f9928c = method3;
        try {
            WorkSource.class.getMethod("get", Integer.TYPE);
        } catch (Exception unused4) {
        }
        try {
            WorkSource.class.getMethod("getName", Integer.TYPE);
        } catch (Exception unused5) {
        }
        try {
            WorkSource.class.getMethod("createWorkChain", null);
        } catch (Exception e5) {
            Log.w("WorkSourceUtil", "Missing WorkChain API createWorkChain", e5);
        }
        try {
            Class.forName("android.os.WorkSource$WorkChain").getMethod("addNode", Integer.TYPE, String.class);
        } catch (Exception e6) {
            Log.w("WorkSourceUtil", "Missing WorkChain class", e6);
        }
        try {
            method4 = WorkSource.class.getMethod("isEmpty", null);
            try {
                method4.setAccessible(true);
            } catch (Exception unused6) {
            }
        } catch (Exception unused7) {
            method4 = null;
        }
        f9929d = method4;
        f9930e = null;
    }

    public static void a(WorkSource workSource, int i5, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Method method = f9927b;
        if (method != null) {
            if (str == null) {
                str = "";
            }
            try {
                method.invoke(workSource, Integer.valueOf(i5), str);
                return;
            } catch (Exception e5) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e5);
                return;
            }
        }
        Method method2 = f9926a;
        if (method2 != null) {
            try {
                method2.invoke(workSource, Integer.valueOf(i5));
            } catch (Exception e6) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
            }
        }
    }

    public static boolean b(WorkSource workSource) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int iIntValue;
        Method method = f9929d;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(workSource, null);
                E.i(objInvoke);
                return ((Boolean) objInvoke).booleanValue();
            } catch (Exception e5) {
                Log.e("WorkSourceUtil", "Unable to check WorkSource emptiness", e5);
            }
        }
        Method method2 = f9928c;
        if (method2 != null) {
            try {
                Object objInvoke2 = method2.invoke(workSource, null);
                E.i(objInvoke2);
                iIntValue = ((Integer) objInvoke2).intValue();
            } catch (Exception e6) {
                Log.wtf("WorkSourceUtil", "Unable to assign blame through WorkSource", e6);
            }
        } else {
            iIntValue = 0;
        }
        return iIntValue == 0;
    }
}
