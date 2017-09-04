
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>게시글 작성</title>
</head>
<body>
<h1>게시글 작성</h1>
<form method="post" action="/writeProcess">
    제목 : <input type="text" name="title">
    <br> <br>
    내용 : <input type="text" name="content">
    <button>게시글 등록</button>
</form>
</body>
</html>
