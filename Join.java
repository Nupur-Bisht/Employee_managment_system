
package employee.managment;
import java.sql.*;

public class Join {
    Connection c;
    Statement s;
    
    public Join(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql:///employee_management","root","16082002@Nb");
            s=c.createStatement();
            
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
    }}
/**
 *
 * @author nupur
 */

