package M2;

import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import g0.AbstractC0535a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class f implements J2.e {

    /* renamed from: f, reason: collision with root package name */
    public static final Charset f1728f = Charset.forName("UTF-8");
    public static final J2.c g = new J2.c("key", AbstractC0535a.o(AbstractC0535a.n(e.class, new a(1))));
    public static final J2.c h = new J2.c("value", AbstractC0535a.o(AbstractC0535a.n(e.class, new a(2))));

    /* renamed from: i, reason: collision with root package name */
    public static final L2.a f1729i = new L2.a(1);

    /* renamed from: a, reason: collision with root package name */
    public OutputStream f1730a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f1731b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f1732c;

    /* renamed from: d, reason: collision with root package name */
    public final J2.d f1733d;

    /* renamed from: e, reason: collision with root package name */
    public final h f1734e = new h(this);

    public f(ByteArrayOutputStream byteArrayOutputStream, Map map, Map map2, J2.d dVar) {
        this.f1730a = byteArrayOutputStream;
        this.f1731b = map;
        this.f1732c = map2;
        this.f1733d = dVar;
    }

    public static int g(J2.c cVar) {
        e eVar = (e) ((Annotation) cVar.f1474b.get(e.class));
        if (eVar != null) {
            return ((a) eVar).f1724a;
        }
        throw new J2.b("Field has no @Protobuf config");
    }

    @Override // J2.e
    public final J2.e a(J2.c cVar, long j5) throws IOException {
        if (j5 != 0) {
            e eVar = (e) ((Annotation) cVar.f1474b.get(e.class));
            if (eVar == null) {
                throw new J2.b("Field has no @Protobuf config");
            }
            h(((a) eVar).f1724a << 3);
            i(j5);
        }
        return this;
    }

    @Override // J2.e
    public final J2.e b(J2.c cVar, int i5) {
        c(cVar, i5, true);
        return this;
    }

    public final void c(J2.c cVar, int i5, boolean z4) {
        if (z4 && i5 == 0) {
            return;
        }
        e eVar = (e) ((Annotation) cVar.f1474b.get(e.class));
        if (eVar == null) {
            throw new J2.b("Field has no @Protobuf config");
        }
        h(((a) eVar).f1724a << 3);
        h(i5);
    }

    public final void d(J2.c cVar, Object obj, boolean z4) {
        if (obj == null) {
            return;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z4 && charSequence.length() == 0) {
                return;
            }
            h((g(cVar) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f1728f);
            h(bytes.length);
            this.f1730a.write(bytes);
            return;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                d(cVar, it.next(), false);
            }
            return;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                f(f1729i, cVar, (Map.Entry) it2.next(), false);
            }
            return;
        }
        if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (z4 && dDoubleValue == 0.0d) {
                return;
            }
            h((g(cVar) << 3) | 1);
            this.f1730a.write(ByteBuffer.allocate(8).order(ByteOrder.LITTLE_ENDIAN).putDouble(dDoubleValue).array());
            return;
        }
        if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (z4 && fFloatValue == BitmapDescriptorFactory.HUE_RED) {
                return;
            }
            h((g(cVar) << 3) | 5);
            this.f1730a.write(ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putFloat(fFloatValue).array());
            return;
        }
        if (obj instanceof Number) {
            long jLongValue = ((Number) obj).longValue();
            if (z4 && jLongValue == 0) {
                return;
            }
            e eVar = (e) ((Annotation) cVar.f1474b.get(e.class));
            if (eVar == null) {
                throw new J2.b("Field has no @Protobuf config");
            }
            h(((a) eVar).f1724a << 3);
            i(jLongValue);
            return;
        }
        if (obj instanceof Boolean) {
            c(cVar, ((Boolean) obj).booleanValue() ? 1 : 0, z4);
            return;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z4 && bArr.length == 0) {
                return;
            }
            h((g(cVar) << 3) | 2);
            h(bArr.length);
            this.f1730a.write(bArr);
            return;
        }
        J2.d dVar = (J2.d) this.f1731b.get(obj.getClass());
        if (dVar != null) {
            f(dVar, cVar, obj, z4);
            return;
        }
        J2.f fVar = (J2.f) this.f1732c.get(obj.getClass());
        if (fVar != null) {
            h hVar = this.f1734e;
            hVar.f1736a = false;
            hVar.f1738c = cVar;
            hVar.f1737b = z4;
            fVar.a(obj, hVar);
            return;
        }
        if (obj instanceof c) {
            c(cVar, ((c) obj).a(), true);
        } else if (obj instanceof Enum) {
            c(cVar, ((Enum) obj).ordinal(), true);
        } else {
            f(this.f1733d, cVar, obj, z4);
        }
    }

    @Override // J2.e
    public final J2.e e(J2.c cVar, Object obj) {
        d(cVar, obj, true);
        return this;
    }

    public final void f(J2.d dVar, J2.c cVar, Object obj, boolean z4) throws IOException {
        b bVar = new b();
        bVar.f1725j = 0L;
        try {
            OutputStream outputStream = this.f1730a;
            this.f1730a = bVar;
            try {
                dVar.a(obj, this);
                this.f1730a = outputStream;
                long j5 = bVar.f1725j;
                bVar.close();
                if (z4 && j5 == 0) {
                    return;
                }
                h((g(cVar) << 3) | 2);
                i(j5);
                dVar.a(obj, this);
            } catch (Throwable th) {
                this.f1730a = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                bVar.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    public final void h(int i5) throws IOException {
        while ((i5 & (-128)) != 0) {
            this.f1730a.write((i5 & 127) | 128);
            i5 >>>= 7;
        }
        this.f1730a.write(i5 & 127);
    }

    public final void i(long j5) throws IOException {
        while (((-128) & j5) != 0) {
            this.f1730a.write((((int) j5) & 127) | 128);
            j5 >>>= 7;
        }
        this.f1730a.write(((int) j5) & 127);
    }
}
