package springbook.step1_4;

import springbook.step1_3.user.dao.ConnectionMaker;
import springbook.step1_3.user.dao.DConnectionMaker;
import springbook.step1_3.user.dao.UserDao;
import springbook.step1_4.user.dao.AccountDao;
import springbook.step1_4.user.dao.MessageDao;

public class DaoFactory {
    public UserDao userDao() {
        return new UserDao(connectionMaker());
    }

    public AccountDao accountDao() {
        return new AccountDao(connectionMaker());
    }

    public MessageDao messageDao() {
        return new MessageDao(connectionMaker());
    }

    private ConnectionMaker connectionMaker() {
        return new DConnectionMaker();
    }
}
