package springbook.step1_7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springbook.step1_3.user.dao.DataSource;
import springbook.step1_3.user.dao.DConnectionMaker;
import springbook.step1_3.user.dao.UserDao;

@Configuration
public class CountingDaoFactory {
    @Bean
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    @Bean
    public DataSource connectionMaker() {
        return new ConutingConnectionMaker(realConnectionMaker());
    }

    @Bean
    public DataSource realConnectionMaker() {
        return new DConnectionMaker();
    }
}
