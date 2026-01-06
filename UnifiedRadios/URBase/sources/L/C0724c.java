package l;

import android.os.Handler;
import h4.d;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: l.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0724c extends d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8322a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f8323b = Executors.newFixedThreadPool(4, new ThreadFactoryC0723b());

    /* renamed from: c, reason: collision with root package name */
    public volatile Handler f8324c;
}
