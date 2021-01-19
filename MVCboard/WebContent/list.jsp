<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>

	<table border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach items="${list }" var="dto">
		
		<tr>
			<td> ${dto.bId}</td>
			<td> ${dto.nName}</td>
			
			<td> <c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
            <a href="content_view.do?bId=${dto.bId}">${dto.bTitle}</a>
			 </td>
			
			<td>${dto.bDate }</td>
			<td>${dto.bHit }</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="writeView.do">글작성</a> </td>
		</tr>
	</table>

</body>
</html>