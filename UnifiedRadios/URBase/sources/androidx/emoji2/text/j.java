package androidx.emoji2.text;

import J1.C;
import android.os.Handler;
import android.os.Looper;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import m3.C0777m;

/* loaded from: classes.dex */
public final class j {

    /* renamed from: i, reason: collision with root package name */
    public static final Object f3606i = new Object();

    /* renamed from: j, reason: collision with root package name */
    public static volatile j f3607j;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantReadWriteLock f3608a;

    /* renamed from: b, reason: collision with root package name */
    public final q.c f3609b;

    /* renamed from: c, reason: collision with root package name */
    public volatile int f3610c;

    /* renamed from: d, reason: collision with root package name */
    public final Handler f3611d;

    /* renamed from: e, reason: collision with root package name */
    public final e f3612e;

    /* renamed from: f, reason: collision with root package name */
    public final i f3613f;
    public final int g;
    public final c h;

    public j(o oVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f3608a = reentrantReadWriteLock;
        this.f3610c = 3;
        i iVar = (i) oVar.f3604b;
        this.f3613f = iVar;
        int i5 = oVar.f3603a;
        this.g = i5;
        this.h = (c) oVar.f3605c;
        this.f3611d = new Handler(Looper.getMainLooper());
        this.f3609b = new q.c(0);
        e eVar = new e(this);
        this.f3612e = eVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i5 == 0) {
            try {
                this.f3610c = 0;
            } catch (Throwable th) {
                this.f3608a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                iVar.d(new d(eVar));
            } catch (Throwable th2) {
                d(th2);
            }
        }
    }

    public static j a() {
        j jVar;
        synchronized (f3606i) {
            try {
                jVar = f3607j;
                if (!(jVar != null)) {
                    throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
                }
            } finally {
            }
        }
        return jVar;
    }

    public final int b() {
        this.f3608a.readLock().lock();
        try {
            return this.f3610c;
        } finally {
            this.f3608a.readLock().unlock();
        }
    }

    public final void c() {
        if (!(this.g == 1)) {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
        if (b() == 1) {
            return;
        }
        this.f3608a.writeLock().lock();
        try {
            if (this.f3610c == 0) {
                return;
            }
            this.f3610c = 0;
            this.f3608a.writeLock().unlock();
            e eVar = this.f3612e;
            j jVar = (j) eVar.f3600a;
            try {
                jVar.f3613f.d(new d(eVar));
            } catch (Throwable th) {
                jVar.d(th);
            }
        } finally {
            this.f3608a.writeLock().unlock();
        }
    }

    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f3608a.writeLock().lock();
        try {
            this.f3610c = 2;
            arrayList.addAll(this.f3609b);
            this.f3609b.clear();
            this.f3608a.writeLock().unlock();
            this.f3611d.post(new B0.r(arrayList, this.f3610c, th));
        } catch (Throwable th2) {
            this.f3608a.writeLock().unlock();
            throw th2;
        }
    }

    public final void e() {
        ArrayList arrayList = new ArrayList();
        this.f3608a.writeLock().lock();
        try {
            this.f3610c = 1;
            arrayList.addAll(this.f3609b);
            this.f3609b.clear();
            this.f3608a.writeLock().unlock();
            this.f3611d.post(new B0.r(arrayList, this.f3610c, (Throwable) null));
        } catch (Throwable th) {
            this.f3608a.writeLock().unlock();
            throw th;
        }
    }

    public final CharSequence f(CharSequence charSequence, int i5, int i6) {
        int iCharCount;
        s[] sVarArr;
        if (!(b() == 1)) {
            throw new IllegalStateException("Not initialized yet");
        }
        if (i5 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        }
        if (i6 < 0) {
            throw new IllegalArgumentException("end cannot be negative");
        }
        h4.f.a(i5 <= i6, "start should be <= than end");
        t tVar = null;
        if (charSequence == null) {
            return null;
        }
        h4.f.a(i5 <= charSequence.length(), "start should be < than charSequence length");
        h4.f.a(i6 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i5 == i6) {
            return charSequence;
        }
        C0777m c0777m = (C0777m) this.f3612e.f3601b;
        c0777m.getClass();
        boolean z4 = charSequence instanceof r;
        if (z4) {
            ((r) charSequence).a();
        }
        if (z4) {
            tVar = new t((Spannable) charSequence);
        } else {
            try {
                if (charSequence instanceof Spannable) {
                    tVar = new t((Spannable) charSequence);
                } else if ((charSequence instanceof Spanned) && ((Spanned) charSequence).nextSpanTransition(i5 - 1, i6 + 1, s.class) <= i6) {
                    tVar = new t(charSequence);
                }
            } finally {
                if (z4) {
                    ((r) charSequence).b();
                }
            }
        }
        if (tVar != null && (sVarArr = (s[]) tVar.f3643k.getSpans(i5, i6, s.class)) != null && sVarArr.length > 0) {
            for (s sVar : sVarArr) {
                int spanStart = tVar.f3643k.getSpanStart(sVar);
                int spanEnd = tVar.f3643k.getSpanEnd(sVar);
                if (spanStart != i6) {
                    tVar.removeSpan(sVar);
                }
                i5 = Math.min(spanStart, i5);
                i6 = Math.max(spanEnd, i6);
            }
        }
        if (i5 != i6 && i5 < charSequence.length()) {
            m mVar = new m((p) ((L0.i) c0777m.f8621d).f1549e);
            int iCodePointAt = Character.codePointAt(charSequence, i5);
            int i7 = 0;
            t tVar2 = tVar;
            loop1: while (true) {
                iCharCount = i5;
                while (i5 < i6 && i7 < Integer.MAX_VALUE) {
                    int iA = mVar.a(iCodePointAt);
                    if (iA == 1) {
                        iCharCount += Character.charCount(Character.codePointAt(charSequence, iCharCount));
                        if (iCharCount < i6) {
                            iCodePointAt = Character.codePointAt(charSequence, iCharCount);
                        }
                        i5 = iCharCount;
                    } else if (iA == 2) {
                        i5 += Character.charCount(iCodePointAt);
                        if (i5 < i6) {
                            iCodePointAt = Character.codePointAt(charSequence, i5);
                        }
                    } else if (iA == 3) {
                        if (!c0777m.e(charSequence, iCharCount, i5, mVar.f3623d.f3634b)) {
                            if (tVar2 == null) {
                                tVar2 = new t((Spannable) new SpannableString(charSequence));
                            }
                            l lVar = mVar.f3623d.f3634b;
                            ((C) c0777m.f8620c).getClass();
                            tVar2.setSpan(new s(lVar), iCharCount, i5, 33);
                            i7++;
                        }
                    }
                }
                break loop1;
            }
            if (mVar.f3620a == 2 && mVar.f3622c.f3634b != null && ((mVar.f3625f > 1 || mVar.c()) && i7 < Integer.MAX_VALUE && !c0777m.e(charSequence, iCharCount, i5, mVar.f3622c.f3634b))) {
                if (tVar2 == null) {
                    tVar2 = new t(charSequence);
                }
                l lVar2 = mVar.f3622c.f3634b;
                ((C) c0777m.f8620c).getClass();
                tVar2.setSpan(new s(lVar2), iCharCount, i5, 33);
            }
            if (tVar2 != null) {
                Spannable spannable = tVar2.f3643k;
                if (z4) {
                    ((r) charSequence).b();
                }
                return spannable;
            }
            if (!z4) {
                return charSequence;
            }
        } else if (!z4) {
            return charSequence;
        }
        return charSequence;
    }

    public final void g(h hVar) {
        h4.f.c(hVar, "initCallback cannot be null");
        this.f3608a.writeLock().lock();
        try {
            if (this.f3610c == 1 || this.f3610c == 2) {
                this.f3611d.post(new B0.r(Arrays.asList(hVar), this.f3610c, (Throwable) null));
            } else {
                this.f3609b.add(hVar);
            }
            this.f3608a.writeLock().unlock();
        } catch (Throwable th) {
            this.f3608a.writeLock().unlock();
            throw th;
        }
    }
}
