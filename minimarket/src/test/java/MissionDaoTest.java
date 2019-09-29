import com.alibaba.fastjson.JSONObject;
import com.minimarket.dao.userMissionDao;
import com.minimarket.model.userMission;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.minimarket.utils.HttpUtil.doPost;

/**
 * @author ronjod
 * @create 2019-09-27 15:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class MissionDaoTest {
    @Autowired
    private userMissionDao dao;
    @Test
public void  testSelectMission() throws Exception {
        userMission userMission = new userMission();
        userMission.setID("12");
        String res = dao.selectReceiver(userMission);
        System.out.println(res);
    }
    @Test
    public void  httpSelectMissionTest() throws Exception {
        //userMission userMission = new userMission();
        String url="http://localhost:8080/minimarket/mission/selectMissionListAll";
        JSONObject json=new JSONObject();
        json.put("ID","12");

        JSONObject jsonObject = doPost(url,json);
        System.out.println(jsonObject.toString());
    }

}
