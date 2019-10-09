package com.minimarket.model;

/**
 * @author ronjod
 * @create 2019-09-12 11:42
 */
public class User {
    private String ID;
    private String Password;
    private String NickName;
    private String RealName;
    private String IDnum;
    private int Gender;
    private String Birthday;
    private String Address;
    private String Tel;
    private String Email;
    private double Credit;
    private String Photo;

    public String getID() {
        return ID;
    }

    public void setID(String iD) {
        ID = iD;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String nickName) {
        NickName = nickName;
    }

    public String getRealName() {
        return RealName;
    }

    public void setRealName(String realName) {
        RealName = realName;
    }

    public String getIDnum() {
        return IDnum;
    }

    public void setIDnum(String iDnum) {
        IDnum = iDnum;
    }

    public int getGender() {
        return Gender;
    }

    public void setGender(int gender) {
        Gender = gender;
    }

    public String getBirthday() {
        return Birthday;
    }

    public void setBirthday(String birthday) {
        Birthday = birthday;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public double getCredit() {
        return Credit;
    }

    public void setCredit(int credit) {
        Credit = credit;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID='" + ID + '\'' +
                ", Password='" + Password + '\'' +
                ", NickName='" + NickName + '\'' +
                ", RealName='" + RealName + '\'' +
                ", IDnum='" + IDnum + '\'' +
                ", Gender=" + Gender +
                ", Birthday='" + Birthday + '\'' +
                ", AddressUtil='" + Address + '\'' +
                ", Tel='" + Tel + '\'' +
                ", Email='" + Email + '\'' +
                ", Credit=" + Credit +
                ", Photo='" + Photo + '\'' +
                '}';
    }
}
