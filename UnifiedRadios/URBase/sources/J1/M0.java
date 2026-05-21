package J1;

import android.content.Context;
import android.os.Bundle;

/* loaded from: classes.dex */
public final class M0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f894a;

    /* renamed from: b, reason: collision with root package name */
    public final String f895b;

    /* renamed from: c, reason: collision with root package name */
    public final String f896c;

    /* renamed from: d, reason: collision with root package name */
    public final String f897d;

    /* renamed from: e, reason: collision with root package name */
    public final Boolean f898e;

    /* renamed from: f, reason: collision with root package name */
    public final long f899f;
    public final com.google.android.gms.internal.measurement.V g;
    public final boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final Long f900i;

    /* renamed from: j, reason: collision with root package name */
    public final String f901j;

    public M0(Context context, com.google.android.gms.internal.measurement.V v4, Long l5) {
        this.h = true;
        q1.E.i(context);
        Context applicationContext = context.getApplicationContext();
        q1.E.i(applicationContext);
        this.f894a = applicationContext;
        this.f900i = l5;
        if (v4 != null) {
            this.g = v4;
            this.f895b = v4.f4783o;
            this.f896c = v4.n;
            this.f897d = v4.f4782m;
            this.h = v4.f4781l;
            this.f899f = v4.f4780k;
            this.f901j = v4.f4785q;
            Bundle bundle = v4.f4784p;
            if (bundle != null) {
                this.f898e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
