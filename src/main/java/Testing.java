import service.users.UserServiceImpl;

public class Testing {
    public static void main(String[] args) {
        UserServiceImpl userService= new UserServiceImpl();
        System.out.println(userService.getAll());
    }
}
