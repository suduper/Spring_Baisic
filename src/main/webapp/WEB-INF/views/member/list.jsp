<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- 태그라이브러리 참조 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
div#wrap {
	width: 600px;
	padding: 20px;
	border: 3px solid #aaa;
	border-radius: 6px;
	margin: 10px auto;
}

hr {
	margin: 10px;
}

table {
	width: 580px;
	border: 1px solid #aaa;
	margin: 10px;
}

table#memberTbl td {
	padding: 2px 10px;
	border: 1px solid #aaa;
}

table#memberTbl td:first-child {
	width: 30px;
	font-size: 17px;
	text-align: right:
}

a {
	font-size: 18px;
	padding: 4px 10px;
	cursor: pointer;
}
</style>
</head>
<body>

<div id="wrap">
	<h1>상세 내용 보기</h1>
	<hr />
	<table id="memberTbl">
		<thead>
			<tr>
				<th>번호</th>
				<th>ID</th>
				<th>이름</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="row" items="${data}">
		
			<tr>
				<td>${row.no}</td>
				<td>
				<a href="/detail?no=${row.no }">${row.uId }</a>
				</td>
				<td>${row.uName }</td>
				<td>${row.uEmail }</td>
			</tr>
			
		</c:forEach>
		</tbody>
	</table>
	
	<div>
			<a href="/create">회원가입</a>
	</div>
	
</div>

</body>
</html>