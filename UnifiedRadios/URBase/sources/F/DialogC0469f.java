package f;

import O.N;
import O.Y;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.AbstractC0245o;
import androidx.lifecycle.C0251v;
import androidx.lifecycle.EnumC0243m;
import androidx.lifecycle.InterfaceC0249t;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import java.util.WeakHashMap;
import k.C0655s0;

/* renamed from: f.f, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class DialogC0469f extends Dialog implements DialogInterface, j, InterfaceC0249t, androidx.activity.v, o0.e {

    /* renamed from: c, reason: collision with root package name */
    public C0251v f6341c;

    /* renamed from: d, reason: collision with root package name */
    public final o0.d f6342d;

    /* renamed from: e, reason: collision with root package name */
    public final androidx.activity.u f6343e;

    /* renamed from: f, reason: collision with root package name */
    public x f6344f;
    public final y g;
    public final C0468e h;

    public DialogC0469f(ContextThemeWrapper contextThemeWrapper, int i5) {
        int i6;
        int iG = g(contextThemeWrapper, i5);
        if (iG == 0) {
            TypedValue typedValue = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue, true);
            i6 = typedValue.resourceId;
        } else {
            i6 = iG;
        }
        super(contextThemeWrapper, i6);
        this.f6342d = new o0.d(this);
        this.f6343e = new androidx.activity.u(new C0.e(9, this));
        this.g = new y(this);
        n nVarB = b();
        if (iG == 0) {
            TypedValue typedValue2 = new TypedValue();
            contextThemeWrapper.getTheme().resolveAttribute(R.attr.dialogTheme, typedValue2, true);
            iG = typedValue2.resourceId;
        }
        ((x) nVarB).f6408V = iG;
        nVarB.d();
        this.h = new C0468e(getContext(), this, getWindow());
    }

    public static void a(DialogC0469f dialogC0469f) {
        F3.i.f(dialogC0469f, "this$0");
        super.onBackPressed();
    }

    public static int g(Context context, int i5) {
        if (((i5 >>> 24) & 255) >= 1) {
            return i5;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // android.app.Dialog
    public final void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        x xVar = (x) b();
        xVar.x();
        ((ViewGroup) xVar.f6390C.findViewById(android.R.id.content)).addView(view, layoutParams);
        xVar.f6424o.a(xVar.n.getCallback());
    }

    public final n b() {
        if (this.f6344f == null) {
            M0.m mVar = n.f6350c;
            this.f6344f = new x(getContext(), getWindow(), this, this);
        }
        return this.f6344f;
    }

    public final C0251v c() {
        C0251v c0251v = this.f6341c;
        if (c0251v != null) {
            return c0251v;
        }
        C0251v c0251v2 = new C0251v(this);
        this.f6341c = c0251v2;
        return c0251v2;
    }

    public final void d(Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            OnBackInvokedDispatcher onBackInvokedDispatcher = getOnBackInvokedDispatcher();
            F3.i.e(onBackInvokedDispatcher, "onBackInvokedDispatcher");
            androidx.activity.u uVar = this.f6343e;
            uVar.getClass();
            uVar.f3282e = onBackInvokedDispatcher;
            uVar.c(uVar.g);
        }
        this.f6342d.b(bundle);
        c().e(EnumC0243m.ON_CREATE);
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public final void dismiss() {
        super.dismiss();
        b().f();
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        getWindow().getDecorView();
        y yVar = this.g;
        if (yVar == null) {
            return false;
        }
        return yVar.f6436c.i(keyEvent);
    }

    public final void e(Bundle bundle) {
        b().a();
        d(bundle);
        b().d();
    }

    public final void f() {
        c().e(EnumC0243m.ON_DESTROY);
        this.f6341c = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public final View findViewById(int i5) {
        x xVar = (x) b();
        xVar.x();
        return xVar.n.findViewById(i5);
    }

    @Override // androidx.lifecycle.InterfaceC0249t
    public final AbstractC0245o getLifecycle() {
        return c();
    }

    @Override // androidx.activity.v
    public final androidx.activity.u getOnBackPressedDispatcher() {
        return this.f6343e;
    }

    @Override // o0.e
    public final o0.c getSavedStateRegistry() {
        return this.f6342d.f8893b;
    }

    public final void h(CharSequence charSequence) {
        super.setTitle(charSequence);
        b().m(charSequence);
    }

    public final boolean i(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.app.Dialog
    public final void invalidateOptionsMenu() {
        b().b();
    }

    @Override // android.app.Dialog
    public final void onBackPressed() {
        this.f6343e.b();
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle bundle) {
        int i5;
        View view;
        int i6;
        ListAdapter listAdapter;
        View viewFindViewById;
        e(bundle);
        C0468e c0468e = this.h;
        c0468e.f6319b.setContentView(c0468e.f6312F);
        Window window = c0468e.f6320c;
        View viewFindViewById2 = window.findViewById(R.id.parentPanel);
        View viewFindViewById3 = viewFindViewById2.findViewById(R.id.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(R.id.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(R.id.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(R.id.customPanel);
        View viewInflate = c0468e.h;
        Context context = c0468e.f6318a;
        if (viewInflate == null) {
            viewInflate = c0468e.f6324i != 0 ? LayoutInflater.from(context).inflate(c0468e.f6324i, viewGroup, false) : null;
        }
        boolean z4 = viewInflate != null;
        if (!z4 || !C0468e.a(viewInflate)) {
            window.setFlags(131072, 131072);
        }
        if (z4) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(R.id.custom);
            frameLayout.addView(viewInflate, new ViewGroup.LayoutParams(-1, -1));
            if (c0468e.f6325j) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (c0468e.g != null) {
                ((LinearLayout.LayoutParams) ((C0655s0) viewGroup.getLayoutParams())).weight = BitmapDescriptorFactory.HUE_RED;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(R.id.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(R.id.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(R.id.buttonPanel);
        ViewGroup viewGroupB = C0468e.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = C0468e.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = C0468e.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(R.id.scrollView);
        c0468e.f6337w = nestedScrollView;
        nestedScrollView.setFocusable(false);
        c0468e.f6337w.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(android.R.id.message);
        c0468e.f6308B = textView;
        if (textView != null) {
            CharSequence charSequence = c0468e.f6323f;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                c0468e.f6337w.removeView(c0468e.f6308B);
                if (c0468e.g != null) {
                    ViewGroup viewGroup2 = (ViewGroup) c0468e.f6337w.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(c0468e.f6337w);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(c0468e.g, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(android.R.id.button1);
        c0468e.f6326k = button;
        com.google.android.material.datepicker.j jVar = c0468e.f6317L;
        button.setOnClickListener(jVar);
        boolean zIsEmpty = TextUtils.isEmpty(c0468e.f6327l);
        int i7 = c0468e.f6321d;
        if (zIsEmpty && c0468e.n == null) {
            c0468e.f6326k.setVisibility(8);
            i5 = 0;
        } else {
            c0468e.f6326k.setText(c0468e.f6327l);
            Drawable drawable = c0468e.n;
            if (drawable != null) {
                drawable.setBounds(0, 0, i7, i7);
                c0468e.f6326k.setCompoundDrawables(c0468e.n, null, null, null);
            }
            c0468e.f6326k.setVisibility(0);
            i5 = 1;
        }
        Button button2 = (Button) viewGroupB3.findViewById(android.R.id.button2);
        c0468e.f6329o = button2;
        button2.setOnClickListener(jVar);
        if (TextUtils.isEmpty(c0468e.f6330p) && c0468e.f6332r == null) {
            c0468e.f6329o.setVisibility(8);
        } else {
            c0468e.f6329o.setText(c0468e.f6330p);
            Drawable drawable2 = c0468e.f6332r;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, i7, i7);
                c0468e.f6329o.setCompoundDrawables(c0468e.f6332r, null, null, null);
            }
            c0468e.f6329o.setVisibility(0);
            i5 |= 2;
        }
        Button button3 = (Button) viewGroupB3.findViewById(android.R.id.button3);
        c0468e.f6333s = button3;
        button3.setOnClickListener(jVar);
        if (TextUtils.isEmpty(c0468e.f6334t) && c0468e.f6336v == null) {
            c0468e.f6333s.setVisibility(8);
            view = null;
        } else {
            c0468e.f6333s.setText(c0468e.f6334t);
            Drawable drawable3 = c0468e.f6336v;
            if (drawable3 != null) {
                drawable3.setBounds(0, 0, i7, i7);
                view = null;
                c0468e.f6333s.setCompoundDrawables(c0468e.f6336v, null, null, null);
            } else {
                view = null;
            }
            c0468e.f6333s.setVisibility(0);
            i5 |= 4;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(R.attr.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data == 0) {
            i6 = 2;
        } else if (i5 == 1) {
            Button button4 = c0468e.f6326k;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
            layoutParams.gravity = 1;
            layoutParams.weight = 0.5f;
            button4.setLayoutParams(layoutParams);
            i6 = 2;
        } else {
            i6 = 2;
            if (i5 == 2) {
                Button button5 = c0468e.f6329o;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i5 == 4) {
                Button button6 = c0468e.f6333s;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i5 == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (c0468e.f6309C != null) {
            viewGroupB.addView(c0468e.f6309C, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(R.id.title_template).setVisibility(8);
        } else {
            c0468e.f6340z = (ImageView) window.findViewById(android.R.id.icon);
            if ((!TextUtils.isEmpty(c0468e.f6322e)) && c0468e.f6315J) {
                TextView textView2 = (TextView) window.findViewById(R.id.alertTitle);
                c0468e.f6307A = textView2;
                textView2.setText(c0468e.f6322e);
                int i8 = c0468e.f6338x;
                if (i8 != 0) {
                    c0468e.f6340z.setImageResource(i8);
                } else {
                    Drawable drawable4 = c0468e.f6339y;
                    if (drawable4 != null) {
                        c0468e.f6340z.setImageDrawable(drawable4);
                    } else {
                        c0468e.f6307A.setPadding(c0468e.f6340z.getPaddingLeft(), c0468e.f6340z.getPaddingTop(), c0468e.f6340z.getPaddingRight(), c0468e.f6340z.getPaddingBottom());
                        c0468e.f6340z.setVisibility(8);
                    }
                }
            } else {
                window.findViewById(R.id.title_template).setVisibility(8);
                c0468e.f6340z.setVisibility(8);
                viewGroupB.setVisibility(8);
            }
        }
        boolean z5 = viewGroup.getVisibility() != 8;
        int i9 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z6 = viewGroupB3.getVisibility() != 8;
        if (!z6 && (viewFindViewById = viewGroupB2.findViewById(R.id.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i9 != 0) {
            NestedScrollView nestedScrollView2 = c0468e.f6337w;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (c0468e.f6323f == null && c0468e.g == null) ? view : viewGroupB.findViewById(R.id.titleDividerNoCustom);
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            View viewFindViewById10 = viewGroupB2.findViewById(R.id.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = c0468e.g;
        if (alertController$RecycleListView instanceof AlertController$RecycleListView) {
            alertController$RecycleListView.getClass();
            if (!z6 || i9 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i9 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.f3284c, alertController$RecycleListView.getPaddingRight(), z6 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.f3285d);
            }
        }
        if (!z5) {
            View view2 = c0468e.g;
            if (view2 == null) {
                view2 = c0468e.f6337w;
            }
            if (view2 != null) {
                int i10 = i9 | (z6 ? i6 : 0);
                View viewFindViewById11 = window.findViewById(R.id.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(R.id.scrollIndicatorDown);
                WeakHashMap weakHashMap = Y.f1904a;
                N.d(view2, i10, 3);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = c0468e.g;
        if (alertController$RecycleListView2 == null || (listAdapter = c0468e.f6310D) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i11 = c0468e.f6311E;
        if (i11 > -1) {
            alertController$RecycleListView2.setItemChecked(i11, true);
            alertController$RecycleListView2.setSelection(i11);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.h.f6337w;
        if (nestedScrollView == null || !nestedScrollView.j(keyEvent)) {
            return super.onKeyDown(i5, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i5, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.h.f6337w;
        if (nestedScrollView == null || !nestedScrollView.j(keyEvent)) {
            return super.onKeyUp(i5, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog
    public final Bundle onSaveInstanceState() {
        Bundle bundleOnSaveInstanceState = super.onSaveInstanceState();
        F3.i.e(bundleOnSaveInstanceState, "super.onSaveInstanceState()");
        this.f6342d.c(bundleOnSaveInstanceState);
        return bundleOnSaveInstanceState;
    }

    @Override // android.app.Dialog
    public final void onStart() {
        super.onStart();
        c().e(EnumC0243m.ON_RESUME);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        f();
        x xVar = (x) b();
        xVar.B();
        AbstractC0464a abstractC0464a = xVar.f6426q;
        if (abstractC0464a != null) {
            abstractC0464a.o(false);
        }
    }

    @Override // f.j
    public final void onSupportActionModeFinished(i.b bVar) {
    }

    @Override // f.j
    public final void onSupportActionModeStarted(i.b bVar) {
    }

    @Override // f.j
    public final i.b onWindowStartingSupportActionMode(i.a aVar) {
        return null;
    }

    @Override // android.app.Dialog
    public final void setContentView(int i5) {
        b().j(i5);
    }

    @Override // android.app.Dialog
    public final void setTitle(int i5) {
        super.setTitle(i5);
        b().m(getContext().getString(i5));
    }

    @Override // android.app.Dialog
    public final void setContentView(View view) {
        b().k(view);
    }

    @Override // android.app.Dialog
    public final void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        b().l(view, layoutParams);
    }

    @Override // android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        h(charSequence);
        C0468e c0468e = this.h;
        c0468e.f6322e = charSequence;
        TextView textView = c0468e.f6307A;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }
}
