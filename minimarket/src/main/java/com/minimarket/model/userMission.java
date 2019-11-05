package com.minimarket.model;

/**
 * @author ronjod
 * @create 2019-09-27 15:44
 */
public class userMission {
    private String Receiver;
    private String Poster;
    private long ID;
    private String Time;
    private int Index;
    private int Status;

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

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

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }
    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    @Override
    public String toString() {
        return "userMission{" +
                "Receiver='" + Receiver + '\'' +
                ", Poster='" + Poster + '\'' +
                ", ID=" + ID +
                ", Time='" + Time + '\'' +
                ", Index=" + Index +
                ", Status=" + Status +
                '}';
    }
}
