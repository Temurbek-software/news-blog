package payload;

import entity.Users;
import service.users.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieService {
    public Users getCurrentUser(HttpServletRequest request) {
        Users user = new Users();
        UserDto userDto = new UserDto();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cocUser")) {
                    userDto.setUsername(cookie.getValue());
                }
                if (cookie.getName().equals("cocPas")) {
                    userDto.setPassword(cookie.getValue());
                }
            }
        }
        UserService userService = new UserService();
        user = userService.getUserDetails(userDto);
        return user;
    }
}
