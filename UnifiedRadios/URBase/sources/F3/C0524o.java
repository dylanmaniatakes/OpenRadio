package f3;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import com.unified.ur1.R;
import com.unified.ur1.inbox.Message;
import g0.AbstractC0535a;
import g3.C0548A;
import i3.C0577f;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

/* renamed from: f3.o, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0524o extends androidx.recyclerview.widget.N {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6768a;

    /* renamed from: b, reason: collision with root package name */
    public List f6769b;

    /* renamed from: c, reason: collision with root package name */
    public Object f6770c;

    public /* synthetic */ C0524o(int i5) {
        this.f6768a = i5;
    }

    @Override // androidx.recyclerview.widget.N
    public final int getItemCount() {
        switch (this.f6768a) {
        }
        return this.f6769b.size();
    }

    @Override // androidx.recyclerview.widget.N
    public int getItemViewType(int i5) {
        switch (this.f6768a) {
            case 1:
                C0532x c0532x = (C0532x) this.f6769b.get(i5);
                if (c0532x.e()) {
                    return 2;
                }
                return c0532x.f() ? 1 : 0;
            default:
                return super.getItemViewType(i5);
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final void onBindViewHolder(androidx.recyclerview.widget.n0 n0Var, int i5) throws NumberFormatException, ParseException {
        int color;
        String strS;
        switch (this.f6768a) {
            case 0:
                C0523n c0523n = (C0523n) n0Var;
                C0525p c0525p = (C0525p) this.f6769b.get(i5);
                c0523n.getClass();
                c0523n.f6759a.setText(c0525p.f6774a);
                c0523n.f6760b.setText(c0525p.f6778e);
                c0523n.f6761c.setText("TG: " + c0525p.f6777d);
                int i6 = c0525p.f6779f;
                c0523n.f6762d.setText(String.format("%02d:%02d", Integer.valueOf(i6 / 60), Integer.valueOf(i6 % 60)));
                c0523n.f6763e.setText(c0525p.f6775b + ", " + c0525p.f6776c);
                c0523n.f6764f.setText(c0525p.g);
                c0523n.itemView.setOnClickListener(new ViewOnClickListenerC0522m(c0523n, (Z2.c) this.f6770c, c0525p));
                break;
            case 1:
                ((AbstractC0496G) n0Var).a((C0532x) this.f6769b.get(i5), (InterfaceC0500K) this.f6770c);
                break;
            case 2:
                g3.v vVar = (g3.v) n0Var;
                i3.I i7 = (i3.I) this.f6769b.get(i5);
                vVar.getClass();
                vVar.f7020a.setText(i7.f7291a);
                String strB = i7.b();
                boolean zIsEmpty = strB.isEmpty();
                TextView textView = vVar.f7021b;
                if (zIsEmpty) {
                    textView.setVisibility(8);
                } else {
                    textView.setVisibility(0);
                    textView.setText(strB);
                }
                String str = i7.f7291a;
                vVar.f7022c.setText(str.length() >= 2 ? str.substring(0, 2).toUpperCase() : str.toUpperCase());
                vVar.f7023d.setOnClickListener(new o0((C0548A) this.f6770c, 3, i7));
                break;
            case 3:
                g3.x xVar = (g3.x) n0Var;
                g3.w wVar = (g3.w) this.f6769b.get(i5);
                xVar.getClass();
                xVar.f7028a.setText(wVar.f7024a);
                double d5 = wVar.f7025b;
                String str2 = wVar.f7026c;
                xVar.f7029b.setText(AbstractC0535a.l("(", d5 < 0.1d ? String.format("%.0f feet %s", Double.valueOf(d5 * 5280.0d), str2) : d5 < 1.0d ? String.format("%.1f miles %s", Double.valueOf(d5), str2) : String.format("%.0f miles %s", Double.valueOf(d5), str2), ")"));
                String str3 = wVar.f7024a;
                xVar.f7030c.setText(str3.length() >= 2 ? str3.substring(0, 2).toUpperCase() : str3.toUpperCase());
                boolean z4 = wVar.f7027d;
                TextView textView2 = xVar.f7031d;
                if (z4) {
                    textView2.setVisibility(0);
                    textView2.setText("🔒");
                } else {
                    textView2.setVisibility(8);
                }
                xVar.f7032e.setOnClickListener(new o0((g3.y) this.f6770c, 4, wVar));
                break;
            case 4:
                C0577f c0577f = (C0577f) n0Var;
                i3.I i8 = (i3.I) ((ArrayList) this.f6769b).get(i5);
                c0577f.getClass();
                c0577f.f7302a.setText(i8.f7291a);
                String strB2 = i8.b();
                boolean zIsEmpty2 = strB2.isEmpty();
                TextView textView3 = c0577f.f7303b;
                if (zIsEmpty2) {
                    textView3.setVisibility(8);
                } else {
                    textView3.setVisibility(0);
                    textView3.setText(strB2);
                }
                o0 o0Var = new o0((D0.p) this.f6770c, 5, i8);
                View view = c0577f.f7304c;
                view.setOnClickListener(o0Var);
                view.setBackground(C.c.b(c0577f.itemView.getContext(), R.drawable.compose_badge));
                break;
            case 5:
                final i3.r rVar = (i3.r) n0Var;
                final Message message = (Message) this.f6769b.get(i5);
                rVar.getClass();
                boolean zIsTeamMessage = message.isTeamMessage();
                LinearLayout linearLayout = rVar.f7353w;
                TextView textView4 = rVar.f7348r;
                ImageView imageView = rVar.f7347q;
                TextView textView5 = rVar.f7339f;
                if (zIsTeamMessage) {
                    String teamId = message.getTeamId();
                    String fromCallsign = message.getFromCallsign();
                    if (message.getDisplayTime() == null || !message.getDisplayTime().startsWith("TEAM:")) {
                        strS = fromCallsign + " (Team: " + teamId + ")";
                    } else {
                        strS = com.unified.ur1.SatelliteTracker.h.s("RadioTeams: ", teamId);
                    }
                    textView5.setText(strS);
                    textView5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_group, 0, 0, 0);
                    textView5.setCompoundDrawableTintList(ColorStateList.valueOf(Color.parseColor("#2196F3")));
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        imageView.setImageResource(R.drawable.ic_group);
                        imageView.setColorFilter(Color.parseColor("#2196F3"));
                    }
                    if (textView4 != null) {
                        textView4.setVisibility(0);
                        textView4.setText("TEAM");
                        textView4.setTextColor(Color.parseColor("#2196F3"));
                    }
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                        linearLayout.setBackgroundColor(Color.parseColor("#332196F3"));
                    }
                } else {
                    textView5.setText(message.getFromCallsign() != null ? message.getFromCallsign() : "Unknown");
                    textView5.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_person, 0, 0, 0);
                    textView5.setCompoundDrawableTintList(null);
                    if (imageView != null) {
                        imageView.setVisibility(8);
                    }
                    if (textView4 != null) {
                        textView4.setVisibility(8);
                    }
                    if (linearLayout != null) {
                        linearLayout.setVisibility(8);
                    }
                }
                String createdAt = message.getCreatedAt();
                String str4 = "";
                if (createdAt != null) {
                    try {
                        if (!createdAt.isEmpty()) {
                            if (createdAt.matches("\\d+")) {
                                long j5 = Long.parseLong(createdAt);
                                if (j5 < 946684800000L) {
                                    j5 *= 1000;
                                }
                                str4 = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(j5));
                            } else if (createdAt.contains("-") && createdAt.contains(":")) {
                                String strSubstring = createdAt.substring(0, Math.min(19, createdAt.length()));
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                                SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH:mm", Locale.getDefault());
                                Date date = simpleDateFormat.parse(strSubstring);
                                Log.d("MessageAdapter", "Original timestamp: ".concat(createdAt));
                                Log.d("MessageAdapter", "Parsed UTC date: " + date);
                                Log.d("MessageAdapter", "Device timezone: " + TimeZone.getDefault().getID());
                                Log.d("MessageAdapter", "Formatted local time: " + simpleDateFormat2.format(date));
                                str4 = simpleDateFormat2.format(date);
                            }
                        }
                    } catch (Exception e5) {
                        Log.e("MessageAdapter", "Error formatting time: ".concat(createdAt), e5);
                    }
                }
                TextView textView6 = rVar.f7335b;
                textView6.setText(str4);
                String subject = message.getSubject() != null ? message.getSubject() : "No Subject";
                TextView textView7 = rVar.f7336c;
                textView7.setText(subject);
                String previewText = message.getPreviewText();
                TextView textView8 = rVar.f7337d;
                textView8.setText(previewText);
                rVar.f7338e.setText(message.getMessageType() != null ? message.getMessageType().toUpperCase() : "MESSAGE");
                boolean zIsHighSensitivity = message.isHighSensitivity();
                LinearLayout linearLayout2 = rVar.f7352v;
                TextView textView9 = rVar.f7346p;
                ImageView imageView2 = rVar.f7345o;
                if (zIsHighSensitivity) {
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                        imageView2.setImageResource(R.drawable.ic_security);
                        imageView2.setColorFilter(Color.parseColor("#FF5722"));
                    }
                    if (textView9 != null) {
                        textView9.setVisibility(0);
                        textView9.setText("SECURE");
                    }
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(0);
                        linearLayout2.setBackgroundColor(Color.parseColor("#33FF5722"));
                    }
                    if (!textView7.getText().toString().startsWith("🔒")) {
                        textView7.setText("🔒 " + textView7.getText().toString());
                        textView7.setTextColor(Color.parseColor("#FF5722"));
                    }
                } else {
                    if (imageView2 != null) {
                        imageView2.setVisibility(8);
                    }
                    if (textView9 != null) {
                        textView9.setVisibility(8);
                    }
                    if (linearLayout2 != null) {
                        linearLayout2.setVisibility(8);
                    }
                }
                boolean zIsRead = message.isRead();
                boolean zIsTeamMessage2 = message.isTeamMessage();
                LinearLayout linearLayout3 = rVar.f7350t;
                TextView textView10 = rVar.f7334a;
                CardView cardView = rVar.f7349s;
                if (zIsHighSensitivity && zIsRead) {
                    cardView.setCardBackgroundColor(Color.parseColor("#3D1F2A"));
                    if (linearLayout3 != null) {
                        linearLayout3.setBackground(C.c.b(rVar.itemView.getContext(), R.drawable.message_header_gradient));
                    }
                    textView10.setTextColor(Color.parseColor("#FFFFFF"));
                    textView6.setTextColor(Color.parseColor("#B0FFFFFF"));
                    textView7.setTextColor(Color.parseColor("#B0FFFFFF"));
                    textView8.setTextColor(Color.parseColor("#FFFFFF"));
                    rVar.itemView.setAlpha(0.85f);
                    textView10.setTypeface(null, 0);
                    cardView.setCardElevation(8.0f);
                } else if (zIsHighSensitivity) {
                    cardView.setCardBackgroundColor(Color.parseColor("#3D1F2A"));
                    if (linearLayout3 != null) {
                        linearLayout3.setBackground(C.c.b(rVar.itemView.getContext(), R.drawable.high_sensitivity_gradient));
                    }
                    textView10.setTextColor(Color.parseColor("#FFFFFF"));
                    textView6.setTextColor(Color.parseColor("#FFCDD2"));
                    textView7.setTextColor(Color.parseColor("#FFCDD2"));
                    textView8.setTextColor(Color.parseColor("#FFFFFF"));
                    rVar.itemView.setAlpha(1.0f);
                    textView10.setTypeface(null, 1);
                    cardView.setCardElevation(16.0f);
                } else if (zIsTeamMessage2 && zIsRead) {
                    cardView.setCardBackgroundColor(Color.parseColor("#1F2A3D"));
                    if (linearLayout3 != null) {
                        linearLayout3.setBackground(C.c.b(rVar.itemView.getContext(), R.drawable.message_header_gradient));
                    }
                    textView10.setTextColor(Color.parseColor("#E3F2FD"));
                    textView6.setTextColor(Color.parseColor("#B0E3F2FD"));
                    textView7.setTextColor(Color.parseColor("#B0E3F2FD"));
                    textView8.setTextColor(Color.parseColor("#E3F2FD"));
                    rVar.itemView.setAlpha(0.85f);
                    textView10.setTypeface(null, 0);
                    cardView.setCardElevation(8.0f);
                } else if (zIsTeamMessage2) {
                    cardView.setCardBackgroundColor(Color.parseColor("#2A3D4F"));
                    if (linearLayout3 != null) {
                        linearLayout3.setBackground(C.c.b(rVar.itemView.getContext(), R.drawable.multirx_badge));
                    }
                    textView10.setTextColor(Color.parseColor("#E3F2FD"));
                    textView6.setTextColor(Color.parseColor("#BBDEFB"));
                    textView7.setTextColor(Color.parseColor("#BBDEFB"));
                    textView8.setTextColor(Color.parseColor("#E3F2FD"));
                    rVar.itemView.setAlpha(1.0f);
                    textView10.setTypeface(null, 1);
                    cardView.setCardElevation(12.0f);
                } else if (zIsRead) {
                    cardView.setCardBackgroundColor(Color.parseColor("#1A1F2E"));
                    if (linearLayout3 != null) {
                        linearLayout3.setBackground(C.c.b(rVar.itemView.getContext(), R.drawable.message_header_gradient));
                    }
                    textView10.setTextColor(Color.parseColor("#FFFFFF"));
                    textView6.setTextColor(Color.parseColor("#B0FFFFFF"));
                    textView7.setTextColor(Color.parseColor("#B0FFFFFF"));
                    textView8.setTextColor(Color.parseColor("#FFFFFF"));
                    rVar.itemView.setAlpha(0.85f);
                    textView10.setTypeface(null, 0);
                    cardView.setCardElevation(8.0f);
                } else {
                    cardView.setCardBackgroundColor(Color.parseColor("#2A2F3E"));
                    if (linearLayout3 != null) {
                        linearLayout3.setBackground(C.c.b(rVar.itemView.getContext(), R.drawable.multirx_badge));
                    }
                    textView10.setTextColor(Color.parseColor("#FFFFFF"));
                    textView6.setTextColor(Color.parseColor("#E0FFFFFF"));
                    textView7.setTextColor(Color.parseColor("#E0FFFFFF"));
                    textView8.setTextColor(Color.parseColor("#FFFFFF"));
                    rVar.itemView.setAlpha(1.0f);
                    textView10.setTypeface(null, 1);
                    cardView.setCardElevation(12.0f);
                }
                rVar.h.setVisibility(message.isRead() ? 8 : 0);
                List<Message.Attachment> attachments = message.getAttachments();
                ImageView imageView3 = rVar.n;
                ImageView imageView4 = rVar.f7340i;
                if ((attachments == null || message.getAttachments().isEmpty()) && !message.isHasAttachments() && message.getAttachmentCount() <= 0) {
                    imageView4.setVisibility(8);
                    if (imageView3 != null) {
                        imageView3.setVisibility(8);
                    }
                } else {
                    imageView4.setVisibility(0);
                    if (imageView3 != null) {
                        imageView3.setVisibility(0);
                    }
                    imageView4.setImageResource(R.drawable.ic_attach_file);
                    if (imageView3 != null) {
                        imageView3.setImageResource(R.drawable.ic_attach_file);
                    }
                    int color2 = zIsHighSensitivity ? Color.parseColor("#FF5722") : message.isTeamMessage() ? Color.parseColor("#2196F3") : Color.parseColor("#FF9800");
                    imageView4.setColorFilter(color2);
                    if (imageView3 != null) {
                        imageView3.setColorFilter(color2);
                    }
                    if (message.getAttachmentCount() > 1) {
                        if (imageView3 != null) {
                            imageView3.setContentDescription("Has " + message.getAttachmentCount() + " attachments");
                        }
                    } else if (imageView3 != null) {
                        imageView3.setContentDescription("Has attachment");
                    }
                }
                String priority = message.getPriority();
                boolean zIsTeamMessage3 = message.isTeamMessage();
                if (zIsHighSensitivity) {
                    color = Color.parseColor("#FF5722");
                } else if (zIsTeamMessage3) {
                    color = Color.parseColor("#2196F3");
                } else {
                    color = ("normal".equals(priority) || "low".equals(priority)) ? Color.parseColor("#3A7BD5") : "high".equals(priority) ? Color.parseColor("#FF9800") : "urgent".equals(priority) ? Color.parseColor("#F44336") : Color.parseColor("#4CAF50");
                }
                View view2 = rVar.g;
                if (view2 != null) {
                    view2.setBackgroundColor(color);
                }
                View view3 = rVar.itemView;
                final i3.s sVar = (i3.s) this.f6770c;
                final int i9 = 0;
                view3.setOnClickListener(new View.OnClickListener() { // from class: i3.n
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        switch (i9) {
                            case 0:
                                s sVar2 = sVar;
                                if (sVar2 != null) {
                                    sVar2.l(message);
                                    break;
                                }
                                break;
                            case 1:
                                s sVar3 = sVar;
                                if (sVar3 != null) {
                                    sVar3.o(message);
                                    break;
                                }
                                break;
                            case 2:
                                s sVar4 = sVar;
                                if (sVar4 != null) {
                                    sVar4.r(message);
                                    break;
                                }
                                break;
                            default:
                                s sVar5 = sVar;
                                if (sVar5 != null) {
                                    sVar5.q(message);
                                    break;
                                }
                                break;
                        }
                    }
                });
                rVar.itemView.setOnLongClickListener(new i3.o(sVar, i9, message));
                ImageView imageView5 = rVar.f7342k;
                if (imageView5 != null) {
                    final int i10 = 1;
                    imageView5.setOnClickListener(new View.OnClickListener() { // from class: i3.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            switch (i10) {
                                case 0:
                                    s sVar2 = sVar;
                                    if (sVar2 != null) {
                                        sVar2.l(message);
                                        break;
                                    }
                                    break;
                                case 1:
                                    s sVar3 = sVar;
                                    if (sVar3 != null) {
                                        sVar3.o(message);
                                        break;
                                    }
                                    break;
                                case 2:
                                    s sVar4 = sVar;
                                    if (sVar4 != null) {
                                        sVar4.r(message);
                                        break;
                                    }
                                    break;
                                default:
                                    s sVar5 = sVar;
                                    if (sVar5 != null) {
                                        sVar5.q(message);
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                }
                ImageView imageView6 = rVar.f7343l;
                if (imageView6 != null) {
                    final int i11 = 2;
                    imageView6.setOnClickListener(new View.OnClickListener() { // from class: i3.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            switch (i11) {
                                case 0:
                                    s sVar2 = sVar;
                                    if (sVar2 != null) {
                                        sVar2.l(message);
                                        break;
                                    }
                                    break;
                                case 1:
                                    s sVar3 = sVar;
                                    if (sVar3 != null) {
                                        sVar3.o(message);
                                        break;
                                    }
                                    break;
                                case 2:
                                    s sVar4 = sVar;
                                    if (sVar4 != null) {
                                        sVar4.r(message);
                                        break;
                                    }
                                    break;
                                default:
                                    s sVar5 = sVar;
                                    if (sVar5 != null) {
                                        sVar5.q(message);
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                }
                ImageView imageView7 = rVar.f7344m;
                if (imageView7 != null) {
                    final int i12 = 3;
                    imageView7.setOnClickListener(new View.OnClickListener() { // from class: i3.n
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            switch (i12) {
                                case 0:
                                    s sVar2 = sVar;
                                    if (sVar2 != null) {
                                        sVar2.l(message);
                                        break;
                                    }
                                    break;
                                case 1:
                                    s sVar3 = sVar;
                                    if (sVar3 != null) {
                                        sVar3.o(message);
                                        break;
                                    }
                                    break;
                                case 2:
                                    s sVar4 = sVar;
                                    if (sVar4 != null) {
                                        sVar4.r(message);
                                        break;
                                    }
                                    break;
                                default:
                                    s sVar5 = sVar;
                                    if (sVar5 != null) {
                                        sVar5.q(message);
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                }
                ImageView imageView8 = rVar.f7341j;
                if (imageView8 != null) {
                    final int i13 = 0;
                    imageView8.setOnClickListener(new View.OnClickListener() { // from class: i3.p
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view4) {
                            switch (i13) {
                                case 0:
                                    r rVar2 = rVar;
                                    s sVar2 = sVar;
                                    if (sVar2 == null) {
                                        rVar2.getClass();
                                        break;
                                    } else {
                                        int adapterPosition = rVar2.getAdapterPosition();
                                        if (adapterPosition != -1) {
                                            sVar2.f(message, adapterPosition);
                                            break;
                                        }
                                    }
                                    break;
                                default:
                                    r rVar3 = rVar;
                                    LinearLayout linearLayout4 = rVar3.f7351u;
                                    if (linearLayout4 != null) {
                                        linearLayout4.setVisibility(8);
                                    }
                                    ImageView imageView9 = rVar3.f7341j;
                                    if (imageView9 != null) {
                                        imageView9.setVisibility(8);
                                    }
                                    s sVar3 = sVar;
                                    if (sVar3 != null) {
                                        sVar3.l(message);
                                        break;
                                    }
                                    break;
                            }
                        }
                    });
                }
                rVar.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: i3.q
                    @Override // android.view.View.OnLongClickListener
                    public final boolean onLongClick(View view4) {
                        r rVar2 = rVar;
                        LinearLayout linearLayout4 = rVar2.f7351u;
                        if (linearLayout4 != null) {
                            linearLayout4.setVisibility(0);
                        }
                        ImageView imageView9 = rVar2.f7341j;
                        if (imageView9 != null) {
                            imageView9.setVisibility(8);
                        }
                        Message message2 = message;
                        ImageView imageView10 = rVar2.f7342k;
                        if (imageView10 != null) {
                            if (message2.isRead()) {
                                imageView10.setImageResource(android.R.drawable.ic_menu_edit);
                                imageView10.setColorFilter(Color.parseColor("#888888"));
                            } else {
                                imageView10.setImageResource(android.R.drawable.ic_menu_view);
                                imageView10.setColorFilter(Color.parseColor("#4CAF50"));
                            }
                        }
                        s sVar2 = sVar;
                        if (sVar2 == null) {
                            return true;
                        }
                        sVar2.h(message2);
                        return true;
                    }
                });
                final int i14 = 1;
                rVar.itemView.setOnClickListener(new View.OnClickListener() { // from class: i3.p
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view4) {
                        switch (i14) {
                            case 0:
                                r rVar2 = rVar;
                                s sVar2 = sVar;
                                if (sVar2 == null) {
                                    rVar2.getClass();
                                    break;
                                } else {
                                    int adapterPosition = rVar2.getAdapterPosition();
                                    if (adapterPosition != -1) {
                                        sVar2.f(message, adapterPosition);
                                        break;
                                    }
                                }
                                break;
                            default:
                                r rVar3 = rVar;
                                LinearLayout linearLayout4 = rVar3.f7351u;
                                if (linearLayout4 != null) {
                                    linearLayout4.setVisibility(8);
                                }
                                ImageView imageView9 = rVar3.f7341j;
                                if (imageView9 != null) {
                                    imageView9.setVisibility(8);
                                }
                                s sVar3 = sVar;
                                if (sVar3 != null) {
                                    sVar3.l(message);
                                    break;
                                }
                                break;
                        }
                    }
                });
                break;
            default:
                i3.F f5 = (i3.F) n0Var;
                Message message2 = (Message) this.f6769b.get(i5);
                f5.getClass();
                StringBuilder sb = new StringBuilder("To: ");
                sb.append(message2.getToCallsign() != null ? message2.getToCallsign() : "Unknown");
                f5.f7280a.setText(sb.toString());
                f5.f7281b.setText(message2.getDisplayTime());
                f5.f7282c.setText(message2.getSubject() != null ? message2.getSubject() : "No Subject");
                f5.f7283d.setText(message2.getPreviewText());
                boolean zIsRead2 = message2.isRead();
                CardView cardView2 = f5.f7286i;
                View view4 = f5.f7285f;
                ImageView imageView9 = f5.h;
                TextView textView11 = f5.f7284e;
                if (zIsRead2) {
                    textView11.setText("READ");
                    textView11.setTextColor(Color.parseColor("#4CAF50"));
                    imageView9.setImageResource(R.drawable.ic_check_circle);
                    imageView9.setColorFilter(Color.parseColor("#4CAF50"));
                    view4.setBackgroundColor(Color.parseColor("#4CAF50"));
                    cardView2.setCardBackgroundColor(Color.parseColor("#1A2E1A"));
                } else {
                    textView11.setText("UNREAD");
                    textView11.setTextColor(Color.parseColor("#F44336"));
                    imageView9.setImageResource(R.drawable.ic_radio_button_unchecked);
                    imageView9.setColorFilter(Color.parseColor("#F44336"));
                    view4.setBackgroundColor(Color.parseColor("#F44336"));
                    cardView2.setCardBackgroundColor(Color.parseColor("#2E1A1A"));
                }
                if (message2.isRead() && message2.getReadAt() != null && !message2.getReadAt().isEmpty()) {
                    textView11.setText("READ at " + message2.getReadAt());
                }
                f5.g.setVisibility((message2.getAttachments() == null || message2.getAttachments().isEmpty()) ? 8 : 0);
                View view5 = f5.itemView;
                C0519j c0519j = (C0519j) this.f6770c;
                view5.setOnClickListener(new o0(c0519j, 7, message2));
                f5.itemView.setOnLongClickListener(new i3.o(c0519j, 1, message2));
                break;
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final androidx.recyclerview.widget.n0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        switch (this.f6768a) {
            case 0:
                View viewInflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_last_heard, viewGroup, false);
                C0523n c0523n = new C0523n(viewInflate);
                c0523n.g = 0L;
                c0523n.h = new Handler();
                c0523n.f6759a = (TextView) viewInflate.findViewById(R.id.callsignText);
                c0523n.f6760b = (TextView) viewInflate.findViewById(R.id.timeText);
                c0523n.f6761c = (TextView) viewInflate.findViewById(R.id.talkgroupText);
                c0523n.f6762d = (TextView) viewInflate.findViewById(R.id.durationText);
                c0523n.f6763e = (TextView) viewInflate.findViewById(R.id.locationText);
                c0523n.f6764f = (TextView) viewInflate.findViewById(R.id.statusText);
                return c0523n;
            case 1:
                return i5 != 1 ? i5 != 2 ? new C0501L(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.memory_channel_item, viewGroup, false)) : new C0499J(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.multirx_memory_channel, viewGroup, false)) : new C0502M(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.roip_memory_channel, viewGroup, false));
            case 2:
                View viewInflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_contact_suggestion, viewGroup, false);
                g3.v vVar = new g3.v(viewInflate2);
                vVar.f7020a = (TextView) viewInflate2.findViewById(R.id.callsignText);
                vVar.f7021b = (TextView) viewInflate2.findViewById(R.id.nameText);
                vVar.f7022c = (TextView) viewInflate2.findViewById(R.id.avatarText);
                vVar.f7023d = viewInflate2.findViewById(R.id.itemContainer);
                return vVar;
            case 3:
                View viewInflate3 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_nearby_contact, viewGroup, false);
                g3.x xVar = new g3.x(viewInflate3);
                xVar.f7028a = (TextView) viewInflate3.findViewById(R.id.callsignText);
                xVar.f7029b = (TextView) viewInflate3.findViewById(R.id.distanceText);
                xVar.f7030c = (TextView) viewInflate3.findViewById(R.id.avatarText);
                xVar.f7031d = (TextView) viewInflate3.findViewById(R.id.privacyIndicator);
                xVar.f7032e = viewInflate3.findViewById(R.id.itemContainer);
                return xVar;
            case 4:
                View viewInflate4 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_user_suggestion, viewGroup, false);
                C0577f c0577f = new C0577f(viewInflate4);
                c0577f.f7302a = (TextView) viewInflate4.findViewById(R.id.callsignText);
                c0577f.f7303b = (TextView) viewInflate4.findViewById(R.id.nameText);
                c0577f.f7304c = viewInflate4.findViewById(R.id.itemContainer);
                return c0577f;
            case 5:
                View viewInflate5 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_message, viewGroup, false);
                i3.r rVar = new i3.r(viewInflate5);
                rVar.f7334a = (TextView) viewInflate5.findViewById(R.id.textFromCallsign);
                rVar.f7339f = (TextView) viewInflate5.findViewById(R.id.textFromCallsign);
                rVar.f7335b = (TextView) viewInflate5.findViewById(R.id.textTime);
                rVar.f7336c = (TextView) viewInflate5.findViewById(R.id.textSubject);
                rVar.f7337d = (TextView) viewInflate5.findViewById(R.id.textPreview);
                rVar.f7338e = (TextView) viewInflate5.findViewById(R.id.textMessageType);
                rVar.g = viewInflate5.findViewById(R.id.priorityIndicator);
                rVar.h = viewInflate5.findViewById(R.id.unreadIndicator);
                rVar.f7340i = (ImageView) viewInflate5.findViewById(R.id.imageAttachment);
                rVar.n = (ImageView) viewInflate5.findViewById(R.id.headerAttachmentIndicator);
                rVar.f7341j = (ImageView) viewInflate5.findViewById(R.id.buttonDelete);
                rVar.f7342k = (ImageView) viewInflate5.findViewById(R.id.buttonToggleRead);
                rVar.f7343l = (ImageView) viewInflate5.findViewById(R.id.buttonReply);
                rVar.f7344m = (ImageView) viewInflate5.findViewById(R.id.buttonForward);
                rVar.f7349s = (CardView) viewInflate5.findViewById(R.id.cardViewMessage);
                rVar.f7350t = (LinearLayout) viewInflate5.findViewById(R.id.headerContainer);
                rVar.f7351u = (LinearLayout) viewInflate5.findViewById(R.id.quickActionsContainer);
                rVar.f7345o = (ImageView) viewInflate5.findViewById(R.id.highSensitivityIndicator);
                rVar.f7346p = (TextView) viewInflate5.findViewById(R.id.highSensitivityLabel);
                rVar.f7352v = (LinearLayout) viewInflate5.findViewById(R.id.highSensitivityContainer);
                rVar.f7347q = (ImageView) viewInflate5.findViewById(R.id.teamIndicator);
                rVar.f7348r = (TextView) viewInflate5.findViewById(R.id.teamLabel);
                rVar.f7353w = (LinearLayout) viewInflate5.findViewById(R.id.teamContainer);
                return rVar;
            default:
                View viewInflate6 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_sent_message, viewGroup, false);
                i3.F f5 = new i3.F(viewInflate6);
                f5.f7280a = (TextView) viewInflate6.findViewById(R.id.textToCallsign);
                f5.f7281b = (TextView) viewInflate6.findViewById(R.id.textTime);
                f5.f7282c = (TextView) viewInflate6.findViewById(R.id.textSubject);
                f5.f7283d = (TextView) viewInflate6.findViewById(R.id.textPreview);
                f5.f7284e = (TextView) viewInflate6.findViewById(R.id.textReadStatus);
                f5.f7285f = viewInflate6.findViewById(R.id.readStatusIndicator);
                f5.g = (ImageView) viewInflate6.findViewById(R.id.imageAttachment);
                f5.h = (ImageView) viewInflate6.findViewById(R.id.iconReadStatus);
                f5.f7286i = (CardView) viewInflate6.findViewById(R.id.cardViewMessage);
                return f5;
        }
    }

    public /* synthetic */ C0524o(ArrayList arrayList, Object obj, int i5) {
        this.f6768a = i5;
        this.f6769b = arrayList;
        this.f6770c = obj;
    }
}
