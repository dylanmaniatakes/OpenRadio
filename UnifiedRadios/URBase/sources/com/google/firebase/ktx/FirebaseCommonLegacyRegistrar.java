package com.google.firebase.ktx;

import F2.b;
import androidx.annotation.Keep;
import com.google.android.gms.internal.measurement.AbstractC0296a2;
import com.google.android.gms.internal.measurement.D1;
import com.google.firebase.components.ComponentRegistrar;
import java.util.List;

@Keep
/* loaded from: classes.dex */
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<b> getComponents() {
        return AbstractC0296a2.i(D1.d("fire-core-ktx", "21.0.0"));
    }
}
