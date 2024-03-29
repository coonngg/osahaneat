package com.congne1.osahaneat.dto;

import jakarta.persistence.Column;

import java.util.Date;

public class UserDto {
    // Data Transfer Object: chuyển đổi dữ liệu từ entity sang class.để tránh vòng
    // lặp vô tận trong entity(entity không bao giờ xuất trực ra chuỗi json)
    private int id;

    private String userName;

    private String password;

    private String fullName;

    private Date createDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}
