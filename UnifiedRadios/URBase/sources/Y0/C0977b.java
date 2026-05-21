package y0;

import android.os.Parcel;
import android.util.SparseIntArray;
import com.unified.ur1.SatelliteTracker.h;

/* renamed from: y0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0977b extends AbstractC0976a {

    /* renamed from: d, reason: collision with root package name */
    public final SparseIntArray f10461d;

    /* renamed from: e, reason: collision with root package name */
    public final Parcel f10462e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10463f;
    public final int g;
    public final String h;

    /* renamed from: i, reason: collision with root package name */
    public int f10464i;

    /* renamed from: j, reason: collision with root package name */
    public int f10465j;

    /* renamed from: k, reason: collision with root package name */
    public int f10466k;

    public C0977b(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new q.b(), new q.b(), new q.b());
    }

    @Override // y0.AbstractC0976a
    public final C0977b a() {
        Parcel parcel = this.f10462e;
        int iDataPosition = parcel.dataPosition();
        int i5 = this.f10465j;
        if (i5 == this.f10463f) {
            i5 = this.g;
        }
        return new C0977b(parcel, iDataPosition, i5, h.e(new StringBuilder(), this.h, "  "), this.f10458a, this.f10459b, this.f10460c);
    }

    @Override // y0.AbstractC0976a
    public final boolean e(int i5) {
        while (this.f10465j < this.g) {
            int i6 = this.f10466k;
            if (i6 == i5) {
                return true;
            }
            if (String.valueOf(i6).compareTo(String.valueOf(i5)) > 0) {
                return false;
            }
            int i7 = this.f10465j;
            Parcel parcel = this.f10462e;
            parcel.setDataPosition(i7);
            int i8 = parcel.readInt();
            this.f10466k = parcel.readInt();
            this.f10465j += i8;
        }
        return this.f10466k == i5;
    }

    @Override // y0.AbstractC0976a
    public final void i(int i5) {
        int i6 = this.f10464i;
        SparseIntArray sparseIntArray = this.f10461d;
        Parcel parcel = this.f10462e;
        if (i6 >= 0) {
            int i7 = sparseIntArray.get(i6);
            int iDataPosition = parcel.dataPosition();
            parcel.setDataPosition(i7);
            parcel.writeInt(iDataPosition - i7);
            parcel.setDataPosition(iDataPosition);
        }
        this.f10464i = i5;
        sparseIntArray.put(i5, parcel.dataPosition());
        parcel.writeInt(0);
        parcel.writeInt(i5);
    }

    public C0977b(Parcel parcel, int i5, int i6, String str, q.b bVar, q.b bVar2, q.b bVar3) {
        super(bVar, bVar2, bVar3);
        this.f10461d = new SparseIntArray();
        this.f10464i = -1;
        this.f10466k = -1;
        this.f10462e = parcel;
        this.f10463f = i5;
        this.g = i6;
        this.f10465j = i5;
        this.h = str;
    }
}
