package r1;

import android.os.Parcel;

/* renamed from: r1.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0874b extends RuntimeException {
    public C0874b(String str, Parcel parcel) {
        super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
    }
}
