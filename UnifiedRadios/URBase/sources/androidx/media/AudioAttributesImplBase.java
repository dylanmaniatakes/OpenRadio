package androidx.media;

import com.unified.ur1.SatelliteTracker.h;
import java.util.Arrays;
import o1.f;
import org.conscrypt.FileClientSessionCache;

/* loaded from: classes.dex */
public class AudioAttributesImplBase implements AudioAttributesImpl {

    /* renamed from: a, reason: collision with root package name */
    public int f3986a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f3987b = 0;

    /* renamed from: c, reason: collision with root package name */
    public int f3988c = 0;

    /* renamed from: d, reason: collision with root package name */
    public int f3989d = -1;

    public final boolean equals(Object obj) {
        int i5;
        if (!(obj instanceof AudioAttributesImplBase)) {
            return false;
        }
        AudioAttributesImplBase audioAttributesImplBase = (AudioAttributesImplBase) obj;
        if (this.f3987b == audioAttributesImplBase.f3987b) {
            int i6 = this.f3988c;
            int i7 = audioAttributesImplBase.f3988c;
            int i8 = audioAttributesImplBase.f3989d;
            if (i8 == -1) {
                int i9 = audioAttributesImplBase.f3986a;
                int i10 = AudioAttributesCompat.f3982b;
                if ((i7 & 1) != 1) {
                    if ((i7 & 4) != 4) {
                        switch (i9) {
                            case 2:
                                i5 = 0;
                                break;
                            case 3:
                                i5 = 8;
                                break;
                            case 4:
                                i5 = 4;
                                break;
                            case 5:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                                i5 = 5;
                                break;
                            case 6:
                                i5 = 2;
                                break;
                            case 11:
                                i5 = 10;
                                break;
                            case FileClientSessionCache.MAX_SIZE /* 12 */:
                            default:
                                i5 = 3;
                                break;
                            case f.ERROR /* 13 */:
                                i5 = 1;
                                break;
                        }
                    } else {
                        i5 = 6;
                    }
                } else {
                    i5 = 7;
                }
            } else {
                i5 = i8;
            }
            if (i5 == 6) {
                i7 |= 4;
            } else if (i5 == 7) {
                i7 |= 1;
            }
            if (i6 == (i7 & 273) && this.f3986a == audioAttributesImplBase.f3986a && this.f3989d == i8) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3987b), Integer.valueOf(this.f3988c), Integer.valueOf(this.f3986a), Integer.valueOf(this.f3989d)});
    }

    public final String toString() {
        String strA;
        StringBuilder sb = new StringBuilder("AudioAttributesCompat:");
        if (this.f3989d != -1) {
            sb.append(" stream=");
            sb.append(this.f3989d);
            sb.append(" derived");
        }
        sb.append(" usage=");
        int i5 = this.f3986a;
        int i6 = AudioAttributesCompat.f3982b;
        switch (i5) {
            case 0:
                strA = "USAGE_UNKNOWN";
                break;
            case 1:
                strA = "USAGE_MEDIA";
                break;
            case 2:
                strA = "USAGE_VOICE_COMMUNICATION";
                break;
            case 3:
                strA = "USAGE_VOICE_COMMUNICATION_SIGNALLING";
                break;
            case 4:
                strA = "USAGE_ALARM";
                break;
            case 5:
                strA = "USAGE_NOTIFICATION";
                break;
            case 6:
                strA = "USAGE_NOTIFICATION_RINGTONE";
                break;
            case 7:
                strA = "USAGE_NOTIFICATION_COMMUNICATION_REQUEST";
                break;
            case 8:
                strA = "USAGE_NOTIFICATION_COMMUNICATION_INSTANT";
                break;
            case 9:
                strA = "USAGE_NOTIFICATION_COMMUNICATION_DELAYED";
                break;
            case 10:
                strA = "USAGE_NOTIFICATION_EVENT";
                break;
            case 11:
                strA = "USAGE_ASSISTANCE_ACCESSIBILITY";
                break;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                strA = "USAGE_ASSISTANCE_NAVIGATION_GUIDANCE";
                break;
            case f.ERROR /* 13 */:
                strA = "USAGE_ASSISTANCE_SONIFICATION";
                break;
            case f.INTERRUPTED /* 14 */:
                strA = "USAGE_GAME";
                break;
            case 15:
            default:
                strA = h.a(i5, "unknown usage ");
                break;
            case 16:
                strA = "USAGE_ASSISTANT";
                break;
        }
        sb.append(strA);
        sb.append(" content=");
        sb.append(this.f3987b);
        sb.append(" flags=0x");
        sb.append(Integer.toHexString(this.f3988c).toUpperCase());
        return sb.toString();
    }
}
