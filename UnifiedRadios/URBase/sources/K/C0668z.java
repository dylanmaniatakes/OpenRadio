package k;

import android.R;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Shader;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.ProgressBar;
import e.AbstractC0429a;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* renamed from: k.z, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0668z implements Y {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f7910d = {R.attr.indeterminateDrawable, R.attr.progressDrawable};

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7911a;

    /* renamed from: b, reason: collision with root package name */
    public final View f7912b;

    /* renamed from: c, reason: collision with root package name */
    public Object f7913c;

    public C0668z(EditText editText) {
        this.f7911a = 1;
        this.f7912b = editText;
        this.f7913c = new L0.l(editText);
    }

    @Override // k.Y
    public void a(int i5) {
        super/*android.widget.TextView*/.setLastBaselineToBottomHeight(i5);
    }

    @Override // k.Y
    public void b(int i5) {
        super/*android.widget.TextView*/.setFirstBaselineToTopHeight(i5);
    }

    public KeyListener c(KeyListener keyListener) {
        if (!(!(keyListener instanceof NumberKeyListener))) {
            return keyListener;
        }
        ((L0.c) ((L0.l) this.f7913c).f1554d).getClass();
        if (keyListener instanceof Y.e) {
            return keyListener;
        }
        if (keyListener == null) {
            return null;
        }
        return keyListener instanceof NumberKeyListener ? keyListener : new Y.e(keyListener);
    }

    public void d(AttributeSet attributeSet, int i5) {
        switch (this.f7911a) {
            case 0:
                ProgressBar progressBar = (ProgressBar) this.f7912b;
                L0.m mVarK = L0.m.k(progressBar.getContext(), attributeSet, f7910d, i5, 0);
                Drawable drawableI = mVarK.i(0);
                if (drawableI != null) {
                    if (drawableI instanceof AnimationDrawable) {
                        AnimationDrawable animationDrawable = (AnimationDrawable) drawableI;
                        int numberOfFrames = animationDrawable.getNumberOfFrames();
                        AnimationDrawable animationDrawable2 = new AnimationDrawable();
                        animationDrawable2.setOneShot(animationDrawable.isOneShot());
                        for (int i6 = 0; i6 < numberOfFrames; i6++) {
                            Drawable drawableG = g(animationDrawable.getFrame(i6), true);
                            drawableG.setLevel(10000);
                            animationDrawable2.addFrame(drawableG, animationDrawable.getDuration(i6));
                        }
                        animationDrawable2.setLevel(10000);
                        drawableI = animationDrawable2;
                    }
                    progressBar.setIndeterminateDrawable(drawableI);
                }
                Drawable drawableI2 = mVarK.i(1);
                if (drawableI2 != null) {
                    progressBar.setProgressDrawable(g(drawableI2, false));
                }
                mVarK.n();
                return;
            default:
                TypedArray typedArrayObtainStyledAttributes = ((EditText) this.f7912b).getContext().obtainStyledAttributes(attributeSet, AbstractC0429a.f6121i, i5, 0);
                try {
                    boolean z4 = typedArrayObtainStyledAttributes.hasValue(14) ? typedArrayObtainStyledAttributes.getBoolean(14, true) : true;
                    typedArrayObtainStyledAttributes.recycle();
                    f(z4);
                    return;
                } catch (Throwable th) {
                    typedArrayObtainStyledAttributes.recycle();
                    throw th;
                }
        }
    }

    public Y.b e(InputConnection inputConnection, EditorInfo editorInfo) {
        L0.l lVar = (L0.l) this.f7913c;
        if (inputConnection == null) {
            lVar.getClass();
            inputConnection = null;
        } else {
            L0.c cVar = (L0.c) lVar.f1554d;
            cVar.getClass();
            if (!(inputConnection instanceof Y.b)) {
                inputConnection = new Y.b((EditText) cVar.f1536d, inputConnection, editorInfo);
            }
        }
        return (Y.b) inputConnection;
    }

    public void f(boolean z4) {
        Y.i iVar = (Y.i) ((L0.c) ((L0.l) this.f7913c).f1554d).f1537e;
        if (iVar.f2884f != z4) {
            if (iVar.f2883e != null) {
                androidx.emoji2.text.j jVarA = androidx.emoji2.text.j.a();
                Y.h hVar = iVar.f2883e;
                jVarA.getClass();
                h4.f.c(hVar, "initCallback cannot be null");
                ReentrantReadWriteLock reentrantReadWriteLock = jVarA.f3608a;
                reentrantReadWriteLock.writeLock().lock();
                try {
                    jVarA.f3609b.remove(hVar);
                } finally {
                    reentrantReadWriteLock.writeLock().unlock();
                }
            }
            iVar.f2884f = z4;
            if (z4) {
                Y.i.a(iVar.f2881c, androidx.emoji2.text.j.a().b());
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable g(Drawable drawable, boolean z4) {
        if (drawable instanceof F.h) {
            ((F.i) ((F.h) drawable)).getClass();
        } else {
            if (drawable instanceof LayerDrawable) {
                LayerDrawable layerDrawable = (LayerDrawable) drawable;
                int numberOfLayers = layerDrawable.getNumberOfLayers();
                Drawable[] drawableArr = new Drawable[numberOfLayers];
                for (int i5 = 0; i5 < numberOfLayers; i5++) {
                    int id = layerDrawable.getId(i5);
                    drawableArr[i5] = g(layerDrawable.getDrawable(i5), id == 16908301 || id == 16908303);
                }
                LayerDrawable layerDrawable2 = new LayerDrawable(drawableArr);
                for (int i6 = 0; i6 < numberOfLayers; i6++) {
                    layerDrawable2.setId(i6, layerDrawable.getId(i6));
                    layerDrawable2.setLayerGravity(i6, layerDrawable.getLayerGravity(i6));
                    layerDrawable2.setLayerWidth(i6, layerDrawable.getLayerWidth(i6));
                    layerDrawable2.setLayerHeight(i6, layerDrawable.getLayerHeight(i6));
                    layerDrawable2.setLayerInsetLeft(i6, layerDrawable.getLayerInsetLeft(i6));
                    layerDrawable2.setLayerInsetRight(i6, layerDrawable.getLayerInsetRight(i6));
                    layerDrawable2.setLayerInsetTop(i6, layerDrawable.getLayerInsetTop(i6));
                    layerDrawable2.setLayerInsetBottom(i6, layerDrawable.getLayerInsetBottom(i6));
                    layerDrawable2.setLayerInsetStart(i6, layerDrawable.getLayerInsetStart(i6));
                    layerDrawable2.setLayerInsetEnd(i6, layerDrawable.getLayerInsetEnd(i6));
                }
                return layerDrawable2;
            }
            if (drawable instanceof BitmapDrawable) {
                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
                Bitmap bitmap = bitmapDrawable.getBitmap();
                if (((Bitmap) this.f7913c) == null) {
                    this.f7913c = bitmap;
                }
                ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f, 5.0f}, null, null));
                shapeDrawable.getPaint().setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.CLAMP));
                shapeDrawable.getPaint().setColorFilter(bitmapDrawable.getPaint().getColorFilter());
                return z4 ? new ClipDrawable(shapeDrawable, 3, 1) : shapeDrawable;
            }
        }
        return drawable;
    }

    public C0668z(ProgressBar progressBar) {
        this.f7911a = 0;
        this.f7912b = progressBar;
    }

    public C0668z(Z z4) {
        this.f7911a = 2;
        this.f7913c = z4;
        this.f7911a = 2;
        this.f7912b = z4;
    }
}
