package springbook.step1_4.user.dao;

import springbook.step1_3.user.dao.ConnectionMaker;

public class MessageDao {
    private ConnectionMaker connectionMaker;

    public MessageDao(ConnectionMaker connectionMaker) {
        this.connectionMaker = connectionMaker;
    }
}
