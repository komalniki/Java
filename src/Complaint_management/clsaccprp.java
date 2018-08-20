
package Complaint_management;

import java.sql.Date;




public class clsaccprp
{ 
   private int accno;
   private String accnam,accadd,accloc,accphnno,acctyp;
   private Date accdat;
   {
        accnam=new String();
         accadd=new String();
          accloc=new String();
           accphnno=new String();
            acctyp=new String();
            
    }

    public Date getAccdat() {
        return accdat;
    }

    public void setAccdat(Date accdat) {
        this.accdat = accdat;
    }

   
    
   

    public int getAccno() {
        return accno;
    }

    public void setAccno(int accno) {
        this.accno = accno;
    }

    public String getAccnam() {
        return accnam;
    }

    public void setAccnam(String accnam) {
        this.accnam = accnam;
    }

    public String getAccadd() {
        return accadd;
    }

    public void setAccadd(String accadd) {
        this.accadd = accadd;
    }

    public String getAccloc() {
        return accloc;
    }

    public void setAccloc(String accloc) {
        this.accloc = accloc;
    }

    public String getAccphnno() {
        return accphnno;
    }

    public void setAccphnno(String accphnno) {
        this.accphnno = accphnno;
    }

    public String getAcctyp() {
        return acctyp;
    }

    public void setAcctyp(String acctyp) {
        this.acctyp = acctyp;
    }

     
}
