package m3;

import android.media.AudioManager;

/* renamed from: m3.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0767c implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ C0768d f8591a;

    public C0767c(C0768d c0768d) {
        this.f8591a = c0768d;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i5) {
        if (i5 == 1) {
            this.f8591a.p();
        }
    }
}
