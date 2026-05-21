package o3;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unified.ur1.R;
import g0.AbstractC0535a;
import java.util.ArrayList;
import java.util.HashMap;
import k.C0657t0;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public final class x {

    /* renamed from: A, reason: collision with root package name */
    public ProgressBar f8977A;

    /* renamed from: B, reason: collision with root package name */
    public Button f8978B;

    /* renamed from: C, reason: collision with root package name */
    public Button f8979C;

    /* renamed from: D, reason: collision with root package name */
    public View f8980D;

    /* renamed from: E, reason: collision with root package name */
    public TextView f8981E;

    /* renamed from: F, reason: collision with root package name */
    public TextView f8982F;

    /* renamed from: G, reason: collision with root package name */
    public String f8983G;

    /* renamed from: H, reason: collision with root package name */
    public int f8984H;

    /* renamed from: a, reason: collision with root package name */
    public Context f8985a;

    /* renamed from: b, reason: collision with root package name */
    public String f8986b;

    /* renamed from: c, reason: collision with root package name */
    public String f8987c;

    /* renamed from: d, reason: collision with root package name */
    public String f8988d;

    /* renamed from: e, reason: collision with root package name */
    public String f8989e;

    /* renamed from: f, reason: collision with root package name */
    public s f8990f;
    public Dialog g;
    public u h;

    /* renamed from: i, reason: collision with root package name */
    public u f8991i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f8992j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f8993k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f8994l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f8995m;
    public ArrayList n;

    /* renamed from: o, reason: collision with root package name */
    public v f8996o;

    /* renamed from: p, reason: collision with root package name */
    public r f8997p;

    /* renamed from: q, reason: collision with root package name */
    public Handler f8998q;

    /* renamed from: r, reason: collision with root package name */
    public Runnable f8999r;

    /* renamed from: s, reason: collision with root package name */
    public Spinner f9000s;

    /* renamed from: t, reason: collision with root package name */
    public EditText f9001t;

    /* renamed from: u, reason: collision with root package name */
    public RecyclerView f9002u;

    /* renamed from: v, reason: collision with root package name */
    public TextView f9003v;

    /* renamed from: w, reason: collision with root package name */
    public TextView f9004w;

    /* renamed from: x, reason: collision with root package name */
    public LinearLayout f9005x;

    /* renamed from: y, reason: collision with root package name */
    public CardView f9006y;

    /* renamed from: z, reason: collision with root package name */
    public CardView f9007z;

    public static boolean f(String str) {
        if (str != null && !str.trim().isEmpty()) {
            String strTrim = str.trim();
            if (strTrim.matches("^\\d{1,7}$") || strTrim.toUpperCase().matches("^TG\\s*\\d{1,7}$")) {
                return true;
            }
        }
        return false;
    }

    public final q a(String str, Q0.k kVar) {
        HashMap map = new HashMap();
        map.put("Content-Type", "application/json");
        return new q(str, kVar, new m(this, 3), map);
    }

    public final v b(String str) {
        String strTrim = str.trim();
        if (strTrim.toUpperCase().startsWith("TG")) {
            strTrim = strTrim.toUpperCase().replaceAll("^TG\\s*", "");
        }
        String str2 = strTrim;
        return new v(com.unified.ur1.SatelliteTracker.h.s("manual_", str2), this.f8989e, str2, com.unified.ur1.SatelliteTracker.h.s("Manual TG: ", str2), AbstractC0535a.l("Manual Entry | TG:", str2, " (not in DB)"));
    }

    public final void c() {
        int iC = AbstractC0882e.c(this.f8984H);
        if (iC == 1) {
            this.f8990f = null;
            ArrayList arrayList = this.f8992j;
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f8989e = null;
                this.f8984H = 1;
                n();
                j();
                return;
            }
            this.f9006y.setVisibility(0);
            r rVar = this.f8997p;
            if (rVar != null) {
                rVar.l();
            }
            this.g.dismiss();
            return;
        }
        if (iC != 2) {
            return;
        }
        this.f8996o = null;
        this.f8984H = 2;
        n();
        String str = this.f8990f.f8954e;
        if (str != null && !str.isEmpty()) {
            h4.c.T(this.f8985a, this.f8990f.f8954e);
            StringBuilder sb = new StringBuilder("Final password storage for network ");
            sb.append(this.f8989e);
            sb.append(" server ");
            sb.append(this.f8990f.f8951b);
            sb.append(": ");
            com.unified.ur1.SatelliteTracker.h.q(sb, this.f8990f.f8954e, "ROIP");
        }
        if (this.f8990f == null) {
            this.f9006y.setVisibility(0);
        }
    }

    public final void d() {
        InputMethodManager inputMethodManager;
        Dialog dialog = this.g;
        if (dialog == null || dialog.getWindow() == null) {
            return;
        }
        View currentFocus = this.g.getCurrentFocus();
        if (currentFocus != null && (inputMethodManager = (InputMethodManager) this.f8985a.getSystemService("input_method")) != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
        }
        EditText editText = this.f9001t;
        if (editText != null) {
            editText.clearFocus();
        }
    }

    public final void e() {
        this.f8992j = new ArrayList();
        this.f8993k = new ArrayList();
        this.f8994l = new ArrayList();
        this.f8995m = new ArrayList();
        this.n = new ArrayList();
        this.f8998q = new Handler(Looper.getMainLooper());
    }

    public final void g() {
        if (this.f8989e == null) {
            return;
        }
        if (!o()) {
            l();
            return;
        }
        this.f9004w.setText("Loading...");
        String str = this.f8986b + "/servers?cloud_auth=" + this.f8987c + "&mode=" + this.f8988d + "&network=" + this.f8989e + "&_t=" + System.currentTimeMillis();
        Log.d("ROIP", "Servers URL: " + str);
        h4.c.I(this.f8985a).a(a(str, new m(this, 2)));
    }

    public final void h() {
        if (this.f8989e == null) {
            return;
        }
        this.f9004w.setText("Loading...");
        String str = this.f8986b + "/talkgroups?cloud_auth=" + this.f8987c + "&network=" + this.f8989e + "&_t=" + System.currentTimeMillis();
        Log.d("ROIP", "TG URL: " + str);
        h4.c.I(this.f8985a).a(a(str, new m(this, 1)));
    }

    public final void i(r rVar) {
        WindowInsetsController insetsController;
        this.f8997p = rVar;
        Context context = this.f8985a;
        this.g = new Dialog(context, R.style.FullScreenDialog);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.roip_talkgroup_selector, (ViewGroup) null);
        this.g.setContentView(viewInflate);
        this.f9000s = (Spinner) viewInflate.findViewById(R.id.networkSpinner);
        this.f8980D = viewInflate.findViewById(R.id.networkSelectorCard);
        this.f9001t = (EditText) viewInflate.findViewById(R.id.searchTalkgroup);
        this.f9002u = (RecyclerView) viewInflate.findViewById(R.id.talkgroupRecyclerView);
        this.f9003v = (TextView) viewInflate.findViewById(R.id.currentNetwork);
        this.f9004w = (TextView) viewInflate.findViewById(R.id.talkgroupCount);
        this.f9005x = (LinearLayout) viewInflate.findViewById(R.id.emptyState);
        this.f9006y = (CardView) viewInflate.findViewById(R.id.networkInfoCard);
        this.f9007z = (CardView) viewInflate.findViewById(R.id.serverInfoCard);
        this.f8977A = (ProgressBar) viewInflate.findViewById(R.id.searchProgress);
        this.f8978B = (Button) viewInflate.findViewById(R.id.selectButton);
        this.f8979C = (Button) viewInflate.findViewById(R.id.backButton);
        this.f8981E = (TextView) viewInflate.findViewById(R.id.headerTitle);
        this.f8982F = (TextView) viewInflate.findViewById(R.id.headerSubtitle);
        Button button = (Button) viewInflate.findViewById(R.id.cancelButton);
        this.f9002u.setLayoutManager(new LinearLayoutManager(1));
        this.f8978B.setEnabled(false);
        this.f8979C.setVisibility(8);
        final int i5 = 0;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: o3.n

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ x f8945d;

            {
                this.f8945d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i6 = 3;
                switch (i5) {
                    case 0:
                        x xVar = this.f8945d;
                        r rVar2 = xVar.f8997p;
                        if (rVar2 != null) {
                            rVar2.l();
                        }
                        xVar.g.dismiss();
                        break;
                    case 1:
                        x xVar2 = this.f8945d;
                        int iC = AbstractC0882e.c(xVar2.f8984H);
                        if (iC == 0) {
                            if (xVar2.f8989e != null) {
                                if (!xVar2.o()) {
                                    xVar2.l();
                                    break;
                                } else {
                                    xVar2.f8984H = 2;
                                    xVar2.n();
                                    xVar2.g();
                                    break;
                                }
                            }
                        } else if (iC == 1) {
                            if (xVar2.f8990f != null) {
                                xVar2.f8984H = 3;
                                xVar2.n();
                                xVar2.h();
                                break;
                            }
                        } else if (iC == 2 && xVar2.f8996o != null && xVar2.f8990f != null && xVar2.f8997p != null) {
                            View viewFindViewById = xVar2.g.findViewById(R.id.waiting);
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(0);
                                Z3.c cVar = Z3.c.h;
                                Log.d("EventBus", "Wait layout found and shown");
                            } else {
                                Z3.c cVar2 = Z3.c.h;
                                Log.d("EventBus", "Wait layout not found in dialog, using progress dialog only");
                            }
                            xVar2.f8978B.setText("Activating...");
                            xVar2.f8978B.setEnabled(false);
                            String str = xVar2.f8990f.f8954e;
                            if (str != null && !str.isEmpty()) {
                                h4.c.T(xVar2.f8985a, xVar2.f8990f.f8954e);
                                StringBuilder sb = new StringBuilder("Final password storage for network ");
                                sb.append(xVar2.f8989e);
                                sb.append(" server ");
                                sb.append(xVar2.f8990f.f8951b);
                                sb.append(": ");
                                com.unified.ur1.SatelliteTracker.h.q(sb, xVar2.f8990f.f8954e, "ROIP");
                            }
                            new Handler(Looper.getMainLooper()).postDelayed(new m3.o(i6, xVar2), 1000L);
                            break;
                        }
                        break;
                    default:
                        this.f8945d.c();
                        break;
                }
            }
        });
        final int i6 = 1;
        this.f8978B.setOnClickListener(new View.OnClickListener(this) { // from class: o3.n

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ x f8945d;

            {
                this.f8945d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = 3;
                switch (i6) {
                    case 0:
                        x xVar = this.f8945d;
                        r rVar2 = xVar.f8997p;
                        if (rVar2 != null) {
                            rVar2.l();
                        }
                        xVar.g.dismiss();
                        break;
                    case 1:
                        x xVar2 = this.f8945d;
                        int iC = AbstractC0882e.c(xVar2.f8984H);
                        if (iC == 0) {
                            if (xVar2.f8989e != null) {
                                if (!xVar2.o()) {
                                    xVar2.l();
                                    break;
                                } else {
                                    xVar2.f8984H = 2;
                                    xVar2.n();
                                    xVar2.g();
                                    break;
                                }
                            }
                        } else if (iC == 1) {
                            if (xVar2.f8990f != null) {
                                xVar2.f8984H = 3;
                                xVar2.n();
                                xVar2.h();
                                break;
                            }
                        } else if (iC == 2 && xVar2.f8996o != null && xVar2.f8990f != null && xVar2.f8997p != null) {
                            View viewFindViewById = xVar2.g.findViewById(R.id.waiting);
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(0);
                                Z3.c cVar = Z3.c.h;
                                Log.d("EventBus", "Wait layout found and shown");
                            } else {
                                Z3.c cVar2 = Z3.c.h;
                                Log.d("EventBus", "Wait layout not found in dialog, using progress dialog only");
                            }
                            xVar2.f8978B.setText("Activating...");
                            xVar2.f8978B.setEnabled(false);
                            String str = xVar2.f8990f.f8954e;
                            if (str != null && !str.isEmpty()) {
                                h4.c.T(xVar2.f8985a, xVar2.f8990f.f8954e);
                                StringBuilder sb = new StringBuilder("Final password storage for network ");
                                sb.append(xVar2.f8989e);
                                sb.append(" server ");
                                sb.append(xVar2.f8990f.f8951b);
                                sb.append(": ");
                                com.unified.ur1.SatelliteTracker.h.q(sb, xVar2.f8990f.f8954e, "ROIP");
                            }
                            new Handler(Looper.getMainLooper()).postDelayed(new m3.o(i62, xVar2), 1000L);
                            break;
                        }
                        break;
                    default:
                        this.f8945d.c();
                        break;
                }
            }
        });
        final int i7 = 2;
        this.f8979C.setOnClickListener(new View.OnClickListener(this) { // from class: o3.n

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ x f8945d;

            {
                this.f8945d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                int i62 = 3;
                switch (i7) {
                    case 0:
                        x xVar = this.f8945d;
                        r rVar2 = xVar.f8997p;
                        if (rVar2 != null) {
                            rVar2.l();
                        }
                        xVar.g.dismiss();
                        break;
                    case 1:
                        x xVar2 = this.f8945d;
                        int iC = AbstractC0882e.c(xVar2.f8984H);
                        if (iC == 0) {
                            if (xVar2.f8989e != null) {
                                if (!xVar2.o()) {
                                    xVar2.l();
                                    break;
                                } else {
                                    xVar2.f8984H = 2;
                                    xVar2.n();
                                    xVar2.g();
                                    break;
                                }
                            }
                        } else if (iC == 1) {
                            if (xVar2.f8990f != null) {
                                xVar2.f8984H = 3;
                                xVar2.n();
                                xVar2.h();
                                break;
                            }
                        } else if (iC == 2 && xVar2.f8996o != null && xVar2.f8990f != null && xVar2.f8997p != null) {
                            View viewFindViewById = xVar2.g.findViewById(R.id.waiting);
                            if (viewFindViewById != null) {
                                viewFindViewById.setVisibility(0);
                                Z3.c cVar = Z3.c.h;
                                Log.d("EventBus", "Wait layout found and shown");
                            } else {
                                Z3.c cVar2 = Z3.c.h;
                                Log.d("EventBus", "Wait layout not found in dialog, using progress dialog only");
                            }
                            xVar2.f8978B.setText("Activating...");
                            xVar2.f8978B.setEnabled(false);
                            String str = xVar2.f8990f.f8954e;
                            if (str != null && !str.isEmpty()) {
                                h4.c.T(xVar2.f8985a, xVar2.f8990f.f8954e);
                                StringBuilder sb = new StringBuilder("Final password storage for network ");
                                sb.append(xVar2.f8989e);
                                sb.append(" server ");
                                sb.append(xVar2.f8990f.f8951b);
                                sb.append(": ");
                                com.unified.ur1.SatelliteTracker.h.q(sb, xVar2.f8990f.f8954e, "ROIP");
                            }
                            new Handler(Looper.getMainLooper()).postDelayed(new m3.o(i62, xVar2), 1000L);
                            break;
                        }
                        break;
                    default:
                        this.f8945d.c();
                        break;
                }
            }
        });
        n();
        Spinner spinner = this.f9000s;
        if (spinner != null) {
            spinner.setOnItemSelectedListener(new C0657t0(3, this));
        }
        this.f9001t.addTextChangedListener(new g3.f(5, this));
        int iC = AbstractC0882e.c(this.f8984H);
        if (iC == 0) {
            this.f9004w.setText("Loading...");
            String str = this.f8986b + "/networks?cloud_auth=" + this.f8987c + "&mode=" + this.f8988d + "&_t=" + System.currentTimeMillis();
            Log.d("ROIP", "Networks URL: " + str);
            h4.c.I(this.f8985a).a(a(str, new m(this, 0)));
        } else if (iC == 1) {
            g();
        } else if (iC == 2) {
            h();
        }
        if (this.g.getWindow() != null) {
            this.g.getWindow().getDecorView().setSystemUiVisibility(5894);
            if (Build.VERSION.SDK_INT >= 30 && (insetsController = this.g.getWindow().getInsetsController()) != null) {
                insetsController.hide(WindowInsets.Type.systemBars());
                insetsController.setSystemBarsBehavior(2);
            }
        }
        this.g.show();
    }

    public final void j() {
        if (this.f9000s == null || this.f8992j == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add("Select Network...");
        arrayList.addAll(this.f8992j);
        ArrayAdapter arrayAdapter = new ArrayAdapter(this.f8985a, android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        this.f9000s.setAdapter((SpinnerAdapter) arrayAdapter);
        this.f9000s.setSelection(0);
    }

    public final void k(String str) {
        Toast.makeText(this.f8985a, str, 0).show();
        r rVar = this.f8997p;
        if (rVar != null) {
            rVar.l();
        }
    }

    public final void l() {
        Context context = this.f8985a;
        final Dialog dialog = new Dialog(context, R.style.FullScreenDialog);
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.error_popup_layout, (ViewGroup) null);
        dialog.setContentView(viewInflate);
        TextView textView = (TextView) viewInflate.findViewById(R.id.error_title);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.error_subtitle);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.error_message);
        Button button = (Button) viewInflate.findViewById(R.id.btn_dismiss);
        textView.setText("Authentication Required");
        textView2.setText("Password Not Configured!");
        textView3.setText("You cannot login to " + (this.f8989e.equals("brandmeister") ? "Brandmeister" : this.f8989e.equals("tgif") ? "TGIF" : this.f8989e) + " network without setting your password. Please visit my.unifiedradios.com to configure your network credentials.");
        final int i5 = 0;
        button.setOnClickListener(new View.OnClickListener(this) { // from class: o3.o

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ x f8947d;

            {
                this.f8947d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i5) {
                    case 0:
                        x xVar = this.f8947d;
                        xVar.getClass();
                        dialog.dismiss();
                        if (xVar.f8984H != 2) {
                            r rVar = xVar.f8997p;
                            if (rVar != null) {
                                rVar.l();
                            }
                            xVar.g.dismiss();
                            break;
                        } else {
                            xVar.c();
                            break;
                        }
                    default:
                        x xVar2 = this.f8947d;
                        xVar2.getClass();
                        dialog.dismiss();
                        if (xVar2.f8984H != 2) {
                            r rVar2 = xVar2.f8997p;
                            if (rVar2 != null) {
                                rVar2.l();
                            }
                            xVar2.g.dismiss();
                            break;
                        } else {
                            xVar2.c();
                            break;
                        }
                }
            }
        });
        final int i6 = 1;
        viewInflate.findViewById(R.id.dismiss_overlay).setOnClickListener(new View.OnClickListener(this) { // from class: o3.o

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ x f8947d;

            {
                this.f8947d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                switch (i6) {
                    case 0:
                        x xVar = this.f8947d;
                        xVar.getClass();
                        dialog.dismiss();
                        if (xVar.f8984H != 2) {
                            r rVar = xVar.f8997p;
                            if (rVar != null) {
                                rVar.l();
                            }
                            xVar.g.dismiss();
                            break;
                        } else {
                            xVar.c();
                            break;
                        }
                    default:
                        x xVar2 = this.f8947d;
                        xVar2.getClass();
                        dialog.dismiss();
                        if (xVar2.f8984H != 2) {
                            r rVar2 = xVar2.f8997p;
                            if (rVar2 != null) {
                                rVar2.l();
                            }
                            xVar2.g.dismiss();
                            break;
                        } else {
                            xVar2.c();
                            break;
                        }
                }
            }
        });
        dialog.show();
    }

    public final void m() {
        int size;
        String str;
        int iC = AbstractC0882e.c(this.f8984H);
        if (iC == 1) {
            size = this.n.size();
            str = "servers";
        } else {
            if (iC != 2) {
                return;
            }
            size = this.f8994l.size();
            str = "TGs";
        }
        this.f9004w.setText(String.format("%,d %s", Integer.valueOf(size), str));
        boolean z4 = size == 0;
        this.f9005x.setVisibility(z4 ? 0 : 8);
        this.f9002u.setVisibility(z4 ? 8 : 0);
    }

    public final void n() {
        int iC = AbstractC0882e.c(this.f8984H);
        int i5 = 0;
        if (iC != 0) {
            if (iC == 1) {
                this.f8981E.setText("Select Server");
                this.f8982F.setText("Choose a server for your connection");
                this.f8980D.setVisibility(8);
                this.f9006y.setVisibility(this.f8990f == null ? 0 : 8);
                this.f9007z.setVisibility(8);
                this.f9001t.setVisibility(0);
                this.f9001t.setHint("Search servers...");
                this.f9002u.setVisibility(0);
                this.f8978B.setText("Continue");
                this.f8978B.setEnabled(this.f8990f != null);
                Button button = this.f8979C;
                if (this.f8989e != null && this.f8996o == null) {
                    i5 = 8;
                }
                button.setVisibility(i5);
                u uVar = this.f8991i;
                if (uVar == null) {
                    u uVar2 = new u(this, 0);
                    this.f8991i = uVar2;
                    this.f9002u.setAdapter(uVar2);
                } else {
                    this.f9002u.setAdapter(uVar);
                    this.f8991i.notifyDataSetChanged();
                }
                this.f9003v.setText(this.f8989e);
                this.f9004w.setText(String.format("%,d servers", Integer.valueOf(this.n.size())));
            } else if (iC == 2) {
                this.f8981E.setText("Select Talkgroup");
                this.f8982F.setText("Choose a talkgroup for your ROIP channel");
                this.f8980D.setVisibility(8);
                this.f9006y.setVisibility(8);
                this.f9007z.setVisibility(8);
                this.f9001t.setVisibility(0);
                this.f9001t.setHint("Search talkgroups (ID or name)...");
                this.f9002u.setVisibility(0);
                this.f8978B.setText("Activate");
                this.f8978B.setEnabled(this.f8996o != null);
                this.f8979C.setVisibility(0);
                u uVar3 = this.h;
                if (uVar3 == null) {
                    u uVar4 = new u(this, 1);
                    this.h = uVar4;
                    this.f9002u.setAdapter(uVar4);
                } else {
                    this.f9002u.setAdapter(uVar3);
                    this.h.notifyDataSetChanged();
                }
                if (this.f8990f != null) {
                    this.f8982F.setText(this.f8989e + " → " + this.f8990f.f8951b);
                }
                this.f9004w.setText(String.format("%,d TGs", Integer.valueOf(this.f8994l.size())));
            }
        } else {
            this.f8981E.setText("Select Network");
            this.f8982F.setText("Choose a DMR network for your ROIP channel");
            this.f8980D.setVisibility(0);
            this.f9006y.setVisibility(8);
            this.f9007z.setVisibility(8);
            this.f9001t.setVisibility(8);
            this.f9002u.setVisibility(8);
            this.f8978B.setText("Continue");
            this.f8978B.setEnabled(false);
            this.f8979C.setVisibility(8);
        }
        EditText editText = this.f9001t;
        if (editText != null) {
            editText.setText("");
        }
    }

    public final boolean o() {
        String str = this.f8989e;
        if (str == null) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        if (!lowerCase.equals("brandmeister") && !lowerCase.equals("tgif")) {
            return true;
        }
        String string = h4.c.C(this.f8985a).getString("dmr_password", "CALL");
        if (string != null && !string.trim().isEmpty()) {
            com.unified.ur1.SatelliteTracker.h.q(new StringBuilder("Password validation passed for network: "), this.f8989e, "ROIP");
            return true;
        }
        StringBuilder sb = new StringBuilder("Password validation failed for network: ");
        sb.append(this.f8989e);
        sb.append(" - Password is ");
        sb.append(string == null ? "null" : "empty");
        Log.w("ROIP", sb.toString());
        return false;
    }
}
