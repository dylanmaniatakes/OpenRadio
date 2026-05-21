package x0;

import android.graphics.Matrix;
import android.graphics.Paint;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.ArrayList;

/* renamed from: x0.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0953i extends AbstractC0954j {

    /* renamed from: a, reason: collision with root package name */
    public final Matrix f10378a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f10379b;

    /* renamed from: c, reason: collision with root package name */
    public float f10380c;

    /* renamed from: d, reason: collision with root package name */
    public float f10381d;

    /* renamed from: e, reason: collision with root package name */
    public float f10382e;

    /* renamed from: f, reason: collision with root package name */
    public float f10383f;
    public float g;
    public float h;

    /* renamed from: i, reason: collision with root package name */
    public float f10384i;

    /* renamed from: j, reason: collision with root package name */
    public final Matrix f10385j;

    /* renamed from: k, reason: collision with root package name */
    public final int f10386k;

    /* renamed from: l, reason: collision with root package name */
    public String f10387l;

    public C0953i() {
        this.f10378a = new Matrix();
        this.f10379b = new ArrayList();
        this.f10380c = BitmapDescriptorFactory.HUE_RED;
        this.f10381d = BitmapDescriptorFactory.HUE_RED;
        this.f10382e = BitmapDescriptorFactory.HUE_RED;
        this.f10383f = 1.0f;
        this.g = 1.0f;
        this.h = BitmapDescriptorFactory.HUE_RED;
        this.f10384i = BitmapDescriptorFactory.HUE_RED;
        this.f10385j = new Matrix();
        this.f10387l = null;
    }

    @Override // x0.AbstractC0954j
    public final boolean a() {
        int i5 = 0;
        while (true) {
            ArrayList arrayList = this.f10379b;
            if (i5 >= arrayList.size()) {
                return false;
            }
            if (((AbstractC0954j) arrayList.get(i5)).a()) {
                return true;
            }
            i5++;
        }
    }

    @Override // x0.AbstractC0954j
    public final boolean b(int[] iArr) {
        int i5 = 0;
        boolean zB = false;
        while (true) {
            ArrayList arrayList = this.f10379b;
            if (i5 >= arrayList.size()) {
                return zB;
            }
            zB |= ((AbstractC0954j) arrayList.get(i5)).b(iArr);
            i5++;
        }
    }

    public final void c() {
        Matrix matrix = this.f10385j;
        matrix.reset();
        matrix.postTranslate(-this.f10381d, -this.f10382e);
        matrix.postScale(this.f10383f, this.g);
        matrix.postRotate(this.f10380c, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED);
        matrix.postTranslate(this.h + this.f10381d, this.f10384i + this.f10382e);
    }

    public String getGroupName() {
        return this.f10387l;
    }

    public Matrix getLocalMatrix() {
        return this.f10385j;
    }

    public float getPivotX() {
        return this.f10381d;
    }

    public float getPivotY() {
        return this.f10382e;
    }

    public float getRotation() {
        return this.f10380c;
    }

    public float getScaleX() {
        return this.f10383f;
    }

    public float getScaleY() {
        return this.g;
    }

    public float getTranslateX() {
        return this.h;
    }

    public float getTranslateY() {
        return this.f10384i;
    }

    public void setPivotX(float f5) {
        if (f5 != this.f10381d) {
            this.f10381d = f5;
            c();
        }
    }

    public void setPivotY(float f5) {
        if (f5 != this.f10382e) {
            this.f10382e = f5;
            c();
        }
    }

    public void setRotation(float f5) {
        if (f5 != this.f10380c) {
            this.f10380c = f5;
            c();
        }
    }

    public void setScaleX(float f5) {
        if (f5 != this.f10383f) {
            this.f10383f = f5;
            c();
        }
    }

    public void setScaleY(float f5) {
        if (f5 != this.g) {
            this.g = f5;
            c();
        }
    }

    public void setTranslateX(float f5) {
        if (f5 != this.h) {
            this.h = f5;
            c();
        }
    }

    public void setTranslateY(float f5) {
        if (f5 != this.f10384i) {
            this.f10384i = f5;
            c();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0953i(C0953i c0953i, q.b bVar) {
        C0951g c0951g;
        this.f10378a = new Matrix();
        this.f10379b = new ArrayList();
        this.f10380c = BitmapDescriptorFactory.HUE_RED;
        this.f10381d = BitmapDescriptorFactory.HUE_RED;
        this.f10382e = BitmapDescriptorFactory.HUE_RED;
        this.f10383f = 1.0f;
        this.g = 1.0f;
        this.h = BitmapDescriptorFactory.HUE_RED;
        this.f10384i = BitmapDescriptorFactory.HUE_RED;
        Matrix matrix = new Matrix();
        this.f10385j = matrix;
        this.f10387l = null;
        this.f10380c = c0953i.f10380c;
        this.f10381d = c0953i.f10381d;
        this.f10382e = c0953i.f10382e;
        this.f10383f = c0953i.f10383f;
        this.g = c0953i.g;
        this.h = c0953i.h;
        this.f10384i = c0953i.f10384i;
        String str = c0953i.f10387l;
        this.f10387l = str;
        this.f10386k = c0953i.f10386k;
        if (str != null) {
            bVar.put(str, this);
        }
        matrix.set(c0953i.f10385j);
        ArrayList arrayList = c0953i.f10379b;
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            Object obj = arrayList.get(i5);
            if (obj instanceof C0953i) {
                this.f10379b.add(new C0953i((C0953i) obj, bVar));
            } else {
                if (obj instanceof C0952h) {
                    C0952h c0952h = (C0952h) obj;
                    C0952h c0952h2 = new C0952h(c0952h);
                    c0952h2.f10371f = BitmapDescriptorFactory.HUE_RED;
                    c0952h2.h = 1.0f;
                    c0952h2.f10372i = 1.0f;
                    c0952h2.f10373j = BitmapDescriptorFactory.HUE_RED;
                    c0952h2.f10374k = 1.0f;
                    c0952h2.f10375l = BitmapDescriptorFactory.HUE_RED;
                    c0952h2.f10376m = Paint.Cap.BUTT;
                    c0952h2.n = Paint.Join.MITER;
                    c0952h2.f10377o = 4.0f;
                    c0952h2.f10370e = c0952h.f10370e;
                    c0952h2.f10371f = c0952h.f10371f;
                    c0952h2.h = c0952h.h;
                    c0952h2.g = c0952h.g;
                    c0952h2.f10390c = c0952h.f10390c;
                    c0952h2.f10372i = c0952h.f10372i;
                    c0952h2.f10373j = c0952h.f10373j;
                    c0952h2.f10374k = c0952h.f10374k;
                    c0952h2.f10375l = c0952h.f10375l;
                    c0952h2.f10376m = c0952h.f10376m;
                    c0952h2.n = c0952h.n;
                    c0952h2.f10377o = c0952h.f10377o;
                    c0951g = c0952h2;
                } else if (obj instanceof C0951g) {
                    c0951g = new C0951g((C0951g) obj);
                } else {
                    throw new IllegalStateException("Unknown object in the tree!");
                }
                this.f10379b.add(c0951g);
                Object obj2 = c0951g.f10389b;
                if (obj2 != null) {
                    bVar.put(obj2, c0951g);
                }
            }
        }
    }
}
