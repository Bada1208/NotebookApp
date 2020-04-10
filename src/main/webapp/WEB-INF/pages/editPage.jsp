<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <c:if test="${empty contact.name}">
        <title>Add</title>
    </c:if>
    <c:if test="${!empty contact.name}">
        <title>Edit</title>
    </c:if>
</head>
<body>
<c:if test="${empty contact.name}">
    <c:url value="/add" var="var"/>
</c:if>
<c:if test="${!empty contact.name}">
    <c:url value="/edit" var="var"/>
</c:if>
<form action="${var}" method="POST">
    <c:if test="${!empty contact.name}">
        <input type="hidden" name="id" value="${contact.id}">
    </c:if>
    <label for="name">Name</label>
    <input type="text" name="name" id="name">
    <label for="surname">Surname</label>
    <input type="text" name="surname" id="surname">
    <label for="phoneNumber">Phone number</label>
    <input type="text" name="phoneNumber" id="phoneNumber">
    <label for="contactType">Contact type</label>
    <input type="text" name="contactType" id="contactType">
    <c:if test="${empty contact.name}">
        <input type="submit" value="Add new contact">
    </c:if>
    <c:if test="${!empty contact.name}">
        <input type="submit" value="Edit contact">
    </c:if>
</form>
</body>
</html>
