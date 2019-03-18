package com.lovo.test18.service.impl;

import com.lovo.test18.bean.StudentBean;
import com.lovo.test18.dao.IStudentDao;
import com.lovo.test18.dao.impl.StudentDaoImpl;
import com.lovo.test18.service.IStudentService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements IStudentService {

    @Override
    public int getAllStudentPage(String studentName, String className, String startTime, String endTime) {
        Map<String,Object> map = new HashMap<>();
        IStudentDao studentDao = new StudentDaoImpl();

        if (studentName != null){
            map.put("studentName",studentName);
        }
        if (className != null){
            map.put("className",className);

        }
        if (endTime != null){
            map.put("endTime",endTime);
        }
        if (startTime != null){
            map.put("startTime",startTime);
        }
        int totalCount = studentDao.getAllStudentCount(map);

        return (totalCount + 10 - 1) / 10;
    }

    @Override
    public List<StudentBean> getStudentList(int currPage, String studentName, String className, String startTime, String endTime) {
        Map<String,Object> map = new HashMap<>();
        IStudentDao studentDao = new StudentDaoImpl();

        int pageSize = 10;

        if (className != null){
            map.put("className",className);
        }
        if (studentName != null){
            map.put("studentName",studentName);
        }
        if (endTime != null){
            map.put("endTime",endTime);
        }
        if (startTime != null){
            map.put("startTime",startTime);
        }
        if (currPage >= 1){
            int index = (currPage - 1) * pageSize;
            map.put("index",index);
        }
        map.put("pageSize",pageSize);


        return studentDao.getStudentList(map);
    }
}
