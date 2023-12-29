package ept.volunteer.ws.requestpayload.response;

public class PayloadResponse {

    private String userId;
    private String userName;
    private String token;
    private String message;
    private String code;

    public PayloadResponse(String userId, String userName, String token, String message, String code) {
        this.userId = userId;
        this.userName = userName;
        this.token = token;
        this.message = message;
        this.code = code;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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
