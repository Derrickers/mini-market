package com.minimarket.service;

import com.minimarket.model.ReturnMsg;

/**
 * @author ronjod
 * @create 2019-10-06 19:01
 */
public interface transactionRecordService {
    String createAccount(String password);//创建账号
    String getBalance(String password);//获取余额
    ReturnMsg getTransactionRecord(String address);//查询交易记录
    ReturnMsg insertTransactionRecord(String address);//插入交易记录




}
