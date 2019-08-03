<%--
  Created by IntelliJ IDEA.
  User: 11714
  Date: 2019/8/3
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>学生界面</title>
</head>
<body>
    <%--  --%>
    <table border="1" width="600">
        <tr>
            <a href="">添加学生信息</a>
        </tr>
        <tr>
            <td>姓名</td>
            <td>学号</td>
            <td>年龄</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${students}" var="list">
            <tr>
                <td>${list.name}</td>
                <td>${list.id}</td>
                <td>${list.age}</td>
                <td>
                    <a href="/student/delete?id=${list.id}">删除</a>
                    <a href="">编辑</a>
                </td>
            </tr>
            <tr>

            </tr>
        </c:forEach>

    </table>
</body>
</html>
