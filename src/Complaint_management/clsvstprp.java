
package Complaint_management;

import java.sql.Date;


public class clsvstprp 
{
  private int vstcod,vstcmpcod,vstfed;
  private String vstdsc;
  private Date vstdat;

    public int getVstcod() {
        return vstcod;
    }

    public void setVstcod(int vstcod) {
        this.vstcod = vstcod;
    }

    public int getVstcmpcod() {
        return vstcmpcod;
    }

    public void setVstcmpcod(int vstcmpcod) {
        this.vstcmpcod = vstcmpcod;
    }

    public int getVstfed() {
        return vstfed;
    }

    public void setVstfed(int vstfed) {
        this.vstfed = vstfed;
    }

    public String getVstdsc() {
        return vstdsc;
    }

    public void setVstdsc(String vstdsc) {
        this.vstdsc = vstdsc;
    }

    public Date getVstdat() {
        return vstdat;
    }

    public void setVstdat(Date vstdat) {
        this.vstdat = vstdat;
    }
  
}
