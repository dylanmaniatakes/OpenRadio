package retrofit2;

import F3.i;
import N3.C0131e;
import a.AbstractC0203a;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.lang.reflect.Method;
import s3.C0892b;
import w3.InterfaceC0936d;
import y3.AbstractC0989c;
import y3.InterfaceC0991e;

/* loaded from: classes.dex */
public final class KotlinExtensions {

    @InterfaceC0991e(c = "retrofit2.KotlinExtensions", f = "KotlinExtensions.kt", l = {113}, m = "suspendAndThrow")
    /* renamed from: retrofit2.KotlinExtensions$suspendAndThrow$1, reason: invalid class name */
    public static final class AnonymousClass1 extends AbstractC0989c {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC0936d interfaceC0936d) {
            super(interfaceC0936d);
        }

        @Override // y3.AbstractC0987a
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinExtensions.suspendAndThrow(null, this);
        }
    }

    public static final <T> Object await(Call<T> call, InterfaceC0936d interfaceC0936d) {
        final C0131e c0131e = new C0131e(1, AbstractC0203a.h(interfaceC0936d));
        c0131e.q(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                i.g(call2, "call");
                i.g(th, "t");
                ((C0131e) c0131e).resumeWith(AbstractC0399v1.c(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.g(call2, "call");
                i.g(response, "response");
                if (!response.isSuccessful()) {
                    ((C0131e) c0131e).resumeWith(AbstractC0399v1.c(new HttpException(response)));
                    return;
                }
                T tBody = response.body();
                if (tBody != null) {
                    ((C0131e) c0131e).resumeWith(tBody);
                    return;
                }
                Object objTag = call2.request().tag(Invocation.class);
                if (objTag == null) {
                    C0892b c0892b = new C0892b();
                    i.j(c0892b, i.class.getName());
                    throw c0892b;
                }
                Method method = ((Invocation) objTag).method();
                StringBuilder sb = new StringBuilder("Response from ");
                i.b(method, "method");
                Class<?> declaringClass = method.getDeclaringClass();
                i.b(declaringClass, "method.declaringClass");
                sb.append(declaringClass.getName());
                sb.append('.');
                sb.append(method.getName());
                sb.append(" was null but response body type was declared as non-null");
                C0892b c0892b2 = new C0892b(sb.toString());
                ((C0131e) c0131e).resumeWith(AbstractC0399v1.c(c0892b2));
            }
        });
        return c0131e.n();
    }

    public static final <T> Object awaitNullable(Call<T> call, InterfaceC0936d interfaceC0936d) {
        final C0131e c0131e = new C0131e(1, AbstractC0203a.h(interfaceC0936d));
        c0131e.q(new KotlinExtensions$await$$inlined$suspendCancellableCoroutine$lambda$2(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$await$4$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                i.g(call2, "call");
                i.g(th, "t");
                ((C0131e) c0131e).resumeWith(AbstractC0399v1.c(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.g(call2, "call");
                i.g(response, "response");
                if (response.isSuccessful()) {
                    ((C0131e) c0131e).resumeWith(response.body());
                } else {
                    ((C0131e) c0131e).resumeWith(AbstractC0399v1.c(new HttpException(response)));
                }
            }
        });
        return c0131e.n();
    }

    public static final <T> Object awaitResponse(Call<T> call, InterfaceC0936d interfaceC0936d) {
        final C0131e c0131e = new C0131e(1, AbstractC0203a.h(interfaceC0936d));
        c0131e.q(new KotlinExtensions$awaitResponse$$inlined$suspendCancellableCoroutine$lambda$1(call));
        call.enqueue(new Callback<T>() { // from class: retrofit2.KotlinExtensions$awaitResponse$2$2
            @Override // retrofit2.Callback
            public void onFailure(Call<T> call2, Throwable th) {
                i.g(call2, "call");
                i.g(th, "t");
                ((C0131e) c0131e).resumeWith(AbstractC0399v1.c(th));
            }

            @Override // retrofit2.Callback
            public void onResponse(Call<T> call2, Response<T> response) {
                i.g(call2, "call");
                i.g(response, "response");
                c0131e.resumeWith(response);
            }
        });
        return c0131e.n();
    }

    public static final <T> T create(Retrofit retrofit) {
        i.g(retrofit, "$this$create");
        throw new UnsupportedOperationException("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object suspendAndThrow(final java.lang.Exception r4, w3.InterfaceC0936d r5) {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.result
            x3.a r1 = x3.EnumC0973a.f10448j
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r4 = r0.L$0
            java.lang.Exception r4 = (java.lang.Exception) r4
            com.google.android.gms.internal.measurement.AbstractC0399v1.j(r5)
            s3.j r4 = s3.C0900j.f9694a
            return r4
        L2d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L35:
            com.google.android.gms.internal.measurement.AbstractC0399v1.j(r5)
            r0.L$0 = r4
            r0.label = r3
            U3.d r5 = N3.B.f1811a
            w3.i r2 = r0.getContext()
            retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1 r3 = new retrofit2.KotlinExtensions$suspendAndThrow$$inlined$suspendCoroutineUninterceptedOrReturn$lambda$1
            r3.<init>()
            r5.W(r2, r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.suspendAndThrow(java.lang.Exception, w3.d):java.lang.Object");
    }
}
