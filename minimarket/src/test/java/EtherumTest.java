import com.alibaba.fastjson.JSONObject;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.transactionRecord;
import com.minimarket.service.transactionRecordService;
import com.minimarket.utils.AddressUtil;
import com.minimarket.utils.HexChangeString;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.concurrent.ExecutionException;

import static com.minimarket.utils.HttpUtil.doPost;

/**
 * @author ronjod
 * @create 2019-10-06 20:12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class EtherumTest {
    @Autowired
    private transactionRecordService eser;

    @Test
    public void createTest() throws Exception {
        //  userMission userMission = new userMission();
        // userMission.setID("12");
//        String res = dao.selectReceiver(userMission);
//        System.out.println(res);

        eser.createAccount("licheng");
    }
//插入交易任务测试
    @Test
    public void testInsertTransactionRecord() throws Exception {
        BigInteger a = new BigInteger("10000");
        transactionRecord t = new transactionRecord();
//        t.setTransOutUser("UTC--2019-10-04T12-41-16.567558100Z--42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed");
//        t.setTransInUser("UTC--2019-10-09T01-58-56.295000000Z--c3e21322799fdc85ea4be399a172f7c1c74eba41.json");
        t.setTransOutUser("UTC--2019-11-02T07-45-03.546897000Z--7e6a71b95df772c51f886521cd9b86e502b57a87.json");
//        t.setTransOutUser("UTC--2019-10-14T14-17-07.559128000Z--6b784cfef575cfe55debf0479ff8a8fce6128a51.json");
//        t.setID(3l);
        t.setReceiver("101");
        t.setMissionId("3");


//        t.setAmount(a);
        ReturnMsg res = eser.insertTransactionRecord(t);
        System.out.println(res);
    }

    @Test
    public void testInsertTransactionRecordHttp() throws Exception {
        String url = "http://localhost:8080/minimarket/transactionRecord/insertTransactionRecord";
        JSONObject json = new JSONObject();
//        BigInteger a = new BigInteger("10000");
//        json.put("transOutUser", "UTC--2019-10-14T14-13-45.372260000Z--f6dd0926a24aad30bf4ee63aee74da518f123fff.json");
        json.put("transOutUser", "UTC--2019-11-02T07-45-03.546897000Z--7e6a71b95df772c51f886521cd9b86e502b57a87.json");
        json.put("missionId", "3");
        json.put("Receiver", "101");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void temp() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException, ExecutionException, InterruptedException {
        String filePath = "/Users/qishuo/Downloads/block";
        String fileName = "UTC--2019-10-11T05-30-52.173000000Z--0a47e501c822c3aab10f05ecaeaee15f32137ebe.json";
        String fileName2 = WalletUtils.generateNewWalletFile("licheng",new File(filePath));
        Credentials credentials = WalletUtils.loadCredentials("licheng", filePath+""+fileName);
        System.out.println(credentials);
//        eser.transferEth("UTC--2019-10-11T05-31-39.549000000Z--87216b60478d5bb5ad5ec8f53ccc71e320fd7e48.json");
        AddressUtil ad=new AddressUtil();

        //查余额测试

        System.out.println(eser.getBalance(ad.getAddress("UTC--2019-10-12T10-28-05.743000000Z--33dce7b5ab99c61f697361158b93f749dd4dbd4a.json")));
    }
//查询交易记录
    @Test
    public void testSelectTransactionRecordHttp() throws Exception {
        String url = "http://localhost:8080/minimarket/transactionRecord/getTransactionRecord";
        JSONObject json = new JSONObject();
        json.put("missionId", "1111");
        JSONObject jsonObject = doPost(url,json);
        System.out.println(jsonObject.toString());
    }

    @Test
    public void testSelectTransactionRecord() throws Exception {
        //ReturnMsg res = eser.getTransactionRecord("1111");
        //System.out.println(res);
    }
//获取余额
    @Test
    public void testGetBalanceHttp() throws Exception {
        AddressUtil ad=new AddressUtil();
        String url = "http://localhost:8080/minimarket/transactionRecord/getBalance";
        JSONObject json = new JSONObject();
        json.put("address", ad.getAddress("UTC--2019-10-14T14-17-07.559128000Z--6b784cfef575cfe55debf0479ff8a8fce6128a51.json"));
        JSONObject jsonObject = doPost(url,json);
        System.out.println(jsonObject.toString());
    }
    //测试转换
    @Test
    public void testChange() throws ExecutionException, InterruptedException {

        String s = "606060405261014d806100126000396000f3606060405260e060020a6000350463837148348114610029578063d5c6130114610039575b610002565b346100025761009e6004356100b8565b34610002576100d66004808035906020019082018035906020019191908080601f01602080910402602001604051908101604052809392919081815260200183838082843750949650505050505050604080516020810190915260009052805b919050565b60408051918252519081900360200190f35b610144600183035b600081600014806100c95750816001145b156100b057506001610099565b60405180806020018281038252838181518152602001915080519060200190808383829060006004602084601f0104600302600f01f150905090810190601f1680156101365780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b8202905061009956";
String ss=HexChangeString.toStringHex(s);
        System.out.println(ss);
    }
    //查任务id通过区块链
    @Test
    public void getInfoByHash() throws ExecutionException, InterruptedException {

        String Hash1="0xe10d308fba8f93b3e4bab65671a575d091081788d27ec704bc642d05bcf9743e";
        String Hash2="0x38e94a946f4aca8b4ef40a72435af7fd8f0b98d70f302a090964660b0f6e5b20";
        String Hash3="0x9f50f0efbe409de387d1f91357fb53c58f188b13bc5e73d4710f231bfd1d4422";
        String Hash4="0xcee48bbde957216d9c22de81573675e9066051c352a9732eb26da6934639f67f";
        String Hash5="0x9f50f0efbe409de387d1f91357fb53c58f188b13bc5e73d4710f231bfd1d4422";

        eser.getMissionInfoByHash(Hash3);


    }

}
