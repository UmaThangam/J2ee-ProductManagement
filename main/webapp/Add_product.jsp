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
<h1>PRODUCT SCREEN</h1>
<h2> To Add New Product ... </h2>
<form action="Addproduct_servlet" method="Post">
Enter Product Name : <input type="text" name="name"><br><br>
Enter Product Brand : <input type="text" name="brand"><br><br>
Enter Product Price : <input type="number" name="price"><br><br>
Enter MFD[yy/mm/dd] : <input type="date" name="mfd"><br><br>
Enter No Of Stock  : <input type="number" name="stock"><br><br>
Click : <input type="submit" value="add product">
<br><br>
<h4>To Search Product : <a href="search_product.jsp"> Click here</a></h4>
<h4>To Delete Product : <a href="delete_product.jsp"> Click here</a></h4>
</form>
</body>
</html>