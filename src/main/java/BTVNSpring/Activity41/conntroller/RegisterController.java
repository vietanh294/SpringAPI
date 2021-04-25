package BTVNSpring.Activity41.conntroller;

import BTVNSpring.Activity41.DBConnection.DBConnection;
import BTVNSpring.Activity41.Model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

@RestController
@RequestMapping(value = "/home")

public class RegisterController {
    @PostMapping(value = "/regiter")
    public String register(@RequestBody User user) throws Exception {
        DBConnection dbcon = DBConnection.getInstance();
        Connection connection = dbcon.getConnection();
        String sqlQuery = "select user_email from website_sach_cu.user";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sqlQuery);

        if (user.checkEmail(user.getUserEmail()) == false) {
            return "Invalid Email";
        }
        while (resultSet.next()) {
            if (user.getUserEmail().equals(resultSet.getString("user_email")) == true) {
                return "Email already exists";
            } else {
                if (user.checkPassword(user.getUserPassword()) == false) {
                    return "Invalid Password";
                } else if (user.checkPhoneNumber(user.getUserPhoneNumber()) == false) {
                    return "Invalid Phone Number";
                }
            }
        }
        String insertQuery = "insert into website_sach_cu.user (user_phone , user_password ,user_email) VALUES ('" + user.getUserPhoneNumber() + "','" + user.getUserPassword() + "','" + user.getUserEmail() + "') ";
        statement.executeQuery(insertQuery);
        return "Register Success";
    }


}
