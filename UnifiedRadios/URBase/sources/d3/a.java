package d3;

import L0.s;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final s f6113a = new s(14);

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(String str) {
        String string;
        s sVar = f6113a;
        if (str == 0) {
            string = "null";
        } else {
            sVar.getClass();
            string = !str.getClass().isArray() ? str.toString() : str instanceof boolean[] ? Arrays.toString((boolean[]) str) : str instanceof byte[] ? Arrays.toString((byte[]) str) : str instanceof char[] ? Arrays.toString((char[]) str) : str instanceof short[] ? Arrays.toString((short[]) str) : str instanceof int[] ? Arrays.toString((int[]) str) : str instanceof long[] ? Arrays.toString((long[]) str) : str instanceof float[] ? Arrays.toString((float[]) str) : str instanceof double[] ? Arrays.toString((double[]) str) : str instanceof Object[] ? Arrays.deepToString((Object[]) str) : "Couldn't find a correct type for the object";
        }
        sVar.m(3, null, string, new Object[0]);
    }

    public static void b(String str, Object... objArr) {
        f6113a.m(6, null, str, objArr);
    }
}
