<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Member Join</h1>
<form action="memberJoin" method="post" enctype="multipart/form-data">
<p>ID : <input type="text" name="id"></p>
<p>PW : <input type="text" name="pw"></p>
<p>NAME : <input type="text" name="name"></p>
<p>EMAIL : <input type="email" name="email"></p>
<p>PHONE : <input type="text" name="phone"></p>
<p>AGE : <input type="number" name="age"></p>
<p>JOB : Student<input type="radio" name="job" value="S" checked="checked">Teacher<input type="radio" name="job" value="T"></p>
<p>File : <input type="file" name="file"></p>
<button>Join</button>
</form>
</body>
</html>