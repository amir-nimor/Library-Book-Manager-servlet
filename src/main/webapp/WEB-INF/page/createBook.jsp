<%--
  Created by IntelliJ IDEA.
  User: Soly
  Date: 9/12/2026
  Time: 10:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Book</title>
</head>
<body style="background-color: peru">

<center>
    <form action='/CreateBook' method='POST'>
        <label>Title:
        <input type="text" name="title" required>
        </label><br>

        <label>Author:
        <input type="text" name="author" required>
        </label><br>

        <label>Category:
            <input type="text" name="category" required>
        </label><br>


        <label>Price:
            <input type="number" name="price" required>
        </label><br>

        <button type="submit"> create </button>
    </form>

</center>


</body>
</html>
