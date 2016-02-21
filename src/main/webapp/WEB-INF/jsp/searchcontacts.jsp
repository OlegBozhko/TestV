<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>TestV</title>
</head>
<body>
<h1>Selected Users</h1>

<form action="searchContacts" method="post">
    <table style="border-collapse: collapse;" width="500" border="0" bordercolor="#006699">
        <tbody>
        <tr>
            <td>Search contact name</td>
            <td><input name="name" type="text">
                <input value="Search" type="submit">
            </td>
        </tr>
        </tbody>
    </table>
</form>

<table style="border: 1px solid; width: 500px; text-align:center">
    <thead style="background:#fcf">
    <tr>
        <th>Name</th>
        <th>Age</th>
        <th>Admin</th>
        <th>Created Date</th>
        <th colspan="4"></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user">
        <c:url var="editUrl" value="/testForJR/main/users/edit?id=${user.id}"/>
        <c:url var="deleteUrl" value="/testForJR/main/users/delete?id=${user.id}"/>
        <tr>
            <td><c:out value="${user.name}"/></td>
            <td><c:out value="${user.age}"/></td>
            <td><c:out value="${user.admin}"/></td>
            <td><c:out value="${user.date}"/></td>
            <td><a href="${editUrl}">Edit</a></td>
            <td><a href="${deleteUrl}">Delete</a></td>

        </tr>
    </c:forEach>
    </tbody>
</table>

<c:if test="${empty users}">
    There are currently no search users in the list.
</c:if>

<c:url var="editUrl" value="/testForJR/main/users"/>
<td><a href="${editUrl}">Main List</a></td>

</body>
</html>