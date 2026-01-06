package R1;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Xml;
import com.google.android.gms.internal.measurement.AbstractC0409x1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import g2.m;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f2267a;

    /* renamed from: b, reason: collision with root package name */
    public final b f2268b;

    /* renamed from: c, reason: collision with root package name */
    public final float f2269c;

    /* renamed from: d, reason: collision with root package name */
    public final float f2270d;

    /* renamed from: e, reason: collision with root package name */
    public final float f2271e;

    /* renamed from: f, reason: collision with root package name */
    public final float f2272f;
    public final float g;
    public final float h;

    /* renamed from: i, reason: collision with root package name */
    public final int f2273i;

    /* renamed from: j, reason: collision with root package name */
    public final int f2274j;

    /* renamed from: k, reason: collision with root package name */
    public final int f2275k;

    public c(Context context, b bVar) throws XmlPullParserException, Resources.NotFoundException, IOException {
        AttributeSet attributeSet;
        int styleAttribute;
        int next;
        b bVar2 = new b();
        bVar2.f2258r = 255;
        bVar2.f2260t = -2;
        bVar2.f2261u = -2;
        bVar2.f2262v = -2;
        bVar2.f2241C = Boolean.TRUE;
        this.f2268b = bVar2;
        int i5 = bVar.f2251j;
        if (i5 != 0) {
            try {
                XmlResourceParser xml = context.getResources().getXml(i5);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                if (!TextUtils.equals(xml.getName(), "badge")) {
                    throw new XmlPullParserException("Must have a <" + ((Object) "badge") + "> start tag");
                }
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                styleAttribute = attributeSetAsAttributeSet.getStyleAttribute();
                attributeSet = attributeSetAsAttributeSet;
            } catch (IOException | XmlPullParserException e5) {
                Resources.NotFoundException notFoundException = new Resources.NotFoundException("Can't load badge resource ID #0x" + Integer.toHexString(i5));
                notFoundException.initCause(e5);
                throw notFoundException;
            }
        } else {
            attributeSet = null;
            styleAttribute = 0;
        }
        TypedArray typedArrayI = m.i(context, attributeSet, O1.a.f1999a, R.attr.badgeStyle, styleAttribute == 0 ? 2132018202 : styleAttribute, new int[0]);
        Resources resources = context.getResources();
        this.f2269c = typedArrayI.getDimensionPixelSize(4, -1);
        this.f2273i = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.f2274j = context.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.f2270d = typedArrayI.getDimensionPixelSize(14, -1);
        this.f2271e = typedArrayI.getDimension(12, resources.getDimension(R.dimen.m3_badge_size));
        this.g = typedArrayI.getDimension(17, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f2272f = typedArrayI.getDimension(3, resources.getDimension(R.dimen.m3_badge_size));
        this.h = typedArrayI.getDimension(13, resources.getDimension(R.dimen.m3_badge_with_text_size));
        this.f2275k = typedArrayI.getInt(24, 1);
        b bVar3 = this.f2268b;
        int i6 = bVar.f2258r;
        bVar3.f2258r = i6 == -2 ? 255 : i6;
        int i7 = bVar.f2260t;
        if (i7 != -2) {
            bVar3.f2260t = i7;
        } else if (typedArrayI.hasValue(23)) {
            this.f2268b.f2260t = typedArrayI.getInt(23, 0);
        } else {
            this.f2268b.f2260t = -1;
        }
        String str = bVar.f2259s;
        if (str != null) {
            this.f2268b.f2259s = str;
        } else if (typedArrayI.hasValue(7)) {
            this.f2268b.f2259s = typedArrayI.getString(7);
        }
        b bVar4 = this.f2268b;
        bVar4.f2264x = bVar.f2264x;
        CharSequence charSequence = bVar.f2265y;
        bVar4.f2265y = charSequence == null ? context.getString(R.string.mtrl_badge_numberless_content_description) : charSequence;
        b bVar5 = this.f2268b;
        int i8 = bVar.f2266z;
        bVar5.f2266z = i8 == 0 ? R.plurals.mtrl_badge_content_description : i8;
        int i9 = bVar.f2239A;
        bVar5.f2239A = i9 == 0 ? R.string.mtrl_exceed_max_badge_number_content_description : i9;
        Boolean bool = bVar.f2241C;
        bVar5.f2241C = Boolean.valueOf(bool == null || bool.booleanValue());
        b bVar6 = this.f2268b;
        int i10 = bVar.f2261u;
        bVar6.f2261u = i10 == -2 ? typedArrayI.getInt(21, -2) : i10;
        b bVar7 = this.f2268b;
        int i11 = bVar.f2262v;
        bVar7.f2262v = i11 == -2 ? typedArrayI.getInt(22, -2) : i11;
        b bVar8 = this.f2268b;
        Integer num = bVar.n;
        bVar8.n = Integer.valueOf(num == null ? typedArrayI.getResourceId(5, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num.intValue());
        b bVar9 = this.f2268b;
        Integer num2 = bVar.f2255o;
        bVar9.f2255o = Integer.valueOf(num2 == null ? typedArrayI.getResourceId(6, 0) : num2.intValue());
        b bVar10 = this.f2268b;
        Integer num3 = bVar.f2256p;
        bVar10.f2256p = Integer.valueOf(num3 == null ? typedArrayI.getResourceId(15, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : num3.intValue());
        b bVar11 = this.f2268b;
        Integer num4 = bVar.f2257q;
        bVar11.f2257q = Integer.valueOf(num4 == null ? typedArrayI.getResourceId(16, 0) : num4.intValue());
        b bVar12 = this.f2268b;
        Integer num5 = bVar.f2252k;
        bVar12.f2252k = Integer.valueOf(num5 == null ? AbstractC0409x1.f(context, typedArrayI, 1).getDefaultColor() : num5.intValue());
        b bVar13 = this.f2268b;
        Integer num6 = bVar.f2254m;
        bVar13.f2254m = Integer.valueOf(num6 == null ? typedArrayI.getResourceId(8, R.style.TextAppearance_MaterialComponents_Badge) : num6.intValue());
        Integer num7 = bVar.f2253l;
        if (num7 != null) {
            this.f2268b.f2253l = num7;
        } else if (typedArrayI.hasValue(9)) {
            this.f2268b.f2253l = Integer.valueOf(AbstractC0409x1.f(context, typedArrayI, 9).getDefaultColor());
        } else {
            int iIntValue = this.f2268b.f2254m.intValue();
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iIntValue, O1.a.f1995E);
            typedArrayObtainStyledAttributes.getDimension(0, BitmapDescriptorFactory.HUE_RED);
            ColorStateList colorStateListF = AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 3);
            AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 4);
            AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 5);
            typedArrayObtainStyledAttributes.getInt(2, 0);
            typedArrayObtainStyledAttributes.getInt(1, 1);
            int i12 = typedArrayObtainStyledAttributes.hasValue(12) ? 12 : 10;
            typedArrayObtainStyledAttributes.getResourceId(i12, 0);
            typedArrayObtainStyledAttributes.getString(i12);
            typedArrayObtainStyledAttributes.getBoolean(14, false);
            AbstractC0409x1.f(context, typedArrayObtainStyledAttributes, 6);
            typedArrayObtainStyledAttributes.getFloat(7, BitmapDescriptorFactory.HUE_RED);
            typedArrayObtainStyledAttributes.getFloat(8, BitmapDescriptorFactory.HUE_RED);
            typedArrayObtainStyledAttributes.getFloat(9, BitmapDescriptorFactory.HUE_RED);
            typedArrayObtainStyledAttributes.recycle();
            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(iIntValue, O1.a.f2015t);
            typedArrayObtainStyledAttributes2.hasValue(0);
            typedArrayObtainStyledAttributes2.getFloat(0, BitmapDescriptorFactory.HUE_RED);
            typedArrayObtainStyledAttributes2.recycle();
            this.f2268b.f2253l = Integer.valueOf(colorStateListF.getDefaultColor());
        }
        b bVar14 = this.f2268b;
        Integer num8 = bVar.f2240B;
        bVar14.f2240B = Integer.valueOf(num8 == null ? typedArrayI.getInt(2, 8388661) : num8.intValue());
        b bVar15 = this.f2268b;
        Integer num9 = bVar.f2242D;
        bVar15.f2242D = Integer.valueOf(num9 == null ? typedArrayI.getDimensionPixelSize(11, resources.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding)) : num9.intValue());
        b bVar16 = this.f2268b;
        Integer num10 = bVar.f2243E;
        bVar16.f2243E = Integer.valueOf(num10 == null ? typedArrayI.getDimensionPixelSize(10, resources.getDimensionPixelSize(R.dimen.m3_badge_with_text_vertical_padding)) : num10.intValue());
        b bVar17 = this.f2268b;
        Integer num11 = bVar.f2244F;
        bVar17.f2244F = Integer.valueOf(num11 == null ? typedArrayI.getDimensionPixelOffset(18, 0) : num11.intValue());
        b bVar18 = this.f2268b;
        Integer num12 = bVar.f2245G;
        bVar18.f2245G = Integer.valueOf(num12 == null ? typedArrayI.getDimensionPixelOffset(25, 0) : num12.intValue());
        b bVar19 = this.f2268b;
        Integer num13 = bVar.f2246H;
        bVar19.f2246H = Integer.valueOf(num13 == null ? typedArrayI.getDimensionPixelOffset(19, bVar19.f2244F.intValue()) : num13.intValue());
        b bVar20 = this.f2268b;
        Integer num14 = bVar.I;
        bVar20.I = Integer.valueOf(num14 == null ? typedArrayI.getDimensionPixelOffset(26, bVar20.f2245G.intValue()) : num14.intValue());
        b bVar21 = this.f2268b;
        Integer num15 = bVar.f2249L;
        bVar21.f2249L = Integer.valueOf(num15 == null ? typedArrayI.getDimensionPixelOffset(20, 0) : num15.intValue());
        b bVar22 = this.f2268b;
        Integer num16 = bVar.f2247J;
        bVar22.f2247J = Integer.valueOf(num16 == null ? 0 : num16.intValue());
        b bVar23 = this.f2268b;
        Integer num17 = bVar.f2248K;
        bVar23.f2248K = Integer.valueOf(num17 == null ? 0 : num17.intValue());
        b bVar24 = this.f2268b;
        Boolean bool2 = bVar.f2250M;
        bVar24.f2250M = Boolean.valueOf(bool2 == null ? typedArrayI.getBoolean(0, false) : bool2.booleanValue());
        typedArrayI.recycle();
        Locale locale = bVar.f2263w;
        if (locale == null) {
            this.f2268b.f2263w = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            this.f2268b.f2263w = locale;
        }
        this.f2267a = bVar;
    }
}
