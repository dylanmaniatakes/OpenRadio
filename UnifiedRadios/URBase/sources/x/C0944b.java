package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashMap;
import s.AbstractC0882e;

/* renamed from: x.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0944b {

    /* renamed from: a, reason: collision with root package name */
    public boolean f10147a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f10148b;

    /* renamed from: c, reason: collision with root package name */
    public int f10149c;

    /* renamed from: d, reason: collision with root package name */
    public float f10150d;

    /* renamed from: e, reason: collision with root package name */
    public String f10151e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10152f;
    public int g;

    public C0944b(C0944b c0944b, Object obj) {
        c0944b.getClass();
        this.f10148b = c0944b.f10148b;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap map) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), r.f10347d);
        int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
        String string = null;
        int i5 = 0;
        boolean z4 = false;
        Object objValueOf = null;
        for (int i6 = 0; i6 < indexCount; i6++) {
            int index = typedArrayObtainStyledAttributes.getIndex(i6);
            int i7 = 1;
            if (index == 0) {
                string = typedArrayObtainStyledAttributes.getString(index);
                if (string != null && string.length() > 0) {
                    string = Character.toUpperCase(string.charAt(0)) + string.substring(1);
                }
            } else if (index == 10) {
                string = typedArrayObtainStyledAttributes.getString(index);
                z4 = true;
            } else if (index == 1) {
                objValueOf = Boolean.valueOf(typedArrayObtainStyledAttributes.getBoolean(index, false));
                i5 = 6;
            } else {
                int i8 = 3;
                if (index == 3) {
                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                } else {
                    i8 = 4;
                    if (index == 2) {
                        objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getColor(index, 0));
                    } else {
                        if (index == 7) {
                            objValueOf = Float.valueOf(TypedValue.applyDimension(1, typedArrayObtainStyledAttributes.getDimension(index, BitmapDescriptorFactory.HUE_RED), context.getResources().getDisplayMetrics()));
                        } else if (index == 4) {
                            objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getDimension(index, BitmapDescriptorFactory.HUE_RED));
                        } else {
                            i8 = 5;
                            if (index == 5) {
                                objValueOf = Float.valueOf(typedArrayObtainStyledAttributes.getFloat(index, Float.NaN));
                                i5 = 2;
                            } else {
                                if (index == 6) {
                                    objValueOf = Integer.valueOf(typedArrayObtainStyledAttributes.getInteger(index, -1));
                                } else if (index == 9) {
                                    objValueOf = typedArrayObtainStyledAttributes.getString(index);
                                } else {
                                    i7 = 8;
                                    if (index == 8) {
                                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                        if (resourceId == -1) {
                                            resourceId = typedArrayObtainStyledAttributes.getInt(index, -1);
                                        }
                                        objValueOf = Integer.valueOf(resourceId);
                                    }
                                }
                                i5 = i7;
                            }
                        }
                        i5 = 7;
                    }
                }
                i5 = i8;
            }
        }
        if (string != null && objValueOf != null) {
            C0944b c0944b = new C0944b();
            c0944b.f10148b = i5;
            c0944b.f10147a = z4;
            c0944b.b(objValueOf);
            map.put(string, c0944b);
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (AbstractC0882e.c(this.f10148b)) {
            case 0:
            case 7:
                this.f10149c = ((Integer) obj).intValue();
                break;
            case 1:
                this.f10150d = ((Float) obj).floatValue();
                break;
            case 2:
            case 3:
                this.g = ((Integer) obj).intValue();
                break;
            case 4:
                this.f10151e = (String) obj;
                break;
            case 5:
                this.f10152f = ((Boolean) obj).booleanValue();
                break;
            case 6:
                this.f10150d = ((Float) obj).floatValue();
                break;
        }
    }
}
