package androidx.appcompat.view.menu;

import L0.m;
import O.G;
import O.Y;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import com.unified.ur1.R;
import e.AbstractC0429a;
import j.InterfaceC0581A;
import j.o;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public class ListMenuItemView extends LinearLayout implements InterfaceC0581A, AbsListView.SelectionBoundsAdjuster {

    /* renamed from: c, reason: collision with root package name */
    public o f3298c;

    /* renamed from: d, reason: collision with root package name */
    public ImageView f3299d;

    /* renamed from: e, reason: collision with root package name */
    public RadioButton f3300e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f3301f;
    public CheckBox g;
    public TextView h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f3302i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f3303j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f3304k;

    /* renamed from: l, reason: collision with root package name */
    public final Drawable f3305l;

    /* renamed from: m, reason: collision with root package name */
    public final int f3306m;
    public final Context n;

    /* renamed from: o, reason: collision with root package name */
    public boolean f3307o;

    /* renamed from: p, reason: collision with root package name */
    public final Drawable f3308p;

    /* renamed from: q, reason: collision with root package name */
    public final boolean f3309q;

    /* renamed from: r, reason: collision with root package name */
    public LayoutInflater f3310r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f3311s;

    public ListMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m mVarK = m.k(getContext(), attributeSet, AbstractC0429a.f6129r, R.attr.listMenuViewStyle, 0);
        this.f3305l = mVarK.g(5);
        TypedArray typedArray = (TypedArray) mVarK.f1557e;
        this.f3306m = typedArray.getResourceId(1, -1);
        this.f3307o = typedArray.getBoolean(7, false);
        this.n = context;
        this.f3308p = mVarK.g(8);
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(null, new int[]{android.R.attr.divider}, R.attr.dropDownListViewStyle, 0);
        this.f3309q = typedArrayObtainStyledAttributes.hasValue(0);
        mVarK.n();
        typedArrayObtainStyledAttributes.recycle();
    }

    private LayoutInflater getInflater() {
        if (this.f3310r == null) {
            this.f3310r = LayoutInflater.from(getContext());
        }
        return this.f3310r;
    }

    private void setSubMenuArrowVisible(boolean z4) {
        ImageView imageView = this.f3302i;
        if (imageView != null) {
            imageView.setVisibility(z4 ? 0 : 8);
        }
    }

    @Override // android.widget.AbsListView.SelectionBoundsAdjuster
    public final void adjustListItemSelectionBounds(Rect rect) {
        ImageView imageView = this.f3303j;
        if (imageView == null || imageView.getVisibility() != 0) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f3303j.getLayoutParams();
        rect.top = this.f3303j.getHeight() + layoutParams.topMargin + layoutParams.bottomMargin + rect.top;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005e  */
    @Override // j.InterfaceC0581A
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(j.o r11) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ListMenuItemView.c(j.o):void");
    }

    @Override // j.InterfaceC0581A
    public o getItemData() {
        return this.f3298c;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        WeakHashMap weakHashMap = Y.f1904a;
        G.q(this, this.f3305l);
        TextView textView = (TextView) findViewById(R.id.title);
        this.f3301f = textView;
        int i5 = this.f3306m;
        if (i5 != -1) {
            textView.setTextAppearance(this.n, i5);
        }
        this.h = (TextView) findViewById(R.id.shortcut);
        ImageView imageView = (ImageView) findViewById(R.id.submenuarrow);
        this.f3302i = imageView;
        if (imageView != null) {
            imageView.setImageDrawable(this.f3308p);
        }
        this.f3303j = (ImageView) findViewById(R.id.group_divider);
        this.f3304k = (LinearLayout) findViewById(R.id.content);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i5, int i6) {
        if (this.f3299d != null && this.f3307o) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f3299d.getLayoutParams();
            int i7 = layoutParams.height;
            if (i7 > 0 && layoutParams2.width <= 0) {
                layoutParams2.width = i7;
            }
        }
        super.onMeasure(i5, i6);
    }

    public void setCheckable(boolean z4) {
        CompoundButton compoundButton;
        View view;
        if (!z4 && this.f3300e == null && this.g == null) {
            return;
        }
        if ((this.f3298c.f7501x & 4) != 0) {
            if (this.f3300e == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f3300e = radioButton;
                LinearLayout linearLayout = this.f3304k;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f3300e;
            view = this.g;
        } else {
            if (this.g == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.g = checkBox;
                LinearLayout linearLayout2 = this.f3304k;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.g;
            view = this.f3300e;
        }
        if (z4) {
            compoundButton.setChecked(this.f3298c.isChecked());
            if (compoundButton.getVisibility() != 0) {
                compoundButton.setVisibility(0);
            }
            if (view == null || view.getVisibility() == 8) {
                return;
            }
            view.setVisibility(8);
            return;
        }
        CheckBox checkBox2 = this.g;
        if (checkBox2 != null) {
            checkBox2.setVisibility(8);
        }
        RadioButton radioButton2 = this.f3300e;
        if (radioButton2 != null) {
            radioButton2.setVisibility(8);
        }
    }

    public void setChecked(boolean z4) {
        CompoundButton compoundButton;
        if ((this.f3298c.f7501x & 4) != 0) {
            if (this.f3300e == null) {
                RadioButton radioButton = (RadioButton) getInflater().inflate(R.layout.abc_list_menu_item_radio, (ViewGroup) this, false);
                this.f3300e = radioButton;
                LinearLayout linearLayout = this.f3304k;
                if (linearLayout != null) {
                    linearLayout.addView(radioButton, -1);
                } else {
                    addView(radioButton, -1);
                }
            }
            compoundButton = this.f3300e;
        } else {
            if (this.g == null) {
                CheckBox checkBox = (CheckBox) getInflater().inflate(R.layout.abc_list_menu_item_checkbox, (ViewGroup) this, false);
                this.g = checkBox;
                LinearLayout linearLayout2 = this.f3304k;
                if (linearLayout2 != null) {
                    linearLayout2.addView(checkBox, -1);
                } else {
                    addView(checkBox, -1);
                }
            }
            compoundButton = this.g;
        }
        compoundButton.setChecked(z4);
    }

    public void setForceShowIcon(boolean z4) {
        this.f3311s = z4;
        this.f3307o = z4;
    }

    public void setGroupDividerEnabled(boolean z4) {
        ImageView imageView = this.f3303j;
        if (imageView != null) {
            imageView.setVisibility((this.f3309q || !z4) ? 8 : 0);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f3298c.n.getClass();
        boolean z4 = this.f3311s;
        if (z4 || this.f3307o) {
            ImageView imageView = this.f3299d;
            if (imageView == null && drawable == null && !this.f3307o) {
                return;
            }
            if (imageView == null) {
                ImageView imageView2 = (ImageView) getInflater().inflate(R.layout.abc_list_menu_item_icon, (ViewGroup) this, false);
                this.f3299d = imageView2;
                LinearLayout linearLayout = this.f3304k;
                if (linearLayout != null) {
                    linearLayout.addView(imageView2, 0);
                } else {
                    addView(imageView2, 0);
                }
            }
            if (drawable == null && !this.f3307o) {
                this.f3299d.setVisibility(8);
                return;
            }
            ImageView imageView3 = this.f3299d;
            if (!z4) {
                drawable = null;
            }
            imageView3.setImageDrawable(drawable);
            if (this.f3299d.getVisibility() != 0) {
                this.f3299d.setVisibility(0);
            }
        }
    }

    public void setTitle(CharSequence charSequence) {
        if (charSequence == null) {
            if (this.f3301f.getVisibility() != 8) {
                this.f3301f.setVisibility(8);
            }
        } else {
            this.f3301f.setText(charSequence);
            if (this.f3301f.getVisibility() != 0) {
                this.f3301f.setVisibility(0);
            }
        }
    }
}
