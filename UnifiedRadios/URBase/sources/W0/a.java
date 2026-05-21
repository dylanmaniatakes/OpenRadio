package W0;

import L0.f;
import Y0.l;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class a implements l {

    /* renamed from: c, reason: collision with root package name */
    public static final String f2572c;

    /* renamed from: d, reason: collision with root package name */
    public static final Set f2573d;

    /* renamed from: e, reason: collision with root package name */
    public static final a f2574e;

    /* renamed from: f, reason: collision with root package name */
    public static final a f2575f;

    /* renamed from: a, reason: collision with root package name */
    public final String f2576a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2577b;

    static {
        String strJ = f.j("hts/frbslgiggolai.o/0clgbthfra=snpoo", "tp:/ieaeogn.ogepscmvc/o/ac?omtjo_rt3");
        f2572c = strJ;
        String strJ2 = f.j("hts/frbslgigp.ogepscmv/ieo/eaybtho", "tp:/ieaeogn-agolai.o/1frlglgc/aclg");
        String strJ3 = f.j("AzSCki82AwsLzKd5O8zo", "IayckHiZRO1EFl1aGoK");
        f2573d = Collections.unmodifiableSet(new HashSet(Arrays.asList(new V0.c("proto"), new V0.c("json"))));
        f2574e = new a(strJ, null);
        f2575f = new a(strJ2, strJ3);
    }

    public a(String str, String str2) {
        this.f2576a = str;
        this.f2577b = str2;
    }

    public static a a(byte[] bArr) {
        String str = new String(bArr, Charset.forName("UTF-8"));
        if (!str.startsWith("1$")) {
            throw new IllegalArgumentException("Version marker missing from extras");
        }
        String[] strArrSplit = str.substring(2).split(Pattern.quote("\\"), 2);
        if (strArrSplit.length != 2) {
            throw new IllegalArgumentException("Extra is not a valid encoded LegacyFlgDestination");
        }
        String str2 = strArrSplit[0];
        if (str2.isEmpty()) {
            throw new IllegalArgumentException("Missing endpoint in CCTDestination extras");
        }
        String str3 = strArrSplit[1];
        if (str3.isEmpty()) {
            str3 = null;
        }
        return new a(str2, str3);
    }
}
