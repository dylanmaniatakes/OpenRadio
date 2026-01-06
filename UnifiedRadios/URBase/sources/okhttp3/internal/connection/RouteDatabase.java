package okhttp3.internal.connection;

import F3.i;
import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

/* loaded from: classes.dex */
public final class RouteDatabase {
    private final Set<Route> failedRoutes = new LinkedHashSet();

    public final synchronized void connected(Route route) {
        i.f(route, "route");
        this.failedRoutes.remove(route);
    }

    public final synchronized void failed(Route route) {
        i.f(route, "failedRoute");
        this.failedRoutes.add(route);
    }

    public final synchronized boolean shouldPostpone(Route route) {
        i.f(route, "route");
        return this.failedRoutes.contains(route);
    }
}
