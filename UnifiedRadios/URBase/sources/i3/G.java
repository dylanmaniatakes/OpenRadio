package i3;

import android.util.Log;
import com.unified.ur1.inbox.UnifiedInboxActivity;

/* loaded from: classes.dex */
public final /* synthetic */ class G implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f7287j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ UnifiedInboxActivity f7288k;

    public /* synthetic */ G(UnifiedInboxActivity unifiedInboxActivity, int i5) {
        this.f7287j = i5;
        this.f7288k = unifiedInboxActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5 = 1;
        UnifiedInboxActivity unifiedInboxActivity = this.f7288k;
        switch (this.f7287j) {
            case 0:
                int i6 = UnifiedInboxActivity.f5830m;
                unifiedInboxActivity.getClass();
                Log.d("UnifiedInbox", "Creating SentFragment by navigating to position 1");
                unifiedInboxActivity.f5832d.b(1, false);
                unifiedInboxActivity.f5832d.postDelayed(new G(unifiedInboxActivity, i5), 200L);
                break;
            case 1:
                int i7 = UnifiedInboxActivity.f5830m;
                unifiedInboxActivity.getClass();
                Log.d("UnifiedInbox", "Going back to inbox (position 0)");
                unifiedInboxActivity.f5832d.b(0, false);
                unifiedInboxActivity.f5832d.postDelayed(new G(unifiedInboxActivity, 2), 200L);
                break;
            default:
                int i8 = UnifiedInboxActivity.f5830m;
                unifiedInboxActivity.getClass();
                Log.d("UnifiedInbox", "Both fragments should now be created, setting up listeners");
                try {
                    y yVar = unifiedInboxActivity.f5834f;
                    if (yVar != null) {
                        m mVarH = yVar.h();
                        if (mVarH != null) {
                            Log.d("UnifiedInbox", "Setting listener for InboxFragment");
                            mVarH.f7320i = unifiedInboxActivity;
                            if (mVarH.g != null) {
                                Log.d("MessageAdapter", "Current user callsign updated to: " + unifiedInboxActivity.f5836j);
                            }
                            mVarH.i();
                        } else {
                            Log.w("UnifiedInbox", "InboxFragment is null, will retry");
                        }
                        unifiedInboxActivity.q(0);
                        break;
                    } else {
                        Log.e("UnifiedInbox", "PagerAdapter is null when setting listeners");
                        break;
                    }
                } catch (Exception e5) {
                    Log.e("UnifiedInbox", "Error setting fragment listeners", e5);
                }
        }
    }
}
