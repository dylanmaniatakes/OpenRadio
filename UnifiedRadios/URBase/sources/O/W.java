package O;

import android.view.ContentInfo;
import android.view.OnReceiveContentListener;
import android.view.View;
import java.util.Objects;

/* loaded from: classes.dex */
public final class W implements OnReceiveContentListener {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC0184x f1903a;

    public W(InterfaceC0184x interfaceC0184x) {
        this.f1903a = interfaceC0184x;
    }

    public final ContentInfo onReceiveContent(View view, ContentInfo contentInfo) {
        C0164g c0164g = new C0164g(new L0.l(contentInfo));
        C0164g c0164gA = ((S.s) this.f1903a).a(view, c0164g);
        if (c0164gA == null) {
            return null;
        }
        if (c0164gA == c0164g) {
            return contentInfo;
        }
        ContentInfo contentInfoM = c0164gA.f1929a.m();
        Objects.requireNonNull(contentInfoM);
        return B.w.h(contentInfoM);
    }
}
