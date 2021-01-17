<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateView</title>
</head>
<body>
	<h1>선수 인적사항 기입란</h1>
	<form action="update.pl" method="post">
	<table border="1">
		<tr>
			<td>이름</td>
			<td><input type="text" name="pName"></td>
		</tr>
		<tr>
			<td>국적</td>
			<td><input type="text" name="pNationality"></td>
		</tr>
		<tr>
			<td>생년월일</td>
			<td><input type="date" name="pBirth"></td>
		</tr>
		<tr>
			<td>신장</td>
			<td><input type="text" name="pHeight"></td>
		</tr>
		<tr>
			<td>체중</td>
			<td><input type="text" name="pWeight"></td>
		</tr>
		<tr>
			<td>소속팀</td>
			<td><input type="text" name="pTeam"></td>
		</tr>
		<tr>
			<td>등번호</td>
			<td><input type="text" name="pBackNumber"></td>
		</tr>
		<tr>
			<td>포지션</td>
			<td><select name="pPosition">
					<option>FW</option>
					<option>MF</option>
					<option>DF</option>
					<option>GK</option>
			</select></td>
		</tr>
		<tr>
			<td>소속리그</td>
			<td><select name="pLeague">
					<option>프리미어리그</option>
					<option>분데스리그</option>
					<option>세리에A</option>
					<option>프리메라리그</option>
					<option>리그앙</option>
			</select></td>
		</tr>
		<tr >
			<td colspan="2"><input type="submit" value="업데이트"><a href="list.pl">return</a> </td>
		</tr>

	</table>
	</form>

</body>
</html>