package n3;

import D0.w;
import android.util.Log;
import m3.v;

/* renamed from: n3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final /* synthetic */ class C0805a implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8882a;

    public /* synthetic */ C0805a(int i5) {
        this.f8882a = i5;
    }

    @Override // m3.v
    public final void a(w wVar) {
        switch (this.f8882a) {
            case 0:
                Log.d("Unified - AnalogProgramming", "Analog channel setup response: " + wVar.toString());
                break;
            case 1:
                Log.d("Unified - AnalogProgramming", "setMicGain Change response: " + wVar.toString());
                break;
            case 2:
                Log.d("Unified - AnalogProgramming", "Volume Change response: " + wVar.toString());
                break;
            case 3:
                Log.d("Unified - ProgrammingThread", "Digital channel setup response: " + wVar.toString());
                break;
            case 4:
                Log.d("Unified - ProgrammingThread", "Volume Change response: " + wVar.toString());
                break;
            default:
                Log.d("Unified - ProgrammingThread", "setMicGain Change response: " + wVar.toString());
                break;
        }
    }
}
