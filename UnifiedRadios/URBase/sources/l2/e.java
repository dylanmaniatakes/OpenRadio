package L2;

import J2.f;
import J2.g;
import android.util.Base64;
import android.util.JsonWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e implements J2.e, g {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f1620a = true;

    /* renamed from: b, reason: collision with root package name */
    public final JsonWriter f1621b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f1622c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f1623d;

    /* renamed from: e, reason: collision with root package name */
    public final J2.d f1624e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f1625f;

    public e(BufferedWriter bufferedWriter, HashMap map, HashMap map2, a aVar, boolean z4) {
        this.f1621b = new JsonWriter(bufferedWriter);
        this.f1622c = map;
        this.f1623d = map2;
        this.f1624e = aVar;
        this.f1625f = z4;
    }

    @Override // J2.e
    public final J2.e a(J2.c cVar, long j5) throws IOException {
        String str = cVar.f1473a;
        h();
        JsonWriter jsonWriter = this.f1621b;
        jsonWriter.name(str);
        h();
        jsonWriter.value(j5);
        return this;
    }

    @Override // J2.e
    public final J2.e b(J2.c cVar, int i5) throws IOException {
        String str = cVar.f1473a;
        h();
        JsonWriter jsonWriter = this.f1621b;
        jsonWriter.name(str);
        h();
        jsonWriter.value(i5);
        return this;
    }

    @Override // J2.g
    public final g c(String str) throws IOException {
        h();
        this.f1621b.value(str);
        return this;
    }

    @Override // J2.g
    public final g d(boolean z4) throws IOException {
        h();
        this.f1621b.value(z4);
        return this;
    }

    @Override // J2.e
    public final J2.e e(J2.c cVar, Object obj) throws IOException {
        g(obj, cVar.f1473a);
        return this;
    }

    public final e f(Object obj) throws IOException {
        JsonWriter jsonWriter = this.f1621b;
        if (obj == null) {
            jsonWriter.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            jsonWriter.value((Number) obj);
            return this;
        }
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                jsonWriter.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    f(it.next());
                }
                jsonWriter.endArray();
                return this;
            }
            if (obj instanceof Map) {
                jsonWriter.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        g(entry.getValue(), (String) key);
                    } catch (ClassCastException e5) {
                        throw new J2.b(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e5);
                    }
                }
                jsonWriter.endObject();
                return this;
            }
            J2.d dVar = (J2.d) this.f1622c.get(obj.getClass());
            if (dVar != null) {
                jsonWriter.beginObject();
                dVar.a(obj, this);
                jsonWriter.endObject();
                return this;
            }
            f fVar = (f) this.f1623d.get(obj.getClass());
            if (fVar != null) {
                fVar.a(obj, this);
                return this;
            }
            if (obj instanceof Enum) {
                String strName = ((Enum) obj).name();
                h();
                jsonWriter.value(strName);
                return this;
            }
            jsonWriter.beginObject();
            this.f1624e.a(obj, this);
            jsonWriter.endObject();
            return this;
        }
        if (obj instanceof byte[]) {
            h();
            jsonWriter.value(Base64.encodeToString((byte[]) obj, 2));
            return this;
        }
        jsonWriter.beginArray();
        int i5 = 0;
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i5 < length) {
                jsonWriter.value(r6[i5]);
                i5++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i5 < length2) {
                long j5 = jArr[i5];
                h();
                jsonWriter.value(j5);
                i5++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i5 < length3) {
                jsonWriter.value(dArr[i5]);
                i5++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i5 < length4) {
                jsonWriter.value(zArr[i5]);
                i5++;
            }
        } else if (obj instanceof Number[]) {
            Number[] numberArr = (Number[]) obj;
            int length5 = numberArr.length;
            while (i5 < length5) {
                f(numberArr[i5]);
                i5++;
            }
        } else {
            Object[] objArr = (Object[]) obj;
            int length6 = objArr.length;
            while (i5 < length6) {
                f(objArr[i5]);
                i5++;
            }
        }
        jsonWriter.endArray();
        return this;
    }

    public final e g(Object obj, String str) throws IOException {
        boolean z4 = this.f1625f;
        JsonWriter jsonWriter = this.f1621b;
        if (z4) {
            if (obj != null) {
                h();
                jsonWriter.name(str);
                f(obj);
            }
            return this;
        }
        h();
        jsonWriter.name(str);
        if (obj == null) {
            jsonWriter.nullValue();
        } else {
            f(obj);
        }
        return this;
    }

    public final void h() {
        if (!this.f1620a) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
    }
}
