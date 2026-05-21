package y0;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: y0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0976a {

    /* renamed from: a, reason: collision with root package name */
    public final q.b f10458a;

    /* renamed from: b, reason: collision with root package name */
    public final q.b f10459b;

    /* renamed from: c, reason: collision with root package name */
    public final q.b f10460c;

    public AbstractC0976a(q.b bVar, q.b bVar2, q.b bVar3) {
        this.f10458a = bVar;
        this.f10459b = bVar2;
        this.f10460c = bVar3;
    }

    public abstract C0977b a();

    public final Class b(Class cls) throws ClassNotFoundException {
        String name = cls.getName();
        q.b bVar = this.f10460c;
        Class cls2 = (Class) bVar.getOrDefault(name, null);
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(cls.getPackage().getName() + "." + cls.getSimpleName() + "Parcelizer", false, cls.getClassLoader());
        bVar.put(cls.getName(), cls3);
        return cls3;
    }

    public final Method c(String str) throws NoSuchMethodException, SecurityException {
        q.b bVar = this.f10458a;
        Method method = (Method) bVar.getOrDefault(str, null);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC0976a.class.getClassLoader()).getDeclaredMethod("read", AbstractC0976a.class);
        bVar.put(str, declaredMethod);
        return declaredMethod;
    }

    public final Method d(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        String name = cls.getName();
        q.b bVar = this.f10459b;
        Method method = (Method) bVar.getOrDefault(name, null);
        if (method != null) {
            return method;
        }
        Class clsB = b(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsB.getDeclaredMethod("write", cls, AbstractC0976a.class);
        bVar.put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    public abstract boolean e(int i5);

    public final int f(int i5, int i6) {
        return !e(i6) ? i5 : ((C0977b) this).f10462e.readInt();
    }

    public final Parcelable g(Parcelable parcelable, int i5) {
        if (!e(i5)) {
            return parcelable;
        }
        return ((C0977b) this).f10462e.readParcelable(C0977b.class.getClassLoader());
    }

    public final InterfaceC0978c h() {
        String string = ((C0977b) this).f10462e.readString();
        if (string == null) {
            return null;
        }
        try {
            return (InterfaceC0978c) c(string).invoke(null, a());
        } catch (ClassNotFoundException e5) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
        } catch (IllegalAccessException e6) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
        } catch (NoSuchMethodException e7) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
        } catch (InvocationTargetException e8) {
            if (e8.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e8.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
        }
    }

    public abstract void i(int i5);

    public final void j(int i5, int i6) {
        i(i6);
        ((C0977b) this).f10462e.writeInt(i5);
    }

    public final void k(Parcelable parcelable, int i5) {
        i(i5);
        ((C0977b) this).f10462e.writeParcelable(parcelable, 0);
    }

    public final void l(InterfaceC0978c interfaceC0978c) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC0978c == null) {
            ((C0977b) this).f10462e.writeString(null);
            return;
        }
        try {
            ((C0977b) this).f10462e.writeString(b(interfaceC0978c.getClass()).getName());
            C0977b c0977bA = a();
            try {
                d(interfaceC0978c.getClass()).invoke(null, interfaceC0978c, c0977bA);
                int i5 = c0977bA.f10464i;
                if (i5 >= 0) {
                    int i6 = c0977bA.f10461d.get(i5);
                    Parcel parcel = c0977bA.f10462e;
                    int iDataPosition = parcel.dataPosition();
                    parcel.setDataPosition(i6);
                    parcel.writeInt(iDataPosition - i6);
                    parcel.setDataPosition(iDataPosition);
                }
            } catch (ClassNotFoundException e5) {
                throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e5);
            } catch (IllegalAccessException e6) {
                throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e6);
            } catch (NoSuchMethodException e7) {
                throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e7);
            } catch (InvocationTargetException e8) {
                if (!(e8.getCause() instanceof RuntimeException)) {
                    throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e8);
                }
                throw ((RuntimeException) e8.getCause());
            }
        } catch (ClassNotFoundException e9) {
            throw new RuntimeException(interfaceC0978c.getClass().getSimpleName().concat(" does not have a Parcelizer"), e9);
        }
    }
}
