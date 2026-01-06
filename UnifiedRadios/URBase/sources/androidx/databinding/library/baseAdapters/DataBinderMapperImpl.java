package androidx.databinding.library.baseAdapters;

import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.a;
import androidx.databinding.e;
import com.unified.ur1.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f3593a = new SparseIntArray(0);

    @Override // androidx.databinding.a
    public final List a() {
        return new ArrayList(0);
    }

    @Override // androidx.databinding.a
    public final e b(View view) {
        if (f3593a.get(R.layout.activity_main) <= 0 || view.getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.a
    public final e c(View[] viewArr) {
        if (viewArr.length != 0 && f3593a.get(R.layout.activity_main) > 0 && viewArr[0].getTag() == null) {
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }
}
