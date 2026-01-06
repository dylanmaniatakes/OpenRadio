package k;

import O.C0160e;
import O.InterfaceC0158d;
import android.app.Activity;
import android.content.ClipData;
import android.os.Build;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import f3.C0519j;

/* renamed from: k.C, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0608C {
    public static boolean a(DragEvent dragEvent, TextView textView, Activity activity) {
        InterfaceC0158d c0519j;
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ClipData clipData = dragEvent.getClipData();
            if (Build.VERSION.SDK_INT >= 31) {
                c0519j = new C0519j(clipData, 3);
            } else {
                C0160e c0160e = new C0160e();
                c0160e.f1924d = clipData;
                c0160e.f1925e = 3;
                c0519j = c0160e;
            }
            O.Y.g(textView, c0519j.c());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    public static boolean b(DragEvent dragEvent, View view, Activity activity) {
        InterfaceC0158d c0519j;
        activity.requestDragAndDropPermissions(dragEvent);
        ClipData clipData = dragEvent.getClipData();
        if (Build.VERSION.SDK_INT >= 31) {
            c0519j = new C0519j(clipData, 3);
        } else {
            C0160e c0160e = new C0160e();
            c0160e.f1924d = clipData;
            c0160e.f1925e = 3;
            c0519j = c0160e;
        }
        O.Y.g(view, c0519j.c());
        return true;
    }
}
