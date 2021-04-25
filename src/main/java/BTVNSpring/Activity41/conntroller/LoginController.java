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

public class LoginController {

    @PostMapping(value = "/login")
    public String login (@RequestBody User user) throws  Exception {
        DBConnection dbconn = DBConnection.getInstance();
        Connection conn = dbconn.getConnection();
        String query = " select * from website_sach_cu.user where user_phone = " + user.getUserPhoneNumber();
        Statement statementLogin = conn.createStatement();
        ResultSet resultSetLogin = statementLogin.executeQuery(query);
        while (resultSetLogin.next()) {
            if (user.getUserEmail().equals(resultSetLogin.getString("user_email")) == true) {
                if (user.getUserPassword().equals(resultSetLogin.getString("user_password")) == true) {
                    return "Login Successed";
                } else   return "Email or Password is incorrect";

                } else {
                    return "Email does not exist";
                }
            } return "login failed";
        }

    }
