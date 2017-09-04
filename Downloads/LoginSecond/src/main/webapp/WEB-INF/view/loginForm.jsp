<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-08-29
  Time: 오후 1:08
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome To My Login World</title>
</head>
<body>
<h1>로그인 페이지</h1>
<form action="./loginCheck" method="post">
    아이디: <input type="text" name="id" maxlength="15"/><br/><br/>
    비밀번호: <input type="password" name="password" maxlength="15"><br/><br/>
    <input type="submit" value="로그인"/>
    <input type="button" value="아이디/비밀번호 찾기"/>
    <input type="button" value="회원가입"/>
</form>
</body>
</html>
