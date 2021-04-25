package BTVNSpring.Activity41.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private DBConnection(){}
    private static DBConnection dbConnection ;
    private static Connection connection;

    public static DBConnection getInstance(){
        if ( dbConnection == null ){
            dbConnection = new DBConnection();
        }
        return  dbConnection;
    }

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if ( connection== null) {
                connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/website_sach_cu?characterEncoding=utf8" , "root" , "123456789");
            } else return connection;
        } catch (Exception e){
            e.printStackTrace();
        }
        return connection;
    }

}

//class Test{
//    public static void main(String[] args) {
//        DBConnection dbConnection = DBConnection.getInstance();
//        if (dbConnection.getConnection() == null){
//            System.out.printf("Thatbai");
//        } else {
//            System.out.printf("thanhcong");
//        };
//    }
//}