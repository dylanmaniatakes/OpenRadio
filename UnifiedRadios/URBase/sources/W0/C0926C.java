package w0;

import android.view.View;
import android.view.WindowId;

/* renamed from: w0.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0926C {

    /* renamed from: a, reason: collision with root package name */
    public final WindowId f10045a;

    public C0926C(View view) {
        this.f10045a = view.getWindowId();
    }

    public final boolean equals(Object obj) {
        return (obj instanceof C0926C) && ((C0926C) obj).f10045a.equals(this.f10045a);
    }

    public final int hashCode() {
        return this.f10045a.hashCode();
    }
}
