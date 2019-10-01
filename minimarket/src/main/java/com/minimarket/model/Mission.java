package com.minimarket.model;

/**
 * @author ronjod
 * @create 2019-09-27 15:07
 */
public class Mission {
    private String ID;
    private String Name;
    private int Status;
    private String Tab;
    private String Owner;
    private int Level;
    private String Brief;
    private int Quota;
    private int accNum;
    private String SDate;
    private String EDate;
    private double Reward;
    private double Credit;
    private String Complete;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    public String getTab() {
        return Tab;
    }

    public void setTab(String tab) {
        Tab = tab;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public int getLevel() {
        return Level;
    }

    public void setLevel(int level) {
        Level = level;
    }

    public String getBrief() {
        return Brief;
    }

    public void setBrief(String brief) {
        Brief = brief;
    }

    public int getQuota() {
        return Quota;
    }

    public void setQuota(int quota) {
        Quota = quota;
    }

    public int getAccNum() {
        return accNum;
    }

    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public String getSDate() {
        return SDate;
    }

    public void setSDate(String SDate) {
        this.SDate = SDate;
    }

    public String getEDate() {
        return EDate;
    }

    public void setEDate(String EDate) {
        this.EDate = EDate;
    }

    public double getReward() {
        return Reward;
    }

    public void setReward(double reward) {
        Reward = reward;
    }

    public double getCredit() {
        return Credit;
    }

    public void setCredit(double credit) {
        Credit = credit;
    }

    public String getComplete() {
        return Complete;
    }

    public void setComplete(String complete) {
        Complete = complete;
    }

    @Override
    public String toString() {
        return "Mission{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Status=" + Status +
                ", Tab='" + Tab + '\'' +
                ", Owner='" + Owner + '\'' +
                ", Level=" + Level +
                ", Brief='" + Brief + '\'' +
                ", Quota=" + Quota +
                ", accNum=" + accNum +
                ", SDate='" + SDate + '\'' +
                ", EDate='" + EDate + '\'' +
                ", Reward=" + Reward +
                ", Credit=" + Credit +
                ", Complete='" + Complete + '\'' +
                '}';
    }
}
