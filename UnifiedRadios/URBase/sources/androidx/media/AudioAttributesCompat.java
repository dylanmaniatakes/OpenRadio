package androidx.media;

import android.util.SparseIntArray;
import y0.InterfaceC0978c;

/* loaded from: classes.dex */
public class AudioAttributesCompat implements InterfaceC0978c {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f3982b = 0;

    /* renamed from: a, reason: collision with root package name */
    public AudioAttributesImpl f3983a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sparseIntArray.put(5, 1);
        sparseIntArray.put(6, 2);
        sparseIntArray.put(7, 2);
        sparseIntArray.put(8, 1);
        sparseIntArray.put(9, 1);
        sparseIntArray.put(10, 1);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof AudioAttributesCompat)) {
            return false;
        }
        AudioAttributesCompat audioAttributesCompat = (AudioAttributesCompat) obj;
        AudioAttributesImpl audioAttributesImpl = this.f3983a;
        return audioAttributesImpl == null ? audioAttributesCompat.f3983a == null : audioAttributesImpl.equals(audioAttributesCompat.f3983a);
    }

    public final int hashCode() {
        return this.f3983a.hashCode();
    }

    public final String toString() {
        return this.f3983a.toString();
    }
}
