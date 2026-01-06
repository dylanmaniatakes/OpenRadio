package com.unified.ur1.inbox;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class ApiResponse {

    @SerializedName("error")
    private String error;

    @SerializedName("message")
    private String message;

    @SerializedName("success")
    private boolean success;

    public String getError() {
        return this.error;
    }

    public String getMessage() {
        return this.message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public void setError(String str) {
        this.error = str;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setSuccess(boolean z4) {
        this.success = z4;
    }
}
