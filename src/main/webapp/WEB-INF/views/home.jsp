<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./notice/noticeList">Notice</a>
<a href="./qna/qnaList">Qna</a>

<c:if test="${empty member}">
<a href="./member/memberJoin">Join</a>
<a href="./member/memberLogin">Login</a>
</c:if>
<c:if test="${not empty member }">
<a href="./member/memberMypage">Mypage</a>
<a href="./member/memberLogout">Logout</a>
</c:if>
</body>
</html>
