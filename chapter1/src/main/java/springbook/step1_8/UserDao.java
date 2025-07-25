package springbook.step1_8;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

    private javax.sql.DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        Connection c = dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }


    public User get(String id) throws SQLException {
        // JDBC 드라이버 로드
        Connection c = dataSource.getConnection();

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
