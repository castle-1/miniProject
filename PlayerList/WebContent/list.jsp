<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<h1>선수 리스트</h1>
	<form action="updateView.pl" method="post">
	<table border="1">
		<tr>
			<td>포지션 </td>
			<td>이름 </td>
			<td>국적 </td>
			<td>리그 </td>
			<td>소속팀 </td>
		</tr>
		<c:forEach items="${list }" var="pldto">
		<tr>
		
		
			<td> ${pldto.pPosition }</td>
			<td> <a href="modifyView.pl?pName=${pldto.pName }">${pldto.pName }</a>  </td>	
			<td> ${pldto.pNationality }</td>	
			<td> ${pldto.pLeague }</td>	
			<td> ${pldto.pTeam }</td>			
		
		</tr>
		</c:forEach>
		<tr>
			<td> <input type="submit" value="player UPdate">
		</tr>
	
	
	</table>
	</form>



</body>
</html>