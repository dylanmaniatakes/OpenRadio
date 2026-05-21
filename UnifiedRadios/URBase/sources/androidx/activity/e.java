package androidx.activity;

import android.os.Bundle;
import androidx.fragment.app.AbstractActivityC0230z;
import androidx.lifecycle.K;

/* loaded from: classes.dex */
public final /* synthetic */ class e implements o0.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3227a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3228b;

    public /* synthetic */ e(int i5, Object obj) {
        this.f3227a = i5;
        this.f3228b = obj;
    }

    @Override // o0.b
    public final Bundle a() {
        switch (this.f3227a) {
            case 0:
                return ComponentActivity.g((AbstractActivityC0230z) ((ComponentActivity) this.f3228b));
            default:
                return K.a((K) this.f3228b);
        }
    }
}
