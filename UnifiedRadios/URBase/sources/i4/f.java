package i4;

import O.C0182v;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;
import org.conscrypt.PSKKeyManager;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static final e f7375a;

    /* renamed from: b, reason: collision with root package name */
    public static final e f7376b;

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f7377c;

    static {
        e eVar = new e("Mapnik", 0, 19, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png", new String[]{"https://tile.openstreetmap.org/"}, new C0182v(2, 15));
        f7375a = eVar;
        e eVar2 = new e("Wikimedia", 1, 19, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png", new String[]{"https://maps.wikimedia.org/osm-intl/"}, new C0182v(1, 15));
        e eVar3 = new e("OSMPublicTransport", 0, 17, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png", new String[]{"http://openptmap.org/tiles/"}, 2);
        f7376b = eVar;
        C0182v c0182v = new C0182v(0, 0);
        new Random();
        int i5 = c0182v.f1974a;
        if (i5 > 0) {
            new Semaphore(i5, true);
        }
        C0182v c0182v2 = new C0182v(0, 0);
        new Random();
        int i6 = c0182v2.f1974a;
        if (i6 > 0) {
            new Semaphore(i6, true);
        }
        C0182v c0182v3 = new C0182v(0, 0);
        new Random();
        int i7 = c0182v3.f1974a;
        if (i7 > 0) {
            new Semaphore(i7, true);
        }
        C0182v c0182v4 = new C0182v(0, 0);
        new Random();
        int i8 = c0182v4.f1974a;
        if (i8 > 0) {
            new Semaphore(i8, true);
        }
        C0182v c0182v5 = new C0182v(0, 0);
        new Random();
        int i9 = c0182v5.f1974a;
        if (i9 > 0) {
            new Semaphore(i9, true);
        }
        e eVar4 = new e("HikeBikeMap", 0, 18, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png", new String[]{"https://tiles.wmflabs.org/hikebike/"}, 2);
        C0182v c0182v6 = new C0182v(0, 0);
        new Random();
        int i10 = c0182v6.f1974a;
        if (i10 > 0) {
            new Semaphore(i10, true);
        }
        e eVar5 = new e("USGS National Map Topo", 0, 15, PSKKeyManager.MAX_KEY_LENGTH_BYTES, "", new String[]{"https://basemap.nationalmap.gov/arcgis/rest/services/USGSTopo/MapServer/tile/"}, 0);
        e eVar6 = new e("USGS National Map Sat", 0, 15, PSKKeyManager.MAX_KEY_LENGTH_BYTES, "", new String[]{"https://basemap.nationalmap.gov/arcgis/rest/services/USGSImageryTopo/MapServer/tile/"}, 1);
        e eVar7 = new e("ChartbundleWAC", 4, 12, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png?type=google", new String[]{"https://wms.chartbundle.com/tms/v1.0/wac/"}, 2);
        e eVar8 = new e("ChartbundleENRH", 4, 12, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png?type=google", new String[]{"https://wms.chartbundle.com/tms/v1.0/enrh/", "chartbundle.com"}, 2);
        e eVar9 = new e("ChartbundleENRL", 4, 12, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png?type=google", new String[]{"https://wms.chartbundle.com/tms/v1.0/enrl/", "chartbundle.com"}, 2);
        e eVar10 = new e("OpenTopoMap", 0, 17, PSKKeyManager.MAX_KEY_LENGTH_BYTES, ".png", new String[]{"https://a.tile.opentopomap.org/", "https://b.tile.opentopomap.org/", "https://c.tile.opentopomap.org/"}, 2);
        ArrayList arrayList = new ArrayList();
        f7377c = arrayList;
        arrayList.add(eVar);
        arrayList.add(eVar2);
        arrayList.add(eVar3);
        arrayList.add(eVar4);
        arrayList.add(eVar5);
        arrayList.add(eVar6);
        arrayList.add(eVar7);
        arrayList.add(eVar8);
        arrayList.add(eVar9);
        arrayList.add(eVar10);
    }
}
