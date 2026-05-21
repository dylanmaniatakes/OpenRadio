package B;

import android.app.Notification;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.os.Build;
import androidx.core.graphics.drawable.IconCompat;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;

/* loaded from: classes.dex */
public final class r extends u {

    /* renamed from: d, reason: collision with root package name */
    public IconCompat f60d;

    /* renamed from: e, reason: collision with root package name */
    public IconCompat f61e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f62f;

    @Override // B.u
    public final void h(L0.i iVar) {
        Bitmap bitmap;
        int i5 = Build.VERSION.SDK_INT;
        Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle((Notification.Builder) iVar.f1548d).setBigContentTitle(null);
        IconCompat iconCompat = this.f60d;
        Context context = (Context) iVar.f1547c;
        if (iconCompat != null) {
            if (i5 >= 31) {
                q.a(bigContentTitle, F.d.c(iconCompat, context));
            } else {
                int iC = iconCompat.f3542a;
                if (iC == -1) {
                    iC = F.f.c(iconCompat.f3543b);
                }
                if (iC == 1) {
                    IconCompat iconCompat2 = this.f60d;
                    int i6 = iconCompat2.f3542a;
                    if (i6 == -1) {
                        Object obj = iconCompat2.f3543b;
                        bitmap = obj instanceof Bitmap ? (Bitmap) obj : null;
                    } else if (i6 == 1) {
                        bitmap = (Bitmap) iconCompat2.f3543b;
                    } else {
                        if (i6 != 5) {
                            throw new IllegalStateException("called getBitmap() on " + iconCompat2);
                        }
                        Bitmap bitmap2 = (Bitmap) iconCompat2.f3543b;
                        int iMin = (int) (Math.min(bitmap2.getWidth(), bitmap2.getHeight()) * 0.6666667f);
                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(iMin, iMin, Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(bitmapCreateBitmap);
                        Paint paint = new Paint(3);
                        float f5 = iMin;
                        float f6 = 0.5f * f5;
                        float f7 = 0.9166667f * f6;
                        float f8 = 0.010416667f * f5;
                        paint.setColor(0);
                        paint.setShadowLayer(f8, BitmapDescriptorFactory.HUE_RED, f5 * 0.020833334f, 1023410176);
                        canvas.drawCircle(f6, f6, f7, paint);
                        paint.setShadowLayer(f8, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, 503316480);
                        canvas.drawCircle(f6, f6, f7, paint);
                        paint.clearShadowLayer();
                        paint.setColor(-16777216);
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        BitmapShader bitmapShader = new BitmapShader(bitmap2, tileMode, tileMode);
                        Matrix matrix = new Matrix();
                        matrix.setTranslate((-(bitmap2.getWidth() - iMin)) / 2.0f, (-(bitmap2.getHeight() - iMin)) / 2.0f);
                        bitmapShader.setLocalMatrix(matrix);
                        paint.setShader(bitmapShader);
                        canvas.drawCircle(f6, f6, f7, paint);
                        canvas.setBitmap(null);
                        bitmap = bitmapCreateBitmap;
                    }
                    bigContentTitle = bigContentTitle.bigPicture(bitmap);
                }
            }
        }
        if (this.f62f) {
            IconCompat iconCompat3 = this.f61e;
            if (iconCompat3 == null) {
                o.a(bigContentTitle, null);
            } else {
                p.a(bigContentTitle, F.d.c(iconCompat3, context));
            }
        }
        if (i5 >= 31) {
            q.c(bigContentTitle, false);
            q.b(bigContentTitle, null);
        }
    }

    @Override // B.u
    public final String i() {
        return "androidx.core.app.NotificationCompat$BigPictureStyle";
    }
}
