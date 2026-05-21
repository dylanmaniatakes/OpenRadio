package y1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import h1.C0558b;
import h1.C0559c;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import n1.C0789f;
import q1.E;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: e, reason: collision with root package name */
    public static Boolean f10473e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f10474f = null;
    public static boolean g = false;
    public static int h = -1;

    /* renamed from: i, reason: collision with root package name */
    public static Boolean f10475i;

    /* renamed from: m, reason: collision with root package name */
    public static i f10479m;
    public static j n;

    /* renamed from: a, reason: collision with root package name */
    public final Context f10480a;

    /* renamed from: j, reason: collision with root package name */
    public static final ThreadLocal f10476j = new ThreadLocal();

    /* renamed from: k, reason: collision with root package name */
    public static final H3.b f10477k = new H3.b(3);

    /* renamed from: l, reason: collision with root package name */
    public static final C0559c f10478l = new C0559c();

    /* renamed from: b, reason: collision with root package name */
    public static final C0558b f10470b = new C0558b(10);

    /* renamed from: c, reason: collision with root package name */
    public static final C0559c f10471c = new C0559c();

    /* renamed from: d, reason: collision with root package name */
    public static final C0558b f10472d = new C0558b(11);

    public e(Context context) {
        this.f10480a = context;
    }

    public static int a(Context context, String str) throws NoSuchFieldException, ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (E.l(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e5) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e5.getMessage())));
            return 0;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0099, code lost:
    
        if (r10 != 0) goto L23;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:119:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0097 A[Catch: all -> 0x008d, TryCatch #9 {all -> 0x008d, blocks: (B:9:0x0053, B:13:0x0081, B:21:0x0097, B:24:0x009d, B:27:0x00b1, B:105:0x021c, B:106:0x0223, B:109:0x0226, B:110:0x0227, B:111:0x022e, B:112:0x022f, B:114:0x024d, B:116:0x025a), top: B:160:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x009d A[Catch: all -> 0x008d, TRY_LEAVE, TryCatch #9 {all -> 0x008d, blocks: (B:9:0x0053, B:13:0x0081, B:21:0x0097, B:24:0x009d, B:27:0x00b1, B:105:0x021c, B:106:0x0223, B:109:0x0226, B:110:0x0227, B:111:0x022e, B:112:0x022f, B:114:0x024d, B:116:0x025a), top: B:160:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00af  */
    /* JADX WARN: Type inference failed for: r10v6 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static y1.e c(android.content.Context r23, y1.d r24, java.lang.String r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 777
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.e.c(android.content.Context, y1.d, java.lang.String):y1.e");
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ad A[Catch: all -> 0x0036, TryCatch #10 {, blocks: (B:9:0x0026, B:11:0x0032, B:52:0x00b6, B:16:0x003b, B:18:0x0042, B:20:0x0048, B:25:0x004e, B:27:0x0052, B:31:0x005c, B:33:0x0064, B:36:0x006b, B:43:0x0095, B:44:0x009d, B:39:0x0072, B:41:0x0078, B:42:0x0087, B:47:0x00a0, B:50:0x00a3, B:51:0x00ad, B:17:0x003e), top: B:145:0x0026, inners: #11 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int d(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 541
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.e.d(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:119:0x00e2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x012d A[PHI: r14
      0x012d: PHI (r14v9 boolean) = (r14v8 boolean), (r14v11 boolean), (r14v11 boolean) binds: [B:58:0x00ec, B:75:0x0124, B:77:0x0128] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int e(android.content.Context r12, java.lang.String r13, boolean r14, boolean r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 388
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.e.e(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    public static void f(ClassLoader classLoader) throws C0979a {
        try {
            j jVar = null;
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder != null) {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                jVar = iInterfaceQueryLocalInterface instanceof j ? (j) iInterfaceQueryLocalInterface : new j(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2", 1);
            }
            n = jVar;
        } catch (ClassNotFoundException e5) {
            e = e5;
            throw new C0979a("Failed to instantiate dynamite loader", e);
        } catch (IllegalAccessException e6) {
            e = e6;
            throw new C0979a("Failed to instantiate dynamite loader", e);
        } catch (InstantiationException e7) {
            e = e7;
            throw new C0979a("Failed to instantiate dynamite loader", e);
        } catch (NoSuchMethodException e8) {
            e = e8;
            throw new C0979a("Failed to instantiate dynamite loader", e);
        } catch (InvocationTargetException e9) {
            e = e9;
            throw new C0979a("Failed to instantiate dynamite loader", e);
        }
    }

    public static boolean g(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f10475i)) {
            return true;
        }
        boolean z4 = false;
        if (f10475i == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", Build.VERSION.SDK_INT >= 29 ? 268435456 : 0);
            if (C0789f.f8740b.c(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z4 = true;
            }
            f10475i = Boolean.valueOf(z4);
            if (z4 && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                g = true;
            }
        }
        if (!z4) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z4;
    }

    public static i h(Context context) {
        i iVar;
        synchronized (e.class) {
            i iVar2 = f10479m;
            if (iVar2 != null) {
                return iVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    iVar = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    iVar = iInterfaceQueryLocalInterface instanceof i ? (i) iInterfaceQueryLocalInterface : new i(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader", 1);
                }
                if (iVar != null) {
                    f10479m = iVar;
                    return iVar;
                }
            } catch (Exception e5) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e5.getMessage());
            }
            return null;
        }
    }

    public final IBinder b(String str) throws C0979a {
        try {
            return (IBinder) this.f10480a.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e5) {
            throw new C0979a("Failed to instantiate module class: ".concat(str), e5);
        }
    }
}
