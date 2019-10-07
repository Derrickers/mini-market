import com.alibaba.fastjson.JSONObject;
import com.minimarket.controller.UserController;
import com.minimarket.dao.UserDao;
import com.minimarket.model.User;
import com.minimarket.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static com.minimarket.utils.HttpUtil.doPost;

/**
 * @author ronjod
 * @create 2019-09-12 13:49
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao dao;
    @Autowired
    private UserService userv;
    @Test
    public void testSelectUser() throws Exception {
        User user = new User();
        user.setID("1");

        user.setPassword("123");
        List<User> user1 = dao.selectUser(user);
        System.out.println(user1);
    }

    //注册
    @Test
    public void testHttpRegister() throws Exception {
        String url = "http://localhost:8080/minimarket/user/register";
        JSONObject json = new JSONObject();
        json.put("ID", "14");
        json.put("password", "licheng");
        json.put("nickName", "zzz");
        json.put("realName", "rrr");
        json.put("identityNum", "888462823743273");
        json.put("gender", "1");
        //get 请求
//        String ret = getSerchPersion(url, json.toString());
//        System.out.println(ret);
//        JSONObject jsonResponse=JSONObject.fromObject(param);
//        JSONObject json = (JSONObject)jsonResponse.get("page");
//        System.out.println(json.get("pageSize"));

        //post 请求
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
    @Test
    public void testRegister() throws Exception {
        User user = new User();
        user.setID("13");
        user.setPassword("licheng");
        user.setNickName("zzz");
        System.out.println(userv.register(user));
    }
    //查询
    @Test
    public void testHttpSelectUser() throws Exception {
        String url = "http://localhost:8080/minimarket/user/selectUser";
        JSONObject json = new JSONObject();
        json.put("ID", "1");

        //post 请求
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
    //个人信息修改测试
    @Test
    public void httpAccountUpdateTest() throws Exception {
        String url = "http://localhost:8080/minimarket/user/accountUpdate";
        JSONObject json = new JSONObject();
        json.put("ID", "3");
        json.put("NickName","335433");
        //get 请求
//        String ret = getSerchPersion(url, json.toString());
//        System.out.println(ret);
//        JSONObject jsonResponse=JSONObject.fromObject(param);
//        JSONObject json = (JSONObject)jsonResponse.get("page");
//        System.out.println(json.get("pageSize"));

        //post 请求
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
    //密码修改测试
    @Test
    public void httpPasswordUpdateTest() throws Exception {
        String url = "http://localhost:8080/minimarket/user/passwordUpdate";
        JSONObject json = new JSONObject();
        json.put("ID", "1");
        json.put("Password", "123");

        //post 请求
        JSONObject jsonObject = doPost(url, json);
        System.out.println(jsonObject.toString());
    }
}