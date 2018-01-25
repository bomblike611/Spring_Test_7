<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/SE2/js/HuskyEZCreator.js" charset="utf-8"></script>
<script type="text/javascript">
$(function(){
	 //전역변수
    var obj = [];              
    //스마트에디터 프레임생성
    nhn.husky.EZCreator.createInIFrame({
        oAppRef: obj,
        elPlaceHolder: "contents",
        sSkinURI: "../resources/SE2/SmartEditor2Skin.html",
        htParams : {
            // 툴바 사용 여부
            bUseToolbar : true,            
            // 입력창 크기 조절바 사용 여부
            bUseVerticalResizer : true,    
            // 모드 탭(Editor | HTML | TEXT) 사용 여부
            bUseModeChanger : true,
        }
    });
    //전송버튼
    $("#insertBoard").click(function(){
        //id가 smarteditor인 textarea에 에디터에서 대입
        obj.getById["contents"].exec("UPDATE_CONTENTS_FIELD", []);
        //폼 submit
        $("#frm").submit();
    });
	var i=0;
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

	
}); 
</script>


<style type="text/css">
.X{
cursor: pointer;
}

#ex{
display: none;}

</style>
</head>

<body>
<h1>${board }Write</h1>

<form action="${board }Write" method="post" id="frm" enctype="multipart/form-data">
<p>TITLE : <input type="text" name="title"></p>
<p>WRITER : <input type="text" name="writer"></p>
<p>CONTENTS : <textarea rows="" cols="" name="contents" id="contents"></textarea></p>
<p><input type="button" value="fileadd" id="add"></p>
<div id="result">
</div>
<input type="button" value="Write" id="insertBoard">
</form>
<div id="ex">
<p><input type="file" name="file"><span class="X">X</span></p>
</div>
</body>
</html>