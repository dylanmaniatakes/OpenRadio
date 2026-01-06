package j;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;
import f.C0467d;
import f.DialogC0469f;

/* loaded from: classes.dex */
public final class i implements z, AdapterView.OnItemClickListener {

    /* renamed from: c, reason: collision with root package name */
    public Context f7445c;

    /* renamed from: d, reason: collision with root package name */
    public LayoutInflater f7446d;

    /* renamed from: e, reason: collision with root package name */
    public m f7447e;

    /* renamed from: f, reason: collision with root package name */
    public ExpandedMenuView f7448f;
    public y g;
    public h h;

    public i(Context context) {
        this.f7445c = context;
        this.f7446d = LayoutInflater.from(context);
    }

    @Override // j.z
    public final void a(m mVar, boolean z4) {
        y yVar = this.g;
        if (yVar != null) {
            yVar.a(mVar, z4);
        }
    }

    @Override // j.z
    public final boolean d(o oVar) {
        return false;
    }

    @Override // j.z
    public final void e(Parcelable parcelable) {
        SparseArray<Parcelable> sparseParcelableArray = ((Bundle) parcelable).getSparseParcelableArray("android:menu:list");
        if (sparseParcelableArray != null) {
            this.f7448f.restoreHierarchyState(sparseParcelableArray);
        }
    }

    @Override // j.z
    public final void g(boolean z4) {
        h hVar = this.h;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // j.z
    public final int getId() {
        return 0;
    }

    @Override // j.z
    public final void h(Context context, m mVar) {
        if (this.f7445c != null) {
            this.f7445c = context;
            if (this.f7446d == null) {
                this.f7446d = LayoutInflater.from(context);
            }
        }
        this.f7447e = mVar;
        h hVar = this.h;
        if (hVar != null) {
            hVar.notifyDataSetChanged();
        }
    }

    @Override // j.z
    public final boolean i() {
        return false;
    }

    @Override // j.z
    public final Parcelable j() {
        if (this.f7448f == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        SparseArray<Parcelable> sparseArray = new SparseArray<>();
        ExpandedMenuView expandedMenuView = this.f7448f;
        if (expandedMenuView != null) {
            expandedMenuView.saveHierarchyState(sparseArray);
        }
        bundle.putSparseParcelableArray("android:menu:list", sparseArray);
        return bundle;
    }

    @Override // j.z
    public final boolean k(o oVar) {
        return false;
    }

    @Override // j.z
    public final void l(y yVar) {
        this.g = yVar;
    }

    @Override // j.z
    public final boolean m(F f5) {
        if (!f5.hasVisibleItems()) {
            return false;
        }
        n nVar = new n();
        nVar.f7475c = f5;
        Context context = f5.f7454a;
        L.h hVar = new L.h(context);
        C0467d c0467d = (C0467d) hVar.f1522d;
        i iVar = new i(c0467d.f6289a);
        nVar.f7477e = iVar;
        iVar.g = nVar;
        f5.b(iVar, context);
        i iVar2 = nVar.f7477e;
        if (iVar2.h == null) {
            iVar2.h = new h(iVar2);
        }
        c0467d.f6302q = iVar2.h;
        c0467d.f6303r = nVar;
        View view = f5.f7465o;
        if (view != null) {
            c0467d.f6293e = view;
        } else {
            c0467d.f6291c = f5.n;
            c0467d.f6292d = f5.f7464m;
        }
        c0467d.f6300o = nVar;
        DialogC0469f dialogC0469fB = hVar.b();
        nVar.f7476d = dialogC0469fB;
        dialogC0469fB.setOnDismissListener(nVar);
        WindowManager.LayoutParams attributes = nVar.f7476d.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        nVar.f7476d.show();
        y yVar = this.g;
        if (yVar == null) {
            return true;
        }
        yVar.i(f5);
        return true;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i5, long j5) {
        this.f7447e.q(this.h.getItem(i5), this, 0);
    }
}
