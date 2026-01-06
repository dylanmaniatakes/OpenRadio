package B0;

import com.unified.ur1.inbox.UnifiedInboxActivity;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class c extends k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f88a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f89b;

    public c() {
        this.f88a = 0;
        this.f89b = new ArrayList(3);
    }

    @Override // B0.k
    public void a(int i5) {
        switch (this.f88a) {
            case 0:
                try {
                    Iterator it = ((ArrayList) this.f89b).iterator();
                    while (it.hasNext()) {
                        ((k) it.next()).a(i5);
                    }
                    return;
                } catch (ConcurrentModificationException e5) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e5);
                }
            case 1:
                ((androidx.viewpager2.adapter.a) this.f89b).b(false);
                return;
            default:
                return;
        }
    }

    @Override // B0.k
    public void b(int i5, float f5, int i6) {
        switch (this.f88a) {
            case 0:
                try {
                    Iterator it = ((ArrayList) this.f89b).iterator();
                    while (it.hasNext()) {
                        ((k) it.next()).b(i5, f5, i6);
                    }
                    return;
                } catch (ConcurrentModificationException e5) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e5);
                }
            default:
                return;
        }
    }

    @Override // B0.k
    public final void c(int i5) {
        switch (this.f88a) {
            case 0:
                try {
                    Iterator it = ((ArrayList) this.f89b).iterator();
                    while (it.hasNext()) {
                        ((k) it.next()).c(i5);
                    }
                    return;
                } catch (ConcurrentModificationException e5) {
                    throw new IllegalStateException("Adding and removing callbacks during dispatch to callbacks is not supported", e5);
                }
            case 1:
                ((androidx.viewpager2.adapter.a) this.f89b).b(false);
                return;
            default:
                UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f89b;
                if (unifiedInboxActivity.getSupportActionBar() != null) {
                    if (i5 == 0) {
                        unifiedInboxActivity.getSupportActionBar().p("Inbox - " + unifiedInboxActivity.f5836j);
                        return;
                    }
                    if (i5 != 1) {
                        return;
                    }
                    unifiedInboxActivity.getSupportActionBar().p("Sent - " + unifiedInboxActivity.f5836j);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ c(int i5, Object obj) {
        this.f88a = i5;
        this.f89b = obj;
    }
}
