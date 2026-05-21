package D0;

import android.content.Context;
import java.io.File;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f237a = new a();

    public final File a(Context context) {
        F3.i.f(context, "context");
        File noBackupFilesDir = context.getNoBackupFilesDir();
        F3.i.e(noBackupFilesDir, "context.noBackupFilesDir");
        return noBackupFilesDir;
    }
}
