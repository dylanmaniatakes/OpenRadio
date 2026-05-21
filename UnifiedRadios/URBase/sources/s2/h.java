package s2;

import O.C0163f0;
import O.G;
import O.Y;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.material.textfield.TextInputLayout;
import com.unified.ur1.R;
import i3.ViewOnFocusChangeListenerC0574c;
import java.util.WeakHashMap;
import o3.ViewOnTouchListenerC0815d;

/* loaded from: classes.dex */
public final class h extends m {

    /* renamed from: e, reason: collision with root package name */
    public final int f9593e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9594f;
    public final TimeInterpolator g;
    public AutoCompleteTextView h;

    /* renamed from: i, reason: collision with root package name */
    public final com.google.android.material.datepicker.l f9595i;

    /* renamed from: j, reason: collision with root package name */
    public final ViewOnFocusChangeListenerC0574c f9596j;

    /* renamed from: k, reason: collision with root package name */
    public final D0.p f9597k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f9598l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f9599m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public long f9600o;

    /* renamed from: p, reason: collision with root package name */
    public AccessibilityManager f9601p;

    /* renamed from: q, reason: collision with root package name */
    public ValueAnimator f9602q;

    /* renamed from: r, reason: collision with root package name */
    public ValueAnimator f9603r;

    public h(l lVar) {
        super(lVar);
        this.f9595i = new com.google.android.material.datepicker.l(10, this);
        this.f9596j = new ViewOnFocusChangeListenerC0574c(2, this);
        this.f9597k = new D0.p(20, this);
        this.f9600o = Long.MAX_VALUE;
        this.f9594f = A2.b.v(lVar.getContext(), R.attr.motionDurationShort3, 67);
        this.f9593e = A2.b.v(lVar.getContext(), R.attr.motionDurationShort3, 50);
        this.g = A2.b.w(lVar.getContext(), R.attr.motionEasingLinearInterpolator, P1.a.f2064a);
    }

    @Override // s2.m
    public final void a() {
        if (this.f9601p.isTouchExplorationEnabled() && Z3.i.g(this.h) && !this.f9632d.hasFocus()) {
            this.h.dismissDropDown();
        }
        this.h.post(new m3.o(7, this));
    }

    @Override // s2.m
    public final int c() {
        return R.string.exposed_dropdown_menu_content_description;
    }

    @Override // s2.m
    public final int d() {
        return R.drawable.mtrl_dropdown_arrow;
    }

    @Override // s2.m
    public final View.OnFocusChangeListener e() {
        return this.f9596j;
    }

    @Override // s2.m
    public final View.OnClickListener f() {
        return this.f9595i;
    }

    @Override // s2.m
    public final P.d h() {
        return this.f9597k;
    }

    @Override // s2.m
    public final boolean i(int i5) {
        return i5 != 0;
    }

    @Override // s2.m
    public final boolean j() {
        return this.f9598l;
    }

    @Override // s2.m
    public final boolean l() {
        return this.n;
    }

    @Override // s2.m
    public final void m(EditText editText) {
        int i5 = 1;
        if (!(editText instanceof AutoCompleteTextView)) {
            throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
        }
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) editText;
        this.h = autoCompleteTextView;
        autoCompleteTextView.setOnTouchListener(new ViewOnTouchListenerC0815d(i5, this));
        this.h.setOnDismissListener(new AutoCompleteTextView.OnDismissListener() { // from class: s2.g
            @Override // android.widget.AutoCompleteTextView.OnDismissListener
            public final void onDismiss() {
                h hVar = this.f9592a;
                hVar.f9599m = true;
                hVar.f9600o = System.currentTimeMillis();
                hVar.t(false);
            }
        });
        this.h.setThreshold(0);
        TextInputLayout textInputLayout = this.f9629a;
        textInputLayout.setErrorIconDrawable((Drawable) null);
        if (!Z3.i.g(editText) && this.f9601p.isTouchExplorationEnabled()) {
            WeakHashMap weakHashMap = Y.f1904a;
            G.s(this.f9632d, 2);
        }
        textInputLayout.setEndIconVisible(true);
    }

    @Override // s2.m
    public final void n(P.j jVar) {
        if (!Z3.i.g(this.h)) {
            jVar.f(Spinner.class.getName());
        }
        AccessibilityNodeInfo accessibilityNodeInfo = jVar.f2058a;
        if (accessibilityNodeInfo.isShowingHintText()) {
            accessibilityNodeInfo.setHintText(null);
        }
    }

    @Override // s2.m
    public final void o(AccessibilityEvent accessibilityEvent) {
        if (!this.f9601p.isEnabled() || Z3.i.g(this.h)) {
            return;
        }
        boolean z4 = accessibilityEvent.getEventType() == 32768 && this.n && !this.h.isPopupShowing();
        if (accessibilityEvent.getEventType() == 1 || z4) {
            u();
            this.f9599m = true;
            this.f9600o = System.currentTimeMillis();
        }
    }

    @Override // s2.m
    public final void r() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(BitmapDescriptorFactory.HUE_RED, 1.0f);
        TimeInterpolator timeInterpolator = this.g;
        valueAnimatorOfFloat.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat.setDuration(this.f9594f);
        valueAnimatorOfFloat.addUpdateListener(new C0163f0(2, this));
        this.f9603r = valueAnimatorOfFloat;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, BitmapDescriptorFactory.HUE_RED);
        valueAnimatorOfFloat2.setInterpolator(timeInterpolator);
        valueAnimatorOfFloat2.setDuration(this.f9593e);
        valueAnimatorOfFloat2.addUpdateListener(new C0163f0(2, this));
        this.f9602q = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.addListener(new S1.a(5, this));
        this.f9601p = (AccessibilityManager) this.f9631c.getSystemService("accessibility");
    }

    @Override // s2.m
    public final void s() {
        AutoCompleteTextView autoCompleteTextView = this.h;
        if (autoCompleteTextView != null) {
            autoCompleteTextView.setOnTouchListener(null);
            this.h.setOnDismissListener(null);
        }
    }

    public final void t(boolean z4) {
        if (this.n != z4) {
            this.n = z4;
            this.f9603r.cancel();
            this.f9602q.start();
        }
    }

    public final void u() {
        if (this.h == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f9600o;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis > 300) {
            this.f9599m = false;
        }
        if (this.f9599m) {
            this.f9599m = false;
            return;
        }
        t(!this.n);
        if (!this.n) {
            this.h.dismissDropDown();
        } else {
            this.h.requestFocus();
            this.h.showDropDown();
        }
    }
}
