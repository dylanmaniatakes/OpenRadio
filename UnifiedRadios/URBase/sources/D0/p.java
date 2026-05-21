package D0;

import X2.C;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import androidx.recyclerview.widget.C0258e;
import b1.C0284a;
import com.unified.ur1.R;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.rfmodule.RecordingsActivity;
import e1.C0442j;
import e1.C0444l;
import f3.InterfaceC0512d0;
import f3.Q;
import f3.f0;
import f3.m0;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ScheduledFuture;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.internal.Util;
import p0.C0818a;
import p0.InterfaceC0819b;
import q0.C0845h;
import q1.E;
import q3.AbstractC0869a;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements InterfaceC0819b, F2.e, EventListener.Factory, N1.b, N1.e, g1.b, f1.h, InterfaceC0512d0, u0.j, i2.i, N1.g, androidx.activity.result.b, P.d {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f288c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f289d;

    public /* synthetic */ p(int i5, Object obj) {
        this.f288c = i5;
        this.f289d = obj;
    }

    @Override // f3.InterfaceC0512d0
    public void a(String str) {
        f0 f0Var = (f0) this.f289d;
        if (str == null) {
            f0Var.getClass();
            return;
        }
        f0Var.d(str);
        f0Var.f6711c.execute(new Q(f0Var, 0));
    }

    @Override // f1.h
    public Object apply(Object obj) {
        Cursor cursor = (Cursor) obj;
        f1.j jVar = (f1.j) this.f289d;
        jVar.getClass();
        while (cursor.moveToNext()) {
            jVar.x(cursor.getInt(0), b1.c.MESSAGE_TOO_OLD, cursor.getString(1));
        }
        return null;
    }

    @Override // F2.e
    public Object b(F2.t tVar) {
        return this.f289d;
    }

    @Override // N1.b
    public Object c(N1.j jVar) throws IOException {
        Object obj;
        ((X2.n) this.f289d).getClass();
        N1.r rVar = (N1.r) jVar;
        synchronized (rVar.f1804a) {
            E.k("Task is not yet complete", rVar.f1806c);
            if (rVar.f1807d) {
                throw new CancellationException("Task is already canceled.");
            }
            if (IOException.class.isInstance(rVar.f1809f)) {
                throw ((Throwable) IOException.class.cast(rVar.f1809f));
            }
            Exception exc = rVar.f1809f;
            if (exc != null) {
                throw new N1.h(exc);
            }
            obj = rVar.f1808e;
        }
        Bundle bundle = (Bundle) obj;
        if (bundle == null) {
            throw new IOException("SERVICE_NOT_AVAILABLE");
        }
        String string = bundle.getString("registration_id");
        if (string != null || (string = bundle.getString("unregistered")) != null) {
            return string;
        }
        String string2 = bundle.getString("error");
        if ("RST".equals(string2)) {
            throw new IOException("INSTANCE_ID_RESET");
        }
        if (string2 != null) {
            throw new IOException(string2);
        }
        Log.w("FirebaseMessaging", "Unexpected response: " + bundle, new Throwable());
        throw new IOException("SERVICE_NOT_AVAILABLE");
    }

    @Override // okhttp3.EventListener.Factory
    public EventListener create(Call call) {
        return Util.asFactory$lambda$8((EventListener) this.f289d, call);
    }

    @Override // i2.i
    public boolean d(MenuItem menuItem) {
        int i5 = UnifiedInboxActivity.f5830m;
        UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f289d;
        unifiedInboxActivity.getClass();
        try {
            int itemId = menuItem.getItemId();
            if (itemId == R.id.nav_inbox) {
                unifiedInboxActivity.f5832d.b(0, true);
                if (unifiedInboxActivity.getSupportActionBar() != null) {
                    unifiedInboxActivity.getSupportActionBar().p("Inbox - " + unifiedInboxActivity.f5836j);
                }
            } else if (itemId == R.id.nav_sent) {
                unifiedInboxActivity.f5832d.b(1, true);
                if (unifiedInboxActivity.getSupportActionBar() != null) {
                    unifiedInboxActivity.getSupportActionBar().p("Sent - " + unifiedInboxActivity.f5836j);
                }
            } else {
                if (itemId != R.id.nav_compose) {
                    return false;
                }
                Intent intent = new Intent(unifiedInboxActivity, (Class<?>) ComposeMessageActivity.class);
                intent.putExtra("from_callsign", unifiedInboxActivity.f5836j);
                unifiedInboxActivity.startActivity(intent);
            }
            return true;
        } catch (Exception e5) {
            Log.e("UnifiedInbox", "Error in navigation selection", e5);
            return false;
        }
    }

    @Override // androidx.activity.result.b
    public void e(Object obj) {
        int i5 = RecordingsActivity.f6091j;
        RecordingsActivity recordingsActivity = (RecordingsActivity) this.f289d;
        recordingsActivity.getClass();
        Intent intent = ((androidx.activity.result.a) obj).f3256k;
        if (intent != null && recordingsActivity.h != null) {
            new Thread(new f(recordingsActivity, recordingsActivity.h, intent.getData(), 16)).start();
        }
        recordingsActivity.h = null;
    }

    @Override // g1.b
    public Object execute() {
        SQLiteDatabase sQLiteDatabaseA;
        int i5 = 4;
        Object obj = this.f289d;
        switch (this.f288c) {
            case 8:
                f1.j jVar = (f1.j) ((f1.c) obj);
                jVar.getClass();
                int i6 = C0284a.f4513e;
                X2.t tVar = new X2.t(4);
                HashMap map = new HashMap();
                sQLiteDatabaseA = jVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    C0284a c0284a = (C0284a) f1.j.W(sQLiteDatabaseA.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new X2.m(jVar, map, tVar, i5));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return c0284a;
                } finally {
                }
            case 9:
                f1.j jVar2 = (f1.j) ((f1.d) obj);
                long jA = jVar2.f6462k.a() - jVar2.f6464m.f6447d;
                sQLiteDatabaseA = jVar2.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(jA)};
                    f1.j.W(sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr), new p(12, jVar2));
                    int iDelete = sQLiteDatabaseA.delete("events", "timestamp_ms < ?", strArr);
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    return Integer.valueOf(iDelete);
                } finally {
                }
            case 10:
                f1.j jVar3 = (f1.j) ((C0442j) obj).f6182i;
                sQLiteDatabaseA = jVar3.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    sQLiteDatabaseA.compileStatement("DELETE FROM log_event_dropped").execute();
                    sQLiteDatabaseA.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + jVar3.f6462k.a()).execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                C0444l c0444l = (C0444l) obj;
                Iterator it = ((Iterable) ((f1.j) c0444l.f6191b).o(new A2.i(17))).iterator();
                while (it.hasNext()) {
                    c0444l.f6192c.a((Y0.i) it.next(), 1, false);
                }
                return null;
        }
    }

    @Override // p0.InterfaceC0819b
    public p0.c f(C0818a c0818a) {
        Context context = (Context) this.f289d;
        F3.i.f(context, "$context");
        C0258e c0258e = c0818a.f9076c;
        F3.i.f(c0258e, "callback");
        String str = c0818a.f9075b;
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.".toString());
        }
        return new C0845h(context, str, c0258e, true, true);
    }

    @Override // u0.j
    public void g() {
        ((i3.E) this.f289d).g();
    }

    @Override // N1.g
    public void h(Object obj) {
        Location location = (Location) obj;
        Context context = LaunchActivity.f5853D1;
        LaunchActivity launchActivity = (LaunchActivity) this.f289d;
        launchActivity.getClass();
        if (location == null) {
            Log.d("Location", "Location is null");
            return;
        }
        launchActivity.f5945n0 = (float) location.getLatitude();
        launchActivity.f5948o0 = (float) location.getLongitude();
        Log.d("Location", "Lat: " + launchActivity.f5945n0 + ", Lng: " + launchActivity.f5948o0);
    }

    public void i() {
        String str = (String) this.f289d;
        String strSubstring = str.substring(34, str.length() - 2);
        String strSubstring2 = str.substring(16, 18);
        String strSubstring3 = str.substring(18, 26);
        char[] cArr = AbstractC0869a.f9481a;
        StringBuffer stringBuffer = new StringBuffer();
        Log.e("yuan", "s = " + strSubstring);
        String str2 = "";
        if (strSubstring.length() != 0 && strSubstring.length() % 4 == 0) {
            int i5 = 0;
            while (i5 < strSubstring.length()) {
                StringBuilder sb = new StringBuilder("\\u");
                int i6 = i5 + 4;
                sb.append(strSubstring.substring(i5, i6));
                stringBuffer.append(sb.toString());
                i5 = i6;
            }
            String string = stringBuffer.toString();
            Matcher matcher = Pattern.compile("(\\\\u(\\w{4}))").matcher(string);
            while (matcher.find()) {
                string = string.replace(matcher.group(1), ((char) Integer.parseInt(matcher.group(2), 16)) + "");
            }
            str2 = string;
        }
        StringBuilder sb2 = new StringBuilder("SMS Message - Group: ");
        sb2.append(strSubstring2);
        sb2.append(", Sender: ");
        sb2.append(strSubstring3);
        sb2.append(", Content: ");
        com.unified.ur1.SatelliteTracker.h.q(sb2, str2, "DMR Context");
    }

    @Override // N1.e
    public void k(N1.j jVar) {
        switch (this.f288c) {
            case 5:
                C.b((Intent) this.f289d);
                break;
            case 6:
                ((X2.E) this.f289d).f2769b.c(null);
                break;
            default:
                ((ScheduledFuture) this.f289d).cancel(false);
                break;
        }
    }

    public /* synthetic */ p(f0 f0Var, m0 m0Var) {
        this.f288c = 13;
        this.f289d = f0Var;
    }
}
