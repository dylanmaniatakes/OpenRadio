package com.unified.ur1.inbox;

import com.google.gson.annotations.SerializedName;
import com.unified.ur1.SatelliteTracker.h;
import java.util.List;

/* loaded from: classes.dex */
public class Message {

    @SerializedName("attachment_count")
    private int attachmentCount;

    @SerializedName("attachments")
    private List<Attachment> attachments;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("display_time")
    private String displayTime;

    @SerializedName("from_callsign")
    private String fromCallsign;

    @SerializedName("has_attachments")
    private boolean hasAttachments;

    @SerializedName("id")
    private int id;

    @SerializedName("image_count")
    private int imageCount;

    @SerializedName("is_deleted")
    private boolean isDeleted;

    @SerializedName("is_high_sensitivity")
    private boolean isHighSensitivity;

    @SerializedName("is_read")
    private boolean isRead;

    @SerializedName("message_body")
    private String messageBody;

    @SerializedName("message_type")
    private String messageType;

    @SerializedName("preview_text")
    private String previewText;

    @SerializedName("priority")
    private String priority;

    @SerializedName("read_at")
    private String readAt;

    @SerializedName("subject")
    private String subject;

    @SerializedName("team_id")
    private String teamId;

    @SerializedName("to_callsign")
    private String toCallsign;

    public static class Attachment {

        @SerializedName("data")
        private String data;

        @SerializedName("filename")
        private String filename;

        @SerializedName("size")
        private int size;

        @SerializedName("type")
        private String type;

        public Attachment() {
        }

        public String getData() {
            return this.data;
        }

        public String getFilename() {
            return this.filename;
        }

        public int getSize() {
            return this.size;
        }

        public String getType() {
            return this.type;
        }

        public void setData(String str) {
            this.data = str;
        }

        public void setFilename(String str) {
            this.filename = str;
        }

        public void setSize(int i5) {
            this.size = i5;
        }

        public void setType(String str) {
            this.type = str;
        }

        public String toString() {
            return "Attachment{type='" + this.type + "', filename='" + this.filename + "', size=" + this.size + '}';
        }

        public Attachment(String str, String str2, String str3, int i5) {
            this.type = str;
            this.filename = str2;
            this.data = str3;
            this.size = i5;
        }
    }

    public Message() {
    }

    public int getAttachmentCount() {
        return this.attachmentCount;
    }

    public List<Attachment> getAttachments() {
        return this.attachments;
    }

    public String getCreatedAt() {
        return this.createdAt;
    }

    public String getDisplayFromName() {
        if (!isTeamMessage()) {
            return this.fromCallsign;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.fromCallsign);
        sb.append(" (Teams: ");
        return h.e(sb, this.teamId, ")");
    }

    public String getDisplaySubject() {
        String str = this.subject;
        if (str == null) {
            str = "No Subject";
        }
        return this.isHighSensitivity ? h.s("🔒 ", str) : str;
    }

    public String getDisplayTime() {
        return this.displayTime;
    }

    public String getFromCallsign() {
        return this.fromCallsign;
    }

    public int getId() {
        return this.id;
    }

    public int getImageCount() {
        return this.imageCount;
    }

    public String getMessageBody() {
        return this.messageBody;
    }

    public String getMessageType() {
        return this.messageType;
    }

    public String getPreviewText() {
        return this.previewText;
    }

    public String getPriority() {
        return this.priority;
    }

    public String getReadAt() {
        return this.readAt;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getTeamId() {
        return this.teamId;
    }

    public String getToCallsign() {
        return this.toCallsign;
    }

    public boolean isDeleted() {
        return this.isDeleted;
    }

    public boolean isHasAttachments() {
        return this.hasAttachments;
    }

    public boolean isHighSensitivity() {
        return this.isHighSensitivity;
    }

    public boolean isRead() {
        return this.isRead;
    }

    public boolean isTeamMessage() {
        String str = this.teamId;
        return (str == null || str.trim().isEmpty()) ? false : true;
    }

    public boolean requiresSecureHandling() {
        return this.isHighSensitivity;
    }

    public void setAttachmentCount(int i5) {
        this.attachmentCount = i5;
    }

    public void setAttachments(List<Attachment> list) {
        this.attachments = list;
    }

    public void setCreatedAt(String str) {
        this.createdAt = str;
    }

    public void setDeleted(boolean z4) {
        this.isDeleted = z4;
    }

    public void setDisplayTime(String str) {
        this.displayTime = str;
    }

    public void setFromCallsign(String str) {
        this.fromCallsign = str;
    }

    public void setHasAttachments(boolean z4) {
        this.hasAttachments = z4;
    }

    public void setHighSensitivity(boolean z4) {
        this.isHighSensitivity = z4;
    }

    public void setId(int i5) {
        this.id = i5;
    }

    public void setImageCount(int i5) {
        this.imageCount = i5;
    }

    public void setMessageBody(String str) {
        this.messageBody = str;
    }

    public void setMessageType(String str) {
        this.messageType = str;
    }

    public void setPreviewText(String str) {
        this.previewText = str;
    }

    public void setPriority(String str) {
        this.priority = str;
    }

    public void setRead(boolean z4) {
        this.isRead = z4;
    }

    public void setReadAt(String str) {
        this.readAt = str;
    }

    public void setSubject(String str) {
        this.subject = str;
    }

    public void setTeamId(String str) {
        this.teamId = str;
    }

    public void setToCallsign(String str) {
        this.toCallsign = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Message{id=");
        sb.append(this.id);
        sb.append(", toCallsign='");
        sb.append(this.toCallsign);
        sb.append("', fromCallsign='");
        sb.append(this.fromCallsign);
        sb.append("', subject='");
        sb.append(this.subject);
        sb.append("', messageType='");
        sb.append(this.messageType);
        sb.append("', priority='");
        sb.append(this.priority);
        sb.append("', isRead=");
        sb.append(this.isRead);
        sb.append(", isHighSensitivity=");
        sb.append(this.isHighSensitivity);
        sb.append(", hasAttachments=");
        sb.append(this.hasAttachments);
        sb.append(", attachmentCount=");
        sb.append(this.attachmentCount);
        sb.append(", createdAt='");
        return h.e(sb, this.createdAt, "'}");
    }

    public Message(int i5, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z4, boolean z5) {
        this.id = i5;
        this.teamId = str;
        this.toCallsign = str2;
        this.fromCallsign = str3;
        this.subject = str4;
        this.messageBody = str5;
        this.messageType = str6;
        this.priority = str7;
        this.isRead = z4;
        this.isHighSensitivity = z5;
    }
}
