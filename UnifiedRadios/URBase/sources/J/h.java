package j;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.unified.ur1.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h extends BaseAdapter {

    /* renamed from: c, reason: collision with root package name */
    public int f7443c = -1;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ i f7444d;

    public h(i iVar) {
        this.f7444d = iVar;
        a();
    }

    public final void a() {
        m mVar = this.f7444d.f7447e;
        o oVar = mVar.f7472v;
        if (oVar != null) {
            mVar.i();
            ArrayList arrayList = mVar.f7461j;
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                if (((o) arrayList.get(i5)) == oVar) {
                    this.f7443c = i5;
                    return;
                }
            }
        }
        this.f7443c = -1;
    }

    @Override // android.widget.Adapter
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final o getItem(int i5) {
        i iVar = this.f7444d;
        m mVar = iVar.f7447e;
        mVar.i();
        ArrayList arrayList = mVar.f7461j;
        iVar.getClass();
        int i6 = this.f7443c;
        if (i6 >= 0 && i5 >= i6) {
            i5++;
        }
        return (o) arrayList.get(i5);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        i iVar = this.f7444d;
        m mVar = iVar.f7447e;
        mVar.i();
        int size = mVar.f7461j.size();
        iVar.getClass();
        return this.f7443c < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i5) {
        return i5;
    }

    @Override // android.widget.Adapter
    public final View getView(int i5, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.f7444d.f7446d.inflate(R.layout.abc_list_menu_item_layout, viewGroup, false);
        }
        ((InterfaceC0581A) view).c(getItem(i5));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
