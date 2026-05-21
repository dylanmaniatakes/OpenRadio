package O;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public abstract class E0 {
    public static int a(int i5) {
        int iStatusBars;
        int i6 = 0;
        for (int i7 = 1; i7 <= 256; i7 <<= 1) {
            if ((i5 & i7) != 0) {
                if (i7 == 1) {
                    iStatusBars = WindowInsets.Type.statusBars();
                } else if (i7 == 2) {
                    iStatusBars = WindowInsets.Type.navigationBars();
                } else if (i7 == 4) {
                    iStatusBars = WindowInsets.Type.captionBar();
                } else if (i7 == 8) {
                    iStatusBars = WindowInsets.Type.ime();
                } else if (i7 == 16) {
                    iStatusBars = WindowInsets.Type.systemGestures();
                } else if (i7 == 32) {
                    iStatusBars = WindowInsets.Type.mandatorySystemGestures();
                } else if (i7 == 64) {
                    iStatusBars = WindowInsets.Type.tappableElement();
                } else if (i7 == 128) {
                    iStatusBars = WindowInsets.Type.displayCutout();
                }
                i6 |= iStatusBars;
            }
        }
        return i6;
    }
}
