package androidx.appcompat.widget;

import android.view.inputmethod.InputMethodManager;
import androidx.appcompat.widget.SearchView;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ SearchView.SearchAutoComplete f3488j;

    public d(SearchView.SearchAutoComplete searchAutoComplete) {
        this.f3488j = searchAutoComplete;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchView.SearchAutoComplete searchAutoComplete = this.f3488j;
        if (searchAutoComplete.f3438i) {
            ((InputMethodManager) searchAutoComplete.getContext().getSystemService("input_method")).showSoftInput(searchAutoComplete, 0);
            searchAutoComplete.f3438i = false;
        }
    }
}
