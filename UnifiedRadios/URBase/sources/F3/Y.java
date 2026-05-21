package f3;

import android.widget.Toast;

/* loaded from: classes.dex */
public final /* synthetic */ class Y implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6658j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f0 f6659k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Exception f6660l;

    public /* synthetic */ Y(f0 f0Var, Exception exc, int i5) {
        this.f6658j = i5;
        this.f6659k = f0Var;
        this.f6660l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f6658j) {
            case 0:
                f0 f0Var = this.f6659k;
                f0Var.getClass();
                Toast.makeText(f0Var.f6710b, "Network error: " + this.f6660l.getMessage(), 1).show();
                break;
            default:
                f0 f0Var2 = this.f6659k;
                f0Var2.getClass();
                Toast.makeText(f0Var2.f6710b, "Network error: " + this.f6660l.getMessage(), 1).show();
                break;
        }
    }
}
