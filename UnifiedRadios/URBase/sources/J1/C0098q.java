package J1;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* renamed from: J1.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0098q extends F0 {

    /* renamed from: e, reason: collision with root package name */
    public long f1350e;

    /* renamed from: f, reason: collision with root package name */
    public String f1351f;

    @Override // J1.F0
    public final boolean k() {
        Calendar calendar = Calendar.getInstance();
        this.f1350e = TimeUnit.MINUTES.convert(calendar.get(16) + calendar.get(15), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.f1351f = language.toLowerCase(locale2) + "-" + locale.getCountry().toLowerCase(locale2);
        return false;
    }
}
