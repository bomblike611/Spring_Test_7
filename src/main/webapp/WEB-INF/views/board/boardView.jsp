<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>${board}View</h1>
<h1>${view.title }</h1>
<h1>${view.writer }</h1>
<h1>${view.contents }</h1>
<c:forEach items="${view.files}" var="f" >
<a href="../file/fileDown?fname=${f.fname}&oname=${f.oname}">${f.oname}</a>
</c:forEach>
<a href="${board}Update?num=${view.num}">Update</a>
<a href="${board}Delete?num=${view.num}">Delete</a>
</body>
</html>