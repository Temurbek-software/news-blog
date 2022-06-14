import service.category.CategoryService;

import java.sql.SQLException;

public class MainTest {

    public static void main(String[] args) throws SQLException {


        System.out.println(CategoryService.getProductByCategory(1));
    }
}
