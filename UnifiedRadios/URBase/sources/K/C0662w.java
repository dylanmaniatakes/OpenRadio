package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.recyclerview.widget.C0255b;
import i3.C0573b;

/* renamed from: k.w, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0662w extends ImageView {

    /* renamed from: c, reason: collision with root package name */
    public final C0255b f7875c;

    /* renamed from: d, reason: collision with root package name */
    public final C0573b f7876d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7877e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0662w(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        V0.a(context);
        this.f7877e = false;
        U0.a(this, getContext());
        C0255b c0255b = new C0255b(this);
        this.f7875c = c0255b;
        c0255b.k(attributeSet, i5);
        C0573b c0573b = new C0573b(this);
        this.f7876d = c0573b;
        c0573b.i(attributeSet, i5);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        C0255b c0255b = this.f7875c;
        if (c0255b != null) {
            c0255b.a();
        }
        C0573b c0573b = this.f7876d;
        if (c0573b != null) {
            c0573b.b();
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        C0255b c0255b = this.f7875c;
        if (c0255b != null) {
            return c0255b.h();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        C0255b c0255b = this.f7875c;
        if (c0255b != null) {
            return c0255b.i();
        }
        return null;
    }

    public ColorStateList getSupportImageTintList() {
        W0 w02;
        C0573b c0573b = this.f7876d;
        if (c0573b == null || (w02 = (W0) c0573b.f7297e) == null) {
            return null;
        }
        return w02.f7724a;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        W0 w02;
        C0573b c0573b = this.f7876d;
        if (c0573b == null || (w02 = (W0) c0573b.f7297e) == null) {
            return null;
        }
        return w02.f7725b;
    }

    @Override // android.widget.ImageView, android.view.View
    public final boolean hasOverlappingRendering() {
        return ((((ImageView) this.f7876d.f7296d).getBackground() instanceof RippleDrawable) ^ true) && super.hasOverlappingRendering();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        C0255b c0255b = this.f7875c;
        if (c0255b != null) {
            c0255b.m();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i5) {
        super.setBackgroundResource(i5);
        C0255b c0255b = this.f7875c;
        if (c0255b != null) {
            c0255b.n(i5);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        C0573b c0573b = this.f7876d;
        if (c0573b != null) {
            c0573b.b();
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        C0573b c0573b = this.f7876d;
        if (c0573b != null && drawable != null && !this.f7877e) {
            c0573b.f7295c = drawable.getLevel();
        }
        super.setImageDrawable(drawable);
        if (c0573b != null) {
            c0573b.b();
            if (this.f7877e) {
                return;
            }
            ImageView imageView = (ImageView) c0573b.f7296d;
            if (imageView.getDrawable() != null) {
                imageView.getDrawable().setLevel(c0573b.f7295c);
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageLevel(int i5) {
        super.setImageLevel(i5);
        this.f7877e = true;
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i5) {
        C0573b c0573b = this.f7876d;
        if (c0573b != null) {
            c0573b.m(i5);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        C0573b c0573b = this.f7876d;
        if (c0573b != null) {
            c0573b.b();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        C0255b c0255b = this.f7875c;
        if (c0255b != null) {
            c0255b.s(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        C0255b c0255b = this.f7875c;
        if (c0255b != null) {
            c0255b.t(mode);
        }
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        C0573b c0573b = this.f7876d;
        if (c0573b != null) {
            if (((W0) c0573b.f7297e) == null) {
                c0573b.f7297e = new W0();
            }
            W0 w02 = (W0) c0573b.f7297e;
            w02.f7724a = colorStateList;
            w02.f7727d = true;
            c0573b.b();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        C0573b c0573b = this.f7876d;
        if (c0573b != null) {
            if (((W0) c0573b.f7297e) == null) {
                c0573b.f7297e = new W0();
            }
            W0 w02 = (W0) c0573b.f7297e;
            w02.f7725b = mode;
            w02.f7726c = true;
            c0573b.b();
        }
    }
}
