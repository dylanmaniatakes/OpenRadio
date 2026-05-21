package J1;

/* renamed from: J1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0050a implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f1095j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ String f1096k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f1097l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ A f1098m;

    public /* synthetic */ RunnableC0050a(A a2, String str, long j5, int i5) {
        this.f1095j = i5;
        this.f1096k = str;
        this.f1097l = j5;
        this.f1098m = a2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1095j) {
            case 0:
                A a2 = this.f1098m;
                a2.j();
                String str = this.f1096k;
                q1.E.f(str);
                q.b bVar = a2.f697e;
                boolean zIsEmpty = bVar.isEmpty();
                long j5 = this.f1097l;
                if (zIsEmpty) {
                    a2.f698f = j5;
                }
                Integer num = (Integer) bVar.getOrDefault(str, null);
                if (num == null) {
                    if (bVar.f9278l < 100) {
                        bVar.put(str, 1);
                        a2.f696d.put(str, Long.valueOf(j5));
                        break;
                    } else {
                        Z z4 = ((C0113v0) a2.f84c).f1417k;
                        C0113v0.k(z4);
                        z4.f1080k.a("Too many ads visible");
                        break;
                    }
                } else {
                    bVar.put(str, Integer.valueOf(num.intValue() + 1));
                    break;
                }
            default:
                A a3 = this.f1098m;
                a3.j();
                String str2 = this.f1096k;
                q1.E.f(str2);
                q.b bVar2 = a3.f697e;
                Integer num2 = (Integer) bVar2.getOrDefault(str2, null);
                C0113v0 c0113v0 = (C0113v0) a3.f84c;
                if (num2 == null) {
                    Z z5 = c0113v0.f1417k;
                    C0113v0.k(z5);
                    z5.h.b(str2, "Call to endAdUnitExposure for unknown ad unit id");
                    break;
                } else {
                    C0091n1 c0091n1 = c0113v0.f1422q;
                    C0113v0.j(c0091n1);
                    C0082k1 c0082k1Q = c0091n1.q(false);
                    int iIntValue = num2.intValue() - 1;
                    if (iIntValue != 0) {
                        bVar2.put(str2, Integer.valueOf(iIntValue));
                        break;
                    } else {
                        bVar2.remove(str2);
                        q.b bVar3 = a3.f696d;
                        Long l5 = (Long) bVar3.getOrDefault(str2, null);
                        long j6 = this.f1097l;
                        Z z6 = c0113v0.f1417k;
                        if (l5 == null) {
                            C0113v0.k(z6);
                            z6.h.a("First ad unit exposure time was never set");
                        } else {
                            long jLongValue = j6 - l5.longValue();
                            bVar3.remove(str2);
                            a3.o(str2, jLongValue, c0082k1Q);
                        }
                        if (bVar2.isEmpty()) {
                            long j7 = a3.f698f;
                            if (j7 != 0) {
                                a3.n(j6 - j7, c0082k1Q);
                                a3.f698f = 0L;
                                break;
                            } else {
                                C0113v0.k(z6);
                                z6.h.a("First ad exposure time was never set");
                                break;
                            }
                        }
                    }
                }
                break;
        }
    }
}
