
package Complaint_management;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clsrep 
{
  public ResultSet cmpasgbyemp(int ecod)
  {
      ResultSet rs=null;
      try {
          databaseconnectivity.getcon();
          CallableStatement stm=databaseconnectivity.con.prepareCall("{call cmpasgbyemp(?)}");
          stm.setInt(1, ecod);
          rs=stm.executeQuery();
          //databaseconnectivity.closecon();
      } catch (IOException | ClassNotFoundException | SQLException ex) {
          Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
      }
      return rs;
  }  
   public ResultSet cmpforcurmon() 
  {
      ResultSet rs=null;
      try {
          databaseconnectivity.getcon();
          CallableStatement stm=databaseconnectivity.con.prepareCall("{call cmpforcurmon()}");
          rs=stm.executeQuery();
          //databaseconnectivity.closecon();
      } catch (SQLException | IOException | ClassNotFoundException ex) {
          Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
      }
      return rs;
  }
     public ResultSet empprfformon() 
  {
      ResultSet rs=null;
      try {
          databaseconnectivity.getcon();
          CallableStatement stm=databaseconnectivity.con.prepareCall("{call empprfformon()}");
          rs=stm.executeQuery();
          //databaseconnectivity.closecon();
      } catch (SQLException | IOException | ClassNotFoundException ex) {
          Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
      }
      return rs;
  }
}
