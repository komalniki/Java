
package Complaint_management;

import java.sql.Date;


public class clscmpprp 
{
    private int cmpcod,cmpaccno,cmpasgempcod;
    private String cmpdsc,cmpsts;
    private Date cmpdat;

    public int getCmpcod() {
        return cmpcod;
    }

    public void setCmpcod(int cmpcod) {
        this.cmpcod = cmpcod;
    }

    public int getCmpaccno() {
        return cmpaccno;
    }

    public void setCmpaccno(int cmpaccno) {
        this.cmpaccno = cmpaccno;
    }

    public int getCmpasgempcod() {
        return cmpasgempcod;
    }

    public void setCmpasgempcod(int cmpasgempcod) {
        this.cmpasgempcod = cmpasgempcod;
    }

    public String getCmpdsc() {
        return cmpdsc;
    }

    public void setCmpdsc(String cmpdsc) {
        this.cmpdsc = cmpdsc;
    }

    public Date getCmpdat() {
        return cmpdat;
    }

    public void setCmpdat(Date cmpdat) {
        this.cmpdat = cmpdat;
    }

   
    
    

    public String getCmpsts() {
        return cmpsts;
    }

    public void setCmpsts(String cmpsts) {
        this.cmpsts = cmpsts;
    }
    
}
