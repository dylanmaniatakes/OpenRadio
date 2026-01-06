package J1;

import android.content.SharedPreferences;
import android.text.TextUtils;
import y2.AbstractC0985d;
import y2.C0983b;

/* loaded from: classes.dex */
public abstract class J1 {

    /* renamed from: a, reason: collision with root package name */
    public static final y2.h f877a;

    static {
        C0983b c0983b = AbstractC0985d.f10493k;
        Object[] objArr = new Object[24];
        objArr[0] = "Version";
        objArr[1] = "GoogleConsent";
        objArr[2] = "VendorConsent";
        objArr[3] = "VendorLegitimateInterest";
        objArr[4] = "gdprApplies";
        objArr[5] = "EnableAdvertiserConsentMode";
        objArr[6] = "PolicyVersion";
        objArr[7] = "PurposeConsents";
        objArr[8] = "PurposeOneTreatment";
        objArr[9] = "Purpose1";
        objArr[10] = "Purpose3";
        objArr[11] = "Purpose4";
        System.arraycopy(new String[]{"Purpose7", "CmpSdkID", "PublisherCC", "PublisherRestrictions1", "PublisherRestrictions3", "PublisherRestrictions4", "PublisherRestrictions7", "AuthorizePurpose1", "AuthorizePurpose3", "AuthorizePurpose4", "AuthorizePurpose7", "PurposeDiagnostics"}, 0, objArr, 12, 12);
        com.google.android.gms.internal.measurement.D1.b(24, objArr);
        f877a = AbstractC0985d.f(24, objArr);
    }

    public static int a(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getInt(str, -1);
        } catch (ClassCastException unused) {
            return -1;
        }
    }

    public static String b(SharedPreferences sharedPreferences, String str) {
        try {
            return sharedPreferences.getString(str, "");
        } catch (ClassCastException unused) {
            return "";
        }
    }

    public static final boolean c(com.google.android.gms.internal.measurement.L1 l12, y2.m mVar, y2.m mVar2, y2.o oVar, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, String str2, String str3, boolean z4, boolean z5) {
        int i10;
        int i11;
        int i12;
        I1 i13;
        char c2;
        int iD = d(l12);
        if (iD > 0) {
            i11 = i7;
            if (i11 == 1) {
                i10 = i6;
                if (i10 != 1) {
                    i11 = 1;
                } else {
                    i11 = 1;
                    i10 = 1;
                }
            } else {
                i10 = i6;
            }
            cArr[iD] = '2';
        } else {
            i10 = i6;
            i11 = i7;
        }
        if (e(l12, mVar2) == com.google.android.gms.internal.measurement.M1.PURPOSE_RESTRICTION_NOT_ALLOWED) {
            c2 = '3';
        } else {
            if (l12 == com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
                i12 = i9;
                if (i12 == 1) {
                    if (oVar.f10522m.equals(str)) {
                        if (iD > 0 && cArr[iD] != '2') {
                            cArr[iD] = '1';
                        }
                        return true;
                    }
                    i12 = 1;
                }
            } else {
                i12 = i9;
            }
            if (mVar.containsKey(l12) && (i13 = (I1) mVar.get(l12)) != null) {
                int iOrdinal = i13.ordinal();
                com.google.android.gms.internal.measurement.M1 m12 = com.google.android.gms.internal.measurement.M1.PURPOSE_RESTRICTION_REQUIRE_LEGITIMATE_INTEREST;
                if (iOrdinal != 0) {
                    com.google.android.gms.internal.measurement.M1 m13 = com.google.android.gms.internal.measurement.M1.PURPOSE_RESTRICTION_REQUIRE_CONSENT;
                    if (iOrdinal != 1) {
                        if (iOrdinal == 2) {
                            return e(l12, mVar2) == m12 ? h(l12, cArr, i5, i10, i11, i8, i12, str3, z4, z5) : g(l12, cArr, i5, i10, i11, i8, i12, str2, z4, z5);
                        }
                        if (iOrdinal == 3) {
                            return e(l12, mVar2) == m13 ? g(l12, cArr, i5, i10, i11, i8, i12, str2, z4, z5) : h(l12, cArr, i5, i10, i11, i8, i12, str3, z4, z5);
                        }
                        c2 = '0';
                    } else if (e(l12, mVar2) != m13) {
                        return h(l12, cArr, i5, i10, i11, i8, i12, str3, z4, z5);
                    }
                } else if (e(l12, mVar2) != m12) {
                    return g(l12, cArr, i5, i10, i11, i8, i12, str2, z4, z5);
                }
                c2 = '8';
            } else {
                c2 = '0';
            }
        }
        if (iD <= 0 || cArr[iD] == '2') {
            return false;
        }
        cArr[iD] = c2;
        return false;
    }

    public static final int d(com.google.android.gms.internal.measurement.L1 l12) {
        if (l12 == com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_STORE_AND_ACCESS_INFORMATION_ON_A_DEVICE) {
            return 1;
        }
        if (l12 == com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_CREATE_A_PERSONALISED_ADS_PROFILE) {
            return 2;
        }
        if (l12 == com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_SELECT_PERSONALISED_ADS) {
            return 3;
        }
        return l12 == com.google.android.gms.internal.measurement.L1.IAB_TCF_PURPOSE_MEASURE_AD_PERFORMANCE ? 4 : -1;
    }

    public static final com.google.android.gms.internal.measurement.M1 e(com.google.android.gms.internal.measurement.L1 l12, y2.m mVar) {
        Object obj = com.google.android.gms.internal.measurement.M1.PURPOSE_RESTRICTION_UNDEFINED;
        Object obj2 = mVar.get(l12);
        if (obj2 != null) {
            obj = obj2;
        }
        return (com.google.android.gms.internal.measurement.M1) obj;
    }

    public static final String f(com.google.android.gms.internal.measurement.L1 l12, String str, String str2) {
        String strValueOf = "0";
        String strValueOf2 = (TextUtils.isEmpty(str) || str.length() < l12.a()) ? "0" : String.valueOf(str.charAt(l12.a() - 1));
        if (!TextUtils.isEmpty(str2) && str2.length() >= l12.a()) {
            strValueOf = String.valueOf(str2.charAt(l12.a() - 1));
        }
        return String.valueOf(strValueOf2).concat(String.valueOf(strValueOf));
    }

    public static final boolean g(com.google.android.gms.internal.measurement.L1 l12, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, boolean z4, boolean z5) {
        char c2;
        int iD = d(l12);
        if (!z4) {
            c2 = '4';
        } else {
            if (str.length() >= l12.a()) {
                char cCharAt = str.charAt(l12.a() - 1);
                boolean z6 = cCharAt == '1';
                if (iD > 0 && cArr[iD] != '2') {
                    cArr[iD] = cCharAt != '1' ? '6' : '1';
                }
                return z6;
            }
            c2 = '0';
        }
        if (iD > 0 && cArr[iD] != '2') {
            cArr[iD] = c2;
        }
        return false;
    }

    public static final boolean h(com.google.android.gms.internal.measurement.L1 l12, char[] cArr, int i5, int i6, int i7, int i8, int i9, String str, boolean z4, boolean z5) {
        char c2;
        int iD = d(l12);
        if (!z5) {
            c2 = '5';
        } else {
            if (str.length() >= l12.a()) {
                char cCharAt = str.charAt(l12.a() - 1);
                boolean z6 = cCharAt == '1';
                if (iD > 0 && cArr[iD] != '2') {
                    cArr[iD] = cCharAt != '1' ? '7' : '1';
                }
                return z6;
            }
            c2 = '0';
        }
        if (iD > 0 && cArr[iD] != '2') {
            cArr[iD] = c2;
        }
        return false;
    }
}
