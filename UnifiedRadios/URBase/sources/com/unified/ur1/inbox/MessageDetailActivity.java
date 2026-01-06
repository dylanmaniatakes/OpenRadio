package com.unified.ur1.inbox;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageDetailActivity;
import f.AbstractActivityC0472i;
import f3.o0;
import h4.c;
import java.util.List;
import java.util.Map;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes.dex */
public class MessageDetailActivity extends AbstractActivityC0472i {

    /* renamed from: p, reason: collision with root package name */
    public static final /* synthetic */ int f5814p = 0;

    /* renamed from: c, reason: collision with root package name */
    public TextView f5815c;

    /* renamed from: d, reason: collision with root package name */
    public TextView f5816d;

    /* renamed from: e, reason: collision with root package name */
    public TextView f5817e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f5818f;
    public LinearLayout g;
    public LinearLayout h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f5819i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f5820j;

    /* renamed from: k, reason: collision with root package name */
    public MessageApiService f5821k;

    /* renamed from: l, reason: collision with root package name */
    public String f5822l;

    /* renamed from: m, reason: collision with root package name */
    public int f5823m;
    public boolean n;

    /* renamed from: o, reason: collision with root package name */
    public Message f5824o;

    public final boolean j(String str, String str2) {
        if ("image".equals(str) && str2 != null && !str2.isEmpty()) {
            try {
                byte[] bArrDecode = Base64.decode(str2, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                if (bitmapDecodeByteArray != null) {
                    ImageView imageView = new ImageView(this);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(0, 16, 0, 16);
                    imageView.setLayoutParams(layoutParams);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    imageView.setAdjustViewBounds(true);
                    imageView.setMaxHeight(600);
                    imageView.setImageBitmap(bitmapDecodeByteArray);
                    imageView.setOnClickListener(new o0(this, 6, bitmapDecodeByteArray));
                    this.g.addView(imageView);
                    Log.d("MessageDetailActivity", "Successfully added image to container");
                    return true;
                }
                Log.w("MessageDetailActivity", "Failed to decode bitmap from base64");
            } catch (Exception e5) {
                Log.e("MessageDetailActivity", "Error creating image view: " + e5.getMessage(), e5);
            }
        }
        return false;
    }

    public final void k(String str) {
        Toast.makeText(this, str, 1).show();
        this.f5815c.setText("Error loading message");
        this.f5816d.setText("Error");
        this.f5817e.setText("--");
        this.f5818f.setText(str);
        Log.e("MessageDetailActivity", "Error: " + str);
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_message_detail);
        this.f5822l = c.h(this);
        this.f5815c = (TextView) findViewById(R.id.textFromCallsign);
        this.f5816d = (TextView) findViewById(R.id.textSubject);
        this.f5817e = (TextView) findViewById(R.id.textDateTime);
        this.f5818f = (TextView) findViewById(R.id.textMessageBody);
        this.g = (LinearLayout) findViewById(R.id.imageContainer);
        this.h = (LinearLayout) findViewById(R.id.actionButtonsContainer);
        this.f5819i = (TextView) findViewById(R.id.buttonReply);
        this.f5820j = (TextView) findViewById(R.id.buttonForward);
        TextView textView = this.f5819i;
        if (textView != null) {
            final int i5 = 0;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: i3.t

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ MessageDetailActivity f7355d;

                {
                    this.f7355d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessageDetailActivity messageDetailActivity = this.f7355d;
                    switch (i5) {
                        case 0:
                            int i6 = MessageDetailActivity.f5814p;
                            messageDetailActivity.getClass();
                            Intent intent = new Intent(messageDetailActivity, (Class<?>) ComposeMessageActivity.class);
                            intent.putExtra("action_type", "reply");
                            intent.putExtra("to_callsign", messageDetailActivity.f5824o.getFromCallsign());
                            intent.putExtra("subject", "Re: " + messageDetailActivity.f5824o.getSubject());
                            intent.putExtra("quoted_content", "\n\n--- Original Message ---\nFrom: " + messageDetailActivity.f5824o.getFromCallsign() + "\nSubject: " + messageDetailActivity.f5824o.getSubject() + "\n\n" + messageDetailActivity.f5824o.getMessageBody());
                            messageDetailActivity.startActivity(intent);
                            break;
                        default:
                            int i7 = MessageDetailActivity.f5814p;
                            messageDetailActivity.getClass();
                            Intent intent2 = new Intent(messageDetailActivity, (Class<?>) ComposeMessageActivity.class);
                            intent2.putExtra("action_type", "forward");
                            intent2.putExtra("subject", "Fwd: " + messageDetailActivity.f5824o.getSubject());
                            intent2.putExtra("quoted_content", "\n\n--- Forwarded Message ---\nFrom: " + messageDetailActivity.f5824o.getFromCallsign() + "\nSubject: " + messageDetailActivity.f5824o.getSubject() + "\n\n" + messageDetailActivity.f5824o.getMessageBody());
                            if (messageDetailActivity.f5824o.isHasAttachments() && messageDetailActivity.f5824o.getAttachments() != null) {
                                try {
                                    List<Message.Attachment> attachments = messageDetailActivity.f5824o.getAttachments();
                                    if (attachments instanceof List) {
                                        String[] strArr = new String[attachments.size()];
                                        String[] strArr2 = new String[attachments.size()];
                                        int i8 = 0;
                                        for (Object obj : attachments) {
                                            if (obj instanceof Message.Attachment) {
                                                Message.Attachment attachment = (Message.Attachment) obj;
                                                strArr[i8] = attachment.getType();
                                                strArr2[i8] = attachment.getData();
                                            } else if (obj instanceof Map) {
                                                Map map = (Map) obj;
                                                strArr[i8] = (String) map.get("type");
                                                strArr2[i8] = (String) map.get("data");
                                            }
                                            i8++;
                                        }
                                        intent2.putExtra("forwarded_attachment_types", strArr);
                                        intent2.putExtra("forwarded_attachment_data", strArr2);
                                        intent2.putExtra("has_forwarded_attachments", true);
                                        Log.d("MessageDetailActivity", "Forwarding " + attachments.size() + " attachments");
                                    }
                                } catch (Exception e5) {
                                    Log.e("MessageDetailActivity", "Error preparing attachments for forwarding: " + e5.getMessage(), e5);
                                }
                            }
                            messageDetailActivity.startActivity(intent2);
                            break;
                    }
                }
            });
        }
        TextView textView2 = this.f5820j;
        if (textView2 != null) {
            final int i6 = 1;
            textView2.setOnClickListener(new View.OnClickListener(this) { // from class: i3.t

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ MessageDetailActivity f7355d;

                {
                    this.f7355d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    MessageDetailActivity messageDetailActivity = this.f7355d;
                    switch (i6) {
                        case 0:
                            int i62 = MessageDetailActivity.f5814p;
                            messageDetailActivity.getClass();
                            Intent intent = new Intent(messageDetailActivity, (Class<?>) ComposeMessageActivity.class);
                            intent.putExtra("action_type", "reply");
                            intent.putExtra("to_callsign", messageDetailActivity.f5824o.getFromCallsign());
                            intent.putExtra("subject", "Re: " + messageDetailActivity.f5824o.getSubject());
                            intent.putExtra("quoted_content", "\n\n--- Original Message ---\nFrom: " + messageDetailActivity.f5824o.getFromCallsign() + "\nSubject: " + messageDetailActivity.f5824o.getSubject() + "\n\n" + messageDetailActivity.f5824o.getMessageBody());
                            messageDetailActivity.startActivity(intent);
                            break;
                        default:
                            int i7 = MessageDetailActivity.f5814p;
                            messageDetailActivity.getClass();
                            Intent intent2 = new Intent(messageDetailActivity, (Class<?>) ComposeMessageActivity.class);
                            intent2.putExtra("action_type", "forward");
                            intent2.putExtra("subject", "Fwd: " + messageDetailActivity.f5824o.getSubject());
                            intent2.putExtra("quoted_content", "\n\n--- Forwarded Message ---\nFrom: " + messageDetailActivity.f5824o.getFromCallsign() + "\nSubject: " + messageDetailActivity.f5824o.getSubject() + "\n\n" + messageDetailActivity.f5824o.getMessageBody());
                            if (messageDetailActivity.f5824o.isHasAttachments() && messageDetailActivity.f5824o.getAttachments() != null) {
                                try {
                                    List<Message.Attachment> attachments = messageDetailActivity.f5824o.getAttachments();
                                    if (attachments instanceof List) {
                                        String[] strArr = new String[attachments.size()];
                                        String[] strArr2 = new String[attachments.size()];
                                        int i8 = 0;
                                        for (Object obj : attachments) {
                                            if (obj instanceof Message.Attachment) {
                                                Message.Attachment attachment = (Message.Attachment) obj;
                                                strArr[i8] = attachment.getType();
                                                strArr2[i8] = attachment.getData();
                                            } else if (obj instanceof Map) {
                                                Map map = (Map) obj;
                                                strArr[i8] = (String) map.get("type");
                                                strArr2[i8] = (String) map.get("data");
                                            }
                                            i8++;
                                        }
                                        intent2.putExtra("forwarded_attachment_types", strArr);
                                        intent2.putExtra("forwarded_attachment_data", strArr2);
                                        intent2.putExtra("has_forwarded_attachments", true);
                                        Log.d("MessageDetailActivity", "Forwarding " + attachments.size() + " attachments");
                                    }
                                } catch (Exception e5) {
                                    Log.e("MessageDetailActivity", "Error preparing attachments for forwarding: " + e5.getMessage(), e5);
                                }
                            }
                            messageDetailActivity.startActivity(intent2);
                            break;
                    }
                }
            });
        }
        try {
            this.f5821k = (MessageApiService) new Retrofit.Builder().baseUrl("https://ur1.unifiedradios.com/messages/").addConverterFactory(GsonConverterFactory.create()).build().create(MessageApiService.class);
            Log.d("MessageDetailActivity", "API Service created successfully");
        } catch (Exception e5) {
            StringBuilder sbG = h.g("MessageDetailActivity", "Error setting up API", e5, "API setup failed: ");
            sbG.append(e5.getMessage());
            Toast.makeText(this, sbG.toString(), 1).show();
            this.f5821k = null;
        }
        this.f5823m = getIntent().getIntExtra("message_id", 0);
        this.n = getIntent().getBooleanExtra("is_sent_message", false);
        if (getSupportActionBar() != null) {
            getSupportActionBar().p("Message Details");
            getSupportActionBar().n(true);
        }
        if (this.f5823m <= 0) {
            k("Invalid message ID");
            return;
        }
        MessageApiService messageApiService = this.f5821k;
        if (messageApiService == null) {
            k("API service not available");
        } else {
            (this.n ? messageApiService.getSentMessages("get_sent", this.f5822l, 0, 100) : messageApiService.getMessages(this.f5822l, 0, 100)).enqueue(new Z2.c(19, this));
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.d("MessageDetailActivity", "MessageDetailActivity destroyed");
    }

    @Override // f.AbstractActivityC0472i
    public final boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
