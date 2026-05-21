package X2;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import com.unified.ur1.R;
import g0.AbstractC0535a;
import i0.ExecutorC0566c;
import j3.RunnableC0603a;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;
import k.AbstractC0636i0;
import k.G0;
import k.U0;
import m1.C0761b;
import m3.C0764B;
import org.conscrypt.PSKKeyManager;
import q3.AbstractC0869a;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public Object f2818a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2819b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2820c;

    /* renamed from: d, reason: collision with root package name */
    public Object f2821d;

    /* renamed from: e, reason: collision with root package name */
    public Object f2822e;

    /* renamed from: f, reason: collision with root package name */
    public Object f2823f;

    public static boolean b(int[] iArr, int i5) {
        for (int i6 : iArr) {
            if (i6 == i5) {
                return true;
            }
        }
        return false;
    }

    public static byte[] c(byte[] bArr) {
        int i5;
        if (bArr.length < 8) {
            return null;
        }
        for (int i6 = 0; i6 < bArr.length - 7; i6++) {
            if (bArr[i6] == 104 && bArr[i6 + 1] == 43 && (i5 = i6 + 7) < bArr.length) {
                int i7 = (bArr[i5] & 255) | ((bArr[i6 + 6] & 255) << 8);
                int i8 = i7 + 9;
                if (i6 + i8 <= bArr.length && i7 >= 9) {
                    byte[] bArr2 = new byte[i8];
                    System.arraycopy(bArr, i6, bArr2, 0, i8);
                    return bArr2;
                }
            }
        }
        return null;
    }

    public static String e(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b5 : bArr) {
            sb.append(String.format("%02X ", Byte.valueOf(b5)));
        }
        return sb.toString().trim();
    }

    public static ColorStateList f(Context context, int i5) {
        int iC = U0.c(context, R.attr.colorControlHighlight);
        int iB = U0.b(context, R.attr.colorButtonNormal);
        int[] iArr = U0.f7718b;
        int[] iArr2 = U0.f7720d;
        int iB2 = E.a.b(iC, i5);
        return new ColorStateList(new int[][]{iArr, iArr2, U0.f7719c, U0.f7722f}, new int[]{iB, iB2, E.a.b(iC, i5), i5});
    }

    public static int h(byte[] bArr) {
        Log.d("Unified - DMR-CallerID", "res = " + e(bArr));
        if (bArr.length < 13) {
            Log.e("Unified - DMR-CallerID", "Response too short: length=" + bArr.length);
            return -1;
        }
        int i5 = (bArr[7] & 255) | ((bArr[6] & 255) << 8);
        if (i5 < 5) {
            Log.e("Unified - DMR-CallerID", "Data length too short: " + i5);
            return -1;
        }
        int i6 = (bArr[9] & 255) | ((bArr[12] & 255) << 24) | ((bArr[11] & 255) << 16) | ((bArr[10] & 255) << 8);
        AbstractC0535a.u("Successfully extracted transmitter ID: ", i6, "Unified - DMR-CallerID");
        return i6;
    }

    public static LayerDrawable j(G0 g02, Context context, int i5) throws Resources.NotFoundException {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i5);
        Drawable drawableE = g02.e(context, R.drawable.abc_star_black_48dp);
        Drawable drawableE2 = g02.e(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableE instanceof BitmapDrawable) && drawableE.getIntrinsicWidth() == dimensionPixelSize && drawableE.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableE;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableE.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableE.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableE2 instanceof BitmapDrawable) && drawableE2.getIntrinsicWidth() == dimensionPixelSize && drawableE2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableE2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableE2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableE2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void n(long j5) throws InterruptedException {
        try {
            Thread.sleep(j5);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
    }

    public static void p(Drawable drawable, int i5) {
        PorterDuff.Mode mode = k.r.f7853b;
        int[] iArr = AbstractC0636i0.f7786a;
        drawable.mutate().setColorFilter(k.r.c(i5, mode));
    }

    public void a(String str, String str2) {
        Map map = (Map) this.f2823f;
        if (map == null) {
            throw new IllegalStateException("Property \"autoMetadata\" has not been set");
        }
        map.put(str, str2);
    }

    public Y0.h d() {
        String strB = ((String) this.f2818a) == null ? " transportName" : "";
        if (((Y0.m) this.f2820c) == null) {
            strB = strB.concat(" encodedPayload");
        }
        if (((Long) this.f2821d) == null) {
            strB = com.unified.ur1.SatelliteTracker.h.b(strB, " eventMillis");
        }
        if (((Long) this.f2822e) == null) {
            strB = com.unified.ur1.SatelliteTracker.h.b(strB, " uptimeMillis");
        }
        if (((Map) this.f2823f) == null) {
            strB = com.unified.ur1.SatelliteTracker.h.b(strB, " autoMetadata");
        }
        if (strB.isEmpty()) {
            return new Y0.h((String) this.f2818a, (Integer) this.f2819b, (Y0.m) this.f2820c, ((Long) this.f2821d).longValue(), ((Long) this.f2822e).longValue(), (Map) this.f2823f);
        }
        throw new IllegalStateException("Missing required properties:".concat(strB));
    }

    public N1.r g(N1.r rVar) {
        return rVar.i(new ExecutorC0566c(0), new D0.p(4, this));
    }

    public byte[] i(byte[] bArr) throws InterruptedException {
        if (Thread.currentThread().isInterrupted()) {
            return null;
        }
        StringBuilder sb = new StringBuilder("Sending control command: ");
        C0764B c0764b = (C0764B) this.f2819b;
        c0764b.getClass();
        sb.append(C0764B.b(bArr));
        sb.append(", timeout: 800ms");
        Log.d("SerialPort", sb.toString());
        ReentrantLock reentrantLock = c0764b.f8563d;
        reentrantLock.lock();
        try {
            c0764b.h(bArr);
            Log.d("SerialPort", "Control command sent, waiting for response");
            long jCurrentTimeMillis = System.currentTimeMillis();
            while (System.currentTimeMillis() - jCurrentTimeMillis < 800) {
                if (c0764b.a() > 0) {
                    byte[] bArrG = c0764b.g(PSKKeyManager.MAX_KEY_LENGTH_BYTES);
                    Log.i("SerialPort", "Control response received: " + C0764B.b(bArrG));
                    reentrantLock.unlock();
                    byte[] bArrC = c(bArrG);
                    if (bArrC != null) {
                        return bArrC;
                    }
                    n(25L);
                    try {
                        if (c0764b.a() <= 0) {
                            return bArrC;
                        }
                        byte[] bArrG2 = c0764b.g(PSKKeyManager.MAX_KEY_LENGTH_BYTES);
                        if (bArrG2.length <= 0) {
                            return bArrC;
                        }
                        byte[] bArr2 = new byte[bArrG.length + bArrG2.length];
                        System.arraycopy(bArrG, 0, bArr2, 0, bArrG.length);
                        System.arraycopy(bArrG2, 0, bArr2, bArrG.length, bArrG2.length);
                        return c(bArr2);
                    } catch (Exception e5) {
                        Log.w("Unified - DMR-CallerID", "Error reading additional response data", e5);
                        return bArrC;
                    }
                }
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException e6) {
                    Log.w("SerialPort", "Wait interrupted while waiting for control response", e6);
                    Thread.currentThread().interrupt();
                }
            }
            Log.e("SerialPort", "Control response timeout after 800ms");
            throw new IOException("Timeout waiting for control response");
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public ColorStateList k(Context context, int i5) {
        if (i5 == R.drawable.abc_edit_text_material) {
            return C.h.c(context, R.color.abc_tint_edittext);
        }
        if (i5 == R.drawable.abc_switch_track_mtrl_alpha) {
            return C.h.c(context, R.color.abc_tint_switch_track);
        }
        if (i5 != R.drawable.abc_switch_thumb_material) {
            if (i5 == R.drawable.abc_btn_default_mtrl_shape) {
                return f(context, U0.c(context, R.attr.colorButtonNormal));
            }
            if (i5 == R.drawable.abc_btn_borderless_material) {
                return f(context, 0);
            }
            if (i5 == R.drawable.abc_btn_colored_material) {
                return f(context, U0.c(context, R.attr.colorAccent));
            }
            if (i5 == R.drawable.abc_spinner_mtrl_am_alpha || i5 == R.drawable.abc_spinner_textfield_background_material) {
                return C.h.c(context, R.color.abc_tint_spinner);
            }
            if (b((int[]) this.f2819b, i5)) {
                return U0.d(context, R.attr.colorControlNormal);
            }
            if (b((int[]) this.f2822e, i5)) {
                return C.h.c(context, R.color.abc_tint_default);
            }
            if (b((int[]) this.f2823f, i5)) {
                return C.h.c(context, R.color.abc_tint_btn_checkable);
            }
            if (i5 == R.drawable.abc_seekbar_thumb_material) {
                return C.h.c(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListD = U0.d(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListD == null || !colorStateListD.isStateful()) {
            iArr[0] = U0.f7718b;
            iArr2[0] = U0.b(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = U0.f7721e;
            iArr2[1] = U0.c(context, R.attr.colorControlActivated);
            iArr[2] = U0.f7722f;
            iArr2[2] = U0.c(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = U0.f7718b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListD.getColorForState(iArr3, 0);
            iArr[1] = U0.f7721e;
            iArr2[1] = U0.c(context, R.attr.colorControlActivated);
            iArr[2] = U0.f7722f;
            iArr2[2] = colorStateListD.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public void l() throws InterruptedException {
        int iH;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i5 = 0;
        int i6 = 0;
        while (i5 < 5 && System.currentTimeMillis() - jCurrentTimeMillis < 12000) {
            if (Thread.currentThread().isInterrupted()) {
                Log.d("Unified - DMR-CallerID", "Request interrupted");
                return;
            }
            StringBuilder sb = new StringBuilder("Caller ID attempt ");
            int i7 = i5 + 1;
            sb.append(i7);
            sb.append("/5");
            Log.d("Unified - DMR-CallerID", sb.toString());
            for (int i8 = 0; i8 < 2 && !Thread.currentThread().isInterrupted(); i8++) {
                if (((C0764B) this.f2819b).f8564e) {
                    if (i8 > 0) {
                        try {
                            n(50L);
                        } catch (Exception e5) {
                            Log.e("Unified - DMR-CallerID", "Error on sub-attempt " + (i8 + 1) + ": " + e5.getMessage());
                        }
                    }
                    String strA = new D0.w("2B", "01").a();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Command packet (sub-attempt ");
                    int i9 = i8 + 1;
                    sb2.append(i9);
                    sb2.append("): ");
                    sb2.append(strA);
                    Log.d("Unified - DMR-CallerID", sb2.toString());
                    byte[] bArrC = AbstractC0869a.c(strA);
                    Log.d("Unified - DMR-CallerID", "Sending bytes: " + e(bArrC));
                    byte[] bArrI = i(bArrC);
                    if (bArrI != null) {
                        int i10 = 0;
                        while (true) {
                            if (i10 >= bArrI.length - 1) {
                                break;
                            }
                            if (bArrI[i10] == 104 && bArrI[i10 + 1] == 43) {
                                int i11 = ((bArrI[i10 + 7] & 255) | ((bArrI[i10 + 6] & 255) << 8)) + 9;
                                if (i10 + i11 <= bArrI.length) {
                                    byte[] bArr = new byte[i11];
                                    System.arraycopy(bArrI, i10, bArr, 0, i11);
                                    bArrI = bArr;
                                    break;
                                }
                            }
                            i10++;
                        }
                        iH = h(bArrI);
                        if (iH != -1) {
                            Log.d("Unified - DMR-CallerID", "Successfully got caller ID on sub-attempt " + i9);
                            break;
                        }
                    } else {
                        Log.w("Unified - DMR-CallerID", "No response received from device on sub-attempt " + i9);
                    }
                } else {
                    Log.w("Unified - DMR-CallerID", "Control port not initialized on sub-attempt " + (i8 + 1));
                    n(50L);
                }
            }
            iH = -1;
            if (iH == -1) {
                i6++;
                Log.w("Unified - DMR-CallerID", "Failed to get caller ID on attempt " + i7 + " (consecutive failures: " + i6 + ")");
                if (i6 >= 2) {
                    Log.d("Unified - DMR-CallerID", "Multiple failures detected, adding recovery delay");
                    n(200L);
                } else {
                    n(100L);
                }
            } else {
                if (iH != 0) {
                    AbstractC0535a.u("Valid caller ID received: ", iH, "Unified - DMR-CallerID");
                    ((Handler) this.f2821d).post(new D.n(iH, 3, this));
                    return;
                }
                Log.d("Unified - DMR-CallerID", "Zero caller ID received on attempt " + i7 + ", retrying...");
                n(100L);
                i6 = 0;
            }
            i5 = i7;
        }
        if (System.currentTimeMillis() - jCurrentTimeMillis >= 12000) {
            Log.e("Unified - DMR-CallerID", "Caller ID request timed out after 12000ms with " + i6 + " consecutive failures");
            ((Handler) this.f2821d).post(new RunnableC0603a(this, "Caller ID request timed out after 12 seconds"));
            return;
        }
        Log.e("Unified - DMR-CallerID", "Failed to retrieve caller ID after 5 attempts with " + i6 + " consecutive failures");
        ((Handler) this.f2821d).post(new RunnableC0603a(this, "Failed to retrieve caller ID after 5 attempts"));
    }

    public void m() {
        Future future = (Future) this.f2823f;
        if (future != null && !future.isDone()) {
            ((Future) this.f2823f).cancel(true);
            Log.d("Unified - DMR-CallerID", "Cancelled current caller ID request");
        }
        AtomicBoolean atomicBoolean = (AtomicBoolean) this.f2822e;
        atomicBoolean.set(false);
        if (atomicBoolean.getAndSet(true)) {
            Log.w("Unified - DMR-CallerID", "Request already in progress, ignoring new request");
            return;
        }
        Log.w("Unified - DMR-CallerID", "Requesting Calling ID Info");
        try {
            C0764B c0764b = (C0764B) this.f2819b;
            if (c0764b != null) {
                if (c0764b.f8564e) {
                    this.f2823f = ((ExecutorService) this.f2820c).submit(new RunnableC0603a(this));
                    return;
                }
            }
        } catch (Exception e5) {
            com.unified.ur1.SatelliteTracker.h.o(e5, new StringBuilder("Error checking device readiness: "), "Unified - DMR-CallerID");
        }
        Log.e("Unified - DMR-CallerID", "Device not ready for caller ID request");
        ((Handler) this.f2821d).post(new RunnableC0603a(this, "Device not ready"));
        atomicBoolean.set(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x015d A[ADDED_TO_REGION, ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void o(java.lang.String r6, java.lang.String r7, android.os.Bundle r8) {
        /*
            Method dump skipped, instructions count: 354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.n.o(java.lang.String, java.lang.String, android.os.Bundle):void");
    }

    public N1.r q(String str, String str2, Bundle bundle) {
        int i5;
        try {
            o(str, str2, bundle);
            C0761b c0761b = (C0761b) this.f2820c;
            com.google.android.material.datepicker.m mVar = c0761b.f8515c;
            int iA = mVar.a();
            m1.h hVar = m1.h.f8527l;
            if (iA >= 12000000) {
                m1.m mVarB = m1.m.b(c0761b.f8514b);
                synchronized (mVarB) {
                    i5 = mVarB.f8544c;
                    mVarB.f8544c = i5 + 1;
                }
                return mVarB.c(new m1.l(i5, 1, bundle, 1)).i(hVar, m1.d.f8520d);
            }
            if (mVar.b() != 0) {
                return c0761b.a(bundle).j(hVar, new L0.e(c0761b, 20, bundle));
            }
            IOException iOException = new IOException("MISSING_INSTANCEID_SERVICE");
            N1.r rVar = new N1.r();
            rVar.l(iOException);
            return rVar;
        } catch (InterruptedException | ExecutionException e5) {
            N1.r rVar2 = new N1.r();
            rVar2.l(e5);
            return rVar2;
        }
    }
}
