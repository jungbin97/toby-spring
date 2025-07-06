package springbook.step1_4.user.dao;

import springbook.step1_3.user.dao.ConnectionMaker;

public class AccountDao {
    private ConnectionMaker connectionMaker;

    public AccountDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

}
