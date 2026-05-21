package g3;

import com.unified.ur1.chat.ChatActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f6973j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ l f6974k;

    public /* synthetic */ j(l lVar, int i5) {
        this.f6973j = i5;
        this.f6974k = lVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f6974k;
        int i5 = this.f6973j;
        lVar.getClass();
        switch (i5) {
            case 0:
                int i6 = ChatActivity.f5725L;
                lVar.f6979d.r();
                break;
            default:
                int i7 = ChatActivity.f5725L;
                lVar.f6979d.r();
                break;
        }
    }
}
