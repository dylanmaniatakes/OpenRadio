package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public abstract class N {
    private final O mObservable = new O();
    private boolean mHasStableIds = false;
    private M mStateRestorationPolicy = M.f4064j;

    public final void bindViewHolder(n0 n0Var, int i5) {
        boolean z4 = n0Var.mBindingAdapter == null;
        if (z4) {
            n0Var.mPosition = i5;
            if (hasStableIds()) {
                n0Var.mItemId = getItemId(i5);
            }
            n0Var.setFlags(1, 519);
            int i6 = K.l.f1491a;
            K.k.a("RV OnBindView");
        }
        n0Var.mBindingAdapter = this;
        if (RecyclerView.f4066C0) {
            if (n0Var.itemView.getParent() == null) {
                View view = n0Var.itemView;
                WeakHashMap weakHashMap = O.Y.f1904a;
                if (O.J.b(view) != n0Var.isTmpDetached()) {
                    throw new IllegalStateException("Temp-detached state out of sync with reality. holder.isTmpDetached(): " + n0Var.isTmpDetached() + ", attached to window: " + O.J.b(n0Var.itemView) + ", holder: " + n0Var);
                }
            }
            if (n0Var.itemView.getParent() == null) {
                View view2 = n0Var.itemView;
                WeakHashMap weakHashMap2 = O.Y.f1904a;
                if (O.J.b(view2)) {
                    throw new IllegalStateException("Attempting to bind attached holder with no parent (AKA temp detached): " + n0Var);
                }
            }
        }
        onBindViewHolder(n0Var, i5, n0Var.getUnmodifiedPayloads());
        if (z4) {
            n0Var.clearPayload();
            ViewGroup.LayoutParams layoutParams = n0Var.itemView.getLayoutParams();
            if (layoutParams instanceof Y) {
                ((Y) layoutParams).f4192c = true;
            }
            int i7 = K.l.f1491a;
            K.k.b();
        }
    }

    public boolean canRestoreState() {
        int iOrdinal = this.mStateRestorationPolicy.ordinal();
        return iOrdinal != 1 ? iOrdinal != 2 : getItemCount() > 0;
    }

    public final n0 createViewHolder(ViewGroup viewGroup, int i5) {
        try {
            int i6 = K.l.f1491a;
            K.k.a("RV CreateView");
            n0 n0VarOnCreateViewHolder = onCreateViewHolder(viewGroup, i5);
            if (n0VarOnCreateViewHolder.itemView.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            n0VarOnCreateViewHolder.mItemViewType = i5;
            K.k.b();
            return n0VarOnCreateViewHolder;
        } catch (Throwable th) {
            int i7 = K.l.f1491a;
            K.k.b();
            throw th;
        }
    }

    public int findRelativeAdapterPositionIn(N n, n0 n0Var, int i5) {
        if (n == this) {
            return i5;
        }
        return -1;
    }

    public abstract int getItemCount();

    public long getItemId(int i5) {
        return -1L;
    }

    public int getItemViewType(int i5) {
        return 0;
    }

    public final M getStateRestorationPolicy() {
        return this.mStateRestorationPolicy;
    }

    public final boolean hasObservers() {
        return this.mObservable.a();
    }

    public final boolean hasStableIds() {
        return this.mHasStableIds;
    }

    public final void notifyDataSetChanged() {
        this.mObservable.b();
    }

    public final void notifyItemChanged(int i5) {
        this.mObservable.d(i5, 1, null);
    }

    public final void notifyItemInserted(int i5) {
        this.mObservable.e(i5, 1);
    }

    public final void notifyItemMoved(int i5, int i6) {
        this.mObservable.c(i5, i6);
    }

    public final void notifyItemRangeChanged(int i5, int i6) {
        this.mObservable.d(i5, i6, null);
    }

    public final void notifyItemRangeInserted(int i5, int i6) {
        this.mObservable.e(i5, i6);
    }

    public final void notifyItemRangeRemoved(int i5, int i6) {
        this.mObservable.f(i5, i6);
    }

    public final void notifyItemRemoved(int i5) {
        this.mObservable.f(i5, 1);
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
    }

    public abstract void onBindViewHolder(n0 n0Var, int i5);

    public void onBindViewHolder(n0 n0Var, int i5, List<Object> list) {
        onBindViewHolder(n0Var, i5);
    }

    public abstract n0 onCreateViewHolder(ViewGroup viewGroup, int i5);

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
    }

    public boolean onFailedToRecycleView(n0 n0Var) {
        return false;
    }

    public void onViewAttachedToWindow(n0 n0Var) {
    }

    public void onViewDetachedFromWindow(n0 n0Var) {
    }

    public void onViewRecycled(n0 n0Var) {
    }

    public void registerAdapterDataObserver(P p4) {
        this.mObservable.registerObserver(p4);
    }

    public void setHasStableIds(boolean z4) {
        if (hasObservers()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.mHasStableIds = z4;
    }

    public void setStateRestorationPolicy(M m5) {
        this.mStateRestorationPolicy = m5;
        this.mObservable.g();
    }

    public void unregisterAdapterDataObserver(P p4) {
        this.mObservable.unregisterObserver(p4);
    }

    public final void notifyItemChanged(int i5, Object obj) {
        this.mObservable.d(i5, 1, obj);
    }

    public final void notifyItemRangeChanged(int i5, int i6, Object obj) {
        this.mObservable.d(i5, i6, obj);
    }
}
