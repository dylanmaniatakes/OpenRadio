package l4;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class g extends ViewGroup.LayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public d4.a f8466a;

    /* renamed from: b, reason: collision with root package name */
    public int f8467b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8468c;

    /* renamed from: d, reason: collision with root package name */
    public final int f8469d;

    public g(d4.a aVar, int i5, int i6) {
        super(-2, -2);
        if (aVar != null) {
            this.f8466a = aVar;
        } else {
            this.f8466a = new k4.d(0.0d, 0.0d);
        }
        this.f8467b = 8;
        this.f8468c = i5;
        this.f8469d = i6;
    }
}
