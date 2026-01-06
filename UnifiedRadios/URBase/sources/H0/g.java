package H0;

import android.content.Context;
import androidx.lifecycle.M;
import androidx.lifecycle.X;
import java.io.File;
import l0.AbstractC0740p;
import q0.C0841d;
import q0.C0844g;
import q0.C0845h;

/* loaded from: classes.dex */
public final class g extends F3.j implements E3.a {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f651j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f652k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i5, Object obj) {
        super(0);
        this.f651j = i5;
        this.f652k = obj;
    }

    @Override // E3.a
    public final Object invoke() {
        C0844g c0844g;
        switch (this.f651j) {
            case 0:
                return new c[((Q3.e[]) this.f652k).length];
            case 1:
                return M.e((X) this.f652k);
            case 2:
                return ((AbstractC0740p) this.f652k).k();
            default:
                C0845h c0845h = (C0845h) this.f652k;
                if (c0845h.f9302k == null || !c0845h.f9304m) {
                    c0844g = new C0844g(c0845h.f9301j, c0845h.f9302k, new C0841d(), c0845h.f9303l, c0845h.n);
                } else {
                    Context context = c0845h.f9301j;
                    F3.i.f(context, "context");
                    File noBackupFilesDir = context.getNoBackupFilesDir();
                    F3.i.e(noBackupFilesDir, "context.noBackupFilesDir");
                    c0844g = new C0844g(c0845h.f9301j, new File(noBackupFilesDir, c0845h.f9302k).getAbsolutePath(), new C0841d(), c0845h.f9303l, c0845h.n);
                }
                c0844g.setWriteAheadLoggingEnabled(c0845h.f9306p);
                return c0844g;
        }
    }
}
