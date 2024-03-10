package com.Assignment.crud.exceptionHandling;



public class ProjectNotFoundException extends RuntimeException {
    private int status;
    private String message;



    public ProjectNotFoundException() {
    }

    public ProjectNotFoundException(int status,String message) {
        this.message=message;
        this.status=status;
    }



    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
