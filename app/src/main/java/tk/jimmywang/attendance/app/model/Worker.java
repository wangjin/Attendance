package tk.jimmywang.attendance.app.model;

/**
 * <i>Created by WangJin on 2014-08-30 23:38.
 *
 * @author WangJin
 * @version 1.0
 */

public class Worker extends BaseModel{

    private String name;
    private String phoneNumber;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
