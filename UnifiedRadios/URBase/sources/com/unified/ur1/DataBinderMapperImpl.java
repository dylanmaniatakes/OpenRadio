package com.unified.ur1;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.databinding.a;
import androidx.databinding.e;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import h3.C0561b;
import h3.C0563d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class DataBinderMapperImpl extends a {

    /* renamed from: a, reason: collision with root package name */
    public static final SparseIntArray f5556a;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(2);
        f5556a = sparseIntArray;
        sparseIntArray.put(R.layout.activity_main, 1);
        sparseIntArray.put(R.layout.memory_row, 2);
    }

    @Override // androidx.databinding.a
    public final List a() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    @Override // androidx.databinding.a
    public final e b(View view) {
        int i5 = f5556a.get(R.layout.activity_main);
        if (i5 > 0) {
            Object tag = view.getTag();
            if (tag == null) {
                throw new RuntimeException("view must have a tag");
            }
            if (i5 == 1) {
                if (!"layout/activity_main_0".equals(tag)) {
                    throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
                }
                Object[] objArr = new Object[61];
                e.y(view, objArr, C0561b.f7084p, true);
                Object obj = objArr[3];
                if (obj != null) {
                    View view2 = (View) obj;
                    int i6 = R.id.InCompDevice;
                    if (((TextView) AbstractC0296a2.d(view2, R.id.InCompDevice)) != null) {
                        i6 = R.id.contactSupportButton;
                        if (((AppCompatButton) AbstractC0296a2.d(view2, R.id.contactSupportButton)) != null) {
                            i6 = R.id.incompatibilityDetails;
                            if (((TextView) AbstractC0296a2.d(view2, R.id.incompatibilityDetails)) != null) {
                                i6 = R.id.incompatibilityProgress;
                                if (((ProgressBar) AbstractC0296a2.d(view2, R.id.incompatibilityProgress)) != null) {
                                    i6 = R.id.incompatibilitySubtitle;
                                    if (((TextView) AbstractC0296a2.d(view2, R.id.incompatibilitySubtitle)) != null) {
                                        i6 = R.id.notcompatible;
                                        if (((LinearLayout) AbstractC0296a2.d(view2, R.id.notcompatible)) != null) {
                                            i6 = R.id.retryButton;
                                            if (((AppCompatButton) AbstractC0296a2.d(view2, R.id.retryButton)) != null) {
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i6)));
                }
                Object obj2 = objArr[1];
                int i7 = R.id.lock_overlay;
                if (obj2 != null) {
                    View view3 = (View) obj2;
                    int i8 = R.id.lock_icon;
                    if (((ImageView) AbstractC0296a2.d(view3, R.id.lock_icon)) == null) {
                        i7 = i8;
                    } else if (AbstractC0296a2.d(view3, R.id.lock_overlay) != null) {
                        i8 = R.id.tx_icon;
                        if (((ImageView) AbstractC0296a2.d(view3, R.id.tx_icon)) != null) {
                            i8 = R.id.tx_inhibit;
                            if (((ImageView) AbstractC0296a2.d(view3, R.id.tx_inhibit)) != null) {
                            }
                        }
                        i7 = i8;
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(view3.getResources().getResourceName(i7)));
                }
                Object obj3 = objArr[2];
                if (obj3 != null) {
                    View view4 = (View) obj3;
                    if (AbstractC0296a2.d(view4, R.id.lock_overlay) != null) {
                        i7 = R.id.textView2;
                        if (((TextView) AbstractC0296a2.d(view4, R.id.textView2)) != null) {
                        }
                    }
                    throw new NullPointerException("Missing required view with ID: ".concat(view4.getResources().getResourceName(i7)));
                }
                C0561b c0561b = new C0561b(view);
                c0561b.f7085o = -1L;
                ((FrameLayout) objArr[0]).setTag(null);
                view.setTag(R.id.dataBinding, c0561b);
                synchronized (c0561b) {
                    c0561b.f7085o = 2L;
                }
                c0561b.z();
                return c0561b;
            }
            if (i5 == 2) {
                if (!"layout/memory_row_0".equals(tag)) {
                    throw new IllegalArgumentException("The tag for memory_row is invalid. Received: " + tag);
                }
                Object[] objArr2 = new Object[4];
                e.y(view, objArr2, C0563d.f7087q, true);
                LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) objArr2[0];
                C0563d c0563d = new C0563d(view, linearLayoutCompat);
                c0563d.f7088p = -1L;
                c0563d.f7086o.setTag(null);
                view.setTag(R.id.dataBinding, c0563d);
                synchronized (c0563d) {
                    c0563d.f7088p = 1L;
                }
                c0563d.z();
                return c0563d;
            }
        }
        return null;
    }

    @Override // androidx.databinding.a
    public final e c(View[] viewArr) {
        if (viewArr.length != 0 && f5556a.get(R.layout.activity_main) > 0 && viewArr[0].getTag() == null) {
            throw new RuntimeException("view must have a tag");
        }
        return null;
    }
}
