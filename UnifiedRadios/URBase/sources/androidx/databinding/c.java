package androidx.databinding;

import O.K;
import O.Y;
import android.database.SQLException;
import android.view.View;
import com.unified.ur1.R;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class c implements View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3581c;

    public /* synthetic */ c(int i5) {
        this.f3581c = i5;
    }

    private final void a(View view) {
    }

    private final void b(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) throws InterruptedException, SQLException {
        switch (this.f3581c) {
            case 0:
                (view != null ? (e) view.getTag(R.id.dataBinding) : null).f3585b.run();
                view.removeOnAttachStateChangeListener(this);
                break;
            default:
                view.removeOnAttachStateChangeListener(this);
                WeakHashMap weakHashMap = Y.f1904a;
                K.c(view);
                break;
        }
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        int i5 = this.f3581c;
    }
}
