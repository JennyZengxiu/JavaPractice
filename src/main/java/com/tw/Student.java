package com.tw;

public class Student {
    private String  name;
    private int stuNumber;
    Subject subject;

    public void setSubject(Subject subject){
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public int getStuNumber() {
        return stuNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStuNumber(int stuNumber) {
        this.stuNumber = stuNumber;
    }
}
