
package Complaint_management;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clsacc 
{
   public void insacc(clsaccprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=databaseconnectivity.con.prepareCall("{call insacc(?,?,?,?,?,?)}");
       stm.setString(1, p.getAccnam());      
       stm.setString(2, p.getAccadd());
       stm.setString(3, p.getAccloc());
       stm.setString(4, p.getAccphnno());
       stm.setString(5, p.getAcctyp());
       java.sql.Date s = new java.sql.Date(p.getAccdat().getTime());
            stm.setDate(6,s);
       stm.execute();
       databaseconnectivity.closecon();
   }
   public void updacc(clsaccprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=databaseconnectivity.con.prepareCall("{call updacc(?,?,?,?,?,?)}");
       stm.setInt(1, p.getAccno());
       stm.setString(2, p.getAccnam());
       stm.setString(3, p.getAccadd());
       stm.setString(4, p.getAccloc());
       stm.setString(5, p.getAccphnno());
       stm.setString(6, p.getAcctyp());
       stm.setDate(7, (java.sql.Date) (Date) p.getAccdat());
       stm.execute();
       databaseconnectivity.closecon();
   }
   public clsaccprp fndacc(int ano) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call fndacc(?)}");
       stm.setInt(1,ano);
       ResultSet rs=stm.executeQuery();
       clsaccprp p=new clsaccprp();
       if(rs.next())
       {
           p.setAccno(rs.getInt("accno"));
           p.setAccnam(rs.getString("accnam"));
           p.setAccadd(rs.getString("accadd"));
           p.setAccloc(rs.getString("accloc"));
           p.setAccphnno(rs.getString("accphnno"));
           p.setAcctyp(rs.getString("acctyp"));
           p.setAccdat(rs.getDate("accdat"));
       }
       databaseconnectivity.closecon();
       return p;
   }

    /**
     *
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public ArrayList<clsaccprp> dspacc() throws IOException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call dspacc()}");
       ResultSet rs=stm.executeQuery();
      ArrayList<clsaccprp> k= new ArrayList<>();
       while(rs.next())
       {
           clsaccprp p=new clsaccprp();
           p.setAccno(rs.getInt("accno"));
           p.setAccnam(rs.getString("accnam"));
           p.setAccadd(rs.getString("accadd"));
           p.setAccloc(rs.getString("accloc"));
           p.setAccphnno(rs.getString("accphnno"));
           p.setAcctyp(rs.getString("acctyp"));
           p.setAccdat(rs.getDate("accdat"));
           k.add(p);
       }
           databaseconnectivity.closecon();
           return k;
       
   }
   public void delacc(clsaccprp p)
   {
       try {
           databaseconnectivity.getcon();
           CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call delacc(?)}");
           stm.setInt(1, p.getAccno());
           stm.execute();
           databaseconnectivity.closecon();
       } catch (IOException | ClassNotFoundException | SQLException ex) {
           Logger.getLogger(clsacc.class.getName()).log(Level.SEVERE, null, ex);
       } 
   }
}
