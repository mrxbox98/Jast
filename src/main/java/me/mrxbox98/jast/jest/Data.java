package me.mrxbox98.Jast.jest;

public class Data {

    private String message;

    private boolean success;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
