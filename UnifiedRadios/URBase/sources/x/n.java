package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.PinConfig;
import g0.AbstractC0535a;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import okhttp3.internal.ws.WebSocketProtocol;
import org.conscrypt.FileClientSessionCache;
import org.xmlpull.v1.XmlPullParserException;
import s.AbstractC0882e;
import t.AbstractC0901a;
import w.AbstractC0923a;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: d, reason: collision with root package name */
    public static final int[] f10337d = {0, 4, 8};

    /* renamed from: e, reason: collision with root package name */
    public static final SparseIntArray f10338e;

    /* renamed from: f, reason: collision with root package name */
    public static final SparseIntArray f10339f;

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f10340a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    public final boolean f10341b = true;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f10342c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f10338e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f10339f = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] c(C0943a c0943a, String str) throws IllegalAccessException, IllegalArgumentException {
        int iIntValue;
        HashMap map;
        String[] strArrSplit = str.split(",");
        Context context = c0943a.getContext();
        int[] iArr = new int[strArrSplit.length];
        int i5 = 0;
        int i6 = 0;
        while (i5 < strArrSplit.length) {
            String strTrim = strArrSplit[i5].trim();
            Object obj = null;
            try {
                iIntValue = q.class.getField(strTrim).getInt(null);
            } catch (Exception unused) {
                iIntValue = 0;
            }
            if (iIntValue == 0) {
                iIntValue = context.getResources().getIdentifier(strTrim, "id", context.getPackageName());
            }
            if (iIntValue == 0 && c0943a.isInEditMode() && (c0943a.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) c0943a.getParent();
                constraintLayout.getClass();
                if ((strTrim instanceof String) && (map = constraintLayout.f3505o) != null && map.containsKey(strTrim)) {
                    obj = constraintLayout.f3505o.get(strTrim);
                }
                if (obj != null && (obj instanceof Integer)) {
                    iIntValue = ((Integer) obj).intValue();
                }
            }
            iArr[i6] = iIntValue;
            i5++;
            i6++;
        }
        return i6 != strArrSplit.length ? Arrays.copyOf(iArr, i6) : iArr;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:125:0x0606. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:12:0x008b. Please report as an issue. */
    public static i d(Context context, AttributeSet attributeSet, boolean z4) {
        int i5;
        String str;
        String str2;
        String str3;
        int i6;
        String str4;
        int i7;
        i iVar = new i();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, z4 ? r.f10346c : r.f10344a);
        int[] iArr = f10337d;
        SparseIntArray sparseIntArray = f10338e;
        String[] strArr = AbstractC0901a.f9695a;
        l lVar = iVar.f10245b;
        m mVar = iVar.f10248e;
        k kVar = iVar.f10246c;
        j jVar = iVar.f10247d;
        String str5 = "Unknown attribute 0x";
        String str6 = "ConstraintSet";
        if (z4) {
            int indexCount = typedArrayObtainStyledAttributes.getIndexCount();
            h hVar = new h();
            hVar.f10234a = new int[10];
            hVar.f10235b = new int[10];
            hVar.f10236c = 0;
            hVar.f10237d = new int[10];
            hVar.f10238e = new float[10];
            hVar.f10239f = 0;
            hVar.g = new int[5];
            hVar.h = new String[5];
            hVar.f10240i = 0;
            hVar.f10241j = new int[4];
            hVar.f10242k = new boolean[4];
            hVar.f10243l = 0;
            kVar.getClass();
            jVar.getClass();
            lVar.getClass();
            mVar.getClass();
            int i8 = 0;
            while (i8 < indexCount) {
                int index = typedArrayObtainStyledAttributes.getIndex(i8);
                int i9 = indexCount;
                switch (f10339f.get(index)) {
                    case 2:
                        str4 = str5;
                        hVar.b(2, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.I));
                        i7 = 1;
                        break;
                    case 3:
                    case 4:
                    case 9:
                    case 10:
                    case 25:
                    case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                    case 29:
                    case 30:
                    case 32:
                    case 33:
                    case 35:
                    case 36:
                    case 61:
                    case 88:
                    case 89:
                    case 90:
                    case 91:
                    case 92:
                    default:
                        StringBuilder sb = new StringBuilder(str5);
                        str4 = str5;
                        sb.append(Integer.toHexString(index));
                        sb.append("   ");
                        sb.append(sparseIntArray.get(index));
                        Log.w("ConstraintSet", sb.toString());
                        i7 = 1;
                        break;
                    case 5:
                        str4 = str5;
                        hVar.c(5, typedArrayObtainStyledAttributes.getString(index));
                        i7 = 1;
                        break;
                    case 6:
                        str4 = str5;
                        hVar.b(6, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f10253C));
                        i7 = 1;
                        break;
                    case 7:
                        str4 = str5;
                        hVar.b(7, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f10254D));
                        i7 = 1;
                        break;
                    case 8:
                        str4 = str5;
                        hVar.b(8, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10259J));
                        i7 = 1;
                        break;
                    case 11:
                        str4 = str5;
                        hVar.b(11, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10265P));
                        i7 = 1;
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        str4 = str5;
                        hVar.b(12, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10266Q));
                        i7 = 1;
                        break;
                    case o1.f.ERROR /* 13 */:
                        str4 = str5;
                        hVar.b(13, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10262M));
                        i7 = 1;
                        break;
                    case o1.f.INTERRUPTED /* 14 */:
                        str4 = str5;
                        hVar.b(14, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10264O));
                        i7 = 1;
                        break;
                    case 15:
                        str4 = str5;
                        hVar.b(15, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10267R));
                        i7 = 1;
                        break;
                    case 16:
                        str4 = str5;
                        hVar.b(16, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10263N));
                        i7 = 1;
                        break;
                    case o1.f.API_NOT_CONNECTED /* 17 */:
                        str4 = str5;
                        hVar.b(17, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f10282d));
                        i7 = 1;
                        break;
                    case 18:
                        str4 = str5;
                        hVar.b(18, typedArrayObtainStyledAttributes.getDimensionPixelOffset(index, jVar.f10284e));
                        i7 = 1;
                        break;
                    case o1.f.REMOTE_EXCEPTION /* 19 */:
                        str4 = str5;
                        hVar.a(19, typedArrayObtainStyledAttributes.getFloat(index, jVar.f10286f));
                        i7 = 1;
                        break;
                    case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                        str4 = str5;
                        hVar.a(20, typedArrayObtainStyledAttributes.getFloat(index, jVar.f10310w));
                        i7 = 1;
                        break;
                    case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                        str4 = str5;
                        hVar.b(21, typedArrayObtainStyledAttributes.getLayoutDimension(index, jVar.f10280c));
                        i7 = 1;
                        break;
                    case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                        str4 = str5;
                        hVar.b(22, iArr[typedArrayObtainStyledAttributes.getInt(index, lVar.f10322a)]);
                        i7 = 1;
                        break;
                    case 23:
                        str4 = str5;
                        hVar.b(23, typedArrayObtainStyledAttributes.getLayoutDimension(index, jVar.f10278b));
                        i7 = 1;
                        break;
                    case 24:
                        str4 = str5;
                        hVar.b(24, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10256F));
                        i7 = 1;
                        break;
                    case 27:
                        str4 = str5;
                        hVar.b(27, typedArrayObtainStyledAttributes.getInt(index, jVar.f10255E));
                        i7 = 1;
                        break;
                    case 28:
                        str4 = str5;
                        hVar.b(28, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10257G));
                        i7 = 1;
                        break;
                    case 31:
                        str4 = str5;
                        hVar.b(31, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10260K));
                        i7 = 1;
                        break;
                    case 34:
                        str4 = str5;
                        hVar.b(34, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10258H));
                        i7 = 1;
                        break;
                    case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                        str4 = str5;
                        hVar.a(37, typedArrayObtainStyledAttributes.getFloat(index, jVar.f10311x));
                        i7 = 1;
                        break;
                    case 38:
                        str4 = str5;
                        int resourceId = typedArrayObtainStyledAttributes.getResourceId(index, iVar.f10244a);
                        iVar.f10244a = resourceId;
                        hVar.b(38, resourceId);
                        i7 = 1;
                        break;
                    case 39:
                        str4 = str5;
                        hVar.a(39, typedArrayObtainStyledAttributes.getFloat(index, jVar.f10270U));
                        i7 = 1;
                        break;
                    case 40:
                        str4 = str5;
                        hVar.a(40, typedArrayObtainStyledAttributes.getFloat(index, jVar.f10269T));
                        i7 = 1;
                        break;
                    case 41:
                        str4 = str5;
                        hVar.b(41, typedArrayObtainStyledAttributes.getInt(index, jVar.f10271V));
                        i7 = 1;
                        break;
                    case 42:
                        str4 = str5;
                        hVar.b(42, typedArrayObtainStyledAttributes.getInt(index, jVar.f10272W));
                        i7 = 1;
                        break;
                    case 43:
                        str4 = str5;
                        hVar.a(43, typedArrayObtainStyledAttributes.getFloat(index, lVar.f10324c));
                        i7 = 1;
                        break;
                    case 44:
                        str4 = str5;
                        hVar.d(44, true);
                        hVar.a(44, typedArrayObtainStyledAttributes.getDimension(index, mVar.f10336m));
                        i7 = 1;
                        break;
                    case 45:
                        str4 = str5;
                        hVar.a(45, typedArrayObtainStyledAttributes.getFloat(index, mVar.f10327b));
                        i7 = 1;
                        break;
                    case 46:
                        str4 = str5;
                        hVar.a(46, typedArrayObtainStyledAttributes.getFloat(index, mVar.f10328c));
                        i7 = 1;
                        break;
                    case 47:
                        str4 = str5;
                        hVar.a(47, typedArrayObtainStyledAttributes.getFloat(index, mVar.f10329d));
                        i7 = 1;
                        break;
                    case 48:
                        str4 = str5;
                        hVar.a(48, typedArrayObtainStyledAttributes.getFloat(index, mVar.f10330e));
                        i7 = 1;
                        break;
                    case 49:
                        str4 = str5;
                        hVar.a(49, typedArrayObtainStyledAttributes.getDimension(index, mVar.f10331f));
                        i7 = 1;
                        break;
                    case 50:
                        str4 = str5;
                        hVar.a(50, typedArrayObtainStyledAttributes.getDimension(index, mVar.g));
                        i7 = 1;
                        break;
                    case 51:
                        str4 = str5;
                        hVar.a(51, typedArrayObtainStyledAttributes.getDimension(index, mVar.f10332i));
                        i7 = 1;
                        break;
                    case 52:
                        str4 = str5;
                        hVar.a(52, typedArrayObtainStyledAttributes.getDimension(index, mVar.f10333j));
                        i7 = 1;
                        break;
                    case 53:
                        str4 = str5;
                        hVar.a(53, typedArrayObtainStyledAttributes.getDimension(index, mVar.f10334k));
                        i7 = 1;
                        break;
                    case 54:
                        str4 = str5;
                        hVar.b(54, typedArrayObtainStyledAttributes.getInt(index, jVar.f10273X));
                        i7 = 1;
                        break;
                    case 55:
                        str4 = str5;
                        hVar.b(55, typedArrayObtainStyledAttributes.getInt(index, jVar.f10274Y));
                        i7 = 1;
                        break;
                    case 56:
                        str4 = str5;
                        hVar.b(56, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10275Z));
                        i7 = 1;
                        break;
                    case 57:
                        str4 = str5;
                        hVar.b(57, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10277a0));
                        i7 = 1;
                        break;
                    case 58:
                        str4 = str5;
                        hVar.b(58, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10279b0));
                        i7 = 1;
                        break;
                    case 59:
                        str4 = str5;
                        hVar.b(59, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10281c0));
                        i7 = 1;
                        break;
                    case 60:
                        str4 = str5;
                        hVar.a(60, typedArrayObtainStyledAttributes.getFloat(index, mVar.f10326a));
                        i7 = 1;
                        break;
                    case 62:
                        str4 = str5;
                        hVar.b(62, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10251A));
                        i7 = 1;
                        break;
                    case 63:
                        str4 = str5;
                        hVar.a(63, typedArrayObtainStyledAttributes.getFloat(index, jVar.f10252B));
                        i7 = 1;
                        break;
                    case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                        str4 = str5;
                        hVar.b(64, f(typedArrayObtainStyledAttributes, index, kVar.f10315a));
                        i7 = 1;
                        break;
                    case 65:
                        str4 = str5;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            hVar.c(65, typedArrayObtainStyledAttributes.getString(index));
                        } else {
                            hVar.c(65, strArr[typedArrayObtainStyledAttributes.getInteger(index, 0)]);
                        }
                        i7 = 1;
                        break;
                    case 66:
                        str4 = str5;
                        hVar.b(66, typedArrayObtainStyledAttributes.getInt(index, 0));
                        i7 = 1;
                        break;
                    case 67:
                        str4 = str5;
                        hVar.a(67, typedArrayObtainStyledAttributes.getFloat(index, kVar.f10319e));
                        i7 = 1;
                        break;
                    case 68:
                        str4 = str5;
                        hVar.a(68, typedArrayObtainStyledAttributes.getFloat(index, lVar.f10325d));
                        i7 = 1;
                        break;
                    case 69:
                        str4 = str5;
                        hVar.a(69, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        i7 = 1;
                        break;
                    case 70:
                        str4 = str5;
                        hVar.a(70, typedArrayObtainStyledAttributes.getFloat(index, 1.0f));
                        i7 = 1;
                        break;
                    case 71:
                        str4 = str5;
                        Log.e("ConstraintSet", "CURRENTLY UNSUPPORTED");
                        i7 = 1;
                        break;
                    case 72:
                        str4 = str5;
                        hVar.b(72, typedArrayObtainStyledAttributes.getInt(index, jVar.f10287f0));
                        i7 = 1;
                        break;
                    case 73:
                        str4 = str5;
                        hVar.b(73, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10288g0));
                        i7 = 1;
                        break;
                    case 74:
                        str4 = str5;
                        hVar.c(74, typedArrayObtainStyledAttributes.getString(index));
                        i7 = 1;
                        break;
                    case 75:
                        str4 = str5;
                        hVar.d(75, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f10300n0));
                        i7 = 1;
                        break;
                    case 76:
                        str4 = str5;
                        hVar.b(76, typedArrayObtainStyledAttributes.getInt(index, kVar.f10317c));
                        i7 = 1;
                        break;
                    case 77:
                        str4 = str5;
                        hVar.c(77, typedArrayObtainStyledAttributes.getString(index));
                        i7 = 1;
                        break;
                    case 78:
                        str4 = str5;
                        hVar.b(78, typedArrayObtainStyledAttributes.getInt(index, lVar.f10323b));
                        i7 = 1;
                        break;
                    case 79:
                        str4 = str5;
                        hVar.a(79, typedArrayObtainStyledAttributes.getFloat(index, kVar.f10318d));
                        i7 = 1;
                        break;
                    case 80:
                        str4 = str5;
                        hVar.d(80, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f10297l0));
                        i7 = 1;
                        break;
                    case 81:
                        str4 = str5;
                        hVar.d(81, typedArrayObtainStyledAttributes.getBoolean(index, jVar.f10299m0));
                        i7 = 1;
                        break;
                    case 82:
                        str4 = str5;
                        hVar.b(82, typedArrayObtainStyledAttributes.getInteger(index, kVar.f10316b));
                        i7 = 1;
                        break;
                    case 83:
                        str4 = str5;
                        hVar.b(83, f(typedArrayObtainStyledAttributes, index, mVar.h));
                        i7 = 1;
                        break;
                    case 84:
                        str4 = str5;
                        hVar.b(84, typedArrayObtainStyledAttributes.getInteger(index, kVar.g));
                        i7 = 1;
                        break;
                    case 85:
                        str4 = str5;
                        hVar.a(85, typedArrayObtainStyledAttributes.getFloat(index, kVar.f10320f));
                        i7 = 1;
                        break;
                    case 86:
                        str4 = str5;
                        int i10 = typedArrayObtainStyledAttributes.peekValue(index).type;
                        if (i10 == 1) {
                            int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                            kVar.f10321i = resourceId2;
                            hVar.b(89, resourceId2);
                            if (kVar.f10321i != -1) {
                                hVar.b(88, -2);
                            }
                        } else if (i10 == 3) {
                            String string = typedArrayObtainStyledAttributes.getString(index);
                            kVar.h = string;
                            hVar.c(90, string);
                            if (kVar.h.indexOf("/") > 0) {
                                int resourceId3 = typedArrayObtainStyledAttributes.getResourceId(index, -1);
                                kVar.f10321i = resourceId3;
                                hVar.b(89, resourceId3);
                                hVar.b(88, -2);
                            } else {
                                hVar.b(88, -1);
                            }
                        } else {
                            hVar.b(88, typedArrayObtainStyledAttributes.getInteger(index, kVar.f10321i));
                        }
                        i7 = 1;
                        break;
                    case 87:
                        str4 = str5;
                        Log.w("ConstraintSet", "unused attribute 0x" + Integer.toHexString(index) + "   " + sparseIntArray.get(index));
                        i7 = 1;
                        break;
                    case 93:
                        str4 = str5;
                        hVar.b(93, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10261L));
                        i7 = 1;
                        break;
                    case 94:
                        str4 = str5;
                        hVar.b(94, typedArrayObtainStyledAttributes.getDimensionPixelSize(index, jVar.f10268S));
                        i7 = 1;
                        break;
                    case 95:
                        str4 = str5;
                        g(hVar, typedArrayObtainStyledAttributes, index, 0);
                        i7 = 1;
                        break;
                    case 96:
                        str4 = str5;
                        i7 = 1;
                        g(hVar, typedArrayObtainStyledAttributes, index, 1);
                        break;
                    case 97:
                        str4 = str5;
                        hVar.b(97, typedArrayObtainStyledAttributes.getInt(index, jVar.f10302o0));
                        i7 = 1;
                        break;
                    case 98:
                        str4 = str5;
                        int i11 = AbstractC0923a.f10032u;
                        if (typedArrayObtainStyledAttributes.peekValue(index).type == 3) {
                            typedArrayObtainStyledAttributes.getString(index);
                        } else {
                            iVar.f10244a = typedArrayObtainStyledAttributes.getResourceId(index, iVar.f10244a);
                        }
                        i7 = 1;
                        break;
                    case 99:
                        str4 = str5;
                        hVar.d(99, typedArrayObtainStyledAttributes.getBoolean(index, jVar.g));
                        i7 = 1;
                        break;
                }
                i8 += i7;
                indexCount = i9;
                str5 = str4;
            }
        } else {
            String str7 = "CURRENTLY UNSUPPORTED";
            String str8 = "Unknown attribute 0x";
            int i12 = 1;
            int indexCount2 = typedArrayObtainStyledAttributes.getIndexCount();
            int i13 = 0;
            while (i13 < indexCount2) {
                int index2 = typedArrayObtainStyledAttributes.getIndex(i13);
                if (index2 != i12 && 23 != index2 && 24 != index2) {
                    kVar.getClass();
                    jVar.getClass();
                    lVar.getClass();
                    mVar.getClass();
                }
                switch (sparseIntArray.get(index2)) {
                    case 1:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10303p = f(typedArrayObtainStyledAttributes, index2, jVar.f10303p);
                        i6 = 1;
                        break;
                    case 2:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.I = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.I);
                        i6 = 1;
                        break;
                    case 3:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10301o = f(typedArrayObtainStyledAttributes, index2, jVar.f10301o);
                        i6 = 1;
                        break;
                    case 4:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.n = f(typedArrayObtainStyledAttributes, index2, jVar.n);
                        i6 = 1;
                        break;
                    case 5:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10312y = typedArrayObtainStyledAttributes.getString(index2);
                        i6 = 1;
                        break;
                    case 6:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10253C = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f10253C);
                        i6 = 1;
                        break;
                    case 7:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10254D = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f10254D);
                        i6 = 1;
                        break;
                    case 8:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10259J = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10259J);
                        i6 = 1;
                        break;
                    case 9:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10309v = f(typedArrayObtainStyledAttributes, index2, jVar.f10309v);
                        i6 = 1;
                        break;
                    case 10:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10308u = f(typedArrayObtainStyledAttributes, index2, jVar.f10308u);
                        i6 = 1;
                        break;
                    case 11:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10265P = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10265P);
                        i6 = 1;
                        break;
                    case FileClientSessionCache.MAX_SIZE /* 12 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10266Q = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10266Q);
                        i6 = 1;
                        break;
                    case o1.f.ERROR /* 13 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10262M = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10262M);
                        i6 = 1;
                        break;
                    case o1.f.INTERRUPTED /* 14 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10264O = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10264O);
                        i6 = 1;
                        break;
                    case 15:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10267R = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10267R);
                        i6 = 1;
                        break;
                    case 16:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10263N = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10263N);
                        i6 = 1;
                        break;
                    case o1.f.API_NOT_CONNECTED /* 17 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10282d = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f10282d);
                        i6 = 1;
                        break;
                    case 18:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10284e = typedArrayObtainStyledAttributes.getDimensionPixelOffset(index2, jVar.f10284e);
                        i6 = 1;
                        break;
                    case o1.f.REMOTE_EXCEPTION /* 19 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10286f = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f10286f);
                        i6 = 1;
                        break;
                    case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10310w = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f10310w);
                        i6 = 1;
                        break;
                    case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10280c = typedArrayObtainStyledAttributes.getLayoutDimension(index2, jVar.f10280c);
                        i6 = 1;
                        break;
                    case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        int i14 = typedArrayObtainStyledAttributes.getInt(index2, lVar.f10322a);
                        lVar.f10322a = i14;
                        lVar.f10322a = iArr[i14];
                        i6 = 1;
                        break;
                    case 23:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10278b = typedArrayObtainStyledAttributes.getLayoutDimension(index2, jVar.f10278b);
                        i6 = 1;
                        break;
                    case 24:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10256F = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10256F);
                        i6 = 1;
                        break;
                    case 25:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.h = f(typedArrayObtainStyledAttributes, index2, jVar.h);
                        i6 = 1;
                        break;
                    case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10290i = f(typedArrayObtainStyledAttributes, index2, jVar.f10290i);
                        i6 = 1;
                        break;
                    case 27:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10255E = typedArrayObtainStyledAttributes.getInt(index2, jVar.f10255E);
                        i6 = 1;
                        break;
                    case 28:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10257G = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10257G);
                        i6 = 1;
                        break;
                    case 29:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10292j = f(typedArrayObtainStyledAttributes, index2, jVar.f10292j);
                        i6 = 1;
                        break;
                    case 30:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10294k = f(typedArrayObtainStyledAttributes, index2, jVar.f10294k);
                        i6 = 1;
                        break;
                    case 31:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10260K = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10260K);
                        i6 = 1;
                        break;
                    case 32:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10306s = f(typedArrayObtainStyledAttributes, index2, jVar.f10306s);
                        i6 = 1;
                        break;
                    case 33:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10307t = f(typedArrayObtainStyledAttributes, index2, jVar.f10307t);
                        i6 = 1;
                        break;
                    case 34:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10258H = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10258H);
                        i6 = 1;
                        break;
                    case 35:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10298m = f(typedArrayObtainStyledAttributes, index2, jVar.f10298m);
                        i6 = 1;
                        break;
                    case 36:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10296l = f(typedArrayObtainStyledAttributes, index2, jVar.f10296l);
                        i6 = 1;
                        break;
                    case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10311x = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f10311x);
                        i6 = 1;
                        break;
                    case 38:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        iVar.f10244a = typedArrayObtainStyledAttributes.getResourceId(index2, iVar.f10244a);
                        i6 = 1;
                        break;
                    case 39:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10270U = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f10270U);
                        i6 = 1;
                        break;
                    case 40:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10269T = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f10269T);
                        i6 = 1;
                        break;
                    case 41:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10271V = typedArrayObtainStyledAttributes.getInt(index2, jVar.f10271V);
                        i6 = 1;
                        break;
                    case 42:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10272W = typedArrayObtainStyledAttributes.getInt(index2, jVar.f10272W);
                        i6 = 1;
                        break;
                    case 43:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        lVar.f10324c = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f10324c);
                        i6 = 1;
                        break;
                    case 44:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10335l = true;
                        mVar.f10336m = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f10336m);
                        i6 = 1;
                        break;
                    case 45:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10327b = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f10327b);
                        i6 = 1;
                        break;
                    case 46:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10328c = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f10328c);
                        i6 = 1;
                        break;
                    case 47:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10329d = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f10329d);
                        i6 = 1;
                        break;
                    case 48:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10330e = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f10330e);
                        i6 = 1;
                        break;
                    case 49:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10331f = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f10331f);
                        i6 = 1;
                        break;
                    case 50:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.g = typedArrayObtainStyledAttributes.getDimension(index2, mVar.g);
                        i6 = 1;
                        break;
                    case 51:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10332i = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f10332i);
                        i6 = 1;
                        break;
                    case 52:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10333j = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f10333j);
                        i6 = 1;
                        break;
                    case 53:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10334k = typedArrayObtainStyledAttributes.getDimension(index2, mVar.f10334k);
                        i6 = 1;
                        break;
                    case 54:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10273X = typedArrayObtainStyledAttributes.getInt(index2, jVar.f10273X);
                        i6 = 1;
                        break;
                    case 55:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10274Y = typedArrayObtainStyledAttributes.getInt(index2, jVar.f10274Y);
                        i6 = 1;
                        break;
                    case 56:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10275Z = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10275Z);
                        i6 = 1;
                        break;
                    case 57:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10277a0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10277a0);
                        i6 = 1;
                        break;
                    case 58:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10279b0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10279b0);
                        i6 = 1;
                        break;
                    case 59:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10281c0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10281c0);
                        i6 = 1;
                        break;
                    case 60:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        mVar.f10326a = typedArrayObtainStyledAttributes.getFloat(index2, mVar.f10326a);
                        i6 = 1;
                        break;
                    case 61:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10313z = f(typedArrayObtainStyledAttributes, index2, jVar.f10313z);
                        i6 = 1;
                        break;
                    case 62:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10251A = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10251A);
                        i6 = 1;
                        break;
                    case 63:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        jVar.f10252B = typedArrayObtainStyledAttributes.getFloat(index2, jVar.f10252B);
                        i6 = 1;
                        break;
                    case WebSocketProtocol.B0_FLAG_RSV1 /* 64 */:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        kVar.f10315a = f(typedArrayObtainStyledAttributes, index2, kVar.f10315a);
                        i6 = 1;
                        break;
                    case 65:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        str3 = str6;
                        if (typedArrayObtainStyledAttributes.peekValue(index2).type != 3) {
                            String str9 = strArr[typedArrayObtainStyledAttributes.getInteger(index2, 0)];
                            kVar.getClass();
                            i6 = 1;
                            break;
                        } else {
                            typedArrayObtainStyledAttributes.getString(index2);
                            kVar.getClass();
                            i6 = 1;
                            break;
                        }
                    case 66:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        typedArrayObtainStyledAttributes.getInt(index2, 0);
                        kVar.getClass();
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 67:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        kVar.f10319e = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f10319e);
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 68:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        lVar.f10325d = typedArrayObtainStyledAttributes.getFloat(index2, lVar.f10325d);
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 69:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        jVar.f10283d0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 70:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        jVar.f10285e0 = typedArrayObtainStyledAttributes.getFloat(index2, 1.0f);
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 71:
                        i5 = indexCount2;
                        str = str7;
                        str2 = str8;
                        Log.e(str6, str);
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 72:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10287f0 = typedArrayObtainStyledAttributes.getInt(index2, jVar.f10287f0);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 73:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10288g0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10288g0);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 74:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10293j0 = typedArrayObtainStyledAttributes.getString(index2);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 75:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10300n0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f10300n0);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 76:
                        i5 = indexCount2;
                        str2 = str8;
                        kVar.f10317c = typedArrayObtainStyledAttributes.getInt(index2, kVar.f10317c);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 77:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10295k0 = typedArrayObtainStyledAttributes.getString(index2);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 78:
                        i5 = indexCount2;
                        str2 = str8;
                        lVar.f10323b = typedArrayObtainStyledAttributes.getInt(index2, lVar.f10323b);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 79:
                        i5 = indexCount2;
                        str2 = str8;
                        kVar.f10318d = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f10318d);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 80:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10297l0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f10297l0);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 81:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10299m0 = typedArrayObtainStyledAttributes.getBoolean(index2, jVar.f10299m0);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 82:
                        i5 = indexCount2;
                        str2 = str8;
                        kVar.f10316b = typedArrayObtainStyledAttributes.getInteger(index2, kVar.f10316b);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 83:
                        i5 = indexCount2;
                        str2 = str8;
                        mVar.h = f(typedArrayObtainStyledAttributes, index2, mVar.h);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 84:
                        i5 = indexCount2;
                        str2 = str8;
                        kVar.g = typedArrayObtainStyledAttributes.getInteger(index2, kVar.g);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 85:
                        i5 = indexCount2;
                        str2 = str8;
                        kVar.f10320f = typedArrayObtainStyledAttributes.getFloat(index2, kVar.f10320f);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 86:
                        i5 = indexCount2;
                        str2 = str8;
                        int i15 = typedArrayObtainStyledAttributes.peekValue(index2).type;
                        if (i15 == 1) {
                            kVar.f10321i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                        } else if (i15 == 3) {
                            String string2 = typedArrayObtainStyledAttributes.getString(index2);
                            kVar.h = string2;
                            if (string2.indexOf("/") > 0) {
                                kVar.f10321i = typedArrayObtainStyledAttributes.getResourceId(index2, -1);
                            }
                        } else {
                            typedArrayObtainStyledAttributes.getInteger(index2, kVar.f10321i);
                        }
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 87:
                        i5 = indexCount2;
                        str2 = str8;
                        Log.w(str6, "unused attribute 0x" + Integer.toHexString(index2) + "   " + sparseIntArray.get(index2));
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 88:
                    case 89:
                    case 90:
                    default:
                        str2 = str8;
                        StringBuilder sb2 = new StringBuilder(str2);
                        i5 = indexCount2;
                        sb2.append(Integer.toHexString(index2));
                        sb2.append("   ");
                        sb2.append(sparseIntArray.get(index2));
                        Log.w(str6, sb2.toString());
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 91:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10304q = f(typedArrayObtainStyledAttributes, index2, jVar.f10304q);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 92:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10305r = f(typedArrayObtainStyledAttributes, index2, jVar.f10305r);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 93:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10261L = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10261L);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 94:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10268S = typedArrayObtainStyledAttributes.getDimensionPixelSize(index2, jVar.f10268S);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 95:
                        i5 = indexCount2;
                        str2 = str8;
                        g(jVar, typedArrayObtainStyledAttributes, index2, 0);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 96:
                        i5 = indexCount2;
                        str2 = str8;
                        g(jVar, typedArrayObtainStyledAttributes, index2, 1);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                    case 97:
                        i5 = indexCount2;
                        str2 = str8;
                        jVar.f10302o0 = typedArrayObtainStyledAttributes.getInt(index2, jVar.f10302o0);
                        str = str7;
                        str3 = str6;
                        i6 = 1;
                        break;
                }
                i13 += i6;
                indexCount2 = i5;
                str8 = str2;
                String str10 = str;
                i12 = i6;
                str6 = str3;
                str7 = str10;
            }
            if (jVar.f10293j0 != null) {
                jVar.f10291i0 = null;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return iVar;
    }

    public static int f(TypedArray typedArray, int i5, int i6) {
        int resourceId = typedArray.getResourceId(i5, i6);
        return resourceId == -1 ? typedArray.getInt(i5, -1) : resourceId;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void g(java.lang.Object r7, android.content.res.TypedArray r8, int r9, int r10) {
        /*
            Method dump skipped, instructions count: 376
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x.n.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(e eVar, String str) {
        if (str != null) {
            int length = str.length();
            int iIndexOf = str.indexOf(44);
            int i5 = -1;
            if (iIndexOf > 0 && iIndexOf < length - 1) {
                String strSubstring = str.substring(0, iIndexOf);
                i5 = strSubstring.equalsIgnoreCase("W") ? 0 : strSubstring.equalsIgnoreCase("H") ? 1 : -1;
                i = iIndexOf + 1;
            }
            int iIndexOf2 = str.indexOf(58);
            try {
                if (iIndexOf2 < 0 || iIndexOf2 >= length - 1) {
                    String strSubstring2 = str.substring(i);
                    if (strSubstring2.length() > 0) {
                        Float.parseFloat(strSubstring2);
                    }
                } else {
                    String strSubstring3 = str.substring(i, iIndexOf2);
                    String strSubstring4 = str.substring(iIndexOf2 + 1);
                    if (strSubstring3.length() > 0 && strSubstring4.length() > 0) {
                        float f5 = Float.parseFloat(strSubstring3);
                        float f6 = Float.parseFloat(strSubstring4);
                        if (f5 > BitmapDescriptorFactory.HUE_RED && f6 > BitmapDescriptorFactory.HUE_RED) {
                            if (i5 == 1) {
                                Math.abs(f6 / f5);
                            } else {
                                Math.abs(f5 / f6);
                            }
                        }
                    }
                }
            } catch (NumberFormatException unused) {
            }
        }
        eVar.f10165G = str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void a(ConstraintLayout constraintLayout) {
        int i5;
        HashMap map;
        String strS;
        int i6;
        String resourceEntryName;
        n nVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map2 = nVar.f10342c;
        HashSet hashSet = new HashSet(map2.keySet());
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = constraintLayout.getChildAt(i7);
            int id = childAt.getId();
            if (!map2.containsKey(Integer.valueOf(id))) {
                StringBuilder sb = new StringBuilder("id unknown ");
                try {
                    resourceEntryName = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    resourceEntryName = "UNKNOWN";
                }
                sb.append(resourceEntryName);
                Log.w("ConstraintSet", sb.toString());
            } else {
                if (nVar.f10341b && id == -1) {
                    throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
                }
                if (id != -1) {
                    if (map2.containsKey(Integer.valueOf(id))) {
                        hashSet.remove(Integer.valueOf(id));
                        i iVar = (i) map2.get(Integer.valueOf(id));
                        if (iVar != null) {
                            if (childAt instanceof C0943a) {
                                j jVar = iVar.f10247d;
                                jVar.f10289h0 = 1;
                                C0943a c0943a = (C0943a) childAt;
                                c0943a.setId(id);
                                c0943a.setType(jVar.f10287f0);
                                c0943a.setMargin(jVar.f10288g0);
                                c0943a.setAllowsGoneWidget(jVar.f10300n0);
                                int[] iArr = jVar.f10291i0;
                                if (iArr != null) {
                                    c0943a.setReferencedIds(iArr);
                                } else {
                                    String str = jVar.f10293j0;
                                    if (str != null) {
                                        int[] iArrC = c(c0943a, str);
                                        jVar.f10291i0 = iArrC;
                                        c0943a.setReferencedIds(iArrC);
                                    }
                                }
                            }
                            e eVar = (e) childAt.getLayoutParams();
                            eVar.a();
                            iVar.a(eVar);
                            HashMap map3 = iVar.f10249f;
                            Class<?> cls = childAt.getClass();
                            for (String str2 : map3.keySet()) {
                                C0944b c0944b = (C0944b) map3.get(str2);
                                if (c0944b.f10147a) {
                                    map = map3;
                                    strS = str2;
                                } else {
                                    strS = com.unified.ur1.SatelliteTracker.h.s("set", str2);
                                    map = map3;
                                }
                                try {
                                    switch (AbstractC0882e.c(c0944b.f10148b)) {
                                        case 0:
                                            i6 = childCount;
                                            cls.getMethod(strS, Integer.TYPE).invoke(childAt, Integer.valueOf(c0944b.f10149c));
                                            break;
                                        case 1:
                                            i6 = childCount;
                                            cls.getMethod(strS, Float.TYPE).invoke(childAt, Float.valueOf(c0944b.f10150d));
                                            break;
                                        case 2:
                                            i6 = childCount;
                                            cls.getMethod(strS, Integer.TYPE).invoke(childAt, Integer.valueOf(c0944b.g));
                                            break;
                                        case 3:
                                            Method method = cls.getMethod(strS, Drawable.class);
                                            i6 = childCount;
                                            try {
                                                ColorDrawable colorDrawable = new ColorDrawable();
                                                colorDrawable.setColor(c0944b.g);
                                                method.invoke(childAt, colorDrawable);
                                            } catch (IllegalAccessException e5) {
                                                e = e5;
                                                StringBuilder sbM = AbstractC0535a.m(" Custom Attribute \"", str2, "\" not found on ");
                                                sbM.append(cls.getName());
                                                Log.e("TransitionLayout", sbM.toString());
                                                e.printStackTrace();
                                                map3 = map;
                                                childCount = i6;
                                            } catch (NoSuchMethodException e6) {
                                                e = e6;
                                                Log.e("TransitionLayout", e.getMessage());
                                                Log.e("TransitionLayout", " Custom Attribute \"" + str2 + "\" not found on " + cls.getName());
                                                Log.e("TransitionLayout", cls.getName() + " must have a method " + strS);
                                                map3 = map;
                                                childCount = i6;
                                            } catch (InvocationTargetException e7) {
                                                e = e7;
                                                StringBuilder sbM2 = AbstractC0535a.m(" Custom Attribute \"", str2, "\" not found on ");
                                                sbM2.append(cls.getName());
                                                Log.e("TransitionLayout", sbM2.toString());
                                                e.printStackTrace();
                                                map3 = map;
                                                childCount = i6;
                                            }
                                        case 4:
                                            cls.getMethod(strS, CharSequence.class).invoke(childAt, c0944b.f10151e);
                                            i6 = childCount;
                                            break;
                                        case 5:
                                            cls.getMethod(strS, Boolean.TYPE).invoke(childAt, Boolean.valueOf(c0944b.f10152f));
                                            i6 = childCount;
                                            break;
                                        case 6:
                                            cls.getMethod(strS, Float.TYPE).invoke(childAt, Float.valueOf(c0944b.f10150d));
                                            i6 = childCount;
                                            break;
                                        case 7:
                                            cls.getMethod(strS, Integer.TYPE).invoke(childAt, Integer.valueOf(c0944b.f10149c));
                                            i6 = childCount;
                                            break;
                                        default:
                                            i6 = childCount;
                                            break;
                                    }
                                } catch (IllegalAccessException e8) {
                                    e = e8;
                                    i6 = childCount;
                                } catch (NoSuchMethodException e9) {
                                    e = e9;
                                    i6 = childCount;
                                } catch (InvocationTargetException e10) {
                                    e = e10;
                                    i6 = childCount;
                                }
                                map3 = map;
                                childCount = i6;
                            }
                            i5 = childCount;
                            childAt.setLayoutParams(eVar);
                            l lVar = iVar.f10245b;
                            if (lVar.f10323b == 0) {
                                childAt.setVisibility(lVar.f10322a);
                            }
                            childAt.setAlpha(lVar.f10324c);
                            m mVar = iVar.f10248e;
                            childAt.setRotation(mVar.f10326a);
                            childAt.setRotationX(mVar.f10327b);
                            childAt.setRotationY(mVar.f10328c);
                            childAt.setScaleX(mVar.f10329d);
                            childAt.setScaleY(mVar.f10330e);
                            if (mVar.h != -1) {
                                if (((View) childAt.getParent()).findViewById(mVar.h) != null) {
                                    float bottom = (r1.getBottom() + r1.getTop()) / 2.0f;
                                    float right = (r1.getRight() + r1.getLeft()) / 2.0f;
                                    if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                        childAt.setPivotX(right - childAt.getLeft());
                                        childAt.setPivotY(bottom - childAt.getTop());
                                    }
                                }
                            } else {
                                if (!Float.isNaN(mVar.f10331f)) {
                                    childAt.setPivotX(mVar.f10331f);
                                }
                                if (!Float.isNaN(mVar.g)) {
                                    childAt.setPivotY(mVar.g);
                                }
                            }
                            childAt.setTranslationX(mVar.f10332i);
                            childAt.setTranslationY(mVar.f10333j);
                            childAt.setTranslationZ(mVar.f10334k);
                            if (mVar.f10335l) {
                                childAt.setElevation(mVar.f10336m);
                            }
                        }
                    } else {
                        i5 = childCount;
                        Log.v("ConstraintSet", "WARNING NO CONSTRAINTS for view " + id);
                    }
                }
                i7++;
                nVar = this;
                childCount = i5;
            }
            i5 = childCount;
            i7++;
            nVar = this;
            childCount = i5;
        }
        int i8 = childCount;
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            i iVar2 = (i) map2.get(num);
            if (iVar2 != null) {
                j jVar2 = iVar2.f10247d;
                if (jVar2.f10289h0 == 1) {
                    Context context = constraintLayout.getContext();
                    C0943a c0943a2 = new C0943a(context);
                    c0943a2.f10153c = new int[32];
                    c0943a2.f10157i = new HashMap();
                    c0943a2.f10155e = context;
                    c0943a2.g(null);
                    c0943a2.setVisibility(8);
                    c0943a2.setId(num.intValue());
                    int[] iArr2 = jVar2.f10291i0;
                    if (iArr2 != null) {
                        c0943a2.setReferencedIds(iArr2);
                    } else {
                        String str3 = jVar2.f10293j0;
                        if (str3 != null) {
                            int[] iArrC2 = c(c0943a2, str3);
                            jVar2.f10291i0 = iArrC2;
                            c0943a2.setReferencedIds(iArrC2);
                        }
                    }
                    c0943a2.setType(jVar2.f10287f0);
                    c0943a2.setMargin(jVar2.f10288g0);
                    e eVarG = ConstraintLayout.g();
                    c0943a2.i();
                    iVar2.a(eVarG);
                    constraintLayout.addView(c0943a2, eVarG);
                }
                if (jVar2.f10276a) {
                    View pVar = new p(constraintLayout.getContext());
                    pVar.setId(num.intValue());
                    e eVarG2 = ConstraintLayout.g();
                    iVar2.a(eVarG2);
                    constraintLayout.addView(pVar, eVarG2);
                }
            }
        }
        for (int i9 = 0; i9 < i8; i9++) {
            View childAt2 = constraintLayout.getChildAt(i9);
            if (childAt2 instanceof c) {
                ((c) childAt2).e(constraintLayout);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        n nVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap map = nVar.f10342c;
        map.clear();
        int i5 = 0;
        while (i5 < childCount) {
            View childAt = constraintLayout.getChildAt(i5);
            e eVar = (e) childAt.getLayoutParams();
            int id = childAt.getId();
            if (nVar.f10341b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
            if (!map.containsKey(Integer.valueOf(id))) {
                map.put(Integer.valueOf(id), new i());
            }
            i iVar = (i) map.get(Integer.valueOf(id));
            if (iVar != null) {
                HashMap map2 = nVar.f10340a;
                HashMap map3 = new HashMap();
                Class<?> cls = childAt.getClass();
                for (String str : map2.keySet()) {
                    C0944b c0944b = (C0944b) map2.get(str);
                    try {
                        if (str.equals("BackgroundColor")) {
                            map3.put(str, new C0944b(c0944b, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor())));
                        } else {
                            map3.put(str, new C0944b(c0944b, cls.getMethod("getMap" + str, null).invoke(childAt, null)));
                        }
                    } catch (IllegalAccessException e5) {
                        e5.printStackTrace();
                    } catch (NoSuchMethodException e6) {
                        e6.printStackTrace();
                    } catch (InvocationTargetException e7) {
                        e7.printStackTrace();
                    }
                }
                iVar.f10249f = map3;
                iVar.f10244a = id;
                int i6 = eVar.f10192e;
                j jVar = iVar.f10247d;
                jVar.h = i6;
                jVar.f10290i = eVar.f10194f;
                jVar.f10292j = eVar.g;
                jVar.f10294k = eVar.h;
                jVar.f10296l = eVar.f10198i;
                jVar.f10298m = eVar.f10200j;
                jVar.n = eVar.f10202k;
                jVar.f10301o = eVar.f10204l;
                jVar.f10303p = eVar.f10206m;
                jVar.f10304q = eVar.n;
                jVar.f10305r = eVar.f10209o;
                jVar.f10306s = eVar.f10215s;
                jVar.f10307t = eVar.f10216t;
                jVar.f10308u = eVar.f10217u;
                jVar.f10309v = eVar.f10218v;
                jVar.f10310w = eVar.f10163E;
                jVar.f10311x = eVar.f10164F;
                jVar.f10312y = eVar.f10165G;
                jVar.f10313z = eVar.f10211p;
                jVar.f10251A = eVar.f10213q;
                jVar.f10252B = eVar.f10214r;
                jVar.f10253C = eVar.f10177T;
                jVar.f10254D = eVar.f10178U;
                jVar.f10255E = eVar.f10179V;
                jVar.f10286f = eVar.f10188c;
                jVar.f10282d = eVar.f10184a;
                jVar.f10284e = eVar.f10186b;
                jVar.f10278b = ((ViewGroup.MarginLayoutParams) eVar).width;
                jVar.f10280c = ((ViewGroup.MarginLayoutParams) eVar).height;
                jVar.f10256F = ((ViewGroup.MarginLayoutParams) eVar).leftMargin;
                jVar.f10257G = ((ViewGroup.MarginLayoutParams) eVar).rightMargin;
                jVar.f10258H = ((ViewGroup.MarginLayoutParams) eVar).topMargin;
                jVar.I = ((ViewGroup.MarginLayoutParams) eVar).bottomMargin;
                jVar.f10261L = eVar.f10162D;
                jVar.f10269T = eVar.I;
                jVar.f10270U = eVar.f10166H;
                jVar.f10272W = eVar.f10168K;
                jVar.f10271V = eVar.f10167J;
                jVar.f10297l0 = eVar.f10180W;
                jVar.f10299m0 = eVar.f10181X;
                jVar.f10273X = eVar.f10169L;
                jVar.f10274Y = eVar.f10170M;
                jVar.f10275Z = eVar.f10173P;
                jVar.f10277a0 = eVar.f10174Q;
                jVar.f10279b0 = eVar.f10171N;
                jVar.f10281c0 = eVar.f10172O;
                jVar.f10283d0 = eVar.f10175R;
                jVar.f10285e0 = eVar.f10176S;
                jVar.f10295k0 = eVar.f10182Y;
                jVar.f10263N = eVar.f10220x;
                jVar.f10265P = eVar.f10222z;
                jVar.f10262M = eVar.f10219w;
                jVar.f10264O = eVar.f10221y;
                jVar.f10267R = eVar.f10159A;
                jVar.f10266Q = eVar.f10160B;
                jVar.f10268S = eVar.f10161C;
                jVar.f10302o0 = eVar.f10183Z;
                jVar.f10259J = eVar.getMarginEnd();
                jVar.f10260K = eVar.getMarginStart();
                int visibility = childAt.getVisibility();
                l lVar = iVar.f10245b;
                lVar.f10322a = visibility;
                lVar.f10324c = childAt.getAlpha();
                float rotation = childAt.getRotation();
                m mVar = iVar.f10248e;
                mVar.f10326a = rotation;
                mVar.f10327b = childAt.getRotationX();
                mVar.f10328c = childAt.getRotationY();
                mVar.f10329d = childAt.getScaleX();
                mVar.f10330e = childAt.getScaleY();
                float pivotX = childAt.getPivotX();
                float pivotY = childAt.getPivotY();
                if (pivotX != 0.0d || pivotY != 0.0d) {
                    mVar.f10331f = pivotX;
                    mVar.g = pivotY;
                }
                mVar.f10332i = childAt.getTranslationX();
                mVar.f10333j = childAt.getTranslationY();
                mVar.f10334k = childAt.getTranslationZ();
                if (mVar.f10335l) {
                    mVar.f10336m = childAt.getElevation();
                }
                if (childAt instanceof C0943a) {
                    C0943a c0943a = (C0943a) childAt;
                    jVar.f10300n0 = c0943a.getAllowsGoneWidget();
                    jVar.f10291i0 = c0943a.getReferencedIds();
                    jVar.f10287f0 = c0943a.getType();
                    jVar.f10288g0 = c0943a.getMargin();
                }
            }
            i5++;
            nVar = this;
        }
    }

    public final void e(Context context, int i5) {
        XmlResourceParser xml = context.getResources().getXml(i5);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    i iVarD = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        iVarD.f10247d.f10276a = true;
                    }
                    this.f10342c.put(Integer.valueOf(iVarD.f10244a), iVarD);
                }
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        } catch (XmlPullParserException e6) {
            e6.printStackTrace();
        }
    }
}
