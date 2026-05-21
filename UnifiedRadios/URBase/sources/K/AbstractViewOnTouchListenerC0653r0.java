package k;

import android.view.View;
import android.view.ViewConfiguration;

/* renamed from: k.r0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractViewOnTouchListenerC0653r0 implements View.OnTouchListener, View.OnAttachStateChangeListener {

    /* renamed from: c, reason: collision with root package name */
    public final float f7856c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7857d;

    /* renamed from: e, reason: collision with root package name */
    public final int f7858e;

    /* renamed from: f, reason: collision with root package name */
    public final View f7859f;
    public RunnableC0652q0 g;
    public RunnableC0652q0 h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f7860i;

    /* renamed from: j, reason: collision with root package name */
    public int f7861j;

    /* renamed from: k, reason: collision with root package name */
    public final int[] f7862k = new int[2];

    public AbstractViewOnTouchListenerC0653r0(View view) {
        this.f7859f = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f7856c = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        int tapTimeout = ViewConfiguration.getTapTimeout();
        this.f7857d = tapTimeout;
        this.f7858e = (ViewConfiguration.getLongPressTimeout() + tapTimeout) / 2;
    }

    public final void a() {
        RunnableC0652q0 runnableC0652q0 = this.h;
        View view = this.f7859f;
        if (runnableC0652q0 != null) {
            view.removeCallbacks(runnableC0652q0);
        }
        RunnableC0652q0 runnableC0652q02 = this.g;
        if (runnableC0652q02 != null) {
            view.removeCallbacks(runnableC0652q02);
        }
    }

    public abstract j.D b();

    public abstract boolean c();

    public boolean d() {
        j.D dB = b();
        if (dB == null || !dB.b()) {
            return true;
        }
        dB.dismiss();
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0100  */
    @Override // android.view.View.OnTouchListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouch(android.view.View r13, android.view.MotionEvent r14) throws java.lang.IllegalAccessException, java.lang.InterruptedException, android.database.SQLException, java.lang.IllegalArgumentException {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: k.AbstractViewOnTouchListenerC0653r0.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        this.f7860i = false;
        this.f7861j = -1;
        RunnableC0652q0 runnableC0652q0 = this.g;
        if (runnableC0652q0 != null) {
            this.f7859f.removeCallbacks(runnableC0652q0);
        }
    }
}
