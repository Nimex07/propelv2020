<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Address Book</title>

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

 	<div class="sidebar" data-color="green" data-image="../assets/img/sidebar-5.jpg">  
    	<div class="sidebar-wrapper">
            <div class="logo">
                <a href="#" class="simple-text">
                    Online Address Book
                </a>
            </div>
            <ul class="nav">            
                <li>
                    <a href="<%=request.getContextPath()%>/AddressBookServlet?action=edit">
                        <i class="pe-7s-user"></i>
                        <p>My Address</p>
                    </a>
                </li>
                <li>
                    <a href="<%=request.getContextPath()%>/AddressBookServlet?action=list">
                        <i class="pe-7s-note2"></i>
                        <p>View All</p>
                    </a>
                </li>             
             </ul>
    	</div>
    </div>
    <div class="main-panel">
		<nav class="navbar navbar-default navbar-fixed">
            <div class="container-fluid">
                <div class="navbar-header ">
                    <br>
                   <p class="text-uppercase "> WELCOME <%= session.getAttribute("name") %> </p>
                </div>             
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
				      <li>
                            <a href="<%=request.getContextPath()%>/LogOutServlet">
                                <p>Log out</p>
                            </a>
                        </li>
						<li class="separator hidden-lg hidden-md"></li>
                    </ul>
                </div>
            </div>
        </nav>
</body>
</html>