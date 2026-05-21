package com.unified.ur1.rfmodule;

import D0.p;
import L0.l;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageButton;
import androidx.activity.result.c;
import androidx.fragment.app.N;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.unified.ur1.R;
import f.AbstractActivityC0472i;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import m3.C0768d;
import m3.C0776l;
import m3.w;
import m3.z;

/* loaded from: classes.dex */
public class RecordingsActivity extends AbstractActivityC0472i {

    /* renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f6091j = 0;

    /* renamed from: c, reason: collision with root package name */
    public z f6092c;

    /* renamed from: d, reason: collision with root package name */
    public C0768d f6093d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f6094e = false;

    /* renamed from: f, reason: collision with root package name */
    public ImageButton f6095f = null;
    public C0776l g = null;
    public C0776l h = null;

    /* renamed from: i, reason: collision with root package name */
    public final c f6096i = registerForActivityResult(new N(2), new p(19, this));

    public final void j() {
        Log.d("RecordingsActivity", "Stop playback requested");
        if (this.f6094e) {
            this.f6094e = false;
            this.g = null;
            ImageButton imageButton = this.f6095f;
            if (imageButton != null) {
                imageButton.setImageResource(R.drawable.ic_play);
                this.f6095f = null;
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_recordings);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recordings_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(1));
        ArrayList arrayList = new ArrayList();
        l lVar = new l(29, this);
        z zVar = new z();
        zVar.f8648d = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss", Locale.getDefault());
        zVar.f8646b = this;
        zVar.f8645a = arrayList;
        zVar.f8647c = lVar;
        this.f6092c = zVar;
        recyclerView.setAdapter(zVar);
        this.f6093d = new C0768d(this);
        new Thread(new w(this, 0)).start();
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        j();
        C0768d c0768d = this.f6093d;
        if (c0768d != null) {
            c0768d.l();
            this.f6093d = null;
        }
        super.onDestroy();
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onPause() {
        super.onPause();
        j();
    }
}
