<%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-04
  Time: 오후 2:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>UpdatePost</title>
</head>
<body>
<h1>게시글 수정</h1>
<%
    String boardNumber= (String) request.getAttribute("boardNumber");
    request.setAttribute("boardNumber",boardNumber);
%>
<form method="post" action="/updateProcess?index=<%=boardNumber%>">
    게시글 번호 : <%=boardNumber%>
    <br><br>
    제목 : <input type="text" name="title">
    <br> <br>
    내용 : <input type="text" name="content">
    <button name="boardNumber" value="<%=boardNumber%>">게시글 등록</button>
</form>
</body>
</html>
