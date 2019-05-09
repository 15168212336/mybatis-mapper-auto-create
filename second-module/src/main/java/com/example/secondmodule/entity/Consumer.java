package com.example.secondmodule.entity;

import com.example.firstmodule.entity.User;

public class Consumer extends User {
    private Short sex;

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }
}
