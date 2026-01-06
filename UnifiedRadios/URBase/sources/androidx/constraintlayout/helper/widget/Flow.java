package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import u.d;
import u.g;
import v.C0919b;
import x.r;
import x.t;

/* loaded from: classes.dex */
public class Flow extends t {

    /* renamed from: l, reason: collision with root package name */
    public g f3494l;

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10153c = new int[32];
        this.f10157i = new HashMap();
        this.f10155e = context;
        g(attributeSet);
    }

    @Override // x.t, x.c
    public final void g(AttributeSet attributeSet) {
        super.g(attributeSet);
        g gVar = new g();
        gVar.f9865s0 = 0;
        gVar.f9866t0 = 0;
        gVar.f9867u0 = 0;
        gVar.v0 = 0;
        gVar.f9868w0 = 0;
        gVar.f9869x0 = 0;
        gVar.f9870y0 = false;
        gVar.z0 = 0;
        gVar.f9839A0 = 0;
        gVar.f9840B0 = new C0919b();
        gVar.f9841C0 = null;
        gVar.f9842D0 = -1;
        gVar.f9843E0 = -1;
        gVar.f9844F0 = -1;
        gVar.f9845G0 = -1;
        gVar.f9846H0 = -1;
        gVar.f9847I0 = -1;
        gVar.f9848J0 = 0.5f;
        gVar.f9849K0 = 0.5f;
        gVar.f9850L0 = 0.5f;
        gVar.f9851M0 = 0.5f;
        gVar.f9852N0 = 0.5f;
        gVar.O0 = 0.5f;
        gVar.f9853P0 = 0;
        gVar.f9854Q0 = 0;
        gVar.f9855R0 = 2;
        gVar.f9856S0 = 2;
        gVar.T0 = 0;
        gVar.f9857U0 = -1;
        gVar.f9858V0 = 0;
        gVar.f9859W0 = new ArrayList();
        gVar.f9860X0 = null;
        gVar.f9861Y0 = null;
        gVar.f9862Z0 = null;
        gVar.f9864b1 = 0;
        this.f3494l = gVar;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f10345b);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i5 = 0; i5 < indexCount; i5++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i5);
                if (index == 0) {
                    this.f3494l.f9858V0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 1) {
                    g gVar2 = this.f3494l;
                    int dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar2.f9865s0 = dimensionPixelSize;
                    gVar2.f9866t0 = dimensionPixelSize;
                    gVar2.f9867u0 = dimensionPixelSize;
                    gVar2.v0 = dimensionPixelSize;
                } else if (index == 18) {
                    g gVar3 = this.f3494l;
                    int dimensionPixelSize2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                    gVar3.f9867u0 = dimensionPixelSize2;
                    gVar3.f9868w0 = dimensionPixelSize2;
                    gVar3.f9869x0 = dimensionPixelSize2;
                } else if (index == 19) {
                    this.f3494l.v0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 2) {
                    this.f3494l.f9868w0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 3) {
                    this.f3494l.f9865s0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 4) {
                    this.f3494l.f9869x0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 5) {
                    this.f3494l.f9866t0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 54) {
                    this.f3494l.T0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 44) {
                    this.f3494l.f9842D0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 53) {
                    this.f3494l.f9843E0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 38) {
                    this.f3494l.f9844F0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 46) {
                    this.f3494l.f9846H0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 40) {
                    this.f3494l.f9845G0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 48) {
                    this.f3494l.f9847I0 = typedArrayObtainStyledAttributes.getInt(index, 0);
                } else if (index == 42) {
                    this.f3494l.f9848J0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 37) {
                    this.f3494l.f9850L0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 45) {
                    this.f3494l.f9852N0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 39) {
                    this.f3494l.f9851M0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 47) {
                    this.f3494l.O0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 51) {
                    this.f3494l.f9849K0 = typedArrayObtainStyledAttributes.getFloat(index, 0.5f);
                } else if (index == 41) {
                    this.f3494l.f9855R0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 50) {
                    this.f3494l.f9856S0 = typedArrayObtainStyledAttributes.getInt(index, 2);
                } else if (index == 43) {
                    this.f3494l.f9853P0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 52) {
                    this.f3494l.f9854Q0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, 0);
                } else if (index == 49) {
                    this.f3494l.f9857U0 = typedArrayObtainStyledAttributes.getInt(index, -1);
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        this.f10156f = this.f3494l;
        i();
    }

    @Override // x.c
    public final void h(d dVar, boolean z4) {
        g gVar = this.f3494l;
        int i5 = gVar.f9867u0;
        if (i5 > 0 || gVar.v0 > 0) {
            if (z4) {
                gVar.f9868w0 = gVar.v0;
                gVar.f9869x0 = i5;
            } else {
                gVar.f9868w0 = i5;
                gVar.f9869x0 = gVar.v0;
            }
        }
    }

    @Override // x.t
    public final void j(g gVar, int i5, int i6) {
        int mode = View.MeasureSpec.getMode(i5);
        int size = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (gVar == null) {
            setMeasuredDimension(0, 0);
        } else {
            gVar.V(mode, size, mode2, size2);
            setMeasuredDimension(gVar.z0, gVar.f9839A0);
        }
    }

    @Override // x.c, android.view.View
    public final void onMeasure(int i5, int i6) {
        j(this.f3494l, i5, i6);
    }

    public void setFirstHorizontalBias(float f5) {
        this.f3494l.f9850L0 = f5;
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i5) {
        this.f3494l.f9844F0 = i5;
        requestLayout();
    }

    public void setFirstVerticalBias(float f5) {
        this.f3494l.f9851M0 = f5;
        requestLayout();
    }

    public void setFirstVerticalStyle(int i5) {
        this.f3494l.f9845G0 = i5;
        requestLayout();
    }

    public void setHorizontalAlign(int i5) {
        this.f3494l.f9855R0 = i5;
        requestLayout();
    }

    public void setHorizontalBias(float f5) {
        this.f3494l.f9848J0 = f5;
        requestLayout();
    }

    public void setHorizontalGap(int i5) {
        this.f3494l.f9853P0 = i5;
        requestLayout();
    }

    public void setHorizontalStyle(int i5) {
        this.f3494l.f9842D0 = i5;
        requestLayout();
    }

    public void setLastHorizontalBias(float f5) {
        this.f3494l.f9852N0 = f5;
        requestLayout();
    }

    public void setLastHorizontalStyle(int i5) {
        this.f3494l.f9846H0 = i5;
        requestLayout();
    }

    public void setLastVerticalBias(float f5) {
        this.f3494l.O0 = f5;
        requestLayout();
    }

    public void setLastVerticalStyle(int i5) {
        this.f3494l.f9847I0 = i5;
        requestLayout();
    }

    public void setMaxElementsWrap(int i5) {
        this.f3494l.f9857U0 = i5;
        requestLayout();
    }

    public void setOrientation(int i5) {
        this.f3494l.f9858V0 = i5;
        requestLayout();
    }

    public void setPadding(int i5) {
        g gVar = this.f3494l;
        gVar.f9865s0 = i5;
        gVar.f9866t0 = i5;
        gVar.f9867u0 = i5;
        gVar.v0 = i5;
        requestLayout();
    }

    public void setPaddingBottom(int i5) {
        this.f3494l.f9866t0 = i5;
        requestLayout();
    }

    public void setPaddingLeft(int i5) {
        this.f3494l.f9868w0 = i5;
        requestLayout();
    }

    public void setPaddingRight(int i5) {
        this.f3494l.f9869x0 = i5;
        requestLayout();
    }

    public void setPaddingTop(int i5) {
        this.f3494l.f9865s0 = i5;
        requestLayout();
    }

    public void setVerticalAlign(int i5) {
        this.f3494l.f9856S0 = i5;
        requestLayout();
    }

    public void setVerticalBias(float f5) {
        this.f3494l.f9849K0 = f5;
        requestLayout();
    }

    public void setVerticalGap(int i5) {
        this.f3494l.f9854Q0 = i5;
        requestLayout();
    }

    public void setVerticalStyle(int i5) {
        this.f3494l.f9843E0 = i5;
        requestLayout();
    }

    public void setWrapMode(int i5) {
        this.f3494l.T0 = i5;
        requestLayout();
    }
}
