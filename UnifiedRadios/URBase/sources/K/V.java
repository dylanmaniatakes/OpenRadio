package k;

import android.widget.TextView;

/* loaded from: classes.dex */
public abstract class V {
    public static int a(TextView textView) {
        return textView.getAutoSizeStepGranularity();
    }

    public static void b(TextView textView, int i5, int i6, int i7, int i8) {
        textView.setAutoSizeTextTypeUniformWithConfiguration(i5, i6, i7, i8);
    }

    public static void c(TextView textView, int[] iArr, int i5) {
        textView.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i5);
    }

    public static boolean d(TextView textView, String str) {
        return textView.setFontVariationSettings(str);
    }
}
