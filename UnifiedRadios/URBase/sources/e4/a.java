package e4;

import C0.C0001a;
import C0.v;
import D0.o;
import D1.C0016n;
import F3.i;
import L0.q;
import R0.g;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.work.impl.WorkDatabase;
import com.unified.ur1.SatelliteTracker.h;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import l0.AbstractC0737m;
import l0.C0738n;
import t3.f;
import t3.j;
import z2.InterfaceFutureC1000b;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static b f6222a;

    public static final void c(WorkDatabase workDatabase, C0001a c0001a, o oVar) {
        int i5;
        i.f(workDatabase, "workDatabase");
        i.f(c0001a, "configuration");
        i.f(oVar, "continuation");
        ArrayList arrayList = new ArrayList(new f(new o[]{oVar}, true));
        int i6 = 0;
        while (!arrayList.isEmpty()) {
            if (arrayList.isEmpty()) {
                throw new NoSuchElementException("List is empty.");
            }
            List list = ((o) arrayList.remove(j.x(arrayList))).f284b;
            i.e(list, "current.work");
            if (list.isEmpty()) {
                i5 = 0;
            } else {
                Iterator it = list.iterator();
                i5 = 0;
                while (it.hasNext()) {
                    if ((!((v) it.next()).f177b.f1568j.h.isEmpty()) && (i5 = i5 + 1) < 0) {
                        throw new ArithmeticException("Count overflow has happened.");
                    }
                }
            }
            i6 += i5;
        }
        if (i6 == 0) {
            return;
        }
        q qVarV = workDatabase.v();
        qVarV.getClass();
        C0738n c0738nO = C0738n.o(0, "Select COUNT(*) FROM workspec WHERE LENGTH(content_uri_triggers)<>0 AND state NOT IN (2, 3, 5)");
        AbstractC0737m abstractC0737m = qVarV.f1582a;
        abstractC0737m.b();
        Cursor cursorM = abstractC0737m.m(c0738nO, null);
        try {
            int i7 = cursorM.moveToFirst() ? cursorM.getInt(0) : 0;
            cursorM.close();
            c0738nO.s();
            int i8 = i7 + i6;
            int i9 = c0001a.f136i;
            if (i8 <= i9) {
                return;
            }
            StringBuilder sb = new StringBuilder("Too many workers with contentUriTriggers are enqueued:\ncontentUriTrigger workers limit: ");
            sb.append(i9);
            sb.append(";\nalready enqueued count: ");
            sb.append(i7);
            sb.append(";\ncurrent enqueue operation count: ");
            throw new IllegalArgumentException(h.d(sb, i6, ".\nTo address this issue you can: \n1. enqueue less workers or batch some of workers with content uri triggers together;\n2. increase limit via Configuration.Builder.setContentUriTriggerWorkersLimit;\nPlease beware that workers with content uri triggers immediately occupy slots in JobScheduler so no updates to content uris are missed."));
        } catch (Throwable th) {
            cursorM.close();
            c0738nO.s();
            throw th;
        }
    }

    public static void d(InterfaceFutureC1000b interfaceFutureC1000b) {
        if (!interfaceFutureC1000b.isDone()) {
            throw new IllegalStateException(Z3.i.i("Future was expected to be done: %s", interfaceFutureC1000b));
        }
        boolean z4 = false;
        while (true) {
            try {
                interfaceFutureC1000b.get();
                break;
            } catch (InterruptedException unused) {
                z4 = true;
            } catch (Throwable th) {
                if (z4) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z4) {
            Thread.currentThread().interrupt();
        }
    }

    public static synchronized b g() {
        try {
            if (f6222a == null) {
                f6222a = new b();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f6222a;
    }

    public static C0016n j(R0.f fVar, long j5, List list) {
        Q0.b bVar = fVar.f2223u;
        if (bVar == null) {
            return new C0016n(304, null, true, j5, list);
        }
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                treeSet.add(((Q0.f) it.next()).f2143a);
            }
        }
        ArrayList arrayList = new ArrayList(list);
        List list2 = bVar.h;
        if (list2 != null) {
            if (!list2.isEmpty()) {
                for (Q0.f fVar2 : bVar.h) {
                    if (!treeSet.contains(fVar2.f2143a)) {
                        arrayList.add(fVar2);
                    }
                }
            }
        } else if (!bVar.g.isEmpty()) {
            for (Map.Entry entry : bVar.g.entrySet()) {
                if (!treeSet.contains(entry.getKey())) {
                    arrayList.add(new Q0.f((String) entry.getKey(), (String) entry.getValue()));
                }
            }
        }
        return new C0016n(304, bVar.f2129a, true, j5, arrayList);
    }

    public static String n(Exception exc) {
        if (exc == null) {
            return "";
        }
        for (Throwable cause = exc; cause != null; cause = cause.getCause()) {
            if (cause instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        exc.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }

    public static byte[] o(InputStream inputStream, int i5, R0.a aVar) throws Throwable {
        byte[] bArrA;
        g gVar = new g(aVar, i5);
        try {
            bArrA = aVar.a(1024);
            while (true) {
                try {
                    int i6 = inputStream.read(bArrA);
                    if (i6 == -1) {
                        break;
                    }
                    gVar.write(bArrA, 0, i6);
                } catch (Throwable th) {
                    th = th;
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                        Q0.o.d("Error occurred when closing InputStream", new Object[0]);
                    }
                    aVar.b(bArrA);
                    gVar.close();
                    throw th;
                }
            }
            byte[] byteArray = gVar.toByteArray();
            try {
                inputStream.close();
            } catch (IOException unused2) {
                Q0.o.d("Error occurred when closing InputStream", new Object[0]);
            }
            aVar.b(bArrA);
            gVar.close();
            return byteArray;
        } catch (Throwable th2) {
            th = th2;
            bArrA = null;
        }
    }

    public static String v(String str, Object... objArr) {
        int length;
        int length2;
        int iIndexOf;
        String string;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            length = objArr.length;
            if (i6 >= length) {
                break;
            }
            Object obj = objArr[i6];
            if (obj == null) {
                string = "null";
            } else {
                try {
                    string = obj.toString();
                } catch (Exception e5) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
                    sb.append(name);
                    sb.append("@");
                    sb.append(hexString);
                    String string2 = sb.toString();
                    Logger.getLogger("com.google.common.base.Strings").logp(Level.WARNING, "com.google.common.base.Strings", "lenientToString", "Exception during lenientFormat for ".concat(string2), (Throwable) e5);
                    String name2 = e5.getClass().getName();
                    StringBuilder sb2 = new StringBuilder(name2.length() + string2.length() + 8 + 1);
                    sb2.append("<");
                    sb2.append(string2);
                    sb2.append(" threw ");
                    sb2.append(name2);
                    sb2.append(">");
                    string = sb2.toString();
                }
            }
            objArr[i6] = string;
            i6++;
        }
        StringBuilder sb3 = new StringBuilder(str.length() + (length * 16));
        int i7 = 0;
        while (true) {
            length2 = objArr.length;
            if (i5 >= length2 || (iIndexOf = str.indexOf("%s", i7)) == -1) {
                break;
            }
            sb3.append((CharSequence) str, i7, iIndexOf);
            sb3.append(objArr[i5]);
            i7 = iIndexOf + 2;
            i5++;
        }
        sb3.append((CharSequence) str, i7, str.length());
        if (i5 < length2) {
            sb3.append(" [");
            sb3.append(objArr[i5]);
            for (int i8 = i5 + 1; i8 < objArr.length; i8++) {
                sb3.append(", ");
                sb3.append(objArr[i8]);
            }
            sb3.append(']');
        }
        return sb3.toString();
    }

    public abstract int a(ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float b(int i5);

    public abstract int e();

    public abstract int f();

    public abstract int h();

    public abstract int i();

    public abstract int k(View view);

    public abstract int l(CoordinatorLayout coordinatorLayout);

    public abstract int m();

    public abstract boolean p(float f5);

    public abstract boolean q(View view);

    public abstract boolean r(float f5, float f6);

    public abstract void s();

    public abstract boolean t(View view, float f5);

    public abstract void u(ViewGroup.MarginLayoutParams marginLayoutParams, int i5, int i6);
}
