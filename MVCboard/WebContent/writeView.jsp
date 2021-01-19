<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeView</title>
</head>
<body>
	<form action="write.do" method="post">
		<table border="1" width="500" cellpadding="0" cellspacing="0">
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="nName">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="bTitle">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" name="bContent" cols=""></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="입력"> <a href="list.do">목록보기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>