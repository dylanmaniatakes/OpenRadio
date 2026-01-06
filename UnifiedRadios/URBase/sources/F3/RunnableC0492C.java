package f3;

import android.content.Context;
import com.unified.ur1.adapters.MemoryChannelActivity;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: f3.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0492C implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6547j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ L0.s f6548k;

    public /* synthetic */ RunnableC0492C(L0.s sVar, int i5) {
        this.f6547j = i5;
        this.f6548k = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        L0.s sVar = this.f6548k;
        switch (this.f6547j) {
            case 0:
                int i5 = MemoryChannelActivity.f5681l;
                sVar.A();
                break;
            case 1:
                int i6 = MemoryChannelActivity.f5681l;
                sVar.y();
                break;
            case 2:
                sVar.A();
                break;
            case 3:
                sVar.y();
                break;
            case 4:
                Context context = LaunchActivity.f5853D1;
                sVar.y();
                break;
            default:
                Context context2 = LaunchActivity.f5853D1;
                sVar.A();
                break;
        }
    }
}
