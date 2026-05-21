package m3;

import android.util.Log;
import com.hebs.dmrserial.jni.SerialPort;
import e1.RunnableC0433a;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Thread;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: m3.B, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0764B {
    public static C0764B h = null;

    /* renamed from: i, reason: collision with root package name */
    public static volatile boolean f8559i = false;

    /* renamed from: a, reason: collision with root package name */
    public SerialPort f8560a;

    /* renamed from: b, reason: collision with root package name */
    public FileInputStream f8561b;

    /* renamed from: c, reason: collision with root package name */
    public FileOutputStream f8562c;

    /* renamed from: d, reason: collision with root package name */
    public final ReentrantLock f8563d = new ReentrantLock();

    /* renamed from: e, reason: collision with root package name */
    public boolean f8564e = false;

    /* renamed from: f, reason: collision with root package name */
    public final ReentrantLock f8565f = new ReentrantLock();
    public SerialPort g;

    static {
        Runtime.getRuntime().addShutdownHook(new Thread(new RunnableC0433a(5)));
    }

    public C0764B() {
        Log.d("SerialPort", "SerialPortManager instance created");
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: m3.A
            @Override // java.lang.Thread.UncaughtExceptionHandler
            public final void uncaughtException(Thread thread, Throwable th) {
                C0764B c0764b = this.f8558a;
                c0764b.getClass();
                Log.e("SerialPort", "Uncaught exception - initiating emergency cleanup", th);
                c0764b.d();
                if (Thread.getDefaultUncaughtExceptionHandler() != null) {
                    Thread.getDefaultUncaughtExceptionHandler().uncaughtException(thread, th);
                }
            }
        });
    }

    public static String b(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b5 : bArr) {
            sb.append(String.format("%02X", Byte.valueOf(b5)));
        }
        return sb.toString();
    }

    public static synchronized C0764B e() {
        try {
            if (h == null && !f8559i) {
                Log.d("SerialPort", "Creating new SerialPortManager instance");
                h = new C0764B();
            }
        } catch (Throwable th) {
            throw th;
        }
        return h;
    }

    public final int a() {
        ReentrantLock reentrantLock = this.f8563d;
        reentrantLock.lock();
        try {
            if (this.f8564e) {
                return this.f8561b.available();
            }
            Log.e("SerialPort", "Available check failed: Control port not initialized");
            throw new IOException("Control port not initialized");
        } finally {
            reentrantLock.unlock();
        }
    }

    public final synchronized void c() {
        Log.d("SerialPort", "Starting control port cleanup process");
        this.f8563d.lock();
        try {
            if (this.f8560a != null) {
                try {
                    try {
                        FileOutputStream fileOutputStream = this.f8562c;
                        if (fileOutputStream != null) {
                            fileOutputStream.flush();
                            this.f8562c.close();
                        }
                        FileInputStream fileInputStream = this.f8561b;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        this.f8560a.close();
                        this.f8560a = null;
                        this.f8561b = null;
                    } catch (Exception e5) {
                        Log.e("SerialPort", "Error cleaning up control port", e5);
                        this.f8560a = null;
                        this.f8561b = null;
                    }
                    this.f8562c = null;
                } catch (Throwable th) {
                    this.f8560a = null;
                    this.f8561b = null;
                    this.f8562c = null;
                    throw th;
                }
            }
            this.f8564e = false;
            Log.i("SerialPort", "Control port cleanup completed");
        } finally {
            this.f8563d.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r11 = this;
            java.lang.String r0 = "Force cleanup completed"
            java.util.concurrent.locks.ReentrantLock r1 = r11.f8565f
            java.util.concurrent.locks.ReentrantLock r2 = r11.f8563d
            java.lang.String r3 = "SerialPort"
            java.lang.String r4 = "Force cleanup initiated"
            android.util.Log.i(r3, r4)
            r4 = 0
            boolean r5 = r2.tryLock()     // Catch: java.lang.Throwable -> L87 java.lang.Exception -> L8c
            boolean r6 = r1.tryLock()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L82
            com.hebs.dmrserial.jni.SerialPort r7 = r11.f8560a     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            r8 = 0
            if (r7 == 0) goto L55
            java.io.FileOutputStream r7 = r11.f8562c     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            if (r7 == 0) goto L2c
            r7.flush()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            java.io.FileOutputStream r7 = r11.f8562c     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r7.close()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            goto L2c
        L28:
            r4 = move-exception
            goto L4e
        L2a:
            r7 = move-exception
            goto L44
        L2c:
            java.io.FileInputStream r7 = r11.f8561b     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            if (r7 == 0) goto L33
            r7.close()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
        L33:
            com.hebs.dmrserial.jni.SerialPort r7 = r11.f8560a     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r7.close()     // Catch: java.lang.Throwable -> L28 java.lang.Exception -> L2a
            r11.f8560a = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            r11.f8561b = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
        L3c:
            r11.f8562c = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            goto L55
        L3f:
            r4 = move-exception
            goto L9e
        L42:
            r4 = move-exception
            goto L90
        L44:
            java.lang.String r9 = "Error closing control port"
            android.util.Log.e(r3, r9, r7)     // Catch: java.lang.Throwable -> L28
            r11.f8560a = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            r11.f8561b = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            goto L3c
        L4e:
            r11.f8560a = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            r11.f8561b = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            r11.f8562c = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            throw r4     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
        L55:
            com.hebs.dmrserial.jni.SerialPort r7 = r11.g     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            if (r7 == 0) goto L6b
            r7.close()     // Catch: java.lang.Throwable -> L5f java.lang.Exception -> L61
        L5c:
            r11.g = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            goto L6b
        L5f:
            r4 = move-exception
            goto L68
        L61:
            r7 = move-exception
            java.lang.String r9 = "Error closing audio port"
            android.util.Log.e(r3, r9, r7)     // Catch: java.lang.Throwable -> L5f
            goto L5c
        L68:
            r11.g = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            throw r4     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
        L6b:
            r11.f8564e = r4     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            m3.C0764B.h = r8     // Catch: java.lang.Throwable -> L3f java.lang.Exception -> L42
            if (r5 == 0) goto L74
            r2.unlock()
        L74:
            if (r6 == 0) goto L79
        L76:
            r1.unlock()
        L79:
            android.util.Log.i(r3, r0)
            goto L9d
        L7d:
            r6 = move-exception
            r10 = r6
            r6 = r4
            r4 = r10
            goto L9e
        L82:
            r6 = move-exception
            r10 = r6
            r6 = r4
            r4 = r10
            goto L90
        L87:
            r5 = move-exception
            r6 = r4
            r4 = r5
            r5 = r6
            goto L9e
        L8c:
            r5 = move-exception
            r6 = r4
            r4 = r5
            r5 = r6
        L90:
            java.lang.String r7 = "Error during force cleanup"
            android.util.Log.e(r3, r7, r4)     // Catch: java.lang.Throwable -> L3f
            if (r5 == 0) goto L9a
            r2.unlock()
        L9a:
            if (r6 == 0) goto L79
            goto L76
        L9d:
            return
        L9e:
            if (r5 == 0) goto La3
            r2.unlock()
        La3:
            if (r6 == 0) goto La8
            r1.unlock()
        La8:
            android.util.Log.i(r3, r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: m3.C0764B.d():void");
    }

    public final synchronized boolean f() {
        if (this.f8564e) {
            Log.d("SerialPort", "Control port already initialized");
            return true;
        }
        Log.d("SerialPort", String.format("Initializing control port: path=%s, baudRate=%d", "/dev/ttyS1", 57600));
        try {
            this.f8560a = new SerialPort("/dev/ttyS1", 57600, 2);
            this.g = new SerialPort("/dev/ttyS0", 230400, 2);
            if (this.f8560a == null) {
                Log.e("SerialPort", "Critical error: Failed to create control port instance");
                return false;
            }
            Log.d("SerialPort", "Control port instance created successfully");
            SerialPort serialPort = this.f8560a;
            FileInputStream fileInputStream = serialPort.f5553a;
            this.f8561b = fileInputStream;
            FileOutputStream fileOutputStream = serialPort.f5554b;
            this.f8562c = fileOutputStream;
            if (fileInputStream != null && fileOutputStream != null) {
                Log.d("SerialPort", "Control port streams initialized successfully");
                int iAvailable = this.f8561b.available();
                if (iAvailable > 0) {
                    Log.d("SerialPort", "Clearing " + iAvailable + " bytes from control input buffer");
                    this.f8561b.skip((long) iAvailable);
                }
                this.f8564e = true;
                Log.i("SerialPort", "Control port initialization completed successfully");
                return true;
            }
            StringBuilder sb = new StringBuilder("Control stream initialization failed - inputStream: ");
            sb.append(this.f8561b == null ? "null" : "valid");
            sb.append(", outputStream: ");
            sb.append(this.f8562c == null ? "null" : "valid");
            Log.e("SerialPort", sb.toString());
            c();
            return false;
        } catch (Exception e5) {
            Log.e("SerialPort", "Control port initialization failed", e5);
            c();
            return false;
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (!f8559i) {
                Log.i("SerialPort", "Finalizer called - ensuring cleanup");
                d();
            }
        } finally {
            super.finalize();
        }
    }

    public final byte[] g(int i5) {
        Log.d("SerialPort", "Attempting to read up to " + i5 + " bytes from control port");
        ReentrantLock reentrantLock = this.f8563d;
        reentrantLock.lock();
        try {
            if (!this.f8564e) {
                Log.e("SerialPort", "Read failed: Control port not initialized");
                throw new IOException("Control port not initialized");
            }
            byte[] bArr = new byte[i5];
            int i6 = this.f8561b.read(bArr);
            Log.d("SerialPort", "Control port read operation returned: " + i6 + " bytes");
            if (i6 <= 0) {
                Log.d("SerialPort", "No data available to read from control port");
                return new byte[0];
            }
            byte[] bArr2 = new byte[i6];
            System.arraycopy(bArr, 0, bArr2, 0, i6);
            Log.d("SerialPort", "Read data from control port: " + b(bArr2));
            return bArr2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void h(byte[] bArr) throws IOException {
        FileOutputStream fileOutputStream;
        SerialPort serialPort = this.f8560a;
        if (serialPort == null || (fileOutputStream = serialPort.f5554b) == null) {
            throw new IOException("Control port not initialized");
        }
        fileOutputStream.write(bArr);
        this.f8560a.f5554b.flush();
    }
}
