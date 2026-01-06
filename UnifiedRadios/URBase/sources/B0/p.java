package B0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.C0226v;
import androidx.recyclerview.widget.g0;
import g2.C0537a;
import g2.C0542f;
import k.Q0;
import k.d1;
import o2.C0811c;
import org.conscrypt.FileClientSessionCache;
import r2.C0876a;
import s2.w;

/* loaded from: classes.dex */
public final class p implements Parcelable.ClassLoaderCreator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f113a;

    public /* synthetic */ p(int i5) {
        this.f113a = i5;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f113a) {
            case 0:
                q qVar = new q(parcel, classLoader);
                qVar.f114j = parcel.readInt();
                qVar.f115k = parcel.readInt();
                qVar.f116l = parcel.readParcelable(classLoader);
                return qVar;
            case 1:
                if (parcel.readParcelable(classLoader) == null) {
                    return V.b.f2506k;
                }
                throw new IllegalStateException("superState must be null");
            case 2:
                return new V1.c(parcel, classLoader);
            case 3:
                return new W1.b(parcel, classLoader);
            case 4:
                return new C0226v(parcel, classLoader);
            case 5:
                return new g0(parcel, classLoader);
            case 6:
                return new C0537a(parcel, classLoader);
            case 7:
                return new C0542f(parcel, classLoader);
            case 8:
                return new i2.j(parcel, classLoader);
            case 9:
                return new Q0(parcel, classLoader);
            case 10:
                return new d1(parcel, classLoader);
            case 11:
                return new C0811c(parcel, classLoader);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new C0876a(parcel, classLoader);
            case o1.f.ERROR /* 13 */:
                return new w(parcel, classLoader);
            default:
                return new z.f(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i5) {
        switch (this.f113a) {
            case 0:
                return new q[i5];
            case 1:
                return new V.b[i5];
            case 2:
                return new V1.c[i5];
            case 3:
                return new W1.b[i5];
            case 4:
                return new C0226v[i5];
            case 5:
                return new g0[i5];
            case 6:
                return new C0537a[i5];
            case 7:
                return new C0542f[i5];
            case 8:
                return new i2.j[i5];
            case 9:
                return new Q0[i5];
            case 10:
                return new d1[i5];
            case 11:
                return new C0811c[i5];
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new C0876a[i5];
            case o1.f.ERROR /* 13 */:
                return new w[i5];
            default:
                return new z.f[i5];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f113a) {
            case 0:
                q qVar = new q(parcel, null);
                qVar.f114j = parcel.readInt();
                qVar.f115k = parcel.readInt();
                qVar.f116l = parcel.readParcelable(null);
                return qVar;
            case 1:
                if (parcel.readParcelable(null) == null) {
                    return V.b.f2506k;
                }
                throw new IllegalStateException("superState must be null");
            case 2:
                return new V1.c(parcel, (ClassLoader) null);
            case 3:
                return new W1.b(parcel, null);
            case 4:
                return new C0226v(parcel, null);
            case 5:
                return new g0(parcel, null);
            case 6:
                return new C0537a(parcel, null);
            case 7:
                return new C0542f(parcel, null);
            case 8:
                return new i2.j(parcel, null);
            case 9:
                return new Q0(parcel, null);
            case 10:
                return new d1(parcel, null);
            case 11:
                return new C0811c(parcel, (ClassLoader) null);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new C0876a(parcel, null);
            case o1.f.ERROR /* 13 */:
                return new w(parcel, null);
            default:
                return new z.f(parcel, null);
        }
    }
}
