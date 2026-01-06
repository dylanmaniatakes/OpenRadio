package E;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.Font;
import android.graphics.fonts.FontFamily;
import android.graphics.fonts.FontStyle;
import android.os.ParcelFileDescriptor;
import java.io.IOException;

/* loaded from: classes.dex */
public final class i extends h4.f {
    public static Font n(FontFamily fontFamily, int i5) {
        FontStyle fontStyle = new FontStyle((i5 & 1) != 0 ? 700 : 400, (i5 & 2) != 0 ? 1 : 0);
        Font font = fontFamily.getFont(0);
        int iO = o(fontStyle, font.getStyle());
        for (int i6 = 1; i6 < fontFamily.getSize(); i6++) {
            Font font2 = fontFamily.getFont(i6);
            int iO2 = o(fontStyle, font2.getStyle());
            if (iO2 < iO) {
                font = font2;
                iO = iO2;
            }
        }
        return font;
    }

    public static int o(FontStyle fontStyle, FontStyle fontStyle2) {
        return (Math.abs(fontStyle.getWeight() - fontStyle2.getWeight()) / 100) + (fontStyle.getSlant() == fontStyle2.getSlant() ? 0 : 2);
    }

    @Override // h4.f
    public final Typeface d(Context context, D.f fVar, Resources resources, int i5) throws IOException {
        try {
            FontFamily.Builder builder = null;
            for (D.g gVar : fVar.f203a) {
                try {
                    Font fontBuild = new Font.Builder(resources, gVar.f209f).setWeight(gVar.f205b).setSlant(gVar.f206c ? 1 : 0).setTtcIndex(gVar.f208e).setFontVariationSettings(gVar.f207d).build();
                    if (builder == null) {
                        builder = new FontFamily.Builder(fontBuild);
                    } else {
                        builder.addFont(fontBuild);
                    }
                } catch (IOException unused) {
                }
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(n(fontFamilyBuild, i5).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // h4.f
    public final Typeface e(Context context, L.i[] iVarArr, int i5) throws IOException {
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor;
        ContentResolver contentResolver = context.getContentResolver();
        try {
            FontFamily.Builder builder = null;
            for (L.i iVar : iVarArr) {
                try {
                    parcelFileDescriptorOpenFileDescriptor = contentResolver.openFileDescriptor(iVar.f1523a, "r", null);
                } catch (IOException unused) {
                }
                if (parcelFileDescriptorOpenFileDescriptor == null) {
                    if (parcelFileDescriptorOpenFileDescriptor != null) {
                    }
                } else {
                    try {
                        Font fontBuild = new Font.Builder(parcelFileDescriptorOpenFileDescriptor).setWeight(iVar.f1525c).setSlant(iVar.f1526d ? 1 : 0).setTtcIndex(iVar.f1524b).build();
                        if (builder == null) {
                            builder = new FontFamily.Builder(fontBuild);
                        } else {
                            builder.addFont(fontBuild);
                        }
                    } catch (Throwable th) {
                        try {
                            parcelFileDescriptorOpenFileDescriptor.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                parcelFileDescriptorOpenFileDescriptor.close();
            }
            if (builder == null) {
                return null;
            }
            FontFamily fontFamilyBuild = builder.build();
            return new Typeface.CustomFallbackBuilder(fontFamilyBuild).setStyle(n(fontFamilyBuild, i5).getStyle()).build();
        } catch (Exception unused2) {
            return null;
        }
    }

    @Override // h4.f
    public final Typeface f(Context context, Resources resources, int i5, String str, int i6) throws IOException {
        try {
            Font fontBuild = new Font.Builder(resources, i5).build();
            return new Typeface.CustomFallbackBuilder(new FontFamily.Builder(fontBuild).build()).setStyle(fontBuild.getStyle()).build();
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // h4.f
    public final L.i g(int i5, L.i[] iVarArr) {
        throw new RuntimeException("Do not use this function in API 29 or later.");
    }
}
