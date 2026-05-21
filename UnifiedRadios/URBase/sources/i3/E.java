package i3;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.unified.ur1.R;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import f3.C0519j;
import f3.C0524o;
import g0.AbstractC0535a;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class E extends Fragment {

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f7276c;

    /* renamed from: d, reason: collision with root package name */
    public SwipeRefreshLayout f7277d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f7278e;

    /* renamed from: f, reason: collision with root package name */
    public C0524o f7279f;
    public ArrayList g;
    public D h;

    public final void g() {
        Log.d("SentFragment", "=== SentFragment loadSentMessages() called ===");
        D d5 = this.h;
        if (d5 == null) {
            Log.e("SentFragment", "Listener is null - fragment not properly connected to activity");
            SwipeRefreshLayout swipeRefreshLayout = this.f7277d;
            if (swipeRefreshLayout != null) {
                swipeRefreshLayout.setRefreshing(false);
                return;
            }
            return;
        }
        if (((UnifiedInboxActivity) d5).h == null) {
            Log.e("SentFragment", "API Service is null from listener");
            SwipeRefreshLayout swipeRefreshLayout2 = this.f7277d;
            if (swipeRefreshLayout2 != null) {
                swipeRefreshLayout2.setRefreshing(false);
                return;
            }
            return;
        }
        if (((UnifiedInboxActivity) d5).f5836j != null && !((UnifiedInboxActivity) d5).f5836j.isEmpty()) {
            String str = ((UnifiedInboxActivity) this.h).f5836j;
            AbstractC0535a.v("Making API call for sent messages, callsign: ", str, "SentFragment");
            ((UnifiedInboxActivity) this.h).h.getSentMessages("get_sent", str, 0, 50).enqueue(new L0.l(24, this));
        } else {
            Log.e("SentFragment", "User callsign is null or empty from listener");
            SwipeRefreshLayout swipeRefreshLayout3 = this.f7277d;
            if (swipeRefreshLayout3 != null) {
                swipeRefreshLayout3.setRefreshing(false);
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View viewInflate = layoutInflater.inflate(R.layout.fragment_sent, viewGroup, false);
        this.f7276c = (RecyclerView) viewInflate.findViewById(R.id.recyclerViewSentMessages);
        this.f7277d = (SwipeRefreshLayout) viewInflate.findViewById(R.id.swipeRefreshLayout);
        this.f7278e = (TextView) viewInflate.findViewById(R.id.emptyView);
        ArrayList arrayList = new ArrayList();
        this.g = arrayList;
        this.f7279f = new C0524o(arrayList, new C0519j(18, this), 6);
        RecyclerView recyclerView = this.f7276c;
        getContext();
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        this.f7276c.setAdapter(this.f7279f);
        this.f7277d.setOnRefreshListener(new D0.p(15, this));
        this.f7277d.setColorSchemeColors(getResources().getColor(android.R.color.holo_blue_bright), getResources().getColor(android.R.color.holo_green_light), getResources().getColor(android.R.color.holo_orange_light));
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        Log.d("SentFragment", "onViewCreated() called");
    }
}
