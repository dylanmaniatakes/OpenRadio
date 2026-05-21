package m3;

import android.database.Cursor;
import android.util.Log;
import android.widget.Toast;
import com.unified.ur1.rfmodule.DmrDatabase;
import com.unified.ur1.rfmodule.RecordingsActivity;
import java.util.ArrayList;
import l0.AbstractC0737m;
import l0.C0738n;
import q0.C0847j;

/* loaded from: classes.dex */
public final /* synthetic */ class w implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8637j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RecordingsActivity f8638k;

    public /* synthetic */ w(RecordingsActivity recordingsActivity, int i5) {
        this.f8637j = i5;
        this.f8638k = recordingsActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = 2;
        RecordingsActivity recordingsActivity = this.f8638k;
        switch (this.f8637j) {
            case 0:
                int i6 = RecordingsActivity.f6091j;
                recordingsActivity.getClass();
                try {
                    C0777m c0777mR = DmrDatabase.q(recordingsActivity).r();
                    AbstractC0737m abstractC0737m = (AbstractC0737m) c0777mR.f8620c;
                    abstractC0737m.b();
                    L0.h hVar = (L0.h) c0777mR.f8622e;
                    C0847j c0847jA = hVar.a();
                    try {
                        abstractC0737m.c();
                        try {
                            c0847jA.c();
                            abstractC0737m.o();
                            hVar.n(c0847jA);
                            new Thread(new w(recordingsActivity, i5)).start();
                            return;
                        } finally {
                            abstractC0737m.k();
                        }
                    } catch (Throwable th) {
                        hVar.n(c0847jA);
                        throw th;
                    }
                } catch (Exception e5) {
                    Log.e("RecordingsActivity", "Error fixing durations", e5);
                    return;
                }
            case 1:
                int i7 = RecordingsActivity.f6091j;
                recordingsActivity.getClass();
                new Thread(new w(recordingsActivity, i5)).start();
                return;
            case 2:
                int i8 = RecordingsActivity.f6091j;
                recordingsActivity.getClass();
                C0777m c0777mR2 = DmrDatabase.q(recordingsActivity).r();
                c0777mR2.getClass();
                C0738n c0738nO = C0738n.o(0, "SELECT * FROM recordings ORDER BY timestamp DESC");
                AbstractC0737m abstractC0737m2 = (AbstractC0737m) c0777mR2.f8620c;
                abstractC0737m2.b();
                Cursor cursorM = abstractC0737m2.m(c0738nO, null);
                try {
                    int iH = L0.f.h(cursorM, "id");
                    int iH2 = L0.f.h(cursorM, "timestamp");
                    int iH3 = L0.f.h(cursorM, "filename");
                    int iH4 = L0.f.h(cursorM, "durationMs");
                    ArrayList arrayList = new ArrayList(cursorM.getCount());
                    while (cursorM.moveToNext()) {
                        C0776l c0776l = new C0776l();
                        c0776l.f8616a = cursorM.getLong(iH);
                        c0776l.f8617b = cursorM.getLong(iH2);
                        if (cursorM.isNull(iH3)) {
                            c0776l.f8618c = null;
                        } else {
                            c0776l.f8618c = cursorM.getString(iH3);
                        }
                        c0776l.f8619d = cursorM.getInt(iH4);
                        arrayList.add(c0776l);
                    }
                    cursorM.close();
                    c0738nO.s();
                    recordingsActivity.runOnUiThread(new g3.k(recordingsActivity, 23, arrayList));
                    return;
                } catch (Throwable th2) {
                    cursorM.close();
                    c0738nO.s();
                    throw th2;
                }
            default:
                int i9 = RecordingsActivity.f6091j;
                recordingsActivity.getClass();
                Toast.makeText(recordingsActivity, "Recording saved successfully", 0).show();
                return;
        }
    }
}
