package h1;

import android.content.Context;
import android.util.Log;
import j.m;
import j.y;
import j0.InterfaceC0591d;
import java.io.IOException;
import java.io.Serializable;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.json.JSONObject;
import p0.C0818a;
import p0.InterfaceC0819b;
import q0.C0845h;
import r3.InterfaceC0877a;
import y1.InterfaceC0980b;
import y1.e;

/* renamed from: h1.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0559c implements InterfaceC0877a, InterfaceC0591d, y, Callback, InterfaceC0819b, InterfaceC0980b, y1.d {
    @Override // j.y
    public void a(m mVar, boolean z4) {
    }

    @Override // y1.InterfaceC0980b
    public int b(Context context, String str) {
        return e.a(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001b A[PHI: r4
      0x001b: PHI (r4v2 int) = (r4v1 int), (r4v3 int) binds: [B:3:0x0014, B:5:0x0017] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // y1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public y1.C0981c c(android.content.Context r3, java.lang.String r4, y1.InterfaceC0980b r5) {
        /*
            r2 = this;
            y1.c r0 = new y1.c
            r0.<init>()
            int r1 = r5.b(r3, r4)
            r0.f10467a = r1
            r1 = 1
            int r3 = r5.e(r3, r4, r1)
            r0.f10468b = r3
            int r4 = r0.f10467a
            if (r4 != 0) goto L1b
            r4 = 0
            if (r3 != 0) goto L1b
            r1 = r4
            goto L1e
        L1b:
            if (r4 < r3) goto L1e
            r1 = -1
        L1e:
            r0.f10469c = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: h1.C0559c.c(android.content.Context, java.lang.String, y1.b):y1.c");
    }

    @Override // j0.InterfaceC0591d
    public void d(int i5, Serializable serializable) {
        String str;
        switch (i5) {
            case 1:
                str = "RESULT_INSTALL_SUCCESS";
                break;
            case 2:
                str = "RESULT_ALREADY_INSTALLED";
                break;
            case 3:
                str = "RESULT_UNSUPPORTED_ART_VERSION";
                break;
            case 4:
                str = "RESULT_NOT_WRITABLE";
                break;
            case 5:
                str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                break;
            case 6:
                str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                break;
            case 7:
                str = "RESULT_IO_EXCEPTION";
                break;
            case 8:
                str = "RESULT_PARSE_EXCEPTION";
                break;
            case 9:
            default:
                str = "";
                break;
            case 10:
                str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                break;
            case 11:
                str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                break;
        }
        if (i5 == 6 || i5 == 7 || i5 == 8) {
            Log.e("ProfileInstaller", str, (Throwable) serializable);
        } else {
            Log.d("ProfileInstaller", str);
        }
    }

    @Override // y1.InterfaceC0980b
    public int e(Context context, String str, boolean z4) {
        return e.d(context, str, z4);
    }

    @Override // p0.InterfaceC0819b
    public p0.c f(C0818a c0818a) {
        return new C0845h(c0818a.f9074a, c0818a.f9075b, c0818a.f9076c, c0818a.f9077d, c0818a.f9078e);
    }

    public float g(float f5, float f6) {
        return 1.0f;
    }

    @Override // r3.InterfaceC0877a
    public Object get() {
        return new d(0);
    }

    @Override // j.y
    public boolean i(m mVar) {
        return false;
    }

    @Override // j0.InterfaceC0591d
    public void m() {
        Log.d("ProfileInstaller", "DIAGNOSTIC_PROFILE_IS_COMPRESSED");
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, IOException iOException) {
        Log.e("Unified - Main Activity", "Failed to call rx_stop API: " + iOException.getMessage());
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        try {
            ResponseBody responseBodyBody = response.body();
            try {
                if (!response.isSuccessful() || responseBodyBody == null) {
                    Log.e("Unified - Main Activity", "rx_stop API returned error code: " + response.code());
                } else {
                    JSONObject jSONObject = new JSONObject(responseBodyBody.string());
                    if ("SUCCESS".equals(jSONObject.optString("status"))) {
                        Log.d("Unified - Main Activity", "Successfully stopped RX call via rx_stop API");
                    } else {
                        Log.e("Unified - Main Activity", "rx_stop API error: " + jSONObject.optString("error", "Unknown error"));
                    }
                }
                if (responseBodyBody != null) {
                    responseBodyBody.close();
                }
            } finally {
            }
        } catch (JSONException e5) {
            Log.e("Unified - Main Activity", "Error parsing rx_stop response: " + e5.getMessage());
        }
    }
}
