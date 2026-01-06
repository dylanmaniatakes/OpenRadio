package L;

import P.u;
import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.UnifiedInboxActivity;
import e3.C0454h;
import f.C0466c;
import f.C0467d;
import f.C0468e;
import f.DialogC0469f;
import f3.C0524o;
import java.util.Iterator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes.dex */
public final class h implements Q3.f, u, Callback {

    /* renamed from: c, reason: collision with root package name */
    public int f1521c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f1522d;

    public /* synthetic */ h(int i5, Object obj) {
        this.f1522d = obj;
        this.f1521c = i5;
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e5 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // Q3.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(java.lang.Object r8, w3.InterfaceC0936d r9) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: L.h.a(java.lang.Object, w3.d):java.lang.Object");
    }

    public DialogC0469f b() {
        C0467d c0467d = (C0467d) this.f1522d;
        DialogC0469f dialogC0469f = new DialogC0469f((ContextThemeWrapper) c0467d.f6289a, this.f1521c);
        View view = c0467d.f6293e;
        C0468e c0468e = dialogC0469f.h;
        if (view != null) {
            c0468e.f6309C = view;
        } else {
            CharSequence charSequence = c0467d.f6292d;
            if (charSequence != null) {
                c0468e.f6322e = charSequence;
                TextView textView = c0468e.f6307A;
                if (textView != null) {
                    textView.setText(charSequence);
                }
            }
            Drawable drawable = c0467d.f6291c;
            if (drawable != null) {
                c0468e.f6339y = drawable;
                c0468e.f6338x = 0;
                ImageView imageView = c0468e.f6340z;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    c0468e.f6340z.setImageDrawable(drawable);
                }
            }
        }
        CharSequence charSequence2 = c0467d.f6294f;
        if (charSequence2 != null) {
            c0468e.f6323f = charSequence2;
            TextView textView2 = c0468e.f6308B;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = c0467d.g;
        if (charSequence3 != null) {
            c0468e.c(-1, (String) charSequence3, c0467d.h);
        }
        CharSequence charSequence4 = c0467d.f6295i;
        if (charSequence4 != null) {
            c0468e.c(-2, (String) charSequence4, c0467d.f6296j);
        }
        CharSequence charSequence5 = c0467d.f6297k;
        if (charSequence5 != null) {
            c0468e.c(-3, (String) charSequence5, c0467d.f6298l);
        }
        if (c0467d.f6301p != null || c0467d.f6302q != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) c0467d.f6290b.inflate(c0468e.f6313G, (ViewGroup) null);
            int i5 = c0467d.f6305t ? c0468e.f6314H : c0468e.I;
            ListAdapter c0454h = c0467d.f6302q;
            if (c0454h == null) {
                c0454h = new C0454h(c0467d.f6289a, i5, R.id.text1, c0467d.f6301p);
            }
            c0468e.f6310D = c0454h;
            c0468e.f6311E = c0467d.f6306u;
            if (c0467d.f6303r != null) {
                alertController$RecycleListView.setOnItemClickListener(new C0466c(c0467d, c0468e));
            }
            if (c0467d.f6305t) {
                alertController$RecycleListView.setChoiceMode(1);
            }
            c0468e.g = alertController$RecycleListView;
        }
        View view2 = c0467d.f6304s;
        if (view2 != null) {
            c0468e.h = view2;
            c0468e.f6324i = 0;
            c0468e.f6325j = false;
        }
        dialogC0469f.setCancelable(c0467d.f6299m);
        if (c0467d.f6299m) {
            dialogC0469f.setCanceledOnTouchOutside(true);
        }
        dialogC0469f.setOnCancelListener(c0467d.n);
        dialogC0469f.setOnDismissListener(null);
        DialogInterface.OnKeyListener onKeyListener = c0467d.f6300o;
        if (onKeyListener != null) {
            dialogC0469f.setOnKeyListener(onKeyListener);
        }
        return dialogC0469f;
    }

    public void c(String str, DialogInterface.OnClickListener onClickListener) {
        C0467d c0467d = (C0467d) this.f1522d;
        c0467d.f6295i = str;
        c0467d.f6296j = onClickListener;
    }

    @Override // P.u
    public boolean d(View view) {
        ((BottomSheetBehavior) this.f1522d).B(this.f1521c);
        return true;
    }

    public void e(String str, DialogInterface.OnClickListener onClickListener) {
        C0467d c0467d = (C0467d) this.f1522d;
        c0467d.g = str;
        c0467d.h = onClickListener;
    }

    public void f() {
        b().show();
    }

    @Override // retrofit2.Callback
    public void onFailure(Call call, Throwable th) {
        Log.e("UnifiedInbox", "Failed to mark message as read", th);
    }

    @Override // retrofit2.Callback
    public void onResponse(Call call, Response response) {
        if (response.isSuccessful()) {
            UnifiedInboxActivity unifiedInboxActivity = (UnifiedInboxActivity) this.f1522d;
            Iterator it = unifiedInboxActivity.f5835i.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Message message = (Message) it.next();
                if (message.getId() == this.f1521c) {
                    message.setRead(true);
                    break;
                }
            }
            C0524o c0524o = unifiedInboxActivity.g;
            if (c0524o != null) {
                c0524o.notifyDataSetChanged();
            }
            unifiedInboxActivity.u();
        }
    }

    public h(int i5) {
        this.f1522d = new int[i5];
    }

    public h(Context context) {
        this(context, DialogC0469f.g(context, 0));
    }

    public h(Context context, int i5) {
        this.f1522d = new C0467d(new ContextThemeWrapper(context, DialogC0469f.g(context, i5)));
        this.f1521c = i5;
    }

    public h(int i5, i[] iVarArr) {
        this.f1521c = i5;
        this.f1522d = iVarArr;
    }
}
