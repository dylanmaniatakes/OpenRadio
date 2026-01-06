package h4;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Trace;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import f3.C0532x;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public static long f7090a;

    /* renamed from: b, reason: collision with root package name */
    public static Method f7091b;

    public f() {
        new ConcurrentHashMap();
    }

    public static void a(boolean z4, String str) {
        if (!z4) {
            throw new IllegalArgumentException(str);
        }
    }

    public static void b(int i5) {
        if (i5 < 0) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static ArrayList h(Context context) throws JSONException {
        int i5 = 0;
        String string = context.getSharedPreferences("memory_channel_cache", 0).getString("cached_channels", null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            try {
                for (JSONArray jSONArray = new JSONArray(string); i5 < jSONArray.length(); jSONArray = jSONArray) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i5);
                    arrayList.add(new C0532x(jSONObject.getString("name"), jSONObject.getString("zone"), jSONObject.getString("rxFreq"), jSONObject.getString("txFreq"), jSONObject.getString("mode"), jSONObject.getDouble("txTone"), jSONObject.getDouble("rxTone"), jSONObject.getInt("txDcs"), jSONObject.getInt("rxDcs"), jSONObject.getInt("colorCode"), jSONObject.getInt("timeslot"), jSONObject.getInt("groupCall"), jSONObject.getString("scan"), jSONObject.getString("roip"), jSONObject.getString("power"), "", "", "", "Off", "", "", "", "", "", 0, "", "", 0, 0, 0, "No", null, null));
                    i5++;
                }
                Log.d("MemoryChannelCache", "Successfully loaded " + arrayList.size() + " cached channels");
            } catch (JSONException e5) {
                Log.e("MemoryChannelCache", "Error loading cached channels", e5);
            }
        }
        return arrayList;
    }

    public static String i(String str, String str2) {
        F3.i.f(str, "tableName");
        F3.i.f(str2, "triggerType");
        return "`room_table_modification_trigger_" + str + '_' + str2 + '`';
    }

    public static boolean j() {
        try {
            if (f7091b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        try {
            if (f7091b == null) {
                f7090a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f7091b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f7091b.invoke(null, Long.valueOf(f7090a))).booleanValue();
        } catch (Exception e5) {
            if (!(e5 instanceof InvocationTargetException)) {
                Log.v("Trace", "Unable to call isTagEnabled via reflection", e5);
                return false;
            }
            Throwable cause = e5.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            throw new RuntimeException(cause);
        }
    }

    public static X.b k(MappedByteBuffer mappedByteBuffer) throws IOException {
        long j5;
        ByteBuffer byteBufferDuplicate = mappedByteBuffer.duplicate();
        byteBufferDuplicate.order(ByteOrder.BIG_ENDIAN);
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
        int i5 = byteBufferDuplicate.getShort() & 65535;
        if (i5 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        byteBufferDuplicate.position(byteBufferDuplicate.position() + 6);
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                j5 = -1;
                break;
            }
            int i7 = byteBufferDuplicate.getInt();
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            j5 = byteBufferDuplicate.getInt() & 4294967295L;
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 4);
            if (1835365473 == i7) {
                break;
            }
            i6++;
        }
        if (j5 != -1) {
            byteBufferDuplicate.position(byteBufferDuplicate.position() + ((int) (j5 - byteBufferDuplicate.position())));
            byteBufferDuplicate.position(byteBufferDuplicate.position() + 12);
            long j6 = byteBufferDuplicate.getInt() & 4294967295L;
            for (int i8 = 0; i8 < j6; i8++) {
                int i9 = byteBufferDuplicate.getInt();
                long j7 = byteBufferDuplicate.getInt() & 4294967295L;
                byteBufferDuplicate.getInt();
                if (1164798569 == i9 || 1701669481 == i9) {
                    byteBufferDuplicate.position((int) (j7 + j5));
                    X.b bVar = new X.b();
                    byteBufferDuplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int iPosition = byteBufferDuplicate.position() + byteBufferDuplicate.getInt(byteBufferDuplicate.position());
                    bVar.f1892d = byteBufferDuplicate;
                    bVar.f1889a = iPosition;
                    int i10 = iPosition - byteBufferDuplicate.getInt(iPosition);
                    bVar.f1890b = i10;
                    bVar.f1891c = ((ByteBuffer) bVar.f1892d).getShort(i10);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }

    public static void l(Context context, List list) throws JSONException {
        SharedPreferences sharedPreferences = context.getSharedPreferences("memory_channel_cache", 0);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C0532x c0532x = (C0532x) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("name", c0532x.f6828a);
                jSONObject.put("zone", c0532x.f6829b);
                jSONObject.put("rxFreq", c0532x.f6830c);
                jSONObject.put("txFreq", c0532x.f6831d);
                jSONObject.put("mode", c0532x.f6832e);
                jSONObject.put("txTone", c0532x.f6833f);
                jSONObject.put("rxTone", c0532x.g);
                jSONObject.put("txDcs", c0532x.h);
                jSONObject.put("rxDcs", c0532x.f6834i);
                jSONObject.put("colorCode", c0532x.f6835j);
                jSONObject.put("timeslot", c0532x.f6836k);
                jSONObject.put("groupCall", c0532x.f6837l);
                jSONObject.put("scan", c0532x.f6838m);
                jSONObject.put("roip", c0532x.n);
                jSONObject.put("power", c0532x.f6839o);
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("cached_channels", jSONArray.toString());
            editorEdit.putLong("last_update_time", System.currentTimeMillis());
            editorEdit.apply();
            Log.d("MemoryChannelCache", "Successfully cached " + list.size() + " channels");
        } catch (JSONException e5) {
            Log.e("MemoryChannelCache", "Error caching channels", e5);
        }
    }

    public static void m(Status status, Object obj, N1.k kVar) {
        if (status.f4639j <= 0) {
            kVar.a(obj);
        } else {
            kVar.f1789a.l(status.f4641l != null ? new o1.m(status) : new o1.e(status));
        }
    }

    public abstract Typeface d(Context context, D.f fVar, Resources resources, int i5);

    public abstract Typeface e(Context context, L.i[] iVarArr, int i5);

    public Typeface f(Context context, Resources resources, int i5, String str, int i6) {
        File fileJ = r.j(context);
        if (fileJ == null) {
            return null;
        }
        try {
            if (r.e(fileJ, resources, i5)) {
                return Typeface.createFromFile(fileJ.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            fileJ.delete();
        }
    }

    public L.i g(int i5, L.i[] iVarArr) {
        n2.e eVar = new n2.e(11);
        int i6 = (i5 & 1) == 0 ? 400 : 700;
        boolean z4 = (i5 & 2) != 0;
        L.i iVar = null;
        int i7 = Integer.MAX_VALUE;
        for (L.i iVar2 : iVarArr) {
            int iAbs = (Math.abs(eVar.f(iVar2) - i6) * 2) + (eVar.g(iVar2) == z4 ? 0 : 1);
            if (iVar == null || i7 > iAbs) {
                iVar = iVar2;
                i7 = iAbs;
            }
        }
        return iVar;
    }
}
