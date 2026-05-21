package B;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public final Context f64a;

    /* renamed from: e, reason: collision with root package name */
    public CharSequence f68e;

    /* renamed from: f, reason: collision with root package name */
    public CharSequence f69f;
    public PendingIntent g;
    public Bitmap h;

    /* renamed from: i, reason: collision with root package name */
    public int f70i;

    /* renamed from: j, reason: collision with root package name */
    public int f71j;

    /* renamed from: l, reason: collision with root package name */
    public u f73l;
    public String n;

    /* renamed from: o, reason: collision with root package name */
    public Bundle f75o;

    /* renamed from: r, reason: collision with root package name */
    public String f78r;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f81u;

    /* renamed from: v, reason: collision with root package name */
    public final Notification f82v;

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f83w;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f65b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f66c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f67d = new ArrayList();

    /* renamed from: k, reason: collision with root package name */
    public boolean f72k = true;

    /* renamed from: m, reason: collision with root package name */
    public boolean f74m = false;

    /* renamed from: p, reason: collision with root package name */
    public int f76p = 0;

    /* renamed from: q, reason: collision with root package name */
    public int f77q = 0;

    /* renamed from: s, reason: collision with root package name */
    public int f79s = 0;

    /* renamed from: t, reason: collision with root package name */
    public int f80t = 0;

    public t(Context context, String str) {
        Notification notification = new Notification();
        this.f82v = notification;
        this.f64a = context;
        this.f78r = str;
        notification.when = System.currentTimeMillis();
        notification.audioStreamType = -1;
        this.f71j = 0;
        this.f83w = new ArrayList();
        this.f81u = true;
    }

    public static CharSequence b(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public final Notification a() {
        Bundle bundle;
        int i5;
        int i6;
        int i7;
        L0.i iVar = new L0.i();
        new ArrayList();
        iVar.f1550f = new Bundle();
        iVar.f1549e = this;
        iVar.f1547c = this.f64a;
        Notification.Builder builder = new Notification.Builder(this.f64a, this.f78r);
        iVar.f1548d = builder;
        Notification notification = this.f82v;
        builder.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, null).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(this.f68e).setContentText(this.f69f).setContentInfo(null).setContentIntent(this.g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(null, (notification.flags & 128) != 0).setLargeIcon(this.h).setNumber(this.f70i).setProgress(0, 0, false);
        builder.setSubText(null).setUsesChronometer(false).setPriority(this.f71j);
        Iterator it = this.f65b.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (nVar.f55b == null && (i7 = nVar.f58e) != 0) {
                nVar.f55b = IconCompat.a(i7);
            }
            IconCompat iconCompat = nVar.f55b;
            Notification.Action.Builder builder2 = new Notification.Action.Builder(iconCompat != null ? F.d.c(iconCompat, null) : null, nVar.f59f, nVar.g);
            Bundle bundle2 = nVar.f54a;
            Bundle bundle3 = bundle2 != null ? new Bundle(bundle2) : new Bundle();
            boolean z4 = nVar.f56c;
            bundle3.putBoolean("android.support.allowGeneratedReplies", z4);
            int i8 = Build.VERSION.SDK_INT;
            builder2.setAllowGeneratedReplies(z4);
            bundle3.putInt("android.support.action.semanticAction", 0);
            builder2.setSemanticAction(0);
            if (i8 >= 29) {
                builder2.setContextual(false);
            }
            if (i8 >= 31) {
                builder2.setAuthenticationRequired(false);
            }
            bundle3.putBoolean("android.support.action.showsUserInterface", nVar.f57d);
            builder2.addExtras(bundle3);
            ((Notification.Builder) iVar.f1548d).addAction(builder2.build());
        }
        Bundle bundle4 = this.f75o;
        if (bundle4 != null) {
            ((Bundle) iVar.f1550f).putAll(bundle4);
        }
        ((Notification.Builder) iVar.f1548d).setShowWhen(this.f72k);
        ((Notification.Builder) iVar.f1548d).setLocalOnly(this.f74m).setGroup(null).setGroupSummary(false).setSortKey(null);
        ((Notification.Builder) iVar.f1548d).setCategory(this.n).setColor(this.f76p).setVisibility(this.f77q).setPublicVersion(null).setSound(notification.sound, notification.audioAttributes);
        ArrayList arrayList = this.f83w;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Notification.Builder) iVar.f1548d).addPerson((String) it2.next());
            }
        }
        ArrayList arrayList2 = this.f67d;
        if (arrayList2.size() > 0) {
            if (this.f75o == null) {
                this.f75o = new Bundle();
            }
            Bundle bundle5 = this.f75o.getBundle("android.car.EXTENSIONS");
            if (bundle5 == null) {
                bundle5 = new Bundle();
            }
            Bundle bundle6 = new Bundle(bundle5);
            Bundle bundle7 = new Bundle();
            for (int i9 = 0; i9 < arrayList2.size(); i9++) {
                String string = Integer.toString(i9);
                n nVar2 = (n) arrayList2.get(i9);
                Bundle bundle8 = new Bundle();
                if (nVar2.f55b == null && (i6 = nVar2.f58e) != 0) {
                    nVar2.f55b = IconCompat.a(i6);
                }
                IconCompat iconCompat2 = nVar2.f55b;
                bundle8.putInt("icon", iconCompat2 != null ? iconCompat2.b() : 0);
                bundle8.putCharSequence("title", nVar2.f59f);
                bundle8.putParcelable("actionIntent", nVar2.g);
                Bundle bundle9 = nVar2.f54a;
                Bundle bundle10 = bundle9 != null ? new Bundle(bundle9) : new Bundle();
                bundle10.putBoolean("android.support.allowGeneratedReplies", nVar2.f56c);
                bundle8.putBundle("extras", bundle10);
                bundle8.putParcelableArray("remoteInputs", null);
                bundle8.putBoolean("showsUserInterface", nVar2.f57d);
                bundle8.putInt("semanticAction", 0);
                bundle7.putBundle(string, bundle8);
            }
            bundle5.putBundle("invisible_actions", bundle7);
            bundle6.putBundle("invisible_actions", bundle7);
            if (this.f75o == null) {
                this.f75o = new Bundle();
            }
            this.f75o.putBundle("android.car.EXTENSIONS", bundle5);
            ((Bundle) iVar.f1550f).putBundle("android.car.EXTENSIONS", bundle6);
        }
        int i10 = Build.VERSION.SDK_INT;
        ((Notification.Builder) iVar.f1548d).setExtras(this.f75o).setRemoteInputHistory(null);
        ((Notification.Builder) iVar.f1548d).setBadgeIconType(this.f79s).setSettingsText(null).setShortcutId(null).setTimeoutAfter(0L).setGroupAlertBehavior(0);
        if (!TextUtils.isEmpty(this.f78r)) {
            ((Notification.Builder) iVar.f1548d).setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
        Iterator it3 = this.f66c.iterator();
        if (it3.hasNext()) {
            com.unified.ur1.SatelliteTracker.h.p(it3.next());
            throw null;
        }
        if (i10 >= 29) {
            ((Notification.Builder) iVar.f1548d).setAllowSystemGeneratedContextualActions(this.f81u);
            ((Notification.Builder) iVar.f1548d).setBubbleMetadata(null);
        }
        if (i10 >= 31 && (i5 = this.f80t) != 0) {
            ((Notification.Builder) iVar.f1548d).setForegroundServiceBehavior(i5);
        }
        t tVar = (t) iVar.f1549e;
        u uVar = tVar.f73l;
        if (uVar != null) {
            uVar.h(iVar);
        }
        Notification notificationBuild = ((Notification.Builder) iVar.f1548d).build();
        if (uVar != null) {
            tVar.f73l.getClass();
        }
        if (uVar != null && (bundle = notificationBuild.extras) != null) {
            uVar.g(bundle);
        }
        return notificationBuild;
    }

    public final void c(int i5, boolean z4) {
        Notification notification = this.f82v;
        if (z4) {
            notification.flags = i5 | notification.flags;
        } else {
            notification.flags = (~i5) & notification.flags;
        }
    }

    public final void d(u uVar) {
        if (this.f73l != uVar) {
            this.f73l = uVar;
            if (((t) uVar.f84c) != this) {
                uVar.f84c = this;
                d(uVar);
            }
        }
    }
}
