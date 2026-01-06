package q1;

import android.content.Intent;

/* loaded from: classes.dex */
public final class t extends u {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Intent f9415c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ p1.k f9416d;

    public t(Intent intent, p1.k kVar) {
        this.f9415c = intent;
        this.f9416d = kVar;
    }

    @Override // q1.u
    public final void a() {
        Intent intent = this.f9415c;
        if (intent != null) {
            this.f9416d.startActivityForResult(intent, 2);
        }
    }
}
