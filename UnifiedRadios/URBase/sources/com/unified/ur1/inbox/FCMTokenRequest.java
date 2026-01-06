package com.unified.ur1.inbox;

import com.google.gson.annotations.SerializedName;
import com.unified.ur1.SatelliteTracker.h;

/* loaded from: classes.dex */
public class FCMTokenRequest {

    @SerializedName("callsign")
    private String callsign;

    @SerializedName("device_id")
    private String deviceId;

    @SerializedName("device_name")
    private String deviceName;

    @SerializedName("platform")
    private String platform;

    @SerializedName("token")
    private String token;

    public FCMTokenRequest(String str, String str2, String str3) {
        this.callsign = str;
        this.token = str2;
        this.platform = str3;
    }

    public String getCallsign() {
        return this.callsign;
    }

    public String getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getPlatform() {
        return this.platform;
    }

    public String getToken() {
        return this.token;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FCMTokenRequest{callsign='");
        sb.append(this.callsign);
        sb.append("', platform='");
        sb.append(this.platform);
        sb.append("', deviceId='");
        sb.append(this.deviceId);
        sb.append("', deviceName='");
        return h.e(sb, this.deviceName, "'}");
    }

    public FCMTokenRequest(String str, String str2, String str3, String str4, String str5) {
        this.callsign = str;
        this.token = str2;
        this.platform = str3;
        this.deviceId = str4;
        this.deviceName = str5;
    }
}
