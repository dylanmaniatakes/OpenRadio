package x1;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.util.LinkedList;
import n1.C0788e;
import n1.C0789f;
import q1.r;

/* renamed from: x1.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0960a {
    private InterfaceC0962c zaa;
    private Bundle zab;
    private LinkedList zac;
    private final InterfaceC0964e zad = new B0.l(25, this);

    public static void showGooglePlayUnavailableMessage(FrameLayout frameLayout) {
        C0788e c0788e = C0788e.f8738d;
        Context context = frameLayout.getContext();
        int iC = c0788e.c(context, C0789f.f8739a);
        String strC = r.c(context, iC);
        String strB = r.b(context, iC);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(strC);
        linearLayout.addView(textView);
        Intent intentA = c0788e.a(iC, context, null);
        if (intentA != null) {
            Button button = new Button(context);
            button.setId(R.id.button1);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(strB);
            linearLayout.addView(button);
            button.setOnClickListener(new i(context, intentA));
        }
    }

    public final void a(int i5) {
        while (!this.zac.isEmpty() && ((k) this.zac.getLast()).a() >= i5) {
            this.zac.removeLast();
        }
    }

    public final void b(Bundle bundle, k kVar) {
        if (this.zaa != null) {
            kVar.b();
            return;
        }
        if (this.zac == null) {
            this.zac = new LinkedList();
        }
        this.zac.add(kVar);
        if (bundle != null) {
            Bundle bundle2 = this.zab;
            if (bundle2 == null) {
                this.zab = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        createDelegate(this.zad);
    }

    public abstract void createDelegate(InterfaceC0964e interfaceC0964e);

    public InterfaceC0962c getDelegate() {
        return this.zaa;
    }

    public void handleGooglePlayUnavailable(FrameLayout frameLayout) {
        showGooglePlayUnavailableMessage(frameLayout);
    }

    public void onCreate(Bundle bundle) {
        b(bundle, new g(this, bundle));
    }

    @ResultIgnorabilityUnspecified
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        b(bundle, new h(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.zaa == null) {
            handleGooglePlayUnavailable(frameLayout);
        }
        return frameLayout;
    }

    public void onDestroy() {
        InterfaceC0962c interfaceC0962c = this.zaa;
        if (interfaceC0962c != null) {
            interfaceC0962c.onDestroy();
        } else {
            a(1);
        }
    }

    public void onDestroyView() {
        InterfaceC0962c interfaceC0962c = this.zaa;
        if (interfaceC0962c != null) {
            interfaceC0962c.onDestroyView();
        } else {
            a(2);
        }
    }

    public void onInflate(Activity activity, Bundle bundle, Bundle bundle2) {
        b(bundle2, new C0965f(this, activity, bundle, bundle2));
    }

    public void onLowMemory() {
        InterfaceC0962c interfaceC0962c = this.zaa;
        if (interfaceC0962c != null) {
            interfaceC0962c.onLowMemory();
        }
    }

    public void onPause() {
        InterfaceC0962c interfaceC0962c = this.zaa;
        if (interfaceC0962c != null) {
            interfaceC0962c.onPause();
        } else {
            a(5);
        }
    }

    public void onResume() {
        b(null, new j(this, 1));
    }

    public void onSaveInstanceState(Bundle bundle) {
        InterfaceC0962c interfaceC0962c = this.zaa;
        if (interfaceC0962c != null) {
            interfaceC0962c.onSaveInstanceState(bundle);
            return;
        }
        Bundle bundle2 = this.zab;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void onStart() {
        b(null, new j(this, 0));
    }

    public void onStop() {
        InterfaceC0962c interfaceC0962c = this.zaa;
        if (interfaceC0962c != null) {
            interfaceC0962c.onStop();
        } else {
            a(4);
        }
    }
}
