package springbook.step1_4.user.dao;

import springbook.step1_3.user.dao.DataSource;

public class MessageDao {
    private DataSource connectionMaker;

    public MessageDao(DataSource connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
