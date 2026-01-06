package d2;

import android.content.Context;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import com.unified.ur1.R;

/* renamed from: d2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0428a {

    /* renamed from: f, reason: collision with root package name */
    public static final int f6107f = (int) Math.round(5.1000000000000005d);

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6108a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6109b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6110c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6111d;

    /* renamed from: e, reason: collision with root package name */
    public final float f6112e;

    public C0428a(Context context) {
        boolean zG = AbstractC0399v1.g(context, R.attr.elevationOverlayEnabled, false);
        int iE = AbstractC0296a2.e(context, R.attr.elevationOverlayColor, 0);
        int iE2 = AbstractC0296a2.e(context, R.attr.elevationOverlayAccentColor, 0);
        int iE3 = AbstractC0296a2.e(context, R.attr.colorSurface, 0);
        float f5 = context.getResources().getDisplayMetrics().density;
        this.f6108a = zG;
        this.f6109b = iE;
        this.f6110c = iE2;
        this.f6111d = iE3;
        this.f6112e = f5;
    }
}
