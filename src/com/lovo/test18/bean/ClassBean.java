package com.lovo.test18.bean;

import java.util.List;

public class ClassBean {

    private int id;

    private String name;

    private String creatTime;

    private List<StudentBean> studentBeanList;

    public List<StudentBean> getStudentBeanList() {
        return studentBeanList;
    }

    public void setStudentBeanList(List<StudentBean> studentBeanList) {
        this.studentBeanList = studentBeanList;
    }

    public ClassBean() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }
}
