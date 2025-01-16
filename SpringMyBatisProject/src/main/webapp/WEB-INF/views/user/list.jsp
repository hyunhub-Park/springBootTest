<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mybatis 회원</title>
</head>
<body>
<form:form modelAttribute="member" method="POST" action="search">
	<h3>회원 목록</h3>
	<!-- [단일] 검색기능 추가. -->
	<%-- TITLE : <form:input path="userId" /><input type="submit" value="검색" /> --%>
	
	<!-- [다중] 검색기능 추가. -->
	<!-- 하나의 입력창을 통해 userId와 userName을 검색 -->
	Search : <input type="text" name="searchKeyword" placeholder="아이디 또는 이름을 입력하세요..." style="width: 300px;"/>
			<input type="submit" value="검색" />
			&nbsp;
			<a href="/user/register">New</a>
			&nbsp;
			<a href="/user/list">List</a>

	<!-- 검색창 placeholder 스타일 적용. -->
			<style>
				input::placeholder
				{
					font-style: italic; /* placeholder 텍스트에 이탤릭체 적용 */
				}
			</style>
			
		<table border="1">
		<tr>
			<th align="center" width="60">NO</th>
			<th align="center" width="80">USERID</th>
			<th align="center" width="50">USERPW</th>
			<th align="center" width="50">USERNAME</th>
			<th align="center" width="180">REGDATE</th>
		</tr>
		<c:forEach items="${list}" var="member">
			<tr>
				<td align="center">${member.userNo}</td>
				<td align="center"><a href='/user/read?userNo=${member.userNo}'>${member.userId}</a></td>
				<td align="left">${member.userPw}</td>
				<td align="right">${member.userName}</td>
				<td align="center"><fmt:formatDate pattern="yyyy-MM-dd HH:mm"
						value="${member.regDate}" /></td>
			</tr>
		</c:forEach>
	</table>
</form:form>
</body>
</html>
