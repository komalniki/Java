
package Complaint_management;

import com.mysql.jdbc.CallableStatement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clscmp 
{
   public int inscmp(clscmpprp p)
   {
       try {
           databaseconnectivity.getcon();
           CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call inscmp(?,?,?,?,?,?)}");
           stm.setInt(1, p.getCmpaccno());
           stm.setString(2, p.getCmpdsc());
           stm.setInt(3, p.getCmpasgempcod());
           stm.setString(4,p.getCmpsts());
           java.sql.Date s = new java.sql.Date(p.getCmpdat().getTime());
           stm.setDate(5,s);
           stm.registerOutParameter(6, Types.INTEGER);
           stm.execute();
           int a=stm.getInt(6);
           databaseconnectivity.closecon();
           return a;
       } catch (IOException | ClassNotFoundException | SQLException ex) {
           Logger.getLogger(clscmp.class.getName()).log(Level.SEVERE, null, ex);
       }
       return -1;
   }
   public void updcmp(clscmpprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call updcmp(?,?)}");
       stm.setInt(1, p.getCmpcod());
       stm.setString(2,p.getCmpsts());
       stm.execute();
       databaseconnectivity.closecon();
   }
   public clscmpprp fndcmp(int ccod) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call fndcmp(?)}");
       stm.setInt(1,ccod);
       ResultSet rs=stm.executeQuery();
       clscmpprp p=new clscmpprp();
       if(rs.next())
       {
           p.setCmpcod(rs.getInt("cmpcod"));
           p.setCmpaccno(rs.getInt("cmpaccno"));
           p.setCmpdat(rs.getDate("cmpdat"));
           p.setCmpdsc(rs.getString("cmpdsc"));
           p.setCmpasgempcod(rs.getInt("cmpasgempcod"));
           p.setCmpsts(rs.getString("cmpsts"));
       }
       databaseconnectivity.closecon();
       return p;
   }
        public ResultSet dispcmpofmonth() throws IOException 
  {
      ResultSet rs=null;
      try {
          databaseconnectivity.getcon();
          java.sql.CallableStatement stm=databaseconnectivity.con.prepareCall("{call dispcurrmonthrep()}");
          rs=stm.executeQuery();
         // databaseconnectivity.disconnect();
      } catch (SQLException ex) {
          Logger.getLogger(clsrep.class.getName()).log(Level.SEVERE, null, ex);
      } catch (FileNotFoundException ex) {
           Logger.getLogger(clscmp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(clscmp.class.getName()).log(Level.SEVERE, null, ex);
       }
      return rs;
  }
    public List<clscmpprp> dspcmp() throws IOException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call dspcmp()}");
       ResultSet rs=stm.executeQuery();
       List <clscmpprp> k= new ArrayList<clscmpprp>();
       while(rs.next())
       {
           clscmpprp p=new clscmpprp();
           p.setCmpcod(rs.getInt("cmpcod"));
           p.setCmpaccno(rs.getInt("cmpaccno"));
           p.setCmpdsc(rs.getString("cmpdsc"));
           p.setCmpasgempcod(rs.getInt("cmpasgempcod"));
           p.setCmpsts(rs.getString("cmpsts"));
           p.setCmpdat(rs.getDate("cmpdat"));
           k.add(p);
           databaseconnectivity.closecon();
       }
       return k;
   }
   public void delcmp(clscmpprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call delcmp(?)");
       stm.setInt(1, p.getCmpcod());
       stm.execute();
       databaseconnectivity.closecon();
   }
}
