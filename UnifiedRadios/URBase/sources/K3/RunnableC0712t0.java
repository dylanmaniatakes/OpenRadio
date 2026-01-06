package k3;

import android.text.SpannableStringBuilder;
import android.text.style.RelativeSizeSpan;
import android.widget.TextView;
import com.unified.ur1.R;
import com.unified.ur1.primary.LaunchActivity;

/* renamed from: k3.t0, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class RunnableC0712t0 implements Runnable {

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ int f8207j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ int[] f8208k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f8209l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f8210m;
    public final /* synthetic */ int n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ int f8211o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ int f8212p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ int f8213q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ int f8214r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ int f8215s;

    /* renamed from: t, reason: collision with root package name */
    public final /* synthetic */ String f8216t;

    /* renamed from: u, reason: collision with root package name */
    public final /* synthetic */ LaunchActivity f8217u;

    public RunnableC0712t0(LaunchActivity launchActivity, int i5, int[] iArr, long j5, long j6, int i6, int i7, int i8, int i9, int i10, int i11, String str) {
        this.f8217u = launchActivity;
        this.f8207j = i5;
        this.f8208k = iArr;
        this.f8209l = j5;
        this.f8210m = j6;
        this.n = i6;
        this.f8211o = i7;
        this.f8212p = i8;
        this.f8213q = i9;
        this.f8214r = i10;
        this.f8215s = i11;
        this.f8216t = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i5;
        int i6;
        LaunchActivity launchActivity = this.f8217u;
        TextView textView = (TextView) launchActivity.findViewById(R.id.MODE);
        TextView textView2 = (TextView) launchActivity.findViewById(R.id.DUP);
        int i7 = this.f8207j;
        int[] iArr = this.f8208k;
        if (i7 == 0) {
            iArr[0] = 1;
            i5 = 1;
        } else {
            iArr[0] = 2;
            i5 = 2;
        }
        long j5 = this.f8209l;
        long j6 = this.f8210m;
        if (j5 > j6) {
            textView2.setText("DUP +");
        } else if (j5 < j6) {
            textView2.setText("DUP -");
        } else {
            textView2.setText("Smplx");
        }
        TextView textView3 = (TextView) launchActivity.findViewById(R.id.activeFrequency);
        textView3.setClickable(true);
        if (launchActivity.f5970w.equals("FM")) {
            int i8 = this.f8211o;
            int i9 = this.n;
            if (i9 == 1) {
                LaunchActivity.k(launchActivity, i9, i8);
                textView.setText("FM - CTCSS | ");
            } else if (i9 == 2) {
                LaunchActivity.k(launchActivity, i9, i8);
                textView.setText("FM - DCS | ");
            } else if (i9 == 3) {
                LaunchActivity.k(launchActivity, i9, i8);
                textView.setText("FM - R-DCS | ");
            } else if (i9 == 0 && (i6 = this.f8212p) == 1) {
                LaunchActivity.k(launchActivity, i6, this.f8213q);
                textView.setText("FM - Tone | ");
            } else {
                textView.setText("FM | ");
            }
        } else {
            textView.setText(String.format("TG: %d | CC: %d | TS: %d | ", Integer.valueOf(this.f8214r), Integer.valueOf(this.f8215s), Integer.valueOf(i5)));
        }
        textView3.setText("Ready");
        String str = this.f8216t;
        if (str.length() > 7) {
            String strSubstring = str.substring(0, str.length() - 2);
            String strSubstring2 = str.substring(str.length() - 2);
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(com.unified.ur1.SatelliteTracker.h.b(strSubstring, strSubstring2));
            spannableStringBuilder.setSpan(new RelativeSizeSpan(0.25f), strSubstring.length(), strSubstring2.length() + strSubstring.length(), 33);
            textView3.setText(spannableStringBuilder);
        } else if (str.isEmpty()) {
            textView3.setText("Ready");
        } else {
            textView3.setText(str);
        }
        launchActivity.f5897S = str;
    }
}
