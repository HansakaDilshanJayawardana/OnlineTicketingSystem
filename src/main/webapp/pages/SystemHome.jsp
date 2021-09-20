<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dashboard</title>
<style type="text/css">

	h1{
		margin-left: 700px;
		color:#333333 ;
	 	text-transform: uppercase;
 		letter-spacing: 3px;
  		color: grey;
  		text-shadow: 2px 2px 5px white ;
  		font-family: Nunito,-apple-system,BlinkMacSystemFont,
  		"Segoe UI",Roboto,"Helvetica Neue",Arial,sans-serif,"Apple Color Emoji",
  		"Segoe UI Emoji","Segoe UI Symbol","Noto Color Emoji";
		font-weight: bold;
		margin-top:40px;
		font-size:45px;
		margin-bottom: 60px;
	
	}
	img{
		height:70px;width:70px;
		
	}
	.btnHome{
		  padding: 10px 15px;
  		  font-size: 15px;
		  text-align: center;
		  cursor: pointer;
		  outline: none;
		  color: #fffgg;
		  background-color:	 #4d94ff;
		  border: none;
		  border-radius: 15px;
		  box-shadow: 0 4px #999;
		  width:200px;
		  height:50px;
	
	}
	.TDpadding{
			padding-bottom:70px;
	}
	.box{
			margin-left: 315px;
	
	}

</style>
</head>
<body>


	<h1>Welcome!</h1>
	<br>
	<br>
	
	<div class="box">
	
	<table>
		<tr>
			<td class="TDpadding"><a href="students/addStudent.jsp"><img src="logos/student2.png"><input class="btnHome" type="submit" name="submit" value="STUDENT"></a></td>
			<td class="TDpadding"><a href="#"><img src="logos/teacher.png" ><input class="btnHome" type="button" value="TEACHER"></a></td>
			<td class="TDpadding"><a href="#"><img src="logos/time.png"><input class="btnHome" type="submit" name="submit" value="TIME TABLES"></a></td>
			<td class="TDpadding"><a href="#"><img src="logos/attendance.png" style="height:70px;width:70px"><input class="btnHome" type="button" value="ATTENDANCE"></a></td>
		</tr>
	
		<tr>
			<td class="TDpadding"><a href="#"><img src="logos/marks.png"><input class="btnHome" type="button" value="STUDENT MARKS"></a></td>
			<td class="TDpadding"><a href="#"><img src="logos/sport.png" ><input class="btnHome" type="button" style="font-size:11px" value="EXTRA CURRICULAR ACTIVITIES"></a></td>
			<td class="TDpadding"><a href="#"><img src="logos/exam2.png"><input class="btnHome" type="submit" name="submit" value="EXAM"></a></td>
			<td class="TDpadding"><a href="#"><img src="logos/inventory.png"><input class="btnHome" type="button" value="INVENTORY"></a></td>
		</tr>
	
	</table>

	</div>
		
	
</body>
</html>