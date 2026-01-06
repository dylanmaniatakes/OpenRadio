package J1;

import android.os.Bundle;
import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import r1.AbstractC0873a;

/* renamed from: J1.y0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0122y0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1457j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f1458k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1459l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f1460m;
    public final /* synthetic */ Object n;

    public /* synthetic */ RunnableC0122y0(E0 e02, Bundle bundle, String str, b2 b2Var) {
        this.f1457j = 1;
        this.f1458k = e02;
        this.f1460m = bundle;
        this.f1459l = str;
        this.n = b2Var;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:163|116|(1:118)(5:119|(1:121)(2:122|(1:140))|141|138|166)|124|(2:127|125)|168|128|152|129|(2:132|130)|169|134|(1:136)|137|138|166) */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x04f6, code lost:
    
        r5 = r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x052e, code lost:
    
        r2.c().f1080k.b(r4, "Failed to parse queued batch. appId");
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 1426
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.RunnableC0122y0.run():void");
    }

    public /* synthetic */ RunnableC0122y0(C0120x1 c0120x1, AtomicReference atomicReference, b2 b2Var, O1 o12) {
        this.f1457j = 5;
        this.f1458k = c0120x1;
        this.f1459l = atomicReference;
        this.n = b2Var;
        this.f1460m = o12;
    }

    public RunnableC0122y0(L0.l lVar, String str, String str2, Bundle bundle) {
        this.f1457j = 8;
        this.f1459l = str;
        this.f1458k = str2;
        this.f1460m = bundle;
        this.n = lVar;
    }

    public RunnableC0122y0(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.M m5, C0112v c0112v, String str) {
        this.f1457j = 2;
        this.f1458k = m5;
        this.f1460m = c0112v;
        this.f1459l = str;
        this.n = appMeasurementDynamiteService;
    }

    public /* synthetic */ RunnableC0122y0(Object obj, Serializable serializable, AbstractC0873a abstractC0873a, Object obj2, int i5) {
        this.f1457j = i5;
        this.f1458k = obj;
        this.f1459l = serializable;
        this.f1460m = abstractC0873a;
        this.n = obj2;
    }

    public /* synthetic */ RunnableC0122y0(Object obj, Object obj2, Object obj3, Object obj4, int i5) {
        this.f1457j = i5;
        this.f1458k = obj2;
        this.f1459l = obj3;
        this.f1460m = obj4;
        this.n = obj;
    }
}
