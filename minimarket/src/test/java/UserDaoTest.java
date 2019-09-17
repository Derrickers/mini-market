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

/**
 * @author ronjod
 * @create 2019-09-12 13:49
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class UserDaoTest {
    private static final Logger logger= LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserDao dao;

    @Test
    public void testSelectUser() throws Exception {
        User user =new User();
        user.setID("1");

        user.setPassword("123");
        User user1 = dao.selectUser(user);
        System.out.println(user1);
    }
}
