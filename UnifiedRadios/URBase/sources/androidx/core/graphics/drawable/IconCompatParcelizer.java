package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.charset.Charset;
import o1.f;
import y0.AbstractC0976a;
import y0.C0977b;

/* loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC0976a abstractC0976a) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.f3542a = abstractC0976a.f(iconCompat.f3542a, 1);
        byte[] bArr = iconCompat.f3544c;
        if (abstractC0976a.e(2)) {
            Parcel parcel = ((C0977b) abstractC0976a).f10462e;
            int i5 = parcel.readInt();
            if (i5 < 0) {
                bArr = null;
            } else {
                byte[] bArr2 = new byte[i5];
                parcel.readByteArray(bArr2);
                bArr = bArr2;
            }
        }
        iconCompat.f3544c = bArr;
        iconCompat.f3545d = abstractC0976a.g(iconCompat.f3545d, 3);
        iconCompat.f3546e = abstractC0976a.f(iconCompat.f3546e, 4);
        iconCompat.f3547f = abstractC0976a.f(iconCompat.f3547f, 5);
        iconCompat.g = (ColorStateList) abstractC0976a.g(iconCompat.g, 6);
        String string = iconCompat.f3548i;
        if (abstractC0976a.e(7)) {
            string = ((C0977b) abstractC0976a).f10462e.readString();
        }
        iconCompat.f3548i = string;
        String string2 = iconCompat.f3549j;
        if (abstractC0976a.e(8)) {
            string2 = ((C0977b) abstractC0976a).f10462e.readString();
        }
        iconCompat.f3549j = string2;
        iconCompat.h = PorterDuff.Mode.valueOf(iconCompat.f3548i);
        switch (iconCompat.f3542a) {
            case f.SUCCESS_CACHE /* -1 */:
                Parcelable parcelable = iconCompat.f3545d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.f3543b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.f3545d;
                if (parcelable2 != null) {
                    iconCompat.f3543b = parcelable2;
                } else {
                    byte[] bArr3 = iconCompat.f3544c;
                    iconCompat.f3543b = bArr3;
                    iconCompat.f3542a = 3;
                    iconCompat.f3546e = 0;
                    iconCompat.f3547f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.f3544c, Charset.forName("UTF-16"));
                iconCompat.f3543b = str;
                if (iconCompat.f3542a == 2 && iconCompat.f3549j == null) {
                    iconCompat.f3549j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.f3543b = iconCompat.f3544c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC0976a abstractC0976a) {
        abstractC0976a.getClass();
        iconCompat.f3548i = iconCompat.h.name();
        switch (iconCompat.f3542a) {
            case f.SUCCESS_CACHE /* -1 */:
                iconCompat.f3545d = (Parcelable) iconCompat.f3543b;
                break;
            case 1:
            case 5:
                iconCompat.f3545d = (Parcelable) iconCompat.f3543b;
                break;
            case 2:
                iconCompat.f3544c = ((String) iconCompat.f3543b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.f3544c = (byte[]) iconCompat.f3543b;
                break;
            case 4:
            case 6:
                iconCompat.f3544c = iconCompat.f3543b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i5 = iconCompat.f3542a;
        if (-1 != i5) {
            abstractC0976a.j(i5, 1);
        }
        byte[] bArr = iconCompat.f3544c;
        if (bArr != null) {
            abstractC0976a.i(2);
            int length = bArr.length;
            Parcel parcel = ((C0977b) abstractC0976a).f10462e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.f3545d;
        if (parcelable != null) {
            abstractC0976a.k(parcelable, 3);
        }
        int i6 = iconCompat.f3546e;
        if (i6 != 0) {
            abstractC0976a.j(i6, 4);
        }
        int i7 = iconCompat.f3547f;
        if (i7 != 0) {
            abstractC0976a.j(i7, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            abstractC0976a.k(colorStateList, 6);
        }
        String str = iconCompat.f3548i;
        if (str != null) {
            abstractC0976a.i(7);
            ((C0977b) abstractC0976a).f10462e.writeString(str);
        }
        String str2 = iconCompat.f3549j;
        if (str2 != null) {
            abstractC0976a.i(8);
            ((C0977b) abstractC0976a).f10462e.writeString(str2);
        }
    }
}
