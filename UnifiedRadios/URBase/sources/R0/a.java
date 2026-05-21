package R0;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e, reason: collision with root package name */
    public static final B0.a f2194e = new B0.a(2);

    /* renamed from: a, reason: collision with root package name */
    public int f2195a;

    /* renamed from: b, reason: collision with root package name */
    public final int f2196b;

    /* renamed from: c, reason: collision with root package name */
    public final List f2197c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f2198d;

    public a(int i5, ArrayList arrayList, int i6, InputStream inputStream) {
        this.f2195a = i5;
        this.f2197c = arrayList;
        this.f2196b = i6;
        this.f2198d = inputStream;
    }

    public synchronized byte[] a(int i5) {
        for (int i6 = 0; i6 < ((ArrayList) this.f2198d).size(); i6++) {
            byte[] bArr = (byte[]) ((ArrayList) this.f2198d).get(i6);
            if (bArr.length >= i5) {
                this.f2195a -= bArr.length;
                ((ArrayList) this.f2198d).remove(i6);
                ((ArrayList) this.f2197c).remove(bArr);
                return bArr;
            }
        }
        return new byte[i5];
    }

    public synchronized void b(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length <= this.f2196b) {
                ((ArrayList) this.f2197c).add(bArr);
                int iBinarySearch = Collections.binarySearch((ArrayList) this.f2198d, bArr, f2194e);
                if (iBinarySearch < 0) {
                    iBinarySearch = (-iBinarySearch) - 1;
                }
                ((ArrayList) this.f2198d).add(iBinarySearch, bArr);
                this.f2195a += bArr.length;
                c();
            }
        }
    }

    public synchronized void c() {
        while (this.f2195a > this.f2196b) {
            byte[] bArr = (byte[]) ((ArrayList) this.f2197c).remove(0);
            ((ArrayList) this.f2198d).remove(bArr);
            this.f2195a -= bArr.length;
        }
    }

    public a() {
        this.f2197c = new ArrayList();
        this.f2198d = new ArrayList(64);
        this.f2195a = 0;
        this.f2196b = 4096;
    }
}
