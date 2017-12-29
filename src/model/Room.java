package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Room {
    private String roomId;
    private int roomFloor;
    private String roomProporty;
    private String roomDirection;
    private String roomStatus;
    private long leaveRoomTime;
    private float price;

    public long getLeaveRoomTime() {
        return leaveRoomTime;
    }

    public void setLeaveRoomTime(long leaveRoomTime) {
        this.leaveRoomTime = leaveRoomTime;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getRoomDirection() {

        return roomDirection;
    }

    public void setRoomDirection(String roomDirection) {
        this.roomDirection = roomDirection;
    }

    public String getRoomProporty() {

        return roomProporty;
    }

    public void setRoomProporty(String roomProporty) {
        this.roomProporty = roomProporty;
    }

    public int getRoomFloor() {

        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public String leaveRoomTimeString(){
        String leaveTime="";
        if (this.leaveRoomTime==0){
            return leaveTime;
        }
        Date date=new Date(this.leaveRoomTime);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
        leaveTime=simpleDateFormat.format(date);
        return leaveTime;
    }
}
