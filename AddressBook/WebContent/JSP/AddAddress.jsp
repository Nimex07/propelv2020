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
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                            	<c:if test="${address != null}"> <h4 class="title">Edit Address</h4>
           						</c:if>
								<c:if test="${address == null}"> <h4 class="title">Add Address</h4>
            					</c:if>  
                            </div>
                            <div class="content">
                              <c:if test="${address !=null }">
									<form action="<%=request.getContextPath()%>/AddressBookServlet?action=update" method="post">
							  </c:if>
							  <c:if test="${address==null }">
									<form action="<%=request.getContextPath()%>/AddressBookServlet?action=insert" method="post">
							  </c:if>
									<input type="hidden" name="logId" value="<%= session.getAttribute("logId") %> " />
                                    <div class="row">
                                      <div class="col-md-6">
                                          <div class="form-group">
                                                <label>Full Name</label>
                                                <input type="text" name="name" class="form-control" pattern="[A-z ]+" title="Only Alphabets allowed"  placeholder="Full Name"  maxlength="30" minlength="4" autocomplete="off"  value="<c:out value='${address.name.toUpperCase() }'/>"  required>
                                            </div>
                                        </div>
                                        <div class="col-md-6">
                                          <div class="form-group">
                                                <label>House Name</label>
                                                <input type="text" name="houseName" class="form-control" pattern="[A-z ]+" title="Only Alphabets allowed"  placeholder="House Name"  maxlength="30" minlength="4" autocomplete="off"  value="<c:out value='${address.houseName.toUpperCase() }'/>"  required>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                       <div class="col-md-6">
                                          <div class="form-group">
                                                <label>Locality</label>
                                                <input type="text" name="locality" class="form-control" pattern="[A-z ]+" title="Only Alphabets allowed"  placeholder="Locality"  maxlength="30" minlength="4" autocomplete="off"  value="<c:out value='${address.locality.toUpperCase() }'/>"  required>
                                            </div>
                                        </div>
                                         <div class="col-md-6">
                                          <div class="form-group">
                                                <label>City</label>
                                                <input type="text" name="city" class="form-control" pattern="[A-z ]+" title="Only Alphabets allowed"  placeholder="City"  maxlength="30" minlength="4" autocomplete="off"  value="<c:out value='${address.city.toUpperCase() }'/>"  required>
                                            </div>
                                        </div>
                                    </div>
                                    
                                    <div class="row">
                                       <div class="col-md-6">
                                          <div class="form-group">
                                                <label>PinCode</label>
                                                <input type="text" name="pinCode" class="form-control" pattern="[0-9]{6}" title="Only Numbers allowed. PinCode Should contain 6 digits" maxlength="6" placeholder="Pincode" autocomplete="off"  value="<c:out value='${address.pinCode }'/>"  required>
                                            </div>
                                        </div>
                                         <div class="col-md-6">
                                          <div class="form-group">
                                                <label>District</label>
                                                <input type="text" name="district" class="form-control" pattern="[A-z ]+" title="Only Alphabets allowed"  placeholder="District"  maxlength="30" minlength="4" autocomplete="off"  value="<c:out value='${address.district.toUpperCase() }'/>"  required>
                                            </div>
                                        </div>
                                    </div>
								
									<div class="row">
                                       <div class="col-md-6">
                                          <div class="form-group">
                                                <label>State</label>
                                                <input type="text" name="state" class="form-control" pattern="[A-z ]+" title="Only Alphabets allowed"   placeholder="State" autocomplete="off"  value="<c:out value='${address.state.toUpperCase() }'/>"  required>
                                            </div>
                                        </div>
                                         <div class="col-md-6">
                                          <div class="form-group">
                                                <label>Mobile Phone</label>
                                                <input type="text" name="phone" class="form-control" pattern="[0-9]{10}" title="Only Numbers allowed. Phone Should contain 10 digits"  placeholder="Phone"  maxlength="10" autocomplete="off"  value="<c:out value='${address.phone }'/>"  required>
                                            </div>
                                        </div>
                                    </div>
                                    
        							<c:if test="${address.isActive.equals('Y') }">                            
										<span class="badge badge-pill badge-success" style="background-color: green">Active</span>
									</c:if>
									
	 								<c:if test="${address.isActive.equals('N') }">
										<span class="badge badge-pill badge-danger" style="background-color: red">In-Active</span>
									</c:if>	
									
                                    <button type="submit" class="btn btn-info btn-fill pull-right">Save</button>                                 
                                    
                                    <c:if test="${address!=null }">
                                     	<c:if test="${address.isActive.equals('N') }">
                                     		<a class="btn btn-fill btn-success pull-right" href="<%=request.getContextPath() %>/AddressBookServlet?action=activate" role="button">Activate</a>                        		
                                      	</c:if>
                                      	
                                      	<c:if test="${address.isActive.equals('Y') }">  
                                   			<a class="btn btn-fill pull-right btn-danger" href="<%=request.getContextPath() %>/AddressBookServlet?action=deactivate" role="button">DeActivate</a>                
                                   		</c:if>
                                    </c:if>
                                    <div class="clearfix"></div>
             					</form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>






</body>
</html>