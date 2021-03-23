package com.springboot.course.demo.dto;

import java.time.LocalDateTime;

public class CustomerRequestDTO {

    private String status;
    private int code;
    private LocalDateTime time;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
