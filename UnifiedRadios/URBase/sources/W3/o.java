package W3;

import com.google.android.gms.internal.measurement.D1;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class o implements Serializable, Comparable {

    /* renamed from: m, reason: collision with root package name */
    public static final o f2649m = new o(new byte[0]);

    /* renamed from: j, reason: collision with root package name */
    public final byte[] f2650j;

    /* renamed from: k, reason: collision with root package name */
    public transient int f2651k;

    /* renamed from: l, reason: collision with root package name */
    public transient String f2652l;

    public o(byte[] bArr) {
        F3.i.f(bArr, "data");
        this.f2650j = bArr;
    }

    public String a() {
        byte[] bArr = AbstractC0188a.f2628a;
        byte[] bArr2 = this.f2650j;
        F3.i.f(bArr2, "<this>");
        F3.i.f(bArr, "map");
        byte[] bArr3 = new byte[((bArr2.length + 2) / 3) * 4];
        int length = bArr2.length - (bArr2.length % 3);
        int i5 = 0;
        int i6 = 0;
        while (i5 < length) {
            byte b5 = bArr2[i5];
            int i7 = i5 + 2;
            byte b6 = bArr2[i5 + 1];
            i5 += 3;
            byte b7 = bArr2[i7];
            bArr3[i6] = bArr[(b5 & 255) >> 2];
            bArr3[i6 + 1] = bArr[((b5 & 3) << 4) | ((b6 & 255) >> 4)];
            int i8 = i6 + 3;
            bArr3[i6 + 2] = bArr[((b6 & 15) << 2) | ((b7 & 255) >> 6)];
            i6 += 4;
            bArr3[i8] = bArr[b7 & 63];
        }
        int length2 = bArr2.length - length;
        if (length2 == 1) {
            byte b8 = bArr2[i5];
            bArr3[i6] = bArr[(b8 & 255) >> 2];
            bArr3[i6 + 1] = bArr[(b8 & 3) << 4];
            bArr3[i6 + 2] = 61;
            bArr3[i6 + 3] = 61;
        } else if (length2 == 2) {
            int i9 = i5 + 1;
            byte b9 = bArr2[i5];
            byte b10 = bArr2[i9];
            bArr3[i6] = bArr[(b9 & 255) >> 2];
            bArr3[i6 + 1] = bArr[((b9 & 3) << 4) | ((b10 & 255) >> 4)];
            bArr3[i6 + 2] = bArr[(b10 & 15) << 2];
            bArr3[i6 + 3] = 61;
        }
        return new String(bArr3, M3.a.f1740a);
    }

    public o b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        messageDigest.update(this.f2650j, 0, c());
        byte[] bArrDigest = messageDigest.digest();
        F3.i.c(bArrDigest);
        return new o(bArrDigest);
    }

    public int c() {
        return this.f2650j.length;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r0 < r1) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0036, code lost:
    
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x002a, code lost:
    
        if (r7 < r8) goto L9;
     */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int compareTo(java.lang.Object r10) {
        /*
            r9 = this;
            W3.o r10 = (W3.o) r10
            java.lang.String r0 = "other"
            F3.i.f(r10, r0)
            int r0 = r9.c()
            int r1 = r10.c()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = r3
        L15:
            r5 = 1
            r6 = -1
            if (r4 >= r2) goto L30
            byte r7 = r9.f(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.f(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L2a
            int r4 = r4 + 1
            goto L15
        L2a:
            if (r7 >= r8) goto L2e
        L2c:
            r3 = r6
            goto L36
        L2e:
            r3 = r5
            goto L36
        L30:
            if (r0 != r1) goto L33
            goto L36
        L33:
            if (r0 >= r1) goto L2e
            goto L2c
        L36:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: W3.o.compareTo(java.lang.Object):int");
    }

    public String d() {
        byte[] bArr = this.f2650j;
        char[] cArr = new char[bArr.length * 2];
        int i5 = 0;
        for (byte b5 : bArr) {
            int i6 = i5 + 1;
            char[] cArr2 = X3.b.f2864a;
            cArr[i5] = cArr2[(b5 >> 4) & 15];
            i5 += 2;
            cArr[i6] = cArr2[b5 & 15];
        }
        return new String(cArr);
    }

    public byte[] e() {
        return this.f2650j;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            int iC = oVar.c();
            byte[] bArr = this.f2650j;
            if (iC == bArr.length && oVar.g(0, 0, bArr.length, bArr)) {
                return true;
            }
        }
        return false;
    }

    public byte f(int i5) {
        return this.f2650j[i5];
    }

    public boolean g(int i5, int i6, int i7, byte[] bArr) {
        F3.i.f(bArr, "other");
        if (i5 >= 0) {
            byte[] bArr2 = this.f2650j;
            if (i5 <= bArr2.length - i7 && i6 >= 0 && i6 <= bArr.length - i7 && AbstractC0189b.a(bArr2, i5, i6, bArr, i7)) {
                return true;
            }
        }
        return false;
    }

    public boolean h(o oVar, int i5) {
        F3.i.f(oVar, "other");
        return oVar.g(0, 0, i5, this.f2650j);
    }

    public int hashCode() {
        int i5 = this.f2651k;
        if (i5 != 0) {
            return i5;
        }
        int iHashCode = Arrays.hashCode(this.f2650j);
        this.f2651k = iHashCode;
        return iHashCode;
    }

    public o i() {
        int i5 = 0;
        while (true) {
            byte[] bArr = this.f2650j;
            if (i5 >= bArr.length) {
                return this;
            }
            byte b5 = bArr[i5];
            if (b5 >= 65 && b5 <= 90) {
                byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
                F3.i.e(bArrCopyOf, "copyOf(this, size)");
                bArrCopyOf[i5] = (byte) (b5 + 32);
                for (int i6 = i5 + 1; i6 < bArrCopyOf.length; i6++) {
                    byte b6 = bArrCopyOf[i6];
                    if (b6 >= 65 && b6 <= 90) {
                        bArrCopyOf[i6] = (byte) (b6 + 32);
                    }
                }
                return new o(bArrCopyOf);
            }
            i5++;
        }
    }

    public final String j() {
        String str = this.f2652l;
        if (str != null) {
            return str;
        }
        byte[] bArrE = e();
        F3.i.f(bArrE, "<this>");
        String str2 = new String(bArrE, M3.a.f1740a);
        this.f2652l = str2;
        return str2;
    }

    public void k(int i5, l lVar) {
        F3.i.f(lVar, "buffer");
        lVar.m0write(this.f2650j, 0, i5);
    }

    public String toString() {
        o oVar;
        byte b5;
        int i5;
        byte[] bArr = this.f2650j;
        if (bArr.length == 0) {
            return "[size=0]";
        }
        int length = bArr.length;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        loop0: while (true) {
            if (i6 >= length) {
                break;
            }
            byte b6 = bArr[i6];
            if (b6 >= 0) {
                int i9 = i8 + 1;
                if (i8 == 64) {
                    break;
                }
                if ((b6 != 10 && b6 != 13 && ((b6 >= 0 && b6 < 32) || (127 <= b6 && b6 < 160))) || b6 == 65533) {
                    break;
                }
                i7 += b6 < 65536 ? 1 : 2;
                i6++;
                while (true) {
                    i8 = i9;
                    if (i6 < length && (b5 = bArr[i6]) >= 0) {
                        i6++;
                        i9 = i8 + 1;
                        if (i8 == 64) {
                            break loop0;
                        }
                        if ((b5 != 10 && b5 != 13 && ((b5 >= 0 && b5 < 32) || (127 <= b5 && b5 < 160))) || b5 == 65533) {
                            break loop0;
                        }
                        i7 += b5 < 65536 ? 1 : 2;
                    } else {
                        break;
                    }
                }
            } else if ((b6 >> 5) == -2) {
                int i10 = i6 + 1;
                if (length > i10) {
                    byte b7 = bArr[i10];
                    if ((b7 & 192) == 128) {
                        int i11 = (b7 ^ 3968) ^ (b6 << 6);
                        if (i11 >= 128) {
                            i5 = i8 + 1;
                            if (i8 == 64) {
                                break;
                            }
                            if ((i11 != 10 && i11 != 13 && ((i11 >= 0 && i11 < 32) || (127 <= i11 && i11 < 160))) || i11 == 65533) {
                                break;
                            }
                            i7 += i11 < 65536 ? 1 : 2;
                            i6 += 2;
                            i8 = i5;
                        } else if (i8 != 64) {
                            break;
                        }
                    } else if (i8 != 64) {
                        break;
                    }
                } else if (i8 != 64) {
                    break;
                }
            } else if ((b6 >> 4) == -2) {
                int i12 = i6 + 2;
                if (length > i12) {
                    byte b8 = bArr[i6 + 1];
                    if ((b8 & 192) == 128) {
                        byte b9 = bArr[i12];
                        if ((b9 & 192) == 128) {
                            int i13 = ((b9 ^ (-123008)) ^ (b8 << 6)) ^ (b6 << 12);
                            if (i13 < 2048) {
                                if (i8 != 64) {
                                    break;
                                }
                            } else if (55296 > i13 || i13 >= 57344) {
                                i5 = i8 + 1;
                                if (i8 == 64) {
                                    break;
                                }
                                if ((i13 != 10 && i13 != 13 && ((i13 >= 0 && i13 < 32) || (127 <= i13 && i13 < 160))) || i13 == 65533) {
                                    break;
                                }
                                i7 += i13 < 65536 ? 1 : 2;
                                i6 += 3;
                                i8 = i5;
                            } else if (i8 != 64) {
                                break;
                            }
                        } else if (i8 != 64) {
                            break;
                        }
                    } else if (i8 != 64) {
                        break;
                    }
                } else if (i8 != 64) {
                    break;
                }
            } else if ((b6 >> 3) == -2) {
                int i14 = i6 + 3;
                if (length > i14) {
                    byte b10 = bArr[i6 + 1];
                    if ((b10 & 192) == 128) {
                        byte b11 = bArr[i6 + 2];
                        if ((b11 & 192) == 128) {
                            byte b12 = bArr[i14];
                            if ((b12 & 192) == 128) {
                                int i15 = (((b12 ^ 3678080) ^ (b11 << 6)) ^ (b10 << 12)) ^ (b6 << 18);
                                if (i15 > 1114111) {
                                    if (i8 != 64) {
                                        break;
                                    }
                                } else if (55296 > i15 || i15 >= 57344) {
                                    if (i15 >= 65536) {
                                        i5 = i8 + 1;
                                        if (i8 == 64) {
                                            break;
                                        }
                                        if ((i15 != 10 && i15 != 13 && ((i15 >= 0 && i15 < 32) || (127 <= i15 && i15 < 160))) || i15 == 65533) {
                                            break;
                                        }
                                        i7 += i15 < 65536 ? 1 : 2;
                                        i6 += 4;
                                        i8 = i5;
                                    } else if (i8 != 64) {
                                        break;
                                    }
                                } else if (i8 != 64) {
                                    break;
                                }
                            } else if (i8 != 64) {
                                break;
                            }
                        } else if (i8 != 64) {
                            break;
                        }
                    } else if (i8 != 64) {
                        break;
                    }
                } else if (i8 != 64) {
                    break;
                }
            } else if (i8 != 64) {
                break;
            }
        }
        i7 = -1;
        if (i7 != -1) {
            String strJ = j();
            String strSubstring = strJ.substring(0, i7);
            F3.i.e(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            String strV = M3.m.v(M3.m.v(M3.m.v(strSubstring, "\\", "\\\\"), "\n", "\\n"), "\r", "\\r");
            if (i7 >= strJ.length()) {
                return "[text=" + strV + ']';
            }
            return "[size=" + bArr.length + " text=" + strV + "…]";
        }
        if (bArr.length <= 64) {
            return "[hex=" + d() + ']';
        }
        StringBuilder sb = new StringBuilder("[size=");
        sb.append(bArr.length);
        sb.append(" hex=");
        if (64 > bArr.length) {
            throw new IllegalArgumentException(("endIndex > length(" + bArr.length + ')').toString());
        }
        if (64 == bArr.length) {
            oVar = this;
        } else {
            D1.c(64, bArr.length);
            byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, 0, 64);
            F3.i.e(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
            oVar = new o(bArrCopyOfRange);
        }
        sb.append(oVar.d());
        sb.append("…]");
        return sb.toString();
    }
}
