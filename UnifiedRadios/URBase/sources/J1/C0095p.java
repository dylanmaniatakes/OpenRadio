package J1;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Objects;

/* renamed from: J1.p, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0095p {

    /* renamed from: f, reason: collision with root package name */
    public static final C0095p f1336f = new C0095p((Boolean) null, 100, (Boolean) null, (String) null);

    /* renamed from: a, reason: collision with root package name */
    public final int f1337a;

    /* renamed from: b, reason: collision with root package name */
    public final String f1338b;

    /* renamed from: c, reason: collision with root package name */
    public final Boolean f1339c;

    /* renamed from: d, reason: collision with root package name */
    public final String f1340d;

    /* renamed from: e, reason: collision with root package name */
    public final EnumMap f1341e;

    public C0095p(Boolean bool, int i5, Boolean bool2, String str) {
        EnumMap enumMap = new EnumMap(J0.class);
        this.f1341e = enumMap;
        enumMap.put((EnumMap) J0.AD_USER_DATA, (J0) (bool == null ? H0.UNINITIALIZED : bool.booleanValue() ? H0.GRANTED : H0.DENIED));
        this.f1337a = i5;
        this.f1338b = e();
        this.f1339c = bool2;
        this.f1340d = str;
    }

    public static C0095p a(int i5, Bundle bundle) {
        if (bundle == null) {
            return new C0095p((Boolean) null, i5, (Boolean) null, (String) null);
        }
        EnumMap enumMap = new EnumMap(J0.class);
        for (J0 j02 : I0.DMA.f868j) {
            enumMap.put((EnumMap) j02, (J0) K0.b(bundle.getString(j02.f876j)));
        }
        return new C0095p(enumMap, i5, bundle.containsKey("is_dma_region") ? Boolean.valueOf(bundle.getString("is_dma_region")) : null, bundle.getString("cps_display_str"));
    }

    public static C0095p b(String str) throws NumberFormatException {
        if (str == null || str.length() <= 0) {
            return f1336f;
        }
        String[] strArrSplit = str.split(":");
        int i5 = Integer.parseInt(strArrSplit[0]);
        EnumMap enumMap = new EnumMap(J0.class);
        J0[] j0Arr = I0.DMA.f868j;
        int length = j0Arr.length;
        int i6 = 1;
        int i7 = 0;
        while (i7 < length) {
            enumMap.put((EnumMap) j0Arr[i7], (J0) K0.c(strArrSplit[i6].charAt(0)));
            i7++;
            i6++;
        }
        return new C0095p(enumMap, i5, (Boolean) null, (String) null);
    }

    public static Boolean d(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        int iOrdinal = K0.b(bundle.getString("ad_personalization")).ordinal();
        if (iOrdinal == 2) {
            return Boolean.FALSE;
        }
        if (iOrdinal != 3) {
            return null;
        }
        return Boolean.TRUE;
    }

    public final H0 c() {
        H0 h02 = (H0) this.f1341e.get(J0.AD_USER_DATA);
        return h02 == null ? H0.UNINITIALIZED : h02;
    }

    public final String e() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f1337a);
        for (J0 j02 : I0.DMA.f868j) {
            sb.append(":");
            sb.append(K0.a((H0) this.f1341e.get(j02)));
        }
        return sb.toString();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof C0095p)) {
            return false;
        }
        C0095p c0095p = (C0095p) obj;
        if (this.f1338b.equalsIgnoreCase(c0095p.f1338b) && Objects.equals(this.f1339c, c0095p.f1339c)) {
            return Objects.equals(this.f1340d, c0095p.f1340d);
        }
        return false;
    }

    public final int hashCode() {
        Boolean bool = this.f1339c;
        int i5 = bool == null ? 3 : true != bool.booleanValue() ? 13 : 7;
        String str = this.f1340d;
        return ((str == null ? 17 : str.hashCode()) * 137) + this.f1338b.hashCode() + (i5 * 29);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("source=");
        sb.append(K0.h(this.f1337a));
        for (J0 j02 : I0.DMA.f868j) {
            sb.append(",");
            sb.append(j02.f876j);
            sb.append("=");
            H0 h02 = (H0) this.f1341e.get(j02);
            if (h02 == null) {
                sb.append("uninitialized");
            } else {
                int iOrdinal = h02.ordinal();
                if (iOrdinal == 0) {
                    sb.append("uninitialized");
                } else if (iOrdinal == 1) {
                    sb.append("eu_consent_policy");
                } else if (iOrdinal == 2) {
                    sb.append("denied");
                } else if (iOrdinal == 3) {
                    sb.append("granted");
                }
            }
        }
        Boolean bool = this.f1339c;
        if (bool != null) {
            sb.append(",isDmaRegion=");
            sb.append(bool);
        }
        String str = this.f1340d;
        if (str != null) {
            sb.append(",cpsDisplayStr=");
            sb.append(str);
        }
        return sb.toString();
    }

    public C0095p(EnumMap enumMap, int i5, Boolean bool, String str) {
        EnumMap enumMap2 = new EnumMap(J0.class);
        this.f1341e = enumMap2;
        enumMap2.putAll(enumMap);
        this.f1337a = i5;
        this.f1338b = e();
        this.f1339c = bool;
        this.f1340d = str;
    }
}
