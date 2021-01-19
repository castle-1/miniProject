<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>replyView</title>
</head>
<body>
	
		<table border="1" width="500" cellpadding="0" cellspacing="0">
		<form action="reply.do" method="post">
			<input type="hidden" name="bId" value="${replyView.bId}">
			<input type="hidden" name="bGroup" value="${replyView.bGroup}">
			<input type="hidden" name="bStep" value="${replyView.bStep}">
			<input type="hidden" name="bIndent" value="${replyView.bIndent}">
			<tr>
				<td>번호</td>
				<td>${replyView.bId }</td>
			</tr>
			<tr>
				<td>히트</td>
				<td>${replyView.bHit }</td>
			</tr>
			<tr>
				<td>이름</td>
				<td>
					<input type="text" name="nName" value="${replyView.nName}">
				</td>
			</tr>
			<tr>
				<td>제목</td>
				<td>
					<input type="text" name="bTitle" value="${replyView.bTitle}">
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="10" name="bContent" cols="">${replyView.bContent}</textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="답변"> <a href="list.do">목록보기</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>