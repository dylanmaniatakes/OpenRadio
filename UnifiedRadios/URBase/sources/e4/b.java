package e4;

import Z3.i;
import android.content.Context;
import android.os.Environment;
import android.util.Log;
import j4.c;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: k, reason: collision with root package name */
    public File f6231k;

    /* renamed from: l, reason: collision with root package name */
    public File f6232l;

    /* renamed from: a, reason: collision with root package name */
    public String f6223a = "osmdroid";

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6224b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final short f6225c = 9;

    /* renamed from: d, reason: collision with root package name */
    public final short f6226d = 2;

    /* renamed from: e, reason: collision with root package name */
    public final short f6227e = 8;

    /* renamed from: f, reason: collision with root package name */
    public final short f6228f = 40;
    public final short g = 40;
    public final long h = 629145600;

    /* renamed from: i, reason: collision with root package name */
    public final long f6229i = 524288000;

    /* renamed from: j, reason: collision with root package name */
    public final SimpleDateFormat f6230j = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);

    /* renamed from: m, reason: collision with root package name */
    public final int f6233m = 1000;
    public final int n = 500;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f6234o = true;

    /* renamed from: p, reason: collision with root package name */
    public final long f6235p = 300000;

    /* renamed from: q, reason: collision with root package name */
    public final int f6236q = 20;

    /* renamed from: r, reason: collision with root package name */
    public final long f6237r = 500;

    /* renamed from: s, reason: collision with root package name */
    public final boolean f6238s = true;

    public final File a(Context context) throws Throwable {
        try {
            if (this.f6231k == null) {
                c cVarD = i.d(context);
                if (cVarD != null) {
                    File file = new File(cVarD.f7624a, "osmdroid");
                    this.f6231k = file;
                    file.mkdirs();
                } else if (!new File(context.getExternalFilesDir(Environment.DIRECTORY_PICTURES), "osmdroid").mkdirs()) {
                    Log.e("OsmDroid", "Directory not created");
                }
            }
        } catch (Exception e5) {
            Log.d("OsmDroid", "Unable to create base path at " + this.f6231k, e5);
        }
        if (this.f6231k == null && context != null) {
            this.f6231k = context.getFilesDir();
        }
        return this.f6231k;
    }

    public final File b(Context context) {
        if (this.f6232l == null) {
            this.f6232l = new File(a(context), "tiles");
        }
        try {
            this.f6232l.mkdirs();
        } catch (Exception e5) {
            Log.d("OsmDroid", "Unable to create tile cache path at " + this.f6232l, e5);
        }
        return this.f6232l;
    }

    public final boolean c() {
        return this.f6238s;
    }
}
