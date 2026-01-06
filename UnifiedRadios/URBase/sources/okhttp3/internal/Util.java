package okhttp3.internal;

import D0.p;
import E3.a;
import E3.l;
import F3.i;
import J1.C;
import J3.c;
import M3.d;
import M3.e;
import M3.m;
import W3.AbstractC0189b;
import W3.D;
import W3.F;
import W3.n;
import W3.o;
import W3.w;
import android.support.v4.media.session.b;
import com.google.android.gms.internal.measurement.AbstractC0399v1;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Header;
import okhttp3.internal.io.FileSystem;
import t3.j;
import t3.k;
import t3.q;
import t3.r;

/* loaded from: classes.dex */
public final class Util {
    public static final byte[] EMPTY_BYTE_ARRAY;
    public static final Headers EMPTY_HEADERS = Headers.Companion.of(new String[0]);
    public static final RequestBody EMPTY_REQUEST;
    public static final ResponseBody EMPTY_RESPONSE;
    private static final w UNICODE_BOMS;
    public static final TimeZone UTC;
    private static final d VERIFY_AS_IP_ADDRESS;
    public static final boolean assertionsEnabled;
    public static final String okHttpName;
    public static final String userAgent = "okhttp/4.12.0";

    static {
        byte[] bArr = new byte[0];
        EMPTY_BYTE_ARRAY = bArr;
        EMPTY_RESPONSE = ResponseBody.Companion.create$default(ResponseBody.Companion, bArr, (MediaType) null, 1, (Object) null);
        EMPTY_REQUEST = RequestBody.Companion.create$default(RequestBody.Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        o oVar = o.f2649m;
        UNICODE_BOMS = AbstractC0189b.g(C.h("efbbbf"), C.h("feff"), C.h("fffe"), C.h("0000ffff"), C.h("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        i.c(timeZone);
        UTC = timeZone;
        VERIFY_AS_IP_ADDRESS = new d("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        assertionsEnabled = false;
        String strI = e.I(OkHttpClient.class.getName(), "okhttp3.");
        if (m.q(strI, "Client")) {
            strI = strI.substring(0, strI.length() - "Client".length());
            i.e(strI, "this as java.lang.String…ing(startIndex, endIndex)");
        }
        okHttpName = strI;
    }

    public static final <E> void addIfAbsent(List<E> list, E e5) {
        i.f(list, "<this>");
        if (list.contains(e5)) {
            return;
        }
        list.add(e5);
    }

    public static final int and(byte b5, int i5) {
        return b5 & i5;
    }

    public static final EventListener.Factory asFactory(EventListener eventListener) {
        i.f(eventListener, "<this>");
        return new p(3, eventListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventListener asFactory$lambda$8(EventListener eventListener, Call call) {
        i.f(eventListener, "$this_asFactory");
        i.f(call, "it");
        return eventListener;
    }

    public static final void assertThreadDoesntHoldLock(Object obj) {
        i.f(obj, "<this>");
        if (assertionsEnabled && Thread.holdsLock(obj)) {
            throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST NOT hold lock on " + obj);
        }
    }

    public static final void assertThreadHoldsLock(Object obj) {
        i.f(obj, "<this>");
        if (!assertionsEnabled || Thread.holdsLock(obj)) {
            return;
        }
        throw new AssertionError("Thread " + Thread.currentThread().getName() + " MUST hold lock on " + obj);
    }

    public static final boolean canParseAsIpAddress(String str) {
        i.f(str, "<this>");
        d dVar = VERIFY_AS_IP_ADDRESS;
        dVar.getClass();
        return dVar.f1752j.matcher(str).matches();
    }

    public static final boolean canReuseConnectionFor(HttpUrl httpUrl, HttpUrl httpUrl2) {
        i.f(httpUrl, "<this>");
        i.f(httpUrl2, "other");
        return i.a(httpUrl.host(), httpUrl2.host()) && httpUrl.port() == httpUrl2.port() && i.a(httpUrl.scheme(), httpUrl2.scheme());
    }

    public static final int checkDuration(String str, long j5, TimeUnit timeUnit) {
        i.f(str, "name");
        if (j5 < 0) {
            throw new IllegalStateException(str.concat(" < 0").toString());
        }
        if (timeUnit == null) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j5);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str.concat(" too large.").toString());
        }
        if (millis != 0 || j5 <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException(str.concat(" too small.").toString());
    }

    public static final void checkOffsetAndCount(long j5, long j6, long j7) {
        if ((j6 | j7) < 0 || j6 > j5 || j5 - j6 < j7) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void closeQuietly(Closeable closeable) throws IOException {
        i.f(closeable, "<this>");
        try {
            closeable.close();
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final String[] concat(String[] strArr, String str) {
        i.f(strArr, "<this>");
        i.f(str, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        i.e(objArrCopyOf, "copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[strArr2.length - 1] = str;
        return strArr2;
    }

    public static final int delimiterOffset(String str, String str2, int i5, int i6) {
        i.f(str, "<this>");
        i.f(str2, "delimiters");
        while (i5 < i6) {
            if (e.y(str2, str.charAt(i5))) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, String str2, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = str.length();
        }
        return delimiterOffset(str, str2, i5, i6);
    }

    public static final boolean discard(F f5, int i5, TimeUnit timeUnit) {
        i.f(f5, "<this>");
        i.f(timeUnit, "timeUnit");
        try {
            return skipAll(f5, i5, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final <T> List<T> filterList(Iterable<? extends T> iterable, l lVar) {
        i.f(iterable, "<this>");
        i.f(lVar, "predicate");
        ArrayList arrayList = q.f9711j;
        for (T t4 : iterable) {
            if (((Boolean) lVar.invoke(t4)).booleanValue()) {
                if (arrayList.isEmpty()) {
                    arrayList = new ArrayList();
                }
                F3.o.a(arrayList).add(t4);
            }
        }
        return arrayList;
    }

    public static final String format(String str, Object... objArr) {
        i.f(str, "format");
        i.f(objArr, "args");
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        return String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x003d, code lost:
    
        r2 = r2 + 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean hasIntersection(java.lang.String[] r7, java.lang.String[] r8, java.util.Comparator<? super java.lang.String> r9) {
        /*
            java.lang.String r0 = "<this>"
            F3.i.f(r7, r0)
            java.lang.String r0 = "comparator"
            F3.i.f(r9, r0)
            int r0 = r7.length
            r1 = 0
            if (r0 != 0) goto Lf
            goto L40
        Lf:
            if (r8 == 0) goto L40
            int r0 = r8.length
            if (r0 != 0) goto L15
            goto L40
        L15:
            int r0 = r7.length
            r2 = r1
        L17:
            if (r2 >= r0) goto L40
            r3 = r7[r2]
            r4 = r1
        L1c:
            int r5 = r8.length
            r6 = 1
            if (r4 >= r5) goto L22
            r5 = r6
            goto L23
        L22:
            r5 = r1
        L23:
            if (r5 == 0) goto L3d
            int r5 = r4 + 1
            r4 = r8[r4]     // Catch: java.lang.ArrayIndexOutOfBoundsException -> L32
            int r4 = r9.compare(r3, r4)
            if (r4 != 0) goto L30
            return r6
        L30:
            r4 = r5
            goto L1c
        L32:
            r7 = move-exception
            java.util.NoSuchElementException r8 = new java.util.NoSuchElementException
            java.lang.String r7 = r7.getMessage()
            r8.<init>(r7)
            throw r8
        L3d:
            int r2 = r2 + 1
            goto L17
        L40:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.Util.hasIntersection(java.lang.String[], java.lang.String[], java.util.Comparator):boolean");
    }

    public static final long headersContentLength(Response response) {
        i.f(response, "<this>");
        String str = response.headers().get("Content-Length");
        if (str != null) {
            return toLongOrDefault(str, -1L);
        }
        return -1L;
    }

    public static final void ignoreIoExceptions(a aVar) {
        i.f(aVar, "block");
        try {
            aVar.invoke();
        } catch (IOException unused) {
        }
    }

    @SafeVarargs
    public static final <T> List<T> immutableListOf(T... tArr) {
        i.f(tArr, "elements");
        Object[] objArr = (Object[]) tArr.clone();
        List<T> listUnmodifiableList = Collections.unmodifiableList(j.y(Arrays.copyOf(objArr, objArr.length)));
        i.e(listUnmodifiableList, "unmodifiableList(listOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int indexOf(String[] strArr, String str, Comparator<String> comparator) {
        i.f(strArr, "<this>");
        i.f(str, "value");
        i.f(comparator, "comparator");
        int length = strArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            if (comparator.compare(strArr[i5], str) == 0) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfControlOrNonAscii(String str) {
        i.f(str, "<this>");
        int length = str.length();
        for (int i5 = 0; i5 < length; i5++) {
            char cCharAt = str.charAt(i5);
            if (i.h(cCharAt, 31) <= 0 || i.h(cCharAt, 127) >= 0) {
                return i5;
            }
        }
        return -1;
    }

    public static final int indexOfFirstNonAsciiWhitespace(String str, int i5, int i6) {
        i.f(str, "<this>");
        while (i5 < i6) {
            char cCharAt = str.charAt(i5);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static /* synthetic */ int indexOfFirstNonAsciiWhitespace$default(String str, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = str.length();
        }
        return indexOfFirstNonAsciiWhitespace(str, i5, i6);
    }

    public static final int indexOfLastNonAsciiWhitespace(String str, int i5, int i6) {
        i.f(str, "<this>");
        int i7 = i6 - 1;
        if (i5 <= i7) {
            while (true) {
                char cCharAt = str.charAt(i7);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i7 + 1;
                }
                if (i7 == i5) {
                    break;
                }
                i7--;
            }
        }
        return i5;
    }

    public static /* synthetic */ int indexOfLastNonAsciiWhitespace$default(String str, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = str.length();
        }
        return indexOfLastNonAsciiWhitespace(str, i5, i6);
    }

    public static final int indexOfNonWhitespace(String str, int i5) {
        i.f(str, "<this>");
        int length = str.length();
        while (i5 < length) {
            char cCharAt = str.charAt(i5);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i5;
            }
            i5++;
        }
        return str.length();
    }

    public static /* synthetic */ int indexOfNonWhitespace$default(String str, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = 0;
        }
        return indexOfNonWhitespace(str, i5);
    }

    public static final String[] intersect(String[] strArr, String[] strArr2, Comparator<? super String> comparator) {
        i.f(strArr, "<this>");
        i.f(strArr2, "other");
        i.f(comparator, "comparator");
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i5]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i5++;
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    public static final boolean isCivilized(FileSystem fileSystem, File file) throws IOException {
        i.f(fileSystem, "<this>");
        i.f(file, "file");
        D dSink = fileSystem.sink(file);
        try {
            fileSystem.delete(file);
            AbstractC0399v1.b(dSink, null);
            return true;
        } catch (IOException unused) {
            AbstractC0399v1.b(dSink, null);
            fileSystem.delete(file);
            return false;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AbstractC0399v1.b(dSink, th);
                throw th2;
            }
        }
    }

    public static final boolean isHealthy(Socket socket, n nVar) throws SocketException {
        i.f(socket, "<this>");
        i.f(nVar, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z4 = !nVar.y();
                socket.setSoTimeout(soTimeout);
                return z4;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final boolean isSensitiveHeader(String str) {
        i.f(str, "name");
        return str.equalsIgnoreCase("Authorization") || str.equalsIgnoreCase("Cookie") || str.equalsIgnoreCase("Proxy-Authorization") || str.equalsIgnoreCase("Set-Cookie");
    }

    public static final void notify(Object obj) {
        i.f(obj, "<this>");
        obj.notify();
    }

    public static final void notifyAll(Object obj) {
        i.f(obj, "<this>");
        obj.notifyAll();
    }

    public static final int parseHexDigit(char c2) {
        if ('0' <= c2 && c2 < ':') {
            return c2 - '0';
        }
        if ('a' <= c2 && c2 < 'g') {
            return c2 - 'W';
        }
        if ('A' > c2 || c2 >= 'G') {
            return -1;
        }
        return c2 - '7';
    }

    public static final String peerName(Socket socket) {
        i.f(socket, "<this>");
        SocketAddress remoteSocketAddress = socket.getRemoteSocketAddress();
        if (!(remoteSocketAddress instanceof InetSocketAddress)) {
            return remoteSocketAddress.toString();
        }
        String hostName = ((InetSocketAddress) remoteSocketAddress).getHostName();
        i.e(hostName, "address.hostName");
        return hostName;
    }

    public static final Charset readBomAsCharset(n nVar, Charset charset) throws IOException {
        Charset charsetForName;
        i.f(nVar, "<this>");
        i.f(charset, "default");
        int iR = nVar.r(UNICODE_BOMS);
        if (iR == -1) {
            return charset;
        }
        if (iR == 0) {
            Charset charset2 = StandardCharsets.UTF_8;
            i.e(charset2, "UTF_8");
            return charset2;
        }
        if (iR == 1) {
            Charset charset3 = StandardCharsets.UTF_16BE;
            i.e(charset3, "UTF_16BE");
            return charset3;
        }
        if (iR == 2) {
            Charset charset4 = StandardCharsets.UTF_16LE;
            i.e(charset4, "UTF_16LE");
            return charset4;
        }
        if (iR == 3) {
            Charset charset5 = M3.a.f1740a;
            charsetForName = M3.a.f1742c;
            if (charsetForName == null) {
                charsetForName = Charset.forName("UTF-32BE");
                i.e(charsetForName, "forName(\"UTF-32BE\")");
                M3.a.f1742c = charsetForName;
            }
        } else {
            if (iR != 4) {
                throw new AssertionError();
            }
            Charset charset6 = M3.a.f1740a;
            charsetForName = M3.a.f1741b;
            if (charsetForName == null) {
                charsetForName = Charset.forName("UTF-32LE");
                i.e(charsetForName, "forName(\"UTF-32LE\")");
                M3.a.f1741b = charsetForName;
            }
        }
        return charsetForName;
    }

    public static final <T> T readFieldOrNull(Object obj, Class<T> cls, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        T tCast;
        Object fieldOrNull;
        i.f(obj, "instance");
        i.f(cls, "fieldType");
        i.f(str, "fieldName");
        Class<?> superclass = obj.getClass();
        while (true) {
            tCast = null;
            if (superclass.equals(Object.class)) {
                if (str.equals("delegate") || (fieldOrNull = readFieldOrNull(obj, Object.class, "delegate")) == null) {
                    return null;
                }
                return (T) readFieldOrNull(fieldOrNull, cls, str);
            }
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                Object obj2 = declaredField.get(obj);
                if (!cls.isInstance(obj2)) {
                    break;
                }
                tCast = cls.cast(obj2);
                break;
            } catch (NoSuchFieldException unused) {
                superclass = superclass.getSuperclass();
                i.e(superclass, "c.superclass");
            }
        }
        return tCast;
    }

    public static final int readMedium(n nVar) throws IOException {
        i.f(nVar, "<this>");
        return and(nVar.U(), 255) | (and(nVar.U(), 255) << 16) | (and(nVar.U(), 255) << 8);
    }

    public static final boolean skipAll(F f5, int i5, TimeUnit timeUnit) throws IOException {
        i.f(f5, "<this>");
        i.f(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jDeadlineNanoTime = f5.timeout().hasDeadline() ? f5.timeout().deadlineNanoTime() - jNanoTime : Long.MAX_VALUE;
        f5.timeout().deadlineNanoTime(Math.min(jDeadlineNanoTime, timeUnit.toNanos(i5)) + jNanoTime);
        try {
            W3.l lVar = new W3.l();
            while (f5.read(lVar, 8192L) != -1) {
                lVar.a();
            }
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                f5.timeout().clearDeadline();
            } else {
                f5.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                f5.timeout().clearDeadline();
            } else {
                f5.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            return false;
        } catch (Throwable th) {
            if (jDeadlineNanoTime == Long.MAX_VALUE) {
                f5.timeout().clearDeadline();
            } else {
                f5.timeout().deadlineNanoTime(jNanoTime + jDeadlineNanoTime);
            }
            throw th;
        }
    }

    public static final ThreadFactory threadFactory(final String str, final boolean z4) {
        i.f(str, "name");
        return new ThreadFactory() { // from class: V3.a
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                return Util.threadFactory$lambda$1(str, z4, runnable);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Thread threadFactory$lambda$1(String str, boolean z4, Runnable runnable) {
        i.f(str, "$name");
        Thread thread = new Thread(runnable, str);
        thread.setDaemon(z4);
        return thread;
    }

    public static final void threadName(String str, a aVar) {
        i.f(str, "name");
        i.f(aVar, "block");
        Thread threadCurrentThread = Thread.currentThread();
        String name = threadCurrentThread.getName();
        threadCurrentThread.setName(str);
        try {
            aVar.invoke();
        } finally {
            threadCurrentThread.setName(name);
        }
    }

    public static final List<Header> toHeaderList(Headers headers) {
        i.f(headers, "<this>");
        c cVarJ = b.j(0, headers.size());
        ArrayList arrayList = new ArrayList(k.A(cVarJ));
        Iterator it = cVarJ.iterator();
        while (((J3.b) it).f1480l) {
            int iA = ((J3.b) it).a();
            arrayList.add(new Header(headers.name(iA), headers.value(iA)));
        }
        return arrayList;
    }

    public static final Headers toHeaders(List<Header> list) {
        i.f(list, "<this>");
        Headers.Builder builder = new Headers.Builder();
        for (Header header : list) {
            builder.addLenient$okhttp(header.component1().j(), header.component2().j());
        }
        return builder.build();
    }

    public static final String toHexString(long j5) {
        String hexString = Long.toHexString(j5);
        i.e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final String toHostHeader(HttpUrl httpUrl, boolean z4) {
        String strHost;
        i.f(httpUrl, "<this>");
        if (e.z(httpUrl.host(), ":")) {
            strHost = "[" + httpUrl.host() + ']';
        } else {
            strHost = httpUrl.host();
        }
        if (!z4 && httpUrl.port() == HttpUrl.Companion.defaultPort(httpUrl.scheme())) {
            return strHost;
        }
        return strHost + ':' + httpUrl.port();
    }

    public static /* synthetic */ String toHostHeader$default(HttpUrl httpUrl, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        return toHostHeader(httpUrl, z4);
    }

    public static final <T> List<T> toImmutableList(List<? extends T> list) {
        i.f(list, "<this>");
        List<T> listUnmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        i.e(listUnmodifiableList, "unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final <K, V> Map<K, V> toImmutableMap(Map<K, ? extends V> map) {
        i.f(map, "<this>");
        if (map.isEmpty()) {
            return r.f9712j;
        }
        Map<K, V> mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        i.e(mapUnmodifiableMap, "{\n    Collections.unmodi…(LinkedHashMap(this))\n  }");
        return mapUnmodifiableMap;
    }

    public static final long toLongOrDefault(String str, long j5) {
        i.f(str, "<this>");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j5;
        }
    }

    public static final int toNonNegativeInt(String str, int i5) throws NumberFormatException {
        if (str != null) {
            try {
                long j5 = Long.parseLong(str);
                if (j5 > 2147483647L) {
                    return Integer.MAX_VALUE;
                }
                if (j5 < 0) {
                    return 0;
                }
                return (int) j5;
            } catch (NumberFormatException unused) {
            }
        }
        return i5;
    }

    public static final String trimSubstring(String str, int i5, int i6) {
        i.f(str, "<this>");
        int iIndexOfFirstNonAsciiWhitespace = indexOfFirstNonAsciiWhitespace(str, i5, i6);
        String strSubstring = str.substring(iIndexOfFirstNonAsciiWhitespace, indexOfLastNonAsciiWhitespace(str, iIndexOfFirstNonAsciiWhitespace, i6));
        i.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static /* synthetic */ String trimSubstring$default(String str, int i5, int i6, int i7, Object obj) {
        if ((i7 & 1) != 0) {
            i5 = 0;
        }
        if ((i7 & 2) != 0) {
            i6 = str.length();
        }
        return trimSubstring(str, i5, i6);
    }

    public static final void wait(Object obj) throws InterruptedException {
        i.f(obj, "<this>");
        obj.wait();
    }

    public static final Throwable withSuppressed(Exception exc, List<? extends Exception> list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        i.f(exc, "<this>");
        i.f(list, "suppressed");
        Iterator<? extends Exception> it = list.iterator();
        while (it.hasNext()) {
            b.b(exc, it.next());
        }
        return exc;
    }

    public static final void writeMedium(W3.m mVar, int i5) throws IOException {
        i.f(mVar, "<this>");
        mVar.A((i5 >>> 16) & 255);
        mVar.A((i5 >>> 8) & 255);
        mVar.A(i5 & 255);
    }

    public static final int and(short s4, int i5) {
        return s4 & i5;
    }

    public static final int delimiterOffset(String str, char c2, int i5, int i6) {
        i.f(str, "<this>");
        while (i5 < i6) {
            if (str.charAt(i5) == c2) {
                return i5;
            }
            i5++;
        }
        return i6;
    }

    public static /* synthetic */ int delimiterOffset$default(String str, char c2, int i5, int i6, int i7, Object obj) {
        if ((i7 & 2) != 0) {
            i5 = 0;
        }
        if ((i7 & 4) != 0) {
            i6 = str.length();
        }
        return delimiterOffset(str, c2, i5, i6);
    }

    public static final String toHexString(int i5) {
        String hexString = Integer.toHexString(i5);
        i.e(hexString, "toHexString(this)");
        return hexString;
    }

    public static final long and(int i5, long j5) {
        return i5 & j5;
    }

    public static final void closeQuietly(Socket socket) throws IOException {
        i.f(socket, "<this>");
        try {
            socket.close();
        } catch (AssertionError e5) {
            throw e5;
        } catch (RuntimeException e6) {
            if (!i.a(e6.getMessage(), "bio == null")) {
                throw e6;
            }
        } catch (Exception unused) {
        }
    }

    public static final void closeQuietly(ServerSocket serverSocket) throws IOException {
        i.f(serverSocket, "<this>");
        try {
            serverSocket.close();
        } catch (RuntimeException e5) {
            throw e5;
        } catch (Exception unused) {
        }
    }

    public static final int skipAll(W3.l lVar, byte b5) throws EOFException {
        i.f(lVar, "<this>");
        int i5 = 0;
        while (!lVar.y() && lVar.x(0L) == b5) {
            i5++;
            lVar.U();
        }
        return i5;
    }
}
