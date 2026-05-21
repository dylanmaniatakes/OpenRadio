package com.unified.ur1.inbox;

import C.d;
import D0.p;
import L0.s;
import Z1.a;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import com.unified.ur1.inbox.ComposeMessageActivity;
import com.unified.ur1.inbox.MessageApiService;
import f.AbstractActivityC0472i;
import f3.C0524o;
import f3.DialogInterfaceOnClickListenerC0520k;
import g0.AbstractC0535a;
import g3.f;
import i3.I;
import i3.ViewOnFocusChangeListenerC0574c;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* loaded from: classes.dex */
public class ComposeMessageActivity extends AbstractActivityC0472i {

    /* renamed from: C, reason: collision with root package name */
    public static final /* synthetic */ int f5790C = 0;

    /* renamed from: A, reason: collision with root package name */
    public Uri f5791A;

    /* renamed from: B, reason: collision with root package name */
    public File f5792B;

    /* renamed from: c, reason: collision with root package name */
    public EditText f5793c;

    /* renamed from: d, reason: collision with root package name */
    public EditText f5794d;

    /* renamed from: e, reason: collision with root package name */
    public EditText f5795e;

    /* renamed from: f, reason: collision with root package name */
    public TextView f5796f;
    public RecyclerView g;
    public View h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f5797i;

    /* renamed from: j, reason: collision with root package name */
    public ImageView f5798j;

    /* renamed from: k, reason: collision with root package name */
    public LinearLayout f5799k;

    /* renamed from: l, reason: collision with root package name */
    public LinearLayout f5800l;

    /* renamed from: m, reason: collision with root package name */
    public String f5801m;
    public String n;

    /* renamed from: o, reason: collision with root package name */
    public MessageApiService f5802o;

    /* renamed from: p, reason: collision with root package name */
    public String f5803p;

    /* renamed from: q, reason: collision with root package name */
    public CheckBox f5804q;

    /* renamed from: r, reason: collision with root package name */
    public LinearLayout f5805r;

    /* renamed from: t, reason: collision with root package name */
    public Runnable f5807t;

    /* renamed from: u, reason: collision with root package name */
    public C0524o f5808u;

    /* renamed from: w, reason: collision with root package name */
    public TextView f5810w;

    /* renamed from: x, reason: collision with root package name */
    public TextView f5811x;

    /* renamed from: y, reason: collision with root package name */
    public ImageView f5812y;

    /* renamed from: s, reason: collision with root package name */
    public final Handler f5806s = new Handler();

    /* renamed from: v, reason: collision with root package name */
    public boolean f5809v = false;

    /* renamed from: z, reason: collision with root package name */
    public String f5813z = null;

    public static void j(ComposeMessageActivity composeMessageActivity, ArrayList arrayList) {
        String str;
        composeMessageActivity.getClass();
        if (arrayList.isEmpty()) {
            composeMessageActivity.r(R.drawable.ic_info, R.color.gray_600, "No users found");
            composeMessageActivity.n();
            composeMessageActivity.f5809v = false;
            return;
        }
        if (arrayList.size() == 1) {
            str = "1 user found";
        } else {
            str = arrayList.size() + " users found";
        }
        composeMessageActivity.r(R.drawable.ic_search, R.color.accent_blue, str);
        C0524o c0524o = composeMessageActivity.f5808u;
        ArrayList arrayList2 = (ArrayList) c0524o.f6769b;
        arrayList2.clear();
        arrayList2.addAll(arrayList);
        c0524o.notifyDataSetChanged();
        composeMessageActivity.h.setVisibility(0);
        TextView textView = composeMessageActivity.f5810w;
        if (textView != null) {
            textView.setText(String.valueOf(arrayList.size()));
        }
        if (composeMessageActivity.f5811x != null) {
            if (arrayList.size() > 5) {
                composeMessageActivity.f5811x.setVisibility(0);
                composeMessageActivity.f5811x.setText("Scroll to see all " + arrayList.size() + " users");
            } else {
                composeMessageActivity.f5811x.setVisibility(8);
            }
        }
        composeMessageActivity.g.g0(0);
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) composeMessageActivity.getSystemService("input_method");
            if (inputMethodManager != null && composeMessageActivity.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(composeMessageActivity.getCurrentFocus().getWindowToken(), 0);
            }
        } catch (Exception e5) {
            Log.e("ComposeMessageActivity", "Error hiding keyboard", e5);
        }
        String upperCase = composeMessageActivity.f5793c.getText().toString().trim().toUpperCase();
        composeMessageActivity.f5809v = false;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            I i5 = (I) it.next();
            if (i5.f7291a.equalsIgnoreCase(upperCase)) {
                composeMessageActivity.f5809v = true;
                composeMessageActivity.r(R.drawable.ic_check_circle, R.color.accent_green, "✓ " + i5.a());
                composeMessageActivity.n();
                return;
            }
        }
    }

    public final String k(Uri uri) throws IOException {
        InputStream inputStreamOpenInputStream = getContentResolver().openInputStream(uri);
        Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpenInputStream);
        inputStreamOpenInputStream.close();
        if (bitmapDecodeStream.getWidth() > 800 || bitmapDecodeStream.getHeight() > 800) {
            float f5 = 800;
            float fMin = Math.min(f5 / bitmapDecodeStream.getWidth(), f5 / bitmapDecodeStream.getHeight());
            bitmapDecodeStream = Bitmap.createScaledBitmap(bitmapDecodeStream, Math.round(bitmapDecodeStream.getWidth() * fMin), Math.round(bitmapDecodeStream.getHeight() * fMin), true);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapDecodeStream.compress(Bitmap.CompressFormat.JPEG, 70, byteArrayOutputStream);
        return Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public final File l() {
        File cacheDir;
        String strS = h.s("CAMERA_", new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()));
        try {
            cacheDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "camera_temp");
            if (!cacheDir.exists()) {
                cacheDir.mkdirs();
            }
            Log.d("ComposeMessageActivity", "Using external files directory: " + cacheDir.getAbsolutePath());
        } catch (Exception e5) {
            Log.w("ComposeMessageActivity", "External files directory not available, trying cache", e5);
            cacheDir = getCacheDir();
            Log.d("ComposeMessageActivity", "Using cache directory: " + cacheDir.getAbsolutePath());
        }
        File file = new File(cacheDir, h.b(strS, ".jpg"));
        Log.d("ComposeMessageActivity", "Created image file: " + file.getAbsolutePath());
        return file;
    }

    public final void m(Uri uri) {
        try {
            String strK = k(uri);
            this.f5813z = strK;
            byte[] bArrDecode = Base64.decode(strK, 0);
            this.f5812y.setImageBitmap(BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length));
            this.f5812y.setVisibility(0);
            Uri uri2 = this.f5791A;
            Toast.makeText(this, "Image " + ((uri2 == null || !uri2.equals(uri)) ? "selected" : "captured") + "! Tap preview to remove.", 0).show();
        } catch (Exception e5) {
            Log.e("ComposeMessageActivity", "Error processing image", e5);
            Toast.makeText(this, "Failed to process image", 0).show();
        }
    }

    public final void n() {
        this.h.setVisibility(8);
        TextView textView = this.f5811x;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public final void o() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent, 1001);
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        Uri uri;
        super.onActivityResult(i5, i6, intent);
        if (i6 == -1) {
            if (i5 != 1001) {
                if (i5 == 1002 && (uri = this.f5791A) != null) {
                    m(uri);
                    return;
                }
                return;
            }
            if (intent == null || intent.getData() == null) {
                return;
            }
            m(intent.getData());
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_compose_message);
        SharedPreferences sharedPreferences = getSharedPreferences("app_settings", 0);
        String string = null;
        String string2 = sharedPreferences.getString("user_callsign", null);
        if (string2 == null) {
            string2 = sharedPreferences.getString("my_callsign", null);
        }
        if (string2 == null) {
            string2 = sharedPreferences.getString("current_user_callsign", null);
        }
        if (string2 == null) {
            string2 = sharedPreferences.getString("callsign", null);
        }
        AbstractC0535a.v("Retrieved current user callsign: ", string2, "ComposeMessageActivity");
        this.f5801m = string2;
        if (string2 == null || string2.isEmpty()) {
            this.f5801m = getIntent().getStringExtra("from_callsign");
            h.q(new StringBuilder("Using fromCallsign from intent: "), this.f5801m, "ComposeMessageActivity");
        } else {
            h.q(new StringBuilder("Using fromCallsign from SharedPreferences: "), this.f5801m, "ComposeMessageActivity");
        }
        this.n = getSharedPreferences("app_settings", 0).getString("auth_code_1", null);
        this.f5803p = getIntent().getStringExtra("action_type");
        h.q(new StringBuilder("From callsign: "), this.f5801m, "ComposeMessageActivity");
        Log.d("ComposeMessageActivity", "Cloud auth: ".concat(this.n != null ? "present" : "missing"));
        Log.d("ComposeMessageActivity", "Action type: " + this.f5803p);
        if (getSupportActionBar() != null) {
            getSupportActionBar().p("reply".equals(this.f5803p) ? "Reply" : "forward".equals(this.f5803p) ? "Forward Message" : "Compose Message");
            getSupportActionBar().n(true);
        }
        this.f5793c = (EditText) findViewById(R.id.editToCallsign);
        this.f5794d = (EditText) findViewById(R.id.editSubject);
        this.f5795e = (EditText) findViewById(R.id.editMessage);
        this.f5796f = (TextView) findViewById(R.id.buttonSend);
        this.g = (RecyclerView) findViewById(R.id.userSuggestionsRecyclerView);
        this.h = findViewById(R.id.userSuggestionsCard);
        this.f5797i = (TextView) findViewById(R.id.validationStatusText);
        this.f5798j = (ImageView) findViewById(R.id.validationStatusIcon);
        this.f5810w = (TextView) findViewById(R.id.userCountText);
        this.f5811x = (TextView) findViewById(R.id.scrollHintText);
        final int i5 = 0;
        this.f5796f.setOnClickListener(new View.OnClickListener(this) { // from class: i3.d

            /* renamed from: d, reason: collision with root package name */
            public final /* synthetic */ ComposeMessageActivity f7301d;

            {
                this.f7301d = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) throws IOException {
                String str;
                String str2;
                ComposeMessageActivity composeMessageActivity = this.f7301d;
                switch (i5) {
                    case 0:
                        String upperCase = composeMessageActivity.f5793c.getText().toString().trim().toUpperCase();
                        String strTrim = composeMessageActivity.f5794d.getText().toString().trim();
                        String strTrim2 = composeMessageActivity.f5795e.getText().toString().trim();
                        Log.d("ComposeMessageActivity", "Attempting to send message:");
                        Log.d("ComposeMessageActivity", "To: " + upperCase);
                        Log.d("ComposeMessageActivity", "From: " + composeMessageActivity.f5801m);
                        StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("ComposeMessageActivity", "Subject: " + strTrim, "Body length: ");
                        sbH.append(strTrim2.length());
                        Log.d("ComposeMessageActivity", sbH.toString());
                        StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("Action type: "), composeMessageActivity.f5803p, "ComposeMessageActivity", "User validated: ");
                        sbI.append(composeMessageActivity.f5809v);
                        Log.d("ComposeMessageActivity", sbI.toString());
                        StringBuilder sb = new StringBuilder("Body preview: ");
                        if (strTrim2.length() > 50) {
                            str = strTrim2.substring(0, 50) + "...";
                        } else {
                            str = strTrim2;
                        }
                        sb.append(str);
                        Log.d("ComposeMessageActivity", sb.toString());
                        if (!upperCase.isEmpty() && !strTrim2.isEmpty()) {
                            if (!composeMessageActivity.f5809v) {
                                if (upperCase.length() < 3) {
                                    Toast.makeText(composeMessageActivity, "Please search and select a valid user", 0).show();
                                    composeMessageActivity.f5793c.requestFocus();
                                    break;
                                } else {
                                    MessageApiService messageApiService = composeMessageActivity.f5802o;
                                    if (messageApiService != null && (str2 = composeMessageActivity.n) != null) {
                                        messageApiService.searchUsersRaw(upperCase, str2).enqueue(new L0.e(17, composeMessageActivity, upperCase, false));
                                        break;
                                    } else {
                                        Toast.makeText(composeMessageActivity, "Cannot validate user - please select from suggestions", 0).show();
                                        break;
                                    }
                                }
                            } else {
                                composeMessageActivity.q();
                                break;
                            }
                        } else {
                            Toast.makeText(composeMessageActivity, "Please fill required fields (To and Message)", 0).show();
                            break;
                        }
                    case 1:
                        int i6 = ComposeMessageActivity.f5790C;
                        composeMessageActivity.getClass();
                        if (C.h.a(composeMessageActivity, "android.permission.CAMERA") == 0) {
                            composeMessageActivity.p();
                            break;
                        } else {
                            Log.d("ComposeMessageActivity", "Camera permission not granted, requesting...");
                            B.e.d(composeMessageActivity, new String[]{"android.permission.CAMERA"}, 1003);
                            break;
                        }
                    case 2:
                        int i7 = ComposeMessageActivity.f5790C;
                        composeMessageActivity.o();
                        break;
                    case 3:
                        int i8 = ComposeMessageActivity.f5790C;
                        composeMessageActivity.getClass();
                        AlertDialog.Builder builder = new AlertDialog.Builder(composeMessageActivity);
                        builder.setTitle("Select Image Source");
                        builder.setItems(new CharSequence[]{"Take Photo", "Choose from Gallery"}, new DialogInterfaceOnClickListenerC0520k(3, composeMessageActivity));
                        builder.show();
                        break;
                    case 4:
                        int i9 = ComposeMessageActivity.f5790C;
                        composeMessageActivity.f5813z = null;
                        composeMessageActivity.f5812y.setVisibility(8);
                        Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                        break;
                    default:
                        int i10 = ComposeMessageActivity.f5790C;
                        composeMessageActivity.f5813z = null;
                        composeMessageActivity.f5812y.setVisibility(8);
                        Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                        break;
                }
            }
        });
        this.f5804q = (CheckBox) findViewById(R.id.checkboxHighSensitivity);
        this.f5805r = (LinearLayout) findViewById(R.id.encryptionStatusLayout);
        CheckBox checkBox = this.f5804q;
        if (checkBox != null) {
            checkBox.setOnCheckedChangeListener(new a(3, this));
        }
        p pVar = new p(14, this);
        C0524o c0524o = new C0524o(4);
        c0524o.f6769b = new ArrayList();
        c0524o.f6770c = pVar;
        this.f5808u = c0524o;
        this.g.setLayoutManager(new LinearLayoutManager(1));
        this.g.setAdapter(this.f5808u);
        this.g.setHasFixedSize(false);
        this.g.setItemViewCacheSize(20);
        this.g.setDrawingCacheEnabled(true);
        this.g.setDrawingCacheQuality(1048576);
        this.f5799k = (LinearLayout) findViewById(R.id.cameraButton);
        this.f5800l = (LinearLayout) findViewById(R.id.galleryButton);
        LinearLayout linearLayout = this.f5799k;
        if (linearLayout != null) {
            final int i6 = 1;
            linearLayout.setOnClickListener(new View.OnClickListener(this) { // from class: i3.d

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ComposeMessageActivity f7301d;

                {
                    this.f7301d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    String str;
                    String str2;
                    ComposeMessageActivity composeMessageActivity = this.f7301d;
                    switch (i6) {
                        case 0:
                            String upperCase = composeMessageActivity.f5793c.getText().toString().trim().toUpperCase();
                            String strTrim = composeMessageActivity.f5794d.getText().toString().trim();
                            String strTrim2 = composeMessageActivity.f5795e.getText().toString().trim();
                            Log.d("ComposeMessageActivity", "Attempting to send message:");
                            Log.d("ComposeMessageActivity", "To: " + upperCase);
                            Log.d("ComposeMessageActivity", "From: " + composeMessageActivity.f5801m);
                            StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("ComposeMessageActivity", "Subject: " + strTrim, "Body length: ");
                            sbH.append(strTrim2.length());
                            Log.d("ComposeMessageActivity", sbH.toString());
                            StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("Action type: "), composeMessageActivity.f5803p, "ComposeMessageActivity", "User validated: ");
                            sbI.append(composeMessageActivity.f5809v);
                            Log.d("ComposeMessageActivity", sbI.toString());
                            StringBuilder sb = new StringBuilder("Body preview: ");
                            if (strTrim2.length() > 50) {
                                str = strTrim2.substring(0, 50) + "...";
                            } else {
                                str = strTrim2;
                            }
                            sb.append(str);
                            Log.d("ComposeMessageActivity", sb.toString());
                            if (!upperCase.isEmpty() && !strTrim2.isEmpty()) {
                                if (!composeMessageActivity.f5809v) {
                                    if (upperCase.length() < 3) {
                                        Toast.makeText(composeMessageActivity, "Please search and select a valid user", 0).show();
                                        composeMessageActivity.f5793c.requestFocus();
                                        break;
                                    } else {
                                        MessageApiService messageApiService = composeMessageActivity.f5802o;
                                        if (messageApiService != null && (str2 = composeMessageActivity.n) != null) {
                                            messageApiService.searchUsersRaw(upperCase, str2).enqueue(new L0.e(17, composeMessageActivity, upperCase, false));
                                            break;
                                        } else {
                                            Toast.makeText(composeMessageActivity, "Cannot validate user - please select from suggestions", 0).show();
                                            break;
                                        }
                                    }
                                } else {
                                    composeMessageActivity.q();
                                    break;
                                }
                            } else {
                                Toast.makeText(composeMessageActivity, "Please fill required fields (To and Message)", 0).show();
                                break;
                            }
                        case 1:
                            int i62 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            if (C.h.a(composeMessageActivity, "android.permission.CAMERA") == 0) {
                                composeMessageActivity.p();
                                break;
                            } else {
                                Log.d("ComposeMessageActivity", "Camera permission not granted, requesting...");
                                B.e.d(composeMessageActivity, new String[]{"android.permission.CAMERA"}, 1003);
                                break;
                            }
                        case 2:
                            int i7 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.o();
                            break;
                        case 3:
                            int i8 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            AlertDialog.Builder builder = new AlertDialog.Builder(composeMessageActivity);
                            builder.setTitle("Select Image Source");
                            builder.setItems(new CharSequence[]{"Take Photo", "Choose from Gallery"}, new DialogInterfaceOnClickListenerC0520k(3, composeMessageActivity));
                            builder.show();
                            break;
                        case 4:
                            int i9 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                        default:
                            int i10 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                    }
                }
            });
        }
        LinearLayout linearLayout2 = this.f5800l;
        if (linearLayout2 != null) {
            final int i7 = 2;
            linearLayout2.setOnClickListener(new View.OnClickListener(this) { // from class: i3.d

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ComposeMessageActivity f7301d;

                {
                    this.f7301d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    String str;
                    String str2;
                    ComposeMessageActivity composeMessageActivity = this.f7301d;
                    switch (i7) {
                        case 0:
                            String upperCase = composeMessageActivity.f5793c.getText().toString().trim().toUpperCase();
                            String strTrim = composeMessageActivity.f5794d.getText().toString().trim();
                            String strTrim2 = composeMessageActivity.f5795e.getText().toString().trim();
                            Log.d("ComposeMessageActivity", "Attempting to send message:");
                            Log.d("ComposeMessageActivity", "To: " + upperCase);
                            Log.d("ComposeMessageActivity", "From: " + composeMessageActivity.f5801m);
                            StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("ComposeMessageActivity", "Subject: " + strTrim, "Body length: ");
                            sbH.append(strTrim2.length());
                            Log.d("ComposeMessageActivity", sbH.toString());
                            StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("Action type: "), composeMessageActivity.f5803p, "ComposeMessageActivity", "User validated: ");
                            sbI.append(composeMessageActivity.f5809v);
                            Log.d("ComposeMessageActivity", sbI.toString());
                            StringBuilder sb = new StringBuilder("Body preview: ");
                            if (strTrim2.length() > 50) {
                                str = strTrim2.substring(0, 50) + "...";
                            } else {
                                str = strTrim2;
                            }
                            sb.append(str);
                            Log.d("ComposeMessageActivity", sb.toString());
                            if (!upperCase.isEmpty() && !strTrim2.isEmpty()) {
                                if (!composeMessageActivity.f5809v) {
                                    if (upperCase.length() < 3) {
                                        Toast.makeText(composeMessageActivity, "Please search and select a valid user", 0).show();
                                        composeMessageActivity.f5793c.requestFocus();
                                        break;
                                    } else {
                                        MessageApiService messageApiService = composeMessageActivity.f5802o;
                                        if (messageApiService != null && (str2 = composeMessageActivity.n) != null) {
                                            messageApiService.searchUsersRaw(upperCase, str2).enqueue(new L0.e(17, composeMessageActivity, upperCase, false));
                                            break;
                                        } else {
                                            Toast.makeText(composeMessageActivity, "Cannot validate user - please select from suggestions", 0).show();
                                            break;
                                        }
                                    }
                                } else {
                                    composeMessageActivity.q();
                                    break;
                                }
                            } else {
                                Toast.makeText(composeMessageActivity, "Please fill required fields (To and Message)", 0).show();
                                break;
                            }
                        case 1:
                            int i62 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            if (C.h.a(composeMessageActivity, "android.permission.CAMERA") == 0) {
                                composeMessageActivity.p();
                                break;
                            } else {
                                Log.d("ComposeMessageActivity", "Camera permission not granted, requesting...");
                                B.e.d(composeMessageActivity, new String[]{"android.permission.CAMERA"}, 1003);
                                break;
                            }
                        case 2:
                            int i72 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.o();
                            break;
                        case 3:
                            int i8 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            AlertDialog.Builder builder = new AlertDialog.Builder(composeMessageActivity);
                            builder.setTitle("Select Image Source");
                            builder.setItems(new CharSequence[]{"Take Photo", "Choose from Gallery"}, new DialogInterfaceOnClickListenerC0520k(3, composeMessageActivity));
                            builder.show();
                            break;
                        case 4:
                            int i9 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                        default:
                            int i10 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                    }
                }
            });
        }
        LinearLayout linearLayout3 = (LinearLayout) findViewById(R.id.attachImageButton);
        if (linearLayout3 != null) {
            final int i8 = 3;
            linearLayout3.setOnClickListener(new View.OnClickListener(this) { // from class: i3.d

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ComposeMessageActivity f7301d;

                {
                    this.f7301d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    String str;
                    String str2;
                    ComposeMessageActivity composeMessageActivity = this.f7301d;
                    switch (i8) {
                        case 0:
                            String upperCase = composeMessageActivity.f5793c.getText().toString().trim().toUpperCase();
                            String strTrim = composeMessageActivity.f5794d.getText().toString().trim();
                            String strTrim2 = composeMessageActivity.f5795e.getText().toString().trim();
                            Log.d("ComposeMessageActivity", "Attempting to send message:");
                            Log.d("ComposeMessageActivity", "To: " + upperCase);
                            Log.d("ComposeMessageActivity", "From: " + composeMessageActivity.f5801m);
                            StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("ComposeMessageActivity", "Subject: " + strTrim, "Body length: ");
                            sbH.append(strTrim2.length());
                            Log.d("ComposeMessageActivity", sbH.toString());
                            StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("Action type: "), composeMessageActivity.f5803p, "ComposeMessageActivity", "User validated: ");
                            sbI.append(composeMessageActivity.f5809v);
                            Log.d("ComposeMessageActivity", sbI.toString());
                            StringBuilder sb = new StringBuilder("Body preview: ");
                            if (strTrim2.length() > 50) {
                                str = strTrim2.substring(0, 50) + "...";
                            } else {
                                str = strTrim2;
                            }
                            sb.append(str);
                            Log.d("ComposeMessageActivity", sb.toString());
                            if (!upperCase.isEmpty() && !strTrim2.isEmpty()) {
                                if (!composeMessageActivity.f5809v) {
                                    if (upperCase.length() < 3) {
                                        Toast.makeText(composeMessageActivity, "Please search and select a valid user", 0).show();
                                        composeMessageActivity.f5793c.requestFocus();
                                        break;
                                    } else {
                                        MessageApiService messageApiService = composeMessageActivity.f5802o;
                                        if (messageApiService != null && (str2 = composeMessageActivity.n) != null) {
                                            messageApiService.searchUsersRaw(upperCase, str2).enqueue(new L0.e(17, composeMessageActivity, upperCase, false));
                                            break;
                                        } else {
                                            Toast.makeText(composeMessageActivity, "Cannot validate user - please select from suggestions", 0).show();
                                            break;
                                        }
                                    }
                                } else {
                                    composeMessageActivity.q();
                                    break;
                                }
                            } else {
                                Toast.makeText(composeMessageActivity, "Please fill required fields (To and Message)", 0).show();
                                break;
                            }
                        case 1:
                            int i62 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            if (C.h.a(composeMessageActivity, "android.permission.CAMERA") == 0) {
                                composeMessageActivity.p();
                                break;
                            } else {
                                Log.d("ComposeMessageActivity", "Camera permission not granted, requesting...");
                                B.e.d(composeMessageActivity, new String[]{"android.permission.CAMERA"}, 1003);
                                break;
                            }
                        case 2:
                            int i72 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.o();
                            break;
                        case 3:
                            int i82 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            AlertDialog.Builder builder = new AlertDialog.Builder(composeMessageActivity);
                            builder.setTitle("Select Image Source");
                            builder.setItems(new CharSequence[]{"Take Photo", "Choose from Gallery"}, new DialogInterfaceOnClickListenerC0520k(3, composeMessageActivity));
                            builder.show();
                            break;
                        case 4:
                            int i9 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                        default:
                            int i10 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                    }
                }
            });
        }
        ImageView imageView = (ImageView) findViewById(R.id.selectedImagePreview);
        this.f5812y = imageView;
        if (imageView != null) {
            final int i9 = 4;
            imageView.setOnClickListener(new View.OnClickListener(this) { // from class: i3.d

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ComposeMessageActivity f7301d;

                {
                    this.f7301d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    String str;
                    String str2;
                    ComposeMessageActivity composeMessageActivity = this.f7301d;
                    switch (i9) {
                        case 0:
                            String upperCase = composeMessageActivity.f5793c.getText().toString().trim().toUpperCase();
                            String strTrim = composeMessageActivity.f5794d.getText().toString().trim();
                            String strTrim2 = composeMessageActivity.f5795e.getText().toString().trim();
                            Log.d("ComposeMessageActivity", "Attempting to send message:");
                            Log.d("ComposeMessageActivity", "To: " + upperCase);
                            Log.d("ComposeMessageActivity", "From: " + composeMessageActivity.f5801m);
                            StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("ComposeMessageActivity", "Subject: " + strTrim, "Body length: ");
                            sbH.append(strTrim2.length());
                            Log.d("ComposeMessageActivity", sbH.toString());
                            StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("Action type: "), composeMessageActivity.f5803p, "ComposeMessageActivity", "User validated: ");
                            sbI.append(composeMessageActivity.f5809v);
                            Log.d("ComposeMessageActivity", sbI.toString());
                            StringBuilder sb = new StringBuilder("Body preview: ");
                            if (strTrim2.length() > 50) {
                                str = strTrim2.substring(0, 50) + "...";
                            } else {
                                str = strTrim2;
                            }
                            sb.append(str);
                            Log.d("ComposeMessageActivity", sb.toString());
                            if (!upperCase.isEmpty() && !strTrim2.isEmpty()) {
                                if (!composeMessageActivity.f5809v) {
                                    if (upperCase.length() < 3) {
                                        Toast.makeText(composeMessageActivity, "Please search and select a valid user", 0).show();
                                        composeMessageActivity.f5793c.requestFocus();
                                        break;
                                    } else {
                                        MessageApiService messageApiService = composeMessageActivity.f5802o;
                                        if (messageApiService != null && (str2 = composeMessageActivity.n) != null) {
                                            messageApiService.searchUsersRaw(upperCase, str2).enqueue(new L0.e(17, composeMessageActivity, upperCase, false));
                                            break;
                                        } else {
                                            Toast.makeText(composeMessageActivity, "Cannot validate user - please select from suggestions", 0).show();
                                            break;
                                        }
                                    }
                                } else {
                                    composeMessageActivity.q();
                                    break;
                                }
                            } else {
                                Toast.makeText(composeMessageActivity, "Please fill required fields (To and Message)", 0).show();
                                break;
                            }
                        case 1:
                            int i62 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            if (C.h.a(composeMessageActivity, "android.permission.CAMERA") == 0) {
                                composeMessageActivity.p();
                                break;
                            } else {
                                Log.d("ComposeMessageActivity", "Camera permission not granted, requesting...");
                                B.e.d(composeMessageActivity, new String[]{"android.permission.CAMERA"}, 1003);
                                break;
                            }
                        case 2:
                            int i72 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.o();
                            break;
                        case 3:
                            int i82 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            AlertDialog.Builder builder = new AlertDialog.Builder(composeMessageActivity);
                            builder.setTitle("Select Image Source");
                            builder.setItems(new CharSequence[]{"Take Photo", "Choose from Gallery"}, new DialogInterfaceOnClickListenerC0520k(3, composeMessageActivity));
                            builder.show();
                            break;
                        case 4:
                            int i92 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                        default:
                            int i10 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                    }
                }
            });
        }
        TextView textView = (TextView) findViewById(R.id.removeImageButton);
        if (textView != null) {
            final int i10 = 5;
            textView.setOnClickListener(new View.OnClickListener(this) { // from class: i3.d

                /* renamed from: d, reason: collision with root package name */
                public final /* synthetic */ ComposeMessageActivity f7301d;

                {
                    this.f7301d = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) throws IOException {
                    String str;
                    String str2;
                    ComposeMessageActivity composeMessageActivity = this.f7301d;
                    switch (i10) {
                        case 0:
                            String upperCase = composeMessageActivity.f5793c.getText().toString().trim().toUpperCase();
                            String strTrim = composeMessageActivity.f5794d.getText().toString().trim();
                            String strTrim2 = composeMessageActivity.f5795e.getText().toString().trim();
                            Log.d("ComposeMessageActivity", "Attempting to send message:");
                            Log.d("ComposeMessageActivity", "To: " + upperCase);
                            Log.d("ComposeMessageActivity", "From: " + composeMessageActivity.f5801m);
                            StringBuilder sbH = com.unified.ur1.SatelliteTracker.h.h("ComposeMessageActivity", "Subject: " + strTrim, "Body length: ");
                            sbH.append(strTrim2.length());
                            Log.d("ComposeMessageActivity", sbH.toString());
                            StringBuilder sbI = com.unified.ur1.SatelliteTracker.h.i(new StringBuilder("Action type: "), composeMessageActivity.f5803p, "ComposeMessageActivity", "User validated: ");
                            sbI.append(composeMessageActivity.f5809v);
                            Log.d("ComposeMessageActivity", sbI.toString());
                            StringBuilder sb = new StringBuilder("Body preview: ");
                            if (strTrim2.length() > 50) {
                                str = strTrim2.substring(0, 50) + "...";
                            } else {
                                str = strTrim2;
                            }
                            sb.append(str);
                            Log.d("ComposeMessageActivity", sb.toString());
                            if (!upperCase.isEmpty() && !strTrim2.isEmpty()) {
                                if (!composeMessageActivity.f5809v) {
                                    if (upperCase.length() < 3) {
                                        Toast.makeText(composeMessageActivity, "Please search and select a valid user", 0).show();
                                        composeMessageActivity.f5793c.requestFocus();
                                        break;
                                    } else {
                                        MessageApiService messageApiService = composeMessageActivity.f5802o;
                                        if (messageApiService != null && (str2 = composeMessageActivity.n) != null) {
                                            messageApiService.searchUsersRaw(upperCase, str2).enqueue(new L0.e(17, composeMessageActivity, upperCase, false));
                                            break;
                                        } else {
                                            Toast.makeText(composeMessageActivity, "Cannot validate user - please select from suggestions", 0).show();
                                            break;
                                        }
                                    }
                                } else {
                                    composeMessageActivity.q();
                                    break;
                                }
                            } else {
                                Toast.makeText(composeMessageActivity, "Please fill required fields (To and Message)", 0).show();
                                break;
                            }
                        case 1:
                            int i62 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            if (C.h.a(composeMessageActivity, "android.permission.CAMERA") == 0) {
                                composeMessageActivity.p();
                                break;
                            } else {
                                Log.d("ComposeMessageActivity", "Camera permission not granted, requesting...");
                                B.e.d(composeMessageActivity, new String[]{"android.permission.CAMERA"}, 1003);
                                break;
                            }
                        case 2:
                            int i72 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.o();
                            break;
                        case 3:
                            int i82 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.getClass();
                            AlertDialog.Builder builder = new AlertDialog.Builder(composeMessageActivity);
                            builder.setTitle("Select Image Source");
                            builder.setItems(new CharSequence[]{"Take Photo", "Choose from Gallery"}, new DialogInterfaceOnClickListenerC0520k(3, composeMessageActivity));
                            builder.show();
                            break;
                        case 4:
                            int i92 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                        default:
                            int i102 = ComposeMessageActivity.f5790C;
                            composeMessageActivity.f5813z = null;
                            composeMessageActivity.f5812y.setVisibility(8);
                            Toast.makeText(composeMessageActivity, "Image removed", 0).show();
                            break;
                    }
                }
            });
        }
        try {
            Log.d("ComposeMessageActivity", "Setting up API service...");
            this.f5802o = (MessageApiService) new Retrofit.Builder().baseUrl("https://ur1.unifiedradios.com/messages/").addConverterFactory(GsonConverterFactory.create()).build().create(MessageApiService.class);
            Log.d("ComposeMessageActivity", "API service created successfully");
        } catch (Exception e5) {
            Log.e("ComposeMessageActivity", "Error setting up API", e5);
            this.f5802o = null;
        }
        this.f5793c.addTextChangedListener(new f(2, this));
        this.f5793c.setOnFocusChangeListener(new ViewOnFocusChangeListenerC0574c(0, this));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Log.d("ComposeMessageActivity", "Intent extras received:");
            for (String str : extras.keySet()) {
                Log.d("ComposeMessageActivity", "  " + str + " = " + extras.get(str));
            }
            String string3 = extras.containsKey("to_callsign") ? extras.getString("to_callsign") : extras.containsKey("recipient_callsign") ? extras.getString("recipient_callsign") : extras.containsKey("to") ? extras.getString("to") : extras.containsKey("reply_to") ? extras.getString("reply_to") : null;
            if (string3 != null && !string3.isEmpty()) {
                this.f5793c.setText(string3.toUpperCase());
                Log.d("ComposeMessageActivity", "Set TO field: ".concat(string3));
                this.f5809v = true;
                r(R.drawable.ic_check_circle, R.color.accent_green, "✓ " + string3.toUpperCase());
            }
            String string4 = extras.containsKey("subject") ? extras.getString("subject") : extras.containsKey("reply_subject") ? extras.getString("reply_subject") : extras.containsKey("forward_subject") ? extras.getString("forward_subject") : extras.containsKey("message_subject") ? extras.getString("message_subject") : null;
            if (string4 != null && !string4.isEmpty()) {
                this.f5794d.setText(string4);
                Log.d("ComposeMessageActivity", "Set SUBJECT field: ".concat(string4));
            }
            if (extras.containsKey("message_content")) {
                string = extras.getString("message_content");
            } else if (extras.containsKey("content")) {
                string = extras.getString("content");
            } else if (extras.containsKey("body")) {
                string = extras.getString("body");
            } else if (extras.containsKey("quoted_text")) {
                string = extras.getString("quoted_text");
            } else if (extras.containsKey("forward_content")) {
                string = extras.getString("forward_content");
            } else if (extras.containsKey("quoted_content")) {
                string = extras.getString("quoted_content");
            }
            if (string != null && !string.isEmpty()) {
                this.f5795e.setText(string);
                Log.d("ComposeMessageActivity", "Set MESSAGE content, length: " + string.length());
                if ("reply".equals(this.f5803p)) {
                    this.f5795e.setSelection(0);
                }
            }
            if ("reply".equals(this.f5803p)) {
                this.f5795e.requestFocus();
                this.f5795e.setSelection(0);
            } else if ("forward".equals(this.f5803p)) {
                this.f5793c.requestFocus();
            } else {
                this.f5793c.requestFocus();
            }
        }
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        Log.d("ComposeMessageActivity", "ComposeMessageActivity destroyed");
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) throws IOException {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 1003) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Log.d("ComposeMessageActivity", "Camera permission denied");
                Toast.makeText(this, "Camera permission is required to take photos", 1).show();
                return;
            } else {
                Log.d("ComposeMessageActivity", "Camera permission granted");
                p();
                return;
            }
        }
        if (i5 != 1004) {
            return;
        }
        if (iArr.length <= 0 || iArr[0] != 0) {
            Log.d("ComposeMessageActivity", "Storage permission denied");
            Toast.makeText(this, "Storage permission is required to access gallery", 1).show();
        } else {
            Log.d("ComposeMessageActivity", "Storage permission granted");
            o();
        }
    }

    @Override // f.AbstractActivityC0472i
    public final boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    public final void p() throws IOException {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) == null) {
            Toast.makeText(this, "No camera app available", 0).show();
            return;
        }
        this.f5792B = null;
        try {
            this.f5792B = l();
            Uri uriB = FileProvider.b(this, getPackageName() + ".fileprovider", this.f5792B);
            this.f5791A = uriB;
            intent.putExtra("output", uriB);
            startActivityForResult(intent, 1002);
        } catch (IOException e5) {
            Log.e("ComposeMessageActivity", "Error occurred while creating the File", e5);
            Toast.makeText(this, "Error creating image file", 0).show();
        }
    }

    public final void q() {
        SendMessageRequest sendMessageRequest;
        String upperCase = this.f5793c.getText().toString().trim().toUpperCase();
        String strTrim = this.f5794d.getText().toString().trim();
        String strTrim2 = this.f5795e.getText().toString().trim();
        String str = this.f5801m;
        if (str == null || str.isEmpty()) {
            Toast.makeText(this, "From callsign not set", 0).show();
            return;
        }
        if (this.f5802o == null) {
            Toast.makeText(this, "API service not available", 0).show();
            return;
        }
        this.f5796f.setEnabled(false);
        String string = this.f5796f.getText().toString();
        this.f5796f.setText("Sending...");
        CheckBox checkBox = this.f5804q;
        boolean z4 = checkBox != null && checkBox.isChecked();
        Log.d("ComposeMessageActivity", "High sensitivity mode: " + z4);
        String str2 = this.f5813z;
        if (str2 == null || str2.isEmpty()) {
            String str3 = this.f5801m;
            if (strTrim.isEmpty()) {
                strTrim = "No Subject";
            }
            sendMessageRequest = new SendMessageRequest(upperCase, str3, strTrim, strTrim2, "email", "normal", null, z4);
            Log.d("ComposeMessageActivity", "SendMessageRequest created without attachments");
        } else {
            String str4 = "[{\"type\":\"image\",\"filename\":\"image_" + System.currentTimeMillis() + ".jpg\",\"data\":\"" + this.f5813z + "\",\"size\":" + this.f5813z.length() + "}]";
            String str5 = this.f5801m;
            if (strTrim.isEmpty()) {
                strTrim = "No Subject";
            }
            sendMessageRequest = new SendMessageRequest(upperCase, str5, strTrim, strTrim2, "email", "normal", str4, z4);
            Log.d("ComposeMessageActivity", "SendMessageRequest created with image attachment");
        }
        Log.d("ComposeMessageActivity", "SendMessageRequest: " + sendMessageRequest.toString());
        Log.d("ComposeMessageActivity", "About to send request to API...");
        this.f5802o.sendMessage(sendMessageRequest).enqueue(new s(17, this, string, false));
    }

    public final void r(int i5, int i6, String str) {
        this.f5797i.setText(str);
        this.f5798j.setImageResource(i5);
        this.f5797i.setTextColor(d.a(this, i6));
        this.f5798j.setColorFilter(d.a(this, i6));
        this.f5797i.setVisibility(0);
        this.f5798j.setVisibility(0);
    }
}
