package O;

import android.content.ClipData;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Locale;

/* renamed from: O.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0160e implements InterfaceC0158d, InterfaceC0162f {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1923c = 0;

    /* renamed from: d, reason: collision with root package name */
    public ClipData f1924d;

    /* renamed from: e, reason: collision with root package name */
    public int f1925e;

    /* renamed from: f, reason: collision with root package name */
    public int f1926f;
    public Uri g;
    public Bundle h;

    public /* synthetic */ C0160e() {
    }

    @Override // O.InterfaceC0162f
    public ClipData a() {
        return this.f1924d;
    }

    @Override // O.InterfaceC0158d
    public C0164g c() {
        return new C0164g(new C0160e(this));
    }

    @Override // O.InterfaceC0158d
    public void g(Bundle bundle) {
        this.h = bundle;
    }

    @Override // O.InterfaceC0162f
    public int i() {
        return this.f1926f;
    }

    @Override // O.InterfaceC0162f
    public ContentInfo m() {
        return null;
    }

    @Override // O.InterfaceC0162f
    public int n() {
        return this.f1925e;
    }

    @Override // O.InterfaceC0158d
    public void o(Uri uri) {
        this.g = uri;
    }

    @Override // O.InterfaceC0158d
    public void q(int i5) {
        this.f1926f = i5;
    }

    public String toString() {
        String str;
        switch (this.f1923c) {
            case 1:
                StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
                sb.append(this.f1924d.getDescription());
                sb.append(", source=");
                int i5 = this.f1925e;
                sb.append(i5 != 0 ? i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? i5 != 5 ? String.valueOf(i5) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP");
                sb.append(", flags=");
                int i6 = this.f1926f;
                sb.append((i6 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i6));
                Uri uri = this.g;
                if (uri == null) {
                    str = "";
                } else {
                    str = ", hasLinkUri(" + uri.toString().length() + ")";
                }
                sb.append(str);
                return com.unified.ur1.SatelliteTracker.h.e(sb, this.h != null ? ", hasExtras" : "", "}");
            default:
                return super.toString();
        }
    }

    public C0160e(C0160e c0160e) {
        ClipData clipData = c0160e.f1924d;
        clipData.getClass();
        this.f1924d = clipData;
        int i5 = c0160e.f1925e;
        if (i5 < 0) {
            Locale locale = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too low)");
        }
        if (i5 > 5) {
            Locale locale2 = Locale.US;
            throw new IllegalArgumentException("source is out of range of [0, 5] (too high)");
        }
        this.f1925e = i5;
        int i6 = c0160e.f1926f;
        if ((i6 & 1) == i6) {
            this.f1926f = i6;
            this.g = c0160e.g;
            this.h = c0160e.h;
        } else {
            throw new IllegalArgumentException("Requested flags 0x" + Integer.toHexString(i6) + ", but only 0x" + Integer.toHexString(1) + " are allowed");
        }
    }
}
