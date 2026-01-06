package androidx.recyclerview.widget;

import android.database.Observable;

/* loaded from: classes.dex */
public final class O extends Observable {
    public final boolean a() {
        return !((Observable) this).mObservers.isEmpty();
    }

    public final void b() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((P) ((Observable) this).mObservers.get(size)).a();
        }
    }

    public final void c(int i5, int i6) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((P) ((Observable) this).mObservers.get(size)).d(i5, i6);
        }
    }

    public final void d(int i5, int i6, Object obj) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((P) ((Observable) this).mObservers.get(size)).b(i5, i6, obj);
        }
    }

    public final void e(int i5, int i6) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((P) ((Observable) this).mObservers.get(size)).c(i5, i6);
        }
    }

    public final void f(int i5, int i6) {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((P) ((Observable) this).mObservers.get(size)).e(i5, i6);
        }
    }

    public final void g() {
        for (int size = ((Observable) this).mObservers.size() - 1; size >= 0; size--) {
            ((P) ((Observable) this).mObservers.get(size)).f();
        }
    }
}
