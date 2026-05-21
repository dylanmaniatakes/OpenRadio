package j0;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/* renamed from: j0.j, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0597j {

    /* renamed from: a, reason: collision with root package name */
    public final int f7552a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7553b;

    /* renamed from: c, reason: collision with root package name */
    public final long f7554c;

    /* renamed from: d, reason: collision with root package name */
    public final long f7555d;

    public C0597j(int i5, int i6, long j5, long j6) {
        this.f7552a = i5;
        this.f7553b = i6;
        this.f7554c = j5;
        this.f7555d = j6;
    }

    public static C0597j a(File file) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
        try {
            C0597j c0597j = new C0597j(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
            dataInputStream.close();
            return c0597j;
        } catch (Throwable th) {
            try {
                dataInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final void b(File file) throws IOException {
        file.delete();
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
        try {
            dataOutputStream.writeInt(this.f7552a);
            dataOutputStream.writeInt(this.f7553b);
            dataOutputStream.writeLong(this.f7554c);
            dataOutputStream.writeLong(this.f7555d);
            dataOutputStream.close();
        } catch (Throwable th) {
            try {
                dataOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof C0597j)) {
            return false;
        }
        C0597j c0597j = (C0597j) obj;
        return this.f7553b == c0597j.f7553b && this.f7554c == c0597j.f7554c && this.f7552a == c0597j.f7552a && this.f7555d == c0597j.f7555d;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f7553b), Long.valueOf(this.f7554c), Integer.valueOf(this.f7552a), Long.valueOf(this.f7555d));
    }
}
