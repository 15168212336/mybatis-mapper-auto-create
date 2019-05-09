package com.example.secondmodule.entity;

public class Constant {
    enum MAPPER_CONST {
        MAPPER_HEAD("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >");
        private String value;

        MAPPER_CONST(String value) {
            this.value = value;
        }
    }
}
