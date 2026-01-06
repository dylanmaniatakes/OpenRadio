package J1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;

/* loaded from: classes.dex */
public final class Z0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1085j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f1086k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1087l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f1088m;
    public final /* synthetic */ Object n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ Object f1089o;

    public Z0(C0055b1 c0055b1, boolean z4, Uri uri, String str, String str2) {
        this.f1085j = 2;
        this.f1088m = z4;
        this.n = uri;
        this.f1086k = str;
        this.f1087l = str2;
        this.f1089o = c0055b1;
    }

    /* JADX WARN: Removed duplicated region for block: B:115:0x023a A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:116:0x023c A[Catch: RuntimeException -> 0x0229, TRY_LEAVE, TryCatch #7 {RuntimeException -> 0x0229, blocks: (B:102:0x01f5, B:104:0x0200, B:107:0x020d, B:109:0x0213, B:112:0x022e, B:113:0x0234, B:116:0x023c, B:118:0x0241, B:122:0x0258, B:124:0x0267, B:123:0x025f, B:125:0x027a, B:127:0x0280, B:129:0x0286, B:131:0x028c, B:133:0x0294, B:135:0x029c, B:137:0x02a4, B:139:0x02aa, B:140:0x02ba), top: B:163:0x01f5 }] */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 850
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.Z0.run():void");
    }

    public Z0(C0120x1 c0120x1, b2 b2Var, boolean z4, C0109u c0109u, Bundle bundle) {
        this.f1085j = 3;
        this.n = b2Var;
        this.f1088m = z4;
        this.f1086k = c0109u;
        this.f1087l = bundle;
        this.f1089o = c0120x1;
    }

    public /* synthetic */ Z0(FirebaseInstanceIdReceiver firebaseInstanceIdReceiver, Intent intent, Context context, boolean z4, BroadcastReceiver.PendingResult pendingResult) {
        this.f1085j = 4;
        this.n = firebaseInstanceIdReceiver;
        this.f1086k = intent;
        this.f1087l = context;
        this.f1088m = z4;
        this.f1089o = pendingResult;
    }

    public /* synthetic */ Z0(Object obj, Object obj2, String str, String str2, boolean z4, int i5) {
        this.f1085j = i5;
        this.n = obj2;
        this.f1086k = str;
        this.f1087l = str2;
        this.f1088m = z4;
        this.f1089o = obj;
    }
}
