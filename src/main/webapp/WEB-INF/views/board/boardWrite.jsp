<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	var i=0;
	$("#add").click(function(){
		var ex=$("#ex").html();
		if(i<5){
		$("#result").append(ex);
		i++;
		}
	});
	
	$("#result").on("click",".X",function(){
		$(this).prev().remove();
		$(this).remove();
		i--;
	});
	
	/* var index=0;
	$("#add").click(function(){
		if(index<5){
		index++;
		$("#result").append('<p id="f'+index+'"><input type="file" name="file"><span class="X" id="'+index+'">X</span></p>');
		}else{
			alert("5개까지만 추가 가능합니다.");
		}
	}); */
	
	/* $("#result").on("click",".X",function(){
		var id=$(this).attr("id");
		if(index>0){
		$("#f"+id).remove();
		index--;
		}
	}); */

	
});
</script>
<style type="text/css">
.X{
cursor: pointer;
}
</style>
</head>
<body>
<h1>${board }Write</h1>

<form action="${board }Write" method="post" enctype="multipart/form-data">
<p>TITLE : <input type="text" name="title"></p>
<p>WRITER : <input type="text" name="writer"></p>
<p>CONTENTS : <textarea rows="" cols="" name="contents"></textarea></p>
<p><input type="button" value="fileadd" id="add"></p>
<div id="result">
</div>
<div id="ex">
<input type="file" name="file"><span class="X">X</span>
</div>
<button>Write</button>
</form>
</body>
</html>