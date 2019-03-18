<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>向川江</title>
    <script src="js/jquery-2.1.4.js"></script>
    <link rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.js"></script>
    <script type="text/javascript">
      $(function () {
        var currPage = 1;
        $.getJSON("ShowStudentPageServlet",{currPage:currPage},showStudentPage);
        $("button[name=page]").click(clickEvt);
        $("#search").click(clickSearchEvt);
      });

      function clickEvt() {
        var value = $(this).val();
        var currPage = $("input[name=currPage]").val();
        var totalPage = $("input[name=totalPage]").val();

        currPage = parseInt(currPage);
        totalPage = parseInt(totalPage);

        switch (value) {
          case "first":
            currPage = 1;
            $.getJSON("ShowStudentPageServlet",{currPage:currPage},showStudentPage);
            break;
          case "pre":
            currPage = currPage - 1;
            if (currPage < 1){
              currPage = 1;
            }
            $.getJSON("ShowStudentPageServlet",{currPage:currPage},showStudentPage);
            break;
          case "next":
            currPage = currPage + 1;
            if (currPage > totalPage){
              currPage = totalPage;
            }
            $.getJSON("ShowStudentPageServlet",{currPage:currPage},showStudentPage);
            break;
          case "last":
            currPage = totalPage;
            $.getJSON("ShowStudentPageServlet",{currPage:currPage},showStudentPage);
            break;
        }
      }

      function clickSearchEvt() {
        var currPage = $("input[name=currPage]").val();
        var studentName = $("#studentName").val();
        var className = $("#className").val();
        var startTime = $("#startTime").val();
        var endTime = $("#endTime").val();
        $.getJSON("ShowStudentPageServlet",{currPage:currPage,studentName:studentName,className:className,startTime:startTime,endTime:endTime},showStudentPage);
      }

      function showStudentPage(data) {
        var $tbody = $("tbody");
        $tbody.empty();
        $.each(data.list,function (i,e) {
          var num = i + 1;
          var studentName = e.name;
          var sex = e.sex;
          var birthday = e.birthday;
          var className = e.classBean.name;
          var tr = "<tr><td>" + num + "</td>" +
                  "<td>" + studentName + "</td>" +
                  "<td>" + sex + "</td>" +
                  "<td>" + birthday + "</td>" +
                  "<td>" + className +"</td></tr>";
          $tbody.append(tr);
        });

        var currPage = data.currPage;
        var totalPage = data.totalPage;

        $("input[name=currPage]").val(currPage);
        $("input[name=totalPage]").val(totalPage);
      }
    </script>
  </head>
  <body>
    <div class="container">
      <div class="row">
        <div class="col-sm-12">
          <h1 class="text-center">测试项目</h1>
        </div>
        <div class="col-sm-12">
          <form class="form-inline">
            <div class="form-group">
              <label for="studentName">名字</label>
              <input type="text" class="form-control" id="studentName">
            </div>
            <div class="form-group">
              <label for="className">班级</label>
              <input type="text" class="form-control" id="className" >
            </div>
            <div class="form-group">
              <label for="startTime">起始日期</label>
              <input type="date" class="form-control" id="startTime" >
            </div>
            <div class="form-group">
              <label for="endTime">结束日期</label>
              <input type="date" class="form-control" id="endTime" >
            </div>
            <button type="submit" class="btn btn-default" id="search" value="search">查询</button>
          </form>
        </div>
        <div class="col-sm-12">
          <table class="table table-striped">
            <thead>
              <tr class="info">
                <th>编号</th>
                <th>姓名</th>
                <th>性别</th>
                <th>生日</th>
                <th>班级</th>
              </tr>
            </thead>
            <tbody>
            </tbody>
          </table>
          <input type="hidden" name="currPage">
          <input type="hidden" name="totalPage">
          <button name="page" value="first" class="btn btn-info">首页</button>
          <button name="page" value="pre" class="btn btn-info">上一页</button>
          <button name="page" value="next" class="btn btn-info">下一页</button>
          <button name="page" value="last" class="btn btn-info">尾页</button>
        </div>
      </div>
    </div>
  </body>
</html>
