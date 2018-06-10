<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Works/addWorks.do" method="post">
	<input type="text" name="name" />
	<input type="submit" value="提交"/>
</form>

<h2>获取所有作品</h2>
<form action="Works/getAllWorks.do" method="post">
	<input type="submit" value="提交"/>
</form>
<br/><br/>
<hr/>


<h2>通过姓名获取所有作品</h2>
<form action="Works/getWorksByName.do" method="post">
	<input type="text" name="name" />
	<input type="submit" value="提交"/>
</form>
<br/><br/>
<hr/>

<h2>通过Id获取作品/h2>
<form action="Works/getWorksByWorksId.do" method="post" >
	<input type="text" name="worksId" />
	<input type="submit" value="提交"/>
</form>
<br/><br/>
<hr/>

<h2>通过remark获取作品/h2>
<form action="Works/getFindWokrs.do" method="post" >
	<input type="text" name="remark" />
	<input type="submit" value="提交"/>
</form>
<br/><br/>
<hr/>

<h2>上传文件/h2>
<form action="Works/worksFileUpload.do" method="post" enctype="multipart/form-data">
	<input type="file" name="photo1"/>
	<input type="file" name="photo2"/>
	<input type="file" name="photo3"/>
	<input type="submit" value="提交"/>
</form>
<br/><br/>
<hr/>
</body>
</html>