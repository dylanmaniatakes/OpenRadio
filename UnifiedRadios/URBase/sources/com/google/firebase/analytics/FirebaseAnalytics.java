package com.google.firebase.analytics;

import A2.g;
import B2.a;
import J1.InterfaceC0061d1;
import R2.d;
import R2.e;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.C0294a0;
import com.google.android.gms.internal.measurement.C0354m0;
import com.google.android.gms.internal.measurement.X;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import q1.E;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public final class FirebaseAnalytics {

    /* renamed from: b, reason: collision with root package name */
    public static volatile FirebaseAnalytics f5531b;

    /* renamed from: a, reason: collision with root package name */
    public final C0354m0 f5532a;

    public FirebaseAnalytics(C0354m0 c0354m0) {
        E.i(c0354m0);
        this.f5532a = c0354m0;
    }

    @Keep
    public static FirebaseAnalytics getInstance(Context context) {
        if (f5531b == null) {
            synchronized (FirebaseAnalytics.class) {
                try {
                    if (f5531b == null) {
                        f5531b = new FirebaseAnalytics(C0354m0.c(context, null));
                    }
                } finally {
                }
            }
        }
        return f5531b;
    }

    @Keep
    public static InterfaceC0061d1 getScionFrontendApiImplementation(Context context, Bundle bundle) {
        C0354m0 c0354m0C = C0354m0.c(context, bundle);
        if (c0354m0C == null) {
            return null;
        }
        return new a(c0354m0C);
    }

    @Keep
    public String getFirebaseInstanceId() {
        try {
            Object obj = d.f2284m;
            g gVarB = g.b();
            gVarB.a();
            return (String) AbstractC0930a.b(((d) gVarB.f29d.a(e.class)).c(), 30000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e5) {
            throw new IllegalStateException(e5);
        } catch (ExecutionException e6) {
            throw new IllegalStateException(e6.getCause());
        } catch (TimeoutException unused) {
            throw new IllegalThreadStateException("Firebase Installations getId Task has timed out.");
        }
    }

    @Keep
    @Deprecated
    public void setCurrentScreen(Activity activity, String str, String str2) {
        X xA = X.a(activity);
        C0354m0 c0354m0 = this.f5532a;
        c0354m0.getClass();
        c0354m0.b(new C0294a0(c0354m0, xA, str, str2));
    }
}
