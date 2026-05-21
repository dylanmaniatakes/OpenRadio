package f3;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.unified.ur1.R;
import f.C0467d;
import f.DialogC0469f;
import java.util.ArrayList;

/* renamed from: f3.N, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class ViewOnClickListenerC0503N implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6619c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ f0 f6620d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ m0 f6621e;

    public /* synthetic */ ViewOnClickListenerC0503N(f0 f0Var, m0 m0Var, int i5) {
        this.f6619c = i5;
        this.f6620d = f0Var;
        this.f6621e = m0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws NumberFormatException {
        switch (this.f6619c) {
            case 0:
                f0 f0Var = this.f6620d;
                Context context = f0Var.f6710b;
                L.h hVar = new L.h(context, R.style.ThemeOverlay_MaterialComponents_Dialog_Alert);
                View viewInflate = LayoutInflater.from(context).inflate(R.layout.vote_dialog, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.dialogCallsign);
                TextView textView2 = (TextView) viewInflate.findViewById(R.id.dialogScore);
                TextView textView3 = (TextView) viewInflate.findViewById(R.id.notesSection);
                EditText editText = (EditText) viewInflate.findViewById(R.id.noteInput);
                Button button = (Button) viewInflate.findViewById(R.id.upvoteButton);
                Button button2 = (Button) viewInflate.findViewById(R.id.downvoteButton);
                Button button3 = (Button) viewInflate.findViewById(R.id.addNoteButton);
                Button button4 = (Button) viewInflate.findViewById(R.id.requestUpdateButton);
                Button button5 = (Button) viewInflate.findViewById(R.id.toggleOfflineButton);
                Button button6 = (Button) viewInflate.findViewById(R.id.closeButton);
                Button button7 = (Button) viewInflate.findViewById(R.id.programButton);
                CardView cardView = (CardView) viewInflate.findViewById(R.id.repeateractions);
                String str = Build.DISPLAY;
                if (str.contains("H18_6762") || str.contains("H18V") || str.contains("H18_V1.1V")) {
                    cardView.setVisibility(0);
                } else {
                    cardView.setVisibility(8);
                }
                m0 m0Var = this.f6621e;
                textView.setText(m0Var.f6745a);
                textView2.setText("Score: " + m0Var.f6750f);
                String str2 = m0Var.f6753k;
                textView3.setText((str2 == null || "null".equals(str2)) ? "No notes available" : m0Var.f6753k);
                button5.setText(m0Var.f6752j ? "Report Repeater Back Online" : "Report Repeater Offline");
                C0467d c0467d = (C0467d) hVar.f1522d;
                c0467d.f6304s = viewInflate;
                c0467d.f6299m = true;
                DialogC0469f dialogC0469fB = hVar.b();
                button.setOnClickListener(new W(f0Var, m0Var, editText, dialogC0469fB, 0));
                button2.setOnClickListener(new W(f0Var, m0Var, editText, dialogC0469fB, 1));
                button3.setOnClickListener(new W(f0Var, m0Var, editText, dialogC0469fB, 2));
                button4.setOnClickListener(new ViewOnClickListenerC0508b0(f0Var, m0Var, dialogC0469fB, 0));
                int i5 = 1;
                button5.setOnClickListener(new ViewOnClickListenerC0508b0(f0Var, m0Var, dialogC0469fB, i5));
                button7.setOnClickListener(new ViewOnClickListenerC0503N(f0Var, m0Var, i5));
                button6.setOnClickListener(new com.google.android.material.datepicker.l(i5, dialogC0469fB));
                dialogC0469fB.show();
                break;
            default:
                final f0 f0Var2 = this.f6620d;
                f0Var2.getClass();
                Log.d("Unified - RepeaterDir", "--------------programRepeater Called--------------");
                L.h hVar2 = new L.h(f0Var2.f6710b, R.style.Base_Theme_Material3_Dark_Dialog);
                final m0 m0Var2 = this.f6621e;
                if (m0Var2.f6748d.contains("DMR")) {
                    ArrayList arrayList = new ArrayList();
                    final ArrayList arrayList2 = new ArrayList();
                    final ArrayList arrayList3 = new ArrayList();
                    String strTrim = m0Var2.g;
                    if (strTrim != null && !strTrim.isEmpty()) {
                        if (strTrim.startsWith("TS1:")) {
                            strTrim = strTrim.substring(4).trim();
                        }
                        for (String str3 : strTrim.split(",")) {
                            String strTrim2 = str3.trim();
                            try {
                                int i6 = Integer.parseInt(strTrim2);
                                arrayList.add("TS1: TG" + i6);
                                arrayList2.add(Integer.valueOf(i6));
                                arrayList3.add(1);
                                Log.d("Unified - RepeaterDir", "Parsed TS1 TG: " + i6);
                            } catch (NumberFormatException e5) {
                                Log.e("Unified - RepeaterDir", "Error parsing TS1 talkgroup number: " + strTrim2, e5);
                            }
                        }
                    }
                    String strTrim3 = m0Var2.h;
                    if (strTrim3 != null && !strTrim3.isEmpty()) {
                        if (strTrim3.startsWith("TS2:")) {
                            strTrim3 = strTrim3.substring(4).trim();
                        }
                        for (String str4 : strTrim3.split(",")) {
                            String strTrim4 = str4.trim();
                            try {
                                int i7 = Integer.parseInt(strTrim4);
                                arrayList.add("TS2: TG" + i7);
                                arrayList2.add(Integer.valueOf(i7));
                                arrayList3.add(2);
                                Log.d("Unified - RepeaterDir", "Parsed TS2 TG: " + i7);
                            } catch (NumberFormatException e6) {
                                Log.e("Unified - RepeaterDir", "Error parsing TS2 talkgroup number: " + strTrim4, e6);
                            }
                        }
                    }
                    if (arrayList.isEmpty()) {
                        Log.d("Unified - RepeaterDir", "No valid talkgroups found, proceeding with default programming");
                        f0Var2.b(m0Var2, hVar2);
                        break;
                    } else {
                        Log.d("Unified - RepeaterDir", "Found " + arrayList.size() + " total talkgroups");
                        StringBuilder sb = new StringBuilder("Select Talkgroup for ");
                        sb.append(m0Var2.f6745a);
                        String string = sb.toString();
                        C0467d c0467d2 = (C0467d) hVar2.f1522d;
                        c0467d2.f6292d = string;
                        CharSequence[] charSequenceArr = (CharSequence[]) arrayList.toArray(new String[0]);
                        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() { // from class: f3.P
                            @Override // android.content.DialogInterface.OnClickListener
                            public final void onClick(DialogInterface dialogInterface, int i8) {
                                f0 f0Var3 = f0Var2;
                                f0Var3.getClass();
                                Integer num = (Integer) arrayList2.get(i8);
                                int iIntValue = num.intValue();
                                Integer num2 = (Integer) arrayList3.get(i8);
                                int iIntValue2 = num2.intValue();
                                Context context2 = f0Var3.f6710b;
                                h4.c.w0(context2, iIntValue);
                                int i9 = iIntValue2 - 1;
                                h4.c.Z(context2, i9);
                                h4.c.k0(context2, i9);
                                Log.d("Unified - RepeaterDir", String.format("Selected TG: %d, TS: %d", num, num2));
                                f0Var3.b(m0Var2, new L.h(context2, R.style.Base_Theme_Material3_Dark_Dialog));
                            }
                        };
                        c0467d2.f6301p = charSequenceArr;
                        c0467d2.f6303r = onClickListener;
                        hVar2.c("Cancel", null);
                        hVar2.f();
                        break;
                    }
                } else {
                    Log.d("Unified - RepeaterDir", "Non-DMR or no TG info available, proceeding with normal programming");
                    f0Var2.b(m0Var2, hVar2);
                    break;
                }
                break;
        }
    }
}
