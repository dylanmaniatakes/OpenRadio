package D1;

import android.app.PendingIntent;
import com.google.android.gms.location.GeofencingApi;
import com.google.android.gms.location.GeofencingRequest;
import java.util.List;

/* renamed from: D1.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0020s implements GeofencingApi {
    @Override // com.google.android.gms.location.GeofencingApi
    public final o1.l addGeofences(o1.k kVar, GeofencingRequest geofencingRequest, PendingIntent pendingIntent) {
        new r(kVar, geofencingRequest, pendingIntent);
        throw null;
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public final o1.l removeGeofences(o1.k kVar, PendingIntent pendingIntent) {
        new r(kVar, pendingIntent);
        throw null;
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public final o1.l addGeofences(o1.k kVar, List list, PendingIntent pendingIntent) {
        GeofencingRequest.Builder builder = new GeofencingRequest.Builder();
        builder.addGeofences(list);
        builder.setInitialTrigger(5);
        new r(kVar, builder.build(), pendingIntent);
        throw null;
    }

    @Override // com.google.android.gms.location.GeofencingApi
    public final o1.l removeGeofences(o1.k kVar, List list) {
        new r(kVar, list);
        throw null;
    }
}
