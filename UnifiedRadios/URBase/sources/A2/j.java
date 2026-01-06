package A2;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import q1.E;
import u1.AbstractC0908c;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final String f38a;

    /* renamed from: b, reason: collision with root package name */
    public final String f39b;

    /* renamed from: c, reason: collision with root package name */
    public final String f40c;

    /* renamed from: d, reason: collision with root package name */
    public final String f41d;

    /* renamed from: e, reason: collision with root package name */
    public final String f42e;

    /* renamed from: f, reason: collision with root package name */
    public final String f43f;
    public final String g;

    public j(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i5 = AbstractC0908c.f9925a;
        E.k("ApplicationId must be set.", true ^ (str == null || str.trim().isEmpty()));
        this.f39b = str;
        this.f38a = str2;
        this.f40c = str3;
        this.f41d = str4;
        this.f42e = str5;
        this.f43f = str6;
        this.g = str7;
    }

    public static j a(Context context) {
        L0.e eVar = new L0.e(context);
        String strL = eVar.l("google_app_id");
        if (TextUtils.isEmpty(strL)) {
            return null;
        }
        return new j(strL, eVar.l("google_api_key"), eVar.l("firebase_database_url"), eVar.l("ga_trackingId"), eVar.l("gcm_defaultSenderId"), eVar.l("google_storage_bucket"), eVar.l("project_id"));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return E.l(this.f39b, jVar.f39b) && E.l(this.f38a, jVar.f38a) && E.l(this.f40c, jVar.f40c) && E.l(this.f41d, jVar.f41d) && E.l(this.f42e, jVar.f42e) && E.l(this.f43f, jVar.f43f) && E.l(this.g, jVar.g);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f39b, this.f38a, this.f40c, this.f41d, this.f42e, this.f43f, this.g});
    }

    public final String toString() {
        L0.c cVar = new L0.c(this);
        cVar.b(this.f39b, "applicationId");
        cVar.b(this.f38a, "apiKey");
        cVar.b(this.f40c, "databaseUrl");
        cVar.b(this.f42e, "gcmSenderId");
        cVar.b(this.f43f, "storageBucket");
        cVar.b(this.g, "projectId");
        return cVar.toString();
    }
}
