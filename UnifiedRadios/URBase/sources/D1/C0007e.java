package D1;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import q1.C0866q;
import s1.C0887c;

/* renamed from: D1.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0007e extends AbstractC0296a2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f387a;

    public /* synthetic */ C0007e(int i5) {
        this.f387a = i5;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC0296a2
    public o1.c b(Context context, Looper looper, D0.w wVar, Object obj, o1.i iVar, o1.j jVar) {
        switch (this.f387a) {
            case 2:
                wVar.getClass();
                Integer num = (Integer) wVar.h;
                Bundle bundle = new Bundle();
                bundle.putParcelable("com.google.android.gms.signin.internal.clientRequestedAccount", (Account) wVar.f309b);
                if (num != null) {
                    bundle.putInt("com.google.android.gms.common.internal.ClientSettings.sessionId", num.intValue());
                }
                bundle.putBoolean("com.google.android.gms.signin.internal.offlineAccessRequested", false);
                bundle.putBoolean("com.google.android.gms.signin.internal.idTokenRequested", false);
                bundle.putString("com.google.android.gms.signin.internal.serverClientId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.usePromptModeForAuthCode", true);
                bundle.putBoolean("com.google.android.gms.signin.internal.forceCodeForRefreshToken", false);
                bundle.putString("com.google.android.gms.signin.internal.hostedDomain", null);
                bundle.putString("com.google.android.gms.signin.internal.logSessionId", null);
                bundle.putBoolean("com.google.android.gms.signin.internal.waitForAccessTokenRefresh", false);
                return new L1.a(context, looper, wVar, bundle, iVar, jVar);
            case 3:
                com.unified.ur1.SatelliteTracker.h.p(obj);
                throw null;
            default:
                return super.b(context, looper, wVar, obj, iVar, jVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC0296a2
    public o1.c c(Context context, Looper looper, D0.w wVar, Object obj, o1.i iVar, o1.j jVar) {
        switch (this.f387a) {
            case 0:
                return new U(context, looper, 23, wVar, iVar, jVar);
            case 1:
                return new D(context, looper, wVar, iVar, jVar);
            case 2:
            case 3:
            default:
                return super.c(context, looper, wVar, obj, iVar, jVar);
            case 4:
                return new C0887c(context, looper, wVar, (C0866q) obj, iVar, jVar);
        }
    }
}
