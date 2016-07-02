<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
	<title>welcome to my page</title>
	
</head>
<body>

<div class="container">
<c:choose>
  <c:when test="${empty loginUser}">
  <a href="users?register">Register</a>
  <a href="login">Login</a>
  </c:when>
  <c:otherwise>
    Hello ${loginUser}
    <a href="cart">Cart</a>
    <a href="logout">Log Out</a>
  </c:otherwise>
</c:choose>
<h2>Welcome to My BookStore</h2>
<div class="container">
	
	
	<c:forEach var="item" items="${featuredProducts}">
		<c:out value="${item.name}"/> &nbsp; <a href="cart/add/${item.id}">Add to cart</a> <br/>
	</c:forEach>

		
		
</div>	
		
</div>
</body>
</html>
