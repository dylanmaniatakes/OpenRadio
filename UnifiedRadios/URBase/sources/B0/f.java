package B0;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.a0;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class f extends a0 {

    /* renamed from: a, reason: collision with root package name */
    public k f93a;

    /* renamed from: b, reason: collision with root package name */
    public final ViewPager2 f94b;

    /* renamed from: c, reason: collision with root package name */
    public final RecyclerView f95c;

    /* renamed from: d, reason: collision with root package name */
    public final LinearLayoutManager f96d;

    /* renamed from: e, reason: collision with root package name */
    public int f97e;

    /* renamed from: f, reason: collision with root package name */
    public int f98f;
    public final e g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f99i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f100j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f101k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f102l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f103m;

    public f(ViewPager2 viewPager2) {
        this.f94b = viewPager2;
        o oVar = viewPager2.f4467l;
        this.f95c = oVar;
        this.f96d = (LinearLayoutManager) oVar.getLayoutManager();
        this.g = new e();
        d();
    }

    @Override // androidx.recyclerview.widget.a0
    public final void a(int i5, RecyclerView recyclerView) {
        k kVar;
        k kVar2;
        int i6 = this.f97e;
        boolean z4 = true;
        if (!(i6 == 1 && this.f98f == 1) && i5 == 1) {
            this.f103m = false;
            this.f97e = 1;
            int i7 = this.f99i;
            if (i7 != -1) {
                this.h = i7;
                this.f99i = -1;
            } else if (this.h == -1) {
                this.h = this.f96d.M0();
            }
            c(1);
            return;
        }
        if ((i6 == 1 || i6 == 4) && i5 == 2) {
            if (this.f101k) {
                c(2);
                this.f100j = true;
                return;
            }
            return;
        }
        if (i6 != 1 && i6 != 4) {
            z4 = false;
        }
        e eVar = this.g;
        if (z4 && i5 == 0) {
            e();
            if (!this.f101k) {
                int i8 = eVar.f90a;
                if (i8 != -1 && (kVar2 = this.f93a) != null) {
                    kVar2.b(i8, BitmapDescriptorFactory.HUE_RED, 0);
                }
            } else if (eVar.f92c == 0) {
                int i9 = this.h;
                int i10 = eVar.f90a;
                if (i9 != i10 && (kVar = this.f93a) != null) {
                    kVar.c(i10);
                }
            }
            c(0);
            d();
        }
        if (this.f97e == 2 && i5 == 0 && this.f102l) {
            e();
            if (eVar.f92c == 0) {
                int i11 = this.f99i;
                int i12 = eVar.f90a;
                if (i11 != i12) {
                    if (i12 == -1) {
                        i12 = 0;
                    }
                    k kVar3 = this.f93a;
                    if (kVar3 != null) {
                        kVar3.c(i12);
                    }
                }
                c(0);
                d();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0028  */
    @Override // androidx.recyclerview.widget.a0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(androidx.recyclerview.widget.RecyclerView r6, int r7, int r8) {
        /*
            r5 = this;
            r6 = 1
            r5.f101k = r6
            r5.e()
            boolean r0 = r5.f100j
            B0.e r1 = r5.g
            r2 = -1
            r3 = 0
            if (r0 == 0) goto L40
            r5.f100j = r3
            if (r8 > 0) goto L28
            if (r8 != 0) goto L30
            if (r7 >= 0) goto L18
            r7 = r6
            goto L19
        L18:
            r7 = r3
        L19:
            androidx.viewpager2.widget.ViewPager2 r8 = r5.f94b
            B0.j r8 = r8.f4464i
            int r8 = r8.A()
            if (r8 != r6) goto L25
            r8 = r6
            goto L26
        L25:
            r8 = r3
        L26:
            if (r7 != r8) goto L30
        L28:
            int r7 = r1.f92c
            if (r7 == 0) goto L30
            int r7 = r1.f90a
            int r7 = r7 + r6
            goto L32
        L30:
            int r7 = r1.f90a
        L32:
            r5.f99i = r7
            int r8 = r5.h
            if (r8 == r7) goto L50
            B0.k r8 = r5.f93a
            if (r8 == 0) goto L50
            r8.c(r7)
            goto L50
        L40:
            int r7 = r5.f97e
            if (r7 != 0) goto L50
            int r7 = r1.f90a
            if (r7 != r2) goto L49
            r7 = r3
        L49:
            B0.k r8 = r5.f93a
            if (r8 == 0) goto L50
            r8.c(r7)
        L50:
            int r7 = r1.f90a
            if (r7 != r2) goto L55
            r7 = r3
        L55:
            float r8 = r1.f91b
            int r0 = r1.f92c
            B0.k r4 = r5.f93a
            if (r4 == 0) goto L60
            r4.b(r7, r8, r0)
        L60:
            int r7 = r1.f90a
            int r8 = r5.f99i
            if (r7 == r8) goto L68
            if (r8 != r2) goto L76
        L68:
            int r7 = r1.f92c
            if (r7 != 0) goto L76
            int r7 = r5.f98f
            if (r7 == r6) goto L76
            r5.c(r3)
            r5.d()
        L76:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.f.b(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    public final void c(int i5) {
        if ((this.f97e == 3 && this.f98f == 0) || this.f98f == i5) {
            return;
        }
        this.f98f = i5;
        k kVar = this.f93a;
        if (kVar != null) {
            kVar.a(i5);
        }
    }

    public final void d() {
        this.f97e = 0;
        this.f98f = 0;
        e eVar = this.g;
        eVar.f90a = -1;
        eVar.f91b = BitmapDescriptorFactory.HUE_RED;
        eVar.f92c = 0;
        this.h = -1;
        this.f99i = -1;
        this.f100j = false;
        this.f101k = false;
        this.f103m = false;
        this.f102l = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x013e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void e() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: B0.f.e():void");
    }
}
