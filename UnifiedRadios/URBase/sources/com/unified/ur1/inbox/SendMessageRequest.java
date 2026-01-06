package com.unified.ur1.inbox;

import com.google.gson.annotations.SerializedName;

/* loaded from: classes.dex */
public class SendMessageRequest {

    @SerializedName("attachments")
    private String attachmentsJson;

    @SerializedName("from_callsign")
    private String fromCallsign;

    @SerializedName("is_high_sensitivity")
    private boolean isHighSensitivity;

    @SerializedName("message_body")
    private String messageBody;

    @SerializedName("message_type")
    private String messageType;

    @SerializedName("priority")
    private String priority;

    @SerializedName("subject")
    private String subject;

    @SerializedName("to_callsign")
    private String toCallsign;

    public SendMessageRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        this.toCallsign = str;
        this.fromCallsign = str2;
        this.subject = str3;
        this.messageBody = str4;
        this.messageType = str5;
        this.priority = str6;
        this.attachmentsJson = null;
        this.isHighSensitivity = false;
    }

    public String getAttachmentsJson() {
        return this.attachmentsJson;
    }

    public String getFromCallsign() {
        return this.fromCallsign;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getToCallsign() {
        return this.toCallsign;
    }

    public boolean isHighSensitivity() {
        return this.isHighSensitivity;
    }

    public void setAttachmentsJson(String str) {
        this.attachmentsJson = str;
    }

    public void setFromCallsign(String str) {
        this.fromCallsign = str;
    }

    public void setHighSensitivity(boolean z4) {
        this.isHighSensitivity = z4;
    }

    public void setMessageBody(String str) {
        this.messageBody = str;
    }

    public void setMessageType(String str) {
        this.messageType = str;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setToCallsign(String str) {
        this.toCallsign = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("SendMessageRequest{toCallsign='");
        sb.append(this.toCallsign);
        sb.append("', fromCallsign='");
        sb.append(this.fromCallsign);
        sb.append("', subject='");
        sb.append(this.subject);
        sb.append("', messageType='");
        sb.append(this.messageType);
        sb.append("', priority='");
        sb.append(this.priority);
        sb.append("', isHighSensitivity=");
        sb.append(this.isHighSensitivity);
        sb.append(", attachments=");
        sb.append(this.attachmentsJson != null ? "[present]" : "[none]");
        sb.append(", messageBodyLength=");
        String str = this.messageBody;
        sb.append(str != null ? str.length() : 0);
        sb.append('}');
        return sb.toString();
    }

    public SendMessageRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        this.toCallsign = str;
        this.fromCallsign = str2;
        this.subject = str3;
        this.messageBody = str4;
        this.messageType = str5;
        this.priority = str6;
        this.attachmentsJson = str7;
        this.isHighSensitivity = false;
    }

    public SendMessageRequest(String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z4) {
        this.toCallsign = str;
        this.fromCallsign = str2;
        this.subject = str3;
        this.messageBody = str4;
        this.messageType = str5;
        this.priority = str6;
        this.attachmentsJson = str7;
        this.isHighSensitivity = z4;
    }
}
