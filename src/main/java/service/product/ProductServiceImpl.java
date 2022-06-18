package service.product;

import database.DB;
import entity.Product;
import payload.ProductResponse;

import javax.swing.plaf.PanelUI;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService{

    private static final String GET_ALL_PRODUCTS = "SELECT titles, description, \"sourcelinkTo\", \"createdTime\", photofile, category.name\n" +
            "\tFROM public.product inner join category on product.category_id=category.id";
    private static final String GET_PRODUCT_LATEST_ONE="SELECT id, titles, description, \"sourcelinkTo\", \"createdTime\", photofile, category_id\n" +
            "\tFROM public.product where \"createdTime\"=(select max(\"createdTime\") from product)";
    private static final String GET_CATEGORY_NAME = "SELECT name\tFROM public.product inner join category on category.id=product.category_id\n" +
            "where product.category_id=?";
    private static final String SAVE_PRODUCT = "";
    private static final String UPDATE_PRO="";
    private static final String DELETE_PRO="";

    public static Product getOneProduct()
    {
       List<Product> productList=new ArrayList<>();
        try {
            Connection connection= DB.getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(GET_PRODUCT_LATEST_ONE);
            ResultSet resultSet=preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String titles = resultSet.getString("titles");
                String description = resultSet.getString("description");
                String sourcelinkTo = resultSet.getString("sourcelinkTo");
                Date createdTime = resultSet.getDate("createdTime");
                String photofile = resultSet.getString("photofile");
                productList.add(new Product(id,titles,description,sourcelinkTo,createdTime,photofile));
            }
        }
        catch (SQLException exception) {
            DB.printSQLException(exception);
        }

        return productList.get(0);
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        // using try-with-resources to avoid closing resources (boiler plate code)
        List<ProductResponse> productResponses = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = DB.getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            while (rs.next()) {
//                Long id = rs.getLong("id");
                String titles = rs.getString("titles");
                String description = rs.getString("description");
                String sourcelinkTo = rs.getString("sourcelinkTo");
                Date createdTime = rs.getDate("createdTime");
                String photofile = rs.getString("photofile");
                String name=rs.getString("name");
                productResponses.add(new ProductResponse(titles, description, sourcelinkTo,
                        createdTime, photofile,name));
            }
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return productResponses;
    }

    @Override
    public Product getOne(Long id) {
        return null;
    }
}
