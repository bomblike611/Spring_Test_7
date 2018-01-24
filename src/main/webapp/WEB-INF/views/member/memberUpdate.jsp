<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var i=1;
$("#f").click(function(){
	var check=confirm("삭제 시 복구가 불가능합니다.");
	if(check){
	$(this).prev().remove();
	$(this).remove();
	
	i--;
	}
});
	
	$("#btn").click(function(){
		if(i<1){
			$("#check").val("true");
			$("#file").html( );
		}else{
			alert("파일은 한개만 업로드 가능합니다.");
		}
	});
});
</script>
</head>
<body>
<h1>Member Update</h1>
<form action="memberUpdate" method="post" enctype="multipart/form-data">
<input type="hidden" name="id" value="${member.id }">
<input type="hidden" name="job" value="${member.job }">
<p>PW : <input type="text" name="pw" value="${member.pw }"></p>
<p>NAME : <input type="text" name="name" value="${member.name }"></p>
<p>EMAIL : <input type="email" name="email" value="${member.email }"></p>
<p>PHONE : <input type="text" name="phone" value="${member.phone }"></p>
<p>AGE : <input type="number" name="age" value="${member.age }"></p>
<input type="hidden" name="fname" value="${member.fname}">
<input type="hidden" name="oname" value="${member.oname}">
<input type="button" id="btn" value="fileadd">
<p id="file"><input type="text" value="${member.oname}" disabled="disabled"><span id="f">X</span></p>
<p><input type="hidden" id="check" name="check" value="false"></p>
<button>Join</button>
</form>
</body>
</html>