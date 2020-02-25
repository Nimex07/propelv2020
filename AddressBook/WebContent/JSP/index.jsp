<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online Address Book</title>

<style type="text/css">
	<%@ include file="../css/util.css" %>
	<%@ include file="../css/main.css" %>
	<%@ include file="../css/bootstrap.min.css" %>
	
</style>
<script>
	function preventBack() {
		window.history.forward();
	}
	setTimeout("preventBack()", 0);
	window.onunload = function() {
		null
	};
</script>

</head>
<body>

<div class="limiter">
		<div class="container-login100" style="background-image: url('images/bg-01.jpg');">
			<div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Account Login
				</span>
				<form action="LoginServlet?action=login" method="post" class="login100-form validate-form p-b-33 p-t-5">

					<div class="wrap-input100 validate-input" data-validate = "Enter username">
						<input class="input100" type="text" name="username"
							pattern="[A-Za-z0-9 ]+"
							title="Username Should contain only Alphabets and Numbers"
							minlength="3" maxlength="25" id="userName"
							placeholder="User name" autocomplete="off" required> 
						<span class="focus-input100" data-placeholder="&#xe82a;"></span>
					</div>
					<div class="error" id="errUname"></div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<input class="input100" type="password" name="password"
							id="password" placeholder="Password" minlength="6" maxlength="25"
							required> 
						<span class="focus-input100" data-placeholder="&#xe80f;"></span>
						
					</div>
					<span style="color: red"><%=(request.getAttribute("errMessage") == null) ? ""
					: request.getAttribute("errMessage")%></span> <br>
					<div class="container-login100-form-btn m-t-32">
						<button class="login100-form-btn">Login</button>
						<a class="login100-form-btn"
							href="<%=request.getContextPath()%>/JSP/Register.jsp"
							style="color: white">Sign Up</a>
					</div>
				</form>
			</div>
		</div>
	</div>


<%-- 

<center>
<form action="<%=request.getContextPath()%>/LoginServlet" method="post">
username:
<input type="text" name="username"><br><br>
password:
<input type="password" name="password"><br><br>

<span style="color: red"><%=(request.getAttribute("errMessage") == null) ? ""
					: request.getAttribute("errMessage")%></span>
<br><br>
<button type="submit">LOGIN</button>

</form>
</center>

</body>
</html>

--%>