<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Register</title>
</head>
<body>
<h1>
	Register to buy Books 
</h1>
	<div class="container">
	<form:form name="input" method="post" action="users/save" modelAttribute="user">
	<form:errors path="name" />
	UserName : <form:input  type="text" path="name"/></br>
	Email : <form:input type="text" path="email"/></br>
	First Name : <form:input type="text" path="firstName"/></br>
	Last Name : <form:input type="text" path="lastName"/></br>
	<input class="form-control" type="submit" value="Submit"/>
	</form:form>
	</div>
	

</body>
</html>