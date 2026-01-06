package T;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import com.unified.ur1.SatelliteTracker.h;
import k.T0;

/* loaded from: classes.dex */
public abstract class c extends BaseAdapter implements Filterable, d {

    /* renamed from: c, reason: collision with root package name */
    public boolean f2433c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f2434d;

    /* renamed from: e, reason: collision with root package name */
    public Cursor f2435e;

    /* renamed from: f, reason: collision with root package name */
    public int f2436f;
    public a g;
    public b h;

    /* renamed from: i, reason: collision with root package name */
    public e f2437i;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f2435e;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.g;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                b bVar = this.h;
                if (bVar != null) {
                    cursor2.unregisterDataSetObserver(bVar);
                }
            }
            this.f2435e = cursor;
            if (cursor != null) {
                a aVar2 = this.g;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                b bVar2 = this.h;
                if (bVar2 != null) {
                    cursor.registerDataSetObserver(bVar2);
                }
                this.f2436f = cursor.getColumnIndexOrThrow("_id");
                this.f2433c = true;
                notifyDataSetChanged();
            } else {
                this.f2436f = -1;
                this.f2433c = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f2433c || (cursor = this.f2435e) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i5, View view, ViewGroup viewGroup) {
        if (!this.f2433c) {
            return null;
        }
        this.f2435e.moveToPosition(i5);
        if (view == null) {
            T0 t02 = (T0) this;
            view = t02.f7704l.inflate(t02.f7703k, viewGroup, false);
        }
        a(view, this.f2435e);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f2437i == null) {
            e eVar = new e();
            eVar.f2438a = this;
            this.f2437i = eVar;
        }
        return this.f2437i;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i5) {
        Cursor cursor;
        if (!this.f2433c || (cursor = this.f2435e) == null) {
            return null;
        }
        cursor.moveToPosition(i5);
        return this.f2435e;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i5) {
        Cursor cursor;
        if (this.f2433c && (cursor = this.f2435e) != null && cursor.moveToPosition(i5)) {
            return this.f2435e.getLong(this.f2436f);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i5, View view, ViewGroup viewGroup) {
        if (!this.f2433c) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f2435e.moveToPosition(i5)) {
            throw new IllegalStateException(h.a(i5, "couldn't move cursor to position "));
        }
        if (view == null) {
            view = d(viewGroup);
        }
        a(view, this.f2435e);
        return view;
    }
}
