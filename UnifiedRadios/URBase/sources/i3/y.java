package i3;

import android.util.Log;

/* loaded from: classes.dex */
public final class y extends androidx.viewpager2.adapter.b {

    /* renamed from: j, reason: collision with root package name */
    public m f7365j;

    /* renamed from: k, reason: collision with root package name */
    public E f7366k;

    @Override // androidx.recyclerview.widget.N
    public final int getItemCount() {
        return 2;
    }

    public final m h() {
        Log.d("MessagesPagerAdapter", "getInboxFragment() called, returning: ".concat(this.f7365j != null ? "fragment" : "null"));
        return this.f7365j;
    }

    public final E i() {
        Log.d("MessagesPagerAdapter", "getSentFragment() called, returning: ".concat(this.f7366k != null ? "fragment" : "null"));
        return this.f7366k;
    }
}
