package f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.unified.ur1.R;
import e.AbstractC0429a;
import e0.HandlerC0430a;
import java.lang.ref.WeakReference;

/* renamed from: f.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0468e {

    /* renamed from: A, reason: collision with root package name */
    public TextView f6307A;

    /* renamed from: B, reason: collision with root package name */
    public TextView f6308B;

    /* renamed from: C, reason: collision with root package name */
    public View f6309C;

    /* renamed from: D, reason: collision with root package name */
    public ListAdapter f6310D;

    /* renamed from: F, reason: collision with root package name */
    public final int f6312F;

    /* renamed from: G, reason: collision with root package name */
    public final int f6313G;

    /* renamed from: H, reason: collision with root package name */
    public final int f6314H;
    public final int I;

    /* renamed from: J, reason: collision with root package name */
    public final boolean f6315J;

    /* renamed from: K, reason: collision with root package name */
    public final HandlerC0430a f6316K;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6318a;

    /* renamed from: b, reason: collision with root package name */
    public final DialogC0469f f6319b;

    /* renamed from: c, reason: collision with root package name */
    public final Window f6320c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6321d;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f6322e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f6323f;
    public AlertController$RecycleListView g;
    public View h;

    /* renamed from: i, reason: collision with root package name */
    public int f6324i;

    /* renamed from: k, reason: collision with root package name */
    public Button f6326k;

    /* renamed from: l, reason: collision with root package name */
    public CharSequence f6327l;

    /* renamed from: m, reason: collision with root package name */
    public Message f6328m;
    public Drawable n;

    /* renamed from: o, reason: collision with root package name */
    public Button f6329o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f6330p;

    /* renamed from: q, reason: collision with root package name */
    public Message f6331q;

    /* renamed from: r, reason: collision with root package name */
    public Drawable f6332r;

    /* renamed from: s, reason: collision with root package name */
    public Button f6333s;

    /* renamed from: t, reason: collision with root package name */
    public CharSequence f6334t;

    /* renamed from: u, reason: collision with root package name */
    public Message f6335u;

    /* renamed from: v, reason: collision with root package name */
    public Drawable f6336v;

    /* renamed from: w, reason: collision with root package name */
    public NestedScrollView f6337w;

    /* renamed from: y, reason: collision with root package name */
    public Drawable f6339y;

    /* renamed from: z, reason: collision with root package name */
    public ImageView f6340z;

    /* renamed from: j, reason: collision with root package name */
    public boolean f6325j = false;

    /* renamed from: x, reason: collision with root package name */
    public int f6338x = 0;

    /* renamed from: E, reason: collision with root package name */
    public int f6311E = -1;

    /* renamed from: L, reason: collision with root package name */
    public final com.google.android.material.datepicker.j f6317L = new com.google.android.material.datepicker.j(1, this);

    public C0468e(Context context, DialogC0469f dialogC0469f, Window window) {
        this.f6318a = context;
        this.f6319b = dialogC0469f;
        this.f6320c = window;
        HandlerC0430a handlerC0430a = new HandlerC0430a();
        handlerC0430a.f6139b = new WeakReference(dialogC0469f);
        this.f6316K = handlerC0430a;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, AbstractC0429a.f6119e, R.attr.alertDialogStyle, 0);
        this.f6312F = typedArrayObtainStyledAttributes.getResourceId(0, 0);
        typedArrayObtainStyledAttributes.getResourceId(2, 0);
        this.f6313G = typedArrayObtainStyledAttributes.getResourceId(4, 0);
        typedArrayObtainStyledAttributes.getResourceId(5, 0);
        this.f6314H = typedArrayObtainStyledAttributes.getResourceId(7, 0);
        this.I = typedArrayObtainStyledAttributes.getResourceId(3, 0);
        this.f6315J = typedArrayObtainStyledAttributes.getBoolean(6, true);
        this.f6321d = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
        typedArrayObtainStyledAttributes.recycle();
        dialogC0469f.b().i(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static ViewGroup b(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void c(int i5, String str, DialogInterface.OnClickListener onClickListener) {
        Message messageObtainMessage = onClickListener != null ? this.f6316K.obtainMessage(i5, onClickListener) : null;
        if (i5 == -3) {
            this.f6334t = str;
            this.f6335u = messageObtainMessage;
            this.f6336v = null;
        } else if (i5 == -2) {
            this.f6330p = str;
            this.f6331q = messageObtainMessage;
            this.f6332r = null;
        } else {
            if (i5 != -1) {
                throw new IllegalArgumentException("Button does not exist");
            }
            this.f6327l = str;
            this.f6328m = messageObtainMessage;
            this.n = null;
        }
    }
}
