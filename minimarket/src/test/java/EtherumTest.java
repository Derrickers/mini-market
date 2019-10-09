import com.minimarket.model.transactionRecord;
import com.minimarket.service.transactionRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;

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
    public void Test2() throws Exception {
        //  userMission userMission = new userMission();
        // userMission.setID("12");
//        String res = dao.selectReceiver(userMission);
//        System.out.println(res);
        transactionRecord t = new transactionRecord();
        t.setTransOutUser("UTC--2019-10-04T12-41-16.567558100Z--42c35e4a5232ddc3179e8bcd5125f203d0d1a7ed");
        t.setTransInUser("UTC--2019-10-07T13-45-26.973000000Z--0ef027aec5d7cf3f6bf0c8ea0ace89d4467978d2.json");
        t.setMissionId("1111");
        t.setMissionName("qqqq");
        t.setAmount(BigInteger.valueOf(1000000l));
        eser.insertTransactionRecord(t);
    }
}
