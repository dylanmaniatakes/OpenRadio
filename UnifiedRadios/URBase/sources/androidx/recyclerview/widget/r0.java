package androidx.recyclerview.widget;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class r0 {

    /* renamed from: a, reason: collision with root package name */
    public int f4322a;

    /* renamed from: b, reason: collision with root package name */
    public int f4323b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f4324c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f4325d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f4326e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f4327f;
    public final /* synthetic */ StaggeredGridLayoutManager g;

    public r0(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.g = staggeredGridLayoutManager;
        a();
    }

    public final void a() {
        this.f4322a = -1;
        this.f4323b = Integer.MIN_VALUE;
        this.f4324c = false;
        this.f4325d = false;
        this.f4326e = false;
        int[] iArr = this.f4327f;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
    }
}
