package okhttp3.internal.http;

import F3.i;
import J1.C;
import M3.a;
import W3.l;
import W3.o;
import java.io.EOFException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Challenge;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.Response;
import okhttp3.internal.Util;
import okhttp3.internal.platform.Platform;

/* loaded from: classes.dex */
public final class HttpHeaders {
    private static final o QUOTED_STRING_DELIMITERS;
    private static final o TOKEN_DELIMITERS;

    static {
        o oVar = o.f2649m;
        QUOTED_STRING_DELIMITERS = C.i("\"\\");
        TOKEN_DELIMITERS = C.i("\t ,=");
    }

    public static final boolean hasBody(Response response) {
        i.f(response, "response");
        return promisesBody(response);
    }

    public static final List<Challenge> parseChallenges(Headers headers, String str) {
        i.f(headers, "<this>");
        i.f(str, "headerName");
        ArrayList arrayList = new ArrayList();
        int size = headers.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (str.equalsIgnoreCase(headers.name(i5))) {
                l lVar = new l();
                lVar.m0(headers.value(i5));
                try {
                    readChallengeHeader(lVar, arrayList);
                } catch (EOFException e5) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e5);
                }
            }
        }
        return arrayList;
    }

    public static final boolean promisesBody(Response response) {
        i.f(response, "<this>");
        if (i.a(response.request().method(), "HEAD")) {
            return false;
        }
        int iCode = response.code();
        return (((iCode >= 100 && iCode < 200) || iCode == 204 || iCode == 304) && Util.headersContentLength(response) == -1 && !"chunked".equalsIgnoreCase(Response.header$default(response, "Transfer-Encoding", null, 2, null))) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
    
        r3 = s.AbstractC0882e.b(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0045, code lost:
    
        if (r5 < 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0047, code lost:
    
        if (r5 == 0) goto L30;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x004b, code lost:
    
        if (r5 == 1) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004d, code lost:
    
        r6 = 0;
        r4 = "=".charAt(0);
        r7 = new char[r5];
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r6 >= r5) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0056, code lost:
    
        r7[r6] = r4;
        r6 = r6 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005b, code lost:
    
        r4 = new java.lang.String(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        r4 = "=".toString();
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0066, code lost:
    
        r4 = "";
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x009b, code lost:
    
        throw new java.lang.IllegalArgumentException(("Count 'n' must be non-negative, but was " + r5 + '.').toString());
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00ef, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00ef, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00b9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void readChallengeHeader(W3.l r8, java.util.List<okhttp3.Challenge> r9) throws java.io.EOFException {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.HttpHeaders.readChallengeHeader(W3.l, java.util.List):void");
    }

    private static final String readQuotedString(l lVar) throws EOFException {
        if (lVar.U() != 34) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        l lVar2 = new l();
        while (true) {
            long jV = lVar.V(QUOTED_STRING_DELIMITERS);
            if (jV == -1) {
                return null;
            }
            if (lVar.x(jV) == 34) {
                lVar2.write(lVar, jV);
                lVar.U();
                return lVar2.Z();
            }
            if (lVar.f2648k == jV + 1) {
                return null;
            }
            lVar2.write(lVar, jV);
            lVar.U();
            lVar2.write(lVar, 1L);
        }
    }

    private static final String readToken(l lVar) {
        long jV = lVar.V(TOKEN_DELIMITERS);
        if (jV == -1) {
            jV = lVar.f2648k;
        }
        if (jV != 0) {
            return lVar.Y(jV, a.f1740a);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar cookieJar, HttpUrl httpUrl, Headers headers) {
        i.f(cookieJar, "<this>");
        i.f(httpUrl, "url");
        i.f(headers, "headers");
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.Companion.parseAll(httpUrl, headers);
        if (all.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(httpUrl, all);
    }

    private static final boolean skipCommasAndWhitespace(l lVar) throws EOFException {
        boolean z4 = false;
        while (!lVar.y()) {
            byte bX = lVar.x(0L);
            if (bX == 44) {
                lVar.U();
                z4 = true;
            } else {
                if (bX != 32 && bX != 9) {
                    break;
                }
                lVar.U();
            }
        }
        return z4;
    }

    private static final boolean startsWith(l lVar, byte b5) {
        return !lVar.y() && lVar.x(0L) == b5;
    }
}
