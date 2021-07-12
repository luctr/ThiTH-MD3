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
    <title>Create</title>
</head>
<body>
<table>
    <form action="" method="post">
        <h1>Create</h1>
        <tr>
            <td>
                <input type="text" name="name" placeholder="Name">
            </td>
            <td>
                <input type="number" name="price" placeholder="Price">
            </td>
            <td>
                <input type="number" name="quantity" placeholder="Quantity">
            </td>
            <td>
                <input type="text" name="color" placeholder="Color">
            </td>
            <td>
                <input type="text" name="description" placeholder="description">
            </td>
            <td>
                <input type="text" name="category_name" placeholder="Category Name">
            </td>
            <td>
                <input type="submit" value="create"/>
            </td>

        </tr>


</form>
</table>
</body>
</html>
