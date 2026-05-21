package com.unified.ur1.chat;

import B.e;
import C.h;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ScaleGestureDetector;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.unified.ur1.R;
import f.AbstractActivityC0472i;
import g3.C;
import g3.ViewOnTouchListenerC0549B;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import k3.W;

/* loaded from: classes.dex */
public class SimpleImageViewerActivity extends AbstractActivityC0472i {
    public static final /* synthetic */ int n = 0;

    /* renamed from: c, reason: collision with root package name */
    public ImageView f5773c;

    /* renamed from: d, reason: collision with root package name */
    public Bitmap f5774d;

    /* renamed from: e, reason: collision with root package name */
    public ScaleGestureDetector f5775e;

    /* renamed from: k, reason: collision with root package name */
    public float f5779k;

    /* renamed from: l, reason: collision with root package name */
    public float f5780l;

    /* renamed from: f, reason: collision with root package name */
    public final Matrix f5776f = new Matrix();
    public float g = 1.0f;
    public float h = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: i, reason: collision with root package name */
    public float f5777i = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: j, reason: collision with root package name */
    public boolean f5778j = false;

    /* renamed from: m, reason: collision with root package name */
    public int f5781m = -1;

    public final void j() {
        if (this.f5774d == null) {
            Toast.makeText(this, "No image to save", 0).show();
            return;
        }
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 29 && h.a(this, "android.permission.WRITE_EXTERNAL_STORAGE") != 0) {
            e.d(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 1001);
            return;
        }
        try {
            String str = "IMG_" + new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date()) + ".jpg";
            if (i5 < 29) {
                File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), str);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    this.f5774d.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", file.getAbsolutePath());
                    contentValues.put("mime_type", "image/jpeg");
                    getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Toast.makeText(this, "Image saved to gallery", 1).show();
                    fileOutputStream.close();
                    return;
                } finally {
                }
            }
            ContentResolver contentResolver = getContentResolver();
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("_display_name", str);
            contentValues2.put("mime_type", "image/jpeg");
            contentValues2.put("relative_path", Environment.DIRECTORY_PICTURES);
            Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues2);
            if (uriInsert != null) {
                OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                try {
                    this.f5774d.compress(Bitmap.CompressFormat.JPEG, 90, outputStreamOpenOutputStream);
                    Toast.makeText(this, "Image saved to gallery", 1).show();
                    if (outputStreamOpenOutputStream != null) {
                        outputStreamOpenOutputStream.close();
                        return;
                    }
                    return;
                } finally {
                }
            }
            return;
        } catch (IOException unused) {
            Toast.makeText(this, "Failed to save image", 0).show();
        }
        Toast.makeText(this, "Failed to save image", 0).show();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_simple_image_viewer);
        if (getSupportActionBar() != null) {
            getSupportActionBar().p("Image Viewer");
            getSupportActionBar().n(true);
        }
        ImageView imageView = (ImageView) findViewById(R.id.fullScreenImage);
        this.f5773c = imageView;
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        this.f5775e = new ScaleGestureDetector(this, new C(this));
        String stringExtra = getIntent().getStringExtra("image_data");
        if (stringExtra != null) {
            try {
                byte[] bArrDecode = Base64.decode(stringExtra, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                this.f5774d = bitmapDecodeByteArray;
                this.f5773c.setImageBitmap(bitmapDecodeByteArray);
                if (this.f5774d != null) {
                    this.f5773c.post(new C0.e(18, this));
                }
            } catch (Exception unused) {
                Toast.makeText(this, "Error loading image", 0).show();
                finish();
            }
        }
        this.f5773c.setOnTouchListener(new ViewOnTouchListenerC0549B(0, this));
        this.f5773c.setOnLongClickListener(new W(this, 3));
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.image_viewer_menu, menu);
        return true;
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) throws IOException {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.action_save) {
            j();
            return true;
        }
        if (itemId == R.id.action_reset_zoom) {
            if (this.f5774d != null) {
                this.f5773c.post(new C0.e(18, this));
            }
            return true;
        }
        if (itemId != R.id.action_share) {
            return super.onOptionsItemSelected(menuItem);
        }
        if (this.f5774d == null) {
            Toast.makeText(this, "No image to share", 0).show();
        } else {
            try {
                File file = new File(getCacheDir(), "images");
                file.mkdirs();
                File file2 = new File(file, "shared_image.jpg");
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    this.f5774d.compress(Bitmap.CompressFormat.JPEG, 90, fileOutputStream);
                    fileOutputStream.close();
                    Uri uriB = FileProvider.b(this, getPackageName() + ".fileprovider", file2);
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("image/jpeg");
                    intent.putExtra("android.intent.extra.STREAM", uriB);
                    intent.addFlags(1);
                    startActivity(Intent.createChooser(intent, "Share Image"));
                } finally {
                }
            } catch (IOException unused) {
                Toast.makeText(this, "Failed to share image", 0).show();
            }
        }
        return true;
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 1001) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Permission denied. Cannot save image.", 0).show();
            } else {
                j();
            }
        }
    }
}
