package com.unified.ur1.adapters;

import B0.a;
import Z2.c;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;
import com.unified.ur1.R;
import f.AbstractActivityC0472i;
import f3.C0524o;
import f3.C0525p;
import f3.ViewOnClickListenerC0521l;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes.dex */
public class LastHeardActivity extends AbstractActivityC0472i {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f5664i = 0;

    /* renamed from: c, reason: collision with root package name */
    public RecyclerView f5665c;

    /* renamed from: d, reason: collision with root package name */
    public C0524o f5666d;

    /* renamed from: e, reason: collision with root package name */
    public ArrayList f5667e;

    /* renamed from: f, reason: collision with root package name */
    public Button f5668f;
    public Button g;
    public Gson h;

    public final void j(LinearLayout linearLayout, String str, String str2, String str3) {
        LinearLayout linearLayout2 = new LinearLayout(this);
        linearLayout2.setOrientation(0);
        linearLayout2.setPadding(0, 8, 0, 8);
        linearLayout2.setGravity(16);
        TextView textView = new TextView(this);
        textView.setText(str);
        textView.setTextColor(Color.parseColor(str3));
        textView.setTextSize(14.0f);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.4f));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(this);
        if (str2 == null) {
            str2 = "N/A";
        }
        textView2.setText(str2);
        textView2.setTextColor(-1);
        textView2.setTextSize(14.0f);
        textView2.setTypeface(Typeface.MONOSPACE);
        textView2.setLayoutParams(new LinearLayout.LayoutParams(0, -2, 0.6f));
        linearLayout2.addView(textView2);
        linearLayout.addView(linearLayout2);
    }

    public final void k() {
        C0525p[] c0525pArr;
        SharedPreferences sharedPreferences = getSharedPreferences("last_heard_prefs", 0);
        this.f5667e.clear();
        try {
            String string = sharedPreferences.getString("last_heard_data", "");
            Log.d("LastHeardActivity", "Loading last heard data, JSON length: " + string.length());
            if (!string.isEmpty() && (c0525pArr = (C0525p[]) new Gson().fromJson(string, C0525p[].class)) != null && c0525pArr.length > 0) {
                for (C0525p c0525p : c0525pArr) {
                    this.f5667e.add(c0525p);
                }
                n();
                Log.d("LastHeardActivity", "Loaded " + this.f5667e.size() + " last heard items from preferences (after trimming)");
                for (int i5 = 0; i5 < Math.min(3, this.f5667e.size()); i5++) {
                    C0525p c0525p2 = (C0525p) this.f5667e.get(i5);
                    Log.d("LastHeardActivity", "Item " + i5 + ": " + c0525p2.f6774a + " on TG " + c0525p2.f6777d + " at " + c0525p2.f6778e);
                }
            }
            if (this.f5667e.isEmpty()) {
                Log.d("LastHeardActivity", "No real data found, loading sample data for demonstration");
                l();
            } else {
                Log.d("LastHeardActivity", "Real data loaded successfully, skipping sample data");
                m();
            }
        } catch (Exception e5) {
            Log.e("LastHeardActivity", "Error loading last heard data: " + e5.getMessage(), e5);
            l();
        }
        this.f5666d.notifyDataSetChanged();
        Log.d("LastHeardActivity", "Adapter notified, total items: " + this.f5667e.size());
    }

    public final void l() {
        this.f5667e.add(new C0525p("KJ4ABC", "John Smith", "Atlanta, GA", 91, "14:32:45", 15));
        this.f5667e.add(new C0525p("W5XYZ", "Mary Johnson", "Dallas, TX", 3100, "14:28:12", 8));
        this.f5667e.add(new C0525p("N0TEST", "Bob Wilson", "Denver, CO", 312700, "14:15:33", 22));
        Log.d("LastHeardActivity", "Sample data loaded: " + this.f5667e.size() + " items");
    }

    public final void m() {
        getSharedPreferences("last_heard_prefs", 0).edit().putString("last_heard_data", this.h.toJson(this.f5667e.toArray(new C0525p[0]))).apply();
        Log.d("LastHeardActivity", "Saved " + this.f5667e.size() + " records to preferences");
    }

    public final void n() {
        if (this.f5667e.isEmpty()) {
            return;
        }
        Collections.sort(this.f5667e, new a(5));
        if (this.f5667e.size() > 50) {
            Log.d("LastHeardActivity", "Trimming " + (this.f5667e.size() - 50) + " old records. Keeping latest 50");
            for (int size = this.f5667e.size() + (-1); size >= 50; size--) {
                this.f5667e.remove(size);
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_last_heard);
        this.h = new Gson();
        this.f5665c = (RecyclerView) findViewById(R.id.lastHeardRecyclerView);
        this.f5668f = (Button) findViewById(R.id.clearHistoryButton);
        this.g = (Button) findViewById(R.id.backButton);
        this.f5667e = new ArrayList();
        this.f5665c.setLayoutManager(new LinearLayoutManager(1));
        ArrayList arrayList = this.f5667e;
        c cVar = new c(17, this);
        C0524o c0524o = new C0524o(0);
        c0524o.f6769b = arrayList;
        c0524o.f6770c = cVar;
        this.f5666d = c0524o;
        this.f5665c.setAdapter(c0524o);
        this.f5668f.setOnClickListener(new ViewOnClickListenerC0521l(this, 0));
        this.g.setOnClickListener(new ViewOnClickListenerC0521l(this, 1));
        k();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onResume() {
        super.onResume();
        Log.d("LastHeardActivity", "onResume called - reloading data");
        k();
    }
}
