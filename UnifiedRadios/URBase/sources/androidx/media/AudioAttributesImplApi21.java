package androidx.media;

import android.media.AudioAttributes;

/* loaded from: classes.dex */
public class AudioAttributesImplApi21 implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributes f3984a;

    /* renamed from: b, reason: collision with root package name */
    public int f3985b = -1;

    public final boolean equals(Object obj) {
        if (obj instanceof AudioAttributesImplApi21) {
            return this.f3984a.equals(((AudioAttributesImplApi21) obj).f3984a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f3984a.hashCode();
    }

    public final String toString() {
        return "AudioAttributesCompat: audioattributes=" + this.f3984a;
    }
}
