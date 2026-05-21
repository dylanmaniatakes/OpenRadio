package x;

import android.view.ViewGroup;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: a, reason: collision with root package name */
    public int f10244a;

    /* renamed from: b, reason: collision with root package name */
    public final l f10245b;

    /* renamed from: c, reason: collision with root package name */
    public final k f10246c;

    /* renamed from: d, reason: collision with root package name */
    public final j f10247d;

    /* renamed from: e, reason: collision with root package name */
    public final m f10248e;

    /* renamed from: f, reason: collision with root package name */
    public HashMap f10249f;

    public i() {
        l lVar = new l();
        lVar.f10322a = 0;
        lVar.f10323b = 0;
        lVar.f10324c = 1.0f;
        lVar.f10325d = Float.NaN;
        this.f10245b = lVar;
        k kVar = new k();
        kVar.f10315a = -1;
        kVar.f10316b = 0;
        kVar.f10317c = -1;
        kVar.f10318d = Float.NaN;
        kVar.f10319e = Float.NaN;
        kVar.f10320f = Float.NaN;
        kVar.g = -1;
        kVar.h = null;
        kVar.f10321i = -1;
        this.f10246c = kVar;
        j jVar = new j();
        jVar.f10276a = false;
        jVar.f10282d = -1;
        jVar.f10284e = -1;
        jVar.f10286f = -1.0f;
        jVar.g = true;
        jVar.h = -1;
        jVar.f10290i = -1;
        jVar.f10292j = -1;
        jVar.f10294k = -1;
        jVar.f10296l = -1;
        jVar.f10298m = -1;
        jVar.n = -1;
        jVar.f10301o = -1;
        jVar.f10303p = -1;
        jVar.f10304q = -1;
        jVar.f10305r = -1;
        jVar.f10306s = -1;
        jVar.f10307t = -1;
        jVar.f10308u = -1;
        jVar.f10309v = -1;
        jVar.f10310w = 0.5f;
        jVar.f10311x = 0.5f;
        jVar.f10312y = null;
        jVar.f10313z = -1;
        jVar.f10251A = 0;
        jVar.f10252B = BitmapDescriptorFactory.HUE_RED;
        jVar.f10253C = -1;
        jVar.f10254D = -1;
        jVar.f10255E = -1;
        jVar.f10256F = 0;
        jVar.f10257G = 0;
        jVar.f10258H = 0;
        jVar.I = 0;
        jVar.f10259J = 0;
        jVar.f10260K = 0;
        jVar.f10261L = 0;
        jVar.f10262M = Integer.MIN_VALUE;
        jVar.f10263N = Integer.MIN_VALUE;
        jVar.f10264O = Integer.MIN_VALUE;
        jVar.f10265P = Integer.MIN_VALUE;
        jVar.f10266Q = Integer.MIN_VALUE;
        jVar.f10267R = Integer.MIN_VALUE;
        jVar.f10268S = Integer.MIN_VALUE;
        jVar.f10269T = -1.0f;
        jVar.f10270U = -1.0f;
        jVar.f10271V = 0;
        jVar.f10272W = 0;
        jVar.f10273X = 0;
        jVar.f10274Y = 0;
        jVar.f10275Z = 0;
        jVar.f10277a0 = 0;
        jVar.f10279b0 = 0;
        jVar.f10281c0 = 0;
        jVar.f10283d0 = 1.0f;
        jVar.f10285e0 = 1.0f;
        jVar.f10287f0 = -1;
        jVar.f10288g0 = 0;
        jVar.f10289h0 = -1;
        jVar.f10297l0 = false;
        jVar.f10299m0 = false;
        jVar.f10300n0 = true;
        jVar.f10302o0 = 0;
        this.f10247d = jVar;
        m mVar = new m();
        mVar.f10326a = BitmapDescriptorFactory.HUE_RED;
        mVar.f10327b = BitmapDescriptorFactory.HUE_RED;
        mVar.f10328c = BitmapDescriptorFactory.HUE_RED;
        mVar.f10329d = 1.0f;
        mVar.f10330e = 1.0f;
        mVar.f10331f = Float.NaN;
        mVar.g = Float.NaN;
        mVar.h = -1;
        mVar.f10332i = BitmapDescriptorFactory.HUE_RED;
        mVar.f10333j = BitmapDescriptorFactory.HUE_RED;
        mVar.f10334k = BitmapDescriptorFactory.HUE_RED;
        mVar.f10335l = false;
        mVar.f10336m = BitmapDescriptorFactory.HUE_RED;
        this.f10248e = mVar;
        this.f10249f = new HashMap();
    }

    public final void a(e eVar) {
        j jVar = this.f10247d;
        eVar.f10192e = jVar.h;
        eVar.f10194f = jVar.f10290i;
        eVar.g = jVar.f10292j;
        eVar.h = jVar.f10294k;
        eVar.f10198i = jVar.f10296l;
        eVar.f10200j = jVar.f10298m;
        eVar.f10202k = jVar.n;
        eVar.f10204l = jVar.f10301o;
        eVar.f10206m = jVar.f10303p;
        eVar.n = jVar.f10304q;
        eVar.f10209o = jVar.f10305r;
        eVar.f10215s = jVar.f10306s;
        eVar.f10216t = jVar.f10307t;
        eVar.f10217u = jVar.f10308u;
        eVar.f10218v = jVar.f10309v;
        ((ViewGroup.MarginLayoutParams) eVar).leftMargin = jVar.f10256F;
        ((ViewGroup.MarginLayoutParams) eVar).rightMargin = jVar.f10257G;
        ((ViewGroup.MarginLayoutParams) eVar).topMargin = jVar.f10258H;
        ((ViewGroup.MarginLayoutParams) eVar).bottomMargin = jVar.I;
        eVar.f10159A = jVar.f10267R;
        eVar.f10160B = jVar.f10266Q;
        eVar.f10220x = jVar.f10263N;
        eVar.f10222z = jVar.f10265P;
        eVar.f10163E = jVar.f10310w;
        eVar.f10164F = jVar.f10311x;
        eVar.f10211p = jVar.f10313z;
        eVar.f10213q = jVar.f10251A;
        eVar.f10214r = jVar.f10252B;
        eVar.f10165G = jVar.f10312y;
        eVar.f10177T = jVar.f10253C;
        eVar.f10178U = jVar.f10254D;
        eVar.I = jVar.f10269T;
        eVar.f10166H = jVar.f10270U;
        eVar.f10168K = jVar.f10272W;
        eVar.f10167J = jVar.f10271V;
        eVar.f10180W = jVar.f10297l0;
        eVar.f10181X = jVar.f10299m0;
        eVar.f10169L = jVar.f10273X;
        eVar.f10170M = jVar.f10274Y;
        eVar.f10173P = jVar.f10275Z;
        eVar.f10174Q = jVar.f10277a0;
        eVar.f10171N = jVar.f10279b0;
        eVar.f10172O = jVar.f10281c0;
        eVar.f10175R = jVar.f10283d0;
        eVar.f10176S = jVar.f10285e0;
        eVar.f10179V = jVar.f10255E;
        eVar.f10188c = jVar.f10286f;
        eVar.f10184a = jVar.f10282d;
        eVar.f10186b = jVar.f10284e;
        ((ViewGroup.MarginLayoutParams) eVar).width = jVar.f10278b;
        ((ViewGroup.MarginLayoutParams) eVar).height = jVar.f10280c;
        String str = jVar.f10295k0;
        if (str != null) {
            eVar.f10182Y = str;
        }
        eVar.f10183Z = jVar.f10302o0;
        eVar.setMarginStart(jVar.f10260K);
        eVar.setMarginEnd(jVar.f10259J);
        eVar.a();
    }

    public final Object clone() {
        i iVar = new i();
        j jVar = iVar.f10247d;
        jVar.getClass();
        j jVar2 = this.f10247d;
        jVar.f10276a = jVar2.f10276a;
        jVar.f10278b = jVar2.f10278b;
        jVar.f10280c = jVar2.f10280c;
        jVar.f10282d = jVar2.f10282d;
        jVar.f10284e = jVar2.f10284e;
        jVar.f10286f = jVar2.f10286f;
        jVar.g = jVar2.g;
        jVar.h = jVar2.h;
        jVar.f10290i = jVar2.f10290i;
        jVar.f10292j = jVar2.f10292j;
        jVar.f10294k = jVar2.f10294k;
        jVar.f10296l = jVar2.f10296l;
        jVar.f10298m = jVar2.f10298m;
        jVar.n = jVar2.n;
        jVar.f10301o = jVar2.f10301o;
        jVar.f10303p = jVar2.f10303p;
        jVar.f10304q = jVar2.f10304q;
        jVar.f10305r = jVar2.f10305r;
        jVar.f10306s = jVar2.f10306s;
        jVar.f10307t = jVar2.f10307t;
        jVar.f10308u = jVar2.f10308u;
        jVar.f10309v = jVar2.f10309v;
        jVar.f10310w = jVar2.f10310w;
        jVar.f10311x = jVar2.f10311x;
        jVar.f10312y = jVar2.f10312y;
        jVar.f10313z = jVar2.f10313z;
        jVar.f10251A = jVar2.f10251A;
        jVar.f10252B = jVar2.f10252B;
        jVar.f10253C = jVar2.f10253C;
        jVar.f10254D = jVar2.f10254D;
        jVar.f10255E = jVar2.f10255E;
        jVar.f10256F = jVar2.f10256F;
        jVar.f10257G = jVar2.f10257G;
        jVar.f10258H = jVar2.f10258H;
        jVar.I = jVar2.I;
        jVar.f10259J = jVar2.f10259J;
        jVar.f10260K = jVar2.f10260K;
        jVar.f10261L = jVar2.f10261L;
        jVar.f10262M = jVar2.f10262M;
        jVar.f10263N = jVar2.f10263N;
        jVar.f10264O = jVar2.f10264O;
        jVar.f10265P = jVar2.f10265P;
        jVar.f10266Q = jVar2.f10266Q;
        jVar.f10267R = jVar2.f10267R;
        jVar.f10268S = jVar2.f10268S;
        jVar.f10269T = jVar2.f10269T;
        jVar.f10270U = jVar2.f10270U;
        jVar.f10271V = jVar2.f10271V;
        jVar.f10272W = jVar2.f10272W;
        jVar.f10273X = jVar2.f10273X;
        jVar.f10274Y = jVar2.f10274Y;
        jVar.f10275Z = jVar2.f10275Z;
        jVar.f10277a0 = jVar2.f10277a0;
        jVar.f10279b0 = jVar2.f10279b0;
        jVar.f10281c0 = jVar2.f10281c0;
        jVar.f10283d0 = jVar2.f10283d0;
        jVar.f10285e0 = jVar2.f10285e0;
        jVar.f10287f0 = jVar2.f10287f0;
        jVar.f10288g0 = jVar2.f10288g0;
        jVar.f10289h0 = jVar2.f10289h0;
        jVar.f10295k0 = jVar2.f10295k0;
        int[] iArr = jVar2.f10291i0;
        if (iArr == null || jVar2.f10293j0 != null) {
            jVar.f10291i0 = null;
        } else {
            jVar.f10291i0 = Arrays.copyOf(iArr, iArr.length);
        }
        jVar.f10293j0 = jVar2.f10293j0;
        jVar.f10297l0 = jVar2.f10297l0;
        jVar.f10299m0 = jVar2.f10299m0;
        jVar.f10300n0 = jVar2.f10300n0;
        jVar.f10302o0 = jVar2.f10302o0;
        k kVar = iVar.f10246c;
        kVar.getClass();
        k kVar2 = this.f10246c;
        kVar2.getClass();
        kVar.f10315a = kVar2.f10315a;
        kVar.f10317c = kVar2.f10317c;
        kVar.f10319e = kVar2.f10319e;
        kVar.f10318d = kVar2.f10318d;
        l lVar = iVar.f10245b;
        lVar.getClass();
        l lVar2 = this.f10245b;
        lVar2.getClass();
        lVar.f10322a = lVar2.f10322a;
        lVar.f10324c = lVar2.f10324c;
        lVar.f10325d = lVar2.f10325d;
        lVar.f10323b = lVar2.f10323b;
        m mVar = iVar.f10248e;
        mVar.getClass();
        m mVar2 = this.f10248e;
        mVar2.getClass();
        mVar.f10326a = mVar2.f10326a;
        mVar.f10327b = mVar2.f10327b;
        mVar.f10328c = mVar2.f10328c;
        mVar.f10329d = mVar2.f10329d;
        mVar.f10330e = mVar2.f10330e;
        mVar.f10331f = mVar2.f10331f;
        mVar.g = mVar2.g;
        mVar.h = mVar2.h;
        mVar.f10332i = mVar2.f10332i;
        mVar.f10333j = mVar2.f10333j;
        mVar.f10334k = mVar2.f10334k;
        mVar.f10335l = mVar2.f10335l;
        mVar.f10336m = mVar2.f10336m;
        iVar.f10244a = this.f10244a;
        return iVar;
    }
}
