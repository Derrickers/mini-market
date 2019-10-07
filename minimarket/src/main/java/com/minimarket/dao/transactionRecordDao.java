package com.minimarket.dao;

import com.minimarket.model.transactionRecord;

import java.util.List;

/**
 * @author ronjod
 * @create 2019-10-07 10:19
 */
public interface transactionRecordDao {

    int insertTransRecord();

    List<transactionRecord> selectTransRecord();
}
