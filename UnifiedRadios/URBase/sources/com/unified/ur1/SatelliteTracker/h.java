package com.unified.ur1.SatelliteTracker;

import android.content.Context;
import android.os.Parcel;
import android.util.Log;
import java.util.HashMap;
import org.conscrypt.OpenSSLProvider;
import x1.BinderC0963d;
import x1.InterfaceC0961b;

/* loaded from: classes.dex */
public abstract /* synthetic */ class h {
    public static String a(int i5, String str) {
        return str + i5;
    }

    public static String b(String str, String str2) {
        return str + str2;
    }

    public static String c(String str, String str2, int i5, int i6) {
        return str + i5 + str2 + i6;
    }

    public static String d(StringBuilder sb, int i5, String str) {
        sb.append(i5);
        sb.append(str);
        return sb.toString();
    }

    public static String e(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder f(String str, int i5, String str2) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(i5);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder g(String str, String str2, Exception exc, String str3) {
        Log.e(str, str2, exc);
        return new StringBuilder(str3);
    }

    public static StringBuilder h(String str, String str2, String str3) {
        Log.d(str, str2);
        return new StringBuilder(str3);
    }

    public static StringBuilder i(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        Log.d(str2, sb.toString());
        return new StringBuilder(str3);
    }

    public static StringBuilder j(OpenSSLProvider openSSLProvider, String str, String str2, String str3, String str4) {
        openSSLProvider.put(str, str2);
        openSSLProvider.put(str3, str4);
        return new StringBuilder();
    }

    public static InterfaceC0961b k(Parcel parcel) {
        InterfaceC0961b interfaceC0961bJ = BinderC0963d.J(parcel.readStrongBinder());
        parcel.recycle();
        return interfaceC0961bJ;
    }

    public static /* synthetic */ void l(int i5) {
        if (i5 == 0) {
            throw new NullPointerException("null reference");
        }
    }

    public static void m(int i5, Context context, String str) {
        h4.c.C(context).edit().putInt(str, i5).apply();
    }

    public static void n(int i5, HashMap map, String str, int i6, String str2) {
        map.put(str, Integer.valueOf(i5));
        map.put(str2, Integer.valueOf(i6));
    }

    public static void o(Exception exc, StringBuilder sb, String str) {
        sb.append(exc.getMessage());
        Log.e(str, sb.toString());
    }

    public static /* synthetic */ void p(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void q(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.d(str2, sb.toString());
    }

    public static void r(StringBuilder sb, String str, String str2, OpenSSLProvider openSSLProvider, String str3) {
        sb.append(str);
        sb.append(str2);
        openSSLProvider.put(str3, sb.toString());
    }

    public static String s(String str, String str2) {
        return str + str2;
    }

    public static /* synthetic */ String t(int i5) {
        switch (i5) {
            case 1:
                return "NONE";
            case 2:
                return "LEFT";
            case 3:
                return "TOP";
            case 4:
                return "RIGHT";
            case 5:
                return "BOTTOM";
            case 6:
                return "BASELINE";
            case 7:
                return "CENTER";
            case 8:
                return "CENTER_X";
            case 9:
                return "CENTER_Y";
            default:
                throw null;
        }
    }
}
