package m4;

import J1.C0106t;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public final class a implements Iterable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b f8649j;

    public a(b bVar) {
        this.f8649j = bVar;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        while (true) {
            try {
                CopyOnWriteArrayList copyOnWriteArrayList = this.f8649j.f8651k;
                return new C0106t(copyOnWriteArrayList.listIterator(copyOnWriteArrayList.size()));
            } catch (IndexOutOfBoundsException unused) {
            }
        }
    }
}
