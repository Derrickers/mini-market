package com.minimarket.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.abi.FunctionEncoder;
import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Address;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.abi.datatypes.generated.Uint256;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.RawTransaction;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.admin.Admin;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.Transaction;
import org.web3j.protocol.core.methods.response.EthCall;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.utils.Numeric;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

/**
 * @author LiCheng
 * @PackageName:eth
 * @ClassName:demo
 * @Description:
 * @date 2019/10/3 20:30
 */
public class demo {
    private static Logger logger = LoggerFactory.getLogger(demo.class);

    public static void main(String[] args) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/826618f408214f28a0c5b030860341fe"));
        Admin admin = Admin.build(new HttpService("https://ropsten.infura.io/v3/826618f408214f28a0c5b030860341fe"));

        //方法一
//        Web3j web3j = Web3j.build(new HttpService("https://rinkeby.infura.io/v3/826618f408214f28a0c5b030860341fe"));
//        Admin admin = Admin.build(new HttpService("https://rinkeby.infura.io/v3/826618f408214f28a0c5b030860341fe"));
//        //logger.info("Connected to Ethereum client version: "+ web3j.web3ClientVersion().send().getWeb3ClientVersion());
//        Web3ClientVersion web3ClientVersion = web3j.web3ClientVersion().send();
//        System.out.println(web3ClientVersion.getWeb3ClientVersion());
//        try {
//            NewAccountIdentifier newAccountIdentifier = admin.personalNewAccount(password).send();
//            logger.info("创建ETH账户成功,账户id = {}",newAccountIdentifier.getAccountId());
//            return newAccountIdentifier.getAccountId();
//        } catch (IOException e) {
//            logger.error("创建ETH账户失败，错误信息：{}",e);
//            return null;
//        }
        // 方法二
        String walletFileName = "";
        String password = "licheng";
        String walletFilePath = "E:\\wallet\\";
        //walletFileName = WalletUtils.generateNewWalletFile(password, new File(walletFilePath));
        System.out.println("walletName: " + walletFileName);

//        Credentials credentials = WalletUtils.loadCredentials(password, walletFilePath+"UTC--2019-10-03T12-45-10.835000000Z--8542474125bc2a3a302ccdff3a395a6e2e57430b.json");
        Credentials credentials = WalletUtils.loadCredentials(password, walletFilePath + "UTC--2019-10-04T12-41-16.567558100Z--42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed");
        String address = credentials.getAddress();
        String publicKey = credentials.getEcKeyPair().getPublicKey().toString(16);
        String privateKey = credentials.getEcKeyPair().getPrivateKey().toString(16);
        System.out.println(address + "\n" + publicKey + "\n" + privateKey);
        // EthGetBalance ethGetBalance = web3j.ethGetBalance(address, DefaultBlockParameterName.LATEST).send();
        // System.out.println("124"+ethGetBalance);
//        System.out.println(test2());

//        test9();

    }

    public static void test6() throws IOException, ExecutionException, InterruptedException {

        //调用的是kovan测试环境，这里使用的是infura这个客户端
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/826618f408214f28a0c5b030860341fe"));

//        EthTransaction ethTransaction = web3j.ethGetTransactionByHash("0x60aba945322cb251443f4ccf6b2b7ee82ea4bae926e9f5fcf9d61065bcb479ca").sendAsync().get().toString();
//logger.info("是{}",web3j.ethGetTransactionByHash("0x60aba945322cb251443f4ccf6b2b7ee82ea4bae926e9f5fcf9d61065bcb479ca").sendAsync().get().getResult().getFrom());
//logger.info("是{}",web3j.ethGetTransactionByHash("0xfab91233478e4bd131c6d5e949a483a60738230db39a5fadc510edc6d16ee563").sendAsync().get().getResult().getFrom());
//logger.info("是{}",web3j.ethGetTransactionByHash("0xcf993fbbbb4f298b71ad68bae912785e3ebd19da4aa07094d42c3b6e6cf86000").sendAsync().get().getResult().getFrom());
        logger.info("是{}", web3j.ethGetTransactionByHash("0x556d5f5fa5e2e46787dec750bfdffc58e96022603bfcc071497ff896459ee420").sendAsync().get().getResult().getFrom());

//        if(ethTransaction!=null){
//// 打印账户余额
//            System.out.println(transaction);
//// 将单位转为以太，方便查看
//
//        }
    }

    //    public static String test7() throws IOException, CipherException, ExecutionException, InterruptedException {
//        String password ="licheng";
//        String filePath="E:\\Ethereum\\rinkeby\\keystore\\UTC--2019-10-04T12-41-16.567558100Z--42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed";
//        String path="E:\\Ethereum\\rinkeby\\keystore\\UTC--2019-10-04T12-41-16.567558100Z--42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed";
//        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/826618f408214f28a0c5b030860341fe"));
////        String contractAddress="0x348f4392386ca41578018301c27fe960e4c35501";
////        String to="0x18ca8eb9166704854e823dd30415faf4f9e58439";
//        String contractAddress="0x18ca8eb9166704854e823dd30415faf4f9e58439";
//        String to="0x348f4392386ca41578018301c27fe960e4c35501";
//
//        EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount(
//                "0x42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed", DefaultBlockParameterName.LATEST).sendAsync().get();
//        BigInteger amount = ethGetTransactionCount.getTransactionCount();
//        try {
//            Credentials creds = WalletUtils.loadCredentials(password,filePath);
//            RawTransactionManager manager = new RawTransactionManager(web3j, creds);
//            String data = encodeTransferData(to, amount);
//            BigInteger gasPrice = BigInteger.valueOf(22_000_000_000L);
//            BigInteger gasLimit = BigInteger.valueOf(4_300_000);
//            EthSendTransaction transaction = manager.sendTransaction(gasPrice, gasLimit, contractAddress, data, BigInteger.valueOf(100000));
//            if (transaction.hasError()){
//                logger.error("转账失败，失败原因：{}",transaction.getError().getMessage());
//                return null;
//            }
//            logger.info("转账hash={}",transaction.getTransactionHash());
//            return transaction.getTransactionHash();
//        }catch (Exception e){
//            logger.error("转账失败，失败原因：{}",e);
//            return null;
//        }
//
//    }
//    private static String encodeTransferData(String toAddress, BigInteger sum) {
//        Function function = new Function(
//                "transfer",
//                Arrays.<Type>asList(new AddressUtil(toAddress),
//                        new Uint256(sum)),
//                Collections.<TypeReference<?>>emptyList());
//        return FunctionEncoder.encode(function);
//    }
    private static void test8() throws Exception {
        String from = "0x42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed";
        String contractAddress = "0x348f4392386ca41578018301c27fe960e4c35501";
        String to = "0x18ca8eb9166704854e823dd30415faf4f9e58439";//10000=1
        System.out.println(transferERC20Token(from, to, BigInteger.valueOf(1000000), "838803d2fca2fea9389944f4073ab004a8f915dd22968420ebfc81c58b8338f2", contractAddress));
    }

    public static EthSendTransaction transferERC20Token(String from,
                                                        String to,
                                                        BigInteger value,
                                                        String privateKey,
                                                        String contractAddress) throws Exception {
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/826618f408214f28a0c5b030860341fe"));

        //加载转账所需的凭证，用私钥
        Credentials credentials = Credentials.create(privateKey);
        //获取nonce，交易笔数
        BigInteger nonce = getNonce(from);
        //get gasPrice
        BigInteger gasPrice = BigInteger.valueOf(22_000_000_000L);
        BigInteger gasLimit = Contract.GAS_LIMIT;

        //创建RawTransaction交易对象
        Function function = new Function(
                "transfer",
                Arrays.asList(new Address(to), new Uint256(value)),
                Arrays.asList(new TypeReference<Type>() {
                }));

        String encodedFunction = FunctionEncoder.encode(function);

        RawTransaction rawTransaction = RawTransaction.createTransaction(nonce,
                gasPrice,
                gasLimit,
                contractAddress, encodedFunction);

        //签名Transaction，这里要对交易做签名
        byte[] signMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
        String hexValue = Numeric.toHexString(signMessage);
        //发送交易
        EthSendTransaction ethSendTransaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();
        return ethSendTransaction;
    }

    private static BigInteger getNonce(String from) throws ExecutionException, InterruptedException {
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/826618f408214f28a0c5b030860341fe"));
        EthGetTransactionCount transactionCount = web3j.ethGetTransactionCount(from, DefaultBlockParameterName.LATEST).sendAsync().get();
        BigInteger nonce = transactionCount.getTransactionCount();
        return nonce;
    }

    public static String getERC20Balance(String address, String contractAddress) throws ExecutionException, InterruptedException {
        Function function = new Function("balanceOf",
                Arrays.asList(new Address(address)),
                Arrays.asList(new TypeReference<Address>() {
                }));
        Web3j web3j = Web3j.build(new HttpService("https://ropsten.infura.io/v3/826618f408214f28a0c5b030860341fe"));

        String encode = FunctionEncoder.encode(function);
        logger.info("getERC20Balance encode : " + encode);
        Transaction ethCallTransaction = Transaction.createEthCallTransaction(address, contractAddress, encode);
        EthCall ethCall = web3j.ethCall(ethCallTransaction, DefaultBlockParameterName.LATEST).sendAsync().get();
        String value = ethCall.getResult();
        logger.info("getERC20Balance balance : " + value);
        return value;
    }

    public static void test9() throws ExecutionException, InterruptedException {
        getERC20Balance("0x42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed", "0x348f4392386ca41578018301c27fe960e4c35501");
    }
}
