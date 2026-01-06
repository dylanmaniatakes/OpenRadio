package J0;

import C0.t;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* loaded from: classes.dex */
public final class a extends f {

    /* renamed from: f, reason: collision with root package name */
    public final d f680f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, L0.i iVar, int i5) {
        super(context, iVar);
        this.g = i5;
        F3.i.f(iVar, "taskExecutor");
        this.f680f = new d(0, this);
    }

    @Override // J0.f
    public final Object a() {
        switch (this.g) {
            case 0:
                Intent intentRegisterReceiver = this.f687b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver == null) {
                    t.d().b(b.f681a, "getInitialState - null intent received");
                    return Boolean.FALSE;
                }
                int intExtra = intentRegisterReceiver.getIntExtra("status", -1);
                return Boolean.valueOf(intExtra == 2 || intExtra == 5);
            case 1:
                Intent intentRegisterReceiver2 = this.f687b.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (intentRegisterReceiver2 == null) {
                    t.d().b(c.f682a, "getInitialState - null intent received");
                    return Boolean.FALSE;
                }
                int intExtra2 = intentRegisterReceiver2.getIntExtra("status", -1);
                float intExtra3 = intentRegisterReceiver2.getIntExtra("level", -1) / intentRegisterReceiver2.getIntExtra("scale", -1);
                boolean z4 = true;
                if (intExtra2 != 1 && intExtra3 <= 0.15f) {
                    z4 = false;
                }
                return Boolean.valueOf(z4);
            default:
                Intent intentRegisterReceiver3 = this.f687b.registerReceiver(null, e());
                boolean z5 = true;
                if (intentRegisterReceiver3 != null && intentRegisterReceiver3.getAction() != null) {
                    String action = intentRegisterReceiver3.getAction();
                    if (action == null) {
                        z5 = false;
                    } else {
                        int iHashCode = action.hashCode();
                        if (iHashCode == -1181163412) {
                            action.equals("android.intent.action.DEVICE_STORAGE_LOW");
                        } else if (iHashCode != -730838620 || !action.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                        }
                        z5 = false;
                    }
                }
                return Boolean.valueOf(z5);
        }
    }

    @Override // J0.f
    public final void c() {
        t.d().a(e.f685a, getClass().getSimpleName().concat(": registering receiver"));
        this.f687b.registerReceiver(this.f680f, e());
    }

    @Override // J0.f
    public final void d() {
        t.d().a(e.f685a, getClass().getSimpleName().concat(": unregistering receiver"));
        this.f687b.unregisterReceiver(this.f680f);
    }

    public final IntentFilter e() {
        switch (this.g) {
            case 0:
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.os.action.CHARGING");
                intentFilter.addAction("android.os.action.DISCHARGING");
                return intentFilter;
            case 1:
                IntentFilter intentFilter2 = new IntentFilter();
                intentFilter2.addAction("android.intent.action.BATTERY_OKAY");
                intentFilter2.addAction("android.intent.action.BATTERY_LOW");
                return intentFilter2;
            default:
                IntentFilter intentFilter3 = new IntentFilter();
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_OK");
                intentFilter3.addAction("android.intent.action.DEVICE_STORAGE_LOW");
                return intentFilter3;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void f(Intent intent) {
        switch (this.g) {
            case 0:
                F3.i.f(intent, "intent");
                String action = intent.getAction();
                if (action != null) {
                    t.d().a(b.f681a, "Received ".concat(action));
                    switch (action.hashCode()) {
                        case -1886648615:
                            if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                                b(Boolean.FALSE);
                                break;
                            }
                            break;
                        case -54942926:
                            if (action.equals("android.os.action.DISCHARGING")) {
                                b(Boolean.FALSE);
                                break;
                            }
                            break;
                        case 948344062:
                            if (action.equals("android.os.action.CHARGING")) {
                                b(Boolean.TRUE);
                                break;
                            }
                            break;
                        case 1019184907:
                            if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                                b(Boolean.TRUE);
                                break;
                            }
                            break;
                    }
                }
                break;
            case 1:
                F3.i.f(intent, "intent");
                if (intent.getAction() != null) {
                    t.d().a(c.f682a, "Received " + intent.getAction());
                    String action2 = intent.getAction();
                    if (action2 != null) {
                        int iHashCode = action2.hashCode();
                        if (iHashCode == -1980154005) {
                            if (action2.equals("android.intent.action.BATTERY_OKAY")) {
                                b(Boolean.TRUE);
                                break;
                            }
                        } else if (iHashCode == 490310653 && action2.equals("android.intent.action.BATTERY_LOW")) {
                            b(Boolean.FALSE);
                            break;
                        }
                    }
                }
                break;
            default:
                F3.i.f(intent, "intent");
                if (intent.getAction() != null) {
                    t.d().a(k.f695a, "Received " + intent.getAction());
                    String action3 = intent.getAction();
                    if (action3 != null) {
                        int iHashCode2 = action3.hashCode();
                        if (iHashCode2 == -1181163412) {
                            if (action3.equals("android.intent.action.DEVICE_STORAGE_LOW")) {
                                b(Boolean.FALSE);
                                break;
                            }
                        } else if (iHashCode2 == -730838620 && action3.equals("android.intent.action.DEVICE_STORAGE_OK")) {
                            b(Boolean.TRUE);
                            break;
                        }
                    }
                }
                break;
        }
    }
}
