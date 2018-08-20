
package Complaint_management;

import com.mysql.jdbc.Connection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class databaseconnectivity 
{
    static Connection con;
    public static void getcon() throws FileNotFoundException, IOException, ClassNotFoundException, SQLException
    {
        if(con==null)
        {
            FileInputStream fis=new FileInputStream("config.properties");
            Properties prp=new Properties();
            prp.load(fis);
            fis.close();
            Class.forName(prp.getProperty("driver"));
            con=(Connection) DriverManager.getConnection(prp.getProperty("url"),prp.getProperty("username"),"");
        }
    }
public static void closecon() throws SQLException
{
    if(con==null)
    return;
    else
    {
        con.close();
        con=null;
    }
}
    
}
