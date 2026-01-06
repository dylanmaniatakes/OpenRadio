package j;

import O.AbstractC0153a0;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class m implements Menu {

    /* renamed from: y, reason: collision with root package name */
    public static final int[] f7453y = {1, 4, 5, 3, 2, 0};

    /* renamed from: a, reason: collision with root package name */
    public final Context f7454a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources f7455b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f7456c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f7457d;

    /* renamed from: e, reason: collision with root package name */
    public k f7458e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f7459f;
    public final ArrayList g;
    public boolean h;

    /* renamed from: i, reason: collision with root package name */
    public final ArrayList f7460i;

    /* renamed from: j, reason: collision with root package name */
    public final ArrayList f7461j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f7462k;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f7464m;
    public Drawable n;

    /* renamed from: o, reason: collision with root package name */
    public View f7465o;

    /* renamed from: v, reason: collision with root package name */
    public o f7472v;

    /* renamed from: x, reason: collision with root package name */
    public boolean f7474x;

    /* renamed from: l, reason: collision with root package name */
    public int f7463l = 0;

    /* renamed from: p, reason: collision with root package name */
    public boolean f7466p = false;

    /* renamed from: q, reason: collision with root package name */
    public boolean f7467q = false;

    /* renamed from: r, reason: collision with root package name */
    public boolean f7468r = false;

    /* renamed from: s, reason: collision with root package name */
    public boolean f7469s = false;

    /* renamed from: t, reason: collision with root package name */
    public final ArrayList f7470t = new ArrayList();

    /* renamed from: u, reason: collision with root package name */
    public final CopyOnWriteArrayList f7471u = new CopyOnWriteArrayList();

    /* renamed from: w, reason: collision with root package name */
    public boolean f7473w = false;

    public m(Context context) {
        boolean z4 = false;
        this.f7454a = context;
        Resources resources = context.getResources();
        this.f7455b = resources;
        this.f7459f = new ArrayList();
        this.g = new ArrayList();
        this.h = true;
        this.f7460i = new ArrayList();
        this.f7461j = new ArrayList();
        this.f7462k = true;
        if (resources.getConfiguration().keyboard != 1 && AbstractC0153a0.b(ViewConfiguration.get(context))) {
            z4 = true;
        }
        this.f7457d = z4;
    }

    public o a(int i5, int i6, int i7, CharSequence charSequence) {
        int i8;
        int i9 = ((-65536) & i7) >> 16;
        if (i9 < 0 || i9 >= 6) {
            throw new IllegalArgumentException("order does not contain a valid category.");
        }
        int i10 = (f7453y[i9] << 16) | (65535 & i7);
        o oVar = new o(this, i5, i6, i7, i10, charSequence, this.f7463l);
        ArrayList arrayList = this.f7459f;
        int size = arrayList.size() - 1;
        while (true) {
            if (size < 0) {
                i8 = 0;
                break;
            }
            if (((o) arrayList.get(size)).f7484d <= i10) {
                i8 = size + 1;
                break;
            }
            size--;
        }
        arrayList.add(i8, oVar);
        p(true);
        return oVar;
    }

    @Override // android.view.Menu
    public final MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public final int addIntentOptions(int i5, int i6, int i7, ComponentName componentName, Intent[] intentArr, Intent intent, int i8, MenuItem[] menuItemArr) {
        int i9;
        PackageManager packageManager = this.f7454a.getPackageManager();
        List<ResolveInfo> listQueryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = listQueryIntentActivityOptions != null ? listQueryIntentActivityOptions.size() : 0;
        if ((i8 & 1) == 0) {
            removeGroup(i5);
        }
        for (int i10 = 0; i10 < size; i10++) {
            ResolveInfo resolveInfo = listQueryIntentActivityOptions.get(i10);
            int i11 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i11 < 0 ? intent : intentArr[i11]);
            ActivityInfo activityInfo = resolveInfo.activityInfo;
            intent2.setComponent(new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name));
            o oVarA = a(i5, i6, i7, resolveInfo.loadLabel(packageManager));
            oVarA.setIcon(resolveInfo.loadIcon(packageManager));
            oVarA.g = intent2;
            if (menuItemArr != null && (i9 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i9] = oVarA;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public final void b(z zVar, Context context) {
        this.f7471u.add(new WeakReference(zVar));
        zVar.h(context, this);
        this.f7462k = true;
    }

    public final void c(boolean z4) {
        if (this.f7469s) {
            return;
        }
        this.f7469s = true;
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7471u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zVar.a(this, z4);
            }
        }
        this.f7469s = false;
    }

    @Override // android.view.Menu
    public final void clear() {
        o oVar = this.f7472v;
        if (oVar != null) {
            d(oVar);
        }
        this.f7459f.clear();
        p(true);
    }

    public final void clearHeader() {
        this.n = null;
        this.f7464m = null;
        this.f7465o = null;
        p(false);
    }

    @Override // android.view.Menu
    public final void close() {
        c(true);
    }

    public boolean d(o oVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7471u;
        boolean zK = false;
        if (!copyOnWriteArrayList.isEmpty() && this.f7472v == oVar) {
            w();
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                z zVar = (z) weakReference.get();
                if (zVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zK = zVar.k(oVar);
                    if (zK) {
                        break;
                    }
                }
            }
            v();
            if (zK) {
                this.f7472v = null;
            }
        }
        return zK;
    }

    public boolean e(m mVar, MenuItem menuItem) {
        k kVar = this.f7458e;
        return kVar != null && kVar.g(mVar, menuItem);
    }

    public boolean f(o oVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7471u;
        boolean zD = false;
        if (copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zD = zVar.d(oVar);
                if (zD) {
                    break;
                }
            }
        }
        v();
        if (zD) {
            this.f7472v = oVar;
        }
        return zD;
    }

    @Override // android.view.Menu
    public final MenuItem findItem(int i5) {
        MenuItem menuItemFindItem;
        ArrayList arrayList = this.f7459f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            o oVar = (o) arrayList.get(i6);
            if (oVar.f7481a == i5) {
                return oVar;
            }
            if (oVar.hasSubMenu() && (menuItemFindItem = oVar.f7492o.findItem(i5)) != null) {
                return menuItemFindItem;
            }
        }
        return null;
    }

    public final o g(int i5, KeyEvent keyEvent) {
        ArrayList arrayList = this.f7470t;
        arrayList.clear();
        h(arrayList, i5, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return (o) arrayList.get(0);
        }
        boolean zN = n();
        for (int i6 = 0; i6 < size; i6++) {
            o oVar = (o) arrayList.get(i6);
            char c2 = zN ? oVar.f7488j : oVar.h;
            char[] cArr = keyData.meta;
            if ((c2 == cArr[0] && (metaState & 2) == 0) || ((c2 == cArr[2] && (metaState & 2) != 0) || (zN && c2 == '\b' && i5 == 67))) {
                return oVar;
            }
        }
        return null;
    }

    @Override // android.view.Menu
    public final MenuItem getItem(int i5) {
        return (MenuItem) this.f7459f.get(i5);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(java.util.List r17, int r18, android.view.KeyEvent r19) {
        /*
            r16 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r16.n()
            int r4 = r19.getModifiers()
            android.view.KeyCharacterMap$KeyData r5 = new android.view.KeyCharacterMap$KeyData
            r5.<init>()
            boolean r6 = r2.getKeyData(r5)
            r7 = 67
            if (r6 != 0) goto L1e
            if (r1 == r7) goto L1e
            return
        L1e:
            r6 = r16
            java.util.ArrayList r8 = r6.f7459f
            int r9 = r8.size()
            r10 = 0
            r11 = r10
        L28:
            if (r11 >= r9) goto L7a
            java.lang.Object r12 = r8.get(r11)
            j.o r12 = (j.o) r12
            boolean r13 = r12.hasSubMenu()
            if (r13 == 0) goto L3b
            j.F r13 = r12.f7492o
            r13.h(r0, r1, r2)
        L3b:
            if (r3 == 0) goto L40
            char r13 = r12.f7488j
            goto L42
        L40:
            char r13 = r12.h
        L42:
            if (r3 == 0) goto L47
            int r14 = r12.f7489k
            goto L49
        L47:
            int r14 = r12.f7487i
        L49:
            r15 = 69647(0x1100f, float:9.7596E-41)
            r7 = r4 & r15
            r14 = r14 & r15
            if (r7 != r14) goto L69
            if (r13 == 0) goto L69
            char[] r7 = r5.meta
            char r14 = r7[r10]
            if (r13 == r14) goto L6c
            r14 = 2
            char r7 = r7[r14]
            if (r13 == r7) goto L6c
            if (r3 == 0) goto L69
            r7 = 8
            if (r13 != r7) goto L69
            r7 = 67
            if (r1 != r7) goto L77
            goto L6e
        L69:
            r7 = 67
            goto L77
        L6c:
            r7 = 67
        L6e:
            boolean r13 = r12.isEnabled()
            if (r13 == 0) goto L77
            r0.add(r12)
        L77:
            int r11 = r11 + 1
            goto L28
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j.m.h(java.util.List, int, android.view.KeyEvent):void");
    }

    @Override // android.view.Menu
    public final boolean hasVisibleItems() {
        if (this.f7474x) {
            return true;
        }
        ArrayList arrayList = this.f7459f;
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            if (((o) arrayList.get(i5)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public final void i() {
        ArrayList arrayListL = l();
        if (this.f7462k) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f7471u;
            Iterator it = copyOnWriteArrayList.iterator();
            boolean zI = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                z zVar = (z) weakReference.get();
                if (zVar == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    zI |= zVar.i();
                }
            }
            ArrayList arrayList = this.f7460i;
            ArrayList arrayList2 = this.f7461j;
            if (zI) {
                arrayList.clear();
                arrayList2.clear();
                int size = arrayListL.size();
                for (int i5 = 0; i5 < size; i5++) {
                    o oVar = (o) arrayListL.get(i5);
                    if (oVar.f()) {
                        arrayList.add(oVar);
                    } else {
                        arrayList2.add(oVar);
                    }
                }
            } else {
                arrayList.clear();
                arrayList2.clear();
                arrayList2.addAll(l());
            }
            this.f7462k = false;
        }
    }

    @Override // android.view.Menu
    public final boolean isShortcutKey(int i5, KeyEvent keyEvent) {
        return g(i5, keyEvent) != null;
    }

    public String j() {
        return "android:menu:actionviewstates";
    }

    public m k() {
        return this;
    }

    public final ArrayList l() {
        boolean z4 = this.h;
        ArrayList arrayList = this.g;
        if (!z4) {
            return arrayList;
        }
        arrayList.clear();
        ArrayList arrayList2 = this.f7459f;
        int size = arrayList2.size();
        for (int i5 = 0; i5 < size; i5++) {
            o oVar = (o) arrayList2.get(i5);
            if (oVar.isVisible()) {
                arrayList.add(oVar);
            }
        }
        this.h = false;
        this.f7462k = true;
        return arrayList;
    }

    public boolean m() {
        return this.f7473w;
    }

    public boolean n() {
        return this.f7456c;
    }

    public boolean o() {
        return this.f7457d;
    }

    public final void p(boolean z4) {
        if (this.f7466p) {
            this.f7467q = true;
            if (z4) {
                this.f7468r = true;
                return;
            }
            return;
        }
        if (z4) {
            this.h = true;
            this.f7462k = true;
        }
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7471u;
        if (copyOnWriteArrayList.isEmpty()) {
            return;
        }
        w();
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar = (z) weakReference.get();
            if (zVar == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                zVar.g(z4);
            }
        }
        v();
    }

    @Override // android.view.Menu
    public final boolean performIdentifierAction(int i5, int i6) {
        return q(findItem(i5), null, i6);
    }

    @Override // android.view.Menu
    public final boolean performShortcut(int i5, KeyEvent keyEvent, int i6) {
        o oVarG = g(i5, keyEvent);
        boolean zQ = oVarG != null ? q(oVarG, null, i6) : false;
        if ((i6 & 2) != 0) {
            c(true);
        }
        return zQ;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean q(android.view.MenuItem r7, j.z r8, int r9) {
        /*
            r6 = this;
            j.o r7 = (j.o) r7
            r0 = 0
            if (r7 == 0) goto Ld7
            boolean r1 = r7.isEnabled()
            if (r1 != 0) goto Ld
            goto Ld7
        Ld:
            android.view.MenuItem$OnMenuItemClickListener r1 = r7.f7493p
            r2 = 1
            if (r1 == 0) goto L1a
            boolean r1 = r1.onMenuItemClick(r7)
            if (r1 == 0) goto L1a
        L18:
            r1 = r2
            goto L43
        L1a:
            j.m r1 = r7.n
            boolean r3 = r1.e(r1, r7)
            if (r3 == 0) goto L23
            goto L18
        L23:
            android.content.Intent r3 = r7.g
            if (r3 == 0) goto L35
            android.content.Context r1 = r1.f7454a     // Catch: android.content.ActivityNotFoundException -> L2d
            r1.startActivity(r3)     // Catch: android.content.ActivityNotFoundException -> L2d
            goto L18
        L2d:
            r1 = move-exception
            java.lang.String r3 = "MenuItemImpl"
            java.lang.String r4 = "Can't find activity to handle intent; ignoring"
            android.util.Log.e(r3, r4, r1)
        L35:
            j.p r1 = r7.f7478A
            if (r1 == 0) goto L42
            android.view.ActionProvider r1 = r1.f7504a
            boolean r1 = r1.onPerformDefaultAction()
            if (r1 == 0) goto L42
            goto L18
        L42:
            r1 = r0
        L43:
            j.p r3 = r7.f7478A
            if (r3 == 0) goto L51
            android.view.ActionProvider r4 = r3.f7504a
            boolean r4 = r4.hasSubMenu()
            if (r4 == 0) goto L51
            r4 = r2
            goto L52
        L51:
            r4 = r0
        L52:
            boolean r5 = r7.e()
            if (r5 == 0) goto L64
            boolean r7 = r7.expandActionView()
            r1 = r1 | r7
            if (r1 == 0) goto Ld6
            r6.c(r2)
            goto Ld6
        L64:
            boolean r5 = r7.hasSubMenu()
            if (r5 != 0) goto L75
            if (r4 == 0) goto L6d
            goto L75
        L6d:
            r7 = r9 & 1
            if (r7 != 0) goto Ld6
            r6.c(r2)
            goto Ld6
        L75:
            r9 = r9 & 4
            if (r9 != 0) goto L7c
            r6.c(r0)
        L7c:
            boolean r9 = r7.hasSubMenu()
            if (r9 != 0) goto L90
            j.F r9 = new j.F
            android.content.Context r5 = r6.f7454a
            r9.<init>(r5, r6, r7)
            r7.f7492o = r9
            java.lang.CharSequence r5 = r7.f7485e
            r9.setHeaderTitle(r5)
        L90:
            j.F r7 = r7.f7492o
            if (r4 == 0) goto L9e
            j.t r9 = r3.f7505b
            r9.getClass()
            android.view.ActionProvider r9 = r3.f7504a
            r9.onPrepareSubMenu(r7)
        L9e:
            java.util.concurrent.CopyOnWriteArrayList r9 = r6.f7471u
            boolean r3 = r9.isEmpty()
            if (r3 == 0) goto La7
            goto Ld0
        La7:
            if (r8 == 0) goto Lad
            boolean r0 = r8.m(r7)
        Lad:
            java.util.Iterator r8 = r9.iterator()
        Lb1:
            boolean r3 = r8.hasNext()
            if (r3 == 0) goto Ld0
            java.lang.Object r3 = r8.next()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r4 = r3.get()
            j.z r4 = (j.z) r4
            if (r4 != 0) goto Lc9
            r9.remove(r3)
            goto Lb1
        Lc9:
            if (r0 != 0) goto Lb1
            boolean r0 = r4.m(r7)
            goto Lb1
        Ld0:
            r1 = r1 | r0
            if (r1 != 0) goto Ld6
            r6.c(r2)
        Ld6:
            return r1
        Ld7:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.m.q(android.view.MenuItem, j.z, int):boolean");
    }

    public final void r(z zVar) {
        CopyOnWriteArrayList copyOnWriteArrayList = this.f7471u;
        Iterator it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            z zVar2 = (z) weakReference.get();
            if (zVar2 == null || zVar2 == zVar) {
                copyOnWriteArrayList.remove(weakReference);
            }
        }
    }

    @Override // android.view.Menu
    public final void removeGroup(int i5) {
        ArrayList arrayList = this.f7459f;
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (true) {
            if (i7 >= size) {
                i7 = -1;
                break;
            } else if (((o) arrayList.get(i7)).f7482b == i5) {
                break;
            } else {
                i7++;
            }
        }
        if (i7 >= 0) {
            int size2 = arrayList.size() - i7;
            while (true) {
                int i8 = i6 + 1;
                if (i6 >= size2 || ((o) arrayList.get(i7)).f7482b != i5) {
                    break;
                }
                if (i7 >= 0) {
                    ArrayList arrayList2 = this.f7459f;
                    if (i7 < arrayList2.size()) {
                        arrayList2.remove(i7);
                    }
                }
                i6 = i8;
            }
            p(true);
        }
    }

    @Override // android.view.Menu
    public final void removeItem(int i5) {
        ArrayList arrayList = this.f7459f;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                i6 = -1;
                break;
            } else if (((o) arrayList.get(i6)).f7481a == i5) {
                break;
            } else {
                i6++;
            }
        }
        if (i6 >= 0) {
            ArrayList arrayList2 = this.f7459f;
            if (i6 >= arrayList2.size()) {
                return;
            }
            arrayList2.remove(i6);
            p(true);
        }
    }

    public final void s(Bundle bundle) {
        MenuItem menuItemFindItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(j());
        int size = this.f7459f.size();
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((F) item.getSubMenu()).s(bundle);
            }
        }
        int i6 = bundle.getInt("android:menu:expandedactionview");
        if (i6 <= 0 || (menuItemFindItem = findItem(i6)) == null) {
            return;
        }
        menuItemFindItem.expandActionView();
    }

    @Override // android.view.Menu
    public final void setGroupCheckable(int i5, boolean z4, boolean z5) {
        ArrayList arrayList = this.f7459f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            o oVar = (o) arrayList.get(i6);
            if (oVar.f7482b == i5) {
                oVar.g(z5);
                oVar.setCheckable(z4);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z4) {
        this.f7473w = z4;
    }

    @Override // android.view.Menu
    public final void setGroupEnabled(int i5, boolean z4) {
        ArrayList arrayList = this.f7459f;
        int size = arrayList.size();
        for (int i6 = 0; i6 < size; i6++) {
            o oVar = (o) arrayList.get(i6);
            if (oVar.f7482b == i5) {
                oVar.setEnabled(z4);
            }
        }
    }

    @Override // android.view.Menu
    public final void setGroupVisible(int i5, boolean z4) {
        ArrayList arrayList = this.f7459f;
        int size = arrayList.size();
        boolean z5 = false;
        for (int i6 = 0; i6 < size; i6++) {
            o oVar = (o) arrayList.get(i6);
            if (oVar.f7482b == i5) {
                int i7 = oVar.f7501x;
                int i8 = (i7 & (-9)) | (z4 ? 0 : 8);
                oVar.f7501x = i8;
                if (i7 != i8) {
                    z5 = true;
                }
            }
        }
        if (z5) {
            p(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z4) {
        this.f7456c = z4;
        p(false);
    }

    @Override // android.view.Menu
    public final int size() {
        return this.f7459f.size();
    }

    public final void t(Bundle bundle) {
        int size = this.f7459f.size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i5 = 0; i5 < size; i5++) {
            MenuItem item = getItem(i5);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((F) item.getSubMenu()).t(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(j(), sparseArray);
        }
    }

    public final void u(int i5, CharSequence charSequence, int i6, Drawable drawable, View view) {
        if (view != null) {
            this.f7465o = view;
            this.f7464m = null;
            this.n = null;
        } else {
            if (i5 > 0) {
                this.f7464m = this.f7455b.getText(i5);
            } else if (charSequence != null) {
                this.f7464m = charSequence;
            }
            if (i6 > 0) {
                this.n = C.c.b(this.f7454a, i6);
            } else if (drawable != null) {
                this.n = drawable;
            }
            this.f7465o = null;
        }
        p(false);
    }

    public final void v() {
        this.f7466p = false;
        if (this.f7467q) {
            this.f7467q = false;
            p(this.f7468r);
        }
    }

    public final void w() {
        if (this.f7466p) {
            return;
        }
        this.f7466p = true;
        this.f7467q = false;
        this.f7468r = false;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5) {
        return a(0, 0, 0, this.f7455b.getString(i5));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5) {
        return addSubMenu(0, 0, 0, this.f7455b.getString(i5));
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, CharSequence charSequence) {
        return a(i5, i6, i7, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i5, int i6, int i7, CharSequence charSequence) {
        o oVarA = a(i5, i6, i7, charSequence);
        F f5 = new F(this.f7454a, this, oVarA);
        oVarA.f7492o = f5;
        f5.setHeaderTitle(oVarA.f7485e);
        return f5;
    }

    @Override // android.view.Menu
    public final MenuItem add(int i5, int i6, int i7, int i8) {
        return a(i5, i6, i7, this.f7455b.getString(i8));
    }

    @Override // android.view.Menu
    public final SubMenu addSubMenu(int i5, int i6, int i7, int i8) {
        return addSubMenu(i5, i6, i7, this.f7455b.getString(i8));
    }
}
