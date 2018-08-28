package com.guide_finder.model.contact;

import com.guide_finder.util.TableAnnotation;

import java.util.Objects;

@TableAnnotation(name="socialcontact")
public class SocialContact {

    private String vk;

    private String ok;

    private String fb;

    private String tg;

    public SocialContact(String vk, String ok, String fb, String tg) {
        this.vk = vk;
        this.ok = ok;
        this.fb = fb;
        this.tg = tg;
    }

    public String getVk() {
        return vk;
    }

    public void setVk(String vk) {
        this.vk = vk;
    }

    public String getOk() {
        return ok;
    }

    public void setOk(String ok) {
        this.ok = ok;
    }

    public String getFb() {
        return fb;
    }

    public void setFb(String fb) {
        this.fb = fb;
    }

    public String getTg() {
        return tg;
    }

    public void setTg(String tg) {
        this.tg = tg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SocialContact that = (SocialContact) o;
        return Objects.equals(vk, that.vk) &&
                Objects.equals(ok, that.ok) &&
                Objects.equals(fb, that.fb) &&
                Objects.equals(tg, that.tg);
    }

    @Override
    public int hashCode() {

        return Objects.hash(vk, ok, fb, tg);
    }

    @Override
    public String toString() {
        return "VK: " + vk + ", " + "OK: " + ok + "FB: " + fb + "TG: " + tg;
    }
}
