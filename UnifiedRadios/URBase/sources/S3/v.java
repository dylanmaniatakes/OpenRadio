package S3;

import a.AbstractC0203a;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import s3.AbstractC0897g;
import y3.AbstractC0987a;

/* loaded from: classes.dex */
public abstract class v {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2420a = 0;

    static {
        Object objC;
        Object objC2;
        Exception exc = new Exception();
        String simpleName = AbstractC0203a.class.getSimpleName();
        StackTraceElement stackTraceElement = exc.getStackTrace()[0];
        new StackTraceElement("_COROUTINE.".concat(simpleName), "_", stackTraceElement.getFileName(), stackTraceElement.getLineNumber());
        try {
            objC = AbstractC0987a.class.getCanonicalName();
        } catch (Throwable th) {
            objC = AbstractC0399v1.c(th);
        }
        if (AbstractC0897g.a(objC) != null) {
            objC = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        try {
            objC2 = v.class.getCanonicalName();
        } catch (Throwable th2) {
            objC2 = AbstractC0399v1.c(th2);
        }
        if (AbstractC0897g.a(objC2) != null) {
            objC2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
    }
}
