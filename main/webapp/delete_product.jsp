<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body
{
text-align:center;
}
div
{
background-color:#f20bce;
padding:20px;
color
}
a
{
font-size:30px;
font-weight:bold;
text-decoration:none;
color:green;
}
</style>
</head>
<body bgcolor="pink">
<h2> To Delete Product ... </h2>
<form action="Deleteproduct_servlet" method="Post">
Enter Product Name : <input type="text" name="name"><br><br>
Enter Product Brand : <input type="text" name="brand"><br><br>
Click : <input type="submit" value="delete product">
<br><br>
To Search Product : <a href="search_product.jsp"> Click here</a><br>
To Add Product : <a href="Add_product.jsp"> Click here</a>
</body>
</html>