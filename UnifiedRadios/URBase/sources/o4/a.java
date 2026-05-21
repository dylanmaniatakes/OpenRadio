package o4;

import android.os.Looper;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import k4.d;
import l4.g;
import org.osmdroid.views.MapView;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: i, reason: collision with root package name */
    public static int f9008i;

    /* renamed from: j, reason: collision with root package name */
    public static int f9009j;

    /* renamed from: k, reason: collision with root package name */
    public static int f9010k;

    /* renamed from: l, reason: collision with root package name */
    public static int f9011l;

    /* renamed from: a, reason: collision with root package name */
    public View f9012a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f9013b;

    /* renamed from: c, reason: collision with root package name */
    public MapView f9014c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9015d;

    /* renamed from: e, reason: collision with root package name */
    public d f9016e;

    /* renamed from: f, reason: collision with root package name */
    public int f9017f;
    public int g;
    public m4.d h;

    public final void a() {
        if (this.f9013b) {
            this.f9013b = false;
            ((ViewGroup) this.f9012a.getParent()).removeView(this.f9012a);
            c();
        }
    }

    public final void b() {
        if (this.f9013b) {
            try {
                this.f9014c.updateViewLayout(this.f9012a, new g(this.f9016e, this.f9017f, this.g));
            } catch (Exception e5) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    throw e5;
                }
            }
        }
    }

    public final void c() {
        this.h = null;
    }

    public final void d(Object obj) {
        e(obj);
        this.h = (m4.d) obj;
        View view = this.f9012a;
        if (view == null) {
            Log.w("OsmDroid", "Error trapped, MarkerInfoWindow.open, mView is null!");
            return;
        }
        ImageView imageView = (ImageView) view.findViewById(f9011l);
        this.h.getClass();
        imageView.setVisibility(8);
    }

    public final void e(Object obj) {
        m4.g gVar = (m4.g) obj;
        String str = gVar.f8675b;
        if (str == null) {
            str = "";
        }
        View view = this.f9012a;
        if (view == null) {
            Log.w("OsmDroid", "Error trapped, BasicInfoWindow.open, mView is null!");
            return;
        }
        TextView textView = (TextView) view.findViewById(f9008i);
        if (textView != null) {
            textView.setText(str);
        }
        String str2 = gVar.f8676c;
        ((TextView) this.f9012a.findViewById(f9009j)).setText(Html.fromHtml(str2 != null ? str2 : ""));
        ((TextView) this.f9012a.findViewById(f9010k)).setVisibility(8);
    }

    public final void f(Object obj, d dVar, int i5, int i6) {
        View view;
        a();
        this.f9015d = obj;
        this.f9016e = dVar;
        this.f9017f = i5;
        this.g = i6;
        d(obj);
        g gVar = new g(this.f9016e, this.f9017f, this.g);
        MapView mapView = this.f9014c;
        if (mapView != null && (view = this.f9012a) != null) {
            mapView.addView(view, gVar);
            this.f9013b = true;
            return;
        }
        StringBuilder sb = new StringBuilder("Error trapped, InfoWindow.open mMapView: ");
        sb.append(this.f9014c == null ? "null" : "ok");
        sb.append(" mView: ");
        sb.append(this.f9012a == null ? "null" : "ok");
        Log.w("OsmDroid", sb.toString());
    }
}
