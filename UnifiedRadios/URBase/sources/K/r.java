package k;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.Log;
import com.unified.ur1.R;

/* loaded from: classes.dex */
public final class r {

    /* renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f7853b = PorterDuff.Mode.SRC_IN;

    /* renamed from: c, reason: collision with root package name */
    public static r f7854c;

    /* renamed from: a, reason: collision with root package name */
    public G0 f7855a;

    public static synchronized r a() {
        try {
            if (f7854c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f7854c;
    }

    public static synchronized PorterDuffColorFilter c(int i5, PorterDuff.Mode mode) {
        return G0.g(i5, mode);
    }

    public static synchronized void d() {
        if (f7854c == null) {
            r rVar = new r();
            f7854c = rVar;
            rVar.f7855a = G0.c();
            G0 g02 = f7854c.f7855a;
            X2.n nVar = new X2.n();
            nVar.f2818a = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
            nVar.f2819b = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
            nVar.f2820c = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
            nVar.f2821d = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
            nVar.f2822e = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
            nVar.f2823f = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
            synchronized (g02) {
                g02.f7653e = nVar;
            }
        }
    }

    public static void e(Drawable drawable, W0 w02, int[] iArr) {
        PorterDuff.Mode mode = G0.f7648f;
        int[] state = drawable.getState();
        int[] iArr2 = AbstractC0636i0.f7786a;
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z4 = w02.f7727d;
        if (!z4 && !w02.f7726c) {
            drawable.clearColorFilter();
            return;
        }
        PorterDuffColorFilter porterDuffColorFilterG = null;
        ColorStateList colorStateList = z4 ? w02.f7724a : null;
        PorterDuff.Mode mode2 = w02.f7726c ? w02.f7725b : G0.f7648f;
        if (colorStateList != null && mode2 != null) {
            porterDuffColorFilterG = G0.g(colorStateList.getColorForState(iArr, 0), mode2);
        }
        drawable.setColorFilter(porterDuffColorFilterG);
    }

    public final synchronized Drawable b(Context context, int i5) {
        return this.f7855a.e(context, i5);
    }
}
