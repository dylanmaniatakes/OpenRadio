package B;

import O.InterfaceC0172k;
import O.Y;
import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.InterfaceC0249t;
import androidx.lifecycle.J;
import androidx.lifecycle.M;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class i extends Activity implements InterfaceC0249t, InterfaceC0172k {
    private q.k mExtraDataMap = new q.k();
    private C0251v mLifecycleRegistry = new C0251v(this);

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (getWindow().getDecorView() != null) {
            WeakHashMap weakHashMap = Y.f1904a;
        }
        return superDispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
        if (getWindow().getDecorView() != null) {
            WeakHashMap weakHashMap = Y.f1904a;
        }
        return super.dispatchKeyShortcutEvent(keyEvent);
    }

    @Deprecated
    public <T extends h> T getExtraData(Class<T> cls) {
        com.unified.ur1.SatelliteTracker.h.p(this.mExtraDataMap.getOrDefault(cls, null));
        return null;
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        int i5 = J.f3913d;
        M.f(this);
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        C0251v c0251v = this.mLifecycleRegistry;
        c0251v.getClass();
        c0251v.d("markState");
        c0251v.g();
        super.onSaveInstanceState(bundle);
    }

    @Deprecated
    public void putExtraData(h hVar) {
        throw null;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean shouldDumpInternalState(java.lang.String[] r5) {
        /*
            r4 = this;
            r0 = 0
            r1 = 1
            if (r5 == 0) goto L64
            int r2 = r5.length
            if (r2 <= 0) goto L64
            r5 = r5[r0]
            r5.getClass()
            r2 = -1
            int r3 = r5.hashCode()
            switch(r3) {
                case -645125871: goto L41;
                case 100470631: goto L36;
                case 472614934: goto L2b;
                case 1159329357: goto L20;
                case 1455016274: goto L15;
                default: goto L14;
            }
        L14:
            goto L4b
        L15:
            java.lang.String r3 = "--autofill"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L1e
            goto L4b
        L1e:
            r2 = 4
            goto L4b
        L20:
            java.lang.String r3 = "--contentcapture"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L29
            goto L4b
        L29:
            r2 = 3
            goto L4b
        L2b:
            java.lang.String r3 = "--list-dumpables"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L34
            goto L4b
        L34:
            r2 = 2
            goto L4b
        L36:
            java.lang.String r3 = "--dump-dumpable"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L3f
            goto L4b
        L3f:
            r2 = r1
            goto L4b
        L41:
            java.lang.String r3 = "--translation"
            boolean r5 = r5.equals(r3)
            if (r5 != 0) goto L4a
            goto L4b
        L4a:
            r2 = r0
        L4b:
            switch(r2) {
                case 0: goto L5d;
                case 1: goto L58;
                case 2: goto L58;
                case 3: goto L51;
                case 4: goto L4f;
                default: goto L4e;
            }
        L4e:
            goto L64
        L4f:
            r0 = r1
            goto L64
        L51:
            int r5 = android.os.Build.VERSION.SDK_INT
            r2 = 29
            if (r5 < r2) goto L64
            goto L4f
        L58:
            boolean r0 = com.google.android.gms.internal.measurement.AbstractC0399v1.e()
            goto L64
        L5d:
            int r5 = android.os.Build.VERSION.SDK_INT
            r2 = 31
            if (r5 < r2) goto L64
            goto L4f
        L64:
            r5 = r0 ^ 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: B.i.shouldDumpInternalState(java.lang.String[]):boolean");
    }

    @Override // O.InterfaceC0172k
    public boolean superDispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }
}
