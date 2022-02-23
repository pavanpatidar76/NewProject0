<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>  
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1,user-scalable=0">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>



<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<style type="text/css">
	
	</style>
	<style type="text/css">
 body {
	background-image: url("/ors_proj0/resources/img/Bulb.jpg");
    background-size: cover;
	background-repeat: no-repeat;
	background-attachment: fixed;
	background-position: center;

} 

.btn {
 
	background: #ffc61a;
	border-radius: 100px;
	padding: 5px 10px;
	color: black;
	text-decoration: none;
	font-size: 0.75em;
	margin: 0 15px;
}

 .btn:hover{
color: red;
}
</style>
</head>
<body class="img-fluid">
	<div class="container-fluid">
		<div class="row">
		<div class="col-sm-4"></div>
		<div class="col-sm-4 ">
<br><br><br><br><br><br><br>
		<div align="center">

	 <img class="img-circle img-fluid"
			src='<c:url value="/resources/img/logo.jpg"></c:url>' width="400px" height="200px">
			<br><br>
			<a   class="btn shadow"  style="font-size: 40px;" href='<c:url value="/Welcome"  ></c:url>'>
			<u><b >Online Result system</b></u></a>
		</div>
		</div>
		<div class="col-sm-4"></div>
	</div>
	</div>
</body>
</html>
