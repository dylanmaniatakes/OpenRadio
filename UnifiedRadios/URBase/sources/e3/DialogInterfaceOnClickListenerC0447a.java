package e3;

import android.content.DialogInterface;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import com.unified.ur1.OnTheAir.UnifiedOnTheAirActivity;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;
import f.AbstractActivityC0472i;
import l3.k;

/* renamed from: e3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class DialogInterfaceOnClickListenerC0447a implements DialogInterface.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6197c = 0;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AbstractActivityC0472i f6198d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Object f6199e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ Object f6200f;
    public final /* synthetic */ View g;
    public final /* synthetic */ Object h;

    public /* synthetic */ DialogInterfaceOnClickListenerC0447a(UnifiedOnTheAirActivity unifiedOnTheAirActivity, String[] strArr, Spinner spinner, String[] strArr2, Spinner spinner2) {
        this.f6198d = unifiedOnTheAirActivity;
        this.f6199e = strArr;
        this.g = spinner;
        this.f6200f = strArr2;
        this.h = spinner2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i5) {
        Object obj = this.h;
        View view = this.g;
        Object obj2 = this.f6200f;
        Object obj3 = this.f6199e;
        AbstractActivityC0472i abstractActivityC0472i = this.f6198d;
        switch (this.f6197c) {
            case 0:
                int i6 = UnifiedOnTheAirActivity.f5557u;
                UnifiedOnTheAirActivity unifiedOnTheAirActivity = (UnifiedOnTheAirActivity) abstractActivityC0472i;
                unifiedOnTheAirActivity.getClass();
                unifiedOnTheAirActivity.f5572t = ((String[]) obj3)[((Spinner) view).getSelectedItemPosition()];
                unifiedOnTheAirActivity.f5571s = ((String[]) obj2)[((Spinner) obj).getSelectedItemPosition()];
                unifiedOnTheAirActivity.k();
                unifiedOnTheAirActivity.updateMapMarkers();
                unifiedOnTheAirActivity.s();
                unifiedOnTheAirActivity.q();
                Toast.makeText(unifiedOnTheAirActivity, "Filters applied", 0).show();
                break;
            default:
                int i7 = RadioTeamsManagerActivity.f6026l;
                RadioTeamsManagerActivity radioTeamsManagerActivity = (RadioTeamsManagerActivity) abstractActivityC0472i;
                radioTeamsManagerActivity.getClass();
                String strTrim = ((EditText) obj3).getText().toString().trim();
                String strTrim2 = ((EditText) obj2).getText().toString().trim();
                boolean zIsChecked = ((CheckBox) view).isChecked();
                Log.d("RadioTeamsManager", "Saving edited team: " + strTrim + " / " + strTrim2 + " / " + zIsChecked);
                if (!strTrim.isEmpty() && !strTrim2.isEmpty()) {
                    k kVar = (k) obj;
                    kVar.f8423a = strTrim;
                    kVar.f8424b = strTrim2;
                    kVar.f8425c = zIsChecked;
                    radioTeamsManagerActivity.m();
                    radioTeamsManagerActivity.f6031i.notifyDataSetChanged();
                    Toast.makeText(radioTeamsManagerActivity, "Team updated", 0).show();
                    break;
                } else {
                    Log.w("RadioTeamsManager", "Edit cancelled - empty fields");
                    break;
                }
                break;
        }
    }

    public /* synthetic */ DialogInterfaceOnClickListenerC0447a(RadioTeamsManagerActivity radioTeamsManagerActivity, EditText editText, EditText editText2, CheckBox checkBox, k kVar) {
        this.f6198d = radioTeamsManagerActivity;
        this.f6199e = editText;
        this.f6200f = editText2;
        this.g = checkBox;
        this.h = kVar;
    }
}
