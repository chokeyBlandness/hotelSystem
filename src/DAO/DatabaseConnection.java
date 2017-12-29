package DAO;

import java.sql.ResultSet;

public interface DatabaseConnection {
    ResultSet allRoom();
    ResultSet allAdministor();
    ResultSet allStaff();
    ResultSet staffFindById(String id);
    ResultSet administorFindByAccount(String account);
    ResultSet roomsFindById(String roomId);
    ResultSet roomsFindByFloor(int floor);
    ResultSet roomsFindByProporty(String proporty);
    ResultSet roomsFindByDirection(String direction);
    ResultSet roomsFindByStatus(String status);
    ResultSet usefulRoomsFindByTime(long limitTime);
    ResultSet indentFindByOrderAccount(String orderAccount);
    ResultSet indentFindByIdentification(String identification);
    void insertNewNormalAdministor(String account,String password,
                                   String username,String level);
    void insertNewNormalAdministor(String account,String password,
                                   String username,String level,String identification);
    void updateAdministorIdentificationByAccount(String account,String identification);
    void insertNewStaff(String id,String password,String name,String position);
    void deleteNormalAdministorByAccount(String account);
    void deleteStaffById(String id);
    void insertNewIndent(String orderAccount,String roomProporty,String indentStatus,
                         long checkInTime,long checkOutTime,String person_1,
                         String person_2,String person_3);
    void finishIndent(int indentNumber);
    void checkIn(String roomId,long leaveRoomTime);
    void checkOut(String roomId);
    void closeConnection();

}
