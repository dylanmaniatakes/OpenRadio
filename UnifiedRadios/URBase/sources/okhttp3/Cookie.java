package okhttp3;

import F3.f;
import F3.i;
import M3.e;
import M3.m;
import com.unified.ur1.SatelliteTracker.h;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.HostnamesKt;
import okhttp3.internal.Util;
import okhttp3.internal.http.DatesKt;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import t3.q;

/* loaded from: classes.dex */
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public static final class Builder {
        private String domain;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private boolean persistent;
        private boolean secure;
        private String value;
        private long expiresAt = DatesKt.MAX_DATE;
        private String path = "/";

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j5 = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j5, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, null);
            }
            throw new NullPointerException("builder.domain == null");
        }

        public final Builder domain(String str) {
            i.f(str, "domain");
            return domain(str, false);
        }

        public final Builder expiresAt(long j5) {
            if (j5 <= 0) {
                j5 = Long.MIN_VALUE;
            }
            if (j5 > DatesKt.MAX_DATE) {
                j5 = 253402300799999L;
            }
            this.expiresAt = j5;
            this.persistent = true;
            return this;
        }

        public final Builder hostOnlyDomain(String str) {
            i.f(str, "domain");
            return domain(str, true);
        }

        public final Builder httpOnly() {
            this.httpOnly = true;
            return this;
        }

        public final Builder name(String str) {
            i.f(str, "name");
            if (!i.a(e.P(str).toString(), str)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            this.name = str;
            return this;
        }

        public final Builder path(String str) {
            i.f(str, "path");
            if (!m.x(str, "/", false)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            this.path = str;
            return this;
        }

        public final Builder secure() {
            this.secure = true;
            return this;
        }

        public final Builder value(String str) {
            i.f(str, "value");
            if (!i.a(e.P(str).toString(), str)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            this.value = str;
            return this;
        }

        private final Builder domain(String str, boolean z4) {
            String canonicalHost = HostnamesKt.toCanonicalHost(str);
            if (canonicalHost == null) {
                throw new IllegalArgumentException(h.s("unexpected domain: ", str));
            }
            this.domain = canonicalHost;
            this.hostOnly = z4;
            return this;
        }
    }

    public static final class Companion {
        private Companion() {
        }

        private final int dateCharacterOffset(String str, int i5, int i6, boolean z4) {
            while (i5 < i6) {
                char cCharAt = str.charAt(i5);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && cCharAt < ':') || (('a' <= cCharAt && cCharAt < '{') || (('A' <= cCharAt && cCharAt < '[') || cCharAt == ':'))) == (!z4)) {
                    return i5;
                }
                i5++;
            }
            return i6;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean domainMatch(String str, String str2) {
            if (i.a(str, str2)) {
                return true;
            }
            return m.q(str, str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !Util.canParseAsIpAddress(str);
        }

        private final String parseDomain(String str) {
            if (!(!m.q(str, "."))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String canonicalHost = HostnamesKt.toCanonicalHost(e.I(str, "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        private final long parseExpires(String str, int i5, int i6) throws NumberFormatException {
            int iDateCharacterOffset = dateCharacterOffset(str, i5, i6, false);
            Matcher matcher = Cookie.TIME_PATTERN.matcher(str);
            int i7 = -1;
            int i8 = -1;
            int i9 = -1;
            int iD = -1;
            int i10 = -1;
            int i11 = -1;
            while (iDateCharacterOffset < i6) {
                int iDateCharacterOffset2 = dateCharacterOffset(str, iDateCharacterOffset + 1, i6, true);
                matcher.region(iDateCharacterOffset, iDateCharacterOffset2);
                if (i8 == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    i.e(strGroup, "matcher.group(1)");
                    i8 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    i.e(strGroup2, "matcher.group(2)");
                    i10 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    i.e(strGroup3, "matcher.group(3)");
                    i11 = Integer.parseInt(strGroup3);
                } else if (i9 == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    i.e(strGroup4, "matcher.group(1)");
                    i9 = Integer.parseInt(strGroup4);
                } else if (iD == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    i.e(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    i.e(locale, "US");
                    String lowerCase = strGroup5.toLowerCase(locale);
                    i.e(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    i.e(strPattern, "MONTH_PATTERN.pattern()");
                    iD = e.D(strPattern, lowerCase, 0, false, 6) / 4;
                } else if (i7 == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    i.e(strGroup6, "matcher.group(1)");
                    i7 = Integer.parseInt(strGroup6);
                }
                iDateCharacterOffset = dateCharacterOffset(str, iDateCharacterOffset2 + 1, i6, false);
            }
            if (70 <= i7 && i7 < 100) {
                i7 += 1900;
            }
            if (i7 >= 0 && i7 < 70) {
                i7 += 2000;
            }
            if (i7 < 1601) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (iD == -1) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (1 > i9 || i9 >= 32) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i8 < 0 || i8 >= 24) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i10 < 0 || i10 >= 60) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (i11 < 0 || i11 >= 60) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(Util.UTC);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i7);
            gregorianCalendar.set(2, iD - 1);
            gregorianCalendar.set(5, i9);
            gregorianCalendar.set(11, i8);
            gregorianCalendar.set(12, i10);
            gregorianCalendar.set(13, i11);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        private final long parseMaxAge(String str) throws NumberFormatException {
            try {
                long j5 = Long.parseLong(str);
                if (j5 <= 0) {
                    return Long.MIN_VALUE;
                }
                return j5;
            } catch (NumberFormatException e5) {
                Pattern patternCompile = Pattern.compile("-?\\d+");
                i.e(patternCompile, "compile(pattern)");
                i.f(str, "input");
                if (patternCompile.matcher(str).matches()) {
                    return m.x(str, "-", false) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e5;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean pathMatch(HttpUrl httpUrl, String str) {
            String strEncodedPath = httpUrl.encodedPath();
            if (i.a(strEncodedPath, str)) {
                return true;
            }
            return m.x(strEncodedPath, str, false) && (m.q(str, "/") || strEncodedPath.charAt(str.length()) == '/');
        }

        public final Cookie parse(HttpUrl httpUrl, String str) {
            i.f(httpUrl, "url");
            i.f(str, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), httpUrl, str);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00d5 A[PHI: r1
          0x00d5: PHI (r1v23 long) = (r1v7 long), (r1v11 long) binds: [B:42:0x00d3, B:53:0x00fb] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final okhttp3.Cookie parse$okhttp(long r25, okhttp3.HttpUrl r27, java.lang.String r28) throws java.lang.NumberFormatException {
            /*
                Method dump skipped, instructions count: 352
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.Cookie.Companion.parse$okhttp(long, okhttp3.HttpUrl, java.lang.String):okhttp3.Cookie");
        }

        public final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
            i.f(httpUrl, "url");
            i.f(headers, "headers");
            List<String> listValues = headers.values("Set-Cookie");
            int size = listValues.size();
            ArrayList arrayList = null;
            for (int i5 = 0; i5 < size; i5++) {
                Cookie cookie = parse(httpUrl, listValues.get(i5));
                if (cookie != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(cookie);
                }
            }
            if (arrayList == null) {
                return q.f9711j;
            }
            List<Cookie> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            i.e(listUnmodifiableList, "{\n        Collections.un…ableList(cookies)\n      }");
            return listUnmodifiableList;
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    public /* synthetic */ Cookie(String str, String str2, long j5, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7, f fVar) {
        this(str, str2, j5, str3, str4, z4, z5, z6, z7);
    }

    public static final Cookie parse(HttpUrl httpUrl, String str) {
        return Companion.parse(httpUrl, str);
    }

    public static final List<Cookie> parseAll(HttpUrl httpUrl, Headers headers) {
        return Companion.parseAll(httpUrl, headers);
    }

    /* renamed from: -deprecated_domain, reason: not valid java name */
    public final String m34deprecated_domain() {
        return this.domain;
    }

    /* renamed from: -deprecated_expiresAt, reason: not valid java name */
    public final long m35deprecated_expiresAt() {
        return this.expiresAt;
    }

    /* renamed from: -deprecated_hostOnly, reason: not valid java name */
    public final boolean m36deprecated_hostOnly() {
        return this.hostOnly;
    }

    /* renamed from: -deprecated_httpOnly, reason: not valid java name */
    public final boolean m37deprecated_httpOnly() {
        return this.httpOnly;
    }

    /* renamed from: -deprecated_name, reason: not valid java name */
    public final String m38deprecated_name() {
        return this.name;
    }

    /* renamed from: -deprecated_path, reason: not valid java name */
    public final String m39deprecated_path() {
        return this.path;
    }

    /* renamed from: -deprecated_persistent, reason: not valid java name */
    public final boolean m40deprecated_persistent() {
        return this.persistent;
    }

    /* renamed from: -deprecated_secure, reason: not valid java name */
    public final boolean m41deprecated_secure() {
        return this.secure;
    }

    /* renamed from: -deprecated_value, reason: not valid java name */
    public final String m42deprecated_value() {
        return this.value;
    }

    public final String domain() {
        return this.domain;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Cookie) {
            Cookie cookie = (Cookie) obj;
            if (i.a(cookie.name, this.name) && i.a(cookie.value, this.value) && cookie.expiresAt == this.expiresAt && i.a(cookie.domain, this.domain) && i.a(cookie.path, this.path) && cookie.secure == this.secure && cookie.httpOnly == this.httpOnly && cookie.persistent == this.persistent && cookie.hostOnly == this.hostOnly) {
                return true;
            }
        }
        return false;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return Boolean.hashCode(this.hostOnly) + ((Boolean.hashCode(this.persistent) + ((Boolean.hashCode(this.httpOnly) + ((Boolean.hashCode(this.secure) + ((this.path.hashCode() + ((this.domain.hashCode() + ((Long.hashCode(this.expiresAt) + ((this.value.hashCode() + ((this.name.hashCode() + 527) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean matches(HttpUrl httpUrl) {
        i.f(httpUrl, "url");
        if ((this.hostOnly ? i.a(httpUrl.host(), this.domain) : Companion.domainMatch(httpUrl.host(), this.domain)) && Companion.pathMatch(httpUrl, this.path)) {
            return !this.secure || httpUrl.isHttps();
        }
        return false;
    }

    public final String name() {
        return this.name;
    }

    public final String path() {
        return this.path;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean secure() {
        return this.secure;
    }

    public String toString() {
        return toString$okhttp(false);
    }

    public final String toString$okhttp(boolean z4) {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        sb.append('=');
        sb.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                sb.append(DatesKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            sb.append("; domain=");
            if (z4) {
                sb.append(".");
            }
            sb.append(this.domain);
        }
        sb.append("; path=");
        sb.append(this.path);
        if (this.secure) {
            sb.append("; secure");
        }
        if (this.httpOnly) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        i.e(string, "toString()");
        return string;
    }

    public final String value() {
        return this.value;
    }

    private Cookie(String str, String str2, long j5, String str3, String str4, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.name = str;
        this.value = str2;
        this.expiresAt = j5;
        this.domain = str3;
        this.path = str4;
        this.secure = z4;
        this.httpOnly = z5;
        this.persistent = z6;
        this.hostOnly = z7;
    }
}
