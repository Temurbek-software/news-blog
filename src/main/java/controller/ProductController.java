package controller;

import entity.Category;
import entity.Product;
import entity.Publisher;
import payload.ProductResponse;
import service.category.CategoryService;
import service.product.ProductService;
import service.product.ProductServiceImpl;
import service.publisher.PublisherServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet(urlPatterns = {"/", "/categoryNews", "/aboutUs",
        "/displayPublisher", "/singleData", "/contact", "/saveContact"})
@MultipartConfig(maxFileSize = 16177215)
public class ProductController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductService productService;
    private PublisherServices publisherServices;

    public void init() {
        productService = new ProductServiceImpl();
        publisherServices = new PublisherServices();
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
                case "/singleData":
                    getOnlyOneData(request, response);
                    break;
                case "/searchNews":
                    getFilteredNews(request, response);
                    break;
                case "/aboutUs":
                    getAbout(request, response);
                    break;
                case "/contact":
                    getContacts(request, response);
                    break;
                case "/saveContact":
                    saveContact(request, response);
                    break;

                case "/displayPublisher":
                    showPublisher(request, response);
                    break;
                default:
                    newsList(request, response);
                    break;
            }
        } catch (SQLException | ParseException ex) {
            throw new ServletException(ex);
        }
    }

    protected void getContacts(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("contact/contact.jsp");
        dispatcher.forward(request, response);
    }

    protected void saveContact(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String textMassage = request.getParameter("textMassage");
        if (productService.saveContactMassage(username,email,textMassage)==1)
        {
            request.setAttribute("msg",true);
        }
        else
        {
            request.setAttribute("msg",false);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/contact");
        dispatcher.forward(request, response);
    }


    protected void showPublisher(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        Publisher publisher = publisherServices.getPublisherById(id);
        request.setAttribute("publisherAtribute", publisher);
        RequestDispatcher dispatcher = request.getRequestDispatcher("publishers/pubProfile.jsp");
        dispatcher.forward(request, response);
    }

    protected void newsList(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<ProductResponse> productList = productService.getAllProduct();
        Product product = productService.getOneProduct();
        request.setAttribute("latestProduct", product);
        commonItems(request, response);
        request.setAttribute("productList", productList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");
        dispatcher.forward(request, response);
    }

    protected void getAbout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Publisher> publisherList = publisherServices.getAllPublisher();
        request.setAttribute("listPub", publisherList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("about/aboutUs.jsp");
        dispatcher.forward(request, response);
    }

    public void getOnlyOneData(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, ParseException {
        int id = Integer.parseInt(request.getParameter("id"));
        productService.saveCounter(id);
        Product product = productService.getProductByID(id);
        request.setAttribute("currentProduct", product);
        Publisher publisher = publisherServices.getPublisherByProductId(id);
        request.setAttribute("currentPublisher", publisher);
        commonItems(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-to-do/singlePage.jsp");
        dispatcher.forward(request, response);
    }

    protected void getFilteredNews(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String title = request.getParameter("searchedProduct");
        String categoryId = request.getParameter("category_id");
        commonItems(request, response);
        if (categoryId.equals("Categories")) {
            //go filter only titles
            List<Product> productByTitles = productService.getProductByTitles(title);
            if (!productByTitles.isEmpty()) {
                request.setAttribute("searchedProduct", productByTitles);
                RequestDispatcher dispatcher = request.getRequestDispatcher("list-to-do/searchList.jsp");
                dispatcher.forward(request, response);

            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("notFoundMessages/noFound.jsp");
                dispatcher.forward(request, response);
            }
        } else {
            //only category and title
            int cat_Id = Integer.parseInt(request.getParameter("category_id"));
            List<Product> productByTitleandCategory = productService.getProductByTitleandCategory(title, cat_Id);
            if (!productByTitleandCategory.isEmpty()) {
                request.setAttribute("searchedProduct", productByTitleandCategory);
                RequestDispatcher dispatcher = request.getRequestDispatcher("list-to-do/searchList.jsp");
                dispatcher.forward(request, response);
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("notFoundMessages/noFound.jsp");
                dispatcher.forward(request, response);
            }
        }


    }

    public void listOfCategory(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Product> list = CategoryService.getProductByCategory(id);
        request.setAttribute("productCategory", list);
        commonItems(request, response);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list-to-do/list-category.jsp");
        dispatcher.forward(request, response);
    }

    public void commonItems(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Product> stringListOfLastPost = productService.showLastsixProduct();
        request.setAttribute("lastPosts", stringListOfLastPost);
        List<Category> categoryList = CategoryService.categoryList();
        request.setAttribute("categoryList", categoryList);
    }


}
