package O;

import android.view.ContentInfo;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class V {
    public static String[] a(View view) {
        return view.getReceiveContentMimeTypes();
    }

    public static C0164g b(View view, C0164g c0164g) {
        ContentInfo contentInfoM = c0164g.f1929a.m();
        Objects.requireNonNull(contentInfoM);
        ContentInfo contentInfoH = B.w.h(contentInfoM);
        ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoH);
        if (contentInfoPerformReceiveContent == null) {
            return null;
        }
        return contentInfoPerformReceiveContent == contentInfoH ? c0164g : new C0164g(new L0.l(contentInfoPerformReceiveContent));
    }

    public static void c(View view, String[] strArr, InterfaceC0184x interfaceC0184x) {
        if (interfaceC0184x == null) {
            view.setOnReceiveContentListener(strArr, null);
        } else {
            view.setOnReceiveContentListener(strArr, new W(interfaceC0184x));
        }
    }
}
