package o1;

import com.google.android.gms.common.api.Status;

/* loaded from: classes.dex */
public class e extends Exception {

    /* renamed from: j, reason: collision with root package name */
    public final Status f8898j;

    /* JADX WARN: Illegal instructions before constructor call */
    public e(Status status) {
        int i5 = status.f4639j;
        String str = status.f4640k;
        super(i5 + ": " + (str == null ? "" : str));
        this.f8898j = status;
    }
}
