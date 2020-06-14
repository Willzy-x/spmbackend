package com.example.spm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Files {
    private String name;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime = new Date();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
