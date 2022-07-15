package service.product;

import entity.Product;
import payload.ProductResponse;

import java.text.ParseException;
import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    Product getProductByID(long id) throws ParseException;
    List<Product> getProductByTitleandCategory(String sampletitle,int category_id);
    List<Product> getProductByTitles(String sampletitle);
    Product getOneProduct();
    List<Product> showLastsixProduct();
    void saveCounter(int id) throws ParseException;
    int saveContactMassage(String username,String email,String text);

}
