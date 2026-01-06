package k;

import android.widget.AbsListView;
import java.lang.reflect.Field;

/* renamed from: k.n0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0646n0 {

    /* renamed from: a, reason: collision with root package name */
    public static final Field f7827a;

    static {
        Field declaredField = null;
        try {
            declaredField = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            declaredField.setAccessible(true);
        } catch (NoSuchFieldException e5) {
            e5.printStackTrace();
        }
        f7827a = declaredField;
    }
}
