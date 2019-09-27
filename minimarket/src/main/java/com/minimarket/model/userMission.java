package com.minimarket.model;

/**
 * @author ronjod
 * @create 2019-09-27 15:44
 */
public class userMission {
    private String Receiver;
    private String Poster;
    private String ID;
    private String Time;

    public String getReceiver() {
        return Receiver;
    }

    public void setReceiver(String receiver) {
        Receiver = receiver;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    @Override
    public String toString() {
        return "userMission{" +
                "Receiver='" + Receiver + '\'' +
                ", Poster='" + Poster + '\'' +
                ", ID='" + ID + '\'' +
                ", Time='" + Time + '\'' +
                '}';
    }
}
