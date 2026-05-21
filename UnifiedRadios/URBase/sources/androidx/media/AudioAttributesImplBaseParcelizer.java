package androidx.media;

import y0.AbstractC0976a;

/* loaded from: classes.dex */
public class AudioAttributesImplBaseParcelizer {
    public static AudioAttributesImplBase read(AbstractC0976a abstractC0976a) {
        AudioAttributesImplBase audioAttributesImplBase = new AudioAttributesImplBase();
        audioAttributesImplBase.f3986a = abstractC0976a.f(audioAttributesImplBase.f3986a, 1);
        audioAttributesImplBase.f3987b = abstractC0976a.f(audioAttributesImplBase.f3987b, 2);
        audioAttributesImplBase.f3988c = abstractC0976a.f(audioAttributesImplBase.f3988c, 3);
        audioAttributesImplBase.f3989d = abstractC0976a.f(audioAttributesImplBase.f3989d, 4);
        return audioAttributesImplBase;
    }

    public static void write(AudioAttributesImplBase audioAttributesImplBase, AbstractC0976a abstractC0976a) {
        abstractC0976a.getClass();
        abstractC0976a.j(audioAttributesImplBase.f3986a, 1);
        abstractC0976a.j(audioAttributesImplBase.f3987b, 2);
        abstractC0976a.j(audioAttributesImplBase.f3988c, 3);
        abstractC0976a.j(audioAttributesImplBase.f3989d, 4);
    }
}
