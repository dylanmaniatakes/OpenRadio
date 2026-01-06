package i3;

import android.app.AlertDialog;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.unified.ur1.R;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import e0.C0432c;
import f3.C0524o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class m extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    public J0.d f7316c;

    /* renamed from: d, reason: collision with root package name */
    public RecyclerView f7317d;

    /* renamed from: e, reason: collision with root package name */
    public SwipeRefreshLayout f7318e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f7319f;
    public C0524o g;
    public ArrayList h;

    /* renamed from: i, reason: collision with root package name */
    public l f7320i;

    public static void g(m mVar, Message message, int i5) {
        String fromCallsign;
        if (mVar.getContext() == null) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(mVar.getContext());
        if (message.isTeamMessage()) {
            fromCallsign = "team " + message.getTeamId();
        } else {
            fromCallsign = message.getFromCallsign() != null ? message.getFromCallsign() : "Unknown";
        }
        builder.setTitle("Delete Conversation").setMessage("Are you sure you want to delete this conversation with " + fromCallsign + "?").setPositiveButton("Delete", new k(mVar, message, i5, 0)).setNegativeButton("Cancel", new j(i5, 0, mVar)).show();
    }

    public static String h(String str) {
        if (str == null || str.trim().isEmpty()) {
            return "No content";
        }
        if (str.length() <= 50) {
            return str;
        }
        return str.substring(0, 50) + "...";
    }

    public final void i() {
        l lVar = this.f7320i;
        if (lVar == null || ((UnifiedInboxActivity) lVar).h == null || ((UnifiedInboxActivity) lVar).f5836j == null || ((UnifiedInboxActivity) lVar).f5836j.isEmpty()) {
            this.f7318e.setRefreshing(false);
            return;
        }
        l lVar2 = this.f7320i;
        String str = ((UnifiedInboxActivity) lVar2).f5836j;
        ((UnifiedInboxActivity) lVar2).h.getMessages(str, 0, 500).enqueue(new L0.c(this, 18, str));
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_inbox, viewGroup, false);
        this.f7317d = (RecyclerView) viewInflate.findViewById(R.id.recyclerViewMessages);
        this.f7318e = (SwipeRefreshLayout) viewInflate.findViewById(R.id.swipeRefreshLayout);
        this.f7319f = (TextView) viewInflate.findViewById(R.id.emptyView);
        ArrayList arrayList = new ArrayList();
        this.h = arrayList;
        this.g = new C0524o(arrayList, new L0.l(23, this), 5);
        RecyclerView recyclerView = this.f7317d;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        this.f7317d.setAdapter(this.g);
        this.f7318e.setOnRefreshListener(new C0579h(this));
        this.f7318e.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_bright), getResources().getColor(android.R.color.holo_green_light), getResources().getColor(android.R.color.holo_orange_light));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        if (this.f7316c != null) {
            C0432c.a(requireContext()).d(this.f7316c);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f7316c = new J0.d(4, this);
        C0432c.a(requireContext()).b(this.f7316c, new IntentFilter("REFRESH_INBOX"));
        getParentFragmentManager().R(this, new C0579h(this));
        view.postDelayed(new C0.e(20, this), 100L);
    }
}
