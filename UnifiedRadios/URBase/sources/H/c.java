package H;

import android.location.Location;

/* loaded from: classes.dex */
public abstract class c {
    public static float a(Location location) {
        return location.getBearingAccuracyDegrees();
    }

    public static float b(Location location) {
        return location.getSpeedAccuracyMetersPerSecond();
    }

    public static float c(Location location) {
        return location.getVerticalAccuracyMeters();
    }

    public static boolean d(Location location) {
        return location.hasBearingAccuracy();
    }

    public static boolean e(Location location) {
        return location.hasSpeedAccuracy();
    }

    public static boolean f(Location location) {
        return location.hasVerticalAccuracy();
    }

    public static void g(Location location, float f5) {
        location.setBearingAccuracyDegrees(f5);
    }

    public static void h(Location location, float f5) {
        location.setSpeedAccuracyMetersPerSecond(f5);
    }

    public static void i(Location location, float f5) {
        location.setVerticalAccuracyMeters(f5);
    }
}
