package p3;

import android.media.AudioManager;
import android.util.Log;
import g0.AbstractC0535a;

/* renamed from: p3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0835a implements AudioManager.OnAudioFocusChangeListener {
    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i5) {
        AbstractC0535a.u("Audio focus changed: ", i5, "DMR_TX");
        if (i5 == -1) {
            Log.w("DMR_TX", "Audio focus lost but continuing transmission");
        }
    }
}
