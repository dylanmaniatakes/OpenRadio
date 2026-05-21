package J1;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: J1.l, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0083l {

    /* renamed from: a, reason: collision with root package name */
    public final String f1288a;

    /* renamed from: b, reason: collision with root package name */
    public long f1289b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ C0089n f1290c;

    public C0083l(C0089n c0089n, String str) {
        this.f1290c = c0089n;
        q1.E.f(str);
        this.f1288a = str;
        this.f1289b = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [java.util.List] */
    public final List a() {
        ArrayList arrayListEmptyList;
        C0089n c0089n = this.f1290c;
        ArrayList arrayList = new ArrayList();
        String strValueOf = String.valueOf(this.f1289b);
        String str = this.f1288a;
        Cursor cursorQuery = null;
        try {
            try {
                cursorQuery = c0089n.f0().query("raw_events", new String[]{"rowid", "name", "timestamp", "metadata_fingerprint", "data", "realtime"}, "app_id = ? and rowid > ?", new String[]{str, strValueOf}, null, null, "rowid", "1000");
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j5 = cursorQuery.getLong(0);
                        long j6 = cursorQuery.getLong(3);
                        boolean z4 = cursorQuery.getLong(5) == 1;
                        byte[] blob = cursorQuery.getBlob(4);
                        if (j5 > this.f1289b) {
                            this.f1289b = j5;
                        }
                        try {
                            com.google.android.gms.internal.measurement.W0 w02 = (com.google.android.gms.internal.measurement.W0) C0060d0.P(com.google.android.gms.internal.measurement.X0.t(), blob);
                            String string = cursorQuery.getString(1);
                            if (string == null) {
                                string = "";
                            }
                            w02.g();
                            com.google.android.gms.internal.measurement.X0.B((com.google.android.gms.internal.measurement.X0) w02.f4913k, string);
                            long j7 = cursorQuery.getLong(2);
                            w02.g();
                            com.google.android.gms.internal.measurement.X0.E(j7, (com.google.android.gms.internal.measurement.X0) w02.f4913k);
                            arrayList.add(new C0080k(j5, j6, z4, (com.google.android.gms.internal.measurement.X0) w02.e()));
                        } catch (IOException e5) {
                            Z z5 = ((C0113v0) c0089n.f84c).f1417k;
                            C0113v0.k(z5);
                            z5.h.c(Z.q(str), e5, "Data loss. Failed to merge raw event. appId");
                        }
                    } while (cursorQuery.moveToNext());
                } else {
                    arrayListEmptyList = Collections.emptyList();
                }
            } catch (SQLiteException e6) {
                Z z6 = ((C0113v0) c0089n.f84c).f1417k;
                C0113v0.k(z6);
                z6.h.c(Z.q(str), e6, "Data loss. Error querying raw events batch. appId");
                arrayListEmptyList = arrayList;
            }
            return arrayListEmptyList;
        } finally {
            if (0 != 0) {
                cursorQuery.close();
            }
        }
    }

    public C0083l(C0089n c0089n, String str, long j5) {
        this.f1290c = c0089n;
        q1.E.f(str);
        this.f1288a = str;
        this.f1289b = c0089n.b0("select rowid from raw_events where app_id = ? and timestamp < ? order by rowid desc limit 1", new String[]{str, String.valueOf(j5)}, -1L);
    }
}
