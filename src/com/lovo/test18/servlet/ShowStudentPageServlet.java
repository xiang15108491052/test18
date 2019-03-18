package com.lovo.test18.servlet;

import com.lovo.test18.bean.PaginationBean;
import com.lovo.test18.bean.StudentBean;
import com.lovo.test18.service.IStudentService;
import com.lovo.test18.service.impl.StudentServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/ShowStudentPageServlet")
public class ShowStudentPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String currPageStr = request.getParameter("currPage");
        String studentName = request.getParameter("studentName");
        String className = request.getParameter("className");
        String startTime = request.getParameter("startTime");
        String endTime = request.getParameter("endTime");

/*        if (studentName == null || studentName.length() ==0){
            studentName = null;
        }
        if (className == null || className.length() ==0){
            className = null;
        }
        if (startTime == null || startTime.length() ==0){
            startTime = null;
        }
        if (endTime == null || endTime.length() ==0){
            endTime = null;
        }*/

        int currPage = Integer.parseInt(currPageStr);

        IStudentService studentService = new StudentServiceImpl();

        List<StudentBean> studentBeanList = studentService.getStudentList(currPage,studentName,className,startTime,endTime);
        //List<StudentBean> List = studentService.getStudentList(currPage,studentName,className,startTime,endTime);

        int totalPage = studentService.getAllStudentPage(studentName,className,startTime,endTime);

        PaginationBean paginationBean = new PaginationBean();
        paginationBean.setList(studentBeanList);
        paginationBean.setCurrPage(currPage);
        paginationBean.setTotalPage(totalPage);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(),paginationBean);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
