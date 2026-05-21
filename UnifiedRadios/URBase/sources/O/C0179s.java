package O;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

/* renamed from: O.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0179s {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f1960a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f1961b;

    /* renamed from: c, reason: collision with root package name */
    public final View f1962c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f1963d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f1964e;

    public C0179s(View view) {
        this.f1962c = view;
    }

    public final boolean a(float f5, float f6, boolean z4) {
        ViewParent viewParentE;
        if (!this.f1963d || (viewParentE = e(0)) == null) {
            return false;
        }
        try {
            return AbstractC0161e0.a(viewParentE, this.f1962c, f5, f6, z4);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedFling", e5);
            return false;
        }
    }

    public final boolean b(float f5, float f6) {
        ViewParent viewParentE;
        if (!this.f1963d || (viewParentE = e(0)) == null) {
            return false;
        }
        try {
            return AbstractC0161e0.b(viewParentE, this.f1962c, f5, f6);
        } catch (AbstractMethodError e5) {
            Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreFling", e5);
            return false;
        }
    }

    public final boolean c(int i5, int i6, int i7, int[] iArr, int[] iArr2) {
        ViewParent viewParentE;
        int i8;
        int i9;
        int[] iArr3;
        if (!this.f1963d || (viewParentE = e(i7)) == null) {
            return false;
        }
        if (i5 == 0 && i6 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        View view = this.f1962c;
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            i8 = iArr2[0];
            i9 = iArr2[1];
        } else {
            i8 = 0;
            i9 = 0;
        }
        if (iArr == null) {
            if (this.f1964e == null) {
                this.f1964e = new int[2];
            }
            iArr3 = this.f1964e;
        } else {
            iArr3 = iArr;
        }
        iArr3[0] = 0;
        iArr3[1] = 0;
        boolean z4 = viewParentE instanceof InterfaceC0180t;
        View view2 = this.f1962c;
        if (z4) {
            ((InterfaceC0180t) viewParentE).c(view2, i5, i6, iArr3, i7);
        } else if (i7 == 0) {
            try {
                AbstractC0161e0.c(viewParentE, view2, i5, i6, iArr3);
            } catch (AbstractMethodError e5) {
                Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedPreScroll", e5);
            }
        }
        if (iArr2 != null) {
            view.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i8;
            iArr2[1] = iArr2[1] - i9;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i5, int i6, int i7, int i8, int[] iArr, int i9, int[] iArr2) {
        ViewParent viewParentE;
        int i10;
        int i11;
        int[] iArr3;
        if (!this.f1963d || (viewParentE = e(i9)) == null) {
            return false;
        }
        if (i5 == 0 && i6 == 0 && i7 == 0 && i8 == 0) {
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
            }
            return false;
        }
        View view = this.f1962c;
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            i10 = iArr[0];
            i11 = iArr[1];
        } else {
            i10 = 0;
            i11 = 0;
        }
        if (iArr2 == null) {
            if (this.f1964e == null) {
                this.f1964e = new int[2];
            }
            int[] iArr4 = this.f1964e;
            iArr4[0] = 0;
            iArr4[1] = 0;
            iArr3 = iArr4;
        } else {
            iArr3 = iArr2;
        }
        boolean z4 = viewParentE instanceof InterfaceC0181u;
        View view2 = this.f1962c;
        if (z4) {
            ((InterfaceC0181u) viewParentE).d(view2, i5, i6, i7, i8, i9, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i7;
            iArr3[1] = iArr3[1] + i8;
            if (viewParentE instanceof InterfaceC0180t) {
                ((InterfaceC0180t) viewParentE).e(view2, i5, i6, i7, i8, i9);
            } else if (i9 == 0) {
                try {
                    AbstractC0161e0.d(viewParentE, view2, i5, i6, i7, i8);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onNestedScroll", e5);
                }
            }
        }
        if (iArr != null) {
            view.getLocationInWindow(iArr);
            iArr[0] = iArr[0] - i10;
            iArr[1] = iArr[1] - i11;
        }
        return true;
    }

    public final ViewParent e(int i5) {
        if (i5 == 0) {
            return this.f1960a;
        }
        if (i5 != 1) {
            return null;
        }
        return this.f1961b;
    }

    public final boolean f(int i5) {
        return e(i5) != null;
    }

    public final boolean g(int i5, int i6) {
        boolean zF;
        if (f(i6)) {
            return true;
        }
        if (this.f1963d) {
            View view = this.f1962c;
            View view2 = view;
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                boolean z4 = parent instanceof InterfaceC0180t;
                if (z4) {
                    zF = ((InterfaceC0180t) parent).f(view2, view, i5, i6);
                } else if (i6 == 0) {
                    try {
                        zF = AbstractC0161e0.f(parent, view2, view, i5);
                    } catch (AbstractMethodError e5) {
                        Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e5);
                    }
                } else {
                    zF = false;
                }
                if (zF) {
                    if (i6 == 0) {
                        this.f1960a = parent;
                    } else if (i6 == 1) {
                        this.f1961b = parent;
                    }
                    if (z4) {
                        ((InterfaceC0180t) parent).a(view2, view, i5, i6);
                    } else if (i6 == 0) {
                        try {
                            AbstractC0161e0.e(parent, view2, view, i5);
                        } catch (AbstractMethodError e6) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e6);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view2 = parent;
                }
            }
        }
        return false;
    }

    public final void h(int i5) {
        ViewParent viewParentE = e(i5);
        if (viewParentE != null) {
            boolean z4 = viewParentE instanceof InterfaceC0180t;
            View view = this.f1962c;
            if (z4) {
                ((InterfaceC0180t) viewParentE).b(view, i5);
            } else if (i5 == 0) {
                try {
                    AbstractC0161e0.g(viewParentE, view);
                } catch (AbstractMethodError e5) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParentE + " does not implement interface method onStopNestedScroll", e5);
                }
            }
            if (i5 == 0) {
                this.f1960a = null;
            } else {
                if (i5 != 1) {
                    return;
                }
                this.f1961b = null;
            }
        }
    }
}
