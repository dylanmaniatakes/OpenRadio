package O;

import android.text.TextUtils;
import android.view.View;

/* loaded from: classes.dex */
public final class C extends E {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1884e;

    public C(int i5, Class cls, int i6, int i7, int i8) {
        this.f1884e = i8;
        this.f1889a = i5;
        this.f1892d = cls;
        this.f1891c = i6;
        this.f1890b = i7;
    }

    @Override // O.E
    public final Object b(View view) {
        switch (this.f1884e) {
            case 0:
                return Boolean.valueOf(S.d(view));
            case 1:
                return S.b(view);
            default:
                return Boolean.valueOf(S.c(view));
        }
    }

    @Override // O.E
    public final void c(View view, Object obj) {
        switch (this.f1884e) {
            case 0:
                S.i(view, ((Boolean) obj).booleanValue());
                break;
            case 1:
                S.h(view, (CharSequence) obj);
                break;
            default:
                S.g(view, ((Boolean) obj).booleanValue());
                break;
        }
    }

    @Override // O.E
    public final boolean f(Object obj, Object obj2) {
        switch (this.f1884e) {
            case 0:
                Boolean bool = (Boolean) obj;
                Boolean bool2 = (Boolean) obj2;
                return !((bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue()));
            case 1:
                return !TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
            default:
                Boolean bool3 = (Boolean) obj;
                Boolean bool4 = (Boolean) obj2;
                return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
        }
    }
}
