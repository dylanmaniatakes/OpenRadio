package m3;

import android.os.HandlerThread;
import com.hebs.dmrserial.jni.SerialPort;
import com.unified.ur1.primary.LaunchActivity;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import q3.AbstractC0869a;

/* renamed from: m3.n, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class HandlerThreadC0778n extends HandlerThread {

    /* renamed from: m, reason: collision with root package name */
    public static HandlerThreadC0778n f8623m;

    /* renamed from: j, reason: collision with root package name */
    public SerialPort f8624j;

    /* renamed from: k, reason: collision with root package name */
    public StringBuffer f8625k;

    /* renamed from: l, reason: collision with root package name */
    public LaunchActivity f8626l;

    public static HandlerThreadC0778n b() {
        if (f8623m == null) {
            HandlerThreadC0778n handlerThreadC0778n = new HandlerThreadC0778n("DmrThread_Voice", 1000);
            handlerThreadC0778n.f8625k = new StringBuffer();
            handlerThreadC0778n.c();
            f8623m = handlerThreadC0778n;
        }
        return f8623m;
    }

    public final void a() {
        d3.a.a("Starting comprehensive DMR serial cleanup");
        try {
            interrupt();
            quit();
            StringBuffer stringBuffer = this.f8625k;
            if (stringBuffer != null) {
                stringBuffer.setLength(0);
                this.f8625k = null;
            }
            SerialPort serialPort = this.f8624j;
            if (serialPort != null) {
                try {
                    FileInputStream fileInputStream = serialPort.f5553a;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    FileOutputStream fileOutputStream = this.f8624j.f5554b;
                    if (fileOutputStream != null) {
                        fileOutputStream.flush();
                        this.f8624j.f5554b.close();
                    }
                    this.f8624j.close();
                    this.f8624j = null;
                } catch (IOException e5) {
                    d3.a.b("Error closing serial port streams", e5);
                }
            }
            this.f8626l = null;
            f8623m = null;
            d3.a.a("DMR serial cleanup completed successfully");
        } catch (Exception e6) {
            d3.a.b("Error during DMR serial cleanup", e6);
        }
    }

    public final void c() {
        try {
            this.f8624j = new SerialPort("/dev/ttyS0", 230400, 0);
            d3.a.a("Serial port initialized: /dev/ttyS0");
            SerialPort serialPort = this.f8624j;
            if (serialPort.f5554b != null && serialPort.f5553a != null) {
                d3.a.a("Serial streams opened successfully");
                return;
            }
            d3.a.b("Failed to open serial streams", new Object[0]);
        } catch (Exception e5) {
            d3.a.b("Failed to initialize serial port", e5);
        }
    }

    public final void d() throws IOException {
        FileInputStream fileInputStream = this.f8624j.f5553a;
        if (fileInputStream == null) {
            d3.a.b("Serial port read unavailable.", new Object[0]);
            return;
        }
        byte[] bArr = new byte[640];
        int i5 = fileInputStream.read(bArr);
        if (i5 <= 0) {
            return;
        }
        byte[] bArr2 = new byte[i5];
        System.arraycopy(bArr, 0, bArr2, 0, i5);
        String strTrim = AbstractC0869a.d(bArr2).trim();
        if (strTrim.startsWith("BB0000A0") && strTrim.length() >= 334) {
            this.f8626l.f0(strTrim);
            StringBuffer stringBuffer = this.f8625k;
            stringBuffer.delete(0, stringBuffer.length());
            return;
        }
        StringBuffer stringBuffer2 = this.f8625k;
        stringBuffer2.append(strTrim);
        String string = stringBuffer2.toString();
        if (string.startsWith("BB0000A0")) {
            if (string.length() >= 334) {
                this.f8626l.f0(string);
                StringBuffer stringBuffer3 = this.f8625k;
                stringBuffer3.delete(0, stringBuffer3.length());
                return;
            }
            return;
        }
        if (string.length() >= 8) {
            this.f8626l.f0(string);
            StringBuffer stringBuffer4 = this.f8625k;
            stringBuffer4.delete(0, stringBuffer4.length());
        }
    }

    public final boolean e(byte[] bArr) throws IOException {
        try {
            FileOutputStream fileOutputStream = this.f8624j.f5554b;
            if (fileOutputStream == null) {
                d3.a.b("DMR output stream unavailable.", new Object[0]);
                return false;
            }
            fileOutputStream.write(bArr);
            fileOutputStream.flush();
            return true;
        } catch (IOException e5) {
            d3.a.f6113a.m(6, e5, "System exception when sending command", new Object[0]);
            return true;
        }
    }

    @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
    public final void run() {
        while (!isInterrupted()) {
            try {
                d();
            } catch (Exception e5) {
                d3.a.f6113a.m(6, e5, "Voice serial port reception exception", new Object[0]);
                return;
            }
        }
    }
}
