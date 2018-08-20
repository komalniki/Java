
package Complaint_management;

import com.mysql.jdbc.CallableStatement;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class clsemp 
{
    public void insemp(clsempprp p)
   {
       try {
           databaseconnectivity.getcon();
           CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call insemp(?,?,?,?)}");
           stm.setString(1 , p.getEmpnam());
           stm.setString(2, p.getEmppic());
           stm.setString(3, p.getEmploc());
           stm.setString(4,p.getEmpphnno());
           stm.execute();
           databaseconnectivity.closecon();
       } catch (IOException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
   public void updemp(clsempprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
            databaseconnectivity.getcon();
            CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call updemp(?,?,?,?,?)}");
            stm.setInt(1,p.getEmpno());
            stm.setString(2,p.getEmpnam());    
            stm.setString(3,p.getEmppic());
            stm.setString(4,p.getEmploc());
            stm.setString(5, p.getEmpphnno());
            stm.execute();
            databaseconnectivity.closecon();
   }
   public clsempprp fndemp(int eno) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call fndemp(?)}");
       stm.setInt(1,eno);
       ResultSet rs=stm.executeQuery();
       clsempprp p=new clsempprp();
       if(rs.next())
       {
           p.setEmpno(rs.getInt("empcod"));
           p.setEmpnam(rs.getString("empnam"));
           p.setEmppic(rs.getString("emppic"));
           p.setEmploc(rs.getString("emploc"));
           p.setEmpphnno(rs.getString("empphnno"));
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
   public ArrayList<clsempprp> dspemp() throws IOException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       java.sql.CallableStatement stm=(java.sql.CallableStatement) databaseconnectivity.con.prepareCall("{call dspemp()}");
       ResultSet rs=stm.executeQuery();
      ArrayList<clsempprp> k= new ArrayList<clsempprp>();
       while(rs.next())
       {
           clsempprp p=new clsempprp();
           p.setEmpno(rs.getInt("empcod"));
           p.setEmpnam(rs.getString("empnam"));
           p.setEmppic(rs.getString("emppic"));
           p.setEmploc(rs.getString("emploc"));
           p.setEmpphnno(rs.getString("empphnno"));
           k.add(p);
       }
           databaseconnectivity.closecon();
           return k;
       
   }
   public ArrayList<clsempprp> dspempbyloc(String loc)
   {
           ArrayList<clsempprp> k=new ArrayList<clsempprp>();
        try
        {
           databaseconnectivity.getcon();
           java.sql.CallableStatement stm=databaseconnectivity.con.prepareCall("{call dspempbyloc(?)}");
           stm.setString(1,loc);
           ResultSet rs=stm.executeQuery();
           
           while(rs.next())
           {
               clsempprp p=new clsempprp();
               p.setEmpno(rs.getInt("empcod"));
               p.setEmpnam(rs.getString("empnam"));
               p.setEmppic(rs.getString("emppic"));
               p.setEmploc(rs.getString("emploc"));
               p.setEmpphnno(rs.getString("empphnno"));
               k.add(p);
           }
               databaseconnectivity.closecon();
       } catch (IOException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       }
        return k;
   }
   public void delemp(clsempprp p)
   {
       try {
           databaseconnectivity.getcon();
           CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call delemp(?)}");
           stm.setInt(1, p.getEmpno());
           stm.execute();
           databaseconnectivity.closecon();
       } catch (IOException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ClassNotFoundException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       } catch (SQLException ex) {
           Logger.getLogger(clsemp.class.getName()).log(Level.SEVERE, null, ex);
       }
   }
}

