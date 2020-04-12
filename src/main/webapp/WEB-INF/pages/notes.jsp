<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Notes</title>
</head>
<body>

<h2>Notes</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>phone number</th>
        <th>contact type</th>
    </tr>
    <c:forEach var="contact" items="${notesList}">
        <tr>
            <td>${contact.id}</td>
            <td>${contact.name}</td>
            <td>${contact.surname}</td>
            <td>${contact.phoneNumber}</td>
            <td>${contact.contactType}</td>
            <td>
                <a href="/edit/${contact.id}">edit</a>
                <a href="/delete/${contact.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Add</h2>
<c:url value="/add" var="add"/>
<a href="${add}">Add new contact</a>
</body>
</html>