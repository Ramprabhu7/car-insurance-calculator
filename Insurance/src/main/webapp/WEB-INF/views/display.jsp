<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{
background-color:grey;
text-align:center;
display:block;
}

a{
color:black;
font-size:30px;
font-family:Arial;
margin:auto;
padding:5px 10px;
text-decoration:none;
border: 1px solid black;
background-color:red;

}

.first{
background-color:white;
}

.second{
background-color:white;
}

.third{
background-color:white;
} 

ul li{
display:inline-block;
padding:3px 80px;
font-size:30px;
text-align:center;
}

ul li a:hover{
color:white;
} 
</style>
</head>
<body>
		<div class="first">
		<ul>
			<li>Tata AIG</li>
			<li>IDV ${IDV1}</li>
			<li><a href="#">${premium1}</a> </li>
		</ul>
		</div>
		
		<div class="second">
			<ul>
			<li>HDFC ERGO</li>
			<li>IDV ${IDV2}</li>
			<li><a href="#">${premium2}</a> </li>
		</ul>
		</div>
		
		<div class="third">
			<ul>
			<li>United India</li>
			<li>IDV ${IDV3}</li>
			<li><a href="#">${premium3}</a> </li>
		</ul>
		</div>
		
 
</body>
</html>