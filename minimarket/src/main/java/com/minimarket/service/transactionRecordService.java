package com.minimarket.service;

import com.minimarket.model.ReturnMsg;
import com.minimarket.model.transactionRecord;
import org.web3j.crypto.CipherException;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author ronjod
 * @create 2019-10-06 19:01
 */
public interface transactionRecordService {
    List<String> createAccount(String password) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException;//创建账号
    String getBalance(String address) throws ExecutionException, InterruptedException;//获取余额
    ReturnMsg getTransactionRecord(String address);//查询交易记录
    ReturnMsg insertTransactionRecord(transactionRecord temp) throws ExecutionException, InterruptedException;//插入交易记录

}
