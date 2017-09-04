<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-04
  Time: 오전 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ReadPost</title>
</head>
<body>
<%
    Map<String,String> returnBoard= (Map<String, String>) request.getAttribute("board");
    String title=returnBoard.get("title");
    String content=returnBoard.get("content");
    String views=returnBoard.get("views");
%>
<tr align="center">
    <td><%=title%></td>
    <td><%=content%></td>
    <td><%=views%></td>
</tr>
<table>
    <tr>
        <td colspan="6" align="right">
            &nbsp;
            <input type="button" value="리스트" onclick="location.href='./list'"/>
        </td>

    </tr>
</table>
</body>
</html>