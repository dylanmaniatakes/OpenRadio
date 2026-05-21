package androidx.fragment.app;

import android.util.Log;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes.dex */
public final class J implements androidx.activity.result.b {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3669c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ T f3670d;

    public /* synthetic */ J(T t4, int i5) {
        this.f3669c = i5;
        this.f3670d = t4;
    }

    @Override // androidx.activity.result.b
    public final void e(Object obj) {
        switch (this.f3669c) {
            case 0:
                androidx.activity.result.a aVar = (androidx.activity.result.a) obj;
                T t4 = this.f3670d;
                O o5 = (O) t4.f3715x.pollFirst();
                if (o5 == null) {
                    Log.w("FragmentManager", "No IntentSenders were started for " + this);
                    break;
                } else {
                    c0 c0Var = t4.f3697c;
                    String str = o5.f3679j;
                    Fragment fragmentC = c0Var.c(str);
                    if (fragmentC == null) {
                        Log.w("FragmentManager", "Intent Sender result delivered for unknown Fragment " + str);
                        break;
                    } else {
                        fragmentC.onActivityResult(o5.f3680k, aVar.f3255j, aVar.f3256k);
                        break;
                    }
                }
            case 1:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    iArr[i5] = ((Boolean) arrayList.get(i5)).booleanValue() ? 0 : -1;
                }
                T t5 = this.f3670d;
                O o6 = (O) t5.f3715x.pollFirst();
                if (o6 == null) {
                    Log.w("FragmentManager", "No permissions were requested for " + this);
                    break;
                } else {
                    c0 c0Var2 = t5.f3697c;
                    String str2 = o6.f3679j;
                    Fragment fragmentC2 = c0Var2.c(str2);
                    if (fragmentC2 == null) {
                        Log.w("FragmentManager", "Permission request result delivered for unknown Fragment " + str2);
                        break;
                    } else {
                        fragmentC2.onRequestPermissionsResult(o6.f3680k, strArr, iArr);
                        break;
                    }
                }
            default:
                androidx.activity.result.a aVar2 = (androidx.activity.result.a) obj;
                T t6 = this.f3670d;
                O o7 = (O) t6.f3715x.pollFirst();
                if (o7 == null) {
                    Log.w("FragmentManager", "No Activities were started for result for " + this);
                    break;
                } else {
                    c0 c0Var3 = t6.f3697c;
                    String str3 = o7.f3679j;
                    Fragment fragmentC3 = c0Var3.c(str3);
                    if (fragmentC3 == null) {
                        Log.w("FragmentManager", "Activity result delivered for unknown Fragment " + str3);
                        break;
                    } else {
                        fragmentC3.onActivityResult(o7.f3680k, aVar2.f3255j, aVar2.f3256k);
                        break;
                    }
                }
        }
    }
}
