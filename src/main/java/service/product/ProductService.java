package service.product;

import entity.Product;
import payload.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProduct();
    Product getOne(Long id);

}
