package com.unified.ur1.rfmodule;

import F3.i;
import android.content.Context;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import l0.AbstractC0737m;
import l0.C0736l;
import m3.C0777m;
import w1.AbstractC0930a;

/* loaded from: classes.dex */
public abstract class DmrDatabase extends AbstractC0737m {

    /* renamed from: k, reason: collision with root package name */
    public static volatile DmrDatabase f6050k;

    public static synchronized DmrDatabase q(Context context) {
        try {
            if (f6050k == null) {
                C0736l c0736lH = AbstractC0930a.h(context.getApplicationContext(), DmrDatabase.class, "dmr_database");
                ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
                i.f(executorServiceNewSingleThreadExecutor, "executor");
                c0736lH.g = executorServiceNewSingleThreadExecutor;
                c0736lH.f8359j = true;
                c0736lH.f8361l = false;
                c0736lH.f8362m = true;
                f6050k = (DmrDatabase) c0736lH.b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6050k;
    }

    public abstract C0777m r();
}
