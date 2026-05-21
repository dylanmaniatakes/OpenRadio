package m1;

import N1.r;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.io.IOException;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final /* synthetic */ class d implements N1.b, N1.i {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ d f8520d = new d(0);

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ d f8521e = new d(1);

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ d f8522f = new d(2);

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f8523c;

    public /* synthetic */ d(int i5) {
        this.f8523c = i5;
    }

    @Override // N1.i
    public r a(Object obj) {
        Bundle bundle = (Bundle) obj;
        int i5 = C0761b.h;
        return (bundle == null || !bundle.containsKey("google.messenger")) ? AbstractC0930a.i(bundle) : AbstractC0930a.i(null);
    }

    @Override // N1.b
    public Object c(N1.j jVar) throws IOException {
        switch (this.f8523c) {
            case 0:
                if (jVar.f()) {
                    return (Bundle) jVar.d();
                }
                if (Log.isLoggable("Rpc", 3)) {
                    Log.d("Rpc", "Error making request: ".concat(String.valueOf(jVar.c())));
                }
                throw new IOException("SERVICE_NOT_AVAILABLE", jVar.c());
            default:
                Intent intent = (Intent) ((Bundle) jVar.d()).getParcelable("notification_data");
                if (intent != null) {
                    return new C0760a(intent);
                }
                return null;
        }
    }
}
