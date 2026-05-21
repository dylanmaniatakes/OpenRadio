package f1;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements h {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ long f6455c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Y0.i f6456d;

    public /* synthetic */ f(long j5, Y0.i iVar) {
        this.f6455c = j5;
        this.f6456d = iVar;
    }

    @Override // f1.h
    public final Object apply(Object obj) {
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(this.f6455c));
        Y0.i iVar = this.f6456d;
        String str = iVar.f2912a;
        V0.d dVar = iVar.f2914c;
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{str, String.valueOf(i1.a.a(dVar))}) < 1) {
            contentValues.put("backend_name", iVar.f2912a);
            contentValues.put("priority", Integer.valueOf(i1.a.a(dVar)));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }
}
