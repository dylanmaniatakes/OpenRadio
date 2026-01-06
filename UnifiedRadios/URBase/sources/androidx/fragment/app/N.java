package androidx.fragment.app;

import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.util.Log;
import d.AbstractC0422a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import s3.C0895e;

/* loaded from: classes.dex */
public final class N extends AbstractC0422a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3678a;

    public /* synthetic */ N(int i5) {
        this.f3678a = i5;
    }

    @Override // d.AbstractC0422a
    public final Intent a(Context context, Object obj) {
        Bundle bundleExtra;
        switch (this.f3678a) {
            case 0:
                androidx.activity.result.i iVar = (androidx.activity.result.i) obj;
                Intent intent = new Intent("androidx.activity.result.contract.action.INTENT_SENDER_REQUEST");
                Intent intent2 = iVar.f3272k;
                if (intent2 != null && (bundleExtra = intent2.getBundleExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE")) != null) {
                    intent.putExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE", bundleExtra);
                    intent2.removeExtra("androidx.activity.result.contract.extra.ACTIVITY_OPTIONS_BUNDLE");
                    if (intent2.getBooleanExtra("androidx.fragment.extra.ACTIVITY_OPTIONS_BUNDLE", false)) {
                        IntentSender intentSender = iVar.f3271j;
                        F3.i.f(intentSender, "intentSender");
                        iVar = new androidx.activity.result.i(intentSender, null, iVar.f3273l, iVar.f3274m);
                    }
                }
                intent.putExtra("androidx.activity.result.contract.extra.INTENT_SENDER_REQUEST", iVar);
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "CreateIntent created the following intent: " + intent);
                }
                return intent;
            case 1:
                String[] strArr = (String[]) obj;
                F3.i.f(context, "context");
                F3.i.f(strArr, "input");
                Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
                F3.i.e(intentPutExtra, "Intent(ACTION_REQUEST_PE…EXTRA_PERMISSIONS, input)");
                return intentPutExtra;
            default:
                Intent intent3 = (Intent) obj;
                F3.i.f(context, "context");
                F3.i.f(intent3, "input");
                return intent3;
        }
    }

    @Override // d.AbstractC0422a
    public P.i b(Context context, Object obj) {
        switch (this.f3678a) {
            case 1:
                String[] strArr = (String[]) obj;
                F3.i.f(context, "context");
                F3.i.f(strArr, "input");
                if (strArr.length == 0) {
                    return new P.i(t3.r.f9712j);
                }
                for (String str : strArr) {
                    if (C.h.a(context, str) != 0) {
                        return null;
                    }
                }
                int iW = t3.u.w(strArr.length);
                if (iW < 16) {
                    iW = 16;
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap(iW);
                for (String str2 : strArr) {
                    linkedHashMap.put(str2, Boolean.TRUE);
                }
                return new P.i(linkedHashMap);
            default:
                return super.b(context, obj);
        }
    }

    @Override // d.AbstractC0422a
    public final Object c(Intent intent, int i5) {
        switch (this.f3678a) {
            case 0:
                return new androidx.activity.result.a(intent, i5);
            case 1:
                t3.r rVar = t3.r.f9712j;
                if (i5 != -1 || intent == null) {
                    return rVar;
                }
                String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
                int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
                if (intArrayExtra == null || stringArrayExtra == null) {
                    return rVar;
                }
                ArrayList arrayList = new ArrayList(intArrayExtra.length);
                for (int i6 : intArrayExtra) {
                    arrayList.add(Boolean.valueOf(i6 == 0));
                }
                ArrayList arrayListW = t3.h.w(stringArrayExtra);
                Iterator it = arrayListW.iterator();
                Iterator it2 = arrayList.iterator();
                ArrayList arrayList2 = new ArrayList(Math.min(t3.k.A(arrayListW), t3.k.A(arrayList)));
                while (it.hasNext() && it2.hasNext()) {
                    arrayList2.add(new C0895e(it.next(), it2.next()));
                }
                return t3.u.x(arrayList2);
            default:
                return new androidx.activity.result.a(intent, i5);
        }
    }
}
