package L2;

import M2.f;
import java.util.Map;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements J2.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1611a;

    @Override // J2.a
    public final void a(Object obj, Object obj2) {
        switch (this.f1611a) {
            case 0:
                throw new J2.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
            case 1:
                Map.Entry entry = (Map.Entry) obj;
                J2.e eVar = (J2.e) obj2;
                eVar.e(f.g, entry.getKey());
                eVar.e(f.h, entry.getValue());
                return;
            default:
                throw new J2.b("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
        }
    }
}
