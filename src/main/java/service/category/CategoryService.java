package service.category;

import database.DB;
import entity.Category;
import entity.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CategoryService {
    private static final String GET_CATEGORY_LIST = "SELECT id, name\n" +
            "\tFROM public.category;";
    private static final String GET_ONE_PRODUCT = "SELECT id, titles, description, \"sourcelinkTo\", \"createdTime\", photofile\n" +
            "\tFROM public.product where category_id=?";
    public static List<Product> getProductByCategory(int num)
    {
        List<Product> categoryList = new ArrayList<>();
        try (Connection connection = DB.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ONE_PRODUCT);) {
            System.out.println(preparedStatement);
            preparedStatement.setInt(1,num);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long id = rs.getLong("id");
                String titles = rs.getString("titles");
                String description = rs.getString("description");
                String sourcelinkTo = rs.getString("sourcelinkTo");
                Date createdTime = rs.getDate("createdTime");
                String photofile = rs.getString("photofile");
                categoryList.add(new Product(id, titles, description, sourcelinkTo,
                        createdTime, photofile));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return categoryList;
    }

    public static List<Category> categoryList() {
        List<Category> categoryList = new ArrayList<>();
        try (Connection connection = DB.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_LIST);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                categoryList.add(new Category(id, name));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return categoryList;

    }

}
