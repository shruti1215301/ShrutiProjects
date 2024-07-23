<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="updateform">
<%@page import="product.MyProduct"%>
<%@page import="util.HibernateConnectivity"%> 
<% MyProduct p=HibernateConnectivity.getProduct(request.getParameter("pid")); %>

<form action="updateProduct" method="post"><h3>Add your new product here!</h3>
				
                <div class="title pdetails"><h3>Title :</h3><input type="text" placeholder="Enter product title" name="ptitle" value="<%=p.getTitle()%>"></div>
                <div class="quantity pdetails"><h3>Quantity :</h3><input type="text" placeholder="Enter product Quantity" name="pquantity" value=<%= p.getQuantity() %>></div>
                <div class="size pdetails"><h3>Size :</h3><input type="text" placeholder="Enter product size" name="psize" value=<%= p.getSize() %> ></div>
                <div class="image pdetails"><h3>Image :</h3><input type="text" placeholder="Enter image url" name="pimage" value=<%= p.getImagesrc() %>></div>
                <div class="pdetails"><button type="submit" name="updateButton" value=<%= p.getPid() %>>update product</button></div></form>
</div>
</body>
</html>