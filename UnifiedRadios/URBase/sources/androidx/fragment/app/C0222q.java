package androidx.fragment.app;

import android.animation.Animator;

/* renamed from: androidx.fragment.app.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0222q implements K.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3864a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3865b;

    public /* synthetic */ C0222q(int i5, Object obj) {
        this.f3864a = i5;
        this.f3865b = obj;
    }

    public Object a() {
        switch (this.f3864a) {
            case 0:
                Fragment fragment = (Fragment) this.f3865b;
                Object obj = fragment.mHost;
                return obj instanceof androidx.activity.result.h ? ((androidx.activity.result.h) obj).getActivityResultRegistry() : fragment.requireActivity().getActivityResultRegistry();
            default:
                return (androidx.activity.result.g) this.f3865b;
        }
    }

    @Override // K.c
    public void onCancel() {
        switch (this.f3864a) {
            case 1:
                ((Animator) this.f3865b).end();
                break;
            default:
                ((p0) this.f3865b).a();
                break;
        }
    }
}
