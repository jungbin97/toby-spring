package springbook.step1_5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook.step1_3.user.dao.ConnectionMaker;
import springbook.step1_3.user.dao.DConnectionMaker;
import springbook.step1_3.user.dao.UserDao;
import springbook.step1_4.user.dao.AccountDao;
import springbook.step1_4.user.dao.MessageDao;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    @Bean
    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    @Bean
    public ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
