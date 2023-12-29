package ept.volunteer.ws.models;

public class PayloadRequest {

    private Long id;
    private String data;

    public PayloadRequest(Long id, String data) {
        this.id = id;
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PayloadRequest{" +
                "id=" + id +
                ", data='" + data + '\'' +
                '}';
    }

}
