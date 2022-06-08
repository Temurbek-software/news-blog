package service.users;

import database.DB;
import entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    public UserServiceImpl() {
    }

    private static final String GET_ALL_USERS = "SELECT id, username, \"fullName\", password, \"phoneNumber\", email, \"createdTime\"\n" +
            "\tFROM public.users;";
    private static final String GET_BY_ID = "SELECT id, username, \"fullName\", password, \"phoneNumber\", email, \"createdDate\"\n" +
            "\tFROM public.\"Users\" where \"id\"=;";
    private static final String CREATE_NEW_USER = "INSERT INTO public.users(\n" +
            "\tusername, fullname, password, \"phoneNumber\", email, \"createdTime\")\n" +
            "\tVALUES (?, ?, ?, ?, ?, ?);";
    private static final String UPDATE_BY_ID = "UPDATE public.\"Users\"\n" +
            "\tSET id=?, username=?, \"fullName\"=?, password=?," +
            " \"phoneNumber\"=?, email=?, \"createdDate\"=?\n" +
            "\tWHERE <condition>;";
    private static final String DELETE_BY_ID = "DELETE FROM public.\"Users\"\n" +
            "\twhere \"id\"=;";

    @Override
    public boolean save(Users userData) {
        // try-with-resource statement will auto close the connection
        boolean result = false;
        try {
            try (Connection connection = DB.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_USER)) {
                preparedStatement.setString(1, userData.getUsername());
                preparedStatement.setString(2, userData.getFullName());
                preparedStatement.setString(3, userData.getPassword());
                preparedStatement.setString(4, userData.getPhoneNumber());
                preparedStatement.setString(5, userData.getEmail());
                preparedStatement.setDate(6, DB.getUtilDate(userData.getCreatedTime()));
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
                result = true;
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
            result = false;
        }
        return result;
    }

    @Override
    public List<Users> getAll() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<Users> list = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DB.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long id = rs.getLong("id");
                String username = rs.getString("username");
                String fullName = rs.getString("fullName");
                String password = rs.getString("password");
                String phoneNumber = rs.getString("phoneNumber");
                String email = rs.getString("email");
                Date targetDate = rs.getDate("createdTime");
                list.add(new Users(id, username, fullName, password,
                        phoneNumber, email, targetDate));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return list;

    }

    @Override
    public boolean delete(Long id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = DB.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_BY_ID);) {
            statement.setLong(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
}
