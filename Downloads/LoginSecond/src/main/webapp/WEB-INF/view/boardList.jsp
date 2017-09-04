<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: daou
  Date: 2017-09-04
  Time: 오전 10:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>BoardList</title>
</head>
<% Map<String, Map<String, String>> returnBoardList = (Map<String, Map<String, String>>) request.getAttribute("returnBoardList"); %>
<table>
    <tr align="center" >
        <td width="50px">글번호</td>
        <td width="400px">제목</td>
    </tr>
    <tr>
        <td colspan="4"><hr></hr></td>
    </tr>
    <%if(returnBoardList==null){ %>
    <tr>
        <td colspan="4">리스트 없음</td>
    </tr>
    <%}%>

    <%
        for(int indexI=1; indexI <= returnBoardList.size(); indexI++) {
        Map<String, String> board = returnBoardList.get(Integer.toString(returnBoardList.size()-indexI));
        System.out.println(Integer.toString(returnBoardList.size()-indexI));
    %>
    <tr align="center">
        <td><%=board.get("index")%></td>
        <td><a href="./read?index=<%=board.get("index")%>"><%=board.get("title")%></a></td>
        <td><input type="button" value="수정" onclick="location.href='./update_form?index=<%=board.get("index")%>'"></td>
        <td><input type="button" value="삭제" onclick="location.href='./remove?index=<%=board.get("index")%>'"></td>
    </tr>
    <tr>
        <td colspan="4"><hr></hr></td>
    </tr>
    <%}%>

    <tr>
        <td colspan="4" align="right">
            <input type="button" value="등록" onclick="location.href='./write_form'">
        </td>
    </tr>
</table>
</body>
</html>