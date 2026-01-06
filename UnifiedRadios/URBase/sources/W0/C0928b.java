package w0;

import O.I;
import O.Y;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import java.util.WeakHashMap;

/* renamed from: w0.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0928b extends Property {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10046a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C0928b(Class cls, String str, int i5) {
        super(cls, str);
        this.f10046a = i5;
    }

    @Override // android.util.Property
    public final Object get(Object obj) {
        switch (this.f10046a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return null;
            case 3:
                return null;
            case 4:
                return null;
            case 5:
                return Float.valueOf(w.f10116a.o((View) obj));
            default:
                WeakHashMap weakHashMap = Y.f1904a;
                return I.a((View) obj);
        }
    }

    @Override // android.util.Property
    public final void set(Object obj, Object obj2) {
        switch (this.f10046a) {
            case 0:
                e eVar = (e) obj;
                PointF pointF = (PointF) obj2;
                eVar.getClass();
                eVar.f10049a = Math.round(pointF.x);
                int iRound = Math.round(pointF.y);
                eVar.f10050b = iRound;
                int i5 = eVar.f10054f + 1;
                eVar.f10054f = i5;
                if (i5 == eVar.g) {
                    w.a(eVar.f10053e, eVar.f10049a, iRound, eVar.f10051c, eVar.f10052d);
                    eVar.f10054f = 0;
                    eVar.g = 0;
                    break;
                }
                break;
            case 1:
                e eVar2 = (e) obj;
                PointF pointF2 = (PointF) obj2;
                eVar2.getClass();
                eVar2.f10051c = Math.round(pointF2.x);
                int iRound2 = Math.round(pointF2.y);
                eVar2.f10052d = iRound2;
                int i6 = eVar2.g + 1;
                eVar2.g = i6;
                if (eVar2.f10054f == i6) {
                    w.a(eVar2.f10053e, eVar2.f10049a, eVar2.f10050b, eVar2.f10051c, iRound2);
                    eVar2.f10054f = 0;
                    eVar2.g = 0;
                    break;
                }
                break;
            case 2:
                View view = (View) obj;
                PointF pointF3 = (PointF) obj2;
                w.a(view, view.getLeft(), view.getTop(), Math.round(pointF3.x), Math.round(pointF3.y));
                break;
            case 3:
                View view2 = (View) obj;
                PointF pointF4 = (PointF) obj2;
                w.a(view2, Math.round(pointF4.x), Math.round(pointF4.y), view2.getRight(), view2.getBottom());
                break;
            case 4:
                View view3 = (View) obj;
                PointF pointF5 = (PointF) obj2;
                int iRound3 = Math.round(pointF5.x);
                int iRound4 = Math.round(pointF5.y);
                w.a(view3, iRound3, iRound4, view3.getWidth() + iRound3, view3.getHeight() + iRound4);
                break;
            case 5:
                float fFloatValue = ((Float) obj2).floatValue();
                w.f10116a.E((View) obj, fFloatValue);
                break;
            default:
                WeakHashMap weakHashMap = Y.f1904a;
                I.c((View) obj, (Rect) obj2);
                break;
        }
    }
}
