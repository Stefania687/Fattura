<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
h1 {
	text-align: center;
	color: #cf3a0c;
}

.wrapper-ordini {
	margin: 30px auto;
	border: 2px solid #cf3a0c;
	border-radius: 5px;
	width: fit-content;
}

.ordine {
	display: flex;
	flex-direction: row;
	width: fit-content;
	border-bottom: 1px solid #cf3a0c;
}

.numero-ordine, .fattura {
	width: 150px;
	margin: 0;
	padding: 10px;
	text-align: center;
}

.numero-ordine {
	background-color: #F44611;
	color: #FFFFFF;
}

.fattura a {
	color: #F44611;
	text-decoration: none;
}

.fattura a:hover {
	text-decoration: underline;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>Lista Ordini</h1>
	<div class="wrapper-ordini">

		<c:forEach items="${listaOrdini}" var="ordine">
			<div class="ordine">
				<p class="numero-ordine">${ordine.numeroOrdine}</p>
				<p class="fattura">
					<a href="/fattura-pdf?numeroOrdine=${ordine.numeroOrdine}">Vedi Fattura</a>
				</p>
			</div>
		</c:forEach>
		
	</div>
</body>
</html>