
package GoldGymManagementSystem;
import java.sql.Connection;
import java.sql.*;
import javax.swing.JOptionPane;
public class DatabaseConnection {
    Connection con;
  public   DatabaseConnection(){
            try { 
        String url ="jdbc:mysql://localhost:3306/gym";
          Class.forName("com.mysql.jdbc.Driver");
        con =DriverManager.getConnection(url,"root","root");
            } 
            catch (Exception ex) {
                 JOptionPane.showMessageDialog(null,ex);                
            }
        }   

}
