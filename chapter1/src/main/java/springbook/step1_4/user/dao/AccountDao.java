package springbook.step1_4.user.dao;

import springbook.step1_3.user.dao.DataSource;

public class AccountDao {
    private DataSource connectionMaker;

    public AccountDao(DataSource connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

}
