<%--
  Created by IntelliJ IDEA.
  User: Huy Hoang
  Date: 6/8/2021
  Time: 3:31 PM
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
        <td>Category Name</td>
        <td>Action</td>
    </tr>
    <tr>
        <td>
            <input name="id" value="${edit.id}" hidden>
        </td>
        <td>
            <input name="name" value="${edit.product_name}">
        </td>
        <td>
            <input name="price" value="${edit.price}">
        </td>
        <td>
            <input name="quantity" value="${edit.quantity}">
        </td>
        <td>
            <input name="color" value="${edit.color}">
        </td>
        <td>
            <input name="description" value="${edit.description}">
        </td>
        <td>
            <input name="category_name" value="${edit.category_name}">
        </td>
        <td>
            <input type="submit" value="update">
        </td>


    </tr>
</table>
</body>
</html>
