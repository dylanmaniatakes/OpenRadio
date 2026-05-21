package com.unified.ur1.SatelliteTracker;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.AbstractC0266m;
import androidx.recyclerview.widget.N;
import androidx.recyclerview.widget.n0;
import com.unified.ur1.R;
import com.unified.ur1.SatelliteTracker.SatelliteTrackerActivity;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class CurrentSatelliteAdapter extends N {
    private static final int TYPE_CALCULATING = 3;
    private static final int TYPE_EMPTY = 2;
    private static final int TYPE_LOADING = 0;
    private static final int TYPE_SATELLITE = 1;
    private boolean isEmpty;
    private final List<SatelliteTrackerActivity.CurrentSatellite> satellites;
    private boolean isLoading = false;
    private boolean isCalculating = false;
    private String statusMessage = "";
    private Handler animationHandler = new Handler(Looper.getMainLooper());
    private int animationFrame = 0;
    private final Runnable loadingAnimationRunnable = new Runnable() { // from class: com.unified.ur1.SatelliteTracker.CurrentSatelliteAdapter.1
        @Override // java.lang.Runnable
        public void run() {
            if (CurrentSatelliteAdapter.this.isLoading) {
                CurrentSatelliteAdapter currentSatelliteAdapter = CurrentSatelliteAdapter.this;
                currentSatelliteAdapter.animationFrame = (currentSatelliteAdapter.animationFrame + 1) % 4;
                CurrentSatelliteAdapter.this.notifyItemChanged(0);
                CurrentSatelliteAdapter.this.animationHandler.postDelayed(this, 500L);
            }
        }
    };
    private final Runnable calculatingAnimationRunnable = new Runnable() { // from class: com.unified.ur1.SatelliteTracker.CurrentSatelliteAdapter.2
        @Override // java.lang.Runnable
        public void run() {
            if (CurrentSatelliteAdapter.this.isCalculating) {
                CurrentSatelliteAdapter currentSatelliteAdapter = CurrentSatelliteAdapter.this;
                currentSatelliteAdapter.animationFrame = (currentSatelliteAdapter.animationFrame + 1) % 3;
                CurrentSatelliteAdapter.this.notifyItemChanged(0);
                CurrentSatelliteAdapter.this.animationHandler.postDelayed(this, 300L);
            }
        }
    };

    public static class CalculatingViewHolder extends n0 {
        TextView messageText;
        ProgressBar progressBar;
        TextView progressText;

        public CalculatingViewHolder(View view) {
            super(view);
            this.messageText = (TextView) view.findViewById(R.id.calculating_message);
            this.progressText = (TextView) view.findViewById(R.id.progress_text);
            this.progressBar = (ProgressBar) view.findViewById(R.id.calculating_progress);
        }
    }

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

    public static class SatelliteDiffCallback extends AbstractC0266m {
        private final List<SatelliteTrackerActivity.CurrentSatellite> newList;
        private final List<SatelliteTrackerActivity.CurrentSatellite> oldList;

        public SatelliteDiffCallback(List<SatelliteTrackerActivity.CurrentSatellite> list, List<SatelliteTrackerActivity.CurrentSatellite> list2) {
            this.oldList = list;
            this.newList = list2;
        }

        @Override // androidx.recyclerview.widget.AbstractC0266m
        public boolean areContentsTheSame(int i5, int i6) {
            SatelliteTrackerActivity.CurrentSatellite currentSatellite = this.oldList.get(i5);
            SatelliteTrackerActivity.CurrentSatellite currentSatellite2 = this.newList.get(i6);
            return currentSatellite.name.equals(currentSatellite2.name) && Math.abs(currentSatellite.topocentric.elevation - currentSatellite2.topocentric.elevation) < 0.1d && Math.abs(currentSatellite.topocentric.azimuth - currentSatellite2.topocentric.azimuth) < 1.0d;
        }

        @Override // androidx.recyclerview.widget.AbstractC0266m
        public boolean areItemsTheSame(int i5, int i6) {
            return this.oldList.get(i5).name.equals(this.newList.get(i6).name);
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

    public static class SatelliteViewHolder extends n0 {
        TextView altitudeText;
        TextView azimuthText;
        TextView elevationText;
        TextView frequencyText;
        TextView nameText;
        TextView positionText;
        TextView rangeText;
        TextView signalText;
        TextView statusText;
        TextView typeText;

        public SatelliteViewHolder(final View view) {
            super(view);
            this.nameText = (TextView) view.findViewById(R.id.satellite_name);
            this.statusText = (TextView) view.findViewById(R.id.satellite_status);
            this.elevationText = (TextView) view.findViewById(R.id.elevation_value);
            this.azimuthText = (TextView) view.findViewById(R.id.azimuth_value);
            this.rangeText = (TextView) view.findViewById(R.id.range_value);
            this.altitudeText = (TextView) view.findViewById(R.id.altitude_value);
            this.frequencyText = (TextView) view.findViewById(R.id.frequency_info);
            this.typeText = (TextView) view.findViewById(R.id.satellite_type);
            this.positionText = (TextView) view.findViewById(R.id.position_info);
            this.signalText = (TextView) view.findViewById(R.id.signal_strength);
            ((Button) view.findViewById(R.id.AmSattoRadio)).setOnClickListener(new View.OnClickListener() { // from class: com.unified.ur1.SatelliteTracker.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    this.f5573c.lambda$new$0(view, view2);
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void lambda$new$0(View view, View view2) {
            Toast.makeText(view.getContext(), "Coming Soon - satellite: " + ((Object) this.nameText.getText()), 0).show();
        }
    }

    public CurrentSatelliteAdapter(List<SatelliteTrackerActivity.CurrentSatellite> list) {
        this.isEmpty = false;
        list = list == null ? new ArrayList<>() : list;
        this.satellites = list;
        this.isEmpty = list.isEmpty();
    }

    private void bindCalculatingViewHolder(CalculatingViewHolder calculatingViewHolder) {
        calculatingViewHolder.messageText.setText(!this.statusMessage.isEmpty() ? this.statusMessage : "Calculating satellite positions...");
        TextView textView = calculatingViewHolder.progressText;
        Locale locale = Locale.US;
        textView.setText("Processing " + this.satellites.size() + " satellites");
    }

    private void bindEmptyViewHolder(EmptyViewHolder emptyViewHolder) {
        emptyViewHolder.messageText.setText(!this.statusMessage.isEmpty() ? this.statusMessage : "No satellites currently visible");
        emptyViewHolder.subtitleText.setText("Satellites will appear here when they pass overhead");
    }

    private void bindLoadingViewHolder(LoadingViewHolder loadingViewHolder) {
        loadingViewHolder.messageText.setText(!this.statusMessage.isEmpty() ? this.statusMessage : "Loading satellite data...");
    }

    private void bindSatelliteViewHolder(SatelliteViewHolder satelliteViewHolder, SatelliteTrackerActivity.CurrentSatellite currentSatellite) {
        try {
            satelliteViewHolder.nameText.setText(currentSatellite.name);
            satelliteViewHolder.statusText.setText("🔴 LIVE");
            TextView textView = satelliteViewHolder.elevationText;
            Locale locale = Locale.US;
            textView.setText(String.format(locale, "%.1f°", Double.valueOf(currentSatellite.topocentric.elevation)));
            satelliteViewHolder.azimuthText.setText(String.format(locale, "%.0f°", Double.valueOf(currentSatellite.topocentric.azimuth)));
            satelliteViewHolder.rangeText.setText(String.format(locale, "%.0f km", Double.valueOf(currentSatellite.topocentric.range)));
            satelliteViewHolder.altitudeText.setText(String.format(locale, "%.0f km", Double.valueOf(currentSatellite.position.altitude)));
            StringBuilder sb = new StringBuilder();
            SatelliteTrackerActivity.SatelliteFrequency satelliteFrequency = currentSatellite.frequency;
            if (satelliteFrequency != null) {
                String[] strArr = satelliteFrequency.uplink;
                if (strArr != null && strArr.length > 0) {
                    sb.append("↑ ");
                    sb.append(currentSatellite.frequency.uplink[0]);
                    sb.append("\n");
                }
                String[] strArr2 = currentSatellite.frequency.downlink;
                if (strArr2 != null && strArr2.length > 0) {
                    sb.append("↓ ");
                    sb.append(currentSatellite.frequency.downlink[0]);
                }
                TextView textView2 = satelliteViewHolder.typeText;
                String str = currentSatellite.frequency.type;
                textView2.setText(str != null ? str : "Unknown");
            } else {
                sb.append("No frequency data");
                satelliteViewHolder.typeText.setText("Unknown");
            }
            satelliteViewHolder.frequencyText.setText(sb.toString());
            satelliteViewHolder.positionText.setText(String.format(locale, "%.4f°, %.4f°", Double.valueOf(currentSatellite.position.latitude), Double.valueOf(currentSatellite.position.longitude)));
            updateSignalStrength(satelliteViewHolder, currentSatellite.topocentric.elevation);
        } catch (Exception unused) {
            satelliteViewHolder.nameText.setText("Error loading satellite");
            satelliteViewHolder.statusText.setText("⚠️ ERROR");
        }
    }

    private void startCalculatingAnimation() {
        stopAnimations();
        this.animationHandler.post(this.calculatingAnimationRunnable);
    }

    private void startLoadingAnimation() {
        stopAnimations();
        this.animationHandler.post(this.loadingAnimationRunnable);
    }

    private void stopAnimations() {
        this.animationHandler.removeCallbacks(this.loadingAnimationRunnable);
        this.animationHandler.removeCallbacks(this.calculatingAnimationRunnable);
    }

    private void updateSignalStrength(SatelliteViewHolder satelliteViewHolder, double d5) {
        satelliteViewHolder.signalText.setText(d5 >= 60.0d ? "📶📶📶📶📶" : d5 >= 40.0d ? "📶📶📶📶⬜" : d5 >= 25.0d ? "📶📶📶⬜⬜" : d5 >= 15.0d ? "📶📶⬜⬜⬜" : "📶⬜⬜⬜⬜");
    }

    public void addSatelliteProgressively(SatelliteTrackerActivity.CurrentSatellite currentSatellite, boolean z4) {
        this.satellites.add(currentSatellite);
        if (this.isLoading || this.isCalculating) {
            setDataState();
        } else {
            notifyItemInserted(this.satellites.size() - 1);
        }
        if (z4) {
            setDataState();
        }
    }

    public void cleanup() {
        stopAnimations();
        this.animationHandler = null;
    }

    @Override // androidx.recyclerview.widget.N
    public int getItemCount() {
        if (this.isLoading || this.isCalculating || this.isEmpty || this.satellites.isEmpty()) {
            return 1;
        }
        return this.satellites.size();
    }

    @Override // androidx.recyclerview.widget.N
    public int getItemViewType(int i5) {
        if (this.isLoading) {
            return 0;
        }
        if (this.isCalculating) {
            return 3;
        }
        return (this.isEmpty || this.satellites.isEmpty()) ? 2 : 1;
    }

    @Override // androidx.recyclerview.widget.N
    public void onBindViewHolder(n0 n0Var, int i5) {
        int itemViewType = n0Var.getItemViewType();
        if (itemViewType == 0) {
            bindLoadingViewHolder((LoadingViewHolder) n0Var);
            return;
        }
        if (itemViewType == 1) {
            if (i5 < this.satellites.size()) {
                bindSatelliteViewHolder((SatelliteViewHolder) n0Var, this.satellites.get(i5));
            }
        } else if (itemViewType == 2) {
            bindEmptyViewHolder((EmptyViewHolder) n0Var);
        } else {
            if (itemViewType != 3) {
                return;
            }
            bindCalculatingViewHolder((CalculatingViewHolder) n0Var);
        }
    }

    @Override // androidx.recyclerview.widget.N
    public n0 onCreateViewHolder(ViewGroup viewGroup, int i5) {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(viewGroup.getContext());
        return i5 != 0 ? i5 != 2 ? i5 != 3 ? new SatelliteViewHolder(layoutInflaterFrom.inflate(R.layout.item_current_satellite, viewGroup, false)) : new CalculatingViewHolder(layoutInflaterFrom.inflate(R.layout.item_satellite_calculating, viewGroup, false)) : new EmptyViewHolder(layoutInflaterFrom.inflate(R.layout.item_satellite_empty, viewGroup, false)) : new LoadingViewHolder(layoutInflaterFrom.inflate(R.layout.item_satellite_loading, viewGroup, false));
    }

    public void setCalculatingState(String str) {
        this.isLoading = false;
        this.isCalculating = true;
        this.isEmpty = false;
        this.statusMessage = str;
        notifyDataSetChanged();
        startCalculatingAnimation();
    }

    public void setDataState() {
        this.isLoading = false;
        this.isCalculating = false;
        this.isEmpty = this.satellites.isEmpty();
        this.statusMessage = "";
        notifyDataSetChanged();
        stopAnimations();
    }

    public void setEmptyState(String str) {
        this.isLoading = false;
        this.isCalculating = false;
        this.isEmpty = true;
        this.statusMessage = str;
        notifyDataSetChanged();
        stopAnimations();
    }

    public void setLoadingState(String str) {
        this.isLoading = true;
        this.isCalculating = false;
        this.isEmpty = false;
        this.statusMessage = str;
        notifyDataSetChanged();
        startLoadingAnimation();
    }

    public void updateSatellites(List<SatelliteTrackerActivity.CurrentSatellite> list) {
        if (list == null) {
            setEmptyState("No satellite data available");
            return;
        }
        this.satellites.clear();
        this.satellites.addAll(list);
        setDataState();
        notifyDataSetChanged();
    }
}
