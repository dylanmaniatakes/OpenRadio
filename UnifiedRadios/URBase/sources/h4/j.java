package h4;

import android.content.IntentFilter;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import k4.t;

/* loaded from: classes.dex */
public final class j extends m {

    /* renamed from: e, reason: collision with root package name */
    public final Y0.j f7098e;

    /* renamed from: f, reason: collision with root package name */
    public J0.d f7099f;
    public final /* synthetic */ int g;
    public final AtomicReference h;

    /* renamed from: i, reason: collision with root package name */
    public Object f7100i;

    public j(Y0.j jVar, int i5, int i6) {
        super(i5, i6);
        this.f7098e = jVar;
        this.f7099f = new J0.d(3, this);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.MEDIA_MOUNTED");
        intentFilter.addAction("android.intent.action.MEDIA_UNMOUNTED");
        intentFilter.addDataScheme("file");
        jVar.f2915a.registerReceiver(this.f7099f, intentFilter);
    }

    private final void n() {
    }

    @Override // h4.m
    public void b() {
        switch (this.g) {
            case 1:
                break;
            case 2:
            default:
                j();
                return;
            case 3:
                this.f7100i = null;
                j();
                return;
        }
        while (true) {
            ArrayList arrayList = (ArrayList) this.f7100i;
            if (arrayList.isEmpty()) {
                j();
                return;
            } else {
                com.unified.ur1.SatelliteTracker.h.p(arrayList.get(0));
                arrayList.remove(0);
            }
        }
    }

    @Override // h4.m
    public final int c() {
        switch (this.g) {
            case 0:
                i4.c cVar = (i4.c) this.h.get();
                if (cVar == null) {
                    break;
                } else {
                    break;
                }
            case 1:
                i4.c cVar2 = (i4.c) this.h.get();
                if (cVar2 == null) {
                    break;
                } else {
                    break;
                }
            case 2:
                i4.c cVar3 = (i4.c) this.h.get();
                if (cVar3 == null) {
                    break;
                } else {
                    break;
                }
            default:
                i4.c cVar4 = (i4.c) this.h.get();
                if (cVar4 == null) {
                    break;
                } else {
                    break;
                }
        }
        return t.f8315b;
    }

    @Override // h4.m
    public final int d() {
        switch (this.g) {
            case 0:
                i4.c cVar = (i4.c) this.h.get();
                if (cVar != null) {
                    return ((i4.d) cVar).f7367a;
                }
                return 0;
            case 1:
                i4.c cVar2 = (i4.c) this.h.get();
                if (cVar2 != null) {
                    return ((i4.d) cVar2).f7367a;
                }
                return 0;
            case 2:
                i4.c cVar3 = (i4.c) this.h.get();
                if (cVar3 != null) {
                    return ((i4.d) cVar3).f7367a;
                }
                return 0;
            default:
                i4.c cVar4 = (i4.c) this.h.get();
                if (cVar4 != null) {
                    return ((i4.d) cVar4).f7367a;
                }
                return 0;
        }
    }

    @Override // h4.m
    public final String e() {
        switch (this.g) {
            case 0:
                return "assets";
            case 1:
                return "filearchive";
            case 2:
                return "filesystem";
            default:
                return "sqlcache";
        }
    }

    @Override // h4.m
    public final M0.d f() {
        switch (this.g) {
            case 0:
                return new i(this, (AssetManager) this.f7100i);
            case 1:
                return new g(this, 2);
            case 2:
                return new g(this, 3);
            default:
                return new g(this, 4);
        }
    }

    @Override // h4.m
    public final boolean g() {
        switch (this.g) {
        }
        return false;
    }

    @Override // h4.m
    public final void i(i4.c cVar) {
        switch (this.g) {
            case 0:
                this.h.set(cVar);
                break;
            case 1:
                this.h.set(cVar);
                break;
            case 2:
                this.h.set(cVar);
                break;
            default:
                this.h.set(cVar);
                break;
        }
    }

    public final void j() {
        J0.d dVar = this.f7099f;
        if (dVar != null) {
            this.f7098e.f2915a.unregisterReceiver(dVar);
            this.f7099f = null;
        }
        a();
        this.f7107a.shutdown();
    }

    public void k() throws Throwable {
        int i5;
        File[] fileArrListFiles;
        while (true) {
            ArrayList arrayList = (ArrayList) this.f7100i;
            if (arrayList.isEmpty()) {
                break;
            }
            com.unified.ur1.SatelliteTracker.h.p(arrayList.get(0));
            arrayList.remove(0);
        }
        File fileA = e4.a.g().a(null);
        if (fileA == null || (fileArrListFiles = fileA.listFiles()) == null) {
            return;
        }
        for (File file : fileArrListFiles) {
            HashMap map = a.f7089a;
            String name = file.getName();
            if (name.contains(".")) {
                try {
                    name = name.substring(name.lastIndexOf(".") + 1);
                } catch (Exception unused) {
                }
            }
            Class cls = (Class) a.f7089a.get(name.toLowerCase());
            if (cls != null) {
                try {
                    try {
                        com.unified.ur1.SatelliteTracker.h.p(cls.newInstance());
                        throw null;
                    } catch (Exception e5) {
                        Log.e("OsmDroid", "Error opening archive file " + file.getAbsolutePath(), e5);
                    }
                } catch (IllegalAccessException e6) {
                    Log.e("OsmDroid", "Error initializing archive file provider " + file.getAbsolutePath(), e6);
                } catch (InstantiationException e7) {
                    Log.e("OsmDroid", "Error initializing archive file provider " + file.getAbsolutePath(), e7);
                }
            }
        }
    }

    public void l() {
        switch (this.g) {
            case 1:
                k();
                break;
        }
    }

    public final void m() {
    }

    public void o() {
        switch (this.g) {
            case 1:
                k();
                break;
            case 3:
                o oVar = (o) this.f7100i;
                if (oVar != null) {
                    oVar.getClass();
                }
                this.f7100i = new o();
                break;
        }
    }

    public final void p() {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Y0.j jVar, AssetManager assetManager, i4.c cVar) {
        this(jVar, e4.a.g().f6226d, e4.a.g().f6228f);
        this.g = 0;
        this.h = new AtomicReference();
        i(cVar);
        this.f7100i = assetManager;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public j(Y0.j jVar, i4.c cVar, int i5) throws Throwable {
        this(jVar, e4.a.g().f6227e, e4.a.g().g);
        this.g = i5;
        switch (i5) {
            case 2:
                e4.a.g().getClass();
                this(jVar, e4.a.g().f6227e, e4.a.g().g);
                q qVar = new q();
                this.f7100i = qVar;
                this.h = new AtomicReference();
                i(cVar);
                qVar.f7125b = 604800000L;
                break;
            case 3:
                this(jVar, e4.a.g().f6227e, e4.a.g().g);
                this.h = new AtomicReference();
                i(cVar);
                this.f7100i = new o();
                break;
            default:
                this.f7100i = new ArrayList();
                this.h = new AtomicReference();
                i(cVar);
                k();
                break;
        }
    }
}
