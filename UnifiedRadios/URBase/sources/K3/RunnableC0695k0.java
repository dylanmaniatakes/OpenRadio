package k3;

import android.util.Log;
import com.unified.ur1.rfmodule.RadioAudioService;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* renamed from: k3.k0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0695k0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ boolean f8148j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ boolean f8149k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f8150l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ RunnableC0697l0 f8151m;

    public RunnableC0695k0(RunnableC0697l0 runnableC0697l0, boolean z4, boolean z5, boolean z6) {
        this.f8151m = runnableC0697l0;
        this.f8148j = z4;
        this.f8149k = z5;
        this.f8150l = z6;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        String str;
        RadioAudioService radioAudioService = this.f8151m.f8163t.f8021k.f5965u;
        if (radioAudioService == null || (i5 = radioAudioService.f6086f) == -1 || i5 == 2) {
            return;
        }
        radioAudioService.f6086f = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8148j ? "1" : "0");
        sb.append(this.f8149k ? "1" : "0");
        sb.append(this.f8150l ? "1" : "0");
        String string = sb.toString();
        byte[] bArr = RadioAudioService.f6081m;
        byte[] bArr2 = {bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7], 4};
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[string.length() + 9]);
        byteBufferWrap.put(bArr2);
        byteBufferWrap.put(string.getBytes(StandardCharsets.US_ASCII));
        byteBufferWrap.array();
        StringBuilder sb2 = new StringBuilder("Sent command: ");
        switch (4) {
            case 1:
                str = "PTT_DOWN";
                break;
            case 2:
                str = "PTT_UP";
                break;
            case 3:
                str = "TUNE_TO";
                break;
            case 4:
                str = "FILTERS";
                break;
            case 5:
                str = "STOP";
                break;
            case 6:
                str = "GET_FIRMWARE_VER";
                break;
            case 7:
                str = "POWER_ON";
                break;
            default:
                str = "null";
                break;
        }
        sb2.append(str);
        sb2.append(" params: ");
        sb2.append(string);
        Log.d("Unified", sb2.toString());
    }
}
