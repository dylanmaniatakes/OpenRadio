package androidx.activity.result;

import d.AbstractC0422a;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class d extends c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3257a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f3258b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ AbstractC0422a f3259c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ g f3260d;

    public /* synthetic */ d(g gVar, String str, AbstractC0422a abstractC0422a, int i5) {
        this.f3257a = i5;
        this.f3260d = gVar;
        this.f3258b = str;
        this.f3259c = abstractC0422a;
    }

    @Override // androidx.activity.result.c
    public final void a(Object obj) throws Exception {
        switch (this.f3257a) {
            case 0:
                g gVar = this.f3260d;
                HashMap map = gVar.f3266b;
                String str = this.f3258b;
                Integer num = (Integer) map.get(str);
                AbstractC0422a abstractC0422a = this.f3259c;
                if (num != null) {
                    gVar.f3268d.add(str);
                    try {
                        gVar.b(num.intValue(), abstractC0422a, obj);
                        return;
                    } catch (Exception e5) {
                        gVar.f3268d.remove(str);
                        throw e5;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0422a + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
            default:
                g gVar2 = this.f3260d;
                HashMap map2 = gVar2.f3266b;
                String str2 = this.f3258b;
                Integer num2 = (Integer) map2.get(str2);
                AbstractC0422a abstractC0422a2 = this.f3259c;
                if (num2 != null) {
                    gVar2.f3268d.add(str2);
                    try {
                        gVar2.b(num2.intValue(), abstractC0422a2, obj);
                        return;
                    } catch (Exception e6) {
                        gVar2.f3268d.remove(str2);
                        throw e6;
                    }
                }
                throw new IllegalStateException("Attempting to launch an unregistered ActivityResultLauncher with contract " + abstractC0422a2 + " and input " + obj + ". You must ensure the ActivityResultLauncher is registered before calling launch().");
        }
    }

    public void b() {
        this.f3260d.f(this.f3258b);
    }
}
