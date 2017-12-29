package DAO;

import model.Administor;
import model.Indent;
import model.Room;
import model.Staff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConnectHotelDAO {
    private ConnectHotel connectHotel;
    public ConnectHotelDAO(){
        connectHotel=new ConnectHotel();
    }

    private ArrayList<Room> changeRoomsResultToRoomList(ResultSet resultRooms){
        ArrayList<Room> rooms=new ArrayList<Room>();
        try {
            while (resultRooms.next()){
                Room newRoom=new Room();
                newRoom.setRoomId(resultRooms.getString("roomId"));
                newRoom.setRoomFloor(resultRooms.getInt("roomFloor"));
                newRoom.setRoomProporty(resultRooms.getString("roomProporty"));
                newRoom.setRoomDirection(resultRooms.getString("roomDirection"));
                newRoom.setRoomStatus(resultRooms.getString("roomStatus"));
                newRoom.setLeaveRoomTime(resultRooms.getLong("leaveRoomTime"));
                newRoom.setPrice(resultRooms.getFloat("roomPrice"));
                rooms.add(newRoom);
            }
            return rooms;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Staff> changeStaffsResultToStaffList(ResultSet resultStaffs){
        ArrayList<Staff> staffList=new ArrayList<Staff>();
        try {
            while (resultStaffs.next()){
                Staff newStaff=new Staff();
                newStaff.setStaffId(resultStaffs.getString("staffId"));
                newStaff.setStaffPassword(resultStaffs.getString("staffPassword"));
                newStaff.setStaffName(resultStaffs.getString("staffName"));
                newStaff.setStaffPosition(resultStaffs.getString("staffPosition"));
                staffList.add(newStaff);
            }
            return staffList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Administor> changeAdministorsResultToAdministorList(ResultSet resultAdministors){
        ArrayList<Administor> administors=new ArrayList<Administor>();
        try {
            while (resultAdministors.next()){
                Administor newAdministor=new Administor();
                newAdministor.setAdministorAccount(resultAdministors.getString("AdministorAccount"));
                newAdministor.setAdministorPassword(resultAdministors.getString("AdministorPassword"));
                newAdministor.setUsername(resultAdministors.getString("username"));
                newAdministor.setAdministorlevel(resultAdministors.getString("AdministorLevel"));
                newAdministor.setPersonalIdentification(resultAdministors.getString("personalIdentification"));
                administors.add(newAdministor);
            }
            return administors;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private ArrayList<Indent> changeIndentsResultToIndentList(ResultSet resultIndents){
        ArrayList<Indent> indents=new ArrayList<Indent>();
        try {
            while (resultIndents.next()){
                Indent newIndent=new Indent();
                newIndent.setIndentNumber(resultIndents.getInt("indentNumber"));
                newIndent.setOrderAccount(resultIndents.getString("orderAccount"));
                newIndent.setIndentStatus(resultIndents.getString("indentStatus"));
                newIndent.setRoomProporty(resultIndents.getString("roomProporty"));
                newIndent.setCheckInTime(resultIndents.getLong("checkInTime"));
                newIndent.setCheckOutTime(resultIndents.getLong("checkOutTime"));
                newIndent.setPerson_1(resultIndents.getString("person_1"));
                newIndent.setPerson_2(resultIndents.getString("person_2"));
                newIndent.setPerson_3(resultIndents.getString("person_3"));
                indents.add(newIndent);
            }
            return indents;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<Room> allRoom(){
        ArrayList<Room> rooms=changeRoomsResultToRoomList(connectHotel.allRoom());
        connectHotel.closeConnection();
        return rooms;
    }

    public ArrayList<Administor> allAdministor(){
        ArrayList<Administor> administors=changeAdministorsResultToAdministorList(connectHotel.allAdministor());
        connectHotel.closeConnection();
        return administors;
    };

    public Administor administorFindByAccount(String account){
        Administor foundAdministor=null;
        ArrayList<Administor> administors=changeAdministorsResultToAdministorList(
                connectHotel.administorFindByAccount(account));
        connectHotel.closeConnection();
        if (administors.size()==1){
            foundAdministor=administors.get(0);
        }
        return foundAdministor;
    }

    public ArrayList<Staff> allStaff(){
        ArrayList<Staff> staffs= changeStaffsResultToStaffList(connectHotel.allStaff());
        connectHotel.closeConnection();
        return staffs;
    };

    public Staff staffFindById(String id){
        Staff foundStaff=null;
        ArrayList<Staff> staffs= changeStaffsResultToStaffList(connectHotel.staffFindById(id));
        if (staffs.size()==1){
            foundStaff=staffs.get(0);
        }
        return foundStaff;
    }

    public ArrayList<Room> roomsFindById(String roomId){
        ArrayList<Room> rooms=changeRoomsResultToRoomList(connectHotel.roomsFindById(roomId));
        connectHotel.closeConnection();
        return rooms;
    }

    public ArrayList<Room> roomsFindByFloor(int floor){
        ArrayList<Room> rooms=changeRoomsResultToRoomList(connectHotel.roomsFindByFloor(floor));
        connectHotel.closeConnection();
        return rooms;
    }

    public ArrayList<Room> roomsFindByProporty(String proporty){
        ArrayList<Room> rooms=changeRoomsResultToRoomList(connectHotel.roomsFindByProporty(proporty));
        connectHotel.closeConnection();
        return rooms;
    }

    public ArrayList<Room> roomsFindByDirection(String direction){
        ArrayList<Room> rooms=changeRoomsResultToRoomList(connectHotel.roomsFindByDirection(direction));
        connectHotel.closeConnection();
        return rooms;
    }

    public ArrayList<Room> roomsFindByStatus(String status){
        ArrayList<Room> rooms=changeRoomsResultToRoomList(connectHotel.roomsFindByStatus(status));
        connectHotel.closeConnection();
        return rooms;
    }

    public ArrayList<Room> usefulRoomsFindByTime(long limitTime){
        ArrayList<Room> rooms=changeRoomsResultToRoomList(connectHotel.usefulRoomsFindByTime(limitTime));
        connectHotel.closeConnection();
        return rooms;
    }

    public ArrayList<Indent> indentFindByOrderAccount(String orderAccount){
        ArrayList<Indent> indents=changeIndentsResultToIndentList(connectHotel.indentFindByOrderAccount(orderAccount));
        connectHotel.closeConnection();
        return indents;
    }

    public ArrayList<Indent> indentFindByIdentification(String identification){
        ArrayList<Indent> indents=changeIndentsResultToIndentList(connectHotel.indentFindByIdentification(identification));
        connectHotel.closeConnection();
        return indents;
    }

    public void insertNewNormalAdministor(String account,String password,
                                   String username,String level){
        connectHotel.insertNewNormalAdministor(account,password,username,level);
        connectHotel.closeConnection();
    }

    public void insertNewNormalAdministor(Administor newAdministor){
        connectHotel.insertNewNormalAdministor(newAdministor.getAdministorAccount(),
                newAdministor.getAdministorPassword(),
                newAdministor.getUsername(),
                newAdministor.getAdministorlevel(),
                newAdministor.getPersonalIdentification());
        connectHotel.closeConnection();
    }

    public void updateAdministorIdentificationByAccount(String account,String identification){
        connectHotel.updateAdministorIdentificationByAccount(account,identification);
        connectHotel.closeConnection();
    }

    public void insertNewStaff(Staff newStaff){
        connectHotel.insertNewStaff(newStaff.getStaffId(),
                newStaff.getStaffPassword(),
                newStaff.getStaffName(),
                newStaff.getStaffPosition());
        connectHotel.closeConnection();
    }

    public void deleteNormalAdministorByAccount(String account){
        connectHotel.deleteNormalAdministorByAccount(account);
        connectHotel.closeConnection();
    }

    public void insertNewIndent(Indent newIndent){
        connectHotel.insertNewIndent(newIndent.getOrderAccount(),
                newIndent.getRoomProporty(),
                newIndent.getIndentStatus(),
                newIndent.getCheckInTime(),
                newIndent.getCheckOutTime(),
                newIndent.getPerson_1(),
                newIndent.getPerson_2(),
                newIndent.getPerson_3());
        connectHotel.closeConnection();
    }

    public void deleteStarffById(String id){
        connectHotel.deleteStaffById(id);
        connectHotel.closeConnection();
    }

    public void finishIndent(int indentNumber){
        connectHotel.finishIndent(indentNumber);
        connectHotel.closeConnection();
    }

    public void checkIn(String roomId,long leaveRoomTime){
        connectHotel.checkIn(roomId,leaveRoomTime);
        connectHotel.closeConnection();
    }

    public void checkOut(String roomId){
        connectHotel.checkOut(roomId);
        connectHotel.closeConnection();
    }

}
