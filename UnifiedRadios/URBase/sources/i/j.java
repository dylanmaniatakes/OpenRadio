package i;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.SubMenu;
import e.AbstractC0429a;
import j.p;
import java.io.IOException;
import k.AbstractC0636i0;
import okhttp3.internal.http2.Settings;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class j extends MenuInflater {

    /* renamed from: e, reason: collision with root package name */
    public static final Class[] f7171e;

    /* renamed from: f, reason: collision with root package name */
    public static final Class[] f7172f;

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f7173a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f7174b;

    /* renamed from: c, reason: collision with root package name */
    public final Context f7175c;

    /* renamed from: d, reason: collision with root package name */
    public Object f7176d;

    static {
        Class[] clsArr = {Context.class};
        f7171e = clsArr;
        f7172f = clsArr;
    }

    public j(Context context) {
        super(context);
        this.f7175c = context;
        Object[] objArr = {context};
        this.f7173a = objArr;
        this.f7174b = objArr;
    }

    public static Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r4v60 */
    public final void b(XmlResourceParser xmlResourceParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        ?? r4;
        int i5;
        boolean z4;
        ColorStateList colorStateList;
        int resourceId;
        i iVar = new i(this, menu);
        int eventType = xmlResourceParser.getEventType();
        while (true) {
            r4 = 1;
            i5 = 2;
            if (eventType == 2) {
                String name = xmlResourceParser.getName();
                if (!name.equals("menu")) {
                    throw new RuntimeException("Expecting menu, got ".concat(name));
                }
                eventType = xmlResourceParser.next();
            } else {
                eventType = xmlResourceParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        boolean z5 = false;
        boolean z6 = false;
        String str = null;
        while (!z5) {
            if (eventType == r4) {
                throw new RuntimeException("Unexpected end of document");
            }
            if (eventType != i5) {
                if (eventType != 3) {
                    z4 = r4;
                } else {
                    String name2 = xmlResourceParser.getName();
                    if (z6 && name2.equals(str)) {
                        z4 = r4;
                        z6 = false;
                        str = null;
                    } else {
                        if (name2.equals("group")) {
                            iVar.f7149b = 0;
                            iVar.f7150c = 0;
                            iVar.f7151d = 0;
                            iVar.f7152e = 0;
                            iVar.f7153f = r4;
                            iVar.g = r4;
                        } else if (name2.equals("item")) {
                            if (!iVar.h) {
                                p pVar = iVar.f7170z;
                                if (pVar == null || !pVar.f7504a.hasSubMenu()) {
                                    iVar.h = r4;
                                    iVar.b(iVar.f7148a.add(iVar.f7149b, iVar.f7154i, iVar.f7155j, iVar.f7156k));
                                } else {
                                    iVar.h = r4;
                                    iVar.b(iVar.f7148a.addSubMenu(iVar.f7149b, iVar.f7154i, iVar.f7155j, iVar.f7156k).getItem());
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z4 = r4;
                            z5 = z4;
                        }
                        z4 = r4;
                    }
                }
                eventType = xmlResourceParser.next();
                r4 = z4;
                i5 = 2;
                z6 = z6;
            } else {
                if (!z6) {
                    String name3 = xmlResourceParser.getName();
                    boolean zEquals = name3.equals("group");
                    j jVar = iVar.f7147E;
                    if (zEquals) {
                        TypedArray typedArrayObtainStyledAttributes = jVar.f7175c.obtainStyledAttributes(attributeSet, AbstractC0429a.f6127p);
                        iVar.f7149b = typedArrayObtainStyledAttributes.getResourceId(r4, 0);
                        iVar.f7150c = typedArrayObtainStyledAttributes.getInt(3, 0);
                        iVar.f7151d = typedArrayObtainStyledAttributes.getInt(4, 0);
                        iVar.f7152e = typedArrayObtainStyledAttributes.getInt(5, 0);
                        iVar.f7153f = typedArrayObtainStyledAttributes.getBoolean(2, r4);
                        iVar.g = typedArrayObtainStyledAttributes.getBoolean(0, r4);
                        typedArrayObtainStyledAttributes.recycle();
                    } else {
                        if (name3.equals("item")) {
                            Context context = jVar.f7175c;
                            TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, AbstractC0429a.f6128q);
                            iVar.f7154i = typedArrayObtainStyledAttributes2.getResourceId(2, 0);
                            iVar.f7155j = (typedArrayObtainStyledAttributes2.getInt(5, iVar.f7150c) & (-65536)) | (typedArrayObtainStyledAttributes2.getInt(6, iVar.f7151d) & Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                            iVar.f7156k = typedArrayObtainStyledAttributes2.getText(7);
                            iVar.f7157l = typedArrayObtainStyledAttributes2.getText(8);
                            iVar.f7158m = typedArrayObtainStyledAttributes2.getResourceId(0, 0);
                            String string = typedArrayObtainStyledAttributes2.getString(9);
                            iVar.n = string == null ? (char) 0 : string.charAt(0);
                            iVar.f7159o = typedArrayObtainStyledAttributes2.getInt(16, 4096);
                            String string2 = typedArrayObtainStyledAttributes2.getString(10);
                            iVar.f7160p = string2 == null ? (char) 0 : string2.charAt(0);
                            iVar.f7161q = typedArrayObtainStyledAttributes2.getInt(20, 4096);
                            if (typedArrayObtainStyledAttributes2.hasValue(11)) {
                                iVar.f7162r = typedArrayObtainStyledAttributes2.getBoolean(11, false) ? 1 : 0;
                            } else {
                                iVar.f7162r = iVar.f7152e;
                            }
                            iVar.f7163s = typedArrayObtainStyledAttributes2.getBoolean(3, false);
                            iVar.f7164t = typedArrayObtainStyledAttributes2.getBoolean(4, iVar.f7153f);
                            iVar.f7165u = typedArrayObtainStyledAttributes2.getBoolean(1, iVar.g);
                            iVar.f7166v = typedArrayObtainStyledAttributes2.getInt(21, -1);
                            iVar.f7169y = typedArrayObtainStyledAttributes2.getString(12);
                            iVar.f7167w = typedArrayObtainStyledAttributes2.getResourceId(13, 0);
                            iVar.f7168x = typedArrayObtainStyledAttributes2.getString(15);
                            String string3 = typedArrayObtainStyledAttributes2.getString(14);
                            boolean z7 = string3 != null;
                            if (z7 && iVar.f7167w == 0 && iVar.f7168x == null) {
                                iVar.f7170z = (p) iVar.a(string3, f7172f, jVar.f7174b);
                            } else {
                                if (z7) {
                                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                                }
                                iVar.f7170z = null;
                            }
                            iVar.f7143A = typedArrayObtainStyledAttributes2.getText(17);
                            iVar.f7144B = typedArrayObtainStyledAttributes2.getText(22);
                            if (typedArrayObtainStyledAttributes2.hasValue(19)) {
                                iVar.f7146D = AbstractC0636i0.b(typedArrayObtainStyledAttributes2.getInt(19, -1), iVar.f7146D);
                            } else {
                                iVar.f7146D = null;
                            }
                            if (typedArrayObtainStyledAttributes2.hasValue(18)) {
                                if (!typedArrayObtainStyledAttributes2.hasValue(18) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(18, 0)) == 0 || (colorStateList = C.h.c(context, resourceId)) == null) {
                                    colorStateList = typedArrayObtainStyledAttributes2.getColorStateList(18);
                                }
                                iVar.f7145C = colorStateList;
                            } else {
                                iVar.f7145C = null;
                            }
                            typedArrayObtainStyledAttributes2.recycle();
                            iVar.h = false;
                            z4 = true;
                        } else if (name3.equals("menu")) {
                            z4 = true;
                            iVar.h = true;
                            SubMenu subMenuAddSubMenu = iVar.f7148a.addSubMenu(iVar.f7149b, iVar.f7154i, iVar.f7155j, iVar.f7156k);
                            iVar.b(subMenuAddSubMenu.getItem());
                            b(xmlResourceParser, attributeSet, subMenuAddSubMenu);
                        } else {
                            z4 = true;
                            str = name3;
                            z6 = true;
                        }
                        eventType = xmlResourceParser.next();
                        r4 = z4;
                        i5 = 2;
                        z6 = z6;
                    }
                }
                z4 = r4;
            }
            eventType = xmlResourceParser.next();
            r4 = z4;
            i5 = 2;
            z6 = z6;
        }
    }

    @Override // android.view.MenuInflater
    public final void inflate(int i5, Menu menu) {
        if (!(menu instanceof j.m)) {
            super.inflate(i5, menu);
            return;
        }
        XmlResourceParser layout = null;
        try {
            try {
                try {
                    layout = this.f7175c.getResources().getLayout(i5);
                    b(layout, Xml.asAttributeSet(layout), menu);
                    layout.close();
                } catch (IOException e5) {
                    throw new InflateException("Error inflating menu XML", e5);
                }
            } catch (XmlPullParserException e6) {
                throw new InflateException("Error inflating menu XML", e6);
            }
        } catch (Throwable th) {
            if (layout != null) {
                layout.close();
            }
            throw th;
        }
    }
}
