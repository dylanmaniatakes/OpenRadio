package d0;

import androidx.lifecycle.InterfaceC0249t;
import androidx.lifecycle.W;
import com.unified.ur1.SatelliteTracker.h;
import f3.C0513e;
import java.io.PrintWriter;
import q.l;

/* renamed from: d0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0425c extends AbstractC0423a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0249t f6099a;

    /* renamed from: b, reason: collision with root package name */
    public final C0424b f6100b;

    public C0425c(InterfaceC0249t interfaceC0249t, W w4) {
        this.f6099a = interfaceC0249t;
        this.f6100b = (C0424b) new C0513e(w4, C0424b.f6097e).c(C0424b.class);
    }

    public final void b(String str, PrintWriter printWriter) {
        l lVar = this.f6100b.f6098d;
        if (lVar.f9282l > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (lVar.f9282l <= 0) {
                return;
            }
            h.p(lVar.f9281k[0]);
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(lVar.f9280j[0]);
            printWriter.print(": ");
            throw null;
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        InterfaceC0249t interfaceC0249t = this.f6099a;
        if (interfaceC0249t == null) {
            sb.append("null");
        } else {
            String simpleName = interfaceC0249t.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = interfaceC0249t.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(iLastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(interfaceC0249t)));
        }
        sb.append("}}");
        return sb.toString();
    }
}
