package com.minimarket.utils;

import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

/**
 * @author ronjod
 * @create 2019-10-06 20:29
 */
public class Initial {
    private static Web3j web3j;

    private Initial() {
    }

    public static synchronized Web3j getWeb3j() {
        if (web3j == null) {
            web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/826618f408214f28a0c5b030860341fe"));
        }
        return web3j;
    }
}
