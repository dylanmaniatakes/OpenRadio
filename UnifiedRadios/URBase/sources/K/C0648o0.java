package k;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.unified.ur1.R;
import java.lang.reflect.InvocationTargetException;

/* renamed from: k.o0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0648o0 extends ListView {

    /* renamed from: c, reason: collision with root package name */
    public final Rect f7832c;

    /* renamed from: d, reason: collision with root package name */
    public int f7833d;

    /* renamed from: e, reason: collision with root package name */
    public int f7834e;

    /* renamed from: f, reason: collision with root package name */
    public int f7835f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public C0644m0 f7836i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f7837j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f7838k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f7839l;

    /* renamed from: m, reason: collision with root package name */
    public S.g f7840m;
    public C0.A n;

    public C0648o0(Context context, boolean z4) {
        super(context, null, R.attr.dropDownListViewStyle);
        this.f7832c = new Rect();
        this.f7833d = 0;
        this.f7834e = 0;
        this.f7835f = 0;
        this.g = 0;
        this.f7838k = z4;
        setCacheColorHint(0);
    }

    public final int a(int i5, int i6) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int measuredHeight = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i7 = 0;
        View view = null;
        for (int i8 = 0; i8 < count; i8++) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i7) {
                view = null;
                i7 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            int i9 = layoutParams.height;
            view.measure(i5, i9 > 0 ? View.MeasureSpec.makeMeasureSpec(i9, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i8 > 0) {
                measuredHeight += dividerHeight;
            }
            measuredHeight += view.getMeasuredHeight();
            if (measuredHeight >= i6) {
                return i6;
            }
        }
        return measuredHeight;
    }

    /* JADX WARN: Removed duplicated region for block: B:82:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(android.view.MotionEvent r17, int r18) throws java.lang.IllegalAccessException, java.lang.InterruptedException, android.database.SQLException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.C0648o0.b(android.view.MotionEvent, int):boolean");
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        Drawable selector;
        Rect rect = this.f7832c;
        if (!rect.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(rect);
            selector.draw(canvas);
        }
        super.dispatchDraw(canvas);
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        if (this.n != null) {
            return;
        }
        super.drawableStateChanged();
        C0644m0 c0644m0 = this.f7836i;
        if (c0644m0 != null) {
            c0644m0.f7822d = true;
        }
        Drawable selector = getSelector();
        if (selector != null && this.f7839l && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean hasFocus() {
        return this.f7838k || super.hasFocus();
    }

    @Override // android.view.View
    public final boolean hasWindowFocus() {
        return this.f7838k || super.hasWindowFocus();
    }

    @Override // android.view.View
    public final boolean isFocused() {
        return this.f7838k || super.isFocused();
    }

    @Override // android.view.View
    public final boolean isInTouchMode() {
        return (this.f7838k && this.f7837j) || super.isInTouchMode();
    }

    @Override // android.widget.ListView, android.widget.AbsListView, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.n = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        int i5 = Build.VERSION.SDK_INT;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.n == null) {
            C0.A a2 = new C0.A(23, this);
            this.n = a2;
            post(a2);
        }
        boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int iPointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (iPointToPosition != -1 && iPointToPosition != getSelectedItemPosition()) {
                View childAt = getChildAt(iPointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    requestFocus();
                    if (i5 < 30 || !AbstractC0640k0.f7814d) {
                        setSelectionFromTop(iPointToPosition, childAt.getTop() - getTop());
                    } else {
                        try {
                            AbstractC0640k0.f7811a.invoke(this, Integer.valueOf(iPointToPosition), childAt, Boolean.FALSE, -1, -1);
                            AbstractC0640k0.f7812b.invoke(this, Integer.valueOf(iPointToPosition));
                            AbstractC0640k0.f7813c.invoke(this, Integer.valueOf(iPointToPosition));
                        } catch (IllegalAccessException e5) {
                            e5.printStackTrace();
                        } catch (InvocationTargetException e6) {
                            e6.printStackTrace();
                        }
                    }
                }
                Drawable selector = getSelector();
                if (selector != null && this.f7839l && isPressed()) {
                    selector.setState(getDrawableState());
                }
            }
        } else {
            setSelection(-1);
        }
        return zOnHoverEvent;
    }

    @Override // android.widget.AbsListView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.h = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        C0.A a2 = this.n;
        if (a2 != null) {
            C0648o0 c0648o0 = (C0648o0) a2.f128k;
            c0648o0.n = null;
            c0648o0.removeCallbacks(a2);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setListSelectionHidden(boolean z4) {
        this.f7837j = z4;
    }

    @Override // android.widget.AbsListView
    public void setSelector(Drawable drawable) {
        C0644m0 c0644m0;
        if (drawable != null) {
            c0644m0 = new C0644m0(drawable);
            c0644m0.f7822d = true;
        } else {
            c0644m0 = null;
        }
        this.f7836i = c0644m0;
        super.setSelector(c0644m0);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f7833d = rect.left;
        this.f7834e = rect.top;
        this.f7835f = rect.right;
        this.g = rect.bottom;
    }
}
