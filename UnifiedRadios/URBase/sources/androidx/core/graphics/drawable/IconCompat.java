package androidx.core.graphics.drawable;

import F.d;
import F.f;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Parcelable;
import androidx.versionedparcelable.CustomVersionedParcelable;

/* loaded from: classes.dex */
public class IconCompat extends CustomVersionedParcelable {

    /* renamed from: k, reason: collision with root package name */
    public static final PorterDuff.Mode f3541k = PorterDuff.Mode.SRC_IN;

    /* renamed from: a, reason: collision with root package name */
    public int f3542a;

    /* renamed from: b, reason: collision with root package name */
    public Object f3543b;

    /* renamed from: c, reason: collision with root package name */
    public byte[] f3544c;

    /* renamed from: d, reason: collision with root package name */
    public Parcelable f3545d;

    /* renamed from: e, reason: collision with root package name */
    public int f3546e;

    /* renamed from: f, reason: collision with root package name */
    public int f3547f;
    public ColorStateList g;
    public PorterDuff.Mode h;

    /* renamed from: i, reason: collision with root package name */
    public String f3548i;

    /* renamed from: j, reason: collision with root package name */
    public String f3549j;

    public IconCompat() {
        this.f3542a = -1;
        this.f3544c = null;
        this.f3545d = null;
        this.f3546e = 0;
        this.f3547f = 0;
        this.g = null;
        this.h = f3541k;
        this.f3548i = null;
    }

    public static IconCompat a(int i5) {
        if (i5 == 0) {
            throw new IllegalArgumentException("Drawable resource ID must not be 0");
        }
        IconCompat iconCompat = new IconCompat(2);
        iconCompat.f3546e = i5;
        iconCompat.f3543b = "";
        iconCompat.f3549j = "";
        return iconCompat;
    }

    public final int b() {
        int i5 = this.f3542a;
        if (i5 == -1) {
            return f.a(this.f3543b);
        }
        if (i5 == 2) {
            return this.f3546e;
        }
        throw new IllegalStateException("called getResId() on " + this);
    }

    public final Uri c() {
        int i5 = this.f3542a;
        if (i5 == -1) {
            return d.a(this.f3543b);
        }
        if (i5 == 4 || i5 == 6) {
            return Uri.parse((String) this.f3543b);
        }
        throw new IllegalStateException("called getUri() on " + this);
    }

    public final String toString() {
        String str;
        if (this.f3542a == -1) {
            return String.valueOf(this.f3543b);
        }
        StringBuilder sb = new StringBuilder("Icon(typ=");
        switch (this.f3542a) {
            case 1:
                str = "BITMAP";
                break;
            case 2:
                str = "RESOURCE";
                break;
            case 3:
                str = "DATA";
                break;
            case 4:
                str = "URI";
                break;
            case 5:
                str = "BITMAP_MASKABLE";
                break;
            case 6:
                str = "URI_MASKABLE";
                break;
            default:
                str = "UNKNOWN";
                break;
        }
        sb.append(str);
        switch (this.f3542a) {
            case 1:
            case 5:
                sb.append(" size=");
                sb.append(((Bitmap) this.f3543b).getWidth());
                sb.append("x");
                sb.append(((Bitmap) this.f3543b).getHeight());
                break;
            case 2:
                sb.append(" pkg=");
                sb.append(this.f3549j);
                sb.append(" id=");
                sb.append(String.format("0x%08x", Integer.valueOf(b())));
                break;
            case 3:
                sb.append(" len=");
                sb.append(this.f3546e);
                if (this.f3547f != 0) {
                    sb.append(" off=");
                    sb.append(this.f3547f);
                    break;
                }
                break;
            case 4:
            case 6:
                sb.append(" uri=");
                sb.append(this.f3543b);
                break;
        }
        if (this.g != null) {
            sb.append(" tint=");
            sb.append(this.g);
        }
        if (this.h != f3541k) {
            sb.append(" mode=");
            sb.append(this.h);
        }
        sb.append(")");
        return sb.toString();
    }

    public IconCompat(int i5) {
        this.f3544c = null;
        this.f3545d = null;
        this.f3546e = 0;
        this.f3547f = 0;
        this.g = null;
        this.h = f3541k;
        this.f3548i = null;
        this.f3542a = i5;
    }
}
