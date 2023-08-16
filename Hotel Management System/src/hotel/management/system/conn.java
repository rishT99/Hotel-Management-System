/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author risha
 */
package hotel.management.system;
import java.sql.*;

public class conn {
    
    Connection c;
    PreparedStatement pstm;
    Statement s;

    
    public conn()
    {
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","root");
            s = c.createStatement();
            
        }
          catch(Exception e){
              e.printStackTrace();
          }   
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
