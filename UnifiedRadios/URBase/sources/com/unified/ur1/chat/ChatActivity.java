package com.unified.ur1.chat;

import C0.A;
import D.m;
import Q0.i;
import S1.a;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.GeofenceStatusCodes;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.chat.ChatActivity;
import com.unified.ur1.inbox.ApiResponse;
import com.unified.ur1.inbox.Message;
import com.unified.ur1.inbox.MessageApiService;
import com.unified.ur1.inbox.SendMessageRequest;
import e0.C0432c;
import f.AbstractActivityC0472i;
import f3.r;
import g3.RunnableC0551b;
import g3.ViewOnClickListenerC0552c;
import g3.d;
import g3.e;
import g3.f;
import g3.g;
import g3.l;
import g3.u;
import h4.c;
import i3.C;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes.dex */
public class ChatActivity extends AbstractActivityC0472i {

    /* renamed from: L, reason: collision with root package name */
    public static final /* synthetic */ int f5725L = 0;

    /* renamed from: A, reason: collision with root package name */
    public Runnable f5726A;

    /* renamed from: B, reason: collision with root package name */
    public FrameLayout f5727B;

    /* renamed from: C, reason: collision with root package name */
    public LinearLayout f5728C;

    /* renamed from: D, reason: collision with root package name */
    public LinearLayout f5729D;

    /* renamed from: E, reason: collision with root package name */
    public LinearLayout f5730E;

    /* renamed from: F, reason: collision with root package name */
    public ImageView f5731F;

    /* renamed from: H, reason: collision with root package name */
    public LinearLayout f5733H;

    /* renamed from: J, reason: collision with root package name */
    public A f5734J;

    /* renamed from: c, reason: collision with root package name */
    public Uri f5736c;

    /* renamed from: d, reason: collision with root package name */
    public File f5737d;

    /* renamed from: e, reason: collision with root package name */
    public RecyclerView f5738e;

    /* renamed from: f, reason: collision with root package name */
    public SwipeRefreshLayout f5739f;
    public EditText g;
    public ImageView h;

    /* renamed from: i, reason: collision with root package name */
    public ImageView f5740i;

    /* renamed from: j, reason: collision with root package name */
    public TextView f5741j;

    /* renamed from: k, reason: collision with root package name */
    public TextView f5742k;

    /* renamed from: l, reason: collision with root package name */
    public u f5743l;

    /* renamed from: m, reason: collision with root package name */
    public MessageApiService f5744m;
    public ArrayList n;

    /* renamed from: o, reason: collision with root package name */
    public String f5745o;

    /* renamed from: p, reason: collision with root package name */
    public String f5746p;

    /* renamed from: q, reason: collision with root package name */
    public i f5747q;

    /* renamed from: r, reason: collision with root package name */
    public LinearLayout f5748r;

    /* renamed from: u, reason: collision with root package name */
    public String f5751u;

    /* renamed from: v, reason: collision with root package name */
    public boolean f5752v;

    /* renamed from: w, reason: collision with root package name */
    public String f5753w;

    /* renamed from: x, reason: collision with root package name */
    public TypingBubbleView f5754x;

    /* renamed from: y, reason: collision with root package name */
    public LinearLayout f5755y;

    /* renamed from: z, reason: collision with root package name */
    public TextView f5756z;

    /* renamed from: s, reason: collision with root package name */
    public final Handler f5749s = new Handler();

    /* renamed from: t, reason: collision with root package name */
    public boolean f5750t = false;

    /* renamed from: G, reason: collision with root package name */
    public boolean f5732G = false;
    public final Handler I = new Handler(Looper.getMainLooper());

    /* renamed from: K, reason: collision with root package name */
    public boolean f5735K = true;

    public static void j(ChatActivity chatActivity, List list) {
        Message message;
        chatActivity.getClass();
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Message message2 = (Message) it.next();
            if (chatActivity.s(message2)) {
                arrayList.add(message2);
            }
        }
        arrayList.sort(new e(chatActivity, 0));
        Log.d("ChatActivity", "=== updateLocalMessages DEBUG ===");
        Log.d("ChatActivity", "Server messages count: " + arrayList.size());
        Log.d("ChatActivity", "Local messages count: " + chatActivity.n.size());
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            Message message3 = (Message) it2.next();
            linkedHashMap.put(Integer.valueOf(message3.getId()), message3);
        }
        ArrayList arrayList2 = new ArrayList(linkedHashMap.values());
        Log.d("ChatActivity", "After deduplication: " + arrayList2.size() + " unique messages");
        HashSet hashSet = new HashSet();
        Iterator it3 = chatActivity.n.iterator();
        while (it3.hasNext()) {
            hashSet.add(Integer.valueOf(((Message) it3.next()).getId()));
        }
        Iterator it4 = arrayList2.iterator();
        boolean z4 = false;
        while (it4.hasNext()) {
            Message message4 = (Message) it4.next();
            Log.d("ChatActivity", "Processing server message ID: " + message4.getId() + ", From: " + message4.getFromCallsign() + ", To: " + message4.getToCallsign() + ", Body: " + message4.getMessageBody().substring(0, Math.min(20, message4.getMessageBody().length())));
            if (hashSet.contains(Integer.valueOf(message4.getId()))) {
                Log.d("ChatActivity", "Message ID " + message4.getId() + " already processed, skipping");
            } else if (chatActivity.s(message4)) {
                long jW = w(message4.getCreatedAt());
                int size = 0;
                while (true) {
                    if (size >= chatActivity.n.size()) {
                        size = chatActivity.n.size();
                        break;
                    } else if (jW < w(((Message) chatActivity.n.get(size)).getCreatedAt())) {
                        break;
                    } else {
                        size++;
                    }
                }
                chatActivity.n.add(size, message4);
                hashSet.add(Integer.valueOf(message4.getId()));
                Log.d("ChatActivity", "ADDED new server message ID: " + message4.getId() + " at position " + size);
                z4 = true;
            } else {
                Log.d("ChatActivity", "Message ID " + message4.getId() + " not for this conversation");
            }
        }
        Iterator it5 = arrayList2.iterator();
        while (it5.hasNext()) {
            Message message5 = (Message) it5.next();
            if (chatActivity.s(message5)) {
                long id = message5.getId();
                Iterator it6 = chatActivity.n.iterator();
                while (true) {
                    if (!it6.hasNext()) {
                        message = null;
                        break;
                    } else {
                        message = (Message) it6.next();
                        if (message.getId() == id) {
                            break;
                        }
                    }
                }
                if (message != null && message.isRead() != message5.isRead()) {
                    message.setRead(message5.isRead());
                    Log.d("ChatActivity", "Updated read status for message ID: " + message5.getId());
                    z4 = true;
                }
            }
        }
        Log.d("ChatActivity", "Final local messages count: " + chatActivity.n.size());
        Log.d("ChatActivity", "=== END updateLocalMessages DEBUG ===");
        if (z4) {
            chatActivity.runOnUiThread(new RunnableC0551b(chatActivity, 5));
        }
    }

    public static long w(String str) throws NumberFormatException {
        if (str != null) {
            try {
                if (!str.trim().isEmpty()) {
                    String strTrim = str.trim();
                    if (strTrim.matches("\\d+")) {
                        long j5 = Long.parseLong(strTrim);
                        return j5 < 946684800000L ? j5 * 1000 : j5;
                    }
                    if (strTrim.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
                        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(strTrim).getTime();
                    }
                    if (strTrim.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}\\.\\d+")) {
                        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(strTrim.substring(0, 19)).getTime();
                    }
                    return Long.parseLong(strTrim);
                }
            } catch (Exception unused) {
                return System.currentTimeMillis();
            }
        }
        return System.currentTimeMillis();
    }

    public final void A(String str) {
        runOnUiThread(new m(this, 29, str));
    }

    public final void k() {
        String str;
        String str2;
        String str3;
        MessageApiService messageApiService = this.f5744m;
        if (messageApiService != null && (str = this.f5745o) != null) {
            boolean z4 = this.f5752v;
            if (z4 && (str3 = this.f5751u) != null) {
                messageApiService.getTeamTypingStatus("get_team_typing", str3, str).enqueue(new g3.i(this, 0));
            } else if (!z4 && (str2 = this.f5746p) != null) {
                messageApiService.sendTyping(str2, str, "check").enqueue(new l(this, 0));
            }
        }
        this.f5749s.postDelayed(new RunnableC0551b(this, 4), 1500L);
    }

    public final String l(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
        inputStreamOpenInputStream.close();
        if (bitmapDecodeStream.getWidth() > 800 || bitmapDecodeStream.getHeight() > 800) {
            float f5 = 800;
            float fMin = Math.min(f5 / bitmapDecodeStream.getWidth(), f5 / bitmapDecodeStream.getHeight());
            bitmapDecodeStream = Bitmap.createScaledBitmap(bitmapDecodeStream, Math.round(bitmapDecodeStream.getWidth() * fMin), Math.round(bitmapDecodeStream.getHeight() * fMin), true);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public final File m() {
        File cacheDir;
        String strS = h.s("CAMERA_", new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()));
        try {
            cacheDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "camera_temp");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            Log.d("ChatActivity", "Using external files directory: " + cacheDir.getAbsolutePath());
        } catch (Exception e5) {
            Log.w("ChatActivity", "External files directory not available, trying cache", e5);
            cacheDir = getCacheDir();
            Log.d("ChatActivity", "Using cache directory: " + cacheDir.getAbsolutePath());
        }
        File file = new File(cacheDir, h.b(strS, ".jpg"));
        Log.d("ChatActivity", "Created image file: " + file.getAbsolutePath());
        return file;
    }

    public final void n() {
        LocationManager locationManager = (LocationManager) getSystemService("location");
        if (!locationManager.isProviderEnabled("gps")) {
            Toast.makeText(this, "Please enable GPS", 0).show();
            return;
        }
        try {
            locationManager.requestSingleUpdate("gps", new r(this, 1), (Looper) null);
            Toast.makeText(this, "Getting location...", 0).show();
        } catch (SecurityException unused) {
            Toast.makeText(this, "Location permission denied", 0).show();
        }
    }

    public final void o(JSONObject jSONObject) {
        if (!jSONObject.getBoolean("success")) {
            Log.w("ChatActivity", "Distance API error: " + jSONObject.optString("error", "Unknown error"));
            A("");
            return;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("data");
        JSONObject jSONObject3 = jSONObject2.getJSONObject("direction");
        JSONObject jSONObject4 = jSONObject2.getJSONObject("to_callsign_info");
        String string = jSONObject3.getString("display");
        Log.d("ChatActivity", "Distance info received: " + string + " (Private: " + jSONObject4.getBoolean("is_private") + ")");
        A(string);
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        Uri uri;
        super.onActivityResult(i5, i6, intent);
        if (i6 == -1) {
            if (i5 != 1001) {
                if (i5 == 1002 && (uri = this.f5736c) != null) {
                    p(uri);
                    return;
                }
                return;
            }
            if (intent == null || intent.getData() == null) {
                return;
            }
            p(intent.getData());
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.f5732G) {
            q();
        } else {
            super.onBackPressed();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        String str;
        super.onCreate(bundle);
        setContentView(R.layout.activity_enhanced_simple_chat);
        this.f5751u = getIntent().getStringExtra("team_id");
        this.f5753w = getIntent().getStringExtra("team_name");
        String str2 = this.f5751u;
        this.f5752v = (str2 == null || str2.isEmpty()) ? false : true;
        this.f5745o = c.h(this);
        if (this.f5752v) {
            StringBuilder sb = new StringBuilder("RadioTeams");
            String str3 = this.f5753w;
            if (str3 == null) {
                str3 = this.f5751u;
            }
            sb.append(str3);
            this.f5746p = sb.toString();
            StringBuilder sb2 = new StringBuilder("Starting team chat with team_id: ");
            sb2.append(this.f5751u);
            sb2.append(", team_name: ");
            h.q(sb2, this.f5753w, "ChatActivity");
        } else {
            this.f5746p = getIntent().getStringExtra("other_user_callsign");
            h.q(new StringBuilder("Starting direct chat with: "), this.f5746p, "ChatActivity");
        }
        String str4 = this.f5746p;
        if (str4 == null || str4.isEmpty() || (str = this.f5745o) == null || str.isEmpty()) {
            Toast.makeText(this, "Invalid chat parameters", 0).show();
            finish();
            return;
        }
        this.f5738e = (RecyclerView) findViewById(R.id.recyclerViewChat);
        this.f5739f = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.g = (EditText) findViewById(R.id.editMessage);
        this.h = (ImageView) findViewById(R.id.buttonSend);
        this.f5740i = (ImageView) findViewById(R.id.buttonBack);
        this.f5731F = (ImageView) findViewById(R.id.buttonAttachment);
        this.f5741j = (TextView) findViewById(R.id.titleText);
        this.f5742k = (TextView) findViewById(R.id.avatarText);
        this.f5754x = (TypingBubbleView) findViewById(R.id.typingBubble);
        this.f5755y = (LinearLayout) findViewById(R.id.typingContainer);
        this.f5756z = (TextView) findViewById(R.id.typingText);
        this.f5748r = (LinearLayout) findViewById(R.id.menuItemDMR);
        this.f5727B = (FrameLayout) findViewById(R.id.attachmentMenuOverlay);
        this.f5728C = (LinearLayout) findViewById(R.id.attachmentMenuContainer);
        this.f5729D = (LinearLayout) findViewById(R.id.menuItemCamera);
        this.f5730E = (LinearLayout) findViewById(R.id.menuItemGallery);
        this.f5733H = (LinearLayout) findViewById(R.id.menuItemLocation);
        this.f5747q = c.I(this);
        this.f5741j.setText(this.f5746p);
        if (this.f5752v) {
            this.f5742k.setText("T");
        } else {
            this.f5742k.setText(this.f5746p.length() >= 2 ? this.f5746p.substring(0, 2).toUpperCase() : this.f5746p.toUpperCase());
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        final int i5 = 0;
        this.h.setOnClickListener(new View.OnClickListener(this) { // from class: g3.a

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f6960d;

            {
                this.f6960d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, IOException {
                ChatActivity chatActivity = this.f6960d;
                switch (i5) {
                    case 0:
                        String strTrim = chatActivity.g.getText().toString().trim();
                        if (!strTrim.isEmpty() && chatActivity.f5744m != null) {
                            if (chatActivity.f5750t) {
                                chatActivity.z("0");
                                chatActivity.f5750t = false;
                            }
                            chatActivity.y(strTrim, null);
                            chatActivity.g.setText("");
                            break;
                        }
                        break;
                    case 1:
                        int i6 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.CAMERA") == 0) {
                            chatActivity.x();
                            break;
                        } else {
                            Log.d("ChatActivity", "Camera permission not granted, requesting...");
                            B.e.d(chatActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i7 = ChatActivity.f5725L;
                        chatActivity.q();
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        chatActivity.startActivityForResult(intent, 1001);
                        break;
                    case 3:
                        int i8 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            chatActivity.n();
                            break;
                        } else {
                            B.e.d(chatActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
                            break;
                        }
                    case 4:
                        int i9 = ChatActivity.f5725L;
                        chatActivity.q();
                        try {
                            String strJ = h4.c.j(chatActivity);
                            String strY = h4.c.y(chatActivity);
                            int i10 = h4.c.C(chatActivity).getInt("dmr_port", 62031);
                            int iL = h4.c.l(chatActivity);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "dmr_invitation");
                            jSONObject.put("from_callsign", chatActivity.f5745o);
                            jSONObject.put("hostname", strJ);
                            jSONObject.put("network", strY);
                            jSONObject.put("port", i10);
                            jSONObject.put("talkgroup", iL);
                            jSONObject.put("timestamp", System.currentTimeMillis());
                            chatActivity.y("📻 " + chatActivity.f5745o + " is inviting you to join them on: " + strY + ", Talkgroup: " + iL, "[{\"type\":\"dmr_invitation\",\"data\":\"" + jSONObject.toString().replace("\"", "\\\"") + "\"}]");
                            Toast.makeText(chatActivity, "ROIP invitation sent!", 0).show();
                            break;
                        } catch (Exception e5) {
                            Log.e("ChatActivity", "Error creating DMR invitation", e5);
                            Toast.makeText(chatActivity, "Failed to create invitation", 0).show();
                            return;
                        }
                    case 5:
                        int i11 = ChatActivity.f5725L;
                        chatActivity.q();
                        break;
                    case 6:
                        int i12 = ChatActivity.f5725L;
                        chatActivity.finish();
                        break;
                    default:
                        boolean z4 = chatActivity.f5732G;
                        if (!z4) {
                            if (!z4) {
                                chatActivity.f5732G = true;
                                chatActivity.f5727B.setVisibility(0);
                                chatActivity.f5731F.setColorFilter(-8355712);
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) chatActivity.f5728C.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                }
                                layoutParams.gravity = 8388691;
                                layoutParams.leftMargin = 16;
                                layoutParams.bottomMargin = 120;
                                chatActivity.f5728C.setLayoutParams(layoutParams);
                                chatActivity.f5728C.setScaleX(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setScaleY(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setAlpha(BitmapDescriptorFactory.HUE_RED);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleX", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleY", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5727B, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f));
                                animatorSet.setDuration(250L);
                                animatorSet.setInterpolator(new OvershootInterpolator(1.2f));
                                animatorSet.start();
                                break;
                            }
                        } else {
                            chatActivity.q();
                            break;
                        }
                        break;
                }
            }
        });
        final int i6 = 6;
        this.f5740i.setOnClickListener(new View.OnClickListener(this) { // from class: g3.a

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f6960d;

            {
                this.f6960d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, IOException {
                ChatActivity chatActivity = this.f6960d;
                switch (i6) {
                    case 0:
                        String strTrim = chatActivity.g.getText().toString().trim();
                        if (!strTrim.isEmpty() && chatActivity.f5744m != null) {
                            if (chatActivity.f5750t) {
                                chatActivity.z("0");
                                chatActivity.f5750t = false;
                            }
                            chatActivity.y(strTrim, null);
                            chatActivity.g.setText("");
                            break;
                        }
                        break;
                    case 1:
                        int i62 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.CAMERA") == 0) {
                            chatActivity.x();
                            break;
                        } else {
                            Log.d("ChatActivity", "Camera permission not granted, requesting...");
                            B.e.d(chatActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i7 = ChatActivity.f5725L;
                        chatActivity.q();
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        chatActivity.startActivityForResult(intent, 1001);
                        break;
                    case 3:
                        int i8 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            chatActivity.n();
                            break;
                        } else {
                            B.e.d(chatActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
                            break;
                        }
                    case 4:
                        int i9 = ChatActivity.f5725L;
                        chatActivity.q();
                        try {
                            String strJ = h4.c.j(chatActivity);
                            String strY = h4.c.y(chatActivity);
                            int i10 = h4.c.C(chatActivity).getInt("dmr_port", 62031);
                            int iL = h4.c.l(chatActivity);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "dmr_invitation");
                            jSONObject.put("from_callsign", chatActivity.f5745o);
                            jSONObject.put("hostname", strJ);
                            jSONObject.put("network", strY);
                            jSONObject.put("port", i10);
                            jSONObject.put("talkgroup", iL);
                            jSONObject.put("timestamp", System.currentTimeMillis());
                            chatActivity.y("📻 " + chatActivity.f5745o + " is inviting you to join them on: " + strY + ", Talkgroup: " + iL, "[{\"type\":\"dmr_invitation\",\"data\":\"" + jSONObject.toString().replace("\"", "\\\"") + "\"}]");
                            Toast.makeText(chatActivity, "ROIP invitation sent!", 0).show();
                            break;
                        } catch (Exception e5) {
                            Log.e("ChatActivity", "Error creating DMR invitation", e5);
                            Toast.makeText(chatActivity, "Failed to create invitation", 0).show();
                            return;
                        }
                    case 5:
                        int i11 = ChatActivity.f5725L;
                        chatActivity.q();
                        break;
                    case 6:
                        int i12 = ChatActivity.f5725L;
                        chatActivity.finish();
                        break;
                    default:
                        boolean z4 = chatActivity.f5732G;
                        if (!z4) {
                            if (!z4) {
                                chatActivity.f5732G = true;
                                chatActivity.f5727B.setVisibility(0);
                                chatActivity.f5731F.setColorFilter(-8355712);
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) chatActivity.f5728C.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                }
                                layoutParams.gravity = 8388691;
                                layoutParams.leftMargin = 16;
                                layoutParams.bottomMargin = 120;
                                chatActivity.f5728C.setLayoutParams(layoutParams);
                                chatActivity.f5728C.setScaleX(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setScaleY(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setAlpha(BitmapDescriptorFactory.HUE_RED);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleX", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleY", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5727B, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f));
                                animatorSet.setDuration(250L);
                                animatorSet.setInterpolator(new OvershootInterpolator(1.2f));
                                animatorSet.start();
                                break;
                            }
                        } else {
                            chatActivity.q();
                            break;
                        }
                        break;
                }
            }
        });
        final int i7 = 7;
        this.f5731F.setOnClickListener(new View.OnClickListener(this) { // from class: g3.a

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f6960d;

            {
                this.f6960d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, IOException {
                ChatActivity chatActivity = this.f6960d;
                switch (i7) {
                    case 0:
                        String strTrim = chatActivity.g.getText().toString().trim();
                        if (!strTrim.isEmpty() && chatActivity.f5744m != null) {
                            if (chatActivity.f5750t) {
                                chatActivity.z("0");
                                chatActivity.f5750t = false;
                            }
                            chatActivity.y(strTrim, null);
                            chatActivity.g.setText("");
                            break;
                        }
                        break;
                    case 1:
                        int i62 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.CAMERA") == 0) {
                            chatActivity.x();
                            break;
                        } else {
                            Log.d("ChatActivity", "Camera permission not granted, requesting...");
                            B.e.d(chatActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i72 = ChatActivity.f5725L;
                        chatActivity.q();
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        chatActivity.startActivityForResult(intent, 1001);
                        break;
                    case 3:
                        int i8 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            chatActivity.n();
                            break;
                        } else {
                            B.e.d(chatActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
                            break;
                        }
                    case 4:
                        int i9 = ChatActivity.f5725L;
                        chatActivity.q();
                        try {
                            String strJ = h4.c.j(chatActivity);
                            String strY = h4.c.y(chatActivity);
                            int i10 = h4.c.C(chatActivity).getInt("dmr_port", 62031);
                            int iL = h4.c.l(chatActivity);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "dmr_invitation");
                            jSONObject.put("from_callsign", chatActivity.f5745o);
                            jSONObject.put("hostname", strJ);
                            jSONObject.put("network", strY);
                            jSONObject.put("port", i10);
                            jSONObject.put("talkgroup", iL);
                            jSONObject.put("timestamp", System.currentTimeMillis());
                            chatActivity.y("📻 " + chatActivity.f5745o + " is inviting you to join them on: " + strY + ", Talkgroup: " + iL, "[{\"type\":\"dmr_invitation\",\"data\":\"" + jSONObject.toString().replace("\"", "\\\"") + "\"}]");
                            Toast.makeText(chatActivity, "ROIP invitation sent!", 0).show();
                            break;
                        } catch (Exception e5) {
                            Log.e("ChatActivity", "Error creating DMR invitation", e5);
                            Toast.makeText(chatActivity, "Failed to create invitation", 0).show();
                            return;
                        }
                    case 5:
                        int i11 = ChatActivity.f5725L;
                        chatActivity.q();
                        break;
                    case 6:
                        int i12 = ChatActivity.f5725L;
                        chatActivity.finish();
                        break;
                    default:
                        boolean z4 = chatActivity.f5732G;
                        if (!z4) {
                            if (!z4) {
                                chatActivity.f5732G = true;
                                chatActivity.f5727B.setVisibility(0);
                                chatActivity.f5731F.setColorFilter(-8355712);
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) chatActivity.f5728C.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                }
                                layoutParams.gravity = 8388691;
                                layoutParams.leftMargin = 16;
                                layoutParams.bottomMargin = 120;
                                chatActivity.f5728C.setLayoutParams(layoutParams);
                                chatActivity.f5728C.setScaleX(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setScaleY(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setAlpha(BitmapDescriptorFactory.HUE_RED);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleX", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleY", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5727B, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f));
                                animatorSet.setDuration(250L);
                                animatorSet.setInterpolator(new OvershootInterpolator(1.2f));
                                animatorSet.start();
                                break;
                            }
                        } else {
                            chatActivity.q();
                            break;
                        }
                        break;
                }
            }
        });
        this.f5739f.setOnRefreshListener(new d(this));
        final int i8 = 1;
        this.f5729D.setOnClickListener(new View.OnClickListener(this) { // from class: g3.a

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f6960d;

            {
                this.f6960d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, IOException {
                ChatActivity chatActivity = this.f6960d;
                switch (i8) {
                    case 0:
                        String strTrim = chatActivity.g.getText().toString().trim();
                        if (!strTrim.isEmpty() && chatActivity.f5744m != null) {
                            if (chatActivity.f5750t) {
                                chatActivity.z("0");
                                chatActivity.f5750t = false;
                            }
                            chatActivity.y(strTrim, null);
                            chatActivity.g.setText("");
                            break;
                        }
                        break;
                    case 1:
                        int i62 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.CAMERA") == 0) {
                            chatActivity.x();
                            break;
                        } else {
                            Log.d("ChatActivity", "Camera permission not granted, requesting...");
                            B.e.d(chatActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i72 = ChatActivity.f5725L;
                        chatActivity.q();
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        chatActivity.startActivityForResult(intent, 1001);
                        break;
                    case 3:
                        int i82 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            chatActivity.n();
                            break;
                        } else {
                            B.e.d(chatActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
                            break;
                        }
                    case 4:
                        int i9 = ChatActivity.f5725L;
                        chatActivity.q();
                        try {
                            String strJ = h4.c.j(chatActivity);
                            String strY = h4.c.y(chatActivity);
                            int i10 = h4.c.C(chatActivity).getInt("dmr_port", 62031);
                            int iL = h4.c.l(chatActivity);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "dmr_invitation");
                            jSONObject.put("from_callsign", chatActivity.f5745o);
                            jSONObject.put("hostname", strJ);
                            jSONObject.put("network", strY);
                            jSONObject.put("port", i10);
                            jSONObject.put("talkgroup", iL);
                            jSONObject.put("timestamp", System.currentTimeMillis());
                            chatActivity.y("📻 " + chatActivity.f5745o + " is inviting you to join them on: " + strY + ", Talkgroup: " + iL, "[{\"type\":\"dmr_invitation\",\"data\":\"" + jSONObject.toString().replace("\"", "\\\"") + "\"}]");
                            Toast.makeText(chatActivity, "ROIP invitation sent!", 0).show();
                            break;
                        } catch (Exception e5) {
                            Log.e("ChatActivity", "Error creating DMR invitation", e5);
                            Toast.makeText(chatActivity, "Failed to create invitation", 0).show();
                            return;
                        }
                    case 5:
                        int i11 = ChatActivity.f5725L;
                        chatActivity.q();
                        break;
                    case 6:
                        int i12 = ChatActivity.f5725L;
                        chatActivity.finish();
                        break;
                    default:
                        boolean z4 = chatActivity.f5732G;
                        if (!z4) {
                            if (!z4) {
                                chatActivity.f5732G = true;
                                chatActivity.f5727B.setVisibility(0);
                                chatActivity.f5731F.setColorFilter(-8355712);
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) chatActivity.f5728C.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                }
                                layoutParams.gravity = 8388691;
                                layoutParams.leftMargin = 16;
                                layoutParams.bottomMargin = 120;
                                chatActivity.f5728C.setLayoutParams(layoutParams);
                                chatActivity.f5728C.setScaleX(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setScaleY(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setAlpha(BitmapDescriptorFactory.HUE_RED);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleX", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleY", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5727B, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f));
                                animatorSet.setDuration(250L);
                                animatorSet.setInterpolator(new OvershootInterpolator(1.2f));
                                animatorSet.start();
                                break;
                            }
                        } else {
                            chatActivity.q();
                            break;
                        }
                        break;
                }
            }
        });
        final int i9 = 2;
        this.f5730E.setOnClickListener(new View.OnClickListener(this) { // from class: g3.a

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f6960d;

            {
                this.f6960d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, IOException {
                ChatActivity chatActivity = this.f6960d;
                switch (i9) {
                    case 0:
                        String strTrim = chatActivity.g.getText().toString().trim();
                        if (!strTrim.isEmpty() && chatActivity.f5744m != null) {
                            if (chatActivity.f5750t) {
                                chatActivity.z("0");
                                chatActivity.f5750t = false;
                            }
                            chatActivity.y(strTrim, null);
                            chatActivity.g.setText("");
                            break;
                        }
                        break;
                    case 1:
                        int i62 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.CAMERA") == 0) {
                            chatActivity.x();
                            break;
                        } else {
                            Log.d("ChatActivity", "Camera permission not granted, requesting...");
                            B.e.d(chatActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i72 = ChatActivity.f5725L;
                        chatActivity.q();
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        chatActivity.startActivityForResult(intent, 1001);
                        break;
                    case 3:
                        int i82 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            chatActivity.n();
                            break;
                        } else {
                            B.e.d(chatActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
                            break;
                        }
                    case 4:
                        int i92 = ChatActivity.f5725L;
                        chatActivity.q();
                        try {
                            String strJ = h4.c.j(chatActivity);
                            String strY = h4.c.y(chatActivity);
                            int i10 = h4.c.C(chatActivity).getInt("dmr_port", 62031);
                            int iL = h4.c.l(chatActivity);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "dmr_invitation");
                            jSONObject.put("from_callsign", chatActivity.f5745o);
                            jSONObject.put("hostname", strJ);
                            jSONObject.put("network", strY);
                            jSONObject.put("port", i10);
                            jSONObject.put("talkgroup", iL);
                            jSONObject.put("timestamp", System.currentTimeMillis());
                            chatActivity.y("📻 " + chatActivity.f5745o + " is inviting you to join them on: " + strY + ", Talkgroup: " + iL, "[{\"type\":\"dmr_invitation\",\"data\":\"" + jSONObject.toString().replace("\"", "\\\"") + "\"}]");
                            Toast.makeText(chatActivity, "ROIP invitation sent!", 0).show();
                            break;
                        } catch (Exception e5) {
                            Log.e("ChatActivity", "Error creating DMR invitation", e5);
                            Toast.makeText(chatActivity, "Failed to create invitation", 0).show();
                            return;
                        }
                    case 5:
                        int i11 = ChatActivity.f5725L;
                        chatActivity.q();
                        break;
                    case 6:
                        int i12 = ChatActivity.f5725L;
                        chatActivity.finish();
                        break;
                    default:
                        boolean z4 = chatActivity.f5732G;
                        if (!z4) {
                            if (!z4) {
                                chatActivity.f5732G = true;
                                chatActivity.f5727B.setVisibility(0);
                                chatActivity.f5731F.setColorFilter(-8355712);
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) chatActivity.f5728C.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                }
                                layoutParams.gravity = 8388691;
                                layoutParams.leftMargin = 16;
                                layoutParams.bottomMargin = 120;
                                chatActivity.f5728C.setLayoutParams(layoutParams);
                                chatActivity.f5728C.setScaleX(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setScaleY(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setAlpha(BitmapDescriptorFactory.HUE_RED);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleX", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleY", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5727B, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f));
                                animatorSet.setDuration(250L);
                                animatorSet.setInterpolator(new OvershootInterpolator(1.2f));
                                animatorSet.start();
                                break;
                            }
                        } else {
                            chatActivity.q();
                            break;
                        }
                        break;
                }
            }
        });
        final int i10 = 3;
        this.f5733H.setOnClickListener(new View.OnClickListener(this) { // from class: g3.a

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f6960d;

            {
                this.f6960d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, IOException {
                ChatActivity chatActivity = this.f6960d;
                switch (i10) {
                    case 0:
                        String strTrim = chatActivity.g.getText().toString().trim();
                        if (!strTrim.isEmpty() && chatActivity.f5744m != null) {
                            if (chatActivity.f5750t) {
                                chatActivity.z("0");
                                chatActivity.f5750t = false;
                            }
                            chatActivity.y(strTrim, null);
                            chatActivity.g.setText("");
                            break;
                        }
                        break;
                    case 1:
                        int i62 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.CAMERA") == 0) {
                            chatActivity.x();
                            break;
                        } else {
                            Log.d("ChatActivity", "Camera permission not granted, requesting...");
                            B.e.d(chatActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i72 = ChatActivity.f5725L;
                        chatActivity.q();
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        chatActivity.startActivityForResult(intent, 1001);
                        break;
                    case 3:
                        int i82 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            chatActivity.n();
                            break;
                        } else {
                            B.e.d(chatActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
                            break;
                        }
                    case 4:
                        int i92 = ChatActivity.f5725L;
                        chatActivity.q();
                        try {
                            String strJ = h4.c.j(chatActivity);
                            String strY = h4.c.y(chatActivity);
                            int i102 = h4.c.C(chatActivity).getInt("dmr_port", 62031);
                            int iL = h4.c.l(chatActivity);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "dmr_invitation");
                            jSONObject.put("from_callsign", chatActivity.f5745o);
                            jSONObject.put("hostname", strJ);
                            jSONObject.put("network", strY);
                            jSONObject.put("port", i102);
                            jSONObject.put("talkgroup", iL);
                            jSONObject.put("timestamp", System.currentTimeMillis());
                            chatActivity.y("📻 " + chatActivity.f5745o + " is inviting you to join them on: " + strY + ", Talkgroup: " + iL, "[{\"type\":\"dmr_invitation\",\"data\":\"" + jSONObject.toString().replace("\"", "\\\"") + "\"}]");
                            Toast.makeText(chatActivity, "ROIP invitation sent!", 0).show();
                            break;
                        } catch (Exception e5) {
                            Log.e("ChatActivity", "Error creating DMR invitation", e5);
                            Toast.makeText(chatActivity, "Failed to create invitation", 0).show();
                            return;
                        }
                    case 5:
                        int i11 = ChatActivity.f5725L;
                        chatActivity.q();
                        break;
                    case 6:
                        int i12 = ChatActivity.f5725L;
                        chatActivity.finish();
                        break;
                    default:
                        boolean z4 = chatActivity.f5732G;
                        if (!z4) {
                            if (!z4) {
                                chatActivity.f5732G = true;
                                chatActivity.f5727B.setVisibility(0);
                                chatActivity.f5731F.setColorFilter(-8355712);
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) chatActivity.f5728C.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                }
                                layoutParams.gravity = 8388691;
                                layoutParams.leftMargin = 16;
                                layoutParams.bottomMargin = 120;
                                chatActivity.f5728C.setLayoutParams(layoutParams);
                                chatActivity.f5728C.setScaleX(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setScaleY(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setAlpha(BitmapDescriptorFactory.HUE_RED);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleX", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleY", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5727B, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f));
                                animatorSet.setDuration(250L);
                                animatorSet.setInterpolator(new OvershootInterpolator(1.2f));
                                animatorSet.start();
                                break;
                            }
                        } else {
                            chatActivity.q();
                            break;
                        }
                        break;
                }
            }
        });
        final int i11 = 4;
        this.f5748r.setOnClickListener(new View.OnClickListener(this) { // from class: g3.a

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f6960d;

            {
                this.f6960d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, IOException {
                ChatActivity chatActivity = this.f6960d;
                switch (i11) {
                    case 0:
                        String strTrim = chatActivity.g.getText().toString().trim();
                        if (!strTrim.isEmpty() && chatActivity.f5744m != null) {
                            if (chatActivity.f5750t) {
                                chatActivity.z("0");
                                chatActivity.f5750t = false;
                            }
                            chatActivity.y(strTrim, null);
                            chatActivity.g.setText("");
                            break;
                        }
                        break;
                    case 1:
                        int i62 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.CAMERA") == 0) {
                            chatActivity.x();
                            break;
                        } else {
                            Log.d("ChatActivity", "Camera permission not granted, requesting...");
                            B.e.d(chatActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i72 = ChatActivity.f5725L;
                        chatActivity.q();
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        chatActivity.startActivityForResult(intent, 1001);
                        break;
                    case 3:
                        int i82 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            chatActivity.n();
                            break;
                        } else {
                            B.e.d(chatActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
                            break;
                        }
                    case 4:
                        int i92 = ChatActivity.f5725L;
                        chatActivity.q();
                        try {
                            String strJ = h4.c.j(chatActivity);
                            String strY = h4.c.y(chatActivity);
                            int i102 = h4.c.C(chatActivity).getInt("dmr_port", 62031);
                            int iL = h4.c.l(chatActivity);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "dmr_invitation");
                            jSONObject.put("from_callsign", chatActivity.f5745o);
                            jSONObject.put("hostname", strJ);
                            jSONObject.put("network", strY);
                            jSONObject.put("port", i102);
                            jSONObject.put("talkgroup", iL);
                            jSONObject.put("timestamp", System.currentTimeMillis());
                            chatActivity.y("📻 " + chatActivity.f5745o + " is inviting you to join them on: " + strY + ", Talkgroup: " + iL, "[{\"type\":\"dmr_invitation\",\"data\":\"" + jSONObject.toString().replace("\"", "\\\"") + "\"}]");
                            Toast.makeText(chatActivity, "ROIP invitation sent!", 0).show();
                            break;
                        } catch (Exception e5) {
                            Log.e("ChatActivity", "Error creating DMR invitation", e5);
                            Toast.makeText(chatActivity, "Failed to create invitation", 0).show();
                            return;
                        }
                    case 5:
                        int i112 = ChatActivity.f5725L;
                        chatActivity.q();
                        break;
                    case 6:
                        int i12 = ChatActivity.f5725L;
                        chatActivity.finish();
                        break;
                    default:
                        boolean z4 = chatActivity.f5732G;
                        if (!z4) {
                            if (!z4) {
                                chatActivity.f5732G = true;
                                chatActivity.f5727B.setVisibility(0);
                                chatActivity.f5731F.setColorFilter(-8355712);
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) chatActivity.f5728C.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                }
                                layoutParams.gravity = 8388691;
                                layoutParams.leftMargin = 16;
                                layoutParams.bottomMargin = 120;
                                chatActivity.f5728C.setLayoutParams(layoutParams);
                                chatActivity.f5728C.setScaleX(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setScaleY(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setAlpha(BitmapDescriptorFactory.HUE_RED);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleX", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleY", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5727B, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f));
                                animatorSet.setDuration(250L);
                                animatorSet.setInterpolator(new OvershootInterpolator(1.2f));
                                animatorSet.start();
                                break;
                            }
                        } else {
                            chatActivity.q();
                            break;
                        }
                        break;
                }
            }
        });
        final int i12 = 5;
        this.f5727B.setOnClickListener(new View.OnClickListener(this) { // from class: g3.a

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ChatActivity f6960d;

            {
                this.f6960d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws JSONException, IOException {
                ChatActivity chatActivity = this.f6960d;
                switch (i12) {
                    case 0:
                        String strTrim = chatActivity.g.getText().toString().trim();
                        if (!strTrim.isEmpty() && chatActivity.f5744m != null) {
                            if (chatActivity.f5750t) {
                                chatActivity.z("0");
                                chatActivity.f5750t = false;
                            }
                            chatActivity.y(strTrim, null);
                            chatActivity.g.setText("");
                            break;
                        }
                        break;
                    case 1:
                        int i62 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.CAMERA") == 0) {
                            chatActivity.x();
                            break;
                        } else {
                            Log.d("ChatActivity", "Camera permission not granted, requesting...");
                            B.e.d(chatActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i72 = ChatActivity.f5725L;
                        chatActivity.q();
                        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/*");
                        chatActivity.startActivityForResult(intent, 1001);
                        break;
                    case 3:
                        int i82 = ChatActivity.f5725L;
                        chatActivity.q();
                        if (C.h.a(chatActivity, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                            chatActivity.n();
                            break;
                        } else {
                            B.e.d(chatActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION"}, GeofenceStatusCodes.GEOFENCE_INSUFFICIENT_LOCATION_PERMISSION);
                            break;
                        }
                    case 4:
                        int i92 = ChatActivity.f5725L;
                        chatActivity.q();
                        try {
                            String strJ = h4.c.j(chatActivity);
                            String strY = h4.c.y(chatActivity);
                            int i102 = h4.c.C(chatActivity).getInt("dmr_port", 62031);
                            int iL = h4.c.l(chatActivity);
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("type", "dmr_invitation");
                            jSONObject.put("from_callsign", chatActivity.f5745o);
                            jSONObject.put("hostname", strJ);
                            jSONObject.put("network", strY);
                            jSONObject.put("port", i102);
                            jSONObject.put("talkgroup", iL);
                            jSONObject.put("timestamp", System.currentTimeMillis());
                            chatActivity.y("📻 " + chatActivity.f5745o + " is inviting you to join them on: " + strY + ", Talkgroup: " + iL, "[{\"type\":\"dmr_invitation\",\"data\":\"" + jSONObject.toString().replace("\"", "\\\"") + "\"}]");
                            Toast.makeText(chatActivity, "ROIP invitation sent!", 0).show();
                            break;
                        } catch (Exception e5) {
                            Log.e("ChatActivity", "Error creating DMR invitation", e5);
                            Toast.makeText(chatActivity, "Failed to create invitation", 0).show();
                            return;
                        }
                    case 5:
                        int i112 = ChatActivity.f5725L;
                        chatActivity.q();
                        break;
                    case 6:
                        int i122 = ChatActivity.f5725L;
                        chatActivity.finish();
                        break;
                    default:
                        boolean z4 = chatActivity.f5732G;
                        if (!z4) {
                            if (!z4) {
                                chatActivity.f5732G = true;
                                chatActivity.f5727B.setVisibility(0);
                                chatActivity.f5731F.setColorFilter(-8355712);
                                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) chatActivity.f5728C.getLayoutParams();
                                if (layoutParams == null) {
                                    layoutParams = new FrameLayout.LayoutParams(-2, -2);
                                }
                                layoutParams.gravity = 8388691;
                                layoutParams.leftMargin = 16;
                                layoutParams.bottomMargin = 120;
                                chatActivity.f5728C.setLayoutParams(layoutParams);
                                chatActivity.f5728C.setScaleX(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setScaleY(BitmapDescriptorFactory.HUE_RED);
                                chatActivity.f5728C.setAlpha(BitmapDescriptorFactory.HUE_RED);
                                AnimatorSet animatorSet = new AnimatorSet();
                                animatorSet.playTogether(ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleX", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "scaleY", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5728C, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f), ObjectAnimator.ofFloat(chatActivity.f5727B, "alpha", BitmapDescriptorFactory.HUE_RED, 1.0f));
                                animatorSet.setDuration(250L);
                                animatorSet.setInterpolator(new OvershootInterpolator(1.2f));
                                animatorSet.start();
                                break;
                            }
                        } else {
                            chatActivity.q();
                            break;
                        }
                        break;
                }
            }
        });
        this.f5728C.setOnClickListener(new ViewOnClickListenerC0552c());
        this.g.addTextChangedListener(new f(0, this));
        try {
            this.f5744m = (MessageApiService) new Retrofit.Builder().baseUrl("https://ur1.unifiedradios.com/messages/").addConverterFactory(GsonConverterFactory.create()).build().create(MessageApiService.class);
            Log.d("ChatActivity", "API Service configured with base URL: https://ur1.unifiedradios.com/messages/");
        } catch (Exception e5) {
            h.o(e5, new StringBuilder("Failed to setup API service: "), "ChatActivity");
            this.f5744m = null;
        }
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        String str5 = this.f5745o;
        g gVar = new g(this);
        boolean z4 = this.f5752v;
        u uVar = new u();
        uVar.f7016a = arrayList;
        uVar.f7017b = str5;
        uVar.f7018c = gVar;
        uVar.f7019d = z4;
        this.f5743l = uVar;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.d1(true);
        linearLayoutManager.c(null);
        if (linearLayoutManager.f4057t) {
            linearLayoutManager.f4057t = false;
            linearLayoutManager.n0();
        }
        this.f5738e.setLayoutManager(linearLayoutManager);
        this.f5738e.setAdapter(this.f5743l);
        A a2 = new A(20, this);
        this.f5734J = a2;
        this.I.postDelayed(a2, DeviceOrientationRequest.OUTPUT_PERIOD_FAST);
        boolean z5 = this.f5752v;
        if (!z5) {
            if (z5) {
                A("");
            } else {
                String string = getSharedPreferences("app_settings", 0).getString("auth_code_1", "");
                if (string.isEmpty() || this.f5745o.isEmpty()) {
                    A("");
                } else {
                    this.f5747q.a(new R0.f("https://ur1.unifiedradios.com/api-nearby/callsign_distance_api.php?from_callsign=" + this.f5745o + "&to_callsign=" + this.f5746p + "&cloud_auth=" + string, new d(this), new d(this)));
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController insetsController = getWindow().getInsetsController();
            if (insetsController != null) {
                insetsController.hide(WindowInsets.Type.navigationBars());
                insetsController.setSystemBarsBehavior(2);
            }
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4102);
        }
        t();
        k();
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        if (this.f5750t) {
            z("0");
        }
        r();
        this.I.removeCallbacks(this.f5734J);
        this.f5749s.removeCallbacksAndMessages(null);
        v();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        this.f5735K = false;
        if (this.f5732G) {
            q();
        }
        if (this.f5750t) {
            z("0");
            this.f5750t = false;
        }
        r();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) throws IOException {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 1003) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Log.d("ChatActivity", "Camera permission denied");
                Toast.makeText(this, "Camera permission is required to take photos", 1).show();
                return;
            } else {
                Log.d("ChatActivity", "Camera permission granted");
                x();
                return;
            }
        }
        if (i5 == 1004) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Log.d("ChatActivity", "Location permission denied");
                Toast.makeText(this, "Location permission is required to share location", 1).show();
            } else {
                Log.d("ChatActivity", "Location permission granted");
                n();
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onResume() {
        super.onResume();
        this.f5735K = true;
        t();
    }

    public final void p(Uri uri) {
        try {
            String strL = l(uri);
            if (strL != null && this.f5744m != null) {
                y("📷 Image", "[{\"type\":\"image\",\"filename\":\"image_" + System.currentTimeMillis() + ".jpg\",\"data\":\"" + strL + "\"}]");
            }
            Uri uri2 = this.f5736c;
            Toast.makeText(this, "Image " + ((uri2 == null || !uri2.equals(uri)) ? "selected" : "captured") + " and sent!", 0).show();
        } catch (Exception e5) {
            Log.e("ChatActivity", "Error processing image", e5);
            Toast.makeText(this, "Failed to process image", 0).show();
        }
    }

    public final void q() {
        if (this.f5732G) {
            this.f5732G = false;
            this.f5731F.clearColorFilter();
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ObjectAnimator.ofFloat(this.f5728C, "scaleX", 1.0f, BitmapDescriptorFactory.HUE_RED), ObjectAnimator.ofFloat(this.f5728C, "scaleY", 1.0f, BitmapDescriptorFactory.HUE_RED), ObjectAnimator.ofFloat(this.f5728C, "alpha", 1.0f, BitmapDescriptorFactory.HUE_RED), ObjectAnimator.ofFloat(this.f5727B, "alpha", 1.0f, BitmapDescriptorFactory.HUE_RED));
            animatorSet.setDuration(200L);
            animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
            animatorSet.addListener(new a(2, this));
            animatorSet.start();
        }
    }

    public final void r() {
        LinearLayout linearLayout = this.f5755y;
        if (linearLayout == null || this.f5754x == null) {
            return;
        }
        linearLayout.setVisibility(8);
        this.f5754x.a();
    }

    public final boolean s(Message message) {
        if (message.isDeleted()) {
            return false;
        }
        if (this.f5752v) {
            return this.f5751u.equals(message.getTeamId());
        }
        if (message.getTeamId() == null || message.getTeamId().isEmpty()) {
            return (message.getFromCallsign().equals(this.f5745o) && message.getToCallsign().equals(this.f5746p)) || (message.getFromCallsign().equals(this.f5746p) && message.getToCallsign().equals(this.f5745o)) || (this.f5745o.equals(this.f5746p) && message.getFromCallsign().equals(this.f5745o) && message.getToCallsign().equals(this.f5745o));
        }
        return false;
    }

    public final void t() {
        MessageApiService messageApiService = this.f5744m;
        if (messageApiService == null) {
            this.f5739f.setRefreshing(false);
        } else if (this.f5752v) {
            messageApiService.getTeamMessages("get_team_messages", this.f5751u, this.f5745o, 0, 300).enqueue(new B0.l(15, this));
        } else {
            messageApiService.getMessages(this.f5745o, 0, 300).enqueue(new g3.i(this, 1));
        }
    }

    public final void u() {
        if (this.f5744m == null) {
            return;
        }
        Iterator it = this.n.iterator();
        boolean z4 = false;
        while (it.hasNext()) {
            Message message = (Message) it.next();
            if (this.f5752v) {
                if (!message.isRead() && !message.getFromCallsign().equals(this.f5745o)) {
                    this.f5744m.markAsRead("mark_read", message.getId()).enqueue(new L0.c(this, 17, message));
                    z4 = true;
                }
            } else if (!message.isRead() && message.getToCallsign().equals(this.f5745o)) {
                this.f5744m.markAsRead("mark_read", message.getId()).enqueue(new L0.c(this, 17, message));
                z4 = true;
            }
        }
        if (z4) {
            new Handler(Looper.getMainLooper()).postDelayed(new RunnableC0551b(this, 1), 1000L);
        }
    }

    public final void v() {
        C0432c.a(this).c(new Intent("REFRESH_INBOX"));
        Log.d("ChatActivity", "Sent REFRESH_INBOX broadcast");
    }

    public final void x() throws IOException {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, "No camera app available", 0).show();
            return;
        }
        this.f5737d = null;
        try {
            this.f5737d = m();
            Uri uriB = FileProvider.b(this, getPackageName() + ".fileprovider", this.f5737d);
            this.f5736c = uriB;
            intent.putExtra("output", uriB);
            startActivityForResult(intent, 1002);
        } catch (IOException e5) {
            Log.e("ChatActivity", "Error occurred while creating the File", e5);
            Toast.makeText(this, "Error creating image file", 0).show();
        }
    }

    public final void y(String str, String str2) {
        Call<ApiResponse> callSendMessage;
        this.h.setEnabled(false);
        this.h.setAlpha(0.5f);
        if (this.f5752v) {
            String str3 = this.f5751u;
            String str4 = this.f5745o;
            C c2 = new C();
            c2.f7269a = "send_team_message";
            c2.f7270b = str3;
            c2.f7271c = str4;
            c2.f7272d = "HamChat";
            c2.f7273e = str;
            c2.f7274f = "email";
            c2.g = "normal";
            c2.h = str2;
            c2.f7275i = false;
            StringBuilder sbI = h.i(h.i(h.i(h.i(h.i(h.i(h.i(h.i(h.h("SendTeamMessageRequest", "=== REQUEST OBJECT CREATED ===", "action: "), c2.f7269a, "SendTeamMessageRequest", "team_id: "), c2.f7270b, "SendTeamMessageRequest", "from_callsign: "), c2.f7271c, "SendTeamMessageRequest", "subject: "), c2.f7272d, "SendTeamMessageRequest", "message_body: "), c2.f7273e, "SendTeamMessageRequest", "message_type: "), c2.f7274f, "SendTeamMessageRequest", "priority: "), c2.g, "SendTeamMessageRequest", "attachments: "), c2.h, "SendTeamMessageRequest", "is_high_sensitivity: ");
            sbI.append(c2.f7275i);
            Log.d("SendTeamMessageRequest", sbI.toString());
            Log.d("ChatActivity", "=== SENDING TEAM MESSAGE ===");
            StringBuilder sbI2 = h.i(new StringBuilder("Team ID: "), this.f5751u, "ChatActivity", "From Callsign: ");
            sbI2.append(this.f5745o);
            Log.d("ChatActivity", sbI2.toString());
            Log.d("ChatActivity", "Message Body: " + str);
            callSendMessage = this.f5744m.sendTeamMessage(c2);
        } else {
            callSendMessage = this.f5744m.sendMessage(new SendMessageRequest(this.f5746p, this.f5745o, "HamChat", str, "email", "normal", str2));
            h.q(new StringBuilder("Sending direct message to: "), this.f5746p, "ChatActivity");
        }
        callSendMessage.enqueue(new l(this, 1));
    }

    public final void z(String str) {
        String str2;
        String str3;
        String str4;
        MessageApiService messageApiService = this.f5744m;
        if (messageApiService == null || (str2 = this.f5745o) == null) {
            return;
        }
        boolean z4 = this.f5752v;
        if (z4 && (str4 = this.f5751u) != null) {
            messageApiService.sendTeamTyping(str2, str4, str).enqueue(new L0.c(this, 16, str));
        } else {
            if (z4 || (str3 = this.f5746p) == null) {
                return;
            }
            messageApiService.sendTyping(str2, str3, str).enqueue(new B0.l(14, str));
        }
    }
}
