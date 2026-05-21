package e0;

import D.n;
import L0.m;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.Toast;
import com.unified.ur1.primary.OptionsActivity;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import m3.p;

/* renamed from: e0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerC0430a extends Handler {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6138a;

    /* renamed from: b, reason: collision with root package name */
    public Object f6139b;

    public /* synthetic */ HandlerC0430a() {
        this.f6138a = 1;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int size;
        L0.c[] cVarArr;
        switch (this.f6138a) {
            case 0:
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                }
                C0432c c0432c = (C0432c) this.f6139b;
                while (true) {
                    synchronized (c0432c.f6146b) {
                        try {
                            size = c0432c.f6148d.size();
                            if (size <= 0) {
                                return;
                            }
                            cVarArr = new L0.c[size];
                            c0432c.f6148d.toArray(cVarArr);
                            c0432c.f6148d.clear();
                        } catch (Throwable th) {
                            throw th;
                        }
                    }
                    for (int i5 = 0; i5 < size; i5++) {
                        L0.c cVar = cVarArr[i5];
                        int size2 = ((ArrayList) cVar.f1537e).size();
                        for (int i6 = 0; i6 < size2; i6++) {
                            C0431b c0431b = (C0431b) ((ArrayList) cVar.f1537e).get(i6);
                            if (!c0431b.f6143d) {
                                c0431b.f6141b.onReceive(c0432c.f6145a, (Intent) cVar.f1536d);
                            }
                        }
                    }
                }
            case 1:
                int i7 = message.what;
                if (i7 == -3 || i7 == -2 || i7 == -1) {
                    ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.f6139b).get(), message.what);
                    return;
                } else {
                    if (i7 != 1) {
                        return;
                    }
                    ((DialogInterface) message.obj).dismiss();
                    return;
                }
            case 2:
                OptionsActivity optionsActivity = (OptionsActivity) this.f6139b;
                if (optionsActivity.isFinishing()) {
                    return;
                }
                Object obj = message.obj;
                if (obj != null) {
                    Toast.makeText(optionsActivity, (String) obj, 0).show();
                }
                if (message.what == 1) {
                    d3.a.a("Firmware update successful");
                    return;
                }
                d3.a.b("Firmware update failed: " + message.obj, new Object[0]);
                return;
            default:
                if (message.what == 1) {
                    int i8 = message.arg1;
                    m mVar = (m) this.f6139b;
                    if (((p) mVar.f1556d) != null) {
                        ((HandlerC0430a) mVar.f1558f).post(new n(i8, 7, mVar));
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerC0430a(Object obj, Looper looper, int i5) {
        super(looper);
        this.f6138a = i5;
        this.f6139b = obj;
    }
}
