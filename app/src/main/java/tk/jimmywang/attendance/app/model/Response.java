package tk.jimmywang.attendance.app.model;

/**
 * <i>Created by WangJin on 2014-08-31 20:20.
 *
 * @author WangJin
 * @version 1.0
 */
public class Response<T> {

    private Integer status;

    private String message;

    private T data;

    public Response(Integer status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
