package com.guide_finder.dto;

import java.util.Objects;

public class UserCoordsDto {
    private long id;
    private String firstname;
    private String lastname;
    private double latitude;
    private double longitude;

    public UserCoordsDto(long id, String firstname, String lastname, double latitude, double longitude) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public long getId() {
        return id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "UserCoordsDto{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserCoordsDto that = (UserCoordsDto) o;
//        return id == that.id &&
//                Double.compare(that.latitude, latitude) == 0 &&
//                Double.compare(that.longitude, longitude) == 0;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, latitude, longitude);
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserCoordsDto that = (UserCoordsDto) o;
        return id == that.id &&
                Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0 &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, firstname, lastname, latitude, longitude);
    }
}
