package R;

import D0.p;
import L0.l;
import O.C0160e;
import O.InterfaceC0158d;
import O.Y;
import Z2.c;
import android.content.ClipData;
import android.content.ClipDescription;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.view.inputmethod.InputContentInfo;
import f3.C0519j;

/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f2193a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(InputConnection inputConnection, p pVar) {
        super(inputConnection, false);
        this.f2193a = pVar;
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean commitContent(InputContentInfo inputContentInfo, int i5, Bundle bundle) {
        Bundle bundle2;
        InterfaceC0158d c0519j;
        c cVar = inputContentInfo == null ? null : new c(11, new l(inputContentInfo));
        p pVar = this.f2193a;
        pVar.getClass();
        if ((i5 & 1) != 0) {
            try {
                ((l) cVar.f3147d).t();
                InputContentInfo inputContentInfo2 = (InputContentInfo) ((l) cVar.f3147d).f1554d;
                bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle2.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", inputContentInfo2);
            } catch (Exception e5) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e5);
            }
        } else {
            bundle2 = bundle;
        }
        ClipDescription description = ((InputContentInfo) ((l) cVar.f3147d).f1554d).getDescription();
        l lVar = (l) cVar.f3147d;
        ClipData clipData = new ClipData(description, new ClipData.Item(((InputContentInfo) lVar.f1554d).getContentUri()));
        if (Build.VERSION.SDK_INT >= 31) {
            c0519j = new C0519j(clipData, 2);
        } else {
            C0160e c0160e = new C0160e();
            c0160e.f1924d = clipData;
            c0160e.f1925e = 2;
            c0519j = c0160e;
        }
        c0519j.o(((InputContentInfo) lVar.f1554d).getLinkUri());
        c0519j.g(bundle2);
        if (Y.g((View) pVar.f289d, c0519j.c()) == null) {
            return true;
        }
        return super.commitContent(inputContentInfo, i5, bundle);
    }
}
