package h4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class l extends LinkedHashMap {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7105j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ m f7106k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(m mVar, int i5, int i6) {
        super(i5, 0.1f, true);
        this.f7106k = mVar;
        this.f7105j = i6;
    }

    @Override // java.util.LinkedHashMap
    public final boolean removeEldestEntry(Map.Entry entry) {
        g4.f fVar;
        if (size() <= this.f7105j) {
            return false;
        }
        m mVar = this.f7106k;
        Iterator it = mVar.f7110d.keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Long l5 = (Long) it.next();
            long jLongValue = l5.longValue();
            if (!mVar.f7109c.containsKey(l5) && (fVar = (g4.f) mVar.f7110d.get(l5)) != null) {
                mVar.h(jLongValue);
                ((g4.e) fVar.f7065c).i(fVar);
                break;
            }
        }
        return false;
    }
}
