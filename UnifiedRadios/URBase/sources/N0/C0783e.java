package n0;

import F3.i;
import android.database.Cursor;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import q0.C0840c;
import t3.h;
import t3.r;
import u3.C0911b;
import u3.C0914e;
import u3.C0917h;

/* renamed from: n0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0783e {

    /* renamed from: a, reason: collision with root package name */
    public final String f8721a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f8722b;

    /* renamed from: c, reason: collision with root package name */
    public final Set f8723c;

    /* renamed from: d, reason: collision with root package name */
    public final Set f8724d;

    public C0783e(String str, Map map, AbstractSet abstractSet, AbstractSet abstractSet2) {
        i.f(abstractSet, "foreignKeys");
        this.f8721a = str;
        this.f8722b = map;
        this.f8723c = abstractSet;
        this.f8724d = abstractSet2;
    }

    /* JADX WARN: Finally extract failed */
    public static final C0783e a(C0840c c0840c, String str) {
        Map mapB;
        List listR;
        C0917h c0917hA;
        C0917h c0917h;
        int i5;
        String str2;
        int i6;
        int i7;
        Throwable th;
        C0782d c0782d;
        C0840c c0840c2 = c0840c;
        StringBuilder sb = new StringBuilder("PRAGMA table_info(`");
        sb.append(str);
        String str3 = "`)";
        sb.append("`)");
        Cursor cursorX = c0840c2.X(sb.toString());
        try {
            String str4 = "name";
            if (cursorX.getColumnCount() <= 0) {
                mapB = r.f9712j;
                AbstractC0399v1.b(cursorX, null);
            } else {
                int columnIndex = cursorX.getColumnIndex("name");
                int columnIndex2 = cursorX.getColumnIndex("type");
                int columnIndex3 = cursorX.getColumnIndex("notnull");
                int columnIndex4 = cursorX.getColumnIndex("pk");
                int columnIndex5 = cursorX.getColumnIndex("dflt_value");
                C0914e c0914e = new C0914e();
                while (cursorX.moveToNext()) {
                    String string = cursorX.getString(columnIndex);
                    String string2 = cursorX.getString(columnIndex2);
                    boolean z4 = cursorX.getInt(columnIndex3) != 0;
                    int i8 = cursorX.getInt(columnIndex4);
                    String string3 = cursorX.getString(columnIndex5);
                    i.e(string, "name");
                    i.e(string2, "type");
                    c0914e.put(string, new C0779a(string, string2, z4, i8, string3, 2));
                    columnIndex = columnIndex;
                }
                mapB = c0914e.b();
                AbstractC0399v1.b(cursorX, null);
            }
            cursorX = c0840c2.X("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = cursorX.getColumnIndex("id");
                int columnIndex7 = cursorX.getColumnIndex("seq");
                int columnIndex8 = cursorX.getColumnIndex("table");
                int columnIndex9 = cursorX.getColumnIndex("on_delete");
                int columnIndex10 = cursorX.getColumnIndex("on_update");
                int columnIndex11 = cursorX.getColumnIndex("id");
                int columnIndex12 = cursorX.getColumnIndex("seq");
                int columnIndex13 = cursorX.getColumnIndex("from");
                int columnIndex14 = cursorX.getColumnIndex("to");
                C0911b c0911b = new C0911b();
                while (cursorX.moveToNext()) {
                    String str5 = str4;
                    int i9 = cursorX.getInt(columnIndex11);
                    int i10 = columnIndex11;
                    int i11 = cursorX.getInt(columnIndex12);
                    int i12 = columnIndex12;
                    String string4 = cursorX.getString(columnIndex13);
                    int i13 = columnIndex13;
                    i.e(string4, "cursor.getString(fromColumnIndex)");
                    String string5 = cursorX.getString(columnIndex14);
                    i.e(string5, "cursor.getString(toColumnIndex)");
                    c0911b.add(new C0781c(string4, string5, i9, i11));
                    mapB = mapB;
                    str4 = str5;
                    columnIndex11 = i10;
                    columnIndex12 = i12;
                    columnIndex13 = i13;
                    columnIndex14 = columnIndex14;
                }
                Map map = mapB;
                String str6 = str4;
                C0911b c0911bA = AbstractC0296a2.a(c0911b);
                i.f(c0911bA, "<this>");
                if (c0911bA.a() <= 1) {
                    listR = t3.i.H(c0911bA);
                } else {
                    Object[] array = c0911bA.toArray(new Comparable[0]);
                    Comparable[] comparableArr = (Comparable[]) array;
                    if (comparableArr.length > 1) {
                        Arrays.sort(comparableArr);
                    }
                    listR = h.r(array);
                }
                cursorX.moveToPosition(-1);
                C0917h c0917h2 = new C0917h();
                while (cursorX.moveToNext()) {
                    if (cursorX.getInt(columnIndex7) == 0) {
                        int i14 = cursorX.getInt(columnIndex6);
                        ArrayList arrayList = new ArrayList();
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        for (Object obj : listR) {
                            List list = listR;
                            if (((C0781c) obj).f8713j == i14) {
                                arrayList3.add(obj);
                            }
                            listR = list;
                        }
                        List list2 = listR;
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            C0781c c0781c = (C0781c) it.next();
                            arrayList.add(c0781c.f8715l);
                            arrayList2.add(c0781c.f8716m);
                        }
                        String string6 = cursorX.getString(columnIndex8);
                        i.e(string6, "cursor.getString(tableColumnIndex)");
                        String string7 = cursorX.getString(columnIndex9);
                        i.e(string7, "cursor.getString(onDeleteColumnIndex)");
                        String string8 = cursorX.getString(columnIndex10);
                        i.e(string8, "cursor.getString(onUpdateColumnIndex)");
                        c0917h2.add(new C0780b(string6, string7, string8, arrayList, arrayList2));
                        columnIndex6 = columnIndex6;
                        listR = list2;
                    }
                }
                C0917h c0917hA2 = h4.c.a(c0917h2);
                AbstractC0399v1.b(cursorX, null);
                cursorX = c0840c2.X("PRAGMA index_list(`" + str + "`)");
                String str7 = str6;
                try {
                    int columnIndex15 = cursorX.getColumnIndex(str7);
                    int columnIndex16 = cursorX.getColumnIndex("origin");
                    int columnIndex17 = cursorX.getColumnIndex("unique");
                    if (columnIndex15 == -1 || columnIndex16 == -1 || columnIndex17 == -1) {
                        c0917hA = null;
                        AbstractC0399v1.b(cursorX, null);
                    } else {
                        C0917h c0917h3 = new C0917h();
                        while (cursorX.moveToNext()) {
                            if ("c".equals(cursorX.getString(columnIndex16))) {
                                String string9 = cursorX.getString(columnIndex15);
                                boolean z5 = cursorX.getInt(columnIndex17) == 1;
                                i.e(string9, str7);
                                cursorX = c0840c2.X("PRAGMA index_xinfo(`" + string9 + str3);
                                try {
                                    int columnIndex18 = cursorX.getColumnIndex("seqno");
                                    int columnIndex19 = cursorX.getColumnIndex("cid");
                                    int columnIndex20 = cursorX.getColumnIndex(str7);
                                    int columnIndex21 = cursorX.getColumnIndex("desc");
                                    String str8 = str7;
                                    if (columnIndex18 == -1 || columnIndex19 == -1 || columnIndex20 == -1 || columnIndex21 == -1) {
                                        i5 = columnIndex15;
                                        str2 = str3;
                                        i6 = columnIndex16;
                                        i7 = columnIndex17;
                                        th = null;
                                        AbstractC0399v1.b(cursorX, null);
                                        c0782d = null;
                                    } else {
                                        TreeMap treeMap = new TreeMap();
                                        i5 = columnIndex15;
                                        TreeMap treeMap2 = new TreeMap();
                                        while (cursorX.moveToNext()) {
                                            if (cursorX.getInt(columnIndex19) >= 0) {
                                                int i15 = cursorX.getInt(columnIndex18);
                                                String str9 = str3;
                                                String string10 = cursorX.getString(columnIndex20);
                                                int i16 = columnIndex21;
                                                String str10 = cursorX.getInt(columnIndex21) > 0 ? "DESC" : "ASC";
                                                int i17 = columnIndex16;
                                                Integer numValueOf = Integer.valueOf(i15);
                                                i.e(string10, "columnName");
                                                treeMap.put(numValueOf, string10);
                                                treeMap2.put(Integer.valueOf(i15), str10);
                                                str3 = str9;
                                                columnIndex16 = i17;
                                                columnIndex21 = i16;
                                                columnIndex17 = columnIndex17;
                                            }
                                        }
                                        str2 = str3;
                                        i6 = columnIndex16;
                                        i7 = columnIndex17;
                                        Collection collectionValues = treeMap.values();
                                        i.e(collectionValues, "columnsMap.values");
                                        List listH = t3.i.H(collectionValues);
                                        Collection collectionValues2 = treeMap2.values();
                                        i.e(collectionValues2, "ordersMap.values");
                                        c0782d = new C0782d(string9, z5, listH, t3.i.H(collectionValues2));
                                        AbstractC0399v1.b(cursorX, null);
                                        th = null;
                                    }
                                    if (c0782d == null) {
                                        AbstractC0399v1.b(cursorX, th);
                                        c0917h = null;
                                        break;
                                    }
                                    c0917h3.add(c0782d);
                                    c0840c2 = c0840c;
                                    str7 = str8;
                                    columnIndex15 = i5;
                                    str3 = str2;
                                    columnIndex16 = i6;
                                    columnIndex17 = i7;
                                } finally {
                                }
                            }
                        }
                        c0917hA = h4.c.a(c0917h3);
                        AbstractC0399v1.b(cursorX, null);
                    }
                    c0917h = c0917hA;
                    return new C0783e(str, map, c0917hA2, c0917h);
                } finally {
                }
            } catch (Throwable th2) {
                try {
                    throw th2;
                } finally {
                }
            }
        } finally {
            try {
                throw th2;
            } finally {
            }
        }
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0783e)) {
            return false;
        }
        C0783e c0783e = (C0783e) obj;
        if (!i.a(this.f8721a, c0783e.f8721a) || !i.a(this.f8722b, c0783e.f8722b) || !i.a(this.f8723c, c0783e.f8723c)) {
            return false;
        }
        Set set2 = this.f8724d;
        if (set2 == null || (set = c0783e.f8724d) == null) {
            return true;
        }
        return i.a(set2, set);
    }

    public final int hashCode() {
        return this.f8723c.hashCode() + ((this.f8722b.hashCode() + (this.f8721a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "TableInfo{name='" + this.f8721a + "', columns=" + this.f8722b + ", foreignKeys=" + this.f8723c + ", indices=" + this.f8724d + '}';
    }
}
