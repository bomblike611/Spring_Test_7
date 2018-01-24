<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>MemberView</h1>
<img src="../resources/upload/${member.fname}">
<p>id :${member.id}</p>
<p>name :${member.name }</p>
<p>email :${member.email }</p>
<p>job :${member.job }</p>
<a href="./memberUpdate">Update</a>
<a href="./memberDelete?id=${member.id}&fname=${member.fname}">Delete</a>
</body>
</html>