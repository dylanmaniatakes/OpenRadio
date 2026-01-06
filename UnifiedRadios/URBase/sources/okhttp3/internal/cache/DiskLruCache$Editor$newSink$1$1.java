package okhttp3.internal.cache;

import E3.l;
import F3.i;
import F3.j;
import java.io.IOException;
import okhttp3.internal.cache.DiskLruCache;
import s3.C0900j;

/* loaded from: classes.dex */
public final class DiskLruCache$Editor$newSink$1$1 extends j implements l {
    final /* synthetic */ DiskLruCache this$0;
    final /* synthetic */ DiskLruCache.Editor this$1;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiskLruCache$Editor$newSink$1$1(DiskLruCache diskLruCache, DiskLruCache.Editor editor) {
        super(1);
        this.this$0 = diskLruCache;
        this.this$1 = editor;
    }

    @Override // E3.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((IOException) obj);
        return C0900j.f9694a;
    }

    public final void invoke(IOException iOException) {
        i.f(iOException, "it");
        DiskLruCache diskLruCache = this.this$0;
        DiskLruCache.Editor editor = this.this$1;
        synchronized (diskLruCache) {
            editor.detach$okhttp();
        }
    }
}
