package springbook.step1_3.user.dao;


import springbook.step1_3.user.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private DataSource connectionMaker;

    public UserDao(DataSource connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void setConnectionMaker(DataSource connectionMaker) {
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException {
        Connection c = connectionMaker.makeNewConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }


    public User get(String id) throws ClassNotFoundException, SQLException {
        // JDBC 드라이버 로드
        Connection c = connectionMaker.makeNewConnection();

        // PreparedStatement를 사용하여 SQL 쿼리 실행
        PreparedStatement ps = c.prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        // 쿼리 실행 후 결과를 ResultSet으로 받음
        ResultSet rs = ps.executeQuery();
        // 커서를 첫행으로 이동(결과 존재 여부 확인)
        rs.next();

        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        // 자원 해제 (역순: ResultSet → PreparedStatement → Connection)
        rs.close();
        ps.close();
        c.close();

        return user;
    }
}
