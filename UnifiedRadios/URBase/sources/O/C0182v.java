package O;

import android.view.View;
import java.net.HttpURLConnection;

/* renamed from: O.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0182v {

    /* renamed from: a, reason: collision with root package name */
    public int f1974a;

    /* renamed from: b, reason: collision with root package name */
    public int f1975b;

    public C0182v(int i5, int i6) {
        this.f1974a = i5;
        this.f1975b = i6;
    }

    public static long b(HttpURLConnection httpURLConnection, long j5) throws NumberFormatException {
        Long lValueOf;
        long jLongValue;
        String headerField = httpURLConnection.getHeaderField("Expires");
        String headerField2 = httpURLConnection.getHeaderField("Cache-Control");
        e4.a.g().getClass();
        e4.a.g().getClass();
        Long lValueOf2 = null;
        if (headerField2 == null || headerField2.length() <= 0) {
            lValueOf = null;
        } else {
            try {
                for (String str : headerField2.split(", ")) {
                    if (str.indexOf("max-age=") == 0) {
                        lValueOf = Long.valueOf(str.substring(8));
                        break;
                    }
                }
            } catch (Exception unused) {
                e4.a.g().getClass();
            }
            lValueOf = null;
        }
        if (lValueOf != null) {
            jLongValue = (lValueOf.longValue() * 1000) + j5;
        } else {
            if (headerField != null && headerField.length() > 0) {
                try {
                    lValueOf2 = Long.valueOf(e4.a.g().f6230j.parse(headerField).getTime());
                } catch (Exception unused2) {
                    e4.a.g().getClass();
                }
            }
            jLongValue = lValueOf2 != null ? lValueOf2.longValue() : 604800000 + j5;
        }
        e4.a.g().getClass();
        return jLongValue;
    }

    public boolean a(String str) {
        if ((this.f1975b & 4) == 0) {
            return true;
        }
        return (str == null || str.trim().length() <= 0 || str.equals("osmdroid")) ? false : true;
    }

    public boolean c() {
        return (this.f1975b & 8) != 0;
    }

    public void d(androidx.recyclerview.widget.n0 n0Var) {
        View view = n0Var.itemView;
        this.f1974a = view.getLeft();
        this.f1975b = view.getTop();
        view.getRight();
        view.getBottom();
    }
}
