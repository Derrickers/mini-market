import com.alibaba.fastjson.JSONObject;
import com.minimarket.controller.UserController;
import com.minimarket.dao.UserDao;
import com.minimarket.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @Test
    public void testSelectUser() throws Exception {
        User user = new User();
        user.setID("1");

        user.setPassword("123");
        User user1 = dao.selectUser(user);
        System.out.println(user1);
    }

    @Test
    public void testhttpSelectUser() throws Exception{
        String url="http://localhost:8080/minimarket/user/register";
        JSONObject json=new JSONObject();
        json.put("ID","3");
        json.put("password","12212");
        json.put("nickName","zzz");
        json.put("realName","rrr");
        json.put("identityNum","888462823743273");
        json.put("gender","1");


        //String url = "http://localhost:8080/";

//        JSONObject param = new JSONObject();

        //get 请求
//        String ret = getSerchPersion(url, json.toString());
//        System.out.println(ret);
//        JSONObject jsonResponse=JSONObject.fromObject(param);
//        JSONObject json = (JSONObject)jsonResponse.get("page");
//        System.out.println(json.get("pageSize"));

        //post 请求
        JSONObject jsonObject = doPost(url,json);
        System.out.println(jsonObject.toString());
    }
}
