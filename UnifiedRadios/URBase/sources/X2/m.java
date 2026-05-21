package X2;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Base64;
import android.util.Log;
import b1.C0284a;
import com.google.firebase.messaging.FirebaseMessaging;
import d1.C0426a;
import f1.C0475a;
import f1.C0476b;
import f3.C0519j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final /* synthetic */ class m implements N1.i, g1.b, f1.h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f2814c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2815d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f2816e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f2817f;

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, int i5) {
        this.f2814c = i5;
        this.f2815d = obj;
        this.f2816e = obj2;
        this.f2817f = obj3;
    }

    @Override // N1.i
    public N1.r a(Object obj) {
        FirebaseMessaging firebaseMessaging = (FirebaseMessaging) this.f2815d;
        String str = (String) this.f2816e;
        u uVar = (u) this.f2817f;
        String str2 = (String) obj;
        C0519j c0519jC = FirebaseMessaging.c(firebaseMessaging.f5544b);
        A2.g gVar = firebaseMessaging.f5543a;
        gVar.a();
        String strC = "[DEFAULT]".equals(gVar.f27b) ? "" : gVar.c();
        String strA = firebaseMessaging.h.a();
        synchronized (c0519jC) {
            String strA2 = u.a(str2, strA, System.currentTimeMillis());
            if (strA2 != null) {
                SharedPreferences.Editor editorEdit = ((SharedPreferences) c0519jC.f6730d).edit();
                editorEdit.putString(strC + "|T|" + str + "|*", strA2);
                editorEdit.commit();
            }
        }
        if (uVar == null || !str2.equals(uVar.f2838a)) {
            A2.g gVar2 = firebaseMessaging.f5543a;
            gVar2.a();
            if ("[DEFAULT]".equals(gVar2.f27b)) {
                if (Log.isLoggable("FirebaseMessaging", 3)) {
                    StringBuilder sb = new StringBuilder("Invoking onNewToken for app: ");
                    gVar2.a();
                    com.unified.ur1.SatelliteTracker.h.q(sb, gVar2.f27b, "FirebaseMessaging");
                }
                Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                intent.putExtra("token", str2);
                new j(firebaseMessaging.f5544b).b(intent);
            }
        }
        return AbstractC0930a.i(str2);
    }

    /* JADX WARN: Finally extract failed */
    @Override // f1.h
    public Object apply(Object obj) {
        String str;
        int i5;
        int i6;
        long jInsert;
        b1.c cVar;
        b1.c cVar2;
        String str2 = "bytes";
        int i7 = 5;
        int i8 = 4;
        int i9 = 3;
        b1.c cVar3 = b1.c.CACHE_FULL;
        int i10 = 2;
        Object obj2 = this.f2817f;
        Object obj3 = this.f2816e;
        int i11 = 0;
        Object obj4 = this.f2815d;
        int i12 = 1;
        switch (this.f2814c) {
            case 2:
                Cursor cursor = (Cursor) obj;
                f1.j jVar = (f1.j) obj4;
                jVar.getClass();
                while (cursor.moveToNext()) {
                    long j5 = cursor.getLong(0);
                    int i13 = cursor.getInt(7) != 0 ? i12 : 0;
                    n nVar = new n();
                    nVar.f2823f = new HashMap();
                    String string = cursor.getString(i12);
                    if (string == null) {
                        throw new NullPointerException("Null transportName");
                    }
                    nVar.f2818a = string;
                    nVar.f2821d = Long.valueOf(cursor.getLong(i10));
                    nVar.f2822e = Long.valueOf(cursor.getLong(3));
                    if (i13 != 0) {
                        String string2 = cursor.getString(4);
                        nVar.f2820c = new Y0.m(string2 == null ? f1.j.f6460o : new V0.c(string2), cursor.getBlob(5));
                        str = str2;
                        i5 = i12;
                        i6 = 6;
                    } else {
                        String string3 = cursor.getString(4);
                        V0.c cVar4 = string3 == null ? f1.j.f6460o : new V0.c(string3);
                        Cursor cursorQuery = jVar.a().query("event_payloads", new String[]{str2}, "event_id = ?", new String[]{String.valueOf(j5)}, null, null, "sequence_num");
                        try {
                            ArrayList arrayList = new ArrayList();
                            int length = 0;
                            while (cursorQuery.moveToNext()) {
                                byte[] blob = cursorQuery.getBlob(0);
                                arrayList.add(blob);
                                length += blob.length;
                            }
                            byte[] bArr = new byte[length];
                            str = str2;
                            int i14 = 0;
                            int length2 = 0;
                            while (i14 < arrayList.size()) {
                                byte[] bArr2 = (byte[]) arrayList.get(i14);
                                ArrayList arrayList2 = arrayList;
                                System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
                                length2 += bArr2.length;
                                i14++;
                                arrayList = arrayList2;
                            }
                            i5 = 1;
                            cursorQuery.close();
                            nVar.f2820c = new Y0.m(cVar4, bArr);
                            i6 = 6;
                        } catch (Throwable th) {
                            cursorQuery.close();
                            throw th;
                        }
                    }
                    if (!cursor.isNull(i6)) {
                        nVar.f2819b = Integer.valueOf(cursor.getInt(i6));
                    }
                    ((List) obj3).add(new C0476b(j5, (Y0.i) obj2, nVar.d()));
                    i12 = i5;
                    str2 = str;
                    i10 = 2;
                }
                return null;
            case 3:
                SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
                f1.j jVar2 = (f1.j) obj4;
                long jSimpleQueryForLong = jVar2.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * jVar2.a().compileStatement("PRAGMA page_count").simpleQueryForLong();
                C0475a c0475a = jVar2.f6464m;
                Y0.h hVar = (Y0.h) obj3;
                if (jSimpleQueryForLong >= c0475a.f6444a) {
                    jVar2.x(1L, cVar3, hVar.f2906a);
                    return -1L;
                }
                Y0.i iVar = (Y0.i) obj2;
                Long lC = f1.j.c(sQLiteDatabase, iVar);
                if (lC != null) {
                    jInsert = lC.longValue();
                } else {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("backend_name", iVar.f2912a);
                    contentValues.put("priority", Integer.valueOf(i1.a.a(iVar.f2914c)));
                    contentValues.put("next_request_ms", (Integer) 0);
                    byte[] bArr3 = iVar.f2913b;
                    if (bArr3 != null) {
                        contentValues.put("extras", Base64.encodeToString(bArr3, 0));
                    }
                    jInsert = sQLiteDatabase.insert("transport_contexts", null, contentValues);
                }
                byte[] bArr4 = hVar.f2908c.f2922b;
                int length3 = bArr4.length;
                int i15 = c0475a.f6448e;
                boolean z4 = length3 <= i15;
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("context_id", Long.valueOf(jInsert));
                contentValues2.put("transport_name", hVar.f2906a);
                contentValues2.put("timestamp_ms", Long.valueOf(hVar.f2909d));
                contentValues2.put("uptime_ms", Long.valueOf(hVar.f2910e));
                contentValues2.put("payload_encoding", hVar.f2908c.f2921a.f2511a);
                contentValues2.put("code", hVar.f2907b);
                contentValues2.put("num_attempts", (Integer) 0);
                contentValues2.put("inline", Boolean.valueOf(z4));
                contentValues2.put("payload", z4 ? bArr4 : new byte[0]);
                long jInsert2 = sQLiteDatabase.insert("events", null, contentValues2);
                if (!z4) {
                    int iCeil = (int) Math.ceil(bArr4.length / i15);
                    for (int i16 = 1; i16 <= iCeil; i16++) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr4, (i16 - 1) * i15, Math.min(i16 * i15, bArr4.length));
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("event_id", Long.valueOf(jInsert2));
                        contentValues3.put("sequence_num", Integer.valueOf(i16));
                        contentValues3.put("bytes", bArrCopyOfRange);
                        sQLiteDatabase.insert("event_payloads", null, contentValues3);
                    }
                }
                for (Map.Entry entry : Collections.unmodifiableMap(hVar.f2911f).entrySet()) {
                    ContentValues contentValues4 = new ContentValues();
                    contentValues4.put("event_id", Long.valueOf(jInsert2));
                    contentValues4.put("name", (String) entry.getKey());
                    contentValues4.put("value", (String) entry.getValue());
                    sQLiteDatabase.insert("event_metadata", null, contentValues4);
                }
                return Long.valueOf(jInsert2);
            default:
                Cursor cursor2 = (Cursor) obj;
                f1.j jVar3 = (f1.j) obj4;
                jVar3.getClass();
                while (true) {
                    Map map = (Map) obj3;
                    if (cursor2.moveToNext()) {
                        String string4 = cursor2.getString(i11);
                        int i17 = cursor2.getInt(1);
                        b1.c cVar5 = b1.c.REASON_UNKNOWN;
                        if (i17 != 0) {
                            if (i17 == 1) {
                                cVar5 = b1.c.MESSAGE_TOO_OLD;
                            } else if (i17 == 2) {
                                cVar = cVar3;
                                cVar2 = cVar;
                            } else if (i17 == i9) {
                                cVar5 = b1.c.PAYLOAD_TOO_BIG;
                            } else if (i17 == i8) {
                                cVar5 = b1.c.MAX_RETRIES_REACHED;
                            } else if (i17 == i7) {
                                cVar5 = b1.c.INVALID_PAYLOD;
                            } else if (i17 == 6) {
                                cVar5 = b1.c.SERVER_ERROR;
                            } else {
                                h4.r.g("SQLiteEventStore", "%n is not valid. No matched LogEventDropped-Reason found. Treated it as REASON_UNKNOWN", Integer.valueOf(i17));
                            }
                            cVar2 = cVar3;
                            cVar = cVar5;
                        } else {
                            cVar2 = cVar3;
                            cVar = cVar5;
                        }
                        long j6 = cursor2.getLong(2);
                        if (!map.containsKey(string4)) {
                            map.put(string4, new ArrayList());
                        }
                        ((List) map.get(string4)).add(new b1.d(j6, cVar));
                        cVar3 = cVar2;
                        i7 = 5;
                        i8 = 4;
                        i9 = 3;
                        i11 = 0;
                    } else {
                        Iterator it = map.entrySet().iterator();
                        while (true) {
                            t tVar = (t) obj2;
                            if (!it.hasNext()) {
                                final long jA = jVar3.f6462k.a();
                                SQLiteDatabase sQLiteDatabaseA = jVar3.a();
                                sQLiteDatabaseA.beginTransaction();
                                try {
                                    b1.g gVar = (b1.g) f1.j.W(sQLiteDatabaseA.rawQuery("SELECT last_metrics_upload_ms FROM global_log_event_state LIMIT 1", new String[0]), new f1.h() { // from class: f1.g
                                        @Override // f1.h
                                        public final Object apply(Object obj5) {
                                            Cursor cursor3 = (Cursor) obj5;
                                            cursor3.moveToNext();
                                            return new b1.g(cursor3.getLong(0), jA);
                                        }
                                    });
                                    sQLiteDatabaseA.setTransactionSuccessful();
                                    sQLiteDatabaseA.endTransaction();
                                    tVar.f2834d = gVar;
                                    tVar.f2836f = new b1.b(new b1.f(jVar3.a().compileStatement("PRAGMA page_size").simpleQueryForLong() * jVar3.a().compileStatement("PRAGMA page_count").simpleQueryForLong(), C0475a.f6443f.f6444a));
                                    tVar.f2833c = (String) jVar3.n.get();
                                    return new C0284a((b1.g) tVar.f2834d, Collections.unmodifiableList((ArrayList) tVar.f2835e), (b1.b) tVar.f2836f, (String) tVar.f2833c);
                                } catch (Throwable th2) {
                                    sQLiteDatabaseA.endTransaction();
                                    throw th2;
                                }
                            }
                            Map.Entry entry2 = (Map.Entry) it.next();
                            int i18 = b1.e.f4529c;
                            new ArrayList();
                            ((ArrayList) tVar.f2835e).add(new b1.e((String) entry2.getKey(), Collections.unmodifiableList((List) entry2.getValue())));
                        }
                    }
                }
        }
    }

    @Override // g1.b
    public Object execute() {
        C0426a c0426a = (C0426a) this.f2815d;
        f1.j jVar = (f1.j) c0426a.f6105d;
        jVar.getClass();
        Y0.i iVar = (Y0.i) this.f2816e;
        V0.d dVar = iVar.f2914c;
        Y0.h hVar = (Y0.h) this.f2817f;
        String str = hVar.f2906a;
        String strConcat = "TRuntime.".concat("SQLiteEventStore");
        if (Log.isLoggable(strConcat, 3)) {
            StringBuilder sb = new StringBuilder("Storing event with priority=");
            sb.append(dVar);
            sb.append(", name=");
            sb.append(str);
            sb.append(" for destination ");
            com.unified.ur1.SatelliteTracker.h.q(sb, iVar.f2912a, strConcat);
        }
        ((Long) jVar.o(new m(jVar, hVar, iVar, 3))).getClass();
        c0426a.f6102a.a(iVar, 1, false);
        return null;
    }
}
