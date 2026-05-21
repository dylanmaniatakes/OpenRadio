package androidx.emoji2.text;

import android.util.SparseArray;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public int f3620a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final p f3621b;

    /* renamed from: c, reason: collision with root package name */
    public p f3622c;

    /* renamed from: d, reason: collision with root package name */
    public p f3623d;

    /* renamed from: e, reason: collision with root package name */
    public int f3624e;

    /* renamed from: f, reason: collision with root package name */
    public int f3625f;

    public m(p pVar) {
        this.f3621b = pVar;
        this.f3622c = pVar;
    }

    public final int a(int i5) {
        SparseArray sparseArray = this.f3622c.f3633a;
        p pVar = sparseArray == null ? null : (p) sparseArray.get(i5);
        int i6 = 1;
        int i7 = 2;
        if (this.f3620a == 2) {
            if (pVar != null) {
                this.f3622c = pVar;
                this.f3625f++;
            } else if (i5 == 65038) {
                b();
            } else if (i5 != 65039) {
                p pVar2 = this.f3622c;
                if (pVar2.f3634b != null) {
                    i7 = 3;
                    if (this.f3625f != 1) {
                        this.f3623d = pVar2;
                        b();
                    } else if (c()) {
                        this.f3623d = this.f3622c;
                        b();
                    } else {
                        b();
                    }
                } else {
                    b();
                }
            }
            i6 = i7;
        } else if (pVar == null) {
            b();
        } else {
            this.f3620a = 2;
            this.f3622c = pVar;
            this.f3625f = 1;
            i6 = i7;
        }
        this.f3624e = i5;
        return i6;
    }

    public final void b() {
        this.f3620a = 1;
        this.f3622c = this.f3621b;
        this.f3625f = 0;
    }

    public final boolean c() {
        X.a aVarC = this.f3622c.f3634b.c();
        int iA = aVarC.a(6);
        return !(iA == 0 || ((ByteBuffer) aVarC.f1892d).get(iA + aVarC.f1889a) == 0) || this.f3624e == 65039;
    }
}
