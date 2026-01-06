package Z0;

import L0.s;
import android.content.Context;
import com.google.android.datatransport.cct.CctBackendFactory;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final s f3072a;

    /* renamed from: b, reason: collision with root package name */
    public final d f3073b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f3074c;

    public e(Context context, d dVar) {
        s sVar = new s(context);
        this.f3074c = new HashMap();
        this.f3072a = sVar;
        this.f3073b = dVar;
    }

    public final synchronized f a(String str) {
        if (this.f3074c.containsKey(str)) {
            return (f) this.f3074c.get(str);
        }
        CctBackendFactory cctBackendFactoryG = this.f3072a.g(str);
        if (cctBackendFactoryG == null) {
            return null;
        }
        d dVar = this.f3073b;
        f fVarCreate = cctBackendFactoryG.create(new b(dVar.f3069a, dVar.f3070b, dVar.f3071c, str));
        this.f3074c.put(str, fVarCreate);
        return fVarCreate;
    }
}
