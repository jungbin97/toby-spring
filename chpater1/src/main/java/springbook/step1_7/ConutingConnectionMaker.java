package springbook.step1_7;

import springbook.step1_3.user.dao.ConnectionMaker;

import java.sql.Connection;
import java.sql.SQLException;

public class ConutingConnectionMaker implements ConnectionMaker {
    int counter = 0;
    private ConnectionMaker realConnectionMaker;

    public ConutingConnectionMaker(ConnectionMaker realConnectionMaker) {
        this.realConnectionMaker = realConnectionMaker;
    }


    @Override
    public Connection makeNewConnection() throws ClassNotFoundException, SQLException {
        this.counter++;

        return realConnectionMaker.makeNewConnection();
    }

    public int getCounter() {
        return counter;
    }
}
