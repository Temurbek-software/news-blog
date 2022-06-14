package service.users;

import entity.Users;

import java.sql.SQLException;
import java.util.List;

public interface UserService {

    boolean save(Users users);

    List<Users> getAll();

    boolean delete(Long id) throws SQLException ;

}
