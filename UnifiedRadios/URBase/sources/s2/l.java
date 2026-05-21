package s2;

import O.AbstractC0173l;
import O.G;
import O.H;
import O.J;
import O.Y;
import a.AbstractC0203a;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.material.internal.CheckableImageButton;
import com.google.android.material.textfield.TextInputLayout;
import com.unified.ur1.R;
import j.ViewOnAttachStateChangeListenerC0586e;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;
import k.Z;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class l extends LinearLayout {

    /* renamed from: c, reason: collision with root package name */
    public final TextInputLayout f9610c;

    /* renamed from: d, reason: collision with root package name */
    public final FrameLayout f9611d;

    /* renamed from: e, reason: collision with root package name */
    public final CheckableImageButton f9612e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f9613f;
    public PorterDuff.Mode g;
    public View.OnLongClickListener h;

    /* renamed from: i, reason: collision with root package name */
    public final CheckableImageButton f9614i;

    /* renamed from: j, reason: collision with root package name */
    public final k f9615j;

    /* renamed from: k, reason: collision with root package name */
    public int f9616k;

    /* renamed from: l, reason: collision with root package name */
    public final LinkedHashSet f9617l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f9618m;
    public PorterDuff.Mode n;

    /* renamed from: o, reason: collision with root package name */
    public int f9619o;

    /* renamed from: p, reason: collision with root package name */
    public ImageView.ScaleType f9620p;

    /* renamed from: q, reason: collision with root package name */
    public View.OnLongClickListener f9621q;

    /* renamed from: r, reason: collision with root package name */
    public CharSequence f9622r;

    /* renamed from: s, reason: collision with root package name */
    public final Z f9623s;

    /* renamed from: t, reason: collision with root package name */
    public boolean f9624t;

    /* renamed from: u, reason: collision with root package name */
    public EditText f9625u;

    /* renamed from: v, reason: collision with root package name */
    public final AccessibilityManager f9626v;

    /* renamed from: w, reason: collision with root package name */
    public P.d f9627w;

    /* renamed from: x, reason: collision with root package name */
    public final i f9628x;

    public l(TextInputLayout textInputLayout, L0.m mVar) {
        CharSequence text;
        super(textInputLayout.getContext());
        this.f9616k = 0;
        this.f9617l = new LinkedHashSet();
        this.f9628x = new i(this);
        j jVar = new j(this);
        this.f9626v = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.f9610c = textInputLayout;
        setVisibility(8);
        setOrientation(0);
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1, 8388613));
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f9611d = frameLayout;
        frameLayout.setVisibility(8);
        frameLayout.setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        CheckableImageButton checkableImageButtonA = a(this, layoutInflaterFrom, R.id.text_input_error_icon);
        this.f9612e = checkableImageButtonA;
        CheckableImageButton checkableImageButtonA2 = a(frameLayout, layoutInflaterFrom, R.id.text_input_end_icon);
        this.f9614i = checkableImageButtonA2;
        this.f9615j = new k(this, mVar);
        Z z4 = new Z(getContext(), null);
        this.f9623s = z4;
        TypedArray typedArray = (TypedArray) mVar.f1557e;
        if (typedArray.hasValue(38)) {
            this.f9613f = AbstractC0409x1.e(getContext(), mVar, 38);
        }
        if (typedArray.hasValue(39)) {
            this.g = g2.m.k(typedArray.getInt(39, -1), null);
        }
        if (typedArray.hasValue(37)) {
            i(mVar.g(37));
        }
        checkableImageButtonA.setContentDescription(getResources().getText(R.string.error_icon_content_description));
        WeakHashMap weakHashMap = Y.f1904a;
        G.s(checkableImageButtonA, 2);
        checkableImageButtonA.setClickable(false);
        checkableImageButtonA.setPressable(false);
        checkableImageButtonA.setFocusable(false);
        if (!typedArray.hasValue(53)) {
            if (typedArray.hasValue(32)) {
                this.f9618m = AbstractC0409x1.e(getContext(), mVar, 32);
            }
            if (typedArray.hasValue(33)) {
                this.n = g2.m.k(typedArray.getInt(33, -1), null);
            }
        }
        if (typedArray.hasValue(30)) {
            g(typedArray.getInt(30, 0));
            if (typedArray.hasValue(27) && checkableImageButtonA2.getContentDescription() != (text = typedArray.getText(27))) {
                checkableImageButtonA2.setContentDescription(text);
            }
            checkableImageButtonA2.setCheckable(typedArray.getBoolean(26, true));
        } else if (typedArray.hasValue(53)) {
            if (typedArray.hasValue(54)) {
                this.f9618m = AbstractC0409x1.e(getContext(), mVar, 54);
            }
            if (typedArray.hasValue(55)) {
                this.n = g2.m.k(typedArray.getInt(55, -1), null);
            }
            g(typedArray.getBoolean(53, false) ? 1 : 0);
            CharSequence text2 = typedArray.getText(51);
            if (checkableImageButtonA2.getContentDescription() != text2) {
                checkableImageButtonA2.setContentDescription(text2);
            }
        }
        int dimensionPixelSize = typedArray.getDimensionPixelSize(29, getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size));
        if (dimensionPixelSize < 0) {
            throw new IllegalArgumentException("endIconSize cannot be less than 0");
        }
        if (dimensionPixelSize != this.f9619o) {
            this.f9619o = dimensionPixelSize;
            checkableImageButtonA2.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA2.setMinimumHeight(dimensionPixelSize);
            checkableImageButtonA.setMinimumWidth(dimensionPixelSize);
            checkableImageButtonA.setMinimumHeight(dimensionPixelSize);
        }
        if (typedArray.hasValue(31)) {
            ImageView.ScaleType scaleTypeD = AbstractC0203a.d(typedArray.getInt(31, -1));
            this.f9620p = scaleTypeD;
            checkableImageButtonA2.setScaleType(scaleTypeD);
            checkableImageButtonA.setScaleType(scaleTypeD);
        }
        z4.setVisibility(8);
        z4.setId(R.id.textinput_suffix_text);
        z4.setLayoutParams(new LinearLayout.LayoutParams(-2, -2, 80.0f));
        J.f(z4, 1);
        z4.setTextAppearance(typedArray.getResourceId(72, 0));
        if (typedArray.hasValue(73)) {
            z4.setTextColor(mVar.f(73));
        }
        CharSequence text3 = typedArray.getText(71);
        this.f9622r = TextUtils.isEmpty(text3) ? null : text3;
        z4.setText(text3);
        n();
        frameLayout.addView(checkableImageButtonA2);
        addView(z4);
        addView(frameLayout);
        addView(checkableImageButtonA);
        textInputLayout.f5449g0.add(jVar);
        if (textInputLayout.f5447f != null) {
            jVar.a(textInputLayout);
        }
        addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0586e(2, this));
    }

    public final CheckableImageButton a(ViewGroup viewGroup, LayoutInflater layoutInflater, int i5) {
        CheckableImageButton checkableImageButton = (CheckableImageButton) layoutInflater.inflate(R.layout.design_text_input_end_icon, viewGroup, false);
        checkableImageButton.setId(i5);
        if (AbstractC0409x1.j(getContext())) {
            AbstractC0173l.h((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams(), 0);
        }
        return checkableImageButton;
    }

    public final m b() {
        m dVar;
        int i5 = this.f9616k;
        k kVar = this.f9615j;
        SparseArray sparseArray = kVar.f9606a;
        m sVar = (m) sparseArray.get(i5);
        if (sVar == null) {
            l lVar = kVar.f9607b;
            if (i5 == -1) {
                dVar = new d(lVar, 0);
            } else if (i5 == 0) {
                dVar = new d(lVar, 1);
            } else if (i5 == 1) {
                sVar = new s(lVar, kVar.f9609d);
                sparseArray.append(i5, sVar);
            } else if (i5 == 2) {
                dVar = new C0890c(lVar);
            } else {
                if (i5 != 3) {
                    throw new IllegalArgumentException(com.unified.ur1.SatelliteTracker.h.a(i5, "Invalid end icon mode: "));
                }
                dVar = new h(lVar);
            }
            sVar = dVar;
            sparseArray.append(i5, sVar);
        }
        return sVar;
    }

    public final int c() {
        int iC;
        if (d() || e()) {
            CheckableImageButton checkableImageButton = this.f9614i;
            iC = AbstractC0173l.c((ViewGroup.MarginLayoutParams) checkableImageButton.getLayoutParams()) + checkableImageButton.getMeasuredWidth();
        } else {
            iC = 0;
        }
        WeakHashMap weakHashMap = Y.f1904a;
        return H.e(this.f9623s) + H.e(this) + iC;
    }

    public final boolean d() {
        return this.f9611d.getVisibility() == 0 && this.f9614i.getVisibility() == 0;
    }

    public final boolean e() {
        return this.f9612e.getVisibility() == 0;
    }

    public final void f(boolean z4) {
        boolean z5;
        boolean zIsActivated;
        boolean z6;
        m mVarB = b();
        boolean zK = mVarB.k();
        CheckableImageButton checkableImageButton = this.f9614i;
        boolean z7 = true;
        if (!zK || (z6 = checkableImageButton.f5375f) == mVarB.l()) {
            z5 = false;
        } else {
            checkableImageButton.setChecked(!z6);
            z5 = true;
        }
        if (!(mVarB instanceof h) || (zIsActivated = checkableImageButton.isActivated()) == mVarB.j()) {
            z7 = z5;
        } else {
            checkableImageButton.setActivated(!zIsActivated);
        }
        if (z4 || z7) {
            AbstractC0203a.l(this.f9610c, checkableImageButton, this.f9618m);
        }
    }

    public final void g(int i5) {
        if (this.f9616k == i5) {
            return;
        }
        m mVarB = b();
        P.d dVar = this.f9627w;
        AccessibilityManager accessibilityManager = this.f9626v;
        if (dVar != null && accessibilityManager != null) {
            P.c.b(accessibilityManager, dVar);
        }
        this.f9627w = null;
        mVarB.s();
        this.f9616k = i5;
        Iterator it = this.f9617l.iterator();
        if (it.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            throw null;
        }
        h(i5 != 0);
        m mVarB2 = b();
        int iD = this.f9615j.f9608c;
        if (iD == 0) {
            iD = mVarB2.d();
        }
        Drawable drawableK = iD != 0 ? AbstractC0930a.k(getContext(), iD) : null;
        CheckableImageButton checkableImageButton = this.f9614i;
        checkableImageButton.setImageDrawable(drawableK);
        TextInputLayout textInputLayout = this.f9610c;
        if (drawableK != null) {
            AbstractC0203a.a(textInputLayout, checkableImageButton, this.f9618m, this.n);
            AbstractC0203a.l(textInputLayout, checkableImageButton, this.f9618m);
        }
        int iC = mVarB2.c();
        CharSequence text = iC != 0 ? getResources().getText(iC) : null;
        if (checkableImageButton.getContentDescription() != text) {
            checkableImageButton.setContentDescription(text);
        }
        checkableImageButton.setCheckable(mVarB2.k());
        if (!mVarB2.i(textInputLayout.getBoxBackgroundMode())) {
            throw new IllegalStateException("The current box background mode " + textInputLayout.getBoxBackgroundMode() + " is not supported by the end icon mode " + i5);
        }
        mVarB2.r();
        P.d dVarH = mVarB2.h();
        this.f9627w = dVarH;
        if (dVarH != null && accessibilityManager != null) {
            WeakHashMap weakHashMap = Y.f1904a;
            if (J.b(this)) {
                P.c.a(accessibilityManager, this.f9627w);
            }
        }
        View.OnClickListener onClickListenerF = mVarB2.f();
        View.OnLongClickListener onLongClickListener = this.f9621q;
        checkableImageButton.setOnClickListener(onClickListenerF);
        AbstractC0203a.m(checkableImageButton, onLongClickListener);
        EditText editText = this.f9625u;
        if (editText != null) {
            mVarB2.m(editText);
            j(mVarB2);
        }
        AbstractC0203a.a(textInputLayout, checkableImageButton, this.f9618m, this.n);
        f(true);
    }

    public final void h(boolean z4) {
        if (d() != z4) {
            this.f9614i.setVisibility(z4 ? 0 : 8);
            k();
            m();
            this.f9610c.q();
        }
    }

    public final void i(Drawable drawable) {
        CheckableImageButton checkableImageButton = this.f9612e;
        checkableImageButton.setImageDrawable(drawable);
        l();
        AbstractC0203a.a(this.f9610c, checkableImageButton, this.f9613f, this.g);
    }

    public final void j(m mVar) {
        if (this.f9625u == null) {
            return;
        }
        if (mVar.e() != null) {
            this.f9625u.setOnFocusChangeListener(mVar.e());
        }
        if (mVar.g() != null) {
            this.f9614i.setOnFocusChangeListener(mVar.g());
        }
    }

    public final void k() {
        this.f9611d.setVisibility((this.f9614i.getVisibility() != 0 || e()) ? 8 : 0);
        setVisibility((d() || e() || !((this.f9622r == null || this.f9624t) ? 8 : false)) ? 0 : 8);
    }

    public final void l() {
        CheckableImageButton checkableImageButton = this.f9612e;
        Drawable drawable = checkableImageButton.getDrawable();
        TextInputLayout textInputLayout = this.f9610c;
        checkableImageButton.setVisibility((drawable != null && textInputLayout.f5457l.f9654q && textInputLayout.m()) ? 0 : 8);
        k();
        m();
        if (this.f9616k != 0) {
            return;
        }
        textInputLayout.q();
    }

    public final void m() {
        int iE;
        TextInputLayout textInputLayout = this.f9610c;
        if (textInputLayout.f5447f == null) {
            return;
        }
        if (d() || e()) {
            iE = 0;
        } else {
            EditText editText = textInputLayout.f5447f;
            WeakHashMap weakHashMap = Y.f1904a;
            iE = H.e(editText);
        }
        int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding);
        int paddingTop = textInputLayout.f5447f.getPaddingTop();
        int paddingBottom = textInputLayout.f5447f.getPaddingBottom();
        WeakHashMap weakHashMap2 = Y.f1904a;
        H.k(this.f9623s, dimensionPixelSize, paddingTop, iE, paddingBottom);
    }

    public final void n() {
        Z z4 = this.f9623s;
        int visibility = z4.getVisibility();
        int i5 = (this.f9622r == null || this.f9624t) ? 8 : 0;
        if (visibility != i5) {
            b().p(i5 == 0);
        }
        k();
        z4.setVisibility(i5);
        this.f9610c.q();
    }
}
