package service.product;

import entity.Product;

import java.util.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService
{
    public ProductServiceImpl() {
    }

    private static final String GET_ALL_PRODUCTS = "SELECT id, titles, " +
            "description, \"sourcelinkTo\", \"createdTime\", photofile\n" +
            "\tFROM public.product;";
    private static final String GET_ONE_PRODUCT = "";
    private static final String SAVE_PRODUCT = "";
    private static final String UPDATE_PRO="";
    private static final String DELETE_PRO="";

    @Override

    public List<Product> getAllProduct() {
        return null;
    }

    @Override
    public Product getOne(Long id) {
        return null;
    }

    @Override
    public boolean save(Product product) {
        return false;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public String updateProduct(Long id, Product product) {
        return null;
    }
}
