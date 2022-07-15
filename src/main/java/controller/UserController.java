package controller;

import entity.EmailConfir;
import entity.Publisher;
import entity.Users;
import payload.CookieService;
import payload.UserDto;
import service.email.EmailServices;
import service.publisher.PublisherServices;
import service.users.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = {"/sendEmail", "/registration",
        "/showRegister", "/login", "/logout",
        "/userSetting", "/complain", "/complained", "/changeProfile"})
public class UserController extends HttpServlet {
    private EmailServices emailServices;
    private UserService userService;
    private PublisherServices publisherServices;
    private CookieService cookieService;
    private static final long serialVersionUID = 1L;

    public void init() {
        cookieService = new CookieService();
        emailServices = new EmailServices();
        userService = new UserService();
        publisherServices = new PublisherServices();
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        try {
            switch (action) {
                case "/sendEmail":
                    sendEmail(request, response);
                    break;
                case "/login":
                    authenticate(request, response);
                    break;
                case "/logout":
                    calcelAuthentication(request, response);
                    break;
                case "/complain":
                    getComplaining(request, response);
                    break;
                case "/complained":
                    potComplaining(request, response);
                    break;
                case "/showRegister":
                    showRegister(request, response);
                    break;
                case "/registration":
                    register(request, response);
                    break;
                case "/changeProfile":
                    profileChange(request, response);
                    break;
                case "/userSetting":
                    setting(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void getComplaining(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        Publisher publisher = publisherServices.getPublisherById(id);
        request.setAttribute("publish", publisher);
        RequestDispatcher dispatcher = request.getRequestDispatcher("complain/complaining.jsp");
        dispatcher.forward(request, response);
    }

    protected void profileChange(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        System.out.println("started");
        Users users = cookieService.getCurrentUser(request);
        Cookie cUserName = new Cookie("cocUser", null);
        Cookie cPassword = new Cookie("cocPas", null);
        Cookie cRemember = new Cookie("cocRem", null);
        cUserName.setMaxAge(0);
        cPassword.setMaxAge(0);
        cRemember.setMaxAge(0);
        response.addCookie(cUserName);
        response.addCookie(cPassword);
        response.addCookie(cRemember);
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
         userService.updateUser(username,fullName,password,phoneNumber,email,users.getId());
            response.sendRedirect("/");
    }

    protected void potComplaining(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String mass = request.getParameter("messageComplain");
        System.out.println("get username");
        System.out.println(request.getParameter("id") + "qdqw");
        CookieService cookieService = new CookieService();
        Users users = cookieService.getCurrentUser(request);
        System.out.println("tookk it");
        System.out.println(users.getUsername());
//        long userID=userService.getId(username);
        if (userService.saveMassage(users.getId(), id, mass) == 1) {
            request.setAttribute("msg", true);
        } else {
            request.setAttribute("msg", false);
        }
        Publisher publisher = publisherServices.getPublisherById(id);
        request.setAttribute("publish", publisher);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/complain");
        dispatcher.forward(request, response);
    }

    protected void sendEmail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String email = request.getParameter("emailing");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                EmailConfir confir = new EmailConfir(email);
                int numb = emailServices.saveEmail(confir);
                if (numb > 0) {
//                    result = numb;
                    request.setAttribute("natija", true);
                } else {
                    request.setAttribute("natija", false);
                }
            }
        });
        thread.start();
        response.sendRedirect("/");
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = request.getParameter("logusername").trim();
        String password = request.getParameter("logpassword").trim();
        String remember = request.getParameter("remember");
        UserDto userDto = new UserDto();
        userDto.setUsername(username);
        userDto.setPassword(password);
        HttpSession httpSession = request.getSession();

        if (userService.validate(userDto)) {
            Users users = userService.getUserDetails(userDto);
            userService.saveisActive(users);
            httpSession.setAttribute("userSession", users);
            Cookie cookieUser = new Cookie("cocUser", username);
            Cookie cookiePas = new Cookie("cocPas", password);
            Cookie cookieRem = new Cookie("cocRem", remember);
            cookieUser.setMaxAge(60 * 60);
            cookiePas.setMaxAge(60 * 60);
            cookieRem.setMaxAge(60 * 60);
            response.addCookie(cookieUser);
            response.addCookie(cookiePas);
            response.addCookie(cookieRem);

            httpSession.setAttribute("sessUser", username.trim());
            response.sendRedirect("/");
        } else {
            request.setAttribute("falseUser", false);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/");
            dispatcher.forward(request, response);
        }

    }

    private void calcelAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Users users = cookieService.getCurrentUser(request);
        userService.saveNoisActive(users);
        Cookie cUserName = new Cookie("cocUser", null);
        Cookie cPassword = new Cookie("cocPas", null);
        Cookie cRemember = new Cookie("cocRem", null);
        cUserName.setMaxAge(0);
        cPassword.setMaxAge(0);
        cRemember.setMaxAge(0);
        response.addCookie(cUserName);
        response.addCookie(cPassword);
        response.addCookie(cRemember);
        HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        response.sendRedirect("/");
    }

    private void showRegister(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register/registration.jsp");
        dispatcher.forward(request, response);
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String username = request.getParameter("username");
        String fullName = request.getParameter("fullName");
        String password = request.getParameter("password");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");

        Users users = new Users();
        users.setUsername(username);
        users.setFullName(fullName);
        users.setPassword(password);
        users.setPhoneNumber(phoneNumber);
        users.setEmail(email);

        try {
            if (userService.isUserExist(users)) {
                request.setAttribute("msg", false);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/showRegister");
                dispatcher.forward(request, response);

            } else {
                int result = userService.saveUser(users);
                if (result == 1) {
                    request.setAttribute("result", true);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/showRegister");
                    dispatcher.forward(request, response);
                } else {
                    request.setAttribute("result", false);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("/showRegister");
                    dispatcher.forward(request, response);
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setting(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("users/userProfile.jsp");
        dispatcher.forward(request, response);
    }
}
