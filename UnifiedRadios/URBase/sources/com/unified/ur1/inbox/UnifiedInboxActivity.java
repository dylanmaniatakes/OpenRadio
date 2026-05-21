package com.unified.ur1.inbox;

import A2.g;
import B.e;
import D.n;
import D0.p;
import J0.d;
import N1.k;
import android.app.AlertDialog;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.messaging.FirebaseMessaging;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.h;
import e0.C0432c;
import f.AbstractActivityC0472i;
import f3.C0519j;
import f3.C0524o;
import h4.c;
import i3.B;
import i3.C0573b;
import i3.D;
import i3.DialogInterfaceOnClickListenerC0580i;
import i3.E;
import i3.G;
import i3.H;
import i3.j;
import i3.l;
import i3.y;
import java.util.ArrayList;
import java.util.Iterator;
import m1.m;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import s.AbstractC0882e;

/* loaded from: classes.dex */
public class UnifiedInboxActivity extends AbstractActivityC0472i implements l, D {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f5830m = 0;

    /* renamed from: c, reason: collision with root package name */
    public ProgressBar f5831c;

    /* renamed from: d, reason: collision with root package name */
    public ViewPager2 f5832d;

    /* renamed from: e, reason: collision with root package name */
    public BottomNavigationView f5833e;

    /* renamed from: f, reason: collision with root package name */
    public y f5834f;
    public C0524o g;
    public MessageApiService h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f5835i;

    /* renamed from: j, reason: collision with root package name */
    public String f5836j;

    /* renamed from: k, reason: collision with root package name */
    public SharedPreferences f5837k;

    /* renamed from: l, reason: collision with root package name */
    public final d f5838l = new d(5, this);

    public final void j(ArrayList arrayList, int i5) {
        if (i5 >= arrayList.size()) {
            this.f5831c.setVisibility(8);
            Toast.makeText(this, arrayList.size() + " messages deleted", 0).show();
            m();
            return;
        }
        Message message = (Message) arrayList.get(i5);
        Call<ApiResponse> callMarkAsRead = this.h.markAsRead("mark_deleted", message.getId());
        m mVar = new m();
        mVar.f8547f = this;
        mVar.f8545d = message;
        mVar.f8546e = arrayList;
        mVar.f8544c = i5;
        callMarkAsRead.enqueue(mVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(java.lang.String r8) {
        /*
            r7 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            int r1 = r8.hashCode()
            r2 = -1165461084(0xffffffffba8879a4, float:-0.0010412228)
            r3 = 0
            r4 = 1
            if (r1 == r2) goto L2f
            r2 = -840272977(0xffffffffcdea73af, float:-4.9168125E8)
            if (r1 == r2) goto L25
            r2 = 96673(0x179a1, float:1.35468E-40)
            if (r1 == r2) goto L1b
            goto L39
        L1b:
            java.lang.String r1 = "all"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L39
            r1 = 2
            goto L3a
        L25:
            java.lang.String r1 = "unread"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L39
            r1 = r3
            goto L3a
        L2f:
            java.lang.String r1 = "priority"
            boolean r1 = r8.equals(r1)
            if (r1 == 0) goto L39
            r1 = r4
            goto L3a
        L39:
            r1 = -1
        L3a:
            if (r1 == 0) goto L6e
            if (r1 == r4) goto L44
            java.util.ArrayList r1 = r7.f5835i
            r0.addAll(r1)
            goto L8a
        L44:
            java.util.ArrayList r1 = r7.f5835i
            java.util.Iterator r1 = r1.iterator()
        L4a:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L8a
            java.lang.Object r2 = r1.next()
            com.unified.ur1.inbox.Message r2 = (com.unified.ur1.inbox.Message) r2
            java.lang.String r5 = r2.getPriority()
            java.lang.String r6 = "high"
            boolean r6 = r6.equals(r5)
            if (r6 != 0) goto L6a
            java.lang.String r6 = "urgent"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L4a
        L6a:
            r0.add(r2)
            goto L4a
        L6e:
            java.util.ArrayList r1 = r7.f5835i
            java.util.Iterator r1 = r1.iterator()
        L74:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L8a
            java.lang.Object r2 = r1.next()
            com.unified.ur1.inbox.Message r2 = (com.unified.ur1.inbox.Message) r2
            boolean r5 = r2.isRead()
            if (r5 != 0) goto L74
            r0.add(r2)
            goto L74
        L8a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = r8.substring(r3, r4)
            java.lang.String r2 = r2.toUpperCase()
            r1.append(r2)
            java.lang.String r8 = r8.substring(r4)
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Showing "
            r1.<init>(r2)
            int r0 = r0.size()
            r1.append(r0)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r8)
            java.lang.String r0 = " messages"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            android.widget.Toast r0 = android.widget.Toast.makeText(r7, r0, r3)
            r0.show()
            f.a r0 = r7.getSupportActionBar()
            if (r0 == 0) goto Lf5
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Inbox - "
            r0.<init>(r1)
            java.lang.String r1 = r7.f5836j
            r0.append(r1)
            java.lang.String r1 = " ("
            r0.append(r1)
            r0.append(r8)
            java.lang.String r8 = ")"
            r0.append(r8)
            java.lang.String r8 = r0.toString()
            f.a r0 = r7.getSupportActionBar()
            r0.p(r8)
        Lf5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.inbox.UnifiedInboxActivity.k(java.lang.String):void");
    }

    public final void l(Message message) {
        Intent intent = new Intent(this, (Class<?>) ComposeMessageActivity.class);
        intent.putExtra("from_callsign", this.f5836j);
        intent.putExtra("action_type", "forward");
        intent.putExtra("original_message_id", message.getId());
        String subject = message.getSubject() != null ? message.getSubject() : "No Subject";
        String strConcat = (subject.toLowerCase().startsWith("fwd:") || subject.toLowerCase().startsWith("fw:")) ? subject : "Fwd: ".concat(subject);
        intent.putExtra("subject", strConcat);
        intent.putExtra("forward_subject", strConcat);
        String previewText = message.getPreviewText();
        if (previewText == null || previewText.trim().isEmpty()) {
            previewText = "No message content available";
        }
        StringBuilder sbB = AbstractC0882e.b("\n\n---------- Forwarded message ----------\nFrom: ");
        sbB.append(message.getFromCallsign() != null ? message.getFromCallsign() : "Unknown");
        sbB.append("\nDate: ");
        sbB.append(message.getDisplayTime());
        sbB.append("\nSubject: ");
        sbB.append(subject);
        sbB.append("\n");
        if (message.getMessageType() != null) {
            sbB.append("Type: ");
            sbB.append(message.getMessageType());
            sbB.append("\n");
        }
        if (message.getPriority() != null && !message.getPriority().equals("normal")) {
            sbB.append("Priority: ");
            sbB.append(message.getPriority().toUpperCase());
            sbB.append("\n");
        }
        sbB.append("\n");
        sbB.append(previewText);
        sbB.append("\n---------- End forwarded message ----------\n");
        intent.putExtra("message_content", sbB.toString());
        intent.putExtra("content", sbB.toString());
        intent.putExtra("body", sbB.toString());
        intent.putExtra("forward_content", sbB.toString());
        Log.d("UnifiedInbox", "Forward Intent Extras:");
        Log.d("UnifiedInbox", "  - subject: " + strConcat);
        Log.d("UnifiedInbox", "  - content length: " + sbB.length());
        Log.d("UnifiedInbox", "  - original from: " + message.getFromCallsign());
        startActivityForResult(intent, 1002);
        Toast.makeText(this, "Forwarding message", 0).show();
    }

    public final void m() {
        Log.d("UnifiedInbox", "=== loadMessages() called ===");
        if (this.h == null) {
            Log.e("UnifiedInbox", "API service is null!");
            Toast.makeText(this, "API not available", 0).show();
            ProgressBar progressBar = this.f5831c;
            if (progressBar != null) {
                progressBar.setVisibility(8);
                return;
            }
            return;
        }
        String str = this.f5836j;
        if (str == null || str.isEmpty()) {
            Log.e("UnifiedInbox", "User callsign is null or empty!");
            return;
        }
        h.q(new StringBuilder("Making API call with callsign: "), this.f5836j, "UnifiedInbox");
        ProgressBar progressBar2 = this.f5831c;
        if (progressBar2 != null) {
            progressBar2.setVisibility(0);
        }
        try {
            this.h.getMessages(this.f5836j, 0, 50).enqueue(new L0.l(25, this));
        } catch (Exception e5) {
            Log.e("UnifiedInbox", "Exception creating API call", e5);
            ProgressBar progressBar3 = this.f5831c;
            if (progressBar3 != null) {
                progressBar3.setVisibility(8);
            }
        }
    }

    public final void n(Message message) {
        Intent intent = new Intent(this, (Class<?>) ComposeMessageActivity.class);
        intent.putExtra("from_callsign", this.f5836j);
        intent.putExtra("action_type", "reply");
        intent.putExtra("original_message_id", message.getId());
        intent.putExtra("recipient_callsign", message.getFromCallsign());
        intent.putExtra("to", message.getFromCallsign());
        intent.putExtra("reply_to", message.getFromCallsign());
        String subject = message.getSubject() != null ? message.getSubject() : "No Subject";
        if (!subject.toLowerCase().startsWith("re:")) {
            subject = "Re: ".concat(subject);
        }
        intent.putExtra("subject", subject);
        intent.putExtra("reply_subject", subject);
        String previewText = message.getPreviewText();
        if (previewText == null || previewText.trim().isEmpty()) {
            previewText = "No message content available";
        }
        StringBuilder sbB = AbstractC0882e.b("\n\nOn ");
        sbB.append(message.getDisplayTime());
        sbB.append(", ");
        sbB.append(message.getFromCallsign() != null ? message.getFromCallsign() : "Unknown");
        sbB.append(" wrote:\n\n");
        for (String str : previewText.split("\n")) {
            sbB.append("> ");
            sbB.append(str);
            sbB.append("\n");
        }
        intent.putExtra("message_content", sbB.toString());
        intent.putExtra("content", sbB.toString());
        intent.putExtra("body", sbB.toString());
        intent.putExtra("quoted_text", sbB.toString());
        Log.d("UnifiedInbox", "Reply Intent Extras:");
        Log.d("UnifiedInbox", "  - to: " + message.getFromCallsign());
        StringBuilder sbH = h.h("UnifiedInbox", "  - subject: " + subject, "  - content length: ");
        sbH.append(sbB.length());
        Log.d("UnifiedInbox", sbH.toString());
        startActivityForResult(intent, 1002);
        Toast.makeText(this, "Replying to " + message.getFromCallsign(), 0).show();
        if (message.isRead()) {
            return;
        }
        int id = message.getId();
        this.h.markAsRead("mark_read", id).enqueue(new L.h(id, this));
    }

    public final void o() {
        try {
            Log.d("UnifiedInbox", "Setting up Retrofit API...");
            Retrofit retrofitBuild = new Retrofit.Builder().baseUrl("https://ur1.unifiedradios.com/messages/").addConverterFactory(GsonConverterFactory.create()).build();
            Log.d("UnifiedInbox", "Retrofit builder created successfully");
            this.h = (MessageApiService) retrofitBuild.create(MessageApiService.class);
            Log.d("UnifiedInbox", "API Service created successfully");
        } catch (Exception e5) {
            StringBuilder sbG = h.g("UnifiedInbox", "Error setting up API", e5, "API setup failed: ");
            sbG.append(e5.getMessage());
            Toast.makeText(this, sbG.toString(), 1).show();
            this.h = null;
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i5, int i6, Intent intent) {
        super.onActivityResult(i5, i6, intent);
        if (i5 == 1002 && i6 == -1) {
            m();
            Toast.makeText(this, "Message sent successfully", 0).show();
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, B.i, android.app.Activity
    public final void onCreate(Bundle bundle) {
        FirebaseMessaging firebaseMessaging;
        super.onCreate(bundle);
        try {
            setContentView(R.layout.activity_unified_inbox);
            Log.d("UnifiedInbox", "Layout inflated successfully");
            this.f5835i = new ArrayList();
            this.f5837k = getSharedPreferences("user_prefs", 0);
            this.f5836j = c.h(this);
            h.q(new StringBuilder("User callsign: "), this.f5836j, "UnifiedInbox");
            String str = this.f5836j;
            if (str == null || str.isEmpty()) {
                Log.e("UnifiedInbox", "Callsign is null or empty, finishing activity");
                Toast.makeText(this, "Callsign not found", 0).show();
                finish();
                return;
            }
            try {
                r();
                o();
                p();
                int i5 = Build.VERSION.SDK_INT;
                if (i5 >= 33 && C.h.a(this, "android.permission.POST_NOTIFICATIONS") != 0) {
                    e.d(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 1001);
                }
                Log.d("UnifiedInbox", "Setting up FCM...");
                C0519j c0519j = FirebaseMessaging.f5540k;
                synchronized (FirebaseMessaging.class) {
                    firebaseMessaging = FirebaseMessaging.getInstance(g.b());
                }
                firebaseMessaging.getClass();
                k kVar = new k();
                firebaseMessaging.f5548f.execute(new D.m(firebaseMessaging, 10, kVar));
                kVar.f1789a.g(new C0519j(19, this));
                IntentFilter intentFilter = new IntentFilter("REGISTER_FCM_TOKEN");
                d dVar = this.f5838l;
                if (i5 >= 33) {
                    registerReceiver(dVar, intentFilter, 4);
                } else {
                    registerReceiver(dVar, intentFilter);
                }
                Log.d("UnifiedInbox", "onCreate completed successfully");
            } catch (Exception e5) {
                StringBuilder sbG = h.g("UnifiedInbox", "Error in onCreate setup", e5, "Initialization error: ");
                sbG.append(e5.getMessage());
                Toast.makeText(this, sbG.toString(), 1).show();
            }
        } catch (Exception e6) {
            Log.e("UnifiedInbox", "Error inflating layout", e6);
            finish();
        }
    }

    @Override // android.app.Activity
    public final boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.inbox_menu, menu);
        return true;
    }

    @Override // f.AbstractActivityC0472i, androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        try {
            unregisterReceiver(this.f5838l);
        } catch (IllegalArgumentException unused) {
        }
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        }
        if (itemId == R.id.action_refresh) {
            m();
            return true;
        }
        if (itemId == R.id.action_mark_all_read) {
            this.h.markAllAsRead("mark_all_read", this.f5836j).enqueue(new B0.l(18, this));
            return true;
        }
        if (itemId == R.id.action_sent_messages) {
            startActivity(new Intent(this, (Class<?>) B.class));
            return true;
        }
        if (itemId == R.id.action_delete_all_read) {
            ArrayList arrayList = new ArrayList();
            Iterator it = this.f5835i.iterator();
            while (it.hasNext()) {
                Message message = (Message) it.next();
                if (message.isRead()) {
                    arrayList.add(message);
                }
            }
            if (arrayList.isEmpty()) {
                Toast.makeText(this, "No read messages to delete", 0).show();
            } else {
                new AlertDialog.Builder(this).setTitle("Delete All Read Messages").setMessage("Are you sure you want to delete all " + arrayList.size() + " read messages?").setPositiveButton("Delete All", new DialogInterfaceOnClickListenerC0580i(this, 3, arrayList)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            }
            return true;
        }
        if (itemId == R.id.action_search) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            EditText editText = new EditText(this);
            editText.setHint("Search messages...");
            editText.setInputType(1);
            builder.setTitle("Search Messages").setView(editText).setPositiveButton("Search", new DialogInterfaceOnClickListenerC0580i(this, 2, editText)).setNegativeButton("Cancel", (DialogInterface.OnClickListener) null).show();
            return true;
        }
        if (itemId == R.id.filter_unread) {
            k("unread");
            return true;
        }
        if (itemId == R.id.filter_all) {
            k("all");
            return true;
        }
        if (itemId == R.id.filter_priority) {
            k("priority");
            return true;
        }
        if (itemId != R.id.action_settings) {
            return super.onOptionsItemSelected(menuItem);
        }
        startActivity(new Intent(this, (Class<?>) NotificationSettingsActivity.class));
        return true;
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, androidx.activity.ComponentActivity, android.app.Activity
    public final void onRequestPermissionsResult(int i5, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i5, strArr, iArr);
        if (i5 == 1001) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(this, "Notification permission denied", 0).show();
            } else {
                Log.d("UnifiedInbox", "Notification permission granted");
            }
        }
    }

    @Override // androidx.fragment.app.AbstractActivityC0230z, android.app.Activity
    public final void onResume() {
        super.onResume();
        y yVar = this.f5834f;
        if (yVar != null) {
            i3.m mVarH = yVar.h();
            if (mVarH != null) {
                Log.d("UnifiedInbox", "Refreshing InboxFragment on resume");
                mVarH.i();
            }
            E eI = this.f5834f.i();
            if (eI != null) {
                Log.d("UnifiedInbox", "Refreshing SentFragment on resume");
                eI.g();
            }
        }
    }

    public final void p() {
        NotificationChannel notificationChannel = new NotificationChannel("MESSAGE_NOTIFICATIONS", "Message Notifications", 4);
        notificationChannel.setDescription("Notifications for new messages");
        notificationChannel.enableVibration(true);
        notificationChannel.setVibrationPattern(new long[]{0, 250, 250, 250});
        notificationChannel.setSound(Uri.parse("android.resource://" + getPackageName() + "/2131886085"), null);
        ((NotificationManager) getSystemService(NotificationManager.class)).createNotificationChannel(notificationChannel);
    }

    public final void q(int i5) {
        if (i5 >= 10) {
            Log.e("UnifiedInbox", "Failed to setup SentFragment listener after 10 attempts");
            return;
        }
        y yVar = this.f5834f;
        if (yVar == null) {
            Log.e("UnifiedInbox", "PagerAdapter is null, cannot setup SentFragment");
            return;
        }
        E eI = yVar.i();
        if (eI == null) {
            Log.w("UnifiedInbox", "SentFragment is null (attempt " + (i5 + 1) + "), retrying in 500ms...");
            this.f5832d.postDelayed(new n(i5, 2, this), 500L);
            return;
        }
        Log.d("UnifiedInbox", "Setting listener for SentFragment (attempt " + (i5 + 1) + ")");
        Log.d("SentFragment", "setListener() called - listener is ".concat("not null"));
        eI.h = this;
        Log.d("SentFragment", "Listener set, now loading sent messages");
        eI.g();
        Log.d("UnifiedInbox", "SentFragment listener setup complete");
    }

    public final void r() {
        try {
            if (getSupportActionBar() != null) {
                getSupportActionBar().p("Messages - " + this.f5836j);
                getSupportActionBar().n(true);
            }
            this.f5832d = (ViewPager2) findViewById(R.id.viewPager);
            this.f5833e = (BottomNavigationView) findViewById(R.id.bottomNavigation);
            this.f5831c = (ProgressBar) findViewById(R.id.progressBar);
            if (this.f5832d != null && this.f5833e != null) {
                y yVar = new y(this);
                this.f5834f = yVar;
                this.f5832d.setAdapter(yVar);
                this.f5832d.setOffscreenPageLimit(1);
                Log.d("UnifiedInbox", "ViewPager adapter set with offscreen limit");
                FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fabCompose);
                if (floatingActionButton != null) {
                    floatingActionButton.setOnClickListener(new com.google.android.material.datepicker.l(2, this));
                }
                this.f5833e.setOnItemSelectedListener(new p(16, this));
                ((ArrayList) this.f5832d.f4462e.f89b).add(new B0.c(2, this));
                Log.d("UnifiedInbox", "Forcing creation of both fragments...");
                this.f5832d.b(0, false);
                this.f5832d.post(new G(this, 0));
                return;
            }
            Log.e("UnifiedInbox", "Critical views not found");
            finish();
        } catch (Exception e5) {
            Log.e("UnifiedInbox", "Error in setupViews", e5);
            finish();
        }
    }

    public final void s(Message message, int i5) {
        AlertDialog.Builder title = new AlertDialog.Builder(this).setTitle("Delete Message");
        StringBuilder sb = new StringBuilder("Are you sure you want to delete this message from ");
        sb.append(message.getFromCallsign() != null ? message.getFromCallsign() : "Unknown");
        sb.append("?");
        title.setMessage(sb.toString()).setPositiveButton("Delete", new i3.k(this, message, i5, 1)).setNegativeButton("Cancel", new j(i5, 1, this)).setOnCancelListener(new H(this, i5)).show();
    }

    public final void t(Message message) {
        if (this.h == null) {
            Toast.makeText(this, "Cannot update message - API not available", 0).show();
            return;
        }
        String str = message.isRead() ? "mark_unread" : "mark_read";
        this.f5831c.setVisibility(0);
        this.h.markAsRead(str, message.getId()).enqueue(new L0.e(18, this, message, false));
    }

    public final void u() {
        i3.m mVarH;
        y yVar = this.f5834f;
        if (yVar == null || (mVarH = yVar.h()) == null) {
            return;
        }
        Iterator it = mVarH.h.iterator();
        int i5 = 0;
        while (it.hasNext()) {
            if (!((Message) it.next()).isRead()) {
                i5++;
            }
        }
        C0573b.g(this).o(i5);
        Intent intent = new Intent("UPDATE_MESSAGE_BADGE");
        intent.putExtra("unread_count", i5);
        sendBroadcast(intent);
        C0432c.a(this).c(intent);
        SharedPreferences.Editor editorEdit = this.f5837k.edit();
        editorEdit.putInt("unread_count", i5);
        editorEdit.putLong("last_badge_update", System.currentTimeMillis());
        editorEdit.apply();
        Log.d("UnifiedInbox", "Badge count updated: " + i5 + " unread messages");
    }
}
