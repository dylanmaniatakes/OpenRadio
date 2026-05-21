package G0;

import C0.t;
import C0.u;
import android.content.ComponentName;
import android.content.Context;
import androidx.work.impl.background.systemjob.SystemJobService;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final String f604c = t.f("SystemJobInfoConverter");

    /* renamed from: a, reason: collision with root package name */
    public final ComponentName f605a;

    /* renamed from: b, reason: collision with root package name */
    public final u f606b;

    public a(Context context, u uVar) {
        this.f606b = uVar;
        this.f605a = new ComponentName(context.getApplicationContext(), (Class<?>) SystemJobService.class);
    }
}
