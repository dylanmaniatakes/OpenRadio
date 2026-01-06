package m3;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.os.PowerManager;
import android.util.Log;
import com.unified.ur1.rfmodule.DmrDatabase;
import g0.AbstractC0535a;
import java.io.File;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/* renamed from: m3.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0768d {

    /* renamed from: a, reason: collision with root package name */
    public final ByteBuffer f8592a;

    /* renamed from: b, reason: collision with root package name */
    public final LinkedBlockingQueue f8593b;

    /* renamed from: c, reason: collision with root package name */
    public final byte[] f8594c;

    /* renamed from: d, reason: collision with root package name */
    public int f8595d;

    /* renamed from: e, reason: collision with root package name */
    public final AudioTrack f8596e;

    /* renamed from: f, reason: collision with root package name */
    public final AudioManager f8597f;
    public final PowerManager.WakeLock g;
    public final AtomicBoolean h;

    /* renamed from: i, reason: collision with root package name */
    public final AtomicBoolean f8598i;

    /* renamed from: j, reason: collision with root package name */
    public final AtomicBoolean f8599j;

    /* renamed from: k, reason: collision with root package name */
    public int f8600k;

    /* renamed from: l, reason: collision with root package name */
    public final DmrDatabase f8601l;

    /* renamed from: m, reason: collision with root package name */
    public final C0767c f8602m = new C0767c(this);

    public C0768d(Context context) throws UnsupportedOperationException {
        Log.i("DMR_RX", String.format("Initializing DMR Audio Handler - Sample Rate: %d, Frame Size: %d", 8000, 640));
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(668);
        this.f8592a = byteBufferAllocate;
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        this.f8593b = new LinkedBlockingQueue(4);
        this.f8594c = new byte[334];
        this.f8595d = 0;
        this.h = new AtomicBoolean(false);
        this.f8598i = new AtomicBoolean(false);
        this.f8599j = new AtomicBoolean(false);
        this.f8600k = 0;
        this.f8597f = (AudioManager) context.getSystemService("audio");
        this.g = ((PowerManager) context.getSystemService("power")).newWakeLock(536870913, "DmrAudio::AudioWakeLock");
        new File(context.getFilesDir(), "dmr_recordings").mkdirs();
        this.f8601l = DmrDatabase.q(context);
        try {
            AudioAttributes audioAttributesBuild = new AudioAttributes.Builder().setUsage(1).setContentType(2).setFlags(1).build();
            AudioTrack audioTrackBuild = new AudioTrack.Builder().setAudioAttributes(audioAttributesBuild).setAudioFormat(new AudioFormat.Builder().setEncoding(2).setSampleRate(8000).setChannelMask(4).build()).setBufferSizeInBytes(Math.max(AudioTrack.getMinBufferSize(8000, 4, 2) * 4, 5120)).setTransferMode(1).build();
            if (audioTrackBuild.getState() != 1) {
                throw new IllegalStateException("AudioTrack initialization failed");
            }
            float f5 = f();
            audioTrackBuild.setVolume(f5);
            Log.i("DMR_RX", "AudioTrack initialized with volume: " + f5);
            this.f8596e = audioTrackBuild;
            new Thread(new C0.e(28, this), "DmrAudioProcessor").start();
        } catch (Exception e5) {
            Log.e("DMR_RX", "Failed to initialize AudioTrack", e5);
            throw new RuntimeException("AudioTrack initialization failed", e5);
        }
    }

    public static byte[] a(byte[] bArr) {
        if (bArr.length == 0) {
            return null;
        }
        int length = (bArr.length / 2) * 2;
        if (length != bArr.length) {
            Log.w("DMR_RX", "Truncating odd-length audio data: " + bArr.length + " -> " + length);
        }
        byte[] bArr2 = new byte[length];
        for (int i5 = 0; i5 < length; i5 += 2) {
            int i6 = i5 + 1;
            try {
                float f5 = ((short) (((bArr[i6] & 255) << 8) | (bArr[i5] & 255))) * 2.5f;
                float f6 = 32767.0f;
                if (f5 > 32767.0f) {
                    f5 = f6;
                } else {
                    f6 = -32768.0f;
                    if (f5 < -32768.0f) {
                        f5 = f6;
                    }
                }
                short s4 = (short) f5;
                bArr2[i5] = (byte) (s4 & 255);
                bArr2[i6] = (byte) ((s4 >> 8) & 255);
            } catch (Exception e5) {
                Log.e("DMR_RX", "Error during audio amplification", e5);
                return null;
            }
        }
        return bArr2;
    }

    public static byte[] d(int i5, byte[] bArr) {
        int i6;
        if (bArr == null || i5 < 0 || (i6 = i5 + 167) > bArr.length) {
            Log.v("DMR_RX", String.format("Frame structure check failed: data=%s, offset=%d, required=%d, available=%d", bArr == null ? "null" : "present", Integer.valueOf(i5), 167, Integer.valueOf(bArr != null ? bArr.length - i5 : 0)));
        } else if (bArr[i5] == -69 && bArr[i5 + 1] == 0 && bArr[i5 + 2] == 0) {
            int i7 = i5 + 3;
            if (i7 >= bArr.length) {
                Log.v("DMR_RX", "Cannot validate audio length - position beyond buffer");
            } else {
                byte b5 = bArr[i7];
                int i8 = b5 & 255;
                if (i8 <= 0 || i8 > 640) {
                    Log.v("DMR_RX", String.format("Invalid audio length: %d (expected 1-%d)", Integer.valueOf(i8), 640));
                } else {
                    int i9 = i5 + 166;
                    if (i9 >= bArr.length) {
                        Log.v("DMR_RX", "Cannot validate frame tail - position beyond buffer");
                    } else {
                        if (bArr[i9] == 68) {
                            if (i5 < 0 || i5 >= bArr.length) {
                                StringBuilder sbF = com.unified.ur1.SatelliteTracker.h.f("Invalid offset: ", i5, " for buffer length: ");
                                sbF.append(bArr.length);
                                Log.w("DMR_RX", sbF.toString());
                                return null;
                            }
                            if (i7 >= bArr.length) {
                                Log.w("DMR_RX", "Cannot read audio length - buffer too short");
                                return null;
                            }
                            int i10 = b5 & 255;
                            int i11 = i5 + 6;
                            if (i11 >= bArr.length || i6 > bArr.length) {
                                Log.w("DMR_RX", "Audio data position beyond buffer bounds");
                                return null;
                            }
                            int i12 = (i6 - i11) - 1;
                            int iMin = Math.min(Math.min(i10, i12), 640);
                            if (iMin <= 0) {
                                Log.w("DMR_RX", "No valid audio data available (declared: " + i10 + ", available: " + i12 + ")");
                                return null;
                            }
                            if (i11 + iMin > bArr.length) {
                                Log.w("DMR_RX", "Audio data would exceed buffer bounds, truncating");
                                iMin = bArr.length - i11;
                                if (iMin <= 0) {
                                    return null;
                                }
                            }
                            byte[] bArr2 = new byte[iMin];
                            try {
                                System.arraycopy(bArr, i11, bArr2, 0, iMin);
                                while (i < iMin) {
                                    if (bArr2[i] != 0) {
                                        return bArr2;
                                    }
                                    i++;
                                }
                                Log.w("DMR_RX", "Dropping all-zero audio frame");
                                return null;
                            } catch (ArrayIndexOutOfBoundsException e5) {
                                Log.e("DMR_RX", String.format("Buffer copy failed: src[%d], srcPos=%d, dst[%d], dstPos=0, length=%d", Integer.valueOf(bArr.length), Integer.valueOf(i11), Integer.valueOf(iMin), Integer.valueOf(iMin)), e5);
                                return null;
                            }
                        }
                        Log.v("DMR_RX", String.format("Invalid frame tail at position %d: %02X (expected %02X)", Integer.valueOf(i9), Integer.valueOf(bArr[i9] & 255), 68));
                    }
                }
            }
        } else {
            Log.v("DMR_RX", String.format("Invalid frame header at offset %d: %02X %02X %02X", Integer.valueOf(i5), Integer.valueOf(bArr[i5] & 255), Integer.valueOf(bArr[i5 + 1] & 255), Integer.valueOf(bArr[i5 + 2] & 255)));
        }
        Log.w("DMR_RX", "Invalid frame structure at offset " + i5);
        return null;
    }

    public static byte[] i(String str) {
        if (str.length() % 2 != 0) {
            throw new IllegalArgumentException("Invalid hex string");
        }
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i5 = 0; i5 < length; i5 += 2) {
            try {
                bArr[i5 / 2] = (byte) ((Character.digit(str.charAt(i5), 16) << 4) + Character.digit(str.charAt(i5 + 1), 16));
            } catch (Exception e5) {
                throw new IllegalArgumentException("Invalid hex string", e5);
            }
        }
        return bArr;
    }

    public final void b() {
        AudioTrack audioTrack = this.f8596e;
        if (audioTrack == null) {
            Log.e("DMR_RX", "AudioTrack is null");
            return;
        }
        Log.d("DMR_RX", "Audio state - initialized: " + (audioTrack.getState() == 1) + ", playing: " + (audioTrack.getPlayState() == 3));
    }

    public final void c() {
    }

    public final void e() {
        AudioTrack audioTrack = this.f8596e;
        if (audioTrack == null) {
            return;
        }
        try {
            byte[] bArr = new byte[320];
            for (int i5 = 0; i5 < 160; i5++) {
                short s4 = (short) ((1.0f - (i5 / 160)) * 32767.0f);
                int i6 = i5 * 2;
                bArr[i6] = (byte) (s4 & 255);
                bArr[i6 + 1] = (byte) ((s4 >> 8) & 255);
            }
            audioTrack.write(bArr, 0, 320);
            audioTrack.flush();
        } catch (Exception e5) {
            Log.w("DMR_RX", "Error during fade out", e5);
        }
    }

    public final float f() {
        AudioManager audioManager = this.f8597f;
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        float f5 = streamVolume / streamMaxVolume;
        Log.d("DMR_RX", String.format("Current system volume: %d/%d = %.2f", Integer.valueOf(streamVolume), Integer.valueOf(streamMaxVolume), Float.valueOf(f5)));
        return f5;
    }

    public final byte[] g(byte[] bArr) {
        if (bArr.length == 0) {
            this.f8595d = 0;
            return new byte[0];
        }
        int i5 = this.f8595d;
        if (i5 >= 167 || i5 < 0) {
            Log.w("DMR_RX", "Resetting oversized incomplete frame: " + this.f8595d);
            this.f8595d = 0;
        }
        int i6 = this.f8595d;
        byte[] bArr2 = this.f8594c;
        if (i6 > 0) {
            int i7 = 0;
            while (true) {
                int i8 = this.f8595d;
                if (i7 >= i8 - 2) {
                    this.f8595d = 0;
                    break;
                }
                if (bArr2[i7] != -69 || bArr2[i7 + 1] != 0 || bArr2[i7 + 2] != 0) {
                    i7++;
                } else if (i7 > 0) {
                    System.arraycopy(bArr2, i7, bArr2, 0, i8 - i7);
                    this.f8595d -= i7;
                }
            }
        }
        int i9 = this.f8595d;
        int i10 = 167 - i9;
        if (bArr.length + i9 < 167) {
            System.arraycopy(bArr, 0, bArr2, i9, bArr.length);
            this.f8595d += bArr.length;
            return new byte[0];
        }
        int iMin = Math.min(i10, bArr.length);
        System.arraycopy(bArr, 0, bArr2, this.f8595d, iMin);
        if (167 > bArr2.length) {
            Log.d("DMR_RX", String.format("Frame validation failed - length: %d, offset: %d", 167, 0));
        } else {
            byte b5 = bArr2[0];
            if (b5 == -69 && bArr2[1] == 0 && bArr2[2] == 0) {
                byte b6 = bArr2[3];
                int i11 = b6 & 255;
                if (i11 <= 0 || i11 > 640) {
                    Log.d("DMR_RX", String.format("Invalid audio length: %02X (%d bytes)", Byte.valueOf(b6), Integer.valueOf(i11)));
                } else {
                    int i12 = i11 + 7;
                    if (167 < i12) {
                        AbstractC0535a.u("Frame too short for audio length: 167 vs ", i12, "DMR_RX");
                    } else {
                        byte[] bArrD = d(0, bArr2);
                        if (bArrD != null) {
                            this.f8593b.offer(bArrD);
                        }
                    }
                }
            } else {
                Log.d("DMR_RX", String.format("Invalid frame header: %02X %02X %02X", Byte.valueOf(b5), Byte.valueOf(bArr2[1]), Byte.valueOf(bArr2[2])));
            }
        }
        int length = bArr.length - iMin;
        byte[] bArr3 = new byte[length];
        if (length > 0) {
            System.arraycopy(bArr, iMin, bArr3, 0, length);
        }
        this.f8595d = 0;
        return bArr3;
    }

    public final void h() {
        int i5 = this.f8600k + 1;
        this.f8600k = i5;
        if (i5 >= 5) {
            Log.e("DMR_RX", "Too many consecutive errors, resetting audio handler");
            m();
            this.f8600k = 0;
        }
    }

    public final void j(byte[] bArr) {
        AudioTrack audioTrack;
        if (!this.h.get() || (audioTrack = this.f8596e) == null) {
            Log.d("DMR_RX", "Not processing audio - not listening or audioTrack null");
            return;
        }
        if (bArr == null || bArr.length == 0) {
            Log.w("DMR_RX", "Invalid audio data for processing");
            return;
        }
        if (bArr.length % 2 != 0) {
            Log.w("DMR_RX", "Audio data length is odd, padding with zero");
            byte[] bArr2 = new byte[bArr.length + 1];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            bArr2[bArr.length] = 0;
            bArr = bArr2;
        }
        try {
            if (audioTrack.getPlayState() != 3) {
                Log.d("DMR_RX", "Restarting AudioTrack for playback");
                audioTrack.flush();
                p();
                audioTrack.play();
            }
            byte[] bArrA = a(bArr);
            if (bArrA == null) {
                Log.w("DMR_RX", "Audio amplification failed, skipping frame");
                return;
            }
            int iWrite = audioTrack.write(bArrA, 0, bArrA.length, 0);
            if (iWrite < 0) {
                Log.e("DMR_RX", "AudioTrack write error: " + iWrite);
                h();
            } else if (iWrite != bArrA.length) {
                Log.w("DMR_RX", "Partial audio write: " + iWrite + "/" + bArrA.length + " bytes");
            }
            this.f8600k = 0;
        } catch (Exception e5) {
            Log.e("DMR_RX", "Error processing audio data", e5);
            h();
        }
    }

    public final void k(byte[] bArr) {
        byte[] bArr2;
        boolean z4;
        byte[] bArrD;
        if (bArr.length == 0) {
            return;
        }
        int length = bArr.length;
        int i5 = 0;
        while (true) {
            bArr2 = this.f8594c;
            if (length < 167) {
                break;
            }
            int i6 = i5;
            while (true) {
                if (i6 > (i5 + length) - 167) {
                    z4 = false;
                    break;
                }
                if (bArr[i6] == -69 && bArr[i6 + 1] == 0 && bArr[i6 + 2] == 0 && (bArrD = d(i6, bArr)) != null) {
                    this.f8593b.offer(bArrD);
                    i5 = i6 + 167;
                    length = bArr.length - i5;
                    z4 = true;
                    break;
                }
                i6++;
            }
            if (!z4) {
                if (length > 0) {
                    System.arraycopy(bArr, i5, bArr2, 0, length);
                    this.f8595d = length;
                }
            }
        }
        if (length <= 0 || length >= 167) {
            return;
        }
        System.arraycopy(bArr, i5, bArr2, 0, length);
        this.f8595d = length;
    }

    public final synchronized void l() {
        try {
            if (this.f8598i.get()) {
                return;
            }
            Log.i("DMR_RX", "Releasing DMR audio handler");
            try {
                this.f8597f.abandonAudioFocus(this.f8602m);
                this.h.set(false);
                this.f8599j.set(false);
                this.f8598i.set(true);
                PowerManager.WakeLock wakeLock = this.g;
                if (wakeLock != null && wakeLock.isHeld()) {
                    this.g.release();
                }
                if (this.f8596e != null) {
                    try {
                        e();
                        this.f8596e.stop();
                        this.f8596e.flush();
                        this.f8596e.release();
                    } catch (Exception e5) {
                        Log.e("DMR_RX", "Error releasing AudioTrack", e5);
                    }
                }
                this.f8592a.clear();
                this.f8593b.clear();
                DmrDatabase dmrDatabase = this.f8601l;
                if (dmrDatabase != null) {
                    try {
                        dmrDatabase.d();
                    } catch (Exception e6) {
                        Log.e("DMR_RX", "Error closing database", e6);
                    }
                }
                Log.i("DMR_RX", "DMR audio handler released successfully");
            } catch (Exception e7) {
                Log.e("DMR_RX", "Error during release", e7);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void m() {
        Log.d("DMR_RX", "Resetting audio state");
        this.f8592a.clear();
        this.f8593b.clear();
        this.f8595d = 0;
        this.f8600k = 0;
        AudioTrack audioTrack = this.f8596e;
        if (audioTrack != null) {
            try {
                audioTrack.flush();
            } catch (Exception e5) {
                Log.w("DMR_RX", "Error flushing AudioTrack", e5);
            }
        }
    }

    public final synchronized void n() {
        try {
            if (this.f8598i.get() || this.f8599j.get()) {
                Log.e("DMR_RX", "Cannot start listening - handler is released or playing recording");
                return;
            }
            try {
                if (!this.g.isHeld()) {
                    this.g.acquire(600000L);
                }
                if (this.f8597f.requestAudioFocus(this.f8602m, 3, 1) == 1) {
                    m();
                    b();
                    if (this.f8596e != null) {
                        p();
                        this.f8596e.play();
                    }
                    this.h.set(true);
                    System.currentTimeMillis();
                    Log.i("DMR_RX", "Started DMR audio listening");
                } else {
                    Log.e("DMR_RX", "Could not get audio focus");
                }
            } catch (Exception e5) {
                Log.e("DMR_RX", "Error starting listening", e5);
                o();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void o() {
        try {
            if (this.f8598i.get()) {
                return;
            }
            Log.i("DMR_RX", "Stopping DMR audio");
            this.h.set(false);
            try {
                if (this.g.isHeld()) {
                    this.g.release();
                }
                if (this.f8596e != null && !this.f8599j.get()) {
                    e();
                    this.f8596e.pause();
                    this.f8596e.flush();
                }
                m();
            } catch (Exception e5) {
                Log.e("DMR_RX", "Error stopping audio", e5);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void p() {
        AudioTrack audioTrack = this.f8596e;
        if (audioTrack == null || audioTrack.getState() != 1) {
            return;
        }
        float f5 = f();
        float fMax = Math.max(Math.min(2.5f * f5, 4.0f), 0.1f);
        audioTrack.setVolume(fMax);
        Log.d("DMR_RX", "Updated AudioTrack volume to: " + fMax + " (system volume: " + f5 + ", boost: 2.5)");
    }
}
