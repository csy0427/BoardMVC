<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-04
  Time: 오전 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WriteResult</title>
</head>
<%
    String title= (String) request.getAttribute("title");
    String content= (String) request.getAttribute("content");
%>
<tr align="center">
    <td><%=title%></td>
    <td><%=content%></td>
    <td>
        <button onclick="location.href='./list'">정상적으로 등록되었습니다.</button>
    </td>
</tr>
</form>
</body>
</html>

