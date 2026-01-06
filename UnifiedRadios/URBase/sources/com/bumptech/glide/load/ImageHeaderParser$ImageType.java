package com.bumptech.glide.load;

import S0.a;

/* loaded from: classes.dex */
public enum ImageHeaderParser$ImageType {
    GIF(true),
    JPEG(false),
    RAW(false),
    PNG_A(true),
    PNG(false),
    WEBP_A(true),
    WEBP(false),
    ANIMATED_WEBP(true),
    AVIF(true),
    UNKNOWN(false);


    /* renamed from: j, reason: collision with root package name */
    public final boolean f4618j;

    ImageHeaderParser$ImageType(boolean z4) {
        this.f4618j = z4;
    }

    public boolean hasAlpha() {
        return this.f4618j;
    }

    public boolean isWebp() {
        int i5 = a.f2352a[ordinal()];
        return i5 == 1 || i5 == 2 || i5 == 3;
    }
}
