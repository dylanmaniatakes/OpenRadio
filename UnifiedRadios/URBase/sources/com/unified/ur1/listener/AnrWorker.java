package com.unified.ur1.listener;

import C0.h;
import C0.p;
import C0.q;
import C0.r;
import android.content.Context;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

/* loaded from: classes.dex */
public class AnrWorker extends Worker {
    public AnrWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    @Override // androidx.work.Worker
    public final r f() throws InterruptedException {
        try {
            Thread.sleep(500L);
            return new q(h.f157c);
        } catch (Exception unused) {
            return new p();
        }
    }
}
