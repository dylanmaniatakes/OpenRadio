package g3;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Handler;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.n0;
import com.unified.ur1.R;
import com.unified.ur1.inbox.Message;
import f3.S;
import f3.o0;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class u extends N {

    /* renamed from: a, reason: collision with root package name */
    public List f7016a;

    /* renamed from: b, reason: collision with root package name */
    public String f7017b;

    /* renamed from: c, reason: collision with root package name */
    public g f7018c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f7019d;

    public static String b(String str) {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    return new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(c(str)));
                }
            } catch (Exception e5) {
                Log.w("ChatAdapter", "Error formatting time: ".concat(str), e5);
            }
        }
        return "";
    }

    public static long c(String str) throws NumberFormatException {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    String strTrim = str.trim();
                    if (strTrim.matches("\\d+")) {
                        long j5 = Long.parseLong(strTrim);
                        return j5 < 946684800000L ? j5 * 1000 : j5;
                    }
                    if (strTrim.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                        return simpleDateFormat.parse(strTrim).getTime();
                    }
                    if (!strTrim.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+")) {
                        return Long.parseLong(strTrim);
                    }
                    String strSubstring = strTrim.substring(0, 19);
                    SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
                    simpleDateFormat2.setTimeZone(TimeZone.getTimeZone("UTC"));
                    return simpleDateFormat2.parse(strSubstring).getTime();
                }
            } catch (Exception e5) {
                Log.w("ChatAdapter", "Failed to parse timestamp: " + str, e5);
                return System.currentTimeMillis();
            }
        }
        return System.currentTimeMillis();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x008f A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:6:0x001f, B:12:0x0033, B:14:0x003d, B:33:0x008f, B:37:0x009d, B:39:0x00aa, B:43:0x0145, B:42:0x0134, B:38:0x00a5, B:18:0x0049, B:20:0x0053, B:22:0x005d, B:24:0x0067, B:27:0x0073, B:29:0x007d, B:31:0x0087, B:9:0x0028), top: B:47:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00a5 A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:6:0x001f, B:12:0x0033, B:14:0x003d, B:33:0x008f, B:37:0x009d, B:39:0x00aa, B:43:0x0145, B:42:0x0134, B:38:0x00a5, B:18:0x0049, B:20:0x0053, B:22:0x005d, B:24:0x0067, B:27:0x0073, B:29:0x007d, B:31:0x0087, B:9:0x0028), top: B:47:0x001a }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0132 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0134 A[Catch: Exception -> 0x0025, TryCatch #0 {Exception -> 0x0025, blocks: (B:6:0x001f, B:12:0x0033, B:14:0x003d, B:33:0x008f, B:37:0x009d, B:39:0x00aa, B:43:0x0145, B:42:0x0134, B:38:0x00a5, B:18:0x0049, B:20:0x0053, B:22:0x005d, B:24:0x0067, B:27:0x0073, B:29:0x007d, B:31:0x0087, B:9:0x0028), top: B:47:0x001a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void d(android.content.Context r16, java.lang.String r17, java.lang.String r18, int r19, int r20, java.lang.String r21, java.lang.String r22) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.u.d(android.content.Context, java.lang.String, java.lang.String, int, int, java.lang.String, java.lang.String):void");
    }

    public final void a(final Context context, final String str, final String str2, final int i5, final int i6) {
        String strH = h4.c.h(context);
        if (strH == null || strH.isEmpty()) {
            Log.w("ChatAdapter", "Missing callsign or cloud_auth, skipping credential fetch");
            d(context, str, str2, i5, i6, null, null);
            return;
        }
        try {
            final String str3 = "https://ur1.unifiedradios.com/api-cred/api_cred.php?callsign=" + URLEncoder.encode(strH, "UTF-8") + "&cloud_auth=" + URLEncoder.encode("c2cb03a0", "UTF-8");
            Log.d("ChatAdapter", "Fetching credentials from API for callsign: ".concat(strH));
            new Thread(new Runnable() { // from class: g3.p
                @Override // java.lang.Runnable
                public final void run() throws JSONException, IOException {
                    final u uVar;
                    final String str4;
                    HttpURLConnection httpURLConnection;
                    String str5 = str3;
                    final Context context2 = context;
                    final String str6 = str;
                    final String str7 = str2;
                    final int i7 = i5;
                    final int i8 = i6;
                    final u uVar2 = this.f6989j;
                    uVar2.getClass();
                    try {
                        HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str5).openConnection();
                        httpURLConnection2.setRequestMethod("GET");
                        httpURLConnection2.setConnectTimeout(10000);
                        httpURLConnection2.setReadTimeout(10000);
                        httpURLConnection2.setRequestProperty("Accept", "application/json");
                        httpURLConnection2.setRequestProperty("User-Agent", "UnifiedRadios-Android");
                        int responseCode = httpURLConnection2.getResponseCode();
                        Log.d("ChatAdapter", "API Response Code: " + responseCode);
                        try {
                            if (responseCode == 200) {
                                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream()));
                                StringBuilder sb = new StringBuilder();
                                while (true) {
                                    String line = bufferedReader.readLine();
                                    if (line == null) {
                                        break;
                                    } else {
                                        sb.append(line);
                                    }
                                }
                                bufferedReader.close();
                                JSONObject jSONObject = new JSONObject(sb.toString());
                                if (jSONObject.getBoolean("success")) {
                                    JSONObject jSONObject2 = jSONObject.getJSONObject("data");
                                    final String strOptString = jSONObject2.optString("brandmeister_password", null);
                                    final String strOptString2 = jSONObject2.optString("tgif_password", null);
                                    Log.d("ChatAdapter", "Successfully fetched credentials for: " + jSONObject2.getString("callsign"));
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("BM Password available: ");
                                    boolean z4 = false;
                                    sb2.append((strOptString == null || strOptString.isEmpty()) ? false : true);
                                    Log.d("ChatAdapter", sb2.toString());
                                    StringBuilder sb3 = new StringBuilder();
                                    sb3.append("TGIF Password available: ");
                                    if (strOptString2 != null && !strOptString2.isEmpty()) {
                                        z4 = true;
                                    }
                                    sb3.append(z4);
                                    Log.d("ChatAdapter", sb3.toString());
                                    httpURLConnection = httpURLConnection2;
                                    str4 = str7;
                                    str7 = "ChatAdapter";
                                    uVar = uVar2;
                                    new Handler(context2.getMainLooper()).post(new Runnable() { // from class: g3.q
                                        /* JADX WARN: Removed duplicated region for block: B:23:0x0061  */
                                        @Override // java.lang.Runnable
                                        /*
                                            Code decompiled incorrectly, please refer to instructions dump.
                                            To view partially-correct add '--show-bad-code' argument
                                        */
                                        public final void run() {
                                            /*
                                                r9 = this;
                                                g3.u r0 = r1
                                                r0.getClass()
                                                java.lang.String r0 = "Using BrandMeister password for network: "
                                                java.lang.String r1 = "Using TGIF password for network: "
                                                android.content.Context r2 = r2
                                                java.lang.String r3 = r3
                                                java.lang.String r7 = r4
                                                java.lang.String r8 = r5
                                                java.lang.String r4 = "ChatAdapter"
                                                if (r7 == 0) goto L23
                                                boolean r5 = r7.isEmpty()     // Catch: java.lang.Exception -> L21
                                                if (r5 != 0) goto L23
                                                java.lang.String r5 = "Stored BrandMeister password"
                                                android.util.Log.d(r4, r5)     // Catch: java.lang.Exception -> L21
                                                goto L23
                                            L21:
                                                r0 = move-exception
                                                goto L73
                                            L23:
                                                if (r8 == 0) goto L30
                                                boolean r5 = r8.isEmpty()     // Catch: java.lang.Exception -> L21
                                                if (r5 != 0) goto L30
                                                java.lang.String r5 = "Stored TGIF password"
                                                android.util.Log.d(r4, r5)     // Catch: java.lang.Exception -> L21
                                            L30:
                                                if (r3 == 0) goto L61
                                                java.lang.String r5 = r3.toLowerCase()     // Catch: java.lang.Exception -> L21
                                                java.lang.String r6 = "brandmeister"
                                                boolean r6 = r5.contains(r6)     // Catch: java.lang.Exception -> L21
                                                if (r6 != 0) goto L58
                                                java.lang.String r6 = "bm"
                                                boolean r6 = r5.contains(r6)     // Catch: java.lang.Exception -> L21
                                                if (r6 == 0) goto L47
                                                goto L58
                                            L47:
                                                java.lang.String r0 = "tgif"
                                                boolean r0 = r5.contains(r0)     // Catch: java.lang.Exception -> L21
                                                if (r0 == 0) goto L61
                                                java.lang.String r0 = r1.concat(r3)     // Catch: java.lang.Exception -> L21
                                                android.util.Log.d(r4, r0)     // Catch: java.lang.Exception -> L21
                                                r0 = r8
                                                goto L62
                                            L58:
                                                java.lang.String r0 = r0.concat(r3)     // Catch: java.lang.Exception -> L21
                                                android.util.Log.d(r4, r0)     // Catch: java.lang.Exception -> L21
                                                r0 = r7
                                                goto L62
                                            L61:
                                                r0 = 0
                                            L62:
                                                if (r0 == 0) goto L78
                                                boolean r1 = r0.isEmpty()     // Catch: java.lang.Exception -> L21
                                                if (r1 != 0) goto L78
                                                h4.c.T(r2, r0)     // Catch: java.lang.Exception -> L21
                                                java.lang.String r0 = "Set DMR password for current connection"
                                                android.util.Log.d(r4, r0)     // Catch: java.lang.Exception -> L21
                                                goto L78
                                            L73:
                                                java.lang.String r1 = "Error storing network credentials"
                                                android.util.Log.e(r4, r1, r0)
                                            L78:
                                                int r5 = r7
                                                int r6 = r8
                                                java.lang.String r4 = r6
                                                g3.u.d(r2, r3, r4, r5, r6, r7, r8)
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: g3.q.run():void");
                                        }
                                    });
                                } else {
                                    httpURLConnection = httpURLConnection2;
                                    uVar = uVar2;
                                    str4 = str7;
                                    str7 = "ChatAdapter";
                                    Log.w(str7, "API returned error: " + jSONObject.getString("error"));
                                    final int i9 = 0;
                                    new Handler(context2.getMainLooper()).post(new Runnable() { // from class: g3.r
                                        @Override // java.lang.Runnable
                                        public final void run() {
                                            switch (i9) {
                                                case 0:
                                                    uVar.getClass();
                                                    u.d(context2, str6, str4, i7, i8, null, null);
                                                    break;
                                                case 1:
                                                    uVar.getClass();
                                                    u.d(context2, str6, str4, i7, i8, null, null);
                                                    break;
                                                default:
                                                    uVar.getClass();
                                                    u.d(context2, str6, str4, i7, i8, null, null);
                                                    break;
                                            }
                                        }
                                    });
                                }
                            } else {
                                httpURLConnection = httpURLConnection2;
                                uVar = uVar2;
                                str4 = str7;
                                str7 = "ChatAdapter";
                                Log.w(str7, "API request failed with code: " + responseCode);
                                final int i10 = 1;
                                new Handler(context2.getMainLooper()).post(new Runnable() { // from class: g3.r
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        switch (i10) {
                                            case 0:
                                                uVar.getClass();
                                                u.d(context2, str6, str4, i7, i8, null, null);
                                                break;
                                            case 1:
                                                uVar.getClass();
                                                u.d(context2, str6, str4, i7, i8, null, null);
                                                break;
                                            default:
                                                uVar.getClass();
                                                u.d(context2, str6, str4, i7, i8, null, null);
                                                break;
                                        }
                                    }
                                });
                            }
                            httpURLConnection.disconnect();
                        } catch (Exception e5) {
                            e = e5;
                            Log.e(str7, "Error fetching network credentials", e);
                            final int i11 = 2;
                            final u uVar3 = uVar;
                            final String str8 = str4;
                            new Handler(context2.getMainLooper()).post(new Runnable() { // from class: g3.r
                                @Override // java.lang.Runnable
                                public final void run() {
                                    switch (i11) {
                                        case 0:
                                            uVar3.getClass();
                                            u.d(context2, str6, str8, i7, i8, null, null);
                                            break;
                                        case 1:
                                            uVar3.getClass();
                                            u.d(context2, str6, str8, i7, i8, null, null);
                                            break;
                                        default:
                                            uVar3.getClass();
                                            u.d(context2, str6, str8, i7, i8, null, null);
                                            break;
                                    }
                                }
                            });
                        }
                    } catch (Exception e6) {
                        e = e6;
                        uVar = uVar2;
                        str4 = str7;
                        str7 = "ChatAdapter";
                    }
                }
            }).start();
        } catch (UnsupportedEncodingException e5) {
            throw new RuntimeException(e5);
        }
    }

    public final boolean e(n0 n0Var, Message message) throws JSONException {
        TextView textView;
        String type;
        String data;
        if (!(n0Var instanceof t)) {
            if (n0Var instanceof s) {
                textView = ((s) n0Var).f7008a;
            }
            return false;
        }
        textView = ((t) n0Var).f7012a;
        TextView textView2 = textView;
        if (message.isHasAttachments() && message.getAttachments() != null) {
            try {
                List<Message.Attachment> attachments = message.getAttachments();
                if (attachments instanceof List) {
                    for (Object obj : attachments) {
                        if (obj instanceof Message.Attachment) {
                            Message.Attachment attachment = (Message.Attachment) obj;
                            type = attachment.getType();
                            data = attachment.getData();
                        } else if (obj instanceof Map) {
                            Map map = (Map) obj;
                            type = (String) map.get("type");
                            data = (String) map.get("data");
                        } else {
                            type = null;
                            data = null;
                        }
                        if ("dmr_invitation".equals(type) && data != null) {
                            JSONObject jSONObject = new JSONObject(data);
                            String string = jSONObject.getString("from_callsign");
                            String string2 = jSONObject.getString("network");
                            int i5 = jSONObject.getInt("talkgroup");
                            if (n0Var instanceof s) {
                                g(textView2, string, string2, i5, jSONObject);
                                return true;
                            }
                            textView2.setVisibility(0);
                            if (n0Var instanceof t) {
                                ((t) n0Var).f7015d.setVisibility(8);
                            }
                            textView2.setText("📻 ROIP Invitation sent: " + string2 + ", TG: " + i5);
                            textView2.setTextColor(Color.parseColor("#000000"));
                            return true;
                        }
                    }
                }
            } catch (Exception e5) {
                Log.e("ChatAdapter", "Error processing DMR invitation", e5);
            }
        }
        return false;
    }

    public final boolean f(n0 n0Var, Message message) throws IllegalAccessException, SecurityException, IllegalArgumentException {
        TextView textView;
        ImageView imageView;
        String type;
        String data;
        boolean z4;
        if (n0Var instanceof t) {
            t tVar = (t) n0Var;
            textView = tVar.f7012a;
            imageView = tVar.f7015d;
        } else {
            if (!(n0Var instanceof s)) {
                return false;
            }
            s sVar = (s) n0Var;
            textView = sVar.f7008a;
            imageView = sVar.f7011d;
        }
        TextView textView2 = textView;
        ImageView imageView2 = imageView;
        StringBuilder sb = new StringBuilder("Processing message ID: ");
        sb.append(message.getId());
        sb.append(", hasAttachments: ");
        sb.append(message.isHasAttachments());
        sb.append(", attachments null: ");
        boolean z5 = true;
        sb.append(message.getAttachments() == null);
        Log.d("ChatAdapter", sb.toString());
        if (!message.isHasAttachments() || message.getAttachments() == null) {
            Log.d("ChatAdapter", "No attachments found for message ID: " + message.getId());
            return false;
        }
        try {
            List<Message.Attachment> attachments = message.getAttachments();
            Log.d("ChatAdapter", "Attachments object type: ".concat(attachments.getClass().getSimpleName()));
            Log.d("ChatAdapter", "Processing " + attachments.size() + " attachments for message ID: " + message.getId());
            int i5 = 0;
            while (i5 < attachments.size()) {
                Object obj = attachments.get(i5);
                Log.d("ChatAdapter", "Attachment " + i5 + " type: " + obj.getClass().getSimpleName());
                if (obj instanceof Message.Attachment) {
                    Message.Attachment attachment = (Message.Attachment) obj;
                    type = attachment.getType();
                    data = attachment.getData();
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append("Attachment object - type: ");
                    sb2.append(type);
                    sb2.append(", data length: ");
                    sb2.append(data != null ? Integer.valueOf(data.length()) : "null");
                    Log.d("ChatAdapter", sb2.toString());
                    try {
                        Field[] declaredFields = attachment.getClass().getDeclaredFields();
                        Log.d("ChatAdapter", "Attachment fields: ");
                        int length = declaredFields.length;
                        int i6 = 0;
                        while (i6 < length) {
                            Field field = declaredFields[i6];
                            field.setAccessible(z5);
                            Log.d("ChatAdapter", "  " + field.getName() + " = " + field.get(attachment));
                            i6++;
                            z5 = true;
                        }
                    } catch (Exception e5) {
                        Log.e("ChatAdapter", "Error inspecting attachment object", e5);
                    }
                } else if (obj instanceof Map) {
                    Map map = (Map) obj;
                    type = (String) map.get("type");
                    data = (String) map.get("data");
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("Map attachment - type: ");
                    sb3.append(type);
                    sb3.append(", data length: ");
                    sb3.append(data != null ? Integer.valueOf(data.length()) : "null");
                    Log.d("ChatAdapter", sb3.toString());
                    Log.d("ChatAdapter", "Map keys: " + map.keySet().toString());
                } else {
                    Log.d("ChatAdapter", "Unknown attachment type: " + obj.getClass().getName());
                    try {
                        Field[] declaredFields2 = obj.getClass().getDeclaredFields();
                        Log.d("ChatAdapter", "Unknown object fields: ");
                        for (Field field2 : declaredFields2) {
                            field2.setAccessible(true);
                            Log.d("ChatAdapter", "  " + field2.getName() + " = " + field2.get(obj));
                        }
                    } catch (Exception e6) {
                        Log.e("ChatAdapter", "Error inspecting unknown attachment object", e6);
                    }
                    type = null;
                    data = null;
                }
                if (!"image".equals(type) || data == null || data.isEmpty()) {
                    z4 = true;
                    StringBuilder sb4 = new StringBuilder();
                    sb4.append("Skipping attachment - type: ");
                    sb4.append(type);
                    sb4.append(", data null/empty: ");
                    sb4.append(data == null || data.isEmpty());
                    Log.d("ChatAdapter", sb4.toString());
                } else {
                    Log.d("ChatAdapter", "Processing image attachment, original data length: " + data.length());
                    String strReplace = data.replace("\\/", "/");
                    Log.d("ChatAdapter", "Cleaned data length: " + strReplace.length());
                    try {
                        textView2.setVisibility(8);
                        imageView2.setVisibility(0);
                        byte[] bArrDecode = Base64.decode(strReplace, 0);
                        Log.d("ChatAdapter", "Decoded image bytes length: " + bArrDecode.length);
                        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                        if (bitmapDecodeByteArray != null) {
                            Log.d("ChatAdapter", "Bitmap created successfully: " + bitmapDecodeByteArray.getWidth() + "x" + bitmapDecodeByteArray.getHeight());
                            imageView2.setImageBitmap(bitmapDecodeByteArray);
                            try {
                                imageView2.setOnClickListener(new o0(this, 2, message));
                                Log.d("ChatAdapter", "Successfully loaded image from attachment");
                                return true;
                            } catch (Exception e7) {
                                e = e7;
                                z4 = true;
                                try {
                                    Log.e("ChatAdapter", "Failed to decode image: " + e.getMessage(), e);
                                    i5++;
                                    z5 = z4;
                                } catch (Exception e8) {
                                    e = e8;
                                    Log.e("ChatAdapter", "Error processing attachments: " + e.getMessage(), e);
                                    return false;
                                }
                            }
                        } else {
                            z4 = true;
                            try {
                                Log.w("ChatAdapter", "Failed to decode bitmap from base64 - bitmap is null");
                            } catch (Exception e9) {
                                e = e9;
                                Log.e("ChatAdapter", "Failed to decode image: " + e.getMessage(), e);
                                i5++;
                                z5 = z4;
                            }
                        }
                    } catch (Exception e10) {
                        e = e10;
                    }
                }
                i5++;
                z5 = z4;
            }
            return false;
        } catch (Exception e11) {
            e = e11;
        }
    }

    public final void g(TextView textView, final String str, final String str2, final int i5, final JSONObject jSONObject) {
        final Context context = textView.getContext();
        textView.setVisibility(0);
        textView.setText("📻 " + str + " invites you to join: " + str2 + ", TG: " + i5 + "\n\n[Tap to Accept Invitation]");
        textView.setTextColor(-11890462);
        textView.setOnClickListener(new View.OnClickListener() { // from class: g3.o
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                u uVar = this.f6985c;
                uVar.getClass();
                Context context2 = context;
                new AlertDialog.Builder(context2).setTitle("DMR Channel Invitation").setMessage(str + " is inviting you to join:\n\nNetwork: " + str2 + "\nTalkgroup: " + i5 + "\n\nAccept this invitation?").setPositiveButton("Accept", new S(uVar, context2, jSONObject, 2)).setNegativeButton("Decline", (DialogInterface.OnClickListener) null).show();
            }
        });
    }

    @Override // androidx.recyclerview.widget.N
    public final int getItemCount() {
        return this.f7016a.size();
    }

    @Override // androidx.recyclerview.widget.N
    public final int getItemViewType(int i5) {
        return ((Message) this.f7016a.get(i5)).getFromCallsign().equals(this.f7017b) ? 1 : 2;
    }

    @Override // androidx.recyclerview.widget.N
    public final void onBindViewHolder(n0 n0Var, int i5) {
        final Message message = (Message) this.f7016a.get(i5);
        if (n0Var instanceof t) {
            t tVar = (t) n0Var;
            if (!e(tVar, message) && !f(tVar, message)) {
                tVar.f7012a.setVisibility(0);
                tVar.f7015d.setVisibility(8);
                String messageBody = message.getMessageBody();
                TextView textView = tVar.f7012a;
                textView.setText(messageBody);
                textView.setAutoLinkMask(1);
                textView.setLinksClickable(true);
                textView.setLinkTextColor(Color.parseColor("#000000"));
            }
            tVar.f7013b.setText(b(message.getCreatedAt()));
            TextView textView2 = tVar.f7014c;
            if (textView2 != null) {
                textView2.setVisibility(0);
                if (message.isRead()) {
                    textView2.setText("Read");
                    textView2.setTextColor(-16743169);
                } else {
                    textView2.setText("Delivered");
                    textView2.setTextColor(-5197648);
                }
            }
            final int i6 = 1;
            tVar.itemView.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: g3.n

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ u f6983b;

                {
                    this.f6983b = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    switch (i6) {
                        case 0:
                            g gVar = this.f6983b.f7018c;
                            if (gVar != null) {
                                gVar.a(message);
                                break;
                            }
                            break;
                        default:
                            g gVar2 = this.f6983b.f7018c;
                            if (gVar2 != null) {
                                gVar2.a(message);
                                break;
                            }
                            break;
                    }
                    return true;
                }
            });
            return;
        }
        if (n0Var instanceof s) {
            s sVar = (s) n0Var;
            if (!e(sVar, message) && !f(sVar, message)) {
                sVar.f7008a.setVisibility(0);
                sVar.f7011d.setVisibility(8);
                String messageBody2 = message.getMessageBody();
                TextView textView3 = sVar.f7008a;
                textView3.setText(messageBody2);
                textView3.setAutoLinkMask(1);
                textView3.setLinksClickable(true);
                textView3.setLinkTextColor(Color.parseColor("#4A90E2"));
            }
            sVar.f7009b.setText(b(message.getCreatedAt()));
            boolean z4 = this.f7019d;
            TextView textView4 = sVar.f7010c;
            if (z4) {
                textView4.setText(message.getFromCallsign());
                textView4.setVisibility(0);
            } else {
                textView4.setVisibility(8);
            }
            final int i7 = 0;
            sVar.itemView.setOnLongClickListener(new View.OnLongClickListener(this) { // from class: g3.n

                /* renamed from: b, reason: collision with root package name */
                public final /* synthetic */ u f6983b;

                {
                    this.f6983b = this;
                }

                @Override // android.view.View.OnLongClickListener
                public final boolean onLongClick(View view) {
                    switch (i7) {
                        case 0:
                            g gVar = this.f6983b.f7018c;
                            if (gVar != null) {
                                gVar.a(message);
                                break;
                            }
                            break;
                        default:
                            g gVar2 = this.f6983b.f7018c;
                            if (gVar2 != null) {
                                gVar2.a(message);
                                break;
                            }
                            break;
                    }
                    return true;
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.N
    public final n0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        if (i5 == 1) {
            View viewInflate = layoutInflaterFrom.inflate(R.layout.item_enhanced_chat_sent, viewGroup, false);
            t tVar = new t(viewInflate);
            tVar.f7012a = (TextView) viewInflate.findViewById(R.id.messageText);
            tVar.f7013b = (TextView) viewInflate.findViewById(R.id.timeText);
            tVar.f7015d = (ImageView) viewInflate.findViewById(R.id.imageMessage);
            tVar.f7014c = (TextView) viewInflate.findViewById(R.id.readReceiptText);
            return tVar;
        }
        View viewInflate2 = layoutInflaterFrom.inflate(R.layout.item_enhanced_chat_received, viewGroup, false);
        s sVar = new s(viewInflate2);
        sVar.f7008a = (TextView) viewInflate2.findViewById(R.id.messageText);
        sVar.f7009b = (TextView) viewInflate2.findViewById(R.id.timeText);
        sVar.f7011d = (ImageView) viewInflate2.findViewById(R.id.imageMessage);
        sVar.f7010c = (TextView) viewInflate2.findViewById(R.id.callsignText);
        return sVar;
    }
}
