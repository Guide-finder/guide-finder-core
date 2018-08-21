package com.guide_finder.model.comment;

public class Commentary {

    private final long authorId;

    private final long recipientId;

    private String message;

    public Commentary(long authorId, long recipientId, String message) {
        this.authorId = authorId;
        this.recipientId = recipientId;
        this.message = message;
    }

    public long getAuthorId() {
        return authorId;
    }

    public long getRecipientId() {
        return recipientId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
