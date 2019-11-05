import com.alibaba.fastjson.JSONObject;
import com.minimarket.controller.transactionRecordController;
import com.minimarket.dao.MissionDao;
import com.minimarket.dao.transactionRecordDao;
import com.minimarket.dao.userMissionDao;
import com.minimarket.model.Mission;
import com.minimarket.model.ReturnMsg;
import com.minimarket.model.transactionRecord;
import com.minimarket.model.userMission;
import com.minimarket.service.MissionService;
import com.minimarket.service.transactionRecordService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigInteger;
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
    @Autowired
    private transactionRecordDao tdao;
    @Autowired
    private transactionRecordService eser;

    //插入任务
    @Test
    public void testInsertMission() throws Exception {
        Mission mission = new Mission();
       // mission.setID("000test1");
        mission.setName("new");
        mission.setOwner("test2");
        mission.setTab("ttt");
        mission.setLevel(5);
        mission.setBrief("测试任务");
        mission.setQuota(2);
        mission.setSDate("20000101");
        mission.setEDate("20000303");
        mission.setReward(10);
        mission.setCredit(88);
   //     int res = mdao.insertMission(mission);
   //     System.out.println(res);
//        String res = dao.selectReceiver(userMission);
//        System.out.println(res);
        ReturnMsg returnMsg = mser.insertMission(mission);
        System.out.println(returnMsg);
    }

    @Test
    public void httpInsertMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/insertMission";
        JSONObject json = new JSONObject();
        json.put("Name", "11nnnn");
        json.put("Owner", "00test");
        json.put("Tab", "000test");
        json.put("Level", 1);
        json.put("accNum", 1);
        json.put("Brief", "000test");
        json.put("Quota", 20000101);
        json.put("SDate", "20000101");
        json.put("EDate", "20000303");
        json.put("Credit", 88);
        json.put("Reward",10);
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

    //更新任务
    @Test
    public void UpdateMissionTest() throws Exception {
        Mission mission = new Mission();
        mission.setID(2);
        mission.setBrief("cecece");
        mission.setStatus(1);
        mission.setReward(1000);
//        int res = mdao.updateMission(mission);
        ReturnMsg res = mser.updateMission(mission);

        System.out.println(res);
    }

    @Test
    public void httpUpdateMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/updateMission";
        JSONObject json = new JSONObject();
        json.put("ID", 1);
        json.put("Name", "iu");
//        json.put("Tab", "000test");
//        json.put("Level", 1);
        json.put("Brief", 1);
//        json.put("Quota", 1);
//        json.put("EDate", 1);
        json.put("Reward", 1);
//        json.put("Credit", 1);
//        json.put("accNum", 1);
//        json.put("Status", 1);
//        json.put("Complete", 1);





        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

    //删除任务
    @Test
    public void testDeleteMission() throws Exception {
        Mission mission = new Mission();
        mission.setID(1);
        int res = mdao.deleteMission(mission);
        System.out.println(res);
    }

    @Test
    public void httpDeleteMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/mission/deleteMission";
        JSONObject json = new JSONObject();
        json.put("ID", "9");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

    //插入关系任务
    @Test
    public void acceptMissionTest() throws Exception {
        userMission usermission = new userMission();
        usermission.setReceiver("test1");
        usermission.setPoster("test2");
        usermission.setID(1);
        usermission.setTime("20000202");
        int res = dao.acceptMission(usermission);
        System.out.println(res);
    }

    @Test
    public void httpAcceptMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/userMission/acceptMission";
        JSONObject json = new JSONObject();
        json.put("Receiver", "test1");
        json.put("Poster", "test2");
        json.put("ID", 15);
        json.put("Time", "20000202");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }

    //删除关系任务
    @Test
    public void abortMissionTest() throws Exception {
        userMission usermission = new userMission();
        usermission.setID(1);
        int res = dao.abortMission(usermission);
        System.out.println(res);
    }

    @Test
    public void httpAbortMissionTest() throws Exception {
        String url = "http://localhost:8080/minimarket/userMission/abortMission";
        JSONObject json = new JSONObject();
        json.put("ID", "1");
        json.put("Receiver", "888");
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }


    @Test
    public void httpUpdateMissionStatusTest() throws Exception {
        String url = "http://localhost:8080/minimarket/userMission/updateMission";
        JSONObject json = new JSONObject();
        json.put("ID", "1");
        json.put("Receiver", "test1");
//        json.put("Poster", "test2");

        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
//
//    @Test
//    public void testHttpRegister() throws Exception {
//        String url = "http://localhost:8080/minimarket/transactionRecord/getTransactionRecord";
//        JSONObject json = new JSONObject();
//        json.put("ID", "17");
//        json.put("password", "licheng");
//        json.put("nickName", "zzz");
//        json.put("realName", "rrr");
//        json.put("identityNum", "888462823743273");
//        json.put("gender", "1");
//        //get 请求
////        String ret = getSerchPersion(url, json.toString());
////        System.out.println(ret);
////        JSONObject jsonResponse=JSONObject.fromObject(param);
////        JSONObject json = (JSONObject)jsonResponse.get("page");
////        System.out.println(json.get("pageSize"));
//
//        //post 请求
//        JSONObject jsonObject = doPost(url, json);
//        System.out.println(jsonObject.toString());
//    }




}

