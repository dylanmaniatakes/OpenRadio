package androidx.databinding;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final DataBinderMapperImpl f3580a = new DataBinderMapperImpl();

    public static e a(Activity activity) {
        activity.setContentView(R.layout.activity_main);
        ViewGroup viewGroup = (ViewGroup) activity.getWindow().getDecorView().findViewById(android.R.id.content);
        int childCount = viewGroup.getChildCount();
        DataBinderMapperImpl dataBinderMapperImpl = f3580a;
        if (childCount == 1) {
            return dataBinderMapperImpl.b(viewGroup.getChildAt(childCount - 1));
        }
        View[] viewArr = new View[childCount];
        for (int i5 = 0; i5 < childCount; i5++) {
            viewArr[i5] = viewGroup.getChildAt(i5);
        }
        return dataBinderMapperImpl.c(viewArr);
    }
}
