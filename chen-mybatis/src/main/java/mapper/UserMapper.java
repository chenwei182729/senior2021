package mapper;


import anno.Select;
import bean.User;

public interface UserMapper {
    @Select(value = "select * from user where id = 1")
    User getUserById(String id);
}
