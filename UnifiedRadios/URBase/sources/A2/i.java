package A2;

import F2.n;
import F2.r;
import F2.t;
import G2.k;
import L0.m;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.datatransport.TransportRegistrar;
import com.google.firebase.installations.FirebaseInstallationsRegistrar;
import com.unified.ur1.primary.LaunchActivity;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.ScheduledExecutorService;
import org.conscrypt.FileClientSessionCache;
import s2.v;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements F2.e, N1.b, N2.a, f1.h, N1.f, v {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f37c;

    public /* synthetic */ i(int i5) {
        this.f37c = i5;
    }

    public String a(Context context) {
        switch (this.f37c) {
            case 0:
                ApplicationInfo applicationInfo = context.getApplicationInfo();
                return applicationInfo != null ? String.valueOf(applicationInfo.targetSdkVersion) : "";
            case 1:
                ApplicationInfo applicationInfo2 = context.getApplicationInfo();
                return applicationInfo2 != null ? String.valueOf(applicationInfo2.minSdkVersion) : "";
            case 2:
                return context.getPackageManager().hasSystemFeature("android.hardware.type.television") ? "tv" : context.getPackageManager().hasSystemFeature("android.hardware.type.watch") ? "watch" : context.getPackageManager().hasSystemFeature("android.hardware.type.automotive") ? "auto" : context.getPackageManager().hasSystemFeature("android.hardware.type.embedded") ? "embedded" : "";
            default:
                String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                return installerPackageName != null ? FirebaseCommonRegistrar.a(installerPackageName) : "";
        }
    }

    @Override // f1.h
    public Object apply(Object obj) {
        switch (this.f37c) {
            case o1.f.API_NOT_CONNECTED /* 17 */:
                Cursor cursorRawQuery = ((SQLiteDatabase) obj).rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]);
                try {
                    ArrayList arrayList = new ArrayList();
                    while (cursorRawQuery.moveToNext()) {
                        m mVarA = Y0.i.a();
                        mVarA.o(cursorRawQuery.getString(1));
                        mVarA.f1558f = i1.a.b(cursorRawQuery.getInt(2));
                        String string = cursorRawQuery.getString(3);
                        mVarA.f1557e = string == null ? null : Base64.decode(string, 0);
                        arrayList.add(mVarA.d());
                    }
                    return arrayList;
                } finally {
                    cursorRawQuery.close();
                }
            default:
                return Boolean.valueOf(((Cursor) obj).getCount() > 0);
        }
    }

    @Override // F2.e
    public Object b(t tVar) {
        switch (this.f37c) {
            case 4:
                return (ScheduledExecutorService) ExecutorsRegistrar.f5533a.get();
            case 5:
                return (ScheduledExecutorService) ExecutorsRegistrar.f5535c.get();
            case 6:
                return (ScheduledExecutorService) ExecutorsRegistrar.f5534b.get();
            case 7:
                n nVar = ExecutorsRegistrar.f5533a;
                return k.f641j;
            case 8:
                return TransportRegistrar.lambda$getComponents$0(tVar);
            case 9:
                return TransportRegistrar.lambda$getComponents$1(tVar);
            case 10:
                return TransportRegistrar.lambda$getComponents$2(tVar);
            case 11:
                return FirebaseInstallationsRegistrar.lambda$getComponents$0(tVar);
            default:
                Set setB = tVar.b(r.a(Z2.a.class));
                Z2.c cVar = Z2.c.f3145e;
                if (cVar == null) {
                    synchronized (Z2.c.class) {
                        try {
                            cVar = Z2.c.f3145e;
                            if (cVar == null) {
                                cVar = new Z2.c(0);
                                Z2.c.f3145e = cVar;
                            }
                        } finally {
                        }
                    }
                }
                return new Z2.b(setB, cVar);
        }
    }

    @Override // N1.b
    public Object c(N1.j jVar) {
        switch (this.f37c) {
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return 403;
            default:
                return -1;
        }
    }

    @Override // N1.f
    public void d(Exception exc) {
        Context context = LaunchActivity.f5853D1;
        Log.e("Location", "Error getting location", exc);
    }
}
