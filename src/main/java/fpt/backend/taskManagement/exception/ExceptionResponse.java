package fpt.backend.taskManagement.exception;

public class ExceptionResponse {
    private String status;
    private String message;

    public ExceptionResponse(String status, String message){
        this.status = status;
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }
}
