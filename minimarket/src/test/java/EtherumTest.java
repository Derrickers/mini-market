import com.minimarket.service.transactionRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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
}
