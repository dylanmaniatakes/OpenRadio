package W3;

import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class w extends t3.c implements RandomAccess {

    /* renamed from: j, reason: collision with root package name */
    public final o[] f2666j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f2667k;

    public w(o[] oVarArr, int[] iArr) {
        this.f2666j = oVarArr;
        this.f2667k = iArr;
    }

    @Override // t3.c
    public final int a() {
        return this.f2666j.length;
    }

    @Override // t3.c, java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof o) {
            return super.contains((o) obj);
        }
        return false;
    }

    @Override // java.util.List
    public final Object get(int i5) {
        return this.f2666j[i5];
    }

    @Override // t3.c, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof o) {
            return super.indexOf((o) obj);
        }
        return -1;
    }

    @Override // t3.c, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof o) {
            return super.lastIndexOf((o) obj);
        }
        return -1;
    }
}
