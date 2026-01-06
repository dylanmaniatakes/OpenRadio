package D1;

import D1.G;
import J1.C0059d;
import J1.C0062e;
import J1.C0074i;
import J1.C0109u;
import J1.C0112v;
import J1.K1;
import J1.N1;
import J1.O1;
import J1.P1;
import J1.Y1;
import J1.b2;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.maps.model.PinConfig;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import n1.C0785b;
import n1.C0787d;
import org.conscrypt.FileClientSessionCache;
import q1.C0855f;

/* loaded from: classes.dex */
public final class G implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f345a;

    public /* synthetic */ G(int i5) {
        this.f345a = i5;
    }

    public static void a(C0112v c0112v, Parcel parcel, int i5) {
        String str = c0112v.f1398j;
        int I = A2.b.I(20293, parcel);
        A2.b.E(parcel, 2, str);
        A2.b.D(parcel, 3, c0112v.f1399k, i5);
        A2.b.E(parcel, 4, c0112v.f1400l);
        A2.b.M(parcel, 5, 8);
        parcel.writeLong(c0112v.f1401m);
        A2.b.K(I, parcel);
    }

    public static void b(Y1 y12, Parcel parcel) {
        int i5 = y12.f1070j;
        int I = A2.b.I(20293, parcel);
        A2.b.M(parcel, 1, 4);
        parcel.writeInt(i5);
        A2.b.E(parcel, 2, y12.f1071k);
        A2.b.M(parcel, 3, 8);
        parcel.writeLong(y12.f1072l);
        Long l5 = y12.f1073m;
        if (l5 != null) {
            A2.b.M(parcel, 4, 8);
            parcel.writeLong(l5.longValue());
        }
        A2.b.E(parcel, 6, y12.n);
        A2.b.E(parcel, 7, y12.f1074o);
        Double d5 = y12.f1075p;
        if (d5 != null) {
            A2.b.M(parcel, 8, 8);
            parcel.writeDouble(d5.doubleValue());
        }
        A2.b.K(I, parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        Bundle bundle;
        switch (this.f345a) {
            case 0:
                int iH = y1.f.H(parcel);
                IBinder iBinderZ = null;
                IBinder iBinderZ2 = null;
                PendingIntent pendingIntent = null;
                String strJ = null;
                int iA = 0;
                while (parcel.dataPosition() < iH) {
                    int i5 = parcel.readInt();
                    char c2 = (char) i5;
                    if (c2 == 1) {
                        iA = y1.f.A(i5, parcel);
                    } else if (c2 == 2) {
                        iBinderZ = y1.f.z(i5, parcel);
                    } else if (c2 == 3) {
                        iBinderZ2 = y1.f.z(i5, parcel);
                    } else if (c2 == 4) {
                        pendingIntent = (PendingIntent) y1.f.i(parcel, i5, PendingIntent.CREATOR);
                    } else if (c2 != 6) {
                        y1.f.G(i5, parcel);
                    } else {
                        strJ = y1.f.j(i5, parcel);
                    }
                }
                y1.f.n(iH, parcel);
                return new F(iA, iBinderZ, iBinderZ2, pendingIntent, strJ);
            case 1:
                int iH2 = y1.f.H(parcel);
                long jB = Long.MAX_VALUE;
                LocationRequest locationRequest = null;
                ArrayList arrayListM = null;
                boolean zU = false;
                boolean zU2 = false;
                boolean zU3 = false;
                boolean zU4 = false;
                while (parcel.dataPosition() < iH2) {
                    int i6 = parcel.readInt();
                    char c5 = (char) i6;
                    if (c5 == 1) {
                        locationRequest = (LocationRequest) y1.f.i(parcel, i6, LocationRequest.CREATOR);
                    } else if (c5 == 5) {
                        arrayListM = y1.f.m(parcel, i6, C0855f.CREATOR);
                    } else if (c5 == '\b') {
                        zU = y1.f.u(i6, parcel);
                    } else if (c5 != '\t') {
                        switch (c5) {
                            case 11:
                                zU3 = y1.f.u(i6, parcel);
                                break;
                            case FileClientSessionCache.MAX_SIZE /* 12 */:
                                zU4 = y1.f.u(i6, parcel);
                                break;
                            case o1.f.ERROR /* 13 */:
                                y1.f.j(i6, parcel);
                                break;
                            case o1.f.INTERRUPTED /* 14 */:
                                jB = y1.f.B(i6, parcel);
                                break;
                            default:
                                y1.f.G(i6, parcel);
                                break;
                        }
                    } else {
                        zU2 = y1.f.u(i6, parcel);
                    }
                }
                y1.f.n(iH2, parcel);
                return new H(locationRequest, arrayListM, zU, zU2, zU3, zU4, jB);
            case 2:
                int iH3 = y1.f.H(parcel);
                H h = null;
                IBinder iBinderZ3 = null;
                IBinder iBinderZ4 = null;
                PendingIntent pendingIntent2 = null;
                IBinder iBinderZ5 = null;
                String strJ2 = null;
                int iA2 = 1;
                while (parcel.dataPosition() < iH3) {
                    int i7 = parcel.readInt();
                    switch ((char) i7) {
                        case 1:
                            iA2 = y1.f.A(i7, parcel);
                            break;
                        case 2:
                            h = (H) y1.f.i(parcel, i7, H.CREATOR);
                            break;
                        case 3:
                            iBinderZ3 = y1.f.z(i7, parcel);
                            break;
                        case 4:
                            pendingIntent2 = (PendingIntent) y1.f.i(parcel, i7, PendingIntent.CREATOR);
                            break;
                        case 5:
                            iBinderZ4 = y1.f.z(i7, parcel);
                            break;
                        case 6:
                            iBinderZ5 = y1.f.z(i7, parcel);
                            break;
                        case 7:
                        default:
                            y1.f.G(i7, parcel);
                            break;
                        case '\b':
                            strJ2 = y1.f.j(i7, parcel);
                            break;
                    }
                }
                y1.f.n(iH3, parcel);
                return new I(iA2, h, iBinderZ3, iBinderZ4, pendingIntent2, iBinderZ5, strJ2);
            case 3:
                int iH4 = y1.f.H(parcel);
                int iA3 = -1;
                int iA4 = 0;
                short s4 = 0;
                int iA5 = 0;
                long jB2 = 0;
                float fX = 0.0f;
                double dW = 0.0d;
                double dW2 = 0.0d;
                String strJ3 = null;
                while (parcel.dataPosition() < iH4) {
                    int i8 = parcel.readInt();
                    switch ((char) i8) {
                        case 1:
                            strJ3 = y1.f.j(i8, parcel);
                            break;
                        case 2:
                            jB2 = y1.f.B(i8, parcel);
                            break;
                        case 3:
                            y1.f.N(parcel, i8, 4);
                            s4 = (short) parcel.readInt();
                            break;
                        case 4:
                            dW = y1.f.w(i8, parcel);
                            break;
                        case 5:
                            dW2 = y1.f.w(i8, parcel);
                            break;
                        case 6:
                            fX = y1.f.x(i8, parcel);
                            break;
                        case 7:
                            iA4 = y1.f.A(i8, parcel);
                            break;
                        case '\b':
                            iA5 = y1.f.A(i8, parcel);
                            break;
                        case '\t':
                            iA3 = y1.f.A(i8, parcel);
                            break;
                        default:
                            y1.f.G(i8, parcel);
                            break;
                    }
                }
                y1.f.n(iH4, parcel);
                return new J(strJ3, iA4, s4, dW, dW2, fX, jB2, iA5, iA3);
            case 4:
                int iH5 = y1.f.H(parcel);
                String strJ4 = "";
                ArrayList arrayListK = null;
                PendingIntent pendingIntent3 = null;
                while (parcel.dataPosition() < iH5) {
                    int i9 = parcel.readInt();
                    char c6 = (char) i9;
                    if (c6 == 1) {
                        arrayListK = y1.f.k(i9, parcel);
                    } else if (c6 == 2) {
                        pendingIntent3 = (PendingIntent) y1.f.i(parcel, i9, PendingIntent.CREATOR);
                    } else if (c6 != 3) {
                        y1.f.G(i9, parcel);
                    } else {
                        strJ4 = y1.f.j(i9, parcel);
                    }
                }
                y1.f.n(iH5, parcel);
                return new K(arrayListK, pendingIntent3, strJ4);
            case 5:
                int iH6 = y1.f.H(parcel);
                String strJ5 = null;
                String strJ6 = null;
                String strJ7 = null;
                ArrayList arrayListM2 = null;
                E e5 = null;
                int iA6 = 0;
                while (parcel.dataPosition() < iH6) {
                    int i10 = parcel.readInt();
                    char c7 = (char) i10;
                    if (c7 == 1) {
                        iA6 = y1.f.A(i10, parcel);
                    } else if (c7 == 3) {
                        strJ5 = y1.f.j(i10, parcel);
                    } else if (c7 == 4) {
                        strJ6 = y1.f.j(i10, parcel);
                    } else if (c7 == 6) {
                        strJ7 = y1.f.j(i10, parcel);
                    } else if (c7 == 7) {
                        e5 = (E) y1.f.i(parcel, i10, E.CREATOR);
                    } else if (c7 != '\b') {
                        y1.f.G(i10, parcel);
                    } else {
                        arrayListM2 = y1.f.m(parcel, i10, C0787d.CREATOR);
                    }
                }
                y1.f.n(iH6, parcel);
                return new E(iA6, strJ5, strJ6, strJ7, arrayListM2, e5);
            case 6:
                int iH7 = y1.f.H(parcel);
                DeviceOrientationRequest deviceOrientationRequest = V.n;
                List listM = V.f378m;
                String strJ8 = null;
                while (parcel.dataPosition() < iH7) {
                    int i11 = parcel.readInt();
                    char c8 = (char) i11;
                    if (c8 == 1) {
                        deviceOrientationRequest = (DeviceOrientationRequest) y1.f.i(parcel, i11, DeviceOrientationRequest.CREATOR);
                    } else if (c8 == 2) {
                        listM = y1.f.m(parcel, i11, C0855f.CREATOR);
                    } else if (c8 != 3) {
                        y1.f.G(i11, parcel);
                    } else {
                        strJ8 = y1.f.j(i11, parcel);
                    }
                }
                y1.f.n(iH7, parcel);
                return new V(deviceOrientationRequest, listM, strJ8);
            case 7:
                int iH8 = y1.f.H(parcel);
                V v4 = null;
                IBinder iBinderZ6 = null;
                IBinder iBinderZ7 = null;
                int iA7 = 1;
                while (parcel.dataPosition() < iH8) {
                    int i12 = parcel.readInt();
                    char c9 = (char) i12;
                    if (c9 == 1) {
                        iA7 = y1.f.A(i12, parcel);
                    } else if (c9 == 2) {
                        v4 = (V) y1.f.i(parcel, i12, V.CREATOR);
                    } else if (c9 == 3) {
                        iBinderZ6 = y1.f.z(i12, parcel);
                    } else if (c9 != 4) {
                        y1.f.G(i12, parcel);
                    } else {
                        iBinderZ7 = y1.f.z(i12, parcel);
                    }
                }
                y1.f.n(iH8, parcel);
                return new W(iA7, v4, iBinderZ6, iBinderZ7);
            case 8:
                int iH9 = y1.f.H(parcel);
                Status status = null;
                while (parcel.dataPosition() < iH9) {
                    int i13 = parcel.readInt();
                    if (((char) i13) != 1) {
                        y1.f.G(i13, parcel);
                    } else {
                        status = (Status) y1.f.i(parcel, i13, Status.CREATOR);
                    }
                }
                y1.f.n(iH9, parcel);
                return new X(status);
            case 9:
                int iH10 = y1.f.H(parcel);
                long jB3 = 0;
                long jB4 = 0;
                int iA8 = 0;
                while (parcel.dataPosition() < iH10) {
                    int i14 = parcel.readInt();
                    char c10 = (char) i14;
                    if (c10 == 1) {
                        jB3 = y1.f.B(i14, parcel);
                    } else if (c10 == 2) {
                        iA8 = y1.f.A(i14, parcel);
                    } else if (c10 != 3) {
                        y1.f.G(i14, parcel);
                    } else {
                        jB4 = y1.f.B(i14, parcel);
                    }
                }
                y1.f.n(iH10, parcel);
                return new C0059d(jB3, iA8, jB4);
            case 10:
                int iH11 = y1.f.H(parcel);
                String strJ9 = null;
                String strJ10 = null;
                Y1 y12 = null;
                String strJ11 = null;
                C0112v c0112v = null;
                C0112v c0112v2 = null;
                C0112v c0112v3 = null;
                long jB5 = 0;
                long jB6 = 0;
                long jB7 = 0;
                boolean zU5 = false;
                while (parcel.dataPosition() < iH11) {
                    int i15 = parcel.readInt();
                    switch ((char) i15) {
                        case 2:
                            strJ9 = y1.f.j(i15, parcel);
                            break;
                        case 3:
                            strJ10 = y1.f.j(i15, parcel);
                            break;
                        case 4:
                            y12 = (Y1) y1.f.i(parcel, i15, Y1.CREATOR);
                            break;
                        case 5:
                            jB5 = y1.f.B(i15, parcel);
                            break;
                        case 6:
                            zU5 = y1.f.u(i15, parcel);
                            break;
                        case 7:
                            strJ11 = y1.f.j(i15, parcel);
                            break;
                        case '\b':
                            c0112v = (C0112v) y1.f.i(parcel, i15, C0112v.CREATOR);
                            break;
                        case '\t':
                            jB6 = y1.f.B(i15, parcel);
                            break;
                        case '\n':
                            c0112v2 = (C0112v) y1.f.i(parcel, i15, C0112v.CREATOR);
                            break;
                        case 11:
                            jB7 = y1.f.B(i15, parcel);
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            c0112v3 = (C0112v) y1.f.i(parcel, i15, C0112v.CREATOR);
                            break;
                        default:
                            y1.f.G(i15, parcel);
                            break;
                    }
                }
                y1.f.n(iH11, parcel);
                return new C0062e(strJ9, strJ10, y12, jB5, zU5, strJ11, c0112v, jB6, c0112v2, jB7, c0112v3);
            case 11:
                int iH12 = y1.f.H(parcel);
                Bundle bundleG = null;
                while (parcel.dataPosition() < iH12) {
                    int i16 = parcel.readInt();
                    if (((char) i16) != 1) {
                        y1.f.G(i16, parcel);
                    } else {
                        bundleG = y1.f.g(i16, parcel);
                    }
                }
                y1.f.n(iH12, parcel);
                return new C0074i(bundleG);
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                int iH13 = y1.f.H(parcel);
                Bundle bundleG2 = null;
                while (parcel.dataPosition() < iH13) {
                    int i17 = parcel.readInt();
                    if (((char) i17) != 2) {
                        y1.f.G(i17, parcel);
                    } else {
                        bundleG2 = y1.f.g(i17, parcel);
                    }
                }
                y1.f.n(iH13, parcel);
                return new C0109u(bundleG2);
            case o1.f.ERROR /* 13 */:
                int iH14 = y1.f.H(parcel);
                long jB8 = 0;
                String strJ12 = null;
                C0109u c0109u = null;
                String strJ13 = null;
                while (parcel.dataPosition() < iH14) {
                    int i18 = parcel.readInt();
                    char c11 = (char) i18;
                    if (c11 == 2) {
                        strJ12 = y1.f.j(i18, parcel);
                    } else if (c11 == 3) {
                        c0109u = (C0109u) y1.f.i(parcel, i18, C0109u.CREATOR);
                    } else if (c11 == 4) {
                        strJ13 = y1.f.j(i18, parcel);
                    } else if (c11 != 5) {
                        y1.f.G(i18, parcel);
                    } else {
                        jB8 = y1.f.B(i18, parcel);
                    }
                }
                y1.f.n(iH14, parcel);
                return new C0112v(strJ12, c0109u, strJ13, jB8);
            case o1.f.INTERRUPTED /* 14 */:
                int iH15 = y1.f.H(parcel);
                int iA9 = 0;
                long jB9 = 0;
                String strJ14 = null;
                while (parcel.dataPosition() < iH15) {
                    int i19 = parcel.readInt();
                    char c12 = (char) i19;
                    if (c12 == 1) {
                        strJ14 = y1.f.j(i19, parcel);
                    } else if (c12 == 2) {
                        jB9 = y1.f.B(i19, parcel);
                    } else if (c12 != 3) {
                        y1.f.G(i19, parcel);
                    } else {
                        iA9 = y1.f.A(i19, parcel);
                    }
                }
                y1.f.n(iH15, parcel);
                return new K1(iA9, strJ14, jB9);
            case 15:
                int iH16 = y1.f.H(parcel);
                byte[] bArr = null;
                String strJ15 = null;
                Bundle bundleG3 = null;
                String strJ16 = null;
                long jB10 = 0;
                long jB11 = 0;
                int iA10 = 0;
                while (parcel.dataPosition() < iH16) {
                    int i20 = parcel.readInt();
                    switch ((char) i20) {
                        case 1:
                            jB10 = y1.f.B(i20, parcel);
                            break;
                        case 2:
                            int iC = y1.f.C(i20, parcel);
                            int iDataPosition = parcel.dataPosition();
                            if (iC == 0) {
                                bArr = null;
                                break;
                            } else {
                                byte[] bArrCreateByteArray = parcel.createByteArray();
                                parcel.setDataPosition(iDataPosition + iC);
                                bArr = bArrCreateByteArray;
                                break;
                            }
                        case 3:
                            strJ15 = y1.f.j(i20, parcel);
                            break;
                        case 4:
                            bundleG3 = y1.f.g(i20, parcel);
                            break;
                        case 5:
                            iA10 = y1.f.A(i20, parcel);
                            break;
                        case 6:
                            jB11 = y1.f.B(i20, parcel);
                            break;
                        case 7:
                            strJ16 = y1.f.j(i20, parcel);
                            break;
                        default:
                            y1.f.G(i20, parcel);
                            break;
                    }
                }
                y1.f.n(iH16, parcel);
                return new N1(jB10, bArr, strJ15, bundleG3, iA10, jB11, strJ16);
            case 16:
                int iH17 = y1.f.H(parcel);
                while (true) {
                    ArrayList arrayList = null;
                    while (parcel.dataPosition() < iH17) {
                        int i21 = parcel.readInt();
                        if (((char) i21) != 1) {
                            y1.f.G(i21, parcel);
                        } else {
                            int iC2 = y1.f.C(i21, parcel);
                            int iDataPosition2 = parcel.dataPosition();
                            if (iC2 == 0) {
                                break;
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int i22 = parcel.readInt();
                            for (int i23 = 0; i23 < i22; i23++) {
                                arrayList2.add(Integer.valueOf(parcel.readInt()));
                            }
                            parcel.setDataPosition(iDataPosition2 + iC2);
                            arrayList = arrayList2;
                        }
                    }
                    y1.f.n(iH17, parcel);
                    return new O1(arrayList);
                    break;
                }
            case o1.f.API_NOT_CONNECTED /* 17 */:
                int iH18 = y1.f.H(parcel);
                ArrayList arrayListM3 = null;
                while (parcel.dataPosition() < iH18) {
                    int i24 = parcel.readInt();
                    if (((char) i24) != 1) {
                        y1.f.G(i24, parcel);
                    } else {
                        arrayListM3 = y1.f.m(parcel, i24, N1.CREATOR);
                    }
                }
                y1.f.n(iH18, parcel);
                return new P1(arrayListM3);
            case 18:
                int iH19 = y1.f.H(parcel);
                String strJ17 = null;
                Long lValueOf = null;
                Float fY = null;
                String strJ18 = null;
                String strJ19 = null;
                Double dValueOf = null;
                long jB12 = 0;
                int iA11 = 0;
                while (parcel.dataPosition() < iH19) {
                    int i25 = parcel.readInt();
                    switch ((char) i25) {
                        case 1:
                            iA11 = y1.f.A(i25, parcel);
                            break;
                        case 2:
                            strJ17 = y1.f.j(i25, parcel);
                            break;
                        case 3:
                            jB12 = y1.f.B(i25, parcel);
                            break;
                        case 4:
                            int iC3 = y1.f.C(i25, parcel);
                            if (iC3 == 0) {
                                lValueOf = null;
                                break;
                            } else {
                                y1.f.M(parcel, iC3, 8);
                                lValueOf = Long.valueOf(parcel.readLong());
                                break;
                            }
                        case 5:
                            fY = y1.f.y(i25, parcel);
                            break;
                        case 6:
                            strJ18 = y1.f.j(i25, parcel);
                            break;
                        case 7:
                            strJ19 = y1.f.j(i25, parcel);
                            break;
                        case '\b':
                            int iC4 = y1.f.C(i25, parcel);
                            if (iC4 == 0) {
                                dValueOf = null;
                                break;
                            } else {
                                y1.f.M(parcel, iC4, 8);
                                dValueOf = Double.valueOf(parcel.readDouble());
                                break;
                            }
                        default:
                            y1.f.G(i25, parcel);
                            break;
                    }
                }
                y1.f.n(iH19, parcel);
                return new Y1(iA11, strJ17, jB12, lValueOf, fY, strJ18, strJ19, dValueOf);
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                int iH20 = y1.f.H(parcel);
                boolean zU6 = false;
                int iA12 = 0;
                boolean zU7 = false;
                boolean zU8 = false;
                int iA13 = 0;
                int iA14 = 0;
                long jB13 = 0;
                long jB14 = 0;
                long jB15 = 0;
                long jB16 = 0;
                long jB17 = 0;
                long jB18 = 0;
                long jB19 = 0;
                String strJ20 = "";
                String strJ21 = strJ20;
                String strJ22 = strJ21;
                String strJ23 = strJ22;
                String strJ24 = null;
                String strJ25 = null;
                String strJ26 = null;
                String strJ27 = null;
                String strJ28 = null;
                String strJ29 = null;
                String strJ30 = null;
                Boolean boolValueOf = null;
                ArrayList arrayListK2 = null;
                String strJ31 = null;
                String strJ32 = null;
                String strJ33 = null;
                int iA15 = 100;
                boolean zU9 = true;
                boolean zU10 = true;
                long jB20 = -2147483648L;
                while (parcel.dataPosition() < iH20) {
                    int i26 = parcel.readInt();
                    switch ((char) i26) {
                        case 2:
                            strJ24 = y1.f.j(i26, parcel);
                            break;
                        case 3:
                            strJ25 = y1.f.j(i26, parcel);
                            break;
                        case 4:
                            strJ26 = y1.f.j(i26, parcel);
                            break;
                        case 5:
                            strJ27 = y1.f.j(i26, parcel);
                            break;
                        case 6:
                            jB13 = y1.f.B(i26, parcel);
                            break;
                        case 7:
                            jB14 = y1.f.B(i26, parcel);
                            break;
                        case '\b':
                            strJ28 = y1.f.j(i26, parcel);
                            break;
                        case '\t':
                            zU9 = y1.f.u(i26, parcel);
                            break;
                        case '\n':
                            zU6 = y1.f.u(i26, parcel);
                            break;
                        case 11:
                            jB20 = y1.f.B(i26, parcel);
                            break;
                        case FileClientSessionCache.MAX_SIZE /* 12 */:
                            strJ29 = y1.f.j(i26, parcel);
                            break;
                        case o1.f.ERROR /* 13 */:
                        case o1.f.API_NOT_CONNECTED /* 17 */:
                        case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                        case '!':
                        default:
                            y1.f.G(i26, parcel);
                            break;
                        case o1.f.INTERRUPTED /* 14 */:
                            jB15 = y1.f.B(i26, parcel);
                            break;
                        case 15:
                            iA12 = y1.f.A(i26, parcel);
                            break;
                        case 16:
                            zU10 = y1.f.u(i26, parcel);
                            break;
                        case 18:
                            zU7 = y1.f.u(i26, parcel);
                            break;
                        case o1.f.REMOTE_EXCEPTION /* 19 */:
                            strJ30 = y1.f.j(i26, parcel);
                            break;
                        case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                            int iC5 = y1.f.C(i26, parcel);
                            if (iC5 == 0) {
                                boolValueOf = null;
                                break;
                            } else {
                                y1.f.M(parcel, iC5, 4);
                                boolValueOf = Boolean.valueOf(parcel.readInt() != 0);
                                break;
                            }
                        case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                            jB16 = y1.f.B(i26, parcel);
                            break;
                        case 23:
                            arrayListK2 = y1.f.k(i26, parcel);
                            break;
                        case 24:
                            strJ31 = y1.f.j(i26, parcel);
                            break;
                        case 25:
                            strJ20 = y1.f.j(i26, parcel);
                            break;
                        case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                            strJ21 = y1.f.j(i26, parcel);
                            break;
                        case 27:
                            strJ32 = y1.f.j(i26, parcel);
                            break;
                        case 28:
                            zU8 = y1.f.u(i26, parcel);
                            break;
                        case 29:
                            jB17 = y1.f.B(i26, parcel);
                            break;
                        case 30:
                            iA15 = y1.f.A(i26, parcel);
                            break;
                        case 31:
                            strJ22 = y1.f.j(i26, parcel);
                            break;
                        case ' ':
                            iA13 = y1.f.A(i26, parcel);
                            break;
                        case '\"':
                            jB18 = y1.f.B(i26, parcel);
                            break;
                        case '#':
                            strJ33 = y1.f.j(i26, parcel);
                            break;
                        case '$':
                            strJ23 = y1.f.j(i26, parcel);
                            break;
                        case PinConfig.BITMAP_LENGTH_DP /* 37 */:
                            jB19 = y1.f.B(i26, parcel);
                            break;
                        case '&':
                            iA14 = y1.f.A(i26, parcel);
                            break;
                    }
                }
                y1.f.n(iH20, parcel);
                return new b2(strJ24, strJ25, strJ26, strJ27, jB13, jB14, strJ28, zU9, zU6, jB20, strJ29, jB15, iA12, zU10, zU7, strJ30, boolValueOf, jB16, arrayListK2, strJ31, strJ20, strJ21, strJ32, zU8, jB17, iA15, strJ22, iA13, jB18, strJ33, strJ23, jB19, iA14);
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                int iH21 = y1.f.H(parcel);
                Intent intent = null;
                int iA16 = 0;
                int iA17 = 0;
                while (parcel.dataPosition() < iH21) {
                    int i27 = parcel.readInt();
                    char c13 = (char) i27;
                    if (c13 == 1) {
                        iA16 = y1.f.A(i27, parcel);
                    } else if (c13 == 2) {
                        iA17 = y1.f.A(i27, parcel);
                    } else if (c13 != 3) {
                        y1.f.G(i27, parcel);
                    } else {
                        intent = (Intent) y1.f.i(parcel, i27, Intent.CREATOR);
                    }
                }
                y1.f.n(iH21, parcel);
                return new L1.b(iA16, iA17, intent);
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                int iH22 = y1.f.H(parcel);
                ArrayList arrayListK3 = null;
                String strJ34 = null;
                while (parcel.dataPosition() < iH22) {
                    int i28 = parcel.readInt();
                    char c14 = (char) i28;
                    if (c14 == 1) {
                        arrayListK3 = y1.f.k(i28, parcel);
                    } else if (c14 != 2) {
                        y1.f.G(i28, parcel);
                    } else {
                        strJ34 = y1.f.j(i28, parcel);
                    }
                }
                y1.f.n(iH22, parcel);
                return new L1.f(strJ34, arrayListK3);
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                int iH23 = y1.f.H(parcel);
                C0785b c0785b = null;
                int iA18 = 0;
                q1.w wVar = null;
                while (parcel.dataPosition() < iH23) {
                    int i29 = parcel.readInt();
                    char c15 = (char) i29;
                    if (c15 == 1) {
                        iA18 = y1.f.A(i29, parcel);
                    } else if (c15 == 2) {
                        c0785b = (C0785b) y1.f.i(parcel, i29, C0785b.CREATOR);
                    } else if (c15 != 3) {
                        y1.f.G(i29, parcel);
                    } else {
                        wVar = (q1.w) y1.f.i(parcel, i29, q1.w.CREATOR);
                    }
                }
                y1.f.n(iH23, parcel);
                return new L1.g(iA18, c0785b, wVar);
            case 23:
                R1.b bVar = new R1.b();
                bVar.f2258r = 255;
                bVar.f2260t = -2;
                bVar.f2261u = -2;
                bVar.f2262v = -2;
                bVar.f2241C = Boolean.TRUE;
                bVar.f2251j = parcel.readInt();
                bVar.f2252k = (Integer) parcel.readSerializable();
                bVar.f2253l = (Integer) parcel.readSerializable();
                bVar.f2254m = (Integer) parcel.readSerializable();
                bVar.n = (Integer) parcel.readSerializable();
                bVar.f2255o = (Integer) parcel.readSerializable();
                bVar.f2256p = (Integer) parcel.readSerializable();
                bVar.f2257q = (Integer) parcel.readSerializable();
                bVar.f2258r = parcel.readInt();
                bVar.f2259s = parcel.readString();
                bVar.f2260t = parcel.readInt();
                bVar.f2261u = parcel.readInt();
                bVar.f2262v = parcel.readInt();
                bVar.f2264x = parcel.readString();
                bVar.f2265y = parcel.readString();
                bVar.f2266z = parcel.readInt();
                bVar.f2240B = (Integer) parcel.readSerializable();
                bVar.f2242D = (Integer) parcel.readSerializable();
                bVar.f2243E = (Integer) parcel.readSerializable();
                bVar.f2244F = (Integer) parcel.readSerializable();
                bVar.f2245G = (Integer) parcel.readSerializable();
                bVar.f2246H = (Integer) parcel.readSerializable();
                bVar.I = (Integer) parcel.readSerializable();
                bVar.f2249L = (Integer) parcel.readSerializable();
                bVar.f2247J = (Integer) parcel.readSerializable();
                bVar.f2248K = (Integer) parcel.readSerializable();
                bVar.f2241C = (Boolean) parcel.readSerializable();
                bVar.f2263w = (Locale) parcel.readSerializable();
                bVar.f2250M = (Boolean) parcel.readSerializable();
                return bVar;
            case 24:
                S.l lVar = new S.l(parcel);
                lVar.f2351j = parcel.readInt();
                return lVar;
            case 25:
                int iH24 = y1.f.H(parcel);
                Bundle bundleG4 = null;
                while (parcel.dataPosition() < iH24) {
                    int i30 = parcel.readInt();
                    if (((char) i30) != 2) {
                        y1.f.G(i30, parcel);
                    } else {
                        bundleG4 = y1.f.g(i30, parcel);
                    }
                }
                y1.f.n(iH24, parcel);
                return new X2.r(bundleG4);
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                Y1.b bVar2 = new Y1.b(parcel);
                bVar2.f2939j = ((Integer) parcel.readValue(Y1.b.class.getClassLoader())).intValue();
                return bVar2;
            case 27:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new G(27);

                    /* renamed from: j, reason: collision with root package name */
                    public final int f3174j;

                    /* renamed from: k, reason: collision with root package name */
                    public final MediaDescriptionCompat f3175k;

                    {
                        this.f3174j = parcel.readInt();
                        this.f3175k = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.f3174j + ", mDescription=" + this.f3175k + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i31) {
                        parcel2.writeInt(this.f3174j);
                        this.f3175k.writeToParcel(parcel2, i31);
                    }
                };
            case 28:
                Object objCreateFromParcel = MediaDescription.CREATOR.createFromParcel(parcel);
                if (objCreateFromParcel == null) {
                    return null;
                }
                MediaDescription mediaDescription = (MediaDescription) objCreateFromParcel;
                String strG = android.support.v4.media.a.g(mediaDescription);
                CharSequence charSequenceI = android.support.v4.media.a.i(mediaDescription);
                CharSequence charSequenceH = android.support.v4.media.a.h(mediaDescription);
                CharSequence charSequenceC = android.support.v4.media.a.c(mediaDescription);
                Bitmap bitmapE = android.support.v4.media.a.e(mediaDescription);
                Uri uriF = android.support.v4.media.a.f(mediaDescription);
                Bundle bundleD = android.support.v4.media.a.d(mediaDescription);
                if (bundleD != null) {
                    bundleD = android.support.v4.media.session.b.i(bundleD);
                }
                Uri uriA = bundleD != null ? (Uri) bundleD.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
                if (uriA == null) {
                    bundle = bundleD;
                } else if (bundleD.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundleD.size() == 2) {
                    bundle = null;
                } else {
                    bundleD.remove("android.support.v4.media.description.MEDIA_URI");
                    bundleD.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                    bundle = bundleD;
                }
                if (uriA == null) {
                    uriA = android.support.v4.media.b.a(mediaDescription);
                }
                MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(strG, charSequenceI, charSequenceH, charSequenceC, bitmapE, uriF, bundle, uriA);
                mediaDescriptionCompat.f3183r = mediaDescription;
                return mediaDescriptionCompat;
            default:
                return new MediaMetadataCompat(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i5) {
        switch (this.f345a) {
            case 0:
                return new F[i5];
            case 1:
                return new H[i5];
            case 2:
                return new I[i5];
            case 3:
                return new J[i5];
            case 4:
                return new K[i5];
            case 5:
                return new E[i5];
            case 6:
                return new V[i5];
            case 7:
                return new W[i5];
            case 8:
                return new X[i5];
            case 9:
                return new C0059d[i5];
            case 10:
                return new C0062e[i5];
            case 11:
                return new C0074i[i5];
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return new C0109u[i5];
            case o1.f.ERROR /* 13 */:
                return new C0112v[i5];
            case o1.f.INTERRUPTED /* 14 */:
                return new K1[i5];
            case 15:
                return new N1[i5];
            case 16:
                return new O1[i5];
            case o1.f.API_NOT_CONNECTED /* 17 */:
                return new P1[i5];
            case 18:
                return new Y1[i5];
            case o1.f.REMOTE_EXCEPTION /* 19 */:
                return new b2[i5];
            case o1.f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                return new L1.b[i5];
            case o1.f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                return new L1.f[i5];
            case o1.f.RECONNECTION_TIMED_OUT /* 22 */:
                return new L1.g[i5];
            case 23:
                return new R1.b[i5];
            case 24:
                return new S.l[i5];
            case 25:
                return new X2.r[i5];
            case PinConfig.BITMAP_WIDTH_DP /* 26 */:
                return new Y1.b[i5];
            case 27:
                return new MediaBrowserCompat$MediaItem[i5];
            case 28:
                return new MediaDescriptionCompat[i5];
            default:
                return new MediaMetadataCompat[i5];
        }
    }
}
