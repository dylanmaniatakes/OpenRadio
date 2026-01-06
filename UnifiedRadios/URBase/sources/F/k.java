package f;

import android.content.Context;

/* loaded from: classes.dex */
public final /* synthetic */ class k implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6348j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Context f6349k;

    public /* synthetic */ k(Context context, int i5) {
        this.f6348j = i5;
        this.f6349k = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009e  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() throws java.lang.Throwable {
        /*
            r11 = this;
            int r0 = r11.f6348j
            switch(r0) {
                case 0: goto L31;
                case 1: goto L14;
                default: goto L5;
            }
        L5:
            i0.c r0 = new i0.c
            r1 = 0
            r0.<init>(r1)
            h1.b r1 = j0.AbstractC0592e.f7543a
            r2 = 0
            android.content.Context r3 = r11.f6349k
            j0.AbstractC0592e.s(r3, r0, r1, r2)
            return
        L14:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            java.util.concurrent.TimeUnit r9 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.LinkedBlockingQueue r10 = new java.util.concurrent.LinkedBlockingQueue
            r10.<init>()
            r5 = 0
            r6 = 1
            r7 = 0
            r4 = r0
            r4.<init>(r5, r6, r7, r9, r10)
            f.k r1 = new f.k
            android.content.Context r2 = r11.f6349k
            r3 = 2
            r1.<init>(r2, r3)
            r0.execute(r1)
            return
        L31:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 33
            r2 = 1
            if (r0 < r1) goto Lb6
            android.content.ComponentName r0 = new android.content.ComponentName
            android.content.Context r1 = r11.f6349k
            java.lang.String r3 = "androidx.appcompat.app.AppLocalesMetadataHolderService"
            r0.<init>(r1, r3)
            android.content.pm.PackageManager r3 = r1.getPackageManager()
            int r3 = r3.getComponentEnabledSetting(r0)
            if (r3 == r2) goto Lb6
            boolean r3 = com.google.android.gms.internal.measurement.AbstractC0399v1.e()
            java.lang.String r4 = "locale"
            if (r3 == 0) goto L8d
            q.c r3 = f.n.f6354i
            java.util.Iterator r3 = r3.iterator()
        L59:
            r5 = r3
            q.g r5 = (q.g) r5
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L7b
            java.lang.Object r5 = r5.next()
            java.lang.ref.WeakReference r5 = (java.lang.ref.WeakReference) r5
            java.lang.Object r5 = r5.get()
            f.n r5 = (f.n) r5
            if (r5 == 0) goto L59
            f.x r5 = (f.x) r5
            android.content.Context r5 = r5.f6423m
            if (r5 == 0) goto L59
            java.lang.Object r3 = r5.getSystemService(r4)
            goto L7c
        L7b:
            r3 = 0
        L7c:
            if (r3 == 0) goto L92
            android.os.LocaleList r3 = f.m.a(r3)
            K.i r5 = new K.i
            K.j r6 = new K.j
            r6.<init>(r3)
            r5.<init>(r6)
            goto L94
        L8d:
            K.i r5 = f.n.f6352e
            if (r5 == 0) goto L92
            goto L94
        L92:
            K.i r5 = K.i.f1488b
        L94:
            K.j r3 = r5.f1489a
            android.os.LocaleList r3 = r3.f1490a
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto Laf
            java.lang.String r3 = h4.d.m(r1)
            java.lang.Object r4 = r1.getSystemService(r4)
            if (r4 == 0) goto Laf
            android.os.LocaleList r3 = f.l.a(r3)
            f.m.b(r4, r3)
        Laf:
            android.content.pm.PackageManager r1 = r1.getPackageManager()
            r1.setComponentEnabledSetting(r0, r2, r2)
        Lb6:
            f.n.h = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.k.run():void");
    }
}
