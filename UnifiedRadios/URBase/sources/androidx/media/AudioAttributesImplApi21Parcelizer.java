package androidx.media;

import android.media.AudioAttributes;
import y0.AbstractC0976a;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21Parcelizer {
    public static AudioAttributesImplApi21 read(AbstractC0976a abstractC0976a) {
        AudioAttributesImplApi21 audioAttributesImplApi21 = new AudioAttributesImplApi21();
        audioAttributesImplApi21.f3984a = (AudioAttributes) abstractC0976a.g(audioAttributesImplApi21.f3984a, 1);
        audioAttributesImplApi21.f3985b = abstractC0976a.f(audioAttributesImplApi21.f3985b, 2);
        return audioAttributesImplApi21;
    }

    public static void write(AudioAttributesImplApi21 audioAttributesImplApi21, AbstractC0976a abstractC0976a) {
        abstractC0976a.getClass();
        abstractC0976a.k(audioAttributesImplApi21.f3984a, 1);
        abstractC0976a.j(audioAttributesImplApi21.f3985b, 2);
    }
}
