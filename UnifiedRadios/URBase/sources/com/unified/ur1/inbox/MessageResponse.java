package com.unified.ur1.inbox;

import java.util.List;

/* loaded from: classes.dex */
public class MessageResponse {
    private String message;
    private List<Message> messages;
    private boolean success;
    private int total_count;
    private int unread_count;

    public String getMessage() {
        return this.message;
    }

    public List<Message> getMessages() {
        return this.messages;
    }

    public int getTotalCount() {
        return this.total_count;
    }

    public int getUnreadCount() {
        return this.unread_count;
    }

    public boolean isSuccess() {
        return this.success;
    }
}
