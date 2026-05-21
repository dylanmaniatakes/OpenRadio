package R0;

import Q0.o;
import com.unified.ur1.SatelliteTracker.h;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public long f2199a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2200b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2201c;

    /* renamed from: d, reason: collision with root package name */
    public final long f2202d;

    /* renamed from: e, reason: collision with root package name */
    public final long f2203e;

    /* renamed from: f, reason: collision with root package name */
    public final long f2204f;
    public final long g;
    public final List h;

    public b(String str, String str2, long j5, long j6, long j7, long j8, List list) {
        this.f2200b = str;
        this.f2201c = "".equals(str2) ? null : str2;
        this.f2202d = j5;
        this.f2203e = j6;
        this.f2204f = j7;
        this.g = j8;
        this.h = list;
    }

    public static b a(c cVar) throws IOException {
        if (d.i(cVar) != 538247942) {
            throw new IOException();
        }
        String strK = d.k(cVar);
        String strK2 = d.k(cVar);
        long j5 = d.j(cVar);
        long j6 = d.j(cVar);
        long j7 = d.j(cVar);
        long j8 = d.j(cVar);
        int i5 = d.i(cVar);
        if (i5 < 0) {
            throw new IOException(h.a(i5, "readHeaderList size="));
        }
        List listEmptyList = i5 == 0 ? Collections.emptyList() : new ArrayList();
        for (int i6 = 0; i6 < i5; i6++) {
            listEmptyList.add(new Q0.f(d.k(cVar).intern(), d.k(cVar).intern()));
        }
        return new b(strK, strK2, j5, j6, j7, j8, listEmptyList);
    }

    public final Q0.b b(byte[] bArr) {
        Q0.b bVar = new Q0.b();
        bVar.f2129a = bArr;
        bVar.f2130b = this.f2201c;
        bVar.f2131c = this.f2202d;
        bVar.f2132d = this.f2203e;
        bVar.f2133e = this.f2204f;
        bVar.f2134f = this.g;
        TreeMap treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        List<Q0.f> list = this.h;
        for (Q0.f fVar : list) {
            treeMap.put(fVar.f2143a, fVar.f2144b);
        }
        bVar.g = treeMap;
        bVar.h = Collections.unmodifiableList(list);
        return bVar;
    }

    public final boolean c(BufferedOutputStream bufferedOutputStream) throws IOException {
        try {
            d.m(bufferedOutputStream, 538247942);
            d.o(bufferedOutputStream, this.f2200b);
            String str = this.f2201c;
            if (str == null) {
                str = "";
            }
            d.o(bufferedOutputStream, str);
            d.n(bufferedOutputStream, this.f2202d);
            d.n(bufferedOutputStream, this.f2203e);
            d.n(bufferedOutputStream, this.f2204f);
            d.n(bufferedOutputStream, this.g);
            List<Q0.f> list = this.h;
            if (list != null) {
                d.m(bufferedOutputStream, list.size());
                for (Q0.f fVar : list) {
                    d.o(bufferedOutputStream, fVar.f2143a);
                    d.o(bufferedOutputStream, fVar.f2144b);
                }
            } else {
                d.m(bufferedOutputStream, 0);
            }
            bufferedOutputStream.flush();
            return true;
        } catch (IOException e5) {
            o.b("%s", e5.toString());
            return false;
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2 */
    public b(String str, Q0.b bVar) {
        String str2 = bVar.f2130b;
        long j5 = bVar.f2131c;
        long j6 = bVar.f2132d;
        long j7 = bVar.f2133e;
        long j8 = bVar.f2134f;
        List arrayList = bVar.h;
        if (arrayList == 0) {
            Map map = bVar.g;
            arrayList = new ArrayList(map.size());
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(new Q0.f((String) entry.getKey(), (String) entry.getValue()));
            }
        }
        this(str, str2, j5, j6, j7, j8, arrayList);
    }
}
