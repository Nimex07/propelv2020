<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Address Book</title>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<style type="text/css">
	<%@ include file="../assets/css/bootstrap.min.css" %>
	<%@ include file="../assets/css/animate.min.css" %>
	<%@ include file="../assets/css/light-bootstrap-dashboard.css" %>
	<%@ include file="../assets/css/pe-icon-7-stroke.css" %>s
</style>
	
	 <!--     Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300' rel='stylesheet' type='text/css'>

</head>
<body>

<jsp:include page="AddBookHeader.jsp"></jsp:include>


  <div class="content">
    <form action="<%=request.getContextPath()%>/AddressBookServlet?action=search" method="post">

 <div class="col-md-4">
             <div class="form-group">                                   
          		<input type="text" name="searchName" class="form-control" autocomplete="off" pattern="[A-z ]+" title="Name should contain only Alphabets "  maxlength="25" placeholder="Search By Name" required>
          		</div>
          		</div>
          		<button type="submit" class="btn btn-success">Search</button>

 				<span style="color: red"><%=(request.getAttribute("errMessage") == null) ? ""
					: request.getAttribute("errMessage")%></span>

</form>
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">View All Address</h4>
                                <p class="category">&nbsp;</p>
                            </div>
                            <div class="content table-responsive table-full-width">
                                <table class="table table-hover table-striped">
                                    <thead>
                                    
									    <th>Name</th>						
										<th>House Name</th>
										<th>Locality</th>
										<th>City</th>
										<th>Pin Code</th>
										<th>District</th>					
										<th>State</th>	
										<th>Phone</th>	
                                    </thead>
                                    <tbody>
                                    
                                    
                                    
                                         <c:forEach var="address" items="${listAddressBook}">
                                        <tr>
                                   			
											<td><c:out value="${address.name.toUpperCase() }" /></td>
											<td><c:out value="${address.houseName.toUpperCase() }" /></td>
											<td><c:out value="${address.locality.toUpperCase() }" /></td>
											<td><c:out value="${address.city.toUpperCase() }" /></td>
											<td><c:out value="${address.pinCode}" /></td>
											<td><c:out value="${address.district.toUpperCase() }" /></td>
											<td><c:out value="${address.state.toUpperCase() }" /></td>
											<td><c:out value="${address.phone }" /></td>
							
										
                                        </tr>
                                      </c:forEach>
                                      
                                       
                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>




</body>
</html>