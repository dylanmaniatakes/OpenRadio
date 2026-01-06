package y3;

import com.google.android.gms.internal.measurement.AbstractC0399v1;
import f3.C0513e;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* renamed from: y3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0987a implements InterfaceC0936d, InterfaceC0990d, Serializable {
    private final InterfaceC0936d completion;

    public AbstractC0987a(InterfaceC0936d interfaceC0936d) {
        this.completion = interfaceC0936d;
    }

    public InterfaceC0936d create(InterfaceC0936d interfaceC0936d) {
        F3.i.f(interfaceC0936d, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    @Override // y3.InterfaceC0990d
    public InterfaceC0990d getCallerFrame() {
        InterfaceC0936d interfaceC0936d = this.completion;
        if (interfaceC0936d instanceof InterfaceC0990d) {
            return (InterfaceC0990d) interfaceC0936d;
        }
        return null;
    }

    public final InterfaceC0936d getCompletion() {
        return this.completion;
    }

    public StackTraceElement getStackTraceElement() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        int iIntValue;
        String strC;
        InterfaceC0991e interfaceC0991e = (InterfaceC0991e) getClass().getAnnotation(InterfaceC0991e.class);
        String str = null;
        if (interfaceC0991e == null) {
            return null;
        }
        int iV = interfaceC0991e.v();
        if (iV > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + iV + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            iIntValue = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            iIntValue = -1;
        }
        int i5 = iIntValue >= 0 ? interfaceC0991e.l()[iIntValue] : -1;
        C0513e c0513e = AbstractC0992f.f10525b;
        C0513e c0513e2 = AbstractC0992f.f10524a;
        if (c0513e == null) {
            try {
                C0513e c0513e3 = new C0513e(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                AbstractC0992f.f10525b = c0513e3;
                c0513e = c0513e3;
            } catch (Exception unused2) {
                AbstractC0992f.f10525b = c0513e2;
                c0513e = c0513e2;
            }
        }
        if (c0513e != c0513e2) {
            Method method = (Method) c0513e.f6686c;
            Object objInvoke = method != null ? method.invoke(getClass(), null) : null;
            if (objInvoke != null) {
                Method method2 = (Method) c0513e.f6687d;
                Object objInvoke2 = method2 != null ? method2.invoke(objInvoke, null) : null;
                if (objInvoke2 != null) {
                    Method method3 = (Method) c0513e.f6688e;
                    Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
                    if (objInvoke3 instanceof String) {
                        str = (String) objInvoke3;
                    }
                }
            }
        }
        if (str == null) {
            strC = interfaceC0991e.c();
        } else {
            strC = str + '/' + interfaceC0991e.c();
        }
        return new StackTraceElement(strC, interfaceC0991e.m(), interfaceC0991e.f(), i5);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    @Override // w3.InterfaceC0936d
    public final void resumeWith(Object obj) {
        InterfaceC0936d interfaceC0936d = this;
        while (true) {
            AbstractC0987a abstractC0987a = (AbstractC0987a) interfaceC0936d;
            InterfaceC0936d interfaceC0936d2 = abstractC0987a.completion;
            F3.i.c(interfaceC0936d2);
            try {
                obj = abstractC0987a.invokeSuspend(obj);
                if (obj == EnumC0973a.f10448j) {
                    return;
                }
            } catch (Throwable th) {
                obj = AbstractC0399v1.c(th);
            }
            abstractC0987a.releaseIntercepted();
            if (!(interfaceC0936d2 instanceof AbstractC0987a)) {
                interfaceC0936d2.resumeWith(obj);
                return;
            }
            interfaceC0936d = interfaceC0936d2;
        }
    }

    public String toString() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        StringBuilder sb = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb.append(stackTraceElement);
        return sb.toString();
    }

    public InterfaceC0936d create(Object obj, InterfaceC0936d interfaceC0936d) {
        F3.i.f(interfaceC0936d, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
