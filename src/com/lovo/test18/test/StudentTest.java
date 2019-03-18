package com.lovo.test18.test;

import com.lovo.test18.bean.StudentBean;
import com.lovo.test18.mapper.StudentMapper;
import com.lovo.test18.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentTest {

    @Test
    public void getAllStudentCount(){
        Map<String,Object> map = new HashMap<>();
        map.put("className","J114");
        map.put("studentName","小");
        map.put("startTime","1994-09-29");
        map.put("endTime","1996-07-06");

        SqlSession sqlSession = DBUtil.getSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int totalCount = studentMapper.getAllStudentCount(map);
        Assert.assertEquals(3,totalCount);

    }

    @Test
    public void getStudentList(){

        Map<String,Object> map = new HashMap<>();
        map.put("className","J114");
        map.put("startTime","1994-09-29");
        map.put("studentName","小");
        map.put("endTime","1996-07-06");
        map.put("index",0);
        map.put("pageSize",3);

        SqlSession sqlSession = DBUtil.getSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentBean> list = studentMapper.getStudentList(map);
        Assert.assertNotNull(list);
    }
}
