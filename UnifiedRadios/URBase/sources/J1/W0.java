package J1;

/* loaded from: classes.dex */
public final class W0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1044j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f1045k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1046l;

    public /* synthetic */ W0(Object obj, boolean z4, int i5) {
        this.f1044j = i5;
        this.f1045k = z4;
        this.f1046l = obj;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c2  */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r9 = this;
            int r0 = r9.f1044j
            switch(r0) {
                case 0: goto L72;
                default: goto L5;
            }
        L5:
            com.unified.ur1.adapters.AppDatabase r0 = k3.C0.g
            f3.e r0 = r0.q()
            java.lang.String r1 = "hidePTT"
            f3.d r0 = r0.e(r1)
            java.lang.String r2 = "1"
            java.lang.Object r3 = r9.f1046l
            com.unified.ur1.primary.AppSettings r3 = (com.unified.ur1.primary.AppSettings) r3
            boolean r4 = r9.f1045k
            java.lang.String r5 = ""
            if (r0 != 0) goto L4b
            f3.d r0 = new f3.d
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r0.<init>(r1, r4)
            com.unified.ur1.adapters.AppDatabase r4 = k3.C0.g
            f3.e r4 = r4.q()
            f3.d[] r0 = new f3.C0511d[]{r0}
            r4.g(r0)
            android.content.SharedPreferences r0 = h4.c.C(r3)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            android.content.SharedPreferences$Editor r0 = r0.putString(r1, r2)
            r0.apply()
            goto L71
        L4b:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r0.f6684b = r4
            com.unified.ur1.adapters.AppDatabase r4 = k3.C0.g
            f3.e r4 = r4.q()
            r4.j(r0)
            android.content.SharedPreferences r0 = h4.c.C(r3)
            android.content.SharedPreferences$Editor r0 = r0.edit()
            android.content.SharedPreferences$Editor r0 = r0.putString(r1, r2)
            r0.apply()
        L71:
            return
        L72:
            java.lang.Object r0 = r9.f1046l
            J1.c1 r0 = (J1.C0058c1) r0
            java.lang.Object r1 = r0.f84c
            J1.v0 r1 = (J1.C0113v0) r1
            boolean r2 = r1.b()
            java.lang.Boolean r3 = r1.f1406D
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L8e
            java.lang.Boolean r3 = r1.f1406D
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L8e
            r3 = r5
            goto L8f
        L8e:
            r3 = r4
        L8f:
            boolean r6 = r9.f1045k
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            r1.f1406D = r7
            if (r3 != r6) goto La9
            J1.Z r3 = r1.f1417k
            J1.C0113v0.k(r3)
            J1.X r3 = r3.f1084p
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r6)
            java.lang.String r8 = "Default data collection state already set to"
            r3.b(r7, r8)
        La9:
            boolean r3 = r1.b()
            if (r3 == r2) goto Lc2
            boolean r3 = r1.b()
            java.lang.Boolean r7 = r1.f1406D
            if (r7 == 0) goto Lc0
            java.lang.Boolean r7 = r1.f1406D
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto Lc0
            r4 = r5
        Lc0:
            if (r3 == r4) goto Ld6
        Lc2:
            J1.Z r1 = r1.f1417k
            J1.C0113v0.k(r1)
            J1.X r1 = r1.f1082m
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r6)
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r4 = "Default data collection is different than actual status"
            r1.c(r3, r2, r4)
        Ld6:
            r0.G()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: J1.W0.run():void");
    }
}
