import com.alibaba.fastjson.JSONObject;
import com.minimarket.dao.MissionDao;
import com.minimarket.model.Mission;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.User;
import com.minimarket.model.userMission;
import com.minimarket.service.MissionService;
import com.minimarket.service.userMissionService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.minimarket.utils.HttpUtil.doPost;

/**
 * @author ronjod
 * @create 2019-09-27 15:11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class MissionDaoTest {

    @Autowired
    private MissionDao mdao;
    @Autowired
    private MissionService mser;
    @Autowired
    private userMissionService umser;
    @Test
    public void testSelectMission() throws Exception {
          userMission userMission = new userMission();
         userMission.setID(3l);
         userMission.setPoster("110");
//        String res = dao.selectReceiver(userMission);
//        System.out.println(res);
        ReturnMsg returnMsg = umser.selectReceiver(userMission);
        System.out.println(returnMsg);
    }

    //a)	查询当前可以接取的全部任务
    @Test
    public void testSelectMissionListAll() throws Exception {
        userMission u = new userMission();
        u.setReceiver("2");
        ReturnMsg list = mser.selectMissionListAll(u);
        System.out.println(list);
    }

    @Test
    public void httpSelectMissionListAllTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionListAll";
        JSONObject json = new JSONObject();
        json.put("Receiver","2");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

    //b)	查询当前个人发布的全部任务
    @Test
    public void testSelectMissionListUpload() throws Exception {
        Mission mission = new Mission();
        mission.setOwner("888");

        List<Mission> list = mdao.selectMissionListUpload(mission);
        System.out.println(list);
    }

    @Test
    public void httpSelectMissionListUploadTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionListUpload";
        JSONObject json = new JSONObject();
        json.put("Owner", "888");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

    //测试c)查询当前个人接取的全部任务
    @Test
    public void testSelectMissionListGet() throws Exception {
        User user = new User();
        user.setID("3");
        List<Mission> list = mdao.selectMissionListGet(user);
        System.out.println(list);
//        ReturnMsg returnMsg = mser.selectMissionListGet(user);
//        System.out.println(returnMsg);
    }

    @Test
    public void httpSelectMissionListGetTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionListGet";
        JSONObject json = new JSONObject();
        json.put("ID", "101");

        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

    //d)	查询某个任务具体信息
    @Test
    public void testSelectMissionInfo() throws Exception {
        Mission mission = new Mission();
        mission.setID(3);
        List<Mission> list = mdao.selectMissionInfo(mission);
//        ReturnMsg list = mser.selectMissionInfo(mission);

        System.out.println(list);
    }

    @Test
    public void httpSelectMissionInfo() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionInfo";
        JSONObject json = new JSONObject();
        json.put("ID", "1");

        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

}
