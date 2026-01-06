package M3;

import E3.p;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c implements L3.c {

    /* renamed from: a, reason: collision with root package name */
    public final CharSequence f1748a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1749b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1750c;

    /* renamed from: d, reason: collision with root package name */
    public final p f1751d;

    public c(CharSequence charSequence, int i5, int i6, p pVar) {
        F3.i.f(charSequence, "input");
        this.f1748a = charSequence;
        this.f1749b = i5;
        this.f1750c = i6;
        this.f1751d = pVar;
    }

    @Override // L3.c
    public final Iterator iterator() {
        return new b(this);
    }
}
