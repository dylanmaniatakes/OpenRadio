package B0;

import android.content.Context;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

/* loaded from: classes.dex */
public final class o extends RecyclerView {

    /* renamed from: M0, reason: collision with root package name */
    public final /* synthetic */ ViewPager2 f112M0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(ViewPager2 viewPager2, Context context) {
        super(context, null);
        this.f112M0 = viewPager2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final CharSequence getAccessibilityClassName() {
        this.f112M0.f4476v.getClass();
        return super.getAccessibilityClassName();
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        ViewPager2 viewPager2 = this.f112M0;
        accessibilityEvent.setFromIndex(viewPager2.f4463f);
        accessibilityEvent.setToIndex(viewPager2.f4463f);
        accessibilityEvent.setSource((ViewPager2) viewPager2.f4476v.f2836f);
        accessibilityEvent.setClassName("androidx.viewpager.widget.ViewPager");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f112M0.f4474t && super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f112M0.f4474t && super.onTouchEvent(motionEvent);
    }
}
