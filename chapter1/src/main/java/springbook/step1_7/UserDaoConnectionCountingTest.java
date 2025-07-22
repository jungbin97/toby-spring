package springbook.step1_7;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.step1_3.user.dao.UserDao;
import springbook.step1_3.user.domain.User;

public class UserDaoConnectionCountingTest {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CountingDaoFactory.class);
        UserDao dao = context.getBean(UserDao.class);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("123456");

        dao.add(user);

        ConutingConnectionMaker ccm = context.getBean("connectionMaker", ConutingConnectionMaker.class);
        System.out.println("ccm.getCounter() = " + ccm.getCounter());
    }
}
