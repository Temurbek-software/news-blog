package controller;

import entity.Category;
import entity.Product;

import service.category.CategoryService;
import service.product.ProductService;
import service.product.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService productService;

    public void init() {
        productService = new ProductServiceImpl();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/categoryNews":
                    listOfCategory(request, response);
                    break;
                default:
                    newsList(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void newsList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> productList = productService.getAllProduct();
        List<Category> categoryList = CategoryService.categoryList();
        request.setAttribute("categoryList", categoryList);
        request.setAttribute("productList", productList);
        System.out.println("Product list");
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }

    private void listOfCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> list = CategoryService.getProductByCategory(id);
        request.setAttribute("productCategory",list);
        List<Category> categoryList = CategoryService.categoryList();
        request.setAttribute("categoryList", categoryList);
        RequestDispatcher dispatcher=request.getRequestDispatcher("list-to-do/list-category.jsp");
        dispatcher.forward(request,response);
    }


}
