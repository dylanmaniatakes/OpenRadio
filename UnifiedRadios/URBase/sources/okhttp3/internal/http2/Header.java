package okhttp3.internal.http2;

import F3.f;
import F3.i;
import J1.C;
import W3.o;

/* loaded from: classes.dex */
public final class Header {
    public static final Companion Companion = new Companion(null);
    public static final o PSEUDO_PREFIX;
    public static final o RESPONSE_STATUS;
    public static final String RESPONSE_STATUS_UTF8 = ":status";
    public static final o TARGET_AUTHORITY;
    public static final String TARGET_AUTHORITY_UTF8 = ":authority";
    public static final o TARGET_METHOD;
    public static final String TARGET_METHOD_UTF8 = ":method";
    public static final o TARGET_PATH;
    public static final String TARGET_PATH_UTF8 = ":path";
    public static final o TARGET_SCHEME;
    public static final String TARGET_SCHEME_UTF8 = ":scheme";
    public final int hpackSize;
    public final o name;
    public final o value;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(f fVar) {
            this();
        }
    }

    static {
        o oVar = o.f2649m;
        PSEUDO_PREFIX = C.i(":");
        RESPONSE_STATUS = C.i(RESPONSE_STATUS_UTF8);
        TARGET_METHOD = C.i(TARGET_METHOD_UTF8);
        TARGET_PATH = C.i(TARGET_PATH_UTF8);
        TARGET_SCHEME = C.i(TARGET_SCHEME_UTF8);
        TARGET_AUTHORITY = C.i(TARGET_AUTHORITY_UTF8);
    }

    public Header(o oVar, o oVar2) {
        i.f(oVar, "name");
        i.f(oVar2, "value");
        this.name = oVar;
        this.value = oVar2;
        this.hpackSize = oVar2.c() + oVar.c() + 32;
    }

    public static /* synthetic */ Header copy$default(Header header, o oVar, o oVar2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            oVar = header.name;
        }
        if ((i5 & 2) != 0) {
            oVar2 = header.value;
        }
        return header.copy(oVar, oVar2);
    }

    public final o component1() {
        return this.name;
    }

    public final o component2() {
        return this.value;
    }

    public final Header copy(o oVar, o oVar2) {
        i.f(oVar, "name");
        i.f(oVar2, "value");
        return new Header(oVar, oVar2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Header)) {
            return false;
        }
        Header header = (Header) obj;
        return i.a(this.name, header.name) && i.a(this.value, header.value);
    }

    public int hashCode() {
        return this.value.hashCode() + (this.name.hashCode() * 31);
    }

    public String toString() {
        return this.name.j() + ": " + this.value.j();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(String str, String str2) {
        this(C.i(str), C.i(str2));
        i.f(str, "name");
        i.f(str2, "value");
        o oVar = o.f2649m;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Header(o oVar, String str) {
        this(oVar, C.i(str));
        i.f(oVar, "name");
        i.f(str, "value");
        o oVar2 = o.f2649m;
    }
}
