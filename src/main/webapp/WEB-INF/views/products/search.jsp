<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search</title>
</head>
<body>
	<div class="container">
	<h2>Search Products</h2>
	<div class="form-group form">
	<form:form name="input"  method="post"
		modelAttribute="product" action="getProducts">
		<div>
			<label>Book Name: </label>
			<form:input type="text" path="bookName" />
			<form:errors path="bookName" />
		</div>
		
		<div>
			<input type="submit" value="Submit" class="form-control">
		</div>


	</form:form>
	</div>
	
	<h2>Search Results:</h2>
	<c:out value="${results.bookName}"/> <br/>
	
	</div>

</body>
</html>