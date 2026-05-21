package t3;

import java.util.AbstractList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class d extends AbstractList implements List, G3.b {
    public abstract int a();

    public abstract Object b(int i5);

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ Object remove(int i5) {
        return b(i5);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ int size() {
        return a();
    }
}
