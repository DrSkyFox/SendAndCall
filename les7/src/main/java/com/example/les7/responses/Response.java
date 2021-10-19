package com.example.les7.responses;

import lombok.Data;


@Data
public class Response {
    private String msg;
    private String error;

    public Response(String msg, String error) {
        this.msg = msg;
        this.error = error;
    }
}
