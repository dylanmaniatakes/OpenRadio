package com.unified.ur1.chat;

import Q0.i;
import R0.f;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unified.ur1.R;
import com.unified.ur1.chat.NewMessageActivity;
import com.unified.ur1.inbox.MessageApiService;
import f.AbstractActivityC0472i;
import f3.C0524o;
import g3.C0548A;
import g3.w;
import g3.y;
import h4.c;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes.dex */
public class NewMessageActivity extends AbstractActivityC0472i implements y {

    /* renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f5757u = 0;

    /* renamed from: c, reason: collision with root package name */
    public EditText f5758c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f5759d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f5760e;

    /* renamed from: f, reason: collision with root package name */
    public ImageView f5761f;
    public LinearLayout g;
    public LinearLayout h;

    /* renamed from: i, reason: collision with root package name */
    public LinearLayout f5762i;

    /* renamed from: j, reason: collision with root package name */
    public LinearLayout f5763j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f5764k;

    /* renamed from: l, reason: collision with root package name */
    public RecyclerView f5765l;

    /* renamed from: m, reason: collision with root package name */
    public RecyclerView f5766m;
    public C0524o n;

    /* renamed from: o, reason: collision with root package name */
    public C0524o f5767o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f5768p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f5769q;

    /* renamed from: r, reason: collision with root package name */
    public MessageApiService f5770r;

    /* renamed from: s, reason: collision with root package name */
    public i f5771s;

    /* renamed from: t, reason: collision with root package name */
    public String f5772t;

    public static void j(NewMessageActivity newMessageActivity, boolean z4) {
        if (z4) {
            newMessageActivity.g.setVisibility(0);
            newMessageActivity.f5762i.setVisibility(8);
            newMessageActivity.h.setVisibility(8);
        } else {
            newMessageActivity.g.setVisibility(8);
            newMessageActivity.f5762i.setVisibility(0);
            newMessageActivity.h.setVisibility(8);
        }
    }

    public final void k(JSONObject jSONObject) {
        this.f5769q.clear();
        if (!jSONObject.getBoolean("success")) {
            n("API Error: " + jSONObject.optString("error", "Unknown error"));
            return;
        }
        JSONArray jSONArray = jSONObject.getJSONObject("data").getJSONArray("nearby_callsigns");
        for (int i5 = 0; i5 < jSONArray.length(); i5++) {
            JSONObject jSONObject2 = jSONArray.getJSONObject(i5);
            String string = jSONObject2.getString("callsign");
            double d5 = jSONObject2.getDouble("distance_miles");
            String string2 = jSONObject2.getString("direction");
            jSONObject2.getString("display");
            boolean zEquals = "On".equals(jSONObject2.getString("is_private"));
            jSONObject2.getString("last_updated");
            w wVar = new w();
            wVar.f7024a = string;
            wVar.f7025b = d5;
            wVar.f7026c = string2;
            wVar.f7027d = zEquals;
            this.f5769q.add(wVar);
        }
        this.f5763j.setVisibility(8);
        this.f5764k.setVisibility(8);
        if (this.f5769q.isEmpty()) {
            n("No nearby contacts found");
            return;
        }
        this.f5766m.setVisibility(0);
        C0524o c0524o = this.f5767o;
        c0524o.f6769b = this.f5769q;
        c0524o.notifyDataSetChanged();
    }

    public final void l() {
        this.g.setVisibility(8);
    }

    public final void m() {
        this.f5763j.setVisibility(0);
        this.f5766m.setVisibility(8);
        this.f5764k.setVisibility(8);
        String string = getSharedPreferences("app_settings", 0).getString("auth_code_1", "");
        if (string.isEmpty() || this.f5772t.isEmpty()) {
            n("Authentication required");
            return;
        }
        this.f5771s.a(new f("https://ur1.unifiedradios.com/api-nearby/nearby_callsigns_api.php?callsign=" + this.f5772t + "&max_distance=300&cloud_auth=" + string, new C0548A(this), new C0548A(this)));
    }

    public final void n(String str) {
        this.f5763j.setVisibility(8);
        this.f5766m.setVisibility(8);
        this.f5764k.setVisibility(0);
        TextView textView = (TextView) this.f5764k.findViewById(R.id.nearbyErrorMessage);
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void o(String str) {
        Intent intent = new Intent(this, (Class<?>) ChatActivity.class);
        intent.putExtra("other_user_callsign", str);
        startActivity(intent);
        finish();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_new_message);
        this.f5772t = c.h(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.f5758c = (EditText) findViewById(R.id.editToCallsign);
        this.f5759d = (ImageView) findViewById(R.id.buttonClose);
        this.f5760e = (ImageView) findViewById(R.id.buttonAddContact);
        this.f5761f = (ImageView) findViewById(R.id.buttonRefreshNearby);
        this.g = (LinearLayout) findViewById(R.id.suggestionsContainer);
        this.h = (LinearLayout) findViewById(R.id.emptyState);
        this.f5762i = (LinearLayout) findViewById(R.id.nearbyContactsSection);
        this.f5763j = (LinearLayout) findViewById(R.id.nearbyLoadingContainer);
        this.f5764k = (LinearLayout) findViewById(R.id.nearbyErrorContainer);
        this.f5765l = (RecyclerView) findViewById(R.id.suggestionsRecyclerView);
        this.f5766m = (RecyclerView) findViewById(R.id.nearbyContactsRecyclerView);
        final int i5 = 0;
        this.f5759d.setOnClickListener(new View.OnClickListener(this) { // from class: g3.z

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ NewMessageActivity f7034d;

            {
                this.f7034d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMessageActivity newMessageActivity = this.f7034d;
                switch (i5) {
                    case 0:
                        int i6 = NewMessageActivity.f5757u;
                        newMessageActivity.finish();
                        break;
                    case 1:
                        String upperCase = newMessageActivity.f5758c.getText().toString().trim().toUpperCase();
                        if (!upperCase.isEmpty()) {
                            newMessageActivity.o(upperCase);
                            break;
                        } else {
                            Toast.makeText(newMessageActivity, "Please enter a callsign", 0).show();
                            break;
                        }
                    default:
                        int i7 = NewMessageActivity.f5757u;
                        newMessageActivity.m();
                        break;
                }
            }
        });
        final int i6 = 1;
        this.f5760e.setOnClickListener(new View.OnClickListener(this) { // from class: g3.z

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ NewMessageActivity f7034d;

            {
                this.f7034d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMessageActivity newMessageActivity = this.f7034d;
                switch (i6) {
                    case 0:
                        int i62 = NewMessageActivity.f5757u;
                        newMessageActivity.finish();
                        break;
                    case 1:
                        String upperCase = newMessageActivity.f5758c.getText().toString().trim().toUpperCase();
                        if (!upperCase.isEmpty()) {
                            newMessageActivity.o(upperCase);
                            break;
                        } else {
                            Toast.makeText(newMessageActivity, "Please enter a callsign", 0).show();
                            break;
                        }
                    default:
                        int i7 = NewMessageActivity.f5757u;
                        newMessageActivity.m();
                        break;
                }
            }
        });
        final int i7 = 2;
        this.f5761f.setOnClickListener(new View.OnClickListener(this) { // from class: g3.z

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ NewMessageActivity f7034d;

            {
                this.f7034d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                NewMessageActivity newMessageActivity = this.f7034d;
                switch (i7) {
                    case 0:
                        int i62 = NewMessageActivity.f5757u;
                        newMessageActivity.finish();
                        break;
                    case 1:
                        String upperCase = newMessageActivity.f5758c.getText().toString().trim().toUpperCase();
                        if (!upperCase.isEmpty()) {
                            newMessageActivity.o(upperCase);
                            break;
                        } else {
                            Toast.makeText(newMessageActivity, "Please enter a callsign", 0).show();
                            break;
                        }
                    default:
                        int i72 = NewMessageActivity.f5757u;
                        newMessageActivity.m();
                        break;
                }
            }
        });
        this.f5758c.addTextChangedListener(new g3.f(1, this));
        try {
            this.f5770r = (MessageApiService) new Retrofit.Builder().baseUrl("https://ur1.unifiedradios.com/messages/").addConverterFactory(GsonConverterFactory.create()).build().create(MessageApiService.class);
        } catch (Exception unused) {
            this.f5770r = null;
        }
        this.f5771s = c.I(this);
        ArrayList arrayList = new ArrayList();
        this.f5768p = arrayList;
        C0548A c0548a = new C0548A(this);
        C0524o c0524o = new C0524o(2);
        c0524o.f6769b = arrayList;
        c0524o.f6770c = c0548a;
        this.n = c0524o;
        this.f5765l.setLayoutManager(new LinearLayoutManager(1));
        this.f5765l.setAdapter(this.n);
        ArrayList arrayList2 = new ArrayList();
        this.f5769q = arrayList2;
        C0524o c0524o2 = new C0524o(3);
        c0524o2.f6769b = arrayList2;
        c0524o2.f6770c = this;
        this.f5767o = c0524o2;
        this.f5766m.setLayoutManager(new LinearLayoutManager(1));
        this.f5766m.setAdapter(this.f5767o);
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4102);
        }
        m();
        this.f5758c.requestFocus();
    }
}
