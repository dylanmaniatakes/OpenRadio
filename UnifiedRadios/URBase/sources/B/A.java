package B;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class A implements Iterable {

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f45j = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public final Context f46k;

    public A(Context context) {
        this.f46k = context;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.f45j.iterator();
    }
}
