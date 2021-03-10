<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${nameList}" var="nomeUtente">
		<div>
			<ul>
				<li>
					<a href="">${nomeUtente}</a>
				</li>
			</ul>

		</div>
	</c:forEach>
</body>
</html>