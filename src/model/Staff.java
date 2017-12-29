package model;

public class Staff {
    private String staffId;
    private String staffPassword;
    private String staffName;
    private String staffPosition;

    public String getStaffPosition() {
        return staffPosition;
    }

    public void setStaffPosition(String staffPosition) {
        this.staffPosition = staffPosition;
    }

    public String getStaffName() {

        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPassword() {

        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public String getStaffId() {

        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }
}
