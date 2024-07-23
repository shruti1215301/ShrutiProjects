
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Management Tool</title>
</head>
<style>
* {
	margin: 0;
	padding: 0;
}

body {
	height: 100vh;
}

.main {
	height: 100%;
}

table, th, td {
	border: 1px solid;
	padding: 2px;
	cellpadding: 12;
}

.head {
	height: 100px;
	display: flex;
	justify-content: center;
	align-items: center;
	position: relative;
	background-color: black;
	color: white;
}

.logout {
	display: flex;
	position: absolute;
	right: 30px;
}

.logout * {
	margin: 0 5px;
}

.addProduct .pdetails {
	display: flex;
	width: 25%;
	justify-content: space-between;
	margin: 10px;
}

.pimage {
	height: 120px;
}
</style>
<%
if (session == null) {
	response.sendRedirect("index.jsp");
}
%>

<body>
	<div class="main">
		<header class="head">
			<div>
				<h2>
					<u>PRODUCT MANAGEMENT TOOL</u>
				</h2>
			</div>
			<br>
			<div class="logout">
				<h3>
					Hello
					<%=session.getAttribute("currentUser")%>!!
				</h3>
				<form action="logout">
					<button style="padding: 2px">
						<b>logout</b>
					</button>
				</form>

			</div>
		</header>
		<div class="addProduct" style="padding: 10px">
			<form action="addProduct">
				<h3>Add your new product here!</h3>
				<div class="title pdetails">
					<h3>Title :</h3>
					<input type="text" placeholder="Enter product title" name="ptitle">
				</div>
				<div class="quantity pdetails">
					<h3>Quantity :</h3>
					<input type="text" placeholder="Enter product Quantity"
						name="pquantity">
				</div>
				<div class="size pdetails">
					<h3>Size :</h3>
					<input type="text" placeholder="Enter product size" name="psize">
				</div>
				<div class="image pdetails">
					<h3>Image :</h3>
					<input type="text" placeholder="Enter image url" name="pimage">
				</div>
				<div class="pdetails">
					<button type="submit"
						style="background-color: green; color: white; border-color: yellowgreen; padding: 2px">Upload
						Product</button>
				</div>
			</form>


		</div>
		<div class="content"  style="padding: 10px">
			<%--Importing all the dependent classes--%>
			<%@page import="java.util.ArrayList"%>
			<%@page import="product.MyProduct"%>
			<%@page import="java.util.Iterator"%>

			<%
			ArrayList<MyProduct> userproduct = (ArrayList<MyProduct>) session.getAttribute("userProducts");
			%>
			<%--Assigning ArrayList object containing Employee data to the local object --%>


			<table >

				<tr>
					<th>Product Image</th>
					<th>Product title</th>
					<th>Product Size</th>
					<th>Product quantity</th>
					<th>Actions</th>
				</tr>
				<%
				// Iterating through subjectList

				if (session.getAttribute("userProducts") != null) // Null check for the object
				{
					Iterator<MyProduct> iterator = userproduct.iterator(); // Iterator interface

					while (iterator.hasNext()) // iterate through all the data until the last record
					{
						MyProduct pDetails = iterator.next(); //assign individual employee record to the employee class object
				%>
				<tr>
					<td><img src="<%=pDetails.getImagesrc()%>" class="pimage"></img>
					</td>
					<td><%=pDetails.getTitle()%></td>
					<td><%=pDetails.getSize()%></td>
					<td><%=pDetails.getQuantity()%></td>
					<td><form action="deleteProduct">
							<button value="<%=pDetails.getPid()%>" name="deleteButton"
								style="background-color: red; color: white; border-color: red; padding: 2px">Delete</button>
						</form> <a href="update.jsp?pid=<%=pDetails.getPid()%>"
						value="<%=pDetails.getPid()%>" name="updateButton"><b>Update</b></a>
					</td>
				</tr>
				<%
				}
				}
				%>
			</table>
		</div>
	</div>
</body>
</html>