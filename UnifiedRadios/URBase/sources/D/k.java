package D;

import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    public final ColorStateList f214a;

    /* renamed from: b, reason: collision with root package name */
    public final Configuration f215b;

    /* renamed from: c, reason: collision with root package name */
    public final int f216c;

    public k(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
        this.f214a = colorStateList;
        this.f215b = configuration;
        this.f216c = theme == null ? 0 : theme.hashCode();
    }
}
