package z;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.unified.ur1.SatelliteTracker.h;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import y.AbstractC0975a;

/* loaded from: classes.dex */
public final class e extends ViewGroup.MarginLayoutParams {

    /* renamed from: a, reason: collision with root package name */
    public b f10529a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f10530b;

    /* renamed from: c, reason: collision with root package name */
    public final int f10531c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10532d;

    /* renamed from: e, reason: collision with root package name */
    public final int f10533e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10534f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f10535i;

    /* renamed from: j, reason: collision with root package name */
    public int f10536j;

    /* renamed from: k, reason: collision with root package name */
    public View f10537k;

    /* renamed from: l, reason: collision with root package name */
    public View f10538l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10539m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f10540o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f10541p;

    /* renamed from: q, reason: collision with root package name */
    public final Rect f10542q;

    public e() {
        super(-2, -2);
        this.f10530b = false;
        this.f10531c = 0;
        this.f10532d = 0;
        this.f10533e = -1;
        this.f10534f = -1;
        this.g = 0;
        this.h = 0;
        this.f10542q = new Rect();
    }

    public final boolean a(int i5) {
        if (i5 == 0) {
            return this.n;
        }
        if (i5 != 1) {
            return false;
        }
        return this.f10540o;
    }

    public final void b(b bVar) {
        b bVar2 = this.f10529a;
        if (bVar2 != bVar) {
            if (bVar2 != null) {
                bVar2.e();
            }
            this.f10529a = bVar;
            this.f10530b = true;
            if (bVar != null) {
                bVar.c(this);
            }
        }
    }

    public e(Context context, AttributeSet attributeSet) throws NoSuchMethodException, SecurityException {
        b bVar;
        super(context, attributeSet);
        this.f10530b = false;
        this.f10531c = 0;
        this.f10532d = 0;
        this.f10533e = -1;
        this.f10534f = -1;
        this.g = 0;
        this.h = 0;
        this.f10542q = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, AbstractC0975a.f10457b);
        this.f10531c = typedArrayObtainStyledAttributes.getInteger(0, 0);
        this.f10534f = typedArrayObtainStyledAttributes.getResourceId(1, -1);
        this.f10532d = typedArrayObtainStyledAttributes.getInteger(2, 0);
        this.f10533e = typedArrayObtainStyledAttributes.getInteger(6, -1);
        this.g = typedArrayObtainStyledAttributes.getInt(5, 0);
        this.h = typedArrayObtainStyledAttributes.getInt(4, 0);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(3);
        this.f10530b = zHasValue;
        if (zHasValue) {
            String string = typedArrayObtainStyledAttributes.getString(3);
            String str = CoordinatorLayout.f3510v;
            if (TextUtils.isEmpty(string)) {
                bVar = null;
            } else {
                if (string.startsWith(".")) {
                    string = context.getPackageName() + string;
                } else if (string.indexOf(46) < 0) {
                    String str2 = CoordinatorLayout.f3510v;
                    if (!TextUtils.isEmpty(str2)) {
                        string = str2 + '.' + string;
                    }
                }
                try {
                    ThreadLocal threadLocal = CoordinatorLayout.f3512x;
                    Map map = (Map) threadLocal.get();
                    if (map == null) {
                        map = new HashMap();
                        threadLocal.set(map);
                    }
                    Constructor<?> constructor = (Constructor) map.get(string);
                    if (constructor == null) {
                        constructor = Class.forName(string, false, context.getClassLoader()).getConstructor(CoordinatorLayout.f3511w);
                        constructor.setAccessible(true);
                        map.put(string, constructor);
                    }
                    bVar = (b) constructor.newInstance(context, attributeSet);
                } catch (Exception e5) {
                    throw new RuntimeException(h.s("Could not inflate Behavior subclass ", string), e5);
                }
            }
            this.f10529a = bVar;
        }
        typedArrayObtainStyledAttributes.recycle();
        b bVar2 = this.f10529a;
        if (bVar2 != null) {
            bVar2.c(this);
        }
    }

    public e(e eVar) {
        super((ViewGroup.MarginLayoutParams) eVar);
        this.f10530b = false;
        this.f10531c = 0;
        this.f10532d = 0;
        this.f10533e = -1;
        this.f10534f = -1;
        this.g = 0;
        this.h = 0;
        this.f10542q = new Rect();
    }

    public e(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.f10530b = false;
        this.f10531c = 0;
        this.f10532d = 0;
        this.f10533e = -1;
        this.f10534f = -1;
        this.g = 0;
        this.h = 0;
        this.f10542q = new Rect();
    }

    public e(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.f10530b = false;
        this.f10531c = 0;
        this.f10532d = 0;
        this.f10533e = -1;
        this.f10534f = -1;
        this.g = 0;
        this.h = 0;
        this.f10542q = new Rect();
    }
}
