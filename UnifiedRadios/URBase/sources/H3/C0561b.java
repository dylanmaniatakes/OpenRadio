package h3;

import android.util.SparseIntArray;
import com.unified.ur1.R;

/* renamed from: h3.b, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0561b extends AbstractC0560a {

    /* renamed from: p, reason: collision with root package name */
    public static final SparseIntArray f7084p;

    /* renamed from: o, reason: collision with root package name */
    public long f7085o;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f7084p = sparseIntArray;
        sparseIntArray.put(R.id.screen_lock, 1);
        sparseIntArray.put(R.id.waiting, 2);
        sparseIntArray.put(R.id.incompatibility_overlay, 3);
        sparseIntArray.put(R.id.rxAudioCircle, 4);
        sparseIntArray.put(R.id.txAudioCircle, 5);
        sparseIntArray.put(R.id.mainTopLevelLayout, 6);
        sparseIntArray.put(R.id.time, 7);
        sparseIntArray.put(R.id.imageView, 8);
        sparseIntArray.put(R.id.battery, 9);
        sparseIntArray.put(R.id.unified, 10);
        sparseIntArray.put(R.id.playbackButton, 11);
        sparseIntArray.put(R.id.frequencyContainer, 12);
        sparseIntArray.put(R.id.locFlag, 13);
        sparseIntArray.put(R.id.activeMemoryName, 14);
        sparseIntArray.put(R.id.ip_image1, 15);
        sparseIntArray.put(R.id.ip_aprs, 16);
        sparseIntArray.put(R.id.ip_image2, 17);
        sparseIntArray.put(R.id.ip_image3, 18);
        sparseIntArray.put(R.id.IP, 19);
        sparseIntArray.put(R.id.activeFrequency, 20);
        sparseIntArray.put(R.id.network, 21);
        sparseIntArray.put(R.id.status, 22);
        sparseIntArray.put(R.id.MODE, 23);
        sparseIntArray.put(R.id.DUP, 24);
        sparseIntArray.put(R.id.aprs, 25);
        sparseIntArray.put(R.id.textView, 26);
        sparseIntArray.put(R.id.roip_banner_card, 27);
        sparseIntArray.put(R.id.ROIP_Connection, 28);
        sparseIntArray.put(R.id.roip_disconnect, 29);
        sparseIntArray.put(R.id.ROIP_Close, 30);
        sparseIntArray.put(R.id.voiceModeLineHolder, 31);
        sparseIntArray.put(R.id.groupSelector, 32);
        sparseIntArray.put(R.id.dtmf_keypad, 33);
        sparseIntArray.put(R.id.CallerID, 34);
        sparseIntArray.put(R.id.voiceModeBottomControls, 35);
        sparseIntArray.put(R.id.textModeContainer, 36);
        sparseIntArray.put(R.id.textChatScrollView, 37);
        sparseIntArray.put(R.id.textChatLog, 38);
        sparseIntArray.put(R.id.textChatTo, 39);
        sparseIntArray.put(R.id.textChatInput, 40);
        sparseIntArray.put(R.id.sendButton, 41);
        sparseIntArray.put(R.id.sendButtonOverlay, 42);
        sparseIntArray.put(R.id.bottomNavigationView1, 43);
        sparseIntArray.put(R.id.bottomNavigationView, 44);
        sparseIntArray.put(R.id.pttButton, 45);
        sparseIntArray.put(R.id.sourceView, 46);
        sparseIntArray.put(R.id.imagedistance, 47);
        sparseIntArray.put(R.id.locView, 48);
        sparseIntArray.put(R.id.buttonbar, 49);
        sparseIntArray.put(R.id.scanButton, 50);
        sparseIntArray.put(R.id.messageButton, 51);
        sparseIntArray.put(R.id.mailBadge, 52);
        sparseIntArray.put(R.id.optionsButton, 53);
        sparseIntArray.put(R.id.validate, 54);
        sparseIntArray.put(R.id.expiredDownload, 55);
        sparseIntArray.put(R.id.download_button, 56);
        sparseIntArray.put(R.id.popupMenuOverlay, 57);
        sparseIntArray.put(R.id.menuItemRadioTeams, 58);
        sparseIntArray.put(R.id.menuItemOnTheAir, 59);
        sparseIntArray.put(R.id.menuItemOptions, 60);
    }

    @Override // androidx.databinding.e
    public final void w() {
        synchronized (this) {
            this.f7085o = 0L;
        }
    }

    @Override // androidx.databinding.e
    public final boolean x() {
        synchronized (this) {
            try {
                return this.f7085o != 0;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
