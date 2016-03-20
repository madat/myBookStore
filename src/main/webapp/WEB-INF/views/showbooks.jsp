
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>



	<h1>${msg}</h1>
	<h1>${allBooks}</h1>
	<c:if test="${not empty lists}">

		<ul>
			<c:forEach var="listValue" items="${lists}">
				<li>${listValue}</li>
			</c:forEach>
		</ul>

	</c:if>
	
	<c:if test="${not empty allBooks}">

		<ul>
			<c:forEach var="book" items="${allBooks}">
				<li>${book.bookName}</li>
			</c:forEach>
		</ul>

	</c:if>
	

   
</body>
</html>