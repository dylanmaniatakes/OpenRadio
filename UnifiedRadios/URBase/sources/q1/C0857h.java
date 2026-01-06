package q1;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import n1.C0787d;
import r1.AbstractC0873a;

/* renamed from: q1.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0857h extends AbstractC0873a {
    public static final Parcelable.Creator<C0857h> CREATOR = new x(4);

    /* renamed from: x, reason: collision with root package name */
    public static final Scope[] f9373x = new Scope[0];

    /* renamed from: y, reason: collision with root package name */
    public static final C0787d[] f9374y = new C0787d[0];

    /* renamed from: j, reason: collision with root package name */
    public final int f9375j;

    /* renamed from: k, reason: collision with root package name */
    public final int f9376k;

    /* renamed from: l, reason: collision with root package name */
    public final int f9377l;

    /* renamed from: m, reason: collision with root package name */
    public String f9378m;
    public IBinder n;

    /* renamed from: o, reason: collision with root package name */
    public Scope[] f9379o;

    /* renamed from: p, reason: collision with root package name */
    public Bundle f9380p;

    /* renamed from: q, reason: collision with root package name */
    public Account f9381q;

    /* renamed from: r, reason: collision with root package name */
    public C0787d[] f9382r;

    /* renamed from: s, reason: collision with root package name */
    public C0787d[] f9383s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f9384t;

    /* renamed from: u, reason: collision with root package name */
    public final int f9385u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f9386v;

    /* renamed from: w, reason: collision with root package name */
    public final String f9387w;

    public C0857h(int i5, int i6, int i7, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C0787d[] c0787dArr, C0787d[] c0787dArr2, boolean z4, int i8, boolean z5, String str2) {
        Account account2;
        Scope[] scopeArr2 = scopeArr == null ? f9373x : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        C0787d[] c0787dArr3 = f9374y;
        C0787d[] c0787dArr4 = c0787dArr == null ? c0787dArr3 : c0787dArr;
        c0787dArr3 = c0787dArr2 != null ? c0787dArr2 : c0787dArr3;
        this.f9375j = i5;
        this.f9376k = i6;
        this.f9377l = i7;
        if ("com.google.android.gms".equals(str)) {
            this.f9378m = "com.google.android.gms";
        } else {
            this.f9378m = str;
        }
        if (i5 < 2) {
            account2 = null;
            if (iBinder != null) {
                int i9 = AbstractBinderC0850a.f9344d;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                IInterface s4 = iInterfaceQueryLocalInterface instanceof InterfaceC0859j ? (InterfaceC0859j) iInterfaceQueryLocalInterface : new S(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 1);
                if (s4 != null) {
                    long jClearCallingIdentity = Binder.clearCallingIdentity();
                    try {
                        try {
                            S s5 = (S) s4;
                            Parcel parcelA = s5.a(2, s5.b());
                            Account account3 = (Account) C1.a.a(parcelA, Account.CREATOR);
                            parcelA.recycle();
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                            account2 = account3;
                        } catch (RemoteException unused) {
                            Log.w("AccountAccessor", "Remote account accessor probably died");
                            Binder.restoreCallingIdentity(jClearCallingIdentity);
                        }
                    } catch (Throwable th) {
                        Binder.restoreCallingIdentity(jClearCallingIdentity);
                        throw th;
                    }
                }
            }
        } else {
            this.n = iBinder;
            account2 = account;
        }
        this.f9381q = account2;
        this.f9379o = scopeArr2;
        this.f9380p = bundle2;
        this.f9382r = c0787dArr4;
        this.f9383s = c0787dArr3;
        this.f9384t = z4;
        this.f9385u = i8;
        this.f9386v = z5;
        this.f9387w = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i5) {
        x.a(this, parcel, i5);
    }
}
