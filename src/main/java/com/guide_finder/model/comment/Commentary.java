package com.guide_finder.model.comment;

import java.util.Objects;

public class Commentary {

    private final long authorId;

    private final long recipientId;

    private boolean rate;

    private String message;

    public Commentary(long authorId, long recipientId, String message, boolean rate) {
        this.authorId = authorId;
        this.recipientId = recipientId;
        this.rate = rate;
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

    public boolean isRate() { return rate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Commentary that = (Commentary) o;
        return authorId == that.authorId &&
                recipientId == that.recipientId &&
                Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {

        return Objects.hash(authorId, recipientId, message);
    }
}
