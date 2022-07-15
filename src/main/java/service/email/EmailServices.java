package service.email;

import database.DB;
import entity.EmailConfir;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmailServices {
    private static final String SAVE_EMAIL = "INSERT INTO public.\"EmailConfir\"(email)\n" +
            "\tVALUES (?);";

    public int saveEmail(EmailConfir confir) {
        int result = 0;
        try (Connection connection = DB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_EMAIL)
        ) {
            preparedStatement.setString(1, confir.getEmail());
            result = preparedStatement.executeUpdate();
        } catch (SQLException exception) {
            DB.printSQLException(exception);
        }
        return result;
    }

}
