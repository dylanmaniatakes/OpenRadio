package g4;

import L.k;
import N1.p;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: c, reason: collision with root package name */
    public static final a f7035c = new a();

    /* renamed from: a, reason: collision with root package name */
    public final LinkedList f7036a = new LinkedList();

    /* renamed from: b, reason: collision with root package name */
    public final ExecutorService f7037b = Executors.newFixedThreadPool(1, new k(1, a.class.getName()));

    public final void a(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        this.f7037b.execute(new p(this, 5, drawable));
    }

    public final Bitmap b(int i5, int i6) {
        synchronized (this.f7036a) {
            try {
                if (this.f7036a.isEmpty()) {
                    return null;
                }
                Iterator it = this.f7036a.iterator();
                while (it.hasNext()) {
                    Bitmap bitmap = (Bitmap) it.next();
                    if (bitmap.isRecycled()) {
                        this.f7036a.remove(bitmap);
                        return b(i5, i6);
                    }
                    if (bitmap.getWidth() == i5 && bitmap.getHeight() == i6) {
                        this.f7036a.remove(bitmap);
                        return bitmap;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
