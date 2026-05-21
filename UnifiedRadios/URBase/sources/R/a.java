package R;

import android.view.inputmethod.EditorInfo;

/* loaded from: classes.dex */
public abstract class a {
    public static void a(EditorInfo editorInfo, CharSequence charSequence) {
        editorInfo.setInitialSurroundingSubText(charSequence, 0);
    }
}
