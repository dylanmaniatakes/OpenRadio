package e3;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import com.unified.ur1.radioteams.RadioTeamsActivity;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import f.AbstractActivityC0472i;
import l3.C0749g;
import l3.k;

/* renamed from: e3.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0451e implements AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6208c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0472i f6209d;

    public /* synthetic */ C0451e(AbstractActivityC0472i abstractActivityC0472i, int i5) {
        this.f6208c = i5;
        this.f6209d = abstractActivityC0472i;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        AbstractActivityC0472i abstractActivityC0472i = this.f6209d;
        switch (this.f6208c) {
            case 0:
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = (UnifiedOnTheAirActivity) abstractActivityC0472i;
                unifiedOnTheAirActivity.r((C0453g) unifiedOnTheAirActivity.f5565l.get(i5));
                break;
            case 1:
                RadioTeamsActivity radioTeamsActivity = (RadioTeamsActivity) abstractActivityC0472i;
                radioTeamsActivity.u((C0749g) radioTeamsActivity.f6020o.get(i5));
                break;
            default:
                int i6 = RadioTeamsManagerActivity.f6026l;
                RadioTeamsManagerActivity radioTeamsManagerActivity = (RadioTeamsManagerActivity) abstractActivityC0472i;
                radioTeamsManagerActivity.getClass();
                Log.d("RadioTeamsManager", "Team item clicked at position: " + i5);
                k kVar = (k) radioTeamsManagerActivity.h.get(i5);
                Log.d("RadioTeamsManager", "Selected team: " + kVar.f8423a);
                radioTeamsManagerActivity.j(kVar);
                break;
        }
    }
}
