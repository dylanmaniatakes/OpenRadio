package D0;

import a.AbstractC0203a;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: classes.dex */
public final class o extends AbstractC0203a {

    /* renamed from: f, reason: collision with root package name */
    public static final String f282f = C0.t.f("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    public final v f283a;

    /* renamed from: b, reason: collision with root package name */
    public final List f284b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f285c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f286d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public boolean f287e;

    public o(v vVar, List list) {
        this.f283a = vVar;
        this.f284b = list;
        this.f285c = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            String string = ((C0.v) list.get(i5)).f176a.toString();
            F3.i.e(string, "id.toString()");
            this.f285c.add(string);
            this.f286d.add(string);
        }
    }

    public static HashSet q(o oVar) {
        HashSet hashSet = new HashSet();
        oVar.getClass();
        return hashSet;
    }
}
