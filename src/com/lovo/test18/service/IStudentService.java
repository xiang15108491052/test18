package com.lovo.test18.service;

import com.lovo.test18.bean.StudentBean;

import java.util.List;

public interface IStudentService {


    /**
     * 根据条件找到数据的条数
     * @param studentName 学生名字
     * @param className 班级名字
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return 返回一个总页数
     */
    public int getAllStudentPage(String studentName,String className,String startTime,String endTime);

    /**
     * 根据条件进行分页
     * @param currPage 当前页数
     * @param studentName 学生名字
     * @param className 班级名字
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @return StudentBean集合
     */
    public List<StudentBean> getStudentList(int currPage,String studentName,String className,String startTime,String endTime);
}
