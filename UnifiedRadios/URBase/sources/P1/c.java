package P1;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Property;
import android.widget.ImageView;

/* loaded from: classes.dex */
public final class c extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2070a = 0;

    /* renamed from: b, reason: collision with root package name */
    public Object f2071b;

    public /* synthetic */ c(String str, Class cls) {
        super(cls, str);
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f2070a) {
            case 0:
                Matrix matrix = (Matrix) this.f2071b;
                matrix.set(((ImageView) obj).getImageMatrix());
                return matrix;
            default:
                ((Drawable) obj).copyBounds((Rect) this.f2071b);
                return new PointF(r0.left, r0.top);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f2070a) {
            case 0:
                ((ImageView) obj).setImageMatrix((Matrix) obj2);
                break;
            default:
                Drawable drawable = (Drawable) obj;
                PointF pointF = (PointF) obj2;
                Rect rect = (Rect) this.f2071b;
                drawable.copyBounds(rect);
                rect.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
                drawable.setBounds(rect);
                break;
        }
    }

    public c() {
        super(Matrix.class, "imageMatrixProperty");
        this.f2071b = new Matrix();
    }
}
