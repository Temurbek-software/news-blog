package service.product;

import entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProduct();
    Product getOne(Long id);
    boolean save(Product product);
    boolean delete(Long id);
    String updateProduct(Long id,Product product);
}
