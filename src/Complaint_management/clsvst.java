
package Complaint_management;
import com.mysql.jdbc.CallableStatement;
import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class clsvst 
{
   public void insvst(clsvstprp p) throws ClassNotFoundException, IOException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call insvst(?,?,?,?)}");
       stm.setInt(1, p.getVstcmpcod());
       stm.setString(2, p.getVstdsc());
       stm.setInt(3,p.getVstfed());
       java.sql.Date s = new java.sql.Date(p.getVstdat().getTime());
       stm.setDate(4,s);
       stm.execute();
       databaseconnectivity.closecon();
   }
   public void updvst(clsvstprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call updvst(?,?,?,?,?)}");
       stm.setInt(1, p.getVstcod());
        java.sql.Date s = new java.sql.Date(p.getVstdat().getTime());
            stm.setDate(2,s);
       stm.setInt(3, p.getVstcmpcod());
       stm.setString(4, p.getVstdsc());
       stm.setInt(5, p.getVstfed());
       stm.execute();
       databaseconnectivity.closecon();
   }
   public clsvstprp fndvst(int vcod) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call fndvst(?)}");
       stm.setInt(1,vcod);
       ResultSet rs=stm.executeQuery();
       clsvstprp p=new clsvstprp();
       if(rs.next())
       {
           p.setVstcod(rs.getInt("vstcod"));
           p.setVstdat(rs.getDate("vstdat"));
           p.setVstcmpcod(rs.getInt("vstcmpcod"));
           p.setVstdsc(rs.getString("vstdsc"));
           p.setVstfed(rs.getInt("vstfed"));
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
    /*public List<clsaccprp> dspacc() throws IOException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call dspacc()}");
       ResultSet rs=stm.executeQuery();
       List <clsacccprp> k= new ArrayList<clsaccprp>();
       while(rs.next())
       {
           clsaccprp p=new clsaccprp();
           k.setAccno(rs.getInt("accno"));
           k.setAccnam(rs.getString("accnam"));
           k.setAccrtdat(rs.getDate("accrtdat"));
           k.setAccadd(rs.getString("accadd"));
           k.setAccloc(rs.getString("accloc"));
           k.setAccphnno(rs.getString("accphnno"));
           k.setAcctyp(rs.getString("acctyp"));
           k.add(p);
           databaseconnectivity.closecon();
           return k;
       }
   }*/
   public void delvst(clsvstprp p) throws IOException, FileNotFoundException, ClassNotFoundException, SQLException
   {
       databaseconnectivity.getcon();
       CallableStatement stm=(CallableStatement) databaseconnectivity.con.prepareCall("{call delvst(?)");
       stm.setInt(1, p.getVstcod());
       stm.execute();
       databaseconnectivity.closecon();
   }
}


