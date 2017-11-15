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
    private String timeStart;
    private String timeEnd;
    private String careRegime;

    public ScheduleDTO() {
    }

    public ScheduleDTO(int id, int customerid, int courseid,String timeStart, String timeEnd, String careRegime) {
        this.id = id;
        this.customerid = customerid;
        this.courseid = courseid;
     
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.careRegime = careRegime;
    }

    public ScheduleDTO(int customerid, int courseid, String timeStart, String timeEnd, String careRegime) {
        this.customerid = customerid;
        this.courseid = courseid;
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

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
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
        return "ScheduleDTO{" + "id=" + id + ", customerid=" + customerid + ", courseid=" + courseid + ", timeStart=" + timeStart + ", timeEnd=" + timeEnd + ", careRegime=" + careRegime + '}';
    }
    
    @Override
    public int compareTo(ScheduleDTO o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
