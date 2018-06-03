<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta charset="utf-8">
		<title>Bootstrap E-commerce Templates</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<!--[if ie]><meta content='IE=8' http-equiv='X-UA-Compatible'/><![endif]-->
		<!-- bootstrap -->
		<link href="/Shopper/bootstrap/css/bootstrap.min.css" rel="stylesheet">      
		<link href="/Shopper/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
		
		<link href="/Shopper/themes/css/bootstrappage.css" rel="stylesheet"/>
		
		<!-- global styles -->
		<link href="/Shopper/themes/css/flexslider.css" rel="stylesheet"/>
		<link href="/Shopper/themes/css/main.css" rel="stylesheet"/>

		<!-- scripts -->
		<script src="/Shopper/themes/js/jquery-1.7.2.min.js"></script>
		<script src="/Shopper/bootstrap/js/bootstrap.min.js"></script>				
		<script src="/Shopper/themes/js/superfish.js"></script>	
		<script src="/Shopper/themes/js/jquery.scrolltotop.js"></script>
		<!--[if lt IE 9]>			
			<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
			<script src="js/respond.min.js"></script>
		<![endif]-->
	</head>
	<body>	
		
		<jsp:include page="${param.view}"/>
		
    </body>
</html>