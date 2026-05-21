package M3;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class d implements Serializable {

    /* renamed from: j, reason: collision with root package name */
    public final Pattern f1752j;

    public d(String str) {
        Pattern patternCompile = Pattern.compile(str);
        F3.i.e(patternCompile, "compile(pattern)");
        this.f1752j = patternCompile;
    }

    public final String toString() {
        String string = this.f1752j.toString();
        F3.i.e(string, "nativePattern.toString()");
        return string;
    }
}
