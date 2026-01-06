package F0;

import C0.u;
import D0.n;
import D1.C0016n;
import N1.r;
import O.s0;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.unified.ur1.primary.LaunchActivity;
import i3.C0573b;
import java.util.concurrent.CountDownLatch;
import m1.C0760a;
import m1.m;
import org.json.JSONObject;
import p1.q;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class e implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f498j;

    /* renamed from: k, reason: collision with root package name */
    public Object f499k;

    /* renamed from: l, reason: collision with root package name */
    public Object f500l;

    /* renamed from: m, reason: collision with root package name */
    public Object f501m;

    public /* synthetic */ e() {
        this.f498j = 10;
    }

    private final void a() {
        Q0.j jVar;
        Q0.k kVar;
        synchronized (((R0.f) this.f499k).n) {
        }
        C0016n c0016n = (C0016n) this.f500l;
        Q0.l lVar = (Q0.l) c0016n.f397f;
        if (lVar == null) {
            R0.f fVar = (R0.f) this.f499k;
            Object obj = c0016n.f395d;
            synchronized (fVar.f2225w) {
                kVar = fVar.f2226x;
            }
            if (kVar != null) {
                kVar.a((JSONObject) obj);
            }
        } else {
            R0.f fVar2 = (R0.f) this.f499k;
            synchronized (fVar2.n) {
                jVar = fVar2.f2217o;
            }
            if (jVar != null) {
                jVar.b(lVar);
            }
        }
        if (((C0016n) this.f500l).f394c) {
            ((R0.f) this.f499k).a("intermediate-response");
        } else {
            ((R0.f) this.f499k).b("done");
        }
        Runnable runnable = (Runnable) this.f501m;
        if (runnable != null) {
            runnable.run();
        }
    }

    private final void b() {
        int i5;
        r rVarC;
        C0760a c0760a = (C0760a) this.f499k;
        Intent intent = c0760a.f8510j;
        String stringExtra = intent.getStringExtra("google.message_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("message_id");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            rVarC = AbstractC0930a.i(null);
        } else {
            Bundle bundle = new Bundle();
            Intent intent2 = c0760a.f8510j;
            String stringExtra2 = intent2.getStringExtra("google.message_id");
            if (stringExtra2 == null) {
                stringExtra2 = intent2.getStringExtra("message_id");
            }
            bundle.putString("google.message_id", stringExtra2);
            Intent intent3 = c0760a.f8510j;
            Integer numValueOf = intent3.hasExtra("google.product_id") ? Integer.valueOf(intent3.getIntExtra("google.product_id", 0)) : null;
            if (numValueOf != null) {
                bundle.putInt("google.product_id", numValueOf.intValue());
            }
            bundle.putBoolean("supports_message_handled", true);
            m mVarB = m.b((Context) this.f500l);
            synchronized (mVarB) {
                i5 = mVarB.f8544c;
                mVarB.f8544c = i5 + 1;
            }
            rVarC = mVarB.c(new m1.l(i5, 2, bundle, 0));
        }
        rVarC.h(m1.h.f8526k, new N1.m((CountDownLatch) this.f501m));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0528  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0539  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0653  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Exception {
        /*
            Method dump skipped, instructions count: 1778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: F0.e.run():void");
    }

    public /* synthetic */ e(Context context, C0760a c0760a, CountDownLatch countDownLatch) {
        this.f498j = 15;
        this.f500l = context;
        this.f499k = c0760a;
        this.f501m = countDownLatch;
    }

    public e(C0573b c0573b, q qVar) {
        this.f498j = 16;
        this.f499k = qVar;
        this.f500l = "ConnectionlessLifecycleHelper";
        this.f501m = c0573b;
    }

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i5) {
        this.f498j = i5;
        this.f499k = obj;
        this.f500l = obj2;
        this.f501m = obj3;
    }

    public /* synthetic */ e(Object obj, Object obj2, Object obj3, int i5, boolean z4) {
        this.f498j = i5;
        this.f499k = obj2;
        this.f500l = obj3;
        this.f501m = obj;
    }

    public e(D0.h hVar, n nVar, u uVar) {
        this.f498j = 11;
        F3.i.f(hVar, "processor");
        this.f499k = hVar;
        this.f500l = nVar;
        this.f501m = uVar;
    }

    public e(View view, s0 s0Var, L0.c cVar, ValueAnimator valueAnimator) {
        this.f498j = 12;
        this.f499k = view;
        this.f500l = cVar;
        this.f501m = valueAnimator;
    }

    public e(LaunchActivity launchActivity, String str, TextView textView, String str2) {
        this.f498j = 14;
        this.f501m = launchActivity;
        this.f499k = textView;
        this.f500l = str2;
    }
}
