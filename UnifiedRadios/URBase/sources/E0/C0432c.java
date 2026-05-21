package e0;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/* renamed from: e0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0432c {

    /* renamed from: f, reason: collision with root package name */
    public static final Object f6144f = new Object();
    public static C0432c g;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6145a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f6146b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f6147c = new HashMap();

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f6148d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final HandlerC0430a f6149e;

    public C0432c(Context context) {
        this.f6145a = context;
        this.f6149e = new HandlerC0430a(this, context.getMainLooper(), 0);
    }

    public static C0432c a(Context context) {
        C0432c c0432c;
        synchronized (f6144f) {
            try {
                if (g == null) {
                    g = new C0432c(context.getApplicationContext());
                }
                c0432c = g;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0432c;
    }

    public final void b(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.f6146b) {
            try {
                C0431b c0431b = new C0431b(broadcastReceiver, intentFilter);
                ArrayList arrayList = (ArrayList) this.f6146b.get(broadcastReceiver);
                if (arrayList == null) {
                    arrayList = new ArrayList(1);
                    this.f6146b.put(broadcastReceiver, arrayList);
                }
                arrayList.add(c0431b);
                for (int i5 = 0; i5 < intentFilter.countActions(); i5++) {
                    String action = intentFilter.getAction(i5);
                    ArrayList arrayList2 = (ArrayList) this.f6147c.get(action);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                        this.f6147c.put(action, arrayList2);
                    }
                    arrayList2.add(c0431b);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v5 */
    /* JADX WARN: Type inference failed for: r12v7 */
    public final void c(Intent intent) {
        ArrayList arrayList;
        int i5;
        String str;
        ?? r12;
        synchronized (this.f6146b) {
            try {
                String action = intent.getAction();
                String strResolveTypeIfNeeded = intent.resolveTypeIfNeeded(this.f6145a.getContentResolver());
                Uri data = intent.getData();
                String scheme = intent.getScheme();
                Set<String> categories = intent.getCategories();
                int i6 = 1;
                boolean z4 = false;
                boolean z5 = (intent.getFlags() & 8) != 0;
                if (z5) {
                    Log.v("LocalBroadcastManager", "Resolving type " + strResolveTypeIfNeeded + " scheme " + scheme + " of intent " + intent);
                }
                ArrayList arrayList2 = (ArrayList) this.f6147c.get(intent.getAction());
                if (arrayList2 != null) {
                    if (z5) {
                        Log.v("LocalBroadcastManager", "Action list: " + arrayList2);
                    }
                    ArrayList arrayList3 = null;
                    int i7 = 0;
                    while (i7 < arrayList2.size()) {
                        C0431b c0431b = (C0431b) arrayList2.get(i7);
                        if (z5) {
                            Log.v("LocalBroadcastManager", "Matching against filter " + c0431b.f6140a);
                        }
                        if (c0431b.f6142c) {
                            if (z5) {
                                Log.v("LocalBroadcastManager", "  Filter's target already added");
                            }
                            arrayList = arrayList2;
                            i5 = i7;
                            str = action;
                            r12 = i6;
                        } else {
                            String str2 = action;
                            arrayList = arrayList2;
                            i5 = i7;
                            str = action;
                            r12 = i6;
                            int iMatch = c0431b.f6140a.match(str2, strResolveTypeIfNeeded, scheme, data, categories, "LocalBroadcastManager");
                            if (iMatch >= 0) {
                                if (z5) {
                                    Log.v("LocalBroadcastManager", "  Filter matched!  match=0x" + Integer.toHexString(iMatch));
                                }
                                if (arrayList3 == null) {
                                    arrayList3 = new ArrayList();
                                }
                                arrayList3.add(c0431b);
                                c0431b.f6142c = r12;
                            } else if (z5) {
                                Log.v("LocalBroadcastManager", "  Filter did not match: " + (iMatch != -4 ? iMatch != -3 ? iMatch != -2 ? iMatch != -1 ? "unknown reason" : "type" : "data" : "action" : "category"));
                            }
                        }
                        i7 = i5 + 1;
                        i6 = r12;
                        arrayList2 = arrayList;
                        action = str;
                        z4 = false;
                    }
                    int i8 = i6;
                    if (arrayList3 != null) {
                        for (int i9 = 0; i9 < arrayList3.size(); i9++) {
                            ((C0431b) arrayList3.get(i9)).f6142c = false;
                        }
                        this.f6148d.add(new L0.c(15, intent, arrayList3, false));
                        if (!this.f6149e.hasMessages(i8)) {
                            this.f6149e.sendEmptyMessage(i8);
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void d(BroadcastReceiver broadcastReceiver) {
        synchronized (this.f6146b) {
            try {
                ArrayList arrayList = (ArrayList) this.f6146b.remove(broadcastReceiver);
                if (arrayList == null) {
                    return;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    C0431b c0431b = (C0431b) arrayList.get(size);
                    c0431b.f6143d = true;
                    for (int i5 = 0; i5 < c0431b.f6140a.countActions(); i5++) {
                        String action = c0431b.f6140a.getAction(i5);
                        ArrayList arrayList2 = (ArrayList) this.f6147c.get(action);
                        if (arrayList2 != null) {
                            for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
                                C0431b c0431b2 = (C0431b) arrayList2.get(size2);
                                if (c0431b2.f6141b == broadcastReceiver) {
                                    c0431b2.f6143d = true;
                                    arrayList2.remove(size2);
                                }
                            }
                            if (arrayList2.size() <= 0) {
                                this.f6147c.remove(action);
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
