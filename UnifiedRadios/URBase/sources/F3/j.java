package F3;

import java.io.Serializable;

/* loaded from: classes.dex */
public abstract class j implements g, Serializable {
    private final int arity;

    public j(int i5) {
        this.arity = i5;
    }

    @Override // F3.g
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        m.f603a.getClass();
        String strA = n.a(this);
        i.e(strA, "renderLambdaToString(this)");
        return strA;
    }
}
