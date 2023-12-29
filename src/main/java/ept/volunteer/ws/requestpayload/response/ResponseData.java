package ept.volunteer.ws.requestpayload.response;

public class ResponseData {

    private String data;
    private String message;
    private String code;

    public ResponseData(String data, String message, String code) {
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public ResponseData() {

    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}
