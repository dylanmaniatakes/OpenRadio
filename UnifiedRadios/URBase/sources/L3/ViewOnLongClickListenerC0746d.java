package l3;

import android.util.Log;
import android.view.View;
import android.widget.Toast;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import f.AbstractActivityC0472i;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: l3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnLongClickListenerC0746d implements View.OnLongClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8402a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0472i f8403b;

    public /* synthetic */ ViewOnLongClickListenerC0746d(AbstractActivityC0472i abstractActivityC0472i, int i5) {
        this.f8402a = i5;
        this.f8403b = abstractActivityC0472i;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        int i5;
        AbstractActivityC0472i abstractActivityC0472i = this.f8403b;
        switch (this.f8402a) {
            case 0:
                int i6 = RadioTeamsActivity.f6010u;
                RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) abstractActivityC0472i;
                radioTeamsActivity.getClass();
                ArrayList arrayList = new ArrayList();
                Iterator it = radioTeamsActivity.f6020o.iterator();
                while (it.hasNext()) {
                    C0749g c0749g = (C0749g) it.next();
                    if (c0749g.c() && ("online".equals(c0749g.f8408e) || "emergency".equals(c0749g.f8407d))) {
                        arrayList.add(new k4.d(c0749g.f8405b, c0749g.f8406c));
                    }
                }
                if (radioTeamsActivity.f6022q.containsKey("USER_LOCATION")) {
                    arrayList.add(((m4.d) radioTeamsActivity.f6022q.get("USER_LOCATION")).f8665f);
                }
                if (arrayList.isEmpty()) {
                    i5 = 0;
                    Toast.makeText(radioTeamsActivity, "No online team members with location data", 0).show();
                } else {
                    if (arrayList.size() == 1) {
                        ((l4.f) radioTeamsActivity.g).c((d4.a) arrayList.get(0));
                        ((l4.f) radioTeamsActivity.g).d(15.0d);
                    } else {
                        Iterator it2 = arrayList.iterator();
                        double dMax = Double.MIN_VALUE;
                        double dMin = Double.MAX_VALUE;
                        double dMin2 = Double.MAX_VALUE;
                        double dMax2 = Double.MIN_VALUE;
                        while (it2.hasNext()) {
                            k4.d dVar = (k4.d) it2.next();
                            dMin = Math.min(dMin, dVar.f8265k);
                            dMax = Math.max(dMax, dVar.f8265k);
                            dMin2 = Math.min(dMin2, dVar.f8264j);
                            dMax2 = Math.max(dMax2, dVar.f8264j);
                        }
                        ((l4.f) radioTeamsActivity.g).c(new k4.d((dMin + dMax) / 2.0d, (dMin2 + dMax2) / 2.0d));
                        double dMax3 = Math.max(dMax - dMin, dMax2 - dMin2);
                        ((l4.f) radioTeamsActivity.g).d(dMax3 > 0.1d ? 10.0d : dMax3 > 0.01d ? 12.0d : dMax3 > 0.001d ? 14.0d : 16.0d);
                    }
                    radioTeamsActivity.f6011c = true;
                    radioTeamsActivity.f6014f.invalidate();
                    i5 = 0;
                }
                Toast.makeText(radioTeamsActivity, "Showing all online team members", i5).show();
                break;
            case 1:
                RadioTeamsActivity radioTeamsActivity2 = (RadioTeamsActivity) abstractActivityC0472i;
                if (radioTeamsActivity2.g != null) {
                    k4.d dVar2 = (k4.d) radioTeamsActivity2.f6014f.getMapCenter();
                    String str = String.format("Map center: %.6f, %.6f", Double.valueOf(dVar2.f8265k), Double.valueOf(dVar2.f8264j));
                    Log.d("RadioTeamsActivity", str);
                    Toast.makeText(radioTeamsActivity2, str, 1).show();
                    break;
                }
                break;
            default:
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = (UnifiedOnTheAirActivity) abstractActivityC0472i;
                if (unifiedOnTheAirActivity.f5561f != null) {
                    k4.d dVar3 = (k4.d) unifiedOnTheAirActivity.f5560e.getMapCenter();
                    String str2 = String.format("Map center: %.6f, %.6f", Double.valueOf(dVar3.f8265k), Double.valueOf(dVar3.f8264j));
                    Log.d("UnifiedOnTheAir", str2);
                    Toast.makeText(unifiedOnTheAirActivity, str2, 1).show();
                    break;
                }
                break;
        }
        return true;
    }
}
