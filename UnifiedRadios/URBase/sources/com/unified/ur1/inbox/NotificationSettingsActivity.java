package com.unified.ur1.inbox;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import com.unified.ur1.R;
import com.unified.ur1.inbox.NotificationSettingsActivity;
import f.AbstractActivityC0472i;

/* loaded from: classes.dex */
public class NotificationSettingsActivity extends AbstractActivityC0472i {

    /* renamed from: c, reason: collision with root package name */
    public Switch f5827c;

    /* renamed from: d, reason: collision with root package name */
    public Switch f5828d;

    /* renamed from: e, reason: collision with root package name */
    public SharedPreferences f5829e;

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_notification_settings);
        if (getSupportActionBar() != null) {
            getSupportActionBar().p("Notification Settings");
            getSupportActionBar().n(true);
        }
        this.f5829e = getSharedPreferences("user_prefs", 0);
        this.f5827c = (Switch) findViewById(R.id.switchSound);
        this.f5828d = (Switch) findViewById(R.id.switchVibration);
        this.f5827c.setChecked(this.f5829e.getBoolean("sound_enabled", true));
        this.f5828d.setChecked(this.f5829e.getBoolean("vibration_enabled", true));
        final int i5 = 0;
        this.f5827c.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: i3.A

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NotificationSettingsActivity f7268b;

            {
                this.f7268b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                switch (i5) {
                    case 0:
                        this.f7268b.f5829e.edit().putBoolean("sound_enabled", z4).apply();
                        break;
                    default:
                        this.f7268b.f5829e.edit().putBoolean("vibration_enabled", z4).apply();
                        break;
                }
            }
        });
        final int i6 = 1;
        this.f5828d.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(this) { // from class: i3.A

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ NotificationSettingsActivity f7268b;

            {
                this.f7268b = this;
            }

            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z4) {
                switch (i6) {
                    case 0:
                        this.f7268b.f5829e.edit().putBoolean("sound_enabled", z4).apply();
                        break;
                    default:
                        this.f7268b.f5829e.edit().putBoolean("vibration_enabled", z4).apply();
                        break;
                }
            }
        });
    }

    @Override // f.AbstractActivityC0472i
    public final boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
