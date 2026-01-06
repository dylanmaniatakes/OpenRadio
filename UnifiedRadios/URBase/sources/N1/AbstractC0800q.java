package n1;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;
import q1.C;
import q1.C0849B;
import q1.D;
import q1.E;
import u1.AbstractC0907b;
import x1.BinderC0963d;
import y1.C0979a;

/* renamed from: n1.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0800q {

    /* renamed from: a, reason: collision with root package name */
    public static final BinderC0796m f8763a;

    /* renamed from: b, reason: collision with root package name */
    public static final BinderC0796m f8764b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile D f8765c;

    /* renamed from: d, reason: collision with root package name */
    public static final Object f8766d;

    /* renamed from: e, reason: collision with root package name */
    public static Context f8767e;

    static {
        new BinderC0796m(0, AbstractBinderC0797n.J("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));
        new BinderC0796m(1, AbstractBinderC0797n.J("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));
        f8763a = new BinderC0796m(2, AbstractBinderC0797n.J("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));
        f8764b = new BinderC0796m(3, AbstractBinderC0797n.J("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));
        f8766d = new Object();
    }

    /* JADX WARN: Type inference failed for: r13v3, types: [n1.l] */
    public static t a(final String str, final BinderC0798o binderC0798o, final boolean z4, boolean z5) {
        try {
            b();
            E.i(f8767e);
            try {
                D d5 = f8765c;
                BinderC0963d binderC0963d = new BinderC0963d(f8767e.getPackageManager());
                C0849B c0849b = (C0849B) d5;
                Parcel parcelB = c0849b.b();
                int i5 = C1.a.f182a;
                boolean z6 = true;
                parcelB.writeInt(1);
                int I = A2.b.I(20293, parcelB);
                A2.b.E(parcelB, 1, str);
                A2.b.B(parcelB, 2, binderC0798o);
                A2.b.M(parcelB, 3, 4);
                parcelB.writeInt(z4 ? 1 : 0);
                A2.b.M(parcelB, 4, 4);
                parcelB.writeInt(z5 ? 1 : 0);
                A2.b.K(I, parcelB);
                C1.a.c(parcelB, binderC0963d);
                Parcel parcelA = c0849b.a(5, parcelB);
                if (parcelA.readInt() == 0) {
                    z6 = false;
                }
                parcelA.recycle();
                return z6 ? t.f8773d : new s(new Callable() { // from class: n1.l
                    @Override // java.util.concurrent.Callable
                    public final Object call() throws NoSuchAlgorithmException {
                        MessageDigest messageDigest;
                        boolean z7 = z4;
                        String str2 = str;
                        AbstractBinderC0797n abstractBinderC0797n = binderC0798o;
                        String str3 = (z7 || !AbstractC0800q.a(str2, (BinderC0798o) abstractBinderC0797n, true, false).f8774a) ? "not allowed" : "debug cert rejected";
                        int i6 = 0;
                        while (true) {
                            if (i6 >= 2) {
                                messageDigest = null;
                                break;
                            }
                            try {
                                messageDigest = MessageDigest.getInstance("SHA-256");
                            } catch (NoSuchAlgorithmException unused) {
                            }
                            if (messageDigest != null) {
                                break;
                            }
                            i6++;
                        }
                        E.i(messageDigest);
                        byte[] bArrDigest = messageDigest.digest(abstractBinderC0797n.K());
                        int length = bArrDigest.length;
                        char[] cArr = new char[length + length];
                        int i7 = 0;
                        for (byte b5 : bArrDigest) {
                            char[] cArr2 = AbstractC0907b.f9920b;
                            cArr[i7] = cArr2[(b5 & 255) >>> 4];
                            cArr[i7 + 1] = cArr2[b5 & 15];
                            i7 += 2;
                        }
                        return str3 + ": pkg=" + str2 + ", sha256=" + new String(cArr) + ", atk=" + z7 + ", ver=12451000.false";
                    }
                });
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
                return new t(false, "module call", e5);
            }
        } catch (C0979a e6) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e6);
            return new t(false, "module init: ".concat(String.valueOf(e6.getMessage())), e6);
        }
    }

    public static void b() {
        D c0849b;
        if (f8765c != null) {
            return;
        }
        E.i(f8767e);
        synchronized (f8766d) {
            try {
                if (f8765c == null) {
                    IBinder iBinderB = y1.e.c(f8767e, y1.e.f10472d, "com.google.android.gms.googlecertificates").b("com.google.android.gms.common.GoogleCertificatesImpl");
                    int i5 = C.f9310d;
                    if (iBinderB == null) {
                        c0849b = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderB.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                        c0849b = iInterfaceQueryLocalInterface instanceof D ? (D) iInterfaceQueryLocalInterface : new C0849B(iBinderB, "com.google.android.gms.common.internal.IGoogleCertificatesApi", 1);
                    }
                    f8765c = c0849b;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
