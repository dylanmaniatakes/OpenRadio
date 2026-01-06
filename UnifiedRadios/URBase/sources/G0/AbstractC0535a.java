package g0;

import F3.i;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.internal.measurement.InterfaceC0341j2;
import com.google.android.gms.internal.measurement.V1;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.SatelliteTracker.h;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import o1.f;
import org.conscrypt.FileClientSessionCache;
import s.AbstractC0882e;

/* renamed from: g0.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract /* synthetic */ class AbstractC0535a {
    public static /* synthetic */ String A(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? i5 != 4 ? "null" : "INVISIBLE" : "GONE" : "VISIBLE" : "REMOVED";
    }

    public static final void a(View view, int i5) {
        int iC = AbstractC0882e.c(i5);
        if (iC == 0) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup != null) {
                if (Log.isLoggable("FragmentManager", 2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: Removing view " + view + " from container " + viewGroup);
                }
                viewGroup.removeView(view);
                return;
            }
            return;
        }
        if (iC == 1) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to VISIBLE");
            }
            view.setVisibility(0);
            return;
        }
        if (iC == 2) {
            if (Log.isLoggable("FragmentManager", 2)) {
                Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to GONE");
            }
            view.setVisibility(8);
            return;
        }
        if (iC != 3) {
            return;
        }
        if (Log.isLoggable("FragmentManager", 2)) {
            Log.v("FragmentManager", "SpecialEffectsController: Setting view " + view + " to INVISIBLE");
        }
        view.setVisibility(4);
    }

    public static int b(int i5) {
        if (i5 == 0) {
            return 2;
        }
        if (i5 == 4) {
            return 4;
        }
        if (i5 == 8) {
            return 3;
        }
        throw new IllegalArgumentException(h.a(i5, "Unknown visibility "));
    }

    public static int c(View view) {
        if (view.getAlpha() == BitmapDescriptorFactory.HUE_RED && view.getVisibility() == 0) {
            return 4;
        }
        return b(view.getVisibility());
    }

    public static final boolean d(int i5) {
        return i5 == 3 || i5 == 4 || i5 == 6;
    }

    public static int e(int i5) {
        switch (i5) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 4;
            case 4:
                return 5;
            case 5:
                return 6;
            case 6:
                return 7;
            case 7:
                return 8;
            case 8:
                return 9;
            default:
                switch (i5) {
                    case f.CONNECTION_SUSPENDED_DURING_CALL /* 20 */:
                        return 10;
                    case f.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                        return 11;
                    case f.RECONNECTION_TIMED_OUT /* 22 */:
                        return 12;
                    default:
                        return 0;
                }
        }
    }

    public static /* synthetic */ int f(int i5) {
        switch (i5) {
            case 1:
                return 0;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            case 8:
                return 7;
            case 9:
                return 8;
            case 10:
                return 20;
            case 11:
                return 21;
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return 22;
            default:
                throw null;
        }
    }

    public static int g(int i5, int i6, int i7) {
        return V1.D(i5) + i6 + i7;
    }

    public static String h(long j5, String str) {
        return str + j5;
    }

    public static String i(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.C());
        return sb.toString();
    }

    public static String j(String str, int i5, String str2) {
        return str + i5 + str2;
    }

    public static String k(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static String l(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static StringBuilder m(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static HashMap n(Class cls, M2.a aVar) {
        HashMap map = new HashMap();
        map.put(cls, aVar);
        return map;
    }

    public static Map o(HashMap map) {
        return Collections.unmodifiableMap(new HashMap(map));
    }

    public static /* synthetic */ void p(int i5, String str) {
        if (i5 != 0) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(i.i(str));
        i.j(nullPointerException, i.class.getName());
        throw nullPointerException;
    }

    public static void q(J1.V1 v12) {
        v12.e().j();
        v12.k();
    }

    public static /* synthetic */ void r(Parcelable parcelable) {
        if (parcelable != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ void s(InterfaceC0341j2 interfaceC0341j2) {
        if (interfaceC0341j2 != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ void t(Object obj) {
        throw new ClassCastException();
    }

    public static void u(String str, int i5, String str2) {
        Log.d(str2, str + i5);
    }

    public static void v(String str, String str2, String str3) {
        Log.d(str3, str + str2);
    }

    public static /* synthetic */ String w(int i5) {
        switch (i5) {
            case 1:
                return "CLIENT_UPLOAD_ELIGIBILITY_UNKNOWN";
            case 2:
                return "CLIENT_UPLOAD_ELIGIBLE";
            case 3:
                return "MEASUREMENT_SERVICE_NOT_ENABLED";
            case 4:
                return "ANDROID_TOO_OLD";
            case 5:
                return "NON_PLAY_MODE";
            case 6:
                return "SDK_TOO_OLD";
            case 7:
                return "MISSING_JOB_SCHEDULER";
            case 8:
                return "NOT_ENABLED_IN_MANIFEST";
            case 9:
                return "CLIENT_FLAG_OFF";
            case 10:
                return "SERVICE_FLAG_OFF";
            case 11:
                return "PINNED_TO_SERVICE_UPLOAD";
            case FileClientSessionCache.MAX_SIZE /* 12 */:
                return "MISSING_SGTM_SERVER_URL";
            default:
                throw null;
        }
    }

    public static /* synthetic */ String x(int i5) {
        switch (i5) {
            case 1:
                return "NOT_REQUIRED";
            case 2:
                return "CONNECTED";
            case 3:
                return "UNMETERED";
            case 4:
                return "NOT_ROAMING";
            case 5:
                return "METERED";
            case 6:
                return "TEMPORARILY_UNMETERED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String y(int i5) {
        switch (i5) {
            case 1:
                return "ENQUEUED";
            case 2:
                return "RUNNING";
            case 3:
                return "SUCCEEDED";
            case 4:
                return "FAILED";
            case 5:
                return "BLOCKED";
            case 6:
                return "CANCELLED";
            default:
                return "null";
        }
    }

    public static /* synthetic */ String z(int i5) {
        return i5 != 1 ? i5 != 2 ? i5 != 3 ? "null" : "REMOVING" : "ADDING" : "NONE";
    }
}
