package l3;

import android.widget.Toast;
import com.unified.ur1.radioteams.RadioTeamsManagerActivity;

/* renamed from: l3.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC0751i implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8419j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ RadioTeamsManagerActivity f8420k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Exception f8421l;

    public /* synthetic */ RunnableC0751i(RadioTeamsManagerActivity radioTeamsManagerActivity, Exception exc, int i5) {
        this.f8419j = i5;
        this.f8420k = radioTeamsManagerActivity;
        this.f8421l = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RadioTeamsManagerActivity radioTeamsManagerActivity = this.f8420k;
        Exception exc = this.f8421l;
        switch (this.f8419j) {
            case 0:
                int i5 = RadioTeamsManagerActivity.f6026l;
                radioTeamsManagerActivity.getClass();
                Toast.makeText(radioTeamsManagerActivity, "Error removing team: " + exc.getMessage(), 1).show();
                break;
            default:
                int i6 = RadioTeamsManagerActivity.f6026l;
                Toast.makeText(radioTeamsManagerActivity, "Error discovering teams: " + exc.getMessage(), 1).show();
                break;
        }
    }
}
