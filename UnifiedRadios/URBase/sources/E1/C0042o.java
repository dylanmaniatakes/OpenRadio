package E1;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.maps.model.Tile;

/* renamed from: E1.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0042o extends AbstractC0028a implements InterfaceC0044q {
    @Override // E1.InterfaceC0044q
    public final Tile zzb(int i5, int i6, int i7) throws RemoteException {
        Parcel parcelZza = zza();
        parcelZza.writeInt(i5);
        parcelZza.writeInt(i6);
        parcelZza.writeInt(i7);
        Parcel parcelZzJ = zzJ(1, parcelZza);
        Tile tile = (Tile) B.a(parcelZzJ, Tile.CREATOR);
        parcelZzJ.recycle();
        return tile;
    }
}
