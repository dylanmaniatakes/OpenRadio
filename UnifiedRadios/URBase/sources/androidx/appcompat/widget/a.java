package androidx.appcompat.widget;

import android.app.SearchableInfo;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.SearchView;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class a implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ SearchView f3486c;

    public a(SearchView searchView) {
        this.f3486c = searchView;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        SearchView searchView = this.f3486c;
        ImageView imageView = searchView.f3433v;
        SearchView.SearchAutoComplete searchAutoComplete = searchView.f3429r;
        if (view == imageView) {
            searchView.y(false);
            searchAutoComplete.requestFocus();
            searchAutoComplete.setImeVisibility(true);
            View.OnClickListener onClickListener = searchView.f3411N;
            if (onClickListener != null) {
                onClickListener.onClick(searchView);
                return;
            }
            return;
        }
        if (view == searchView.f3435x) {
            searchView.o();
            return;
        }
        if (view == searchView.f3434w) {
            searchView.s();
            return;
        }
        if (view != searchView.f3436y) {
            if (view == searchAutoComplete) {
                searchView.n();
                return;
            }
            return;
        }
        SearchableInfo searchableInfo = searchView.f3424d0;
        if (searchableInfo == null) {
            return;
        }
        try {
            if (!searchableInfo.getVoiceSearchLaunchWebSearch()) {
                if (searchableInfo.getVoiceSearchLaunchRecognizer()) {
                    searchView.getContext().startActivity(searchView.m(searchView.f3408K, searchableInfo));
                }
            } else {
                Intent intent = new Intent(searchView.f3407J);
                ComponentName searchActivity = searchableInfo.getSearchActivity();
                intent.putExtra("calling_package", searchActivity == null ? null : searchActivity.flattenToShortString());
                searchView.getContext().startActivity(intent);
            }
        } catch (ActivityNotFoundException unused) {
            Log.w("SearchView", "Could not find voice search activity");
        }
    }
}
