<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>contentView</title>
</head>
<body>
	<form action="modify.do" method="post">
	<table border="1" width="500" cellpadding="0" cellspacing="0">
	 <input type="hidden" name="bId" value="${contentView.bId}">
		<tr>
			<td>번호</td>
			<td> ${contentView.bId } </td>
		</tr>
		<tr>
			<td>히트</td>
			<td> ${contentView.bHit } </td>
		</tr>
		<tr>
			<td>이름</td>
			<td> <input type="text" name="nName" value="${contentView.nName}"> </td>
		</tr>
		<tr>
			<td>제목</td>
			<td> <input type="text" name="bTitle" value="${contentView.bTitle}">  </td>
		</tr>
		<tr>
			<td>내용</td>
			<td> <textarea rows="10" name="bContent" cols="">${contentView.bContent}</textarea> </td>
		</tr>
		
		<tr>
			<td colspan="2"> <input type="submit" value="수정">
			<a href="list.do">목록보기</a>  <a href="delete.do?bId=${contentView.bId}">삭제</a>  <a href="reply_view.do?bId=${contentView.bId}">답변</a></td>
			
		</tr>
	
	
	</table>
</form>

</body>
</html>