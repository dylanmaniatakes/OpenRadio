package e3;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.unified.ur1.R;
import g0.AbstractC0535a;
import java.util.List;
import l3.C0749g;
import l3.k;

/* renamed from: e3.h, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0454h extends ArrayAdapter {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6221c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0454h(Context context, int i5, int i6, Object[] objArr) {
        super(context, i5, i6, objArr);
        this.f6221c = 1;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        switch (this.f6221c) {
            case 4:
                int count = super.getCount();
                AbstractC0535a.u("Adapter getCount(): ", count, "RadioTeamsManager");
                return count;
            default:
                return super.getCount();
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
        switch (this.f6221c) {
            case 2:
                View dropDownView = super.getDropDownView(i5, view, viewGroup);
                if (dropDownView instanceof TextView) {
                    TextView textView = (TextView) dropDownView;
                    textView.setTextColor(-1);
                    textView.setBackgroundColor(Color.parseColor("#252A3A"));
                    textView.setPadding(16, 16, 16, 16);
                }
                return dropDownView;
            default:
                return super.getDropDownView(i5, view, viewGroup);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public long getItemId(int i5) {
        switch (this.f6221c) {
            case 1:
                return i5;
            default:
                return super.getItemId(i5);
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        switch (this.f6221c) {
            case 0:
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.item_unified_user, viewGroup, false);
                }
                C0453g c0453g = (C0453g) getItem(i5);
                if (c0453g != null) {
                    TextView textView = (TextView) view.findViewById(R.id.tvUserCallsign);
                    TextView textView2 = (TextView) view.findViewById(R.id.tvUserStatus);
                    TextView textView3 = (TextView) view.findViewById(R.id.tvUserDevice);
                    TextView textView4 = (TextView) view.findViewById(R.id.tvUserLastSeen);
                    String str = c0453g.f6218f;
                    textView.setText((str == null || str.isEmpty()) ? "Unknown" : c0453g.f6218f);
                    textView2.setText(c0453g.c());
                    String str2 = c0453g.f6214b;
                    String str3 = str2 != null ? str2 : "Unknown";
                    String str4 = c0453g.f6215c;
                    if (str4 == null) {
                        str4 = "";
                    }
                    textView3.setText(str3 + " " + str4);
                    textView4.setText(c0453g.b());
                    View viewFindViewById = view.findViewById(R.id.statusIndicator);
                    if (c0453g.f()) {
                        viewFindViewById.setBackgroundColor(-15681151);
                    } else if (c0453g.e()) {
                        viewFindViewById.setBackgroundColor(-680437);
                    } else {
                        viewFindViewById.setBackgroundColor(-9735552);
                    }
                }
                return view;
            case 1:
            default:
                return super.getView(i5, view, viewGroup);
            case 2:
                View view2 = super.getView(i5, view, viewGroup);
                if (view2 instanceof TextView) {
                    TextView textView5 = (TextView) view2;
                    textView5.setTextColor(-1);
                    textView5.setTextSize(14.0f);
                }
                return view2;
            case 3:
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.item_team_member, viewGroup, false);
                }
                C0749g c0749g = (C0749g) getItem(i5);
                if (c0749g != null) {
                    TextView textView6 = (TextView) view.findViewById(R.id.tvMemberCallsign);
                    TextView textView7 = (TextView) view.findViewById(R.id.tvMemberStatus);
                    TextView textView8 = (TextView) view.findViewById(R.id.tvMemberRole);
                    textView6.setText(c0749g.f8404a);
                    textView7.setText(c0749g.b());
                    String str5 = c0749g.g;
                    if (str5 == null) {
                        str5 = "Role not specified";
                    }
                    textView8.setText(str5);
                    View viewFindViewById2 = view.findViewById(R.id.statusIndicator);
                    if ("emergency".equals(c0749g.f8407d)) {
                        viewFindViewById2.setBackgroundColor(-1096636);
                    } else if ("online".equals(c0749g.f8408e)) {
                        viewFindViewById2.setBackgroundColor(-15681151);
                    } else {
                        viewFindViewById2.setBackgroundColor(-6511697);
                    }
                }
                return view;
            case 4:
                Log.d("RadioTeamsManager", "=== ADAPTER getView ===");
                StringBuilder sb = new StringBuilder("Position: ");
                sb.append(i5);
                sb.append(", convertView: ");
                com.unified.ur1.SatelliteTracker.h.q(sb, view != null ? "reused" : "new", "RadioTeamsManager");
                if (view == null) {
                    view = LayoutInflater.from(getContext()).inflate(R.layout.item_saved_team, viewGroup, false);
                    Log.d("RadioTeamsManager", "Inflated new view");
                }
                k kVar = (k) getItem(i5);
                com.unified.ur1.SatelliteTracker.h.q(com.unified.ur1.SatelliteTracker.h.f("Team at position ", i5, ": "), kVar != null ? kVar.f8423a : "null", "RadioTeamsManager");
                if (kVar != null) {
                    TextView textView9 = (TextView) view.findViewById(R.id.tvTeamId);
                    TextView textView10 = (TextView) view.findViewById(R.id.tvCallsign);
                    TextView textView11 = (TextView) view.findViewById(R.id.tvAutoConnect);
                    com.unified.ur1.SatelliteTracker.h.q(new StringBuilder("Setting view data for team: "), kVar.f8423a, "RadioTeamsManager");
                    textView9.setText(kVar.f8423a);
                    textView10.setText(kVar.f8424b);
                    textView11.setVisibility(kVar.f8425c ? 0 : 8);
                    Log.d("RadioTeamsManager", "View updated successfully");
                }
                return view;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        switch (this.f6221c) {
            case 1:
                return true;
            default:
                return super.hasStableIds();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0454h(Context context, int i5, List list, int i6) {
        super(context, i5, list);
        this.f6221c = i6;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0454h(Context context, int i5, Object[] objArr) {
        super(context, i5, objArr);
        this.f6221c = 2;
    }
}
