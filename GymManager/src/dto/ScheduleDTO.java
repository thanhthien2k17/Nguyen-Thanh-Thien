/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Aptech
 */
public class ScheduleDTO implements Serializable, Comparable<ScheduleDTO>{
    private int id;
    private int customerid;
    private int courseid;
    private int userid;
    private Date timeStart;
    private Date timeEnd;
    private String careRegime;

    public ScheduleDTO() {
    }

    public ScheduleDTO(int id, int customerid, int courseid, int userid, Date timeStart, Date timeEnd, String careRegime) {
        this.id = id;
        this.customerid = customerid;
        this.courseid = courseid;
        this.userid = userid;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.careRegime = careRegime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public Date getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getCareRegime() {
        return careRegime;
    }

    public void setCareRegime(String careRegime) {
        this.careRegime = careRegime;
    }

    @Override
    public String toString() {
        return "ScheduleDTO{" + "id=" + id + ", customerid=" + customerid + ", courseid=" + courseid + ", userid=" + userid + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", careRegime=" + careRegime + '}';
    }
    

    @Override
    public int compareTo(ScheduleDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
