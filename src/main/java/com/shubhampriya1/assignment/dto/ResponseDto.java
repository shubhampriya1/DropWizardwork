package com.shubhampriya1.assignment.dto;

public class ResponseDto {
    private String message;
    private int status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public ResponseDto(String message, int status) {
        this.message = message;
        this.status = status;
    }

}
