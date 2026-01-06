package m3;

import android.util.Log;
import k3.C0675a0;
import n3.C0805a;
import q3.AbstractC0869a;
import s.AbstractC0882e;

/* renamed from: m3.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0774j {

    /* renamed from: a, reason: collision with root package name */
    public static volatile C0774j f8608a;

    /* renamed from: b, reason: collision with root package name */
    public static final int[] f8609b = {0, 4129, 8258, 12387, 16516, 20645, 24774, 28903, 33032, 37161, 41290, 45419, 49548, 53677, 57806, 61935, 4657, 528, 12915, 8786, 21173, 17044, 29431, 25302, 37689, 33560, 45947, 41818, 54205, 50076, 62463, 58334, 9314, 13379, 1056, 5121, 25830, 29895, 17572, 21637, 42346, 46411, 34088, 38153, 58862, 62927, 50604, 54669, 13907, 9842, 5649, 1584, 30423, 26358, 22165, 18100, 46939, 42874, 38681, 34616, 63455, 59390, 55197, 51132, 18628, 22757, 26758, 30887, 2112, 6241, 10242, 14371, 51660, 55789, 59790, 63919, 35144, 39273, 43274, 47403, 23285, 19156, 31415, 27286, 6769, 2640, 14899, 10770, 56317, 52188, 64447, 60318, 39801, 35672, 47931, 43802, 27814, 31879, 19684, 23749, 11298, 15363, 3168, 7233, 60846, 64911, 52716, 56781, 44330, 48395, 36200, 40265, 32407, 28342, 24277, 20212, 15891, 11826, 7761, 3696, 65439, 61374, 57309, 53244, 48923, 44858, 40793, 36728, 37256, 33193, 45514, 41451, 53516, 49453, 61774, 57711, 4224, 161, 12482, 8419, 20484, 16421, 28742, 24679, 33721, 37784, 41979, 46042, 49981, 54044, 58239, 62302, 689, 4752, 8947, 13010, 16949, 21012, 25207, 29270, 46570, 42443, 38312, 34185, 62830, 58703, 54572, 50445, 13538, 9411, 5280, 1153, 29798, 25671, 21540, 17413, 42971, 47098, 34713, 38840, 59231, 63358, 50973, 55100, 9939, 14066, 1681, 5808, 26199, 30326, 17941, 22068, 55628, 51565, 63758, 59695, 39368, 35305, 47498, 43435, 22596, 18533, 30726, 26663, 6336, 2273, 14466, 10403, 52093, 56156, 60223, 64286, 35833, 39896, 43963, 48026, 19061, 23124, 27191, 31254, 2801, 6864, 10931, 14994, 64814, 60687, 56684, 52557, 48554, 44427, 40424, 36297, 31782, 27655, 23652, 19525, 15522, 11395, 7392, 3265, 61215, 65342, 53085, 57212, 44955, 49082, 36825, 40952, 28183, 32310, 20053, 24180, 11923, 16050, 3793, 7920};

    /* renamed from: c, reason: collision with root package name */
    public static C0774j f8610c;

    public static C0774j a() {
        if (f8608a == null) {
            synchronized (C0774j.class) {
                try {
                    if (f8608a == null) {
                        f8608a = new C0774j();
                    }
                } finally {
                }
            }
        }
        return f8608a;
    }

    public static void b(C0675a0 c0675a0) {
        C0773i c0773i = new C0773i(c0675a0);
        String strA = AbstractC0869a.a(1, 2);
        String string = "";
        for (int length = strA.length(); length > 0; length -= 2) {
            StringBuilder sbB = AbstractC0882e.b(string);
            sbB.append(strA.substring(length - 2, length));
            string = sbB.toString();
        }
        String strA2 = new D0.w("34", string).a();
        Log.d("Unified - DmrBusiness", "Sending version command: " + strA2);
        c(strA2, c0773i);
    }

    public static void c(String str, v vVar) {
        HandlerThreadC0775k handlerThreadC0775kA = HandlerThreadC0775k.a();
        str.substring(0, 2);
        String strSubstring = str.substring(2, 4);
        str.substring(4, 6);
        str.substring(6, 8);
        int i5 = Integer.parseInt(str.substring(12, 16), 16) * 2;
        int i6 = i5 + 16;
        str.substring(16, i6);
        str.substring(i6, i5 + 18);
        handlerThreadC0775kA.h(strSubstring, vVar);
        HandlerThreadC0775k.a().g(str);
        try {
            Thread.sleep(10L);
            HandlerThreadC0775k.a().g(str);
        } catch (InterruptedException e5) {
            throw new RuntimeException(e5);
        }
    }

    public static void d(C0765a c0765a, C0805a c0805a) {
        String strA = new D0.w("23", C0765a.b(c0765a.f8567b) + C0765a.b(c0765a.f8568c) + String.format("%02X", Integer.valueOf(c0765a.f8569d)) + String.format("%02X", Integer.valueOf(c0765a.f8570e)) + String.format("%02X", Integer.valueOf(c0765a.f8571f)) + String.format("%02X", Integer.valueOf(c0765a.g)) + String.format("%02X", Integer.valueOf(c0765a.h)) + String.format("%02X", Integer.valueOf(c0765a.f8572i)) + String.format("%02X", Integer.valueOf(c0765a.f8573j)) + String.format("%02X", Integer.valueOf(c0765a.f8574k)) + String.format("%02X", Integer.valueOf(c0765a.f8575l)) + String.format("%02X", Integer.valueOf(c0765a.f8576m)) + String.format("%02X", Integer.valueOf(c0765a.n))).a();
        StringBuilder sb = new StringBuilder("setAnalogChannel cmd = ");
        sb.append(strA);
        Log.e("Unified - DmrBusiness", sb.toString());
        c(strA, c0805a);
    }

    public static void e(C0766b c0766b, C0805a c0805a) {
        StringBuilder sb = new StringBuilder();
        sb.append(C0766b.a(c0766b.f8577a));
        sb.append(C0766b.a(c0766b.f8578b));
        sb.append(C0766b.b(c0766b.f8579c));
        int[] iArr = c0766b.f8590q;
        if (iArr != null) {
            for (int i5 : iArr) {
                sb.append(C0766b.b(i5));
            }
        }
        int length = 32 - (iArr != null ? iArr.length : 0);
        for (int i6 = 0; i6 < length; i6++) {
            sb.append("00000000");
        }
        sb.append(C0766b.b(c0766b.f8580d));
        sb.append(C0766b.c(c0766b.f8581e));
        sb.append(C0766b.c(c0766b.f8582f));
        sb.append(C0766b.c(c0766b.g));
        sb.append(C0766b.c(c0766b.h));
        sb.append(C0766b.c(c0766b.f8583i));
        sb.append(C0766b.c(c0766b.f8584j));
        sb.append(C0766b.c(c0766b.f8585k));
        for (byte b5 : c0766b.f8586l.getBytes()) {
            sb.append(String.format("%02X", Byte.valueOf(b5)));
        }
        sb.append(C0766b.c(c0766b.f8587m));
        sb.append(C0766b.c(c0766b.n));
        sb.append(C0766b.c(c0766b.f8588o));
        sb.append(C0766b.c(c0766b.f8589p));
        String strA = new D0.w("22", sb.toString()).a();
        Log.d("Unified - DmrBusiness", "Sending digital channel command: " + strA);
        c(strA, c0805a);
    }

    public static void f(int i5, v vVar) {
        Log.w("Unified - DmrBusiness", "setting setMicGain to " + i5);
        c(new D0.w("2A", AbstractC0869a.a(i5, 2)).a(), vVar);
    }
}
