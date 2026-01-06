package m3;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import okhttp3.internal.http2.Settings;
import q3.AbstractC0869a;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final Handler f8629a;

    /* renamed from: b, reason: collision with root package name */
    public final InputStream f8630b;

    /* renamed from: c, reason: collision with root package name */
    public final OutputStream f8631c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f8632d;

    /* renamed from: e, reason: collision with root package name */
    public final StringBuffer f8633e = new StringBuffer();

    public s(W3.j jVar, W3.k kVar, Handler handler) {
        this.f8632d = true;
        this.f8630b = jVar;
        this.f8631c = kVar;
        this.f8632d = true;
        this.f8629a = handler;
    }

    public static byte[] g(byte[] bArr, C0774j c0774j) {
        byte[] bArr2 = new byte[2];
        int i5 = 0;
        for (byte b5 : bArr) {
            i5 = (C0774j.f8609b[(i5 >> 8) ^ (b5 & 255)] ^ (i5 << 8)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        }
        long j5 = i5;
        for (int i6 = 0; i6 < 2; i6++) {
            bArr2[1 - i6] = (byte) ((j5 >> (i6 * 8)) & 255);
        }
        return bArr2;
    }

    public final byte a() {
        while (this.f8632d) {
            InputStream inputStream = this.f8630b;
            if (inputStream != null && inputStream.available() > 0) {
                int i5 = inputStream.read();
                Log.i("TAG", " -- readByte --" + i5);
                return (byte) i5;
            }
            try {
                Thread.sleep(2L);
            } catch (InterruptedException e5) {
                try {
                    OutputStream outputStream = this.f8631c;
                    outputStream.write(24);
                    outputStream.flush();
                    OutputStream outputStream2 = this.f8631c;
                    outputStream2.write(24);
                    outputStream2.flush();
                } catch (IOException unused) {
                }
                throw new RuntimeException("Transmission was interrupted", e5);
            }
        }
        throw new IOException("read end");
    }

    public final void b() {
        byte[] bytes = "1".getBytes();
        OutputStream outputStream = this.f8631c;
        outputStream.write(bytes);
        outputStream.flush();
        Log.i("TAG", " -- send1 in ---");
        boolean z4 = true;
        while (z4) {
            byte[] bArr = new byte[1024];
            int i5 = this.f8630b.read(bArr);
            if (i5 > 0) {
                byte[] bArr2 = new byte[i5];
                System.arraycopy(bArr, 0, bArr2, 0, i5);
                String strD = AbstractC0869a.d(bArr2);
                Log.i("TAG", " -- send1 recHex ---" + strD);
                if (strD.startsWith("FE434343") || strD.contains("434343")) {
                    z4 = false;
                }
                StringBuffer stringBuffer = this.f8633e;
                stringBuffer.append(strD);
                String string = stringBuffer.toString();
                Log.i("TAG", " -- send1 recData ---" + string);
                if (string.startsWith("FE43434343") || string.contains("43434343")) {
                    z4 = false;
                }
            }
        }
        Log.i("TAG", " -- send1 out ---");
    }

    public final void c(DataInputStream dataInputStream, C0774j c0774j, byte[] bArr) {
        int i5;
        byte bA;
        int i6 = 1;
        while (true) {
            int i7 = dataInputStream.read(bArr);
            if (i7 != -1) {
                i5 = i6 + 1;
                Message message = new Message();
                Bundle bundle = new Bundle();
                bundle.putInt("blockNumber", i6);
                message.setData(bundle);
                this.f8629a.sendMessage(message);
                if (i7 < bArr.length) {
                    bArr[i7] = 26;
                }
                int i8 = 0;
                while (i8 < 10) {
                    byte[] bArrF = A2.b.f(A2.b.h(AbstractC0869a.e(i6)[3], bArr.length == 1024 ? (byte) 2 : (byte) 1), bArr, g(bArr, c0774j));
                    OutputStream outputStream = this.f8631c;
                    outputStream.write(bArrF);
                    outputStream.flush();
                    Log.i("TAG", " -- fileData -- " + i6 + " ; " + AbstractC0869a.d(bArrF));
                    try {
                        bA = a();
                    } catch (Exception unused) {
                        i8++;
                    }
                    if (bA == 6) {
                        break;
                    }
                    if (bA == 21) {
                        i8++;
                        Log.i("TAG", " -- readByte NAK ---");
                        f();
                    } else {
                        if (bA != 67) {
                            if (bA != 24) {
                                throw new IOException("Transmission terminated");
                            }
                            throw new IOException("Transmission terminated");
                        }
                        i8++;
                        Log.i("TAG", " -- readByte ST_C ---");
                        f();
                    }
                }
                throw new IOException("Too many errors caught, abandoning transfer");
            }
            return;
            Log.i("TAG", " -- readByte ACK ---");
            f();
            i6 = i5;
        }
    }

    public final void d(byte[] bArr, C0774j c0774j) {
        byte bA;
        if (128 < bArr.length) {
            bArr[128] = 26;
        }
        int i5 = 0;
        while (i5 < 10) {
            byte[] bArrF = A2.b.f(A2.b.h(AbstractC0869a.e(0)[3], bArr.length == 1024 ? (byte) 2 : (byte) 1), bArr, g(bArr, c0774j));
            OutputStream outputStream = this.f8631c;
            outputStream.write(bArrF);
            outputStream.flush();
            Log.i("fhf", " -- sendFileInfo -- 0 ; " + AbstractC0869a.d(bArrF));
            boolean z4 = false;
            while (true) {
                try {
                    bA = a();
                    Log.i("TAG", " -- character ---" + ((int) bA));
                    if (bA != 6) {
                        break;
                    }
                    Log.i("TAG", " -- readByte ACK ---");
                    z4 = true;
                } catch (Exception unused) {
                    i5++;
                }
            }
            if (bA == 21) {
                i5++;
                f();
                Log.i("TAG", " -- readByte NAK ---");
            } else {
                if (bA != 67) {
                    if (bA != 24) {
                        throw new IOException("Transmission terminated");
                    }
                    throw new IOException("Transmission terminated");
                }
                Log.i("TAG", " -- readByte ST_C ---");
                if (z4) {
                    f();
                    return;
                } else {
                    i5++;
                    f();
                }
            }
        }
        throw new IOException("Too many errors caught, abandoning transfer");
    }

    public final void e() {
        byte bA;
        for (int i5 = 0; i5 < 6; i5++) {
            byte[] bArr = new byte[128];
            byte[] bArrH = A2.b.h((byte) 0, (byte) 1);
            byte[] bArr2 = new byte[2];
            int i6 = 0;
            for (int i7 = 0; i7 < 128; i7++) {
                i6 = (C0774j.f8609b[(i6 >> 8) ^ (bArr[i7] & 255)] ^ (i6 << 8)) & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            }
            long j5 = i6;
            for (int i8 = 0; i8 < 2; i8++) {
                bArr2[1 - i8] = (byte) ((j5 >> (i8 * 8)) & 255);
            }
            byte[] bArrF = A2.b.f(bArrH, bArr, bArr2);
            OutputStream outputStream = this.f8631c;
            outputStream.write(bArrF);
            outputStream.flush();
            try {
                bA = a();
            } catch (Exception unused) {
            }
            if (bA == 6) {
                return;
            }
            if (bA == 24) {
                throw new IOException("Transmission terminated");
            }
        }
    }

    public final void f() throws InterruptedException, IOException {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e5) {
            try {
                OutputStream outputStream = this.f8631c;
                outputStream.write(24);
                outputStream.flush();
                OutputStream outputStream2 = this.f8631c;
                outputStream2.write(24);
                outputStream2.flush();
            } catch (IOException unused) {
            }
            throw new RuntimeException("Transmission was interrupted", e5);
        }
    }
}
