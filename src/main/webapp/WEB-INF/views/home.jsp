<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>

<html>
<head>
	<title>Home</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){
		var message="${message}";
		if(message!=""){
			alert(message);
		}
		
	});
	</script>
</head>
<body>
<h1>
	Hello world!  
	${empty member}
	${member.id }
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="./notice/noticeList">Notice</a>
<a href="./qna/qnaList">Qna</a>

<c:if test="${empty member}">
<a href="./member/memberJoin">Join</a>
<a href="./member/memberLogin">Login</a>
</c:if>
<c:if test="${not empty member}">
<a href="./member/memberView">Mypage</a>
<a href="./member/memberLogout">Logout</a>
</c:if>

<a href="./transfer">Transfer</a>
</body>
</html>
