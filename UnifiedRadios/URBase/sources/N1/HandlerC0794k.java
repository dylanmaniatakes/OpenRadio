package n1;

import android.content.Context;
import android.content.res.Resources;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: n1.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerC0794k extends A1.f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8753a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0788e f8754b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0794k(C0788e c0788e, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper(), 0);
        this.f8754b = c0788e;
        this.f8753a = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Resources.NotFoundException {
        int i5 = message.what;
        if (i5 != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i5);
            return;
        }
        int i6 = C0789f.f8739a;
        C0788e c0788e = this.f8754b;
        Context context = this.f8753a;
        int iC = c0788e.c(context, i6);
        int i7 = AbstractC0791h.f8746e;
        if (iC == 1 || iC == 2 || iC == 3 || iC == 9) {
            c0788e.g(context, iC, c0788e.b(iC, context, "n"));
        }
    }
}
