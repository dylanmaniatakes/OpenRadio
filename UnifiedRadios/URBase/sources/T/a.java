package T;

import D0.w;
import android.database.ContentObserver;
import android.database.Cursor;
import android.os.Handler;
import com.google.android.gms.internal.measurement.C0419z1;
import com.unified.ur1.SatelliteTracker.h;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class a extends ContentObserver {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2429a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2430b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(int i5, Object obj) {
        super(null);
        this.f2429a = i5;
        this.f2430b = obj;
    }

    @Override // android.database.ContentObserver
    public boolean deliverSelfNotifications() {
        switch (this.f2429a) {
            case 0:
                return true;
            default:
                return super.deliverSelfNotifications();
        }
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z4) {
        Cursor cursor;
        switch (this.f2429a) {
            case 0:
                c cVar = (c) this.f2430b;
                if (!cVar.f2434d || (cursor = cVar.f2435e) == null || cursor.isClosed()) {
                    return;
                }
                cVar.f2433c = cVar.f2435e.requery();
                return;
            case 1:
                ((AtomicBoolean) ((w) this.f2430b).f309b).set(true);
                return;
            default:
                C0419z1 c0419z1 = (C0419z1) this.f2430b;
                synchronized (c0419z1.f5147e) {
                    c0419z1.f5148f = null;
                    c0419z1.f5145c.run();
                }
                synchronized (c0419z1) {
                    try {
                        Iterator it = c0419z1.g.iterator();
                        if (it.hasNext()) {
                            h.p(it.next());
                            throw null;
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar) {
        super(new Handler());
        this.f2429a = 0;
        this.f2430b = cVar;
    }
}
