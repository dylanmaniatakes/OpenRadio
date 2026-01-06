package f;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import g0.AbstractC0535a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class z implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final View f6437c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6438d;

    /* renamed from: e, reason: collision with root package name */
    public Method f6439e;

    /* renamed from: f, reason: collision with root package name */
    public Context f6440f;

    public z(View view, String str) {
        this.f6437c = view;
        this.f6438d = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        Method method;
        if (this.f6439e == null) {
            View view2 = this.f6437c;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f6438d;
                if (context == null) {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    StringBuilder sbM = AbstractC0535a.m("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    sbM.append(view2.getClass());
                    sbM.append(str);
                    throw new IllegalStateException(sbM.toString());
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f6439e = method;
                        this.f6440f = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f6439e.invoke(this.f6440f, view);
        } catch (IllegalAccessException e5) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e5);
        } catch (InvocationTargetException e6) {
            throw new IllegalStateException("Could not execute method for android:onClick", e6);
        }
    }
}
