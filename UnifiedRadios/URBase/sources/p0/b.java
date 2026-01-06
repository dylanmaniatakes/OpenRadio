package P0;

import C0.t;
import F3.i;
import L0.g;
import L0.l;
import L0.o;
import L0.s;
import android.database.Cursor;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.Iterator;
import l0.AbstractC0737m;
import l0.C0738n;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final String f2063a;

    static {
        String strF = t.f("DiagnosticsWrkr");
        i.e(strF, "tagWithPrefix(\"DiagnosticsWrkr\")");
        f2063a = strF;
    }

    public static final String a(l lVar, s sVar, L0.i iVar, ArrayList arrayList) {
        String str;
        StringBuilder sb = new StringBuilder("\n Id \t Class Name\t Job Id\t State\t Unique Name\t Tags\t");
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            o oVar = (o) it.next();
            g gVarG = iVar.g(AbstractC0409x1.d(oVar));
            Integer numValueOf = gVarG != null ? Integer.valueOf(gVarG.f1545c) : null;
            lVar.getClass();
            C0738n c0738nO = C0738n.o(1, "SELECT name FROM workname WHERE work_spec_id=?");
            String str2 = oVar.f1561a;
            if (str2 == null) {
                c0738nO.t(1);
            } else {
                c0738nO.h(1, str2);
            }
            AbstractC0737m abstractC0737m = (AbstractC0737m) lVar.f1554d;
            abstractC0737m.b();
            Cursor cursorM = abstractC0737m.m(c0738nO, null);
            try {
                ArrayList arrayList2 = new ArrayList(cursorM.getCount());
                while (cursorM.moveToNext()) {
                    arrayList2.add(cursorM.isNull(0) ? null : cursorM.getString(0));
                }
                cursorM.close();
                c0738nO.s();
                String strE = t3.i.E(arrayList2, ",", null, null, null, 62);
                String strE2 = t3.i.E(sVar.i(str2), ",", null, null, null, 62);
                StringBuilder sbM = AbstractC0535a.m("\n", str2, "\t ");
                sbM.append(oVar.f1563c);
                sbM.append("\t ");
                sbM.append(numValueOf);
                sbM.append("\t ");
                switch (oVar.f1562b) {
                    case 1:
                        str = "ENQUEUED";
                        break;
                    case 2:
                        str = "RUNNING";
                        break;
                    case 3:
                        str = "SUCCEEDED";
                        break;
                    case 4:
                        str = "FAILED";
                        break;
                    case 5:
                        str = "BLOCKED";
                        break;
                    case 6:
                        str = "CANCELLED";
                        break;
                    default:
                        throw null;
                }
                sbM.append(str);
                sbM.append("\t ");
                sbM.append(strE);
                sbM.append("\t ");
                sbM.append(strE2);
                sbM.append('\t');
                sb.append(sbM.toString());
            } catch (Throwable th) {
                cursorM.close();
                c0738nO.s();
                throw th;
            }
        }
        String string = sb.toString();
        i.e(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
