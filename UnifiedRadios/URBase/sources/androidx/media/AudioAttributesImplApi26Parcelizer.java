package androidx.media;

import android.media.AudioAttributes;
import y0.AbstractC0976a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi26Parcelizer {
    public static AudioAttributesImplApi26 read(AbstractC0976a abstractC0976a) {
        AudioAttributesImplApi26 audioAttributesImplApi26 = new AudioAttributesImplApi26();
        audioAttributesImplApi26.f3984a = (AudioAttributes) abstractC0976a.g(audioAttributesImplApi26.f3984a, 1);
        audioAttributesImplApi26.f3985b = abstractC0976a.f(audioAttributesImplApi26.f3985b, 2);
        return audioAttributesImplApi26;
    }

    public static void write(AudioAttributesImplApi26 audioAttributesImplApi26, AbstractC0976a abstractC0976a) {
        abstractC0976a.getClass();
        abstractC0976a.k(audioAttributesImplApi26.f3984a, 1);
        abstractC0976a.j(audioAttributesImplApi26.f3985b, 2);
    }
}
