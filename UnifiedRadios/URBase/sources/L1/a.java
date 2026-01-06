package L1;

import D0.w;
import N1.p;
import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import l1.C0741a;
import n1.C0785b;
import o1.i;
import o1.j;
import org.json.JSONException;
import p1.BinderC0823D;
import q1.AbstractC0858i;
import q1.C0863n;
import q1.E;
import q1.v;

/* loaded from: classes.dex */
public final class a extends AbstractC0858i implements o1.c {

    /* renamed from: E, reason: collision with root package name */
    public static final /* synthetic */ int f1598E = 0;

    /* renamed from: A, reason: collision with root package name */
    public final boolean f1599A;

    /* renamed from: B, reason: collision with root package name */
    public final w f1600B;

    /* renamed from: C, reason: collision with root package name */
    public final Bundle f1601C;

    /* renamed from: D, reason: collision with root package name */
    public final Integer f1602D;

    public a(Context context, Looper looper, w wVar, Bundle bundle, i iVar, j jVar) {
        super(context, looper, 44, wVar, iVar, jVar);
        this.f1599A = true;
        this.f1600B = wVar;
        this.f1601C = bundle;
        this.f1602D = (Integer) wVar.h;
    }

    public final void B() {
        b(new C0863n(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void C(d dVar) {
        GoogleSignInAccount googleSignInAccountA;
        E.j(dVar, "Expecting a valid ISignInCallbacks");
        try {
            Account account = (Account) this.f1600B.f309b;
            if (account == null) {
                account = new Account("<<default account>>", "com.google");
            }
            if ("<<default account>>".equals(account.name)) {
                C0741a c0741aA = C0741a.a(this.f9348c);
                String strB = c0741aA.b("defaultGoogleSignInAccount");
                if (!TextUtils.isEmpty(strB)) {
                    String strB2 = c0741aA.b("googleSignInAccount:" + strB);
                    if (strB2 != null) {
                        try {
                            googleSignInAccountA = GoogleSignInAccount.a(strB2);
                        } catch (JSONException unused) {
                        }
                    }
                }
                googleSignInAccountA = null;
            } else {
                googleSignInAccountA = null;
            }
            Integer num = this.f1602D;
            E.i(num);
            v vVar = new v(2, account, num.intValue(), googleSignInAccountA);
            e eVar = (e) t();
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.writeInterfaceToken(eVar.f8e);
            int i5 = A1.c.f10a;
            parcelObtain.writeInt(1);
            int I = A2.b.I(20293, parcelObtain);
            A2.b.M(parcelObtain, 1, 4);
            parcelObtain.writeInt(1);
            A2.b.D(parcelObtain, 2, vVar, 0);
            A2.b.K(I, parcelObtain);
            parcelObtain.writeStrongBinder((A1.b) dVar);
            Parcel parcelObtain2 = Parcel.obtain();
            try {
                eVar.f7d.transact(12, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
            } finally {
                parcelObtain.recycle();
                parcelObtain2.recycle();
            }
        } catch (RemoteException e5) {
            Log.w("SignInClientImpl", "Remote service probably died when signIn is called");
            try {
                BinderC0823D binderC0823D = (BinderC0823D) dVar;
                binderC0823D.f9088e.post(new p(binderC0823D, 11, new g(1, new C0785b(8, null), null)));
            } catch (RemoteException unused2) {
                Log.wtf("SignInClientImpl", "ISignInCallbacks#onSignInComplete should be executed from the same process, unexpected RemoteException.", e5);
            }
        }
    }

    @Override // q1.AbstractC0854e, o1.c
    public final int f() {
        return 12451000;
    }

    @Override // q1.AbstractC0854e, o1.c
    public final boolean m() {
        return this.f1599A;
    }

    @Override // q1.AbstractC0854e
    public final IInterface o(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.signin.internal.ISignInService");
        return iInterfaceQueryLocalInterface instanceof e ? (e) iInterfaceQueryLocalInterface : new e(iBinder, "com.google.android.gms.signin.internal.ISignInService", 0);
    }

    @Override // q1.AbstractC0854e
    public final Bundle r() {
        w wVar = this.f1600B;
        boolean zEquals = this.f9348c.getPackageName().equals((String) wVar.f312e);
        Bundle bundle = this.f1601C;
        if (!zEquals) {
            bundle.putString("com.google.android.gms.signin.internal.realClientPackageName", (String) wVar.f312e);
        }
        return bundle;
    }

    @Override // q1.AbstractC0854e
    public final String u() {
        return "com.google.android.gms.signin.internal.ISignInService";
    }

    @Override // q1.AbstractC0854e
    public final String v() {
        return "com.google.android.gms.signin.service.START";
    }
}
