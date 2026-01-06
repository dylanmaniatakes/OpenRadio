package p1;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import i3.C0573b;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class I extends Fragment implements k {

    /* renamed from: d, reason: collision with root package name */
    public static final WeakHashMap f9102d = new WeakHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final C0573b f9103c = new C0573b();

    @Override // p1.k
    public final void a(q qVar) {
        this.f9103c.p(qVar);
    }

    @Override // p1.k
    public final q b() {
        return (q) q.class.cast(((Map) this.f9103c.f7296d).get("ConnectionlessLifecycleHelper"));
    }

    @Override // androidx.fragment.app.Fragment
    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        Iterator it = ((Map) this.f9103c.f7296d).values().iterator();
        while (it.hasNext()) {
            ((q) it.next()).getClass();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        this.f9103c.q(i5, i6, intent);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f9103c.r(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        C0573b c0573b = this.f9103c;
        c0573b.f7295c = 5;
        Iterator it = ((Map) c0573b.f7296d).values().iterator();
        while (it.hasNext()) {
            ((q) it.next()).getClass();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        C0573b c0573b = this.f9103c;
        c0573b.f7295c = 3;
        Iterator it = ((Map) c0573b.f7296d).values().iterator();
        while (it.hasNext()) {
            ((q) it.next()).d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle bundle) {
        this.f9103c.s(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        C0573b c0573b = this.f9103c;
        c0573b.f7295c = 2;
        for (q qVar : ((Map) c0573b.f7296d).values()) {
            qVar.f9131d = true;
            qVar.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        C0573b c0573b = this.f9103c;
        c0573b.f7295c = 4;
        Iterator it = ((Map) c0573b.f7296d).values().iterator();
        while (it.hasNext()) {
            ((q) it.next()).c();
        }
    }
}
