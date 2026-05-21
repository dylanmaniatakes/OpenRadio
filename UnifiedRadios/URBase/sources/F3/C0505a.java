package f3;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.TextView;
import com.unified.ur1.adapters.AntennaCalculatorActivity;
import java.text.DecimalFormat;

/* renamed from: f3.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0505a implements TextWatcher {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f6666c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ AntennaCalculatorActivity f6667d;

    public /* synthetic */ C0505a(AntennaCalculatorActivity antennaCalculatorActivity, int i5) {
        this.f6666c = i5;
        this.f6667d = antennaCalculatorActivity;
    }

    private final void a(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void b(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void c(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void d(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void e(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void f(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void g(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void h(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void i(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void j(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void k(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void l(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void m(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void n(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void o(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void p(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void q(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void r(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void s(int i5, int i6, int i7, CharSequence charSequence) {
    }

    private final void t(int i5, int i6, int i7, CharSequence charSequence) {
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) throws NumberFormatException {
        String str;
        AntennaCalculatorActivity antennaCalculatorActivity = this.f6667d;
        switch (this.f6666c) {
            case 0:
                AntennaCalculatorActivity.m(antennaCalculatorActivity);
                break;
            case 1:
                AntennaCalculatorActivity.n(antennaCalculatorActivity);
                break;
            case 2:
                int i5 = AntennaCalculatorActivity.f5587E0;
                antennaCalculatorActivity.getClass();
                StringBuilder sb = new StringBuilder();
                try {
                    String strTrim = antennaCalculatorActivity.f5638m0.getText().toString().trim();
                    String strTrim2 = antennaCalculatorActivity.f5639n0.getText().toString().trim();
                    boolean zIsEmpty = strTrim.isEmpty();
                    DecimalFormat decimalFormat = antennaCalculatorActivity.f5591B0;
                    if (!zIsEmpty && !strTrim2.isEmpty()) {
                        double dLog10 = Math.log10(Double.parseDouble(strTrim2) / Double.parseDouble(strTrim)) * 10.0d;
                        sb.append("Power Ratio: ");
                        sb.append(decimalFormat.format(dLog10));
                        sb.append(" dB\n");
                    }
                    String strTrim3 = antennaCalculatorActivity.f5645q0.getText().toString().trim();
                    if (!strTrim3.isEmpty()) {
                        double d5 = Double.parseDouble(strTrim3);
                        double dPow = Math.pow(10.0d, d5 / 10.0d);
                        sb.append(antennaCalculatorActivity.f5589A0.format(d5));
                        sb.append(" dB = ");
                        sb.append(decimalFormat.format(dPow));
                        sb.append("x Power\n");
                    }
                    if (sb.length() == 0) {
                        sb.append("Enter values to calculate");
                    }
                    antennaCalculatorActivity.f5649s0.setText(sb.toString().trim());
                    break;
                } catch (NumberFormatException unused) {
                    antennaCalculatorActivity.f5649s0.setText("Error: Invalid input values");
                    return;
                }
            case 3:
                AntennaCalculatorActivity.j(antennaCalculatorActivity);
                break;
            case 4:
                int i6 = AntennaCalculatorActivity.f5587E0;
                antennaCalculatorActivity.getClass();
                try {
                    String strTrim4 = antennaCalculatorActivity.n.getText().toString().trim();
                    String strTrim5 = antennaCalculatorActivity.f5640o.getText().toString().trim();
                    if (!strTrim4.isEmpty() && !strTrim5.isEmpty()) {
                        double d6 = Double.parseDouble(strTrim4);
                        double d7 = Double.parseDouble(strTrim5);
                        if (d6 > 0.0d) {
                            if (d7 >= 0.0d && d7 <= d6) {
                                double d8 = d7 / d6;
                                double dSqrt = Math.sqrt(d8);
                                double d9 = (dSqrt + 1.0d) / (1.0d - dSqrt);
                                boolean zIsInfinite = Double.isInfinite(d9);
                                DecimalFormat decimalFormat2 = antennaCalculatorActivity.f5591B0;
                                if (zIsInfinite || d9 > 200.0d) {
                                    antennaCalculatorActivity.f5642p.setText("SWR: ∞");
                                } else {
                                    antennaCalculatorActivity.f5642p.setText("SWR: " + decimalFormat2.format(d9) + ":1");
                                }
                                double dLog102 = Math.log10(dSqrt) * (-20.0d);
                                double dLog103 = Math.log10(1.0d - Math.pow(dSqrt, 2.0d)) * (-10.0d);
                                double d10 = (1.0d - d8) * 100.0d;
                                String str2 = d9 <= 1.5d ? "Excellent match" : d9 <= 2.0d ? "Good match" : d9 <= 3.0d ? "Fair match, tuning recommended" : "Poor match, check antenna system";
                                StringBuilder sb2 = new StringBuilder();
                                sb2.append(str2);
                                sb2.append("\nReturn Loss: ");
                                DecimalFormat decimalFormat3 = antennaCalculatorActivity.f5589A0;
                                sb2.append(decimalFormat3.format(dLog102));
                                sb2.append(" dB");
                                antennaCalculatorActivity.f5644q.setText((sb2.toString() + "\nEfficiency: " + decimalFormat3.format(d10) + "%") + "\nMismatch Loss: " + decimalFormat2.format(dLog103) + " dB");
                                break;
                            } else {
                                antennaCalculatorActivity.f5642p.setText("SWR: Error");
                                if (d7 > d6) {
                                    antennaCalculatorActivity.f5642p.setText("SWR: ∞");
                                }
                                antennaCalculatorActivity.f5644q.setText("Reflected must be <= forward power");
                                break;
                            }
                        } else {
                            antennaCalculatorActivity.f5642p.setText("SWR: Error");
                            antennaCalculatorActivity.f5644q.setText("Forward power must be > 0");
                            break;
                        }
                    }
                    antennaCalculatorActivity.f5642p.setText("SWR: --");
                    antennaCalculatorActivity.f5644q.setText("Enter forward and reflected power");
                    break;
                } catch (NumberFormatException unused2) {
                    antennaCalculatorActivity.f5642p.setText("SWR: Error");
                    antennaCalculatorActivity.f5644q.setText("Invalid input values");
                    return;
                }
            case 5:
                AntennaCalculatorActivity.k(antennaCalculatorActivity);
                break;
            case 6:
                AntennaCalculatorActivity.l(antennaCalculatorActivity);
                break;
            case 7:
                int i7 = AntennaCalculatorActivity.f5587E0;
                antennaCalculatorActivity.getClass();
                try {
                    String strTrim6 = antennaCalculatorActivity.f5592C.getText().toString().trim();
                    String strTrim7 = antennaCalculatorActivity.f5594D.getText().toString().trim();
                    String strTrim8 = antennaCalculatorActivity.f5596E.getText().toString().trim();
                    if (!strTrim6.isEmpty() && !strTrim7.isEmpty() && !strTrim8.isEmpty()) {
                        double d11 = Double.parseDouble(strTrim6);
                        double d12 = Double.parseDouble(strTrim7);
                        double d13 = Double.parseDouble(strTrim8);
                        double dLog104 = (Math.log10(d11 * 1000.0d) * 10.0d) + d12;
                        double d14 = dLog104 - d13;
                        double d15 = d14 - (-120.0d);
                        TextView textView = antennaCalculatorActivity.f5597F;
                        StringBuilder sb3 = new StringBuilder("EIRP: ");
                        DecimalFormat decimalFormat4 = antennaCalculatorActivity.f5589A0;
                        sb3.append(decimalFormat4.format(dLog104));
                        sb3.append(" dBm");
                        textView.setText(sb3.toString());
                        antennaCalculatorActivity.f5598G.setText("Received: " + decimalFormat4.format(d14) + " dBm");
                        String str3 = "Link Margin: " + decimalFormat4.format(d15) + " dB";
                        if (d15 > 20.0d) {
                            str = str3 + " (Excellent)";
                        } else if (d15 > 10.0d) {
                            str = str3 + " (Good)";
                        } else if (d15 > 0.0d) {
                            str = str3 + " (Marginal)";
                        } else {
                            str = str3 + " (Insufficient)";
                        }
                        antennaCalculatorActivity.f5599H.setText(str);
                        break;
                    }
                    antennaCalculatorActivity.f5597F.setText("EIRP: -- dBm");
                    antennaCalculatorActivity.f5598G.setText("Received: -- dBm");
                    antennaCalculatorActivity.f5599H.setText("Link Margin: -- dB");
                    break;
                } catch (NumberFormatException unused3) {
                    antennaCalculatorActivity.f5597F.setText("EIRP: Error");
                    antennaCalculatorActivity.f5598G.setText("Invalid inputs");
                    antennaCalculatorActivity.f5599H.setText("Link Margin: Error");
                    return;
                }
                break;
            case 8:
                int i8 = AntennaCalculatorActivity.f5587E0;
                antennaCalculatorActivity.getClass();
                try {
                    String strTrim9 = antennaCalculatorActivity.I.getText().toString().trim();
                    String strTrim10 = antennaCalculatorActivity.f5600J.getText().toString().trim();
                    String strTrim11 = antennaCalculatorActivity.f5601K.getText().toString().trim();
                    String strTrim12 = antennaCalculatorActivity.f5602L.getText().toString().trim();
                    if (!strTrim9.isEmpty() && !strTrim10.isEmpty() && !strTrim11.isEmpty() && !strTrim12.isEmpty()) {
                        double d16 = Double.parseDouble(strTrim9);
                        double d17 = Double.parseDouble(strTrim10);
                        double d18 = Double.parseDouble(strTrim11);
                        double d19 = Double.parseDouble(strTrim12);
                        if (d16 > 0.0d && d17 > 0.0d && d18 >= 0.0d && d19 >= 0.0d && d19 <= 100.0d) {
                            double d20 = d16 / d17;
                            double d21 = d18 > 0.0d ? d16 / d18 : Double.POSITIVE_INFINITY;
                            double d22 = d19 / 100.0d;
                            double d23 = d16 / (((1.0d - d22) * d18) + (d17 * d22));
                            TextView textView2 = antennaCalculatorActivity.f5604N;
                            StringBuilder sb4 = new StringBuilder("TX Only: ");
                            DecimalFormat decimalFormat5 = antennaCalculatorActivity.f5589A0;
                            sb4.append(decimalFormat5.format(d20));
                            sb4.append(" hours");
                            textView2.setText(sb4.toString());
                            if (Double.isInfinite(d21)) {
                                antennaCalculatorActivity.f5605O.setText("RX Only: ∞ hours");
                            } else {
                                antennaCalculatorActivity.f5605O.setText("RX Only: " + decimalFormat5.format(d21) + " hours");
                            }
                            antennaCalculatorActivity.f5606P.setText("Mixed (" + antennaCalculatorActivity.f5595D0.format(d19) + "% TX): " + decimalFormat5.format(d23) + " hours");
                            break;
                        }
                        antennaCalculatorActivity.f5606P.setText("Invalid inputs");
                        break;
                    }
                    antennaCalculatorActivity.f5604N.setText("TX Only: -- hours");
                    antennaCalculatorActivity.f5605O.setText("RX Only: -- hours");
                    antennaCalculatorActivity.f5606P.setText("Mixed Use: -- hours");
                    break;
                } catch (NumberFormatException unused4) {
                    antennaCalculatorActivity.f5606P.setText("Error: Invalid inputs");
                    return;
                }
            default:
                int i9 = AntennaCalculatorActivity.f5587E0;
                antennaCalculatorActivity.getClass();
                try {
                    String strTrim13 = antennaCalculatorActivity.f5607Q.getText().toString().trim();
                    String strTrim14 = antennaCalculatorActivity.f5608R.getText().toString().trim();
                    String upperCase = antennaCalculatorActivity.f5609S.getText().toString().trim().toUpperCase();
                    String strTrim15 = antennaCalculatorActivity.f5609S.getText().toString().trim();
                    String strTrim16 = antennaCalculatorActivity.f5612V.getText().toString().trim();
                    if (!strTrim13.isEmpty() && !strTrim14.isEmpty()) {
                        double d24 = Double.parseDouble(strTrim13);
                        double d25 = Double.parseDouble(strTrim14);
                        if (d24 < -90.0d || d24 > 90.0d || d25 < -180.0d || d25 > 180.0d) {
                            antennaCalculatorActivity.f5613W.setText("Invalid Lat/Lon");
                        } else {
                            double d26 = d25 + 180.0d;
                            double d27 = d24 + 90.0d;
                            antennaCalculatorActivity.f5613W.setText("Grid: ".concat(new String(new char[]{(char) (Math.floor(d26 / 20.0d) + 65.0d), (char) (Math.floor(d27 / 10.0d) + 65.0d), (char) (Math.floor((d26 / 2.0d) % 10.0d) + 48.0d), (char) (Math.floor(d27 % 10.0d) + 48.0d), (char) (Math.floor((d26 % 2.0d) * 12.0d) + 97.0d), (char) (Math.floor((d27 % 1.0d) * 24.0d) + 97.0d)})));
                        }
                    } else if (upperCase.isEmpty()) {
                        antennaCalculatorActivity.f5613W.setText("Enter Lat/Lon or a Grid Square");
                    } else {
                        double[] dArrQ = AntennaCalculatorActivity.q(upperCase);
                        if (dArrQ != null) {
                            antennaCalculatorActivity.f5613W.setText(String.format("Center: %.4f, %.4f", Double.valueOf(dArrQ[0]), Double.valueOf(dArrQ[1])));
                        } else {
                            antennaCalculatorActivity.f5613W.setText("Invalid Grid");
                        }
                    }
                    if (!strTrim15.isEmpty() && !strTrim16.isEmpty()) {
                        antennaCalculatorActivity.o();
                        break;
                    } else {
                        antennaCalculatorActivity.f5614X.setText("Enter two grids to find distance");
                        break;
                    }
                } catch (Exception unused5) {
                    antennaCalculatorActivity.f5613W.setText("Error in calculation");
                }
                break;
        }
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        int i8 = this.f6666c;
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i5, int i6, int i7) {
        int i8 = this.f6666c;
    }
}
