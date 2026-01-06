package n0;

import F3.i;

/* renamed from: n0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0781c implements Comparable {

    /* renamed from: j, reason: collision with root package name */
    public final int f8713j;

    /* renamed from: k, reason: collision with root package name */
    public final int f8714k;

    /* renamed from: l, reason: collision with root package name */
    public final String f8715l;

    /* renamed from: m, reason: collision with root package name */
    public final String f8716m;

    public C0781c(String str, String str2, int i5, int i6) {
        this.f8713j = i5;
        this.f8714k = i6;
        this.f8715l = str;
        this.f8716m = str2;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        C0781c c0781c = (C0781c) obj;
        i.f(c0781c, "other");
        int i5 = this.f8713j - c0781c.f8713j;
        return i5 == 0 ? this.f8714k - c0781c.f8714k : i5;
    }
}
