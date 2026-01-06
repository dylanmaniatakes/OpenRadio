package L;

import com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity;
import com.unified.ur1.inbox.Message;
import java.util.Comparator;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1506a;

    public /* synthetic */ a(int i5) {
        this.f1506a = i5;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) throws NumberFormatException {
        switch (this.f1506a) {
            case 0:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i5 = 0; i5 < bArr.length; i5++) {
                    byte b5 = bArr[i5];
                    byte b6 = bArr2[i5];
                    if (b5 != b6) {
                        return b5 - b6;
                    }
                }
                return 0;
            case 1:
                return SatelliteTrackerActivity.lambda$updateSatelliteCalculations$11((SatelliteTrackerActivity.SatellitePass) obj, (SatelliteTrackerActivity.SatellitePass) obj2);
            default:
                Message message = (Message) obj;
                Message message2 = (Message) obj2;
                try {
                    return Long.compare(Long.parseLong(message2.getCreatedAt()), Long.parseLong(message.getCreatedAt()));
                } catch (Exception unused) {
                    return message2.getCreatedAt().compareTo(message.getCreatedAt());
                }
        }
    }
}
