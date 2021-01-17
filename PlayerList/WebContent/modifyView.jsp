<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>modifyView</title>
</head>
<body>
	<h1>선수 상세정보 & 수정란</h1>
	<form action="modify.pl" method="post">
	<input type="hidden" name="pName" value="${ modifyView.pName}">
	<table border="1">
		
		<tr>
			<td>이름</td>
			<td>${modifyView.pName }</td>
		</tr>
		<tr>
			<td>국적</td>
			<td><input type="text" name="pNationality" value="${modifyView.pNationality }"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="text" name="pBirth" value="${modifyView.pBirth }"></td>
		</tr>
		<tr>
			<td>신장</td>
			<td><input type="text" name="pHeight" value="${modifyView.pHeight }"></td>
		</tr>
		<tr>
			<td>체중</td>
			<td><input type="text" name="pWeight" value="${modifyView.pWeight }"></td>
		</tr>
		<tr>
			<td>소속팀</td>
			<td><input type="text" name="pTeam" value="${modifyView.pTeam }"></td>
		</tr>
		<tr>
			<td>등번호</td>
			<td><input type="text" name="pBackNumber" value="${ modifyView.pBackNumber}"></td>
		</tr>
		<tr>
			<td>포지션</td>
			<td><input type="text" name="pPosition" value="${modifyView.pPosition }"></td>
		</tr>
		<tr>
			<td>소속리그</td>
			<td><input type="text" name="pLeague" value="${modifyView.pLeague }"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="modify"> <a href="list.pl">return</a>  <a href="delete.pl?pName=${ modifyView.pName}">delete </a> </td>
		</tr>

	</table>
	
	</form>

</body>
</html>