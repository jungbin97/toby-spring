package springbook.step1_5;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springbook.step1_3.user.dao.UserDao;

public class UserDaoTest {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao bean = context.getBean(UserDao.class);

        System.out.println("UserDao bean: " + bean);
    }
}
