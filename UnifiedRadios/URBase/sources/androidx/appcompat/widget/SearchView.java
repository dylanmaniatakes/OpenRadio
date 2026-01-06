package androidx.appcompat.widget;

import L0.m;
import O.G;
import O.Y;
import android.app.PendingIntent;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.AutoCompleteTextView;
import android.widget.ImageView;
import com.unified.ur1.R;
import e.AbstractC0429a;
import g3.f;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.WeakHashMap;
import k.C0617L;
import k.C0645n;
import k.C0657t0;
import k.K0;
import k.L0;
import k.M0;
import k.N0;
import k.O0;
import k.P0;
import k.Q0;
import k.R0;
import k.T0;
import k.g1;
import m3.C0777m;
import org.conscrypt.PSKKeyManager;

/* loaded from: classes.dex */
public class SearchView extends LinearLayoutCompat implements i.c {

    /* renamed from: i0, reason: collision with root package name */
    public static final C0777m f3398i0;

    /* renamed from: A, reason: collision with root package name */
    public R0 f3399A;

    /* renamed from: B, reason: collision with root package name */
    public final Rect f3400B;

    /* renamed from: C, reason: collision with root package name */
    public final Rect f3401C;

    /* renamed from: D, reason: collision with root package name */
    public final int[] f3402D;

    /* renamed from: E, reason: collision with root package name */
    public final int[] f3403E;

    /* renamed from: F, reason: collision with root package name */
    public final ImageView f3404F;

    /* renamed from: G, reason: collision with root package name */
    public final Drawable f3405G;

    /* renamed from: H, reason: collision with root package name */
    public final int f3406H;
    public final int I;

    /* renamed from: J, reason: collision with root package name */
    public final Intent f3407J;

    /* renamed from: K, reason: collision with root package name */
    public final Intent f3408K;

    /* renamed from: L, reason: collision with root package name */
    public final CharSequence f3409L;

    /* renamed from: M, reason: collision with root package name */
    public View.OnFocusChangeListener f3410M;

    /* renamed from: N, reason: collision with root package name */
    public View.OnClickListener f3411N;

    /* renamed from: O, reason: collision with root package name */
    public boolean f3412O;

    /* renamed from: P, reason: collision with root package name */
    public boolean f3413P;

    /* renamed from: Q, reason: collision with root package name */
    public T.c f3414Q;

    /* renamed from: R, reason: collision with root package name */
    public boolean f3415R;

    /* renamed from: S, reason: collision with root package name */
    public CharSequence f3416S;

    /* renamed from: T, reason: collision with root package name */
    public boolean f3417T;

    /* renamed from: U, reason: collision with root package name */
    public boolean f3418U;

    /* renamed from: V, reason: collision with root package name */
    public int f3419V;

    /* renamed from: W, reason: collision with root package name */
    public boolean f3420W;

    /* renamed from: a0, reason: collision with root package name */
    public CharSequence f3421a0;

    /* renamed from: b0, reason: collision with root package name */
    public boolean f3422b0;

    /* renamed from: c0, reason: collision with root package name */
    public int f3423c0;

    /* renamed from: d0, reason: collision with root package name */
    public SearchableInfo f3424d0;

    /* renamed from: e0, reason: collision with root package name */
    public Bundle f3425e0;

    /* renamed from: f0, reason: collision with root package name */
    public final K0 f3426f0;

    /* renamed from: g0, reason: collision with root package name */
    public final K0 f3427g0;

    /* renamed from: h0, reason: collision with root package name */
    public final WeakHashMap f3428h0;

    /* renamed from: r, reason: collision with root package name */
    public final SearchAutoComplete f3429r;

    /* renamed from: s, reason: collision with root package name */
    public final View f3430s;

    /* renamed from: t, reason: collision with root package name */
    public final View f3431t;

    /* renamed from: u, reason: collision with root package name */
    public final View f3432u;

    /* renamed from: v, reason: collision with root package name */
    public final ImageView f3433v;

    /* renamed from: w, reason: collision with root package name */
    public final ImageView f3434w;

    /* renamed from: x, reason: collision with root package name */
    public final ImageView f3435x;

    /* renamed from: y, reason: collision with root package name */
    public final ImageView f3436y;

    /* renamed from: z, reason: collision with root package name */
    public final View f3437z;

    public static class SearchAutoComplete extends C0645n {
        public int g;
        public SearchView h;

        /* renamed from: i, reason: collision with root package name */
        public boolean f3438i;

        /* renamed from: j, reason: collision with root package name */
        public final d f3439j;

        public SearchAutoComplete(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3439j = new d(this);
            this.g = getThreshold();
        }

        private int getSearchViewTextMinWidthDp() {
            Configuration configuration = getResources().getConfiguration();
            int i5 = configuration.screenWidthDp;
            int i6 = configuration.screenHeightDp;
            if (i5 >= 960 && i6 >= 720 && configuration.orientation == 2) {
                return PSKKeyManager.MAX_KEY_LENGTH_BYTES;
            }
            if (i5 < 600) {
                return (i5 < 640 || i6 < 480) ? 160 : 192;
            }
            return 192;
        }

        public final void a() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (Build.VERSION.SDK_INT >= 29) {
                c.b(this, 1);
                if (enoughToFilter()) {
                    showDropDown();
                    return;
                }
                return;
            }
            C0777m c0777m = SearchView.f3398i0;
            c0777m.getClass();
            C0777m.g();
            Method method = (Method) c0777m.f8622e;
            if (method != null) {
                try {
                    method.invoke(this, Boolean.TRUE);
                } catch (Exception unused) {
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final boolean enoughToFilter() {
            return this.g <= 0 || super.enoughToFilter();
        }

        @Override // k.C0645n, android.widget.TextView, android.view.View
        public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
            InputConnection inputConnectionOnCreateInputConnection = super.onCreateInputConnection(editorInfo);
            if (this.f3438i) {
                d dVar = this.f3439j;
                removeCallbacks(dVar);
                post(dVar);
            }
            return inputConnectionOnCreateInputConnection;
        }

        @Override // android.view.View
        public final void onFinishInflate() {
            super.onFinishInflate();
            setMinWidth((int) TypedValue.applyDimension(1, getSearchViewTextMinWidthDp(), getResources().getDisplayMetrics()));
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onFocusChanged(boolean z4, int i5, Rect rect) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onFocusChanged(z4, i5, rect);
            SearchView searchView = this.h;
            searchView.y(searchView.f3413P);
            searchView.post(searchView.f3426f0);
            if (searchView.f3429r.hasFocus()) {
                searchView.n();
            }
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final boolean onKeyPreIme(int i5, KeyEvent keyEvent) {
            if (i5 == 4) {
                if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                    KeyEvent.DispatcherState keyDispatcherState = getKeyDispatcherState();
                    if (keyDispatcherState != null) {
                        keyDispatcherState.startTracking(keyEvent, this);
                    }
                    return true;
                }
                if (keyEvent.getAction() == 1) {
                    KeyEvent.DispatcherState keyDispatcherState2 = getKeyDispatcherState();
                    if (keyDispatcherState2 != null) {
                        keyDispatcherState2.handleUpEvent(keyEvent);
                    }
                    if (keyEvent.isTracking() && !keyEvent.isCanceled()) {
                        this.h.clearFocus();
                        setImeVisibility(false);
                        return true;
                    }
                }
            }
            return super.onKeyPreIme(i5, keyEvent);
        }

        @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
        public final void onWindowFocusChanged(boolean z4) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            super.onWindowFocusChanged(z4);
            if (z4 && this.h.hasFocus() && getVisibility() == 0) {
                this.f3438i = true;
                Context context = getContext();
                C0777m c0777m = SearchView.f3398i0;
                if (context.getResources().getConfiguration().orientation == 2) {
                    a();
                }
            }
        }

        @Override // android.widget.AutoCompleteTextView
        public final void performCompletion() {
        }

        @Override // android.widget.AutoCompleteTextView
        public final void replaceText(CharSequence charSequence) {
        }

        public void setImeVisibility(boolean z4) {
            InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService("input_method");
            d dVar = this.f3439j;
            if (!z4) {
                this.f3438i = false;
                removeCallbacks(dVar);
                inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
            } else {
                if (!inputMethodManager.isActive(this)) {
                    this.f3438i = true;
                    return;
                }
                this.f3438i = false;
                removeCallbacks(dVar);
                inputMethodManager.showSoftInput(this, 0);
            }
        }

        public void setSearchView(SearchView searchView) {
            this.h = searchView;
        }

        @Override // android.widget.AutoCompleteTextView
        public void setThreshold(int i5) {
            super.setThreshold(i5);
            this.g = i5;
        }
    }

    static {
        C0777m c0777m = null;
        if (Build.VERSION.SDK_INT < 29) {
            C0777m c0777m2 = new C0777m();
            c0777m2.f8620c = null;
            c0777m2.f8621d = null;
            c0777m2.f8622e = null;
            C0777m.g();
            try {
                Method declaredMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", null);
                c0777m2.f8620c = declaredMethod;
                declaredMethod.setAccessible(true);
            } catch (NoSuchMethodException unused) {
            }
            try {
                Method declaredMethod2 = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", null);
                c0777m2.f8621d = declaredMethod2;
                declaredMethod2.setAccessible(true);
            } catch (NoSuchMethodException unused2) {
            }
            try {
                Method method = AutoCompleteTextView.class.getMethod("ensureImeVisible", Boolean.TYPE);
                c0777m2.f8622e = method;
                method.setAccessible(true);
            } catch (NoSuchMethodException unused3) {
            }
            c0777m = c0777m2;
        }
        f3398i0 = c0777m;
    }

    public SearchView(Context context) {
        this(context, null);
    }

    private int getPreferredHeight() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_height);
    }

    private int getPreferredWidth() {
        return getContext().getResources().getDimensionPixelSize(R.dimen.abc_search_view_preferred_width);
    }

    private void setQuery(CharSequence charSequence) {
        SearchAutoComplete searchAutoComplete = this.f3429r;
        searchAutoComplete.setText(charSequence);
        searchAutoComplete.setSelection(TextUtils.isEmpty(charSequence) ? 0 : charSequence.length());
    }

    @Override // i.c
    public final void b() {
        if (this.f3422b0) {
            return;
        }
        this.f3422b0 = true;
        SearchAutoComplete searchAutoComplete = this.f3429r;
        int imeOptions = searchAutoComplete.getImeOptions();
        this.f3423c0 = imeOptions;
        searchAutoComplete.setImeOptions(imeOptions | 33554432);
        searchAutoComplete.setText("");
        setIconified(false);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void clearFocus() {
        this.f3418U = true;
        super.clearFocus();
        SearchAutoComplete searchAutoComplete = this.f3429r;
        searchAutoComplete.clearFocus();
        searchAutoComplete.setImeVisibility(false);
        this.f3418U = false;
    }

    @Override // i.c
    public final void e() {
        SearchAutoComplete searchAutoComplete = this.f3429r;
        searchAutoComplete.setText("");
        searchAutoComplete.setSelection(searchAutoComplete.length());
        this.f3421a0 = "";
        clearFocus();
        y(true);
        searchAutoComplete.setImeOptions(this.f3423c0);
        this.f3422b0 = false;
    }

    public int getImeOptions() {
        return this.f3429r.getImeOptions();
    }

    public int getInputType() {
        return this.f3429r.getInputType();
    }

    public int getMaxWidth() {
        return this.f3419V;
    }

    public CharSequence getQuery() {
        return this.f3429r.getText();
    }

    public CharSequence getQueryHint() {
        CharSequence charSequence = this.f3416S;
        if (charSequence != null) {
            return charSequence;
        }
        SearchableInfo searchableInfo = this.f3424d0;
        return (searchableInfo == null || searchableInfo.getHintId() == 0) ? this.f3409L : getContext().getText(this.f3424d0.getHintId());
    }

    public int getSuggestionCommitIconResId() {
        return this.I;
    }

    public int getSuggestionRowLayout() {
        return this.f3406H;
    }

    public T.c getSuggestionsAdapter() {
        return this.f3414Q;
    }

    public final Intent l(String str, Uri uri, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.addFlags(268435456);
        if (uri != null) {
            intent.setData(uri);
        }
        intent.putExtra("user_query", this.f3421a0);
        if (str3 != null) {
            intent.putExtra("query", str3);
        }
        if (str2 != null) {
            intent.putExtra("intent_extra_data_key", str2);
        }
        Bundle bundle = this.f3425e0;
        if (bundle != null) {
            intent.putExtra("app_data", bundle);
        }
        intent.setComponent(this.f3424d0.getSearchActivity());
        return intent;
    }

    public final Intent m(Intent intent, SearchableInfo searchableInfo) {
        ComponentName searchActivity = searchableInfo.getSearchActivity();
        Intent intent2 = new Intent("android.intent.action.SEARCH");
        intent2.setComponent(searchActivity);
        PendingIntent activity = PendingIntent.getActivity(getContext(), 0, intent2, 1107296256);
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.f3425e0;
        if (bundle2 != null) {
            bundle.putParcelable("app_data", bundle2);
        }
        Intent intent3 = new Intent(intent);
        Resources resources = getResources();
        String string = searchableInfo.getVoiceLanguageModeId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageModeId()) : "free_form";
        String string2 = searchableInfo.getVoicePromptTextId() != 0 ? resources.getString(searchableInfo.getVoicePromptTextId()) : null;
        String string3 = searchableInfo.getVoiceLanguageId() != 0 ? resources.getString(searchableInfo.getVoiceLanguageId()) : null;
        int voiceMaxResults = searchableInfo.getVoiceMaxResults() != 0 ? searchableInfo.getVoiceMaxResults() : 1;
        intent3.putExtra("android.speech.extra.LANGUAGE_MODEL", string);
        intent3.putExtra("android.speech.extra.PROMPT", string2);
        intent3.putExtra("android.speech.extra.LANGUAGE", string3);
        intent3.putExtra("android.speech.extra.MAX_RESULTS", voiceMaxResults);
        intent3.putExtra("calling_package", searchActivity != null ? searchActivity.flattenToShortString() : null);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT", activity);
        intent3.putExtra("android.speech.extra.RESULTS_PENDINGINTENT_BUNDLE", bundle);
        return intent3;
    }

    public final void n() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i5 = Build.VERSION.SDK_INT;
        SearchAutoComplete searchAutoComplete = this.f3429r;
        if (i5 >= 29) {
            c.a(searchAutoComplete);
            return;
        }
        C0777m c0777m = f3398i0;
        c0777m.getClass();
        C0777m.g();
        Method method = (Method) c0777m.f8620c;
        if (method != null) {
            try {
                method.invoke(searchAutoComplete, null);
            } catch (Exception unused) {
            }
        }
        c0777m.getClass();
        C0777m.g();
        Method method2 = (Method) c0777m.f8621d;
        if (method2 != null) {
            try {
                method2.invoke(searchAutoComplete, null);
            } catch (Exception unused2) {
            }
        }
    }

    public final void o() {
        SearchAutoComplete searchAutoComplete = this.f3429r;
        if (!TextUtils.isEmpty(searchAutoComplete.getText())) {
            searchAutoComplete.setText("");
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
        } else if (this.f3412O) {
            clearFocus();
            y(true);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        removeCallbacks(this.f3426f0);
        post(this.f3427g0);
        super.onDetachedFromWindow();
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        if (z4) {
            int[] iArr = this.f3402D;
            SearchAutoComplete searchAutoComplete = this.f3429r;
            searchAutoComplete.getLocationInWindow(iArr);
            int[] iArr2 = this.f3403E;
            getLocationInWindow(iArr2);
            int i9 = iArr[1] - iArr2[1];
            int i10 = iArr[0] - iArr2[0];
            int width = searchAutoComplete.getWidth() + i10;
            int height = searchAutoComplete.getHeight() + i9;
            Rect rect = this.f3400B;
            rect.set(i10, i9, width, height);
            int i11 = rect.left;
            int i12 = rect.right;
            int i13 = i8 - i6;
            Rect rect2 = this.f3401C;
            rect2.set(i11, 0, i12, i13);
            R0 r02 = this.f3399A;
            if (r02 == null) {
                R0 r03 = new R0(rect2, rect, searchAutoComplete);
                this.f3399A = r03;
                setTouchDelegate(r03);
            } else {
                r02.f7688b.set(rect2);
                Rect rect3 = r02.f7690d;
                rect3.set(rect2);
                int i14 = -r02.f7691e;
                rect3.inset(i14, i14);
                r02.f7689c.set(rect);
            }
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public final void onMeasure(int i5, int i6) {
        int i7;
        if (this.f3413P) {
            super.onMeasure(i5, i6);
            return;
        }
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        if (mode == Integer.MIN_VALUE) {
            int i8 = this.f3419V;
            size = i8 > 0 ? Math.min(i8, size) : Math.min(getPreferredWidth(), size);
        } else if (mode == 0) {
            size = this.f3419V;
            if (size <= 0) {
                size = getPreferredWidth();
            }
        } else if (mode == 1073741824 && (i7 = this.f3419V) > 0) {
            size = Math.min(i7, size);
        }
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(getPreferredHeight(), size2);
        } else if (mode2 == 0) {
            size2 = getPreferredHeight();
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Q0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Q0 q02 = (Q0) parcelable;
        super.onRestoreInstanceState(q02.f2507j);
        y(q02.f7686l);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Q0 q02 = new Q0(super.onSaveInstanceState());
        q02.f7686l = this.f3413P;
        return q02;
    }

    @Override // android.view.View
    public final void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        post(this.f3426f0);
    }

    public final void p(int i5) {
        int position;
        String strH;
        Cursor cursor = this.f3414Q.f2435e;
        if (cursor != null && cursor.moveToPosition(i5)) {
            Intent intentL = null;
            try {
                int i6 = T0.f7701z;
                String strH2 = T0.h(cursor, cursor.getColumnIndex("suggest_intent_action"));
                if (strH2 == null) {
                    strH2 = this.f3424d0.getSuggestIntentAction();
                }
                if (strH2 == null) {
                    strH2 = "android.intent.action.SEARCH";
                }
                String strH3 = T0.h(cursor, cursor.getColumnIndex("suggest_intent_data"));
                if (strH3 == null) {
                    strH3 = this.f3424d0.getSuggestIntentData();
                }
                if (strH3 != null && (strH = T0.h(cursor, cursor.getColumnIndex("suggest_intent_data_id"))) != null) {
                    strH3 = strH3 + "/" + Uri.encode(strH);
                }
                intentL = l(strH2, strH3 == null ? null : Uri.parse(strH3), T0.h(cursor, cursor.getColumnIndex("suggest_intent_extra_data")), T0.h(cursor, cursor.getColumnIndex("suggest_intent_query")));
            } catch (RuntimeException e5) {
                try {
                    position = cursor.getPosition();
                } catch (RuntimeException unused) {
                    position = -1;
                }
                Log.w("SearchView", "Search suggestions cursor at row " + position + " returned exception.", e5);
            }
            if (intentL != null) {
                try {
                    getContext().startActivity(intentL);
                } catch (RuntimeException e6) {
                    Log.e("SearchView", "Failed launch activity: " + intentL, e6);
                }
            }
        }
        SearchAutoComplete searchAutoComplete = this.f3429r;
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public final void q(int i5) {
        Editable text = this.f3429r.getText();
        Cursor cursor = this.f3414Q.f2435e;
        if (cursor == null) {
            return;
        }
        if (!cursor.moveToPosition(i5)) {
            setQuery(text);
            return;
        }
        String strC = this.f3414Q.c(cursor);
        if (strC != null) {
            setQuery(strC);
        } else {
            setQuery(text);
        }
    }

    public final void r(CharSequence charSequence) {
        setQuery(charSequence);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean requestFocus(int i5, Rect rect) {
        if (this.f3418U || !isFocusable()) {
            return false;
        }
        if (this.f3413P) {
            return super.requestFocus(i5, rect);
        }
        boolean zRequestFocus = this.f3429r.requestFocus(i5, rect);
        if (zRequestFocus) {
            y(false);
        }
        return zRequestFocus;
    }

    public final void s() {
        SearchAutoComplete searchAutoComplete = this.f3429r;
        Editable text = searchAutoComplete.getText();
        if (text == null || TextUtils.getTrimmedLength(text) <= 0) {
            return;
        }
        if (this.f3424d0 != null) {
            getContext().startActivity(l("android.intent.action.SEARCH", null, null, text.toString()));
        }
        searchAutoComplete.setImeVisibility(false);
        searchAutoComplete.dismissDropDown();
    }

    public void setAppSearchData(Bundle bundle) {
        this.f3425e0 = bundle;
    }

    public void setIconified(boolean z4) {
        if (z4) {
            o();
            return;
        }
        y(false);
        SearchAutoComplete searchAutoComplete = this.f3429r;
        searchAutoComplete.requestFocus();
        searchAutoComplete.setImeVisibility(true);
        View.OnClickListener onClickListener = this.f3411N;
        if (onClickListener != null) {
            onClickListener.onClick(this);
        }
    }

    public void setIconifiedByDefault(boolean z4) {
        if (this.f3412O == z4) {
            return;
        }
        this.f3412O = z4;
        y(z4);
        v();
    }

    public void setImeOptions(int i5) {
        this.f3429r.setImeOptions(i5);
    }

    public void setInputType(int i5) {
        this.f3429r.setInputType(i5);
    }

    public void setMaxWidth(int i5) {
        this.f3419V = i5;
        requestLayout();
    }

    public void setOnCloseListener(N0 n02) {
    }

    public void setOnQueryTextFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener) {
        this.f3410M = onFocusChangeListener;
    }

    public void setOnQueryTextListener(O0 o02) {
    }

    public void setOnSearchClickListener(View.OnClickListener onClickListener) {
        this.f3411N = onClickListener;
    }

    public void setOnSuggestionListener(P0 p02) {
    }

    public void setQueryHint(CharSequence charSequence) {
        this.f3416S = charSequence;
        v();
    }

    public void setQueryRefinementEnabled(boolean z4) {
        this.f3417T = z4;
        T.c cVar = this.f3414Q;
        if (cVar instanceof T0) {
            ((T0) cVar).f7709r = z4 ? 2 : 1;
        }
    }

    public void setSearchableInfo(SearchableInfo searchableInfo) {
        this.f3424d0 = searchableInfo;
        Intent intent = null;
        SearchAutoComplete searchAutoComplete = this.f3429r;
        if (searchableInfo != null) {
            searchAutoComplete.setThreshold(searchableInfo.getSuggestThreshold());
            searchAutoComplete.setImeOptions(this.f3424d0.getImeOptions());
            int inputType = this.f3424d0.getInputType();
            if ((inputType & 15) == 1) {
                inputType &= -65537;
                if (this.f3424d0.getSuggestAuthority() != null) {
                    inputType |= 589824;
                }
            }
            searchAutoComplete.setInputType(inputType);
            T.c cVar = this.f3414Q;
            if (cVar != null) {
                cVar.b(null);
            }
            if (this.f3424d0.getSuggestAuthority() != null) {
                T0 t02 = new T0(getContext(), this, this.f3424d0, this.f3428h0);
                this.f3414Q = t02;
                searchAutoComplete.setAdapter(t02);
                ((T0) this.f3414Q).f7709r = this.f3417T ? 2 : 1;
            }
            v();
        }
        SearchableInfo searchableInfo2 = this.f3424d0;
        boolean z4 = false;
        if (searchableInfo2 != null && searchableInfo2.getVoiceSearchEnabled()) {
            if (this.f3424d0.getVoiceSearchLaunchWebSearch()) {
                intent = this.f3407J;
            } else if (this.f3424d0.getVoiceSearchLaunchRecognizer()) {
                intent = this.f3408K;
            }
            if (intent != null) {
                z4 = getContext().getPackageManager().resolveActivity(intent, 65536) != null;
            }
        }
        this.f3420W = z4;
        if (z4) {
            searchAutoComplete.setPrivateImeOptions("nm");
        }
        y(this.f3413P);
    }

    public void setSubmitButtonEnabled(boolean z4) {
        this.f3415R = z4;
        y(this.f3413P);
    }

    public void setSuggestionsAdapter(T.c cVar) {
        this.f3414Q = cVar;
        this.f3429r.setAdapter(cVar);
    }

    public final void t() {
        boolean z4 = true;
        boolean z5 = !TextUtils.isEmpty(this.f3429r.getText());
        if (!z5 && (!this.f3412O || this.f3422b0)) {
            z4 = false;
        }
        int i5 = z4 ? 0 : 8;
        ImageView imageView = this.f3435x;
        imageView.setVisibility(i5);
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.setState(z5 ? ViewGroup.ENABLED_STATE_SET : ViewGroup.EMPTY_STATE_SET);
        }
    }

    public final void u() {
        int[] iArr = this.f3429r.hasFocus() ? ViewGroup.FOCUSED_STATE_SET : ViewGroup.EMPTY_STATE_SET;
        Drawable background = this.f3431t.getBackground();
        if (background != null) {
            background.setState(iArr);
        }
        Drawable background2 = this.f3432u.getBackground();
        if (background2 != null) {
            background2.setState(iArr);
        }
        invalidate();
    }

    public final void v() {
        Drawable drawable;
        CharSequence queryHint = getQueryHint();
        if (queryHint == null) {
            queryHint = "";
        }
        boolean z4 = this.f3412O;
        SearchAutoComplete searchAutoComplete = this.f3429r;
        if (z4 && (drawable = this.f3405G) != null) {
            int textSize = (int) (searchAutoComplete.getTextSize() * 1.25d);
            drawable.setBounds(0, 0, textSize, textSize);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder("   ");
            spannableStringBuilder.setSpan(new ImageSpan(drawable), 1, 2, 33);
            spannableStringBuilder.append(queryHint);
            queryHint = spannableStringBuilder;
        }
        searchAutoComplete.setHint(queryHint);
    }

    public final void w() {
        this.f3432u.setVisibility(((this.f3415R || this.f3420W) && !this.f3413P && (this.f3434w.getVisibility() == 0 || this.f3436y.getVisibility() == 0)) ? 0 : 8);
    }

    public final void x(boolean z4) {
        boolean z5 = this.f3415R;
        this.f3434w.setVisibility((!z5 || !(z5 || this.f3420W) || this.f3413P || !hasFocus() || (!z4 && this.f3420W)) ? 8 : 0);
    }

    public final void y(boolean z4) {
        this.f3413P = z4;
        int i5 = 8;
        int i6 = z4 ? 0 : 8;
        boolean zIsEmpty = TextUtils.isEmpty(this.f3429r.getText());
        this.f3433v.setVisibility(i6);
        x(!zIsEmpty);
        this.f3430s.setVisibility(z4 ? 8 : 0);
        ImageView imageView = this.f3404F;
        imageView.setVisibility((imageView.getDrawable() == null || this.f3412O) ? 8 : 0);
        t();
        if (this.f3420W && !this.f3413P && zIsEmpty) {
            this.f3434w.setVisibility(8);
            i5 = 0;
        }
        this.f3436y.setVisibility(i5);
        w();
    }

    public SearchView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.searchViewStyle);
    }

    public SearchView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f3400B = new Rect();
        this.f3401C = new Rect();
        this.f3402D = new int[2];
        this.f3403E = new int[2];
        this.f3426f0 = new K0(this, 0);
        this.f3427g0 = new K0(this, 1);
        this.f3428h0 = new WeakHashMap();
        a aVar = new a(this);
        b bVar = new b(this);
        M0 m02 = new M0(this);
        int i6 = 1;
        C0617L c0617l = new C0617L(i6, this);
        C0657t0 c0657t0 = new C0657t0(i6, this);
        f fVar = new f(3, this);
        int[] iArr = AbstractC0429a.f6132u;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i5, 0);
        m mVar = new m(context, typedArrayObtainStyledAttributes);
        Y.j(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes, i5);
        LayoutInflater.from(context).inflate(typedArrayObtainStyledAttributes.getResourceId(19, R.layout.abc_search_view), (ViewGroup) this, true);
        SearchAutoComplete searchAutoComplete = (SearchAutoComplete) findViewById(R.id.search_src_text);
        this.f3429r = searchAutoComplete;
        searchAutoComplete.setSearchView(this);
        this.f3430s = findViewById(R.id.search_edit_frame);
        View viewFindViewById = findViewById(R.id.search_plate);
        this.f3431t = viewFindViewById;
        View viewFindViewById2 = findViewById(R.id.submit_area);
        this.f3432u = viewFindViewById2;
        ImageView imageView = (ImageView) findViewById(R.id.search_button);
        this.f3433v = imageView;
        ImageView imageView2 = (ImageView) findViewById(R.id.search_go_btn);
        this.f3434w = imageView2;
        ImageView imageView3 = (ImageView) findViewById(R.id.search_close_btn);
        this.f3435x = imageView3;
        ImageView imageView4 = (ImageView) findViewById(R.id.search_voice_btn);
        this.f3436y = imageView4;
        ImageView imageView5 = (ImageView) findViewById(R.id.search_mag_icon);
        this.f3404F = imageView5;
        G.q(viewFindViewById, mVar.g(20));
        G.q(viewFindViewById2, mVar.g(25));
        imageView.setImageDrawable(mVar.g(23));
        imageView2.setImageDrawable(mVar.g(15));
        imageView3.setImageDrawable(mVar.g(12));
        imageView4.setImageDrawable(mVar.g(28));
        imageView5.setImageDrawable(mVar.g(23));
        this.f3405G = mVar.g(22);
        g1.a(imageView, getResources().getString(R.string.abc_searchview_description_search));
        this.f3406H = typedArrayObtainStyledAttributes.getResourceId(26, R.layout.abc_search_dropdown_item_icons_2line);
        this.I = typedArrayObtainStyledAttributes.getResourceId(13, 0);
        imageView.setOnClickListener(aVar);
        imageView3.setOnClickListener(aVar);
        imageView2.setOnClickListener(aVar);
        imageView4.setOnClickListener(aVar);
        searchAutoComplete.setOnClickListener(aVar);
        searchAutoComplete.addTextChangedListener(fVar);
        searchAutoComplete.setOnEditorActionListener(m02);
        searchAutoComplete.setOnItemClickListener(c0617l);
        searchAutoComplete.setOnItemSelectedListener(c0657t0);
        searchAutoComplete.setOnKeyListener(bVar);
        searchAutoComplete.setOnFocusChangeListener(new L0(this));
        setIconifiedByDefault(typedArrayObtainStyledAttributes.getBoolean(18, true));
        int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(2, -1);
        if (dimensionPixelSize != -1) {
            setMaxWidth(dimensionPixelSize);
        }
        this.f3409L = typedArrayObtainStyledAttributes.getText(14);
        this.f3416S = typedArrayObtainStyledAttributes.getText(21);
        int i7 = typedArrayObtainStyledAttributes.getInt(6, -1);
        if (i7 != -1) {
            setImeOptions(i7);
        }
        int i8 = typedArrayObtainStyledAttributes.getInt(5, -1);
        if (i8 != -1) {
            setInputType(i8);
        }
        setFocusable(typedArrayObtainStyledAttributes.getBoolean(1, true));
        mVar.n();
        Intent intent = new Intent("android.speech.action.WEB_SEARCH");
        this.f3407J = intent;
        intent.addFlags(268435456);
        intent.putExtra("android.speech.extra.LANGUAGE_MODEL", "web_search");
        Intent intent2 = new Intent("android.speech.action.RECOGNIZE_SPEECH");
        this.f3408K = intent2;
        intent2.addFlags(268435456);
        View viewFindViewById3 = findViewById(searchAutoComplete.getDropDownAnchor());
        this.f3437z = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.addOnLayoutChangeListener(new T1.a(2, this));
        }
        y(this.f3412O);
        v();
    }
}
