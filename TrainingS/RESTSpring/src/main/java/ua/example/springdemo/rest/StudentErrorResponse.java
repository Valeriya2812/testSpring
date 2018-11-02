package ua.example.springdemo.rest;

public class StudentErrorResponse {
    private int status;
    private String message;
    private long timeStemp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(int status, String message, long timeStamp) {
        this.message = message;
        this.status=status;
        this.timeStemp=timeStamp;
    }

    public long getTimeStemp() {
        return timeStemp;
    }

    public void setTimeStemp(long timeStemp) {
        this.timeStemp = timeStemp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
