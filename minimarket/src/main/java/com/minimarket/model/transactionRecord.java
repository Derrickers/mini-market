package com.minimarket.model;

import java.math.BigInteger;

/**
 * @author ronjod
 * @create 2019-10-07 10:22
 */
public class transactionRecord {

    private int index;
    private String transOutUser;
    private String transInUser;
    private String missionId;
    private String missionName;
    private BigInteger amount;

    public String getTransOutUser() {
        return transOutUser;
    }

    public void setTransOutUser(String transOutUser) {
        this.transOutUser = transOutUser;
    }

    public String getTransInUser() {
        return transInUser;
    }

    public void setTransInUser(String transInUser) {
        this.transInUser = transInUser;
    }

    public String getMissionId() {
        return missionId;
    }

    public void setMissionId(String missionId) {
        this.missionId = missionId;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public BigInteger getAmount() {
        return amount;
    }

    public void setAmount(BigInteger amount) {
        this.amount = amount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "transactionRecord{" +
                "transOutUser='" + transOutUser + '\'' +
                ", transInUser='" + transInUser + '\'' +
                ", missionId='" + missionId + '\'' +
                ", missionName='" + missionName + '\'' +
                ", amount=" + amount +
                '}';
    }
}
