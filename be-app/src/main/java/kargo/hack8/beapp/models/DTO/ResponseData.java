package kargo.hack8.beapp.models.DTO;

import org.springframework.http.HttpStatus;

public class ResponseData<T> {
    private HttpStatus status;
    private String messages;

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    private T payload;

    public String getMessages() {
        return messages;
    }
    public void setMessages(String messages) {
        this.messages = messages;
    }
    public T getPayload() {
        return payload;
    }
    public void setPayload(T payload) {
        this.payload = payload;
    }
}