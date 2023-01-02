package tools;
import java.sql.Connection;
import java.sql.DriverManager;
import com.mysql.jdbc.Driver;


//import com.mysql.cj.jdbc.Driver;

public class DbConnection {
    private Connection con;

    public Connection getConnection(){
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mahasiswa", "root", "1234");
        } catch (Exception e) {
            System.out.println("Error + " + e.getMessage());
        }
        return con;
    }
    
}
