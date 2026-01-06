package androidx.fragment.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import g0.AbstractC0535a;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class H implements LayoutInflater.Factory2 {

    /* renamed from: c, reason: collision with root package name */
    public final T f3666c;

    public H(T t4) {
        this.f3666c = t4;
    }

    @Override // android.view.LayoutInflater.Factory
    public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        boolean zIsAssignableFrom;
        b0 b0VarF;
        View view2;
        boolean zEquals = FragmentContainerView.class.getName().equals(str);
        T t4 = this.f3666c;
        if (zEquals) {
            FragmentContainerView fragmentContainerView = new FragmentContainerView(context, attributeSet);
            fragmentContainerView.f3659f = true;
            String classAttribute = attributeSet.getClassAttribute();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Z.a.f3062b);
            if (classAttribute == null) {
                classAttribute = typedArrayObtainStyledAttributes.getString(0);
            }
            String string = typedArrayObtainStyledAttributes.getString(1);
            typedArrayObtainStyledAttributes.recycle();
            int id = fragmentContainerView.getId();
            Fragment fragmentW = t4.w(id);
            if (classAttribute != null && fragmentW == null) {
                if (id <= 0) {
                    throw new IllegalStateException(AbstractC0535a.l("FragmentContainerView must have an android:id to add Fragment ", classAttribute, string != null ? " with tag ".concat(string) : ""));
                }
                L lZ = t4.z();
                context.getClassLoader();
                Fragment fragmentInstantiate = Fragment.instantiate(lZ.f3676a.f3706o.f3652d, classAttribute, null);
                fragmentInstantiate.onInflate(context, attributeSet, (Bundle) null);
                C0206a c0206a = new C0206a(t4);
                c0206a.f3753o = true;
                fragmentInstantiate.mContainer = fragmentContainerView;
                c0206a.e(fragmentContainerView.getId(), fragmentInstantiate, string, 1);
                if (c0206a.g) {
                    throw new IllegalStateException("This transaction is already being added to the back stack");
                }
                c0206a.f3754p.t(c0206a, true);
            }
            Iterator it = t4.f3697c.d().iterator();
            while (it.hasNext()) {
                b0 b0Var = (b0) it.next();
                Fragment fragment = b0Var.f3773c;
                if (fragment.mContainerId == fragmentContainerView.getId() && (view2 = fragment.mView) != null && view2.getParent() == null) {
                    fragment.mContainer = fragmentContainerView;
                    b0Var.b();
                }
            }
            return fragmentContainerView;
        }
        if (!"fragment".equals(str)) {
            return null;
        }
        String attributeValue = attributeSet.getAttributeValue(null, "class");
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, Z.a.f3061a);
        if (attributeValue == null) {
            attributeValue = typedArrayObtainStyledAttributes2.getString(0);
        }
        int resourceId = typedArrayObtainStyledAttributes2.getResourceId(1, -1);
        String string2 = typedArrayObtainStyledAttributes2.getString(2);
        typedArrayObtainStyledAttributes2.recycle();
        if (attributeValue != null) {
            try {
                zIsAssignableFrom = Fragment.class.isAssignableFrom(L.a(context.getClassLoader(), attributeValue));
            } catch (ClassNotFoundException unused) {
                zIsAssignableFrom = false;
            }
            if (zIsAssignableFrom) {
                int id2 = view != null ? view.getId() : 0;
                if (id2 == -1 && resourceId == -1 && string2 == null) {
                    throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + attributeValue);
                }
                Fragment fragmentW2 = resourceId != -1 ? t4.w(resourceId) : null;
                if (fragmentW2 == null && string2 != null) {
                    fragmentW2 = t4.x(string2);
                }
                if (fragmentW2 == null && id2 != -1) {
                    fragmentW2 = t4.w(id2);
                }
                if (fragmentW2 == null) {
                    L lZ2 = t4.z();
                    context.getClassLoader();
                    fragmentW2 = Fragment.instantiate(lZ2.f3676a.f3706o.f3652d, attributeValue, null);
                    fragmentW2.mFromLayout = true;
                    fragmentW2.mFragmentId = resourceId != 0 ? resourceId : id2;
                    fragmentW2.mContainerId = id2;
                    fragmentW2.mTag = string2;
                    fragmentW2.mInLayout = true;
                    fragmentW2.mFragmentManager = t4;
                    F f5 = t4.f3706o;
                    fragmentW2.mHost = f5;
                    fragmentW2.onInflate(f5.f3652d, attributeSet, fragmentW2.mSavedFragmentState);
                    b0VarF = t4.a(fragmentW2);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Fragment " + fragmentW2 + " has been inflated via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                } else {
                    if (fragmentW2.mInLayout) {
                        throw new IllegalArgumentException(attributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(resourceId) + ", tag " + string2 + ", or parent id 0x" + Integer.toHexString(id2) + " with another fragment for " + attributeValue);
                    }
                    fragmentW2.mInLayout = true;
                    fragmentW2.mFragmentManager = t4;
                    F f6 = t4.f3706o;
                    fragmentW2.mHost = f6;
                    fragmentW2.onInflate(f6.f3652d, attributeSet, fragmentW2.mSavedFragmentState);
                    b0VarF = t4.f(fragmentW2);
                    if (Log.isLoggable("FragmentManager", 2)) {
                        Log.v("FragmentManager", "Retained Fragment " + fragmentW2 + " has been re-attached via the <fragment> tag: id=0x" + Integer.toHexString(resourceId));
                    }
                }
                fragmentW2.mContainer = (ViewGroup) view;
                b0VarF.k();
                b0VarF.j();
                View view3 = fragmentW2.mView;
                if (view3 == null) {
                    throw new IllegalStateException(AbstractC0535a.l("Fragment ", attributeValue, " did not create a view."));
                }
                if (resourceId != 0) {
                    view3.setId(resourceId);
                }
                if (fragmentW2.mView.getTag() == null) {
                    fragmentW2.mView.setTag(string2);
                }
                fragmentW2.mView.addOnAttachStateChangeListener(new G(this, b0VarF));
                return fragmentW2.mView;
            }
        }
        return null;
    }
}
