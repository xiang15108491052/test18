package com.lovo.test18.dao.impl;

import com.lovo.test18.bean.StudentBean;
import com.lovo.test18.dao.IStudentDao;
import com.lovo.test18.mapper.StudentMapper;
import com.lovo.test18.util.DBUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;
import java.util.Map;

public class StudentDaoImpl implements IStudentDao {

    @Override
    public int getAllStudentCount(Map<String, Object> map) {

        SqlSession sqlSession = DBUtil.getSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        int count = studentMapper.getAllStudentCount(map);
        return count;
    }

    @Override
    public List<StudentBean> getStudentList(Map<String, Object> map) {
        SqlSession sqlSession = DBUtil.getSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<StudentBean> list = studentMapper.getStudentList(map);
        return list;
    }
}
