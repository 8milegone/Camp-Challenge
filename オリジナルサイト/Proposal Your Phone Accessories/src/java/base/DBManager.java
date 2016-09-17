package base;
/**
 * DBへのアドレスを指定
 * @author 長島　奨
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBManager {
    public static Connection getConnection(){
        Connection con = null;
        try{
            System.out.println("origin_siteDB try Connect");
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/origin_site","root","");
            System.out.println("DBConnected!!");
            return con;
        }catch(ClassNotFoundException e){
            System.out.println("接続時にエラーが発生しました："+e.toString());
            throw new IllegalMonitorStateException();
        } catch (SQLException e) {
            System.out.println("接続時にエラーが発生しました："+e.toString());
            throw new IllegalMonitorStateException();
        }
    }
}
