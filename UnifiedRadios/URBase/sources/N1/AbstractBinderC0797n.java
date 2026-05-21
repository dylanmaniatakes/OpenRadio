package n1;

import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import q1.E;
import q1.z;
import x1.BinderC0963d;
import x1.InterfaceC0961b;

/* renamed from: n1.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractBinderC0797n extends A1.b implements z {

    /* renamed from: d, reason: collision with root package name */
    public final int f8760d;

    public AbstractBinderC0797n(byte[] bArr) {
        super("com.google.android.gms.common.internal.ICertData", 1);
        E.a(bArr.length == 25);
        this.f8760d = Arrays.hashCode(bArr);
    }

    public static byte[] J(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e5) {
            throw new AssertionError(e5);
        }
    }

    @Override // A1.b
    public final boolean I(int i5, Parcel parcel, Parcel parcel2) {
        if (i5 == 1) {
            InterfaceC0961b interfaceC0961bZzd = zzd();
            parcel2.writeNoException();
            C1.a.c(parcel2, interfaceC0961bZzd);
        } else {
            if (i5 != 2) {
                return false;
            }
            parcel2.writeNoException();
            parcel2.writeInt(this.f8760d);
        }
        return true;
    }

    public abstract byte[] K();

    public final boolean equals(Object obj) {
        InterfaceC0961b interfaceC0961bZzd;
        if (obj != null && (obj instanceof z)) {
            try {
                z zVar = (z) obj;
                if (zVar.zzc() == this.f8760d && (interfaceC0961bZzd = zVar.zzd()) != null) {
                    return Arrays.equals(K(), (byte[]) BinderC0963d.K(interfaceC0961bZzd));
                }
                return false;
            } catch (RemoteException e5) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e5);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f8760d;
    }

    @Override // q1.z
    public final int zzc() {
        return this.f8760d;
    }

    @Override // q1.z
    public final InterfaceC0961b zzd() {
        return new BinderC0963d(K());
    }
}
