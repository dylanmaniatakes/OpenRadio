package m3;

import android.content.Context;
import android.os.HandlerThread;
import android.util.Log;
import com.hebs.dmrserial.jni.SerialPort;
import com.unified.ur1.primary.LaunchActivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import q3.AbstractC0869a;

/* renamed from: m3.k, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerThreadC0775k extends HandlerThread {

    /* renamed from: o, reason: collision with root package name */
    public static HandlerThreadC0775k f8611o;

    /* renamed from: j, reason: collision with root package name */
    public SerialPort f8612j;

    /* renamed from: k, reason: collision with root package name */
    public StringBuffer f8613k;

    /* renamed from: l, reason: collision with root package name */
    public Hashtable f8614l;

    /* renamed from: m, reason: collision with root package name */
    public volatile boolean f8615m;
    public volatile boolean n;

    public static HandlerThreadC0775k a() {
        if (f8611o == null) {
            HandlerThreadC0775k handlerThreadC0775k = new HandlerThreadC0775k("DmrThread_DMRContext", 1000);
            handlerThreadC0775k.f8613k = new StringBuffer();
            handlerThreadC0775k.f8614l = new Hashtable();
            handlerThreadC0775k.f8615m = false;
            handlerThreadC0775k.n = false;
            try {
                Context context = LaunchActivity.f5853D1;
                handlerThreadC0775k.f8612j = new SerialPort("/dev/ttyS1", 57600, 0);
                Log.d("DMR Context", "Serial port initialized successfully");
            } catch (Exception e5) {
                Log.e("DMR Context", "Failed to initialize serial port", e5);
            }
            f8611o = handlerThreadC0775k;
        }
        return f8611o;
    }

    public static void b(String str) {
        if (str.length() > 36) {
            Z3.c cVar = Z3.c.h;
            if (cVar == null) {
                synchronized (Z3.c.class) {
                    try {
                        cVar = Z3.c.h;
                        if (cVar == null) {
                            cVar = new Z3.c();
                            Z3.c.h = cVar;
                        }
                    } finally {
                    }
                }
            }
            ExecutorService executorServiceNewCachedThreadPool = Executors.newCachedThreadPool();
            executorServiceNewCachedThreadPool.execute(new D.m(new L0.m(executorServiceNewCachedThreadPool, cVar), 12, new D0.p(18, str)));
        }
    }

    public final void c() {
        StringBuilder sb = new StringBuilder("Active listeners: ");
        Iterator it = this.f8614l.keySet().iterator();
        while (it.hasNext()) {
            sb.append((String) it.next());
            sb.append(", ");
        }
        Log.d("DMR Context", sb.toString());
    }

    public final void d(String str) {
        Log.d("DMR Context", "Processing received data: " + str);
        boolean zStartsWith = str.startsWith("682");
        StringBuffer stringBuffer = this.f8613k;
        if ((zStartsWith || str.startsWith("683")) && str.endsWith("10")) {
            f(str);
            stringBuffer.delete(0, stringBuffer.length());
            return;
        }
        if (stringBuffer.length() <= 0 && !str.startsWith("BFAABB")) {
            Log.d("DMR Context", "Discarding invalid data: ".concat(str));
            return;
        }
        stringBuffer.append(str);
        String string = stringBuffer.toString();
        if (string.equals("BFAABBFAB3F5CABCBBAFCDEAB3C90D0A00")) {
            Log.d("DMR Context", "Power-on sequence detected");
            stringBuffer.delete(0, stringBuffer.length());
        } else if ((string.startsWith("682") || string.startsWith("683")) && string.endsWith("10")) {
            f(string);
            stringBuffer.delete(0, stringBuffer.length());
        }
    }

    public final void e() {
        byte[] bArr;
        int i5;
        try {
            FileInputStream fileInputStream = this.f8612j.f5553a;
            if (fileInputStream == null) {
                Log.d("DMR Context", "Serial port read unavailable");
                return;
            }
            if (fileInputStream.available() > 0 && (i5 = fileInputStream.read((bArr = new byte[1024]))) > 0) {
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, 0, bArr2, 0, i5);
                String strTrim = AbstractC0869a.d(bArr2).trim();
                Log.d("DMR Context", "⬇️ Raw received data: " + strTrim);
                d(strTrim);
            }
        } catch (Exception e5) {
            Log.e("DMR Context", "Error reading from serial port", e5);
        }
    }

    public final void f(String str) {
        try {
            D0.w wVar = new D0.w(str);
            String str2 = (String) wVar.f310c;
            Log.d("DMR Context", "Processing command response: " + str2 + ", data: " + str);
            if ("36".equals(str2)) {
                if ("6836020090B800010510".equals(str)) {
                    Log.d("DMR Context", "Received message notification");
                    return;
                }
            } else if ("2D".equals(str2)) {
                b(str);
            }
            Hashtable hashtable = this.f8614l;
            v vVar = (v) hashtable.get(str2);
            if (vVar == null) {
                Log.d("DMR Context", "No listener found for command: " + str2);
                c();
                return;
            }
            Log.d("DMR Context", "Executing listener for command: " + str2);
            vVar.a(wVar);
            hashtable.remove(str2);
        } catch (Exception e5) {
            Log.e("DMR Context", "Failed to process command response", e5);
        }
    }

    public final boolean g(String str) {
        if (this.f8615m) {
            try {
                Thread.sleep(50L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                return false;
            }
        }
        try {
            this.f8615m = true;
            Log.d("DMR Context", "⬆️ Sending serial data: " + str);
            byte[] bArrC = AbstractC0869a.c(str);
            FileOutputStream fileOutputStream = this.f8612j.f5554b;
            if (fileOutputStream == null) {
                Log.e("DMR Context", "DMR output stream unavailable");
                return false;
            }
            fileOutputStream.write(bArrC);
            fileOutputStream.flush();
            return true;
        } catch (IOException e5) {
            Log.e("DMR Context", "Failed to send command", e5);
            return false;
        } finally {
            this.f8615m = false;
        }
    }

    public final void h(String str, v vVar) {
        if (str != null) {
            Hashtable hashtable = this.f8614l;
            if (hashtable.containsKey(str)) {
                Log.w("DMR Context", "Replacing existing listener for command: ".concat(str));
            }
            Log.d("DMR Context", "Setting listener for command: ".concat(str));
            hashtable.put(str, vVar);
        }
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        try {
            try {
                Log.d("DMR Context", "Starting DMR read thread");
                this.n = true;
                while (this.n && !isInterrupted()) {
                    e();
                    Thread.sleep(10L);
                }
            } catch (Exception e5) {
                Log.e("DMR Context", "Serial port reception exception", e5);
            }
        } finally {
            this.n = false;
            Log.d("DMR Context", "DMR read thread stopped");
        }
    }
}
