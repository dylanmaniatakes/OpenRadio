package P1;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import java.util.ArrayList;
import q.k;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final k f2072a = new k();

    /* renamed from: b, reason: collision with root package name */
    public final k f2073b = new k();

    public static d a(Context context, TypedArray typedArray, int i5) {
        int resourceId;
        if (!typedArray.hasValue(i5) || (resourceId = typedArray.getResourceId(i5, 0)) == 0) {
            return null;
        }
        return b(context, resourceId);
    }

    public static d b(Context context, int i5) throws Resources.NotFoundException {
        try {
            Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(context, i5);
            if (animatorLoadAnimator instanceof AnimatorSet) {
                return c(((AnimatorSet) animatorLoadAnimator).getChildAnimations());
            }
            if (animatorLoadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(animatorLoadAnimator);
            return c(arrayList);
        } catch (Exception e5) {
            Log.w("MotionSpec", "Can't load animation resource ID #0x" + Integer.toHexString(i5), e5);
            return null;
        }
    }

    public static d c(ArrayList arrayList) {
        d dVar = new d();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            Animator animator = (Animator) arrayList.get(i5);
            if (!(animator instanceof ObjectAnimator)) {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            dVar.f2073b.put(objectAnimator.getPropertyName(), objectAnimator.getValues());
            String propertyName = objectAnimator.getPropertyName();
            long startDelay = objectAnimator.getStartDelay();
            long duration = objectAnimator.getDuration();
            TimeInterpolator interpolator = objectAnimator.getInterpolator();
            if ((interpolator instanceof AccelerateDecelerateInterpolator) || interpolator == null) {
                interpolator = a.f2065b;
            } else if (interpolator instanceof AccelerateInterpolator) {
                interpolator = a.f2066c;
            } else if (interpolator instanceof DecelerateInterpolator) {
                interpolator = a.f2067d;
            }
            e eVar = new e();
            eVar.f2077d = 0;
            eVar.f2078e = 1;
            eVar.f2074a = startDelay;
            eVar.f2075b = duration;
            eVar.f2076c = interpolator;
            eVar.f2077d = objectAnimator.getRepeatCount();
            eVar.f2078e = objectAnimator.getRepeatMode();
            dVar.f2072a.put(propertyName, eVar);
        }
        return dVar;
    }

    public final e d(String str) {
        k kVar = this.f2072a;
        if (kVar.getOrDefault(str, null) != null) {
            return (e) kVar.getOrDefault(str, null);
        }
        throw new IllegalArgumentException();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d) {
            return this.f2072a.equals(((d) obj).f2072a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f2072a.hashCode();
    }

    public final String toString() {
        return "\n" + d.class.getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " timings: " + this.f2072a + "}\n";
    }
}
