package com.example.secondmodule.entity;

public class Yuan extends BaseEntity {
    private String yuanName;
    private Long yuanGardenId;

    public String getYuanName() {
        return yuanName;
    }

    public void setYuanName(String yuanName) {
        this.yuanName = yuanName;
    }

    public Long getYuanGardenId() {
        return yuanGardenId;
    }

    public void setYuanGardenId(Long yuanGardenId) {
        this.yuanGardenId = yuanGardenId;
    }
}
