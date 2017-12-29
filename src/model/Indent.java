package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Indent {
    private int indentNumber;
    private String orderAccount;
    private String indentStatus;
    private String roomProporty;
    private long checkInTime;
    private long checkOutTime;
    private String person_1;
    private String person_2;
    private String person_3;

    public String checkInTimeString(){
        String checkInTimeString="";
        if (this.checkInTime==0){
            return checkInTimeString;
        }
        Date date=new Date(this.checkInTime);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
        checkInTimeString=simpleDateFormat.format(date);
        return checkInTimeString;
    }

    public String checkOutTimeString(){
        String checkOutTimeString="";
        if (this.checkOutTime==0){
            return checkOutTimeString;
        }
        Date date=new Date(this.checkOutTime);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
        checkOutTimeString=simpleDateFormat.format(date);
        return checkOutTimeString;
    }

    public String getIndentStatus() {
        return indentStatus;
    }

    public void setIndentStatus(String indentStatus) {
        this.indentStatus = indentStatus;
    }

    public String getRoomProporty() {
        return roomProporty;
    }

    public void setRoomProporty(String roomProporty) {
        this.roomProporty = roomProporty;
    }

    public long getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(long checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public long getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(long checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getPerson_3() {

        return person_3;
    }

    public void setPerson_3(String person_3) {
        this.person_3 = person_3;
    }

    public String getPerson_2() {

        return person_2;
    }

    public void setPerson_2(String person_2) {
        this.person_2 = person_2;
    }

    public String getPerson_1() {

        return person_1;
    }

    public void setPerson_1(String person_1) {
        this.person_1 = person_1;
    }

    public String getOrderAccount() {
        return orderAccount;
    }

    public void setOrderAccount(String orderAccount) {
        this.orderAccount = orderAccount;
    }

    public int getIndentNumber() {

        return indentNumber;
    }

    public void setIndentNumber(int indentNumber) {
        this.indentNumber = indentNumber;
    }
}
