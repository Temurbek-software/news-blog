package service.users;

import database.DB;
import entity.Users;
import payload.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class UserService {
    private static final String GET_AUTHENTICATE = "SELECT id, username, \"fullName\", password, \"phoneNumber\", email, created_at, updated_at\n" +
            "\tFROM public.users where username=? and password=?";
    private static final String SAVE_USERS = "INSERT INTO public.users(\n" +
            "\tusername, \"fullName\", password, \"phoneNumber\", email)\n" +
            "\tVALUES (?, ?, ?, ?,?);";
    private static final String GET_ALL_USERS = "SELECT id, username, \"fullName\", password, \"phoneNumber\", email, created_at, updated_at\n" +
            "\tFROM public.users";
    private static final String SAVE_MASSAGE = "INSERT INTO public.complain(\n" +
            "\tmessage, user_id, publisher_id)\n" +
            "\tVALUES (?, ?, ?);";


    public ResultSet getresultSet(String query) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet rs = preparedStatement.executeQuery();
        return rs;
    }


    public PreparedStatement getstatement(String query) throws SQLException {
        Connection connection = DB.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        return preparedStatement;
    }

    public Users getUser(ResultSet resultSet) throws SQLException {
        Users users = null;
        Long id = resultSet.getLong("id");
        String username = resultSet.getString("username");
        String fullName = resultSet.getString("fullName");
        String password = resultSet.getString("password");
        String phoneNumber = resultSet.getString("phoneNumber");
        String email = resultSet.getString("email");
        Date created_at = resultSet.getDate("created_at");
        Date updated_at = resultSet.getDate("updated_at");
        users = new Users(id, username, fullName, password, phoneNumber, email,
                created_at, updated_at);
        return users;
    }

    public Users getUserDetails(UserDto userDto) {
        Users users = new Users();
        try (PreparedStatement preparedStatement = getstatement("SELECT id, username, \"fullName\", password, \"phoneNumber\", email, created_at, updated_at\n" +
                "\tFROM public.users" +
                " where username='" + userDto.getUsername() + "' and " +
                "password='" + userDto.getPassword() + "'");
             ResultSet set = preparedStatement.executeQuery();) {
            while (set.next()) {
                users.setId(set.getLong("id"));
                users.setUsername(set.getString("username"));
                users.setFullName(set.getString("fullname"));
                users.setPhoneNumber(set.getString("phoneNumber"));
                users.setEmail(set.getString("email"));
                users.setActive(true);
                users.setPassword(set.getString("password"));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return users;
    }

    public void saveisActive(Users users) {
        boolean status = true;
        long idUser = users.getId();
        try {
            PreparedStatement preparedStatement = getstatement(
                    "UPDATE public.users\n" +
                            "\tSET \"isActive\"=" + status + "\n" +
                            "\tWHERE id=" + idUser + ";"
            );
            int resultSet = preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
    }

    public void saveNoisActive(Users users) {
        long idUser = users.getId();
        try {
            PreparedStatement preparedStatement = getstatement(
                    "UPDATE public.users\n" +
                            "\tSET \"isActive\"=" + "false" + "\n" +
                            "\tWHERE id=" + idUser + ";"
            );
            int resultSet = preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
    }

    public boolean validate(UserDto userDto) {
        boolean status = false;
        try (Connection connection = DB.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection
                     .prepareStatement(GET_AUTHENTICATE)) {
            preparedStatement.setString(1, userDto.getUsername());
            preparedStatement.setString(2, userDto.getPassword());
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();
        } catch (SQLException e) {
            // process sql exception
            DB.printSQLException(e);
        }
        return status;
    }


    public int saveUser(Users users) {
        int result = 0;
        System.out.println(SAVE_USERS);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_USERS)) {
            preparedStatement.setString(1, users.getUsername());
            preparedStatement.setString(2, users.getFullName());
            preparedStatement.setString(3, users.getPassword());
            preparedStatement.setString(4, users.getPhoneNumber());
            preparedStatement.setString(5, users.getEmail());
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return result;
    }

    public int updateUser(String username, String fullName,String pass, String phone, String email,long id)
    {
        int resul = 0;
        try {
            PreparedStatement preparedStatement = getstatement(
                    "UPDATE public.users\n" +
                            "\tSET username='"+username+"'," +
                            " \"fullName\"='"+fullName+"'," +
                            " password='"+pass+"'," +
                            " \"phoneNumber\"='"+phone+"'," +
                            " email='"+email+"',\"isActive\"='"+false+"' WHERE id='"+id+"';"
            );
             resul = preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return resul;
    }

    public int saveMassage(long userId, int publisher_id, String mas) {
        int result = 0;
        System.out.println(SAVE_MASSAGE);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_MASSAGE)) {
            preparedStatement.setString(1, mas);
            preparedStatement.setLong(2, userId);
            preparedStatement.setInt(3, publisher_id);
            System.out.println(preparedStatement);
            result = preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return result;
    }

    public List<Users> getAllUser() {
        List<Users> usersList = new ArrayList<>();
        try {
            ResultSet rs = getresultSet(GET_ALL_USERS);
            while (rs.next()) {
                usersList.add(getUser(rs));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return usersList;
    }

    public long getId(String username) {
        Users users = getAllUser().stream().filter((s) -> s.getUsername().equals(username)).findAny().get();
        return users.getId();
    }

    public boolean isUserExist(Users users) {
        boolean status = false;
        List<Users> usersList = getAllUser();
        Set<Users> users1 = usersList.stream().collect(Collectors.toSet());
        Predicate<Users> predicate = (s) -> s.equals(users);
        for (Users users2 : users1) {
            if (predicate.test(users2)) {
                status = true;
            } else {
                continue;
            }
        }
        return status;
    }


}
