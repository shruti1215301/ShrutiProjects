<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="com.tshirtkart.dao.OutputDao"%>
<%@page import="com.tshirtkart.thread.ReadDetails"%>
<%@page import="com.tshirtkart.entities.ProductDetails"%>
<%@page import="javax.persistence.criteria.CriteriaQuery"%>
<%@page import="javax.persistence.criteria.CriteriaBuilder"%>
<%@page import="javax.persistence.TypedQuery"%>
<%@page import="org.hibernate.Transaction"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.List"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.hibernate.Session"%>

<%@page import="org.hibernate.cfg.Configuration"%>
<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>

<!DOCTYPE web-app

<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet" href="product.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Insert title here</title>
</head>
<style>
@charset "ISO-8859-1";

body{
	width:100%;
}
.form-control{
	width:30%;
	
}
form{
	padding :2%;
	
}

section{
	margin-top:3%;
}
.prohead{
	display:inline-block;
	margin-left:14%;
	padding:0;
}
</style>
<body>
<%
response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
if(session.getAttribute("session")==null)
	response.sendRedirect("login.jsp");
	
%>
<div class="row mx-auto d-flex justify-content-between">
<div class="col-lg-10 d-flex justify-content-center">
<h2 style="text-align: center; font-weight: bold;" class="prohead">Product Management Tool</h2>
</div>
<div class="col-lg-2">
<div class="row mt-2">
<div class="col-lg-7">
<h5 style="text-align: center; font-weight: bold;">Shruti </h5>
</div>
<div class="col-lg-5">
<form action="logout" method="post">
<input type="submit" value="Logout" class="btn btn-danger"></input>
</form>
</div>
</div>
</div>
</div>
<section>

<form action="fetch">
	<h4 style="font-weight: bold;">Please Enter Product Details</h4>
  <div class="form-group row mb-2">
    <label for="inputPassword" class="col-sm-1 col-form-label">Color</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  placeholder="" name="color" required="required">
    </div>
  </div>
  <div class="form-group row mb-2">
    <label for="inputPassword" class="col-sm-1 col-form-label">Size</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  placeholder="" name="size" required="required">
    </div>
  </div>
  <div class="form-group row mb-2">
    <label for="inputPassword" class="col-sm-1 col-form-label">Gender</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  placeholder="" name="gender" required="required">
    </div>
  </div>
    <div class="form-group row mb-2">
    <label for="inputPassword" class="col-sm-1 col-form-label">Output preference</label>
    <div class="col-sm-10">
      <input type="text" class="form-control"  placeholder="" name="output">
    </div>
  </div>
<input type="submit" class="btn btn-primary" name="sub"></input>
</form>
</section>
<table class="w3-table-all">
<thead>
<tr class="w3-green">
<th>Id</th>
<th>Name</th>
<th>Color</th>
<th>Gender</th>
<th>Size</th>
<th>Price</th>
<th>Rating</th>
<th>Availability</th>
</tr>
</thead>
<tr>
<%

String x=request.getParameter("sub");
if(x!=null)
{

List<ProductDetails> li= new ArrayList<ProductDetails>();
li=OutputDao.getList();
if(li.size()!=0)
{
for(ProductDetails p:li)
{
%>
<tr>
<td><%=p.getId() %></td>
<td><%=p.getName() %></td>
<td><%=p.getColor() %></td>
<td><%=p.getGenderRecommendation() %></td>
<td><%=p.getSize() %></td>
<td><%=p.getPrice() %></td>
<td><%=p.getRating() %></td>
<td><%=p.getAvailability() %></td>
 
<%

}
}
}
%>
</table>
</body>
</html>
