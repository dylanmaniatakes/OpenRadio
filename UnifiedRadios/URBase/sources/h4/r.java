package h4;

import N3.AbstractC0146u;
import N3.C0138l;
import N3.K;
import N3.L;
import S3.t;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import f3.m0;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import q0.C0840c;
import q0.C0841d;
import x3.EnumC0973a;

/* loaded from: classes.dex */
public abstract class r {
    public static void d(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static boolean e(File file, Resources resources, int i5) throws Throwable {
        InputStream inputStreamOpenRawResource;
        try {
            inputStreamOpenRawResource = resources.openRawResource(i5);
            try {
                boolean zF = f(file, inputStreamOpenRawResource);
                d(inputStreamOpenRawResource);
                return zF;
            } catch (Throwable th) {
                th = th;
                d(inputStreamOpenRawResource);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamOpenRawResource = null;
        }
    }

    public static boolean f(File file, InputStream inputStream) throws Throwable {
        FileOutputStream fileOutputStream;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskWrites = StrictMode.allowThreadDiskWrites();
        FileOutputStream fileOutputStream2 = null;
        try {
            try {
                fileOutputStream = new FileOutputStream(file, false);
            } catch (IOException e5) {
                e = e5;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int i5 = inputStream.read(bArr);
                if (i5 == -1) {
                    d(fileOutputStream);
                    StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
                    return true;
                }
                fileOutputStream.write(bArr, 0, i5);
            }
        } catch (IOException e6) {
            e = e6;
            fileOutputStream2 = fileOutputStream;
            Log.e("TypefaceCompatUtil", "Error copying resource contents to temp file: " + e.getMessage());
            d(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileOutputStream2 = fileOutputStream;
            d(fileOutputStream2);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskWrites);
            throw th;
        }
    }

    public static void g(String str, String str2, Object obj) {
        String strConcat = "TRuntime.".concat(str);
        if (Log.isLoggable(strConcat, 3)) {
            Log.d(strConcat, String.format(str2, obj));
        }
    }

    public static void h(String str, String str2, Exception exc) {
        String strConcat = "TRuntime.".concat(str);
        if (Log.isLoggable(strConcat, 6)) {
            Log.e(strConcat, str2, exc);
        }
    }

    public static ArrayList i(Context context) throws JSONException {
        int i5 = 0;
        String string = context.getSharedPreferences("repeater_cache", 0).getString("cached_repeaters", null);
        ArrayList arrayList = new ArrayList();
        if (string != null) {
            try {
                for (JSONArray jSONArray = new JSONArray(string); i5 < jSONArray.length(); jSONArray = jSONArray) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i5);
                    m0 m0Var = new m0(jSONObject.getString("callsign"), jSONObject.getString("frequency"), jSONObject.getString("txFrequency"), jSONObject.getString("mode"), jSONObject.getString("city"), jSONObject.getString("state"), jSONObject.getString("tone"), jSONObject.getInt("score"), jSONObject.getString("dmrTS1"), jSONObject.getString("dmrTS2"), jSONObject.getString("dmrColorCode"), jSONObject.getDouble("distance"));
                    m0Var.f6752j = jSONObject.getBoolean("offline");
                    m0Var.f6753k = jSONObject.getString("notes");
                    arrayList.add(m0Var);
                    i5++;
                }
                Log.d("RepeaterCache", "Successfully loaded " + arrayList.size() + " cached repeaters");
            } catch (JSONException e5) {
                Log.e("RepeaterCache", "Error loading cached repeaters", e5);
            }
        }
        return arrayList;
    }

    public static File j(Context context) {
        File cacheDir = context.getCacheDir();
        if (cacheDir == null) {
            return null;
        }
        String str = ".font" + Process.myPid() + "-" + Process.myTid() + "-";
        for (int i5 = 0; i5 < 100; i5++) {
            File file = new File(cacheDir, str + i5);
            if (file.createNewFile()) {
                return file;
            }
        }
        return null;
    }

    public static C0840c k(C0841d c0841d, SQLiteDatabase sQLiteDatabase) {
        F3.i.f(c0841d, "refHolder");
        F3.i.f(sQLiteDatabase, "sqLiteDatabase");
        C0840c c0840c = c0841d.f9289a;
        if (c0840c != null && F3.i.a(c0840c.f9288j, sQLiteDatabase)) {
            return c0840c;
        }
        C0840c c0840c2 = new C0840c(sQLiteDatabase);
        c0841d.f9289a = c0840c2;
        return c0840c2;
    }

    public static MappedByteBuffer l(Context context, Uri uri) throws IOException {
        try {
            ParcelFileDescriptor parcelFileDescriptorA = E.j.a(context.getContentResolver(), uri, "r", null);
            if (parcelFileDescriptorA == null) {
                if (parcelFileDescriptorA != null) {
                    parcelFileDescriptorA.close();
                }
                return null;
            }
            try {
                FileInputStream fileInputStream = new FileInputStream(parcelFileDescriptorA.getFileDescriptor());
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_ONLY, 0L, channel.size());
                    fileInputStream.close();
                    parcelFileDescriptorA.close();
                    return map;
                } finally {
                }
            } finally {
            }
        } catch (IOException unused) {
            return null;
        }
    }

    public static void o(Context context, ArrayList arrayList, double d5, double d6) throws JSONException {
        SharedPreferences sharedPreferences = context.getSharedPreferences("repeater_cache", 0);
        JSONArray jSONArray = new JSONArray();
        try {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                m0 m0Var = (m0) it.next();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("callsign", m0Var.f6745a);
                jSONObject.put("frequency", m0Var.f6747c);
                jSONObject.put("mode", m0Var.f6748d);
                jSONObject.put("city", m0Var.f6755m);
                jSONObject.put("state", m0Var.f6754l);
                jSONObject.put("tone", m0Var.f6749e);
                jSONObject.put("score", m0Var.f6750f);
                jSONObject.put("dmrTS1", m0Var.g);
                jSONObject.put("dmrTS2", m0Var.h);
                jSONObject.put("dmrColorCode", m0Var.f6746b);
                jSONObject.put("distance", m0Var.f6751i);
                jSONObject.put("offline", m0Var.f6752j);
                jSONObject.put("notes", m0Var.f6753k);
                jSONObject.put("rxFrequency", m0Var.f6757p);
                jSONObject.put("txFrequency", m0Var.f6758q);
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            editorEdit.putString("cached_repeaters", jSONArray.toString());
            editorEdit.putLong("last_update_time", System.currentTimeMillis());
            editorEdit.putFloat("last_latitude", (float) d5);
            editorEdit.putFloat("last_longitude", (float) d6);
            editorEdit.apply();
            Log.d("RepeaterCache", "Successfully cached " + arrayList.size() + " repeaters");
        } catch (JSONException e5) {
            Log.e("RepeaterCache", "Error caching repeaters", e5);
        }
    }

    public static final Object p(t tVar, t tVar2, E3.p pVar) throws Throwable {
        Object c0138l;
        Object objH;
        K k5;
        try {
            F3.o.b(2, pVar);
            c0138l = pVar.c(tVar2, tVar);
        } catch (Throwable th) {
            c0138l = new C0138l(th, false);
        }
        EnumC0973a enumC0973a = EnumC0973a.f10448j;
        if (c0138l == enumC0973a || (objH = tVar.H(c0138l)) == AbstractC0146u.f1875d) {
            return enumC0973a;
        }
        if (objH instanceof C0138l) {
            throw ((C0138l) objH).f1860a;
        }
        L l5 = objH instanceof L ? (L) objH : null;
        return (l5 == null || (k5 = l5.f1821a) == null) ? objH : k5;
    }

    public abstract boolean a(N0.i iVar, N0.d dVar, N0.d dVar2);

    public abstract boolean b(N0.i iVar, Object obj, Object obj2);

    public abstract boolean c(N0.i iVar, N0.h hVar, N0.h hVar2);

    public abstract void m(N0.h hVar, N0.h hVar2);

    public abstract void n(N0.h hVar, Thread thread);
}
