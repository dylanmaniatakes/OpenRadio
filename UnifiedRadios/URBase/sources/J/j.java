package j;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j extends BaseAdapter {

    /* renamed from: c, reason: collision with root package name */
    public final m f7449c;

    /* renamed from: d, reason: collision with root package name */
    public int f7450d = -1;

    /* renamed from: e, reason: collision with root package name */
    public boolean f7451e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f7452f;
    public final LayoutInflater g;
    public final int h;

    public j(m mVar, LayoutInflater layoutInflater, boolean z4, int i5) {
        this.f7452f = z4;
        this.g = layoutInflater;
        this.f7449c = mVar;
        this.h = i5;
        a();
    }

    public final void a() {
        m mVar = this.f7449c;
        o oVar = mVar.f7472v;
        if (oVar != null) {
            mVar.i();
            ArrayList arrayList = mVar.f7461j;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (((o) arrayList.get(i5)) == oVar) {
                    this.f7450d = i5;
                    return;
                }
            }
        }
        this.f7450d = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final o getItem(int i5) {
        ArrayList arrayListL;
        boolean z4 = this.f7452f;
        m mVar = this.f7449c;
        if (z4) {
            mVar.i();
            arrayListL = mVar.f7461j;
        } else {
            arrayListL = mVar.l();
        }
        int i6 = this.f7450d;
        if (i6 >= 0 && i5 >= i6) {
            i5++;
        }
        return (o) arrayListL.get(i5);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        boolean z4 = this.f7452f;
        m mVar = this.f7449c;
        if (z4) {
            mVar.i();
            arrayListL = mVar.f7461j;
        } else {
            arrayListL = mVar.l();
        }
        return this.f7450d < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i5) {
        return i5;
    }

    @Override // android.widget.Adapter
    public final View getView(int i5, View view, ViewGroup viewGroup) {
        boolean z4 = false;
        if (view == null) {
            view = this.g.inflate(this.h, viewGroup, false);
        }
        int i6 = getItem(i5).f7482b;
        int i7 = i5 - 1;
        int i8 = i7 >= 0 ? getItem(i7).f7482b : i6;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        if (this.f7449c.m() && i6 != i8) {
            z4 = true;
        }
        listMenuItemView.setGroupDividerEnabled(z4);
        InterfaceC0581A interfaceC0581A = (InterfaceC0581A) view;
        if (this.f7451e) {
            listMenuItemView.setForceShowIcon(true);
        }
        interfaceC0581A.c(getItem(i5));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
