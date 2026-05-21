package g3;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import com.google.android.material.textfield.TextInputLayout;
import com.unified.ur1.R;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.chat.NewMessageActivity;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.primary.OptionsActivity;

/* loaded from: classes.dex */
public final class f implements TextWatcher {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6966c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f6967d;

    public /* synthetic */ f(int i5, Object obj) {
        this.f6966c = i5;
        this.f6967d = obj;
    }

    private final void a(Editable editable) {
    }

    private final void b(Editable editable) {
    }

    private final void c(Editable editable) {
    }

    private final void d(Editable editable) {
    }

    private final void e(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void f(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void g(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void h(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void i(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void j(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void k(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void l(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void m(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void n(int i5, int i6, int i7, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) throws Resources.NotFoundException {
        Object obj = this.f6967d;
        switch (this.f6966c) {
            case 0:
            case 1:
            case 2:
            case 3:
                break;
            case 4:
                String upperCase = editable.toString().trim().toUpperCase();
                int i5 = OptionsActivity.f5981H;
                OptionsActivity optionsActivity = (OptionsActivity) obj;
                optionsActivity.getClass();
                try {
                    SharedPreferences.Editor editorEdit = optionsActivity.getSharedPreferences("radioteams_settings", 0).edit();
                    editorEdit.putString("KEY_RADIOTEAMS_ID", upperCase);
                    editorEdit.apply();
                    Log.d("Unified - Settings", "RadioTeams ID set to: " + upperCase);
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Error setting RadioTeams ID", e5);
                    return;
                }
            case 5:
                String strTrim = editable.toString().trim();
                o3.x xVar = (o3.x) obj;
                Runnable runnable = xVar.f8999r;
                if (runnable != null) {
                    xVar.f8998q.removeCallbacks(runnable);
                }
                k kVar = new k(this, 26, strTrim);
                xVar.f8999r = kVar;
                xVar.f8998q.postDelayed(kVar, 300L);
                break;
            default:
                TextInputLayout textInputLayout = (TextInputLayout) obj;
                textInputLayout.u(!textInputLayout.f5417B0, false);
                if (textInputLayout.f5459m) {
                    textInputLayout.n(editable);
                }
                if (textInputLayout.f5474u) {
                    textInputLayout.v(editable);
                    break;
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        int i8 = this.f6966c;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        switch (this.f6966c) {
            case 0:
                boolean z4 = charSequence.toString().trim().length() > 0;
                ChatActivity chatActivity = (ChatActivity) this.f6967d;
                chatActivity.h.setAlpha(z4 ? 1.0f : 0.5f);
                chatActivity.h.setEnabled(z4);
                if (z4 && chatActivity.f5732G) {
                    chatActivity.q();
                }
                if (!z4) {
                    if (chatActivity.f5750t) {
                        chatActivity.z("0");
                        chatActivity.f5750t = false;
                    }
                    chatActivity.f5749s.removeCallbacks(chatActivity.f5726A);
                    break;
                } else {
                    if (!chatActivity.f5750t) {
                        chatActivity.z("1");
                        chatActivity.f5750t = true;
                    }
                    chatActivity.f5749s.removeCallbacks(chatActivity.f5726A);
                    C0.e eVar = new C0.e(15, this);
                    chatActivity.f5726A = eVar;
                    chatActivity.f5749s.postDelayed(eVar, 3000L);
                    break;
                }
                break;
            case 1:
                String strTrim = charSequence.toString().trim();
                int length = strTrim.length();
                NewMessageActivity newMessageActivity = (NewMessageActivity) this.f6967d;
                if (length < 2) {
                    NewMessageActivity.j(newMessageActivity, false);
                    newMessageActivity.l();
                    break;
                } else {
                    NewMessageActivity.j(newMessageActivity, true);
                    if (newMessageActivity.f5770r != null) {
                        newMessageActivity.f5770r.searchUsersRaw(strTrim, newMessageActivity.getSharedPreferences("app_settings", 0).getString("auth_code_1", null)).enqueue(new Z2.c(18, newMessageActivity));
                        break;
                    }
                }
                break;
            case 2:
                ComposeMessageActivity composeMessageActivity = (ComposeMessageActivity) this.f6967d;
                Runnable runnable = composeMessageActivity.f5807t;
                if (runnable != null) {
                    composeMessageActivity.f5806s.removeCallbacks(runnable);
                }
                String strTrim2 = charSequence.toString().trim();
                if (strTrim2.length() < 3) {
                    if (strTrim2.length() <= 0) {
                        composeMessageActivity.f5797i.setVisibility(8);
                        composeMessageActivity.f5798j.setVisibility(8);
                        composeMessageActivity.n();
                        composeMessageActivity.f5809v = false;
                        break;
                    } else {
                        composeMessageActivity.r(R.drawable.ic_info, R.color.gray_600, "Type at least 3 characters to search");
                        composeMessageActivity.n();
                        composeMessageActivity.f5809v = false;
                        break;
                    }
                } else {
                    composeMessageActivity.r(R.drawable.ic_search, R.color.manual_entry_color, "Searching...");
                    k kVar = new k(this, 3, strTrim2);
                    composeMessageActivity.f5807t = kVar;
                    composeMessageActivity.f5806s.postDelayed(kVar, 500L);
                    break;
                }
            case 3:
                SearchView searchView = (SearchView) this.f6967d;
                Editable text = searchView.f3429r.getText();
                searchView.f3421a0 = text;
                boolean zIsEmpty = TextUtils.isEmpty(text);
                searchView.x(!zIsEmpty);
                int i8 = 8;
                if (searchView.f3420W && !searchView.f3413P && zIsEmpty) {
                    searchView.f3434w.setVisibility(8);
                    i8 = 0;
                }
                searchView.f3436y.setVisibility(i8);
                searchView.t();
                searchView.w();
                charSequence.toString();
                searchView.getClass();
                break;
        }
    }
}
