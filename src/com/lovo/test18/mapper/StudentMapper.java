package com.lovo.test18.mapper;

import com.lovo.test18.bean.StudentBean;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    /**
     * 根据条件获取到数据总条数
     * @param map map对象
     * @return 数量
     */
    public int getAllStudentCount(Map<String,Object> map);

    /**
     * 根据条件进行分页
     * @param map map对象
     * @return list集合
     */
    public List<StudentBean> getStudentList(Map<String,Object> map);
}
