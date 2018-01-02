package DAO;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectHotel implements DatabaseConnection{
    private Connection connection;
    private PreparedStatement preparedStatement;
    ConnectHotel() {
        DataSource dataSource = null;
        try {
            Context context = new InitialContext();
            dataSource = (DataSource) context.lookup("java:comp/env/mysql/hotel");
        } catch (NamingException e) {
            e.printStackTrace();
        }
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet allRoom(){
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM room");
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet allAdministor() {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM normalAdministor " +
                    "ORDER BY AdministorLevel");
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet allStaff() {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM staffMember");
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet staffFindById(String id) {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM staffMember " +
                    "WHERE staffId=?");
            preparedStatement.setString(1,id);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet administorFindByAccount(String account) {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM normaladministor " +
                    "WHERE AdministorAccount=?");
            preparedStatement.setString(1,account);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet roomsFindById(String roomId){
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM room " +
                    "WHERE roomId=?");
            preparedStatement.setString(1,roomId);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet roomsFindByFloor(int floor){
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM room " +
                    "WHERE roomFloor=?");
            preparedStatement.setInt(1,floor);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet roomsFindByProporty(String proporty){
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM room " +
                    "WHERE roomProporty=?");
            preparedStatement.setString(1,proporty);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet roomsFindByDirection(String direction) {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM room " +
                    "WHERE roomDirection=?");
            preparedStatement.setString(1,direction);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet roomsFindByStatus(String status) {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM room " +
                    "WHERE roomStatus=?");
            preparedStatement.setString(1,status);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet usefulRoomsFindByTime(long limitTime) {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM room " +
                    "WHERE roomStatus='empty' OR leaveRoomTime<?");
            preparedStatement.setLong(1,limitTime);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet indentFindByOrderAccount(String orderAccount) {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM indent " +
                    "WHERE orderAccount=? ORDER BY checkInTime,indentStatus DESC");
            preparedStatement.setString(1,orderAccount);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ResultSet indentFindByIdentification(String identification) {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM indent " +
                    "WHERE (person_1=? OR person_2=? OR person_3=?) AND " +
                    "indentStatus='undone'");
            preparedStatement.setString(1,identification);
            preparedStatement.setString(2,identification);
            preparedStatement.setString(3,identification);
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void insertNewNormalAdministor(String account, String password, String username, String level) {
        try {
            preparedStatement=connection.prepareStatement("INSERT INTO normalAdministor " +
                    //"(AdministorAccount,AdministorPassword,username,AdministorLevel) " +
                    "VALUES (?,?,?,?)");
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,level);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertNewNormalAdministor(String account, String password, String username, String level, String identification) {
        try {
            preparedStatement=connection.prepareStatement("INSERT INTO normalAdministor " +
                    //"(AdministorAccount,AdministorPassword,username,AdministorLevel,personalIdentification) " +
                    "VALUES(?,?,?,?,?)");
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,username);
            preparedStatement.setString(4,level);
            preparedStatement.setString(5,identification);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAdministorIdentificationByAccount(String account, String identification) {
        try {
            preparedStatement=connection.prepareStatement("UPDATE normalAdministor SET " +
                    "personalIdentification=? WHERE AdministorAccount=?");
            preparedStatement.setString(1,account);
            preparedStatement.setString(2,identification);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertNewStaff(String id, String password, String name, String position) {
        try {
            preparedStatement=connection.prepareStatement("INSERT INTO staffMember" +
                    "(staffId,staffPassword,staffName,staffPosition) VALUES " +
                    "(?,?,?,?)");
            preparedStatement.setString(1,id);
            preparedStatement.setString(2,password);
            preparedStatement.setString(3,name);
            preparedStatement.setString(4,position);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteNormalAdministorByAccount(String account) {
        try {
            preparedStatement=connection.prepareStatement("DELETE FROM normalAdministor " +
                    "WHERE AdministorAccount=?");
            preparedStatement.setString(1,account);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStaffById(String id) {
        try {
            preparedStatement=connection.prepareStatement("DELETE FROM starffMember " +
                    "WHERE starffId=?");
            preparedStatement.setString(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void insertNewIndent(String orderAccount, String roomProporty, String indentStatus,
                                long checkInTime, long checkOutTime,
                                String person_1, String person_2, String person_3) {
        try {
            preparedStatement=connection.prepareStatement("INSERT INTO indent" +
                    "(orderAccount,roomProporty,indentStatus,checkInTime,checkOutTime," +
                    "person_1,person_2,person_3) VALUES (?,?,?,?,?,?,?,?)");
            preparedStatement.setString(1,orderAccount);
            preparedStatement.setString(2,roomProporty);
            preparedStatement.setString(3,indentStatus);
            preparedStatement.setLong(4,checkInTime);
            preparedStatement.setLong(5,checkOutTime);
            preparedStatement.setString(6,person_1);
            preparedStatement.setString(7,person_2);
            preparedStatement.setString(8,person_3);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void finishIndent(int indentNumber) {
        try {
            preparedStatement=connection.prepareStatement("UPDATE indent SET indentStatus='done' " +
                    "WHERE indentNumber=?");
            preparedStatement.setInt(1,indentNumber);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkIn(String roomId,long leaveRoomTime) {
        try {
            preparedStatement=connection.prepareStatement("UPDATE room SET roomStatus='full'," +
                    "leaveRoomTime=? WHERE roomId=?");
            preparedStatement.setLong(1,leaveRoomTime);
            preparedStatement.setString(2,roomId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void checkOut(String roomId) {
        try {
            preparedStatement=connection.prepareStatement("UPDATE room SET " +
                    "roomStatus='empty',leaveRoomTime=NULL WHERE roomId=?");
            preparedStatement.setString(1,roomId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
