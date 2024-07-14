
package card_mark_system;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class databaseconnection {
    final static String JDBC_DRIVER="com.mysql.jdbc.Driver";
    final static String DB_URL="jdbc:mysql://localhost:3306/tusionclass";
    final static String USER="root";
    final static String PASS="";
    
    public static Connection connection(){
        try{
            Class.forName(JDBC_DRIVER);
            
            
            Connection conn = (Connection) DriverManager.getConnection(DB_URL,USER,PASS);
            return conn;
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
            return null;
        }
    }
}
