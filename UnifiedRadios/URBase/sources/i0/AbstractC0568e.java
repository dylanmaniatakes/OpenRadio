package i0;

import F3.i;
import N3.C0131e;
import S3.t;
import a.AbstractC0203a;
import android.adservices.measurement.MeasurementManager;
import android.net.Uri;
import android.view.InputEvent;
import h4.r;
import s3.C0900j;
import w3.InterfaceC0936d;
import x3.EnumC0973a;

/* renamed from: i0.e, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0568e {

    /* renamed from: a, reason: collision with root package name */
    public final MeasurementManager f7190a;

    public AbstractC0568e(MeasurementManager measurementManager) {
        i.f(measurementManager, "mMeasurementManager");
        this.f7190a = measurementManager;
    }

    public static Object b(AbstractC0568e abstractC0568e, AbstractC0564a abstractC0564a, InterfaceC0936d interfaceC0936d) {
        new C0131e(1, AbstractC0203a.h(interfaceC0936d)).o();
        MeasurementManager measurementManager = abstractC0568e.f7190a;
        throw null;
    }

    public static Object d(AbstractC0568e abstractC0568e, InterfaceC0936d interfaceC0936d) {
        C0131e c0131e = new C0131e(1, AbstractC0203a.h(interfaceC0936d));
        c0131e.o();
        abstractC0568e.f7190a.getMeasurementApiStatus(new ExecutorC0566c(0), new K.f(c0131e));
        return c0131e.n();
    }

    public static Object g(AbstractC0568e abstractC0568e, Uri uri, InputEvent inputEvent, InterfaceC0936d interfaceC0936d) throws Throwable {
        C0131e c0131e = new C0131e(1, AbstractC0203a.h(interfaceC0936d));
        c0131e.o();
        abstractC0568e.f7190a.registerSource(uri, inputEvent, new ExecutorC0566c(0), new K.f(c0131e));
        Object objN = c0131e.n();
        return objN == EnumC0973a.f10448j ? objN : C0900j.f9694a;
    }

    public static Object h(AbstractC0568e abstractC0568e, AbstractC0569f abstractC0569f, InterfaceC0936d interfaceC0936d) throws Throwable {
        C0567d c0567d = new C0567d(abstractC0568e, null);
        t tVar = new t(interfaceC0936d, interfaceC0936d.getContext());
        Object objP = r.p(tVar, tVar, c0567d);
        return objP == EnumC0973a.f10448j ? objP : C0900j.f9694a;
    }

    public static Object j(AbstractC0568e abstractC0568e, Uri uri, InterfaceC0936d interfaceC0936d) throws Throwable {
        C0131e c0131e = new C0131e(1, AbstractC0203a.h(interfaceC0936d));
        c0131e.o();
        abstractC0568e.f7190a.registerTrigger(uri, new ExecutorC0566c(0), new K.f(c0131e));
        Object objN = c0131e.n();
        return objN == EnumC0973a.f10448j ? objN : C0900j.f9694a;
    }

    public static Object l(AbstractC0568e abstractC0568e, AbstractC0570g abstractC0570g, InterfaceC0936d interfaceC0936d) {
        new C0131e(1, AbstractC0203a.h(interfaceC0936d)).o();
        MeasurementManager measurementManager = abstractC0568e.f7190a;
        throw null;
    }

    public static Object n(AbstractC0568e abstractC0568e, h hVar, InterfaceC0936d interfaceC0936d) {
        new C0131e(1, AbstractC0203a.h(interfaceC0936d)).o();
        MeasurementManager measurementManager = abstractC0568e.f7190a;
        throw null;
    }

    public Object a(AbstractC0564a abstractC0564a, InterfaceC0936d interfaceC0936d) {
        return b(this, abstractC0564a, interfaceC0936d);
    }

    public Object c(InterfaceC0936d interfaceC0936d) {
        return d(this, interfaceC0936d);
    }

    public Object e(Uri uri, InputEvent inputEvent, InterfaceC0936d interfaceC0936d) {
        return g(this, uri, inputEvent, interfaceC0936d);
    }

    public Object f(AbstractC0569f abstractC0569f, InterfaceC0936d interfaceC0936d) {
        return h(this, abstractC0569f, interfaceC0936d);
    }

    public Object i(Uri uri, InterfaceC0936d interfaceC0936d) {
        return j(this, uri, interfaceC0936d);
    }

    public Object k(AbstractC0570g abstractC0570g, InterfaceC0936d interfaceC0936d) {
        return l(this, abstractC0570g, interfaceC0936d);
    }

    public Object m(h hVar, InterfaceC0936d interfaceC0936d) {
        return n(this, hVar, interfaceC0936d);
    }
}
