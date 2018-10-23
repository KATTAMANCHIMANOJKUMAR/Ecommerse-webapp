<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<title>List of products</title>
 <style>
body {
    background-color: #f49841;
}

h1 {
    color: white;
    text-align: center;
}

p {
    font-family: verdana;
    font-size: 20px;
}
  table, th, td,tr {
    border: 1px solid black;
}  
</style> 
<script type="text/javascript">
	$(document).ready(function() {
		var searchCondition = '${searchCondition}'
		$('.table').DataTable({
			"lengthMenu" : [ [ 5, 7, -1 ], [ 5, 7, "All" ] ],
			"oSearch" : {
				"sSearch" : searchCondition

			}

		})
	})
</script>



<!-- <style>
.myTable { 
  width: 100%;
  text-align: left;
  background-color: lemonchiffon;
  border-collapse: collapse; 
  }
.myTable th { 
  background-color: goldenrod;
  color: white; 
  }
.myTable td, 
.myTable th { 
  padding: 10px;
  border: 1px solid goldenrod; 
  }
</style -->


</head>
<body>
	
	<%-- <br>${productsList} --%>
	<div class="container">
	
 <table class="table table-striped" border="1" style="width:100%;text-align:left;background-color:#f49841;"  > 
		
		<!--  <table class="table table-striped" border="1"  >  -->
<!-- <table border="1" ;background-color:#f49841;">  -->
<!--  <table style="width:100%;text-align:left;background-color:#f49841;"> -->

    
  
			<thead>
				<tr>
					<th>Id</th>
					<th>Image</th>
					<th>Product Name</th>
					<th>Price</th>
					<th>Category</th>
					<th>Action</th>

				</tr>
			</thead>
			<tbody style="width:100%;text-align:left;background-color:#f49841;" >
				<c:forEach var="p" items="${productsList}">

					<tr>
						<td><a
							href="<c:url value='/all/getproduct/${p.id }'></c:url>">${p.id }</a></td>
						<td><img
							src="<c:url value='/resources/images/${p.id }.jpg'></c:url>"
							height="60%" width="60%"></td>

						<td><a
							href="<c:url value='/all/getproduct/${p.id }'></c:url>">${p.productname }</a></td>
						<td>${p.price }</td>
						<td>${p.category.categoryname }</td>

						<td><a
							href="<c:url value='/all/getproduct/${p.id }'></c:url>"><span
								class="glyphicon glyphicon-info-sign"></span></a> <security:authorize
								access="hasRole('ROLE_ADMIN')">
								<a href="<c:url value='/admin/deleteproduct/${p.id }'></c:url>"><span
									class="glyphicon glyphicon-trash"></span></a>
								<a href="<c:url value='/admin/getupdateform/${p.id }'></c:url>"><span
									class="glyphicon glyphicon-pencil"></span></a>
							</security:authorize></td>

					</tr>

				</c:forEach>
			</tbody>


  
		</table>


	</div>

</body>
</html>