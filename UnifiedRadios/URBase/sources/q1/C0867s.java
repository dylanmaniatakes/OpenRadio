package q1;

import android.app.Activity;
import android.content.Intent;

/* renamed from: q1.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0867s extends u {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Intent f9412c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Activity f9413d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9414e = 2;

    public C0867s(Activity activity, Intent intent) {
        this.f9412c = intent;
        this.f9413d = activity;
    }

    @Override // q1.u
    public final void a() {
        Intent intent = this.f9412c;
        if (intent != null) {
            this.f9413d.startActivityForResult(intent, this.f9414e);
        }
    }
}
