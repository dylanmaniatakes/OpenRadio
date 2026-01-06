package w0;

import O.J;
import O.Y;
import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.PointF;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import h1.C0558b;
import java.util.HashMap;
import java.util.WeakHashMap;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class f extends p {

    /* renamed from: G, reason: collision with root package name */
    public static final String[] f10055G = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* renamed from: H, reason: collision with root package name */
    public static final C0928b f10056H;
    public static final C0928b I;

    /* renamed from: J, reason: collision with root package name */
    public static final C0928b f10057J;

    /* renamed from: K, reason: collision with root package name */
    public static final C0928b f10058K;

    /* renamed from: L, reason: collision with root package name */
    public static final C0928b f10059L;

    static {
        new P1.c("boundsOrigin", PointF.class).f2071b = new Rect();
        f10056H = new C0928b(PointF.class, "topLeft", 0);
        I = new C0928b(PointF.class, "bottomRight", 1);
        f10057J = new C0928b(PointF.class, "bottomRight", 2);
        f10058K = new C0928b(PointF.class, "topLeft", 3);
        f10059L = new C0928b(PointF.class, "position", 4);
    }

    public static void H(v vVar) {
        View view = vVar.f10114b;
        WeakHashMap weakHashMap = Y.f1904a;
        if (!J.c(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        HashMap map = vVar.f10113a;
        map.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        map.put("android:changeBounds:parent", vVar.f10114b.getParent());
    }

    @Override // w0.p
    public final void d(v vVar) {
        H(vVar);
    }

    @Override // w0.p
    public final void g(v vVar) {
        H(vVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // w0.p
    public final Animator k(ViewGroup viewGroup, v vVar, v vVar2) {
        int i5;
        f fVar;
        ObjectAnimator objectAnimatorOfObject;
        if (vVar == null || vVar2 == null) {
            return null;
        }
        HashMap map = vVar.f10113a;
        HashMap map2 = vVar2.f10113a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        Rect rect = (Rect) map.get("android:changeBounds:bounds");
        Rect rect2 = (Rect) map2.get("android:changeBounds:bounds");
        int i6 = rect.left;
        int i7 = rect2.left;
        int i8 = rect.top;
        int i9 = rect2.top;
        int i10 = rect.right;
        int i11 = rect2.right;
        int i12 = rect.bottom;
        int i13 = rect2.bottom;
        int i14 = i10 - i6;
        int i15 = i12 - i8;
        int i16 = i11 - i7;
        int i17 = i13 - i9;
        Rect rect3 = (Rect) map.get("android:changeBounds:clip");
        Rect rect4 = (Rect) map2.get("android:changeBounds:clip");
        if ((i14 == 0 || i15 == 0) && (i16 == 0 || i17 == 0)) {
            i5 = 0;
        } else {
            i5 = (i6 == i7 && i8 == i9) ? 0 : 1;
            if (i10 != i11 || i12 != i13) {
                i5++;
            }
        }
        if ((rect3 != null && !rect3.equals(rect4)) || (rect3 == null && rect4 != null)) {
            i5++;
        }
        if (i5 <= 0) {
            return null;
        }
        View view = vVar2.f10114b;
        w.a(view, i6, i8, i10, i12);
        if (i5 != 2) {
            fVar = this;
            if (i6 == i7 && i8 == i9) {
                fVar.f10085C.getClass();
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, f10057J, (TypeConverter) null, C0558b.g(i10, i12, i11, i13));
            } else {
                fVar.f10085C.getClass();
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, f10058K, (TypeConverter) null, C0558b.g(i6, i8, i7, i9));
            }
        } else if (i14 == i16 && i15 == i17) {
            fVar = this;
            fVar.f10085C.getClass();
            objectAnimatorOfObject = ObjectAnimator.ofObject(view, f10059L, (TypeConverter) null, C0558b.g(i6, i8, i7, i9));
        } else {
            fVar = this;
            e eVar = new e();
            eVar.f10053e = view;
            fVar.f10085C.getClass();
            ObjectAnimator objectAnimatorOfObject2 = ObjectAnimator.ofObject(eVar, f10056H, (TypeConverter) null, C0558b.g(i6, i8, i7, i9));
            fVar.f10085C.getClass();
            ObjectAnimator objectAnimatorOfObject3 = ObjectAnimator.ofObject(eVar, I, (TypeConverter) null, C0558b.g(i10, i12, i11, i13));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(objectAnimatorOfObject2, objectAnimatorOfObject3);
            animatorSet.addListener(new C0929c(eVar));
            objectAnimatorOfObject = animatorSet;
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            AbstractC0930a.p(viewGroup4, true);
            fVar.a(new d(viewGroup4));
        }
        return objectAnimatorOfObject;
    }

    @Override // w0.p
    public final String[] p() {
        return f10055G;
    }
}
