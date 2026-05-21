package androidx.activity;

import B.AbstractC0000a;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.AbstractActivityC0230z;
import d.AbstractC0422a;

/* loaded from: classes.dex */
public final class g extends androidx.activity.result.g {
    public final /* synthetic */ ComponentActivity h;

    public g(AbstractActivityC0230z abstractActivityC0230z) {
        this.h = abstractActivityC0230z;
    }

    @Override // androidx.activity.result.g
    public final void b(int i5, AbstractC0422a abstractC0422a, Object obj) {
        Bundle bundle;
        ComponentActivity componentActivity = this.h;
        P.i iVarB = abstractC0422a.b(componentActivity, obj);
        if (iVarB != null) {
            new Handler(Looper.getMainLooper()).post(new F0.j(this, i5, iVarB, 3));
            return;
        }
        Intent intentA = abstractC0422a.a(componentActivity, obj);
        if (intentA.getExtras() != null && intentA.getExtras().getClassLoader() == null) {
            intentA.setExtrasClassLoader(componentActivity.getClassLoader());
        }
        if (intentA.hasExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) {
            Bundle bundleExtra = intentA.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            intentA.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
            bundle = bundleExtra;
        } else {
            bundle = null;
        }
        if ("androidx.activity.result.contract.action.REQUEST_PERMISSIONS".equals(intentA.getAction())) {
            String[] stringArrayExtra = intentA.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
            if (stringArrayExtra == null) {
                stringArrayExtra = new String[0];
            }
            B.e.d(componentActivity, stringArrayExtra, i5);
            return;
        }
        if (!"androidx.activity.result.contract.action.INTENT_SENDER_REQUEST".equals(intentA.getAction())) {
            AbstractC0000a.b(componentActivity, intentA, i5, bundle);
            return;
        }
        androidx.activity.result.i iVar = (androidx.activity.result.i) intentA.getParcelableExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST");
        try {
            AbstractC0000a.c(componentActivity, iVar.f3271j, i5, iVar.f3272k, iVar.f3273l, iVar.f3274m, 0, bundle);
        } catch (IntentSender.SendIntentException e5) {
            new Handler(Looper.getMainLooper()).post(new F0.j(this, i5, e5, 4));
        }
    }
}
