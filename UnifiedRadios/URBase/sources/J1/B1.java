package J1;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class B1 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f707a;

    public B1(Context context, int i5) {
        switch (i5) {
            case 1:
                q1.E.i(context);
                Context applicationContext = context.getApplicationContext();
                q1.E.i(applicationContext);
                this.f707a = applicationContext;
                break;
            case 2:
                this.f707a = context;
                break;
            default:
                q1.E.i(context);
                this.f707a = context;
                break;
        }
    }

    public ApplicationInfo a(int i5, String str) {
        return this.f707a.getPackageManager().getApplicationInfo(str, i5);
    }

    public PackageInfo b(int i5, String str) {
        return this.f707a.getPackageManager().getPackageInfo(str, i5);
    }

    public boolean c() {
        int callingUid = Binder.getCallingUid();
        int iMyUid = Process.myUid();
        Context context = this.f707a;
        if (callingUid == iMyUid) {
            return AbstractC0930a.l(context);
        }
        String nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid());
        if (nameForUid != null) {
            return context.getPackageManager().isInstantApp(nameForUid);
        }
        return false;
    }
}
