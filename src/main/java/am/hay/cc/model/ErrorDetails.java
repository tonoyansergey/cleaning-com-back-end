package am.hay.cc.model;

import java.util.Date;

public class ErrorDetails {

    private Date timestamp;
    private String message;
    private String details;
    private Object data;

    public ErrorDetails() {
    }

    public ErrorDetails(final Date timestamp, final String message, final String details) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public ErrorDetails(final Date timestamp, final String message, final String details, final Object data) {
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
        this.data = data;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(final String details) {
        this.details = details;
    }

    public Object getData() {
        return data;
    }

    public void setData(final Object data) {
        this.data = data;
    }
}
