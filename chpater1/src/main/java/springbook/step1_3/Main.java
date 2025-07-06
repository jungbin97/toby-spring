package springbook.step1_3;

import springbook.step1_3.user.dao.ConnectionMaker;
import springbook.step1_3.user.dao.DConnectionMaker;
import springbook.step1_3.user.dao.UserDao;
import springbook.step1_3.user.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        ConnectionMaker connectionMaker = new DConnectionMaker();
        UserDao dao = new UserDao(connectionMaker);

        User user = new User();
        user.setId("whiteship");
        user.setName("백기선");
        user.setPassword("123456");

        dao.add(user);

        System.out.println(user.getId() + " 등록 성공");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getId() + " 조회 성공");
        System.out.println(user2.getName() + " " + user2.getPassword() + " 조회 성공");
        System.out.println(user2.getPassword());
    }
}
