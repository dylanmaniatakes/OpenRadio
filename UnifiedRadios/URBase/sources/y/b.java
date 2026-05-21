package Y;

import J1.C;
import android.os.Bundle;
import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public final class b extends InputConnectionWrapper {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f2868a;

    /* renamed from: b, reason: collision with root package name */
    public final C f2869b;

    public b(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        C c2 = new C(20);
        super(inputConnection, false);
        this.f2868a = textView;
        this.f2869b = c2;
        if (androidx.emoji2.text.j.f3607j != null) {
            androidx.emoji2.text.j jVarA = androidx.emoji2.text.j.a();
            if (jVarA.b() != 1 || editorInfo == null) {
                return;
            }
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            androidx.emoji2.text.e eVar = jVarA.f3612e;
            eVar.getClass();
            Bundle bundle = editorInfo.extras;
            X.b bVar = (X.b) ((L0.i) eVar.f3602c).f1547c;
            int iA = bVar.a(4);
            bundle.putInt("android.support.text.emoji.emojiCompat_metadataVersion", iA != 0 ? ((ByteBuffer) bVar.f1892d).getInt(iA + bVar.f1889a) : 0);
            Bundle bundle2 = editorInfo.extras;
            ((androidx.emoji2.text.j) eVar.f3600a).getClass();
            bundle2.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", false);
        }
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingText(int i5, int i6) {
        Editable editableText = this.f2868a.getEditableText();
        this.f2869b.getClass();
        return C.j(this, editableText, i5, i6, false) || super.deleteSurroundingText(i5, i6);
    }

    @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
    public final boolean deleteSurroundingTextInCodePoints(int i5, int i6) {
        Editable editableText = this.f2868a.getEditableText();
        this.f2869b.getClass();
        return C.j(this, editableText, i5, i6, true) || super.deleteSurroundingTextInCodePoints(i5, i6);
    }
}
