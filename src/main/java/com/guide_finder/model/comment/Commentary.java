package com.guide_finder.model.comment;

import com.guide_finder.util.TableAnnotation;

import java.util.Objects;

@TableAnnotation(name = "commentary")
public class Commentary {

    private long authorId;

    private String authorName;

    private long recipientId;

    private String message;

    public Commentary(long authorId, long recipientId, String message) {
        this.authorId = authorId;
        this.recipientId = recipientId;
        this.message = message;
    }

    public Commentary(String authorName, String message) {
        this.authorName = authorName;
        this.message = message;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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
