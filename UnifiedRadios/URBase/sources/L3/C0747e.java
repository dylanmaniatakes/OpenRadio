package l3;

import k4.l;

/* renamed from: l3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0747e extends i4.e {
    @Override // i4.e, i4.d
    public final String d(long j5) {
        int i5 = (int) (j5 >> 58);
        int iG = l.g(j5);
        return String.format("https://server.arcgisonline.com/ArcGIS/rest/services/Reference/World_Boundaries_and_Places/MapServer/tile/%d/%d/%d", Integer.valueOf(i5), Integer.valueOf(l.h(j5)), Integer.valueOf(iG));
    }
}
