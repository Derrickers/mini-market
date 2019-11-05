package com.minimarket.dao;

import com.minimarket.model.transactionRecord;

import java.util.List;

/**
 * @author ronjod
 * @create 2019-10-07 10:19
 */
public interface transactionRecordDao {

    int insertTransRecord(transactionRecord transactionRecord);

    List<transactionRecord> selectTransRecord(transactionRecord transactionRecord);

    String getPasswordByAddress(String address);

}
