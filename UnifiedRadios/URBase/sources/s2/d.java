package s2;

import a.AbstractC0203a;
import com.google.android.material.internal.CheckableImageButton;

/* loaded from: classes.dex */
public final class d extends m {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f9588e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(l lVar, int i5) {
        super(lVar);
        this.f9588e = i5;
    }

    @Override // s2.m
    public void r() {
        switch (this.f9588e) {
            case 0:
                l lVar = this.f9630b;
                lVar.f9621q = null;
                CheckableImageButton checkableImageButton = lVar.f9614i;
                checkableImageButton.setOnLongClickListener(null);
                AbstractC0203a.m(checkableImageButton, null);
                break;
        }
    }
}
