package com.studentcui.hotel.po;

public class Room {
    private int id;
    private String type;
    private String state;
    private String guestname;
    private String getGuestid;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public String getGetGuestid() {
        return getGuestid;
    }

    public void setGetGuestid(String getGuestid) {
        this.getGuestid = getGuestid;
    }
}
