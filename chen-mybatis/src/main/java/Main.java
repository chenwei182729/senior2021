import bean.User;
import mapper.UserMapper;
import sqlsession.MySqlSession;

public class Main {
    public static void main(String[] args) {
        MySqlSession sqlsession = new MySqlSession();
        UserMapper mapper = sqlsession.getMapper(UserMapper.class);
        User user = mapper.getUserById("1");
        System.out.println(user);
    }
}
