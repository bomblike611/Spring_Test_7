<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	

	var i=${fn:length(nupdate.files)};
	var j=0;
	/* $(".f").each(function(){
		j++;
	}); */
	var total=5-j;
	$("#add").click(function(){
		var ex=$("#ex").html();
		if(i<5){
		$("#result").append(ex);
		i++;
		}else{
			alert("최대 5개까지만 가능합니다");
		}
	});
	//위임이 필요하기때문에 on을 사용하여 위임해줌
	$("#result").on("click",".X",function(){
		if(i>0){
		$(this).prev().remove();
		$(this).remove();
		i--;
		}
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
	 $(".del").click(function() {
		 var del=$(this);
         var fnum=$(this).attr("title");
         var fname=$(this).attr("id");
         var check=confirm("삭제 시 복구가 불가능합니다.");
         
         if(check){
            $.ajax({
               url:"../file/fileDelete",
               type:"GET",
               data:{
                  fnum:fnum,
                  fname:fname
               },
               success:function(data){
                  if(data.trim()==1){
                	  $(del).prev().remove();
                	  $(del).remove();
                	  i--;
                  }
               }
               
            });
         }
      });
	
});
</script>


<style type="text/css">
.X, .del{
cursor: pointer;
}

#ex{
display: none;}

</style>
</head>
<body>
<h1>${board }Update</h1>
<form action="${board }Update" method="post" enctype="multipart/form-data">
<input type="hidden" name="num" value="${nupdate.num }">
<p>TITLE : <input type="text" name="title" value="${nupdate.title }"></p>
<p>WRITER : <input type="text" name="writer" value="${nupdate.writer}" readonly="readonly"></p>
<p>CONTENTS : <textarea rows="" cols="" name="contents">${nupdate.contents }</textarea></p>
<p><input type="button" value="fileadd" id="add"></p>
<div id="result">
<c:forEach items="${nupdate.files }" var="f" varStatus="j">
	<p><input type="text" value="${f.oname}" disabled="disabled" class="f"><span class="del" id="${f.fname}" title="${f.fnum }">X</span></p>
</c:forEach>
</div>
<input type="submit" value="Button">
</form>
<div id="ex">
<p><input type="file" name="file"><span class="X">X</span></p>
</div>
</body>
</html>