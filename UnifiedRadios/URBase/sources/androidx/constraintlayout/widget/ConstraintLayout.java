package androidx.constraintlayout.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.PinConfig;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import okhttp3.internal.ws.WebSocketProtocol;
import org.conscrypt.FileClientSessionCache;
import org.xmlpull.v1.XmlPullParserException;
import s.C0880c;
import u.d;
import u.e;
import u.h;
import x.c;
import x.f;
import x.n;
import x.o;
import x.p;
import x.r;
import x.s;

/* loaded from: classes.dex */
public class ConstraintLayout extends ViewGroup {

    /* renamed from: t, reason: collision with root package name */
    public static s f3495t;

    /* renamed from: c, reason: collision with root package name */
    public final SparseArray f3496c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f3497d;

    /* renamed from: e, reason: collision with root package name */
    public final e f3498e;

    /* renamed from: f, reason: collision with root package name */
    public int f3499f;
    public int g;
    public int h;

    /* renamed from: i, reason: collision with root package name */
    public int f3500i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f3501j;

    /* renamed from: k, reason: collision with root package name */
    public int f3502k;

    /* renamed from: l, reason: collision with root package name */
    public n f3503l;

    /* renamed from: m, reason: collision with root package name */
    public L0.s f3504m;
    public int n;

    /* renamed from: o, reason: collision with root package name */
    public HashMap f3505o;

    /* renamed from: p, reason: collision with root package name */
    public final SparseArray f3506p;

    /* renamed from: q, reason: collision with root package name */
    public final f f3507q;

    /* renamed from: r, reason: collision with root package name */
    public int f3508r;

    /* renamed from: s, reason: collision with root package name */
    public int f3509s;

    public ConstraintLayout(Context context) throws XmlPullParserException, IOException, NumberFormatException {
        super(context);
        this.f3496c = new SparseArray();
        this.f3497d = new ArrayList(4);
        this.f3498e = new e();
        this.f3499f = 0;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.f3500i = Integer.MAX_VALUE;
        this.f3501j = true;
        this.f3502k = 257;
        this.f3503l = null;
        this.f3504m = null;
        this.n = -1;
        this.f3505o = new HashMap();
        this.f3506p = new SparseArray();
        this.f3507q = new f(this, this);
        this.f3508r = 0;
        this.f3509s = 0;
        i(null, 0, 0);
    }

    public static x.e g() {
        x.e eVar = new x.e(-2, -2);
        eVar.f10184a = -1;
        eVar.f10186b = -1;
        eVar.f10188c = -1.0f;
        eVar.f10190d = true;
        eVar.f10192e = -1;
        eVar.f10194f = -1;
        eVar.g = -1;
        eVar.h = -1;
        eVar.f10198i = -1;
        eVar.f10200j = -1;
        eVar.f10202k = -1;
        eVar.f10204l = -1;
        eVar.f10206m = -1;
        eVar.n = -1;
        eVar.f10209o = -1;
        eVar.f10211p = -1;
        eVar.f10213q = 0;
        eVar.f10214r = BitmapDescriptorFactory.HUE_RED;
        eVar.f10215s = -1;
        eVar.f10216t = -1;
        eVar.f10217u = -1;
        eVar.f10218v = -1;
        eVar.f10219w = Integer.MIN_VALUE;
        eVar.f10220x = Integer.MIN_VALUE;
        eVar.f10221y = Integer.MIN_VALUE;
        eVar.f10222z = Integer.MIN_VALUE;
        eVar.f10159A = Integer.MIN_VALUE;
        eVar.f10160B = Integer.MIN_VALUE;
        eVar.f10161C = Integer.MIN_VALUE;
        eVar.f10162D = 0;
        eVar.f10163E = 0.5f;
        eVar.f10164F = 0.5f;
        eVar.f10165G = null;
        eVar.f10166H = -1.0f;
        eVar.I = -1.0f;
        eVar.f10167J = 0;
        eVar.f10168K = 0;
        eVar.f10169L = 0;
        eVar.f10170M = 0;
        eVar.f10171N = 0;
        eVar.f10172O = 0;
        eVar.f10173P = 0;
        eVar.f10174Q = 0;
        eVar.f10175R = 1.0f;
        eVar.f10176S = 1.0f;
        eVar.f10177T = -1;
        eVar.f10178U = -1;
        eVar.f10179V = -1;
        eVar.f10180W = false;
        eVar.f10181X = false;
        eVar.f10182Y = null;
        eVar.f10183Z = 0;
        eVar.f10185a0 = true;
        eVar.f10187b0 = true;
        eVar.f10189c0 = false;
        eVar.f10191d0 = false;
        eVar.f10193e0 = false;
        eVar.f10195f0 = -1;
        eVar.f10196g0 = -1;
        eVar.f10197h0 = -1;
        eVar.f10199i0 = -1;
        eVar.f10201j0 = Integer.MIN_VALUE;
        eVar.f10203k0 = Integer.MIN_VALUE;
        eVar.f10205l0 = 0.5f;
        eVar.f10212p0 = new d();
        return eVar;
    }

    private int getPaddingWidth() {
        int iMax = Math.max(0, getPaddingRight()) + Math.max(0, getPaddingLeft());
        int iMax2 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        return iMax2 > 0 ? iMax2 : iMax;
    }

    public static s getSharedValues() {
        if (f3495t == null) {
            s sVar = new s();
            new SparseIntArray();
            new HashMap();
            f3495t = sVar;
        }
        return f3495t;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof x.e;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) throws NumberFormatException {
        Object tag;
        int size;
        ArrayList arrayList = this.f3497d;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i5 = 0; i5 < size; i5++) {
                ((c) arrayList.get(i5)).getClass();
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = getWidth();
            float height = getHeight();
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt.getVisibility() != 8 && (tag = childAt.getTag()) != null && (tag instanceof String)) {
                    String[] strArrSplit = ((String) tag).split(",");
                    if (strArrSplit.length == 4) {
                        int i7 = Integer.parseInt(strArrSplit[0]);
                        int i8 = Integer.parseInt(strArrSplit[1]);
                        int i9 = Integer.parseInt(strArrSplit[2]);
                        int i10 = (int) ((i7 / 1080.0f) * width);
                        int i11 = (int) ((i8 / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f5 = i10;
                        float f6 = i11;
                        float f7 = i10 + ((int) ((i9 / 1080.0f) * width));
                        canvas.drawLine(f5, f6, f7, f6, paint);
                        float f8 = i11 + ((int) ((Integer.parseInt(strArrSplit[3]) / 1920.0f) * height));
                        canvas.drawLine(f7, f6, f7, f8, paint);
                        canvas.drawLine(f7, f8, f5, f8, paint);
                        canvas.drawLine(f5, f8, f5, f6, paint);
                        paint.setColor(-16711936);
                        canvas.drawLine(f5, f6, f7, f8, paint);
                        canvas.drawLine(f5, f8, f7, f6, paint);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final void forceLayout() {
        this.f3501j = true;
        super.forceLayout();
    }

    @Override // android.view.ViewGroup
    public final /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return g();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        x.e eVar = new x.e(context, attributeSet);
        eVar.f10184a = -1;
        eVar.f10186b = -1;
        eVar.f10188c = -1.0f;
        eVar.f10190d = true;
        eVar.f10192e = -1;
        eVar.f10194f = -1;
        eVar.g = -1;
        eVar.h = -1;
        eVar.f10198i = -1;
        eVar.f10200j = -1;
        eVar.f10202k = -1;
        eVar.f10204l = -1;
        eVar.f10206m = -1;
        eVar.n = -1;
        eVar.f10209o = -1;
        eVar.f10211p = -1;
        eVar.f10213q = 0;
        eVar.f10214r = BitmapDescriptorFactory.HUE_RED;
        eVar.f10215s = -1;
        eVar.f10216t = -1;
        eVar.f10217u = -1;
        eVar.f10218v = -1;
        eVar.f10219w = Integer.MIN_VALUE;
        eVar.f10220x = Integer.MIN_VALUE;
        eVar.f10221y = Integer.MIN_VALUE;
        eVar.f10222z = Integer.MIN_VALUE;
        eVar.f10159A = Integer.MIN_VALUE;
        eVar.f10160B = Integer.MIN_VALUE;
        eVar.f10161C = Integer.MIN_VALUE;
        eVar.f10162D = 0;
        eVar.f10163E = 0.5f;
        eVar.f10164F = 0.5f;
        eVar.f10165G = null;
        eVar.f10166H = -1.0f;
        eVar.I = -1.0f;
        eVar.f10167J = 0;
        eVar.f10168K = 0;
        eVar.f10169L = 0;
        eVar.f10170M = 0;
        eVar.f10171N = 0;
        eVar.f10172O = 0;
        eVar.f10173P = 0;
        eVar.f10174Q = 0;
        eVar.f10175R = 1.0f;
        eVar.f10176S = 1.0f;
        eVar.f10177T = -1;
        eVar.f10178U = -1;
        eVar.f10179V = -1;
        eVar.f10180W = false;
        eVar.f10181X = false;
        eVar.f10182Y = null;
        eVar.f10183Z = 0;
        eVar.f10185a0 = true;
        eVar.f10187b0 = true;
        eVar.f10189c0 = false;
        eVar.f10191d0 = false;
        eVar.f10193e0 = false;
        eVar.f10195f0 = -1;
        eVar.f10196g0 = -1;
        eVar.f10197h0 = -1;
        eVar.f10199i0 = -1;
        eVar.f10201j0 = Integer.MIN_VALUE;
        eVar.f10203k0 = Integer.MIN_VALUE;
        eVar.f10205l0 = 0.5f;
        eVar.f10212p0 = new d();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, r.f10345b);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        for (int i5 = 0; i5 < indexCount; i5++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i5);
            int i6 = x.d.f10158a.get(index);
            switch (i6) {
                case 1:
                    eVar.f10179V = typedArrayObtainStyledAttributes.getInt(index, eVar.f10179V);
                    break;
                case 2:
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10211p);
                    eVar.f10211p = resourceId;
                    if (resourceId == -1) {
                        eVar.f10211p = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 3:
                    eVar.f10213q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10213q);
                    break;
                case 4:
                    float f5 = typedArrayObtainStyledAttributes.getFloat(index, eVar.f10214r) % 360.0f;
                    eVar.f10214r = f5;
                    if (f5 < BitmapDescriptorFactory.HUE_RED) {
                        eVar.f10214r = (360.0f - f5) % 360.0f;
                        break;
                    } else {
                        break;
                    }
                case 5:
                    eVar.f10184a = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f10184a);
                    break;
                case 6:
                    eVar.f10186b = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f10186b);
                    break;
                case 7:
                    eVar.f10188c = typedArrayObtainStyledAttributes.getFloat(index, eVar.f10188c);
                    break;
                case 8:
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10192e);
                    eVar.f10192e = resourceId2;
                    if (resourceId2 == -1) {
                        eVar.f10192e = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 9:
                    int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10194f);
                    eVar.f10194f = resourceId3;
                    if (resourceId3 == -1) {
                        eVar.f10194f = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 10:
                    int resourceId4 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.g);
                    eVar.g = resourceId4;
                    if (resourceId4 == -1) {
                        eVar.g = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 11:
                    int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.h);
                    eVar.h = resourceId5;
                    if (resourceId5 == -1) {
                        eVar.h = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case FileClientSessionCache.MAX_SIZE /* 12 */:
                    int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10198i);
                    eVar.f10198i = resourceId6;
                    if (resourceId6 == -1) {
                        eVar.f10198i = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case o1.f.ERROR /* 13 */:
                    int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10200j);
                    eVar.f10200j = resourceId7;
                    if (resourceId7 == -1) {
                        eVar.f10200j = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case o1.f.INTERRUPTED /* 14 */:
                    int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10202k);
                    eVar.f10202k = resourceId8;
                    if (resourceId8 == -1) {
                        eVar.f10202k = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 15:
                    int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10204l);
                    eVar.f10204l = resourceId9;
                    if (resourceId9 == -1) {
                        eVar.f10204l = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 16:
                    int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10206m);
                    eVar.f10206m = resourceId10;
                    if (resourceId10 == -1) {
                        eVar.f10206m = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case o1.f.API_NOT_CONNECTED /* 17 */:
                    int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10215s);
                    eVar.f10215s = resourceId11;
                    if (resourceId11 == -1) {
                        eVar.f10215s = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case 18:
                    int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10216t);
                    eVar.f10216t = resourceId12;
                    if (resourceId12 == -1) {
                        eVar.f10216t = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case o1.f.REMOTE_EXCEPTION /* 19 */:
                    int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10217u);
                    eVar.f10217u = resourceId13;
                    if (resourceId13 == -1) {
                        eVar.f10217u = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                    int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10218v);
                    eVar.f10218v = resourceId14;
                    if (resourceId14 == -1) {
                        eVar.f10218v = typedArrayObtainStyledAttributes.getInt(index, -1);
                        break;
                    } else {
                        break;
                    }
                case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    eVar.f10219w = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10219w);
                    break;
                case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                    eVar.f10220x = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10220x);
                    break;
                case 23:
                    eVar.f10221y = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10221y);
                    break;
                case 24:
                    eVar.f10222z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10222z);
                    break;
                case 25:
                    eVar.f10159A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10159A);
                    break;
                case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                    eVar.f10160B = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10160B);
                    break;
                case 27:
                    eVar.f10180W = typedArrayObtainStyledAttributes.getBoolean(index, eVar.f10180W);
                    break;
                case 28:
                    eVar.f10181X = typedArrayObtainStyledAttributes.getBoolean(index, eVar.f10181X);
                    break;
                case 29:
                    eVar.f10163E = typedArrayObtainStyledAttributes.getFloat(index, eVar.f10163E);
                    break;
                case 30:
                    eVar.f10164F = typedArrayObtainStyledAttributes.getFloat(index, eVar.f10164F);
                    break;
                case 31:
                    int i7 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    eVar.f10169L = i7;
                    if (i7 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 32:
                    int i8 = typedArrayObtainStyledAttributes.getInt(index, 0);
                    eVar.f10170M = i8;
                    if (i8 == 1) {
                        Log.e("ConstraintLayout", "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                        break;
                    } else {
                        break;
                    }
                case 33:
                    try {
                        eVar.f10171N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10171N);
                        break;
                    } catch (Exception unused) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.f10171N) == -2) {
                            eVar.f10171N = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 34:
                    try {
                        eVar.f10173P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10173P);
                        break;
                    } catch (Exception unused2) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.f10173P) == -2) {
                            eVar.f10173P = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 35:
                    eVar.f10175R = Math.max(BitmapDescriptorFactory.HUE_RED, typedArrayObtainStyledAttributes.getFloat(index, eVar.f10175R));
                    eVar.f10169L = 2;
                    break;
                case 36:
                    try {
                        eVar.f10172O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10172O);
                        break;
                    } catch (Exception unused3) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.f10172O) == -2) {
                            eVar.f10172O = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                    try {
                        eVar.f10174Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10174Q);
                        break;
                    } catch (Exception unused4) {
                        if (typedArrayObtainStyledAttributes.getInt(index, eVar.f10174Q) == -2) {
                            eVar.f10174Q = -2;
                            break;
                        } else {
                            break;
                        }
                    }
                case 38:
                    eVar.f10176S = Math.max(BitmapDescriptorFactory.HUE_RED, typedArrayObtainStyledAttributes.getFloat(index, eVar.f10176S));
                    eVar.f10170M = 2;
                    break;
                default:
                    switch (i6) {
                        case 44:
                            n.h(eVar, typedArrayObtainStyledAttributes.getString(index));
                            break;
                        case 45:
                            eVar.f10166H = typedArrayObtainStyledAttributes.getFloat(index, eVar.f10166H);
                            break;
                        case 46:
                            eVar.I = typedArrayObtainStyledAttributes.getFloat(index, eVar.I);
                            break;
                        case 47:
                            eVar.f10167J = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 48:
                            eVar.f10168K = typedArrayObtainStyledAttributes.getInt(index, 0);
                            break;
                        case 49:
                            eVar.f10177T = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f10177T);
                            break;
                        case 50:
                            eVar.f10178U = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, eVar.f10178U);
                            break;
                        case 51:
                            eVar.f10182Y = typedArrayObtainStyledAttributes.getString(index);
                            break;
                        case 52:
                            int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.n);
                            eVar.n = resourceId15;
                            if (resourceId15 == -1) {
                                eVar.n = typedArrayObtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 53:
                            int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(index, eVar.f10209o);
                            eVar.f10209o = resourceId16;
                            if (resourceId16 == -1) {
                                eVar.f10209o = typedArrayObtainStyledAttributes.getInt(index, -1);
                                break;
                            } else {
                                break;
                            }
                        case 54:
                            eVar.f10162D = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10162D);
                            break;
                        case 55:
                            eVar.f10161C = typedArrayObtainStyledAttributes.getDimensionPixelSize(index, eVar.f10161C);
                            break;
                        default:
                            switch (i6) {
                                case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                                    n.g(eVar, typedArrayObtainStyledAttributes, index, 0);
                                    break;
                                case 65:
                                    n.g(eVar, typedArrayObtainStyledAttributes, index, 1);
                                    break;
                                case 66:
                                    eVar.f10183Z = typedArrayObtainStyledAttributes.getInt(index, eVar.f10183Z);
                                    break;
                                case 67:
                                    eVar.f10190d = typedArrayObtainStyledAttributes.getBoolean(index, eVar.f10190d);
                                    break;
                            }
                    }
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        eVar.a();
        return eVar;
    }

    public int getMaxHeight() {
        return this.f3500i;
    }

    public int getMaxWidth() {
        return this.h;
    }

    public int getMinHeight() {
        return this.g;
    }

    public int getMinWidth() {
        return this.f3499f;
    }

    public int getOptimizationLevel() {
        return this.f3498e.f9807D0;
    }

    public String getSceneString() {
        int id;
        StringBuilder sb = new StringBuilder();
        e eVar = this.f3498e;
        if (eVar.f9781j == null) {
            int id2 = getId();
            if (id2 != -1) {
                eVar.f9781j = getContext().getResources().getResourceEntryName(id2);
            } else {
                eVar.f9781j = "parent";
            }
        }
        if (eVar.f9778h0 == null) {
            eVar.f9778h0 = eVar.f9781j;
            Log.v("ConstraintLayout", " setDebugName " + eVar.f9778h0);
        }
        Iterator it = eVar.f9816q0.iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            View view = (View) dVar.f9776f0;
            if (view != null) {
                if (dVar.f9781j == null && (id = view.getId()) != -1) {
                    dVar.f9781j = getContext().getResources().getResourceEntryName(id);
                }
                if (dVar.f9778h0 == null) {
                    dVar.f9778h0 = dVar.f9781j;
                    Log.v("ConstraintLayout", " setDebugName " + dVar.f9778h0);
                }
            }
        }
        eVar.n(sb);
        return sb.toString();
    }

    public final d h(View view) {
        if (view == this) {
            return this.f3498e;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof x.e) {
            return ((x.e) view.getLayoutParams()).f10212p0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof x.e) {
            return ((x.e) view.getLayoutParams()).f10212p0;
        }
        return null;
    }

    public final void i(AttributeSet attributeSet, int i5, int i6) throws XmlPullParserException, IOException, NumberFormatException {
        e eVar = this.f3498e;
        eVar.f9776f0 = this;
        f fVar = this.f3507q;
        eVar.f9820u0 = fVar;
        eVar.f9818s0.f9980f = fVar;
        this.f3496c.put(getId(), this);
        this.f3503l = null;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, r.f10345b, i5, i6);
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            for (int i7 = 0; i7 < indexCount; i7++) {
                int index = typedArrayObtainStyledAttributes.getIndex(i7);
                if (index == 16) {
                    this.f3499f = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3499f);
                } else if (index == 17) {
                    this.g = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.g);
                } else if (index == 14) {
                    this.h = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.h);
                } else if (index == 15) {
                    this.f3500i = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, this.f3500i);
                } else if (index == 113) {
                    this.f3502k = typedArrayObtainStyledAttributes.getInt(index, this.f3502k);
                } else if (index == 56) {
                    int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            j(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.f3504m = null;
                        }
                    }
                } else if (index == 34) {
                    int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, 0);
                    try {
                        n nVar = new n();
                        this.f3503l = nVar;
                        nVar.e(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.f3503l = null;
                    }
                    this.n = resourceId2;
                }
            }
            typedArrayObtainStyledAttributes.recycle();
        }
        eVar.f9807D0 = this.f3502k;
        C0880c.f9542p = eVar.W(512);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0075  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j(int r10) throws org.xmlpull.v1.XmlPullParserException, android.content.res.Resources.NotFoundException, java.io.IOException, java.lang.NumberFormatException {
        /*
            r9 = this;
            L0.s r0 = new L0.s
            android.content.Context r1 = r9.getContext()
            r2 = 24
            r3 = 0
            r0.<init>(r2, r3)
            android.util.SparseArray r2 = new android.util.SparseArray
            r2.<init>()
            r0.f1596d = r2
            android.util.SparseArray r2 = new android.util.SparseArray
            r2.<init>()
            r0.f1597e = r2
            android.content.res.Resources r2 = r1.getResources()
            android.content.res.XmlResourceParser r10 = r2.getXml(r10)
            int r2 = r10.getEventType()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r3 = 0
        L27:
            r4 = 1
            if (r2 == r4) goto Lae
            if (r2 == 0) goto L9f
            r5 = 2
            if (r2 == r5) goto L31
            goto La2
        L31:
            java.lang.String r2 = r10.getName()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            int r6 = r2.hashCode()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r7 = 4
            r8 = 3
            switch(r6) {
                case -1349929691: goto L6b;
                case 80204913: goto L61;
                case 1382829617: goto L58;
                case 1657696882: goto L4e;
                case 1901439077: goto L3f;
                default: goto L3e;
            }     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
        L3e:
            goto L75
        L3f:
            java.lang.String r4 = "Variant"
            boolean r2 = r2.equals(r4)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L75
            r4 = r8
            goto L76
        L49:
            r10 = move-exception
            goto La7
        L4b:
            r10 = move-exception
            goto Lab
        L4e:
            java.lang.String r4 = "layoutDescription"
            boolean r2 = r2.equals(r4)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L75
            r4 = 0
            goto L76
        L58:
            java.lang.String r6 = "StateSet"
            boolean r2 = r2.equals(r6)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L75
            goto L76
        L61:
            java.lang.String r4 = "State"
            boolean r2 = r2.equals(r4)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L75
            r4 = r5
            goto L76
        L6b:
            java.lang.String r4 = "ConstraintSet"
            boolean r2 = r2.equals(r4)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r2 == 0) goto L75
            r4 = r7
            goto L76
        L75:
            r4 = -1
        L76:
            if (r4 == r5) goto L90
            if (r4 == r8) goto L81
            if (r4 == r7) goto L7d
            goto La2
        L7d:
            r0.u(r1, r10)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto La2
        L81:
            x.g r2 = new x.g     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r2.<init>(r1, r10)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            if (r3 == 0) goto La2
            java.lang.Object r4 = r3.f5313e     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            java.util.ArrayList r4 = (java.util.ArrayList) r4     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r4.add(r2)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto La2
        L90:
            com.google.android.material.datepicker.m r3 = new com.google.android.material.datepicker.m     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r3.<init>(r1, r10)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            java.lang.Object r2 = r0.f1596d     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            android.util.SparseArray r2 = (android.util.SparseArray) r2     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            int r4 = r3.f5311c     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            r2.put(r4, r3)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto La2
        L9f:
            r10.getName()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
        La2:
            int r2 = r10.next()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b
            goto L27
        La7:
            r10.printStackTrace()
            goto Lae
        Lab:
            r10.printStackTrace()
        Lae:
            r9.f3504m = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.j(int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:159:0x02ea  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0309  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04d1  */
    /* JADX WARN: Removed duplicated region for block: B:420:0x04d5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(u.e r26, int r27, int r28, int r29) {
        /*
            Method dump skipped, instructions count: 1741
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.k(u.e, int, int, int):void");
    }

    public final void l(d dVar, x.e eVar, SparseArray sparseArray, int i5, int i6) {
        View view = (View) this.f3496c.get(i5);
        d dVar2 = (d) sparseArray.get(i5);
        if (dVar2 == null || view == null || !(view.getLayoutParams() instanceof x.e)) {
            return;
        }
        eVar.f10189c0 = true;
        if (i6 == 6) {
            x.e eVar2 = (x.e) view.getLayoutParams();
            eVar2.f10189c0 = true;
            eVar2.f10212p0.f9744E = true;
        }
        dVar.i(6).b(dVar2.i(i6), eVar.f10162D, eVar.f10161C, true);
        dVar.f9744E = true;
        dVar.i(3).j();
        dVar.i(5).j();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int childCount = getChildCount();
        boolean zIsInEditMode = isInEditMode();
        for (int i9 = 0; i9 < childCount; i9++) {
            View childAt = getChildAt(i9);
            x.e eVar = (x.e) childAt.getLayoutParams();
            d dVar = eVar.f10212p0;
            if (childAt.getVisibility() != 8 || eVar.f10191d0 || eVar.f10193e0 || zIsInEditMode) {
                int iR = dVar.r();
                int iS = dVar.s();
                childAt.layout(iR, iS, dVar.q() + iR, dVar.k() + iS);
            }
        }
        ArrayList arrayList = this.f3497d;
        int size = arrayList.size();
        if (size > 0) {
            for (int i10 = 0; i10 < size; i10++) {
                ((c) arrayList.get(i10)).getClass();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0395  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03c8  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x03f3  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x051a  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0520  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r24, int r25) throws android.content.res.Resources.NotFoundException, java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1508
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.onMeasure(int, int):void");
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        super.onViewAdded(view);
        d dVarH = h(view);
        if ((view instanceof p) && !(dVarH instanceof h)) {
            x.e eVar = (x.e) view.getLayoutParams();
            h hVar = new h();
            eVar.f10212p0 = hVar;
            eVar.f10191d0 = true;
            hVar.S(eVar.f10179V);
        }
        if (view instanceof c) {
            c cVar = (c) view;
            cVar.i();
            ((x.e) view.getLayoutParams()).f10193e0 = true;
            ArrayList arrayList = this.f3497d;
            if (!arrayList.contains(cVar)) {
                arrayList.add(cVar);
            }
        }
        this.f3496c.put(view.getId(), view);
        this.f3501j = true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.f3496c.remove(view.getId());
        d dVarH = h(view);
        this.f3498e.f9816q0.remove(dVarH);
        dVarH.C();
        this.f3497d.remove(view);
        this.f3501j = true;
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        this.f3501j = true;
        super.requestLayout();
    }

    public void setConstraintSet(n nVar) {
        this.f3503l = nVar;
    }

    @Override // android.view.View
    public void setId(int i5) {
        int id = getId();
        SparseArray sparseArray = this.f3496c;
        sparseArray.remove(id);
        super.setId(i5);
        sparseArray.put(getId(), this);
    }

    public void setMaxHeight(int i5) {
        if (i5 == this.f3500i) {
            return;
        }
        this.f3500i = i5;
        requestLayout();
    }

    public void setMaxWidth(int i5) {
        if (i5 == this.h) {
            return;
        }
        this.h = i5;
        requestLayout();
    }

    public void setMinHeight(int i5) {
        if (i5 == this.g) {
            return;
        }
        this.g = i5;
        requestLayout();
    }

    public void setMinWidth(int i5) {
        if (i5 == this.f3499f) {
            return;
        }
        this.f3499f = i5;
        requestLayout();
    }

    public void setOnConstraintsChanged(o oVar) {
        L0.s sVar = this.f3504m;
        if (sVar != null) {
            sVar.getClass();
        }
    }

    public void setOptimizationLevel(int i5) {
        this.f3502k = i5;
        e eVar = this.f3498e;
        eVar.f9807D0 = i5;
        C0880c.f9542p = eVar.W(512);
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet);
        this.f3496c = new SparseArray();
        this.f3497d = new ArrayList(4);
        this.f3498e = new e();
        this.f3499f = 0;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.f3500i = Integer.MAX_VALUE;
        this.f3501j = true;
        this.f3502k = 257;
        this.f3503l = null;
        this.f3504m = null;
        this.n = -1;
        this.f3505o = new HashMap();
        this.f3506p = new SparseArray();
        this.f3507q = new f(this, this);
        this.f3508r = 0;
        this.f3509s = 0;
        i(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i5) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet, i5);
        this.f3496c = new SparseArray();
        this.f3497d = new ArrayList(4);
        this.f3498e = new e();
        this.f3499f = 0;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.f3500i = Integer.MAX_VALUE;
        this.f3501j = true;
        this.f3502k = 257;
        this.f3503l = null;
        this.f3504m = null;
        this.n = -1;
        this.f3505o = new HashMap();
        this.f3506p = new SparseArray();
        this.f3507q = new f(this, this);
        this.f3508r = 0;
        this.f3509s = 0;
        i(attributeSet, i5, 0);
    }

    @TargetApi(o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i5, int i6) throws XmlPullParserException, IOException, NumberFormatException {
        super(context, attributeSet, i5, i6);
        this.f3496c = new SparseArray();
        this.f3497d = new ArrayList(4);
        this.f3498e = new e();
        this.f3499f = 0;
        this.g = 0;
        this.h = Integer.MAX_VALUE;
        this.f3500i = Integer.MAX_VALUE;
        this.f3501j = true;
        this.f3502k = 257;
        this.f3503l = null;
        this.f3504m = null;
        this.n = -1;
        this.f3505o = new HashMap();
        this.f3506p = new SparseArray();
        this.f3507q = new f(this, this);
        this.f3508r = 0;
        this.f3509s = 0;
        i(attributeSet, i5, i6);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        x.e eVar = new x.e(layoutParams);
        eVar.f10184a = -1;
        eVar.f10186b = -1;
        eVar.f10188c = -1.0f;
        eVar.f10190d = true;
        eVar.f10192e = -1;
        eVar.f10194f = -1;
        eVar.g = -1;
        eVar.h = -1;
        eVar.f10198i = -1;
        eVar.f10200j = -1;
        eVar.f10202k = -1;
        eVar.f10204l = -1;
        eVar.f10206m = -1;
        eVar.n = -1;
        eVar.f10209o = -1;
        eVar.f10211p = -1;
        eVar.f10213q = 0;
        eVar.f10214r = BitmapDescriptorFactory.HUE_RED;
        eVar.f10215s = -1;
        eVar.f10216t = -1;
        eVar.f10217u = -1;
        eVar.f10218v = -1;
        eVar.f10219w = Integer.MIN_VALUE;
        eVar.f10220x = Integer.MIN_VALUE;
        eVar.f10221y = Integer.MIN_VALUE;
        eVar.f10222z = Integer.MIN_VALUE;
        eVar.f10159A = Integer.MIN_VALUE;
        eVar.f10160B = Integer.MIN_VALUE;
        eVar.f10161C = Integer.MIN_VALUE;
        eVar.f10162D = 0;
        eVar.f10163E = 0.5f;
        eVar.f10164F = 0.5f;
        eVar.f10165G = null;
        eVar.f10166H = -1.0f;
        eVar.I = -1.0f;
        eVar.f10167J = 0;
        eVar.f10168K = 0;
        eVar.f10169L = 0;
        eVar.f10170M = 0;
        eVar.f10171N = 0;
        eVar.f10172O = 0;
        eVar.f10173P = 0;
        eVar.f10174Q = 0;
        eVar.f10175R = 1.0f;
        eVar.f10176S = 1.0f;
        eVar.f10177T = -1;
        eVar.f10178U = -1;
        eVar.f10179V = -1;
        eVar.f10180W = false;
        eVar.f10181X = false;
        eVar.f10182Y = null;
        eVar.f10183Z = 0;
        eVar.f10185a0 = true;
        eVar.f10187b0 = true;
        eVar.f10189c0 = false;
        eVar.f10191d0 = false;
        eVar.f10193e0 = false;
        eVar.f10195f0 = -1;
        eVar.f10196g0 = -1;
        eVar.f10197h0 = -1;
        eVar.f10199i0 = -1;
        eVar.f10201j0 = Integer.MIN_VALUE;
        eVar.f10203k0 = Integer.MIN_VALUE;
        eVar.f10205l0 = 0.5f;
        eVar.f10212p0 = new d();
        return eVar;
    }
}
