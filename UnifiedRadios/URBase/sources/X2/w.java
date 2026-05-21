package X2;

import android.util.Log;
import g0.AbstractC0535a;
import java.util.Arrays;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: d, reason: collision with root package name */
    public static final Pattern f2844d = Pattern.compile("[a-zA-Z0-9-_.~%]{1,900}");

    /* renamed from: a, reason: collision with root package name */
    public final String f2845a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2846b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2847c;

    public w(String str, String str2) {
        String strSubstring;
        if (str2 == null || !str2.startsWith("/topics/")) {
            strSubstring = str2;
        } else {
            Log.w("FirebaseMessaging", "Format /topics/topic-name is deprecated. Only 'topic-name' should be used in " + str + ".");
            strSubstring = str2.substring(8);
        }
        if (strSubstring == null || !f2844d.matcher(strSubstring).matches()) {
            throw new IllegalArgumentException(AbstractC0535a.l("Invalid topic name: ", strSubstring, " does not match the allowed format [a-zA-Z0-9-_.~%]{1,900}."));
        }
        this.f2845a = strSubstring;
        this.f2846b = str;
        this.f2847c = str + "!" + str2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f2845a.equals(wVar.f2845a) && this.f2846b.equals(wVar.f2846b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2846b, this.f2845a});
    }
}
