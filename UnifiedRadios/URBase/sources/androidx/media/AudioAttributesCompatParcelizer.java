package androidx.media;

import java.lang.reflect.InvocationTargetException;
import y0.AbstractC0976a;
import y0.InterfaceC0978c;

/* loaded from: classes.dex */
public class AudioAttributesCompatParcelizer {
    public static AudioAttributesCompat read(AbstractC0976a abstractC0976a) {
        AudioAttributesCompat audioAttributesCompat = new AudioAttributesCompat();
        InterfaceC0978c interfaceC0978cH = audioAttributesCompat.f3983a;
        if (abstractC0976a.e(1)) {
            interfaceC0978cH = abstractC0976a.h();
        }
        audioAttributesCompat.f3983a = (AudioAttributesImpl) interfaceC0978cH;
        return audioAttributesCompat;
    }

    public static void write(AudioAttributesCompat audioAttributesCompat, AbstractC0976a abstractC0976a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0976a.getClass();
        AudioAttributesImpl audioAttributesImpl = audioAttributesCompat.f3983a;
        abstractC0976a.i(1);
        abstractC0976a.l(audioAttributesImpl);
    }
}
