package Y0;

import f3.C0519j;
import java.io.Closeable;
import m3.C0777m;
import r3.InterfaceC0877a;

/* loaded from: classes.dex */
public final class k implements Closeable {

    /* renamed from: j, reason: collision with root package name */
    public InterfaceC0877a f2916j;

    /* renamed from: k, reason: collision with root package name */
    public C0519j f2917k;

    /* renamed from: l, reason: collision with root package name */
    public InterfaceC0877a f2918l;

    /* renamed from: m, reason: collision with root package name */
    public C0777m f2919m;
    public InterfaceC0877a n;

    /* renamed from: o, reason: collision with root package name */
    public InterfaceC0877a f2920o;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        ((f1.j) ((f1.d) this.n.get())).close();
    }
}
