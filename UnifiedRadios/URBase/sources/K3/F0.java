package k3;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;
import com.unified.ur1.primary.OptionsActivity;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import f3.DialogInterfaceOnClickListenerC0516g;
import f3.DialogInterfaceOnClickListenerC0520k;

/* loaded from: classes.dex */
public final /* synthetic */ class F0 implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7958c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OptionsActivity f7959d;

    public /* synthetic */ F0(OptionsActivity optionsActivity, int i5) {
        this.f7958c = i5;
        this.f7959d = optionsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i5 = 2;
        OptionsActivity optionsActivity = this.f7959d;
        switch (this.f7958c) {
            case 0:
                int i6 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                Intent intent = new Intent(optionsActivity, (Class<?>) RadioTeamsManagerActivity.class);
                intent.putExtra("auto_discover", true);
                optionsActivity.getSharedPreferences("RadioTeamsPrefs", 0);
                intent.putExtra("default_callsign", h4.c.h(optionsActivity));
                optionsActivity.startActivity(intent);
                break;
            case 1:
                int i7 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    final AlertDialog alertDialogCreate = new AlertDialog.Builder(optionsActivity, R.style.Base_Theme_Material3_Dark_Dialog).setTitle("Exit Application").setMessage("Are you sure you want to close the application? Any unsaved changes will be lost.").setIcon(R.drawable.ic_group).setPositiveButton("Exit", new DialogInterfaceOnClickListenerC0520k(4, optionsActivity)).setNegativeButton("Stay", new DialogInterfaceOnClickListenerC0516g(11)).setCancelable(true).create();
                    alertDialogCreate.setOnShowListener(new DialogInterface.OnShowListener() { // from class: k3.Q0
                        @Override // android.content.DialogInterface.OnShowListener
                        public final void onShow(DialogInterface dialogInterface) {
                            int i8 = OptionsActivity.f5981H;
                            AlertDialog alertDialog = alertDialogCreate;
                            Button button = alertDialog.getButton(-1);
                            Button button2 = alertDialog.getButton(-2);
                            if (button != null) {
                                button.setTextColor(-16777216);
                            }
                            if (button2 != null) {
                                button2.setTextColor(-16777216);
                            }
                            TextView textView = (TextView) alertDialog.findViewById(android.R.id.title);
                            TextView textView2 = (TextView) alertDialog.findViewById(android.R.id.message);
                            if (textView != null) {
                                textView.setTextColor(-16777216);
                            }
                            if (textView2 != null) {
                                textView2.setTextColor(-16777216);
                            }
                        }
                    });
                    alertDialogCreate.show();
                    break;
                } catch (Exception e5) {
                    Log.e("Unified - Settings", "Failed to display exit confirmation dialog", e5);
                    optionsActivity.N();
                    return;
                }
            case 2:
                int i8 = OptionsActivity.f5981H;
                optionsActivity.getClass();
                try {
                    optionsActivity.sendBroadcast(new Intent("CHECK_UPDATE"));
                    Log.d("LocalBroadcast", "Local update check broadcast sent");
                    Intent intent2 = new Intent(optionsActivity, (Class<?>) LaunchActivity.class);
                    intent2.addFlags(603979776);
                    optionsActivity.startActivity(intent2);
                    optionsActivity.finish();
                    break;
                } catch (Exception e6) {
                    Log.e("Unified - Settings", "Error in showCheckUpdateDialog", e6);
                    optionsActivity.finish();
                    return;
                }
            case 3:
                int i9 = optionsActivity.f6001r;
                if (i9 < 10) {
                    optionsActivity.f6001r = i9 + 1;
                    optionsActivity.U();
                    break;
                }
                break;
            case 4:
                int i10 = optionsActivity.f6001r;
                if (i10 > 0) {
                    optionsActivity.f6001r = i10 - 1;
                    optionsActivity.U();
                    break;
                }
                break;
            case 5:
                int i11 = optionsActivity.f5997m;
                if (i11 < 10) {
                    int i12 = i11 + 1;
                    optionsActivity.f5997m = i12;
                    TextView textView = optionsActivity.f5996l;
                    if (textView != null) {
                        textView.setText(String.valueOf(i12));
                    }
                    optionsActivity.f5997m = i12;
                    if (optionsActivity.s() || optionsActivity.f6002s == null) {
                        Log.w("Unified - Settings", "Cannot set mic gain - ROIP is connected or DMR Business not available");
                    } else {
                        optionsActivity.B("SetMicGainLevel", new I0(optionsActivity, i12, i5));
                    }
                    optionsActivity.S(optionsActivity.f5997m);
                    optionsActivity.P();
                    int i13 = optionsActivity.f5997m;
                    if (!optionsActivity.s() && optionsActivity.f6002s != null) {
                        optionsActivity.B("SetMicGainLevel", new I0(optionsActivity, i13, i5));
                        break;
                    } else {
                        Log.w("Unified - Settings", "Cannot set mic gain - ROIP is connected or DMR Business not available");
                        break;
                    }
                }
                break;
            default:
                int i14 = optionsActivity.f5997m;
                if (i14 > 0) {
                    int i15 = i14 - 1;
                    optionsActivity.f5997m = i15;
                    TextView textView2 = optionsActivity.f5996l;
                    if (textView2 != null) {
                        textView2.setText(String.valueOf(i15));
                    }
                    optionsActivity.f5997m = i15;
                    if (optionsActivity.s() || optionsActivity.f6002s == null) {
                        Log.w("Unified - Settings", "Cannot set mic gain - ROIP is connected or DMR Business not available");
                    } else {
                        optionsActivity.B("SetMicGainLevel", new I0(optionsActivity, i15, i5));
                    }
                    optionsActivity.S(optionsActivity.f5997m);
                    optionsActivity.P();
                    int i16 = optionsActivity.f5997m;
                    if (!optionsActivity.s() && optionsActivity.f6002s != null) {
                        optionsActivity.B("SetMicGainLevel", new I0(optionsActivity, i16, i5));
                        break;
                    } else {
                        Log.w("Unified - Settings", "Cannot set mic gain - ROIP is connected or DMR Business not available");
                        break;
                    }
                }
                break;
        }
    }
}
