package J1;

import android.content.Context;
import android.content.Intent;
import java.io.IOException;
import java.util.Map;

/* renamed from: J1.f1, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0067f1 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1209j = 1;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int f1210k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1211l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1212m;
    public final /* synthetic */ Cloneable n;

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ RunnableC0067f1(RunnableC0057c0 runnableC0057c0, int i5, IOException iOException, byte[] bArr, Map map) {
        this.f1211l = runnableC0057c0;
        this.f1210k = i5;
        this.f1212m = iOException;
        this.n = bArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1209j) {
            case 0:
                InterfaceC0064e1 interfaceC0064e1 = (InterfaceC0064e1) ((RunnableC0057c0) this.f1211l).f1161o;
                byte[] bArr = (byte[]) this.n;
                interfaceC0064e1.a(this.f1210k, (IOException) ((Exception) this.f1212m), bArr);
                break;
            default:
                Context context = ((B1) this.f1211l).f707a;
                A1 a12 = (A1) context;
                int i5 = this.f1210k;
                if (a12.b(i5)) {
                    ((Z) this.f1212m).f1084p.b(Integer.valueOf(i5), "Local AppMeasurementService processed last upload request. StartId");
                    Z z4 = C0113v0.q(context, null, null).f1417k;
                    C0113v0.k(z4);
                    z4.f1084p.a("Completed wakeful intent.");
                    a12.a((Intent) this.n);
                    break;
                }
                break;
        }
    }

    public /* synthetic */ RunnableC0067f1(B1 b12, int i5, Z z4, Intent intent) {
        this.f1211l = b12;
        this.f1210k = i5;
        this.f1212m = z4;
        this.n = intent;
    }
}
