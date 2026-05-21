package Y;

import android.text.Editable;
import androidx.emoji2.text.r;

/* loaded from: classes.dex */
public final class a extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f2865a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile a f2866b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f2867c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f2867c;
        return cls != null ? new r(cls, charSequence) : super.newEditable(charSequence);
    }
}
