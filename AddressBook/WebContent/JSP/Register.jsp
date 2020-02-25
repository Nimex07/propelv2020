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

<div class="main-panel">

	<div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-8">
                        <div class="card">
                            <div class="header">
                                <h4 class="title">Register</h4>
                            </div>
                            <div class="content">
                                <form action="<%=request.getContextPath()%>/RegisterServlet?action=register" method="post">
                                    <div class="row">
                                      <div class="col-md-6">
                                          <div class="form-group">
                                                <label>Username</label>
                                             	 <input type="text" name="username" pattern="[A-Za-z0-9 ]+" title="Username Should contain only Alphabets and Numbers" minlength="3" maxlength="25" class="form-control" placeholder="username" autocomplete="off" required />                                          
                                               </div>
                                        </div>
                                   
                                   
                                      <div class="col-md-6">
                                          <div class="form-group">
                                                <label>Password</label>
                                             	<input type="password" name="password" minlength="6" maxlength="25" class="form-control" placeholder="Password" autocomplete="off" required />                                          
                                            </div>
                                        </div>
                                    </div>
                                   <div class="row">
                                   <div class="col-md-6">
                                    	<div class="form-group">
  											<button type="submit" class="btn btn-info btn-fill pull-left">Register</button>
  										</div>  
  										</div>  
  								  </div>                             
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
</div>




</body>
</html>