package com.minimarket.service.impl;

import com.minimarket.controller.UserController;
import com.minimarket.model.ReturnMsg;
import com.minimarket.service.transactionRecordService;
import com.minimarket.utils.Initial;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;

import java.io.IOException;

/**
 * @author ronjod
 * @create 2019-10-06 19:03
 */
@Service("ethereumService")
public class transactionRecordServiceImpl implements transactionRecordService {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Override
    public String createAccount(String password)  {
        Web3j web3j= Initial.getWeb3j();

        password = "ronjod201";
        String walletFilePath="E:\\wallet\\";//根据到时候的服务器部署
        //walletFileName = WalletUtils.generateNewWalletFile(password, new File(walletFilePath));
        String walletFileName=walletFilePath+"UTC--2019-10-04T11-50-51.909021000Z--18ca8eb9166704854e823dd30415faf4f9e58439";
        System.out.println("walletName: "+walletFileName);

        Credentials credentials = null;
        try {
            credentials = WalletUtils.loadCredentials(password,walletFileName);
        } catch (IOException e) {
            e.printStackTrace();
            logger.info("文件不存在");
        } catch (CipherException e) {
            e.printStackTrace();
            logger.info("密钥错误");
        }
        String address = credentials.getAddress();
        String publicKey = credentials.getEcKeyPair().getPublicKey().toString(16);
        String privateKey = credentials.getEcKeyPair().getPrivateKey().toString(16);
        System.out.println(address+"\n"+publicKey+"\n"+privateKey);
        //  System.out.println(test2());
        return address;
    }

    @Override
    public String getBalance(String password) {
        return null;
    }

    @Override
    public ReturnMsg getTransactionRecord(String address) {
        return null;
    }

    @Override
    public ReturnMsg insertTransactionRecord(String address) {
        return null;
    }
}
