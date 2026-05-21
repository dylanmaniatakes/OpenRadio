package O2;

import F3.i;
import L0.l;
import android.util.Base64OutputStream;
import androidx.work.impl.WorkDatabase;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Callable;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final /* synthetic */ class c implements Callable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2026a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2027b;

    public /* synthetic */ c(int i5, Object obj) {
        this.f2026a = i5;
        this.f2027b = obj;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        String string;
        switch (this.f2026a) {
            case 0:
                d dVar = (d) this.f2027b;
                synchronized (dVar) {
                    try {
                        h hVar = (h) dVar.f2028a.get();
                        ArrayList arrayListC = hVar.c();
                        hVar.b();
                        JSONArray jSONArray = new JSONArray();
                        for (int i5 = 0; i5 < arrayListC.size(); i5++) {
                            a aVar = (a) arrayListC.get(i5);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("agent", aVar.f2022a);
                            jSONObject.put("dates", new JSONArray((Collection) aVar.f2023b));
                            jSONArray.put(jSONObject);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("heartbeats", jSONArray);
                        jSONObject2.put("version", "2");
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 11);
                        try {
                            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(base64OutputStream);
                            try {
                                gZIPOutputStream.write(jSONObject2.toString().getBytes("UTF-8"));
                                gZIPOutputStream.close();
                                base64OutputStream.close();
                                string = byteArrayOutputStream.toString("UTF-8");
                            } finally {
                            }
                        } finally {
                        }
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                return string;
            case 1:
                d dVar2 = (d) this.f2027b;
                synchronized (dVar2) {
                    ((h) dVar2.f2028a.get()).h(System.currentTimeMillis(), ((Z2.b) dVar2.f2030c.get()).a());
                }
                return null;
            default:
                l lVar = (l) this.f2027b;
                i.f(lVar, "this$0");
                WorkDatabase workDatabase = (WorkDatabase) lVar.f1554d;
                Long lJ = workDatabase.r().j("next_alarm_manager_id");
                int iLongValue = lJ != null ? (int) lJ.longValue() : 0;
                workDatabase.r().m(new L0.d("next_alarm_manager_id", Long.valueOf(iLongValue != Integer.MAX_VALUE ? iLongValue + 1 : 0)));
                return Integer.valueOf(iLongValue);
        }
    }
}
