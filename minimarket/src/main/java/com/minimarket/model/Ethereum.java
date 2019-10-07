package com.minimarket.model;

/**
 * @author ronjod
 * @create 2019-10-07 20:19
 */
public class Ethereum {
    String address;
    String token;

    public Ethereum(String address, String token) {
        this.address = address;
        this.token = token;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "Ethereum{" +
                "address='" + address + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
