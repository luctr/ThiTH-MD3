<%--
  Created by IntelliJ IDEA.
  User: Huy Hoang
  Date: 7/12/2021
  Time: 10:32 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <td>Id</td>
        <td>Name</td>
        <td>Price</td>
        <td>Quantity</td>
        <td>Color</td>
        <td>Description</td>
        <td>Category</td>
        <td>Action</td>
    </tr>
    <c:forEach items="${search}" var="s">

        <tr>
            <td>${s.id}</td>
            <td>${s.product_name}</td>
            <td>${s.price}</td>
            <td>${s.quantity}</td>
            <td>${s.color}</td>
            <td>${s.description}</td>
            <td>${s.category_name}</td>
            <td>
                <form action="/product" method="post">
                    <input type="number" name="id" value="${s.id}" hidden>
                    <input type="text" name="action" value="update" hidden>
                    <button type="submit">Update</button>
                </form>
            </td>
            <td>
                <form action="/product" method="post">
                    <input type="number" name="id" value="${s.id}" hidden>
                    <input type="text" name="action" value="remove" hidden>
                    <button type="submit">Delete</button>

                </form>
            </td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
