package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.lang.reflect.InvocationTargetException;
import y0.AbstractC0976a;
import y0.C0977b;
import y0.InterfaceC0978c;

/* loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC0976a abstractC0976a) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        InterfaceC0978c interfaceC0978cH = remoteActionCompat.f3531a;
        if (abstractC0976a.e(1)) {
            interfaceC0978cH = abstractC0976a.h();
        }
        remoteActionCompat.f3531a = (IconCompat) interfaceC0978cH;
        CharSequence charSequence = remoteActionCompat.f3532b;
        if (abstractC0976a.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0977b) abstractC0976a).f10462e);
        }
        remoteActionCompat.f3532b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.f3533c;
        if (abstractC0976a.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C0977b) abstractC0976a).f10462e);
        }
        remoteActionCompat.f3533c = charSequence2;
        remoteActionCompat.f3534d = (PendingIntent) abstractC0976a.g(remoteActionCompat.f3534d, 4);
        boolean z4 = remoteActionCompat.f3535e;
        if (abstractC0976a.e(5)) {
            z4 = ((C0977b) abstractC0976a).f10462e.readInt() != 0;
        }
        remoteActionCompat.f3535e = z4;
        boolean z5 = remoteActionCompat.f3536f;
        if (abstractC0976a.e(6)) {
            z5 = ((C0977b) abstractC0976a).f10462e.readInt() != 0;
        }
        remoteActionCompat.f3536f = z5;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC0976a abstractC0976a) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        abstractC0976a.getClass();
        IconCompat iconCompat = remoteActionCompat.f3531a;
        abstractC0976a.i(1);
        abstractC0976a.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.f3532b;
        abstractC0976a.i(2);
        Parcel parcel = ((C0977b) abstractC0976a).f10462e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.f3533c;
        abstractC0976a.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        abstractC0976a.k(remoteActionCompat.f3534d, 4);
        boolean z4 = remoteActionCompat.f3535e;
        abstractC0976a.i(5);
        parcel.writeInt(z4 ? 1 : 0);
        boolean z5 = remoteActionCompat.f3536f;
        abstractC0976a.i(6);
        parcel.writeInt(z5 ? 1 : 0);
    }
}
