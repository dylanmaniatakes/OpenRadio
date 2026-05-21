package com.unified.ur1.SatelliteTracker;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.recyclerview.widget.AbstractC0266m;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.n0;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class UpcomingPassAdapter extends N {
    private static final String TAG = "UpcomingPassAdapter";
    private static final int TYPE_EMPTY = 2;
    private static final int TYPE_LOADING = 0;
    private static final int TYPE_PASS = 1;
    private List<SatelliteTrackerActivity.SatellitePass> passes;
    private SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss", Locale.US);
    private Date tempDate = new Date();
    private boolean isLoading = false;
    private String statusMessage = "";

    public static class EmptyViewHolder extends n0 {
        TextView messageText;
        TextView subtitleText;

        public EmptyViewHolder(View view) {
            super(view);
            this.messageText = (TextView) view.findViewById(R.id.empty_message);
            this.subtitleText = (TextView) view.findViewById(R.id.empty_subtitle);
        }
    }

    public static class LoadingViewHolder extends n0 {
        TextView messageText;
        ProgressBar progressBar;

        public LoadingViewHolder(View view) {
            super(view);
            this.messageText = (TextView) view.findViewById(R.id.loading_message);
            this.progressBar = (ProgressBar) view.findViewById(R.id.loading_progress);
        }
    }

    public static class PassDiffCallback extends AbstractC0266m {
        private final List<SatelliteTrackerActivity.SatellitePass> newList;
        private final List<SatelliteTrackerActivity.SatellitePass> oldList;

        public PassDiffCallback(List<SatelliteTrackerActivity.SatellitePass> list, List<SatelliteTrackerActivity.SatellitePass> list2) {
            this.oldList = list;
            this.newList = list2;
        }

        @Override // androidx.recyclerview.widget.AbstractC0266m
        public boolean areContentsTheSame(int i5, int i6) {
            SatelliteTrackerActivity.SatellitePass satellitePass = this.oldList.get(i5);
            SatelliteTrackerActivity.SatellitePass satellitePass2 = this.newList.get(i6);
            return satellitePass.satelliteName.equals(satellitePass2.satelliteName) && satellitePass.startTime == satellitePass2.startTime && Math.abs(satellitePass.maxElevation - satellitePass2.maxElevation) < 0.1d;
        }

        @Override // androidx.recyclerview.widget.AbstractC0266m
        public boolean areItemsTheSame(int i5, int i6) {
            return this.oldList.get(i5).noradId.equals(this.newList.get(i6).noradId) && this.oldList.get(i5).startTime == this.newList.get(i6).startTime;
        }

        @Override // androidx.recyclerview.widget.AbstractC0266m
        public int getNewListSize() {
            return this.newList.size();
        }

        @Override // androidx.recyclerview.widget.AbstractC0266m
        public int getOldListSize() {
            return this.oldList.size();
        }
    }

    public static class PassViewHolder extends n0 {
        final TextView countdownText;
        final TextView durationText;
        final TextView endTimeText;
        final TextView frequencyText;
        final TextView maxElevTimeText;
        final TextView maxElevationText;
        final TextView nameText;
        final TextView qualityText;
        final TextView startTimeText;
        final TextView statusText;
        final TextView typeText;

        public PassViewHolder(View view) {
            super(view);
            this.nameText = (TextView) view.findViewById(R.id.satellite_name);
            this.qualityText = (TextView) view.findViewById(R.id.quality_badge);
            this.startTimeText = (TextView) view.findViewById(R.id.start_time);
            this.maxElevTimeText = (TextView) view.findViewById(R.id.max_elev_time);
            this.endTimeText = (TextView) view.findViewById(R.id.end_time);
            this.maxElevationText = (TextView) view.findViewById(R.id.max_elevation);
            this.durationText = (TextView) view.findViewById(R.id.duration);
            this.countdownText = (TextView) view.findViewById(R.id.countdown_timer);
            this.frequencyText = (TextView) view.findViewById(R.id.frequency_info);
            this.typeText = (TextView) view.findViewById(R.id.satellite_type);
            this.statusText = (TextView) view.findViewById(R.id.satellite_status);
        }
    }

    public UpcomingPassAdapter(List<SatelliteTrackerActivity.SatellitePass> list) {
        this.passes = list == null ? new ArrayList<>() : list;
        Log.d(TAG, "UpcomingPassAdapter constructor - passes size: " + this.passes.size());
    }

    private void bindEmptyViewHolder(EmptyViewHolder emptyViewHolder) {
        emptyViewHolder.messageText.setText(!this.statusMessage.isEmpty() ? this.statusMessage : "No upcoming passes");
        emptyViewHolder.subtitleText.setText("Check back later for new satellite opportunities");
    }

    private void bindLoadingViewHolder(LoadingViewHolder loadingViewHolder) {
        loadingViewHolder.messageText.setText(!this.statusMessage.isEmpty() ? this.statusMessage : "Calculating satellite passes...");
    }

    private void bindPassViewHolder(PassViewHolder passViewHolder, SatelliteTrackerActivity.SatellitePass satellitePass) {
        if (satellitePass == null) {
            Log.e(TAG, "Pass is null in bindPassViewHolder");
            return;
        }
        try {
            passViewHolder.nameText.setText(satellitePass.satelliteName);
            passViewHolder.qualityText.setText(satellitePass.quality + " Pass");
            setQualityBadge(passViewHolder.qualityText, satellitePass.quality);
            this.tempDate.setTime(satellitePass.startTime * 1000);
            passViewHolder.startTimeText.setText(this.timeFormat.format(this.tempDate));
            this.tempDate.setTime(satellitePass.maxElevationTime * 1000);
            passViewHolder.maxElevTimeText.setText(this.timeFormat.format(this.tempDate));
            this.tempDate.setTime(satellitePass.endTime * 1000);
            passViewHolder.endTimeText.setText(this.timeFormat.format(this.tempDate));
            passViewHolder.maxElevationText.setText(String.format(Locale.US, "%.1f°", Double.valueOf(satellitePass.maxElevation)));
            passViewHolder.durationText.setText(formatDuration(satellitePass.duration));
            updateCountdown(passViewHolder, satellitePass.startTime);
            setFrequencyInfo(passViewHolder, satellitePass);
        } catch (Exception e5) {
            h.o(e5, new StringBuilder("Error binding pass: "), TAG);
        }
    }

    private String formatDuration(long j5) {
        if (j5 < 60) {
            return j5 + "s";
        }
        return (j5 / 60) + "m " + (j5 % 60) + "s";
    }

    private void setFrequencyInfo(PassViewHolder passViewHolder, SatelliteTrackerActivity.SatellitePass satellitePass) {
        if (satellitePass.frequency == null) {
            passViewHolder.frequencyText.setText("No frequency data");
            passViewHolder.typeText.setText("Unknown");
            passViewHolder.statusText.setText("Unknown");
            return;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = satellitePass.frequency.uplink;
        if (strArr != null && strArr.length > 0) {
            sb.append("↑ ");
            sb.append(satellitePass.frequency.uplink[0]);
            sb.append("\n");
        }
        String[] strArr2 = satellitePass.frequency.downlink;
        if (strArr2 != null && strArr2.length > 0) {
            sb.append("↓ ");
            sb.append(satellitePass.frequency.downlink[0]);
        }
        passViewHolder.frequencyText.setText(sb.toString());
        TextView textView = passViewHolder.typeText;
        String str = satellitePass.frequency.type;
        if (str == null) {
            str = "Unknown";
        }
        textView.setText(str);
        TextView textView2 = passViewHolder.statusText;
        String str2 = satellitePass.frequency.status;
        textView2.setText(str2 != null ? str2 : "Unknown");
    }

    private void setQualityBadge(TextView textView, String str) {
        int i5;
        if (str == null) {
            return;
        }
        String lowerCase = str.toLowerCase();
        lowerCase.getClass();
        switch (lowerCase) {
            case "very good":
                i5 = R.drawable.quality_very_good_bg;
                break;
            case "fair":
                i5 = R.drawable.quality_fair_bg;
                break;
            case "good":
                i5 = R.drawable.quality_good_bg;
                break;
            case "excellent":
                i5 = R.drawable.quality_excellent_bg;
                break;
            default:
                i5 = R.drawable.quality_poor_bg;
                break;
        }
        textView.setBackgroundResource(i5);
    }

    private void updateCountdown(PassViewHolder passViewHolder, long j5) {
        long jCurrentTimeMillis = j5 - (System.currentTimeMillis() / 1000);
        if (jCurrentTimeMillis <= 0) {
            passViewHolder.countdownText.setText("ACTIVE");
            passViewHolder.countdownText.setVisibility(0);
            passViewHolder.countdownText.setBackgroundResource(R.drawable.countdown_bg_green);
        } else {
            passViewHolder.countdownText.setText("T-" + formatDuration(jCurrentTimeMillis));
            passViewHolder.countdownText.setVisibility(0);
            passViewHolder.countdownText.setBackgroundResource(R.drawable.countdown_bg_red);
        }
    }

    @Override // androidx.recyclerview.widget.N
    public int getItemCount() {
        if (this.isLoading || this.passes.isEmpty()) {
            return 1;
        }
        return this.passes.size();
    }

    @Override // androidx.recyclerview.widget.N
    public int getItemViewType(int i5) {
        if (this.isLoading) {
            return 0;
        }
        return this.passes.isEmpty() ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.N
    public void onBindViewHolder(n0 n0Var, int i5) {
        int itemViewType = n0Var.getItemViewType();
        if (itemViewType == 0) {
            bindLoadingViewHolder((LoadingViewHolder) n0Var);
            return;
        }
        if (itemViewType != 1) {
            if (itemViewType != 2) {
                return;
            }
            bindEmptyViewHolder((EmptyViewHolder) n0Var);
        } else if (i5 < this.passes.size()) {
            bindPassViewHolder((PassViewHolder) n0Var, this.passes.get(i5));
        }
    }

    @Override // androidx.recyclerview.widget.N
    public n0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        return i5 != 0 ? i5 != 2 ? new PassViewHolder(layoutInflaterFrom.inflate(R.layout.item_upcoming_pass, viewGroup, false)) : new EmptyViewHolder(layoutInflaterFrom.inflate(R.layout.item_pass_empty, viewGroup, false)) : new LoadingViewHolder(layoutInflaterFrom.inflate(R.layout.item_pass_loading, viewGroup, false));
    }

    public void setDataState() {
        this.isLoading = false;
        this.statusMessage = "";
        notifyDataSetChanged();
    }

    public void setEmptyState(String str) {
        this.isLoading = false;
        this.statusMessage = str;
        notifyDataSetChanged();
    }

    public void setLoadingState(String str) {
        this.isLoading = true;
        this.statusMessage = str;
        notifyDataSetChanged();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00d3 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void updatePasses(java.util.List<com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity.SatellitePass> r23) {
        /*
            Method dump skipped, instructions count: 930
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unified.ur1.SatelliteTracker.UpcomingPassAdapter.updatePasses(java.util.List):void");
    }
}
