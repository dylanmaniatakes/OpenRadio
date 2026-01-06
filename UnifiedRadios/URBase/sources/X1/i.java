package x1;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
public final class i implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Context f10435c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Intent f10436d;

    public i(Context context, Intent intent) {
        this.f10435c = context;
        this.f10436d = intent;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            this.f10435c.startActivity(this.f10436d);
        } catch (ActivityNotFoundException e5) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e5);
        }
    }
}
