package L0;

import C0.ThreadFactoryC0002b;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import e0.C0432c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import q1.E;
import r1.InterfaceC0875c;

/* loaded from: classes.dex */
public abstract class f {
    public static final ExecutorService a(boolean z4) {
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(Math.max(2, Math.min(Runtime.getRuntime().availableProcessors() - 1, 4)), new ThreadFactoryC0002b(z4));
        F3.i.e(executorServiceNewFixedThreadPool, "newFixedThreadPool(\n    …)),\n        factory\n    )");
        return executorServiceNewFixedThreadPool;
    }

    public static String b(int i5, int i6, String str) {
        if (i5 < 0) {
            return Z3.i.i("%s (%s) must not be negative", str, Integer.valueOf(i5));
        }
        if (i6 >= 0) {
            return Z3.i.i("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i5), Integer.valueOf(i6));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i6);
        throw new IllegalArgumentException(sb.toString());
    }

    public static void c(int i5, int i6) {
        String strI;
        if (i5 < 0 || i5 >= i6) {
            if (i5 < 0) {
                strI = Z3.i.i("%s (%s) must not be negative", "index", Integer.valueOf(i5));
            } else {
                if (i6 < 0) {
                    StringBuilder sb = new StringBuilder(26);
                    sb.append("negative size: ");
                    sb.append(i6);
                    throw new IllegalArgumentException(sb.toString());
                }
                strI = Z3.i.i("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i5), Integer.valueOf(i6));
            }
            throw new IndexOutOfBoundsException(strI);
        }
    }

    public static void d(int i5, int i6) {
        if (i5 < 0 || i5 > i6) {
            throw new IndexOutOfBoundsException(b(i5, i6, "index"));
        }
    }

    public static void e(int i5, int i6, int i7) {
        if (i5 < 0 || i6 < i5 || i6 > i7) {
            throw new IndexOutOfBoundsException((i5 < 0 || i5 > i7) ? b(i5, i7, "start index") : (i6 < 0 || i6 > i7) ? b(i6, i7, "end index") : Z3.i.i("end index (%s) must not be less than start index (%s)", Integer.valueOf(i6), Integer.valueOf(i5)));
        }
    }

    public static InterfaceC0875c f(byte[] bArr, Parcelable.Creator creator) {
        E.i(creator);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        InterfaceC0875c interfaceC0875c = (InterfaceC0875c) creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return interfaceC0875c;
    }

    public static void g(ArrayList arrayList) {
        HashMap map = new HashMap(arrayList.size());
        Iterator it = arrayList.iterator();
        while (true) {
            int i5 = 0;
            if (!it.hasNext()) {
                Iterator it2 = map.values().iterator();
                while (it2.hasNext()) {
                    for (F2.h hVar : (Set) it2.next()) {
                        for (F2.j jVar : hVar.f558a.f545c) {
                            if (jVar.f565c == 0) {
                                Set<F2.h> set = (Set) map.get(new F2.i(jVar.f563a, jVar.f564b == 2));
                                if (set != null) {
                                    for (F2.h hVar2 : set) {
                                        hVar.f559b.add(hVar2);
                                        hVar2.f560c.add(hVar);
                                    }
                                }
                            }
                        }
                    }
                }
                HashSet hashSet = new HashSet();
                Iterator it3 = map.values().iterator();
                while (it3.hasNext()) {
                    hashSet.addAll((Set) it3.next());
                }
                HashSet hashSet2 = new HashSet();
                Iterator it4 = hashSet.iterator();
                while (it4.hasNext()) {
                    F2.h hVar3 = (F2.h) it4.next();
                    if (hVar3.f560c.isEmpty()) {
                        hashSet2.add(hVar3);
                    }
                }
                while (!hashSet2.isEmpty()) {
                    F2.h hVar4 = (F2.h) hashSet2.iterator().next();
                    hashSet2.remove(hVar4);
                    i5++;
                    Iterator it5 = hVar4.f559b.iterator();
                    while (it5.hasNext()) {
                        F2.h hVar5 = (F2.h) it5.next();
                        hVar5.f560c.remove(hVar4);
                        if (hVar5.f560c.isEmpty()) {
                            hashSet2.add(hVar5);
                        }
                    }
                }
                if (i5 == arrayList.size()) {
                    return;
                }
                ArrayList arrayList2 = new ArrayList();
                Iterator it6 = hashSet.iterator();
                while (it6.hasNext()) {
                    F2.h hVar6 = (F2.h) it6.next();
                    if (!hVar6.f560c.isEmpty() && !hVar6.f559b.isEmpty()) {
                        arrayList2.add(hVar6.f558a);
                    }
                }
                throw new F2.k("Dependency cycle detected: " + Arrays.toString(arrayList2.toArray()));
            }
            F2.b bVar = (F2.b) it.next();
            F2.h hVar7 = new F2.h(bVar);
            for (F2.r rVar : bVar.f544b) {
                boolean z4 = !(bVar.f547e == 0);
                F2.i iVar = new F2.i(rVar, z4);
                if (!map.containsKey(iVar)) {
                    map.put(iVar, new HashSet());
                }
                Set set2 = (Set) map.get(iVar);
                if (!set2.isEmpty() && !z4) {
                    throw new IllegalArgumentException("Multiple components provide " + rVar + ".");
                }
                set2.add(hVar7);
            }
        }
    }

    public static final int h(Cursor cursor, String str) {
        String string;
        F3.i.f(cursor, "c");
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + '`');
            if (columnIndex < 0) {
                columnIndex = -1;
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            String[] columnNames = cursor.getColumnNames();
            F3.i.e(columnNames, "c.columnNames");
            StringBuilder sb = new StringBuilder();
            sb.append((CharSequence) "");
            int i5 = 0;
            for (String str2 : columnNames) {
                i5++;
                if (i5 > 1) {
                    sb.append((CharSequence) ", ");
                }
                h4.d.a(sb, str2, null);
            }
            sb.append((CharSequence) "");
            string = sb.toString();
            F3.i.e(string, "joinTo(StringBuilder(), …ed, transform).toString()");
        } catch (Exception e5) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e5);
            string = "unknown";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + string);
    }

    public static void i(Context context) {
        C0432c.a(context).c(new Intent("com.unified.ur1.HIDE_WAIT"));
    }

    public static String j(String str, String str2) {
        int length = str.length() - str2.length();
        if (length < 0 || length > 1) {
            throw new IllegalArgumentException("Invalid input received");
        }
        StringBuilder sb = new StringBuilder(str2.length() + str.length());
        for (int i5 = 0; i5 < str.length(); i5++) {
            sb.append(str.charAt(i5));
            if (str2.length() > i5) {
                sb.append(str2.charAt(i5));
            }
        }
        return sb.toString();
    }

    public static void n(Context context) {
        Intent intent = new Intent("com.unified.ur1.SHOW_WAIT");
        intent.putExtra("message", "Please Wait!");
        C0432c.a(context).c(intent);
    }

    public static int o(int i5) {
        if (i5 == 0) {
            return 1;
        }
        if (i5 == 1) {
            return 2;
        }
        if (i5 == 2) {
            return 3;
        }
        if (i5 != 3) {
            return i5 != 4 ? 0 : 5;
        }
        return 4;
    }

    public abstract void k(boolean z4);

    public abstract void l(boolean z4);

    public abstract void m();
}
