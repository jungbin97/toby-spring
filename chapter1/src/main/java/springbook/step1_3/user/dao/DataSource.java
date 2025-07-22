package springbook.step1_3.user.dao;

import java.sql.Connection;
import java.sql.SQLException;

public interface DataSource {
    Connection makeNewConnection() throws ClassNotFoundException, SQLException;
}
