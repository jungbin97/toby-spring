package springbook.step1_8;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserDaoTest {
    public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
        UserDao bean1 = context.getBean(UserDao.class);
        UserDao bean2 = context.getBean(UserDao.class);

        System.out.println("bean1 = " + bean1);
        System.out.println("bean2 = " + bean2);
    }
}
