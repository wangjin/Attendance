package tk.jimmywang.attendance.app.model;

import java.io.Serializable;

/**
 * Created by 金 on 2014/8/27.
 */
public class Worker implements Serializable {

    private String workerName;

    private String workerPhone;

    public Worker() {
    }

    public Worker(String workerName, String workerPhone) {
        this.workerName = workerName;
        this.workerPhone = workerPhone;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public String getWorkerPhone() {
        return workerPhone;
    }

    public void setWorkerPhone(String workerPhone) {
        this.workerPhone = workerPhone;
    }
}
