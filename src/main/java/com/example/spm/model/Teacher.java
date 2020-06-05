package com.example.spm.model;

public class Teacher {
    private int tid;
    private String tname;
    private String hashedPassword;

    public Teacher() {
    }

    public Teacher(int tid) {
        this.tid = tid;
    }

    public Teacher(int tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Teacher(int tid, String tname, String hashedPassword) {
        this.tid = tid;
        this.tname = tname;
        this.hashedPassword = hashedPassword;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
}
