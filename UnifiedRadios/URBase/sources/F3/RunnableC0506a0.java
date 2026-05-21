package f3;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

/* renamed from: f3.a0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0506a0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6668j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f0 f6669k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ProgressDialog f6670l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ m0 f6671m;
    public final /* synthetic */ Context n;

    public /* synthetic */ RunnableC0506a0(f0 f0Var, ProgressDialog progressDialog, m0 m0Var, Context context, int i5) {
        this.f6668j = i5;
        this.f6669k = f0Var;
        this.f6670l = progressDialog;
        this.f6671m = m0Var;
        this.n = context;
    }

    @Override // java.lang.Runnable
    public final void run() throws NumberFormatException {
        switch (this.f6668j) {
            case 0:
                f0 f0Var = this.f6669k;
                ((Activity) f0Var.f6710b).runOnUiThread(new RunnableC0506a0(f0Var, this.f6670l, this.f6671m, this.n, 1));
                break;
            default:
                f0 f0Var2 = this.f6669k;
                f0Var2.getClass();
                this.f6670l.dismiss();
                f0Var2.a(this.f6671m, this.n);
                break;
        }
    }
}
