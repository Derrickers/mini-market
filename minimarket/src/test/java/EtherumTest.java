import com.minimarket.model.ReturnMsg;
import com.minimarket.model.transactionRecord;
import com.minimarket.service.transactionRecordService;
import com.minimarket.utils.AddressUtil;
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
    @Test
    public void testInsertTransactionRecord() throws Exception {
        BigInteger a = new BigInteger("20000");
        transactionRecord t = new transactionRecord();
//        t.setTransOutUser("UTC--2019-10-04T12-41-16.567558100Z--42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed");
//        t.setTransInUser("UTC--2019-10-09T01-58-56.295000000Z--c3e21322799fdc85ea4be399a172f7c1c74eba41.json");
        t.setTransInUser("UTC--2019-10-12T10-32-31.227000000Z--43bd3b8939952255b865e55708f3ab369c29a12c.json");
        t.setTransOutUser("UTC--2019-10-11T05-31-39.549000000Z--87216b60478d5bb5ad5ec8f53ccc71e320fd7e48.json");
        t.setMissionId("1111");

        t.setMissionName("qqqq");
        t.setAmount(a);
        ReturnMsg res = eser.insertTransactionRecord(t);
        System.out.println(res);
    }
    @Test
    public void temp() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, CipherException, IOException, ExecutionException, InterruptedException {
        String filePath = "E:\\wallet\\";
        String fileName = "UTC--2019-10-11T05-30-52.173000000Z--0a47e501c822c3aab10f05ecaeaee15f32137ebe.json";
        String fileName2 = WalletUtils.generateNewWalletFile("licheng",new File(filePath));
        Credentials credentials = WalletUtils.loadCredentials("licheng", filePath+""+fileName);
        System.out.println(credentials);
//        eser.transferEth("UTC--2019-10-11T05-31-39.549000000Z--87216b60478d5bb5ad5ec8f53ccc71e320fd7e48.json");
        AddressUtil ad=new AddressUtil();
        //查余额测试
        System.out.println(eser.getBalance(ad.getAddress("UTC--2019-10-12T10-28-05.743000000Z--33dce7b5ab99c61f697361158b93f749dd4dbd4a.json")));
    }

}
