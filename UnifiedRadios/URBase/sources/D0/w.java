package D0;

import C0.C0001a;
import android.accounts.Account;
import android.content.Context;
import android.util.Log;
import androidx.work.impl.WorkDatabase;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.http2.Settings;
import q3.AbstractC0869a;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f308a;

    /* renamed from: b, reason: collision with root package name */
    public Object f309b;

    /* renamed from: c, reason: collision with root package name */
    public Object f310c;

    /* renamed from: d, reason: collision with root package name */
    public Object f311d;

    /* renamed from: e, reason: collision with root package name */
    public Object f312e;

    /* renamed from: f, reason: collision with root package name */
    public Object f313f;
    public Object g;
    public Object h;

    public w(int i5) {
        this.f308a = i5;
        switch (i5) {
            case 2:
                this.f309b = new AtomicBoolean();
                this.f310c = null;
                this.f311d = new HashMap(16, 1.0f);
                this.f312e = new HashMap(16, 1.0f);
                this.f313f = new HashMap(16, 1.0f);
                this.g = new HashMap(16, 1.0f);
                this.h = null;
                break;
        }
    }

    public String a() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append((String) this.f309b);
        stringBuffer.append((String) this.f310c);
        stringBuffer.append((String) this.f311d);
        stringBuffer.append((String) this.f312e);
        stringBuffer.append("0000");
        stringBuffer.append((String) this.f313f);
        stringBuffer.append((String) this.g);
        stringBuffer.append((String) this.h);
        String string = stringBuffer.toString();
        char[] cArr = AbstractC0869a.f9481a;
        Log.e("yuan", "res = " + string);
        byte[] bArrC = AbstractC0869a.c(string);
        int i5 = 0;
        int i6 = 0;
        while (true) {
            int i7 = 8;
            if (i5 >= bArrC.length) {
                break;
            }
            byte b5 = bArrC[i5];
            if (i5 % 2 != 0) {
                i7 = 0;
            }
            i6 += (b5 & 255) << i7;
            i5++;
        }
        while (true) {
            int i8 = i6 >> 16;
            if (i8 <= 0) {
                return stringBuffer.replace(8, 12, AbstractC0869a.a(i6 ^ Settings.DEFAULT_INITIAL_WINDOW_SIZE, 4)).toString();
            }
            i6 = (65535 & i6) + i8;
        }
    }

    public String toString() {
        switch (this.f308a) {
            case 3:
                return new Gson().toJson(this);
            default:
                return super.toString();
        }
    }

    public w(Account account, Set set, String str, String str2) {
        this.f308a = 4;
        K1.a aVar = K1.a.f1504b;
        this.f309b = account;
        Set setEmptySet = set == null ? Collections.emptySet() : Collections.unmodifiableSet(set);
        this.f310c = setEmptySet;
        Map mapEmptyMap = Collections.emptyMap();
        this.f312e = str;
        this.f313f = str2;
        this.g = aVar;
        HashSet hashSet = new HashSet(setEmptySet);
        Iterator it = mapEmptyMap.values().iterator();
        if (!it.hasNext()) {
            this.f311d = Collections.unmodifiableSet(hashSet);
        } else {
            com.unified.ur1.SatelliteTracker.h.p(it.next());
            throw null;
        }
    }

    public w(String str, String str2) {
        this.f308a = 3;
        String strA = AbstractC0869a.a(str2.length() / 2, 4);
        this.f309b = "68";
        this.f310c = str;
        this.f311d = "01";
        this.f312e = "01";
        this.f313f = strA;
        this.g = str2;
        this.h = "10";
    }

    public w(String str) {
        this.f308a = 3;
        this.f309b = str.substring(0, 2);
        this.f310c = str.substring(2, 4);
        this.f311d = str.substring(4, 6);
        this.f312e = str.substring(6, 8);
        String strSubstring = str.substring(12, 16);
        this.f313f = strSubstring;
        int i5 = Integer.parseInt(strSubstring, 16) * 2;
        int i6 = i5 + 16;
        this.g = str.substring(16, i6);
        this.h = str.substring(i6, i5 + 18);
    }

    public w(Context context, C0001a c0001a, L0.i iVar, K0.a aVar, WorkDatabase workDatabase, L0.o oVar, ArrayList arrayList) {
        this.f308a = 0;
        new C0.u();
        this.f309b = context.getApplicationContext();
        this.f311d = iVar;
        this.f310c = aVar;
        this.f312e = c0001a;
        this.f313f = workDatabase;
        this.g = oVar;
        this.h = arrayList;
    }
}
