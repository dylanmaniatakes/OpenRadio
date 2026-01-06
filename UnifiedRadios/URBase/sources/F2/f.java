package F2;

import android.os.StrictMode;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.messaging.FirebaseMessaging;
import f3.C0519j;
import java.util.Collections;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements Q2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f551a;

    public /* synthetic */ f(int i5) {
        this.f551a = i5;
    }

    @Override // Q2.a
    public final Object get() {
        switch (this.f551a) {
            case 0:
                return Collections.emptySet();
            case 1:
                return null;
            case 2:
                n nVar = ExecutorsRegistrar.f5533a;
                StrictMode.ThreadPolicy.Builder builderDetectNetwork = new StrictMode.ThreadPolicy.Builder().detectNetwork();
                builderDetectNetwork.detectResourceMismatches();
                builderDetectNetwork.detectUnbufferedIo();
                return new G2.f(Executors.newFixedThreadPool(4, new G2.a("Firebase Background", 10, builderDetectNetwork.penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f5536d.get());
            case 3:
                n nVar2 = ExecutorsRegistrar.f5533a;
                return new G2.f(Executors.newFixedThreadPool(Math.max(2, Runtime.getRuntime().availableProcessors()), new G2.a("Firebase Lite", 0, new StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())), (ScheduledExecutorService) ExecutorsRegistrar.f5536d.get());
            case 4:
                n nVar3 = ExecutorsRegistrar.f5533a;
                return new G2.f(Executors.newCachedThreadPool(new G2.a("Firebase Blocking", 11, null)), (ScheduledExecutorService) ExecutorsRegistrar.f5536d.get());
            case 5:
                n nVar4 = ExecutorsRegistrar.f5533a;
                return Executors.newSingleThreadScheduledExecutor(new G2.a("Firebase Scheduler", 0, null));
            default:
                C0519j c0519j = FirebaseMessaging.f5540k;
                return null;
        }
    }
}
