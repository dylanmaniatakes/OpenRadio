package q1;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.versionedparcelable.ParcelImpl;
import com.google.android.gms.common.api.Scope;
import n1.C0785b;
import n1.C0787d;
import org.conscrypt.FileClientSessionCache;

/* loaded from: classes.dex */
public final class x implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9425a;

    public static void a(C0857h c0857h, Parcel parcel, int i5) {
        int I = A2.b.I(20293, parcel);
        int i6 = c0857h.f9375j;
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(i6);
        A2.b.M(parcel, 2, 4);
        parcel.writeInt(c0857h.f9376k);
        A2.b.M(parcel, 3, 4);
        parcel.writeInt(c0857h.f9377l);
        A2.b.E(parcel, 4, c0857h.f9378m);
        A2.b.B(parcel, 5, c0857h.n);
        A2.b.G(parcel, 6, c0857h.f9379o, i5);
        A2.b.z(parcel, 7, c0857h.f9380p);
        A2.b.D(parcel, 8, c0857h.f9381q, i5);
        A2.b.G(parcel, 10, c0857h.f9382r, i5);
        A2.b.G(parcel, 11, c0857h.f9383s, i5);
        A2.b.M(parcel, 12, 4);
        parcel.writeInt(c0857h.f9384t ? 1 : 0);
        A2.b.M(parcel, 13, 4);
        parcel.writeInt(c0857h.f9385u);
        boolean z4 = c0857h.f9386v;
        A2.b.M(parcel, 14, 4);
        parcel.writeInt(z4 ? 1 : 0);
        A2.b.E(parcel, 15, c0857h.f9387w);
        A2.b.K(I, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f9425a) {
            case 0:
                int iH = y1.f.H(parcel);
                int iA = 0;
                boolean zU = false;
                boolean zU2 = false;
                IBinder iBinderZ = null;
                C0785b c0785b = null;
                while (parcel.dataPosition() < iH) {
                    int i5 = parcel.readInt();
                    char c2 = (char) i5;
                    if (c2 == 1) {
                        iA = y1.f.A(i5, parcel);
                    } else if (c2 == 2) {
                        iBinderZ = y1.f.z(i5, parcel);
                    } else if (c2 == 3) {
                        c0785b = (C0785b) y1.f.i(parcel, i5, C0785b.CREATOR);
                    } else if (c2 == 4) {
                        zU = y1.f.u(i5, parcel);
                    } else if (c2 != 5) {
                        y1.f.G(i5, parcel);
                    } else {
                        zU2 = y1.f.u(i5, parcel);
                    }
                }
                y1.f.n(iH, parcel);
                return new w(iA, iBinderZ, c0785b, zU, zU2);
            case 1:
                int iH2 = y1.f.H(parcel);
                int iA2 = 0;
                boolean zU3 = false;
                boolean zU4 = false;
                int iA3 = 0;
                int iA4 = 0;
                while (parcel.dataPosition() < iH2) {
                    int i6 = parcel.readInt();
                    char c5 = (char) i6;
                    if (c5 == 1) {
                        iA2 = y1.f.A(i6, parcel);
                    } else if (c5 == 2) {
                        zU3 = y1.f.u(i6, parcel);
                    } else if (c5 == 3) {
                        zU4 = y1.f.u(i6, parcel);
                    } else if (c5 == 4) {
                        iA3 = y1.f.A(i6, parcel);
                    } else if (c5 != 5) {
                        y1.f.G(i6, parcel);
                    } else {
                        iA4 = y1.f.A(i6, parcel);
                    }
                }
                y1.f.n(iH2, parcel);
                return new C0864o(iA2, zU3, zU4, iA3, iA4);
            case 2:
                int iH3 = y1.f.H(parcel);
                Bundle bundleG = null;
                C0856g c0856g = null;
                int iA5 = 0;
                C0787d[] c0787dArr = null;
                while (parcel.dataPosition() < iH3) {
                    int i7 = parcel.readInt();
                    char c6 = (char) i7;
                    if (c6 == 1) {
                        bundleG = y1.f.g(i7, parcel);
                    } else if (c6 == 2) {
                        c0787dArr = (C0787d[]) y1.f.l(parcel, i7, C0787d.CREATOR);
                    } else if (c6 == 3) {
                        iA5 = y1.f.A(i7, parcel);
                    } else if (c6 != 4) {
                        y1.f.G(i7, parcel);
                    } else {
                        c0856g = (C0856g) y1.f.i(parcel, i7, C0856g.CREATOR);
                    }
                }
                y1.f.n(iH3, parcel);
                L l5 = new L();
                l5.f9320j = bundleG;
                l5.f9321k = c0787dArr;
                l5.f9322l = iA5;
                l5.f9323m = c0856g;
                return l5;
            case 3:
                int iH4 = y1.f.H(parcel);
                C0864o c0864o = null;
                int[] iArrH = null;
                int[] iArrH2 = null;
                boolean zU5 = false;
                boolean zU6 = false;
                int iA6 = 0;
                while (parcel.dataPosition() < iH4) {
                    int i8 = parcel.readInt();
                    switch ((char) i8) {
                        case 1:
                            c0864o = (C0864o) y1.f.i(parcel, i8, C0864o.CREATOR);
                            break;
                        case 2:
                            zU5 = y1.f.u(i8, parcel);
                            break;
                        case 3:
                            zU6 = y1.f.u(i8, parcel);
                            break;
                        case 4:
                            iArrH = y1.f.h(i8, parcel);
                            break;
                        case 5:
                            iA6 = y1.f.A(i8, parcel);
                            break;
                        case 6:
                            iArrH2 = y1.f.h(i8, parcel);
                            break;
                        default:
                            y1.f.G(i8, parcel);
                            break;
                    }
                }
                y1.f.n(iH4, parcel);
                return new C0856g(c0864o, zU5, zU6, iArrH, iA6, iArrH2);
            case 4:
                int iH5 = y1.f.H(parcel);
                Scope[] scopeArr = C0857h.f9373x;
                Bundle bundle = new Bundle();
                C0787d[] c0787dArr2 = C0857h.f9374y;
                C0787d[] c0787dArr3 = c0787dArr2;
                String strJ = null;
                IBinder iBinderZ2 = null;
                Account account = null;
                String strJ2 = null;
                int iA7 = 0;
                int iA8 = 0;
                int iA9 = 0;
                boolean zU7 = false;
                int iA10 = 0;
                boolean zU8 = false;
                while (parcel.dataPosition() < iH5) {
                    int i9 = parcel.readInt();
                    switch ((char) i9) {
                        case 1:
                            iA7 = y1.f.A(i9, parcel);
                            break;
                        case 2:
                            iA8 = y1.f.A(i9, parcel);
                            break;
                        case 3:
                            iA9 = y1.f.A(i9, parcel);
                            break;
                        case 4:
                            strJ = y1.f.j(i9, parcel);
                            break;
                        case 5:
                            iBinderZ2 = y1.f.z(i9, parcel);
                            break;
                        case 6:
                            scopeArr = (Scope[]) y1.f.l(parcel, i9, Scope.CREATOR);
                            break;
                        case 7:
                            bundle = y1.f.g(i9, parcel);
                            break;
                        case '\b':
                            account = (Account) y1.f.i(parcel, i9, Account.CREATOR);
                            break;
                        case '\t':
                        default:
                            y1.f.G(i9, parcel);
                            break;
                        case '\n':
                            c0787dArr2 = (C0787d[]) y1.f.l(parcel, i9, C0787d.CREATOR);
                            break;
                        case 11:
                            c0787dArr3 = (C0787d[]) y1.f.l(parcel, i9, C0787d.CREATOR);
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            zU7 = y1.f.u(i9, parcel);
                            break;
                        case o1.f.ERROR /* 13 */:
                            iA10 = y1.f.A(i9, parcel);
                            break;
                        case o1.f.INTERRUPTED /* 14 */:
                            zU8 = y1.f.u(i9, parcel);
                            break;
                        case 15:
                            strJ2 = y1.f.j(i9, parcel);
                            break;
                    }
                }
                y1.f.n(iH5, parcel);
                return new C0857h(iA7, iA8, iA9, strJ, iBinderZ2, scopeArr, bundle, account, c0787dArr2, c0787dArr3, zU7, iA10, zU8, strJ2);
            case 5:
                return new u0.k(parcel);
            default:
                return new ParcelImpl(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i5) {
        switch (this.f9425a) {
            case 0:
                return new w[i5];
            case 1:
                return new C0864o[i5];
            case 2:
                return new L[i5];
            case 3:
                return new C0856g[i5];
            case 4:
                return new C0857h[i5];
            case 5:
                return new u0.k[i5];
            default:
                return new ParcelImpl[i5];
        }
    }
}
