package j0;

import android.content.res.AssetManager;
import android.os.Build;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;

/* renamed from: j0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0589b {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f7530a;

    /* renamed from: b, reason: collision with root package name */
    public final InterfaceC0591d f7531b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f7532c;

    /* renamed from: d, reason: collision with root package name */
    public final File f7533d;

    /* renamed from: e, reason: collision with root package name */
    public final String f7534e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f7535f = false;
    public C0590c[] g;
    public byte[] h;

    public C0589b(AssetManager assetManager, Executor executor, InterfaceC0591d interfaceC0591d, String str, File file) {
        this.f7530a = executor;
        this.f7531b = interfaceC0591d;
        this.f7534e = str;
        this.f7533d = file;
        int i5 = Build.VERSION.SDK_INT;
        byte[] bArr = null;
        if (i5 <= 33) {
            switch (i5) {
                case 28:
                case 29:
                case 30:
                    bArr = AbstractC0592e.f7547e;
                    break;
                case 31:
                case 32:
                case 33:
                    bArr = AbstractC0592e.f7546d;
                    break;
            }
        }
        this.f7532c = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e5) {
            String message = e5.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f7531b.m();
            }
            return null;
        }
    }

    public final void b(int i5, Serializable serializable) {
        this.f7530a.execute(new RunnableC0588a(this, i5, serializable, 0));
    }
}
