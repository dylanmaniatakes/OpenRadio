package M3;

import java.nio.charset.Charset;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f1740a;

    /* renamed from: b, reason: collision with root package name */
    public static volatile Charset f1741b;

    /* renamed from: c, reason: collision with root package name */
    public static volatile Charset f1742c;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        F3.i.e(charsetForName, "forName(\"UTF-8\")");
        f1740a = charsetForName;
        F3.i.e(Charset.forName("UTF-16"), "forName(\"UTF-16\")");
        F3.i.e(Charset.forName("UTF-16BE"), "forName(\"UTF-16BE\")");
        F3.i.e(Charset.forName("UTF-16LE"), "forName(\"UTF-16LE\")");
        F3.i.e(Charset.forName("US-ASCII"), "forName(\"US-ASCII\")");
        F3.i.e(Charset.forName("ISO-8859-1"), "forName(\"ISO-8859-1\")");
    }
}
