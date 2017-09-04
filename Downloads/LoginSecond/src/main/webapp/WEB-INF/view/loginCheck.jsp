<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-08-29
  Time: 오후 1:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>로그인 데이터</title>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String id= request.getParameter("id");
    String password= request.getParameter("password");
    String order="";
    Map<String,Map<String,String>> db= (Map<String, Map<String, String>>) request.getAttribute("dbArray");
    System.out.println(db.get(id).get("password") + password);
    if(db==null) System.out.println("null");
    else if(db.get(id)!=null){

        if(!db.get(id).get("password").equals(password)) {
            order="Your Password is not valid";
            password="0";
        }
        else{
            String realPassword=db.get(id).get("password");
            password= realPassword;
            order="Success";
        }
    }
    else{
        order="Your Id is not valid";
        id="0";
        password="0";
    }
%>

<h1>로그인 정보입니다. </h1><br/>
아이디: <%=id%><br/><br/>
비밀번호: <%=password%><br/><br/>
로그인 결과 : <%=order%>
<form action="./main" method="get">
    <button>게시판 입장</button>
</form>
</body>
</html>
