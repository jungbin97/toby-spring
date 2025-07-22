package springbook.step1_7;

import springbook.step1_3.user.dao.DataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class ConutingConnectionMaker implements DataSource {
    int counter = 0;
    private DataSource realConnectionMaker;

    public ConutingConnectionMaker(DataSource realConnectionMaker) {
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
