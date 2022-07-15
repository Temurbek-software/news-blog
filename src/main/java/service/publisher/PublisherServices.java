package service.publisher;

import database.DB;
import entity.Publisher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherServices {
    private static final String GET_PUBLISHER_BY_PRODUCT_ID = "SELECT publisher.id,\"nameOfCompany\", address, " +
            "publisher.description, phonenumber,username, email, " +
            "password FROM public.publisher inner join product on " +
            "product.publisher_id=publisher.id where product.id=?";
    private static final String GET_PUBLISHER_BY_ID = "SELECT id, \"nameOfCompany\", address, description, phonenumber, email, password, created_at, updated_at, username, \"isActive\"\n" +
            "\tFROM public.publisher where id=?";
    private static final String GET_ALL_PUBLISHERS = "SELECT id, \"nameOfCompany\", address, description, phonenumber, email, password, created_at, updated_at, username, \"isActive\"\n" +
            "\tFROM public.publisher;";

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

    public List<Publisher> getAllPublisher()
    {
        List<Publisher> getAllPublishers=new ArrayList<>();
        try {
            ResultSet rs = getresultSet(GET_ALL_PUBLISHERS);
            while (rs.next())
            {
                long id= rs.getLong("id");
                String username=rs.getString("username");
                String nameOfCompany=rs.getString("nameOfCompany");
                String address=rs.getString("address");
                String phoneNumber=rs.getString("phoneNumber");
                String email=rs.getString("email");
                String password=rs.getString("password");
                String description=rs.getString("description");
                boolean isActive=(rs.getBoolean("isActive")!=true)?false:true;
                getAllPublishers.add(new Publisher(id,username,nameOfCompany,
                        address,phoneNumber,email,password,description,isActive));
            }

        }
        catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return getAllPublishers;
    }


    public Publisher getPublisherByProductId(long num) {
        Publisher publishers = new Publisher();
        try (PreparedStatement preparedStatement = getstatement(GET_PUBLISHER_BY_PRODUCT_ID)) {
            preparedStatement.setLong(1, num);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                publishers.setId(resultSet.getLong("id"));
                publishers.setNameOfCompany(resultSet.getString("nameOfCompany"));
                publishers.setAddress(resultSet.getString("address"));
                publishers.setDescription(resultSet.getString("description"));
                publishers.setPhoneNumber(resultSet.getString("phoneNumber"));
                publishers.setUsername(resultSet.getString("username"));
                publishers.setEmail(resultSet.getString("email"));
                publishers.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return publishers;

    }

    public Publisher getPublisherById(long id) {
        Publisher publishersPublisher = new Publisher();
        try (PreparedStatement preparedStatement = getstatement(GET_PUBLISHER_BY_ID)) {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                publishersPublisher.setId(resultSet.getLong("id"));
                publishersPublisher.setNameOfCompany(resultSet.getString("nameOfCompany"));
                publishersPublisher.setAddress(resultSet.getString("address"));
                publishersPublisher.setPhoneNumber(resultSet.getString("phoneNumber"));
                publishersPublisher.setDescription(resultSet.getString("description"));
                publishersPublisher.setUsername(resultSet.getString("username"));
                publishersPublisher.setEmail(resultSet.getString("email"));
                publishersPublisher.setPassword(resultSet.getString("password"));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return publishersPublisher;
    }
}
