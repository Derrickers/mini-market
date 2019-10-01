import com.alibaba.fastjson.JSONObject;
import com.minimarket.dao.MissionDao;
import com.minimarket.dao.userMissionDao;
import com.minimarket.model.Mission;
import com.minimarket.model.ReturnMsg;
import com.minimarket.service.MissionService;
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
public class MissionDaoTest2 {
    @Autowired
    private userMissionDao dao;
    @Autowired
    private MissionDao mdao;
    @Autowired
    private MissionService mser;

    //插入任务
    @Test
    public void testInsertMission() throws Exception {
        //  userMission userMission = new userMission();
        // userMission.setID("12");
//        String res = dao.selectReceiver(userMission);
//        System.out.println(res);
        ReturnMsg returnMsg = mser.selectMissionListAll();
        System.out.println(returnMsg);
    }

    @Test
    public void httpInsertMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionListGet";
        JSONObject json = new JSONObject();
        json.put("ID", "2");

        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
    //更新任务
    @Test
    public void UpdateMissionTest() throws Exception {
        Mission mission = new Mission();
        mission.setOwner("1");

        List<Mission> list = mdao.selectMissionListUpload(mission);
        System.out.println(list);
    }


    @Test
    public void httpUpdateMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionListAll";
        JSONObject json = new JSONObject();
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }



    //删除任务
    @Test
    public void testDeleteMission() throws Exception {
        List<Mission> list = mdao.selectMissionListAll();
        System.out.println(list);
    }
    @Test
    public void httpDeleteMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionListUpload";
        JSONObject json = new JSONObject();
        json.put("Owner", "1");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
    //插入关系任务
    @Test
    public void acceptMissionTest() throws Exception {
        List<Mission> list = mdao.selectMissionListAll();
        System.out.println(list);
    }
    @Test
    public void httpAcceptMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionListUpload";
        JSONObject json = new JSONObject();
        json.put("Owner", "1");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
    //删除关系任务
    @Test
    public void abortMissionTest() throws Exception {
        List<Mission> list = mdao.selectMissionListAll();
        System.out.println(list);
    }
    @Test
    public void httpAbortMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/selectMissionListUpload";
        JSONObject json = new JSONObject();
        json.put("Owner", "1");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
}
